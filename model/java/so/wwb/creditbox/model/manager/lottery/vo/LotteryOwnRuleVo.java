package so.wwb.creditbox.model.manager.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOwnRule;
import so.wwb.creditbox.model.manager.lottery.so.LotteryOwnRuleSo;


/**
 * 自主开号规则表值对象
 *
 * @author block
 * @time 2019-11-15 15:39:42
 */
//region your codes 1
public class LotteryOwnRuleVo extends BaseObjectVo<LotteryOwnRule, LotteryOwnRuleSo, LotteryOwnRuleVo.LotteryOwnRuleQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -5151148994225305948L;
    //endregion your codes 5

    /**
     *  自主开号规则表查询逻辑
     */
    public static class LotteryOwnRuleQuery extends AbstractQuery<LotteryOwnRuleSo> {

        //region your codes 6
        private static final long serialVersionUID = 7818306768839772070L;
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