package so.wwb.lotterybox.model.common;

import org.soul.commons.lang.DateTool;

import java.util.Date;

/**
 * Created by longer on 9/6/15.
 */
public interface Const extends org.soul.commons.init.context.Const{

    /**
     * 默认开始
     */
    Date Platform_Begin_Date = DateTool.parseDate("1970-01-01", "yyyy-MM-dd");

    /**
     * 永久有多远
     */
    Date Platform_Forever_Date = DateTool.parseDate("3000-01-01", "yyyy-MM-dd");

    /**
     * 记住不再提醒回话key
     */
    String sessionRemindKey = "SESSION_REMIND_KEY";

    /**
     * 返水统计显示
     * 统计数据数据需展示所有历史数据，明细仅展示近90天的
     */
    Integer dayInterval = 90 ;

    /**
     * 临时域名可用的的天数
     */
    int Domain_Temp_Can_Use_Days = 15;

    /**
     * Redis消息线程名
     */
    String Thread_Name_Reids_Notification = "Reids_Notification_Thread";

    /**
     * 默认总代id
     */
    Integer DEFAULT_DISTRIBUTOR_ID = -1;
    /**
     * 默认代理id
     * */
    Integer DEFAULT_AGENT_ID = -2;

    /**
     * 注册验证邮箱发送间隔时间
     */
    Integer REGISTER_SEND_EMAIL_INTERVAL_SECONDS = 60;
    /**
     * 找回密码 id加密 密钥
     */
    String PASSWORD_KEY = "FIND_PASSWORD_PASSWORD_KEY";

    /**
     * 页面缓存前缀
     */
    String PAGE_CACHE_PREFIX = "msites:";

    /**站点维护系统公告*/
    String SITE_MAINTAIN_ANNOUNCEMENT_JOB_CODE = "SITE_MAINTAIN_ANNOUNCEMENT_JOB_CODE_";
    String PLATFORM_MAINTAIN_ANNOUNCEMENT_JOB_CODE = "PLATFORM_MAINTAIN_ANNOUNCEMENT_JOB_CODE_";

    /**
     * 注册手机发送间隔时间
     */
    Integer REGISTER_SEND_PHONE_INTERVAL_SECONDS = 60;

    /**
     * 导出每页(xls)最大的行数
     */
    Integer PAGE_SIZE_PER_FILE = 50000;

    Integer DEFAULT_BOSS_USER_ID=0;

    //验证码,模糊化默认
    String DEFAULT_NO_GIMPY = "NoGimpy";

   // Integer DEMO_SITE_ID = 105;
}
