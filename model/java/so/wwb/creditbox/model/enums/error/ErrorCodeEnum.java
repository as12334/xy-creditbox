package so.wwb.creditbox.model.enums.error;

import org.soul.model.error.IErrorCodeEnum;

/**
 * @author alvin
 * @date 2017.08.12
 */
public enum ErrorCodeEnum implements IErrorCodeEnum {
    SC_IP_DB("610", "SC_IP_DB", "/errors/610"), //IP被限制,请添加到IP库中
    TOKEN_DUE("701", "TOKEN_DUE", "/errors/710"); // TOKEN已失效
    private String code;
    private String desc;
    private String url;

    ErrorCodeEnum(String code, String desc, String url) {
        this.code = code;
        this.desc = desc;
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return desc;
    }
}
