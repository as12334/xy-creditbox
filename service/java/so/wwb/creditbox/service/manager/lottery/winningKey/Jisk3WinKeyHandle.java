package so.wwb.creditbox.service.manager.lottery.winningKey;

import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rambo on 18-9-12.
 */
public class Jisk3WinKeyHandle implements IWinRecordKeyHandle {

    static {

    }


    @Override
    public List<String> handle(String code,List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        Integer sum = 0;

        for (int i = 0; i < resultList.size(); i++) {
            //三军
            winningRecordList.add(LotteryBettingEnum.ARMED_FORCES.getCode() + "_" + resultList.get(i));
            sum += Integer.valueOf(resultList.get(i));
        }
        //点数
        winningRecordList.add(LotteryBettingEnum.POINTS.getCode() + "_" + sum);
        if (!isThreeSame(resultList)) {
            if (sum >= 11) {
                winningRecordList.add(LotteryBettingEnum.POINTS.getCode() + "_" + LotteryWinningNum.BIG);
            } else {
                winningRecordList.add(LotteryBettingEnum.POINTS.getCode() + "_" + LotteryWinningNum.SMALL);
            }
            if (sum % 2 == 0) {
                winningRecordList.add(LotteryBettingEnum.POINTS.getCode() + "_" + LotteryWinningNum.DOUBLE);
            } else {
                winningRecordList.add(LotteryBettingEnum.POINTS.getCode() + "_" + LotteryWinningNum.SINGLE);
            }
        }
        //围骰/全骰
        if (isThreeSame(resultList)) {
            winningRecordList.add(LotteryBettingEnum.DICE_FULL_DICE.getCode() + "_" + LotteryWinningNum.FULL_DICE);
            winningRecordList.add(LotteryBettingEnum.DICE_FULL_DICE.getCode() + "_" + resultList.get(0) + resultList.get(1) + resultList.get(2));
        }
        // 长牌
        List<String> list = generateLongCardNum (resultList);
        for (String num : list) {
            winningRecordList.add(LotteryBettingEnum.LONG_CARD.getCode() + "_" + num);
        }
        //短牌
        String num = generateShortCardNum (resultList);
        winningRecordList.add(LotteryBettingEnum.SHORT_CARD.getCode() + "_" + num);
        return winningRecordList;
    }

    private boolean isThreeSame(List<String> resultList) {
        return resultList.get(0).equals(resultList.get(1)) && resultList.get(1).equals(resultList.get(2));
    }

    /**
     * 生成长牌的
     *
     * @param resultList
     * @return
     */
    private List<String> generateLongCardNum(List<String> resultList) {
        List<String> winningNumList = new ArrayList<>();
        if (isThreeSame(resultList)) {//三同
            return winningNumList;
        } else if (isThreeDifferent(resultList)) {//三不同
            winningNumList.add(Integer.valueOf(resultList.get(0)) > Integer.valueOf(resultList.get(1)) ? resultList.get(1) + resultList.get(0) : resultList.get(0) + resultList.get(1));
            winningNumList.add(Integer.valueOf(resultList.get(0)) > Integer.valueOf(resultList.get(2)) ? resultList.get(2) + resultList.get(0) : resultList.get(0) + resultList.get(2));
            winningNumList.add(Integer.valueOf(resultList.get(1)) > Integer.valueOf(resultList.get(2)) ? resultList.get(2) + resultList.get(1) : resultList.get(1) + resultList.get(2));
        } else {//二同+1
            String result1;
            String result2;
            if (resultList.get(0).equals(resultList.get(1))) {
                result1 = resultList.get(0);
                result2 = resultList.get(2);
            } else {
                result1 = resultList.get(0);
                result2 = resultList.get(1);
            }
            winningNumList.add(Integer.valueOf(result1) > Integer.valueOf(result2) ? result2 + result1 : result1 + result2);
        }
        return winningNumList;
    }

    /**
     * 生成短牌结果
     *
     * @param resultList
     * @return
     */
    private String generateShortCardNum(List<String> resultList) {
        if (isThreeDifferent(resultList)) {
            return null;
        }
        if (resultList.get(0).equals(resultList.get(1))) {
            return resultList.get(0) + resultList.get(1);
        } else {
            return resultList.get(1) + resultList.get(2);
        }
    }


    private boolean isThreeDifferent(List<String> resultList) {
        return !resultList.get(0).equals(resultList.get(1)) && !resultList.get(1).equals(resultList.get(2)) && !resultList.get(0).equals(resultList.get(2));
    }
}
