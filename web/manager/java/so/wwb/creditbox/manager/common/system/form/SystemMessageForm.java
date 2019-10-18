package so.wwb.creditbox.manager.common.system.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;

/**
 * Created by jeremy on 18-3-30.
 */
public class SystemMessageForm implements IForm {
    private String result_title;
    private String result_content;

    @NotBlank(message = "标题不能为空")
    public String getResult_title() {
        return result_title;
    }
    public void setResult_title(String result_title) {
        this.result_title = result_title;
    }

    @NotBlank(message = "内容不能为空")
    public String getResult_content() {
        return result_content;
    }
    public void setResult_content(String result_content) {
        this.result_content = result_content;
    }

}
