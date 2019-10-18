package so.wwb.creditbox.model.constants.common;

import org.soul.commons.lang.DateTool;

import java.util.Date;

public interface Const  extends org.soul.commons.init.context.Const{

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
     * 临时域名可用的的天数
     */
    int Domain_Temp_Can_Use_Days = 15;
    /**
     * 注册验证邮箱发送间隔时间
     */
    Integer REGISTER_SEND_EMAIL_INTERVAL_SECONDS = 60;
    /**
     * 页面缓存前缀
     */
    String PAGE_CACHE_PREFIX = "msites:";
    /**
     * 注册手机发送间隔时间
     */
    Integer REGISTER_SEND_PHONE_INTERVAL_SECONDS = 60;
    String MANAGER_SITE_ID ="0";

    /**
     * 存放于请求头中的token
     */
    String PARAM_TOKEN = "token";

    /**
     * 默认系统操作人名称
     */
    String SYSTEM_OPERATOR = "system";

}
