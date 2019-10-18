package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by rambo on 18-5-26.
 */
public enum LotteryOddProjectStatusEnum implements ICodeEnum {
    NORMAL("normal", "启用"),
    DISABLE("disable", "下架");

    private String code;
    private String trans;

    LotteryOddProjectStatusEnum(String code, String trans) {
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
