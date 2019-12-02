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

    private static List<String> sum8List = new ArrayList<>();

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
        digitalPlayList.add(LotteryPlayEnum.SFC_ZBF.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_FW.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_DRAGON_TIGER.getCode());


        sum8List.add(LotteryPlayEnum.SFC_SUM8_BIG_SMALL.getCode());
        sum8List.add(LotteryPlayEnum.SFC_SUM8_SINGLE_DOUBLE.getCode());
        sum8List.add(LotteryPlayEnum.SFC_SUM8_MANTISSA_BIG_SMALL.getCode());


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
//        lotteryWinningRecordList.addAll(createDragonTiger(lotteryResult));
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
                    case SFC_ZBF:
                        winningNum = generateZbfNum(Integer.valueOf(openCodes[i]));
                        break;
                    case SFC_FW:
                        winningNum = generateFwfNum(Integer.valueOf(openCodes[i]));
                        break;
                    case SFC_DRAGON_TIGER:
                        winningNum = generateDragonTigerTie(Integer.valueOf(openCodes[i]), Integer.valueOf(openCodes[7 - i]));
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

}
