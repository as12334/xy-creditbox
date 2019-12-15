package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.ienums.ICodeEnum;
import org.soul.commons.lang.string.StringTool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shook on 17-4-9.
 */
public enum LotteryBettingEnum implements ICodeEnum {


//
//    //时时彩
//    SSC_ONE("ssc", "ten_thousand", "第一球"),
//    SSC_TWO("ssc", "thousand", "第二球"),
//    SSC_THREE("ssc", "hundred", "第三球"),
//    SSC_FOUR("ssc", "ten", "第四球"),
//    SSC_FIVE("ssc", "one", "第五球"),
//
//    SSC_SUM_DRAGON_TIGER("ssc", "ssc_sum_dragon_tiger", "總和、龍虎"),
//    SSC_ONE_COMBINATION("ssc", "ssc_one_combination", "（一字组合）前三、中三、後三"),
//


    //pk10
    RANK_ONE("rank_one", "冠军 第一名"),
    RANK_TWO("rank_two", "亚军 第二名"),
    RANK_THREE("rank_three", "季军 第三名"),
    RANK_FOUR("rank_four", "第四名"),
    RANK_FIVE("rank_five", "第五名"),
    RANK_SIX("rank_six", "第六名"),
    RANK_SEVEN("rank_seven", "第七名"),
    RANK_EIGHT("rank_eight", "第八名"),
    RANK_NINE("rank_nine", "第九名"),
    RANK_TEN("rank_ten", "第十名"),

    RANK_ONE_TWO_SUM("rank_one_two_sum", "冠亚军和"),
    RANK_ONE_TWO_SUM_BIG_SMALL("rank_one_two_sum_big_small", "冠亚军和 大小"),
    RANK_ONE_TWO_SUM_SINGLE_DOUBLE("rank_one_two_sum_single_double", "冠亚军和 單雙"),

    ONE_FIRST_THREE("one_first_three", "前三"),
    ONE_IN_THREE("one_in_three", "中三"),
    ONE_AFTER_THREE("one_after_three", "後三"),




    SUM("sum", "总和"),
    SUM_BIG_SMALL("sum_big_small", "总和大小"),
    SUM_SINGLE_DOUBLE("sum_single_double", "总和單雙"),
    SUM_MANTISSA_BIG_SMALL("sum8_mantissa_big_small", "总和尾数大小"),
    SUM_DRAGON_TIGER_TIE("sum_dragon_tiger_tie", "總和龍虎和"),
    CONTINUOUS_CODE("sfc_continuous_code", "連碼"),


    CONTINUOUS_CODE_RENXUAN_2("continuous_code_renxuan_2", "連碼-任選二"),
    CONTINUOUS_CODE_LIANZHI_2("continuous_code_lianzhi_2", "連碼-選二連直"),
    CONTINUOUS_CODE_LIANZU_2("continuous_code_lianzu_2", "連碼-選二連組"),
    CONTINUOUS_CODE_RENXUAN_3("continuous_code_renxuan_3", "連碼-任選三"),
    CONTINUOUS_CODE_QINAZHI_3("continuous_code_qinazhi_3", "連碼-選三前直"),
    CONTINUOUS_CODE_QIANZU_3("continuous_code_qianzu_3", "連碼-選三前組"),
    CONTINUOUS_CODE_RENXUAN_4("continuous_code_renxuan_4", "連碼-任選四"),
    CONTINUOUS_CODE_RENXUAN_5("continuous_code_renxuan_5", "連碼-任選五"),



    ;
    private String code;
    private String trans;

    LotteryBettingEnum (String code, String trans) {
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
