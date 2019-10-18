package so.wwb.creditbox.web.defense.core.model;

import java.util.HashMap;
import java.util.Map;

public class DefensePadding {
    private Map<String,Object> padding;

    public Object get(String key){
        if (padding != null) {
            return padding.get(key);
        }
        return null;
    }

    public void set(String key,Object val){
        if (padding == null) {
            padding = new HashMap<>();
        }
        padding.put(key,val);
    }

    public Map<String, Object> getPadding() {
        return padding;
    }

    public void setPadding(Map<String, Object> padding) {
        this.padding = padding;
    }
}
