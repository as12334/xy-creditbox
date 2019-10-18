package so.wwb.lotterybox.manager.common.lottery.form;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.soul.web.support.IForm;
import so.wwb.lotterybox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 彩种类型表表单验证对象
 *
 * @author steady
 * @time 2018-5-21 19:42:21
 */
public class LotteryTypeForm implements IForm {
    /**
     * 类型代号
     */
    private String result_typeCode;
    /**
     * 类型名称
     */
    private String result_typeName;
    /**
     * 类型排序
     */
    private String result_orderNum;

    @NotBlank
    @Pattern(regexp = RegexConst.LOTTERY_TYPE_CODE, message = "请输入大小写英文字母或数字")
    public String getResult_typeCode() {
        return result_typeCode;
    }

    public void setResult_typeCode(String result_typeCode) {
        this.result_typeCode = result_typeCode;
    }

    @NotBlank
    @Pattern(regexp = RegexConst.LOTTERY_TYPE_NAME, message = "请输入中文、大小写英文字母或数字")
    public String getResult_typeName() {
        return result_typeName;
    }

    public void setResult_typeName(String result_typeName) {
        this.result_typeName = result_typeName;
    }

    @NotBlank
    @Range(min = 1 ,max = 9999)
    public String getResult_orderNum() {
        return result_orderNum;
    }

    public void setResult_orderNum(String result_orderNum) {
        this.result_orderNum = result_orderNum;
    }

}