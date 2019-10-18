package so.wwb.creditbox.utility;

import so.wwb.creditbox.iservice.manager.lottery.IWinRecordKeyHandle;
import so.wwb.creditbox.service.manager.lottery.winningKey.LotteryWinKeyHandleFactory;

import java.util.List;

public class LotteryOwnWinKeyUtility {

    public static List<String> handleWinKeyRecords(String code,List<String> resultList) {
        IWinRecordKeyHandle winKey = LotteryWinKeyHandleFactory.createHandle(code);
        return  winKey.handle(code,resultList);
    }
}
