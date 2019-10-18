package so.wwb.lotterybox.manager.common.system.form;

import org.hibernate.validator.constraints.NotBlank;
import org.soul.web.support.IForm;

/**
 * Created by jeremy on 18-3-22.
 */
public class SystemAnnouncementForm implements IForm{
    /*语言*/
    private String result_language;
    /*公告内容*/
    private String result_content;
    /*多语言内容*/
    private String contents$$;
    /*发送方式*/
    private String search_sendType;
    @NotBlank
    public String getResult_language() {
        return result_language;
    }

    public void setResult_language(String result_language) {
        this.result_language = result_language;
    }
    @NotBlank
    public String getResult_content() {
        return result_content;
    }

    public void setResult_content(String result_content) {
        this.result_content = result_content;
    }
    @NotBlank
    public String getSearch_sendType() {
        return search_sendType;
    }

    public void setSearch_sendType(String search_sendType) {
        this.search_sendType = search_sendType;
    }
    @NotBlank(message = "内容不能为空")
    public String getContents$$() {
        return contents$$;
    }

    public void setContents$$(String contents$$) {
        this.contents$$ = contents$$;
    }
}
