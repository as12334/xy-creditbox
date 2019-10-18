package so.wwb.lotterybox.lottery;

import org.soul.commons.collections.MapTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.lotterybox.model.company.lottery.po.LotteryOddSet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

/**
 * Create by Fei on 2018-02-13
 */
public final class BetNumTool {

    public static DecimalFormat BONUS = new DecimalFormat("#0.000");

    /**
     * 获取的官方玩法对应的betNum值
     * @param betOrder 投注记录
     * @param oddMap 赔率
     * @return betNum
     */
    public static String getOfficialBetNum(LotteryBetOrder betOrder, Map<String, LotteryOddSet> oddMap){
        String betNum = null;

        String betCode = betOrder.getBetCode();
        // 二不同
        if (LotteryBettingEnum.K3_ERBUTONG.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.TWO_DIFFERENT.getCode();
        }
        // 三不同
        else if (LotteryBettingEnum.K3_SANBUTONG.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.THREE_DIFFERENT.getCode();
        }
        // 通选
        else if (LotteryTool.isGeneral(betCode)) {
            betNum = LotteryBetNumEnum.GENERAL.getCode();
        }
        // 复选
        else if (LotteryBettingEnum.K3_FUXUAN_ERTONG.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.CHECK.getCode();
        }
        // 单选
        else if (LotteryTool.isRadio(betCode)) {
            betNum = LotteryBetNumEnum.RADIO.getCode();
        }
        // 复式
        else if (LotteryTool.isDuplex(betCode)) {
            betNum = LotteryBetNumEnum.DUPLEX.getCode();
        }
        // 单式
        else if (LotteryTool.isSingle(betCode)) {
            betNum = LotteryBetNumEnum.SINGLE.getCode();
        }
        // 直选和值
        else if (LotteryTool.isSum(betCode)) {
            betNum = LotteryBetNumEnum.SUM.getCode();
        }
        // 跨度
        else if (LotteryTool.isSpan(betCode)) {
            betNum = LotteryBetNumEnum.SPAN.getCode();
        }
        // 和尾
        else if (LotteryTool.isSumTail(betCode)) {
            betNum = LotteryBetNumEnum.SUM_MANTISSA.getCode();
        }
        // 特殊号
        else if (LotteryTool.isSpecial(betCode)) {
            String[] betNums = betOrder.getBetNum().split("\\|");
            switch (betNums.length) {
                case 3: {
                    LotteryOddSet odd = getLotteryOdd(oddMap, betCode, betNums[2]);
                    if (odd == null) return null;
                    betOrder.setOdd3(calcOdd(betOrder, odd));
                }
                case 2: {
                    LotteryOddSet odd = getLotteryOdd(oddMap, betCode, betNums[1]);
                    if (odd == null) return null;
                    betOrder.setOdd2(calcOdd(betOrder, odd));
                }
                case 1: {
                    betNum = betNums[0];
                    break;
                }
                default: {
                    break;
                }
            }
        }
        // 混合组选 组选和值 组选包胆
        else if (LotteryTool.isCombine(betCode)) {
            LotteryOddSet odd = getLotteryOdd(oddMap, betCode, LotteryBetNumEnum.THREE_GROUP6.getCode());
            if (odd == null) return null;
            betOrder.setOdd2(calcOdd(betOrder, odd));
            betNum = LotteryBetNumEnum.THREE_GROUP3.getCode();
        }
        // 三星直选组合
        else if (LotteryTool.is3Combine(betCode)) {
            LotteryOddSet odd = getLotteryOdd(oddMap, betCode, LotteryBetNumEnum.TWO_STAR.getCode());
            if (odd == null) return null;
            betOrder.setOdd2(calcOdd(betOrder, odd));

            odd = getLotteryOdd(oddMap, betCode, LotteryBetNumEnum.ONE_STAR.getCode());
            if (odd == null) return null;
            betOrder.setOdd3(calcOdd(betOrder, odd));
            betNum = LotteryBetNumEnum.THREE_STAR.getCode();
        }
        // 定位胆
        else if (LotteryTool.isLocation(betCode)) {
            betNum = LotteryBetNumEnum.POSITION_BILE.getCode();
        }
        // 任选四组选24
        else if (LotteryBettingEnum.SSC_RENXUAN4_ZX24.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.TWENTY_FOUR.getCode();
        }
        // 任选四组选12
        else if (LotteryBettingEnum.SSC_RENXUAN4_ZX12.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.TWELVE.getCode();
        }
        // 任选四组选6
        else if (LotteryBettingEnum.SSC_RENXUAN4_ZX6.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.SIX.getCode();
        }
        // 任选四组选4
        else if (LotteryBettingEnum.SSC_RENXUAN4_ZX4.getCode().equals(betCode)) {
            betNum = LotteryBetNumEnum.FOUR.getCode();
        }
        // 一码不定位
        else if (LotteryTool.isOneCode(betCode)) {
            betNum = "1";
        }
        // 二码不定位
        else if (LotteryTool.isTwoCode(betCode)) {
            betNum = "2";
        }
        // 三码不定位
        else if (LotteryBettingEnum.SSC_BUDINGWEI_WXSM.getCode().equals(betCode)) {
            betNum = "3";
        }
        // 胆拖
        else if (LotteryTool.is11X5CountDt(betCode)) {
            betNum = LotteryBetNumEnum.DANTUO.getCode();
        }
        // todo 暂定
        else if (LotteryTool.isSingleDouble(betCode)) {
            betNum = String.valueOf(betOrder.getBetNum().split("\\|").length);
        }
        return betNum;
    }

    /**
     * 计算赔率
     * @param betOrder 返点
     * @param odd 赔率，基数
     */
    public static Double calcOdd(LotteryBetOrder betOrder, LotteryOddSet odd) {
        return new Double(BONUS.format((new BigDecimal(String.valueOf(odd.getOdd() - odd.getBaseNum() *
                betOrder.getRebate()))).setScale(3, BigDecimal.ROUND_DOWN)));
    }

    /**
     * 获取赔率
     * @param betCode 投注玩法
     * @param betNum 投注号码
     */
    private static LotteryOddSet getLotteryOdd(Map<String, LotteryOddSet> oddMap, String betCode, String betNum) {
        return oddMap.get(CacheKey.getCacheKey(betCode, betNum));
    }

    /**
     * 获取的传统玩法对应的betNum值
     */
    public static String getTraditionBetNum(LotteryBetOrder betOrder, Map<String, LotteryOddSet> oddMap){
        String betNum;
        String betCode = betOrder.getBetCode();
        String playCode = betOrder.getPlayCode();
        // 选5：类似选5中5、选5中4
        if (LotteryPlayEnum.KENO_SELECTION_FIVE.getCode().equals(playCode)) {
            betOrder.setOdd2(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.SELECTION_FIVE_WIN_FOUR.getCode())).getOdd());
            betOrder.setOdd3(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.SELECTION_FIVE_WIN_THREE.getCode())).getOdd());
            betNum = LotteryBetNumEnum.SELECTION_FIVE_WIN_FIVE.getCode();
        } else if (LotteryPlayEnum.KENO_SELECTION_FOUR.getCode().equals(playCode)) {//选4
            betOrder.setOdd2(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.SELECTION_FOUR_WIN_THREE.getCode())).getOdd());
            betOrder.setOdd3(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.SELECTION_FOUR_WIN_TWO.getCode())).getOdd());
            betNum = LotteryBetNumEnum.SELECTION_FOUR_WIN_FOUR.getCode();
        } else if (LotteryPlayEnum.KENO_SELECTION_THREE.getCode().equals(playCode)) { //选3
            betOrder.setOdd2(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.SELECTION_THREE_WIN_TWO.getCode())).getOdd());
            betNum = LotteryBetNumEnum.SELECTION_THREE_WIN_THREE.getCode();
        } else if (LotteryPlayEnum.KENO_SELECTION_TWO.getCode().equals(playCode)) { // 选二
            betNum = LotteryBetNumEnum.SELECTION_TWO.getCode();
        } else if (LotteryPlayEnum.KENO_SELECTION_ONE.getCode().equals(playCode)) { // 选一
            betNum = LotteryBetNumEnum.SELECTION_ONE.getCode();
        }
        // 组选三 组选6
        else if (LotteryBettingEnum.PL3_GROUP3.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_FIRST_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP3_IN_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_AFTER_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP6_FIRST_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP6_IN_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP6_AFTER_THREE.getCode().equals(betCode) || LotteryBettingEnum.PL3_GROUP6.getCode().equals(betCode)) {
            betNum = String.valueOf(betOrder.getBetNum().split(",").length);
        } else if (LotteryPlayEnum.PL3_TWO_DIGITAL.getCode().equals(playCode) || LotteryPlayEnum.TWO_DIGITAL.getCode().equals(playCode)) { //二字定位
            betNum = LotteryBetNumEnum.WIN_TWO.getCode();
        } else if (LotteryPlayEnum.PL3_THREE_DIGITAL.getCode().equals(playCode) || LotteryPlayEnum.THREE_DIGITAL.getCode().equals(playCode)) { //三字定位
            betNum = LotteryBetNumEnum.WIN_THREE.getCode();
        } else if (LotteryBettingEnum.PL3_TWO_SAME.getCode().equals(betCode)) {//二字组合：二同
            betNum = LotteryBetNumEnum.TWO_SAME.getCode();
        } else if (LotteryBettingEnum.PL3_TWO_DIFFERENT.getCode().equals(betCode)) {//二字组合：二不同
            betNum = LotteryBetNumEnum.TWO_DIFFERENT.getCode();
        } else if (LotteryBettingEnum.PL3_THREE_SAME.getCode().equals(betCode)) {//三字组合：三同
            betNum = LotteryBetNumEnum.THREE_SAME.getCode();
        } else if (LotteryBettingEnum.PL3_THREE_GROUP3.getCode().equals(betCode)) {//三字组合：组三
            betNum = LotteryBetNumEnum.THREE_GROUP3.getCode();
        } else if (LotteryBettingEnum.PL3_THREE_GROUP6.getCode().equals(betCode)) {//三字组合：组六
            betNum = LotteryBetNumEnum.THREE_GROUP6.getCode();
        } else if (LotteryPlayEnum.XY28_SUM3_DIGITAL_THREE.getCode().equals(playCode)) {//特码包三
            betNum = LotteryBetNumEnum.SUM3_DIGITAL_THREE.getCode();
        } else if (LotteryPlayEnum.LHC_THREE_IN_TWO.getCode().equals(playCode)) {//三中二
            betOrder.setOdd2(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.WIN_THREE.getCode())).getOdd());
            betNum = LotteryBetNumEnum.WIN_TWO.getCode();
        } else if (LotteryPlayEnum.LHC_TWO_IN_SPECIAL.getCode().equals(playCode)) {//二中特
            betOrder.setOdd2(oddMap.get(CacheKey.getCacheKey(betCode, LotteryBetNumEnum.WIN_TWO.getCode())).getOdd());
            betNum = LotteryBetNumEnum.WIN_SPECIAL.getCode();
        }
        // 四全中,三全中,二全中,特串,合肖,全不中,
        else if (LotteryPlayEnum.LHC_FOUR_ALL_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_THREE_ALL_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TWO_ALL_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SPECIAL_STRAND.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_SUM_ZODIAC.getCode().equals(playCode) || LotteryPlayEnum.LHC_FIVE_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_SIX_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SEVEN_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_EIGHT_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_NINE_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TEN_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_ELEVEN_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TWELVE_NO_IN.getCode().equals(playCode)) {
            betNum = String.valueOf(betOrder.getBetNum().split(",").length);
        }
        // 连肖,尾数连
        else if (LotteryPlayEnum.LHC_TWO_ZODIAC_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FIVE_ZODIAC_LINK.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_THREE_ZODIAC_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FOUR_ZODIAC_LINK.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TWO_MANTISSA_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FIVE_MANTISSA_LINK.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_THREE_MANTISSA_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FOUR_MANTISSA_LINK.getCode().equals(playCode)) {
            betNum = getLhcBetNum(betOrder.getBetNum(), oddMap, betCode);
        }
        // 设置六合彩A盘返点
        else if (LotteryBettingEnum.SPECIAL_A.getCode().equals(betCode)) {
            betNum = betOrder.getBetNum();
            betOrder.setRebate(getLhcSpecialARebate(oddMap, betCode, betNum));
        } else {
            betNum = betOrder.getBetNum();
        }
        if (LotteryPlayEnum.LHC_FOUR_ALL_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_THREE_ALL_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TWO_ALL_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SPECIAL_STRAND.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_THREE_IN_TWO.getCode().equals(playCode) || LotteryPlayEnum.LHC_TWO_IN_SPECIAL.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_FIVE_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_SIX_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SEVEN_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_EIGHT_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_NINE_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TEN_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_ELEVEN_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_TWELVE_NO_IN.getCode().equals(playCode) ||
                LotteryBettingEnum.PL3_GROUP3.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_FIRST_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP3_IN_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_AFTER_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP6_FIRST_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP6_IN_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP6_AFTER_THREE.getCode().equals(betCode) || LotteryBettingEnum.PL3_GROUP6.getCode().equals(betCode)) {
            String[] betContent = betOrder.getBetNum().split(",");
            Arrays.sort(betContent);
            betOrder.setBetNum(StringTool.join(",",betContent));
        }
        return betNum;
    }

    /**
     * 获取赔率最低的注单号码-针对六合彩连肖,尾数连
     */
    private static String getLhcBetNum(String oldBetNum, Map<String, LotteryOddSet> oddMap, String betCode){
        String result = null;
        if(StringTool.isNotEmpty(oldBetNum)){
            String[] oldBetNums = StringTool.split(oldBetNum,",");
            if(oldBetNums != null && oldBetNums.length != 0){
                Double minValue = null;
                for(String betNum : oldBetNums){
                    if(StringTool.isNotEmpty(betNum)){
                        LotteryOddSet odd = oddMap.get(CacheKey.getCacheKey(betCode, betNum.trim()));
                        if(odd != null){
                            if(minValue == null || minValue > odd.getOdd()){
                                minValue = odd.getOdd();
                                result = odd.getBetNum();
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 获取六合彩A盘返点
     * @param oddMap
     * @param betCode
     * @param betNum
     */
    private static Double getLhcSpecialARebate(Map<String, LotteryOddSet> oddMap, String betCode, String betNum) {
        if (MapTool.isNotEmpty(oddMap)) {
            LotteryOddSet oddSet = oddMap.get(betCode + ":" + betNum);
            if (oddSet != null) {
                return oddSet.getRebate();
            }
        }
        return 0.0d;
    }

}
