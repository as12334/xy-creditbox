package so.wwb.lotterybox.web.shiro.local.authc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.security.CryptoTool;
import org.soul.model.session.SessionKey;
import org.soul.web.log.audit.AuditLogTool;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.context.LotteryContextParam;
import so.wwb.lotterybox.model.constants.common.CookieKey;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.web.session.SessionUserListener;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by Fei on 2018-02-21
 */
public class HandleLogin extends FormAuthenticationFilter {
    private static final Log LOG = LogFactory.getLog(HandleLogin.class);

    protected boolean handleLogin(SysUserExtend userExtend, HttpServletRequest request, HttpServletResponse response) {
        try {
            Subject subject = SecurityUtils.getSubject();

            LotteryContextParam context = context();
            initContextParam(userExtend, request, context);
            initSession(userExtend, subject, request, context);
            initPush(userExtend, response, context);

            // shiro token
            LocalToken token = initToken(request, userExtend, context);
            subject.login(token);

            SessionUserListener.getInstance().addOnLineLoginUser(subject.getSession(false));
            return true;
        } catch (AuthenticationException ae) {
            LOG.error(ae, "处理登录异常");
        }
        return false;
    }

    /** 初始化上下文 */
    protected void initContextParam(SysUserExtend userExtend, HttpServletRequest request, LotteryContextParam context) {
        context.setOperator(AuditLogTool.getOperator(request, userExtend));
        context.setUserId(userExtend.getId());
        context.setUserOwnerId(userExtend.getOwnerId());
        context.setUserType(userExtend.getUserType());
        context.setSubsysCode(userExtend.getSubsysCode());
        context.setSysUser(userExtend);
        // TODO user mode
//        context.setUserMode(EnumTool.enumOf(ModeEnum.class, userExtend.getMode()));
    }

    /** 初始化Session */
    protected void initSession(SysUserExtend userExtend, Subject subject, HttpServletRequest request, LotteryContextParam context) {
        Session session = newSession(subject);
        session.setAttribute(SessionKey.S_USER, userExtend);
        session.setAttribute(SessionKey.S_LOGIN_TIME, new Date());
        session.setAttribute(SessionKey.S_USER_ID, userExtend.getId());
        session.setAttribute(SessionKey.S_SITE_ID, context.getSiteId());
        session.setAttribute(SessionKey.S_SITE_USER_ID, context.getSiteUserId());
        session.setAttribute(SessionKey.S_SITE_PARENT_ID, context.getSiteParentId());
    }

    protected Session newSession(Subject subject) {
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

    /** 初始化消息推送 */
    protected void initPush(SysUserExtend userExtend, HttpServletResponse response, LotteryContextParam context) {
        String sessionKey = context.getSiteId().toString() + "_" + userExtend.getId().toString();
        String securityKey = userExtend.getUsername();
        String userId = CryptoTool.encryptDES3(sessionKey, securityKey);
        Cookie cookie = new Cookie(CookieKey.STR_SESSION_KEY, userId);
        cookie.setPath("/manager");
        Cookie cookie2 = new Cookie(CookieKey.STR_SECURITY_KEY, securityKey);
        cookie2.setPath("/manager");
        response.addCookie(cookie);
        response.addCookie(cookie2);
    }

    protected LocalToken initToken(HttpServletRequest request, SysUserExtend userExtend, LotteryContextParam context) {
        String username = userExtend.getUsername();
        String password = userExtend.getPassword();
        LocalToken token = new LocalToken();

        token.setId(userExtend.getId());
        token.setUsername(username);
        token.setPassword(password == null ? null : password.toCharArray());
        token.setRememberMe(false);
        token.setUserType(userExtend.getUserType());
        token.setHost(request.getRemoteHost());
        token.setSiteId(context.getSiteId());
        return token;
    }

    protected LotteryContextParam context() {
        return LotteryCommonContext.get();
    }

}
