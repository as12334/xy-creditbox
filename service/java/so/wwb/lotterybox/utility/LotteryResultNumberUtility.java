package so.wwb.lotterybox.utility;

import org.soul.commons.bean.BeanTool;
import so.wwb.lotterybox.iservice.manager.lottery.IWinningRecordHandle;
import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryWinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.lotterybox.service.manager.lottery.winning.LotteryResultHandleFactory;

import java.util.List;

public class LotteryResultNumberUtility {

    /**
     * 根据LotteryResult转成LotteryResultNumber
     * @param lotteryResult
     * @return
     */
    public static LotteryResultNumber createByLotteryResult(LotteryResult lotteryResult){
        LotteryResultNumber result = BeanTool.copyProperties(lotteryResult,new LotteryResultNumber());
        result.setId(null);
        return result;
    }

    public static List<LotteryWinningRecord> handleWinningRecords(LotteryResult lotteryResult) {
        LotteryResultNumber lotteryResultNumber = createByLotteryResult(lotteryResult);
        return handleWinningRecords(lotteryResultNumber);
    }

    public static List<LotteryWinningRecord> handleWinningRecords(LotteryResultNumber lotteryResultNumber) {
        IWinningRecordHandle winningRecordHandle = LotteryResultHandleFactory.createHandle(lotteryResultNumber.getType());
        WinningRecord winningRecord = winningRecordHandle.handle(lotteryResultNumber);
        return (List<LotteryWinningRecord>) winningRecord.getLotteryWinningRecordList();
    }
}
