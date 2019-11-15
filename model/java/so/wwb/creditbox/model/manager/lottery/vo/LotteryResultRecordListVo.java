package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResultRecord;
import so.wwb.creditbox.model.manager.lottery.so.LotteryResultRecordSo;


/**
 * 开奖结果记录表列表页值对象
 *
 * @author block
 * @time 2019-11-15 14:17:33
 */
//region your codes 1
public class LotteryResultRecordListVo extends BaseListVo<LotteryResultRecord, LotteryResultRecordSo, LotteryResultRecordListVo.LotteryResultRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -579518391681187728L;
    //endregion your codes 5

    /**
     *  开奖结果记录表列表查询逻辑
     */
    public static class LotteryResultRecordQuery extends AbstractQuery<LotteryResultRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = 7497747442615822119L;
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