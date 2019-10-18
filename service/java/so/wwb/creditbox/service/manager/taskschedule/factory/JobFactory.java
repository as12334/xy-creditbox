package so.wwb.creditbox.service.manager.taskschedule.factory;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 非同步的任务工厂类
 * @author: marz
 * @time 2018-3-2 20:35:57
 */
public class JobFactory extends AbstractJobFactory {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        run(context);
    }
}
