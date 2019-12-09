package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum GeneralEnum implements ICodeEnum {

    //查询总账报表，0否，1查询总账、2查询总账包括明细
    OFF("0", "否"),
    TOTAL("1", "查询总账"),
    ALL("2", "查询总账包括明细");

    private String code;
    private String trans;

    GeneralEnum(String code, String trans) {
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
