package so.wwb.creditbox.manager.common.account.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.web.remote.controller.CheckToolController;

import javax.validation.constraints.Pattern;

/**
 * Created by cj on 15-8-24.
 */
public class UpdatePasswordForm implements IForm {
    private String password;
    private String newPassword;
    private String newRePassword;

    @NotBlank
    @Remote(checkClass = CheckToolController.class, checkMethod = "checkPassword", formId = "UpdateMinePasswordEditForm", type = "input",additionalProperties = {"password"}, message = "setting.myAccount.updatePassword.error")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @Pattern(message = "common.valid.loginPWDFormat",regexp = RegexConst.LOGIN_PWD)
    @Compare(message = "新密码不能与旧密码相同", logic = CompareLogic.NE, anotherProperty = "password")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @NotBlank
    @Compare(message = "playerResetPwd.pwdNeConfirmPwd", logic = CompareLogic.EQ, anotherProperty = "newPassword")
    public String getNewRePassword() {
        return newRePassword;
    }

    public void setNewRePassword(String newRePassword) {
        this.newRePassword = newRePassword;
    }
}
