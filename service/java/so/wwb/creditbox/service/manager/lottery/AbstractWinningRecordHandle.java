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
     *
     * @param openCode 开奖结果
     * @return
     */
    String generateMantissaPrimeCombined(String openCode) {
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
        if (openCode1.equals(openCode2) && openCode1.equals(openCode3)) {
            return null;
        }
        if (!openCode1.equals(openCode2) && !openCode2.equals(openCode3) && !openCode1.equals(openCode3)) {
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
    protected LotteryWinningRecord createWinningRecord(LotteryResult lotteryResult, LotteryPlayEnum lotteryPlayEnum, LotteryBettingEnum lotteryBettingEnum, String winningNum) {
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

}
