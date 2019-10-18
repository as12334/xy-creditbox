package so.wwb.lotterybox.model.enums.base;

/**
 * Created by tom on 15-6-25.
 */
public enum SexEnum {

    MALE("male", "男"),
    FEMALE("female", "女"),
    SECRET("secret", "不限");

    private final String code;
    private String desc;

    SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
