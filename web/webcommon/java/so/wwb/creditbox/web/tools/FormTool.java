package so.wwb.creditbox.web.tools;

import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.validation.form.PasswordRule;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * 表单验证工具类
 * Create by Fei on 2017-12-31
 */
public class FormTool {

    private static final Log LOG = LogFactory.getLog(FormTool.class);

    private static final String PROP_CAPTCHA = "captcha";
    private static final String PROP_NEED_CAPTCHA = "needCaptcha";
    private static final String PROP_CONFIRM_PASSWORD = "confirmPassword";

    /**
     * 校验账号和密码
     * @return WebJson
     */
    public static WebJson checkAccountAndPassword(HttpServletRequest request, WebJson webJson, boolean checkWeak) {
        // 校验账号
        String username = WebUtils.getCleanParam(request, SysUser.PROP_USERNAME);
        LOG.info("登录请求 -> 校验账号：{0}", username);
        if (StringTool.isBlank(username)) {

            webJson = null;
        } else {
            boolean isMatch = Pattern.matches(RegexConst.ACCOUNT, username);
            if (!isMatch) {
                webJson = null;
            }
        }
//        if (WebJson.FAIL.equals(webJson.getError())) return webJson;

        // 校验密码
        String password = getPassword(request);
        LOG.info("登录请求 -> 校验{0}的密码: {1}", username, AuthTool.md5SysUserPassword(password, username));
        if (StringTool.isBlank(password)) {
//            webJson.setCodeEnum(CodeEnum.PASSWORD_IS_EMPTY);
        } else {
            boolean isMatch = Pattern.matches(RegexConst.LOGIN_PWD, password);
            if (!isMatch) {
//                webJson.setCodeEnum(CodeEnum.PASSWORD_EXP_ERROR);
            } else if (checkWeak) {
//                webJson = pwdIsWeak(webJson, username, password);
            }
        }

        return webJson;
    }

//    public static WebJson pwdIsWeak(WebJson webJson, String username, String password) {
//        if (password.equals(username)) {
//            return new WebJson(CodeEnum.PASSWORD_SAME_USERNAME);
//        } else if (PasswordRule.isWeak(password)) {
//            return new WebJson(CodeEnum.PASSWORD_TOO_WEAK);
//        }
//        return webJson;
//    }

    /**
     * 校验验证码
     */
    public static WebJson checkCaptcha(HttpServletRequest request, WebJson webJson, String captchaType) {
        String needCaptcha = WebUtils.getCleanParam(request, PROP_NEED_CAPTCHA);
        if (!Boolean.valueOf(needCaptcha)) {
            return webJson;
        }

        String captcha = WebUtils.getCleanParam(request, PROP_CAPTCHA);
        LOG.info("登录请求 -> 校验验证码：{0}", captcha);
//        if (StringTool.isBlank(captcha)) {
//            webJson.setCodeEnum(CodeEnum.CAPTCHA_IS_EMPTY);
//        }
//
//        String sessionCode = SessionManagerCommon.getCaptcha(SessionKey.S_CAPTCHA_PREFIX + captchaType);
//        LOG.info("登录请求 -> Session验证码：{0}", sessionCode);
//        if (!StringTool.equalsIgnoreCase(captcha, sessionCode)) {
//            webJson.setCodeEnum(CodeEnum.CAPTCHA_IS_ERROR);
//        }

        return webJson;
    }

    /**
     * 校验确认密码
     */
    public static WebJson checkConfirmPassword(HttpServletRequest request, WebJson webJson) {
//        String password = WebUtils.getCleanParam(request, SysUserExtend.PROP_PASSWORD);
//        String confirmPassword = WebUtils.getCleanParam(request, PROP_CONFIRM_PASSWORD);
//        if (checkForm(webJson, confirmPassword, CodeEnum.PASSWORD_IS_EMPTY)) return webJson;
//
//        if (!StringTool.equals(password, confirmPassword)) {
//            webJson.setCodeEnum(CodeEnum.PASSWORD_DIFF);
//        }

        return webJson;
    }

//    private static boolean checkForm(WebJson webJson, String val, CodeEnum codeEnum) {
//        if (StringTool.isBlank(val)) {
////            webJson.setCodeEnum(codeEnum);
//            return true;
//        }
//        return false;
//    }

    public static String getPassword(HttpServletRequest request) {
        String password = WebUtils.getCleanParam(request, SysUserExtend.PROP_PASSWORD);
//        String createChannel = WebUtils.getCleanParam(request, UserPlayer.PROP_CREATE_CHANNEL);
        //TODO 后台添加账号传输没有加密，暂时不需要解密
//        if (StringTool.isNotBlank(password) && !StringTool.equals(CreateChannelEnum.MANAGEMENT.getCode(),createChannel)) {
//            password = Base64.decode(password);
//        }
        return password;
    }

}
