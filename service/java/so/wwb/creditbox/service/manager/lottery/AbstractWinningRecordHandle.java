package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;

import java.util.*;

/**
 * Created by shook on 17-4-18.
 */
public abstract class AbstractWinningRecordHandle{

    static final Log log = LogFactory.getLog(AbstractWinningRecordHandle.class);

    /**
     * 开奖记录是否合法
     *
     * @param lotteryResult
     * @return true:合法 false:非法
     */
    boolean isIllegalResult(LotteryResult lotteryResult) {
        return lotteryResult == null || StringTool.isBlank(lotteryResult.getCode())
                || StringTool.isBlank(lotteryResult.getOpenCode())
                || StringTool.isBlank(lotteryResult.getExpect());
    }

    /**
     * 所有开奖号码求和
     *
     * @param openCodes 开奖号码数组
     * @return 总和
     */
    Integer generateTotalSum(String[] openCodes) {
        Integer totalSum = 0;
        for (String openCode : openCodes) {
            totalSum += Integer.valueOf(openCode);
        }
        return totalSum;
    }

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
     *
     * @param totalSum
     * @return
     */
    boolean isSumBigNum(Integer totalSum) {
        return false;
    }

    /**
     * 判断总和的大小，返回总大，总小
     * [重庆幸运农场/广东快乐十分有和局]
     *
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
     *
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
     *
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
     *
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
     * 豹子
     * 順子
     * 對子
     * 半順
     * 雜六
     *
     * @param openCodes
     * @return
     */
    String generateTeshuWinnum(String... openCodes) {
        if (openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])) {
            return LotteryWinningNum.THREE_SAME;
        }
        else if (openCodes[0].equals(openCodes[1]) || openCodes[0].equals(openCodes[2]) || openCodes[1].equals(openCodes[2])) {
            return LotteryWinningNum.PAIR;
        }
        else if (checkStraight(openCodes)) {
            return LotteryWinningNum.STRAIGHT;
        }
        else if (checkHalfStraight(openCodes)) {
            return LotteryWinningNum.HALF_STRAIGHT;
        }
        else {
            return LotteryWinningNum.SIX;
        }
    }

    /**
     * 判断是否是顺子
     *
     * @param openCodes
     * @return
     */
    private boolean checkStraight(String... openCodes) {
        List<String> list = Arrays.asList(openCodes);
        Collections.sort(list);
        if (list.contains("0") && list.contains("9") && (list.contains("1") || list.contains("8"))) {
            return true;
        }
        Integer num1 = Integer.valueOf(list.get(0));
        Integer num2 = Integer.valueOf(list.get(1));
        Integer num3 = Integer.valueOf(list.get(2));
        return num2 == num1 + 1 && num2 == num3 - 1;
    }

    /**
     * 判断是否是半顺
     *
     * @param openCodes
     * @return
     */
    private boolean checkHalfStraight(String... openCodes) {
        List<String> list = Arrays.asList(openCodes);
        Collections.sort(list);
        if (list.contains("0") && list.contains("9")) {
            return true;
        }
        Integer num1 = Integer.valueOf(list.get(0));
        Integer num2 = Integer.valueOf(list.get(1));
        Integer num3 = Integer.valueOf(list.get(2));
        return num2 == num1 + 1 || num2 == num3 - 1;
    }

    /**
     * 获取数字的尾数
     *
     * @param numCode 号码
     * @return 尾数0~9
     */
    String generateMantissa(String numCode) {
        if (StringTool.isBlank(numCode)) {
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
     * 生成中奖结果对象
     *
     * @param lotteryResult      开奖结果
     * @param lotteryPlayEnum    彩种玩法
     * @param lotteryBettingEnum 投注玩法
     * @param winningNum         中奖号码
     * @return 中奖结果对象
     */
    protected LotteryWinningRecord createWinningRecord(LotteryResult lotteryResult, LotteryPlayEnum lotteryPlayEnum, LotteryBettingEnum lotteryBettingEnum, String winningNum) {
        if (StringTool.isBlank(winningNum)) {
            return null;
        }
        LotteryWinningRecord lotteryWinningRecord = new LotteryWinningRecord();
        lotteryWinningRecord.setExpect(lotteryResult.getExpect());
        lotteryWinningRecord.setType(lotteryResult.getType());
        lotteryWinningRecord.setCode(lotteryResult.getCode());
        lotteryWinningRecord.setPlayCode(lotteryPlayEnum.getCode());
        lotteryWinningRecord.setBetCode(lotteryBettingEnum.getCode());
        lotteryWinningRecord.setWinningNum(winningNum);
        lotteryWinningRecord.setCreateTime(new Date());
        return lotteryWinningRecord;
    }

}
