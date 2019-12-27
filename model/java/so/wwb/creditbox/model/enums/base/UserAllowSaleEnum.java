package so.wwb.creditbox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.ienums.ICodeEnum;

/**
 * 報表
 */
public enum UserAllowSaleEnum implements ICodeEnum {
    CLOSE("0", "禁用"),
    OPEN("1", "啟用"),
    ;

    private String code;
    private String trans;

    UserAllowSaleEnum(String code, String trans) {
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

    public static UserAllowSaleEnum enumOf(String code) {
        return EnumTool.enumOf(UserAllowSaleEnum.class, code);
    }
}