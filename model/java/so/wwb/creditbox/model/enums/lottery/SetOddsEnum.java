package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum SetOddsEnum implements ICodeEnum {

    //赔率设置 1:启用  0:禁用
    OFF("0", "禁用"),
    ON("1", "启用");

    private String code;
    private String trans;

    SetOddsEnum(String code, String trans) {
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
