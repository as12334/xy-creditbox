package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

public enum LotteryHashRecordStatusEnum implements ICodeEnum {
    PROCESS("process", "处理中"),
    SUCCESS("success", "成功"),
    FAIL("fail", "失败"),
    EXCEPTION("exception","异常");

    private String code;
    private String trans;

    LotteryHashRecordStatusEnum(String code, String trans) {
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
