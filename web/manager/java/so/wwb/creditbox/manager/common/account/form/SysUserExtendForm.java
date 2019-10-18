package so.wwb.creditbox.manager.common.account.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.Comment;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.web.remote.controller.CheckToolController;

import javax.validation.constraints.Pattern;

/**
 * 账户验证
 * Created by cherry on 17-3-29.
 */
@Comment("账户验证")
public class SysUserExtendForm implements IForm {
    /*账号*/
    private String result_username;
    /*登录密码*/
    private String result_password;
    private String $confirmPwd;
    /*权限密码*/
    private String result_permissionPwd;
    private String $confirmPermissionPwd;
    /*昵称*/
    private String result_nickname;

    /*真实姓名*/
    private String result_realName;


    /*真实姓名*/
    private String result_credits;

//    /*电子邮箱*/
//    private String noticeContactWay_contactValue;
//    private String result_mail;

//    private String[] $roleIds;
//
//    private String result_userType;

    private String result_birthday;

    @NotBlank
    @Pattern(message = "请输入数字！", regexp = RegexConst.DIGIT)
    public String getResult_credits() {
        return result_credits;
    }

    public void setResult_credits(String result_credits) {
        this.result_credits = result_credits;
    }

    @NotBlank
    @Pattern(message = "请输入4-16个字符(由英文字母,下划线“-”,数字或任意组合而成)", regexp = RegexConst.ACCOUNT)
    @Remote(checkClass = CheckToolController.class, checkMethod = "checkUsername", type = "input",additionalProperties = {"result.username", "result.userType", "result.ownerId"}, message = "该用户名已存在于平台")
    public String getResult_username() {
        return result_username;
    }

    public void setResult_username(String result_username) {
        this.result_username = result_username;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.LOGIN_PWD, message = "common.valid.loginPWDFormat")
    public String getResult_password() {
        return result_password;
    }

    public void setResult_password(String result_password) {
        this.result_password = result_password;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.LOGIN_PWD, message = "common.valid.loginPWDFormat")
    @Compare(logic = CompareLogic.EQ, anotherProperty = "result.password", message = "与登录密码不一致！")
    public String get$confirmPwd() {
        return $confirmPwd;
    }

    public void set$confirmPwd(String $confirmPwd) {
        this.$confirmPwd = $confirmPwd;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.SECURITY_PWD, message = "common.valid.securityPWDFormat")
    public String getResult_permissionPwd() {
        return result_permissionPwd;
    }

    public void setResult_permissionPwd(String result_permissionPwd) {
        this.result_permissionPwd = result_permissionPwd;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.SECURITY_PWD, message = "common.valid.securityPWDFormat")
    @Compare(logic = CompareLogic.EQ, anotherProperty = "result.permissionPwd", message = "与安全密码不一致！")
    public String get$confirmPermissionPwd() {
        return $confirmPermissionPwd;
    }

    public void set$confirmPermissionPwd(String $confirmPermissionPwd) {
        this.$confirmPermissionPwd = $confirmPermissionPwd;
    }

    @NotBlank
    @Pattern(message = "请输入3-16个字符（由汉字、大小写英文字母和数字组成）", regexp = RegexConst.NICK_NAME)
    public String getResult_nickname() {
        return result_nickname;
    }

    public void setResult_nickname(String result_nickname) {
        this.result_nickname = result_nickname;
    }

    @NotBlank
    @Pattern(message = "请输入2-30个字符（由汉字、大小写英文字母、“·”组成", regexp = RegexConst.NAME)
    public String getResult_realName() {
        return result_realName;
    }

    public void setResult_realName(String result_realName) {
        this.result_realName = result_realName;
    }

//    @NotBlank
//    @Pattern(message = "输入正确邮箱地址", regexp = RegexConst.EMAIL)
//    public String getNoticeContactWay_contactValue() {
//        return noticeContactWay_contactValue;
//    }
//    public void setNoticeContactWay_contactValue(String noticeContactWay_contactValue) {
//        this.noticeContactWay_contactValue = noticeContactWay_contactValue;
//    }
//    @Pattern(regexp = RegexConst.EMAIL, message = "输入正确邮箱地址")
//    public String getResult_mail() {return result_mail;}
//    public void setResult_mail(String result_mail) {this.result_mail = result_mail;}
//
//    @Depends(message = "请分配角色", operator = Operator.IN, value = "[\"01\", \"11\",\"21\", \"221\"]", property = "result_userType",
//            jsValueExp = "$(\"[name=\\'result.userType\\']\").val()")
//    public String[] get$roleIds() {
//        return $roleIds;
//    }
//
//    public void set$roleIds(String[] $roleIds) {
//        this.$roleIds = $roleIds;
//    }
//
//    public String getResult_userType() {
//        return result_userType;
//    }
//
//    public void setResult_userType(String result_userType) {
//        this.result_userType = result_userType;
//    }

    //此处的验证在多种时间格式下是有问题的
    @Pattern(message = "日期输入错误", regexp = RegexConst.BIRTHDAY)
    public String getResult_birthday() {
        return result_birthday;
    }

    public void setResult_birthday(String result_birthday) {
        this.result_birthday = result_birthday;
    }
}
