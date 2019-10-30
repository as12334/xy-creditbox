package so.wwb.creditbox.company.user.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;
import so.wwb.creditbox.web.remote.controller.CheckToolController;

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

    /*昵称*/
    private String result_credits;

    /*退水設定*/
    private String water;

    /*上級占成*/
    private String result_superiorOccupy;

    /*限制占成*/
    private String result_stintOccupy;


    /*限制占成*/
    private String result_setOdds;


    /*補貨設定*/
    private String result_manualAutoShipments;


    @NotBlank
    @Pattern(message = "请输入数字！", regexp = RegexConst.ZERO_POSITIVE)
    public String getResult_credits() {
        return result_credits;
    }

    public void setResult_credits(String result_credits) {
        this.result_credits = result_credits;
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
    @Pattern(message = "退水設定:輸入錯誤！", regexp = RegexConst.ZERO_POSITIVE)
    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    @NotBlank
    @Pattern(message = "占成輸入錯誤！", regexp = RegexConst.ZERO_POSITIVE)
    public String getResult_superiorOccupy() {
        return result_superiorOccupy;
    }

    public void setResult_superiorOccupy(String result_superiorOccupy) {
        this.result_superiorOccupy = result_superiorOccupy;
    }
    @NotBlank
    @Pattern(message = "限制下線占成:輸入錯誤！", regexp = RegexConst.NUMBER)
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
    public String getResult_manualAutoShipments() {
        return result_manualAutoShipments;
    }

    public void setResult_manualAutoShipments(String result_manualAutoShipments) {
        this.result_manualAutoShipments = result_manualAutoShipments;
    }
    //endregion your codes 2

}