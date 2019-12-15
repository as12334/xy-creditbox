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


    static {
        //投注玩法：百十个
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_ONE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_TWO.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_THREE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_FOUR.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_FIVE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_SIX.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_SEVEN.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_EIGHT.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_NINE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.RANK_TEN.getCode());
        //百十个对应的彩种玩法
        oneDigitalPlayList.add(LotteryPlayEnum.DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SINGLE_DOUBLE.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.DRAGON_TIGER_TIE.getCode());



    }

    @Override
    public WinningRecordHandleVo handle(LotteryResult lotteryResult) {

        if (isIllegalResult(lotteryResult)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecordHandleVo winningRecordHandleVo = new WinningRecordHandleVo();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createChampionUpSum(lotteryResult));
        lotteryWinningRecordList.addAll(createDigital(lotteryResult));
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
                    case DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case DRAGON_TIGER_TIE:
                        if(i<5){
                            winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[i]), Integer.valueOf(openCodes[9 - i]));
                        }
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


        String winningNum;
        LotteryWinningRecord lotteryWinningRecord;
        if (championUpSum == 3) {
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_3, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 4){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_4, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 5){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_5, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 6){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_6, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 7){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_7, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 8){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_8, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 9){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_9, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 10){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_10, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 11){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_11, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 12){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_12, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 13){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_13, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 14){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_14, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 15){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_15, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 16){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_16, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 17){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_17, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 18){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_18, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        else if(championUpSum == 19){
            winningNum = championUpSum + "";
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.CHAMPION_UP_SUM_19, LotteryBettingEnum.RANK_ONE_TWO_SUM, winningNum);
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        winningNum = generateChampionUpSumBigSmall(lotteryResult.getCode(), championUpSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RANK_ONE_TWO_SUM_BIG_SMALL, LotteryBettingEnum.RANK_ONE_TWO_SUM_BIG_SMALL, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);

        winningNum = generateChampionUpSumSingleDouble(lotteryResult.getCode(), championUpSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RANK_ONE_TWO_SUM_SINGLE_DOUBLE, LotteryBettingEnum.RANK_ONE_TWO_SUM_SINGLE_DOUBLE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);
        return lotteryWinningRecordList;
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

    @Override
    boolean isBigNum(Integer num) {
        return num >= 6;
    }

}
