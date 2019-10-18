package so.wwb.creditbox.model.manager.taskschedule.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.creditbox.model.manager.taskschedule.so.TaskRunRecordSo;

//region your codes 1
public class TaskRunRecordListVo extends BaseListVo<TaskRunRecord, TaskRunRecordSo, TaskRunRecordListVo.TaskRunRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -4100453317716395050L;
    //endregion your codes 5

    /**
     *  任务运行结果列表查询逻辑
     */
    public static class TaskRunRecordQuery extends AbstractQuery<TaskRunRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = 6060350417315309326L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(TaskRunRecord.PROP_TASK_SCHEDULE_ID, Operator.EQ, searchObject.getTaskScheduleId());
            criteria.addAnd(TaskRunRecord.PROP_JOB_NAME, Operator.LIKE, searchObject.getJobName());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3
        @Override
        public Sort getDefaultSort() {
            //
            return Sort.add(TaskRunRecord.PROP_STATUS, Direction.ASC).add(TaskRunRecord.PROP_BEGIN_TIME, Direction.DESC);
        }



        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    //endregion your codes 4

}