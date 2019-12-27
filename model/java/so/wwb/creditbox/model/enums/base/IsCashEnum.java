package so.wwb.creditbox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.ienums.ICodeEnum;

/**
 * 信用/現金
 */
public enum IsCashEnum implements ICodeEnum {
    CREDOT("0", "信用"),
    CASH("1", "現金"),
    ;

    private String code;
    private String trans;

    IsCashEnum(String code, String trans) {
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

    public static IsCashEnum enumOf(String code) {
        return EnumTool.enumOf(IsCashEnum.class, code);
    }
}