package so.wwb.creditbox.web.shiro.common.delegate;

import org.apache.shiro.session.Session;
import org.soul.commons.bean.BeanTool;
import org.soul.commons.cache.CacheKey;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.init.context.ClientInfo;
import org.soul.commons.init.context.Const;
import org.soul.commons.init.context.Operator;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.iservice.common.IIpOrAreaResolver;
import org.soul.model.ip.IpBean;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.session.RedisSessionDao;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.shiro.common.delegate.IPassportListener;
import org.soul.web.shiro.common.delegate.PassportEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.passport.captcha.CaptchaUrlEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class PassportDelegate implements IPassportDelegate {
    private Log log = LogFactory.getLog(getClass());

    @Value("${sso.master.passport.login}")
    private String ssoMasterLogin;

    @Value("${sso.master.passport.logout}")
    private String ssoMasterLogout;

    @Value("${subsys.code}")
    private String subsysCode;
    @Autowired
    private RedisSessionDao redisSessionDao;
    @Autowired
    private IIpOrAreaResolver ipOrAreaResolver;


    private String ssoNormal = "/passport/login.html";

    private String hallLogout = "/auth/login.html";

    private List<IPassportListener> passportListeners;

    @Override
    public void onLoginSuccessDelegate(HttpServletRequest request) {
        SysUser sysUser = SessionManagerBase.getUser();
        ClientInfo clientInfo = AuditLogTool.getClientInfo(request);
        Operator operator = AuditLogTool.getOperator(request, sysUser);
        PassportEvent passportEvent = new PassportEvent();
        passportEvent.setSysUser(sysUser);
        passportEvent.setOperator(operator);
        passportEvent.setIsMaster(SessionManagerBase.isCurrentSiteMaster());
        SessionManagerBase.setAttribute(SessionKey.S_USER_CLINT_INFO, ServletTool.getUserClientInfo(request));
        String sessionId= SessionManagerBase.getId();
        String newSessionKey=sessionId.split(",")[2];
        if(StringTool.isNotBlank(sysUser.getSessionKey())) {
            String oldSessionId = CacheKey.getCacheKey(redisSessionDao.genPrefix(), sessionId.replace(newSessionKey, sysUser.getSessionKey()));
            redisSessionDao.getJedisClientProxy().del(oldSessionId);
        }
        sysUser.setSessionKey(newSessionKey);
        updateSysUser4Login(sysUser, clientInfo);
        fireLoginListener(passportEvent);
    }

    @Override
    public void onLoginSuccessDelegate(HttpServletRequest request, Session session) {
        SysUser sysUser = SessionManagerBase.getUser();
        ClientInfo clientInfo = AuditLogTool.getClientInfo(request);
        Operator operator = AuditLogTool.getOperator(request, sysUser);

        PassportEvent passportEvent = new PassportEvent();
        passportEvent.setSysUser(sysUser);
        passportEvent.setOperator(operator);
        passportEvent.setIsMaster(SessionManagerBase.isCurrentSiteMaster());
        sysUser.setSessionKey(session.getId().toString().split(",")[2]);
        updateSysUser4Login(sysUser, clientInfo);
        fireLoginListener(passportEvent);
    }

    @Override
    public void onLoginFailureDelegate(HttpServletRequest request, HttpServletResponse response, Integer id, String username, Integer loginErrorTimes) {
        Operator operator = AuditLogTool.getOperator(request, null);
        operator.setOperatorId(id);
        operator.setOperator(username);
        PassportEvent passportEvent = new PassportEvent();
        passportEvent.setOperator(operator);
        passportEvent.setAuthenticationFailureTimes(loginErrorTimes);
        passportEvent.setAuthenticationFailureFreezeLimit(Const.AUTHENTICATION_FAILURE_FREEZE_LIMIT);

        //未登录成功,不能从session中获取entrance(CommonContext中也获取不到,因为在LocalRealm中被设为null by susu)
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        Integer entrance = getEntranceType(contextPath, uri);

        if (PassportVo.MASTER.equals(entrance)) {
            //使用站点虚拟账号
            passportEvent.setIsMaster(true);
        }
        fireLoginFailListener(passportEvent);
    }

    public void onLogoutDelegate(HttpServletRequest request, HttpServletResponse response) {
        Integer sysUserId = SessionManagerBase.getUserId();
        String sessionId = SessionManagerBase.getId();
        String entrance = SessionManagerBase.getEntrance();
        SysUser sysUser = SessionManagerBase.getUser();
        if (sysUser == null) return;
        ClientInfo clientInfo = AuditLogTool.getClientInfo(request);
        Operator operator = AuditLogTool.getOperator(request, sysUser);

        PassportEvent passportEvent = new PassportEvent();
        passportEvent.setSysUser(sysUser);
        passportEvent.setOperator(operator);
        passportEvent.setIsMaster(SessionManagerBase.isCurrentSiteMaster());

        updateSysUser4Logout(sysUser, clientInfo);
        fireLogoutSuccesslListener(passportEvent);
    }

    /**
     * 登录时更新系统用户信息
     *
     * @param user
     */
    private void updateSysUser4Login(SysUser user, ClientInfo clientInfo) {
        SysUserExtend extend = new SysUserExtend();
        SysUserExtendVo sysUserVo = new SysUserExtendVo();
        sysUserVo.setResult(extend);
        sysUserVo.setProperties(
                SysUser.PROP_LAST_LOGIN_IP,
                SysUser.PROP_LAST_LOGIN_IP_DICT_CODE,
                SysUser.PROP_LAST_LOGIN_TIME,
                SysUser.PROP_LOGIN_IP,
                SysUser.PROP_LOGIN_IP_DICT_CODE,
                SysUser.PROP_LOGIN_TIME,
                SysUser.PROP_LAST_ACTIVE_TIME,
                SysUser.PROP_USE_LINE,
                SysUser.PROP_LOGIN_ERROR_TIMES,
                SysUser.PROP_SECPWD_ERROR_TIMES,
                SysUser.PROP_SESSION_KEY,
                SysUser.PROP_TERMINAL
        );

        Date now = new Date();
        user.setLoginTime(now);
        user.setLoginIp(clientInfo.getIp());
        user.setLastLoginIp(user.getLoginIp());
        //避免登录时,未获取ip信息
        if(SessionManagerBase.getIpDb() == null){
            String ipStr = IpTool.ipv4LongToString(user.getLoginIp());
            IpBean ipdb = ipOrAreaResolver.getIpFormDb(ipStr);
            SessionManagerBase.setIpDb(ipdb);
        }
        user.setLoginIpDictCode(SessionManagerBase.getIpDictCode());
        user.setLastLoginIpDictCode(user.getLoginIpDictCode());
        user.setLastLoginTime(now);
        user.setLastActiveTime(now);
        user.setLoginErrorTimes(0);
        user.setFreezeEndTime(null);
        user.setUseLine(clientInfo.getServerName());
        user.setSecpwdErrorTimes(null);
        user.setTerminal(AuditLogTool.setTerminal(clientInfo));
        log.info("登录请求 -> 玩家账号:{0}", user.getUsername());
        BeanTool.copyProperties(user, extend);
        try {
            if (UserTypeEnum.PLAYER.getCode().equals(user.getUserType())) {
                sysUserVo.setDataSourceId(SessionManagerBase.getSiteId());
            }
            ServiceTool.sysUserExtendService().update(sysUserVo);
            SessionManagerBase.setUser(user);
        } catch (Exception e) {
            log.error(e, "登录成功:但更新用户登录信息时异常!");
        }
    }

    /**
     * 登录时更新系统用户信息
     *
     * @param user
     */
    private void updateSysUser4Logout(SysUser user, ClientInfo clientInfo) {
        SysUserExtend extend = new SysUserExtend();
        BeanTool.copyProperties(user, extend);
        SysUserExtendVo sysUserVo = new SysUserExtendVo();
        sysUserVo.setResult(extend);
        sysUserVo.setProperties(SysUser.PROP_LAST_LOGOUT_TIME);

        if (user != null) {
            user.setLastLogoutTime(new Date());
            try {
                ServiceTool.sysUserExtendService().updateOnly(sysUserVo);
            } catch (Exception e) {
                log.error(e, "登录成功:但更新用户登录信息时异常!");
            }
        }
    }

    @Override
    public void redirectTo(HttpServletRequest request, HttpServletResponse response, String successUrlOld) throws IOException {
        String url = request.getContextPath() + successUrlOld;
        response.getWriter().print("<script>window.top.location.href='" + url + "';</script>");
        response.flushBuffer();
        response.getWriter().close();
    }

    /**
     * 获取登录入口类型
     */
    @Override
    public Integer getEntranceType(String contextPath, String uri) {
        if (StringTool.isBlank(ssoMasterLogin)) {
            return PassportVo.NORMAL;
        }
        if (uri.contains(contextPath + ssoMasterLogin) || uri.contains(contextPath + ssoMasterLogout)) {
            return PassportVo.MASTER;
        }
        return PassportVo.NORMAL;
    }

    @Override
    public String getLoginUrl(Integer entranceType) {
        if (entranceType == null) {
            entranceType = 0;
        }
        if (PassportVo.MASTER.equals(entranceType)) {
            return ssoMasterLogin;
        }else if (SubSysCodeEnum.HALL.getCode().equals(subsysCode)) {
            return hallLogout;
        }
        return ssoNormal;
    }

    /**
     * 增加登录失败次数
     *
     * @param vo
     * @return
     */
    @Override
    public int incLoginErrorTimes(SysUserVo vo) {
        log.info("登录请求 -> 更新登录失败次数");
        return ServiceTool.sysUserService().incLoginErrorTimes(vo);
    }

    @Override
    public String getCaptchaSessionKey() {
        return SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_LOGIN.getSuffix();
    }

    @Override
    public String getCaptchaSessionKeyByType(String type) {
        return SessionKey.S_CAPTCHA_PREFIX + type;
    }

    private void fireLoginListener(PassportEvent passportEvent) {
        if (CollectionTool.isNotEmpty(passportListeners)) {
            for (IPassportListener loginListener : passportListeners) {
                try {
                    loginListener.onLoginSuccess(passportEvent);
                } catch (RuntimeException e) {
                    log.error(e, "登录监听事件处理异常!{0}", loginListener.getClass());
                }
            }
        }
    }

    private void fireLoginFailListener(PassportEvent passportEvent) {
        if (CollectionTool.isNotEmpty(passportListeners)) {
            for (IPassportListener loginListener : passportListeners) {
                try {
                    loginListener.onLoginFailure(passportEvent);
                } catch (RuntimeException e) {
                    log.error(e, "登录监听事件处理异常!{0}", loginListener.getClass());
                }
            }
        }
    }

    private void fireLogoutSuccesslListener(PassportEvent passportEvent) {
        if (CollectionTool.isNotEmpty(passportListeners)) {
            for (IPassportListener loginListener : passportListeners) {
                try {
                    loginListener.onLogoutSuccess(passportEvent);
                } catch (RuntimeException e) {
                    log.error(e, "退出监听事件处理异常!{0}", loginListener.getClass());
                }
            }
        }
    }

    public void setPassportListeners(List<IPassportListener> passportListeners) {
        this.passportListeners = passportListeners;
    }
}
