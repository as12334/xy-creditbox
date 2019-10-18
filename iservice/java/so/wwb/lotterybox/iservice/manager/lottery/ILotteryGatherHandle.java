package so.wwb.lotterybox.iservice.manager.lottery;

import so.wwb.lotterybox.model.manager.lottery.LotteryGatherParam;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;

public interface ILotteryGatherHandle {
    LotteryResultListVo doMakeUp(LotteryGatherParam gatherParam);

    Object doGather(LotteryGatherParam gatherParam);

    void doValid(LotteryGatherConf gatherConf);
}
