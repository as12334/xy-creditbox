package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * Create by diego on 2018-02-12
 */
public enum LotteryResultNumberOrignEnum implements ICodeEnum {

    MANUAL("manual", "手动"),
    AUTOMATIC("automatic", "自动");

    private String code;
    private String trans;

    LotteryResultNumberOrignEnum(String code, String trans) {
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
