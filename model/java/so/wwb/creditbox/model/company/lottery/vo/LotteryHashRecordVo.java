package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryHashRecord;
import so.wwb.creditbox.model.company.lottery.so.LotteryHashRecordSo;

/**
 * hash记录表值对象
 *
 * @author marz
 * @time 2018-3-28 19:00:04
 */
//region your codes 1
public class LotteryHashRecordVo extends BaseObjectVo<LotteryHashRecord, LotteryHashRecordSo, LotteryHashRecordVo.LotteryHashRecordQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -6739143536936681170L;
    //endregion your codes 5

    /**
     *  彩票资金记录表查询逻辑
     */
    public static class LotteryHashRecordQuery extends AbstractQuery<LotteryHashRecordSo> {

        //region your codes 6
        private static final long serialVersionUID = -1432895000839991056L;
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