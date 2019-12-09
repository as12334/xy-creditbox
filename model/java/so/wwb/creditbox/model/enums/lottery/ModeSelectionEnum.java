package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum ModeSelectionEnum implements ICodeEnum {

    //模式选择，1现金模式、0信用模式
    CREDIT("0", "信用模式"),
    CASH("1", "现金模式"),
    ;

    private String code;
    private String trans;

    ModeSelectionEnum(String code, String trans) {
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
