package so.wwb.creditbox.iservice.manager.lottery;


import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

/**
 * Created by younger on 2017/4/13.
 */
public interface ILotteryResultPayoutService {

    /**
     * 自动全平台派彩
     *
     * @param resultVo
     * @return
     */
    boolean payoutForAll(LotteryResultVo resultVo);

    /**
     * 單站点派彩
     *
     * @param resultVo
     * @return
     */
    boolean payoutForOne(LotteryResultVo resultVo);

    /**
     * 全平台重结
     *
     * @param resultVo
     * @return
     */
    boolean heavyForAll(LotteryResultVo resultVo);

    /**
     * 重结單站点
     *
     * @param resultVo
     * @return
     */
    boolean heavyForOne(LotteryResultVo resultVo);

}
