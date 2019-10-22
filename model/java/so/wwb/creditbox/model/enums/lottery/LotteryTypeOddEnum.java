package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.enums.ICodeEnum;

/**
 * Created by shook on 17-4-9.
 */
public enum LotteryTypeOddEnum implements ICodeEnum {
    SSC("ssc", "时时彩"),
    SSCGF("sscgf", "官方时时彩"),
    PK10("pk10", "PK10"),
    PK10GF("pk10gf", "官方PK10"),
    K3("k3", "快3"),
    K3GF("k3gf", "官方快3"),
    LHC("lhc", "六合彩"),
    SFC("sfc", "十分彩"),
    KENO("keno", "快乐彩"),
    XY28("xy28", "幸运28"),
    PL3("pl3", "排列3"),
    PL3GF("pl3gf", "官方排列3"),
    QT("qt", "其他");

    private String code;
    private String trans;

    LotteryTypeOddEnum(String code, String trans) {
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
