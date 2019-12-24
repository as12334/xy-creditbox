package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * 皮肤
 * Created by longer on 12/4/15.
 */
public enum SkinEnum implements ICodeEnum {

    //查询总账报表，0否，1查询总账、2查询总账包括明细
    BLUE("Blue", "蓝色"),
    RED("Red", "红色"),
    GREEN("Green", "绿色"),
    YELLOW("Yellow", "黄色"),;

    private String code;
    private String trans;

    SkinEnum(String code, String trans) {
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
