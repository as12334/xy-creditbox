package so.wwb.lotterybox.web.defense.biz;

import so.wwb.lotterybox.web.defense.biz.enums.DefenseAction;
import so.wwb.lotterybox.web.defense.biz.rule.AgentRegisterDefenseRulesFactiory;
import so.wwb.lotterybox.web.defense.biz.rule.PhoneEmailDefenseRulesFactioryFactory;
import so.wwb.lotterybox.web.defense.biz.rule.PlayerRegisterDefenseRulesFactiory;
import so.wwb.lotterybox.web.defense.core.IDefenseRulesFactoryGen;
import so.wwb.lotterybox.web.defense.core.rule.factory.IDefenseRulesFactory;

public class DefenseRulesFactoryGen implements IDefenseRulesFactoryGen {

    @Override
    public IDefenseRulesFactory gen(String actionCode) {
        DefenseAction defenseAction = DefenseAction.enumOf(actionCode);
        switch (defenseAction) {
            case MAIL:
            case PHONE:
                return new PhoneEmailDefenseRulesFactioryFactory();
            case PLAYER_REGISTER:
                return new PlayerRegisterDefenseRulesFactiory();
            case AGENT_REGISTER:
                return new AgentRegisterDefenseRulesFactiory();
        }
        return null;
    }
}
