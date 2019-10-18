package so.wwb.lotterybox.iservice.manager.lottery;

import so.wwb.lotterybox.model.manager.lottery.WinningRecord;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;

public interface IWinningRecordHandle {

    //根据开奖结果生成对应彩种的所有彩种玩法的中奖记录
    WinningRecord handle(LotteryResultNumber number);
}
