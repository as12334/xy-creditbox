package so.wwb.lotterybox.common.utility.security;

import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.DateTool;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class WeekTool {

    //get first day of the week
    public static Date getWeekStartDate(Date today) {
        int offset = getTimeZone().getRawOffset();
        Date date1 = DateTool.addMilliseconds(today, offset);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        Date date2 = DateTool.addDays(date1, (week < 2 ? (week - 7) : (-week + 2)));

        return DateTool.addMilliseconds(date2, -offset);
    }

    //get first day of the month
    public static Date getMonthStartDate(Date today) {
        int offset = getTimeZone().getRawOffset();
        Date date1 = DateTool.addMilliseconds(today, offset);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date date2 = DateTool.addDays(date1, (-day + 1));

        return DateTool.addMilliseconds(date2, -offset);
    }

    //get the distance with time zoon by hour
    public static Integer getTimeZoneIntervalByHour() {
        int offset = getTimeZone().getRawOffset();
        int interval = offset / 1000 / 60 / 60;
        return interval;
    }

    //get the distance with time zoon by day
    public static Integer getTimeZoneIntervalByDay() {
        int offset = getTimeZone().getRawOffset();
        int interval = offset / 1000 / 60 / 60 / 24;
        return interval;
    }

    //get the distance of time zoon
    public static TimeZone getTimeZone() {
        TimeZone sessionTz = CommonContext.get().getTimeZone();
        if (sessionTz == null) {
            sessionTz = CommonContext.get().getSiteTimeZone();
        }
        return sessionTz;
    }

    /**
     * 本周第一天
     */
    public static Date getWeekStartDate(Date today, TimeZone timeZone) {
        if(timeZone == null ){
            timeZone = CommonContext.get().getTimeZone();
        }
        int offset = timeZone.getRawOffset();
        Date date1 = DateTool.addMilliseconds(today, offset);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        Date date2 = DateTool.addDays(date1, (week < 2 ? (week - 7) : (-week + 2)));

        return DateTool.addMilliseconds(date2, -offset);
    }
}
