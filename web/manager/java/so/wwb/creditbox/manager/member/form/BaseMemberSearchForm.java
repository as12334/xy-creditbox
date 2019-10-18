package so.wwb.creditbox.manager.member.form;

import org.soul.commons.query.enums.Operator;
import org.soul.commons.validation.form.constraints.Depends;
import org.soul.web.support.IForm;

/**
 * Created by bruce on 17-3-20.
 */
public class BaseMemberSearchForm implements IForm {

    private String type;

    private String search_shareholderCode;

    private String search_merchantCode;

    @Depends(message = "请选择股东账号", operator = Operator.IN, value = "[\"0\", \"01\"]", property = "type",
            jsValueExp = "$(\"[name=\\'type\\']\").val()")
    public String getSearch_shareholderCode() {
        return search_shareholderCode;
    }

    public void setSearch_shareholderCode(String search_shareholderCode) {
        this.search_shareholderCode = search_shareholderCode;
    }

    @Depends(message = "请选择商户号", operator = Operator.IN, value = "[\"0\", \"01\", \"1\", \"11\"]", property = "type",
            jsValueExp = "$(\"[name=\\'type\\']\").val()")
    public String getSearch_merchantCode() {
        return search_merchantCode;
    }

    public void setSearch_merchantCode(String search_merchantCode) {
        this.search_merchantCode = search_merchantCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
