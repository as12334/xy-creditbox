package so.wwb.creditbox.model.bean;

import java.io.Serializable;

/**
 * Created by block on 2019/11/25.
 */
public class WebJson implements Serializable {

    private int success;
    private Data data;
    private String tipinfo;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTipinfo() {
        return tipinfo;
    }

    public void setTipinfo(String tipinfo) {
        this.tipinfo = tipinfo;
    }
}
