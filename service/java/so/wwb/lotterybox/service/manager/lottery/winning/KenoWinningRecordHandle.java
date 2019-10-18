package so.wwb.lotterybox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.lotterybox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryWinningNum;
import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
import java.util.List;

public class KenoWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> selectionPlayList = new ArrayList<>(5);

    private static List<String> sum20PlayList = new ArrayList<>(3);

    private static List<String> numberPlayList = new ArrayList<>(2);

    static {
        selectionPlayList.add(LotteryPlayEnum.KENO_SELECTION_ONE.getCode());
        selectionPlayList.add(LotteryPlayEnum.KENO_SELECTION_TWO.getCode());
        selectionPlayList.add(LotteryPlayEnum.KENO_SELECTION_THREE.getCode());
        selectionPlayList.add(LotteryPlayEnum.KENO_SELECTION_FOUR.getCode());
        selectionPlayList.add(LotteryPlayEnum.KENO_SELECTION_FIVE.getCode());

        sum20PlayList.add(LotteryPlayEnum.KENO_SUM20_BIG_SMALL.getCode());
        sum20PlayList.add(LotteryPlayEnum.KENO_SUM20_SINGLE_DOUBLE.getCode());
        sum20PlayList.add(LotteryPlayEnum.KENO_SUM20_FIVE_ELEMENTS.getCode());

        numberPlayList.add(LotteryPlayEnum.KENO_UP_DOWN.getCode());
        numberPlayList.add(LotteryPlayEnum.KENO_ODD_EVEN.getCode());

    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createSelection(number));
        lotteryWinningRecordList.addAll(createSum20(number));
        lotteryWinningRecordList.addAll(createNum(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);

        return winningRecord;
    }

    private List<LotteryWinningRecord> createNum(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String playCode : numberPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case KENO_UP_DOWN:
                    winningNum = generateUpDown(openCodes);
                    break;
                case KENO_ODD_EVEN:
                    winningNum = generateOddEven(openCodes);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.KENO_NUMBER, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快乐彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成上中下盘
     * @param openCodes
     * @return
     */
    private String generateUpDown(String[] openCodes){
        List<String> upList = new ArrayList<>();
        List<String> downList = new ArrayList<>();
        for (String openCode : openCodes){
            if (Integer.valueOf(openCode) <= 40){
                upList.add(openCode);
            }else {
                downList.add(openCode);
            }
        }
        if (upList.size() == downList.size()){
            return LotteryWinningNum.KENO_MIDDLE;
        }
        return upList.size() > downList.size() ? LotteryWinningNum.KENO_UP : LotteryWinningNum.KENO_DOWN;
    }

    /**
     * 生成奇偶和盘
     * @param openCodes
     * @return
     */
    private String generateOddEven(String[] openCodes){
        List<String> oddList = new ArrayList<>();
        List<String> evenList = new ArrayList<>();
        for (String openCode : openCodes){
            if (Integer.valueOf(openCode) % 2 == 0){
                evenList.add(openCode);
            }else {
                oddList.add(openCode);
            }
        }
        if (oddList.size() == evenList.size()){
            return LotteryWinningNum.KENO_DRAW;
        }
        return oddList.size() > evenList.size() ? LotteryWinningNum.KENO_ODD : LotteryWinningNum.KENO_EVEN;
    }

    /**
     * 生成和值中奖结果
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSum20(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer twentySum = generateTotalSum(openCodes);
        for (String playCode : sum20PlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case KENO_SUM20_BIG_SMALL:
                    winningNum = generateSumBigSmallNum(twentySum);
                    break;
                case KENO_SUM20_SINGLE_DOUBLE:
                    winningNum = generateSingleDoubleNum(twentySum);
                    break;
                case KENO_SUM20_FIVE_ELEMENTS:
                    winningNum = generateElements(twentySum);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.KENO_SUM20, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快乐彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private String generateElements(Integer twentySum) {
        if (twentySum >= 210 && twentySum <=695){
            return LotteryWinningNum.KENO_GOLD;
        }else if (twentySum >= 696 && twentySum <= 763){
            return LotteryWinningNum.KENO_WOOD;
        }else if (twentySum >= 764 && twentySum <= 855){
            return LotteryWinningNum.KENO_WATER;
        }else if (twentySum >= 856 && twentySum <= 923){
            return LotteryWinningNum.KENO_FIRE;
        }else if (twentySum >= 924 && twentySum <= 1410){
            return LotteryWinningNum.KENO_EARTH;
        }else {
            return null;
        }
    }

    @Override
    String generateSumBigSmallNum(Integer twentySum) {
        if (twentySum == 810){
            return LotteryWinningNum.KENO_810;
        }
        return super.generateSumBigSmallNum(twentySum);
    }

    @Override
    boolean isSumBigNum(Integer totalSum) {
        return totalSum > 810;
    }

    /**
     * 生成选号中奖结果
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSelection(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        for (String playCode : selectionPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.KENO_SELECTION, lotteryResult.getOpenCode());
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.快乐彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

}
