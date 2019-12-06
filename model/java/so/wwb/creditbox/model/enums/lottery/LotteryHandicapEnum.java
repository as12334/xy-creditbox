package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * 盘口枚举
 *
 * @author marz
 * @time 2018-2-13
 */
public enum LotteryHandicapEnum implements ICodeEnum {

    A("A", "A盘口"),
    B("B", "B盘口"),
    C("C", "C盘口");

    private String code;
    private String trans;

    LotteryHandicapEnum(String code, String trans) {
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
