package so.wwb.lotterybox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;

/**
 * 模式枚举
 *
 * @author marz
 * @time 2018-2-13
 */
public enum LotteryModelEnum  implements ICodeEnum {

    ALL("all", "全部玩法"),
    TRADITION("tradition", "传统玩法"),
    OFFICIAL("official", "官方玩法");

    private String code;
    private String trans;

    LotteryModelEnum(String code, String trans) {
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
