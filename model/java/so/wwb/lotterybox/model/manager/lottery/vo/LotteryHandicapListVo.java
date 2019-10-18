package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryHandicap;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryHandicapSo;

/**
 * 彩种盘口列表页值对象
 *
 * @author admin
 * @time 2017-4-11 20:35:57
 */
//region your codes 1
public class LotteryHandicapListVo extends BaseListVo<LotteryHandicap, LotteryHandicapSo, LotteryHandicapListVo.LotteryHandicapQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5347772008366397312L;
    //endregion your codes 5

    /**
     *  彩种盘口列表查询逻辑
     */
    public static class LotteryHandicapQuery extends AbstractQuery<LotteryHandicapSo> {

        //region your codes 6
        private static final long serialVersionUID = -5618653297264802977L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            Criteria criteria = Criteria.add(LotteryHandicap.PROP_TYPE, Operator.EQ, searchObject.getType());
            criteria.addAnd(LotteryHandicap.PROP_CODE, Operator.EQ, searchObject.getCode());
            return criteria;
            //endregion your codes 2
        }


        //region your codes 3


        //endregion your codes 3
    }

    //region your codes 4
    //endregion your codes 4

}