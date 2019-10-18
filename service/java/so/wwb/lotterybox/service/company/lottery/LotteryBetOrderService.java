package so.wwb.lotterybox.service.company.lottery;

import org.apache.commons.collections.map.HashedMap;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.exception.ServiceException;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.Paging;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.data.rdb.mybatis.IBaseQueryMapper;
import org.soul.model.common.BaseListVo;
import org.soul.model.common.IQuery;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.service.support.BaseService;
import org.soul.web.session.SessionManagerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.data.company.lottery.LotteryBetOrderMapper;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryService;
import so.wwb.lotterybox.iservice.manager.sys.ISysSiteService;
//import so.wwb.lotterybox.iservice.company.bill.IBillAuditService;
//import so.wwb.lotterybox.iservice.company.bill.IBillChangeService;
import so.wwb.lotterybox.iservice.company.lottery.ILotteryBetOrderService;
//import so.wwb.lotterybox.iservice.company.lottery.ILotteryBillService;
//import so.wwb.lotterybox.iservice.company.user.IUserAssetsService;
import so.wwb.lotterybox.lottery.BetOrderTool;
import so.wwb.lotterybox.lottery.ParamCheckTool;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.bean.AssetsBean;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.model.enums.base.DictEnum;
import so.wwb.lotterybox.model.enums.base.Module;
import so.wwb.lotterybox.model.enums.base.SubSysCodeEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryBettingEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryOrderStatusEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.lotterybox.model.manager.lottery.bean.OrderBean;
import so.wwb.lotterybox.model.manager.lottery.po.Lottery;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.company.lottery.po.BetOrderWin;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.lotterybox.model.company.lottery.so.LotteryBetOrderSo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryBetOrderVo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 投注记录表服务
 *
 * @author fei
 * @time 2017-4-8 14:33:26
 */
public class LotteryBetOrderService extends BaseService<LotteryBetOrderMapper, LotteryBetOrderListVo, LotteryBetOrderVo, LotteryBetOrder, Integer> implements ILotteryBetOrderService {

    private Log LOG = LogFactory.getLog(LotteryBetOrderService.class);
//
//    @Autowired
//    private IUserAssetsService userAssetsService;
//    @Autowired
//    private ILotteryBillService lotteryBillService;
//    @Autowired
//    private IBillChangeService billChangeService;
//    @Autowired
//    private IBillAuditService billAuditService;
    @Autowired
    private ILotteryService lotteryService;
    @Autowired
    private ISysSiteService sysSiteService;


//    @Override
//    public Map<String, String> sumAmount(LotteryBetOrderListVo listVo) {
//        return this.mapper.sumAmount(listVo.getSearch());
//    }

    protected <T extends BaseListVo> T search(T listVo, IBaseQueryMapper mapper) {
        IQuery search = listVo.getQuery();
        Criteria criteria = search.getFinalCriteria();
        return this.search(criteria, listVo, mapper);
    }

    @Override
    public Map<String, Map<String, List<LotteryBetOrder>>> load(LotteryBetOrderListVo listVo) {
        Map<String, Map<String, List<LotteryBetOrder>>> result = new LinkedHashMap<>();
        Integer siteId = listVo.getSearch().getSiteId();
        Criteria criteria = Criteria.add(LotteryBetOrder.PROP_CODE, Operator.EQ, listVo.getSearch().getCode()).addAnd(LotteryBetOrder.PROP_EXPECT, Operator.EQ, listVo.getSearch().getExpect());
        List<LotteryBetOrder> list = this.mapper.search(criteria, Order.desc(LotteryBetOrder.PROP_BET_TIME));

        if (CollectionTool.isNotEmpty(list)) {
            String cacheKey = CacheKey.getCacheKey(Integer.toString(siteId), listVo.getSearch().getCode());
            if (result.get(cacheKey) == null) {
                result.put(cacheKey, new HashMap<>());
            }
            String valueKey = CacheKey.getCacheKey(listVo.getSearch().getExpect());
            result.get(cacheKey).put(valueKey, list);
        }
        return result;
    }

//    public List<LotteryBetOrder> billChangeListByOwnerCode(LotteryBetOrderListVo vo) {
//        if (StringTool.isNotBlank(vo.getSearch().getDistributorCode())) {
//            vo.getSearch().setSearchMap(vo.getQueryParams());
//            return this.mapper.billChangeListByOwnerCode(vo.getSearch());
//        } else {
//            return new ArrayList<LotteryBetOrder>();
//        }
//    }
//
//    public Map<String, Double> distributorBetOrderTotal(LotteryBetOrderListVo vo) {
//        vo.getSearch().setSearchMap(vo.getQueryParams());
//        return this.mapper.distributorBetOrderTotal(vo.getSearch());
//    }
//
//    @Override
//    public int distributorBetOrderCount(LotteryBetOrderListVo listVo) {
//        return this.mapper.distributorBetOrderCount(listVo.getSearch());
//    }
//
//    /**
//     * @param betOrderVo
//     * @return
//     */
//    @Transactional
//    public LotteryBetOrderVo revoOrder(LotteryBetOrderVo betOrderVo) {
//        betOrderVo = beforeRevoOrder(betOrderVo);
//        if (!betOrderVo.isSuccess()) {
//            return betOrderVo;
//        }
//        if (BillItemEnum.REVOCATION_REFUND.getCode().equals(betOrderVo.getItem())) {
//            betOrderVo = doRevocationOrder(betOrderVo);
//        } else if (BillItemEnum.REVOKE_REFUND.getCode().equals(betOrderVo.getItem())) {
//            betOrderVo = doRevoKeOrder(betOrderVo);
//        }
//        return betOrderVo;
//    }
//
////    /**
////     * 单条注单撤单或撤销
////     * @param orderVo
////     * @return
////     */
////    @Transactional
////    public LotteryBetOrderVo doRevoOrder(LotteryBetOrderVo orderVo) {
////        LotteryBetOrder lotteryBetOrder = orderVo.getResult();
////        BillItemEnum itemEnum = EnumTool.enumOf(BillItemEnum.class,orderVo.getItem());
////        if(lotteryBetOrder.getBetAmount() != null && lotteryBetOrder.getBetAmount().doubleValue() > 0 && !LotteryPlayEnum.NN_MULTIPLE.getCode().equals(lotteryBetOrder.getPlayCode())){
////            //撤单,撤销退款
////            UserAssetsVo assetsVo = new UserAssetsVo();
////            assetsVo.setResult(new UserAssets());
////            assetsVo.getResult().setId(lotteryBetOrder.getUserId());
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum)) {
////                assetsVo.getResult().setBalance(lotteryBetOrder.getRealBetAmount());
////                assetsVo.getResult().setBetTotal(-lotteryBetOrder.getRealBetAmount());
////            } else if (BillItemEnum.REVOKE_REFUND.equals(itemEnum)) {
////                assetsVo.getResult().setBalance(lotteryBetOrder.getBetAmount());
////                assetsVo.getResult().setBetTotal(-lotteryBetOrder.getBetAmount());
////            }
////            boolean saveFlag = userAssetsService.updateBalanceAndBetTotal(assetsVo);
////            if(!saveFlag){
////                LOG.error("彩票撤单或撤销失败,原因:{0}","更新玩家余额失败！");
////                throw new ServiceException(Module.LOTTERY, "操作失败!");
////            }
//////            BillItemEnum itemEnum = EnumTool.enumOf(BillItemEnum.class,orderVo.getItem());
////            String billNo = GeneratIdTool.genBillNo(itemEnum.getParent(), lotteryBetOrder.getUserId());
////            LotteryBillVo lotteryBillVo = getLotteryBillVo(lotteryBetOrder,billNo, itemEnum);
////            lotteryBillService.saveLotteryBill(lotteryBillVo);
////            BillChangeVo billChangeVo = getBillChangeVo(lotteryBillVo.getResult(),lotteryBetOrder);
////            billChangeService.saveBillChange(billChangeVo);
////
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() != null) {
////                assetsVo.getResult().setProfit(-(lotteryBetOrder.getPayout().doubleValue() - lotteryBetOrder.getEffectiveTradeAmount().doubleValue()));
////                assetsVo.getResult().setEffectiveBetTotal(-lotteryBetOrder.getEffectiveTradeAmount().doubleValue());
////                saveFlag = userAssetsService.updateProfitAndEffectiveBetTotal(assetsVo);
////                if (!saveFlag) {
////                    LOG.error("彩票撤销失败,原因:{0}","更新玩家(总)盈亏失败！");
////                    throw new ServiceException(Module.LOTTERY, "操作失败!");
////                }
////
////                if (lotteryBetOrder.getPayout().doubleValue() > 0) {
////                    assetsVo.getResult().setBalance(-lotteryBetOrder.getPayout());
////                    assetsVo.getResult().setPayout(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateBalanceAndPayoutData(assetsVo);
////                    if(!saveFlag){
////                        LOG.error("彩票撤销失败,原因:{0}","更新玩家余额或(总)派彩失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                }
////                if (lotteryBetOrder.getPayout().doubleValue() > 0 && LotteryOrderStatusEnum.WINING.getCode().equals(lotteryBetOrder.getStatus())) {
////                    assetsVo.getResult().setAward(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateAwardData(assetsVo);
////                    if(!saveFlag){
////                        LOG.error("彩票撤销失败,原因:{0}","更新玩家(总)中奖金额失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                }
////                billNo = GeneratIdTool.genBillNo(BillItemEnum.REVOCATION_WITHHOLD.getParent(), lotteryBetOrder.getUserId());
////                lotteryBillVo = getLotteryBillVo(lotteryBetOrder,billNo, BillItemEnum.REVOCATION_WITHHOLD);
////                lotteryBillService.saveLotteryBill(lotteryBillVo);
////                billChangeVo = getBillChangeVo(lotteryBillVo.getResult(),lotteryBetOrder);
////                billChangeService.saveBillChange(billChangeVo);
////                billAuditService.updateByOrderId(lotteryBetOrder.getId());
////            }
////
////            if(BillItemEnum.REVOKE_REFUND.equals(itemEnum)){
////                if (SubSysCodeEnum.HALL.getCode().equals(orderVo.getSubsysCode())) {
////                    lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOKE_SELF.getCode());
////                } else {
////                    lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOKE_SYS.getCode());
////                }
////            }else if(BillItemEnum.REVOCATION_REFUND.equals(itemEnum)){
////                lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOCATION.getCode());
////            }
////            lotteryBetOrder.setEffectiveTradeAmount(Double.valueOf(0D));
////            this.mapper.updateOnly(lotteryBetOrder, LotteryBetOrder.PROP_STATUS, LotteryBetOrder.PROP_EFFECTIVE_TRADE_AMOUNT);
////        } else if (LotteryPlayEnum.NN_MULTIPLE.getCode().equals(lotteryBetOrder.getPlayCode())) {
////            //撤单,撤销退款
////            UserAssetsVo assetsVo = new UserAssetsVo();
////            assetsVo.setResult(new UserAssets());
////            assetsVo.getResult().setId(lotteryBetOrder.getUserId());
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() != null && lotteryBetOrder.getPayout().doubleValue() <= 0) {
////                assetsVo.getResult().setBalance(lotteryBetOrder.getRealBetAmount().doubleValue() + lotteryBetOrder.getPayout().doubleValue()*-1);
////            } else {
////                if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() != null && lotteryBetOrder.getPayout().doubleValue() > 0) {
////                    assetsVo.getResult().setBalance(lotteryBetOrder.getBetAmount());
////                } else if (BillItemEnum.REVOKE_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() == null) {
////                    assetsVo.getResult().setBalance(lotteryBetOrder.getBetAmount().doubleValue() + lotteryBetOrder.getFreezAmount().doubleValue());
////                }
////            }
////            assetsVo.getResult().setBetTotal(-lotteryBetOrder.getBetAmount());
////            boolean saveFlag = userAssetsService.updateBalanceAndBetTotal(assetsVo);
////            if(!saveFlag){
////                LOG.error("彩票撤单或撤销失败,原因:{0}","更新玩家余额失败！");
////                throw new ServiceException(Module.LOTTERY, "操作失败!");
////            }
////            String billNo = GeneratIdTool.genBillNo(itemEnum.getParent(), lotteryBetOrder.getUserId());
////            LotteryBillVo lotteryBillVo = getLotteryBillVo(lotteryBetOrder,billNo, itemEnum);
////            lotteryBillService.saveLotteryBill(lotteryBillVo);
////            BillChangeVo billChangeVo = getBillChangeVo(lotteryBillVo.getResult(),lotteryBetOrder);
////            billChangeService.saveBillChange(billChangeVo);
////
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() != null) {
////                assetsVo.getResult().setProfit(-(lotteryBetOrder.getPayout().doubleValue() - lotteryBetOrder.getEffectiveTradeAmount().doubleValue()));
////                assetsVo.getResult().setEffectiveBetTotal(-lotteryBetOrder.getEffectiveTradeAmount().doubleValue());
////                saveFlag = userAssetsService.updateProfitAndEffectiveBetTotal(assetsVo);
////                if (!saveFlag) {
////                    LOG.error("彩票撤销失败,原因:{0}","更新玩家(总)盈亏失败！");
////                    throw new ServiceException(Module.LOTTERY, "操作失败!");
////                }
////                assetsVo.getResult().setPayout(-lotteryBetOrder.getPayout());
////                if (lotteryBetOrder.getPayout().doubleValue() > 0) {
////                    assetsVo.getResult().setBalance(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateBalanceAndPayoutData(assetsVo);
////                    if(!saveFlag){
////                        LOG.error("彩票撤销失败,原因:{0}","更新玩家余额或(总)派彩失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                }
////                if (lotteryBetOrder.getPayout().doubleValue() > 0 && LotteryOrderStatusEnum.WINING.getCode().equals(lotteryBetOrder.getStatus())) {
////                    assetsVo.getResult().setAward(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateAwardData(assetsVo);
////                    if(!saveFlag){
////                        LOG.error("彩票撤销失败,原因:{0}","更新玩家(总)中奖金额失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                    billNo = GeneratIdTool.genBillNo(BillItemEnum.REVOCATION_WITHHOLD.getParent(), lotteryBetOrder.getUserId());
////                    lotteryBillVo = getLotteryBillVo(lotteryBetOrder,billNo, BillItemEnum.REVOCATION_WITHHOLD);
////                    lotteryBillService.saveLotteryBill(lotteryBillVo);
////                    billChangeVo = getBillChangeVo(lotteryBillVo.getResult(),lotteryBetOrder);
////                    billChangeService.saveBillChange(billChangeVo);
////                }
////                billAuditService.updateByOrderId(lotteryBetOrder.getId());
////            }
////
////            if(BillItemEnum.REVOKE_REFUND.equals(itemEnum)){
////                lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOKE_SYS.getCode());
////            }else if(BillItemEnum.REVOCATION_REFUND.equals(itemEnum)){
////                lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOCATION.getCode());
////            }
////            lotteryBetOrder.setEffectiveTradeAmount(Double.valueOf(0D));
////            this.mapper.updateOnly(lotteryBetOrder, LotteryBetOrder.PROP_STATUS, LotteryBetOrder.PROP_EFFECTIVE_TRADE_AMOUNT);
////        }
////        return orderVo;
////    }
////
//
//    /**
//     * 单条注单撤单
//     *
//     * @param orderVo
//     * @return
//     */
//    @Transactional
//    public LotteryBetOrderVo doRevoKeOrder(LotteryBetOrderVo orderVo) {
//        LotteryBetOrder lotteryBetOrder = orderVo.getResult();
//        BillItemEnum itemEnum = EnumTool.enumOf(BillItemEnum.class, orderVo.getItem());
//        if (lotteryBetOrder.getBetAmount() != null && lotteryBetOrder.getBetAmount().doubleValue() > 0) {
//            //撤单退款
//            double balance = 0d;
//            if (LotteryPlayEnum.NN_MULTIPLE.getCode().equals(lotteryBetOrder.getPlayCode())) {
//                balance = lotteryBetOrder.getBetAmount().doubleValue() + lotteryBetOrder.getFreezAmount().doubleValue();
//            } else {
//                balance = lotteryBetOrder.getBetAmount();
//            }
//            UserAssetsVo assetsVo = new UserAssetsVo();
//            assetsVo.setResult(new UserAssets());
//            assetsVo.getResult().setId(lotteryBetOrder.getUserId());
//            assetsVo.getResult().setBalance(balance);
//            assetsVo.getResult().setBetTotal(-lotteryBetOrder.getBetAmount());
////            boolean saveFlag = userAssetsService.updateBalanceAndBetTotal(assetsVo);
////            if (!saveFlag) {
////                LOG.error("彩票撤单失败,原因:{0}", "更新玩家余额失败！");
////                throw new ServiceException(Module.LOTTERY, "操作失败!");
////            }
//
//            String billNo = GeneratIdTool.genBillNo(itemEnum.getParent(), lotteryBetOrder.getUserId());
//            LotteryBillVo lotteryBillVo = getLotteryBillVo(lotteryBetOrder, billNo, itemEnum, balance);
////            lotteryBillService.saveLotteryBill(lotteryBillVo);
//            BillChangeVo billChangeVo = getBillChangeVo(lotteryBillVo.getResult(), lotteryBetOrder);
////            billChangeService.saveBillChange(billChangeVo);
//
//            if (BillItemEnum.REVOKE_REFUND.equals(itemEnum)) {
//                if (SubSysCodeEnum.HALL.getCode().equals(orderVo.getSubsysCode())) {
//                    lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOKE_SELF.getCode());
//                } else {
//                    lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOKE_SYS.getCode());
//                }
//            }
//            lotteryBetOrder.setEffectiveTradeAmount(Double.valueOf(0D));
//            lotteryBetOrder.setPayoutTime(new Date());
//            this.mapper.updateOnly(lotteryBetOrder, LotteryBetOrder.PROP_STATUS, LotteryBetOrder.PROP_EFFECTIVE_TRADE_AMOUNT, LotteryBetOrder.PROP_PAYOUT_TIME);
//        }
//        return orderVo;
//    }
//
//    /**
//     * 单条注单撤销
//     *
//     * @param orderVo
//     * @return
//     */
//    @Transactional
//    public LotteryBetOrderVo doRevocationOrder(LotteryBetOrderVo orderVo) {
////        LotteryBetOrder lotteryBetOrder = orderVo.getResult();
////        BillItemEnum itemEnum = EnumTool.enumOf(BillItemEnum.class, orderVo.getItem());
////        if (lotteryBetOrder.getBetAmount() != null && lotteryBetOrder.getBetAmount().doubleValue() > 0) {
////            //撤销退款
////            double balance = 0d;
////            if (LotteryPlayEnum.NN_MULTIPLE.getCode().equals(lotteryBetOrder.getPlayCode()) && lotteryBetOrder.getPayout() != null && lotteryBetOrder.getPayout().doubleValue() <= 0) {
////                balance = lotteryBetOrder.getBetAmount().doubleValue() + lotteryBetOrder.getPayout().doubleValue() * -1;
////            } else {
////                balance = lotteryBetOrder.getRealBetAmount();
////            }
////            UserAssetsVo assetsVo = new UserAssetsVo();
////            assetsVo.setResult(new UserAssets());
////            assetsVo.getResult().setId(lotteryBetOrder.getUserId());
////            assetsVo.getResult().setBalance(balance);
////            assetsVo.getResult().setBetTotal(-lotteryBetOrder.getRealBetAmount());
////            boolean saveFlag = userAssetsService.updateBalanceAndBetTotal(assetsVo);
////            if (!saveFlag) {
////                LOG.error("彩票撤销失败,原因:{0}", "更新玩家余额失败！");
////                throw new ServiceException(Module.LOTTERY, "操作失败!");
////            }
////            String billNo = GeneratIdTool.genBillNo(itemEnum.getParent(), lotteryBetOrder.getUserId());
////            LotteryBillVo lotteryBillVo = getLotteryBillVo(lotteryBetOrder, billNo, itemEnum, balance);
////            lotteryBillService.saveLotteryBill(lotteryBillVo);
////            BillChangeVo billChangeVo = getBillChangeVo(lotteryBillVo.getResult(), lotteryBetOrder);
////            billChangeService.saveBillChange(billChangeVo);
////
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum) && lotteryBetOrder.getPayout() != null) {
////                assetsVo.getResult().setProfit(-(lotteryBetOrder.getPayout().doubleValue() - lotteryBetOrder.getRebateAmount()));
////                assetsVo.getResult().setEffectiveBetTotal(-lotteryBetOrder.getEffectiveTradeAmount().doubleValue());
////                saveFlag = userAssetsService.updateProfitAndEffectiveBetTotal(assetsVo);
////                if (!saveFlag) {
////                    LOG.error("彩票撤销失败,原因:{0}", "更新玩家(总)盈亏失败！");
////                    throw new ServiceException(Module.LOTTERY, "操作失败!");
////                }
////
////                if (lotteryBetOrder.getPayout().doubleValue() > 0) {
////                    assetsVo.getResult().setBalance(-lotteryBetOrder.getPayout());
////                    assetsVo.getResult().setPayout(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateBalanceAndPayoutData(assetsVo);
////                    if (!saveFlag) {
////                        LOG.error("彩票撤销失败,原因:{0}", "更新玩家余额或(总)派彩失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                }
////                if (lotteryBetOrder.getPayout().doubleValue() > 0 && LotteryOrderStatusEnum.WINING.getCode().equals(lotteryBetOrder.getStatus())) {
////                    assetsVo.getResult().setAward(-lotteryBetOrder.getPayout());
////                    saveFlag = userAssetsService.updateAwardData(assetsVo);
////                    if (!saveFlag) {
////                        LOG.error("彩票撤销失败,原因:{0}", "更新玩家(总)中奖金额失败！");
////                        throw new ServiceException(Module.LOTTERY, "操作失败!");
////                    }
////                }
////                if (lotteryBetOrder.getPayout().doubleValue() > 0 && LotteryOrderStatusEnum.WINING.getCode().equals(lotteryBetOrder.getStatus())) {
////                    billNo = GeneratIdTool.genBillNo(BillItemEnum.REVOCATION_WITHHOLD.getParent(), lotteryBetOrder.getUserId());
////                    lotteryBillVo = getLotteryBillVo(lotteryBetOrder, billNo, BillItemEnum.REVOCATION_WITHHOLD, lotteryBetOrder.getPayout() * -1);
////                    lotteryBillService.saveLotteryBill(lotteryBillVo);
////                    billChangeVo = getBillChangeVo(lotteryBillVo.getResult(), lotteryBetOrder);
////                    billChangeService.saveBillChange(billChangeVo);
////                }
////                billAuditService.updateByOrderId(lotteryBetOrder.getId());
////            }
////
////            if (BillItemEnum.REVOCATION_REFUND.equals(itemEnum)) {
////                lotteryBetOrder.setStatus(LotteryOrderStatusEnum.REVOCATION.getCode());
////            }
////            lotteryBetOrder.setEffectiveTradeAmount(Double.valueOf(0D));
////            lotteryBetOrder.setPayoutTime(new Date());
////            this.mapper.updateOnly(lotteryBetOrder, LotteryBetOrder.PROP_STATUS, LotteryBetOrder.PROP_EFFECTIVE_TRADE_AMOUNT, LotteryBetOrder.PROP_PAYOUT_TIME);
////        }
//        return orderVo;
//    }
//
//    /**
//     * 彩票撤单,撤销前置操作校验未通过
//     *
//     * @param betOrderVo
//     * @return
//     */
//    private LotteryBetOrderVo beforeRevoOrder(LotteryBetOrderVo betOrderVo) {
//        if (betOrderVo == null || betOrderVo.getSearch() == null || betOrderVo._getSiteId() == null || betOrderVo.getSearch().getId() == null || StringTool.isBlank(betOrderVo.getSubsysCode()) || StringTool.isBlank(betOrderVo.getItem())
//                || (!BillItemEnum.REVOKE_REFUND.getCode().equals(betOrderVo.getItem()) && !BillItemEnum.REVOCATION_REFUND.getCode().equals(betOrderVo.getItem()))) {
//            betOrderVo.setSuccess(false);
//            betOrderVo.setErrMsg("参数错误");
//            LOG.error("彩票撤单或撤销前置操作校验未通过,原因:{0}", betOrderVo.getErrMsg());
//            return betOrderVo;
//        }
//        if ((!SubSysCodeEnum.BOSS.getCode().equals(betOrderVo.getSubsysCode()) && !SubSysCodeEnum.COMPANY.getCode().equals(betOrderVo.getSubsysCode()) && !SubSysCodeEnum.HALL.getCode().equals(betOrderVo.getSubsysCode()))
//                || ((SubSysCodeEnum.COMPANY.getCode().equals(betOrderVo.getSubsysCode()) ) && BillItemEnum.REVOCATION_REFUND.getCode().equals(betOrderVo.getItem())) || (SubSysCodeEnum.HALL.getCode().equals(betOrderVo.getSubsysCode()) && BillItemEnum.REVOCATION_REFUND.getCode().equals(betOrderVo.getItem()))) {
//            betOrderVo.setSuccess(false);
//            betOrderVo.setErrMsg("无操作权限");
//            LOG.error("彩票撤单或撤销前置操作校验未通过,原因:{0}", betOrderVo.getErrMsg());
//            return betOrderVo;
//        }
//        betOrderVo = this.get(betOrderVo);
//        if (!betOrderVo.isSuccess() || betOrderVo.getResult() == null) {
//            betOrderVo.setSuccess(false);
//            betOrderVo.setErrMsg("缺少注单数据");
//            LOG.error("彩票撤单或撤销前置操作校验未通过,原因:{0}", betOrderVo.getErrMsg());
//            return betOrderVo;
//        }
//        if (BillItemEnum.REVOKE_REFUND.getCode().equals(betOrderVo.getItem()) && !LotteryOrderStatusEnum.PENDING.getCode().equals(betOrderVo.getResult().getStatus())) {
//            betOrderVo.setSuccess(false);
//            betOrderVo.setErrMsg("当前注单已结算,无法撤单");
//            LOG.error("彩票撤单或撤销前置操作校验未通过,原因:{0}", betOrderVo.getErrMsg());
//            return betOrderVo;
//        }
//        if (SubSysCodeEnum.BOSS.getCode().equals(betOrderVo.getSubsysCode()) && BillItemEnum.REVOCATION_REFUND.getCode().equals(betOrderVo.getItem()) && LotteryOrderStatusEnum.PENDING.getCode().equals(betOrderVo.getResult().getStatus())) {
//            betOrderVo.setSuccess(false);
//            betOrderVo.setErrMsg("当前注单还未结算,无法撤销");
//            LOG.error("彩票撤单或撤销前置操作校验未通过,原因:{0}", betOrderVo.getErrMsg());
//            return betOrderVo;
//        }
//        return betOrderVo;
//    }
//
//    //组装lotteryBill
//    private LotteryBillVo getLotteryBillVo(LotteryBetOrder lotteryBetOrder, String billNo, BillItemEnum item) {
//        LotteryBillVo lotteryBillVo = new LotteryBillVo();
//        LotteryBill lotteryBill = new LotteryBill();
//        lotteryBill.setType(item.getParent().getCode());
//        lotteryBill.setItem(item.getCode());
//        lotteryBill.setBillNo(billNo);
//        lotteryBill.setBetCount(lotteryBetOrder.getBetCount());
//        lotteryBill.setBetIds(new Integer[]{lotteryBetOrder.getId()});
//        if (BillItemEnum.REVOCATION_REFUND.equals(item) && lotteryBetOrder.getPayout().doubleValue() > 0) {
//            lotteryBill.setBetMoney(lotteryBetOrder.getRealBetAmount());
//        } else if (BillItemEnum.REVOKE_REFUND.equals(item) && !LotteryEnum.PK10NN.getCode().equals(lotteryBetOrder.getCode())) {
//            lotteryBill.setBetMoney(lotteryBetOrder.getBetAmount());
//        } else if (BillItemEnum.REVOCATION_WITHHOLD.equals(item)) {
//            lotteryBill.setBetMoney(-lotteryBetOrder.getPayout());
//        } else if (BillItemEnum.REVOKE_REFUND.equals(item) && LotteryEnum.PK10NN.getCode().equals(lotteryBetOrder.getCode())) {
//            lotteryBill.setBetMoney(lotteryBetOrder.getBetAmount().doubleValue() + lotteryBetOrder.getFreezAmount().doubleValue());
//        } else if (BillItemEnum.REVOCATION_REFUND.equals(item) && lotteryBetOrder.getPayout() != null && lotteryBetOrder.getPayout().doubleValue() <= 0) {
//            lotteryBill.setBetMoney(lotteryBetOrder.getRealBetAmount().doubleValue() + lotteryBetOrder.getPayout().doubleValue() * -1);
//        }
//        lotteryBill.setCode(lotteryBetOrder.getCode());
//        lotteryBill.setOrigin(lotteryBetOrder.getTerminal());
//        lotteryBill.setPlayerId(lotteryBetOrder.getUserId());
//        lotteryBill.setPlayerName(lotteryBetOrder.getUsername());
//        lotteryBill.setBillTime(new Date());
//        lotteryBillVo.setResult(lotteryBill);
//        return lotteryBillVo;
//    }
//
//    //组装lotteryBill
//    private LotteryBillVo getLotteryBillVo(LotteryBetOrder lotteryBetOrder, String billNo, BillItemEnum item, Double betMoney) {
//        LotteryBillVo lotteryBillVo = new LotteryBillVo();
//        LotteryBill lotteryBill = new LotteryBill();
//        lotteryBill.setType(item.getParent().getCode());
//        lotteryBill.setItem(item.getCode());
//        lotteryBill.setBillNo(billNo);
//        lotteryBill.setBetCount(lotteryBetOrder.getBetCount());
//        lotteryBill.setBetIds(new Integer[]{lotteryBetOrder.getId()});
//        lotteryBill.setBetMoney(betMoney);
//        lotteryBill.setCode(lotteryBetOrder.getCode());
//        lotteryBill.setOrigin(lotteryBetOrder.getTerminal());
//        lotteryBill.setPlayerId(lotteryBetOrder.getUserId());
//        lotteryBill.setPlayerName(lotteryBetOrder.getUsername());
//        lotteryBill.setBillTime(new Date());
//        lotteryBillVo.setResult(lotteryBill);
//        return lotteryBillVo;
//    }
//
//
//    //组装BillChange
//    private BillChangeVo getBillChangeVo(LotteryBill lotteryBill, LotteryBetOrder lotteryBetOrder) {
//        BillChangeVo billChangeVo = new BillChangeVo();
//        BillChange billChange = new BillChange();
//        BillTypeEnum typeEnum = EnumTool.enumOf(BillTypeEnum.class, lotteryBill.getType());
//        BillItemEnum itemEnum = EnumTool.enumOf(BillItemEnum.class, lotteryBill.getItem());
//        billChange.setType(typeEnum.getCode());
//        billChange.setWay(typeEnum.getParent().getCode());
//        billChange.setRemark(itemEnum.getTrans());
//        billChange.setItem(lotteryBill.getItem());
//        billChange.setPlayerId(lotteryBill.getPlayerId());
//        billChange.setPlayerName(lotteryBill.getPlayerName());
//        billChange.setBillNo(lotteryBill.getBillNo());
//        billChange.setSourceBillNo(lotteryBill.getBillNo());
//        billChange.setOrigin(lotteryBill.getOrigin());
//        billChange.setMoney(lotteryBill.getBetMoney());
//        billChange.setCompletionTime(lotteryBill.getBillTime());
//        billChange.setParentAgenterId(lotteryBetOrder.getParentAgenterId());
//        billChange.setParentAgenterName(lotteryBetOrder.getParentAgenterName());
//        billChangeVo.setResult(billChange);
//        return billChangeVo;
//    }
//
//
//    public Map queryBetOrderProfit(LotteryBetOrderListVo listVo) {
//        Map map = mapper.queryBetOrderProfit(listVo.getQueryParams());
//        return map;
//    }
//
//
//    @Override
//    public AssetsBean queryBetOrderAccountTotal(LotteryBetOrderListVo listVo) {
//        Map<String, Object> queryParams = new HashedMap();
//        queryParams.putAll(listVo.getQueryParams());
//        queryParams.put("queryStartDate", listVo.getSearch().getPayoutStartDate());
//        queryParams.put("queryEndDate", listVo.getSearch().getPayoutEndDate());
//        queryParams.put("code", listVo.getSearch().getCode());
//        String data = mapper.queryBetOrderAccountTotal(queryParams);
//        AssetsBean bean = JsonTool.fromJson(data, AssetsBean.class);
//        return bean;
//    }
//
//    @Override
//    public List<Map> queryLotteryBetOrderByTime(LotteryBetOrderListVo vo, String order, String property) {
//        Map<String, Object> map = vo.getQueryParams();
//        setCriterion(vo);
//        if (StringTool.isNotBlank(property) && StringTool.isNotBlank(order)) {
//            if ("DESC".equals(order)) {
//                map.put("sort", "ORDER BY " + property + " desc");
//            } else if ("ASC".equals(order)) {
//                map.put("sort", "ORDER BY " + property + " asc");
//            }
//        }
//        if (StringTool.isBlank(property) && StringTool.isBlank(order)) {
//            map.put("sort", "ORDER BY betAmount desc");
//        }
//        List<Map> maps = this.mapper.queryLotteryBetOrderByTime(map);
//        return maps;
//    }
//
//    @Override
//    public Map queryBetOrderProfitByParntId(LotteryBetOrderListVo listVo) {
//        listVo.getSearch().setSearchMap(listVo.getQueryParams());
//        return this.mapper.queryBetOrderProfitByParntId(listVo.getSearch());
//    }
//
//
//    @Override
//    public Map<String, Object> queryTotalByStatus(LotteryBetOrderListVo listVo) {
//        return this.mapper.queryTotalByStatus(listVo.getQueryParams());
//    }
//
//    @Override
//    public List<Map<String, Object>> getRecentProfit(LotteryBetOrderListVo listVo) {
//        return this.mapper.getRecentProfit(listVo.getSearch());
//    }
//
//    private void setCriterion(LotteryBetOrderListVo listVo) {
////        listVo.getQuery().addOrder("code", Direction.ASC);
//        LotteryBetOrderSo so = listVo.getSearch();
//        listVo.getQuery().setCriterions(new Criterion[]{
//                new Criterion(LotteryBetOrder.PROP_BET_TIME, Operator.GE, so.getQueryStartDate()),
//                new Criterion(LotteryBetOrder.PROP_BET_TIME, Operator.LT, so.getQueryEndDate()),
//                new Criterion(LotteryBetOrder.PROP_CODE, Operator.LT, so.getCode()),
//
//        });
//    }
//
//    // -----------------------------------------
//    @Override
//    @Transactional
//    public LotteryBetOrderVo addBetOrder(LotteryBetOrderVo vo) {
//        OrderBean bean = vo.getOrderBean();
//        SysUser user = vo.getUser();
//        if (ParamCheckTool.checkParam(bean, user)) return vo;
//
//        // 订单号（投注订单号）
//        //订单状态区分站点类型
//       /* String siteType = getSiteSubSysCode();
//        String status;
//        if (StringTool.isNotBlank(siteType) && SubSysCodeEnum.COMPANY.getCode().equals(siteType)) {
//            status = LotteryOrderStatusEnum.SENDING.getCode();
//        } else {
//            status = LotteryOrderStatusEnum.PENDING.getCode();
//        }*/
//
//        String status = LotteryOrderStatusEnum.PENDING.getCode();
//        List<LotteryBetOrder> betOrders = bean.getBetOrders();
//
//        try {
//            Integer[] betIds = new Integer[betOrders.size()];
//            // 冻结金额
//            double freezAmount = 0d;
//            // 投注金额
//            double betAmount = 0d;
//            for (int i = 0; i < betOrders.size(); i++) {
//                LotteryBetOrder order = betOrders.get(i);
//                order = BetOrderTool.packageOrder(order, status, vo);
//                // 保存注单
//                boolean insert = this.mapper.insert(order);
//                LOG.info("保存注单是否成功:{0}", insert);
//                betIds[i] = (order.getId());
//                if (LotteryEnum.PK10NN.getCode().equals(order.getCode()) && LotteryPlayEnum.NN_MULTIPLE.getCode().equals(order.getPlayCode()) && order.getFreezAmount() != null && order.getFreezAmount() > 0) {
//                    freezAmount = new BigDecimal(Double.toString(freezAmount)).add(new BigDecimal(Double.toString(order.getFreezAmount()))).doubleValue();
//                    betAmount = new BigDecimal(Double.toString(betAmount)).add(new BigDecimal(Double.toString(order.getBetAmount()))).doubleValue();
//                }
//            }
//            vo.setBetIds(betIds);
//            vo.setFreezAmount(freezAmount);
//            vo.setBetAmount(betAmount);
//        } catch (Exception e) {
//            vo.setBetIds(null);
//            vo.setFreezAmount(0d);
//            vo.setBetAmount(0d);
//            LOG.error("保存注单记录异常", e);
//        }
//
//        return vo;
//    }
//
//    private String getSiteSubSysCode() {
//        SysSite sysSite = CacheBase.getSiteById(SessionManagerBase.getSiteId());
//        if (sysSite == null) {
//            return null;
//        }
//        return sysSite.getSiteClassifyKey();
//    }
//
//    @Override
//    public List<LotteryBetOrder> sumBetAmountQuota(LotteryBetOrderListVo listVo) {
//        return this.mapper.sumBetAmountQuota(listVo.getSearch());
//    }
//
//    @Override
//    public List<LotteryBetOrder> getBetOrdersByBillNo(LotteryBetOrderListVo listVo) {
//        return this.mapper.search(Criteria.add(LotteryBetOrder.PROP_BILL_NO,
//                Operator.EQ, listVo.getSearch().getBillNo()));
//    }
//
//    private Map<String, Object> setReportQuery(LotteryBetOrderListVo listVo) {
//        listVo.getQuery().addOrder("code", Direction.ASC);
//        LotteryBetOrderSo so = listVo.getSearch();
//        listVo.getQuery().setCriterions(new Criterion[]{
//                new Criterion(LotteryBetOrder.PROP_CODE, Operator.IN, so.getCodes()),
//                new Criterion(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.GE, so.getQueryStartDate()),
//                new Criterion(LotteryBetOrder.PROP_PAYOUT_TIME, Operator.LT, so.getQueryEndDate()),
//                new Criterion(LotteryBetOrder.PROP_STATUS, Operator.IN, so.getStatuss()),
//                new Criterion("extract(year from payout_time)", Operator.EQ, so.getPayout_year()),
//                new Criterion("extract(month from payout_time)", Operator.EQ, so.getPayout_month())
//        });
//        Map<String, Object> map = listVo.getQueryParams();
//        map.put("searchcode", so.getSearchCode());
//        return map;
//    }
//
//    @Override
//    public List<Map> lotteryBetOrderReportPaging(LotteryBetOrderListVo listVo) {
//        return mapper.lotteryBetOrderReportPaging(setReportQuery(listVo));
//    }
//
//    @Override
//    public long lotteryBetOrderReportCount(LotteryBetOrderListVo listVo) {
//        return mapper.lotteryBetOrderReportCount(setReportQuery(listVo));
//    }
//
//    @Override
//    public Map getReportTotal(LotteryBetOrderListVo listVo) {
//        return mapper.getReportTotal(setReportQuery(listVo));
//    }
//
//    private LotteryBetOrderListVo setLotteryBetOrderListVo(LotteryBetOrderListVo lotteryBetOrderListVo) {
//        List<LotteryBetOrder> list = lotteryBetOrderListVo.getResult();
//        if (list != null && list.size() > 0) {
//            for (LotteryBetOrder lotteryBetOrder : list) {
//                String codeName = LocaleTool.tranDict(DictEnum.LOTTERY_BETTING, lotteryBetOrder.getBetCode()) + "-" + LocaleTool.tranDict(DictEnum.LOTTERY_PLAY, lotteryBetOrder.getPlayCode());
//                lotteryBetOrder.setBetCode(codeName);
//
//                String odd = lotteryBetOrder.getOdd().toString();
//                if (lotteryBetOrder.getPlayCode().equals(LotteryPlayEnum.KENO_SELECTION_FIVE.getCode())) {
//                    odd = "中5@" + lotteryBetOrder.getOdd() + "中4@" + lotteryBetOrder.getOdd2() + "中3@" + lotteryBetOrder.getOdd3();
//                } else if (lotteryBetOrder.getPlayCode().equals(LotteryPlayEnum.KENO_SELECTION_FOUR.getCode())) {
//                    odd = "中4@" + lotteryBetOrder.getOdd() + "中3@" + lotteryBetOrder.getOdd2() + "中2@" + lotteryBetOrder.getOdd3();
//                } else if (lotteryBetOrder.getPlayCode().equals(LotteryPlayEnum.KENO_SELECTION_THREE.getCode())) {
//                    odd = "中3@" + lotteryBetOrder.getOdd() + "中2@" + lotteryBetOrder.getOdd2();
//                } else if (lotteryBetOrder.getPlayCode().equals(LotteryPlayEnum.LHC_THREE_IN_TWO.getCode())) {
//                    odd = "中二@" + lotteryBetOrder.getOdd() + "中三@" + lotteryBetOrder.getOdd2();
//                } else if (lotteryBetOrder.getPlayCode().equals(LotteryPlayEnum.LHC_TWO_IN_SPECIAL.getCode())) {
//                    odd = "中特@" + lotteryBetOrder.getOdd() + "中二@" + lotteryBetOrder.getOdd2();
//                } else if (lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_QSZXZH.getCode()) || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_HSZXZH.getCode())) {
//                    odd = "三星@" + lotteryBetOrder.getOdd() + "二星@" + lotteryBetOrder.getOdd2() + "一星@" + lotteryBetOrder.getOdd3();
//                } else if (lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_QSHHZX.getCode()) || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_HSHHZX.getCode())
//                        || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_QSZUXHZ.getCode()) || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_HSZUXHZ.getCode())
//                        || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_QSZXBD.getCode()) || lotteryBetOrder.getBetCode().equals(LotteryBettingEnum.SSC_SANXING_HSZXBD.getCode())
//                        ) {
//                    odd = "组三@" + lotteryBetOrder.getOdd() + "组六@" + lotteryBetOrder.getOdd2();
//                } else if (LotteryOrderStatusEnum.PENDING.getCode().equals(lotteryBetOrder.getStatus()) && LotteryPlayEnum.NN_MULTIPLE.getCode().equals(lotteryBetOrder.getPlayCode())) {
//                    odd = lotteryBetOrder.getOdd() + "-" + lotteryBetOrder.getOdd2();
//                }
//                if (lotteryBetOrder.getCode().equals(LotteryEnum.PK10BJL.getCode()) || lotteryBetOrder.getCode().equals(LotteryEnum.PK10NN.getCode())) {
//                    lotteryBetOrder.setBetNum(LocaleTool.tranDict(DictEnum.LOTTERY_BET_NUM, lotteryBetOrder.getBetNum().trim()));
//                }
//                lotteryBetOrder.setMemo(odd);
//                String status = LocaleTool.tranDict(DictEnum.ORDER_STATUS, lotteryBetOrder.getStatus());
//                lotteryBetOrder.setStatus(status);
//
//                //彩种名称
//                Lottery lottery = CacheBase.getLottery(lotteryBetOrder.getCode());
//                if (lottery != null) {
//                    lotteryBetOrder.setCode(lottery.getName());
//                }
//            }
//        }
//        lotteryBetOrderListVo.setResult(list);
//        return lotteryBetOrderListVo;
//    }
//
//    @Override
//    public LotteryBetOrderListVo queryLotteryBetOrderByIds(LotteryBetOrderListVo listVo) {
//        Paging paging = listVo.getPaging();
//        List result;
//        if (paging != null) {
//            long count = mapper.count(Criteria.add(LotteryBetOrder.PROP_ID, Operator.IN, listVo.getIds()));
//            paging.setTotalCount(count);
//            paging.cal();
//            int pageNo = paging.getPageNumber();
//            int pageSize = paging.getPageSize();
//            result = mapper.pagingSearch(Criteria.add(LotteryBetOrder.PROP_ID, Operator.IN, listVo.getIds()), pageNo, pageSize, listVo.getQuery().getOrders());
//        } else {
//            result = mapper.search(Criteria.add(LotteryBetOrder.PROP_ID, Operator.IN, listVo.getIds()), listVo.getQuery().getOrders());
//        }
//        listVo.setResult(result);
//        listVo.setSuccess(true);
//        return listVo;
//    }
//
//    @Override
//    public WebJson fetchHistoryBetOrders(RecordParam recordParam) {
//        WebJson webJson = new WebJson();
//        if (StringTool.isBlank(recordParam.getUsername())) {
//            return new WebJson(ApiCodeEnum.INVALID_PARAM);
//        }
//        LotteryBetOrderListVo lotteryBetOrderListVo = new LotteryBetOrderListVo();
//        if (StringTool.isNotBlank(recordParam.getCode())) {
//            lotteryBetOrderListVo.getSearch().setCode(recordParam.getCode());
//        }
//        lotteryBetOrderListVo.getSearch().setUsername(recordParam.getUsername());
//
//        // int pa = recordParam.getPageNum();
//        // int ps = recordParam.getPageSize();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar now = Calendar.getInstance();
//        now.add(Calendar.DAY_OF_MONTH, -30);
//        String oneMonth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());//最近30天
//        Date thirtyTime = null;//最近30天
//        try {
//            thirtyTime = sdf.parse(oneMonth);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        setStartEndTime(recordParam, lotteryBetOrderListVo, sdf, thirtyTime);
//        lotteryBetOrderListVo.setPaging(null);
//        LOG.info("API历史注单查询:开始时间{0}，结束时间{1}", lotteryBetOrderListVo.getSearch().getQueryStartDate(), lotteryBetOrderListVo.getSearch().getQueryEndDate());
////        List<LotteryBetOrder> list = ServiceTool.lotteryBetOrderService().queryBetOrderByApi(lotteryBetOrderListVo);
//        webJson.setMessage("成功");
////        webJson.setData(list);
//        return webJson;
//    }
//
//    private void setStartEndTime(RecordParam recordParam, LotteryBetOrderListVo lotteryBetOrderListVo, SimpleDateFormat sdf, Date thirtyTime) {
//        if (StringTool.isBlank(recordParam.getStartDate()) && StringTool.isBlank(recordParam.getEndDate())) {
//            Date startDate = null;
//            Date endDate = null;
//            try {
//                startDate = sdf.parse(recordParam.getStartDate());
//                endDate = sdf.parse(recordParam.getEndDate());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            if (endDate.getTime() < thirtyTime.getTime() || startDate.getTime() < thirtyTime.getTime()) {
//                lotteryBetOrderListVo.getSearch().setQueryStartDate(startDate);
//                lotteryBetOrderListVo.getSearch().setQueryEndDate(endDate);
//            }
//        } else {
//            lotteryBetOrderListVo.getSearch().setQueryStartDate(thirtyTime);
//            lotteryBetOrderListVo.getSearch().setQueryEndDate(new Date());
//        }
//    }
//
//
//    @Override
//    public WebJson fetchBetOrders(RecordParam recordParam) {
//        WebJson webJson = new WebJson();
//        if (StringTool.isBlank(recordParam.getUsername())) {
//            return new WebJson(ApiCodeEnum.INVALID_PARAM);
//        }
//        LotteryBetOrderListVo lotteryBetOrderListVo = new LotteryBetOrderListVo();
//        if (StringTool.isNotBlank(recordParam.getCode())) {
//            lotteryBetOrderListVo.getSearch().setCode(recordParam.getCode());
//        }
//        lotteryBetOrderListVo.getSearch().setUsername(recordParam.getUsername());
//        //int pa = recordParam.getPageNum();
//        //int ps = recordParam.getPageSize();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar nowAfter = Calendar.getInstance();
//        nowAfter.add(Calendar.MINUTE, -30);
//        Date thirtyTime = null;//最近半小时,获取最近30分钟，默认添加最近半小时时间最及时注单查询
//        try {
//            thirtyTime = sdf.parse(sdf.format(nowAfter.getTimeInMillis()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        setStartEndTime(recordParam, lotteryBetOrderListVo, sdf, thirtyTime);
//        lotteryBetOrderListVo.setPaging(null);
//        LOG.info("API即时注单查询:开始时间{0}，结束时间{1}", lotteryBetOrderListVo.getSearch().getQueryStartDate(), lotteryBetOrderListVo.getSearch().getQueryEndDate());
////        List<LotteryBetOrder> list = ServiceTool.lotteryBetOrderService().queryBetOrderByApi(lotteryBetOrderListVo);
//        webJson.setMessage("成功");
////        webJson.setData(list);
//        return webJson;
//    }
//
//    @Override
//    public List<String> getUserNameByExpect(LotteryBetOrderVo lotteryBetOrderVo) {
//        return mapper.getUserNameByExpect(lotteryBetOrderVo.getSearch());
//    }
//
//    @Override
//    public List<Map> getBetAmountByBetNum(LotteryBetOrderVo vo) {
//        List<Map> list = mapper.getBetAmountByBetNum(vo.getSearch());
//        return list;
//    }
//
//    @Override
//    public List<Map> getProfitByExpects(LotteryBetOrderVo vo) {
//        List<Map> list = mapper.getProfitByExpects(vo.getSearch());
//        return list;
//    }
//
//    @Override
//    public Double getProfitByExpectsAndUsername(LotteryBetOrderVo vo) {
//        Double profit = mapper.getProfitByExpectsAndUsername(vo.getSearch());
//        return profit;
//    }
//
//    @Override
//    public LotteryBetOrderListVo queryLotteryBetOrderForExport(LotteryBetOrderListVo lotteryBetOrderListVo) {
//        lotteryBetOrderListVo = this.search(lotteryBetOrderListVo);
//        return setLotteryBetOrderListVo(lotteryBetOrderListVo);
//    }
//
//    @Override
//    public List<BetOrderWin> getAvaliableWinOrder(LotteryBetOrderListVo listVo) {
//        return mapper.getAvaliableWinOrder(listVo.getSearch());
//    }
//
//    @Override
//    public List<LotteryBetOrder> queryBetOrderByApi(LotteryBetOrderListVo lotteryBetOrderListVo) {
//        return mapper.queryBetOrderByApi(lotteryBetOrderListVo.getSearch());
//    }
//
//    @Override
//    public List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTime(LotteryBetOrderListVo listVo) {
//        return mapper.findTeamMemberBetOrdersByPayoutTime(listVo.getSearch());
//    }
//
//    @Override
//    public List<Map<String, Object>> findTeamMemberBetOrdersTotalByPayoutTime(LotteryBetOrderListVo listVo) {
//        return mapper.findTeamMemberBetOrdersTotalByPayoutTime(listVo.getSearch());
//    }
//
//    @Override
//    public Map<String, Double> queryEffectiveAmount(LotteryBetOrderVo lotteryBetOrderVo) {
//        return mapper.queryEffectiveAmount(lotteryBetOrderVo.getSearch());
//    }
//
//    @Override
//    public List<Map<String, Object>> findTeamMemberBetOrdersByPayoutTimeTotalCount(LotteryBetOrderListVo listVo) {
//        return this.mapper.findTeamMemberBetOrdersByPayoutTimeTotalCount(listVo.getSearch());
//    }
//
//    @Override
//    public Map<String, Object> findTeamByPayoutTimeTotal(LotteryBetOrderListVo listVo) {
//        return mapper.findTeamByPayoutTimeTotal(listVo.getSearch());
//    }
//
//
//    @Override
//    public Map analysisList(LotteryBetOrderListVo listVo) {
//        Map<String, Object> resultMap = new HashMap<>();
//        if (StringTool.isBlank(listVo.getSearch().getPageType())) {
//            LOG.error("今日注单查询错误， pageType[{0}]：必须指定pageType参数", listVo.getSearch().getPageType());
//        } else {
//            listVo.getSearch().setPageSize(listVo.getPaging().getPageSize());
//            listVo.getSearch().setPageNo(listVo.getPaging().getPageNumber());
//            List<Map> mapList = this.mapper.analysisList(listVo.getSearch());
//            listVo.getPaging().setTotalCount(this.mapper.analysisListCount(listVo.getSearch()));
//            listVo.getPaging().cal();
//            if (CollectionTool.isNotEmpty(mapList)
//                    && StringTool.equals(LotteryOrderPageTypeEnum.ORDER.getCode(), listVo.getSearch().getPageType())) {
//                resultMap.put("subTotal", getSubTotal(mapList));
//            }
//            resultMap.put("result", mapList);
//            resultMap.put("paging", listVo.getPaging());
//        }
//        return resultMap;
//    }
//
//    private Map getSubTotal(List<Map> mapList) {
//        Map<String, Double> map = new HashMap<>();
//        try {
//            if (CollectionTool.isNotEmpty(mapList)) {
//                BigDecimal bet_amount_bd = BigDecimal.ZERO;
//                BigDecimal rebate_total_bd = BigDecimal.ZERO;
//                BigDecimal payout_total_bd = BigDecimal.ZERO;
//                BigDecimal profit_total_bd = BigDecimal.ZERO;
//                for (Map oneMap : mapList) {
//                    Object status = oneMap.get("status");
//                    Object bet_amount = oneMap.get("bet_amount");
//                    Object rebate = oneMap.get("rebate");
//                    Object payout = oneMap.get("payout");
//                    if (status != null &&
//                            (StringTool.equals(LotteryOrderStatusEnum.WINING.getCode(), status.toString())
//                                    || StringTool.equals(LotteryOrderStatusEnum.NOWIN.getCode(), status.toString()))){
//                        bet_amount_bd = bet_amount_bd.add(new BigDecimal(bet_amount.toString()));
//                        rebate_total_bd = rebate_total_bd.add(new BigDecimal(rebate.toString()).multiply(new BigDecimal(bet_amount.toString())));
//                        payout_total_bd = payout_total_bd.add(new BigDecimal(payout.toString()));
//                        profit_total_bd = profit_total_bd.add(
//                                new BigDecimal(payout.toString())
//                                        .subtract(new BigDecimal(bet_amount.toString()))
//                                        .add(new BigDecimal(rebate.toString()).multiply(new BigDecimal(bet_amount.toString()))));
//                    }
//                }
//                map.put("bet_amount_total", bet_amount_bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
//                map.put("rebate_total", rebate_total_bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
//                map.put("payout_total", payout_total_bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
//                map.put("profit_total", profit_total_bd.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
//            }
//        }catch (Exception e){
//            LOG.error("今日注单当前页小计计算错误：{0}", e);
//        }
//        return map;
//    }
//
//    @Override
//    public Map betOrderTodaySum(LotteryBetOrderListVo listVo) {
//        return this.mapper.betOrderTodaySum(listVo.getSearch());
//    }
//
//    @Override
//    public List<LotteryBetOrder> searchPayoutApiOrder(LotteryBetOrderListVo listVo) {
//        return this.mapper.searchPayoutApiOrder(listVo.getSearch());
//    }
//
//    @Override
//    public List<LotteryBetOrder> queryAllStatus(LotteryBetOrderListVo listVo) {
//        return this.mapper.queryAllStatus(listVo.getSearch());
//    }
//
//    @Override
//    public List<LotteryBetOrder> queryAllStatusCount(LotteryBetOrderListVo listVo) {
//        return this.mapper.queryAllStatusCount(listVo.getSearch());
//    }
//
//
//    @Override
//    public LotteryBetOrderListVo queryButorLotteryBetOrderListVo (LotteryBetOrderListVo listVo){
//        listVo.getPaging().setTotalCount(this.mapper.queryButorBetOrderCount(listVo.getSearch()));
//        listVo.getPaging().cal();
//        listVo.getSearch().setPageSize(listVo.getPaging().getPageSize());
//        listVo.getSearch().setPageNo(listVo.getPaging().getPageNumber());
//        listVo.setResult(this.mapper.queryButorBetOrder(listVo.getSearch()));
//        return listVo;
//    }
}