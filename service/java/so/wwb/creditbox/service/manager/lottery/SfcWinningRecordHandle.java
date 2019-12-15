package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shook on 17-8-15.
 */
public class SfcWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> digitalBettingList = new ArrayList<>(8);

    private static List<String> digitalPlayList = new ArrayList<>(5);


    static {
        //投注玩法：第一球～第八球
        digitalBettingList.add(LotteryBettingEnum.RANK_ONE.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_TWO.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_THREE.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_FOUR.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_FIVE.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_SIX.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_SEVEN.getCode());
        digitalBettingList.add(LotteryBettingEnum.RANK_EIGHT.getCode());
        //第一球～第八球对应的彩种玩法
        digitalPlayList.add(LotteryPlayEnum.DIGITAL.getCode());
        digitalPlayList.add(LotteryPlayEnum.BIG_SMALL.getCode());
        digitalPlayList.add(LotteryPlayEnum.SINGLE_DOUBLE.getCode());
        digitalPlayList.add(LotteryPlayEnum.SUM_SINGLE_DOUBLE.getCode());
        digitalPlayList.add(LotteryPlayEnum.MANTISSA_BIG_SMALL.getCode());
        digitalPlayList.add(LotteryPlayEnum.ZBF.getCode());
        digitalPlayList.add(LotteryPlayEnum.FW.getCode());


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
        lotteryWinningRecordList.addAll(createSum8(lotteryResult));
        lotteryWinningRecordList.addAll(createContinuousCode(lotteryResult));
        winningRecordHandleVo.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecordHandleVo;
    }
    private List<LotteryWinningRecord> createDigital(LotteryResult lotteryResult) {

        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < digitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, digitalBettingList.get(i));
            for (String playCode : digitalPlayList) {
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
                    case MANTISSA_BIG_SMALL:
                        winningNum = generateMantissaBigSmallNum(openCodes[i]);
                        break;
                    case SUM_SINGLE_DOUBLE:
                        winningNum = generateSingleSumSingleDoubleNum(openCodes[i]);
                        break;
                    case ZBF:
                        winningNum = generateZbfNum(Integer.valueOf(openCodes[i]));
                        break;
                    case FW:
                        winningNum = generateFwfNum(Integer.valueOf(openCodes[i]));
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
    //总和
    private List<LotteryWinningRecord> createSum8(LotteryResult lotteryResult) {


        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        Integer totalSum = generateTotalSum(openCodes);

        String winningNum;
        LotteryWinningRecord lotteryWinningRecord;

        winningNum = totalSum +"";
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM, LotteryBettingEnum.SUM, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);

        winningNum = generateTotalBigSmallNum(totalSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_BIG_SMALL, LotteryBettingEnum.SUM_BIG_SMALL, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        winningNum = generateTotalSingleDoubleNum(totalSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_SINGLE_DOUBLE, LotteryBettingEnum.SUM_SINGLE_DOUBLE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);

        winningNum = generateTotalMantissaBigSmallNum(totalSum);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_MANTISSA_BIG_SMALL, LotteryBettingEnum.SUM_MANTISSA_BIG_SMALL, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);


        winningNum =  generateDragonTigerTie(Integer.valueOf(openCodes[0]), Integer.valueOf(openCodes[7]));
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.SUM_DRAGON_TIGER_TIE, LotteryBettingEnum.SUM_DRAGON_TIGER_TIE, winningNum);
        lotteryWinningRecordList.add(lotteryWinningRecord);




        return lotteryWinningRecordList;
    }
    /**
     * 构造連碼中奖记录
     *
     * @param lotteryResult
     * @return
     */
    private List<LotteryWinningRecord> createContinuousCode(LotteryResult lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        LotteryWinningRecord lotteryWinningRecord = null;


        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RENXUAN_2, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.RENXUAN_2.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RENXUAN_3, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.RENXUAN_3.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RENXUAN_4, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.RENXUAN_4.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.RENXUAN_5, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.RENXUAN_5.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }

        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.LIANZU_2, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", openCodes));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.LIANZU_2.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }
        String winnum = StringTool.join(",", openCodes[0],openCodes[1],openCodes[2]);
        lotteryWinningRecord = createWinningRecord(lotteryResult, LotteryPlayEnum.QIANZU_3, LotteryBettingEnum.CONTINUOUS_CODE, StringTool.join(",", winnum));
        if (lotteryWinningRecord != null) {
            log.info("彩票开奖.时时彩.{0},生成中奖记录:{1}", LotteryPlayEnum.QIANZU_3.getCode(), lotteryWinningRecord.toString());
            lotteryWinningRecordList.add(lotteryWinningRecord);
            return lotteryWinningRecordList;
        }
        return lotteryWinningRecordList;
    }

    /**
     * 中發白
     * ●中：開出之號碼為01、02、03、04、05、06、07
     * ●發：開出之號碼為08、09、10、11、12、13、14
     * ●白：開出之號碼為15、16、17、18、19、20
     *
     *
     * @param openCode 开奖号码
     * @return 中發白
     */
    protected String generateZbfNum(Integer openCode) {
        if(openCode <=7){
            return LotteryWinningNum.ZBF_Z;
        }else if(openCode <=14){
            return LotteryWinningNum.ZBF_F;
        }else {
            return LotteryWinningNum.ZBF_B;
        }
    }

    public static void main(String[] args) {
        System.out.println(19%4);
    }
    /**
     * 东南西北
     * ●東：開出之號碼為01、05、09、13、17
     * ●南：開出之號碼為02、06、10、14、18
     * ●西：開出之號碼為03、07、11、15、19
     * ●北：開出之號碼為04、08、12、16、20
     *
     *
     * @param openCode 开奖号码
     * @return 东南西北
     */
    protected String generateFwfNum(Integer openCode) {
        if(openCode%4 == 1){
            return LotteryWinningNum.FW_D;
        }
        else if(openCode%4 == 2){
            return LotteryWinningNum.FW_N;
        }
        else if(openCode%4 == 3){
            return LotteryWinningNum.FW_X;
        }
        else {
            return LotteryWinningNum.FW_B;
        }
    }

    @Override
    boolean isBigNum(Integer num) {
        return num >= 11;
    }
    @Override
    boolean isTotalBigNum(Integer totalSum) {
        return totalSum >= 84;
    }


}
