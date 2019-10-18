package so.wwb.creditbox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by tom on 15-11-30.
 */
public enum SysSiteStatusEnum implements ICodeEnum {
    NORMAL("1","正常"),
    STOP("2","停用"),
    MAINTAIN("3","维护中"),
    UNBUILDDB("4","未建库"),
    PRE_MAINTAIN("5","维护前");

    private String code;
    private String trans;

    SysSiteStatusEnum(String code,String trans) {
        this.code = code;
        this.trans = trans;
    }
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTrans() {
        return this.trans;
    }
}
