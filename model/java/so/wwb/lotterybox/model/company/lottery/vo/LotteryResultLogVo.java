package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultLog;
import so.wwb.lotterybox.model.company.lottery.so.LotteryResultLogSo;

/**
 * 彩票杀率设置值对象
 *
 * @author rambo
 * @time 2017-9-9 19:13:23
 */
//region your codes 1
public class LotteryResultLogVo extends BaseObjectVo<LotteryResultLog, LotteryResultLogSo, LotteryResultLogVo.LotteryResultLogQuery> {

//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 6873634423283988807L;
    //endregion your codes 5

    /**
     *  彩票杀率设置查询逻辑
     */
    public static class LotteryResultLogQuery extends AbstractQuery<LotteryResultLogSo> {

        //region your codes 6

        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryResultLog.PROP_CODE, Operator.EQ, searchObject.getCode());
            criteria.addAnd(LotteryResultLog.PROP_EXPECT, Operator.EQ, searchObject.getExpect());
            return  criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}