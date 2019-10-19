package so.wwb.creditbox.manager.account.site.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.Comment;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.manager.account.site.controller.VSiteMasterManageController;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 站长管理表单验证对象
 *
 * @author tom
 * @time 2015-11-17 16:57:53
 */
//region your codes 1
public class VSiteMasterManageForm implements IForm {
//endregion your codes 1

    //region your codes 2
    // 账号
    private String result_username;
    // 密码
    private String result_password;
    // 确认密码
    private String $confirmPassword;
    // 昵称
    private String result_nickname;
    // 性别
    private String result_sex;
    // 备注
    private String result_memo;
    // 邮箱
    private String $email_contactValue;
    // 手机
    private String $mobilePhone_contactValue;
    // skype
    private String $skype_contactValue;
    // msn
    private String $msn_contactValue;
    // qq
    private String $qq_contactValue;
    // 问题2
    private String $sysUserProtection_answer1;
    // 推荐人
    private String $userExtend_referrals;

    private String result_defaultTimezone;

    @Depends(property = "result.id", operator = Operator.IS_NULL,value = "")
    @Pattern(regexp = RegexConst.ACCOUNT,message = "common.valid.usernameFormat")
    @Length(max = 20)
    @Remote(message = "siteMaster.accountAlreadyExists",checkClass = VSiteMasterManageController.class,additionalProperties = {"result_username"},checkMethod = "userNameIsSame")
    public String getResult_username() {
        return result_username;
    }

    public void setResult_username(String result_username) {
        this.result_username = result_username;
    }

    @Pattern(message = "common.valid.loginPWDFormat",regexp = RegexConst.LOGIN_PWD)
    @Length(max = 20)
    @Depends(property = "result.id", operator = Operator.IS_NULL,value = "")
    public String getResult_password() {
        return result_password;
    }

    public void setResult_password(String result_password) {
        this.result_password = result_password;
    }

    @Depends(property = "result.id", operator = Operator.IS_NULL,value ="")
    @Compare(logic = CompareLogic.EQ, anotherProperty = "result.password",message = "siteMaster.PWDNotMatch")
    public String get$confirmPassword() {
        return $confirmPassword;
    }

    public void set$confirmPassword(String $confirmPassword) {
        this.$confirmPassword = $confirmPassword;
    }

    @Length(min=3,max = 15,message = "请输入3-15个字符（由汉字、大小写英文字母和数字组成）")
    @Pattern(regexp = RegexConst.CNANDEN_NUMBER,message = "格式不正确，请重新输入")
    public String getResult_nickname() {
        return result_nickname;
    }

    public void setResult_nickname(String result_nickname) {
        this.result_nickname = result_nickname;
    }

    @Length(max = 8)
    public String getResult_sex() {
        return result_sex;
    }

    public void setResult_sex(String result_sex) {
        this.result_sex = result_sex;
    }

    @Email
    public String get$email_contactValue() {
        return $email_contactValue;
    }

    public void set$email_contactValue(String $email_contactValue) {
        this.$email_contactValue = $email_contactValue;
    }

    @Pattern(regexp = RegexConst.NUMBER_PHONE)
    public String get$mobilePhone_contactValue() {
        return $mobilePhone_contactValue;
    }

    public void set$mobilePhone_contactValue(String $mobilePhone_contactValue) {
        this.$mobilePhone_contactValue = $mobilePhone_contactValue;
    }

    @Pattern(regexp = RegexConst.SKYPE,message = "6-32个字符（由字母和数字组成，以字母开头,不能包含空格或特殊字符）")
    public String get$skype_contactValue() {
        return $skype_contactValue;
    }

    public void set$skype_contactValue(String $skype_contactValue) {
        this.$skype_contactValue = $skype_contactValue;
    }

    @Length(max = 30)
    @Pattern(regexp = RegexConst.MSN,message = "仅限输入邮箱格式的内容")
    public String get$msn_contactValue() {
        return $msn_contactValue;
    }

    public void set$msn_contactValue(String $msn_contactValue) {
        this.$msn_contactValue = $msn_contactValue;
    }

    @Length(max = 30)
    @Pattern(regexp = RegexConst.QQ,message = "请输入5-11个字符（由数字组成）")
    public String get$qq_contactValue() {
        return $qq_contactValue;
    }

    public void set$qq_contactValue(String $qq_contactValue) {
        this.$qq_contactValue = $qq_contactValue;
    }

    @Depends(property ={"$sysUserProtection_question1","result_id"}, operator = {Operator.IS_NOT_EMPTY, Operator.IS_NOT_EMPTY}, value = {"",""}, message = "请填写问题的答案！")
    @Length(max = 30)
    @Comment("回答")
    public String get$sysUserProtection_answer1() {
        return $sysUserProtection_answer1;
    }

    public void set$sysUserProtection_answer1(String $sysUserProtection_answer1) {
        this.$sysUserProtection_answer1 = $sysUserProtection_answer1;
    }

    @Length(max = 32)
    public String get$userExtend_referrals() {
        return $userExtend_referrals;
    }

    public void set$userExtend_referrals(String $userExtend_referrals) {
        this.$userExtend_referrals = $userExtend_referrals;
    }

    @Length(min = 1, max = 20000)
    public String getResult_memo() {
        return result_memo;
    }

    public void setResult_memo(String result_memo) {
        this.result_memo = result_memo;
    }
    @NotBlank
    public String getResult_defaultTimezone() {
        return result_defaultTimezone;
    }

    public void setResult_defaultTimezone(String result_defaultTimezone) {
        this.result_defaultTimezone = result_defaultTimezone;
    }
    //endregion your codes 2

}