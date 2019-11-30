package so.wwb.creditbox.service.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.service.company.handler.WinningRecordHandleVo;

/**
 * Created by shook on 17-4-9.
 */
public interface IWinningRecordHandle {

    /**
     * 根据开奖结果生成对应彩种的所有彩种玩法的中奖记录
     *
     * @param lotteryResult
     * @return
     */
    WinningRecordHandleVo handle(LotteryResult lotteryResult);
}
