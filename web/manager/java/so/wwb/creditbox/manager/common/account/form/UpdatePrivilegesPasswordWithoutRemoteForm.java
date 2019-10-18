package so.wwb.creditbox.manager.common.account.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

public class UpdatePrivilegesPasswordWithoutRemoteForm implements IForm {
    private String newPassword;
    private String newRePassword;

    @NotBlank
    @Pattern(regexp = RegexConst.SECURITY_PWD,message = "common.valid.securityPWDFormat")
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
