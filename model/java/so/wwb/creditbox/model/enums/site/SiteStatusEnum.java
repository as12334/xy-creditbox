package so.wwb.creditbox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteStatusEnum implements ICodeEnum {
    NORMAL("1","正常"),
    DISABLED("2","停用"),
    MAINTAIN("3","维护中"),
    UN_BUILD("4","未建库"),
    PRE_MAINTAIN("5","维护前");

    private String code;
    private String trans;

    SiteStatusEnum(String code,String trans) {
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
