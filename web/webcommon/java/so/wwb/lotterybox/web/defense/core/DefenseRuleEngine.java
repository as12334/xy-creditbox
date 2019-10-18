package so.wwb.lotterybox.web.defense.core;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.lotterybox.web.defense.core.model.DefenseContext;

import java.util.List;

public class DefenseRuleEngine implements IDefenseRuleEngine{
    private static final Log LOG = LogFactory.getLog(DefenseRuleEngine.class);
    private IDefenseRulesFactoryGen defenseRulesFactoryGen;

    /**
     * 验证规则
     * @param defenseContext
     * @return 防御结果
     */
    public IDefenseRs validRule(DefenseContext defenseContext){
        if (defenseContext == null) {
            return DefenseRs.OK;
        }
        String actionCode = defenseContext.getDefense().action();
        List<IDefenseRule> rules = defenseRulesFactoryGen.gen(actionCode).getRule();
        for ( int i = 0; i < rules.size(); i++) {
            IDefenseRule rule = rules.get(i);
            if (rule == null) {
                continue;
            }
            LOG.info("【防御】，[{0}]：{1}",actionCode,rule.toString());
            if (rule.isMatch(defenseContext)) {
                LOG.info("【防御】，规则生效，此次请求无效!");
                return rule.getResult();
            }
        }
        return DefenseRs.OK;
    }

    public void setDefenseRulesFactoryGen(IDefenseRulesFactoryGen defenseRulesFactoryGen) {
        this.defenseRulesFactoryGen = defenseRulesFactoryGen;
    }
}
