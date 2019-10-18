package so.wwb.lotterybox.model.enums.oauth;

import org.soul.commons.enums.ICodeEnum;

public enum ClientStatusEnum implements ICodeEnum {
    ENABLE("0", "可用"),
    DISABLE("1", "禁用");

    private String code;
    private String trans;

    ClientStatusEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getTrans() {
        return null;
    }
}
