package so.wwb.lotterybox.web.shiro.local.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.bean.Pair;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.SystemTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.security.CryptoTool;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support._Module;
import org.soul.iservice.passport.exception.AccountDisabledException;
import org.soul.iservice.passport.exception.AccountInActiveException;
import org.soul.iservice.passport.exception.AccountPasswordException;
import org.soul.model.gameapi.param.User;
import org.soul.model.passport.vo.PassportVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.web.init.BaseCtxLoaderListener;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.shiro.common.autho.AuthorizationRefresher;
import org.soul.web.shiro.local.PassportResult;
import org.soul.web.support.BaseWebConf;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.common.utility.security.AuthTool;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.context.LotteryContextParam;
import so.wwb.lotterybox.model.constants.common.CookieKey;
import so.wwb.lotterybox.model.constants.common.MessageI18nConst;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;
import so.wwb.lotterybox.model.exception.TokenException;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.lotterybox.utility.DesTool;
import so.wwb.lotterybox.web.passport.PassportConst;
import so.wwb.lotterybox.web.passport.captcha.CaptchaUrlEnum;
import so.wwb.lotterybox.web.passport.captcha.GoogleAuthenticator;
//import so.wwb.lotterybox.web.session.SessionUserListener;
import so.wwb.lotterybox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.lotterybox.web.shiro.local.authc.LocalToken;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

public class LocalLoginFilter extends FormAuthenticationFilter {
    public static final String AUTHENTICATION_PARAM = "authentication";
    private Log LOG = LogFactory.getLog(LocalLoginFilter.class);
    private String captchaParam = "captcha";
    private BaseWebConf baseWebConf;
    private IPassportDelegate passportDelegate;
    private AuthorizationRefresher authorizationRefresher;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return false;
        }

        if (isLoginRequest(servletRequest, servletResponse)) {
            return !isLoginSubmission(servletRequest, servletResponse);
        }
        return true;
    }

    @Override
    public boolean executeLogin(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        AuthenticationToken token = createToken(request, response);
        try {
            PassportResult passportResult = isValidToken(request, (LocalToken) token);
            if (!passportResult.getSuccess()) {
                doDispatcher(request, response, passportResult);
                return false;
            }
            Subject subject = SecurityUtils.getSubject();
            doLogin((LocalToken) token, request, response, subject);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    /**
     * 设置请求服务对象参数
     *
     * @param localToken
     * @return
     */
    protected PassportVo generatePassportVo(LocalToken localToken) {
        return PassportVo.loginParamVo(localToken.getUsername(), String.valueOf(localToken.getPassword()), localToken._getEntrance());
    }

    private void doLogin(LocalToken token, ServletRequest servletRequest, ServletResponse servletResponse, Subject subject) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        PassportVo passportVo = generatePassportVo(token);
        try {
            try {
//                if (DomainTypeEnum.HALL == contextParam().getDomainTypeEnum()) {
//                    passportVo._setDataSourceId(contextParam().getSiteId());
//                }
                //如果用户名不是玩家就去主数据库找
                if(contextParam().getUserType() != UserTypeEnum.PLAYER.getCode()){
                    passportVo._setDataSourceId(0);
                }
                passportVo.getSearch().setSiteId(contextParam().getSiteId());
                CommonContext.get().setEntrance(token._getEntrance());
                passportVo = ServiceTool.passportService().login(passportVo);
            } finally {
                CommonContext.get().setEntrance(null);
            }
            if (passportVo.getResult() == null) {
                throw new FailedLoginException("Password does not match value on record.");
            }
        } catch (AccountNotFoundException e) {
            LOG.error(e,"AccountNotFoundException:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (AccountPasswordException e) {
            LOG.error(e,"AccountPasswordException:{0}",e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (AccountInActiveException e) {
            LOG.error(e,"AccountInActiveException:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (AccountLockedException e) {
            LOG.error(e,"AccountLockedException:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (AccountDisabledException e) {
            LOG.error(e,"AccountDisabledException:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (TokenException e) {
            LOG.error(e,"TokenException:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        } catch (Exception e) {
            LOG.error(e,"Exception:{0}", e.getMessage());
            token.setAuthenticationException(new AuthenticationException(e));
        }

        if (token.getAuthenticationException() == null) {
            SysUser sysUser = passportVo.getResult();

            // 不同代理登录不同代理域名
            if (handleAgent(sysUser)) {
                String message = MessageFormat.format("用户名:[{0}]不存在!", passportVo.getSearch().getUsername());
                token.setAuthenticationException(new AuthenticationException(new AccountNotFoundException(message)));
                LOG.error("用户登录失败:{0}", token.getUsername());
                return;
            }

            LotteryContextParam contextParam = contextParam();
            contextParam.setOperator(AuditLogTool.getOperator(request, sysUser));
            contextParam.setUserId(sysUser.getId());
            contextParam.setUserOwnerId(sysUser.getOwnerId());
            contextParam.setUserType(sysUser.getUserType());
            contextParam.setSubsysCode(sysUser.getSubsysCode());
            contextParam.setSysUser(sysUser);
            // TODO user
//            if (sysUser instanceof SysUserExtend) {
//                ModeEnum modeEum = EnumTool.enumOf(ModeEnum.class, ((SysUserExtend) sysUser).getMode());
//                contextParam.setUserMode(modeEum);
//            }

            BaseWebConf baseWebConf = (BaseWebConf) SpringTool.getBean("baseWebConf");
            baseWebConf.setSubsysCode(sysUser.getSubsysCode());

            Session session = newSession(subject);
            session.setAttribute(SessionKey.S_USER, sysUser);
            session.setAttribute(SessionKey.S_LOGIN_TIME, new Date());
            session.setAttribute(SessionKey.S_USER_ID, sysUser.getId());
            session.setAttribute(SessionKey.S_ENTRANCE, String.valueOf(token._getEntrance()));
            session.setAttribute(SessionKey.S_SITE_ID, contextParam.getSiteId());
            session.setAttribute(SessionKey.S_SITE_USER_ID, contextParam.getSiteUserId());
            session.setAttribute(SessionKey.S_SITE_PARENT_ID, contextParam.getSiteParentId());
            //如果Session中的IP信息为空时，填充上下文的IP信息到Session中，以免多次读取数据库
            if(session.getAttribute(SessionKey.S_IP_DB)==null) {
                session.setAttribute(SessionKey.S_IP_DB, SessionManagerBase.getIpDb());
            }
            token.setSiteId(sysUser.getSiteId());
            token.setId(sysUser.getId());
            token.setUserType(sysUser.getUserType());

            //sessionKey  [site_Id_userId]的加密形式
            //securityKey 保存用户名

            String sessionKey = contextParam.getSiteId().toString() + "_" + sysUser.getId().toString();
            String securityKey = sysUser.getUsername();
            String userId = CryptoTool.encryptDES3(sessionKey, securityKey);
            Cookie cookie = new Cookie(CookieKey.STR_SESSION_KEY, userId);
            cookie.setPath("/manager");
            Cookie cookie2 = new Cookie(CookieKey.STR_SECURITY_KEY, securityKey);
            cookie2.setPath("/manager");
            response.addCookie(cookie);
            response.addCookie(cookie2);

            //更改玩家上线状态
//            updateOnlineStatus(sysUser, subject);

            List<String> ids = new ArrayList<>();
            ids.add(token.getPrincipal().toString());
            authorizationRefresher.refesh(ids);
            //TODO dick添加   || DomainTypeEnum.COMPANY.== contextParam().getDomainTypeEnum()
//            if (SubSysCodeEnum.BOSS == contextParam().getDomainTypeEnum() || DomainTypeEnum.COMPANY== contextParam().getDomainTypeEnum()) {
                Map<String, Pair<String, Boolean>> urlPermission = fetchUrlPermission(sysUser);
                session.setAttribute(SessionKey.S_USER_PERMISSIONS, urlPermission);
//            }

        } else {
            LOG.error("user login failed:{0}", token.getUsername());
        }
    }

//    /**
//     * 更改玩家上线状态
//     */
//    private void updateOnlineStatus(SysUser sysUser, Subject subject) {
//        if(UserTypeEnum.PLAYER.getCode().equals(sysUser.getUserType())) {
//            SessionUserListener.getInstance().addOnLineLoginUser(subject.getSession(false));
//        }
//    }

    /**
     * 代理区分域名登录
     */
    private boolean handleAgent(SysUser sysUser) {
        if (SubSysCodeEnum.DISTRIBUTOR.getCode().equalsIgnoreCase(contextParam().getDomainSubsysCode())||SubSysCodeEnum.DISTRIBUTOR.getCode().equalsIgnoreCase(contextParam().getDomainSubsysCode())) {
            UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, sysUser.getUserType());
            switch (userTypeEnum) {
                case DISTRIBUTOR:
                    if (contextParam().getDomainUserId().equals(sysUser.getId()) || contextParam().getDomainUserId().equals(sysUser.getOwnerId()))
                        return false;
                    break;
                case DISTRIBUTOR_SUB:
                    SysUserExtendVo extendVo = new SysUserExtendVo();
                    extendVo.getSearch().setId(sysUser.getOwnerId());
                    SysUserExtend ownerUser = ServiceTool.sysUserExtendService().get(extendVo).getResult();
                    if (ownerUser != null && contextParam().getDomainUserId().equals(ownerUser.getOwnerId()))
                        return false;
                    break;
                default:
                    break;
            }
            return true;
        }
        return false;
    }

    private Session newSession(Subject subject) {
        Session session = subject.getSession(false);
        Map<Object, Object> attributes = new HashMap<>();
        if (session != null) {
            for (Object key : session.getAttributeKeys()) {
                attributes.put(key, session.getAttribute(key));
            }
            session.stop();
        }
        session = subject.getSession(true);
        for (Object key : attributes.keySet()) {
            session.setAttribute(key, attributes.get(key));
        }
        return session;
    }

    /**
     * 取得入口ID
     */
    protected Integer getEntranceType(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        return passportDelegate.getEntranceType(contextPath, uri);
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Integer entranceId = getEntranceType(request);
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptch(request);
        LocalToken token = new LocalToken();
        token.setUsername(username);
        token.setPassword(password == null ? null : AuthTool.md5SysUserPassword(password, username).toCharArray());
        token.setCaptcha(captcha);
        token.setRememberMe(isRememberMe(request));
        token.setHost(getHost(request));
        token._setEntrance(entranceId);
        token.setSiteId(CommonContext.get().getSiteId());
        return token;
    }

    private Map<String, Pair<String, Boolean>> fetchUrlPermission(SysUser sysUser) {
        PassportVo vo = new PassportVo();
        vo.getSearch().setSubsysCode(sysUser.getSubsysCode());
        vo.getSearch().setSiteId(sysUser.getSiteId());
        if (contextParam().getVirtualSiteId() != null)
            vo.getSearch().setSiteId(contextParam().getVirtualSiteId());
        vo.getSearch().setUsername(sysUser.getUsername());
        vo.getSearch().setUserType(sysUser.getUserType());
        return ServiceTool.passportService().findPermissionMapping(vo);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest servletRequest, ServletResponse servletResponse) {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            closeCaptcha();
            String successUrlOld = getSuccessUrl();

            passportDelegate.onLoginSuccessDelegate(request);
            if (ServletTool.isAjaxRequest(request)) {
                String json = JsonTool.toJson(PassportResult.SUCCESS);
                response.setContentLength(json.length());
                response.getWriter().write(json);
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                Cookie cookie = new Cookie("_Login", "1");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                passportDelegate.redirectTo(request, response, successUrlOld);
            }
        } catch (Exception e) {
            LOG.error(e, "登录成功,但后续出现异常!");
        }
        //TODO jeremy 2018年07月01日17:11:40  登录成功 清空登录结果信息
        SessionManagerCommon.setAttribute(SessionKey.SK_Passport_Rs, new PassportResult());
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        LocalToken localToken = (LocalToken) token;
        //TODO jeremy 2018年07月01日17:43:25 登录页暂时取消图形验证码的显示
//        boolean isOpenCaptcha = isOpenCaptcha(request);
        boolean isOpenCaptcha = false;
        Integer loginErrorTimes = 0;
        String message = "";
        PassportResult passportResult = new PassportResult();
        passportResult.setIsOpenCaptcha(isOpenCaptcha);
        Throwable e = ae.getCause();
        if (e != null && e instanceof LoginException) {
            //判断各种错误原因进行提示
            if (e instanceof AccountLockedException) {
                AccountLockedException exception = (AccountLockedException) e;
                //TODO jeremy 2018年07月01日16:39:56 不管系统冻结还是 手动冻结， 冻结原因统一提示： 账号被冻结 ， 实际冻结原因（freezeContent）仅提供给管理人员查看
                message += LocaleTool.tranMessage(_Module.Passport, Const.I18N_AUTHENTICATION_FAILURE_PREFIX + exception.getClass().getSimpleName());
            } else if (e instanceof TokenException) {
                TokenException exception = (TokenException) e;
                message = exception.getMessage();//authenticationFailure.AccountDisabledException
            } else {
                String code = Const.I18N_AUTHENTICATION_FAILURE_PREFIX + e.getClass().getSimpleName();
                message = LocaleTool.tranMessage(_Module.Passport, code);
                if (e instanceof AccountPasswordException) {
                    AccountPasswordException exception = ((AccountPasswordException) e);
                    SysUserVo sysUserVo = new SysUserVo();
                    if (PassportVo.MASTER.equals(localToken._getEntrance())) {//站长账号保存在运营商库
                        sysUserVo._setDataSourceId(CommonContext.get().getSiteParentId());
                    }
                    sysUserVo.getSearch().setId(exception.getUserId());
                    passportDelegate.incLoginErrorTimes(sysUserVo);
                    loginErrorTimes = exception.getLoginErrorTimes() + 1;
                    int remainTime = Const.AUTHENTICATION_FAILURE_FREEZE_LIMIT - loginErrorTimes;
                    if (remainTime > 0 && remainTime < 4) {
                        message += LocaleTool.tranMessage(_Module.Passport, MessageI18nConst.AUTHENTICATION_FAILURE_REMAIN_TIMES, remainTime);
                    } else if (remainTime == 0) {
                        message = LocaleTool.tranMessage(_Module.Passport, MessageI18nConst.AUTHENTICATION_FAILURE_ACCOUNT_LOCK_MAX_TIMES, Const.AUTHENTICATION_FAILURE_FREEZE_LIMIT, PassportConst.AUTO_FREEZE_HOURS);
                    }
                    localToken.setId(exception.getUserId());
                }
            }
        }

        passportDelegate.onLoginFailureDelegate(request, response, localToken.getId(), localToken.getUsername(), loginErrorTimes);
        passportResult.setMessage(message);
        //账号错误提示信息
        SessionManagerCommon.setAttribute(SessionKey.SK_Passport_Rs,passportResult);
        doDispatcher(request, response, passportResult);
        return false;
    }

    private void doDispatcher(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) {
        try {
            if (ServletTool.isAjaxRequest(request)) {
                ajaxResponse(request, response, passportResult);
            } else {
                normalResponse(request, response, passportResult);
            }
        } catch (Exception exp) {
            LOG.error(exp);
        }
    }

    /**
     * 异常请求错误回复
     */
    protected void ajaxResponse(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) throws IOException {
        passportResult.setUsername(null); //ajax不回传用户名
        passportResult.setPassword(null); //ajax不回传密码
        String json = JsonTool.toJson(passportResult);
        response.getWriter().print(json);
        response.getWriter().flush();
    }

    /**
     * 正常请求错误回复
     */
    protected void normalResponse(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) throws IOException {
        String scheme = request.getHeader("X-Forwarded-Scheme");
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
            port = "90";
        }
        String directPage = MessageFormat.format("{0}://{1}:{2}{3}", scheme, request.getServerName(), port, request.getRequestURI());
        LOG.info("重定向:{0}", directPage);
        response.sendRedirect(directPage);
    }

    protected PassportResult isValidToken(HttpServletRequest request, LocalToken token) {
        PassportResult passportResult = new PassportResult();
        passportResult.setSuccess(true);
        passportResult.setUsername(getUsername(request));
        passportResult.setPassword(getPassword(request));
        validRequired(passportResult, getUsernameParam(), token.getUsername());
        validRequired(passportResult, getPasswordParam(), token.getPassword() == null ? null : new String(token.getPassword()));
        if (passportResult.getIsOpenCaptcha()) {
            String type = getLoginOccasion(request);
            boolean rs = validRequired(passportResult, getCaptchaParam(), token.getCaptcha());
            if (rs) {
                String captchaSessionKey = passportDelegate.getCaptchaSessionKeyByType(type);
                String captchaSessionVal = (String) SessionManagerCommon.getAttribute(captchaSessionKey);
                validCaptcha(request, passportResult, getCaptchaParam(), getCaptch(request), captchaSessionVal);
            }
        }
        if (isOpenAuthentication()) {
            String authentication = getAuthentication(request);
            String authenticationKey = queryAuthenticationKey(token);
            String key =passportResult.getUsername();
            String wordKey = DesTool.decrypt(authenticationKey,key);
            LOG.info("开启身份验证码模式，开始校验动态验证码!用户输入验证码:{0},该用户的authenticationKey:{1}", authentication, authenticationKey);
            if (StringTool.isNotBlank(authentication) && StringTool.isNotBlank(authenticationKey)) {
                long code = Long.valueOf(authentication);
                long t = System.currentTimeMillis();
                GoogleAuthenticator ga = new GoogleAuthenticator();
                ga.setWindowSize(1); //should give 5 * 30 seconds of grace...
                if (!ga.check_code(wordKey, code, t)) {
                    errorMessage(passportResult);
                }
            } else {
                errorMessage(passportResult);
            }
        }
        return passportResult;
    }

    private void errorMessage(PassportResult passportResult) {
        String message = "身份验证码有误!";//LocaleTool.tranMessage(_Module.Passport, Const.I18N_AUTHENTICATION_FAILURE_PREFIX + AUTHENTICATION_PARAM);
        LOG.info(message);
        passportResult.setSuccess(false);
        passportResult.getPropMessages().put(AUTHENTICATION_PARAM, message);
    }

    /**
     * @param token
     * @return
     */
    public String queryAuthenticationKey(LocalToken token) {
        SysUserExtendVo vo = new SysUserExtendVo();
        //TODO dick tony说这个获取subsysCode是配置，我们需要从token取没有这字段，所以取消
        /*vo.getSearch().setSubsysCode(baseWebConf.getSubsysCode());*/
        vo.getSearch().setUsername(token.getUsername());
        vo.getSearch().setSiteId(token.getSiteId());
        if (token.getSiteId() < 0) {
            vo._setDataSourceId(Const.BASE_DATASOURCE_ID);
        }
        SysUserExtend sysUser = ServiceTool.sysUserExtendService().findByUsername(vo);
        if (sysUser == null){
            LOG.info("登录获取身份验证码，但无法查询到该用户，用户名：{0}，站点：{1}", token.getUsername(), token.getSiteId());
        }
        return sysUser == null ? "" : sysUser.getAuthenticationKey();
    }

    /**
     * 获取登录验证码使用场合的类型：前端弹窗/前端首页/前端导航/默认登陆（管理端）
     */
    private String getLoginOccasion(HttpServletRequest request) {
        if (StringTool.isBlank(request.getParameter("type"))) {
            //前端未指定具体的验证码类型使用默认的"code"
            return CaptchaUrlEnum.CODE_LOGIN.getSuffix();
        }
        String type;
        switch (request.getParameter("type")) {
            case "dialog":
                type = CaptchaUrlEnum.CODE_PLAYER_LOGIN_DIALOG.getSuffix();
                break;
            case "index":
                type = CaptchaUrlEnum.CODE_PLAYER_LOGIN_INDEX.getSuffix();
                break;
            case "top":
                type = CaptchaUrlEnum.CODE_PLAYER_LOGIN_TOP.getSuffix();
                break;
            default:
                return CaptchaUrlEnum.CODE_LOGIN.getSuffix();

        }
        return type;

    }

    private boolean validRequired(PassportResult passportResult, String propName, String propVal) {
        if (StringTool.isBlank(propVal)) {
            String prop = propName;
            String code = Const.I18N_AUTHENTICATION_FAILURE_REQUIRED + prop;
            String message = LocaleTool.tranMessage(_Module.Passport, code);
            passportResult.setSuccess(false);
            passportResult.getPropMessages().put(prop, message);
            passportResult.setMessage(message);
            SessionManagerCommon.setAttribute(SessionKey.SK_Passport_Rs, passportResult);
            return false;
        }
        return true;
    }

    /**
     * 是否有效的验证码
     */
    private boolean validCaptcha(HttpServletRequest request, PassportResult passportResult, String propName, String captcha, String captchaSessionVal) {
        if (StringTool.isBlank(captchaSessionVal)) {
            LOG.debug("验证码值为空，请检查是否指定了正确的验证码类型！");
            return false;
        }
        if (StringTool.isNotBlank(captcha) && StringTool.equals(captcha.toUpperCase(), captchaSessionVal.toUpperCase())) {
            return true;
        }
        String prop = propName;
        String code = Const.I18N_AUTHENTICATION_FAILURE_PREFIX + prop;
        String message = LocaleTool.tranMessage(_Module.Passport, code);
        passportResult.setSuccess(false);
        passportResult.getPropMessages().put(prop, message);
        passportResult.setMessage(message);
        SessionManagerCommon.setAttribute(SessionKey.SK_Passport_Rs, passportResult);
        return false;
    }

    /**
     * 是否开启验证码
     */
    private boolean isOpenCaptcha(HttpServletRequest request) {
        if (isOpenAuthentication()) {
            LOG.info("当前系统为:{0},关闭图形验证码，开启身份验证码模式。", baseWebConf.getSubsysCode());
            return false;
        }
        Integer loginErrorTimesInSession = (Integer) SessionManagerCommon.getAttribute(SessionKey.S_LOGIN_ERROR_TIMES);
        if (loginErrorTimesInSession == null) {
            loginErrorTimesInSession = 0;
        }
        loginErrorTimesInSession = loginErrorTimesInSession + 1;
        SessionManagerCommon.setAttribute(SessionKey.S_LOGIN_ERROR_TIMES, loginErrorTimesInSession);

        if (loginErrorTimesInSession >= Const.AUTHENTICATION_FAILURE_CAPTCHA_SHOWN_LIMIT) {
            SessionManagerCommon.setAttribute(SessionKey.S_IS_CAPTCHA_CODE, Boolean.TRUE);
            return true;
        }
        return false;
    }

    /**
     * 是否开启身份验证模式
     */
    protected boolean isOpenAuthentication() {
        //游戏中心暂不需要动态码验证.
        return false;
    }

    private void closeCaptcha() {
        SessionManagerCommon.setAttribute(SessionKey.S_IS_CAPTCHA_CODE, null);
        SessionManagerCommon.setAttribute(passportDelegate.getCaptchaSessionKey(), null);
    }

    public void setPassportDelegate(IPassportDelegate IPassportDelegate) {
        this.passportDelegate = IPassportDelegate;
    }

    protected String getCaptch(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    protected String getAuthentication(ServletRequest request) {
        return WebUtils.getCleanParam(request, AUTHENTICATION_PARAM);
    }

    public String getCaptchaParam() {
        return captchaParam;
    }

    /**
     * Sets the request parameter name to look for when acquiring the username.  Unless overridden by calling this
     * method, the default is <code>username</code>.
     *
     * @param captchaParam the name of the request param to check for acquiring the username.
     */
    public void setCaptchaParam(String captchaParam) {
        this.captchaParam = captchaParam;
    }

    public void setBaseWebConf(BaseWebConf baseWebConf) {
        this.baseWebConf = baseWebConf;
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletResponse req = (HttpServletResponse) response;
        String scheme = req.getHeader("X-Forwarded-Scheme");
        String port = req.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        String loginUrl = getLoginUrl();
        resp.sendRedirect(MessageFormat.format("{0}://{1}:{2}{3}", scheme, request.getServerName(), port,
                BaseCtxLoaderListener.ContextPath, loginUrl));
    }

    public AuthorizationRefresher getAuthorizationRefresher() {
        return authorizationRefresher;
    }

    public void setAuthorizationRefresher(AuthorizationRefresher authorizationRefresher) {
        this.authorizationRefresher = authorizationRefresher;
    }

    private LotteryContextParam contextParam() {
        return LotteryCommonContext.get();
    }
}


