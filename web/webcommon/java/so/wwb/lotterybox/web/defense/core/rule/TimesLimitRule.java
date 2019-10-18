package so.wwb.lotterybox.web.defense.core.rule;

import so.wwb.lotterybox.model.company.setting.po.DefenseRecord;
import so.wwb.lotterybox.web.defense.biz.enums.TimeLimitType;

import java.text.MessageFormat;

/**
 * Created by longer on 1/10/16.
 * 规则:次数限制
 */
public class TimesLimitRule extends AbstractDefenseRule {

    /**
     * 次数限制
     */
    private int times;

    protected TimeLimitType timeLimitType = TimeLimitType.ERROR;

    protected Integer getCompareTimes(DefenseRecord defenseRecord){
        if (getTimeLimitType() == TimeLimitType.ERROR) {
            return defenseRecord.getErrorTimes();
        } else{
            return defenseRecord.getSuccessTimes();
        }
    }

    @Override
    public boolean isSubMatch() {
        Integer recordTimes = getCompareTimes(defenseRecord);
        if (recordTimes == null) {//防御次数为空，则此次防御规则无效
            return false;
        }
        return recordTimes >= getTimes();
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public void setTimeLimitType(TimeLimitType timeLimitType) {
        this.timeLimitType = timeLimitType;
        if (timeLimitType == null) {
            this.timeLimitType = TimeLimitType.ERROR;
        }
    }

    @Override
    public String toString() {
        return  MessageFormat.format("times:[{0}]", getTimes());
    }

    public TimeLimitType getTimeLimitType() {
        return timeLimitType;
    }
}
