package so.wwb.creditbox.manager.common.privilege.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;
import so.wwb.creditbox.manager.common.privilege.controller.PrivilegeController;

/**
 * Created by cj on 15-10-15.
 */
@Comment("安全密码表单验证")
public class PrivilegeForm implements IForm {
    private String code;
    private String validateCode;

    @Comment("安全密码")
    @NotBlank(message = "privilege.privilege.code.notblank")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Comment("验证码")
    @Depends(property = {"requiredValidateCode"}, operator = {Operator.EQ}, value = {"1"}, message = "privilege.privilege.valiCode.notblank")
    @Remote(message = "验证码错误！", checkClass = PrivilegeController.class, checkMethod = "checkValidateCode")
    public String getValidateCode() {
        return validateCode;
    }
    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

}
