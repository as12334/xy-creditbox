package so.wwb.creditbox.web.defense.biz.rule;

import so.wwb.creditbox.model.company.setting.po.DefenseRecord;
import so.wwb.creditbox.web.defense.core.interceptor.DefenseRecordPadding;
import so.wwb.creditbox.web.defense.core.rule.InTimeAndTimeLimitRule;

/**
 * Created by longer on 1/29/16.
 * 规则:同一IP操作用户数
 */
public class IpOpUserCountRule extends InTimeAndTimeLimitRule {
    @Override
    protected Integer getCompareTimes(DefenseRecord defenseRecord) {
        if (defensePadding == null) {
            return 0;
        }
        Integer count = (Integer)defensePadding.get(DefenseRecordPadding.IP_OP_USER_COUNT);
        return count == null ? 0 : count;
    }
}
