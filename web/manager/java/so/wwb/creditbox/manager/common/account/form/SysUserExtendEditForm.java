package so.wwb.creditbox.manager.common.account.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * Created by cherry on 17-3-29.
 */
@Comment("账户验证")
public class SysUserExtendEditForm implements IForm {

    /*昵称*/
    private String result_nickname;
    /*真实姓名*/
    private String result_realName;
    /*电子邮箱*/
    private String noticeContactWay_contactValue;
    private String[] $roleIds;

    private String result_birthday;

    @NotBlank
    @Pattern(message = "common.valid.nickName", regexp = RegexConst.NICK_NAME)
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
    @NotBlank
    @Pattern(message = "输入正确邮箱地址", regexp = RegexConst.EMAIL)
    public String getNoticeContactWay_contactValue() {
        return noticeContactWay_contactValue;
    }

    public void setNoticeContactWay_contactValue(String noticeContactWay_contactValue) {
        this.noticeContactWay_contactValue = noticeContactWay_contactValue;
    }

    @Depends(message = "请分配角色", operator = Operator.IN, value = "[\"01\", \"11\",\"21\", \"221\"]", property = "edit.userType",
            jsValueExp = "$(\"[name=\\'edit.userType\\']\").val()")
    public String[] get$roleIds() {
        return $roleIds;
    }

    public void set$roleIds(String[] $roleIds) {
        this.$roleIds = $roleIds;
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
