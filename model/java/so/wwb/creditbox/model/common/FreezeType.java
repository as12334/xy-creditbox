package so.wwb.creditbox.model.common;

/**
 * Created by tom on 15-7-6.
 */
public enum FreezeType {

    AUTO("1","自动"),
    MANUAL("2","手动");

    private String code;

    private String name;

    FreezeType(String code, String name){
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
