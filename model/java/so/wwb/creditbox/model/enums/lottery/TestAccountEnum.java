package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.enums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum TestAccountEnum implements ICodeEnum {

    //是否是测试账号
    NO("0", "否"),
    YES("1", "是");

    private String code;
    private String trans;

    TestAccountEnum(String code, String trans) {
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
