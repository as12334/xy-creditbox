package so.wwb.creditbox.web.shiro.local.filter;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.support._Module;
import org.soul.iservice.passport.exception.AccountPasswordException;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.web.shiro.common.autho.AuthorizationRefresher;
import org.soul.web.shiro.local.PassportResult;
import org.soul.web.support.BaseWebConf;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.model.bean.HttpCodeEnum;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.company.user.vo.CzUsersChildVo;
import so.wwb.creditbox.model.constants.common.MessageI18nConst;
import so.wwb.creditbox.model.enums.base.PasswordIsChangeEnum;
import so.wwb.creditbox.model.exception.TokenException;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.utility.TerminalTool;
import so.wwb.creditbox.web.passport.PassportConst;
import so.wwb.creditbox.web.session.SessionUserListener;
import so.wwb.creditbox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.creditbox.web.shiro.local.authc.HandleLogin;
import so.wwb.creditbox.web.shiro.local.authc.LocalToken;
import so.wwb.creditbox.web.tools.FormTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.token.TokenHandler;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端登入请求.
 * Create by fei on 2017-12-25
 */
public class HallLoginFilter extends HandleLogin {

    private static final Log LOG = LogFactory.getLog(HallLoginFilter.class);
    private static final String CAPTCHA_PARAM = "captcha";
    protected BaseWebConf baseWebConf;
    protected IPassportDelegate passportDelegate;
    private AuthorizationRefresher authorizationRefresher;
    private static final Integer MAX_ERROR_TIMES = 5;   // 密码错误次数

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() &&
                (!isLoginRequest(servletRequest, servletResponse) || !isLoginSubmission(servletRequest, servletResponse));
    }

    @Override
    public boolean executeLogin(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        Map<Object, Object> dictionary = new HashedMap();
        dictionary.put("type", "user_login");

        WebJson result = new WebJson();
        result.setSuccess(HttpCodeEnum.SUCCESS.getCode());




        // 校验账号
        String username = WebUtils.getCleanParam(request, SysUser.PROP_USERNAME);
        String password = getPassword(request);
        LOG.info("登录请求 -> =============================== {0}开始登录 ===============================", username);
        LOG.info("登录请求 -> 登录平台：==> {0}", TerminalTool.getTerminal(request));
        //用戶名或密碼沒填寫
        if (StringTool.isBlank(username) || StringTool.isBlank(password))
        {
            result.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
            result.setTipinfo("");
            result.getData().put("is_display_code","1");
            SessionManagerCommon.setLotterySessionImgCodeDisplay(1);
        }
        if(result.getIsSuccess()){
            //查詢用戶   先查詢主庫
            getUserExtend(username);
        }



        if (isSuccess(result)) {
            if (isSuccess(result)) {
                result = doLogin(request, response, result);
            }
        }
        ajaxResponse(result, response);
        return false;
    }

    boolean isSuccess(WebJson webJson) {
        return HttpCodeEnum.SUCCESS.getCode() == webJson.getSuccess();
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String username = getUsername(request);
        String password = FormTool.getPassword(request);
        LocalToken token = new LocalToken();
        token.setUsername(username);
        token.setPassword(password == null ? null : AuthTool.md5SysUserPassword(password, username).toCharArray());
        token.setRememberMe(isRememberMe(request));
        token.setHost(getHost(request));
        token.setSiteId(CommonContext.get().getSiteId());
        return token;
    }

    private WebJson doLogin(HttpServletRequest request, HttpServletResponse response, WebJson webJson) {
        String username = getUsername(request);
        String password = FormTool.getPassword(request);
        LOG.info("登录请求 -> 开始登录：{0}", username);
        SysUserExtend userExtend = SessionManagerCommon.getSysUserExtend();
        CzUsersChild userChild = SessionManagerCommon.getSysUserExtend().getSessionUserChild();

        if (userExtend == null) {
            LOG.info("登录请求 -> 玩家账号不存在: {0}", username);
            webJson.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
            webJson.getData().put("is_display_code","1");
            webJson.setTipinfo("");
            return webJson;
        }

        LOG.info("登录请求 -> 玩家信息存在：{0}", username);

        //先驗證子賬號
        if(userChild != null){
            //查詢用戶狀態
            if(webJson.getIsSuccess()){
                webJson = checkChildStatus(userChild, webJson);
            }
            // 校验密码
            if(webJson.getIsSuccess()){
                webJson = checkChildPassword(userChild,webJson, password);
            }
            //是否需要修改密碼
            if(webJson.getIsSuccess()) {
                webJson = checkChangedPassword(webJson,userChild.getIsChanged());
            }
        }
        else {
            //查詢用戶狀態
            if(webJson.getIsSuccess()){
                webJson = checkStatus(userExtend, webJson);
            }
            // 校验密码
            if(webJson.getIsSuccess()){
                webJson = checkPassword(userExtend,webJson, password);
            }
            //是否需要修改密碼
            if(webJson.getIsSuccess()) {
                webJson = checkChangedPassword(webJson,userExtend.getIsChanged());
            }
        }



        if (webJson.getIsSuccess()) {
            handleLogin(userExtend, request, response);
            genFcToken(webJson);
        }
        return webJson;
    }

    private WebJson checkPassword(SysUserExtend userExtend, WebJson webJson, String password) {
        //如果登錄的是子賬號
        LOG.info("登录请求 -> 校验密码：{0}-{1}", userExtend.getUsername(), password);
        SysUserExtendVo userExtendVo = new SysUserExtendVo();
        userExtendVo.setProperties(SysUserExtend.PROP_LOGIN_ERROR_TIMES);
        password = AuthTool.md5SysUserPassword(password, userExtend.getUsername());
        if (!password.equals(userExtend.getPassword())) {

            userExtend.setLoginErrorTimes(userExtend.getLoginErrorTimes() + 1);
            webJson.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
            webJson.setTipinfo(String.format("您输入的密码错误，连续错误%d次将冻结账号。(您还可以尝试%d次)",
                    MAX_ERROR_TIMES, MAX_ERROR_TIMES - userExtend.getLoginErrorTimes()));
            if(userExtend.getLoginErrorTimes() >= MAX_ERROR_TIMES){
                //凍結
                userExtend.setStatus(SysUserStatus.LOCKED.getCode());
                webJson.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
                webJson.setTipinfo("由於輸入錯誤次數過多,您已被禁用,請稍後再試!");
                userExtendVo.setProperties(SysUserExtend.PROP_STATUS);
            }

            userExtendVo._setDataSourceId(SessionManagerCommon.getSiteId());
            if(LotteryCommonContext.get().getDomainUserName().equals(userExtend.getUsername())){
                //總監賬號要去管理庫查詢
                userExtendVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
            }

        }
        else {
            userExtend.setLoginErrorTimes(0);
        }
        userExtendVo.setResult(userExtend);
        ServiceTool.sysUserExtendService().update(userExtendVo);
        return webJson;
    }

    private WebJson checkChangedPassword(WebJson webJson,String isChanged) {
        if(StringTool.isBlank(isChanged)){
            webJson.setSuccess(HttpCodeEnum.PSD_CHANGE.getCode());
            webJson.setTipinfo("新密碼首次登錄,需重置密碼!");
//            【首次登錄，重置密碼】
        }
        else if (PasswordIsChangeEnum.FRIST.getCode().equals(isChanged)){
            webJson.setSuccess(HttpCodeEnum.PSD_CHANGE.getCode());
            webJson.setTipinfo("新密碼首次登錄,需重置密碼!");
//            【重置上級修改的密碼】
        }
       //todo 密碼過期後面添加
        return webJson;
    }

    private WebJson checkChildStatus(CzUsersChild userChild, WebJson webJson) {
        if(userChild.getStatus().equals(SysUserStatus.LOCKED.getCode())){
            webJson.setSuccess(400);
            webJson.setTipinfo("您的帳號已被停用,请与管理员联系!");
        }
        else {
            SysUserExtendVo vo = new SysUserExtendVo();
            vo._setDataSourceId(contextParam().getSiteId());
            vo.setResult(SessionManagerCommon.getSysUserExtend());
            webJson = ServiceTool.sysUserExtendService().checkSuperStatus(vo, webJson);
        }
        return webJson;
    }




    @Override
    protected boolean handleLogin(SysUserExtend userExtend, HttpServletRequest request, HttpServletResponse response) {
        try {
            LOG.info("登录请求 -> 处理登录", userExtend.getUsername());
            Subject subject = SecurityUtils.getSubject();

            LotteryContextParam context = context();
            initContextParam(userExtend, request, context);
            initSession(userExtend, subject, request, context);
            initPush(userExtend, response, context);

            // shiro token
            LocalToken token = initToken(request, userExtend, context);
            subject.login(token);
            onLoginSuccess(token, subject, request, response);
            return true;
        } catch (AuthenticationException ae) {
            LOG.error(ae, "处理登录异常");
            return onLoginFailure(createToken(request, response), ae, request, response);
        }
    }

    /**
     * 查询玩家信息
     */
    SysUserExtend getUserExtend(String username) {
        SysUserExtendVo extendVo = new SysUserExtendVo();
        extendVo.getSearch().setUsername(username);
        extendVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
        //先查詢主庫，主庫沒有再查詢站點庫
        SysUserExtend sysUserExtend = ServiceTool.sysUserExtendService().findByUsername(extendVo);
        CzUsersChild czUsersChild = null;
        if(sysUserExtend == null){
            extendVo._setDataSourceId(context().getSiteId());
            sysUserExtend = ServiceTool.sysUserExtendService().findByUsername(extendVo);
            if(sysUserExtend == null){
                //到站點庫查詢子賬號
                CzUsersChildVo czUsersChildVo = new CzUsersChildVo();
                czUsersChildVo.getSearch().setUname(username);
                czUsersChild = ServiceTool.czUsersChildService().findByUsername(czUsersChildVo);
                if(czUsersChild != null){
                    //如果子賬號的上級賬號，是域名主賬號，要去管理庫查找上級用戶
                    if(czUsersChild.getParentUname().equals(contextParam().getDomainUserName())){
                        extendVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
                        sysUserExtend = ServiceTool.sysUserExtendService().findByUsername(extendVo);
                    }else {
                        extendVo._setDataSourceId(contextParam().getSiteId());
                        sysUserExtend = ServiceTool.sysUserExtendService().findByUsername(extendVo);
                    }
                }
            }

        }
        sysUserExtend.setSessionUserChild(czUsersChild);
        SessionManagerCommon.setUser(sysUserExtend);
        return null;
    }

    /** 校验密码 */
    private WebJson checkChildPassword(CzUsersChild sessionUserChild, WebJson webJson, String password) {

        //如果登錄的是子賬號
        LOG.info("登录请求 -> 校验密码：{0}-{1}", sessionUserChild.getUname(), password);
        CzUsersChildVo czUsersChildVo = new CzUsersChildVo();
        czUsersChildVo.setProperties(CzUsersChild.PROP_RETRY_TIMES);
        password = AuthTool.md5SysUserPassword(password, sessionUserChild.getUname());

        if (!password.equals(sessionUserChild.getUpsw())) {
            sessionUserChild.setRetryTimes(sessionUserChild.getRetryTimes() + 1);

            webJson.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
            webJson.setTipinfo(String.format("您输入的密码错误，连续错误%d次将冻结账号。(您还可以尝试%d次)",
                    MAX_ERROR_TIMES, MAX_ERROR_TIMES - sessionUserChild.getRetryTimes()));
            if(sessionUserChild.getRetryTimes() >= MAX_ERROR_TIMES){
                //凍結
                sessionUserChild.setStatus(SysUserStatus.LOCKED.getCode());
                webJson.setSuccess(HttpCodeEnum.ERROR_OTHER.getCode());
                webJson.setTipinfo("由於輸入錯誤次數過多,您已被禁用,請稍後再試!");
                czUsersChildVo.setProperties(CzUsersChild.PROP_STATUS);
            }
            czUsersChildVo._setDataSourceId(SessionManagerCommon.getSiteId());
            czUsersChildVo.setResult(sessionUserChild);

            ServiceTool.czUsersChildService().update(czUsersChildVo);
        }
        else {
            czUsersChildVo.getResult().setRetryTimes(0);
        }
        ServiceTool.czUsersChildService().update(czUsersChildVo);
        return webJson;
    }

    /** 生成防重复token */
    private void genFcToken(WebJson webJson) {
        LOG.info("登录请求 -> 生成防重token");
        Map<String, Object> map = new HashMap<>();
        map.put(TokenHandler.TOKEN_VALUE, TokenHandler.generateGUID());
//        webJson.setExtend(map);
    }

    /**
     * 校验账号状态
     */
    private WebJson checkStatus(SysUserExtend userExtend, WebJson webJson) {
        if(userExtend.getStatus().equals(SysUserStatus.LOCKED.getCode())){
            webJson.setSuccess(400);
            webJson.setTipinfo("您的帳號已被停用,请与管理员联系!");
        }
        else {
            SysUserExtendVo vo = new SysUserExtendVo();
            vo._setDataSourceId(contextParam().getSiteId());
            if(LotteryCommonContext.get().getDomainUserName().equals(userExtend.getUsername())){
                //總監賬號要去管理庫查詢
                vo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
            }
            vo.setResult(userExtend);
            webJson = ServiceTool.sysUserExtendService().checkSuperStatus(vo, webJson);
        }
        return webJson;
    }


    /**
     * 登录失败后是否开启验证码
     */
    private boolean isOpenCaptcha() {
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
     * 异常请求错误回复
     */
    private void ajaxResponse(WebJson webJson, HttpServletResponse response) throws IOException {
        response.getWriter().print(JsonTool.toJson(webJson));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest servletRequest, ServletResponse servletResponse) {
        try {
            LOG.info("登录请求 -> 登录成功操作");
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            SessionUserListener.getInstance().addOnLineLoginUser(subject.getSession(false));

            passportDelegate.onLoginSuccessDelegate(request);
            if (!ServletTool.isAjaxRequest(request)) {
                Cookie cookie = new Cookie("_Login", "1");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
            }
            LOG.info("登录请求 -> 登录成功！");
        } catch (Exception e) {
            LOG.error(e, "登录成功,但后续出现异常!");
        }
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        LocalToken localToken = (LocalToken) token;
        Integer loginErrorTimes = 0;
        String message = "";
        PassportResult passportResult = new PassportResult();
        Throwable e = ae.getCause();
        if (e != null && e instanceof LoginException) {
            if (e instanceof TokenException) {
                TokenException exception = (TokenException) e;
                message = exception.getMessage();
            } else {
                String code = Const.I18N_AUTHENTICATION_FAILURE_PREFIX + e.getClass().getSimpleName();
                message = LocaleTool.tranMessage(_Module.Passport, code);
                if (e instanceof AccountPasswordException) {
                    AccountPasswordException exception = ((AccountPasswordException) e);
                    SysUserVo sysUserVo = new SysUserVo();
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
        doDispatcher(request, response, passportResult);
        return false;
    }

    private void doDispatcher(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) {
        try {
            if (ServletTool.isAjaxRequest(request)) {
                passportResult.setUsername(null); //ajax不回传用户名
                passportResult.setPassword(null); //ajax不回传密码
                WebJson webJson = new WebJson();
                webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
                response.getWriter().print(webJson);
                response.getWriter().flush();
            } else {
                normalResponse(request, response, passportResult);
            }
        } catch (Exception exp) {
            LOG.error(exp);
        }
    }

    /**
     * 正常请求错误回复
     */
    private void normalResponse(HttpServletRequest request, HttpServletResponse response, PassportResult passportResult) throws IOException {
        String scheme = request.getHeader("X-Forwarded-Scheme");
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        String directPage = MessageFormat.format("{0}://{1}:{2}{3}", scheme, request.getServerName(), port, request.getRequestURI());
        LOG.info("重定向:{0}", directPage);
        response.sendRedirect(directPage);
    }


    protected LotteryContextParam contextParam() {
        return LotteryCommonContext.get();
    }

    public IPassportDelegate getPassportDelegate() {
        return passportDelegate;
    }
    public void setPassportDelegate(IPassportDelegate passportDelegate) {
        this.passportDelegate = passportDelegate;
    }


    public void setBaseWebConf(BaseWebConf baseWebConf) {
        this.baseWebConf = baseWebConf;
    }

    public AuthorizationRefresher getAuthorizationRefresher() {
        return authorizationRefresher;
    }

    public void setAuthorizationRefresher(AuthorizationRefresher authorizationRefresher) {
        this.authorizationRefresher = authorizationRefresher;
    }

}
