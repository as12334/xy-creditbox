package so.wwb.creditbox.model.enums.site;

import org.soul.commons.enums.ICodeEnum;

public enum SiteConfineStatusEnum implements ICodeEnum {
    USING("using","正常"),
    EXPIRED("expired","停用");
    private String code;
    private String trans;

    SiteConfineStatusEnum(String code, String trans){
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}