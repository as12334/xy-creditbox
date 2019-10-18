package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

public enum LotteryHashRecordTypeEnum implements ICodeEnum {
    PAYOUT("payout", "派彩"),
    RESULT("result", "开奖"),
    RECALCULATE("recalculate", "重结");

    private String code;
    private String trans;

    LotteryHashRecordTypeEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getTrans() {
        return this.trans;
    }
}
