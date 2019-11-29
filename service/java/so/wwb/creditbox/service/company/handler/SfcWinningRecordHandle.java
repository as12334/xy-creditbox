package so.wwb.creditbox.service.company.handler;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryWinningNum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shook on 17-8-15.
 */
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
        digitalPlayList.add(LotteryPlayEnum.SFC_ZBF.getCode());
        digitalPlayList.add(LotteryPlayEnum.SFC_FW.getCode());

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
//        lotteryWinningRecordList.addAll(createSum8(lotteryResult));
//        lotteryWinningRecordList.addAll(createDragonTiger(lotteryResult));
        winningRecordHandleVo.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecordHandleVo;
    }
    private List<LotteryWinningRecord> createDigital(LotteryResult lotteryResult) {
        HashMap<String, HashMap<String, String>> map = super.getbetSortMap(LotteryTypeEnum.SFC.getCode());

        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < digitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, digitalBettingList.get(i));
            for (String playCode : digitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningBetSort = null;

                switch (lotteryPlayEnum) {
                    case SFC_DIGITAL:
                        winningBetSort = map.get(lotteryBettingEnum.getCode()).get(Integer.valueOf(openCodes[i])+"");
                        break;
                    case SFC_BIG_SMALL:
                        winningBetSort = generateBigSmallNum(map.get(lotteryBettingEnum.getCode()),openCodes[i]);
                        break;
                    case SFC_SINGLE_DOUBLE:
                        winningBetSort = generateSingleDoubleNum(map.get(lotteryBettingEnum.getCode()),Integer.valueOf(openCodes[i]));
                        break;
                    case SFC_ZBF:
                        winningBetSort = generateZbfNum(map.get(lotteryBettingEnum.getCode()),Integer.valueOf(openCodes[i]));
                        break;
                    case SFC_FW:
                        winningBetSort = generateFwfNum(map.get(lotteryBettingEnum.getCode()),Integer.valueOf(openCodes[i]));
                        break;
                    default:
                        break;
                }

                LotteryWinningRecord lotteryWinningRecord = createWinningRecord(lotteryResult, lotteryPlayEnum, lotteryBettingEnum, winningBetSort);
                if (lotteryWinningRecord != null) {
                    log.info("彩票开奖.十分彩.{0},生成中奖记录:{1}", playCode, lotteryWinningRecord.toString());
                    lotteryWinningRecordList.add(lotteryWinningRecord);
                }
            }
        }
        return lotteryWinningRecordList;
    }
}
