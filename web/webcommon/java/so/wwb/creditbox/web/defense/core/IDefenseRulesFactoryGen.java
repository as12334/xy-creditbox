package so.wwb.creditbox.web.defense.core;

import so.wwb.creditbox.web.defense.core.rule.factory.IDefenseRulesFactory;

public interface IDefenseRulesFactoryGen {
    IDefenseRulesFactory gen(String actionCode);
}
