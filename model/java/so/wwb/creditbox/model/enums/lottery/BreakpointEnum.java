package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.enums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum BreakpointEnum implements ICodeEnum {

    //1占余归总监、2占余归分公司
    ZERO("0", "除了分公司其他角色為0"),
    COMPANY("1", "占余归总监"),
    BRANCH("2", "占余归分公司");

    private String code;
    private String trans;

    BreakpointEnum(String code, String trans) {
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
