package so.wwb.lotterybox.model.company.lottery.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.sort.Order;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryRule;
import so.wwb.lotterybox.model.company.lottery.so.LotteryRuleSo;

/**
 * 彩票杀率设置列表页值对象
 *
 * @author zain
 * @time 2017-8-22 19:13:23
 */
public class LotteryRuleListVo extends BaseListVo<LotteryRule, LotteryRuleSo, LotteryRuleListVo.LotteryRuleQuery> {

    private static final long serialVersionUID = 9130084664960446902L;

    /**
     *  彩票杀率设置列表查询逻辑
     */
    public static class LotteryRuleQuery extends AbstractQuery<LotteryRuleSo> {
        private static final long serialVersionUID = -1230693181413786412L;

        @Override
        public Criteria getCriteria() {
            return  null;
        }

        @Override
        public Order[] getOrders() {
            return new Order[]{ Order.asc(LotteryRule.PROP_CODE) };
        }
    }

}