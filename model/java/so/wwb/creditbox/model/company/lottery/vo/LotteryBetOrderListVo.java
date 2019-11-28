package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSo;


/**
 * 投注记录表列表页值对象
 *
 * @author block
 * @time 2019-11-27 21:11:29
 */
//region your codes 1
public class LotteryBetOrderListVo extends BaseListVo<LotteryBetOrder, LotteryBetOrderSo, LotteryBetOrderListVo.LotteryBetOrderQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -267905531695585172L;
    //endregion your codes 5

    /**
     *  投注记录表列表查询逻辑
     */
    public static class LotteryBetOrderQuery extends AbstractQuery<LotteryBetOrderSo> {

        //region your codes 6
        private static final long serialVersionUID = -2919845011571704936L;
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