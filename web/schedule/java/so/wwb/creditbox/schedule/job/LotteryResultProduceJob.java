package so.wwb.creditbox.schedule.job;

import org.soul.commons.cache.CacheTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.common.dubbo.ServiceTool;

import java.util.Date;

/**
 * Created by shook on 17-11-22.
 * 开奖结果生产任务，提前生成开奖记录
 */
public class LotteryResultProduceJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultProduceJob.class);

    public void execute() {
        try {
            LOG.info("LotteryResultProduceJob:开奖结果生产...");
            ServiceTool.lotteryResultService().doInitLotteryJob(new Date());
        } catch (Exception e) {
            LOG.error(e, "LotteryResultProduceJob:开奖结果生产错误");
        }
    }
}
