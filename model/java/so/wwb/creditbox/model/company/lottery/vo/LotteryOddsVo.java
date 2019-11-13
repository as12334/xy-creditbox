package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.company.lottery.so.LotteryOddsSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-11-14 2:28:50
 */
//region your codes 1
public class LotteryOddsVo extends BaseObjectVo<LotteryOdds, LotteryOddsSo, LotteryOddsVo.LotteryOddsQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7375786816928528126L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class LotteryOddsQuery extends AbstractQuery<LotteryOddsSo> {

        //region your codes 6
        private static final long serialVersionUID = 8562237007303488399L;
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