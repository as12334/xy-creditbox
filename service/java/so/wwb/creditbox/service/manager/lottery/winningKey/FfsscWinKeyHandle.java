package so.wwb.creditbox.service.manager.lottery.winningKey;

import org.soul.commons.enums.EnumTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rambo on 18-9-12.
 */
public class FfsscWinKeyHandle implements IWinRecordKeyHandle {

    private static List<String> oneDigitalBettingList = new ArrayList<>(5);

    private static List<String> twoDigitalBettingList = new ArrayList<>(10);

    private static List<String> threeDigitalBettingList = new ArrayList<>(10);

    private static List<String> oneCombinationBettingList = new ArrayList<>(4);

    private static List<String> spanBettingList = new ArrayList<>(9);

    static {
        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.HUNDRED.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.TEN.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.ONE.getCode());
        //二字定位的投注玩法
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_THOUSAND.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_HUNDRED.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_WAN_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_HUNDRED.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_THOUSAND_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_HUNDRED_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_HUNDRED_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.SSC_TEN_ONE.getCode());
        //三字定位的投注玩法
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_HUNDRED.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_THOUSAND_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_HUNDRED_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_HUNDRED_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.TEN_THOUSAND_TEN_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_HUNDRED_TEN.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_HUNDRED_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.THOUSAND_TEN_ONE.getCode());
        threeDigitalBettingList.add(LotteryBettingEnum.HUNDRED_TEN_ONE.getCode());
        //一字组合
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_ALL_FIVE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_FIRST_THREE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_IN_THREE.getCode());
        oneCombinationBettingList.add(LotteryBettingEnum.ONE_AFTER_THREE.getCode());

        //跨度
        spanBettingList.add(LotteryBettingEnum.SPAN_FIRST_THREE.getCode());
        spanBettingList.add(LotteryBettingEnum.SPAN_IN_THREE.getCode());
        spanBettingList.add(LotteryBettingEnum.SPAN_AFTER_THREE.getCode());
    }


    @Override
    public List<String> handle(String code,List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        //一字，总和
        winningRecordList.addAll(oneDigitalWinKey (resultList));
        //二字,龙虎
        winningRecordList.addAll(twoDigitalWinKey (resultList));
        //三字
        winningRecordList.addAll(threeDigitalWinKey (resultList));
        //一字组合
        winningRecordList.addAll(oneCombinationWinKey (resultList));
        //跨度
        winningRecordList.addAll(spanWinKey (resultList));
        return winningRecordList;
    }


    private List<String> oneDigitalWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            //一字定位 -数字
            winningRecordList.add(oneDigitalBettingList.get(i) + "_" + resultList.get(i));
            //一字定位 -双面 -大小
            if (Integer.valueOf(resultList.get(i)) >= 5) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.BIG);
            } else {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.SMALL);
            }
            //一字定位 -双面 -单双
            if (Integer.valueOf(resultList.get(i)) % 2 == 0) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.DOUBLE);
            } else {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.SINGLE);
            }
            //一字定位 -双面 -质合
            if (Integer.valueOf(resultList.get(i)) == 1 || Integer.valueOf(resultList.get(i)) == 2 ||
                    Integer.valueOf(resultList.get(i)) == 3 || Integer.valueOf(resultList.get(i)) == 5 ||
                    Integer.valueOf(resultList.get(i)) == 7) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.PRIME);
            } else if (Integer.valueOf(resultList.get(i)) == 0 || Integer.valueOf(resultList.get(i)) == 4 ||
                    Integer.valueOf(resultList.get(i)) == 6 || Integer.valueOf(resultList.get(i)) == 8 ||
                    Integer.valueOf(resultList.get(i)) == 9) {
                winningRecordList.add(oneDigitalBettingList.get(i) + "_" + LotteryWinningNum.COMBINED);
            }
            sum += Integer.valueOf(resultList.get(i));
        }
        //总和 -双面 -大小
        if (sum >= 23) {
            winningRecordList.add(LotteryBettingEnum.FIVE_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_BIG);
        } else {
            winningRecordList.add(LotteryBettingEnum.FIVE_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_SMALL);
        }
        //总和 -双面 -大小
        if (sum % 2 == 0) {
            winningRecordList.add(LotteryBettingEnum.FIVE_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_DOUBLE);
        } else {
            winningRecordList.add(LotteryBettingEnum.FIVE_SUM.getCode() + "_" + LotteryWinningNum.TOTAL_SINGLE);
        }
        return winningRecordList;
    }

    private List<String> twoDigitalWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        for (int i = 0; i < twoDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, twoDigitalBettingList.get(i));
            switch (lotteryBettingEnum) {
                case SSC_WAN_THOUSAND:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(0), resultList.get(1)));
                    break;
                case SSC_WAN_HUNDRED:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(0), resultList.get(2)));
                    break;
                case SSC_WAN_TEN:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(0), resultList.get(3)));
                    break;
                case SSC_WAN_ONE:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(0), resultList.get(4)));
                    break;
                case SSC_THOUSAND_HUNDRED:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(1), resultList.get(2)));
                    break;
                case SSC_THOUSAND_TEN:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(1), resultList.get(3)));
                    break;
                case SSC_THOUSAND_ONE:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(1), resultList.get(4)));
                    break;
                case SSC_HUNDRED_TEN:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(2), resultList.get(3)));
                    break;
                case SSC_HUNDRED_ONE:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(2), resultList.get(4)));
                    break;
                case SSC_TEN_ONE:
                    winningRecordList.addAll(twoDigitalWinKey (lotteryBettingEnum, resultList.get(3), resultList.get(4)));
                    break;
                default:
                    break;
            }
        }
        return winningRecordList;
    }

    private List<String> threeDigitalWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        for (String betCode : threeDigitalBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {
                case TEN_THOUSAND_THOUSAND_HUNDRED:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(1) + resultList.get(2));
                    break;
                case TEN_THOUSAND_THOUSAND_TEN:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(1) + resultList.get(3));
                    break;
                case TEN_THOUSAND_THOUSAND_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(1) + resultList.get(4));
                    break;
                case TEN_THOUSAND_HUNDRED_TEN:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(2) + resultList.get(3));
                    break;
                case TEN_THOUSAND_HUNDRED_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(2) + resultList.get(4));
                    break;
                case TEN_THOUSAND_TEN_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(0) + resultList.get(3) + resultList.get(4));
                    break;
                case THOUSAND_HUNDRED_TEN:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(1) + resultList.get(2) + resultList.get(3));
                    break;
                case THOUSAND_HUNDRED_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(1) + resultList.get(2) + resultList.get(4));
                    break;
                case THOUSAND_TEN_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(1) + resultList.get(3) + resultList.get(4));
                    break;
                case HUNDRED_TEN_ONE:
                    winningRecordList.add(lotteryBettingEnum.getCode() + "_" + resultList.get(2) + resultList.get(3) + resultList.get(4));
                    break;
                default:
                    break;
            }
        }
        return winningRecordList;
    }

    private List<String> oneCombinationWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        for (String betCode : oneCombinationBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            List<String> winningNumSet = null;
            switch (lotteryBettingEnum) {
                case ONE_ALL_FIVE:
                    winningNumSet = resultList;
                    break;
                case ONE_FIRST_THREE:
                    winningNumSet = resultList.subList(0,3);
                    break;
                case ONE_IN_THREE:
                    winningNumSet = resultList.subList(1,4);
                    break;
                case ONE_AFTER_THREE:
                    winningNumSet = resultList.subList(2,5);
                    break;
                default:
                    break;
            }
            for (String winningNum : winningNumSet) {
                winningRecordList.add(lotteryBettingEnum.getCode() + "_" + winningNum);
            }
        }
        return winningRecordList;
    }

    private List<String> spanWinKey (List<String> resultList) {
        List<String> winningRecordList = new ArrayList<>();
        for (String betCode : spanBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {
                case SPAN_FIRST_THREE:
                    winningRecordList.add (lotteryBettingEnum.getCode() + "_" + generateSpanNum (resultList.get(0),resultList.get(1),resultList.get(2)));
                    break;
                case SPAN_IN_THREE:
                    winningRecordList.add (lotteryBettingEnum.getCode() + "_" + generateSpanNum (resultList.get(1),resultList.get(2),resultList.get(3)));
                    break;
                case SPAN_AFTER_THREE:
                    winningRecordList.add (lotteryBettingEnum.getCode() + "_" + generateSpanNum (resultList.get(2),resultList.get(3),resultList.get(4)));
                    break;
                default:
                    break;
            }
        }
        return winningRecordList;
    }

    private List<String> twoDigitalWinKey (LotteryBettingEnum lotteryBettingEnum, String dragon, String tiger) {
        List<String> winningRecordList = new ArrayList<>();
        winningRecordList.add(lotteryBettingEnum.getCode() + "_" + dragon + tiger);
        if (Integer.valueOf(dragon) > Integer.valueOf(tiger)) {
            winningRecordList.add(lotteryBettingEnum.getCode() + "_" + LotteryWinningNum.DRAGON);
        } else if (Integer.valueOf(dragon) < Integer.valueOf(tiger)) {
            winningRecordList.add(lotteryBettingEnum.getCode() + "_" + LotteryWinningNum.TIGER);
        } else {
            winningRecordList.add(lotteryBettingEnum.getCode() + "_" + LotteryWinningNum.DRAGON_TIGER_TIE);
        }
        return winningRecordList;
    }

    private String generateSpanNum(String num1, String num2, String num3) {
        int max = Integer.valueOf(num1) > Integer.valueOf(num2) ? Integer.valueOf(num1) : Integer.valueOf(num2);
        max = max > Integer.valueOf(num3) ? max : Integer.valueOf(num3);
        int min = Integer.valueOf(num1) < Integer.valueOf(num2) ? Integer.valueOf(num1) : Integer.valueOf(num2);
        min = min < Integer.valueOf(num3) ? min : Integer.valueOf(num3);
        return String.valueOf(max - min);
    }
}
