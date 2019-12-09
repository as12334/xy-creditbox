package so.wwb.creditbox.model.enums.lottery;
import org.soul.commons.ienums.ICodeEnum;

/**
 * 彩票赔率bet_num枚举
 * Created by cherry on 17-8-16.
 */
public enum LotteryBetNumEnum implements ICodeEnum {
    SELECTION_ONE("选一", "选一"),
    SELECTION_TWO("选二", "选二"),
    SELECTION_THREE_WIN_THREE("选三-中3", "选三-中3"),
    SELECTION_THREE_WIN_TWO("选三-中2", "选三-中2"),
    SELECTION_FOUR_WIN_FOUR("选四-中4", "选四-中4"),
    SELECTION_FOUR_WIN_THREE("选四-中3", "选四-中3"),
    SELECTION_FOUR_WIN_TWO("选四-中2", "选四-中2"),
    SELECTION_FIVE_WIN_FIVE("选五-中5", "选五-中5"),
    SELECTION_FIVE_WIN_FOUR("选五-中4", "选五-中4"),
    SELECTION_FIVE_WIN_THREE("选五-中3", "选五-中3"),
    WIN_TWO("中2","中2"),
    WIN_THREE("中3","中3"),
    WIN_SPECIAL("中特","中特"),
    TWO_SAME("二同", "二同"),
    TWO_DIFFERENT("二不同", "二不同"),
    THREE_DIFFERENT("三不同", "三不同"),
    THREE_SAME("三同", "三同"),
    THREE_GROUP3("组三", "组三"),
    THREE_GROUP6("组六", "组六"),
    SUM3_DIGITAL_THREE("特码包三","特码包三"),

    DUPLEX("复式", "复式"),
    SINGLE("單式", "單式"),
    THREE_STAR("三星","三星"),
    TWO_STAR("二星","二星"),
    ONE_STAR("一星","一星"),
    SUM("和值", "和值"),
    SPAN("跨度", "跨度"),
    SUM_MANTISSA("和尾", "和尾"),
    LEOPARD("豹子", "豹子"),
    STRAIGHT("顺子", "顺子"),
    PAIR("对子", "对子"),
    POSITION_BILE("定位胆", "定位胆"),
    TWENTY_FOUR("24", "24"),
    TWELVE("12", "12"),
    SIX("6", "6"),
    FOUR("4", "4"),
    CHECK("复选", "复选"),
    RADIO("單选", "單选"),
    GENERAL("通选", "通选"),
    DANTUO("胆拖","胆拖"),

    //pk10百家乐
    BJL_XIAN("bjl_xian", "闲"),
    BJL_ZHUANG("bjl_zhuang", "庄"),
    BJL_HE("bjl_he", "和"),
    BJL_XIAN_DUI("bjl_xian_dui", "闲对"),
    BJL_ZHUANG_DUI("bjl_zhuang_dui", "庄对"),
    BJL_DA("bjl_da", "大"),
    BJL_XIAO("bjl_xiao", "小"),
    //pk10牛牛
    NN_XIAN_YI("nn_xian_yi", "闲一"),
    NN_XIAN_ER("nn_xian_er", "闲二"),
    NN_XIAN_SAN("nn_xian_san", "闲三"),
    NN_XIAN_SI("nn_xian_si", "闲四"),
    NN_XIAN_WU("nn_xian_wu", "闲五")
    ;
    private String code;
    private String trans;

    LotteryBetNumEnum(String code, String trans) {
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
