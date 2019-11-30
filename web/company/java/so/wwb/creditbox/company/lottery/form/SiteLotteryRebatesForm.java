package so.wwb.creditbox.company.lottery.form;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.soul.web.support.IForm;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


/**
 * 表單验证对象
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
//region your codes 1
public class SiteLotteryRebatesForm implements IForm {
//endregion your codes 1

    //region your codes 2

    private String[] minBet$$;
    private String[] maxBet$$;
    private String[] maxExpectBet$$;
    private String[] rebateA$$;
    private String[] rebateB$$;
    private String[] rebateC$$;

    @NotBlank(message = "不能为空")
    @Pattern(message = "请输入正整数", regexp = "^\\d+(\\.0)?$")
    @Min(message = "请输入正整数", value = 1)
    public String[] getMinBet$$() {
        return minBet$$;
    }


    public void setMinBet$$(String[] minBet$$) {
        this.minBet$$ = minBet$$;
    }

    @NotBlank(message = "不能为空")
    @Pattern(message = "请输入正整数", regexp = "^\\d+(\\.0)?$")
    @Min(message = "请输入正整数", value = 1)
    public String[] getMaxBet$$() {
        return maxBet$$;
    }

    public void setMaxBet$$(String[] maxBet$$) {
        this.maxBet$$ = maxBet$$;
    }

    @NotBlank(message = "不能为空")
    @Pattern(message = "请输入正整数", regexp = "^\\d+(\\.0)?$")
    @Min(message = "请输入正整数", value = 1)
    public String[] getMaxExpectBet$$() {
        return maxExpectBet$$;
    }

    public void setMaxExpectBet$$(String[] maxExpectBet$$) {
        this.maxExpectBet$$ = maxExpectBet$$;
    }

    @NotBlank(message = "不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String[] getRebateA$$() {
        return rebateA$$;
    }

    public void setRebateA$$(String[] rebateA$$) {
        this.rebateA$$ = rebateA$$;
    }

    @NotBlank(message = "不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String[] getRebateB$$() {
        return rebateB$$;
    }

    public void setRebateB$$(String[] rebateB$$) {
        this.rebateB$$ = rebateB$$;
    }

    @NotBlank(message = "不能为空")
    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
    @DecimalMin("0.001")
    @Digits(integer = 7,fraction = 3)
    public String[] getRebateC$$() {
        return rebateC$$;
    }

    public void setRebateC$$(String[] rebateC$$) {
        this.rebateC$$ = rebateC$$;
    }

    //    private String rebateA;
//    private String rebateB;
//    private String rebateC;
//    /** 最低下注额 */
//    private Double minBet;
//    /** 單注限额 */
//    private Double maxBet;
//    /** 單期限额 */
//    private Double maxExpectBet;
//    /** 起补金额 */
//    private Double postMoney;
//    /** 是否开启，1开启、0关闭 */
//    private String postMoneyClose;
//
//    @NotBlank(message = "不能为空")
//    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
//    @DecimalMin("0.001")
//    @Digits(integer = 7,fraction = 3)
//    public String getRebateA() {
//        return rebateA;
//    }
//
//    public void setRebateA(String rebateA) {
//        this.rebateA = rebateA;
//    }
//    @NotBlank(message = "不能为空")
//    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
//    @DecimalMin("0.001")
//    public String getRebateB() {
//        return rebateB;
//    }
//
//    public void setRebateB(String rebateB) {
//        this.rebateB = rebateB;
//    }
//    @NotBlank(message = "不能为空")
//    @Pattern(message = "格式错误", regexp = "^\\d*[0-9](\\.\\d*[0-9]{1,3})?$")
//    @DecimalMin("0.001")
//    public String getRebateC() {
//        return rebateC;
//    }
//
//    public void setRebateC(String rebateC) {
//        this.rebateC = rebateC;
//    }
//
//    @NotBlank
//    @Range(min = 1,max =99999999 )
//    public Double getMinBet() {
//        return minBet;
//    }
//
//    public void setMinBet(Double minBet) {
//        this.minBet = minBet;
//    }
//
//    @NotBlank
//    @Range(min = 1,max =99999999 )
//    public Double getMaxBet() {
//        return maxBet;
//    }
//
//    public void setMaxBet(Double maxBet) {
//        this.maxBet = maxBet;
//    }
//
//    @NotBlank
//    @Range(min = 1,max =99999999 )
//    public Double getMaxExpectBet() {
//        return maxExpectBet;
//    }
//
//    public void setMaxExpectBet(Double maxExpectBet) {
//        this.maxExpectBet = maxExpectBet;
//    }
//    @NotBlank
//    @Range(min = 1,max =99999999 )
//    public Double getPostMoney() {
//        return postMoney;
//    }
//
//    public void setPostMoney(Double postMoney) {
//        this.postMoney = postMoney;
//    }
//
//    @NotBlank
//    public String getPostMoneyClose() {
//        return postMoneyClose;
//    }
//
//    public void setPostMoneyClose(String postMoneyClose) {
//        this.postMoneyClose = postMoneyClose;
//    }


    //endregion your codes 2

}