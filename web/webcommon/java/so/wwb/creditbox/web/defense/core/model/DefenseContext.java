package so.wwb.creditbox.web.defense.core.model;

import so.wwb.creditbox.model.company.setting.po.DefenseRecord;
import so.wwb.creditbox.web.defense.biz.interceptor.IDefense;

public class DefenseContext {

    private IDefense defense;
    private DefenseRecord defenseRecord;
    private DefensePadding defensePadding;

    public IDefense getDefense() {
        return defense;
    }

    public void setDefense(IDefense defense) {
        this.defense = defense;
    }

    public DefenseRecord getDefenseRecord() {
        return defenseRecord;
    }

    public void setDefenseRecord(DefenseRecord defenseRecord) {
        this.defenseRecord = defenseRecord;
    }

    public DefensePadding getDefensePadding() {
        return defensePadding;
    }

    public void setDefensePadding(DefensePadding defensePadding) {
        this.defensePadding = defensePadding;
    }
}