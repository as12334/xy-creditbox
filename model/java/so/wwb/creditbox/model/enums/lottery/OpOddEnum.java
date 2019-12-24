package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 是否可以调整赔率
 * Created by longer on 12/4/15.
 */
public enum OpOddEnum implements ICodeEnum {

    YES("1", "启用"),
    NO("0", "禁用");

    private String code;
    private String trans;

    OpOddEnum(String code, String trans) {
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
