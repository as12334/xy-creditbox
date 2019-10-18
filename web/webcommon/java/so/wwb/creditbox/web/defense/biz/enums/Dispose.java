package so.wwb.creditbox.web.defense.biz.enums;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;
import org.soul.commons.lang.string.StringTool;

public enum Dispose implements ICodeEnum {
    NEED_NOT("NEED_NOT","不必"),
    CAPTCHA("CAPTCHA","验证码"),
    DISABLED("DISABLED","禁用"),
    IP_CONFINE("IP_CONFINE","限制IP");

    private String code;
    private String trans;

    Dispose(String code, String trans) {
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

    public static Dispose enumOf(String code){
        if (StringTool.isBlank(code)) {
            return Dispose.NEED_NOT;
        }
        return EnumTool.enumOf(Dispose.class,code);
    }
}
