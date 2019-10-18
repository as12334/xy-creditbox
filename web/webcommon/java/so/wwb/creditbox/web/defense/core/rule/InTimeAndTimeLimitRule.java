package so.wwb.creditbox.web.defense.core.rule;

import org.soul.commons.lang.DateTool;

import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by longer on 1/10/16.
 * 在间隔的时间内,达到一定次数
 */
public class InTimeAndTimeLimitRule extends TimesLimitRule {

    /**
     * 间隔秒数
     */
    private long intervalSecond;

    @Override
    public boolean isSubMatch() {
        if (defenseRecord.getOperateEndTime() == null) {//上一次的操作时间为空，则此次防御规则无效
            return false;
        }
        if (isExceedIntervalSecond()) {//上一次的操作时间超过间隔秒数，则此次防御规则无效
            return false;
        }

        return super.isSubMatch();
    }

    /**
     * 是否已经超过时间间隔
     * @return
     */
    private boolean isExceedIntervalSecond() {
        Date now = new Date();
        return DateTool.secondsBetween(now,defenseRecord.getOperateEndTime()) > getIntervalSecond();
    }

    public void setIntervalSecond(long intervalSecond) {
        this.intervalSecond = intervalSecond;
    }

    public long getIntervalSecond() {
        return intervalSecond;
    }

    @Override
    public String toString() {
        return  MessageFormat.format("intervalSecond:[{0}],times:[{1}]", getIntervalSecond(), getTimes());
    }

}
