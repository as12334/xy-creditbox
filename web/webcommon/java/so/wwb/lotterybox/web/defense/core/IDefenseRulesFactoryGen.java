package so.wwb.lotterybox.web.defense.core;

import so.wwb.lotterybox.web.defense.core.rule.factory.IDefenseRulesFactory;

public interface IDefenseRulesFactoryGen {
    IDefenseRulesFactory gen(String actionCode);
}
