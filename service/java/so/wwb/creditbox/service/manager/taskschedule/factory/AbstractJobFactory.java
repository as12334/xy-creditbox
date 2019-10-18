package so.wwb.creditbox.service.manager.taskschedule.factory;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.dubbo.DubboTool;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.ClassTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.reflect.MethodTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleVo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JobFactory抽象工厂
 * @author: marz
 * @time 2018-3-2 20:35:57
 */
public abstract class AbstractJobFactory implements Job {

    private static final Log LOG = LogFactory.getLog(AbstractJobFactory.class);

    protected void run(JobExecutionContext context) throws JobExecutionException{
        TaskSchedule job = (TaskSchedule) context.getMergedJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY);
        Object[] paramArray = (Object[]) context.getMergedJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY_ARRAY);
        Class[] paramClass = null;
        String nextFireTime = DateTool.formatDate(context.getNextFireTime(), DateTool.yyyy_MM_dd_HH_mm_ss);
        String prefix= "LT SCHEDULE调度任务[IDC:{0}]:编号:{1},名称:{2}";
        LOG.debug(prefix + ",下次执行时间:{3}", job.getIdc(), job.getJobCode(), job.getJobName(), nextFireTime);
        Class<?> jobClass = ClassTool.getClass(job.getJobClass());
        Object service;
        Object returnObj;

        if (ArrayTool.isNotEmpty(paramArray)) {
            paramClass = new Class[paramArray.length];
            for (int i = 0; i < paramArray.length; i++) {
                Object object = paramArray[i];
                paramClass[i] = object.getClass();
            }
        } else if (StringTool.isNotBlank(job.getJobMethodArg())) {
            if (String.class.getName().equals(job.getJobMethodArgClass())) {
                paramClass = new Class[]{String.class};
                paramArray = new Object[]{job.getJobMethodArg()};
            } else {
                Object arg = JsonTool.fromJson(job.getJobMethodArg(), ClassTool.getClass(job.getJobMethodArgClass()));
                paramClass = new Class[]{arg.getClass()};
                paramArray = new Object[]{arg};
            }
        }

        Method accessibleMethod = MethodTool.getMatchingAccessibleMethod(jobClass, job.getJobMethod(), paramClass);
        if (job.getIsLocal()) {
            service = SpringTool.getBean(jobClass);
        } else {
            service = DubboTool.getService(jobClass);
        }

        try {
            returnObj = accessibleMethod.invoke(service, paramArray);
            if (returnObj != null) {
                context.getMergedJobDataMap().put(TaskScheduleVo.JOB_RESULT, returnObj);
            }
            LOG.debug(prefix + ",执行完成,返回值为:{3}", job.getIdc(), job.getJobCode(), job.getJobName(), returnObj == null ? "无" : returnObj.toString());
        } catch (Exception e) {
            LOG.error(prefix + ",执行完成,异常!", job.getIdc(), job.getJobCode(), job.getJobName());
            Throwable now = null;
            if (e instanceof InvocationTargetException) {
                now = ((InvocationTargetException) e).getTargetException();
            }
            throw new JobExecutionException(now != null ? now : e);
        }
    }
}