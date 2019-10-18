package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.common.utility.math.PermCombTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.*;

public class Pl3WinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> oneDigitalBettingList = new ArrayList<>(8);

    private static List<String> oneDigitalPlayList = new ArrayList<>(5);

    private static List<String> twoDigitalBettingList = new ArrayList<>(3);

    private static List<String> twoSumBettingList = new ArrayList<>(3);

    private static List<String> twoSumPlayList = new ArrayList<>(5);

    private static List<String> threeSumPlayList = new ArrayList<>(5);

    private static List<String> ofThreeZXBettingList = new ArrayList<>(5);

    private static List<String> ofThreeZUXBettingList = new ArrayList<>(5);

    private static List<String> ofThreeSumPlayList = new ArrayList<>(3);

    private static List<String> ofQTWOZXBettingList = new ArrayList<>(2);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> qemap = new HashMap<>(3,1f);

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> hemap = new HashMap<>(3,1f);

    private static List<String> ofHTWOZXBettingList = new ArrayList<>(2);


    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> map = new HashMap<>(3,1f);


    static {
        //投注玩法：百十个
        oneDigitalBettingList.add(LotteryBettingEnum.PL3_HUNDRED.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.PL3_TEN.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.PL3_ONE.getCode());
        //百十个对应的彩种玩法
        oneDigitalPlayList.add(LotteryPlayEnum.PL3_ONE_DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PL3_ONE_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PL3_ONE_SINGLE_DOUBLE.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.PL3_ONE_PRIME_COMBINED.getCode());

        twoDigitalBettingList.add(LotteryBettingEnum.PL3_HUNDRED_TEN.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.PL3_HUNDRED_ONE.getCode());
        twoDigitalBettingList.add(LotteryBettingEnum.PL3_TEN_ONE.getCode());

        twoSumBettingList.add(LotteryBettingEnum.PL3_HUNDRED_TEN_SUM.getCode());
        twoSumBettingList.add(LotteryBettingEnum.PL3_HUNDRED_ONE_SUM.getCode());
        twoSumBettingList.add(LotteryBettingEnum.PL3_TEN_ONE_SUM.getCode());
        twoSumPlayList.add(LotteryPlayEnum.PL3_SUM2_DIGITAL.getCode());
        twoSumPlayList.add(LotteryPlayEnum.PL3_SUM2_SINGLE_DOUBLE.getCode());
        twoSumPlayList.add(LotteryPlayEnum.PL3_SUM2_MANTISSA.getCode());
        twoSumPlayList.add(LotteryPlayEnum.PL3_SUM2_MANTISSA_BIG_SMALL.getCode());
        twoSumPlayList.add(LotteryPlayEnum.PL3_SUM2_MANTISSA_PRIME_COMBINED.getCode());

        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_DIGITAL.getCode());
        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_MANTISSA.getCode());
        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_BIG_SMALL.getCode());
        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_SINGLE_DOUBLE.getCode());
        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_MANTISSA_BIG_SMALL.getCode());
        threeSumPlayList.add(LotteryPlayEnum.PL3_SUM3_MANTISSA_PRIME_COMBINED.getCode());

        ofThreeZXBettingList.add(LotteryBettingEnum.PL3_SANXING_ZXFS.getCode());
        ofThreeZXBettingList.add(LotteryBettingEnum.PL3_SANXING_ZXDS.getCode());
        ofThreeZXBettingList.add(LotteryBettingEnum.PL3_SANXING_ZXHZ.getCode());
        ofThreeZUXBettingList.add(LotteryBettingEnum.PL3_SANXING_Z3FS.getCode());
        ofThreeZUXBettingList.add(LotteryBettingEnum.PL3_SANXING_Z3DS.getCode());
        ofThreeZUXBettingList.add(LotteryBettingEnum.PL3_SANXING_Z6FS.getCode());
        ofThreeZUXBettingList.add(LotteryBettingEnum.PL3_SANXING_Z6DS.getCode());
        ofThreeZUXBettingList.add(LotteryBettingEnum.PL3_SANXING_HHZX.getCode());

        ofThreeSumPlayList.add(LotteryPlayEnum.PL3_SANXING_ZHIXUAN.getCode());
        ofThreeSumPlayList.add(LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode());

        ofQTWOZXBettingList.add(LotteryBettingEnum.PL3_ERXING_QEZXFS.getCode());
        ofQTWOZXBettingList.add(LotteryBettingEnum.PL3_ERXING_QEZXDS.getCode());

        ofHTWOZXBettingList.add(LotteryBettingEnum.PL3_ERXING_HEZXFS.getCode());
        ofHTWOZXBettingList.add(LotteryBettingEnum.PL3_ERXING_HEZXDS.getCode());

        qemap.put(LotteryPlayEnum.PL3_ERXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.PL3_ERXING_QEZUXFS, LotteryBettingEnum.PL3_ERXING_QEZUXDS));

        hemap.put(LotteryPlayEnum.PL3_ERXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.PL3_ERXING_HEZUXFS, LotteryBettingEnum.PL3_ERXING_HEZUXDS));

        map.put(LotteryPlayEnum.PL3_SANXING_ZUXUAN,
                Arrays.asList(LotteryBettingEnum.PL3_SANXING_Z3FS, LotteryBettingEnum.PL3_SANXING_Z3DS,
                        LotteryBettingEnum.PL3_SANXING_Z6FS, LotteryBettingEnum.PL3_SANXING_Z6DS, LotteryBettingEnum.PL3_SANXING_HHZX,
                        LotteryBettingEnum.PL3_SANXING_ZUXHZ));

    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createOneDigital(number));
        lotteryWinningRecordList.addAll(createTwoDigital(number));
        lotteryWinningRecordList.addAll(createThreeDigital(number));
        lotteryWinningRecordList.addAll(createOneCombination(number));
        lotteryWinningRecordList.addAll(createTwoCombination(number));
        lotteryWinningRecordList.addAll(createThreeCombination(number));
        lotteryWinningRecordList.addAll(createSum2(number));
        lotteryWinningRecordList.addAll(createSum3(number));
        lotteryWinningRecordList.addAll(createGroup3(number));
        lotteryWinningRecordList.addAll(createGroup6(number));
        lotteryWinningRecordList.addAll(createSpan(number));
        lotteryWinningRecordList.addAll(createOffical(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    private List<LotteryWinningRecord> createSpan(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = generateSpanNum(openCodes[0], openCodes[1], openCodes[2]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SPAN, LotteryBettingEnum.PL3_SPAN, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SPAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createGroup6(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = generateGroup6Num(openCodes[0], openCodes[1], openCodes[2]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_GROUP_SIX, LotteryBettingEnum.PL3_GROUP6, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_GROUP_SIX.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createGroup3(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = generateGroup3Num(openCodes[0], openCodes[1], openCodes[2]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_GROUP_THREE, LotteryBettingEnum.PL3_GROUP3, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_GROUP_THREE.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createSum3(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer threeSum = generateTotalSum(openCodes);
        for (String playCode : threeSumPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
                case PL3_SUM3_DIGITAL:
                    winningNum = String.valueOf(threeSum);
                    break;
                case PL3_SUM3_MANTISSA:
                    winningNum = generateMantissa(String.valueOf(threeSum)) + "尾";
                    break;
                case PL3_SUM3_BIG_SMALL:
                    winningNum = generateSumBigSmallNum(threeSum);
                    break;
                case PL3_SUM3_SINGLE_DOUBLE:
                    winningNum = generateSingleDoubleNum(threeSum);
                    break;
                case PL3_SUM3_MANTISSA_BIG_SMALL:
                    winningNum = generateMantissaBigSmallNum(String.valueOf(threeSum));
                    break;
                case PL3_SUM3_MANTISSA_PRIME_COMBINED:
                    winningNum = generateMantissaPrimeCombined(String.valueOf(threeSum));
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.PL3_HUNDRED_TEN_ONE_SUM, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createSum2(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : twoSumBettingList) {
            Integer sum2;
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            switch (lotteryBettingEnum) {
                case PL3_HUNDRED_TEN_SUM:
                    sum2 = Integer.valueOf(openCodes[0]) + Integer.valueOf(openCodes[1]);
                    break;
                case PL3_HUNDRED_ONE_SUM:
                    sum2 = Integer.valueOf(openCodes[0]) + Integer.valueOf(openCodes[2]);
                    break;
                case PL3_TEN_ONE_SUM:
                    sum2 = Integer.valueOf(openCodes[1]) + Integer.valueOf(openCodes[2]);
                    break;
                default:
                    sum2 = null;
                    break;
            }

            for (String playCode : twoSumPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case PL3_SUM2_DIGITAL:
                        winningNum = sum2 == null ? null : String.valueOf(sum2);
                        break;
                    case PL3_SUM2_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(sum2);
                        break;
                    case PL3_SUM2_MANTISSA:
                        winningNum = generateMantissa(String.valueOf(sum2)) + "尾";
                        break;
                    case PL3_SUM2_MANTISSA_BIG_SMALL:
                        winningNum = generateMantissaBigSmallNum(String.valueOf(sum2));
                        break;
                    case PL3_SUM2_MANTISSA_PRIME_COMBINED:
                        winningNum = generateMantissaPrimeCombined(String.valueOf(sum2));
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createThreeCombination(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        LotteryBettingEnum lotteryBettingEnum;
        if (openCodes[0].equals(openCodes[1]) && openCodes[1].equals(openCodes[2])) {
            lotteryBettingEnum = LotteryBettingEnum.PL3_THREE_SAME;
        } else if (!openCodes[0].equals(openCodes[1]) && !openCodes[1].equals(openCodes[2]) && !openCodes[0].equals(openCodes[2])) {
            lotteryBettingEnum = LotteryBettingEnum.PL3_THREE_GROUP6;
        } else {
            lotteryBettingEnum = LotteryBettingEnum.PL3_THREE_GROUP3;
        }
        Set<String> winningNumSet = new LinkedHashSet<>();
        winningNumSet.add(openCodes[0] + openCodes[1] + openCodes[2]);
        winningNumSet.add(openCodes[0] + openCodes[2] + openCodes[1]);
        winningNumSet.add(openCodes[1] + openCodes[0] + openCodes[2]);
        winningNumSet.add(openCodes[1] + openCodes[2] + openCodes[0]);
        winningNumSet.add(openCodes[2] + openCodes[0] + openCodes[1]);
        winningNumSet.add(openCodes[2] + openCodes[1] + openCodes[0]);
        for (String winningNum : winningNumSet) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_THREE_COMBINATION, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_THREE_COMBINATION.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createTwoCombination(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Set<String> sameNumSet = new LinkedHashSet<>();
        Set<String> differentNumSet = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (openCodes[i].equals(openCodes[j])) {
                    sameNumSet.add(openCodes[i] + openCodes[j]);
                } else {
                    differentNumSet.add(openCodes[i] + openCodes[j]);
                    differentNumSet.add(openCodes[j] + openCodes[i]);
                }
            }
        }
        for (String winningNum : sameNumSet) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_TWO_COMBINATION, LotteryBettingEnum.PL3_TWO_SAME, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_TWO_COMBINATION.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        for (String winningNum : differentNumSet) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_TWO_COMBINATION, LotteryBettingEnum.PL3_TWO_DIFFERENT, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_TWO_COMBINATION.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createOneCombination(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<String> winningNumList = new ArrayList<>();
        for (String openCode : openCodes) {
            if (winningNumList.contains(openCode)) {
                continue;
            }
            winningNumList.add(openCode);
        }
        for (String winningNum : winningNumList) {
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_ONE_COMBINATION, LotteryBettingEnum.PL3_ONE_ALL_THREE, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_ONE_COMBINATION.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createThreeDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = openCodes[0] + openCodes[1] + openCodes[2];
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_THREE_DIGITAL, LotteryBettingEnum.PL3_HUNDRED_TEN_ONE, winningNum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_THREE_DIGITAL.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createTwoDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (String betCode : twoDigitalBettingList) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case PL3_HUNDRED_TEN:
                    winningNum = openCodes[0] + openCodes[1];
                    break;
                case PL3_HUNDRED_ONE:
                    winningNum = openCodes[0] + openCodes[2];
                    break;
                case PL3_TEN_ONE:
                    winningNum = openCodes[1] + openCodes[2];
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_TWO_DIGITAL, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_TWO_DIGITAL.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createOneDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, oneDigitalBettingList.get(i));
            for (String playCode : oneDigitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
                    case PL3_ONE_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case PL3_ONE_BIG_SMALL:
                        winningNum = generateBigSmallNum(openCodes[i]);
                        break;
                    case PL3_ONE_SINGLE_DOUBLE:
                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
                        break;
                    case PL3_ONE_PRIME_COMBINED:
                        winningNum = generatePrimeCombinedNum(Integer.valueOf(openCodes[i]));
                        break;
                    default:
                        break;
                }
                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningNum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.3D彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }

        }

        return lotteryWinningRecordList;
    }

    /**
     *官方玩法
     */
    private List<LotteryWinningRecord> createOffical(LotteryResultNumber lotteryResult){
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();

        lotteryWinningRecordList.addAll(createOffThreeZhixuan(lotteryResult));

        lotteryWinningRecordList.addAll(createOfThreeCombination(lotteryResult,map.get(LotteryPlayEnum.PL3_SANXING_ZUXUAN),openCodes));

        lotteryWinningRecordList.addAll(createOffQerZhixuan(lotteryResult));

        String[] qeopenCodes = new String[]{openCodes[0],openCodes[1]};
        lotteryWinningRecordList.addAll(generateEXZuxuanWinningRecord(lotteryResult,qemap.get(LotteryPlayEnum.PL3_ERXING_ZUXUAN),qeopenCodes));

        String[] heopenCodes = new String[]{openCodes[1],openCodes[2]};
        lotteryWinningRecordList.addAll(generateEXZuxuanWinningRecord(lotteryResult,hemap.get(LotteryPlayEnum.PL3_ERXING_ZUXUAN),heopenCodes));

        lotteryWinningRecordList.addAll(createOffHerZhixuan(lotteryResult));

        lotteryWinningRecordList.addAll(createOneStar(lotteryResult));

        lotteryWinningRecordList.addAll(createBdOneStar(lotteryResult));
        return lotteryWinningRecordList;
    }

    /**
     * 官方三星直选
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOffThreeZhixuan(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer threeSum = generateTotalSum(openCodes);
        for(String betCode:ofThreeZXBettingList){
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case PL3_SANXING_ZXFS:
                    winningNum = generateZhixuanFuShiWinnum(openCodes);
                    break;
                case PL3_SANXING_ZXDS:
                    winningNum = generateZhixuanDanShiWinnum(openCodes);
                    break;
                case PL3_SANXING_ZXHZ:
                    winningNum = String.valueOf(threeSum);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZHIXUAN, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }

        }
        return lotteryWinningRecordList;
    }

    /**
     * 官方生成三星组选选中奖记录
     * @param lotteryResult
     * @param bettingList
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> createOfThreeCombination(LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        String group3fsWinnum = generateSXGroup3FsWinNum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(0), group3fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> group3dsWinnumList = generateSXGroup3DsWinNum(openCodes);
        for(String group3dsWinnum : group3dsWinnumList){
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(1), group3dsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        String group6fsWinnum = generateSXGroup6FsWinNum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(2), group6fsWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        List<String> group6dsWinnumList = generateSXGroup6DsWinNumList(openCodes);
        for(String group6dsWinnum : group6dsWinnumList){
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(3), group6dsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        List<String> hhWinnumList = generateHhWinnumSet(openCodes);
        for (String hhWinnum: hhWinnumList) {
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(4), hhWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        String hzWinnum = generateSXHZWinnum(openCodes);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_SANXING_ZUXUAN, bettingList.get(5), hzWinnum);
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_SANXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 三星组选和值
     * @param openCodes
     * @return
     */
    private String generateSXHZWinnum(String... openCodes) {
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return null;
        }
        return StringTool.join(",",openCodes);
    }


    /**
     * 三星组选混合
     * @param openCodes
     * @return
     */
    private List<String> generateHhWinnumSet(String... openCodes) {
        List<String> winNumList = new ArrayList<>();
        if(openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])){
            return winNumList;
        }else if(!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2])){
            winNumList.addAll(PermCombTool.permutationSelect(openCodes,3,","));
        }else{
            String num1 = openCodes[0];
            String num2 = openCodes[1];
            String num3 = openCodes[2];
            winNumList = createZuxuanHhZu3(num1,num2,num3);
        }
        return winNumList;
    }

    /**
     * 三星组选三复式
     * @param openCodes
     * @return
     */
    private String generateSXGroup3FsWinNum(String... openCodes) {
        if((openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2])) ||
                (!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2]))){
            return null;
        }
        return StringTool.join(",",openCodes);
    }

    /**
     * 三星组选六复式
     * @param openCode
     * @return
     */
    private String generateSXGroup6FsWinNum(String... openCode) {
        if (!openCode[0].equals(openCode[1]) && !openCode[0].equals(openCode[2]) && !openCode[1].equals(openCode[2]))
            return StringTool.join(",",openCode);
        return null;
    }

    /**
     * 三星组选六单式
     * @param openCode
     * @return
     */
    private List<String> generateSXGroup6DsWinNumList(String... openCode) {
        List<String> list = new ArrayList<>();
        if (openCode != null && openCode.length == 3 && !openCode[0].equals(openCode[1]) && !openCode[0].equals(openCode[2]) && !openCode[1].equals(openCode[2]))
            list.addAll(PermCombTool.permutationSelect(openCode,3,""));
        return list;
    }


    /**
     * 三星组选三单式
     * @param openCodes
     * @return
     */
    private List<String> generateSXGroup3DsWinNum(String... openCodes) {
        List<String> winNumList = new ArrayList<>();
        if ((openCodes[0].equals(openCodes[1]) && openCodes[0].equals(openCodes[2]))
                || (!openCodes[0].equals(openCodes[1]) && !openCodes[0].equals(openCodes[2]) && !openCodes[1].equals(openCodes[2])))
            return winNumList;
        String num1 = openCodes[0];
        String num2 = openCodes[1];
        String num3 = openCodes[2];
        winNumList = createZuxuanZu3(num1,num2,num3);
        return winNumList;
    }

    /**
     * 官方前二直选
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOffQerZhixuan(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for(String betCode:ofQTWOZXBettingList){
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case PL3_ERXING_QEZXFS:
                    winningNum = generateZhixuanFuShiWinnum(openCodes[0],openCodes[1]);
                    break;
                case PL3_ERXING_QEZXDS:
                    winningNum = generateZhixuanDanShiWinnum(openCodes[0],openCodes[1]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_ERXING_ZHIXUAN, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }

        }
        return lotteryWinningRecordList;
    }


    /**
     * 生成二星组选中奖记录
     * @param openCodes
     * @return
     */
    private List<LotteryWinningRecord> generateEXZuxuanWinningRecord (LotteryResultNumber lotteryResult, List<LotteryBettingEnum> bettingList, String... openCodes) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = null;
        //二星组选不包含对子号
        if (!openCodes[0].equals(openCodes[1])) {
            String fsWinnum = StringTool.join(",", openCodes);
            lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_ERXING_ZUXUAN, bettingList.get(0), fsWinnum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
            List<String> dsWinnumList = PermCombTool.permutationSelect(openCodes, openCodes.length, "");
            for (String dsWinnum : dsWinnumList) {
                lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_ERXING_ZUXUAN, bettingList.get(1), dsWinnum);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_ERXING_ZUXUAN.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 官方后二直选
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOffHerZhixuan(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for(String betCode:ofHTWOZXBettingList){
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, betCode);
            String winningNum = null;
            switch (lotteryBettingEnum) {
                case PL3_ERXING_HEZXFS:
                    winningNum = generateZhixuanFuShiWinnum(openCodes[1],openCodes[2]);
                    break;
                case PL3_ERXING_HEZXDS:
                    winningNum = generateZhixuanDanShiWinnum(openCodes[1],openCodes[2]);
                    break;
                default:
                    break;
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_ERXING_ZHIXUAN, lotteryBettingEnum, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_ERXING_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }

        }
        return lotteryWinningRecordList;
    }


    /**
     *官方一星定位胆
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_YIXING, LotteryBettingEnum.PL3_YIXING_DWD, lotteryResult.getOpenCode());
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_YIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     *官方不位胆
     * @param lotteryResult
     * @return Winnum
     */
    private List<LotteryWinningRecord> createBdOneStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PL3_BUDINGWEI_SANXING, LotteryBettingEnum.PL3_BUDINGWEI_SXYM, lotteryResult.getOpenCode());
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.PL3.{0},生成中奖记录:{1}", LotteryPlayEnum.PL3_BUDINGWEI_SANXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 5;
    }

    @Override
    boolean isSumBigNum(Integer totalSum) {
        return totalSum >= 14;
    }

    /**
     * 生成直选复式中奖号码
     * @return Winnum
     */
    private String generateZhixuanFuShiWinnum(String... openCodes){
        return StringTool.join(",",openCodes);
    }

    /**
     * 生成直选单式中奖号码
     * @return Winnum
     */
    private String generateZhixuanDanShiWinnum(String... openCodes){
        return StringTool.join("",openCodes);
    }
}