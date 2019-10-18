package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * 投注订单结算状态
 * Created by fei on 17-4-10.
 */
public enum LotteryOrderStatusEnum implements ICodeEnum {
    PENDING("pending", "未开奖"),
    WINING("wining", "已中奖"),
    NOWIN("nowin","未中奖"),
    REVOKE_SYS("revoke_sys", "系统撤单"),
    REVOKE_SELF("revoke_self", "主动撤单"),
    REVOCATION("revocation","系统撤销")
    ;

    private String code;
    private String trans;

    LotteryOrderStatusEnum(String code, String trans) {
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
