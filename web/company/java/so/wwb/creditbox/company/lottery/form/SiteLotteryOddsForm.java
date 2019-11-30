package so.wwb.creditbox.company.lottery.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;


/**
 * 表單验证对象
 *
 * @author block
 * @time 2019-11-8 0:58:27
 */
//region your codes 1
public class SiteLotteryOddsForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private String oddA;
    private String oddB;
    private String oddC;
    private String maxOdd;

    @NotBlank(message = "赔率不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String getOddA() {
        return oddA;
    }

    public void setOddA(String oddA) {
        this.oddA = oddA;
    }

    @NotBlank(message = "赔率不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String getOddB() {
        return oddB;
    }

    public void setOddB(String oddB) {
        this.oddB = oddB;
    }

    @NotBlank(message = "赔率不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String getOddC() {
        return oddC;
    }

    public void setOddC(String oddC) {
        this.oddC = oddC;
    }

    @NotBlank(message = "赔率不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String getMaxOdd() {
        return maxOdd;
    }

    public void setMaxOdd(String maxOdd) {
        this.maxOdd = maxOdd;
    }


    //endregion your codes 2

}