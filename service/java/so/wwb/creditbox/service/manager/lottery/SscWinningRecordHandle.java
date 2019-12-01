package so.wwb.creditbox.service.manager.lottery;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

import java.util.*;

/**
 * Created by shook on 17-4-9.
 */
public class SscWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {
    private static List<String> oneDigitalBettingList = new ArrayList<>(5);
    private static List<String> oneDigitalPlayList = new ArrayList<>(5);


    static {
        //一字定位的投注玩法：万千百十个
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_ONE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_TWO.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_THREE.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_FOUR.getCode());
        oneDigitalBettingList.add(LotteryBettingEnum.SSC_FIVE.getCode());

        oneDigitalPlayList.add(LotteryPlayEnum.SSC_BIG_SMALL.getCode());
        oneDigitalPlayList.add(LotteryPlayEnum.SSC_SINGLE_DOUBLE.getCode());

    }

    @Override
    public WinningRecordHandleVo handle(LotteryResult lotteryResult) {
//        if (isIllegalResult(lotteryResult)) {
//            log.info("开奖结果数据异常,请排查开奖接口是否正常!");
//            return null;
//        }
        WinningRecordHandleVo winningRecordHandleVo = new WinningRecordHandleVo();
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        if (openCodes != null && openCodes.length == 5) {
            lotteryWinningRecordList.addAll(createOneDigital(lotteryResult));
//            lotteryWinningRecordList.addAll(createTwoDigital(lotteryResult));
//            lotteryWinningRecordList.addAll(createThreeDigital(lotteryResult));
//            lotteryWinningRecordList.addAll(createOneCombination(lotteryResult));
//            lotteryWinningRecordList.addAll(createTwoCombination(lotteryResult));
//            lotteryWinningRecordList.addAll(createFive(lotteryResult));
//            lotteryWinningRecordList.addAll(createDragonTigerTie(lotteryResult));
//            lotteryWinningRecordList.addAll(createGroup3(lotteryResult));
//            lotteryWinningRecordList.addAll(createGroup6(lotteryResult));
//            lotteryWinningRecordList.addAll(createSpan(lotteryResult));
            //官方玩法的中奖记录
        }
        winningRecordHandleVo.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecordHandleVo;
    }

    private List<LotteryWinningRecord> createOneDigital(LotteryResult lotteryResult) {

        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int i = 0; i < oneDigitalBettingList.size(); i++) {
            LotteryBettingEnum lotteryBettingEnum = EnumTool.enumOf(LotteryBettingEnum.class, oneDigitalBettingList.get(i));
            for (String playCode : oneDigitalPlayList) {
                LotteryPlayEnum lotteryPlayEnum = EnumTool.enumOf(LotteryPlayEnum.class, playCode);
                String winningNum = null;
                switch (lotteryPlayEnum) {
//                    case ONE_DIGITAL:
//                        winningNum = openCodes[i];
//                        break;
//                    case ONE_BIG_SMALL:
//                        winningNum = generateBigSmallNum(openCodes[i]);
//                        break;
//                    case ONE_SINGLE_DOUBLE:
//                        winningNum = generateSingleDoubleNum(Integer.valueOf(openCodes[i]));
//                        break;
//                    case ONE_PRIME_COMBINED:
//                        winningNum = generatePrimeCombinedNum(Integer.valueOf(openCodes[i]));
//                        break;
//                    default:
//                        break;
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




    private String generateTwoDigital(String openCode1, String openCode2) {
        return openCode1 + openCode2;
    }

    private String generateThreeDigital(String openCode1, String openCode2, String openCode3) {
        return openCode1 + openCode2 + openCode3;
    }

}
