package so.wwb.creditbox.manager.account.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 站长管理视图表單验证对象
 *
 * @author admin
 * @time 2016-10-4 16:28:46
 */
//region your codes 1
public class VSiteMasterForm implements IForm {
//endregion your codes 1

    //region your codes 2
    private String result_webSite;

    private String result_remark;

    private String result_maintainStartTime;

    private String result_maintainEndTime;

    private String result_templateCode;

    @Comment("站点域名")
    @Pattern(message = "URL格式不正确", regexp = RegexConst.URL)
    public String getResult_webSite() {
        return result_webSite;
    }

    public void setResult_webSite(String result_webSite) {
        this.result_webSite = result_webSite;
    }

    @NotBlank
    @Length(max=150,message = "备注最大长度150字符")
    public String getResult_remark() {
        return result_remark;
    }

    public void setResult_remark(String result_remark) {
        this.result_remark = result_remark;
    }
    //endregion your codes 2

    @NotBlank
    public String getResult_maintainStartTime() {
        return result_maintainStartTime;
    }

    public void setResult_maintainStartTime(String result_maintainStartTime) {
        this.result_maintainStartTime = result_maintainStartTime;
    }

    @NotBlank
    public String getResult_maintainEndTime() {
        return result_maintainEndTime;
    }

    public void setResult_maintainEndTime(String result_maintainEndTime) {
        this.result_maintainEndTime = result_maintainEndTime;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_templateCode() {
        return result_templateCode;
    }

    public void setResult_templateCode(String result_templateCode) {
        this.result_templateCode = result_templateCode;
    }
}