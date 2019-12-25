package so.wwb.creditbox.web.passport.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.soul.commons.data.json.JsonTool;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.model.company.user.po.CzUsersChild;
import so.wwb.creditbox.model.company.user.vo.CzUsersChildVo;
import so.wwb.creditbox.model.constants.common.Const;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.model.enums.base.PasswordIsChangeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.session.SessionUserListener;
import so.wwb.creditbox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.regex.Pattern;

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

//        if (!request.getContextPath().equals("") && !request.getContextPath().equals("/") && SubSysCodeEnum.HALL.getCode().equals(subsysCode)) {
//            return "redirect:" + SessionManagerCommon.getRedirectUrl(request, "/login/commonLogin.html");
//        }
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


    @RequestMapping(value = "/ResetPasswd", method = RequestMethod.GET)
    public String ResetPasswd() {
        if(SessionManagerCommon.getSysUserExtend() == null){
            return "redirect:/passport/login.html";
        }
        return "/passport/ResetPasssword";
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public String updatePwd(@RequestParam("txtoldpwd") String txtoldpwd, @RequestParam("txtnewpwd") String txtnewpwd,@RequestParam("txtnewpwdcf") String txtnewpwdcf, HttpServletResponse response) {

        if(StringTool.isBlank(txtoldpwd) ||StringTool.isBlank(txtnewpwd) ||StringTool.isBlank(txtnewpwdcf)){
            return getAlert("請輸入完整的密碼！");
        }
        if(txtoldpwd.equals(txtnewpwd)){
            return getAlert("新密碼和舊密碼不能相同！");
        }
        if(!txtnewpwd.equals(txtnewpwdcf)){
            return getAlert("新密碼和確認新密碼不一致！");
        }
        boolean matches = Pattern.matches(RegexConst.LOGIN_PWD, txtnewpwd);
        if(!matches){
            return getAlert("密碼要8-20位,且必需包含字母、和数字！");
        }
        SysUserExtend sysUserExtend = SessionManagerCommon.getSysUserExtend();
        CzUsersChild sessionUserChild = sysUserExtend.getSessionUserChild();

        if(sysUserExtend == null){
            //等待時間過期，轉到登錄頁面
            LocationHref("./login.html");
        }
        if (sessionUserChild != null){
            //登錄的是子賬號
            String oldPassword = sessionUserChild.getUpsw();
            txtoldpwd = AuthTool.md5SysUserPassword(txtoldpwd, sessionUserChild.getUname());
            if(!txtoldpwd.equals(oldPassword)){
                return getAlert("您輸入原密碼不正確！");
            }
            else {
//                更新密碼
                sessionUserChild.setUpsw(AuthTool.md5SysUserPassword(txtnewpwd, sessionUserChild.getUname()));
                sessionUserChild.setIsChanged(PasswordIsChangeEnum.NORMAL.getCode());
                sessionUserChild.setLastChangedDate(new Date());
                CzUsersChildVo czUsersChildVo = new CzUsersChildVo();
                czUsersChildVo._setDataSourceId(LotteryCommonContext.get().getSiteId());
                czUsersChildVo.setResult(sessionUserChild);
                czUsersChildVo.setProperties(CzUsersChild.PROP_UPSW,CzUsersChild.PROP_IS_CHANGED,CzUsersChild.PROP_LAST_CHANGED_DATE);
                czUsersChildVo = ServiceTool.czUsersChildService().updateOnly(czUsersChildVo);
                if(czUsersChildVo.isSuccess()){
                    return getAlert("修改密碼成功") + LocationHref("/passport/login.html");
                }
                else {
                    return getAlert("修改密碼不成功！");
                }
            }
        }
        else {
            //修改主賬號密碼
            String oldPassword = sysUserExtend.getPassword();
            txtoldpwd = AuthTool.md5SysUserPassword(txtoldpwd, sysUserExtend.getUsername());
            if(!txtoldpwd.equals(oldPassword)){
                return getAlert("您輸入原密碼不正確！");
            }
            else {
//                更新密碼
                sysUserExtend.setPassword(AuthTool.md5SysUserPassword(txtnewpwd, sysUserExtend.getUsername()));
                sysUserExtend.setIsChanged(PasswordIsChangeEnum.NORMAL.getCode());
                sysUserExtend.setLastChangedDate(new Date());
                SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
                sysUserExtendVo.setResult(sysUserExtend);
                sysUserExtendVo.setProperties(SysUserExtend.PROP_PASSWORD,SysUserExtend.PROP_IS_CHANGED,SysUserExtend.PROP_LAST_CHANGED_DATE);
                //如果賬號是總監賬號，要切換到管理庫
                if(sysUserExtend.getUsername().equals(LotteryCommonContext.get().getDomainUserName())){
                    sysUserExtendVo._setDataSourceId(Const.BASE_DATASOURCE_ID);
                }
                else {
                    sysUserExtendVo._setDataSourceId(LotteryCommonContext.get().getSiteId());
                }
                sysUserExtendVo = ServiceTool.sysUserExtendService().updateOnly(sysUserExtendVo);
                if(sysUserExtendVo.isSuccess()){
                    return getAlert("修改密碼成功") + LocationHref("/passport/login.html");
                }
                else {
                    return getAlert("修改密碼不成功！");
                }
            }
        }
    }

    public String getAlert(String message)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<script>");
        builder.append(" alert('"+message+"');");
        builder.append("</script>");
        return builder.toString();
    }

    public String LocationHref(String url)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<script>");
        builder.append(" window.location.href='"+url+"' ");
        builder.append("</script>");
        return builder.toString();
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
