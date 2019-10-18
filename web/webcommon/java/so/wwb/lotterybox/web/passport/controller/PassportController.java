package so.wwb.lotterybox.web.passport.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.SupportTerminal;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.session.SessionKey;
import org.soul.web.shiro.local.PassportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.lotterybox.context.LotteryCommonContext;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.web.session.SessionUserListener;
import so.wwb.lotterybox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;

@Controller
@RequestMapping("/**/passport")
public class PassportController {
    private static final Log LOG = LogFactory.getLog(PassportController.class);
    @Value("${subsys.code}")
    private String subsysCode;

    private static final String LOGIN_URI = "/passport/login";
    private static final String PLAY_LOGIN_URI = "/commonPage/login";
    private static final String LOGOUT_URI = "/passport/logout";
    private static final String LOGIN_USER_LOCK = "/passport/UserLock";

    @Autowired(required = false)
    private IPassportDelegate passportDelegate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) {

        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:" + SessionManagerCommon.getRedirectUrl(request, "/");
        }

        if (!request.getContextPath().equals("") && !request.getContextPath().equals("/") && SubSysCodeEnum.HALL.getCode().equals(subsysCode)) {
            return "redirect:" + SessionManagerCommon.getRedirectUrl(request, "/login/commonLogin.html");
        }
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        Integer entranceId = passportDelegate.getEntranceType(contextPath, uri);
        if (entranceId == null) {
            entranceId = 0;
        }
        String loginUrl = passportDelegate.getLoginUrl(entranceId);
        request.setAttribute("loginUrl", loginUrl);
        request.setAttribute("subsysCode", subsysCode);
        VSysSiteDomain domain = SessionManagerCommon.getSiteDomain(request);
        request.setAttribute("siteCode", domain.getSiteCode());

//        if (DomainTypeEnum.HALL == LotteryCommonContext.get().getDomainTypeEnum()) {
//            if (SupportTerminal.PC.getCode().equals(LotteryCommonContext.get().getTerminal()))
//                return "theme/default" + PLAY_LOGIN_URI;
//            else
//                return "theme/mobile" + PLAY_LOGIN_URI;
//        }
        return LOGIN_URI;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_post() {
        return "/index";
    }

    @RequestMapping(value = "/apiLogin", method = RequestMethod.POST)
    public String apiLogin() {
        return "/index";
    }

    @RequestMapping(value = "/displayCaptcha")
    @ResponseBody
    public void displayCaptcha() {
        SessionManagerCommon.setAttribute(SessionKey.S_IS_CAPTCHA_CODE, Boolean.TRUE);
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handleLogout(request, response);

        String redirectUrl = getRedirectUrl(request);
        if (ServletTool.isAjaxRequest(request)) {
            String json = JsonTool.toJson(PassportResult.SUCCESS);
            response.getWriter().print(json);
            response.getWriter().flush();
        } else {
            response.sendRedirect(redirectUrl);
        }
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        Integer entranceId = passportDelegate.getEntranceType(contextPath, uri);
        SessionManagerCommon.setAttribute(SessionKey.S_ENTRANCE, String.valueOf(entranceId));
        try {
            passportDelegate.onLogoutDelegate(request, response);

            //region add by wilson .L --remove login user session
            if (UserTypeEnum.PLAYER.getCode().equals(LotteryCommonContext.get().getUserType())) {
                Subject subject = SecurityUtils.getSubject();
                Session session = subject.getSession(false);
                SessionUserListener.getInstance().removeOnLineLoginUser(session);
            }
            //endregion

            SessionManagerCommon.clearSession();
        } catch (SessionException ise) {
            LOG.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
    }

    protected String getRedirectUrl(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getParameter("url");
        if (StringTool.isNotBlank(url)) {
            return url;
        }
        String scheme = request.getHeader("X-Forwarded-Scheme");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        String directPage = MessageFormat.format("{0}://{1}:{2}{3}", scheme,
                request.getServerName(), port, request.getContextPath() + "/");
        LOG.info("directPage11={0}", directPage);
        return directPage;
    }

    @RequestMapping(value = "/showUserLock")
    public String showUserLock() {
        return LOGIN_USER_LOCK;
    }

    @RequestMapping(value = "/callback")
    public String callback() {
        return "passport/callback";
    }
}
