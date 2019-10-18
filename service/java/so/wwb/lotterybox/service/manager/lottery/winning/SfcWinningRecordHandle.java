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

public class SfcWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> digitalBettingList = new ArrayList<>(8);

    private static List<String> digitalPlayList = new ArrayList<>(5);

    private static List<String> sum8List = new ArrayList<>();

    private static List<String> dragonTigerList = new ArrayList<>();

    static {
        //投注玩法：第一球～第八球
        digitalBettingList.add(LotteryBettingEnum.SFC_FIRST.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_SECOND.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_THIRD.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_FOURTH.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_FIFTH.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_SIXTH.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_SEVENTH.getCode());
        digitalBettingList.add(LotteryBettingEnum.SFC_EIGHTH.getCode());
        //第一球～第八球对应的彩种玩法
        digitalPlayList.add(LotteryPlayEnum.SFC_DIGITAL.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_BIG_SMALL.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_SINGLE_DOUBLE.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_MANTISSA_BIG_SMALL.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_SUM_SINGLE_DOUBLE.getCode());

        sum8List.add(LotteryPlayEnum.SFC_SUM8_BIG_SMALL.getCode());
        sum8List.add(LotteryPlayEnum.SFC_SUM8_SINGLE_DOUBLE.getCode());
        sum8List.add(LotteryPlayEnum.SFC_SUM8_MANTISSA_BIG_SMALL.getCode());

        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_12.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_13.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_14.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_15.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_16.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_17.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_18.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_23.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_24.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_25.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_26.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_27.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_28.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_34.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_35.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_36.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_37.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_38.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_45.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_46.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_47.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_48.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_56.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_57.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_58.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_67.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_68.getCode());
        dragonTigerList.add(LotteryBettingEnum.SFC_DRAGON_TIGER_78.getCode());
    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createDigital(number));
        lotteryWinningRecordList.addAll(createSum8(number));
        lotteryWinningRecordList.addAll(createDragonTiger(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    private List<LotteryWinningRecord> createDragonTiger(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : dragonTigerList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case SFC_DRAGON_TIGER_12:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[1]));
                    break;
                case SFC_DRAGON_TIGER_13:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[2]));
                    break;
                case SFC_DRAGON_TIGER_14:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[3]));
                    break;
                case SFC_DRAGON_TIGER_15:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[4]));
                    break;
                case SFC_DRAGON_TIGER_16:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[5]));
                    break;
                case SFC_DRAGON_TIGER_17:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_18:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_23:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[2]));
                    break;
                case SFC_DRAGON_TIGER_24:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[3]));
                    break;
                case SFC_DRAGON_TIGER_25:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[4]));
                    break;
                case SFC_DRAGON_TIGER_26:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[5]));
                    break;
                case SFC_DRAGON_TIGER_27:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_28:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[1]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_34:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[3]));
                    break;
                case SFC_DRAGON_TIGER_35:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[4]));
                    break;
                case SFC_DRAGON_TIGER_36:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[5]));
                    break;
                case SFC_DRAGON_TIGER_37:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_38:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[2]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_45:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[3]), Integer.valueOf(openCodes[4]));
                    break;
                case SFC_DRAGON_TIGER_46:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[3]), Integer.valueOf(openCodes[5]));
                    break;
                case SFC_DRAGON_TIGER_47:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[3]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_48:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[3]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_56:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[4]), Integer.valueOf(openCodes[5]));
                    break;
                case SFC_DRAGON_TIGER_57:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[4]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_58:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[4]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_67:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[5]), Integer.valueOf(openCodes[6]));
                    break;
                case SFC_DRAGON_TIGER_68:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[5]), Integer.valueOf(openCodes[7]));
                    break;
                case SFC_DRAGON_TIGER_78:
                    winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[6]), Integer.valueOf(openCodes[7]));
                    break;

                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SFC_DRAGON_TIGER, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.十分彩.{0},生成中奖记录:{1}", LotteryPlayEnum.SFC_DRAGON_TIGER.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createSum8(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer eightSum = generateTotalSum(openCodes);
        for (String playCode : sum8List) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case SFC_SUM8_BIG_SMALL:
                    winningNum = generateTotalBigSmallNum(eightSum);
                    break;
                case SFC_SUM8_SINGLE_DOUBLE:
                    winningNum = generateTotalSingleDoubleNum(eightSum);
                    break;
                case SFC_SUM8_MANTISSA_BIG_SMALL:
                    winningNum = generateTotalMantissaBigSmallNum(eightSum);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SFC_SUM8, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.十分彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }


    @Override
    String generateTotalBigSmallNum(Integer totalSum) {
        if (totalSum == 84)
            return LotteryWinningNum.DRAW;
        return super.generateTotalBigSmallNum(totalSum);
    }

    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 84;
    }

    private List<LotteryWinningRecord> createDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < digitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, digitalBettingList.get(i));
            for (String playCode : digitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case SFC_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case SFC_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case SFC_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case SFC_MANTISSA_BIG_SMALL:
                        winningNum = generateMantissaBigSmallNum(openCodes[i]);
                        break;
                    case SFC_SUM_SINGLE_DOUBLE:
                        winningNum = generateSingleSumSingleDoubleNum(openCodes[i]);
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.十分彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 11;
    }
}
