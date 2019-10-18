package so.wwb.creditbox.web.defense.core.interceptor;

import so.wwb.creditbox.web.defense.biz.interceptor.IDefense;
import so.wwb.creditbox.web.defense.core.model.DefenseClientId;
import so.wwb.creditbox.web.defense.core.model.DefensePadding;

public interface IDefenseRecordPadding {
    DefensePadding padding(IDefense defense, DefenseClientId defenseClientId);
}
