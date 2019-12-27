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
 * 表單验证对象
 *
 * @author block
 * @time 2019-12-19 23:20:50
 */
//region your codes 1
public class UserBeanForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private  String $utype;

    private  String $userName;
    private  String $userPassword;
    private  String $userNicker;
    private  String $userReport;
    private  String $userCredit_six;
    private  String $userRate_six;
    private  String $userAllowSale_six;
    private  String $userRateOwner_six;

    private  String $sltupuser;



    //代理下线人数，暂时未用到
//    private  String $sltlimithy;
//    private  String $txtlimithy;
//    会员直属上级类型
    private  String $rdoutype;

    //经营彩票类型：六合彩，快彩
    private  String $lotteryType;

    /**
     * 下綫占成
     */
    private  String $allowmaxrate_six;
    /**
     * 下綫占成 值
     */
    private  String $lowmaxrate_six;
    private  String $userKind_six;
    /**操盘*/
    private  String $op_six;
    /**可用额度*/
    private  String $userCredit_kc;
    /** 快彩占成 */
    private  String $userRate_kc;

    /** 快彩補貨功能 */
    private  String $userAllowSale_kc;
    /** 快彩占餘成數歸 1:總監 0:分公司 */
    private  String $userRateOwner_kc;
    /**
     * 下綫占成
     */
    private  String $allowmaxrate_kc;
    /**
     * 下綫占成 值
     */
    private  String $lowmaxrate_kc;
    private  String $userKind_kc;
    private  String $isCash_kc;
    private  String $isCash_six;
    private  String $op_kc;

    @Depends(property = "result.id", operator = Operator.IS_NULL, value = "")
    @Pattern(message = "请输入4-16个字符(由英文字母,下划线“-”,数字或任意组合而成)", regexp = "^[a-z0-9A-Z][a-z0-9A-Z_]{0,12}$")
    @Remote(checkClass = CheckToolController.class, checkMethod = "checkUsername", type = "input",additionalProperties = {"result.username","result.userType"}, message = "此“賬號”已經有人使用！請重新填寫！")
    public String get$userName() {
        return $userName;
    }
    @Depends(property = "result.id", operator = Operator.IS_NULL, value = "")
    @Pattern(regexp = RegexConst.LOGIN_PWD, message = "请输入6-16个符号（由大小写英文字母、数字或特殊符号组成）")
    public String get$userPassword() {
        return $userPassword;
    }
    @NotBlank
    @Pattern(message = "请输入3-16个字符（由汉字、大小写英文字母和数字组成）", regexp = RegexConst.NICK_NAME)
    public String get$userNicker() {
        return $userNicker;
    }

    @Depends(property = {"utype"}, operator = {Operator.EQ}, value = {"fgs"})
    public String get$userReport() {
        return $userReport;
    }

    @Depends(property = {"utype"}, operator = {Operator.NE}, value = {"fgs"})
    public String get$sltupuser() {
        return $sltupuser;
    }

    @Depends(property = {"utype"}, operator = {Operator.EQ}, value = {"hy"})
    public String get$rdoutype() {
        return $rdoutype;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    @Min(value = 0,message = "请输入数字0-99999999")
    @Max(value = 99999999 , message = "请输入数字0-99999999")
    public String get$userCredit_kc() {
        return $userCredit_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String get$userRate_kc() {
        return $userRate_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    public String get$userAllowSale_kc() {
        return $userAllowSale_kc;
    }


    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})

    public String get$userRateOwner_kc() {
        return $userRateOwner_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    public String get$allowmaxrate_kc() {
        return $allowmaxrate_kc;
    }
    @Depends(property = {"lotteryType","allowmaxrate_kc"}, operator = {Operator.EQ,Operator.EQ}, value = {"2","1"})
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String get$lowmaxrate_kc() {
        return $lowmaxrate_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    public String get$userKind_kc() {
        return $userKind_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    public String get$isCash_kc() {
        return $isCash_kc;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"2"})
    public String get$op_kc() {
        return $op_kc;
    }




    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    @Min(value = 0,message = "请输入数字0-99999999")
    @Max(value = 99999999 , message = "请输入数字0-99999999")
    public String get$userCredit_six() {
        return $userCredit_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String get$userRate_six() {
        return $userRate_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    public String get$userAllowSale_six() {
        return $userAllowSale_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    @Min(value = 0,message = "请输入数字0-100")
    @Max(value = 100 , message = "请输入数字0-100")
    public String get$userRateOwner_six() {
        return $userRateOwner_six;
    }

    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    public String get$allowmaxrate_six() {
        return $allowmaxrate_six;
    }
    @Depends(property = {"lotteryType","allowmaxrate_six"}, operator = {Operator.EQ,Operator.EQ}, value = {"1","1"})
    public String get$lowmaxrate_six() {
        return $lowmaxrate_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    public String get$userKind_six() {
        return $userKind_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    public String get$op_six() {
        return $op_six;
    }
    @Depends(property = {"lotteryType"}, operator = {Operator.EQ}, value = {"1"})
    public String get$isCash_six() {
        return $isCash_six;
    }


    public void set$userName(String $userName) {
        this.$userName = $userName;
    }

    public void set$userPassword(String $userPassword) {
        this.$userPassword = $userPassword;
    }

    public void set$userNicker(String $userNicker) {
        this.$userNicker = $userNicker;
    }

    public void set$userReport(String $userReport) {
        this.$userReport = $userReport;
    }

    public void set$userCredit_six(String $userCredit_six) {
        this.$userCredit_six = $userCredit_six;
    }

    public void set$userRate_six(String $userRate_six) {
        this.$userRate_six = $userRate_six;
    }

    public void set$userAllowSale_six(String $userAllowSale_six) {
        this.$userAllowSale_six = $userAllowSale_six;
    }

    public void set$userRateOwner_six(String $userRateOwner_six) {
        this.$userRateOwner_six = $userRateOwner_six;
    }

    public void set$sltupuser(String $sltupuser) {
        this.$sltupuser = $sltupuser;
    }


    public void set$rdoutype(String $rdoutype) {
        this.$rdoutype = $rdoutype;
    }

    public void set$allowmaxrate_six(String $allowmaxrate_six) {
        this.$allowmaxrate_six = $allowmaxrate_six;
    }

    public void set$lowmaxrate_six(String $lowmaxrate_six) {
        this.$lowmaxrate_six = $lowmaxrate_six;
    }

    public void set$userKind_six(String $userKind_six) {
        this.$userKind_six = $userKind_six;
    }

    public void set$op_six(String $op_six) {
        this.$op_six = $op_six;
    }

    public void set$userCredit_kc(String $userCredit_kc) {
        this.$userCredit_kc = $userCredit_kc;
    }

    public void set$userRate_kc(String $userRate_kc) {
        this.$userRate_kc = $userRate_kc;
    }

    public void set$userAllowSale_kc(String $userAllowSale_kc) {
        this.$userAllowSale_kc = $userAllowSale_kc;
    }

    public void set$userRateOwner_kc(String $userRateOwner_kc) {
        this.$userRateOwner_kc = $userRateOwner_kc;
    }

    public void set$allowmaxrate_kc(String $allowmaxrate_kc) {
        this.$allowmaxrate_kc = $allowmaxrate_kc;
    }

    public void set$lowmaxrate_kc(String $lowmaxrate_kc) {
        this.$lowmaxrate_kc = $lowmaxrate_kc;
    }

    public void set$userKind_kc(String $userKind_kc) {
        this.$userKind_kc = $userKind_kc;
    }

    public void set$isCash_kc(String $isCash_kc) {
        this.$isCash_kc = $isCash_kc;
    }

    public void set$isCash_six(String $isCash_six) {
        this.$isCash_six = $isCash_six;
    }

    public void set$op_kc(String $op_kc) {
        this.$op_kc = $op_kc;
    }

    public String get$lotteryType() {
        return $lotteryType;
    }

    public void set$lotteryType(String $lotteryType) {
        this.$lotteryType = $lotteryType;
    }
    public String get$utype() {
        return $utype;
    }

    public void set$utype(String $utype) {
        this.$utype = $utype;
    }
//endregion your codes 2

}