package so.wwb.creditbox.model.enums.base;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 占餘成數歸
 * Created by longer on 12/4/15.
 */
public enum RateOwnerEnum implements ICodeEnum {

    //查询总账报表，0否，1查询总账、2查询总账包括明细
    ZJ("1", "總監"),
    FGS("0", "分公司");

    private String code;
    private String trans;

    RateOwnerEnum(String code, String trans) {
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
