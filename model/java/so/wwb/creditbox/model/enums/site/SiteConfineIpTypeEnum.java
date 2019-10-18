package so.wwb.creditbox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteConfineIpTypeEnum implements ICodeEnum {
    SITE_DENY("1","限制访问游戏中心"),
    SITE_ALLOW("2","允许访问游戏中心"),
    CENTER_ALLOW("3","允许访问管理中心"),
    API_ALLOW("4","允许访问开放中心-API");

    private String code;
    private String trans;

    SiteConfineIpTypeEnum(String code,String trans) {
        this.code = code;
        this.trans = trans;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
