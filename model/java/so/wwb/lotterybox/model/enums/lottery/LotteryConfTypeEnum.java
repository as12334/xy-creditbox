package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * @function: lottery conf type enum
 */
public enum LotteryConfTypeEnum implements ICodeEnum {
    GATHER("gather", "采集"),
    VALID("valid", "验证"),
    COLLECTION("collection", "补采");

    private String code;
    private String trans;

    LotteryConfTypeEnum(String code, String trans) {
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
