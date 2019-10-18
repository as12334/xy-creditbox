package so.wwb.creditbox.model.common;

/**
 * Created by tom on 15-7-6.
 */
public enum FreezeTime {

    FORERVE("-99","永远"),
    ST("72","72小时"),
    TF("24","24小时"),
    OT("12","12小时"),
    SIX("6","6小时"),
    THREE("3","3小时");

    private String code;

    private String name;

    FreezeTime(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
