package so.wwb.lotterybox.service.manager.taskschedule;

import org.quartz.CronTrigger;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.exception.ServiceException;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleListVo;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.soul.service.quartz.CronExpressionTool;
import org.soul.service.support.BaseService;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.data.manager.taskschedule.TaskScheduleMapper;
import so.wwb.lotterybox.iservice.manager.taskschedule.ITaskScheduleServiceEx;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.exception.ScheduleException;
import so.wwb.lotterybox.utility.ScheduleTool;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

public class TaskScheduleServiceEx extends BaseService<TaskScheduleMapper, TaskScheduleListVo, TaskScheduleVo, TaskSchedule, Integer> implements ITaskScheduleServiceEx {
    private static final Log log = LogFactory.getLog(TaskScheduleServiceEx.class);

    //region search(Criteria criteria)
    @Override
    public List<TaskSchedule> search(Criteria criteria) {
        return this.mapper.search(criteria);
    }
    //endregion

    //region resumeTask(TaskScheduleVo taskScheduleVo)
    @Override
    @Transactional
    public TaskScheduleVo resumeTask(TaskScheduleVo taskScheduleVo) {
        if(checkTaskScheduleVo(taskScheduleVo)){
            TaskSchedule taskSchedule = this.mapper.get(taskScheduleVo.getSearch().getId());
            if (taskSchedule != null) {
                CronTrigger cronTrigger = ScheduleTool.getCronTrigger(taskSchedule);
                if (cronTrigger != null) {
                    ScheduleTool.resumeJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                }else{
                    ScheduleTool.createScheduleJob(taskSchedule);
                }
                taskSchedule.setStatus(TaskSchedule.STATUS_ENABLE);
                this.mapper.update(taskSchedule);
            }else{
                taskScheduleVo.setSuccess(false);
                taskScheduleVo.setErrMsg("无数据");
            }
        }
        return taskScheduleVo;
    }
    //endregion

    //region createTaskAndLoad(TaskScheduleVo taskScheduleVo)
    @Override
    @Transactional
    public TaskScheduleVo createTaskAndLoad(TaskScheduleVo taskScheduleVo) {
        if (taskScheduleVo.isSuccess()) {
            TaskSchedule taskSchedule = taskScheduleVo.getResult();
            try {
                ScheduleTool.createScheduleJob(taskSchedule);
                ScheduleTool.pauseJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                this.mapper.insert(taskSchedule);
            } catch (Exception e) {
                String msg = MessageFormat.format("创建并加载调度任务:{0},异常", taskSchedule.getJobCode());
                log.error(e, msg);
                taskScheduleVo.setSuccess(false);
                taskScheduleVo.setErrMsg(msg);
            }
        }
        return taskScheduleVo;
    }
    //endregion

    //region runOnceTask(TaskScheduleVo taskScheduleVo, Object... obj)
    @Override
    @Transactional
    public TaskScheduleVo runOnceTask(TaskScheduleVo taskScheduleVo, Object... obj) {
        String jobCode = taskScheduleVo.getSearch().getJobCode();
        List<TaskSchedule> taskSchedules = this.mapper.oneSearch(TaskSchedule.PROP_JOB_CODE, jobCode);
        if (CollectionTool.isNotEmpty(taskSchedules) && taskSchedules.size() > 0) {
            TaskSchedule taskSchedule = taskSchedules.get(0);
            if (!taskSchedule.getStatus().equals(TaskSchedule.STATUS_ENABLE)) {
                String msg = "任务编号[{0}]，任务名称[{1}]为停用状态，不可执行";
                log.warn(msg, taskSchedule.getJobCode(), taskSchedule.getJobName());
                throw new ScheduleException(MessageFormat.format(msg, taskSchedule.getJobCode(), taskSchedule.getJobName()));
            }
            ScheduleTool.runOnce(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode(), obj);
        } else {
            log.debug("没有任务编号[{0}]的数据，没办法执行。", jobCode);
            throw new ServiceException(Module.TASKSCHEDULE, "runOnceTask_error", jobCode);
        }
        return taskScheduleVo;
    }
    //endregion

    //region pauseTask(TaskScheduleVo taskScheduleVo)
    @Override
    @Transactional
    public TaskScheduleVo pauseTask(TaskScheduleVo taskScheduleVo) {
        if(checkTaskScheduleVo(taskScheduleVo)){
            TaskSchedule taskSchedule = this.mapper.get(taskScheduleVo.getSearch().getId());
            if (taskSchedule != null) {
                ScheduleTool.pauseJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                taskSchedule.setStatus(TaskSchedule.STATUS_DISABLE);
                this.mapper.update(taskSchedule);
            }else{
                taskScheduleVo.setSuccess(false);
                taskScheduleVo.setErrMsg("无数据");
            }
        }
        return taskScheduleVo;
    }
    //endregion

    //region deleteTask(TaskScheduleVo taskScheduleVo)
    @Override
    @Transactional
    public TaskScheduleVo deleteTask(TaskScheduleVo taskScheduleVo) {
        if(checkTaskScheduleVo(taskScheduleVo)){
            TaskSchedule taskSchedule = this.mapper.get(taskScheduleVo.getSearch().getId());
            if (taskSchedule != null) {
                ScheduleTool.deleteScheduleJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                this.mapper.delete(taskSchedule.getId());
                taskScheduleVo.setSuccess(true);
            }
        }
        return taskScheduleVo;
    }
    //endregion

    /**
     * 检查参数
     * @param taskScheduleVo
     * @return
     */
    private boolean checkTaskScheduleVo(TaskScheduleVo taskScheduleVo){
        if(taskScheduleVo == null || taskScheduleVo.getSearch() == null || taskScheduleVo.getSearch().getId() == null){
            taskScheduleVo.setSuccess(false);
            taskScheduleVo.setErrMsg("缺少参数");
            return false;
        }
        return true;
    }

    //region deleteExpireTask(String idc)
    @Override
    @Transactional
    public void deleteExpireTask(String idc, boolean isIncludeDb) {
        List<TaskSchedule> taskSchedules = this.mapper.search(Criteria.add(TaskSchedule.PROP_STATUS, Operator.EQ, TaskSchedule.STATUS_ENABLE).addAnd(TaskSchedule.PROP_IDC, Operator.EQ, idc));
        if (CollectionTool.isNotEmpty(taskSchedules)) {
            for (TaskSchedule taskSchedule : taskSchedules) {
                if (!CronExpressionTool.validTime(taskSchedule.getCronexpression())) {
                    Integer taskId = taskSchedule.getId();
                    ScheduleTool.deleteScheduleJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                    if (isIncludeDb) {
                        this.mapper.delete(taskId);
                    }
                }
            }
        }
    }
    //endregion

    //region pauseAllEnableTask(String idc)
    @Override
    public void pauseAllEnableTask(String idc) {
        List<TaskSchedule> taskSchedules = this.mapper.search(Criteria.add(TaskSchedule.PROP_STATUS, Operator.EQ, TaskSchedule.STATUS_ENABLE).addAnd(TaskSchedule.PROP_IDC, Operator.EQ, idc));
        if (CollectionTool.isNotEmpty(taskSchedules)) {
            for (TaskSchedule taskSchedule : taskSchedules) {
                try {
                    ScheduleTool.pauseJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    //endregion

    //region resumeAllEnableTask(String idc)
    @Override
    public void resumeAllEnableTask(String idc) {
        List<TaskSchedule> taskSchedules = this.mapper.search(Criteria.add(TaskSchedule.PROP_STATUS, Operator.EQ, TaskSchedule.STATUS_ENABLE).addAnd(TaskSchedule.PROP_IDC, Operator.EQ, idc));
        if (CollectionTool.isNotEmpty(taskSchedules)) {
            for (TaskSchedule taskSchedule : taskSchedules) {
                try {
                    ScheduleTool.resumeJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    //endregion

    //region deleteAllQuartzTask(String idc)
    @Override
    public void deleteAllQuartzTask(String idc, boolean isIncludeDb) {
        List<TaskSchedule> taskSchedules = this.mapper.search(Criteria.add(TaskSchedule.PROP_IDC, Operator.EQ, idc));
        if (CollectionTool.isNotEmpty(taskSchedules)) {
            for (TaskSchedule taskSchedule : taskSchedules) {
                try {
                    ScheduleTool.deleteScheduleJob(ScheduleTool.getScheduler(taskSchedule), taskSchedule.getJobCode());
                    if (isIncludeDb) {
                        this.mapper.delete(taskSchedule.getId());
                    }
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }
    //endregion

    //region Date getJobNextFireTime(String jobCode)
    @Override
    public Date getJobNextFireTime(String jobCode) {
        List<TaskSchedule> taskSchedules = this.mapper.search(Criteria.add(TaskSchedule.PROP_JOB_CODE, Operator.EQ, jobCode));
        if (CollectionTool.isNotEmpty(taskSchedules)) {
            return getJobNextFireTime(taskSchedules.get(0));
        }
        return null;
    }
    //endregion

    //region getJobNextFireTime(TaskSchedule taskSchedule)
    @Override
    public Date getJobNextFireTime(TaskSchedule taskSchedule) {
        CronTrigger cronTrigger = ScheduleTool.getCronTrigger(taskSchedule);
        return cronTrigger.getNextFireTime();
    }
    //endregion

    //region initTaskSchedules(TaskScheduleVo TaskScheduleVo)
    @Override
    @Transactional
    public TaskScheduleListVo initTaskSchedules(TaskScheduleListVo taskScheduleListVo) {
        if (taskScheduleListVo == null || taskScheduleListVo.getResult() == null) {
            log.info("initTaskSchedules：参数丢失");
            taskScheduleListVo.setSuccess(false);
            taskScheduleListVo.setErrMsg("参数丢失");
            return taskScheduleListVo;
        }
        ScheduleTool.initTaskSchedules(taskScheduleListVo.getResult());
        return taskScheduleListVo;
    }
    //endregion

    //region updateScheduleJob(TaskScheduleVo taskScheduleVo)
    @Override
    public void updateScheduleJob(TaskScheduleVo taskScheduleVo) {
        if (taskScheduleVo == null) {
            log.info("TaskScheduleVo--任务不存在");
            return;
        }
        TaskSchedule taskSchedule = taskScheduleVo.getResult();
        if (taskSchedule == null) {
            log.info("taskSchedule--任务不存在");
            return;
        }
        ScheduleTool.updateScheduleJob(taskSchedule);
    }
    //endregion
}
