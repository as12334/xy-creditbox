package so.wwb.creditbox.model.enums.lottery;
import org.soul.commons.ienums.ICodeEnum;

public enum LotteryPlayEnum implements ICodeEnum {

    //时时彩

    DIGITAL("digital", "一字定位"),
    BIG_SMALL("big_small", "大小"),
    SINGLE_DOUBLE("single_double", "單雙"),
    SUM_BIG_SMALL("sum_big_small", "總和大小"),
    SUM_SINGLE_DOUBLE("sum_single_double", "總和單雙"),
    RANK_ONE_TWO_SUM("rank_one_two_sum", "冠亚军和"),
    RANK_ONE_TWO_SUM_BIG_SMALL("rank_one_two_sum_big_small", "冠亚军和 大小"),
    RANK_ONE_TWO_SUM_SINGLE_DOUBLE("rank_one_two_sum_single_double", "冠亚军和 單雙"),
    SUM_MANTISSA_BIG_SMALL("sum_mantissa_big_small", "总和尾数大小"),
    SUM_DRAGON_TIGER_TIE("sum_dragon_tiger_tie", "總和龍虎"),
    SUM("sum", "和值"),
    //    中發白
    ZBF("zfb", "方位"),
    //    方位
    FW("fw", "东南西北"),
    MANTISSA_BIG_SMALL("mantissa_big_small", "尾数大小"),

    DRAGON_TIGER_TIE("dragon_tiger_tie", "龍虎和"),
    ONE_FIRST_THREE("one_first_three", "前三"),
    ONE_IN_THREE("one_in_three", "中三"),
    ONE_AFTER_THREE("one_after_three", "後三"),


    CONTINUOUS_CODE_RENXUAN_2("continuous_code_renxuan_2", "連碼-任選二"),
    CONTINUOUS_CODE_LIANZHI_2("continuous_code_lianzhi_2", "連碼-選二連直"),
    CONTINUOUS_CODE_LIANZU_2("continuous_code_lianzu_2", "連碼-選二連組"),
    CONTINUOUS_CODE_RENXUAN_3("continuous_code_renxuan_3", "連碼-任選三"),
    CONTINUOUS_CODE_QINAZHI_3("continuous_code_qinazhi_3", "連碼-選三前直"),
    CONTINUOUS_CODE_QIANZU_3("continuous_code_qianzu_3", "連碼-選三前組"),
    CONTINUOUS_CODE_RENXUAN_4("continuous_code_renxuan_4", "連碼-任選四"),
    CONTINUOUS_CODE_RENXUAN_5("continuous_code_renxuan_5", "連碼-任選五"),






    CHAMPION_UP_SUM_3("champion_up_sum_3", "冠亚军和 3"),
    CHAMPION_UP_SUM_4("champion_up_sum_4", "冠亚军和 4"),
    CHAMPION_UP_SUM_5("champion_up_sum_5", "冠亚军和 5"),
    CHAMPION_UP_SUM_6("champion_up_sum_6", "冠亚军和 6"),
    CHAMPION_UP_SUM_7("champion_up_sum_7", "冠亚军和 7"),
    CHAMPION_UP_SUM_8("champion_up_sum_8", "冠亚军和 8"),
    CHAMPION_UP_SUM_9("champion_up_sum_9", "冠亚军和 9"),
    CHAMPION_UP_SUM_10("champion_up_sum_10", "冠亚军和 10"),
    CHAMPION_UP_SUM_11("champion_up_sum_11", "冠亚军和 11"),
    CHAMPION_UP_SUM_12("champion_up_sum_12", "冠亚军和 12"),
    CHAMPION_UP_SUM_13("champion_up_sum_13", "冠亚军和 13"),
    CHAMPION_UP_SUM_14("champion_up_sum_14", "冠亚军和 14"),
    CHAMPION_UP_SUM_15("champion_up_sum_15", "冠亚军和 15"),
    CHAMPION_UP_SUM_16("champion_up_sum_16", "冠亚军和 16"),
    CHAMPION_UP_SUM_17("champion_up_sum_17", "冠亚军和 17"),
    CHAMPION_UP_SUM_18("champion_up_sum_18", "冠亚军和 18"),
    CHAMPION_UP_SUM_19("champion_up_sum_19", "冠亚军和 19"),


    //1-8号码 end



    //連碼
    RENXUAN_2("renxuan_2", "連碼-任選二"),
    RENXUAN_3("renxuan_3", "連碼-任選三"),
    RENXUAN_4("renxuan_4", "連碼-任選四"),
    RENXUAN_5("renxuan_5", "連碼-任選五"),

    LIANZU_2("lianzu_2", "連碼-選二連組"),
    QIANZU_3("qianzu_3", "連碼-選三前組"),

    LIANZHI_2("lianzhi_2", "連碼-選二連直"),
    QINAZHI_3("qinazhi_3", "連碼-選三前直"),


    ;

    private String code;
    private String trans;

    LotteryPlayEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
