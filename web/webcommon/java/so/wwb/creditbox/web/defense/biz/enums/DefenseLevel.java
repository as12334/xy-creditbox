package so.wwb.creditbox.web.defense.biz.enums;

import org.soul.commons.enums.ICodeEnum;

public enum DefenseLevel implements ICodeEnum {
    SESSION("0","SESSION"),
    DATABASE("1","DATABASE");

    private String code;
    private String trans;

    DefenseLevel(String code, String trans) {
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
