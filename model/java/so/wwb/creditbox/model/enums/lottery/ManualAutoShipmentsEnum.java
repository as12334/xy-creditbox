package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum ManualAutoShipmentsEnum implements ICodeEnum {

    //补货设定  1:启用  0:禁用
    ON("1", "启用"),
    OFF("0", "禁用");

    private String code;
    private String trans;

    ManualAutoShipmentsEnum(String code, String trans) {
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
