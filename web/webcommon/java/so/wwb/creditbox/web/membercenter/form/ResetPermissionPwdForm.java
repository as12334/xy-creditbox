package so.wwb.creditbox.web.membercenter.form;

import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

/**
 * Created by jeremy on 18-4-16.
 */
public class ResetPermissionPwdForm implements IForm {
    /**
     * 安全密码
     */
    private String $permissionPwd;
    /**
     * 确认安全密码
     */
    private String $confirmPermissionPwd;

    @Pattern(regexp = RegexConst.SECURITY_PWD, message = "common.valid.securityPWDFormat")
    public String get$permissionPwd() {
        return $permissionPwd;
    }
    public void set$permissionPwd(String permissionPwd) {
        this.$permissionPwd = permissionPwd;
    }

    @Compare(message = "两次输入的安全密码不相同", logic = CompareLogic.EQ, anotherProperty = "permissionPwd")
    public String get$confirmPermissionPwd() {
        return $confirmPermissionPwd;
    }
    public void set$confirmPermissionPwd(String $confirmPermissionPwd) {
        this.$confirmPermissionPwd = $confirmPermissionPwd;
    }
}
