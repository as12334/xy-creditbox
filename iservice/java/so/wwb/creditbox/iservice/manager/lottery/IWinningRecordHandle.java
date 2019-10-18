package so.wwb.creditbox.iservice.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.WinningRecord;
import so.wwb.creditbox.model.company.lottery.po.LotteryResultNumber;

public interface IWinningRecordHandle {

    //根据开奖结果生成对应彩种的所有彩种玩法的中奖记录
    WinningRecord handle(LotteryResultNumber number);
}
