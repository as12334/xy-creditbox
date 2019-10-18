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
 * 转账防御规则
 * Created by fei on 16-4-19.
 */
public class TransferDefenseRulesFactiory implements IDefenseRulesFactory {

    private static final String MESSAGE = "";

    @Override
    public List<IDefenseRule> getRule() {
        List<IDefenseRule> rules = new ArrayList<>();
        rules.add(getTimeLimit4Success());
        return rules;
    }

    /**
     * 转账次数限制，1秒钟限转1次
     * @return
     */
    private TimesLimitRule getTimeLimit4Success() {
        InTimeAndTimeLimitRule rule = getInTimeAndTimeLimitRule();
        rule.setTimes(1);
        rule.setIntervalSecond(1);
        rule.setTimeLimitType(TimeLimitType.SUCCESS);

        return rule;
    }

    private InTimeAndTimeLimitRule getInTimeAndTimeLimitRule() {
        return new InTimeAndTimeLimitRule() {
            @Override
            public IDefenseRs getResult() {
                DefenseRs rs = new DefenseRs(Dispose.DISABLED, false);
                rs.setDisposeEndTime(DateTool.addSeconds(defenseRecord.getOperateStartTime(), 1));
                rs.setMessage(MESSAGE);
                return rs;
            }
        };
    }

}
