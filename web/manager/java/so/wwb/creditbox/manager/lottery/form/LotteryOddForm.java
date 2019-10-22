package so.wwb.creditbox.manager.lottery.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;


/**
 * 赔率设置表表单验证对象
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
//region your codes 1
public class LotteryOddForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private String[] lotteryOdds$$_odd;
    private String[] lotteryOdds$$_rebate;

    @NotBlank(message = "common.赔率不能为空")
//    @Min(message = "赔率不能小于1", value = 1)
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7, fraction = 3)
    public String[] getLotteryOdds$$_odd() {
        return lotteryOdds$$_odd;
    }

    public void setLotteryOdds$$_odd(String[] lotteryOdds$$_odd) {
        this.lotteryOdds$$_odd = lotteryOdds$$_odd;
    }

    @NotBlank(message = "common.返点比例不能为空")
    @Pattern(message = "格式错误", regexp = "^[0-9]\\d*(\\.\\d*[0-9]{1,3})?$")
//    @DecimalMin("0.001")
//    @DecimalMax("0.999")
//    @Digits(integer = 1,fraction = 3)
//    @Digits(integer = 7,fraction = 2)
    public String[] getLotteryOdds$$_rebate() {
        return lotteryOdds$$_rebate;
    }

    public void setLotteryOdds$$_rebate(String[] lotteryOdds$$_rebate) {
        this.lotteryOdds$$_rebate = lotteryOdds$$_rebate;
    }
    //endregion your codes 2

}