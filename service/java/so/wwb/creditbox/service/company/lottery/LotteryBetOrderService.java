package so.wwb.creditbox.service.company.lottery;

import org.soul.service.support.BaseService;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.company.lottery.LotteryBetOrderMapper;
import so.wwb.creditbox.iservice.company.lottery.ILotteryBetOrderService;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;


/**
 * 投注记录表服务
 *
 * @author block
 * @time 2019-11-27 21:11:29
 */
//region your codes 1
public class LotteryBetOrderService extends BaseService<LotteryBetOrderMapper, LotteryBetOrderListVo, LotteryBetOrderVo, LotteryBetOrder, Integer> implements ILotteryBetOrderService {

//endregion your codes 1

    //region your codes 2
    @Transactional
    @Override
    public LotteryBetOrderVo saveBetOrder(LotteryBetOrderVo vo) {
        mapper.batchInsert(vo.getEntities());
        return vo;
    }

    @Override
    public LotteryBetOrderListVo sumSortType(LotteryBetOrderListVo lotteryBetOrderListVo) {
        lotteryBetOrderListVo.setResult(mapper.sumSortType(lotteryBetOrderListVo.getSearch()));
        return lotteryBetOrderListVo;
    }
    //endregion your codes 2

}