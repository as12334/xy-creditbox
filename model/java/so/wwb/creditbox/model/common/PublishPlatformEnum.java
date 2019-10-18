package so.wwb.creditbox.model.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * @author fly
 * @time 2015-10-22 11:58
 */
public enum PublishPlatformEnum implements ICodeEnum {
    MASTER_CONTROL("master_control", "总控"),
    OPERATOR("operator", "运营商");

    private String code;
    private String trans;

    PublishPlatformEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    public String getTrans() {
        return trans;
    }

    public String getCode() {
        return code;
    }
}