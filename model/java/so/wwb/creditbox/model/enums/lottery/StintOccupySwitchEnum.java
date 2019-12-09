package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum StintOccupySwitchEnum implements ICodeEnum {

    //查询总账报表，0否，1查询总账、2查询总账包括明细
    OFF("0", "占餘成數下綫任占"),
    ON("1", "限製下綫可占成數");

    private String code;
    private String trans;

    StintOccupySwitchEnum(String code, String trans) {
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
