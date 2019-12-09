package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

public enum LotteryGatherConfEnum implements ICodeEnum {
    opencai("opencai", "开奖网"),
    kai("kai", "168开彩网"),
    lbw("lbw", "六百万"),
    auto("auto", "自动开奖"),
    wangyi("wangyi", "网易采集"),
    fhlm("fhlm", "凤凰联盟"),
    cpk("cpk","彩票控");

    private String code;
    private String trans;

    LotteryGatherConfEnum(String code, String trans) {
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
