package so.wwb.creditbox.web.tools;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.soul.commons.lang.DateTool;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 用于确认cron表达式正确性
 * Created by marz on 18-7-22.
 */
public class TriggerTool {


    public static List<Date> getTriggerDateList(String cron)throws ParseException,InterruptedException{
        return getTriggerDateList(cron,TimeZone.getDefault());
    }

    public static List<Date> getTriggerDateList(String cron,TimeZone timeZone) throws ParseException,InterruptedException{
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        cronTriggerImpl.setCronExpression(cron);//这里写要准备猜测的cron表达式
        cronTriggerImpl.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.YEAR, 2);//把统计的区间段设置为从现在到2年后的今天（主要是为了方法通用考虑，如那些1个月跑一次的任务，如果时间段设置的较短就不足20条)
        return TriggerUtils.computeFireTimesBetween(cronTriggerImpl, null, now, calendar.getTime());//这个是重点，一行代码搞定~~
    }


    public static void main(String[] args) throws ParseException,InterruptedException {
        String cron = "0 5/5 01-15 * * ?";
        TimeZone timeZone = TimeZone.getTimeZone("GMT+:00:00");
        List<Date> dates = getTriggerDateList(cron,timeZone);
        System.out.println(dates.size());
        for (int i = 0; i < dates.size(); i++) {
            if (i > 600) {//这个是提示的日期个数
                break;
            }
            System.out.println(DateTool.formatDate(dates.get(i),DateTool.yyyy_MM_dd_HH_mm_ss));
        }
    }
}
