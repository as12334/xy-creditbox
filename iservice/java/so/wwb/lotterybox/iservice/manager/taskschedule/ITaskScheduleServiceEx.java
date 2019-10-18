package so.wwb.lotterybox.iservice.manager.taskschedule;

import org.soul.commons.query.Criteria;
import org.soul.iservice.support.IBaseService;
import org.soul.model.taskschedule.po.TaskSchedule;
import org.soul.model.taskschedule.vo.TaskScheduleListVo;
import org.soul.model.taskschedule.vo.TaskScheduleVo;

import java.util.Date;
import java.util.List;

public interface ITaskScheduleServiceEx extends IBaseService<TaskScheduleListVo, TaskScheduleVo, TaskSchedule, Integer> {

    TaskScheduleVo resumeTask(TaskScheduleVo taskScheduleVo);

    TaskScheduleVo createTaskAndLoad(TaskScheduleVo taskScheduleVo);

    TaskScheduleVo runOnceTask(TaskScheduleVo taskScheduleVo, Object... obj);

    TaskScheduleVo pauseTask(TaskScheduleVo taskScheduleVo);

    TaskScheduleVo deleteTask(TaskScheduleVo taskScheduleVo);

    void deleteExpireTask(String idc, boolean isIncludeDb);

    void pauseAllEnableTask(String idc);

    void resumeAllEnableTask(String idc);

    void deleteAllQuartzTask(String idc, boolean isIncludeDb);

    Date getJobNextFireTime(String jobCode);

    Date getJobNextFireTime(TaskSchedule taskSchedule);

    List<TaskSchedule> search(Criteria criteria);

    TaskScheduleListVo initTaskSchedules(TaskScheduleListVo taskScheduleVo);

    void updateScheduleJob(TaskScheduleVo taskScheduleVo);
}
