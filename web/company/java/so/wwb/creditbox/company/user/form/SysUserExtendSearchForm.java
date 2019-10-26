package so.wwb.creditbox.company.user.form;

import org.soul.web.support.IForm;

/**
 * Created by cherry on 17-3-29.
 */
public class SysUserExtendSearchForm implements IForm {
    private String search_username;
    //使用js 前端验证
//    @Pattern(message = "请用半角逗号隔开", regexp = "^[a-zA-Z0-9_,]{4,}$")
    public String getSearch_username() {
        return search_username;
    }

    public void setSearch_username(String search_username) {
        this.search_username = search_username;
    }

}
