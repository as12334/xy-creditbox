package so.wwb.creditbox.manager.common.account.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

/**
 * Created by jeremy on 18-5-30.
 */
public class SysUserExtendUpdateForm implements IForm {

    /**
     * 昵称
     */
    private String result_nickname;
    /**
     * 真实姓名
     */
    private String result_realName;
    /**
     * 生日
     */
    private String result_birthday;

    @NotBlank
    @Pattern(message = "请输入3-16个字符（由汉字、大小写英文字母和数字组成）", regexp = RegexConst.NICK_NAME)
    public String getResult_nickname() {
        return result_nickname;
    }

    public void setResult_nickname(String result_nickname) {
        this.result_nickname = result_nickname;
    }

    @NotBlank
    @Pattern(message = "请输入2-30个字符（由汉字、大小写英文字母、“·”组成", regexp = RegexConst.NAME)
    public String getResult_realName() {
        return result_realName;
    }

    public void setResult_realName(String result_realName) {
        this.result_realName = result_realName;
    }

    //此处的验证在多种时间格式下是有问题的
    @Pattern(message = "日期输入错误", regexp = RegexConst.BIRTHDAY)
    public String getResult_birthday() {
        return result_birthday;
    }

    public void setResult_birthday(String result_birthday) {
        this.result_birthday = result_birthday;
    }
}
