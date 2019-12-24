package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 补货枚举
 * Created by longer on 12/4/15.
 */
public enum AllowSaleEnum implements ICodeEnum {

    YES("1", "启用"),
    NO("0", "禁用");

    private String code;
    private String trans;

    AllowSaleEnum(String code, String trans) {
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
