package so.wwb.creditbox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.ienums.ICodeEnum;

public enum PasswordIsChangeEnum implements ICodeEnum {
    FRIST("0", "新密碼首次登錄,需重置密碼!"),
    NORMAL("1", "正常使用，不用修改密碼"),
    ;

    private String code;
    private String trans;

    PasswordIsChangeEnum(String code, String trans) {
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

    public static PasswordIsChangeEnum enumOf(String code) {
        return EnumTool.enumOf(PasswordIsChangeEnum.class, code);
    }
}