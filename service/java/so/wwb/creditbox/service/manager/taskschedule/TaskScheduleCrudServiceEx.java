package so.wwb.creditbox.service.manager.taskschedule;


import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.support.CommonConf;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleListVo;
import org.soul.model.taskschedule.vo.TaskScheduleVo;
import org.soul.service.quartz.CronExpressionTool;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.manager.taskschedule.TaskScheduleMapper;
import so.wwb.creditbox.iservice.manager.taskschedule.ITaskScheduleCrudServiceEx;

import java.util.Date;


/**
 * 任务调度实体服务
 *
 * Created by mark using soul-code-generator on 2015-7-10 17:00:31
 */
//region your codes 1
public class TaskScheduleCrudServiceEx extends BaseService<TaskScheduleMapper, TaskScheduleListVo, TaskScheduleVo, TaskSchedule, Integer> implements ITaskScheduleCrudServiceEx {
//endregion your codes 1

    //region your codes 2
    private static final Log LOG = LogFactory.getLog(TaskScheduleCrudServiceEx.class);

    @Autowired
    private CommonConf commonConf;

    private String errorMsg ="cron表达式验证不通过，可能的原因是书写错误或该时间是过去时间，不被触发。";

    @Override
    public TaskScheduleListVo search(TaskScheduleListVo listVo) {
        listVo.getSearch().setIdc(commonConf.getIdc());
        return super.search(listVo);
    }

    @Override
    @Transactional
    public TaskScheduleVo createTask(TaskScheduleVo taskScheduleVo) {
        TaskSchedule taskSchedule = taskScheduleVo.getResult();
        boolean b = CronExpressionTool.validTime(taskSchedule.getCronexpression());
        if (!b) {
            taskScheduleVo.setErrMsg(errorMsg);
            taskScheduleVo.setSuccess(false);
            return taskScheduleVo;
        }
        String jobCode = taskSchedule.getJobCode();
        long count = this.mapper.count(Criteria.add(TaskSchedule.PROP_JOB_CODE, Operator.EQ, jobCode));
        if (count <= 0) {//不存在此jobCode
            taskSchedule.setCreateTime(new Date());
            taskSchedule.setStatus(TaskSchedule.STATUS_DISABLE);//新增及编辑后的任务都为停用状态
            taskSchedule.setIsSystem(false);
            if (taskSchedule.getIsDynamic() == null) {
                taskSchedule.setIsDynamic(false);
            }
            if (StringTool.isEmpty(taskSchedule.getIdc())) {
                taskSchedule.setIdc(commonConf.getIdc());
            }

            this.mapper.insert(taskSchedule);
        } else {
            taskScheduleVo.setSuccess(false);
            taskScheduleVo.setErrMsg("存在相同的任务编号" + jobCode + "，不能重复添加！");
        }
        return taskScheduleVo;
    }

    @Override
    @Deprecated
    public void updateTask(TaskScheduleVo taskScheduleVo) {}

    @Override
    @Transactional
    public TaskScheduleVo updateTaskSchedule(TaskScheduleVo taskScheduleVo) {
        TaskSchedule taskSchedule = taskScheduleVo.getResult();
        boolean b = CronExpressionTool.validTime(taskSchedule.getCronexpression());
        if (!b) {
            taskScheduleVo.setErrMsg(errorMsg);
            taskScheduleVo.setSuccess(false);
            return taskScheduleVo;
        }
        taskSchedule.setUpdateTime(new Date());
        this.mapper.updateExcludeProperties(taskSchedule, new String[]{TaskSchedule.PROP_CREATE_TIME,taskSchedule.PROP_STATUS,taskSchedule.PROP_IS_DYNAMIC});
        return taskScheduleVo;
    }
}
