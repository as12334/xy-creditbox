package so.wwb.creditbox.manager.boss.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;
import so.wwb.creditbox.manager.boss.site.controller.BossDomainController;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;

/**
 * Created by cherry on 17-3-22.
 */
@Comment("域名表單验证")
public class VSysDomainsForm implements IForm {
    private Integer result_id;
    private String result_domain;
    private String result_name;
    private String result_templateCode;
    private String result_theme;

    @NotBlank
    @Remote(message = "域名已存在", checkClass = BossDomainController.class, formId = "editDomainForm",type="textarea",checkMethod = "checkDomain", additionalProperties = "result_id")
    @Length(max = 100, min = 1,message = "域名最大长度100字符")
    public String getResult_domain() {
        return result_domain;
    }

    public void setResult_domain(String result_domain) {
        this.result_domain = result_domain;
    }

    @NotBlank
    @Length(max = 20, min = 1,message = "名称最大长度20字符")
    public String getResult_name() {
        return result_name;
    }

    public void setResult_name(String result_name) {
        this.result_name = result_name;
    }

    public Integer getResult_id() {
        return result_id;
    }

    public void setResult_id(Integer result_id) {
        this.result_id = result_id;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_templateCode() {
        return result_templateCode;
    }

    public void setResult_templateCode(String result_templateCode) {
        this.result_templateCode = result_templateCode;
    }

    @Pattern(message = "请输入4到32个字符(由英文字母,数字或任意组合而成)", regexp = RegexConst.TEMPLATECODE)
    public String getResult_theme() {
        return result_theme;
    }

    public void setResult_theme(String result_theme) {
        this.result_theme = result_theme;
    }
}
