package so.wwb.creditbox.web.membercenter.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

/**
 * Created by jeremy on 18-4-16.
 */
public class ResetPwdForm implements IForm {
    /**
     * 登录密码
     */
    private String $pwd;
    /**
     * 确认登录密码
     */
    private String $confirmPwd;

    @NotBlank
    @Pattern(regexp = RegexConst.LOGIN_PWD, message = "common.valid.loginPWDFormat")
    public String get$pwd() {
        return $pwd;
    }
    public void set$pwd(String pwd) {
        this.$pwd = pwd;
    }

    @NotBlank
    @Compare(message = "两次输入的登录密码不相同", logic = CompareLogic.EQ, anotherProperty = "pwd")
    public String get$confirmPwd() {
        return $confirmPwd;
    }
    public void set$confirmPwd(String $confirmPwd) {
        this.$confirmPwd = $confirmPwd;
    }

}
