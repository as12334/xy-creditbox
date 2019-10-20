package so.wwb.creditbox.model.enums.lottery;


import org.soul.commons.enums.ICodeEnum;

/**
 * Created by longer on 12/4/15.
 */
public enum LotteryGenreEnum implements ICodeEnum {

    //状态,1:全部玩法，2:官方玩法，3:信用玩法
    ALL("1", "全部玩法"),
    OFFICAL("2", "官方玩法"),
    CREDIT("3", "信用玩法");

    private String code;
    private String trans;

    LotteryGenreEnum(String code, String trans) {
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
