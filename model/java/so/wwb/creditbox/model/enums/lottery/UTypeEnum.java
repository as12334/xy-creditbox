package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 角色类型
 * Created by longer on 12/4/15.
 */
public enum UTypeEnum implements ICodeEnum {

    ZGS("zgs", "总公司"),
    ZJ("zj", "总监"),
    FGS("fgs", "分公司"),
    GD("gd", "股东"),
    ZD("zd", "总代"),
    DL("dl", "代理"),
    HY("hy", "会员"),
    CHILD("child", "子账号"),;

    private String code;
    private String trans;

    UTypeEnum(String code, String trans) {
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
