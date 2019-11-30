package so.wwb.creditbox.manager.form.content;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.constraints.Remote;
import org.soul.web.support.IForm;
import so.wwb.creditbox.manager.boss.site.controller.BossDomainController;
import so.wwb.creditbox.model.constants.common.RegexConst;

import javax.validation.constraints.Pattern;


/**
 * 站长域名表-修改完会替换 sys_domain表單验证对象
 *
 * @author jeff
 * @time 2015-8-20 9:21:53
 */
//region your codes 1
public class SysDomainForm implements IForm {
//endregion your codes 1

    private Integer result_id;
    private String result_domain;
    private String result_name;

    @NotBlank(message = "线路域名不能为空")
    @Remote(message = "域名已存在", checkClass = BossDomainController.class,checkMethod = "checkDomain", additionalProperties = "result_id")
    @Length(max = 100, min = 1,message = "域名最大长度100字符")
    @Pattern(regexp = RegexConst.PREFIX_LINK,message = "请输入正确格式域名")
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

}