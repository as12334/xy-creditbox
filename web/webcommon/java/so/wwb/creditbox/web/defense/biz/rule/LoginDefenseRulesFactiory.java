package so.wwb.creditbox.web.defense.biz.rule;

import org.soul.commons.lang.DateTool;
import so.wwb.creditbox.web.defense.biz.enums.Dispose;
import so.wwb.creditbox.web.defense.biz.enums.TimeLimitType;
import so.wwb.creditbox.web.defense.core.DefenseRs;
import so.wwb.creditbox.web.defense.core.IDefenseRs;
import so.wwb.creditbox.web.defense.core.IDefenseRule;
import so.wwb.creditbox.web.defense.core.rule.InTimeAndTimeLimitRule;
import so.wwb.creditbox.web.defense.core.rule.TimesLimitRule;
import so.wwb.creditbox.web.defense.core.rule.factory.IDefenseRulesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 16-4-11.
 * 登录防御规则
 */
public class LoginDefenseRulesFactiory implements IDefenseRulesFactory {

    private static final String MESSAGE = "";

    @Override
    public List<IDefenseRule> getRule() {
        List<IDefenseRule> rules = new ArrayList<>();
        rules.add(getTimeLimit4Success());

        return rules;
    }

    /**
     * IP 次数限制
     *
     * @return
     */
    private TimesLimitRule getTimeLimit4Success() {
        Integer loginTimes = 5;

        if (loginTimes <= 0) {
            return null;
        }

        InTimeAndTimeLimitRule rule = getInTimeAndTimeLimitRule();
        rule.setTimes(loginTimes);
        rule.setIntervalSecond(24 * 3600);
        rule.setTimeLimitType(TimeLimitType.SUCCESS);

        return rule;
    }

    private InTimeAndTimeLimitRule getInTimeAndTimeLimitRule() {
        return new InTimeAndTimeLimitRule() {
            @Override
            public IDefenseRs getResult() {
                DefenseRs rs = new DefenseRs(Dispose.DISABLED, false);
                rs.setDisposeEndTime(DateTool.addHours(defenseRecord.getOperateStartTime(), 24));
                rs.setMessage(MESSAGE);
                return rs;
            }
        };
    }

}
