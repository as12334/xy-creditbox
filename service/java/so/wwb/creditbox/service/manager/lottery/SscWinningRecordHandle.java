package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

import java.util.*;

/**
 * Created by shook on 17-4-9.
 */
public class SscWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {
    private static List<String> oneDigitalBettingList = new ArrayList<>(5);
    private static List<String> oneDigitalPlayList = new ArrayList<>(5);
    private static List<String> fiveSumPlayList = new ArrayList<>(2);
    private static List<String> oneCombinationBettingList = new ArrayList<>(4);




    static {
        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_ONE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_TWO.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_THREE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_FOUR.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_FIVE.getCode());

        //大小，单双
        oneDigitalPlayList.add(LotteryPlayEnum.SSC_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SSC_SINGLE_DOUBLE.getCode());

        //總和、龍虎
        fiveSumPlayList.add(LotteryPlayEnum.SSC_SUM_BIG_SMALL.getCode());
        fiveSumPlayList.add(LotteryPlayEnum.SSC_SUM_SINGLE_DOUBLE.getCode());
        fiveSumPlayList.add(LotteryPlayEnum.SSC_DRAGON_TIGER_TIE.getCode());

        //一字组合
        oneCombinationBettingList.add(LotteryPlayEnum.SSC_ONE_FIRST_THREE.getCode());
        oneCombinationBettingList.add(LotteryPlayEnum.SSC_ONE_IN_THREE.getCode());
        oneCombinationBettingList.add(LotteryPlayEnum.SSC_ONE_AFTER_THREE.getCode());



    }

    @Override
    public WinningRecordHandleVo handle(LotteryResult lotteryResult) {
        if (isIllegalResult(lotteryResult)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecordHandleVo winningRecordHandleVo = new WinningRecordHandleVo();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        if (openCodes != null && openCodes.length == 5) {
            lotteryWinningRecordList.addAll(createOneDigital(lotteryResult));
            lotteryWinningRecordList.addAll(createFive(lotteryResult));
            lotteryWinningRecordList.addAll(createOneCombination(lotteryResult));
        }
        winningRecordHandleVo.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecordHandleVo;
    }

    private List<LotteryWinningRecord> createOneDigital(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, oneDigitalBettingList.get(i));
            for (String playCode : oneDigitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case SSC_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case SSC_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case SSC_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 构造總和、龍虎的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createFive(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer fiveSum = generateTotalSum(openCodes);
        for (String playCode : fiveSumPlayList) {
            String winningNum = null;
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            if (LotteryPlayEnum.SSC_SUM_BIG_SMALL.equals(lotteryPlayEnum)) {
                winningNum = generateTotalBigSmallNum(fiveSum);
            }
            else if (LotteryPlayEnum.SSC_SUM_SINGLE_DOUBLE.equals(lotteryPlayEnum)) {
                winningNum = generateTotalSingleDoubleNum(fiveSum);
            }
            else if (LotteryPlayEnum.SSC_DRAGON_TIGER_TIE.equals(lotteryPlayEnum)) {
                winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[4]));
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SSC_SUM_DRAGON_TIGER, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    /**
     * 构造一字组合的中奖记录，包含全五，前三，中三，后三
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneCombination(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String playCode : oneCombinationBettingList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNumSet = null;
            switch (lotteryPlayEnum) {
                case SSC_ONE_FIRST_THREE:
                    winningNumSet = generateTeshuWinnum(openCodes[0], openCodes[1], openCodes[2]);
                    break;
                case SSC_ONE_IN_THREE:
                    winningNumSet = generateTeshuWinnum(openCodes[1], openCodes[2], openCodes[3]);
                    break;
                case SSC_ONE_AFTER_THREE:
                    winningNumSet = generateTeshuWinnum(openCodes[2], openCodes[3], openCodes[4]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SSC_SUM_DRAGON_TIGER, winningNumSet);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }
}
