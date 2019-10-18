package so.wwb.creditbox.model.manager.taskschedule.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.taskschedule.po.TaskRunRecord;
import so.wwb.creditbox.model.manager.taskschedule.so.TaskRunRecordSo;

//region your codes 1
public class TaskRunRecordVo extends BaseObjectVo<TaskRunRecord, TaskRunRecordSo, TaskRunRecordVo.TaskRunRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -6281029310545695682L;
    //endregion your codes 5

    /**
     *  任务运行结果查询逻辑
     */
    public static class TaskRunRecordQuery extends AbstractQuery<TaskRunRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = -4258677842108766069L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4
}