package so.wwb.creditbox.lottery;

import org.apache.commons.lang3.ArrayUtils;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.math.NumberTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;

import java.util.*;

/**
 * Create by Fei on 2018-02-13
 */
public final class BetCountTool {

    /**
     * 获取实际投注单数
     *
     * @param betOrder 注单
     * @param betNum   投注号码
     * @return 投注数量
     */
    public static Integer getFactBetCount(LotteryBetOrder betOrder, String betNum) {

        // 实际下注注数
        Integer factBetCount = 0;
        String betCode = betOrder.getBetCode();

        // 复式
        if (LotteryTool.isCountDuplex(betCode)) {
            factBetCount = getBetCountByFs(betCode, betNum);
        }
        // 单式
        else if (LotteryTool.isCountSingle(betCode)) {
            factBetCount = getBetCountByDs(betCode, betNum);
        }
        // 针对后三组合, 前三组合
        else if (LotteryTool.isCountCombine(betCode)) {
            factBetCount = getBetCountByZh(betCode, betNum);
        }
        // 针对后三, 前三和值
        else if (LotteryTool.isCountSum(betCode)) {
            factBetCount = getBetCountByHz(betNum);
        }
        // 针对后三，前三跨度
        else if (LotteryTool.isCountSpan(betCode)) {
            factBetCount = getBetCountByKd(betNum);
        }
        // 针对后三, 前三组三复式
        else if (LotteryTool.isCount3Duplex(betCode)) {
            factBetCount = getBetCountByZ3fs(betNum);
        }
        // 针对后三, 前三组六复式
        else if (LotteryTool.isCount6Single(betCode)) {
            factBetCount = getBetCountByZ6fs(betNum);
        }
        // 针对后三, 前三组选和值
        else if (LotteryTool.isCountCombSum(betCode)) {
            factBetCount = getBetCountBySum(betNum);
        }
        // 针对后三, 前三组选包胆
        else if (LotteryTool.isCountCombWrap(betCode)) {
            factBetCount = getBetCountByWrap(betNum);
        }
        // 针对后三, 前三和值尾数
        else if (LotteryTool.isCountSumTail(betCode)) {
            factBetCount = getBetCountBySumTail(betNum);
        }
        // 针对后三, 前三特殊号
        else if (LotteryTool.isCountSpecial(betCode)) {
            factBetCount = getBetCountBySpecial(betNum);
        }
        // 针对前二直选和值
        else if (LotteryBettingEnum.SSC_ERXING_QEZXHZ.getCode().equals(betCode)) {
            factBetCount = getBetCountByQ2hz(betNum);
        }
        // 针对前二直选跨度
        else if (LotteryBettingEnum.SSC_ERXING_QEZXKD.getCode().equals(betCode)) {
            factBetCount = getBetCountByQ2kd(betNum);
        }
        // 针对前二组选和值
        else if (LotteryBettingEnum.SSC_ERXING_QEZUXHZ.getCode().equals(betCode)) {
            factBetCount = getBetCountByQ2Comb(betNum);
        }
        // 针对前二组选包胆
        else if (LotteryBettingEnum.SSC_ERXING_QEZUXBD.getCode().equals(betCode)) {
            factBetCount = getBetCountByQ2Wrap(betNum);
        }
        // 定位胆
        else if (LotteryTool.isCountLocation(betCode)) {
            factBetCount = getBetCountByDwd(betCode, betNum);
        }
        // 五星三码不定位
        else if (LotteryBettingEnum.SSC_BUDINGWEI_WXSM.getCode().equals(betCode)) {
            factBetCount = getBetCountByBdw(betNum, 3);
        }
        // 五星二码不定位, 四星二码不定位, 三星二码不定位, 前2组选复式
        else if (LotteryTool.isCountTwoCode(betCode)) {
            factBetCount = getBetCountByBdw(betNum, 2);
        }
        // 四星一码不定位,三星一码不定位
        else if (LotteryTool.isCountOneCode(betCode)) {
            factBetCount = getBetCountByBdw(betNum, 1);
        }
        // 快三
        else if (LotteryTool.isCountK3(betCode)) {
            factBetCount = getBetCountByK3All(betCode, betNum);
        }
        // PK10
        else if (LotteryTool.isCountPK10(betCode)) {
            factBetCount = getBetCountByPkAll(betCode, betNum);
        }
        // 11选5 直选复式
        else if (LotteryTool.isCountDuple11X5(betCode)) {
            factBetCount = get11X5BetCountByFs(betCode, betNum);
        }
        // 11选5 直选/组选/任选单式
        else if (LotteryTool.isCountSingle11X5(betCode)) {
            factBetCount = get11X5BetCountByDs(betCode, betNum);
        }
        // 11选5 组选复式
        else if (LotteryTool.isCountDupleZu11X5(betCode)) {
            factBetCount = getBetCountBy11X5fs(betCode, betNum);
        }
        // 11选5 定位胆
        else if (LotteryTool.is11X5CountDWD(betCode)) {
            factBetCount = get11X5BetCountByDwd(betNum);
        }
        // 11选5 三星不定位/任选
        else if (LotteryTool.is11X5Countrenxuan(betCode)) {
            factBetCount = get11X5BetCountByRenxBdw(betNum, betCode);
        }
        // 11选5 胆拖
        else if (LotteryTool.is11X5CountDt(betCode)) {
            factBetCount = get11X5BetCountByDt(betNum, betCode);
        }
        // 时时彩大小单双
        else if (LotteryTool.isBigSmallSingleDouble(betCode)) {
            factBetCount = getSscBigSmallSinDou(betCode, betNum);
        }
        // 时时彩任选直选复式
        else if (LotteryTool.isSscRenxZhixFs(betCode)) {
            factBetCount = getSscRenxZhixFs(betCode, betNum);
        }
        // 时时彩任选单式（直选,组选）
        else if (LotteryTool.isSscRenxDs(betCode)) {
            factBetCount = getSscRenxDsCount(betCode, betNum);
        }
        // 时时彩任选二直选和值
        else if (LotteryTool.isSscRenxZhixErHz (betCode)) {
            factBetCount = getSscRen2ZhixHz (betNum);
        }
        // 时时彩任选二组选和值
        else if (LotteryTool.isSscRenxZuxErHz (betCode)) {
            factBetCount = getSscRen2ZuxHz (betNum);
        }
        // 时时彩任选二组选复式
        else if (LotteryTool.isSscRenxZuxErFs (betCode)) {
            factBetCount = getSscRenx2ZuxFs (betNum);
        }
        // 时时彩任选3直选和值
        else if (LotteryTool.isSscRenxZhix3Hz (betCode)) {
            factBetCount = getSscRenx3ZhixHz (betNum);
        }
        // 时时彩任选3组选和值
        else if (LotteryTool.isSscRenxZux3Hz (betCode)) {
            factBetCount = getSscRenx3ZuxHz (betNum);
        }
        // 时时彩任选3组选组三复式
        else if (LotteryTool.isSscRenx3ZuxFs (betCode)) {
            factBetCount = getSscRenx3Zu36Fs (betNum,betCode);
        }
        // 时时彩任选4组选
        else if (LotteryTool.isSscRenx4Zux (betCode)) {
            factBetCount = getSscRenx4Zux (betNum, betCode);
        }
        return factBetCount;
    }

    /**
     * 复式投注单数
     */
    private static Integer getBetCountByFs(String betCode, String betNum) {
        Integer betCount = 0;

        Integer line = 0; // 拥有选择号码的行数
        if (LotteryBettingEnum.SSC_WUXING_ZXFS.getCode().equals(betCode)) {
            line = 5;
        } else if (LotteryBettingEnum.SSC_SIXING_ZXFS.getCode().equals(betCode)) {
            line = 4;
        } else if (LotteryBettingEnum.SSC_SANXING_HSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_QSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_ZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZXFS.getCode().equals(betCode)) {
            line = 3;
        } else if (LotteryBettingEnum.SSC_ERXING_QEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_HEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_QEZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZXFS.getCode().equals(betCode)) {
            line = 2;
        }

        String[] betNumArr = betNum.split("\\|");

        if (betNum.contains("|") && betNumArr.length == line) {
            if (!betNum.contains(",")) {    // 单注
                for (String num : betNumArr) {
                    if (NumberTool.isNumber(num) && num.length() == 1) {
                        betCount = 1;
                    } else {
                        return 0;
                    }
                }
            } else if (betNum.contains(",")) {  // 多注
                int[] tempArr = new int[line];
                int idx = 0;
                for (String num : betNumArr) {
                    int tempLine = 0;
                    // 行选择单个情况
                    if (!num.contains(",") && num.length() == 1 && NumberTool.isNumber(num)) {
                        tempLine = 1;
                    } else if (num.contains(",")) {
                        String[] tempNumArr = num.split(",");
                        if (tempNumArr.length > 0 && tempNumArr.length <= 10) {
                            for (String numStr : tempNumArr) {
                                if (NumberTool.isNumber(numStr) && numStr.length() == 1) {
                                    tempLine++;
                                } else {
                                    return 0;
                                }
                            }
                        }
                    }
                    tempArr[idx] = tempLine;
                    idx++;
                }
                if (tempArr.length == line) {
                    int temp = 0;
                    for (int betLine : tempArr) {
                        if (temp == 0 && betCount == 0) {
                            betCount = 1;
                        }
                        betCount = betCount * betLine;
                        temp++;
                    }
                }
            }
        }

        return betCount;
    }

    /**
     * 单式投注单数
     */
    private static Integer getBetCountByDs(String betCode, String betNum) {
        Integer betCount = 0;
        Integer line = 0;
        if (LotteryBettingEnum.SSC_WUXING_ZXDS.getCode().equals(betCode)) {
            line = 5;
        } else if (LotteryBettingEnum.SSC_SIXING_ZXDS.getCode().equals(betCode)) {
            line = 4;
        } else if (LotteryBettingEnum.SSC_SANXING_HSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ3DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSZ6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ6DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_Z3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_SANXING_Z6DS.getCode().equals(betCode) || LotteryBettingEnum.PL3_SANXING_HHZX.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_QSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZXDS.getCode().equals(betCode)
                ) {
            line = 3;
        } else if (LotteryBettingEnum.SSC_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_HEZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_QEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZXDS.getCode().equals(betCode)
                ) {
            line = 2;
        }

        if (!betNum.contains("|") && betNum.length() == line && isNumeric(betNum)) {// 单注
            if(LotteryBettingEnum.SSC_SANXING_HSZ3DS.getCode().equals(betCode)|| LotteryBettingEnum.SSC_SANXING_QSZ3DS.getCode().equals(betCode)||
                    LotteryBettingEnum.PL3_SANXING_Z3DS.getCode().equals(betCode)){
                if(isRepeatNum(betNum)==1){
                    betCount = 1;
                }else {
                    return 0;
                }
            }else if(LotteryBettingEnum.SSC_SANXING_HSZ6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ6DS.getCode().equals(betCode) ||
                    LotteryBettingEnum.PL3_SANXING_Z6DS.getCode().equals(betCode)){
                if(isRepeatNum(betNum)==0){
                    betCount = 1;
                }else {
                    return 0;
                }
            }else if( LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode().equals(betCode)||
                    LotteryBettingEnum.PL3_SANXING_HHZX.getCode().equals(betCode)){
                if(isRepeatNum(betNum)!=3){
                    betCount = 1;
                }else {
                    return 0;
                }
            }else if(LotteryBettingEnum.SSC_ERXING_QEZUXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZUXDS.getCode().equals(betCode) ||
                    LotteryBettingEnum.PL3_ERXING_HEZUXDS.getCode().equals(betCode)){
                if(isRepeatNum(betNum)!=1){
                    betCount = 1;
                }else {
                    return 0;
                }
            }else{
                betCount = 1;
            }
        } else if (betNum.contains("|")) { // 多注
            String[] betNumArr = betNum.split("\\|");
            if (isRepeat(betNumArr)) {
                return 0;
            }
            for (String num : betNumArr) {
                if (num.length() == line && isNumeric(num)){
                    if(LotteryBettingEnum.SSC_SANXING_HSZ3DS.getCode().equals(betCode)|| LotteryBettingEnum.SSC_SANXING_QSZ3DS.getCode().equals(betCode)||
                            LotteryBettingEnum.PL3_SANXING_Z3DS.getCode().equals(betCode)){
                        if(isRepeatNum(num)==1){
                            betCount = betNumArr.length;
                        }else {
                            return 0;
                        }
                    } else if(LotteryBettingEnum.SSC_SANXING_HSZ6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSZ6DS.getCode().equals(betCode) ||
                            LotteryBettingEnum.PL3_SANXING_Z6DS.getCode().equals(betCode)){
                        if(isRepeatNum(num)==0){
                            betCount = betNumArr.length;
                        } else {
                            return 0;
                        }
                    } else if( LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode().equals(betCode) || LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode().equals(betCode)||
                            LotteryBettingEnum.PL3_SANXING_HHZX.getCode().equals(betCode)){
                        if(isRepeatNum(num)!=3){
                            betCount = betNumArr.length;
                        } else {
                            return 0;
                        }
                    } else if(LotteryBettingEnum.SSC_ERXING_QEZUXDS.getCode().equals(betCode) || LotteryBettingEnum.PL3_ERXING_QEZUXDS.getCode().equals(betCode) ||
                            LotteryBettingEnum.PL3_ERXING_HEZUXDS.getCode().equals(betCode)){
                        if(isRepeatNum(num)!=1){
                            betCount = betNumArr.length;
                        } else {
                            return 0;
                        }
                    } else {
                        betCount = betNumArr.length;
                    }
                } else {
                    return 0;
                }
            }
        }
        return betCount;
    }

    private static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        //判断是否有全角文字
        return str.length() >= str.getBytes().length;
    }

    /**
     * 后三组合, 前三组合
     */
    private static Integer getBetCountByZh(String betCode, String betNum) {
        Integer betCount = 0;
        Integer line = 0;
        if (LotteryBettingEnum.SSC_SANXING_HSZXZH.getCode().equals(betCode)
                || LotteryBettingEnum.SSC_SANXING_QSZXZH.getCode().equals(betCode)) {
            line = 3;
        }

        String[] betNumArr = betNum.split("\\|");
        if (betNum.contains("|") && betNumArr.length == line) {
            int idx = 0;
            String[] temArr1 = null;
            String[] temArr2 = null;
            String[] temArr3 = null;
            for (String num : betNumArr) {
                String[] temArr = null;
                if (!num.contains(",") && num.length() == 1 && NumberTool.isNumber(num)) {  // 行选择单个情况
                    temArr = new String[1];
                    temArr[0] = num;
                } else if (num.contains(",")) {
                    String[] tempNumArr = num.split(",");
                    if (tempNumArr.length > 0 && tempNumArr.length <= 10) {
                        int tempIndex = 0;
                        for (String numStr : tempNumArr) {
                            if (NumberTool.isNumber(numStr) && numStr.length() == 1) {
                                temArr = new String[tempNumArr.length];
                                temArr[tempIndex] = numStr;
                                tempIndex++;
                            } else {
                                return 0;
                            }
                        }
                    }
                } else {
                    return 0;
                }

                if (idx == 0) {
                    temArr1 = temArr;
                } else if (idx == 1) {
                    temArr2 = temArr;
                } else if (idx == 2) {
                    temArr3 = temArr;
                }
                idx++;
            }
            if (isArrayNotEmpty(temArr1) && isArrayNotEmpty(temArr2) && isArrayNotEmpty(temArr3)) {
                ArrayList<Object> list = new ArrayList<>();
                for (String arr1 : temArr1) {
                    for (String arr2 : temArr2) {
                        for (String arr3 : temArr3) {
                            list.add(arr1 + "" + arr2 + "" + arr3);
                            list.add(arr2 + "" + arr3);
                            list.add(arr3);
                        }
                    }
                }
                betCount = list.size();
            }
        }
        return betCount;
    }

    /**
     * 判断数组是否为空
     */
    private static boolean isArrayNotEmpty(Object[] arr) {
        return arr != null && arr.length > 0;
    }

    /**
     * 后三, 前三和值
     */
    private static Integer getBetCountByHz(String betNum) {
        List<Integer> heZhiArr = new ArrayList<>();
        //分解号组合
        List<Object> splitNum = new ArrayList<>();
        int sumTemp;
        int num; // 当前号码

        String[] tempNumArr = betNum.split("\\|");
        if (!betNum.contains("|") && checkBetNumIsNumber(betNum, 0, 27, 1, false)) { // 单注
            heZhiArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains("|") && tempNumArr.length < 29 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 0, 27, 1, false)) {
                    heZhiArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        // 号码分解: 所选号分解成所有组合的值等于此号的所有组合
        for (Integer aHeZhiArr : heZhiArr) {
            List<Integer> temp = new ArrayList<>();
            sumTemp = aHeZhiArr;
            num = aHeZhiArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            // 所选号码分解至零，被分解出所有的号码三个为一组，所组成的所有组合的每一组值等于所选号的值的组合数
            for (int n = 0; n < temp.size(); n++) {
                for (int m = 0; m < temp.size(); m++) {
                    for (Integer aTemp : temp) {
                        if (temp.get(n) + temp.get(m) + aTemp == num && aTemp <= 9 && temp.get(m) <= 9 && temp.get(n) <= 9) {
                            if (set.add(temp.get(n) + "" + temp.get(m) + "" + aTemp)) {
                                splitNum.add(temp.get(n) + "" + temp.get(m) + "" + aTemp);
                            }
                        }
                    }
                }
            }
        }
        return splitNum.size();
    }

    /**
     * @param betNum    下注号码
     * @param min       最小值
     * @param max       最大值
     * @param arrLength 下注号码长度
     * @param isFlag    下注1-9号码是否是 01,02 的带0 类型,是则为true
     */
    private static boolean checkBetNumIsNumber(String betNum, Integer min, Integer max, Integer arrLength, boolean isFlag) {
        // TODO: 18-11-21  ramob  
//        if (",".equals(betNum.substring(betNum.length() - 1,betNum.length()))) {
//            return false;
//        }
        String[] betNumArr = StringTool.split(betNum, ",");
        if (betNumArr.length == 0) {
            return false;
        }
        if (arrLength != null) {
            if (arrLength != betNumArr.length) {
                return false;
            }
        }
        for (String num : betNumArr) {
            if (StringTool.isBlank(num)) {
                return false;
            }
            if (StringTool.isNotBlank(num) && (num.contains("d") || num.contains("f") || num.contains("l"))) {
                return false;
            }
            // 对号码第一位是否带0进行判断
            if (isNumeric(num) && Integer.valueOf(num) >= 0) {
                if (isFlag) {
                    if (Integer.valueOf(num) > 9 || Integer.valueOf(num) == 0) {
                        if (Integer.valueOf(num).toString().length() != num.length()) {
                            return false;
                        }
                    } else {
                        if (!num.equals("0" + Integer.valueOf(num).toString())) {
                            return false;
                        }
                    }
                } else {
                    if (Integer.valueOf(num).toString().length() != num.length()) {
                        return false;
                    }
                }
            }
            if (!isNumeric(num) || Integer.valueOf(num) < min || Integer.valueOf(num) > max) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRepeat(String betNum[]) {
        Set set = new HashSet(Arrays.asList(betNum));
        int nums = betNum.length - set.size();
        return nums != 0;
    }

    private static boolean isCorrectNumNums (String[] nums) {
        boolean isRight = false;
        for (String num : nums) {
            if (StringTool.isNotEmpty(num) && NumberTool.isNumber(num) && num.length() == 1) {
                isRight = true;
                continue;
            } else {
                return false;
            }
        }
        return isRight;
    }

    private static int isRepeatNum(String num){
        String[] betNum=num.split("");
        int nums=0;
        Set set = new HashSet(Arrays.asList(betNum));
        nums = betNum.length - set.size();
        return nums;
    }

    // 后三，前三跨度
    private static Integer getBetCountByKd(String betNum) {
        List<Integer> kaDuArr = new ArrayList<>();
        List<Integer> tempArr1 = new ArrayList<>();
        List<Integer> tempArr2 = new ArrayList<>();
        List<Integer> tempArr3 = new ArrayList<>();
        List<String> allArr = new ArrayList<>();
        String[] tempNumArr = betNum.split(",");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 0, 9, 1, false)) { // 单注
            kaDuArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && tempNumArr.length > 0 && tempNumArr.length < 11) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 0, 9, 1, false)) {
                    kaDuArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
        for (int t = 0; t < 10; t++) {
            tempArr1.add(t);
            tempArr2.add(t);
            tempArr3.add(t);
        }
        int maxZhi;
        int minZhi;
        int tempZhi;
        for (Integer aKaDuArr : kaDuArr) {
            tempZhi = aKaDuArr;
            for (int n = 0; n < tempArr1.size(); n++) {
                for (int n1 = 0; n1 < tempArr2.size(); n1++) {
                    for (int n2 = 0; n2 < tempArr3.size(); n2++) {
                        maxZhi = tempArr1.get(n) > tempArr2.get(n1) ? tempArr1.get(n) : tempArr2.get(n1);
                        maxZhi = maxZhi > tempArr3.get(n2) ? maxZhi : tempArr3.get(n2);
                        minZhi = tempArr1.get(n) < tempArr2.get(n1) ? tempArr1.get(n) : tempArr2.get(n1);
                        minZhi = minZhi < tempArr3.get(n2) ? minZhi : tempArr3.get(n2);
                        if ((maxZhi - minZhi) == tempZhi) {
                            allArr.add(n + "" + n1 + "" + n2);
                        }
                    }
                }
            }
        }
        return allArr.size();
    }

    /**
     * 后三, 前三组三复式
     */
    private static Integer getBetCountByZ3fs(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> zxArr = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String[] tempNumArr = betNum.split(",");
        if (!betNum.contains(",") && NumberTool.isNumber(betNum) && betNum.length() == 1) { // 单注
            zxArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && tempNumArr.length > 0 && tempNumArr.length < 11 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (NumberTool.isNumber(numStr) && numStr.length() == 1) {
                    zxArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        for (int i = 0; i < zxArr.size() - 1; i++) {
            for (int i1 = 1; i1 < zxArr.size(); i1++) {
                if (!zxArr.get(i1).equals(zxArr.get(i))) {
                    if (set.add(zxArr.get(i) + "" + zxArr.get(i1) + "" + zxArr.get(i1))) {
                        tempArr.add(zxArr.get(i) + "" + zxArr.get(i1) + "" + zxArr.get(i1));
                    }
                    if (set.add(zxArr.get(i1) + "" + zxArr.get(i) + "" + zxArr.get(i))) {
                        tempArr.add(zxArr.get(i1) + "" + zxArr.get(i) + "" + zxArr.get(i));
                    }
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 后三, 前三组六复式
     */
    private static Integer getBetCountByZ6fs(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> zxArr = new ArrayList<>();
        String[] tempNumArr = betNum.split(",");
        if (betNum.contains(",") && tempNumArr.length > 0 && tempNumArr.length < 11 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (NumberTool.isNumber(numStr) && numStr.length() == 1) {
                    zxArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < zxArr.size(); i++) {
            for (int i1 = 0; i1 < zxArr.size(); i1++) {
                for (Integer aZxArr : zxArr) {
                    if (!zxArr.get(i).equals(zxArr.get(i1)) && !zxArr.get(i1).equals(aZxArr) && !zxArr.get(i).equals(aZxArr)) {
                        List<Integer> sortArr = new ArrayList<>();
                        sortArr.add(zxArr.get(i));
                        sortArr.add(zxArr.get(i1));
                        sortArr.add(aZxArr);
                        Collections.sort(sortArr);
                        if (set.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2))) {
                            tempArr.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2));
                        }
                    }
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 后三, 前三组选和值
     */
    private static Integer getBetCountBySum(String betNum) {
        List<Integer> heZhiArr = new ArrayList<>();
        List<String> tempArr = new ArrayList<>();
        int sumTemp;
        int num; // 当前号码
        String[] tempNumArr = betNum.split("\\|");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 1, 26, 1, false)) {//单注
            heZhiArr.add(Integer.valueOf(betNum));
        } else if (tempNumArr.length > 0 && tempNumArr.length < 27 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 1, 26, 1, false)) {
                    heZhiArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        //号码分解---所选号分解成所有组合的值等于此号的所有组合
        Set<String> set = new HashSet<>();
        for (Integer heZhi : heZhiArr) {
            List<Integer> temp = new ArrayList<>();
            sumTemp = heZhi;
            num = heZhi;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            //获取所选号的组选三和组选六形态的所有组数（不包含豹子号、顺序不限）
            for (int n = 0; n < temp.size(); n++) {
                for (int m = 0; m < temp.size(); m++) {
                    for (Integer aTemp : temp) {
                        if (temp.get(n) + temp.get(m) + aTemp == num && aTemp <= 9 && temp.get(m) <= 9 && temp.get(n) <= 9) {
                            if (!temp.get(m).equals(temp.get(n)) && !temp.get(n).equals(aTemp) && !aTemp.equals(temp.get(n))) {
                                List<Integer> sortArr = new ArrayList<>();
                                sortArr.add(temp.get(n));
                                sortArr.add(temp.get(m));
                                sortArr.add(aTemp);
                                Collections.sort(sortArr);
                                if (set.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2))) {
                                    tempArr.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2));
                                }

                            }
                        }
                    }
                }
            }

        }
        return tempArr.size();
    }

    /**
     * 后三, 前三组选包胆
     */
    private static Integer getBetCountByWrap(String betNum) {
        Integer betCount = 0;
        if (NumberTool.isNumber(betNum) && betNum.length() == 1) {
            betCount = 54; //组选包胆固定54位
        }
        return betCount;
    }

    /**
     * 后三, 前三和值尾数
     */
    private static Integer getBetCountBySumTail(String betNum) {
        Integer betCount = 0;
        String[] betNumArr = betNum.split("\\|");
        if (!betNum.contains("|") && NumberTool.isNumber(betNum) && betNum.length() == 1) {// 单注
            betCount = 1;
        } else if (betNum.contains("|") && betNumArr.length > 0 && betNumArr.length <= 10) {
            for (String num : betNumArr) {
                if (NumberTool.isNumber(num) && num.length() == 1) {
                    betCount = betNumArr.length;
                } else {
                    return 0;
                }
            }
        }
        return betCount;
    }

    /**
     * 后三, 前三特殊号
     */
    private static Integer getBetCountBySpecial(String betNum) {
        Integer betCount = 0;
        String[] betNumArr = betNum.split("\\|");
        if (!betNum.contains("|")) { // 单个特殊号
            if ("豹子".equals(betNum) || "顺子".equals(betNum) || "对子".equals(betNum)) {
                betCount = 1;
            }
        } else if (betNum.contains("|") && betNumArr.length > 0 && betNumArr.length <= 3) {
            for (String num : betNumArr) {
                if ("豹子".equals(num) || "顺子".equals(num) || "对子".equals(num)) {
                    betCount = betNumArr.length;
                } else {
                    return 0;
                }
            }
        }
        return betCount;
    }

    /**
     * 前二直选和值
     */
    private static Integer getBetCountByQ2hz(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> hzArr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sumTemp, num;
        String[] tempNumArr = betNum.split("\\|");
        if (!betNum.contains("|") && checkBetNumIsNumber(betNum, 0, 18, 1, false)) {//单注
            hzArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains("|") && tempNumArr.length > 0 && tempNumArr.length < 20 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 0, 18, 1, false)) {
                    hzArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (Integer aHzArr : hzArr) {
            sumTemp = aHzArr;
            num = aHzArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }
            for (int i = 0; i < temp.size(); i++) {
                for (Integer aTemp : temp) {
                    if (temp.get(i) + aTemp == num && temp.get(i) <= 9 && aTemp <= 9) {
                        if (set.add(temp.get(i) + "" + aTemp)) {
                            tempArr.add(temp.get(i) + "" + aTemp);
                        }
                    }
                }
            }
        }
        return tempArr.size();
    }
    /**
     * 时时彩任选2直选和值
     */
    private static Integer getSscRen2ZhixHz (String betNum) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= 2 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    betCount = getBetCountByQ2hzrenx(num);
                } else {
                    return 0;
                }
            }

        }
        betCount = (int)combinationCount(weiCount, 2) * betCount;
        return betCount;
    }

    /**
     * 前二直选和值
     */
    private static Integer getBetCountByQ2hzrenx(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> hzArr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sumTemp, num;
        String[] tempNumArr = betNum.split(",");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 0, 18, 1, false)) {//单注
            hzArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && tempNumArr.length > 0 && tempNumArr.length < 20 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 0, 18, 1, false)) {
                    hzArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (Integer aHzArr : hzArr) {
            sumTemp = aHzArr;
            num = aHzArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }
            for (int i = 0; i < temp.size(); i++) {
                for (Integer aTemp : temp) {
                    if (temp.get(i) + aTemp == num && temp.get(i) <= 9 && aTemp <= 9) {
                        if (set.add(temp.get(i) + "" + aTemp)) {
                            tempArr.add(temp.get(i) + "" + aTemp);
                        }
                    }
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 时时彩任选2组选和值
     */
    private static Integer getSscRen2ZuxHz (String betNum) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= 2 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    betCount = getBetCountByQ2CombRenx(num);
                } else {
                    return 0;
                }
            }
        }
        betCount = (int)combinationCount(weiCount, 2) * betCount;
        return betCount;
    }

    /**
     * 前二组选和值
     */
    private static Integer getBetCountByQ2CombRenx(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> hzArr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sumTemp, num;
        String[] tempNumArr = betNum.split(",");

        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 1, 17, 1, false)) {//单注
            hzArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && tempNumArr.length > 0 && tempNumArr.length < 18 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 1, 17, 1, false)) {
                    hzArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (Integer aHzArr : hzArr) {
            sumTemp = aHzArr;
            num = aHzArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            for (int i = 0; i < temp.size(); i++) {
                for (Integer aTemp : temp) {
                    if (temp.get(i) + aTemp == num && temp.get(i) <= 9 && aTemp <= 9) {
                        if (!temp.get(i).equals(aTemp)) {
                            List<Integer> arr1 = new ArrayList<>();
                            arr1.add(temp.get(i));
                            arr1.add(aTemp);
                            Collections.sort(arr1);
                            if (set.add(arr1.get(0) + "" + arr1.get(1))) {
                                tempArr.add(arr1.get(0) + "" + arr1.get(1));
                            }
                        }
                    }
                }
            }
        }
        return tempArr.size();
    }


    /**
     * 时时彩任选3直选和值
     */
    private static Integer getSscRenx3ZhixHz (String betNum) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= 3 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    betCount = getBetCountByHzrexuan(num);
                } else {
                    return 0;
                }
            }

        }
        betCount = (int)combinationCount(weiCount, 3) * betCount;
        return betCount;
    }

    /**
     * 后三, 前三和值
     */
    private static Integer getBetCountByHzrexuan(String betNum) {
        List<Integer> heZhiArr = new ArrayList<>();
        //分解号组合
        List<Object> splitNum = new ArrayList<>();
        int sumTemp;
        int num; // 当前号码

        String[] tempNumArr = betNum.split(",");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 0, 27, 1, false)) { // 单注
            heZhiArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && tempNumArr.length < 29 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 0, 27, 1, false)) {
                    heZhiArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        // 号码分解: 所选号分解成所有组合的值等于此号的所有组合
        for (Integer aHeZhiArr : heZhiArr) {
            List<Integer> temp = new ArrayList<>();
            sumTemp = aHeZhiArr;
            num = aHeZhiArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            // 所选号码分解至零，被分解出所有的号码三个为一组，所组成的所有组合的每一组值等于所选号的值的组合数
            for (int n = 0; n < temp.size(); n++) {
                for (int m = 0; m < temp.size(); m++) {
                    for (Integer aTemp : temp) {
                        if (temp.get(n) + temp.get(m) + aTemp == num && aTemp <= 9 && temp.get(m) <= 9 && temp.get(n) <= 9) {
                            if (set.add(temp.get(n) + "" + temp.get(m) + "" + aTemp)) {
                                splitNum.add(temp.get(n) + "" + temp.get(m) + "" + aTemp);
                            }
                        }
                    }
                }
            }
        }
        return splitNum.size();
    }

    /**
     * 时时彩任选3组选和值
     */
    private static Integer getSscRenx3ZuxHz (String betNum) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= 3 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    betCount = getBetCountBySumRenx(num);
                } else {
                    return 0;
                }
            }

        }
        betCount = (int)combinationCount(weiCount, 3) * betCount;
        return betCount;
    }

    /**
     * 后三, 前三组选和值
     */
    private static Integer getBetCountBySumRenx(String betNum) {
        List<Integer> heZhiArr = new ArrayList<>();
        List<String> tempArr = new ArrayList<>();
        int sumTemp;
        int num; // 当前号码
        String[] tempNumArr = betNum.split(",");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 1, 26, 1, false)) {//单注
            heZhiArr.add(Integer.valueOf(betNum));
        }else if (tempNumArr.length > 0 && tempNumArr.length < 27 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 1, 26, 1, false)) {
                    heZhiArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        //号码分解---所选号分解成所有组合的值等于此号的所有组合
        Set<String> set = new HashSet<>();
        for (Integer heZhi : heZhiArr) {
            List<Integer> temp = new ArrayList<>();
            sumTemp = heZhi;
            num = heZhi;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            //获取所选号的组选三和组选六形态的所有组数（不包含豹子号、顺序不限）
            for (int n = 0; n < temp.size(); n++) {
                for (int m = 0; m < temp.size(); m++) {
                    for (Integer aTemp : temp) {
                        if (temp.get(n) + temp.get(m) + aTemp == num && aTemp <= 9 && temp.get(m) <= 9 && temp.get(n) <= 9) {
                            if (!temp.get(m).equals(temp.get(n)) && !temp.get(n).equals(aTemp) && !aTemp.equals(temp.get(n))) {
                                List<Integer> sortArr = new ArrayList<>();
                                sortArr.add(temp.get(n));
                                sortArr.add(temp.get(m));
                                sortArr.add(aTemp);
                                Collections.sort(sortArr);
                                if (set.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2))) {
                                    tempArr.add(sortArr.get(0) + "" + sortArr.get(1) + "" + sortArr.get(2));
                                }

                            }
                        }
                    }
                }
            }

        }
        return tempArr.size();
    }

    /**
     * 时时彩任选3组选复式
     */
    private static Integer getSscRenx3Zu36Fs (String betNum, String betCode) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= 3 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    if (num.contains(",")) {
                        if (LotteryBettingEnum.SSC_RENXUAN3_Z3FS.getCode().equals(betCode)) {
                            betCount = getBetCountByZ3fs(num);
                        } else if (LotteryBettingEnum.SSC_RENXUAN3_Z6FS.getCode().equals(betCode)) {
                            betCount = getBetCountByZ6fs(num);
                        }

                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

        }
        betCount = (int)combinationCount(weiCount, 3) * betCount;
        return betCount;
    }

    /**
     * 时时彩任选4组选
     */
    private static Integer getSscRenx4Zux (String betNum, String betCode) {
        Integer betCount = 0;
        Integer weiCount = 0;
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (LotteryBettingEnum.SSC_RENXUAN4_ZX24.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN4_ZX6.getCode().equals(betCode)) {
                if (arr.length == 2 && arr[0].contains(",")) {
                    String[] weis = arr[0].split(",");
                    weiCount = weis.length;
                    String num = arr[1];
                    String[] nums = arr[1].split(",");
                    if (weis.length >= 4 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                        if (!isRepeat(nums)) {
                            if (LotteryBettingEnum.SSC_RENXUAN4_ZX24.getCode().equals(betCode) && nums.length >= 4) {
                                betCount = Integer.valueOf(String.valueOf(combinationCount(nums.length, 4)));
                            } else if (LotteryBettingEnum.SSC_RENXUAN4_ZX6.getCode().equals(betCode) && nums.length >= 2) {
                                betCount = Integer.valueOf(String.valueOf(combinationCount(nums.length, 2)));
                            }

                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                }
            } else if (LotteryBettingEnum.SSC_RENXUAN4_ZX12.getCode().equals(betCode)) {
                if (arr.length == 3 && arr[0].contains(",")) {
                    String[] weis = arr[0].split(",");
                    weiCount = weis.length;
                    if (weis.length >= 4 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                        String[] repateNums = arr[1].split(",");
                        String[] singleNums = arr[2].split(",");
                        if (isCorrectNumNums (repateNums) && isCorrectNumNums (singleNums) && !isRepeat(repateNums) && !isRepeat(singleNums)) {
                            for (String reNum: repateNums) {
                                for (String sinNum1: singleNums) {
                                    for (String sinNum2 : singleNums) {
                                        if (!reNum.equals(sinNum1) && !reNum.equals(sinNum2) && !sinNum1.equals(sinNum2) && Integer.valueOf(sinNum1) > Integer.valueOf(sinNum2)) {
                                            betCount ++;
                                        }
                                    }
                                }
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                }
            } else if (LotteryBettingEnum.SSC_RENXUAN4_ZX4.getCode().equals(betCode)) {
                if (arr.length == 3 && arr[0].contains(",")) {
                    String[] weis = arr[0].split(",");
                    weiCount = weis.length;
                    if (weis.length >= 4 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                        String[] repateNums = arr[1].split(",");
                        String[] singleNums = arr[2].split(",");
                        if (isCorrectNumNums (repateNums) && isCorrectNumNums (singleNums) && !isRepeat(repateNums) && !isRepeat(singleNums) && !isRepeat(repateNums)) {
                            for (String reNum: repateNums) {
                                for (String sinNum1: singleNums) {
                                    if (!reNum.equals(sinNum1)) {
                                        betCount ++;
                                    }
                                }
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        }
        betCount = Integer.valueOf(String.valueOf(combinationCount(weiCount, 4))) * betCount;
        return betCount;
    }

    /**
     * 时时彩任选二组选复式
     */
    private static Integer getSscRenx2ZuxFs (String betNum) {
        Integer betCount = 0;
        String[] arr = new String[2];
        Integer weiCount = 0;
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                String[] nums = arr[1].split(",");
                if (weis.length >= 2 && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    if (num.contains(",") && !isRepeat(nums) && isCorrectNumNums(nums)) {
                        betCount = Integer.valueOf(String.valueOf(combinationCount(nums.length, 2)));
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

        }
        if (betCount != 0) {
            betCount = (int)combinationCount(weiCount, 2) * betCount;
        }
        return betCount;
    }
    /**
     * 前二直选跨度
     */
    private static Integer getBetCountByQ2kd(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> kdArr = new ArrayList<>();
        int num;
        String[] betNumArr = betNum.split(",");
        if (!betNum.contains(",") && checkBetNumIsNumber(betNum, 0, 9, 1, false)) {//单注
            kdArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains(",") && betNumArr.length > 0 && betNumArr.length <= 10 && !isRepeat(betNumArr)) {
            for (String numStr : betNumArr) {
                if (NumberTool.isNumber(numStr) && numStr.length() == 1) {
                    kdArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (Integer aKdArr : kdArr) {
            num = aKdArr;
            for (int i = 0; i < 10; i++) {
                for (int i1 = 0; i1 < 10; i1++) {
                    List<Integer> numTemp = new ArrayList<>();
                    numTemp.add(i);
                    numTemp.add(i1);
                    Collections.sort(numTemp);
                    if (numTemp.get(1) - numTemp.get(0) == num && set.add(i + "" + i1)) {
                        tempArr.add(i + "" + i1);
                    }
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 前二组选和值
     */
    private static Integer getBetCountByQ2Comb(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> hzArr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sumTemp, num;
        String[] tempNumArr = betNum.split("\\|");
        if (!betNum.contains("|") && checkBetNumIsNumber(betNum, 1, 17, 1, false)) {//单注
            hzArr.add(Integer.valueOf(betNum));
        } else if (betNum.contains("|") && tempNumArr.length > 0 && tempNumArr.length < 18 && !isRepeat(tempNumArr)) {
            for (String numStr : tempNumArr) {
                if (checkBetNumIsNumber(numStr, 1, 17, 1, false)) {
                    hzArr.add(Integer.valueOf(numStr));
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (Integer aHzArr : hzArr) {
            sumTemp = aHzArr;
            num = aHzArr;
            while (sumTemp >= 0) {
                temp.add(sumTemp);
                sumTemp--;
            }

            for (int i = 0; i < temp.size(); i++) {
                for (Integer aTemp : temp) {
                    if (temp.get(i) + aTemp == num && temp.get(i) <= 9 && aTemp <= 9) {
                        if (!temp.get(i).equals(aTemp)) {
                            List<Integer> arr1 = new ArrayList<>();
                            arr1.add(temp.get(i));
                            arr1.add(aTemp);
                            Collections.sort(arr1);
                            if (set.add(arr1.get(0) + "" + arr1.get(1))) {
                                tempArr.add(arr1.get(0) + "" + arr1.get(1));
                            }
                        }
                    }
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 前二组选包胆
     */
    private static Integer getBetCountByQ2Wrap(String betNum) {
        List<String> tempArr = new ArrayList<>();
        List<Integer> bdArr = new ArrayList<>();
        if (NumberTool.isNumber(betNum) && betNum.length() == 1) {
            bdArr.add(Integer.valueOf(betNum));
        }

        for (Integer aBdArr : bdArr) {
            for (int i = 0; i < 10; i++) {
                if (i != aBdArr) {
                    tempArr.add(i + "" + aBdArr);
                }
            }
        }
        return tempArr.size();
    }

    /**
     * 定位胆注数统计
     */
    private static Integer getBetCountByDwd(String betCode, String betNum) {
        Integer betCount = 0;
        int len = 5;
        String[] arr = betNum.split("\\|");
        if (LotteryBettingEnum.PL3_YIXING_DWD.getCode().equals(betCode)) {
            len = 3;
        }
        if (arr.length > 0 && arr.length <= len && getStringFoundCount(betNum) == len - 1) {
            for (String betNumTemp : arr) {
                if (StringTool.isNotEmpty(betNumTemp)) {
                    String[] numStr = betNumTemp.split(",");
                    if (numStr.length > 0) {
                        for (String num : numStr) {
                            if (StringTool.isNotEmpty(num) && NumberTool.isNumber(num) && num.length() == 1) {
                                betCount++;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return betCount;
    }

    /**
     * 时时彩任选直选复式
     */
    private static Integer getSscRenxZhixFs(String betCode, String betNum) {
        Integer betCount = 0;
        int len = 5;
        int minLen = 0;
        String[][] newArr = new String[5][];
        List<String> numArr = new ArrayList<>();
        String[] arr = betNum.split("\\|");
        if (LotteryBettingEnum.SSC_RENXUAN2_ZXFS.getCode().equals(betCode)) {
            minLen = 2;
        } else if (LotteryBettingEnum.SSC_RENXUAN3_ZXFS.getCode().equals(betCode)) {
            minLen = 3;
        } else if (LotteryBettingEnum.SSC_RENXUAN4_ZXFS.getCode().equals(betCode)) {
            minLen = 4;
        }
        if (arr.length >= minLen && arr.length <= len && getStringFoundCount(betNum) == len - 1) {
            for (int i = 0; i < arr.length; i++) {
                if (StringTool.isNotEmpty(arr[i])) {
                    String[] numStr = arr[i].split(",");
                    if (numStr.length > 0 && !isRepeat(numStr) && isCorrectNumNums(numStr)) {
                        newArr[i] = numStr;
                        numArr.add(String.valueOf(i));
                    } else {
                        return 0;
                    }

                }
            }
        }
        if (newArr.length >= minLen) {
            List<List<String>> lists = CombinationTool.findsort(numArr,minLen);
            for (List nums: lists) {
                int temResult = 0;
                for (Object num: nums) {
                    temResult = temResult == 0 ? 1 : temResult;
                    temResult *= newArr[Integer.valueOf(num.toString())].length;
                }
                betCount += temResult;
            }
        } else {
            return 0;
        }

        return betCount;
    }

    /**
     * 单式投注单数
     */
    private static Integer getSscRenxDsCount(String betCode, String betNum) {
        Integer betCount = 0;
        Integer weiCount = 0;
        Integer line = 0;
        if (LotteryBettingEnum.SSC_RENXUAN4_ZXDS.getCode().equals(betCode)) {
            line = 4;
        } else if (LotteryBettingEnum.SSC_RENXUAN3_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_Z3DS.getCode().equals(betCode) ||
                LotteryBettingEnum.SSC_RENXUAN3_Z6DS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN3_HHZX.getCode().equals(betCode)) {
            line = 3;
        } else if (LotteryBettingEnum.SSC_RENXUAN2_ZXDS.getCode().equals(betCode) || LotteryBettingEnum.SSC_RENXUAN2_ZUXDS.getCode().equals(betCode)) {
            line = 2;
        }
        String[] arr = new String[2];
        if (betNum.contains("|") && betNum.contains(",")) {
            arr = betNum.split("\\|");
            if (arr.length == 2 && arr[0].contains(",")) {
                String[] weis = arr[0].split(",");
                weiCount = weis.length;
                String num = arr[1];
                if (weis.length >= line && weis.length <= 5 && isCorrectWeiNum (weis)) {
                    if (!num.contains(",") && num.length() == line && isNumeric(num)) { //单注
                        betCount = 1;
                    } else if (num.contains(",")) {
                        String[] nums = arr[1].split(",");
                        if (isCorrectDsNums (line,betCode,nums)) {
                            betCount = nums.length;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

        }
        betCount = (int)combinationCount(weiCount, line) * betCount;
        return betCount;
    }

    private static boolean isCorrectDsNums (Integer line, String betCode, String... nums) {
        boolean isRight = false;
        for (String num : nums) {
            if (num.length() == line && isNumeric(num)) {
                if(LotteryBettingEnum.SSC_RENXUAN3_Z3DS.getCode().equals(betCode)){
                    if(isRepeatNum(num)==1){
                        isRight = true;
                    }else {
                        return false;
                    }
                } else if(LotteryBettingEnum.SSC_RENXUAN3_Z6DS.getCode().equals(betCode) ){
                    if(isRepeatNum(num)==0){
                        isRight = true;
                    } else {
                        return false;
                    }
                } else if( LotteryBettingEnum.SSC_RENXUAN3_HHZX.getCode().equals(betCode)){
                    if(isRepeatNum(num)!=3){
                        isRight = true;
                    } else {
                        return false;
                    }
                }else {
                    isRight = true;
                    continue;
                }
            } else {
                return false;
            }
        }
        return isRight;
    }
    private static int getStringFoundCount(String str) {
        char[] charArray = str.toCharArray();
        int count = 0;
        for (char aCharArray : charArray) {
            if (aCharArray == '|') {
                count++;
            }
        }
        return count;
    }

    /**
     * 四星一码不定位,三星一码不定位注数统计
     */
    private static Integer getBetCountByBdw(String betNum, int m) {
        Integer betCount = 0;
        String[] arr = betNum.split(",");
        if (arr.length > 0 && arr.length <= 10) {
            for (String num : arr) {
                if (!NumberTool.isNumber(num) || num.length() != 1) {
                    return 0;
                }
            }

            int n = 0;
            for (String betNum1 : arr) {
                if (StringTool.isNotEmpty(betNum1)) {
                    n++;
                }
            }
            betCount = Integer.valueOf(String.valueOf(combinationCount(n, m)));
        }
        return betCount;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     */
    private static long combinationCount(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     */
    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 快三
     */
    private static Integer getBetCountByK3All(String betCode, String betNum) {
        Integer betCount = 0;
        // 三连号，三同号通选
        if (LotteryBettingEnum.K3_FUXUAN_SANTONG.getCode().equals(betCode) ||
                LotteryBettingEnum.K3_TONGXUAN_SANLIAN.getCode().equals(betCode)) {
            if (betNum.equals(LotteryBetNumEnum.GENERAL.getCode())) {
                betCount = 1;
            } else {
                return 0;
            }
        } else if (LotteryBettingEnum.K3_DANXUAN_SANTONG.getCode().equals(betCode) ||
                LotteryBettingEnum.K3_FUXUAN_ERTONG.getCode().equals(betCode)
                ) { // 三同号单选，二连号复选
            String[] betNumArr = StringTool.split(betNum, "\\|");
            // 单注
            if (!betNum.contains("|")) {
                if (betNumArr.length == 1) {
                    for (String num : betNumArr) {
                        if (LotteryBettingEnum.K3_DANXUAN_SANTONG.getCode().equals(betCode)) {
                            if (NumberTool.isNumber(num) && checkBetNumThree(num)) {
                                betCount = betNumArr.length;
                            } else {
                                return 0;
                            }
                        } else if (LotteryBettingEnum.K3_FUXUAN_ERTONG.getCode().equals(betCode)) {
                            if (NumberTool.isNumber(num) && checkBetNumTwo(num)) {
                                betCount = betNumArr.length;
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    }

                }
                //多注
            } else if (betNum.contains("|")) {
                if (1 < betNumArr.length && betNumArr.length <= 6) {
                    for (String num : betNumArr) {
                        if (LotteryBettingEnum.K3_DANXUAN_SANTONG.getCode().equals(betCode)) {
                            if (NumberTool.isNumber(num) && checkBetNumThree(num)) {
                                betCount = betNumArr.length;
                            } else {
                                return 0;
                            }
                        } else if (LotteryBettingEnum.K3_FUXUAN_ERTONG.getCode().equals(betCode)) {
                            if (NumberTool.isNumber(num) && checkBetNumTwo(num)) {
                                betCount = betNumArr.length;
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    }
                }
            }
        } else if (LotteryBettingEnum.K3_DANXUAN_ERTONG.getCode().equals(betCode)) { // 二同号单选
            String[] betNumArr = StringTool.split(betNum, "\\|");
            // 单注
            if (!betNum.contains(",") && betNum.contains("|")) {
                if (betNumArr.length == 2) {
                    for (int i = 0; i < betNumArr.length; i++) {
                        if (i == 0) {
                            if (NumberTool.isNumber(betNumArr[i]) && checkBetNumTwo(betNumArr[i]) && NumberTool.toInt(betNumArr[i]) / 11 != NumberTool.toInt(betNumArr[i + 1])) {
                                betCount = 1;
                            } else {
                                return 0;
                            }
                        }
                        if (i == 1) {
                            if (NumberTool.isNumber(betNumArr[i]) && checkBuTongBetNum(betNumArr[i]) && NumberTool.toInt(betNumArr[i]) * 11 != NumberTool.toInt(betNumArr[i - 1])) {
                                betCount = 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            } else if (betNum.contains(",") && betNum.contains("|")) {  // 多注
                if (betNumArr.length == 2) {
                    String tong = null;
                    String diff = null;
                    for (String num : betNumArr) {
                        if (tong == null) {
                            tong = num;
                        } else {
                            diff = num;
                        }
                    }
                    String[] tongArr = StringTool.split(tong, ",");
                    String[] diffArr = StringTool.split(diff, ",");
                    if (diffArr == null) return 0;
                    for (String tongNum : tongArr) {
                        for (String diffNum : diffArr) {
                            if (NumberTool.isNumber(tongNum) && checkBetNumTwo(tongNum) && NumberTool.isNumber(diffNum) && checkBuTongBetNum(diffNum)) {
                                if (NumberTool.toInt(tongNum) / 11 != NumberTool.toInt(diffNum)) {
                                    betCount = tongArr.length * diffArr.length;
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        } else if (LotteryBettingEnum.K3_ERBUTONG.getCode().equals(betCode)) { // 二不同
            String[] betNumArr = StringTool.split(betNum, ",");
            if (betNum.contains(",") && !betNum.contains("|")) {
                if (betNumArr.length >= 2 && betNumArr.length <= 6) {
                    for (String num : betNumArr) {
                        if (NumberTool.isNumber(num) && checkBuTongBetNum(num)) {
                            int len1 = betNumArr.length;
                            if (len1 == 2) {
                                betCount = 1;
                            } else if (len1 == 3) {
                                betCount = 3;
                            } else if (len1 == 4) {
                                betCount = 6;
                            } else if (len1 == 5) {
                                betCount = 10;
                            } else {
                                betCount = 15;
                            }
                        } else {
                            return 0;
                        }
                    }
                }
            }
        } else if (LotteryBettingEnum.K3_SANBUTONG.getCode().equals(betCode)) {//三不同
            String[] betNumArr = StringTool.split(betNum, ",");
            if (betNum.contains(",") && !betNum.contains("|")) {
                if (betNumArr.length >= 3 && betNumArr.length <= 6) {
                    for (String num : betNumArr) {
                        if (NumberTool.isNumber(num) && checkBuTongBetNum(num)) {
                            int len1 = betNumArr.length;
                            if (len1 == 3) {
                                betCount = 1;
                            } else if (len1 == 4) {
                                betCount = 4;
                            } else if (len1 == 5) {
                                betCount = 10;
                            } else {
                                betCount = 20;
                            }
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
        return betCount;
    }

    /**
     * k3 3位数字
     */
    private static boolean checkBetNumThree(String betNum) {
        return betNum.equals("111") || betNum.equals("222") || betNum.equals("333") || betNum.equals("444") ||
                betNum.equals("555") || betNum.equals("666");
    }

    /**
     * k3 2位数字
     */
    private static boolean checkBetNumTwo(String betNum) {
        return betNum.equals("11") || betNum.equals("22") || betNum.equals("33") || betNum.equals("44") ||
                betNum.equals("55") || betNum.equals("66");
    }

    /**
     * k3 一位数字   二三不同
     */
    private static boolean checkBuTongBetNum(String betNum) {
        return betNum.equals("1") || betNum.equals("2") || betNum.equals("3") || betNum.equals("4") ||
                betNum.equals("5") || betNum.equals("6");
    }

    /**
     * PK10
     */
    private static Integer getBetCountByPkAll(String betCode, String betNum) {
        Integer betCount = 0;
        // 前一
        if (LotteryBettingEnum.PK10_ZHIXUAN_QYFS.getCode().equals(betCode)) {
            String[] betNumArr = StringTool.split(betNum, ",");
            // 单注
            if (!betNum.contains(",")) {
                if (checkBetNumPkTwo(betNum)) {
                    betCount = 1;
                } else {
                    return 0;
                }
                // 多注
            } else if (betNum.contains(",")) {
                if (0 < betNumArr.length && betNumArr.length <= 10) {
                    for (String num : betNumArr) {
                        if (LotteryBettingEnum.PK10_ZHIXUAN_QYFS.getCode().equals(betCode)) {
                            if (checkBetNumPkTwo(num)) {
                                betCount = betNumArr.length;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        } else if (LotteryBettingEnum.PK10_ZHIXUAN_QEFS.getCode().equals(betCode)) { // 前二复式
            String[] betNumArr = StringTool.split(betNum, "\\|");
            // 单注
            if (!betNum.contains(",") && betNum.contains("|")) {
                int a = 0;
                if (betNumArr.length == 2) {
                    for (String aBetNumArr : betNumArr) {
                        if (!checkBetNumPkTwo(aBetNumArr)) {
                            a++;
                        }
                    }
                    if (betNumArr[0].equals(betNumArr[1])) {
                        a++;
                    }
                } else {
                    return 0;
                }

                if (a == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
                if (betNumArr.length == 2) {
                    String wan = null;
                    String qian = null;
                    for (String num : betNumArr) {
                        if (wan == null) {
                            wan = num;
                        } else {
                            qian = num;
                        }
                    }
                    String[] wanArr = StringTool.split(wan, ",");
                    String[] qianArr = StringTool.split(qian, ",");
                    int wanLength = wanArr == null ? 0 : wanArr.length;
                    int qianLength = qianArr == null ? 0 : qianArr.length;

                    if (wanLength <= 0 || qianLength <= 0) {
                        return 0;
                    }

                    Set<String> set = new HashSet<>(0);
                    for (String aWanArr : wanArr) {
                        if (checkBetNumPkTwo(aWanArr)) {
                            for (String aQianArr : qianArr) {
                                if (checkBetNumPkTwo(aQianArr)) {
                                    if (!aWanArr.equals(aQianArr)) {
                                        set.add(aWanArr + aQianArr);
                                    }
                                } else {
                                    return 0;
                                }
                            }
                        } else {
                            return 0;
                        }
                    }
                    betCount = set.size();
                }
            }
        } else if (LotteryBettingEnum.PK10_ZHIXUAN_QSFS.getCode().equals(betCode)) {// 前三复式
            String[] betNumArr = StringTool.split(betNum, "\\|");
            // 单注`
            if (!betNum.contains(",") && betNum.contains("|")) {
                int a = 0;
                if (betNumArr.length == 3) {
                    for (String aBetNumArr : betNumArr) {
                        if (!checkBetNumPkTwo(aBetNumArr)) {
                            a++;
                        }
                    }
                    if (betNumArr[0].equals(betNumArr[1]) || betNumArr[0].equals(betNumArr[2]) || betNumArr[2].equals(betNumArr[1])) {
                        a++;
                    }
                } else {
                    return 0;
                }

                if (a == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
                if (betNumArr.length == 3) {
                    String wan = null;
                    String qian = null;
                    String bai = null;
                    for (String bnum : betNumArr) {
                        if (wan == null) {
                            wan = bnum;
                        } else if (qian == null) {
                            qian = bnum;
                        } else if (bai == null) {
                            bai = bnum;
                        }
                    }
                    String[] wanArr = StringTool.split(wan, ",");
                    String[] qianArr = StringTool.split(qian, ",");
                    String[] baiArr = StringTool.split(bai, ",");

                    int wanLength = wanArr.length;
                    int qianLength = qianArr == null ? 0 : qianArr.length;
                    int baiLength = baiArr == null ? 0 : baiArr.length;

                    if (wanLength <= 0 || qianLength <= 0 || baiLength <= 0) {
                        return 0;
                    }

                    Set<String> set = new HashSet<>(0);
                    for (String aWanArr : wanArr) {
                        if (checkBetNumPkTwo(aWanArr)) {
                            for (String aQianArr : qianArr) {
                                if (checkBetNumPkTwo(aQianArr)) {
                                    for (String aBaiArr : baiArr) {
                                        if (checkBetNumPkTwo(aBaiArr)) {
                                            if (!aWanArr.equals(aQianArr) && !aWanArr.equals(aBaiArr) && !aBaiArr.equals(aQianArr)) {
                                                set.add(aWanArr + aQianArr + aBaiArr);
                                            }
                                        } else {
                                            return 0;
                                        }
                                    }
                                } else {
                                    return 0;
                                }
                            }
                        } else {
                            return 0;
                        }
                    }

                    betCount = set.size();

                } else {
                    return 0;
                }
            }
        } else if (LotteryBettingEnum.PK10_ZHIXUAN_QEDS.getCode().equals(betCode)) { // 前二单式
            if (!betNum.contains("|")) { // 单注
                String[] betNumArr = StringTool.split(betNum, " ");
                if (betNumArr.length == 2) {
                    int j = 0;
                    for (String num : betNumArr) {
                        if (!checkBetNumPkTwo(num)) {
                            j++;
                        }
                    }

                    if (j == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

            if (betNum.contains("|")) { // 多注
                String[] betNumArr = StringTool.split(betNum, "\\|");
                int j = 0, i = 0;
                String wan = "";
                String qian = "";
                for (String bnum : betNumArr) {
                    String[] bunumarr = StringTool.split(bnum, " ");
                    if (bunumarr.length != 2) {
                        return 0;
                    }
                    for (String bu : bunumarr) {
                        if (i == 2) {
                            i = 0;
                            wan = "";
                            qian = "";
                        }
                        if ("".equals(wan)) {
                            wan = bu;
                        } else if (!"".equals(wan)) {
                            qian = bu;
                        }
                        i++;
                        if (i == 2) {
                            if (wan.equals(qian) || !checkBetNumPkTwo(wan) || !checkBetNumPkTwo(qian)) {
                                j++;
                            }
                        }
                    }
                }
                if (j == 0) {
                    betCount = betNumArr.length;
                } else {
                    return 0;
                }
            }
        } else if (LotteryBettingEnum.PK10_ZHIXUAN_QSDS.getCode().equals(betCode)) { // 前三单式
            if (!betNum.contains("|")) { // 单注
                String[] betNumArr = StringTool.split(betNum, " ");
                if (betNumArr.length == 3) {
                    int j = 0;
                    for (String bnum : betNumArr) {
                        if (!checkBetNumPkTwo(bnum)) {
                            j++;
                        }
                    }
                    if (j == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

            if (betNum.contains("|")) { // 多注
                String[] betNumArr = StringTool.split(betNum, "\\|");
                int j = 0, i = 0;
                String wan = "";
                String qian = "";
                String bai = "";
                for (String bnum : betNumArr) {
                    String[] bunumarr = StringTool.split(bnum, " ");
                    if (bunumarr.length != 3) {
                        return 0;
                    }
                    for (String bu : bunumarr) {
                        if (i == 3) {
                            i = 0;
                            wan = "";
                            qian = "";
                            bai = "";
                        }
                        if ("".equals(wan)) {
                            wan = bu;
                        } else if (!"".equals(wan) && "".equals(qian)) {
                            qian = bu;
                        } else if (!"".equals(wan) && !"".equals(qian)) {
                            bai = bu;
                        }
                        i++;
                        if (i == 3) {
                            if (wan.equals(qian) || !checkBetNumPkTwo(wan) || !checkBetNumPkTwo(qian) || !checkBetNumPkTwo(bai)) {
                                j++;
                            }
                        }
                    }
                }
                if (j == 0) {
                    betCount = betNumArr.length;
                } else {
                    return 0;
                }
            }
        } else if (LotteryBettingEnum.PK10_YIXING_DWD.getCode().equals(betCode)) { // pk10定位胆

            String[] betNumArr = StringTool.split(betNum, "\\|");
            if (betNumArr != null && betNumArr.length > 0 && betNumArr.length <= 10 && getStringFoundCount(betNum) == 9) {
                for (String betNumTemp : betNumArr) {
                    if (StringTool.isNotEmpty(betNumTemp)) {
                        String[] bunumarr = StringTool.split(betNumTemp, ",");
                        if (bunumarr != null && bunumarr.length > 0) {
                            for (String aBunumarr : bunumarr) {
                                if (StringTool.isNotEmpty(aBunumarr) && checkBetNumPkTwo(aBunumarr) && aBunumarr.length() == 2) {
                                    betCount++;
                                } else {
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        return betCount;
    }

    /**
     * pk10 2位数字
     */
    private static boolean checkBetNumPkTwo(String betNum) {
        return betNum.equals("01") || betNum.equals("02") || betNum.equals("03") || betNum.equals("04") ||
                betNum.equals("05") || betNum.equals("06") || betNum.equals("07") || betNum.equals("08")
                || betNum.equals("09") || betNum.equals("10");
    }

    /**
     * 校验传统玩法下注数量
     */
    public static boolean checkTraditionBetCount(LotteryBetOrder betOrder) {
        String betNum = betOrder.getBetNum();
        if (StringTool.isBlank(betNum)) {
            return false;
        }

        boolean flag = true;
        String betCode = betOrder.getBetCode();
        String playCode = betOrder.getPlayCode();

        if (LotteryBettingEnum.GROUP3_FIRST_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_IN_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP3_AFTER_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.GROUP6_FIRST_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP6_IN_THREE.getCode().equals(betCode) || LotteryBettingEnum.GROUP6_AFTER_THREE.getCode().equals(betCode) ||
                LotteryBettingEnum.PL3_GROUP3.getCode().equals(betCode) || LotteryBettingEnum.PL3_GROUP6.getCode().equals(betCode)) {
            flag = checkBetNumIsNumber(betNum, 0, 9, null, false);
        } else if (LotteryPlayEnum.XY28_SUM3_DIGITAL_THREE.getCode().equals(playCode)) {
            flag = checkBetNumIsNumber(betNum, 0, 27, 3, false);
        } else if (LotteryPlayEnum.LHC_FOUR_ALL_IN.getCode().equals(playCode)) {
            flag = checkBetNumIsNumber(betNum, 1, 49, 4, true);
        } else if (LotteryPlayEnum.LHC_THREE_IN_TWO.getCode().equals(playCode) || LotteryPlayEnum.LHC_THREE_ALL_IN.getCode().equals(playCode)) {
            flag = checkBetNumIsNumber(betNum, 1, 49, 3, true);
        } else if (LotteryPlayEnum.LHC_TWO_IN_SPECIAL.getCode().equals(playCode) || LotteryPlayEnum.LHC_TWO_ALL_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SPECIAL_STRAND.getCode().equals(playCode)) {
            flag = checkBetNumIsNumber(betNum, 1, 49, 2, true);
        } else if (LotteryPlayEnum.LHC_TWELVE_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_ELEVEN_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_TEN_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_NINE_NO_IN.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_EIGHT_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SEVEN_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_SIX_NO_IN.getCode().equals(playCode) || LotteryPlayEnum.LHC_FIVE_NO_IN.getCode().equals(playCode)) {
            flag = checkAllMiss(betNum, playCode);
        } else if (LotteryPlayEnum.KENO_SELECTION_ONE.getCode().equals(playCode) || LotteryPlayEnum.KENO_SELECTION_TWO.getCode().equals(playCode) || LotteryPlayEnum.KENO_SELECTION_THREE.getCode().equals(playCode) ||
                LotteryPlayEnum.KENO_SELECTION_FOUR.getCode().equals(playCode) || LotteryPlayEnum.KENO_SELECTION_FIVE.getCode().equals(playCode)) {
            flag = checkKenoBetNum(betNum, playCode);
        } else if (LotteryPlayEnum.LHC_ONE_ZODIAC.getCode().equals(playCode) || LotteryPlayEnum.LHC_SPECIAL_ZODIAC.getCode().equals(playCode) || LotteryPlayEnum.LHC_SUM_ZODIAC.getCode().equals(playCode)
                || LotteryPlayEnum.LHC_TWO_ZODIAC_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_THREE_ZODIAC_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FOUR_ZODIAC_LINK.getCode().equals(playCode)
                || LotteryPlayEnum.LHC_FIVE_ZODIAC_LINK.getCode().equals(playCode)) {
            flag = checkLhcZodiacBetNum(betNum, playCode, betCode);
        } else if (LotteryPlayEnum.LHC_TWO_MANTISSA_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_THREE_MANTISSA_LINK.getCode().equals(playCode) || LotteryPlayEnum.LHC_FOUR_MANTISSA_LINK.getCode().equals(playCode) ||
                LotteryPlayEnum.LHC_FIVE_MANTISSA_LINK.getCode().equals(playCode)) {
            flag = checkZeroToNightBetNum(betNum, playCode);
        } else if (LotteryPlayEnum.TWO_DIGITAL.getCode().equals(playCode)) {
            flag = checkDigitalBetNum(betNum, 2);
        } else if (LotteryPlayEnum.THREE_DIGITAL.getCode().equals(playCode)) {
            flag = checkDigitalBetNum(betNum, 3);
        } else if (LotteryPlayEnum.SYX5_ONE_DIGITAL.getCode().equals(playCode)) {
            flag = checkBetNum11X5Two(betNum);
        } else if (LotteryPlayEnum.SYX5_ONE_BIG_SMALL.getCode().equals(playCode) || LotteryPlayEnum.SYX5_ONE_SINGLE_DOUBLE.getCode().equals(playCode)) {
            flag = checkBetNumBigSingle(betNum);
        }
        return flag;
    }


    private static boolean checkAllMiss(String betNum, String playCode) {
        boolean flag = false;
        if (LotteryPlayEnum.LHC_TWELVE_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 12, true);
        } else if (LotteryPlayEnum.LHC_ELEVEN_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 11, true);
        } else if (LotteryPlayEnum.LHC_TEN_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 10, true);
        } else if (LotteryPlayEnum.LHC_NINE_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 9, true);
        } else if (LotteryPlayEnum.LHC_EIGHT_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 8, true);
        } else if (LotteryPlayEnum.LHC_SEVEN_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 7, true);
        } else if (LotteryPlayEnum.LHC_SIX_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 6, true);
        } else if (LotteryPlayEnum.LHC_FIVE_NO_IN.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 49, 5, true);
        }
        return flag;
    }

    /**
     * 校验keno彩betNum
     */
    private static boolean checkKenoBetNum(String betNum, String playCode) {
        boolean flag = false;
        if (LotteryPlayEnum.KENO_SELECTION_ONE.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 80, 1, false);
        } else if (LotteryPlayEnum.KENO_SELECTION_TWO.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 80, 2, false);
        } else if (LotteryPlayEnum.KENO_SELECTION_THREE.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 80, 3, false);
        } else if (LotteryPlayEnum.KENO_SELECTION_FOUR.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 80, 4, false);
        } else if (LotteryPlayEnum.KENO_SELECTION_FIVE.getCode().equals(playCode)) {
            flag = BetCountTool.checkBetNumIsNumber(betNum, 1, 80, 5, false);
        }
        return flag;
    }

    /**
     * 校验六合彩生肖BetNum
     */
    private static boolean checkLhcZodiacBetNum(String betNum, String playCode, String betCode) {
        int sl = 0;
        if (LotteryPlayEnum.LHC_ONE_ZODIAC.getCode().equals(playCode) || LotteryPlayEnum.LHC_SPECIAL_ZODIAC.getCode().equals(playCode)) {
            sl = 1;
        } else if (LotteryPlayEnum.LHC_TWO_ZODIAC_LINK.getCode().equals(playCode)) {
            sl = 2;
        } else if (LotteryPlayEnum.LHC_THREE_ZODIAC_LINK.getCode().equals(playCode)) {
            sl = 3;
        } else if (LotteryPlayEnum.LHC_FOUR_ZODIAC_LINK.getCode().equals(playCode)) {
            sl = 4;
        } else if (LotteryPlayEnum.LHC_FIVE_ZODIAC_LINK.getCode().equals(playCode)) {
            sl = 5;
        } else if (LotteryPlayEnum.LHC_SUM_ZODIAC.getCode().equals(playCode)) {
            if (LotteryBettingEnum.LHC_TWO_ZODIAC.getCode().equals(betCode)) {
                sl = 2;
            } else if (LotteryBettingEnum.LHC_THREE_ZODIAC.getCode().equals(betCode)) {
                sl = 3;
            } else if (LotteryBettingEnum.LHC_FOUR_ZODIAC.getCode().equals(betCode)) {
                sl = 4;
            } else if (LotteryBettingEnum.LHC_FIVE_ZODIAC.getCode().equals(betCode)) {
                sl = 5;
            } else if (LotteryBettingEnum.LHC_SIX_ZODIAC.getCode().equals(betCode)) {
                sl = 6;
            } else if (LotteryBettingEnum.LHC_SEVEN_ZODIAC.getCode().equals(betCode)) {
                sl = 7;
            } else if (LotteryBettingEnum.LHC_EIGHT_ZODIAC.getCode().equals(betCode)) {
                sl = 8;
            } else if (LotteryBettingEnum.LHC_NINE_ZODIAC.getCode().equals(betCode)) {
                sl = 9;
            } else if (LotteryBettingEnum.LHC_TEN_ZODIAC.getCode().equals(betCode)) {
                sl = 10;
            } else if (LotteryBettingEnum.LHC_ELEVEN_ZODIAC.getCode().equals(betCode)) {
                sl = 11;
            }
        }

        if (StringTool.isBlank(betNum)) {
            return false;
        }

        String[] numArr = StringTool.split(betNum, ",");
        if (sl != numArr.length) {
            return false;
        }

        if (BetCountTool.isRepeat(numArr)) {
            return false;
        }

        for (String num : numArr) {
            if (StringTool.isBlank(num) || !ArrayUtils.contains(LotteryTool.ZODIACS, num)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 校验凌晨到夜晚的betNum
     */
    private static boolean checkZeroToNightBetNum(String betNum, String playCode) {
        Integer arrLength = 0;
        if (LotteryPlayEnum.LHC_TWO_MANTISSA_LINK.getCode().equals(playCode)) {
            arrLength = 2;
        } else if (LotteryPlayEnum.LHC_THREE_MANTISSA_LINK.getCode().equals(playCode)) {
            arrLength = 3;
        } else if (LotteryPlayEnum.LHC_FOUR_MANTISSA_LINK.getCode().equals(playCode)) {
            arrLength = 4;
        } else if (LotteryPlayEnum.LHC_FIVE_MANTISSA_LINK.getCode().equals(playCode)) {
            arrLength = 5;
        }

        return 0 != arrLength && BetCountTool.checkBetNumIsNumber(betNum, 0, 9, arrLength, false);
    }

    /**
     * 校验数字盘的BetNum
     */
    private static boolean checkDigitalBetNum(String betNum, int numLength) {
        return BetCountTool.isNumeric(betNum) && betNum.length() == numLength;
    }

    /**
     * 11选5直选复式投注单数
     */
    private static Integer get11X5BetCountByFs(String betCode, String betNum) {
        Integer betCount = 0;

        Integer line = 0; // 拥有选择号码的行数
        if (LotteryBettingEnum.SYX5_SANXING_QSZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZXFS.getCode().equals(betCode)) {
            line = 3;
        } else if (LotteryBettingEnum.SYX5_ERXING_QEZXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZXFS.getCode().equals(betCode)) {
            line = 2;
        }

        String[] betNumArr = StringTool.split(betNum, "\\|");
        if (line == 2) {
            betCount = find11x5exzxfsCount(betNumArr, betNum);
        } else if (line == 3) {
            betCount = find11x5sxzxfsCount(betNumArr, betNum);
        }

        return betCount;
    }

    private static Integer find11x5exzxfsCount(String[] betNumArr, String betNum) {
        Integer betCount = 0;
        // 单注
        if (!betNum.contains(",") && betNum.contains("|")) {
            int a = 0;
            if (betNumArr.length == 2) {
                for (String aBetNumArr : betNumArr) {
                    if (!checkBetNum11X5Two(aBetNumArr)) {
                        a++;
                    }
                }
                if (betNumArr[0].equals(betNumArr[1])) {
                    a++;
                }
            } else {
                return 0;
            }

            if (a == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
            if (betNumArr.length == 2) {
                String one = null;
                String two = null;
                for (String num : betNumArr) {
                    if (one == null) {
                        one = num;
                    } else {
                        two = num;
                    }
                }
                String[] wanArr = StringTool.split(one, ",");
                String[] qianArr = StringTool.split(two, ",");
                int wanLength = wanArr == null ? 0 : wanArr.length;
                int qianLength = qianArr == null ? 0 : qianArr.length;

                if (wanLength <= 0 || qianLength <= 0) {
                    return 0;
                }

                Set<String> set = new HashSet<>(0);
                for (String aWanArr : wanArr) {
                    if (checkBetNum11X5Two(aWanArr)) {
                        for (String aQianArr : qianArr) {
                            if (checkBetNum11X5Two(aQianArr)) {
                                if (!aWanArr.equals(aQianArr)) {
                                    set.add(aWanArr + aQianArr);
                                }
                            } else {
                                return 0;
                            }
                        }
                    } else {
                        return 0;
                    }
                }
                betCount = set.size();
            }
        }
        return betCount;
    }
    // 时时彩官方大小单双
    private static Integer findSscTwoBigSmaSinDouCount(String[] betNumArr, String betNum) {
        Integer betCount = 0;
        // 单注
        if (!betNum.contains(",") && betNum.contains("|")) {
            int a = 0;
            if (betNumArr.length == 2) {
                for (String aBetNumArr : betNumArr) {
                    if (!checkBetNumBigSingle(aBetNumArr)) {
                        a++;
                    }
                }
            } else {
                return 0;
            }

            if (a == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
            if (betNumArr.length == 2) {
                String one = null;
                String two = null;
                for (String num : betNumArr) {
                    if (one == null) {
                        one = num;
                    } else {
                        two = num;
                    }
                }
                String[] wanArr = StringTool.split(one, ",");
                String[] qianArr = StringTool.split(two, ",");
                int wanLength = wanArr == null ? 0 : wanArr.length;
                int qianLength = qianArr == null ? 0 : qianArr.length;

                if (wanLength <= 0 || qianLength <= 0) {
                    return 0;
                }

                Set<String> set = new HashSet<>(0);
                for (String aWanArr : wanArr) {
                    if (checkBetNumBigSingle(aWanArr)) {
                        for (String aQianArr : qianArr) {
                            if (checkBetNumBigSingle(aQianArr)) {
                                set.add(aWanArr + aQianArr);
                            } else {
                                return 0;
                            }
                        }
                    } else {
                        return 0;
                    }
                }
                betCount = set.size();
            }
        }
        return betCount;
    }

    private static Integer find11x5sxzxfsCount(String[] betNumArr, String betNum) {
        Integer betCount = 0;
        // 单注
        if (!betNum.contains(",") && betNum.contains("|")) {
            int a = 0;
            if (betNumArr.length == 3) {
                for (String aBetNumArr : betNumArr) {
                    if (!checkBetNum11X5Two(aBetNumArr)) {
                        a++;
                    }
                }
                if (betNumArr[0].equals(betNumArr[1]) || betNumArr[1].equals(betNumArr[2]) || betNumArr[0].equals(betNumArr[2])) {
                    a++;
                }
            } else {
                return 0;
            }

            if (a == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
            if (betNumArr.length == 3) {
                String one = null;
                String two = null;
                String three = null;
                for (String bnum : betNumArr) {
                    if (one == null) {
                        one = bnum;
                    } else if (two == null) {
                        two = bnum;
                    } else if (three == null) {
                        three = bnum;
                    }
                }
                String[] wanArr = StringTool.split(one, ",");
                String[] qianArr = StringTool.split(two, ",");
                String[] baiArr = StringTool.split(three, ",");

                int wanLength = wanArr.length;
                int qianLength = qianArr == null ? 0 : qianArr.length;
                int baiLength = baiArr == null ? 0 : baiArr.length;

                if (wanLength <= 0 || qianLength <= 0 || baiLength <= 0) {
                    return 0;
                }

                Set<String> set = new HashSet<>(0);
                for (String aWanArr : wanArr) {
                    if (checkBetNum11X5Two(aWanArr)) {
                        for (String aQianArr : qianArr) {
                            if (checkBetNum11X5Two(aQianArr)) {
                                for (String aBaiArr : baiArr) {
                                    if (checkBetNum11X5Two(aBaiArr)) {
                                        if (!aWanArr.equals(aQianArr) && !aWanArr.equals(aBaiArr) && !aBaiArr.equals(aQianArr)) {
                                            set.add(aWanArr + aQianArr + aBaiArr);
                                        }
                                    } else {
                                        return 0;
                                    }
                                }
                            } else {
                                return 0;
                            }
                        }
                    } else {
                        return 0;
                    }
                }

                betCount = set.size();

            } else {
                return 0;
            }
        }
        return betCount;
    }
    // 时时彩大小单双三星
    private static Integer findSscThreeBigSmaSinDouCount(String[] betNumArr, String betNum) {
        Integer betCount = 0;
        // 单注
        if (!betNum.contains(",") && betNum.contains("|")) {
            int a = 0;
            if (betNumArr.length == 3) {
                for (String aBetNumArr : betNumArr) {
                    if (!checkBetNumBigSingle(aBetNumArr)) {
                        a++;
                    }
                }
            } else {
                return 0;
            }

            if (a == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (betNum.contains(",") && betNum.contains("|")) {// 多注
            if (betNumArr.length == 3) {
                String one = null;
                String two = null;
                String three = null;
                for (String bnum : betNumArr) {
                    if (one == null) {
                        one = bnum;
                    } else if (two == null) {
                        two = bnum;
                    } else if (three == null) {
                        three = bnum;
                    }
                }
                String[] wanArr = StringTool.split(one, ",");
                String[] qianArr = StringTool.split(two, ",");
                String[] baiArr = StringTool.split(three, ",");

                int wanLength = wanArr.length;
                int qianLength = qianArr == null ? 0 : qianArr.length;
                int baiLength = baiArr == null ? 0 : baiArr.length;

                if (wanLength <= 0 || qianLength <= 0 || baiLength <= 0) {
                    return 0;
                }

                Set<String> set = new HashSet<>(0);
                for (String aWanArr : wanArr) {
                    if (checkBetNumBigSingle(aWanArr)) {
                        for (String aQianArr : qianArr) {
                            if (checkBetNumBigSingle(aQianArr)) {
                                for (String aBaiArr : baiArr) {
                                    if (checkBetNumBigSingle(aBaiArr)) {
                                        set.add(aWanArr + aQianArr + aBaiArr);
                                    } else {
                                        return 0;
                                    }
                                }
                            } else {
                                return 0;
                            }
                        }
                    } else {
                        return 0;
                    }
                }

                betCount = set.size();

            } else {
                return 0;
            }
        }
        return betCount;
    }
    /**
     * 11选5 2位数字
     */
    private static boolean checkBetNum11X5Two(String betNum) {
        return betNum.equals("01") || betNum.equals("02") || betNum.equals("03") || betNum.equals("04") ||
                betNum.equals("05") || betNum.equals("06") || betNum.equals("07") || betNum.equals("08")
                || betNum.equals("09") || betNum.equals("10") || betNum.equals("11");
    }

    /**
     * 时时彩大小单双
     */
    private static boolean checkBetNumBigSingle(String betNum) {
        return betNum.equals("大") || betNum.equals("小") || betNum.equals("单") || betNum.equals("双");
    }

    /**
     * 时时彩任选位校验
     */
    private static boolean checkBetNumWeiNum(String num) {
        return num.equals("万") || num.equals("千") || num.equals("百") || num.equals("十") || num.equals("个");
    }

    private static boolean isCorrectWeiNum (String... weis) {
        boolean isRight = false;
        for (String wei : weis) {
            if (checkBetNumWeiNum(wei)) {
                isRight = true;
                continue;
            } else {
                return false;
            }
        }
        return isRight;
    }


    /**
     * 11选5 2位数字
     */
    private static boolean checkBetNum11X5TwoIsRight(String[] arr) {
        boolean isRight = false;
        for (String num : arr) {
            if (checkBetNum11X5Two(num)) {
                isRight = true;
                continue;
            } else {
                return false;
            }
        }
        Set set = new HashSet(Arrays.asList(arr));
        isRight = set.size() == arr.length;
        return isRight;
    }


    /**
     * 单式投注单数
     */
    private static Integer get11X5BetCountByDs(String betCode, String betNum) {
        Integer betCount = 0;
        Integer line = 0;
        line = findBetNumDsCount(betCode);
        if (!betNum.contains("|")) {// 单注
            if (LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS.getCode().equals(betCode) && !betNum.contains(",") && checkBetNum11X5Two(betNum)) {
                betCount = 1;
            } else if (!LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS.getCode().equals(betCode) && betNum.contains(",")) {
                String[] arr = betNum.split(",");
                if (arr.length == line && checkBetNum11X5TwoIsRight(arr)) {
                    betCount = 1;
                }
            }
        } else if (betNum.contains("|")) { // 多注
            String[] betNumArr = betNum.split("\\|");
            for (String num : betNumArr) {
                String[] arr = num.split(",");
                if (arr.length == line && checkBetNum11X5TwoIsRight(arr)) {
                    betCount = betNumArr.length;
                } else {
                    return 0;
                }
            }
        }
        return betCount;
    }
    /**
     * 后三, 前三, 中三 组选/前二，后二 复式
     */
    private static Integer getBetCountBy11X5fs(String betCode, String betNum) {
        int m = 0;
        if (LotteryBettingEnum.SYX5_SANXING_QSZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSZUXFS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSZUXFS.getCode().equals(betCode)
                ) {
            m = 3;
        } else if (LotteryBettingEnum.SYX5_ERXING_QEZUXFS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXFS.getCode().equals(betCode)) {
            m = 2;
        }
        int n = 0;
        String[] tempNumArr = betNum.split(",");
        if (betNum.contains(",") && tempNumArr.length >= m && tempNumArr.length < 12) {
            for (String numStr : tempNumArr) {
                if (checkBetNum11X5Two(numStr) && numStr.length() == 2) {
                    n++;
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
        return Integer.valueOf(String.valueOf(combinationCount(n, m)));
    }

    private static int get11X5BetCountByDwd(String betNum) {
        int betCount = 0;
        String[] betNumArr = StringTool.split(betNum, "\\|");
        if (betNumArr != null && betNumArr.length > 0 && betNumArr.length <= 5) {
            for (String betNumTemp : betNumArr) {
                if (StringTool.isNotEmpty(betNumTemp)) {
                    String[] bunumarr = StringTool.split(betNumTemp, ",");
                    if (bunumarr != null && bunumarr.length > 0 && bunumarr.length < 12) {
                        for (String aBunumarr : bunumarr) {
                            if (StringTool.isNotEmpty(aBunumarr) && checkBetNum11X5Two(aBunumarr) && aBunumarr.length() == 2) {
                                betCount++;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return betCount;
    }

    /**
     * 11X5不定位，任选
     */
    private static Integer get11X5BetCountByRenxBdw(String betNum, String betCode) {
        Integer betCount = 0;
        int m = findBetNumFsCount(betCode);
        int n = 0;
        String[] arr = betNum.split(",");
        if (arr.length >= m && arr.length <= 11) {
            for (String num : arr) {
                if (StringTool.isNotEmpty(num) && checkBetNum11X5Two(num) && num.length() == 2) {
                    n++;
                }
            }
            betCount = Integer.valueOf(String.valueOf(combinationCount(n, m)));
        } else {
            betCount = 0;
        }
        return betCount;
    }

    /**
     * 11X5胆拖
     */
    private static Integer get11X5BetCountByDt(String betNum, String betCode) {
        Integer betCount = 0;

        int dm = 0;
        int tm = 0;
        int m = findDtNumCount(betCode);
        dm = findDmNum(betNum);
        tm = findTmNum(betNum);
        if (dm == 0 || dm >= m || tm == 0) {
            return 0;
        } else {
            m = m - dm;
        }
        if ((dm + tm) >= m && (dm + tm) <= 11) {
            betCount = Integer.valueOf(String.valueOf(combinationCount(tm, m)));
        }
        return betCount;
    }
    /**
     * 时时彩大小单双
     */
    private static int getSscBigSmallSinDou (String betCode, String betNum) {
        Integer betCount = 0;

        Integer line = 0; // 拥有选择号码的行数
        if (LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q3.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H3.getCode().equals(betCode)) {
            line = 3;
        } else if (LotteryBettingEnum.SSC_DAXIAODANSHUANG_Q2.getCode().equals(betCode) || LotteryBettingEnum.SSC_DAXIAODANSHUANG_H2.getCode().equals(betCode)) {
            line = 2;
        }

        String[] betNumArr = StringTool.split(betNum, "\\|");
        if (line == 2) {
            betCount = findSscTwoBigSmaSinDouCount(betNumArr, betNum);
        } else if (line == 3) {
            betCount = findSscThreeBigSmaSinDouCount(betNumArr, betNum);
        }
        return betCount;
    }

    /**
     * 11x5胆码个数
     */
    private static int findDmNum(String betNum) {
        int dm = 0;
        String[] arr = betNum.split("\\|");
        if (arr.length == 2) {
            String str = arr[0];
            String[] arr1 = str.split(",");
            for (String num : arr1) {
                if (StringTool.isNotEmpty(num) && checkBetNum11X5Two(num) && num.length() == 2) {
                    dm++;
                } else {
                    dm = 0;
                }
            }
        } else {
            dm = 0;
        }
        return dm;
    }

    /**
     * 11x5拖码个数
     */
    private static int findTmNum(String betNum) {
        int tm = 0;
        String[] arr = betNum.split("\\|");
        if (arr.length == 2) {
            String str = arr[1];
            String[] arr1 = str.split(",");
            for (String num : arr1) {
                if (StringTool.isNotEmpty(num) && checkBetNum11X5Two(num) && num.length() == 2) {
                    tm++;
                } else {
                    tm = 0;
                }
            }
        } else {
            tm = 0;
        }
        return tm;
    }

    private static int findBetNumFsCount(String betCode) {
        int m = 0;
        if (LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEFS.getCode().equals(betCode)) {
            m = 8;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEFS.getCode().equals(betCode)) {
            m = 7;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEFS.getCode().equals(betCode)) {
            m = 6;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEFS.getCode().equals(betCode)) {
            m = 5;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURFS.getCode().equals(betCode)) {
            m = 4;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEFS.getCode().equals(betCode)) {
            m = 3;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWOFS.getCode().equals(betCode)) {
            m = 2;
        } else if (LotteryBettingEnum.SYX5_SANXING_QSBDW.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_ZSBDW.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_HSBDW.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEFS.getCode().equals(betCode)) {
            m = 1;
        }
        return m;
    }

    private static int findBetNumDsCount (String betCode) {
        int line = 0;
        if (LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDS.getCode().equals(betCode)) {
            line = 8;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDS.getCode().equals(betCode)) {
            line = 7;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDS.getCode().equals(betCode)) {
            line = 6;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDS.getCode().equals(betCode)) {
            line = 5;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDS.getCode().equals(betCode)) {
            line = 4;
        }else if (LotteryBettingEnum.SYX5_SANXING_QSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_QSZUXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZUXDS.getCode().equals(betCode)
                ) {
            line = 3;
        } else if (LotteryBettingEnum.SYX5_ERXING_QEZXDS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODS.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_QEZUXDS.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_HEZUXDS.getCode().equals(betCode)
                ) {
            line = 2;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS.getCode().equals(betCode)) {
            line = 1;
        }
        return line;
    }

    private static int findDtNumCount(String betCode) {
        int m = 0;
        if (LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDT.getCode().equals(betCode)) {
            m = 8;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDT.getCode().equals(betCode)) {
            m = 7;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDT.getCode().equals(betCode)) {
            m = 6;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDT.getCode().equals(betCode)) {
            m = 5;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDT.getCode().equals(betCode)) {
            m = 4;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_QSZUXDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_SANXING_ZSZUXDT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_SANXING_HSZUXDT.getCode().equals(betCode)) {
            m = 3;
        } else if (LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODT.getCode().equals(betCode) || LotteryBettingEnum.SYX5_ERXING_QEZUXDT.getCode().equals(betCode) ||
                LotteryBettingEnum.SYX5_ERXING_HEZUXDT.getCode().equals(betCode)) {
            m = 2;
        }
        return m;
    }

}
