package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 投注订單奖金模式
 * Created by marz on 17-09-29.
 */
public enum LotteryBonusModelEnum implements ICodeEnum {
    YUAN("1", "元"),
    JIAO("10", "角"),
    FEN("100", "分");

    private String code;
    private String trans;

    LotteryBonusModelEnum(String code, String trans) {
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
