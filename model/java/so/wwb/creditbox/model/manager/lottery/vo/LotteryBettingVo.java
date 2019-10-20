package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryBetting;
import so.wwb.creditbox.model.manager.lottery.so.LotteryBettingSo;


/**
 * 投注玩法表值对象
 *
 * @author block
 * @time 2019-10-20 22:58:44
 */
//region your codes 1
public class LotteryBettingVo extends BaseObjectVo<LotteryBetting, LotteryBettingSo, LotteryBettingVo.LotteryBettingQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 1997066312634883631L;
    //endregion your codes 5

    /**
     *  投注玩法表查询逻辑
     */
    public static class LotteryBettingQuery extends AbstractQuery<LotteryBettingSo> {

        //region your codes 6
        private static final long serialVersionUID = -503101099578335970L;
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