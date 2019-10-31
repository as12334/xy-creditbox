package so.wwb.creditbox.company.user.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.web.remote.controller.CheckToolController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


/**
 * 表单验证对象
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class VSiteUserForm implements IForm {
//endregion your codes 1

    //region your codes 2
    /*昵称*/
    private String result_nickname;
    /*登录密码*/
    private String result_password;
    /*昵称*/
    private String result_credits;

    /*状态*/
    private String result_status;
    /*總賬報表*/
    private String result_general;
    /*退水設定*/
    private String $water;

    /*上級占成*/
    private String result_superiorOccupy;

    /*限制占成*/
    private String result_stintOccupy;
    /*限占单选*/
    private String $stintId;

    /*限制占成*/
    private String result_setOdds;
    /*剩餘成數*/
    private String result_breakpoint;


    /*補貨設定*/
    private String result_manualAutoShipments;


    @NotBlank
    @Min(value = 0,message = "请输入数字0-99999999")
    @Max(value = 99999999 , message = "请输入数字0-99999999")
    public String getResult_credits() {
        return result_credits;
    }

    public void setResult_credits(String result_credits) {
        this.result_credits = result_credits;
    }


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


    @NotBlank
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String getResult_superiorOccupy() {
        return result_superiorOccupy;
    }

    public void setResult_superiorOccupy(String result_superiorOccupy) {
        this.result_superiorOccupy = result_superiorOccupy;
    }


    public String get$stintId() {
        return $stintId;
    }

    public void set$stintId(String $stintId) {
        this.$stintId = $stintId;
    }

    @Depends(property = "$stintId", operator = Operator.EQ, value = {"no"}, jsValueExp = "$(\"[name=\\'stintId\\']\").val()=='no'")
    @Min(value = -1,message = "请输入数字-1 - 100")
    @Max(value = 100 , message = "请输入数字-1 - 100")
    public String getResult_stintOccupy() {
        return result_stintOccupy;
    }

    public void setResult_stintOccupy(String result_stintOccupy) {
        this.result_stintOccupy = result_stintOccupy;
    }
    @NotBlank
    public String getResult_setOdds() {
        return result_setOdds;
    }

    public void setResult_setOdds(String result_setOdds) {
        this.result_setOdds = result_setOdds;
    }

    @NotBlank
    public String getResult_general() {
        return result_general;
    }

    public void setResult_general(String result_general) {
        this.result_general = result_general;
    }

    @NotBlank
    public String getResult_breakpoint() {
        return result_breakpoint;
    }

    public void setResult_breakpoint(String result_breakpoint) {
        this.result_breakpoint = result_breakpoint;
    }

    @NotBlank
    public String getResult_manualAutoShipments() {
        return result_manualAutoShipments;
    }

    public void setResult_manualAutoShipments(String result_manualAutoShipments) {
        this.result_manualAutoShipments = result_manualAutoShipments;
    }

    @NotBlank
    public String getResult_status() {
        return result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }
    //endregion your codes 2

}