package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shook on 17-8-15.
 */
public class Xy28WinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> sumList = new ArrayList<>();

    private static List<Integer> redList = new ArrayList<>();

    private static List<Integer> blueList = new ArrayList<>();

    private static List<Integer> greenList = new ArrayList<>();

    static {
        sumList.add(LotteryPlayEnum.XY28_SUM3_BIG_SMALL.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_SINGLE_DOUBLE.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_HALF.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_EXTREME.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_COLOUR.getCode());
        sumList.add(LotteryPlayEnum.XY28_THREE_SAME.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_DIGITAL.getCode());
        sumList.add(LotteryPlayEnum.XY28_SUM3_DIGITAL_THREE.getCode());

        greenList.add(1);
        greenList.add(4);
        greenList.add(7);
        greenList.add(10);
        greenList.add(16);
        greenList.add(19);
        greenList.add(22);
        greenList.add(25);

        blueList.add(2);
        blueList.add(5);
        blueList.add(8);
        blueList.add(11);
        blueList.add(17);
        blueList.add(20);
        blueList.add(23);
        blueList.add(26);

        redList.add(3);
        redList.add(6);
        redList.add(9);
        redList.add(12);
        redList.add(15);
        redList.add(18);
        redList.add(21);
        redList.add(24);
    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createSum(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);

        return winningRecord;
    }

    private List<LotteryWinningRecord> createSum(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer threeSum = generateTotalSum(openCodes);
        for (String playCode : sumList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case XY28_SUM3_BIG_SMALL:
                    winningNum = generateSumBigSmallNum(threeSum);
                    break;
                case XY28_SUM3_SINGLE_DOUBLE:
                    winningNum = generateSingleDoubleNum(threeSum);
                    break;
                case XY28_SUM3_HALF:
                    winningNum = generateHalf(threeSum);
                    break;
                case XY28_SUM3_EXTREME:
                    winningNum = generateExtreme(threeSum);
                    break;
                case XY28_SUM3_COLOUR:
                    winningNum = generateColour(threeSum);
                    break;
                case XY28_THREE_SAME:
                    winningNum = generateThreeSame(openCodes);
                    break;
                case XY28_SUM3_DIGITAL:
                    winningNum = String.valueOf(threeSum);
                    break;
                case XY28_SUM3_DIGITAL_THREE:
                    winningNum = String.valueOf(threeSum);
                    break;
                default:
                    break;
            }

            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.XY28_SUM3, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.幸运28.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private String generateThreeSame(String[] openCodes) {
        if (openCodes[0].equals(openCodes[1]) && openCodes[1].equals(openCodes[2]))
            return LotteryWinningNum.THREE_SAME;
        return null;
    }

    /**
     * 13,14不中奖
     * @param threeSum
     * @return
     */
    private String generateColour(Integer threeSum) {
        if (greenList.contains(threeSum)) {
            return LotteryWinningNum.GREEN_WAVE;
        } else if (blueList.contains(threeSum)) {
            return LotteryWinningNum.BLUE_WAVE;
        } else if (redList.contains(threeSum)) {
            return LotteryWinningNum.RED_WAVE;
        }
        return null;
    }

    private String generateExtreme(Integer threeSum) {
        if (threeSum <= 5) {
            return LotteryWinningNum.EXTREME_SMALL;
        } else if (threeSum >= 22) {
            return LotteryWinningNum.EXTREME_BIG;
        } else {
            return null;
        }
    }

    private String generateHalf(Integer threeSum) {
        if (threeSum % 2 == 0 && threeSum >= 14) {
            return LotteryWinningNum.BIG_DOUBLE;
        } else if (threeSum % 2 == 0 && threeSum < 14) {
            return LotteryWinningNum.SMALL_DOUBLE;
        } else if (threeSum % 2 != 0 && threeSum >= 14) {
            return LotteryWinningNum.BIG_SINGLE;
        } else {
            return LotteryWinningNum.SMALL_SINGLE;
        }
    }

    @Override
    boolean isSumBigNum(Integer totalSum) {
        return totalSum >= 14;
    }

}
