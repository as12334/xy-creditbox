package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.ienums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum LotterySortTypeEnum implements ICodeEnum {

    //玩法小类
    D("d", "特碼類"),
    LMP("lmp", "兩面類"),
    LM("lm", "連碼類");

    private String code;
    private String trans;

    LotterySortTypeEnum(String code, String trans) {
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
