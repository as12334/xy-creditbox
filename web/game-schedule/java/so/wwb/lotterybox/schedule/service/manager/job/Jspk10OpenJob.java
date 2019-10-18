package so.wwb.lotterybox.schedule.service.manager.job;


import org.soul.commons.collections.CollectionTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultLogVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.lotterybox.schedule.service.manager.task.SystemOpenTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 极速PK10派彩任务
 * Created by rambo on 2018-09-07
 */
public class Jspk10OpenJob extends LotterySystemJob{

    private static final Log LOG = LogFactory.getLog(Jspk10OpenJob.class);

    private static final String JSPK10 = "jspk10";

    @Autowired
    private ExecutorService systemOpenExecutor;
    /**
     * 执行策略：每一分钟的50秒执行
     * 确定当前执行的彩种期数
     * 确定需要开号的站点，每个站点开独立线程执行SystemOpenTask
     * * @param group 分组代号
     */
    public void execute(String group) {
        String expect = caculteExpect (JSPK10);
        LOG.info("自主彩采集任务开始code:{0},期号:{1}", JSPK10, expect);
        List<Lottery> lotteryList = new ArrayList<>();

        List<Integer> list = fetchGroupSite(group);
        list.forEach(s-> initSiteLottery (s,lotteryList,JSPK10));

        if(CollectionTool.isEmpty(lotteryList)){
            LOG.error("自主彩极速pk10采集验未通过,code:{0},expect:{1},原因{2}",JSPK10,expect,"未存在需要采集派彩的商户");
            return;
        }

        List<Future<LotteryResultLogVo>> futures = new LinkedList<>();
        for(Lottery lottery : lotteryList){
            LotteryResultLogVo logVo = new LotteryResultLogVo();
            logVo._setSiteId(lottery.getSiteId());
            logVo.getSearch().setCode(JSPK10);
            logVo.getSearch().setExpect(expect);
            //开号task
            futures.add(systemOpenResult(logVo));
        }
    }

    /**
     * 自主彩采集
     * @param logVo
     * @return
     */
    private Future<LotteryResultLogVo> systemOpenResult(LotteryResultLogVo logVo){
        SystemOpenTask task = SpringTool.getBean(SystemOpenTask.class);
        task.setResultLogVo(logVo);
        return systemOpenExecutor.submit(task);
    }
}
