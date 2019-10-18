package so.wwb.lotterybox.web.defense.core;

import so.wwb.lotterybox.web.defense.core.model.DefenseContext;

public interface IDefenseRuleEngine {

    /**
     * 防御规则列表 + 防御记录 --> 防御结果
     * @param defenseContext
     * @return
     */
    IDefenseRs validRule(DefenseContext defenseContext);

    /**
     * 防御工厂生成器
     * @param defenseRulesFactoryGen
     */
    void setDefenseRulesFactoryGen(IDefenseRulesFactoryGen defenseRulesFactoryGen);
}
