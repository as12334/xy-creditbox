package so.wwb.creditbox.manager.boss.site.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.soul.commons.validation.form.support.Comment;
import org.soul.web.support.IForm;

/**
 * Created by cherry on 17-3-22.
 */
@Comment("域名表單验证")
public class VSysDomainForm implements IForm {
    private Integer result_id;
    private String result_name;

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
