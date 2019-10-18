package so.wwb.lotterybox.web.defense.core.rule;

import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;
import so.wwb.lotterybox.web.defense.core.DefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRs;
import so.wwb.lotterybox.web.defense.core.IDefenseRule;
import so.wwb.lotterybox.web.defense.core.model.DefenseContext;
import so.wwb.lotterybox.web.defense.core.model.DefensePadding;

public abstract class AbstractDefenseRule implements IDefenseRule {

    protected IDefenseRs defenseRs;

    protected DefenseRecord defenseRecord;

    protected DefensePadding defensePadding;

    @Override
    public boolean isMatch(DefenseContext defenseContext) {
        this.defenseRecord = defenseContext.getDefenseRecord();
        this.defensePadding = defenseContext.getDefensePadding();
        return this.isSubMatch();
    }

    protected abstract boolean isSubMatch();

    public IDefenseRs getResult() {
        if (defenseRs == null) {
            defenseRs = DefenseRs.OK;
        }
        return defenseRs;
    }

    public void setResult(IDefenseRs result) {
        this.defenseRs = result;
    }

}
