package so.wwb.creditbox.company.user.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Compare;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.Comment;
import org.soul.commons.validation.form.support.CompareLogic;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.web.remote.controller.CheckToolController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * 账户验证
 * Created by cherry on 17-3-29.
 */
@Comment("账户验证")
public class AddSysUserExtendForm implements IForm {
    /*账号*/
    private String result_username;
    /*登录密码*/
    private String result_password;
    /*昵称*/
    private String result_nickname;

    /*上级Id*/
    private String result_ownerId;

    /*昵称*/
    private String result_credits;

    /*昵称*/
    private String result_userType;

     /*退水設定*/
    private String $water;

    /*限占单选*/
    private String $stintId;

    /*上級占成*/
    private Double result_superiorOccupy;

    /*限制占成*/
    private Double result_stintOccupy;


    /*限制占成*/
    private String result_setOdds;

    /*總賬報表*/
    private String result_general;

    /*剩餘成數*/
    private String result_breakpoint;

    /*補貨設定*/
    private String result_manualAutoShipments;



    /*最高可设置的占成数*/
    private Double maxSuperiorOccupy;



    @NotBlank
    @Min(value = 0,message = "请输入数字0-99999999")
    @Max(value = 99999999 , message = "请输入数字0-99999999")
    public String getResult_credits() {
        return result_credits;
    }

    public void setResult_credits(String result_credits) {
        this.result_credits = result_credits;
    }

    @NotBlank
    @Pattern(message = "请输入4-16个字符(由英文字母,下划线“-”,数字或任意组合而成)", regexp = "^[a-z0-9A-Z][a-z0-9A-Z_]{0,12}$")
    @Remote(checkClass = CheckToolController.class, checkMethod = "checkUsername", type = "input",additionalProperties = {"result.username","result.userType"}, message = "此“賬號”已經有人使用！請重新填寫！")
    public String getResult_username() {
        return result_username;
    }

    public void setResult_username(String result_username) {
        this.result_username = result_username;
    }

    @NotBlank(message = "请先创建上级用户")
    public String getResult_ownerId() {
        return result_ownerId;
    }

    public void setResult_ownerId(String result_ownerId) {
        this.result_ownerId = result_ownerId;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.LOGIN_PWD, message = "请输入6-16个符号（由大小写英文字母、数字或特殊符号组成）")
    public String getResult_password() {
        return result_password;
    }

    public void setResult_password(String result_password) {
        this.result_password = result_password;
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
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String get$water() {
        return $water;
    }

    public void set$water(String $water) {
        this.$water = $water;
    }


    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    @Compare(message = "已超过最大值",logic = CompareLogic.LE,anotherProperty = "maxSuperiorOccupy")
    public Double getResult_superiorOccupy() {
        return result_superiorOccupy;
    }

    public void setResult_superiorOccupy(Double result_superiorOccupy) {
        this.result_superiorOccupy = result_superiorOccupy;
    }


    public String get$stintId() {
        return $stintId;
    }

    public void set$stintId(String $stintId) {
        this.$stintId = $stintId;
    }


//    @Depends(property = "$stintId", operator = Operator.EQ, value = {"no"}, jsValueExp = "$(\"[name=\\'stintId\\']\").val()=='no'")
    @Depends(property = {"result.userType", "$stintId"}, operator = {Operator.NE, Operator.EQ}, value = {"8", "no"})
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public Double getResult_stintOccupy() {
        return result_stintOccupy;
    }

    public void setResult_stintOccupy(Double result_stintOccupy) {
        this.result_stintOccupy = result_stintOccupy;
    }
    @Depends(property = {"result.userType"}, operator = {Operator.NE}, value = {"8"})
    @NotBlank
    public String getResult_setOdds() {
        return result_setOdds;
    }

    public void setResult_setOdds(String result_setOdds) {
        this.result_setOdds = result_setOdds;
    }


    @Depends(property = {"result.userType"}, operator = {Operator.NE}, value = {"8"})
    @NotBlank
    public String getResult_general() {
        return result_general;
    }

    public void setResult_general(String result_general) {
        this.result_general = result_general;
    }
    @Depends(property = {"result.userType"}, operator = {Operator.NE}, value = {"8"})
    @NotBlank
    public String getResult_breakpoint() {
        return result_breakpoint;
    }

    public void setResult_breakpoint(String result_breakpoint) {
        this.result_breakpoint = result_breakpoint;
    }

    @Depends(property = {"result.userType"}, operator = {Operator.NE}, value = {"8"})
    @NotBlank
    public String getResult_manualAutoShipments() {
        return result_manualAutoShipments;
    }

    public void setResult_manualAutoShipments(String result_manualAutoShipments) {
        this.result_manualAutoShipments = result_manualAutoShipments;
    }

    public String getResult_userType() {
        return result_userType;
    }

    public void setResult_userType(String result_userType) {
        this.result_userType = result_userType;
    }

    public Double getMaxSuperiorOccupy() {
        return maxSuperiorOccupy;
    }

    public void setMaxSuperiorOccupy(Double maxSuperiorOccupy) {
        this.maxSuperiorOccupy = maxSuperiorOccupy;
    }
}
