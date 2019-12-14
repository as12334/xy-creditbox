package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;


/**
 * 投注记录表服务接口
 *
 * @author block
 * @time 2019-11-27 21:11:29
 */
//region your codes 1
public interface ILotteryBetOrderService extends IBaseService<LotteryBetOrderListVo, LotteryBetOrderVo, LotteryBetOrder, Integer> {

//endregion your codes 1

    //region your codes 2
    LotteryBetOrderVo saveBetOrder(LotteryBetOrderVo vo);

    LotteryBetOrderListVo sumSortType(LotteryBetOrderListVo lotteryBetOrderListVo);
    //endregion your codes 2

}