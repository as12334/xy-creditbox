package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;

/**
 * 盘口枚举
 *
 * @author marz
 * @time 2018-2-13
 */
public enum LotteryOpTypeEnum implements ICodeEnum {

    PLUS("1", "加赔率"),
    REDUCE("2", "减赔率"),
    opDigita("3", "修改单个赔率"),
    QUICK_PLUS("5", "快捷-加赔率"),
    QUICK_REDUCE("6", "快捷-减赔率");


    private String code;
    private String trans;

    LotteryOpTypeEnum(String code, String trans) {
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
