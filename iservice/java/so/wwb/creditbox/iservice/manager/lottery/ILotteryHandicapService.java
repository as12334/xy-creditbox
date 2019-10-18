package so.wwb.creditbox.iservice.manager.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.manager.lottery.po.LotteryHandicap;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryHandicapListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryHandicapVo;


/**
 * 彩种盘口服务接口
 *
 * @author admin
 * @time 2017-4-11 20:35:57
 */
//region your codes 1
public interface ILotteryHandicapService extends IBaseService<LotteryHandicapListVo, LotteryHandicapVo, LotteryHandicap, Integer> {
//endregion your codes 1

    //region your codes 2

    /**
     * 编辑开奖周期
     * @param resultVo
     * @return
     */
    LotteryHandicapVo updateLotteryHandicap(LotteryHandicapVo resultVo);
    //endregion your codes 2

}