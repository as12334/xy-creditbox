package so.wwb.creditbox.web.membercenter.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;

/**
 * Created by jeremy on 18-4-10.
 */
public class FreezeEditForm implements IForm {
    private String result_freezeStartTime;
    private String result_freezeEndTime;

    @NotBlank(message = "冻结开始时间不能为空")
    public String getResult_freezeStartTime() {
        return result_freezeStartTime;
    }

    public void setResult_freezeStartTime(String result_freezeStartTime) {
        this.result_freezeStartTime = result_freezeStartTime;
    }
    @NotBlank(message = "冻结结束时间不能为空")
    public String getResult_freezeEndTime() {
        return result_freezeEndTime;
    }

    public void setResult_freezeEndTime(String result_freezeEndTime) {
        this.result_freezeEndTime = result_freezeEndTime;
    }
}
