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




    static {
        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_ONE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_TWO.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_THREE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_FOUR.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_FIVE.getCode());

        //大小，单双
        oneDigitalPlayList.add(LotteryPlayEnum.DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SINGLE_DOUBLE.getCode());



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
                    case DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case SINGLE_DOUBLE:
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
        Integer totalSum = generateTotalSum(openCodes);

        String winningNum;
        LotteryWinningRecord lotteryWinningRecord;

        winningNum = totalSum + "";
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM, LotteryBettingEnum.SUM, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);

        winningNum = generateTotalBigSmallNum(totalSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_BIG_SMALL, LotteryBettingEnum.SUM_BIG_SMALL, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        winningNum = generateTotalSingleDoubleNum(totalSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_SINGLE_DOUBLE, LotteryBettingEnum.SUM_SINGLE_DOUBLE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[4]));
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_DRAGON_TIGER_TIE, LotteryBettingEnum.SUM_DRAGON_TIGER_TIE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


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

        String winningNum;
        LotteryWinningRecord lotteryWinningRecord;
        winningNum = generateTeshuWinnum(openCodes[0], openCodes[1], openCodes[2]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.ONE_FIRST_THREE, LotteryBettingEnum.ONE_FIRST_THREE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);

        winningNum = generateTeshuWinnum(openCodes[1], openCodes[2], openCodes[3]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.ONE_IN_THREE, LotteryBettingEnum.ONE_IN_THREE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        winningNum = generateTeshuWinnum(openCodes[2], openCodes[3], openCodes[4]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.ONE_AFTER_THREE, LotteryBettingEnum.ONE_AFTER_THREE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        return lotteryWinningRecordList;
    }
    @Override
    boolean isBigNum(Integer num) {
        return num >= 5;
    }
    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 23;
    }

}
