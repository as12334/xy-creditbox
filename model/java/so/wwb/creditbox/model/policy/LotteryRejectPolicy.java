package so.wwb.creditbox.model.policy;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 彩票线程池拒绝策略
 *
 * @author marz
 * @date 2018.12.30
 */
public class LotteryRejectPolicy implements RejectedExecutionHandler {

    private static final Log LOG = LogFactory.getLog(LotteryRejectPolicy.class);

    public LotteryRejectPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        LOG.error("线程池已经满了,请及时优化处理,Task:{0},ThreadPoolExecutor:{1}", r.toString(), e.toString());
        if (!e.isShutdown()) {
            r.run();
        }
    }
}
