package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
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

        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_BIG_SMALL.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_SINGLE_DOUBLE.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_HALF.getCode());
//        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_34.getCode());
//        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_56.getCode());
//        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_78.getCode());
//        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_910.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_ALONE_11.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_ALONE_34.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_ALONE_56.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_ALONE_78.getCode());
        championUpSumPlayList.add(LotteryPlayEnum.CHAMPION_UP_ALONE_910.getCode());

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
        lotteryWinningRecordList.addAll(createChampionUpSum(number));
        //官方玩法
        lotteryWinningRecordList.addAll(createOffical(number));
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    private List<LotteryWinningRecord> createDigital(LotteryResultNumber lotteryResult) {
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
                    log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createChampionUpSum(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer championUpSum = generateChampionUpSum(openCodes);
        for (String playCode : championUpSumPlayList) {
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            String winningNum = null;
            switch (lotteryPlayEnum) {
//                case CHAMPION_UP_34:
//                    if (championUpSum == 3 || championUpSum == 4 || championUpSum == 18 || championUpSum == 19) {
//                        winningNum = LotteryWinningNum.CHAMPION_UP_34;
//                    }
//                    break;
//                case CHAMPION_UP_56:
//                    if (championUpSum == 5 || championUpSum == 6 || championUpSum == 16 || championUpSum == 17) {
//                        winningNum = LotteryWinningNum.CHAMPION_UP_56;
//                    }
//                    break;
//                case CHAMPION_UP_78:
//                    if (championUpSum == 7 || championUpSum == 8 || championUpSum == 14 || championUpSum == 15) {
//                        winningNum = LotteryWinningNum.CHAMPION_UP_78;
//                    }
//                    break;
//                case CHAMPION_UP_910:
//                    if (championUpSum == 9 || championUpSum == 10 || championUpSum == 12 || championUpSum == 13) {
//                        winningNum = LotteryWinningNum.CHAMPION_UP_910;
//                    }
//                    break;
                case CHAMPION_UP_ALONE_11:
                    if (championUpSum == 11) {
                        winningNum = String.valueOf(championUpSum);
                    }
                    break;
                case CHAMPION_UP_ALONE_34:
                    if (championUpSum == 3 || championUpSum == 4 || championUpSum == 18 || championUpSum == 19) {
                        winningNum = String.valueOf(championUpSum);
                    }
                    break;
                case CHAMPION_UP_ALONE_56:
                    if (championUpSum == 5 || championUpSum == 6 || championUpSum == 16 || championUpSum == 17) {
                        winningNum = String.valueOf(championUpSum);
                    }
                    break;
                case CHAMPION_UP_ALONE_78:
                    if (championUpSum == 7 || championUpSum == 8 || championUpSum == 14 || championUpSum == 15) {
                        winningNum = String.valueOf(championUpSum);
                    }
                    break;
                case CHAMPION_UP_ALONE_910:
                    if (championUpSum == 9 || championUpSum == 10 || championUpSum == 12 || championUpSum == 13) {
                        winningNum = String.valueOf(championUpSum);
                    }
                    break;
                case CHAMPION_UP_BIG_SMALL:
                    winningNum = generateChampionUpSumBigSmall(championUpSum);
                    break;
                case CHAMPION_UP_SINGLE_DOUBLE:
                    winningNum = generateChampionUpSumSingleDouble(championUpSum);
                    break;
                case CHAMPION_UP_HALF:
                    winningNum = generateChampionUpSumHalfNum(championUpSum);
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

    private String generateChampionUpSumHalfNum(Integer championUpSum) {
        if (championUpSum % 2 == 0 && championUpSum > 11) {
            return LotteryWinningNum.BIG_DOUBLE;
        } else if (championUpSum % 2 == 0 && championUpSum < 11) {
            return LotteryWinningNum.SMALL_DOUBLE;
        } else if (championUpSum % 2 != 0 && championUpSum > 11) {
            return LotteryWinningNum.BIG_SINGLE;
        } else {
            return LotteryWinningNum.SMALL_SINGLE;
        }
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 6;
    }

    private Integer generateChampionUpSum(String[] openCodes) {
        Integer championUpSum = Integer.valueOf(openCodes[0]) + Integer.valueOf(openCodes[1]);
        return championUpSum;
    }


    private String generateChampionUpSumBigSmall(Integer championUpSum) {
        if (championUpSum > 11) {
            return LotteryWinningNum.SUM_BIG;
        } else {
            return LotteryWinningNum.SUM_SMALL;
        }
    }

    private String generateChampionUpSumSingleDouble(Integer championUpSum) {
        if (championUpSum % 2 == 0) {
            return LotteryWinningNum.SUM_DOUBLE;
        } else {
            return LotteryWinningNum.SUM_SINGLE;
        }
    }

    /**
     * pk10官方玩法
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOffical(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createOfficalBeforeOne(lotteryResult));
        lotteryWinningRecordList.addAll(createOfficalBeforeTwo(lotteryResult));
        lotteryWinningRecordList.addAll(createOfficalBeforeThree(lotteryResult));
        lotteryWinningRecordList.addAll(createOneStar(lotteryResult));
        return lotteryWinningRecordList;
    }

    /**
     * pk10前一官方玩法
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOfficalBeforeOne(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String winningNum = openCodes[0];
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_QY_ZHIXUAN, LotteryBettingEnum.PK10_ZHIXUAN_QYFS, winningNum);
        if(lotteryWinningRecord !=null) {
            log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_QY_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * pk10前二官方玩法
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOfficalBeforeTwo(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String fsOpenCode = generateZhixuanFuShiWinnum(openCodes[0],openCodes[1]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_QE_ZHIXUAN, LotteryBettingEnum.PK10_ZHIXUAN_QEFS, fsOpenCode);
        if(lotteryWinningRecord !=null) {
            log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_QE_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String dsOpenCode = generateZhixuanDanShiWinnum(openCodes[0],openCodes[1]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_QE_ZHIXUAN, LotteryBettingEnum.PK10_ZHIXUAN_QEDS, dsOpenCode);
        if(lotteryWinningRecord !=null) {
            log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_QE_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * pk10前三官方玩法
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOfficalBeforeThree(LotteryResultNumber lotteryResult){
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        String fsOpenCode = generateZhixuanFuShiWinnum(openCodes[0],openCodes[1],openCodes[2]);
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_QS_ZHIXUAN, LotteryBettingEnum.PK10_ZHIXUAN_QSFS, fsOpenCode);
        if(lotteryWinningRecord !=null){
            log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_QS_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        String dsOpenCode = generateZhixuanDanShiWinnum(openCodes[0],openCodes[1],openCodes[2]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_QS_ZHIXUAN, LotteryBettingEnum.PK10_ZHIXUAN_QSDS, dsOpenCode);
        if(lotteryWinningRecord !=null){
            log.info("彩票开奖.PK10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_QS_ZHIXUAN.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }


    /**
     * 构造官方玩法定位胆的中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOneStar(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.PK10_YIXING, LotteryBettingEnum.PK10_YIXING_DWD, lotteryResult.getOpenCode());
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.PL10.{0},生成中奖记录:{1}", LotteryPlayEnum.PK10_YIXING.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
        }
        return lotteryWinningRecordList;
    }

    /**
     * 生成直选复式Winnum
     * @return
     */
    private String generateZhixuanFuShiWinnum(String... openCodes){
        return StringTool.join(",",openCodes);
    }

    /**
     * 生成直选单式Winnum
     * @return
     */
    private String generateZhixuanDanShiWinnum(String... openCodes){
        return StringTool.join(" ",openCodes);
    }

}
