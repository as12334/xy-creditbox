package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

public enum Lottery600Enum implements ICodeEnum {
    CQSSC("1","cqssc" ,"重庆时时彩"),
    TCPL3("4", "tcpl3","体彩排列3"),
    FC3D("5","fc3d", "福彩3D"),
    HKLHC("6","hklhc", "香港六合彩"),
    BJ28("7", "xy28","北京28"),
    BJKL8("8","bjkl8", "北京快乐8"),
    BJPK10("9","bjpk10", "北京pk10"),
    CQXYNC("10","cqxync", "重庆幸运农场"),
    GDKL10("11","gdkl10", "广东快乐十分"),
    HBK3("19", "hbk3","湖北快3"),
    AHK3("20","ahk3", "安徽快3");

    private String code;
    private String oriCode;
    private String trans;

    Lottery600Enum(String code, String oriCode, String trans) {
        this.code = code;
        this.oriCode = oriCode;
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

    public String getOriCode() {
        return oriCode;
    }

    public void setOriCode(String oriCode) {
        this.oriCode = oriCode;
    }
}
