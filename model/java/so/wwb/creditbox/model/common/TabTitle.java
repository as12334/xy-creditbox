package so.wwb.creditbox.model.common;

import java.io.Serializable;

/**
 * 返水明细表头
 * Created by cheery on 15-9-9.
 */
public class TabTitle implements Serializable {
    private static final long serialVersionUID = -8188247108652829155L;

    private String code;//api Id
    private Boolean state;//是否显示code

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
