package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

public enum LotteryGatherConfStatusEnum implements ICodeEnum {
    NORMAL("normal", "启用"),
    DISABLE("disable", "停用");

    private String code;
    private String trans;

    LotteryGatherConfStatusEnum(String code, String trans) {
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
