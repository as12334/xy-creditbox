package so.wwb.creditbox.service.manager.gather;


import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

/**
 * Created by admin on 17-4-1.
 */
public interface ILotteryGatherHandle {

    LotteryResultListVo doCollection(LotteryGatherParam gatherParam);

    LotteryResultVo doGather(LotteryGatherParam gatherParam);

    void doValid(LotteryGatherConf gatherConf);
}
