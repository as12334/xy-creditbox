package so.wwb.creditbox.iservice.manager.taskschedule;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.creditbox.model.manager.taskschedule.vo.TaskRunRecordListVo;
import so.wwb.creditbox.model.manager.taskschedule.vo.TaskRunRecordVo;

public interface ITaskRunRecordService extends IBaseService<TaskRunRecordListVo, TaskRunRecordVo, TaskRunRecord, Integer> {

    void deleteDirtyData(TaskRunRecordVo taskRunRecordVo);

}