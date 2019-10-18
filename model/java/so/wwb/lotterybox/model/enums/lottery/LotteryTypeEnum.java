package so.wwb.lotterybox.model.enums.lottery;

import so.wwb.lotterybox.model.enums.base.IParentEnum;

public enum LotteryTypeEnum implements IParentEnum {
    SSC("ssc", "时时彩"),
    PK10("pk10", "PK10"),
    K3("k3", "快3"),
    LHC("lhc", "六合彩"),
    SFC("sfc", "十分彩"),
    KENO("keno", "快乐彩"),
    XY28("xy28", "幸运28"),
    PL3("pl3", "排列3"),
    SYX5("syx5", "11选5"),
    BJL("bjl", "百家乐"),
    NN("nn", "牛牛");

    private String code;
    private String trans;

    LotteryTypeEnum(String code, String trans) {
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
