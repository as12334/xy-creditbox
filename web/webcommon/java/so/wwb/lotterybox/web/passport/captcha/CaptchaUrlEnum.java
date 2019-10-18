package so.wwb.lotterybox.web.passport.captcha;

import org.soul.web.shiro.common.captcha.ICaptchaUrlEnum;

/**
 * Created by longer on 12/31/15.
 */
public enum CaptchaUrlEnum implements ICaptchaUrlEnum {

    CODE_LOGIN("code", "登录验证码"),
    CODE_REGISTER("register", "注册验证码"),
    CODE_PLAYER_LOGIN_TOP("loginTop", "官网头部登陆验证码"),
    CODE_PLAYER_LOGIN_INDEX("loginIndex", "官网首页登陆验证码"),
    CODE_PLAYER_LOGIN_DIALOG("loginDialog", "官网弹窗登陆验证码"),
    CODE_PLAYER_REGISTER_PC("ppcregister", "玩家注册验证码"),
    CODE_AGENT_REGISTER_PC("apcregister", "代理注册验证码"),
    CODE_PLAYER_REGISTER_MOBILE("pmregister", "手机玩家注册验证码"),
    CODE_IMP_PLAYER("import", "导入玩家"),
    CODE_RECHARGE("recharge", "玩家存款"),
    CODE_FORGET_PASSWORD("forgetPassword", "忘记密码填写用户名"),
    CODE_CHANGE_PASSWORD_BY_EMAIL("changePassword", "忘记密码修改密码"),
    CODE_FEEDBACK("feedback", "反馈意见"),
    CODE_PHONE("phoneCode", "手机绑定"),
    CODE_EMAIL("emailCode", "邮箱绑定"),
    CODE_PRIVILEGE("privilege", "安全密码"),
    CODE_CONTINUE_QUESTION("continueQuestion", "继续追问验证码"),
    CODE_SECURITY_PASSWORD("securityPwd","修改安全密码");

    private String suffix;
    private String desc;

    CaptchaUrlEnum(String suffix, String desc) {
        this.suffix = suffix;
        this.desc = desc;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
