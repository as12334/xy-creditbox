package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.creditbox.utility.NnResultFormatTool;

import java.util.*;

public abstract class AbstractWinningRecordHandle {

    //region log
    static final Log log = LogFactory.getLog(AbstractWinningRecordHandle.class);
    //endregion

    //region 开奖记录是否合法
    boolean isIllegalResult(LotteryResultNumber lotteryResult) {
        return lotteryResult == null || StringTool.isBlank(lotteryResult.getCode())
                || StringTool.isBlank(lotteryResult.getOpenCode())
                || StringTool.isBlank(lotteryResult.getExpect());
    }
    //endregion

    //region 所有开奖号码求和
    Integer generateTotalSum(String[] openCodes) {
        Integer totalSum = 0;
        for (String openCode : openCodes) {
            totalSum += Integer.valueOf(openCode);
        }
        return totalSum;
    }
    //endregion

    /**
     * 判断总和的大小
     *
     * @param totalSum 号码
     * @return 大，小
     */
    String generateSumBigSmallNum(Integer totalSum) {
        if (isSumBigNum(totalSum)) {
            return LotteryWinningNum.BIG;
        } else {
            return LotteryWinningNum.SMALL;
        }
    }

    /**
     * 和数的大规则
     * @param totalSum
     * @return
     */
    boolean isSumBigNum(Integer totalSum) {
        return false;
    }

    /**
     * 判断总和的大小，返回总大，总小
     *[重庆幸运农场/广东快乐十分有和局]
     * @param totalSum 总和
     * @return 总大，总小
     */
    String generateTotalBigSmallNum(Integer totalSum) {
        if (isTotalBigNum(totalSum)) {
            return LotteryWinningNum.TOTAL_BIG;
        } else {
            return LotteryWinningNum.TOTAL_SMALL;
        }
    }

    boolean isTotalBigNum(Integer totalSum) {
        return true;
    }

    /**
     * 判断单数字的大小
     *
     * @param openCode 开奖号码
     * @return 大，小
     */
    String generateBigSmallNum(String openCode) {
        Integer num = Integer.valueOf(openCode);
        if (isBigNum(num)) {
            return LotteryWinningNum.BIG;
        } else {
            return LotteryWinningNum.SMALL;
        }
    }

    /**
     * 单个数字的大规则
     * @param num
     * @return
     */
    boolean isBigNum(Integer num) {
        return false;
    }


    /**
     * 判断该数字的单双
     *
     * @param num 号码
     * @return 单，双
     */
    String generateSingleDoubleNum(Integer num) {
        if (num % 2 == 0) {
            return LotteryWinningNum.DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE;
        }
    }

    /**
     * 生成合数单双
     * @param openCode 开奖号码
     * @return 合单，合双
     */
    String generateSingleSumSingleDoubleNum(String openCode) {
        Integer num = generateSingleSum(openCode);
        if (num % 2 == 0) {
            return LotteryWinningNum.SINGLE_SUM_DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE_SUM_SINGLE;
        }
    }

    /**
     * 生成总和单双
     * @param num 总和
     * @return 总单，总双
     */
    String generateTotalSingleDoubleNum(Integer num) {
        if (num % 2 == 0) {
            return LotteryWinningNum.TOTAL_DOUBLE;
        } else {
            return LotteryWinningNum.TOTAL_SINGLE;
        }
    }


    /**
     * 获取数字的尾数
     *
     * @param numCode 号码
     * @return 尾数0~9
     */
    String generateMantissa(String numCode) {
        if (StringTool.isBlank(numCode)){
            return null;
        }
        return numCode.substring(numCode.length() - 1, numCode.length());
    }

    /**
     * 判断尾数的大小
     *
     * @param openCode 开奖号码
     * @return 尾大，尾小
     */
    String generateMantissaBigSmallNum(String openCode) {
        Integer num = Integer.valueOf(generateMantissa(openCode));
        if (isMatissaBigNum(num)) {
            return LotteryWinningNum.MANTISSA_BIG;
        } else {
            return LotteryWinningNum.MANTISSA_SMALL;
        }
    }


    /**
     * 判断总和尾数的大小
     *
     * @param total 总和
     * @return 总尾大，总尾小
     */
    String generateTotalMantissaBigSmallNum(Integer total) {
        String matissa = generateMantissa(String.valueOf(total));
        if (isMatissaBigNum(Integer.valueOf(matissa))) {
            return LotteryWinningNum.TOTAL_MANTISSA_BIG;
        } else {
            return LotteryWinningNum.TOTAL_MANTISSA_SMALL;
        }
    }

    boolean isMatissaBigNum(Integer num) {
        return num >= 5;
    }

    /**
     * 获取数字的合数
     *
     * @param numCode 开奖号码
     * @return 单号码的和
     */
    Integer generateSingleSum(String numCode) {
        if (numCode.length() == 1) {
            return Integer.valueOf(numCode);
        } else if (numCode.length() == 2) {
            return Integer.valueOf(numCode.substring(0, 1)) + Integer.valueOf(numCode.substring(1, 2));
        } else {
            return null;
        }
    }

    /**
     * 生成龙虎和结果
     *
     * @param dragon 龙位号码
     * @param tiger  虎位号码
     * @return
     */
    String generateDragonTigerTie(Integer dragon, Integer tiger) {
        if (dragon > tiger) {
            return LotteryWinningNum.DRAGON;
        } else if (dragon < tiger) {
            return LotteryWinningNum.TIGER;
        } else {
            return LotteryWinningNum.DRAGON_TIGER_TIE;
        }
    }

    /**
     * 生成质合结果
     *
     * @param num 号码
     * @return
     */
    String generatePrimeCombinedNum(Integer num) {

        if (num == 1 || num == 2 || num == 3 || num == 5 || num == 7) {
            return LotteryWinningNum.PRIME;
        } else if (num == 0 || num == 4 || num == 6 || num == 8 || num == 9) {
            return LotteryWinningNum.COMBINED;
        } else {
            return null;
        }
    }

    /**
     * 生成尾数质合结果
     * @param openCode 开奖结果
     * @return
     */
    String generateMantissaPrimeCombined(String openCode){
        Integer num = Integer.valueOf(generateMantissa(openCode));
        if (num == 1 || num == 2 || num == 3 || num == 5 || num == 7) {
            return LotteryWinningNum.MANTISSA_PRIME;
        } else if (num == 0 || num == 4 || num == 6 || num == 8 || num == 9) {
            return LotteryWinningNum.MANTISSA_COMBINED;
        } else {
            return null;
        }
    }


    /**
     * 生成组选三的中奖号码
     *
     * @param openCode1
     * @param openCode2
     * @param openCode3
     * @return
     */
    String generateGroup3Num(String openCode1, String openCode2, String openCode3) {
        if (openCode1.equals(openCode2) && openCode1.equals(openCode3)){
            return null;
        }
        if (!openCode1.equals(openCode2) && !openCode2.equals(openCode3) && !openCode1.equals(openCode3)){
            return null;
        }
        return sortOpenCode(openCode1, openCode2, openCode3);
    }


    /**
     * 生成组选六的中奖号码
     *
     * @param openCode1
     * @param openCode2
     * @param openCode3
     * @return
     */
    String generateGroup6Num(String openCode1, String openCode2, String openCode3) {
        if (!openCode1.equals(openCode2) && !openCode2.equals(openCode3) && !openCode1.equals(openCode3)) {
            return sortOpenCode(openCode1, openCode2, openCode3);
        }
        return null;
    }

    /**
     * 由小到大排序，去重
     *
     * @param openCode1
     * @param openCode2
     * @param openCode3
     * @return
     */
    private String sortOpenCode(String openCode1, String openCode2, String openCode3) {
        Set<String> openCodeSet = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.valueOf((String) o1) - Integer.valueOf((String) o2);
            }
        });
        String openCodes = "";
        openCodeSet.add(openCode1);
        openCodeSet.add(openCode2);
        openCodeSet.add(openCode3);
        for (String openCode : openCodeSet) {
            openCodes += openCode;
        }
        return openCodes;
    }

    /**
     * 生成跨度的中奖号码
     *
     * @param openCode1 开奖号码1
     * @param openCode2 开奖号码2
     * @param openCode3 开奖号码3
     * @return 跨度中奖号码
     */
    String generateSpanNum(String openCode1, String openCode2, String openCode3) {
        int max = Integer.valueOf(openCode1) > Integer.valueOf(openCode2) ? Integer.valueOf(openCode1) : Integer.valueOf(openCode2);
        max = max > Integer.valueOf(openCode3) ? max : Integer.valueOf(openCode3);
        int min = Integer.valueOf(openCode1) < Integer.valueOf(openCode2) ? Integer.valueOf(openCode1) : Integer.valueOf(openCode2);
        min = min < Integer.valueOf(openCode3) ? min : Integer.valueOf(openCode3);
        return String.valueOf(max - min);
    }


    /**
     * 生成中奖结果对象
     *
     * @param lotteryResult      开奖结果
     * @param lotteryPlayEnum    彩种玩法
     * @param lotteryBettingEnum 投注玩法
     * @param winningNum         中奖号码
     * @return 中奖结果对象
     */
    protected LotteryWinningRecord createWinningRecord(LotteryResultNumber lotteryResult, LotteryPlayEnum lotteryPlayEnum, LotteryBettingEnum lotteryBettingEnum, String winningNum) {
        if (StringTool.isBlank(winningNum)) {
            return null;
        }
        LotteryWinningRecord lotteryWinningRecord = new LotteryWinningRecord();
        lotteryWinningRecord.setExpect(lotteryResult.getExpect());
        lotteryWinningRecord.setCode(lotteryResult.getCode());
        lotteryWinningRecord.setPlayCode(lotteryPlayEnum.getCode());
        lotteryWinningRecord.setBetCode(lotteryBettingEnum.getCode());
        lotteryWinningRecord.setWinningNum(winningNum);
        lotteryWinningRecord.setCreateTime(new Date());
        return lotteryWinningRecord;
    }

    /**
     * 生成中奖结果对象
     *
     * @param lotteryResult      开奖结果
     * @param playCode    彩种玩法
     * @param betCode 投注玩法
     * @param openCodes         中奖号码
     * @return 中奖结果对象
     */
    protected LotteryWinningRecord createNiuWinningRecord(LotteryResultNumber lotteryResult, String playCode, String betCode, LotteryBetNumEnum nnBetNumEnum, String... openCodes) {
        if (StringTool.isBlank(openCodes.toString())) {
            return null;
        }
        LotteryWinningRecord lotteryWinningRecord = new LotteryWinningRecord();
        lotteryWinningRecord.setExpect(lotteryResult.getExpect());
        lotteryWinningRecord.setCode(lotteryResult.getCode());
        lotteryWinningRecord.setPlayCode(playCode);
        lotteryWinningRecord.setBetCode(betCode);
        lotteryWinningRecord.setCreateTime(new Date());
        lotteryWinningRecord.setBetNum(nnBetNumEnum.getCode());
        createNiuPk10 (playCode, nnBetNumEnum, lotteryWinningRecord , openCodes);
        return lotteryWinningRecord;
    }

    /**
     * 生成牛牛Winnum
     * @return
     */
    private void createNiuPk10(String playCode, LotteryBetNumEnum nnBetNumEnum, LotteryWinningRecord lotteryWinningRecord, String... openCodes){
        String[] winNum = new String[5];
        switch (nnBetNumEnum){
            case NN_XIAN_YI:
                System.arraycopy(openCodes, 1, winNum, 0, 5);
                break;
            case NN_XIAN_ER:
                System.arraycopy(openCodes, 2, winNum, 0, 5);
                break;
            case NN_XIAN_SAN:
                System.arraycopy(openCodes, 3, winNum, 0, 5);
                break;
            case NN_XIAN_SI:
                System.arraycopy(openCodes, 4, winNum, 0, 5);
                break;
            case NN_XIAN_WU:
                System.arraycopy(openCodes, 5, winNum, 0, 5);
            default:
                break;
        }
        List<String> xian = Arrays.asList(winNum);
        List<String> xianList = new ArrayList<>(xian);
        String[] zhuangWin = new String[5];
        System.arraycopy(openCodes, 0, zhuangWin, 0, 5);
        List<String> zhuang = Arrays.asList(zhuangWin);
        List<String> zhuangList = new ArrayList<>(zhuang);
        if (LotteryPlayEnum.NN_LEVEL.getCode().equals(playCode)) {
            createNiuPk10WinPb(xian, zhuang,lotteryWinningRecord);
        } else if (LotteryPlayEnum.NN_MULTIPLE.getCode().equals(playCode)) {
            createNiuPk10WinFb (xianList, zhuangList,lotteryWinningRecord);
        }
    }


    private void createNiuPk10WinFb (List<String> xian, List<String> zhaungWin,LotteryWinningRecord lotteryWinningRecord) {
        String betNum = "";
        Integer betOdd = 1;
        int xianResult = NnResultFormatTool.getScroe(xian);
        int zhuangResult = NnResultFormatTool.getScroe(zhaungWin);
        if (xianResult == zhuangResult) {
            betNum = NnResultFormatTool.getNiuBetNum (xianResult);
            betOdd = getNiuBetOdd (betNum);
            if (xianResult > 6) {
                if (Integer.valueOf(xian.get(0)) < Integer.valueOf(zhaungWin.get(0))) {
                    betOdd = -betOdd;
                }
            } else {
                betOdd = -betOdd;
            }
        } else if (xianResult > zhuangResult) {
            betNum = NnResultFormatTool.getNiuBetNum (xianResult);
            betOdd = getNiuBetOdd (betNum);
        } else if (xianResult < zhuangResult) {
            betNum = NnResultFormatTool.getNiuBetNum (zhuangResult);
            betOdd = -getNiuBetOdd (betNum);
        }
        lotteryWinningRecord.setBetOdd(betOdd);
    }

    private void createNiuPk10WinPb (List<String> xian, List<String> zhaungWin,LotteryWinningRecord lotteryWinningRecord) {
        Integer betOdd = 1;
        int xianResult = NnResultFormatTool.getScroe(xian);
        int zhuangResult = NnResultFormatTool.getScroe(zhaungWin);
        if (xianResult == zhuangResult) {
            betOdd = 1;
            if (xianResult > 6) {
                if (Integer.valueOf(xian.get(0)) < Integer.valueOf(zhaungWin.get(0))) {
                    betOdd = -1;
                }
            } else {
                betOdd = -1;
            }

        } else if (xianResult > zhuangResult) {
            betOdd = 1;
        } else if (xianResult < zhuangResult) {
            betOdd = -1;
        }
        lotteryWinningRecord.setBetOdd(betOdd);
    }

    private Integer getNiuBetOdd (String betNum) {
        Integer betOdd = 0;
        if ("无牛".equals(betNum) || "牛一".equals(betNum) || "牛二".equals(betNum) || "牛三".equals(betNum) ||
                "牛四".equals(betNum) || "牛五".equals(betNum) || "牛六".equals(betNum)) {
            betOdd = 2;
        } else if ("牛七".equals(betNum) || "牛八".equals(betNum)) {
            betOdd = 3;
        } else if ("牛九".equals(betNum)) {
            betOdd = 4;
        } else if ("牛牛".equals(betNum)) {
            betOdd = 6;
        }
        return betOdd;
    }
    /**
     * 生成组选组三中奖号码
     */
    protected List<String> createZuxuanZu3(String num1,String num2,String num3){
        List<String> winNumList = new ArrayList<>();
        if(num1.equals(num2)){
            winNumList.add(num1 + num1 + num3);
            winNumList.add(num1 +  num3 + num1);
            winNumList.add(num3 + num1 + num1);
        }else if(num1.equals(num3)){
            winNumList.add(num1 + num1 + num2);
            winNumList.add(num1 + num2 + num1);
            winNumList.add(num2 + num1 +  num1);
        }else if (num2.equals(num3)){
            winNumList.add(num1 + num2 + num2);
            winNumList.add(num2 + num2 + num1);
            winNumList.add(num2 + num1 + num2);
        }
        return winNumList;
    }

    /**
     * 生成组选混合组三中奖号码
     */
    protected List<String> createZuxuanHhZu3(String num1,String num2,String num3){
        List<String> winNumList = new ArrayList<>();
        if(num1.equals(num2)){
            winNumList.add(num1 + "," + num1 + "" + num3);
            winNumList.add(num1 + ","+ num3 + "," + num1);
            winNumList.add(num3 + ","+ num1 + "," + num1);
        }else if(num1.equals(num3)){
            winNumList.add(num1 + "," + num1 + "," + num2);
            winNumList.add(num1 + "," + num2 + "," + num1);
            winNumList.add(num2 + "," + num1 + "," + num1);
        }else if (num2.equals(num3)){
            winNumList.add(num1 + "," + num2 + "," + num2);
            winNumList.add(num2 + "," + num2 + "," + num1);
            winNumList.add(num2 + "," + num1 + "," + num2);
        }
        return winNumList;
    }
}