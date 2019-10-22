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
 * @time 2019-10-21 22:52:08
 */
//region your codes 1
public class SiteLotteryOddForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private String[] lotteryOdds$$_odd_a;
    private String[] lotteryOdds$$_odd_b;
    private String[] lotteryOdds$$_odd_c;

    @NotBlank(message = "common.赔率不能为空")
    @DecimalMin("0.001")
    @Pattern(message = "格式错误", regexp = "^[0-9]\\d*(\\.\\d*[0-9]{1,3})?$")
    @Digits(integer = 7, fraction = 3)
    public String[] getLotteryOdds$$_odd_a() {
        return lotteryOdds$$_odd_a;
    }

    public void setLotteryOdds$$_odd_a(String[] lotteryOdds$$_odd_a) {
        this.lotteryOdds$$_odd_a = lotteryOdds$$_odd_a;
    }
    @NotBlank(message = "common.赔率不能为空")
    @DecimalMin("0.001")
    @Pattern(message = "格式错误", regexp = "^[0-9]\\d*(\\.\\d*[0-9]{1,3})?$")
    @Digits(integer = 7, fraction = 3)
    public String[] getLotteryOdds$$_odd_b() {
        return lotteryOdds$$_odd_b;
    }

    public void setLotteryOdds$$_odd_b(String[] lotteryOdds$$_odd_b) {
        this.lotteryOdds$$_odd_b = lotteryOdds$$_odd_b;
    }
    @NotBlank(message = "common.赔率不能为空")
    @DecimalMin("0.001")
    @Pattern(message = "格式错误", regexp = "^[0-9]\\d*(\\.\\d*[0-9]{1,3})?$")
    @Digits(integer = 7, fraction = 3)
    public String[] getLotteryOdds$$_odd_c() {
        return lotteryOdds$$_odd_c;
    }

    public void setLotteryOdds$$_odd_c(String[] lotteryOdds$$_odd_c) {
        this.lotteryOdds$$_odd_c = lotteryOdds$$_odd_c;
    }
    //endregion your codes 2

}