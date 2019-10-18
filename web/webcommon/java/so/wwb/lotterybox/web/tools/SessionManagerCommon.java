package so.wwb.lotterybox.web.tools;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.SerializationTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.DateQuickPicker;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.web.session.RedisSessionDao;
import org.soul.web.session.SessionManagerBase;
import org.springframework.beans.BeanUtils;
import redis.clients.util.SafeEncoder;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.model.constants.common.SessionKey;
import so.wwb.lotterybox.model.enums.base.PrivilegeStatusEnum;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.utility.DomainTool;
import so.wwb.lotterybox.web.cache.Cache;
import so.wwb.lotterybox.web.shiro.common.delegate.IPassportDelegate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

public class SessionManagerCommon extends SessionManagerBase {
    private static final Log LOG = LogFactory.getLog(SessionManagerCommon.class);
    public static final String S_IS_REMINDER_MSG = "S_IS_REMINDER_MSG";
    public static final String S_IS_REMINDER_TASK = "S_IS_REMINDER_TASK";
    public static final String SESSION_THEME_FILE_NAME = "SESSION_THEME_FILE_NAME";
    public static final String SESSION_MASTER_INFO = "SESSION_MASTER_INFO";

    public static final String S_PRIVILEGE_STATUS = "S_PRIVILEGE_STATUS";
    //站长信息

    ///找回密码验证邮箱发送时间
    private static final String S_FORGET_PWD_SEND_EMAIL_TIME = "S_FORGET_PWD_SEND_EMAIL_TIME";
    //找回密码邮箱验证码
    private static final String S_FORGET_PWD_CHECK_EMAIL_CODE = "S_FORGET_PWD_CHECK_EMAIL_CODE";
    //用户id加密
    private static final String S_ENCRYPTED_ID = "S_ENCRYPTED_ID";
    //站点未结算账单调用函数间隔时间
    private static final String S_STAT_SITE_ORDER_UNSETTLE_DELAY_TIME = "S_STAT_SITE_ORDER_UNSETTLE_DELAY_TIME";
    //站点重分发行数调用间隔时间
    private static final String S_STAT_SITE_ORDER_DISTRIBUTE_DELAY_TIME = "S_STAT_SITE_ORDER_DISTRIBUTE_DELAY_TIME";
    //查询彩票盘口时间
    public static final String S_LOTTERY_HANDICAP_TIME = "S_LOTTERY_HANDICAP_TIME";
    //彩票试玩
    public static final String SESSION_IS_LOTTERY_DEMO = "SESSION_IS_LOTTERY_DEMO";

    //游戏中心-消息-追问提交时间
    private static final String S_ADVISORY_MESSAGE_TIME = "S_ADVISORY_MESSAGE_TIME";

    /**
     * 站点未结算账单调用函数间隔时间
     *
     * @return
     */
    public static boolean getStatSiteOrderDistributeDelay() {
        long delayTime = 600000;//毫秒
        return isDelayTime(S_STAT_SITE_ORDER_DISTRIBUTE_DELAY_TIME, delayTime);
    }

    public static void resetStatSiteOrderDistributeDelay() {
        setAttribute(S_STAT_SITE_ORDER_DISTRIBUTE_DELAY_TIME, System.currentTimeMillis());
    }

    /**
     * 站点未结算账单调用函数间隔时间
     *
     * @return
     */
    public static boolean getStatSiteOrderUnsettleDelay() {
        long delayTime = 600000;//毫秒
        return isDelayTime(S_STAT_SITE_ORDER_UNSETTLE_DELAY_TIME, delayTime);
    }

    public static void resetStatSiteOrderUnsettleDelay() {
        setAttribute(S_STAT_SITE_ORDER_UNSETTLE_DELAY_TIME, System.currentTimeMillis());
    }

    /**
     * 是否在在限制时间外
     *
     * @param key
     * @param delayTime
     * @return
     */
    private static boolean isDelayTime(String key, long delayTime) {
        if (getAttribute(key) == null) {
            return true;
        }
        long t = (long) getAttribute(key);
        long now = System.currentTimeMillis();
        LOG.info("站点调用函数：{0},间隔剩余时间：{1}毫秒,状态：{2}", key, delayTime - now + t, (now - t) > delayTime ? "开始调用函数" : "限制时间内，跳过调用函数");
        return (now - t) > delayTime;
    }


    /**
     * 当前用户类型
     * 　21站长用户，22，总代用户，2３代理用户，2４玩家用户
     *
     * @return
     */
    public static UserTypeEnum getUserType() {
        return EnumTool.enumOf(UserTypeEnum.class, getUser().getUserType().toString());
    }

    /**
     * 是否提醒消息标识
     *
     * @return
     */
    public static boolean getIsReminderMsg() {
        if (getAttribute(S_IS_REMINDER_MSG) == null) {
            return false;
        } else {
            return (boolean) getAttribute(S_IS_REMINDER_MSG);
        }
    }

    public static void setIsReminderMsg(boolean isReminderMsg) {
        setAttribute(S_IS_REMINDER_MSG, isReminderMsg);
    }

    /**
     * 是否任务提醒消息标识
     *
     * @return
     */
    public static boolean getIsReminderTask() {
        if (getAttribute(S_IS_REMINDER_TASK) == null) {
            return false;
        } else {
            return (boolean) getAttribute(S_IS_REMINDER_TASK);
        }
    }

    public static void setIsReminderTask(boolean isReminderTask) {
        setAttribute(S_IS_REMINDER_TASK, isReminderTask);
    }

    /**
     * 获取用户时区当前时间
     *
     * @return
     * @author: Jerry
     */
    public static String getUserTimeZoneDate() {
        Map<String, String> map = new HashMap<>(2);
        map.put("dateTimeFromat", CommonContext.getDateFormat().getDAY_SECOND());
        map.put("dateTime", SessionManagerBase.getUserDate(CommonContext.getDateFormat().getDAY_SECOND()));
        map.put("time", String.valueOf(System.currentTimeMillis()));
        return JsonTool.toJson(map);
    }

    /**
     * 获取session中的权限状态
     *
     * @return
     * @author: Impluse
     */
    public static Map getPrivilegeStatus() {
        Object o = getAttribute(S_PRIVILEGE_STATUS);
        if (o == null) {
            return null;
        } else {
            return (Map) o;
        }
    }

    /**
     * 检查权限密码是否有效，并且在5分钟内
     *
     * @return true:有效；False:无效
     */
    public static boolean checkPrivilegeStatus() {
        Map<String, Object> pStatus = getPrivilegeStatus();
        if (pStatus != null) {
            Integer privilegeTime = 300;
            String time = ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME).getParamValue();

            if (StringTool.isNotBlank(time)) {
                privilegeTime = Integer.parseInt(time) * 60;

            } else {
                time = ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME).getDefaultValue();
                if (StringTool.isNotBlank(time)) {
                    privilegeTime = Integer.parseInt(time) * 60;
                }
            }
            Map param = null;
            try {
                //为什么取这个值 ？？
                param = (Map) pStatus.values().iterator().next();
                System.out.println("================================");
            } catch (Exception e) {
                param = pStatus;
            }
            return param.get("state") != null && param.get("state").toString().equals(PrivilegeStatusEnum.STATUS_OK.getCode()) &&
                    DateTool.secondsBetween(new Date(), (Date) pStatus.get("time")) < privilegeTime;
        }
        return false;
    }

    public static void setPrivilegeStatus(Map privilegeStatus) {
        setAttribute(S_PRIVILEGE_STATUS, privilegeStatus);
    }

    public static void clearPrivilegeStatus() {
        setAttribute(S_PRIVILEGE_STATUS, null);
    }

    //region site domain

    //get site domain name
    public static String getSiteDomainName(HttpServletRequest request) {
        return getSiteDomain(request).getName();
    }

    public static String getSiteDomainTilte(HttpServletRequest request){
        if(StringUtils.isEmpty(getSiteDomain(request).getTitle())){
            return getSiteDomain(request).getName();
        }
        return getSiteDomain(request).getTitle();
    }

    //get system site domain po
    public static VSysSiteDomain getSiteDomain(HttpServletRequest request) {
        return Cache.getSiteDomain().get(DomainTool.getDomain(request));
    }

    /**
     * 获取站点最新的Logo
     *
     * @return
     */
    public static String getLogo() {
        Collection<SysSite> values = Cache.getSysSite().values();
        String siteLogoUrl = "";
        if (CollectionTool.isNotEmpty(values)){
            for (SysSite site : values){
                if (site.getId().equals(getSiteId())){
                    siteLogoUrl = site.getLogoPath();
                }
            }
        }
        return siteLogoUrl;
    }

    public static String getFlashLogo() {
        //return Cache.getSiteFlashLogoUrl(getSiteId());
        return "";
    }

    /**
     * 获取当前时间
     *
     * @return
     * @author Longer
     */
    public static DateQuickPicker getDate() {
        return DateQuickPicker.getInstance();
    }

    /**
     * 获取权限密码
     *
     * @return
     */
    public static String getPrivilegeCode() {
        return SessionManagerBase.getUser().getPermissionPwd();
    }

    /**
     * 刷新当前登录用户信息
     */
    public static void refreshUser() {
        SysUserVo vo = new SysUserVo();
        vo.getSearch().setId(getUserId());
        if (UserTypeEnum.COMPANY.getCode().equals(getUser().getUserType())) {
            vo._setDataSourceId(SessionManagerCommon.getSiteParentId());
        }
        vo = ServiceTool.sysUserService().get(vo);
        SysUser sysUser = vo.getResult();
        if (sysUser != null) {
            setUser(sysUser);
        }

    }

    /**
     * 统一获取审批用户的方法，主要是处理站长虚拟账号的情况
     *
     * @return
     */
    public static Integer getAuditUserId() {
        if (getUser().getUserType().equals(UserTypeEnum.COMPANY.getCode())) {
            return Const.MASTER_BUILT_IN_ID;
        } else {
            return getUserId();
        }
    }

    /**
     * 根据key获取缓存验证码
     * For Example:SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_PHONE.getSuffix()
     * <p>
     * add by eagle on 20160219
     *
     * @param key
     * @return
     */
    public static String getCaptcha(String key) {
        return (String) getAttribute(key);
    }

    public static void setMasterInfo(SysUser user) {
        setAttribute(SESSION_MASTER_INFO, user);
    }

    public static SysUser getMasterInfo() {
        return (SysUser) getAttribute(SESSION_MASTER_INFO);
    }

    /**
     * 找回密码验证邮箱发送时间
     *
     * @param sendTime 发送时间
     */
    public static void setForgetPwdCheckEmailTime(Date sendTime) {
        setAttribute(S_FORGET_PWD_SEND_EMAIL_TIME, sendTime);
    }

    public static boolean canSendForgetPwdEmail() {
        Date lastSendTime = (Date) getAttribute(S_FORGET_PWD_SEND_EMAIL_TIME);
        return lastSendTime == null || DateTool.addSeconds(lastSendTime, Const.REGISTER_SEND_EMAIL_INTERVAL_SECONDS).getTime() < System.currentTimeMillis();
    }

    public static void setCheckForgetPwdEmailInfo(String code) {
        setAttribute(S_FORGET_PWD_CHECK_EMAIL_CODE, code);
    }

    public static String getCheckForgetPwdEmailInfo() {
        return (String) getAttribute(S_FORGET_PWD_CHECK_EMAIL_CODE);
    }

    /**
     * 注册验证邮箱发送时间
     *
     * @param sendTime 发送时间
     */
    public static void setRegisterCheckEmailTime(Date sendTime) {
        setAttribute(S_FORGET_PWD_SEND_EMAIL_TIME, sendTime);
    }

    public static void clearSession() {
        try {
            SysUser sysUser = getUser();
            if (sysUser != null) {
                SysUserVo vo = new SysUserVo();
                vo.setResult(sysUser);
                vo.getResult().setLastActiveTime(new Date());
                vo.getResult().setLastLogoutTime(new Date());
                if (vo.getResult().getTotalOnlineTime() == null) {
                    vo.getResult().setTotalOnlineTime(0L);
                }
                vo.getResult().setTotalOnlineTime(vo.getResult().getTotalOnlineTime() + DateTool.secondsBetween(vo.getResult().getLastLogoutTime(), vo.getResult().getLoginTime()));
                vo.setProperties(SysUser.PROP_LAST_LOGOUT_TIME, SysUser.PROP_TOTAL_ONLINE_TIME);
                if (sysUser.getUserType().equals(UserTypeEnum.COMPANY.getCode())) {
                    vo._setDataSourceId(CommonContext.get().getSiteParentId());
                } else {
                    vo._setDataSourceId(sysUser.getSiteId());
                }
                ServiceTool.sysUserService().updateOnly(vo);
            }
            Subject subject = SecurityUtils.getSubject();
            org.apache.shiro.mgt.SecurityManager securityManager = SecurityUtils.getSecurityManager();
            securityManager.logout(subject);
        } catch (SessionException ise) {
            LOG.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
    }

    //begin add by Bruce.Q
    //注册验证邮箱发送时间
    private static final String S_REGISTER_SEND_PHONE_TIME = "S_REGISTER_SEND_PHONE_TIME";
    //注册邮箱验证码
    private static final String S_REGISTER_CHECK_PHONE_CODE = "S_REGISTER_CHECK_PHONE_CODE";

    public static void setSendRegisterPhone(Date date) {
        setAttribute(S_REGISTER_SEND_PHONE_TIME, date);
    }

    public static Date getSendRegisterPhone() {
        return (Date) getAttribute(S_REGISTER_SEND_PHONE_TIME);
    }

    public static boolean canSendRegisterPhone() {
        Date lastSendTime = (Date) getAttribute(S_REGISTER_SEND_PHONE_TIME);
        return lastSendTime == null || DateTool.addSeconds(lastSendTime, Const.REGISTER_SEND_PHONE_INTERVAL_SECONDS).getTime() < System.currentTimeMillis();
    }

    public static void setCheckRegisterPhoneInfo(Map<String, String> param) {
        setAttribute(S_REGISTER_CHECK_PHONE_CODE, param);
    }

    public static Map<String, String> getCheckRegisterPhoneInfo() {
        return (Map) getAttribute(S_REGISTER_CHECK_PHONE_CODE);
    }

    public static Object getSpringMvcToken() {
        return getAttribute(SessionKey.S_TOKEN);
    }

    public static void setSpringMvcToken(Map<String, Object[]> springmvc_token) {
        setAttribute(SessionKey.S_TOKEN, springmvc_token);
    }

    /**
     * 忘记密码用到用户id加密
     *
     * @param encryptedId
     */
    public static void setEncryptedId(String encryptedId) {
        setAttribute(S_ENCRYPTED_ID, encryptedId);
    }

    public static String getEncryptedId() {
        return (String) getAttribute(S_ENCRYPTED_ID);
    }

    public static void removeEncryptedId() {
        removeAttribute(S_ENCRYPTED_ID);
    }

    /**
     * 重新赋值session用户
     *
     * @param userId
     */
    public static void resetUserSession(Integer userId) {
        RedisSessionDao redisSessionDao = (RedisSessionDao) SpringTool.getBean("redisSessionDao");
        JedisClientProxy jedisClientProxy = redisSessionDao.getJedisClientProxy();
        SysUserVo userVo = new SysUserVo();
        userVo.getSearch().setId(userId);
        userVo = ServiceTool.sysUserService().get(userVo);
        Set<String> keys = redisSessionDao.getUserActiveSessions(userVo.getResult().getUserType(), userVo.getResult().getId());
        for (String key : keys) {
            try {
                Session session = (Session)SerializationTool.deserialize(jedisClientProxy.get(SafeEncoder.encode(key)));
                session.setAttribute(org.soul.model.session.SessionKey.S_USER, userVo.getResult());
                jedisClientProxy.setex(SafeEncoder.encode(key),1800,SerializationTool.serialize((Serializable)session));
            } catch (Exception e) {
                LOG.error(e);
            }
        }
    }

    /**
     * @return
     */
    public static SysUserExtend getSysUserExtend() {
        Object obj = getAttribute(org.soul.model.session.SessionKey.S_USER);
        if (obj != null && obj instanceof SysUserExtend) {
            return (SysUserExtend) obj;
        } else if (obj != null && obj instanceof SysUser) {
            SysUserExtend user = new SysUserExtend();
            BeanUtils.copyProperties(user, obj);
            return user;
        }
        return null;
    }

    /**
     * 返回当前用户的subsysCode
     * @return
     */
    public static String getSubsysCode() {
        SysUserExtend sysUserExtend = getSysUserExtend();
        return sysUserExtend == null?null:sysUserExtend.getSubsysCode();
    }


    /**
     * 获取上一次查询盘口时间
     *
     * @param code 彩种
     * @return
     */
    public static Date getLotteryHandicapTime(String code) {
        Map<String, Date> map = (Map<String, Date>) getAttribute(S_LOTTERY_HANDICAP_TIME);
        if (map == null) {
            return null;
        }
        return map.get(code);
    }

    /**
     * 设置查询盘口时间
     *
     * @param code 　彩种
     * @param date 　时间
     */
    public static void setLotteryHandicapTime(String code, Date date) {
        Map<String, Date> map = (Map<String, Date>) getAttribute(S_LOTTERY_HANDICAP_TIME);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(code, date);
        setAttribute(S_LOTTERY_HANDICAP_TIME, map);
    }
    //end

    public static String getRedirectUrl(ServletRequest servletRequest) {
        return getRedirectUrl(servletRequest, "");
    }

    public static String getRedirectUrl(ServletRequest servletRequest, String url) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String scheme = request.getHeader("X-Forwarded-Scheme");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        if (StringTool.isBlank(url)) {
            url = request.getParameter("url");
        }
        if (StringTool.isBlank(url)) {
            String entrance = (String) SessionManagerCommon.getAttribute(org.soul.model.session.SessionKey.S_ENTRANCE);
            if (StringTool.isNotBlank(entrance)) {
                IPassportDelegate passportDelegate = (IPassportDelegate) SpringTool.getBean("passportDelegate");
                url = passportDelegate.getLoginUrl(Integer.valueOf(entrance));
            }
        }
        String directPage = MessageFormat.format("{0}://{1}:{2}{3}", scheme,
                request.getServerName(), port, request.getContextPath() + url);
        LOG.info("directPage11={0}", directPage);
        return directPage;
    }

    public static Date getAdvisoryMessageTime() {
        return (Date) getAttribute(S_ADVISORY_MESSAGE_TIME);
    }

    /**
     * 游戏中心-消息-追问提交时间
     *
     * @param date
     */
    public static void setAdvisoryMessageTime(Date date) {
        setAttribute(S_ADVISORY_MESSAGE_TIME, date);
    }

    /**
     * 取款判断终端的方法
     * @param request
     * @return
     */
    public static String withdrawTerminalOrigin(HttpServletRequest request) {
//        boolean fromMobile = ServletTool.isMobile(request);
//        String origin =request.getHeader("User-Agent");
//        String terminalType = OriginEnum.PC.getCode();
//        if (fromMobile || "app_android".equals(origin) || "ios".equals(origin)) {
//            terminalType = OriginEnum.MOBILE.getCode();
//        }
        return null;
    }

}
