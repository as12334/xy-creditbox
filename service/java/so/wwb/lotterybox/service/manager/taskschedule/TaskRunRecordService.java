package so.wwb.lotterybox.service.manager.taskschedule;

import org.soul.service.support.BaseService;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.data.manager.taskschedule.TaskRunRecordMapper;
import so.wwb.lotterybox.iservice.manager.taskschedule.ITaskRunRecordService;
import so.wwb.lotterybox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.lotterybox.model.manager.taskschedule.vo.TaskRunRecordListVo;
import so.wwb.lotterybox.model.manager.taskschedule.vo.TaskRunRecordVo;

public class TaskRunRecordService extends BaseService<TaskRunRecordMapper, TaskRunRecordListVo, TaskRunRecordVo, TaskRunRecord, Integer> implements ITaskRunRecordService {

    @Override
    @Transactional
    public void deleteDirtyData(TaskRunRecordVo taskRunRecordVo) {

    }
}