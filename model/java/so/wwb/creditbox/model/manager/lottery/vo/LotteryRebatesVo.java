package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryRebates;
import so.wwb.creditbox.model.manager.lottery.so.LotteryRebatesSo;


/**
 * 值对象
 *
 * @author block
 * @time 2019-11-11 23:05:37
 */
//region your codes 1
public class LotteryRebatesVo extends BaseObjectVo<LotteryRebates, LotteryRebatesSo, LotteryRebatesVo.LotteryRebatesQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -7616633073658892133L;
    //endregion your codes 5

    /**
     *  查询逻辑
     */
    public static class LotteryRebatesQuery extends AbstractQuery<LotteryRebatesSo> {

        //region your codes 6
        private static final long serialVersionUID = 3093971757160184714L;
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