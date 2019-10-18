package so.wwb.creditbox.lottery;

import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;

/**
 * 彩票玩法工具
 * Create by Fei on 2018-02-13
 */
public final class LotteryTool {

    /** 六合彩生肖 */
    public final static String[] ZODIACS = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};

    /** 通选 */
    public static boolean isGeneral(String betCode) {
        return LotteryBettingEnum.K3_FUXUAN_SANTONG.getCode().equals(betCode) || LotteryBettingEnum.K3_TONGXUAN_SANLIAN.getCode().equals(betCode);
    }

    /** 单选 */
    public static boolean isRadio(String betCode) {
        return LotteryBettingEnum.K3_DANXUAN_ERTONG.getCode().equals(betCode) || LotteryBettingEnum.K3_DANXUAN_SANTONG.getCode().equals(betCode);
    }

    /** 复式 */
    public static boolean isDuplex(String betCode) {
        return LotteryBettingEnum.SSC_WUXING_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SIXING_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ3FS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZ6FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ3FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZ6FS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN4_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_Z3FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_Z6FS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN2_ZUXFS.getCode().equals(betCode) ||

                LotteryBettingEnum.PK10_ZHIXUAN_QYFS.getCode().equals(betCode) || LotteryBettingEnum.PK10_ZHIXUAN_QEFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PK10_ZHIXUAN_QSFS.getCode().equals(betCode) ||

                LotteryBettingEnum.PL3_SANXING_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_Z3FS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z6FS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZUXFS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_HEZUXFS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_QEZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZUXFS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWOFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEFS.getCode().equals(betCode)

                ;
    }

    /** 单式 */
    public static boolean isSingle(String betCode) {
        return LotteryBettingEnum.SSC_WUXING_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SIXING_ZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZ6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ3DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZ6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN4_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_ZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_Z3DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_Z6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN2_ZUXDS.getCode().equals(betCode) ||

                LotteryBettingEnum.PK10_ZHIXUAN_QEDS.getCode().equals(betCode) || LotteryBettingEnum.PK10_ZHIXUAN_QSDS.getCode().equals(betCode) ||

                LotteryBettingEnum.PL3_SANXING_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_Z6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z3DS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_ERXING_QEZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_QSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZXDS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_ERXING_QEZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZUXDS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDS.getCode().equals(betCode)
                ;
    }

    /** 直选和值 */
    public static boolean isSum(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSZXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_ZXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZUXHZ.getCode().equals(betCode) ||

                LotteryBettingEnum.PL3_SANXING_ZXHZ.getCode().equals(betCode);
    }

    /** 跨度 */
    public static boolean isSpan(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSZXKD.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZXKD.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXKD.getCode().equals(betCode);
    }

    /** 和尾 */
    public static boolean isSumTail(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSHZWS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSHZWS.getCode().equals(betCode);
    }

    /** 特殊号 */
    public static boolean isSpecial(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSTS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSTS.getCode().equals(betCode);
    }

    /** 混合组选 组选和值 组选包胆 */
    public static boolean isCombine(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_HHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXBD.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZXBD.getCode().equals(betCode) ||

                LotteryBettingEnum.PL3_SANXING_HHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZUXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZUXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_ZUXHZ.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_ZUXHZ.getCode().equals(betCode);
    }

    /** 三星直选组合 */
    public static boolean is3Combine(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_QSZXZH.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_HSZXZH.getCode().equals(betCode);
    }

    /** 定位胆 */
    public static boolean isLocation(String betCode) {
        return LotteryBettingEnum.SSC_YIXING_DWD.getCode().equals(betCode) ||
                LotteryBettingEnum.PK10_YIXING_DWD.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_YIXING_DWD.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_YIXING_DWD.getCode().equals(betCode)
                ;
    }

    /** 一码不定位 */
    public static boolean isOneCode(String betCode) {
        return LotteryBettingEnum.SSC_BUDINGWEI_Q4YM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_H4YM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_Q3YM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_H3YM.getCode().equals(betCode) ||

                LotteryBettingEnum.PL3_BUDINGWEI_SXYM.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_SANXING_QSBDW.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSBDW.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSBDW.getCode().equals(betCode)
                ;
    }

    /** 一码不定位 */
    public static boolean isTwoCode(String betCode) {
        return LotteryBettingEnum.SSC_BUDINGWEI_WXEM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_Q4EM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_H4EM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_Q3EM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_H3EM.getCode().equals(betCode);
    }

    /** 前二、前三单双 */
    public static boolean isSingleDouble(String betCode) {
        return LotteryBettingEnum.SSC_ERXING_QEZUXBD.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q3.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H3.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q2.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H2.getCode().equals(betCode);
    }

    /** 直选复式 */
    public static boolean isCountDuplex(String betCode) {
        return LotteryBettingEnum.SSC_WUXING_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SIXING_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZXFS.getCode().equals(betCode)
                ;
    }

    /** 直选单式 */
    public static boolean isCountSingle(String betCode) {
        return LotteryBettingEnum.SSC_WUXING_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SIXING_ZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ3DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_Z3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z6DS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_HHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZUXDS.getCode().equals(betCode)
                ;

    }

    /** 后三组合, 前三组合 */
    public static boolean isCountCombine(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZXZH.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXZH.getCode().equals(betCode);
    }

    /** 后三, 前三和值 */
    public static boolean isCountSum(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_ZXHZ.getCode().equals(betCode);
    }

    /** 后三，前三跨度*/
    public static boolean isCountSpan(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZXKD.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXKD.getCode().equals(betCode);
    }

    /** 后三, 前三组三复式 */
    public static boolean isCount3Duplex(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZ3FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ3FS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z3FS.getCode().equals(betCode);
    }

    /** 后三, 前三组六复式 */
    public static boolean isCount6Single(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZ6FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ6FS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z6FS.getCode().equals(betCode);
    }

    /** 后三, 前三组选和值 */
    public static boolean isCountCombSum(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZUXHZ.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZUXHZ.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_ZUXHZ.getCode().equals(betCode);
    }

    /** 后三, 前三组选包胆 */
    public static boolean isCountCombWrap(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSZXBD.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXBD.getCode().equals(betCode);
    }

    /** 后三, 前三和值尾数 */
    public static boolean isCountSumTail(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSHZWS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSHZWS.getCode().equals(betCode);
    }

    /** 后三, 前三特殊号 */
    public static boolean isCountSpecial(String betCode) {
        return LotteryBettingEnum.SSC_SANXING_HSTS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSTS.getCode().equals(betCode);
    }

    /** 定位胆 */
    public static boolean isCountLocation(String betCode) {
        return LotteryBettingEnum.SSC_YIXING_DWD.getCode().equals(betCode) || LotteryBettingEnum.PL3_YIXING_DWD.getCode().equals(betCode);
    }

    /** 五星二码不定位, 四星二码不定位, 三星二码不定位, 前2组选复式 */
    public static boolean isCountTwoCode(String betCode) {
        return LotteryBettingEnum.SSC_BUDINGWEI_WXEM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_Q4EM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_H4EM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_Q3EM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_H3EM.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZUXFS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZUXFS.getCode().equals(betCode);
    }

    /** 四星一码不定位,三星一码不定位 */
    public static boolean isCountOneCode(String betCode) {
        return LotteryBettingEnum.SSC_BUDINGWEI_Q4YM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_H4YM.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_BUDINGWEI_Q3YM.getCode().equals(betCode) || LotteryBettingEnum.SSC_BUDINGWEI_H3YM.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_BUDINGWEI_SXYM.getCode().equals(betCode);
    }

    /** 快3 */
    public static boolean isCountK3(String betCode) {
        return LotteryBettingEnum.K3_DANXUAN_ERTONG.getCode().equals(betCode) || LotteryBettingEnum.K3_FUXUAN_ERTONG.getCode().equals(betCode) ||
                LotteryBettingEnum.K3_DANXUAN_SANTONG.getCode().equals(betCode) || LotteryBettingEnum.K3_FUXUAN_SANTONG.getCode().equals(betCode) ||
                LotteryBettingEnum.K3_TONGXUAN_SANLIAN.getCode().equals(betCode) || LotteryBettingEnum.K3_ERBUTONG.getCode().equals(betCode) ||
                LotteryBettingEnum.K3_SANBUTONG.getCode().equals(betCode);
    }

    /** PK10 */
    public static boolean isCountPK10(String betCode) {
        return LotteryBettingEnum.PK10_ZHIXUAN_QYFS.getCode().equals(betCode) || LotteryBettingEnum.PK10_ZHIXUAN_QEFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PK10_YIXING_DWD.getCode().equals(betCode) || LotteryBettingEnum.PK10_ZHIXUAN_QSFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PK10_ZHIXUAN_QEDS.getCode().equals(betCode) || LotteryBettingEnum.PK10_ZHIXUAN_QSDS.getCode().equals(betCode);
    }

    /** 11选5 直选复式*/
    public static boolean isCountDuple11X5(String betCode) {
        return LotteryBettingEnum.SYX5_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZXFS.getCode().equals(betCode)
                ;
    }

    /** 11选5 单式*/
    public static boolean isCountSingle11X5(String betCode) {

        return LotteryBettingEnum.SYX5_ERXING_QEZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_QSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZXDS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_ERXING_QEZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZUXDS.getCode().equals(betCode) ||

                LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDS.getCode().equals(betCode)
                ;
    }

    /** 11选5 组选复式*/
    public static boolean isCountDupleZu11X5(String betCode) {
        return LotteryBettingEnum.SYX5_ERXING_QEZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZUXFS.getCode().equals(betCode)
                ;
    }
    /** 11选5 定位胆*/
    public static boolean is11X5CountDWD(String betCode) {
        return LotteryBettingEnum.SYX5_YIXING_DWD.getCode().equals(betCode);
    }

    /** 11选5 ,不定位，任选复式*/
    public static boolean is11X5Countrenxuan(String betCode) {
        return  LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWOFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSBDW.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSBDW.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSBDW.getCode().equals(betCode)
                ;
    }
    /** 11选5 ,胆拖*/
    public static boolean is11X5CountDt(String betCode) {
        return  LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_QEZUXDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZUXDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_QSZUXDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZUXDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZUXDT.getCode().equals(betCode)
                ;
    }
    /** 时时彩大小单双*/
    public static boolean isBigSmallSingleDouble (String betCode) {
        return LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q3.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H3.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q2.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H2.getCode().equals(betCode);
    }
    /** 时时彩任选直选复式*/
    public static boolean isSscRenxZhixFs (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN4_ZXFS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZXFS.getCode().equals(betCode);
    }
    /** 时时彩任选单式(直选，组选)*/
    public static boolean isSscRenxDs (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN4_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_ZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN2_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN2_ZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_Z3DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_Z6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_HHZX.getCode().equals(betCode);
    }

    /** 时时彩任选2直选和值*/
    public static boolean isSscRenxZhixErHz (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN2_ZXHZ.getCode().equals(betCode);
    }

    /** 时时彩任选2组选和值*/
    public static boolean isSscRenxZuxErHz (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN2_ZUXHZ.getCode().equals(betCode);
    }

    /** 时时彩任选2组选复式*/
    public static boolean isSscRenxZuxErFs (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN2_ZUXFS.getCode().equals(betCode);
    }
    /** 时时彩任选3直选和值*/
    public static boolean isSscRenxZhix3Hz (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN3_ZXHZ.getCode().equals(betCode);
    }
    /** 时时彩任选3直选和值*/
    public static boolean isSscRenxZux3Hz (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN3_ZUXHZ.getCode().equals(betCode);
    }
    /** 时时彩任选3组选复式*/
    public static boolean isSscRenx3ZuxFs (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN3_Z3FS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_Z6FS.getCode().equals(betCode);
    }
    /** 时时彩任选4组选*/
    public static boolean isSscRenx4Zux (String betCode) {
        return LotteryBettingEnum.SSC_RENXUAN4_ZX24.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN4_ZX12.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN4_ZX6.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN4_ZX4.getCode().equals(betCode);
    }
}
