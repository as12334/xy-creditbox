package so.wwb.creditbox.iservice.company.lottery;

import org.soul.iservice.support.IBaseService;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;
import so.wwb.creditbox.model.company.user.po.VSiteUser;


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

    LotteryBetOrderListVo sumBetCode(LotteryBetOrderListVo lotteryBetOrderListVo);

    /**
     * 查询用户余额和已使用余额
     * @param lotteryBetOrderVo
     * @return
     */
    VSiteUser usableCredit(LotteryBetOrderVo lotteryBetOrderVo);
    //endregion your codes 2

}