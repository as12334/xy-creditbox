package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.lotterybox.schedule.service.manager.task.SystemPayoutTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 极速快3派彩任务
 * Created by steady on 2018-09-07
 */
public class Jisk3PayoutJob extends LotterySystemJob {

    private static final Log LOG = LogFactory.getLog(Jisk3PayoutJob.class);
    private static final String JISK3 = "jisk3";

    @Autowired
    private ExecutorService systemPayoutExecutor;
    /**
     * 执行策略：每一分钟的59秒执行
     * 确定当前执行的彩种期数
     * 确定需要开号的站点，每个站点开独立线程执行SystemPayoutTask
     * @param group 分组代号
     */
    public void execute(String group) {
        String expect = caculteExpect (JISK3);
        LOG.info("自主彩极速快3派彩任务开始code:{0},期号:{1}", JISK3, expect);
        List<Lottery> lotteryList = new ArrayList<>();
        List<Integer> list = fetchGroupSite(group);
        list.forEach(s-> initSiteLottery (s,lotteryList,JISK3));

        if(CollectionTool.isEmpty(lotteryList)){
            LOG.error("自主彩极速快3派彩前校验未通过,code:{0},expect:{1},原因{2}",JISK3,expect,"未存在需要派彩的商户");
            return;
        }
        List<Future<LotteryResultNumberVo>> futures = new LinkedList<>();
        for(Lottery lottery : lotteryList){
            LotteryResultNumberVo resultNumberVo = new LotteryResultNumberVo();
            resultNumberVo._setSiteId(lottery.getSiteId());
            resultNumberVo.getSearch().setCode(JISK3);
            resultNumberVo.getSearch().setExpect(expect);
            //开号task
            futures.add(systemPayout(resultNumberVo));
        }
        validateResultList(futures);
    }

    /**
     * 自主彩采集
     * @param resultNumberVo
     * @return
     */
    private Future<LotteryResultNumberVo> systemPayout(LotteryResultNumberVo resultNumberVo){
        SystemPayoutTask task = SpringTool.getBean(SystemPayoutTask.class);
        task.setNumberVo(resultNumberVo);
        return systemPayoutExecutor.submit(task);
    }

}
