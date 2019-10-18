package so.wwb.lotterybox.model.enums.lottery;

import so.wwb.lotterybox.model.enums.base.IParentEnum;

public enum LotteryOperationEnum implements IParentEnum {

    PAYOUT("payout", "派彩"),
    REVOKE("revoke", "撤单"),
    REVOCATION("revocation", "撤销"),
    RECALCULATE("recalculate", "重结"),
    MAKE_UP("make_up", "补采"),

    INIT("init", "初始化"),
    BATCH_ADJUST("batch_adjust", "批量调盘"),
    ADJUST("adjust", "调盘"),
    OPEN_NUMBER("open_number", "开号"),
    DELETE("delete", "删除");

    private String code;
    private String trans;

    LotteryOperationEnum(String code, String trans) {
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
