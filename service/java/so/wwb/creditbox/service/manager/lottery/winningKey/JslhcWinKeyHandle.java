package so.wwb.creditbox.service.manager.lottery.winningKey;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rambo on 18-9-12.
 */
public class JslhcWinKeyHandle implements IWinRecordKeyHandle {

    private static List<String> specialBettingList = new ArrayList<>(2);

    /**
     * 正码1-6的投注玩法[正码一,正码二,正码三,正码四,正码五,正码六]
     */
    private static List<String> positiveBettingList = new ArrayList<>(6);
    static {
        specialBettingList.add(LotteryBettingEnum.SPECIAL_A.getCode());
        specialBettingList.add(LotteryBettingEnum.SPECIAL_B.getCode());

        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FIRST.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_SECOND.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_THIRD.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FOURTH.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_FIFTH.getCode());
        positiveBettingList.add(LotteryBettingEnum.POSITIVE_SIXTH.getCode());
    }


    @Override
    public List<String> handle(String code,List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        //特码,半波,特肖
        winningRecordList.addAll(specialWinKey (resultList));
        //正码,正码1~6
        winningRecordList.addAll(positiveWinKey (resultList));
        //总和,一肖
        winningRecordList.addAll(sevenSumWinKey (resultList));

        return winningRecordList;
    }

    private List<String> specialWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        String special = resultList.get(6);
        Integer specialSum = generateSingleSum (special);
        //特码
        for (String betting : specialBettingList) {
            winningRecordList.add(betting + "_" + special);
            winningRecordList.add(betting + "_" + generateColourNum (special));
            if (isDraw(special)) {
                winningRecordList.add(betting + "_" + LotteryWinningNum.DRAW);
            } else {
                winningRecordList.add(betting + "_" + generateBigSmallNum (special));
                winningRecordList.add(betting + "_" + generateSingleDoubleNum (special));
                winningRecordList.add(betting + "_" + generateSpecialHalfNum (special));
                winningRecordList.add(betting + "_" + generateSpecialSumSingleDoubleNum (specialSum));
                winningRecordList.add(betting + "_" + generateSpecialSumBigSmallNum (specialSum));
                winningRecordList.add(betting + "_" + generateMantissaBigSmallNum (special));
            }
        }
        //半波
        String color = generateColourNum (special);
        if (Integer.valueOf(special) >= 25) {
            if (LotteryWinningNum.RED_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_RED_BIG);
            } else if (LotteryWinningNum.BLUE_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_BLUE_BIG);
            } else if (LotteryWinningNum.GREEN_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_GREEN_BIG);
            }
        } else {
            if (LotteryWinningNum.RED_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_RED_SMALL);
            } else if (LotteryWinningNum.BLUE_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_BLUE_SMALL);
            } else if (LotteryWinningNum.GREEN_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_GREEN_SMALL);
            }
        }
        if (Integer.valueOf(special) % 2 == 0) {
            if (LotteryWinningNum.RED_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_RED_DOUBLE);
            } else if (LotteryWinningNum.BLUE_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_BLUE_DOUBLE);
            } else if (LotteryWinningNum.GREEN_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_GREEN_DOUBLE);
            }
        } else {
            if (LotteryWinningNum.RED_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_RED_SINGLE);
            } else if (LotteryWinningNum.BLUE_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_BLUE_SINGLE);
            } else if (LotteryWinningNum.GREEN_WAVE.equals(color)) {
                winningRecordList.add(LotteryBettingEnum.LHC_HALF_COLOUR.getCode() + "_" + LotteryWinningNum.LHC_HALFCOLOUR_GREEN_SINGLE);
            }
        }
        //特肖
        String zodiac = CacheBase.getLotteryLhcZodiacMap().get(special);
        winningRecordList.add(LotteryBettingEnum.SPECIAL.getCode() + "_" + zodiac);

        return winningRecordList;
    }

    private List<String> positiveWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        for (int i = 0; i < 6; i++ ) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, positiveBettingList.get(i));
            Integer sum = generateSingleSum (resultList.get(i));
            winningRecordList.add(LotteryBettingEnum.POSITIVE.getCode() + "_" + resultList.get(i));
            winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(i));
            winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateColourNum (resultList.get(i)));
            if (isDraw(resultList.get(i))) {
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + LotteryWinningNum.DRAW);
            } else {
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateBigSmallNum (resultList.get(i)));
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateSingleDoubleNum (resultList.get(i)));
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateSpecialSumSingleDoubleNum (sum));
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateSpecialSumBigSmallNum (sum));
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + generateMantissaBigSmallNum (resultList.get(i)));
            }
        }
        return winningRecordList;
    }

    private List<String> sevenSumWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        Integer sum = 0;
        for (String num : resultList) {
            winningRecordList.add(LotteryBettingEnum.LHC_ONE_ZODIAC.getCode() + "_" + CacheBase.getLotteryLhcZodiacMap().get(num));
            sum += Integer.valueOf(num);
        }
        if (sum >= 175) {
            winningRecordList.add(LotteryBettingEnum.SEVEN_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_BIG);
        } else {
            winningRecordList.add(LotteryBettingEnum.SEVEN_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_SMALL);
        }
        if (sum % 2 == 0) {
            winningRecordList.add(LotteryBettingEnum.SEVEN_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_DOUBLE);
        } else {
            winningRecordList.add(LotteryBettingEnum.SEVEN_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_SINGLE);
        }
        return winningRecordList;
    }

    /**
     * 是否平局
     *
     * @param openCode
     * @return
     */
    private boolean isDraw(String openCode) {
        return "49".equals(openCode);
    }

    /**
     * 判断单数字的大小
     *
     * @param openCode 开奖号码
     * @return 大，小
     */
    private String generateBigSmallNum(String openCode) {
        Integer num = Integer.valueOf(openCode);
        if (num >= 25) {
            return LotteryWinningNum.BIG;
        } else {
            return LotteryWinningNum.SMALL;
        }
    }

    /**
     * 判断该数字的单双
     *
     * @param openCode 号码
     * @return 单，双
     */
    private String generateSingleDoubleNum(String openCode) {
        if (Integer.valueOf(openCode) % 2 == 0) {
            return LotteryWinningNum.DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE;
        }
    }

    /**
     * 判断该数字的半特
     * @param openCode 号码
     * @return 大单,大小，小单，小双
     */
    private String generateSpecialHalfNum(String openCode) {
        if (Integer.valueOf(openCode) % 2 == 0 && Integer.valueOf(openCode) >= 25) {
            return LotteryWinningNum.BIG_DOUBLE;
        } else if (Integer.valueOf(openCode) % 2 == 0 && Integer.valueOf(openCode) < 25) {
            return LotteryWinningNum.SMALL_DOUBLE;
        } else if (Integer.valueOf(openCode) % 2 != 0 && Integer.valueOf(openCode) >= 25) {
            return LotteryWinningNum.BIG_SINGLE;
        } else {
            return LotteryWinningNum.SMALL_SINGLE;
        }
    }

    /**
     * 获取数字的合数
     *
     * @param numCode 开奖号码
     * @return 单号码的和
     */
    private Integer generateSingleSum(String numCode) {
        Integer sum = 0;
        if (!isDraw(numCode)) {
            if (numCode.length() == 1) {
                sum = Integer.valueOf(numCode);
            } else if (numCode.length() == 2) {
                sum = Integer.valueOf(numCode.substring(0, 1)) + Integer.valueOf(numCode.substring(1, 2));
            }
        }
        return sum;
    }
    /**
     * 判断和数字的大小
     *
     * @param specialSum 开奖号码
     * @return 大，小
     */
    private String generateSpecialSumSingleDoubleNum(Integer specialSum) {
        if (specialSum % 2 == 0) {
            return LotteryWinningNum.SINGLE_SUM_DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE_SUM_SINGLE;
        }
    }

    /**
     * 判断和数字的大小
     *
     * @param specialSum 开奖号码
     * @return 单，双
     */
    private String generateSpecialSumBigSmallNum(Integer specialSum) {
        if (specialSum >= 7) {
            return LotteryWinningNum.SINGLE_SUM_BIG;
        } else {
            return LotteryWinningNum.SINGLE_SUM_SMALL;
        }
    }

    /**
     * 判断尾数的大小
     *
     * @param openCode 开奖号码
     * @return 尾大，尾小
     */
    String generateMantissaBigSmallNum(String openCode) {
        Integer num = Integer.valueOf(generateMantissa(openCode));
        if (num >= 5) {
            return LotteryWinningNum.MANTISSA_BIG;
        } else {
            return LotteryWinningNum.MANTISSA_SMALL;
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
     * 获取数字的波色
     *
     * @param openCode 号码
     * @return 尾数0~9
     */
    private String generateColourNum(String openCode) {
        if (isRedCode (openCode)) {
            return LotteryWinningNum.RED_WAVE;
        } else if (isBlueCode (openCode)) {
            return LotteryWinningNum.BLUE_WAVE;
        } else if (isGreenCode (openCode)) {
            return LotteryWinningNum.GREEN_WAVE;
        }
        return null;
    }

    private boolean isRedCode (String openCode) {
        return "01".equals(openCode) || "02".equals(openCode) || "07".equals(openCode) || "08".equals(openCode) ||
                "12".equals(openCode) || "13".equals(openCode) || "18".equals(openCode) || "19".equals(openCode) ||
                "23".equals(openCode) || "24".equals(openCode) || "29".equals(openCode) || "30".equals(openCode) ||
                "34".equals(openCode) || "35".equals(openCode) || "40".equals(openCode) || "45".equals(openCode) ||
                "46".equals(openCode);
    }

    private boolean isBlueCode (String openCode) {
        return "03".equals(openCode) || "04".equals(openCode) || "09".equals(openCode) || "10".equals(openCode) ||
                "14".equals(openCode) || "15".equals(openCode) || "20".equals(openCode) || "25".equals(openCode) ||
                "26".equals(openCode) || "31".equals(openCode) || "36".equals(openCode) || "37".equals(openCode) ||
                "41".equals(openCode) || "42".equals(openCode) || "47".equals(openCode) || "48".equals(openCode);
    }

    private boolean isGreenCode (String openCode) {
        return "05".equals(openCode) || "06".equals(openCode) || "11".equals(openCode) || "16".equals(openCode) ||
                "17".equals(openCode) || "21".equals(openCode) || "22".equals(openCode) || "27".equals(openCode) ||
                "28".equals(openCode) || "32".equals(openCode) || "33".equals(openCode) || "38".equals(openCode) ||
                "39".equals(openCode) || "43".equals(openCode) || "44".equals(openCode) || "49".equals(openCode);
    }

}
