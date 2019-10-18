package so.wwb.creditbox.service.manager.lottery.winningKey;

import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shook on 17-4-10.
 */
public class Jspk10WinKeyHandle implements IWinRecordKeyHandle {
    private static List<String> oneDigitalBettingList = new ArrayList<>(8);

    static {
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
    }


    @Override
    public List<String> handle(String code,List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        //定位
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            winningRecordList.add(oneDigitalBettingList.get(i) + "_" + resultList.get(i));
            if (Integer.valueOf(resultList.get(i)) >= 6) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.BIG);
            } else {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.SMALL);
            }
            if (Integer.valueOf(resultList.get(i)) % 2 == 0) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.DOUBLE);
            } else {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.SINGLE);
            }
            if (i < 5 && Integer.valueOf(resultList.get(i)) > Integer.valueOf(resultList.get(9-i))) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.DRAGON);
            } else if (i < 5 && Integer.valueOf(resultList.get(i)) < Integer.valueOf(resultList.get(9-i))) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.TIGER);
            }
        }
        //冠亚和
        Integer championUpSum = Integer.valueOf(resultList.get(0)) + Integer.valueOf(resultList.get(1));
        winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + championUpSum);
        if (championUpSum > 11) {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SUM_BIG);
        } else {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SUM_SMALL);
        }
        if (championUpSum % 2 == 0) {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SUM_DOUBLE);
        } else {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SUM_SINGLE);
        }
        if (championUpSum % 2 == 0 && championUpSum > 11) {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.BIG_DOUBLE);
        } else if (championUpSum % 2 == 0 && championUpSum < 11) {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SMALL_DOUBLE);
        } else if (championUpSum % 2 != 0 && championUpSum > 11) {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.BIG_SINGLE);
        } else {
            winningRecordList.add(LotteryBettingEnum.CHAMPION_UP_SUM.getCode() + "_" + LotteryWinningNum.SMALL_SINGLE);
        }
        return winningRecordList;
    }
}
