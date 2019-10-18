package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

public enum LotteryGatherOriginEnum implements ICodeEnum {
    AUTO("auto", "自动"),
    MAKE_UP("make_up", "补采"),
    OPEN_NUMBER("open_number", "手动");

    private String code;
    private String trans;

    LotteryGatherOriginEnum(String code, String trans) {
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
