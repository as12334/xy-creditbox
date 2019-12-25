package so.wwb.creditbox.model.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by block on 2019/11/25.
 */
public class WebJson implements Serializable {

    private int success;
    private Map data;
    private String tipinfo;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Map getData() {
        if (data == null){
            data = new HashMap<>();
        }
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getTipinfo() {
        return tipinfo;
    }

    public void setTipinfo(String tipinfo) {
        this.tipinfo = tipinfo;
    }

    public boolean getIsSuccess() {
        return success == 200;
    }
}
