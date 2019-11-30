package so.wwb.creditbox.model.common;

import org.soul.commons.dict.IDictEnum;
import org.soul.commons.support.IModule;

/**
 * 系统模板参数
 */
public enum NoticeParamEnum implements IDictEnum {
    UN_FREEZE_TIME("unfreezetime", "冻结截止时间"),
    OPERATE_TIME("operatetime", "操作时间"),
    CUSTOMER("customer", "联系客服"),
    ORDER_LAUNCH_TIME("orderlaunchtime", "下單时间"),
    ORDER_AMOUNT("orderamount", "下單金额"),
    ORDER_NUM("ordernum", "下單号"),
    SITE_NAME("sitename", "站点名称"),
    YEAR("year", "年"),
    MONTH("month", "月"),
    DAY("day", "日"),
    USER("user", "玩家账号"),
    PERIOD("period", "期"),
    START_DATE("startDate", "开始日期"),
    END_DATE("endDate", "结束日期"),
    SEND_YEAR("sendYear","发送年份"),
    SEND_MONTH("sendMonth","发送月份"),
    SEND_DAY("sendDay","发送日"),
    TAIL_NUMBER("tailNumber","银行卡后四位"),
    BANK("bank","银行名称"),
    WITHDRAW_MONEY("withdrawMoney","取款金额"),
    ORDER("order","交易号"),
    PLASE_MONEY("plaseMoney","取款金额"),
    TIME("time","时间");

    private final String code;
    private String desc;

    NoticeParamEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public IModule getModule() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
