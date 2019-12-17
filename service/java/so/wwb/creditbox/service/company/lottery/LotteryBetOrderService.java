package so.wwb.creditbox.service.company.lottery;

import org.soul.commons.math.NumberTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.service.support.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.creditbox.data.company.lottery.LotteryBetOrderMapper;
import so.wwb.creditbox.data.company.user.VSiteUserMapper;
import so.wwb.creditbox.iservice.company.lottery.ILotteryBetOrderService;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.enums.lottery.LotteryOrderStatusEnum;

import java.util.List;
import java.util.Optional;


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

    @Autowired
    private VSiteUserMapper vSiteUserMapper;
    @Transactional
    @Override
    public LotteryBetOrderVo saveBetOrder(LotteryBetOrderVo vo) {
        mapper.batchInsert(vo.getEntities());
        return vo;
    }

    @Override
    public LotteryBetOrderListVo sumBetCode(LotteryBetOrderListVo lotteryBetOrderListVo) {
        lotteryBetOrderListVo.setResult(mapper.sumBetCode(lotteryBetOrderListVo.getSearch()));
        return lotteryBetOrderListVo;
    }

    @Override
    public VSiteUser usableCredit(LotteryBetOrderVo lotteryBetOrderVo) {
        LotteryBetOrderSo search = lotteryBetOrderVo.getSearch();
        VSiteUser vSiteUser = vSiteUserMapper.get(search.getUserId());
        Number sum1 =  mapper.sum(Criteria.add(LotteryBetOrder.PROP_STATUS, Operator.EQ, LotteryOrderStatusEnum.PENDING.getCode()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.GE, search.getQueryStartDate()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.LE, search.getQueryEndDate()), LotteryBetOrder.PROP_BET_AMOUNT);
        if (sum1 == null){
            sum1 = 0.0;
        }
        Number sum2 = mapper.sum(Criteria.add(LotteryBetOrder.PROP_STATUS, Operator.EQ, LotteryOrderStatusEnum.SETTLED.getCode()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.GE, search.getQueryStartDate()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.LE, search.getQueryEndDate()), LotteryBetOrder.PROP_BPAYOUT);
        if (sum2 == null){
            sum2 = 0.0;
        }
        Number sum3 = mapper.sum(Criteria.add(LotteryBetOrder.PROP_STATUS, Operator.EQ, LotteryOrderStatusEnum.SETTLED.getCode()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.GE, search.getQueryStartDate()).addAnd(LotteryBetOrder.PROP_BET_TIME, Operator.LE, search.getQueryEndDate()), LotteryBetOrder.PROP_REBATE8);
        if (sum3 == null){
            sum3 = 0.0;
        }
        vSiteUser.setToDayProfit(sum2.doubleValue() + sum3.doubleValue());
        double v = sum1.doubleValue() - sum2.doubleValue() -sum3.doubleValue();
        vSiteUser.setUsableCredit(v);
        return vSiteUser;
    }

    @Override
    public List<SiteLotteryOdds> searchOddsInfo(LotteryBetOrderListVo lotteryBetOrderListVo) {
        return mapper.searchOddsInfo(lotteryBetOrderListVo.getSearch());
    }
    //endregion your codes 2

}