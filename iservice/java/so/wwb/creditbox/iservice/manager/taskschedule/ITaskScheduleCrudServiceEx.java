package so.wwb.creditbox.iservice.manager.taskschedule;

import org.soul.iservice.taskschedule.ITaskScheduleCrudService;
import org.soul.model.taskschedule.vo.TaskScheduleVo;

public interface ITaskScheduleCrudServiceEx extends ITaskScheduleCrudService {

    TaskScheduleVo updateTaskSchedule(TaskScheduleVo var1);

}