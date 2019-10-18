package so.wwb.lotterybox.schedule.service.utility;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.soul.commons.exception.ExceptionTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import so.wwb.lotterybox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.lotterybox.model.manager.taskschedule.vo.TaskRunRecordVo;

import java.util.Date;

public class GlobalJobListener implements JobListener {
    private static final Log log = LogFactory.getLog(GlobalJobListener.class);

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        //针对线程清除上下文中的二级缓存
        CommonContext.getCacheObject().clear();
        String jobName = context.getJobDetail().getKey().getName();
        String triggerKeyName = context.getTrigger().getKey().getName();
        String simpleName = context.getJobDetail().getJobClass().getSimpleName();
        TaskSchedule taskSchedule = (TaskSchedule) context.getMergedJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY);
        log.debug("jobName[{0}],triggerKeyName[{1}],jobClass[{2}] 作业执行前事件", jobName, triggerKeyName, simpleName);

        TaskRunRecordVo taskRunRecordVo = new TaskRunRecordVo();
        TaskRunRecord taskRunRecord = new TaskRunRecord();
        taskRunRecord.setJobName(jobName);
        taskRunRecord.setTaskScheduleId(taskSchedule.getId());
        taskRunRecord.setTriggerKeyName(triggerKeyName);
        taskRunRecord.setStatus(TaskRunRecord.STATUS_RUNNING);
        taskRunRecord.setBeginTime(new Date());
        taskRunRecordVo.setResult(taskRunRecord);
        taskRunRecordVo._setDataSourceId(0);

        try {
            TaskRunRecordVo insert = ServiceManager.getTaskRunRecordService().insert(taskRunRecordVo);
            TaskRunRecord result = insert.getResult();
            context.getMergedJobDataMap().put(TaskScheduleVo.JOB_PARAM_KEY_RECORD, result);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        //针对线程清除上下文中的二级缓存
        CommonContext.getCacheObject().clear();
        String jobName = context.getJobDetail().getKey().getName();
        String triggerKeyName = context.getTrigger().getKey().getName();
        String simpleName = context.getJobDetail().getJobClass().getSimpleName();
        log.debug("jobName[{0}],triggerKeyName[{1}],jobClass[{2}] 作业被否决", jobName, triggerKeyName, simpleName);
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        String jobName = context.getJobDetail().getKey().getName();
        String triggerKeyName = context.getTrigger().getKey().getName();
        String simpleName = context.getJobDetail().getJobClass().getSimpleName();
        TaskRunRecord record = (TaskRunRecord) context.getMergedJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY_RECORD);
        log.debug("jobName[{0}],triggerKeyName[{1}],jobClass[{2}] 作业执行后事件......", jobName, triggerKeyName, simpleName);

        String result = TaskRunRecord.RESULT_SUCCESS;
        String remark = "";
        if (jobException != null) {
            result = TaskRunRecord.RESULT_FAIL;
            remark = ExceptionTool.getStackTrace(jobException);
        }

        if (record != null) {
            TaskRunRecordVo taskRunRecordVo = new TaskRunRecordVo();
            taskRunRecordVo.getSearch().setId(record.getId());
            taskRunRecordVo._setDataSourceId(0);
            TaskRunRecordVo taskRunRecordVo1 = ServiceManager.getTaskRunRecordService().get(taskRunRecordVo);
            TaskRunRecord taskRunRecord = taskRunRecordVo1.getResult();
            taskRunRecord.setEndTime(new Date());
            taskRunRecord.setStatus(TaskRunRecord.STATUS_FINISH);
            taskRunRecord.setResult(result);
            taskRunRecord.setRemark(remark);
            taskRunRecordVo1.setResult(taskRunRecord);
            taskRunRecordVo1._setDataSourceId(0);
            ServiceManager.getTaskRunRecordService().update(taskRunRecordVo1);

        } else {
            String errorInfo = "任务调度全局监听器jobWasExecuted,从上下文获取运行记录时为空。";
            log.error(errorInfo);
            result = TaskRunRecord.RESULT_FAIL;
        }

        if (result.equals(TaskRunRecord.RESULT_FAIL)) {
            TaskSchedule taskSchedule = (TaskSchedule) context.getMergedJobDataMap().get(TaskScheduleVo.JOB_PARAM_KEY);
            //Scheduler scheduler = context.getScheduler();
            System.out.println(String.format("任务调度失败：jobId = {0},jobCode ={1}", taskSchedule.getId(), taskSchedule.getJobCode()));
        }
    }
}
