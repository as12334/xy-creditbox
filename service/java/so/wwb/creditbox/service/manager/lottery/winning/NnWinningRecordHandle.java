package so.wwb.creditbox.service.manager.lottery.winning;

import org.soul.commons.lang.string.StringTool;
import so.wwb.creditbox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.creditbox.model.enums.lottery.LotteryBetNumEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shook on 17-4-10.
 */
public class NnWinningRecordHandle extends AbstractWinningRecordHandle implements IWinningRecordHandle {

    private static List<String> playList = new ArrayList<>(2);
    private static List<LotteryBetNumEnum> betList = new ArrayList<>(5);

    static {
        //betCode
        betList.add(LotteryBetNumEnum.NN_XIAN_YI);
        betList.add(LotteryBetNumEnum.NN_XIAN_ER);
        betList.add(LotteryBetNumEnum.NN_XIAN_SAN);
        betList.add(LotteryBetNumEnum.NN_XIAN_SI);
        betList.add(LotteryBetNumEnum.NN_XIAN_WU);
        //playCode
        playList.add(LotteryPlayEnum.NN_LEVEL.getCode());
        playList.add(LotteryPlayEnum.NN_MULTIPLE.getCode());

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
        winningRecord.setLotteryWinningRecordList(lotteryWinningRecordList);
        return winningRecord;
    }

    private List<LotteryWinningRecord> createDigital(LotteryResultNumber lotteryResult) {
        List<LotteryWinningRecord> lotteryWinningRecordList = new ArrayList<>();
        String[] openCodes = StringTool.split(lotteryResult.getOpenCode(), ",");
        for (int j = 0; j < playList.size(); j++) {
            for (LotteryBetNumEnum nnBetNumEnum : betList) {
                if (LotteryPlayEnum.NN_LEVEL.getCode().equals(playList.get(j))) {
                    LotteryWinningRecord lotteryWinningRecord = createNiuWinningRecord(lotteryResult, playList.get(j), LotteryBettingEnum.NN_XIAN_JIA_LEVEL.getCode(), nnBetNumEnum, openCodes);
                    if (lotteryWinningRecord != null) {
                        log.info("彩票开奖.PK10牛牛.{0},生成中奖记录:{1}", playList.get(j), lotteryWinningRecord.toString());
                        lotteryWinningRecordList.add(lotteryWinningRecord);
                    }
                } else if (LotteryPlayEnum.NN_MULTIPLE.getCode().equals(playList.get(j))) {
                    LotteryWinningRecord lotteryWinningRecord = createNiuWinningRecord(lotteryResult, playList.get(j), LotteryBettingEnum.NN_XIAN_JIA_MULTIPLE.getCode(), nnBetNumEnum, openCodes);
                    if (lotteryWinningRecord != null) {
                        log.info("彩票开奖.PK10牛牛.{0},生成中奖记录:{1}", playList.get(j), lotteryWinningRecord.toString());
                        lotteryWinningRecordList.add(lotteryWinningRecord);
                    }
                }
            }

        }
        return lotteryWinningRecordList;
    }
}
