package so.wwb.lotterybox.model.enums.common;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by Fei on 2018-01-01
 */
public enum CurrencyEnum implements ICodeEnum {
    CNY("CNY", "货币代码：CNY"),
    USD("USD", "货币代码：USD 美元"),
    GBP("GBP", "货币代码：GBP英镑"),
    JPY("JPY", "货币代码：日元");

    CurrencyEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    private String code;
    private String trans;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
