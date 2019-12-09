package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

public enum LotteryOriginEnum implements ICodeEnum {
    HAND("0", "手动"),
    AUTO("1", "自动"),
    KILL("2", "杀率"),
    COLLECT("3", "补采"),
    ;

    private String code;
    private String trans;

    LotteryOriginEnum(String code, String trans) {
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
