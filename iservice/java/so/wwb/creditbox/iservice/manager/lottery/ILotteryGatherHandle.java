package so.wwb.creditbox.iservice.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;

public interface ILotteryGatherHandle {
    LotteryResultListVo doMakeUp(LotteryGatherParam gatherParam);

    Object doGather(LotteryGatherParam gatherParam);

    void doValid(LotteryGatherConf gatherConf);
}
