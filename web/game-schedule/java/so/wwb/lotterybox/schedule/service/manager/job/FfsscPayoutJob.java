package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
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
 * 分分时时彩派彩任务
 * Created by steady on 2018-09-07
 */
public class FfsscPayoutJob extends LotterySystemJob {

    private static final Log LOG = LogFactory.getLog(FfsscPayoutJob.class);
    private static final String FFSSC = "ffssc";

    @Autowired
    private ExecutorService systemPayoutExecutor;
    /**
     * 执行策略：每一分钟的59秒执行
     * 确定当前执行的彩种期数
     * 确定需要开号的站点，每个站点开独立线程执行SystemPayoutTask
     * @param group 分组代号
     */
    public void execute(String group) {
        String expect = caculteExpect (FFSSC);
        LOG.info("自主彩分分时时彩派彩任务开始code:{0},期号:{1}", FFSSC, expect);
        List<Lottery> lotteryList = new ArrayList<>();
        List<Integer> list = fetchGroupSite(group);
        list.forEach(s-> initSiteLottery (s,lotteryList,FFSSC));

        if(CollectionTool.isEmpty(lotteryList)){
            LOG.error("自主彩分分时时彩派彩前校验未通过,code:{0},expect:{1},原因{2}",FFSSC,expect,"未存在需要派彩的商户");
            return;
        }
        List<Integer> sites = new ArrayList<>();
        initSite (sites,lotteryList);
        LOG.info("自主彩分分时时彩派彩任务开始code:{0},期号:{1},站点:{2}", FFSSC, expect, StringTool.join(",",sites.toArray()));

        List<Future<LotteryResultNumberVo>> futures = new LinkedList<>();
        for(Lottery lottery : lotteryList){
            LotteryResultNumberVo resultNumberVo = new LotteryResultNumberVo();
            resultNumberVo._setSiteId(lottery.getSiteId());
            resultNumberVo.getSearch().setCode(FFSSC);
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

    private void initSite(List<Integer> sites,List<Lottery> lotteryList) {
        lotteryList.forEach(s-> {
            if (s.getSiteId() != null) {
                sites.add(s.getSiteId());
            }
        });
    }

}
