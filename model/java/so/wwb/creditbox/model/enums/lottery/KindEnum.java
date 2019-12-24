package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 盘口
 * Created by longer on 12/4/15.
 */
public enum KindEnum implements ICodeEnum {

    DEFAULT("0", "A盘口"),
    A("A", "A盘口"),
    B("B", "B盘口"),
    C("C", "C盘口");

    private String code;
    private String trans;

    KindEnum(String code, String trans) {
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
