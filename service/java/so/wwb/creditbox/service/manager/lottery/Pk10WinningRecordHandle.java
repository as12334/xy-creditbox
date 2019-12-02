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

        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_3.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_4.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_5.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_6.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_7.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_8.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_9.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_10.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_11.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_12.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_13.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_14.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_15.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_16.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_17.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_18.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SUM_19.getCode());

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

                case CHAMPION_UP_SUM_3:
                    winningNum = 3 + "";
                    break;
                case CHAMPION_UP_SUM_4:
                    winningNum = 4 + "";
                    break;
                case CHAMPION_UP_SUM_5:
                    winningNum = 5 + "";
                    break;
                case CHAMPION_UP_SUM_6:
                    winningNum = 6 + "";
                    break;
                case CHAMPION_UP_SUM_7:
                    winningNum = 7 + "";
                    break;
                case CHAMPION_UP_SUM_8:
                    winningNum = 8 + "";
                    break;
                case CHAMPION_UP_SUM_9:
                    winningNum = 9 + "";
                    break;
                case CHAMPION_UP_SUM_10:
                    winningNum = 10 + "";
                    break;
                case CHAMPION_UP_SUM_11:
                    winningNum = 11 + "";
                    break;
                case CHAMPION_UP_SUM_12:
                    winningNum = 12 + "";
                    break;
                case CHAMPION_UP_SUM_13:
                    winningNum = 13 + "";
                    break;
                case CHAMPION_UP_SUM_14:
                    winningNum = 14 + "";
                    break;
                case CHAMPION_UP_SUM_15:
                    winningNum = 15 + "";
                    break;
                case CHAMPION_UP_SUM_16:
                    winningNum = 16 + "";
                    break;
                case CHAMPION_UP_SUM_17:
                    winningNum = 17 + "";
                    break;
                case CHAMPION_UP_SUM_18:
                    winningNum = 18 + "";
                    break;
                case CHAMPION_UP_SUM_19:
                    winningNum = 19 + "";
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
