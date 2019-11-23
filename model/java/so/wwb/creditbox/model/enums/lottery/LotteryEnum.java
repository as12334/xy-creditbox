package so.wwb.creditbox.model.enums.lottery;

import so.wwb.creditbox.model.enums.base.IChildEnum;

public enum LotteryEnum implements IChildEnum {

    BJPK10(LotteryTypeEnum.PK10, LotteryClassifyEnum.OFFICE, "bjpk10", "北京PK10"),
    XYFT(LotteryTypeEnum.PK10, LotteryClassifyEnum.OFFICE, "xyft", "幸运飞艇"),
    CQSSC(LotteryTypeEnum.SSC, LotteryClassifyEnum.OFFICE, "cqssc", "重庆时时彩"),
    GDKL10(LotteryTypeEnum.SFC, LotteryClassifyEnum.OFFICE, "gdkl10", "广东快乐十分"),




    JSK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "jsk3", "江苏快3"),
    AHK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "ahk3","安徽快3"),
    HBK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "hbk3","湖北快3"),
    GXK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "gxk3","广西快3"),
    HEBK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "hebk3","河北快3"),
    SHK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "shk3","上海快3"),
    JLK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "jlk3","吉林快3"),
    GSK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OFFICE, "gsk3","甘肃快3"),
    JISK3(LotteryTypeEnum.K3, LotteryClassifyEnum.OWN, "jisk3", "极速快3"),

    HKLHC(LotteryTypeEnum.LHC, LotteryClassifyEnum.OFFICE, "hklhc", "香港六合彩"),
    JSLHC(LotteryTypeEnum.LHC,LotteryClassifyEnum.OWN, "jslhc", "极速六合彩"),

    XJSSC(LotteryTypeEnum.SSC, LotteryClassifyEnum.OFFICE, "xjssc", "新疆时时彩"),
    FFSSC(LotteryTypeEnum.SSC, LotteryClassifyEnum.OWN, "ffssc", "分分时时彩"),


    JSPK10(LotteryTypeEnum.PK10, LotteryClassifyEnum.OWN, "jspk10", "极速PK10"),

    CQXYNC(LotteryTypeEnum.SFC, LotteryClassifyEnum.OFFICE, "cqxync", "重庆幸运农场"),

    BJKL8(LotteryTypeEnum.KENO, LotteryClassifyEnum.OFFICE, "bjkl8", "北京快乐8"),
    XY28(LotteryTypeEnum.XY28, LotteryClassifyEnum.OFFICE, "xy28", "幸运28"),

    FC3D(LotteryTypeEnum.PL3, LotteryClassifyEnum.OFFICE, "fc3d", "福彩3D"),
    TCPL3(LotteryTypeEnum.PL3, LotteryClassifyEnum.OFFICE, "tcpl3", "体彩排列3"),

    GD11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "gd11x5", "广东11选5"),
    HLJ11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "hlj11x5", "黑龙江11选5"),
    JX11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "jx11x5", "江西11选5"),
    SD11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "sd11x5", "山东11选5"),
    JS11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "js11x5", "江苏11选5"),
    SH11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OFFICE, "sh11x5", "上海11选5"),
    JIS11X5(LotteryTypeEnum.SYX5, LotteryClassifyEnum.OWN, "jis11x5", "极速11选5"),
    PK10NN(LotteryTypeEnum.NN, LotteryClassifyEnum.OFFICE, "pk10nn", "PK10牛牛"),
    PK10BJL(LotteryTypeEnum.BJL, LotteryClassifyEnum.OFFICE, "pk10bjl", "PK10百家乐");

    private String code;
    private String trans;
    private LotteryTypeEnum parent;
    private LotteryClassifyEnum classify;


    LotteryEnum(LotteryTypeEnum parent, LotteryClassifyEnum classify, String code, String trans) {
        this.parent = parent;
        this.classify = classify;
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

    @Override
    public LotteryTypeEnum getParent() {
        return parent;
    }

    public String getType() {
        return this.parent.getCode();
    }

    public String getClassify() {
        return this.classify.getCode();
    }

}
