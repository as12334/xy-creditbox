package so.wwb.creditbox.model.enums.lottery;
import org.soul.commons.ienums.ICodeEnum;

public enum LotteryPlayEnum implements ICodeEnum {

    //时时彩

    SSC_DIGITAL("ssc", "ssc_digital", "一字定位"),
    SSC_BIG_SMALL("ssc", "ssc_big_small", "大小"),
    SSC_SINGLE_DOUBLE("ssc", "ssc_single_double", "單雙"),

    SSC_SUM8("sfc","ssc_sum8", "和值"),
    SSC_SUM_BIG_SMALL("ssc", "ssc_sum_big_small", "總和大小"),
    SSC_SUM_SINGLE_DOUBLE("ssc", "ssc_sum_single_double", "總和單雙"),


    SSC_DRAGON_TIGER_TIE("ssc", "ssc_dragon_tiger_tie", "龍虎和"),

    SSC_ONE_FIRST_THREE("ssc", "ssc_one_first_three", "前三"),
    SSC_ONE_IN_THREE("ssc", "ssc_one_in_three", "中三"),
    SSC_ONE_AFTER_THREE("ssc", "ssc_one_after_three", "後三"),





    //pk10
    PK10_DIGITAL("pk10", "pk10_digital", "定位"),
    PK10_BIG_SMALL("pk10", "pk10_big_small", "大小"),
    PK10_SINGLE_DOUBLE("pk10", "pk10_single_double", "單雙"),
    PK10_DRAGON_TIGER("pk10", "pk10_dragon_tiger", "龍虎"),
    CHAMPION_UP_BIG_SMALL("pk10", "champion_up_big_small", "冠亚军和大小"),
    CHAMPION_UP_SINGLE_DOUBLE("pk10", "champion_up_single_double", "冠亚军和單雙"),



    CHAMPION_UP_SUM_3("pk10", "champion_up_sum_3", "冠亚军和 3"),
    CHAMPION_UP_SUM_4("pk10", "champion_up_sum_4", "冠亚军和 4"),
    CHAMPION_UP_SUM_5("pk10", "champion_up_sum_5", "冠亚军和 5"),
    CHAMPION_UP_SUM_6("pk10", "champion_up_sum_6", "冠亚军和 6"),
    CHAMPION_UP_SUM_7("pk10", "champion_up_sum_7", "冠亚军和 7"),
    CHAMPION_UP_SUM_8("pk10", "champion_up_sum_8", "冠亚军和 8"),
    CHAMPION_UP_SUM_9("pk10", "champion_up_sum_9", "冠亚军和 9"),
    CHAMPION_UP_SUM_10("pk10", "champion_up_sum_10", "冠亚军和 10"),
    CHAMPION_UP_SUM_11("pk10", "champion_up_sum_11", "冠亚军和 11"),
    CHAMPION_UP_SUM_12("pk10", "champion_up_sum_12", "冠亚军和 12"),
    CHAMPION_UP_SUM_13("pk10", "champion_up_sum_13", "冠亚军和 13"),
    CHAMPION_UP_SUM_14("pk10", "champion_up_sum_14", "冠亚军和 14"),
    CHAMPION_UP_SUM_15("pk10", "champion_up_sum_15", "冠亚军和 15"),
    CHAMPION_UP_SUM_16("pk10", "champion_up_sum_16", "冠亚军和 16"),
    CHAMPION_UP_SUM_17("pk10", "champion_up_sum_17", "冠亚军和 17"),
    CHAMPION_UP_SUM_18("pk10", "champion_up_sum_18", "冠亚军和 18"),
    CHAMPION_UP_SUM_19("pk10", "champion_up_sum_19", "冠亚军和 19"),

    //十分彩(重庆幸运农场,广东快乐十分)
    //1-8号码 start
    SFC_DIGITAL("sfc","sfc_digital", "定位"),
    SFC_BIG_SMALL("sfc","sfc_big_small", "大小"),
    SFC_SINGLE_DOUBLE("sfc","sfc_single_double", "單雙"),
    //    中發白
    SFC_ZBF("sfc","sfc_zfb", "方位"),
    //    方位
    SFC_FW("sfc","sfc_fw", "东南西北"),
    SFC_MANTISSA_BIG_SMALL("sfc","sfc_mantissa_big_small", "尾数大小"),
    SFC_SUM_SINGLE_DOUBLE("sfc","sfc_sum_single_double", "合数單雙"),
    SFC_DRAGON_TIGER("sfc", "sfc_dragon_tiger", "龍虎"),
    //1-8号码 end


    SFC_SUM8_BIG_SMALL("sfc","sfc_sum8_big_small", "总和大小"),
    SFC_SUM8_SINGLE_DOUBLE("sfc","sfc_sum8_single_double", "总和單雙"),
    SFC_SUM8_MANTISSA_BIG_SMALL("sfc","sfc_sum8_mantissa_big_small", "总和尾数大小"),
    SFC_SUM8_DRAGON_TIGER("sfc","sfc_sum8_dragon_tiger", "總和龍虎"),
    SFC_SUM8("sfc","sfc_sum8", "和值"),


    //連碼
    SFC_RENXUAN_2("sfc","sfc_renxuan_2", "連碼-任選二"),
    SFC_RENXUAN_3("sfc","sfc_renxuan_3", "連碼-任選三"),
    SFC_RENXUAN_4("sfc","sfc_renxuan_4", "連碼-任選四"),
    SFC_RENXUAN_5("sfc","sfc_renxuan_5", "連碼-任選五"),

    SFC_LIANZU_2("sfc","sfc_lianzu_2", "連碼-選二連組"),
    SFC_QIANZU_3("sfc","sfc_qianzu_3", "連碼-選三前組"),

    SFC_LIANZHI_2("sfc","sfc_lianzhi_2", "連碼-選二連直"),
    SFC_QINAZHI_3("sfc","sfc_qinazhi_3", "連碼-選三前直"),





    //六合彩
    SPECIAL_DIGITAL("lhc","special_digital", "特码"),
    SPECIAL_BIG_SMALL("lhc","special_big_small", "特码大小"),
    SPECIAL_SINGLE_DOUBLE("lhc","special_single_double", "特码單雙"),
    SPECIAL_HALF("lhc","special_half", "特码半特"),
    SPECIAL_SUM_BIG_SMALL("lhc","special_sum_big_small", "特码合数大小"),
    SPECIAL_SUM_SINGLE_DOUBLE("lhc","special_sum_single_double", "特码合数單雙"),
//    SPECIAL_MANTISSA("lhc","special_mantissa", "特码尾数"),
    SPECIAL_MANTISSA_BIG_SMALL("lhc","special_mantissa_big_small", "特码尾数大小"),
    SPECIAL_COLOUR("lhc","special_colour", "特码色波"),
    SEVEN_SUM_BIG_SMALL("lhc","seven_sum_big_small", "总和大小"),
    SEVEN_SUM_SINGLE_DOUBLE("lhc","seven_sum_single_double", "总和單雙"),
    POSITIVE_DIGITAL("lhc","positive_digital", "正码"),
    POSITIVE_SPECIAL_DIGITAL("lhc","positive_special_digital", "正码特"),
    POSITIVE_BIG_SMALL("lhc","positive_big_small", "正码1-6大小"),
    POSITIVE_SINGLE_DOUBLE("lhc","positive_single_double", "正码1-6單雙"),
    POSITIVE_COLOUR("lhc","positive_colour", "正码1-6色波"),
    POSITIVE_SUM_BIG_SMALL("lhc","positive_sum_big_small", "正码1-6合数大小"),
    POSITIVE_SUM_SINGLE_DOUBLE("lhc","positive_sum_single_double", "正码1-6合数單雙"),
    POSITIVE_MANTISSA_BIG_SMALL("lhc","positive_mantissa_big_small", "正码1-6尾数大小"),
    LHC_HALF_COLOUR_BIG_SMALL("lhc", "lhc_half_colour_big_small", "半波大小"),
    LHC_HALF_COLOUR_SINGLE_DOUBLE("lhc", "lhc_half_colour_single_double", "半波單雙"),
    LHC_SPECIAL_ZODIAC("lhc","special_zodiac", "特肖"),
    LHC_ONE_ZODIAC("lhc","lhc_one_zodiac", "一肖"),
    LHC_FOUR_ALL_IN("lhc","lhc_four_all_in", "四全中"),
    LHC_THREE_ALL_IN("lhc","lhc_three_all_in", "三全中"),
    LHC_THREE_IN_TWO("lhc","lhc_three_in_two", "三中二"),
    LHC_TWO_ALL_IN("lhc","lhc_two_all_in", "二全中"),
    LHC_TWO_IN_SPECIAL("lhc","lhc_two_in_special", "二中特"),
    LHC_SPECIAL_STRAND("lhc","lhc_special_strand", "特串"),
    LHC_SUM_ZODIAC("lhc","lhc_sum_zodiac", "合肖"),
    LHC_TWO_ZODIAC_LINK("lhc","lhc_two_zodiac_link", "二肖连"),
    LHC_THREE_ZODIAC_LINK("lhc","lhc_three_zodiac_link", "三肖连"),
    LHC_FOUR_ZODIAC_LINK("lhc","lhc_four_zodiac_link", "四肖连"),
    LHC_FIVE_ZODIAC_LINK("lhc","lhc_five_zodiac_link", "五肖连"),
    LHC_TWO_MANTISSA_LINK("lhc","lhc_two_mantissa_link", "二尾连"),
    LHC_THREE_MANTISSA_LINK("lhc","lhc_three_mantissa_link", "三尾连"),
    LHC_FOUR_MANTISSA_LINK("lhc","lhc_four_mantissa_link", "四尾连"),
    LHC_FIVE_MANTISSA_LINK("lhc","lhc_five_mantissa_link", "五尾连"),
    LHC_FIVE_NO_IN("lhc","lhc_five_no_in", "五不中"),
    LHC_SIX_NO_IN("lhc","lhc_six_no_in", "六不中"),
    LHC_SEVEN_NO_IN("lhc","lhc_seven_no_in", "七不中"),
    LHC_EIGHT_NO_IN("lhc","lhc_eight_no_in", "八不中"),
    LHC_NINE_NO_IN("lhc","lhc_nine_no_in", "九不中"),
    LHC_TEN_NO_IN("lhc","lhc_ten_no_in", "十不中"),
    LHC_ELEVEN_NO_IN("lhc","lhc_eleven_no_in", "十一不中"),
    LHC_TWELVE_NO_IN("lhc","lhc_twelve_no_in", "十二不中"),

    //快3
    POINTS_BIG_SMALL("k3","points_big_small", "点数大小"),
    POINTS_SINGLE_DOUBLE("k3","points_single_double", "点数單雙"),
    POINTS_318("k3","points_318", "点数[3,18]"),
    POINTS_417("k3","points_417", "点数[4,17]"),
    POINTS_516("k3","points_516", "点数[5,16]"),
    POINTS_615("k3","points_615", "点数[6,15]"),
    POINTS_714("k3","points_714", "点数[7,14]"),
    POINTS_813("k3","points_813", "点数[8,13]"),
    POINTS_912("k3","points_912", "点数[9,12]"),
    POINTS_1011("k3","points_1011", "点数[10,11]"),
    ARMED_FORCES("k3","armed_forces", "三军"),
    DICE("k3","dice", "围骰"),
    FULL_DICE("k3","full_dice", "全骰"),
    LONG_CARD("k3","long_card", "长牌"),
    SHORT_CARD("k3","short_card", "短牌"),
    K3_SAME_NUM("k3","k3_same_num", "同号"),
    K3_DIFF_NUM("k3","k3_diff_num", "不同号"),
    K3_THREE_STRAIGHT("k3","k3_three_straight", "三连号"),











    //快乐彩(幸运28,北京快乐8)
    KENO_SELECTION_ONE("keno","keno_selection_one", "选一"),
    KENO_SELECTION_TWO("keno","keno_selection_two", "选二"),
    KENO_SELECTION_THREE("keno","keno_selection_three", "选三"),
    KENO_SELECTION_FOUR("keno","keno_selection_four", "选四"),
    KENO_SELECTION_FIVE("keno","keno_selection_five", "选五"),
    KENO_SUM20_BIG_SMALL("keno","keno_sum20_big_small", "和值大小"),
    KENO_SUM20_SINGLE_DOUBLE("sfc","keno_sum20_single_double", "和值單雙"),
    KENO_SUM20_FIVE_ELEMENTS("keno","keno_sum20_elements", "五行"),
    KENO_UP_DOWN("keno","keno_up_down", "上中下"),
    KENO_ODD_EVEN("keno","keno_odd_even", "奇偶和"),

    XY28_SUM3_BIG_SMALL("keno","xy28_sum3_big_small", "大小"),
    XY28_SUM3_SINGLE_DOUBLE("keno","xy28_sum3_single_double", "單雙"),
    XY28_SUM3_HALF("keno","xy28_sum3_half", "半特"),
    XY28_SUM3_EXTREME("keno","xy28_sum3_extreme", "极值"),
    XY28_SUM3_COLOUR("keno","xy28_sum3_colour", "色波"),
    XY28_THREE_SAME("keno","xy28_three_same", "豹子"),
    XY28_SUM3_DIGITAL("keno","xy28_sum3_digital", "特码"),
    XY28_SUM3_DIGITAL_THREE("keno","xy28_sum3_digital_three", "特码包三"),
    //其他(福彩3D,体彩排列3)
    PL3_ONE_DIGITAL("pl3","pl3_one_digital", "一字定位"),
    PL3_ONE_BIG_SMALL("pl3","pl3_one_big_small", "一字大小"),
    PL3_ONE_SINGLE_DOUBLE("pl3","pl3_one_single_double", "一字單雙"),
    PL3_ONE_PRIME_COMBINED("pl3","pl3_one_prime_combined", "一字质合"),
    PL3_TWO_DIGITAL("pl3","pl3_two_digital", "二字定位"),
    PL3_THREE_DIGITAL("pl3","pl3_three_digital", "三字定位"),
    PL3_ONE_COMBINATION("pl3","pl3_one_combination", "一字组合"),
    PL3_TWO_COMBINATION("pl3","pl3_two_combination", "二字组合"),
    PL3_THREE_COMBINATION("qt","pl3_three_combination", "三字组合"),
    PL3_SUM2_DIGITAL("pl3","pl3_sum2_digital", "二字和数"),
    PL3_SUM2_SINGLE_DOUBLE("pl3","pl3_sum2_single_double", "二字和数單雙"),
    PL3_SUM2_MANTISSA("pl3","pl3_sum2_mantissa", "二字和数尾数"),
    PL3_SUM2_MANTISSA_BIG_SMALL("pl3","pl3_sum2_mantissa_big_small", "二字和数尾数大小"),
    PL3_SUM2_MANTISSA_PRIME_COMBINED("pl3","pl3_sum2_mantissa_prime_combined", "二字和数尾数质合"),
    PL3_SUM3_DIGITAL("pl3","pl3_sum3_digital", "三字和数"),
    PL3_SUM3_MANTISSA("pl3","pl3_sum3_mantissa", "三字和数尾数"),
    PL3_SUM3_BIG_SMALL("pl3","pl3_sum3_big_small", "三字和数大小"),
    PL3_SUM3_SINGLE_DOUBLE("pl3","pl3_sum3_single_double", "三字和数單雙"),
    PL3_SUM3_MANTISSA_BIG_SMALL("pl3","pl3_sum3_mantissa_big_small", "三字和数尾数大小"),
    PL3_SUM3_MANTISSA_PRIME_COMBINED("pl3","pl3_sum3_mantissa_prime_combined", "三字和数尾数质合"),
    PL3_GROUP_THREE("pl3","pl3_group_three", "组选三"),
    PL3_GROUP_SIX("pl3","pl3_group_six", "组选六"),
    PL3_SPAN("pl3","pl3_span", "跨度"),

    PL3_SANXING_ZHIXUAN("qt","pl3_sanxing_zhixuan", "三星直选"),
    PL3_SANXING_ZUXUAN("qt","pl3_sanxing_zuxuan", "三星组选"),
    PL3_ERXING_ZHIXUAN("qt","pl3_erxing_zhixuan", "二星直选"),
    PL3_ERXING_ZUXUAN("qt","pl3_erxing_zuxuan", "二星组选"),
    PL3_YIXING("qt","pl3_yixing", "定位胆"),
    PL3_BUDINGWEI_SANXING("qt","pl3_budingwei_sanxing", "三星不定位"),

    //十一选五(广东十一选五)
    //官方
    SYX5_ERNXUANDS("syx5","syx5_renxuands","任选單式"),
    SYX5_ERNXUANFS("syx5","syx5_renxuanfs","任选复式"),
    SYX5_ERNXUANDT("syx5","syx5_renxuandt","任选胆拖"),
    SYX5_SANXING_ZHIXUAN("syx5","syx5_sanxing_zhixuan","三星直选"),
    SYX5_SANXING_ZUXUAN("syx5","syx5_sanxing_zuxuan","三星组选"),
    SYX5_SANXING_BDW("syx5","syx5_sanxing_bdw","三星不定位"),
    SYX5_ERXING_ZHIXUAN("syx5","syx5_erxing_zhixuan","二星直选"),
    SYX5_ERXING_ZUXUAN("syx5","syx5_erxing_zuxuan","二星组选"),
    SYX5_YIXING("syx5","syx5_yixing","定位胆"),
    //传统
    SYX5_ONE_DIGITAL("syx5","syx5_one_digital", "一字定位"),
    SYX5_ONE_BIG_SMALL("syx5","syx5_one_big_small", "一字大小"),
    SYX5_ONE_SINGLE_DOUBLE("syx5v","syx5_one_single_double", "一字單雙"),
    SYX5_SUM_BIG_SMALL("syx5","syx5_sum_big_small", "总和大小"),
    SYX5_SUM_SINGLE_DOUBLE("syx5","syx5_sum_single_double", "总和單雙"),

    //PK10牛牛
    NN_LEVEL("nn","nn_level","平倍"),
    NN_MULTIPLE("nn","nn_multiple","翻倍"),

    //PK10百家乐
    BJL_DA_XIAO("bjl","bjl_da_xiao","大小"),
    BJL_DUI_ZI("bjl","bjl_dui_zi","对子"),
    BJL_ZHUANG_XIAN_HE("bjl","bjl_zhuang_xian_he","庄闲和")
    ;

    private String type;
    private String code;
    private String trans;

    LotteryPlayEnum(String type, String code, String trans) {
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
}
