package so.wwb.creditbox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.ienums.ICodeEnum;

/**
 *
 */
public enum IsautoBackEnum implements ICodeEnum {
    AUTO("0", "自動"),
    MANUAL("1", "手動"),
    ;

    private String code;
    private String trans;

    IsautoBackEnum(String code, String trans) {
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

    public static IsautoBackEnum enumOf(String code) {
        return EnumTool.enumOf(IsautoBackEnum.class, code);
    }
}