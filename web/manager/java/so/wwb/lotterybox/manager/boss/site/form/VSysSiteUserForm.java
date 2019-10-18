package so.wwb.lotterybox.manager.boss.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;
import so.wwb.lotterybox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

/**
 * @author dick
 * @time 2018-6-26 11:04
 */
public class VSysSiteUserForm implements IForm {

    private String result_webSite;

    private String result_remark;

    private String result_maintainStartTime;

    private String result_maintainEndTime;

    private String result_templateCode;

    private String result_theme;

    /**
     * 站点名称
     */
    private String result_name;

    /**标题**/
    private String result_title;

    @Comment("站点域名")
    @Pattern(message = "URL格式不正确", regexp = RegexConst.URL)
    public String getResult_webSite() {
        return result_webSite;
    }

    public void setResult_webSite(String result_webSite) {
        this.result_webSite = result_webSite;
    }

    @Length(max=150,message = "备注最大长度150字符")
    public String getResult_remark() {
        return result_remark;
    }

    public void setResult_remark(String result_remark) {
        this.result_remark = result_remark;
    }

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

    @NotBlank(message = "站点名称不能为空")
    @Length(min = 3, max = 30)
    public String getResult_name() {
        return result_name;
    }

    @NotBlank(message = "标题名称不能为空")
    @Length(max=25,message = "标题名称最大长度150字符")
    public String getResult_title() {
        return result_title;
    }

    public void setResult_title(String result_title) {
        this.result_title = result_title;
    }

    public void setResult_name(String result_name) {
        this.result_name = result_name;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_theme() {
        return result_theme;
    }

    public void setResult_theme(String result_theme) {
        this.result_theme = result_theme;
    }
}
