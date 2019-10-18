package so.wwb.creditbox.model.enums.base;

/**
 * Created by tom on 15-7-6.
 */
public enum FreezeTypeEnum {

    AUTO("1","自动"),
    MANUAL("2","手动");

    private String code;

    private String name;

    FreezeTypeEnum(String code, String name){
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
