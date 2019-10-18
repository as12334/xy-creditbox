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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
   * Created by shook on 17-4-9.
*/

/**
 * Created by shook on 17-4-9.
 */
public class Syx5WinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static Map<LotteryPlayEnum,List<LotteryBettingEnum>> bettingMap = new HashMap<>(9,1f);

    private static List<LotteryBettingEnum> renXuanDsList = new ArrayList<>(8);

    private static List<LotteryBettingEnum> renXuanFsList = new ArrayList<>(8);

    private static List<LotteryBettingEnum> renXuanDtList = new ArrayList<>(7);

    private static List<LotteryBettingEnum> sanXingZhiXuanList = new ArrayList<>(6);

    private static List<LotteryBettingEnum> sanXingZuXuanList = new ArrayList<>(9);

    private static List<LotteryBettingEnum> sanXingBdwList = new ArrayList<>(3);

    private static List<LotteryBettingEnum> erXingZhiXuanList = new ArrayList<>(4);

    private static List<LotteryBettingEnum> erXingZuXuanList = new ArrayList<>(6);

    private static List<LotteryBettingEnum> yiXingDwdList = new ArrayList<>(1);

    private static List<String> oneDigitalBettingList = new ArrayList<>(5);

    private static List<String> oneDigitalPlayList = new ArrayList<>(3);

    private static List<String> fiveSumPlayList = new ArrayList<>(2);


    static {

        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDS);
        renXuanDsList.add(LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDS);

        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_ONE_TO_ONEFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWOFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEFS);
        renXuanFsList.add(LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEFS);

        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_TWO_TO_TWODT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_THREE_TO_THREEDT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_FOUR_TO_FOURDT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_FIVE_TO_FIVEDT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_SIX_TO_FIVEDT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_SEVEN_TO_FIVEDT);
        renXuanDtList.add(LotteryBettingEnum.SYX5_RENXUAN_EIGHT_TO_FIVEDT);

        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_QSZXFS);
        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_QSZXDS);
        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_ZSZXFS);
        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_ZSZXDS);
        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_HSZXFS);
        sanXingZhiXuanList.add(LotteryBettingEnum.SYX5_SANXING_HSZXDS);

        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_QSZUXFS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_QSZUXDS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_QSZUXDT);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_ZSZUXFS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_ZSZUXDS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_ZSZUXDT);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_HSZUXFS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_HSZUXDS);
        sanXingZuXuanList.add(LotteryBettingEnum.SYX5_SANXING_HSZUXDT);

        sanXingBdwList.add(LotteryBettingEnum.SYX5_SANXING_QSBDW);
        sanXingBdwList.add(LotteryBettingEnum.SYX5_SANXING_ZSBDW);
        sanXingBdwList.add(LotteryBettingEnum.SYX5_SANXING_HSBDW);

        erXingZhiXuanList.add(LotteryBettingEnum.SYX5_ERXING_QEZXFS);
        erXingZhiXuanList.add(LotteryBettingEnum.SYX5_ERXING_QEZXDS);
        erXingZhiXuanList.add(LotteryBettingEnum.SYX5_ERXING_HEZXFS);
        erXingZhiXuanList.add(LotteryBettingEnum.SYX5_ERXING_HEZXDS);

        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_QEZUXFS);
        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_QEZUXDS);
        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_QEZUXDT);
        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_HEZUXFS);
        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_HEZUXDS);
        erXingZuXuanList.add(LotteryBettingEnum.SYX5_ERXING_HEZUXDT);

        yiXingDwdList.add(LotteryBettingEnum.SYX5_YIXING_DWD);

        bettingMap.put(LotteryPlayEnum.SYX5_ERNXUANDS,renXuanDsList);
        bettingMap.put(LotteryPlayEnum.SYX5_ERNXUANFS,renXuanFsList);
        bettingMap.put(LotteryPlayEnum.SYX5_ERNXUANDT,renXuanDtList);
        bettingMap.put(LotteryPlayEnum.SYX5_SANXING_ZHIXUAN,sanXingZhiXuanList);
        bettingMap.put(LotteryPlayEnum.SYX5_SANXING_ZUXUAN,sanXingZuXuanList);
        bettingMap.put(LotteryPlayEnum.SYX5_SANXING_BDW,sanXingBdwList);
        bettingMap.put(LotteryPlayEnum.SYX5_ERXING_ZHIXUAN,erXingZhiXuanList);
        bettingMap.put(LotteryPlayEnum.SYX5_ERXING_ZUXUAN,erXingZuXuanList);
        bettingMap.put(LotteryPlayEnum.SYX5_YIXING,yiXingDwdList);

        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.SYX5_TEN_THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SYX5_THOUSAND.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SYX5_HUNDRED.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SYX5_TEN.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SYX5_ONE.getCode());
        //一字定位的彩种玩法
        oneDigitalPlayList.add(LotteryPlayEnum.SYX5_ONE_DIGITAL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SYX5_ONE_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SYX5_ONE_SINGLE_DOUBLE.getCode());
        //总和
        fiveSumPlayList.add(LotteryPlayEnum.SYX5_SUM_BIG_SMALL.getCode());
        fiveSumPlayList.add(LotteryPlayEnum.SYX5_SUM_SINGLE_DOUBLE.getCode());

    }

    @Override
    public WinningRecord handle(LotteryResultNumber number) {
        if (isIllegalResult(number)) {
            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
            return null;
        }
        WinningRecord winningRecord = new WinningRecord();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(number.getOpenCode(), ",");
        if(openCodes != null && openCodes.length == 5){
            //官方玩法的中奖记录
            lotteryWinningRecordList.addAll(createOfficalWinning(number));
            //传统玩法中奖记录
            lotteryWinningRecordList.addAll(createTraditionWinning(number));
        }
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    /**
     * 生成官方中奖记录
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createOfficalWinning(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        for(LotteryPlayEnum lotteryPlayEnum : bettingMap.keySet()){
            List<LotteryBettingEnum> list = bettingMap.get(lotteryPlayEnum);
            LotteryWinningRecord lotteryWinningRecord = null;
            for (LotteryBettingEnum lotteryBettingEnum : list) {
                lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, lotteryResult.getOpenCode());
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.11x5.{0},生成中奖记录:{1}", lotteryBettingEnum.getCode(), lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }

    private List<LotteryWinningRecord> createTraditionWinning (LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        lotteryWinningRecordList.addAll(createOneDigital (lotteryResult));
        lotteryWinningRecordList.addAll(createSum (lotteryResult));
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
                    case SYX5_ONE_DIGITAL:
                        winningNum = openCodes[i];
                        break;
                    case SYX5_ONE_BIG_SMALL:
                        winningNum = generateNnBigSmallNum(openCodes[i]);
                        break;
                    case SYX5_ONE_SINGLE_DOUBLE:
                        winningNum = generateNnSingleDoubleNum(Integer.valueOf(openCodes[i]));
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
     * 构造五字和数大小，五字 和数单双的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createSum(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer fiveSum = generateTotalSum(openCodes);
        for (String playCode : fiveSumPlayList) {
            String winningNum = null;
            LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
            if (LotteryPlayEnum.SYX5_SUM_BIG_SMALL.equals(lotteryPlayEnum)) {
                winningNum = generateNnTotalBigSmallNum(fiveSum);
            } else if (LotteryPlayEnum.SYX5_SUM_SINGLE_DOUBLE.equals(lotteryPlayEnum)) {
                winningNum = generateTotalSingleDoubleNum(fiveSum);
            }
            LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, LotteryBettingEnum.SYX5_SUM, winningNum);
            if (lotteryWinningRecord != null) {
                log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                lotteryWinningRecordList.add(lotteryWinningRecord);
            }
        }
        return lotteryWinningRecordList;
    }

    /**
     * 判断单数字的大小
     *
     * @param openCode 开奖号码
     * @return 大，小
     */
    String generateNnBigSmallNum(String openCode) {
        Integer num = Integer.valueOf(openCode);
        if (num == 11) {
            return LotteryWinningNum.DRAW;
        } else if (isBigNum(num)) {
            return LotteryWinningNum.BIG;
        } else {
            return LotteryWinningNum.SMALL;
        }
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 6;
    }

    /**
     * 判断该数字的单双
     *
     * @param num 号码
     * @return 单，双
     */
    String generateNnSingleDoubleNum(Integer num) {
        if (num == 11) {
            return LotteryWinningNum.DRAW;
        } else if (num % 2 == 0) {
            return LotteryWinningNum.DOUBLE;
        } else {
            return LotteryWinningNum.SINGLE;
        }
    }

    /**
     * 判断总和的大小，返回总大，总小
     *[重庆幸运农场/广东快乐十分有和局]
     * @param totalSum 总和
     * @return 总大，总小
     */
    String generateNnTotalBigSmallNum(Integer totalSum) {
        if (totalSum == 30) {
            return LotteryWinningNum.DRAW;
        } else if (isTotalBigNum(totalSum)) {
            return LotteryWinningNum.TOTAL_BIG;
        } else {
            return LotteryWinningNum.TOTAL_SMALL;
        }
    }

    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 31;
    }
}
