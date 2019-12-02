package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shook on 17-4-10.
 */
public class Pk10WinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> oneDigitalBettingList = new ArrayList<>(8);

    private static List<String> oneDigitalPlayList = new ArrayList<>(5);

    private static List<String> championUpSumPlayList = new ArrayList<>(3);

    static {
        //投注玩法：百十个
        oneDigitalBettingList.add(LotteryBettingEnum.CHAMPION.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RUNNER_UP.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.THIRD_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.FOURTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.FIFTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SIXTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SEVENTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.EIGHTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.NINTH_RUNNER.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.TENTH_RUNNER.getCode());
        //百十个对应的彩种玩法
        oneDigitalPlayList.add(LotteryPlayEnum.PK10_DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PK10_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PK10_SINGLE_DOUBLE.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PK10_DRAGON_TIGER.getCode());


        //冠亚和
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_BIG_SMALL.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SINGLE_DOUBLE.getCode());

    }

    @Override
    public WinningRecordHandleVo handle(LotteryResult lotteryResult) {

        if (isIllegalResult(lotteryResult)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecordHandleVo winningRecordHandleVo = new WinningRecordHandleVo();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createDigital(lotteryResult));
        lotteryWinningRecordList.addAll(createChampionUpSum(lotteryResult));
        //官方玩法
//        lotteryWinningRecordList.addAll(createOffical(lotteryResult));
        winningRecordHandleVo.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecordHandleVo;
    }

    private List<LotteryWinningRecord> createDigital(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, oneDigitalBettingList.get(i));
            for (String playCode : oneDigitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case PK10_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case PK10_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case PK10_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case PK10_DRAGON_TIGER:
                        winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[i]), Integer.valueOf(openCodes[9 - i]));
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }
    private List<LotteryWinningRecord> createChampionUpSum(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer championUpSum = generateChampionUpSum(openCodes);
        for (String playCode : championUpSumPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case CHAMPION_UP_BIG_SMALL:
                    winningNum = generateChampionUpSumBigSmall(lotteryResult.getCode(), championUpSum);
                    break;
                case CHAMPION_UP_SINGLE_DOUBLE:
                    winningNum = generateChampionUpSumSingleDouble(lotteryResult.getCode(), championUpSum);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.CHAMPION_UP_SUM, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    @Override
    boolean isBigNum(Integer num) {
        return num >= 6;
    }

    private Integer generateChampionUpSum(String[] openCodes) {
        Integer championUpSum = Integer.valueOf(openCodes[0]) + Integer.valueOf(openCodes[1]);
        return championUpSum;
    }


    private String generateChampionUpSumBigSmall(String code, Integer championUpSum) {
        if (isNeedDraw(code) && championUpSum == 11) {
            return LotteryWinningNum.DRAW;
        } else if (championUpSum > 11) {
            return LotteryWinningNum.SUM_BIG;
        } else {
            return LotteryWinningNum.SUM_SMALL;
        }
    }

    private String generateChampionUpSumSingleDouble(String code, Integer championUpSum) {
        if (isNeedDraw(code) && championUpSum == 11) {
            return LotteryWinningNum.DRAW;
        } else if (championUpSum % 2 == 0) {
            return LotteryWinningNum.SUM_DOUBLE;
        } else {
            return LotteryWinningNum.SUM_SINGLE;
        }
    }

    /**
     * 是否需要和局
     *
     * @param code 彩种代号
     * @return
     */
    boolean isNeedDraw(String code) {
        return LotteryEnum.BJPK10.getCode().equals(code);
    }



}
