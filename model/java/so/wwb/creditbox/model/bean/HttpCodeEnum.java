package so.wwb.creditbox.model.bean;

/**
 *
 * Created by block on 2019/11/25.
 */
public enum HttpCodeEnum {

    DUPLICATE_LOGON(150,"同一个用户不能同时登录,跳转到指定页面"),
    SUCCESS(200,"成功"),
    PARTIAL_SUCCESS(210,"部分成功"),
    NO_LOGIN(300,"未登錄"),
    ERROR_OTHER(400,"其他错误单独处理"),
    ERROR(500,"内部错误"),
    ODD_CHENGE(610,"赔率变动"),
//    error(700,""),
//    error(800,""),
//    error(900,""),
    ;
    private Integer code;
    private String  trans;

    HttpCodeEnum(Integer code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
