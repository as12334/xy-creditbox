package so.wwb.creditbox.model.manager.lottery.bean;

import org.soul.commons.lang.string.StringTool;

import java.io.Serializable;

public abstract class BaseBean implements Serializable {

    public static String fmtJson(String json) {
        if (StringTool.isNotBlank(json)) {
            return json.replaceAll("&quot;", "\"");
        }
        return "";
    }
}
