package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryBetting;
import so.wwb.creditbox.model.manager.lottery.so.LotteryBettingSo;


/**
 * 投注玩法表列表页值对象
 *
 * @author block
 * @time 2019-10-20 22:58:44
 */
//region your codes 1
public class LotteryBettingListVo extends BaseListVo<LotteryBetting, LotteryBettingSo, LotteryBettingListVo.LotteryBettingQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -8121608843546370991L;
    //endregion your codes 5

    /**
     *  投注玩法表列表查询逻辑
     */
    public static class LotteryBettingQuery extends AbstractQuery<LotteryBettingSo> {

        //region your codes 6
        private static final long serialVersionUID = -5632110069991051298L;
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