package so.wwb.lotterybox.web.defense.core.interceptor;

import so.wwb.lotterybox.web.defense.biz.interceptor.IDefense;
import so.wwb.lotterybox.web.defense.core.model.DefenseClientId;
import so.wwb.lotterybox.web.defense.core.model.DefensePadding;

public interface IDefenseRecordPadding {
    DefensePadding padding(IDefense defense, DefenseClientId defenseClientId);
}
