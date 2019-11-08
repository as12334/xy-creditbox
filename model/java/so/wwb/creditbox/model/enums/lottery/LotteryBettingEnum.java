package so.wwb.creditbox.model.enums.lottery;

import org.soul.commons.enums.ICodeEnum;
import org.soul.commons.lang.string.StringTool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shook on 17-4-9.
 */
public enum LotteryBettingEnum implements ICodeEnum {



    //时时彩
    SSC_ONE("ssc", "1", "第一球"),
    SSC_TWO("ssc", "4", "第二球"),
    SSC_THREE("ssc", "7", "第三球"),
    SSC_FOUR("ssc", "10", "第四球"),
    SSC_FIVE("ssc", "13", "第五球"),

    SSC_SUM_BIG_SMALL("ssc", "16", "總和大小"),
    SSC_SUM_SINGLE_DOUBLE("ssc", "17", "總和单双"),
    SSC_DRAGON_TIGER_SUM("ssc", "18", "龍虎和"),
    SSC_TEN_THOUSAND_THOUSAND_HUNDRED("ssc", "19", "前三"),
    SSC_THOUSAND_HUNDRED_TEN("ssc", "20", "中三"),
    SSC_HUNDRED_TEN_ONE("ssc", "21", "後三"),




    //pk10
    CHAMPION("pk10", "champion", "冠军"),
    RUNNER_UP("pk10", "runner_up", "亚军"),
    THIRD_RUNNER("pk10", "third_runner", "季军"),
    FOURTH_RUNNER("pk10", "fourth_place", "第四名"),
    FIFTH_RUNNER("pk10", "fifth_place", "第五名"),
    SIXTH_RUNNER("pk10", "sixth_place", "第六名"),
    SEVENTH_RUNNER("pk10", "seventh_place", "第七名"),
    EIGHTH_RUNNER("pk10", "eighth_place", "第八名"),
    NINTH_RUNNER("pk10", "ninth_place", "第九名"),
    TENTH_RUNNER("pk10", "tenth_place", "第十名"),
    CHAMPION_UP_SUM("pk10", "champion_up_sum", "冠亚军和"),
    CHAMPION_UP_DAXIAODANSHUANG("pk10", "champion_up_daxiaodanshuang", "冠亚大小單雙"),

    //十分彩(重庆幸运农场,广东快乐十分)
    SFC_FIRST("sfc", "sfc_first", "第一球"),
    SFC_SECOND("sfc", "sfc_second", "第二球"),
    SFC_THIRD("sfc", "sfc_third", "第三球"),
    SFC_FOURTH("sfc", "sfc_fourth", "第四球"),
    SFC_FIFTH("sfc", "sfc_fifth", "第五球"),
    SFC_SIXTH("sfc", "sfc_sixth", "第六球"),
    SFC_SEVENTH("sfc", "sfc_seventh", "第七球"),
    SFC_EIGHTH("sfc", "sfc_eighth", "第八球"),
    SFC_SUM8("sfc", "sfc_sum8", "总和"),
    SFC_SUM_DRAGON_TIGER("sfc", "sfc_sum_dragon_tiger", "總和、龍虎"),
    SFC_CONTINUOUS_CODE("sfc", "sfc_continuous_code", "連碼"),

    //六合彩
    SPECIAL("lhc", "special", "特码"),
    SPECIAL_A("lhc", "special_a", "特码A盘"),
    SPECIAL_B("lhc", "special_b", "特码B盘"),
    SEVEN_SUM("lhc", "seven_sum", "总和"),
    POSITIVE("lhc", "positive", "正码"),
    POSITIVE_FIRST("lhc", "positive_first", "正码一"),
    POSITIVE_SECOND("lhc", "positive_second", "正码二"),
    POSITIVE_THIRD("lhc", "positive_third", "正码三"),
    POSITIVE_FOURTH("lhc", "positive_fourth", "正码四"),
    POSITIVE_FIFTH("lhc", "positive_fifth", "正码五"),
    POSITIVE_SIXTH("lhc", "positive_sixth", "正码六"),
    LHC_HALF_COLOUR("lhc", "lhc_half_colour", "半波"),
    LHC_ONE_ZODIAC("lhc", "lhc_one_zodiac", "一肖"),

    LHC_FOUR_ALL_IN("lhc", "lhc_four_all_in", "四全中"),
    LHC_THREE_ALL_IN("lhc", "lhc_three_all_in", "三全中"),
    LHC_THREE_IN_TWO("lhc", "lhc_three_in_two", "三中二"),
    LHC_TWO_ALL_IN("lhc", "lhc_two_all_in", "二全中"),
    LHC_TWO_IN_SPECIAL("lhc", "lhc_two_in_special", "二中特"),
    LHC_SPECIAL_STRAND("lhc", "lhc_special_strand", "特串"),
    LHC_TWO_ZODIAC("lhc", "lhc_two_zodiac", "二肖"),
    LHC_THREE_ZODIAC("lhc", "lhc_three_zodiac", "三肖"),
    LHC_FOUR_ZODIAC("lhc", "lhc_four_zodiac", "四肖"),
    LHC_FIVE_ZODIAC("lhc", "lhc_five_zodiac", "五肖"),
    LHC_SIX_ZODIAC("lhc", "lhc_six_zodiac", "六肖"),
    LHC_SEVEN_ZODIAC("lhc", "lhc_seven_zodiac", "七肖"),
    LHC_EIGHT_ZODIAC("lhc", "lhc_eight_zodiac", "八肖"),
    LHC_NINE_ZODIAC("lhc", "lhc_nine_zodiac", "九肖"),
    LHC_TEN_ZODIAC("lhc", "lhc_ten_zodiac", "十肖"),
    LHC_ELEVEN_ZODIAC("lhc", "lhc_eleven_zodiac", "十一肖"),
    LHC_TWO_ZODIAC_LINK("lhc", "lhc_two_zodiac_link", "二肖连"),
    LHC_THREE_ZODIAC_LINK("lhc", "lhc_three_zodiac_link", "三肖连"),
    LHC_FOUR_ZODIAC_LINK("lhc", "lhc_four_zodiac_link", "四肖连"),
    LHC_FIVE_ZODIAC_LINK("lhc", "lhc_five_zodiac_link", "五肖连"),
    LHC_TWO_MANTISSA_LINK("lhc", "lhc_two_mantissa_link", "二尾连"),
    LHC_THREE_MANTISSA_LINK("lhc", "lhc_three_mantissa_link", "三尾连"),
    LHC_FOUR_MANTISSA_LINK("lhc", "lhc_four_mantissa_link", "四尾连"),
    LHC_FIVE_MANTISSA_LINK("lhc", "lhc_five_mantissa_link", "五尾连"),
    LHC_FIVE_NO_IN("lhc", "lhc_five_no_in", "五不中"),
    LHC_SIX_NO_IN("lhc", "lhc_six_no_in", "六不中"),
    LHC_SEVEN_NO_IN("lhc", "lhc_seven_no_in", "七不中"),
    LHC_EIGHT_NO_IN("lhc", "lhc_eight_no_in", "八不中"),
    LHC_NINE_NO_IN("lhc", "lhc_nine_no_in", "九不中"),
    LHC_TEN_NO_IN("lhc", "lhc_ten_no_in", "十不中"),
    LHC_ELEVEN_NO_IN("lhc", "lhc_eleven_no_in", "十一不中"),
    LHC_TWELVE_NO_IN("lhc", "lhc_twelve_no_in", "十二不中"),



    ;
    private String type;
    private String code;
    private String trans;

    LotteryBettingEnum(String type, String code, String trans) {
        this.type = type;
        this.code = code;
        this.trans = trans;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public static String getTransByCode(String code) {
        String trans = "";
        if (StringTool.isNotEmpty(code)) {
            for (LotteryBettingEnum lotteryBet : LotteryBettingEnum.values()) {
                if (code.equals(lotteryBet.getCode())) {
                    trans = lotteryBet.getTrans();
                    break;
                }
            }
        }
        return trans;
    }
}
