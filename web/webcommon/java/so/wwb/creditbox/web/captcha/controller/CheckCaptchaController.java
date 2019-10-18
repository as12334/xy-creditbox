package so.wwb.creditbox.web.captcha.controller;

import org.soul.commons.lang.string.StringTool;
import org.soul.model.session.SessionKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.web.passport.captcha.CaptchaUrlEnum;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/check")
public class CheckCaptchaController {

    /**
     * 远程验证码--意见反馈
     * @param code
     * @param reqeust
     * @return
     */
    @RequestMapping(value = "/checkCaptcha")
    @ResponseBody
    public String checkCaptcha(@RequestParam("code") String code, HttpServletRequest reqeust) {
        String sessionCode = SessionManagerCommon.getCaptcha(SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_FEEDBACK.getSuffix());
        if (StringTool.isNotBlank(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
            return "true";
        }
        return "false";
    }

    /**
     * 远程验证码--游戏中心账号设置手机绑定
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkPhoneCaptcha")
    @ResponseBody
    public String checkPhoneCaptcha(@RequestParam("code") String code) {
        String sessionCode = SessionManagerCommon.getCaptcha(SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_PHONE.getSuffix());
        if (StringTool.isNotBlank(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
            return "true";
        }
        return "false";
    }

    /**
     * 远程验证码--游戏中心账号设置邮箱绑定
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkEmailCaptcha")
    @ResponseBody
    public String checkEmailCaptcha(@RequestParam("ecode") String code) {
        String sessionCode = SessionManagerCommon.getCaptcha(SessionKey.S_CAPTCHA_PREFIX + CaptchaUrlEnum.CODE_EMAIL.getSuffix());
        if (StringTool.isNotBlank(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
            return "true";
        }
        return "false";
    }
}
