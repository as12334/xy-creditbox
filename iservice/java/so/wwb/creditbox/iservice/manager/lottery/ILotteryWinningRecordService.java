package so.wwb.creditbox.iservice.manager.lottery;


import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryWinningRecord;

import java.util.List;


/**
 * 中奖记录表服务接口
 *
 * @author shook
 * @time 2017-4-9 9:27:40
 */
//region your codes 1
public interface ILotteryWinningRecordService {
//endregion your codes 1

    //region your codes 2
    List<LotteryWinningRecord> handleWinningRecords(LotteryResult lotteryResult);
    //endregion your codes 2

}