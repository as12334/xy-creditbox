package so.wwb.creditbox.utility;

import org.quartz.*;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.soul.commons.bean.Pair;
import org.soul.commons.collections.SetTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.soul.service.quartz.CronExpressionTool;
import so.wwb.creditbox.model.enums.schedule.TaskSchedulerEnum;
import so.wwb.creditbox.model.exception.ScheduleException;
import so.wwb.creditbox.service.manager.taskschedule.factory.JobFactory;
import so.wwb.creditbox.service.manager.taskschedule.factory.JobSyncFactory;

import java.text.ParseException;
import java.util.*;

public class ScheduleTool {
    private static final Log log = LogFactory.getLog(ScheduleTool.class);
    
    //region init(TaskSchedule taskSchedule)
    public static void initTaskSchedules(List<TaskSchedule> taskSchedules) {
        try {
            Map<Scheduler,Map<JobDetail, Set<? extends Trigger>>> schedulerMap = new HashMap();
            for (TaskSchedule taskSchedule : taskSchedules) {
                if(!TaskSchedule.STATUS_ENABLE.equals(taskSchedule.getStatus()) ||
                        !CronExpressionTool.validTime(taskSchedule.getCronexpression())){
                    continue;
                }
                Scheduler scheduler = getScheduler(taskSchedule);
                Pair<JobDetail, CronTrigger> pair = ScheduleTool.createScheduleJob(taskSchedule);
                if (pair == null) {
                    continue;
                }
                Map<JobDetail, Set<? extends Trigger>> jobDetailSetMap = schedulerMap.get(scheduler);
                if (jobDetailSetMap == null) {
                    jobDetailSetMap = new HashMap<>();
                    schedulerMap.put(scheduler,jobDetailSetMap);
                }
                jobDetailSetMap.put(pair.getKey(), SetTool.newHashSet(pair.getValue()));
            }
            for (Map.Entry<Scheduler, Map<JobDetail, Set<? extends Trigger>>> schedulerMapEntry : schedulerMap.entrySet()) {
                Scheduler scheduler = schedulerMapEntry.getKey();
                ScheduleTool.scheduleJobs(scheduler,schedulerMapEntry.getValue());
                log.debug("批量初始化Scheduler[{0}]成功。", scheduler.getSchedulerName());
            }
//            Scheduler scheduler = ScheduleTool.getScheduler(taskSchedule);
////            CronTrigger cronTrigger = getCronTrigger(scheduler, taskSchedule.getJobCode());
//            if(!TaskSchedule.STATUS_ENABLE.equals(taskSchedule.getStatus()) ||
//                    !CronExpressionTool.validTime(taskSchedule.getCronexpression())){
//                return;
//            }
//            Pair<JobDetail, CronTrigger> pair = createScheduleJob(taskSchedule);
////            scheduler.deleteJob()
//            scheduler.scheduleJob(pair.getKey(), pair.getValue());
//            scheduler.rescheduleJob(TriggerKey.triggerKey(taskSchedule.getJobCode()), pair.getValue());
//            log.debug("任务编号[{0}]创建成功。", pair.getKey().getKey());
        } catch (SchedulerException e) {
            String msg = "SchedulerException--创建定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        } catch (ScheduleException e) {
            String msg = "ScheduleException--创建定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //region getJobDetailByJobCode(Scheduler scheduler, String jobCode)
    public static JobDetail getJobDetailByJobCode(Scheduler scheduler, String jobCode) {
        JobDetail jobDetail = null;
        try {
            jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobCode));
        } catch (SchedulerException e) {
            log.error(e);
        }
        return jobDetail;
    }
    //endregion

    //region scheduleJobs(Scheduler scheduler, Map<JobDetail, Set<? extends Trigger>> triggersAndJobs)
    public static void scheduleJobs(Scheduler scheduler, Map<JobDetail, Set<? extends Trigger>> triggersAndJobs) {
        String schedulerName = "";
        try {
            schedulerName = scheduler.getSchedulerName();
            scheduler.scheduleJobs(triggersAndJobs, true);
                log.info("批量调度创建成功,调度器名称:{0}.", scheduler.getSchedulerName());
        } catch (ObjectAlreadyExistsException e) {
            log.error(e, "任务调度已经存在,调度器名称:{0}.", schedulerName);
        } catch (SchedulerException e) {
            log.error(e, "创建定时任务失败,调度器名称:{0}.", schedulerName);
        }
    }
    //endregion

    //region updateScheduleJob(TaskSchedule taskSchedule)
    public static void updateScheduleJob(TaskSchedule taskSchedule) {
        Scheduler scheduler = ScheduleTool.getScheduler(taskSchedule);
        updateScheduleJob(scheduler, taskSchedule.getJobCode(), taskSchedule.getCronexpression(), taskSchedule);
    }

    public static void updateScheduleJob(Scheduler scheduler, String jobCode, String cronExpression, Object param) {
        try {
            JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobCode));
            TriggerKey triggerKey = TriggerKey.triggerKey(jobCode);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
            resumeJob(scheduler, jobCode);

            TaskSchedule oldJob = (TaskSchedule) jobDetail.getJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY);
            TaskSchedule newJob = (TaskSchedule) param;
            log.debug("任务编号[{0}],任务名称[{1}],任务组名[{2}],修改前任务别名[{3}]，修改后任务别名[{4}]完成更新动作。", jobCode, oldJob.getJobName(), oldJob.getJobGroup(), oldJob.getAliasName(), newJob.getAliasName());
        } catch (SchedulerException e) {
            String msg = "更新定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //region deleteScheduleJob(Scheduler scheduler, String jobCode)
    public static void deleteScheduleJob(Scheduler scheduler, String jobCode) {
        try {
            scheduler.deleteJob(JobKey.jobKey(jobCode));
            log.debug("任务名称[{0}]删除成功。", jobCode);
        } catch (SchedulerException e) {
            String msg = "删除定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //region resumeJob(Scheduler scheduler, String jobCode)
    public static void resumeJob(Scheduler scheduler, String jobCode) {
        JobKey jobKey = JobKey.jobKey(jobCode);
        try {
            scheduler.resumeJob(jobKey);
            log.debug("任务编号[{0}]完成恢复动作。", jobCode);
        } catch (SchedulerException e) {
            String msg = "恢复定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //region runOnce(Scheduler scheduler, String jobCode, Object... objs)
    public static void runOnce(Scheduler scheduler, String jobCode, Object... objs) {
        JobKey jobKey = JobKey.jobKey(jobCode);
        try {
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail != null) {
                JobDataMap jobDataMap = jobDetail.getJobDataMap();
                jobDataMap.put(TaskScheduleVo.JOB_PARAM_KEY_ARRAY, objs);
                scheduler.triggerJob(jobKey, jobDataMap);
            }
        } catch (SchedulerException e) {
            String msg = "运行一次定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //endregion

    //region pauseJob(Scheduler scheduler, String jobCode)
    public static void pauseJob(Scheduler scheduler, String jobCode) {
        JobKey jobKey = JobKey.jobKey(jobCode);
        try {
            scheduler.pauseJob(jobKey);
            log.debug("任务编号[{0}]完成暂停动作。", jobCode);
        } catch (SchedulerException e) {
            String msg = "暂停定时任务失败";
            log.error(e, msg);
            throw new ScheduleException(msg);
        }
    }
    //endregion

    //region create pair with job detail and cron trigger
    public static Pair<JobDetail, CronTrigger> createScheduleJob(TaskSchedule taskSchedule) {
        return createScheduleJob(taskSchedule.getJobCode(), taskSchedule.getCronexpression(),taskSchedule.getIsSync() ? JobSyncFactory.class : JobFactory.class, taskSchedule);
    }

    public static Pair<JobDetail, CronTrigger> createScheduleJob(String jobCode, String cronExpression, Class<? extends Job> jobClass, Object param) {
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(jobCode)
                .requestRecovery() //JobDetail指定了requestRecovery，上次执行中，但没有执行完毕的任务会重新执行一遍
                .storeDurably()    //即使没有Trigger关联时，也不需要删除该JobDetail
                .build();

        jobDetail.getJobDataMap().put(TaskScheduleVo.JOB_PARAM_KEY, param);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        scheduleBuilder.withMisfireHandlingInstructionDoNothing();
        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(jobCode)
                .withSchedule(scheduleBuilder)
                .build();

        if (trigger instanceof CronTriggerImpl) {
            Date ft = ((CronTriggerImpl) trigger).computeFirstFireTime(null);
            if (ft == null) {
                return null;
            }
        }
        return new Pair<JobDetail, CronTrigger>(jobDetail, trigger);
    }
    //endregion

    //region getScheduler(TaskSchedule taskSchedule)
    public static Scheduler getScheduler(TaskSchedule taskSchedule) {
        String beanName = taskSchedule.getScheduler();
        if (StringTool.isBlank(beanName)) {
            return (Scheduler) SpringTool.getBean(TaskSchedulerEnum.DEFAULT.getCode());
        } else {
            return (Scheduler) SpringTool.getBean(beanName);
        }
    }
    //endregion

    //region getCronTrigger(TaskSchedule taskSchedule)
    public static CronTrigger getCronTrigger(TaskSchedule taskSchedule) {
        return getCronTrigger(getScheduler(taskSchedule), taskSchedule.getJobCode());
    }
    //endregion

    //region getCronTrigger(Scheduler scheduler, String jobCode)
    public static CronTrigger getCronTrigger(Scheduler scheduler, String jobCode) {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobCode);
        CronTrigger cronTrigger = null;
        try {
            cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            log.error(e);
        }
        return cronTrigger;
    }
    //endregion

    //region isValidTask(String strCronexpression)
    public static boolean isValidTask(String strCronexpression) {
        try {
            new org.soul.commons.support.CronExpression(strCronexpression);
        } catch (ParseException e) {
            log.error(e, "表达式{0}无效不可执行.", strCronexpression);
            return false;
        }
        return true;
    }
    //endregion
}
