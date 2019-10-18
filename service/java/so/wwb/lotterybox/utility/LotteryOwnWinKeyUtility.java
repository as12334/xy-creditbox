package so.wwb.lotterybox.utility;

import so.wwb.lotterybox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.lotterybox.service.manager.lottery.winningKey.LotteryWinKeyHandleFactory;

import java.util.List;

public class LotteryOwnWinKeyUtility {

    public static List<String> handleWinKeyRecords(String code,List<String> resultList) {
        IWinRecordKeyHandle winKey = LotteryWinKeyHandleFactory.createHandle(code);
        return  winKey.handle(code,resultList);
    }
}
