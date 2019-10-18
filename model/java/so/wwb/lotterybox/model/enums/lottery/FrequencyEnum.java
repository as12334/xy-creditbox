package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * Create by Fei on 2018-02-07
 */
public enum FrequencyEnum implements ICodeEnum {

    HIGH("high", "高频彩"),
    LOW("low", "低频彩");

    private String code;
    private String trans;

    FrequencyEnum(String code, String trans) {
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
