package so.wwb.creditbox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.creditbox.model.company.lottery.po.LotteryRule;
import so.wwb.creditbox.model.company.lottery.so.LotteryRuleSo;

/**
 * 彩票杀率设置值对象
 *
 * @author zain
 * @time 2017-8-22 19:13:23
 */
//region your codes 1
public class LotteryRuleVo extends BaseObjectVo<LotteryRule, LotteryRuleSo, LotteryRuleVo.LotteryRuleQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -5397469305219411187L;
    //endregion your codes 5

    /**
     *  彩票杀率设置查询逻辑
     */
    public static class LotteryRuleQuery extends AbstractQuery<LotteryRuleSo> {

        //region your codes 6
        private static final long serialVersionUID = 6512930630388421929L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryRule.PROP_CODE, Operator.EQ, searchObject.getCode());
            return  criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}