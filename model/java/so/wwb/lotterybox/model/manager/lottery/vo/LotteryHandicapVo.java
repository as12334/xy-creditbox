package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryHandicap;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryHandicapSo;

/**
 * 彩种盘口值对象
 *
 * @author admin
 * @time 2017-4-11 20:35:57
 */
//region your codes 1
public class LotteryHandicapVo extends BaseObjectVo<LotteryHandicap, LotteryHandicapSo, LotteryHandicapVo.LotteryHandicapQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -1545127929103871896L;
    //endregion your codes 5

    /**
     *  彩种盘口查询逻辑
     */
    public static class LotteryHandicapQuery extends AbstractQuery<LotteryHandicapSo> {

        //region your codes 6
        private static final long serialVersionUID = 1053820712816160523L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}