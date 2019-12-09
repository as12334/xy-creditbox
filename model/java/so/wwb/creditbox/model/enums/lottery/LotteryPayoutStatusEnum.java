package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

public enum LotteryPayoutStatusEnum implements ICodeEnum {
    PROCESS("0", "处理中"),
    SUCCESS("1", "成功"),
    FAIL("2", "失败"),
    EXCEPTION("3","异常");

    private String code;
    private String trans;

    LotteryPayoutStatusEnum(String code, String trans) {
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
