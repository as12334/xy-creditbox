package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 投注订單结算状态
 * Created by fei on 17-4-10.
 */
public enum LotteryOrderStatusEnum implements ICodeEnum {
    PENDING("1", "待结算"),
    SETTLED("2", "已结算"),
    REVOKE("3", "已撤單"),
    REVOCATION("4", "已撤销");
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
