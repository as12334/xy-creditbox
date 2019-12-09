package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

public enum LotteryRuleModelEnum implements ICodeEnum{
    RANDOM("random", "随机"),
    BEST("best", "最佳匹配");

    private String code;
    private String trans;

    LotteryRuleModelEnum(String code, String trans) {
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
