package so.wwb.creditbox.web.defense.biz.rule;

import org.soul.commons.lang.DateTool;
import so.wwb.creditbox.web.defense.biz.enums.Dispose;
import so.wwb.creditbox.web.defense.core.DefenseRs;
import so.wwb.creditbox.web.defense.core.IDefenseRule;
import so.wwb.creditbox.web.defense.core.model.ResetColumns;
import so.wwb.creditbox.web.defense.core.rule.factory.IDefenseRulesFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by longer on 1/14/16.
 * 规则列表:电话,邮箱更新防御规则
 */
public abstract class RegisterDefenseRulesFactioryFactory implements IDefenseRulesFactory {

    public static final String MESSAGE_1 = "defense.register.disable.hours";
    public static final String MESSAGE_2 = "defense.register.disable.hours.24";

    @Override
    public List<IDefenseRule> getRule() {
        List<IDefenseRule> list = new ArrayList<>();
        //成功:是否达到 间隔限制
        list.add(isIntervalLimit());
        //成功:是否达到 次数限制
        list.add(getTimeLimit4Success());
        return list;
    }

    protected abstract IDefenseRule isIntervalLimit();

    protected abstract IDefenseRule getTimeLimit4Success();

    /**
     * 限制到第二天
     * @return
     * @param interval
     */
    protected DefenseRs disableToInterval(Float interval) {
        DefenseRs rs = new DefenseRs(Dispose.DISABLED,false);
        int min = Float.valueOf(interval * 60).intValue();
        rs.setDisposeEndTime(DateTool.addMinutes(new Date(), min));
        rs.setMessage(MESSAGE_1);
        //warning: this place can't not clean table DefenseRecord's operateStartTime
        rs.removeReset(ResetColumns.START_TIME);
        rs.removeReset(ResetColumns.SUCCESS_TIMES);
        return rs;
    }

}
