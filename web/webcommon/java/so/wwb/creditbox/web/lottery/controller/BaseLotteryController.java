package so.wwb.creditbox.web.lottery.controller;

import org.apache.shiro.session.mgt.SessionManager;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.web.session.SessionManagerBase;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.bean.HttpCodeEnum;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.enums.base.StatusEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryOrderStatusEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryPlayEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.hall.HandlerForm;
import so.wwb.creditbox.model.hall.LotteryErrorCode;
import so.wwb.creditbox.model.manager.lottery.bean.ErrorCode;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.HidTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by block on 2019/11/28.
 */
public class BaseLotteryController {
    Log LOG = LogFactory.getLog(this.getClass());

    //官方玩法金额保留3位小数
    public static DecimalFormat BONUS = new DecimalFormat("#0.000");

    /**
     * 保存订单
     *
     * @param request
     * @param code
     * @param form
     * @return
     */
    protected WebJson saveBetOrder(HttpServletRequest request, String code, HandlerForm form) {
        ErrorCode errorCode = new ErrorCode();
        List<ErrorCode.Error> errors = new ArrayList<>();
        WebJson webJson = new WebJson();
        webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());


        try {
            //当前开奖结果
            LotteryResult handicap = getHandicap(code);
            //是否封盘
            if(handicap.getLeftTime()<0){
                webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
                webJson.setTipinfo("该期已封盘！");
                return webJson;
            }



            LOG.info("下注表单:site:{0},username:{1},code:{2},handlerForm:{3}", SessionManagerCommon.getSiteId(), SessionManagerCommon.getUser().getUsername(), code, JsonTool.toJson(form));
            Lottery lottery = Cache.getLottery(code);
            if (lottery == null || !StringTool.equals(LotteryStatusEnum.NORMAL.getCode(), lottery.getStatus())) {
                errors.add(errorCode.new Error(errorCode.CODE_111, errorCode.MSG_DISABLE, errorCode.ICON_5));
                webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
                webJson.setTipinfo(errorCode.MSG_DISABLE);
                return webJson;
            }
            Map<String, SiteLottery> siteLotteryMap = Cache.getSiteLottery(SessionManagerCommon.getSiteId());
            SiteLottery siteLottery = siteLotteryMap.get(code);

            if (siteLottery == null || !StringTool.equals(LotteryStatusEnum.NORMAL.getCode(), siteLottery.getStatus())) {
                errors.add(errorCode.new Error(errorCode.CODE_111, errorCode.MSG_DISABLE, errorCode.ICON_5));
                webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
                webJson.setTipinfo(errorCode.MSG_DISABLE);
                return webJson;
            }

            if (StringTool.isNotBlank(form.getOddsid())) {
                SysUserExtend sessionUser = SessionManagerCommon.getSysUserExtend();
                //反水和限额
                Map<String, SiteLotteryRebates> siteLotteryRebatesMap = Cache.getSiteLotteryRebates(HidTool.getBranchHid(sessionUser.getHid()), code);
                //赔率缓存
                Map<String, SiteLotteryOdds> siteLotteryOdds = Cache.getBranchSiteLotteryOdds(sessionUser.getHid(), code);


                List<Integer> indexList = new ArrayList<>();
                List<Double> newPlList = new ArrayList<>();



                //验证赔率是否变动 start
                boolean oddChange=false;
                for (int i=0;i<form.getBetSortArray().length;i++) {
                    //下注项
                    String betSort = form.getBetSortArray()[i];
                    //赔率
                    Double odd = Double.valueOf(form.getOddArray()[i]);
                    SiteLotteryOdds lotteryOdd = siteLotteryOdds.get(betSort);
                    //验证赔率是否变动
                    if(odd.compareTo(lotteryOdd.getBOdd(sessionUser)) != 0){
                        oddChange = true;
                        indexList.add(i);
                        newPlList.add(lotteryOdd.getBOdd(sessionUser));
                    }
                }
                if(oddChange){
                    webJson.setSuccess(HttpCodeEnum.ODD_CHENGE.getCode());
                    webJson.setTipinfo("赔率变动！");
                    HashMap<String, Object> phaseinfoMap = new HashMap<>();
                    phaseinfoMap.put("index",indexList);
                    phaseinfoMap.put("newpl",newPlList);
                    webJson.setData(phaseinfoMap);
                    return webJson;
                }
                //验证赔率是否变动 end


                //限额校验 start
                List<LotteryBetOrder> orders = new ArrayList<>();
                for (int i=0;i<form.getBetSortArray().length;i++) {
                    //下注项
                    String betSort = form.getBetSortArray()[i];
                    //赔率
                    Double odd = Double.valueOf(form.getOddArray()[i]);
                    //下注接
                    Double money = Double.valueOf(form.getMoneyArray()[i]);


                    SiteLotteryRebates rebates = siteLotteryRebatesMap.get(betSort);
                    SiteLotteryOdds lotteryOdd = siteLotteryOdds.get(betSort);

                    if(money < rebates.getMinBet() || money > rebates.getMaxBet()){
                        webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
                        webJson.setTipinfo(errorCode.MSG_113);
                        return webJson;
                    }
                    //todo  单期校验未处理


                    //初始化赔率，返水，限额
                    SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
                    sysUserExtendVo.getSearch().setId(sessionUser.getId());
                    sysUserExtendVo.setDataSourceId(sessionUser.getSiteId());
                    List<SysUserExtend> users = ServiceTool.sysUserExtendService().findOwner(sysUserExtendVo);





                    LotteryBetOrder lotteryBetOrder = new LotteryBetOrder();
                    lotteryBetOrder.setHid(sessionUser.getHid());
                    lotteryBetOrder.setUserId(sessionUser.getId());
                    lotteryBetOrder.setUsername(sessionUser.getUsername());
                    lotteryBetOrder.setStatus(LotteryOrderStatusEnum.PENDING.getCode());
                    lotteryBetOrder.setHandicap(sessionUser.getHandicap());
                    lotteryBetOrder.setExpect(handicap.getExpect());
                    lotteryBetOrder.setCode(code);
                    lotteryBetOrder.setCodd1(lotteryOdd.getCOdd(sessionUser));
                    lotteryBetOrder.setBodd1(lotteryOdd.getBOdd(sessionUser));
                    lotteryBetOrder.setPlayCode(lotteryOdd.getPlayCode());
                    lotteryBetOrder.setBetName(lotteryOdd.getBetName());
                    lotteryBetOrder.setBetNum(lotteryOdd.getBetNum());
                    lotteryBetOrder.setBetAmount(money);
                    lotteryBetOrder.setBodd1(odd);
                    lotteryBetOrder.setBetTime(new Date());
                    lotteryBetOrder.setBetSort(betSort);
                    lotteryBetOrder.setOwnerUserType(sessionUser.getOwnerUserType());

                    for (SysUserExtend user : users) {
                        UserTypeEnum anEnum = EnumTool.enumOf(UserTypeEnum.class, user.getUserType());
                        rebates = siteLotteryRebatesMap.get(betSort);

                        switch (anEnum){
                            case PLAYER:
                                lotteryBetOrder.setRebate8((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy7(user.getSuperiorOccupy()/100.0);
                                break;
                            case AGENT:
                                lotteryBetOrder.setRebate7((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy6(user.getSuperiorOccupy()/100.0);
                                lotteryBetOrder.setAgentId(user.getId());
                                break;
                            case DISTRIBUTOR:
                                lotteryBetOrder.setRebate6((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy5(user.getSuperiorOccupy()/100.0);
                                lotteryBetOrder.setDistributorId(user.getId());
                                break;
                            case SHAREHOLDER:
                                lotteryBetOrder.setRebate5((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy4(user.getSuperiorOccupy()/100.0);
                                lotteryBetOrder.setShareholderId(user.getId());
                                break;
                            case BRANCH:
                                lotteryBetOrder.setRebate4((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy3(user.getSuperiorOccupy()/100.0);
                                lotteryBetOrder.setBranchId(user.getId());
                                break;
                            case COMPANY:
                                lotteryBetOrder.setRebate3((rebates.getRebateA()/100)* money);
                                lotteryBetOrder.setOccupy2(lotteryBetOrder.getOccupy7());
                                lotteryBetOrder.setCompanyId(LotteryCommonContext.get().getDomainUserId());
                                break;
                        }
                    }
                    orders.add(lotteryBetOrder);

                }
                //限额校验 end
                form.setBetOrderList(orders);

                


//                //校验参数（例如期数、赔率）
                if (checkParam(code,   errorCode, form)) {
                    webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
                    webJson.setTipinfo(HttpCodeEnum.ERROR.getTrans());
                    return webJson;
                }
                // 校验余额
                if (checkOrder(errors, errorCode, form, request)) {
                    webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
                    webJson.setTipinfo(HttpCodeEnum.ERROR.getTrans());
                    return webJson;
                }

                LotteryBetOrderVo vo = new LotteryBetOrderVo();
//                initBetVo(request, bean, user, vo);

                vo.setEntities(form.getBetOrderList());
                vo = ServiceTool.lotteryBetOrderService().saveBetOrder(vo);
                webJson.setTipinfo("下单成功！");

            }else {
                LOG.error("注单接口出错:bean:{0}", JsonTool.toJson(form));
                webJson.setTipinfo("非法下注！");
            }


        } catch (Exception e) {
            LOG.error(e, "保存注单异常！");
            webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
            webJson.setTipinfo("保存注单异常");
            return webJson;
        }






        return webJson;

    }

//    /**
//     * 初始化注单数据
//     */
//    private void initBetVo(HttpServletRequest request, HandlerForm form, SysUser user, LotteryBetOrderVo vo) {
//        vo.setEntities(form.getBetOrderList());
//        vo.setTotalAmount(form.getTotalMoney());
//        vo.setUser(user);
//        vo.setBetTime(SessionManagerCommon.getDate().getNow());
//        vo.setTerminal(SessionManagerCommon.fetchTerminalType(request));
//        vo.setGameId(getGameId(bean.getCode(), vo.getTerminal()));
//        vo.setIp(SessionManagerBase.getIpDb().getIp());
//        vo.setIpDictCode(SessionManagerBase.getIpDictCode());
//    }
    /**
     * 校验API余额
     */
    private boolean checkOrder(List<ErrorCode.Error> errors, ErrorCode errorCode, HandlerForm form, HttpServletRequest request) {
        SysUserExtend sessionUser = SessionManagerCommon.getSysUserExtend();
        Double credits = sessionUser.getCredits();
        SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
        //已使用的额度（盈利为负数）
        sysUserExtendVo.setDataSourceId(SessionManagerCommon.getSiteId());
        sysUserExtendVo.getSearch().setId(sessionUser.getId());
        Double usedCredit = ServiceTool.sysUserExtendService().getUsedCredit(sysUserExtendVo);
        double balance = credits - usedCredit - form.getTotalMoney();
        if (balance < 0) {
            errors.add(errorCode.new Error(errorCode.CODE_101, errorCode.MSG_101, errorCode.ICON_5));
            return true;
        }
        return false;
    }
    /**
     * 处理注单赔率，水位，所有的上级ID
     * @param code 彩种CODE
     * @param form 请求对象
     */
//    private void initOddRebate(String code, HandlerForm form) {
//        SysUserExtend sessionUser = SessionManagerCommon.getSysUserExtend();
//        SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
//        sysUserExtendVo.getSearch().setId(sessionUser.getId());
//        sysUserExtendVo.setDataSourceId(sessionUser.getSiteId());
//        List<SysUserExtend> users = ServiceTool.sysUserExtendService().findOwner(sysUserExtendVo);
//
//        List<LotteryBetOrder> orders = new ArrayList<>();
//        Map<String, SiteLotteryOdds> siteLotteryOdds = Cache.getBranchSiteLotteryOdds(sessionUser.getHid(), code);
//
//        String expect = expect(code);
//
//        String[] betSorts = form.getOddsid().split(",");
//        for (String betSort : betSorts) {
//            LotteryBetOrder lotteryBetOrder = new LotteryBetOrder();
//            SiteLotteryOdds lotteryOdd = siteLotteryOdds.get(betSort);
////            lotteryBetOrder.setExpect(form.getPhaseid());
//            lotteryBetOrder.setHid(sessionUser.getHid());
//            lotteryBetOrder.setUserId(sessionUser.getId());
//            lotteryBetOrder.setUsername(sessionUser.getUsername());
//            lotteryBetOrder.setStatus(LotteryOrderStatusEnum.PENDING.getCode());
//            lotteryBetOrder.setHandicap(sessionUser.getHandicap());
//            lotteryBetOrder.setExpect(expect);
//            lotteryBetOrder.setCode(code);
//            lotteryBetOrder.setCodd1(lotteryOdd.getCOdd(sessionUser));
//            lotteryBetOrder.setBodd1(lotteryOdd.getBOdd(sessionUser));
//            lotteryBetOrder.setPlayCode(lotteryOdd.getPlayCode());
//            lotteryBetOrder.setBetName(lotteryOdd.getBetName());
//            lotteryBetOrder.setBetNum(lotteryOdd.getBetNum());
//            lotteryBetOrder.setBetAmount(money);
//            lotteryBetOrder.setBodd1(form.getuPI_P());
//            lotteryBetOrder.setBetTime(new Date());
//            lotteryBetOrder.setBetSort(betSort);
//            lotteryBetOrder.setOwnerUserType(sessionUser.getOwnerUserType());
//
//
//            for (SysUserExtend user : users) {
//                UserTypeEnum anEnum = EnumTool.enumOf(UserTypeEnum.class, user.getUserType());
//                Map<String, SiteLotteryRebates> siteLotteryRebatesMap = Cache.getSiteLotteryRebates(HidTool.getBranchHid(user.getHid()), code);
//                SiteLotteryRebates rebates = siteLotteryRebatesMap.get(betSort);
//
//                switch (anEnum){
//                    case PLAYER:
//                        lotteryBetOrder.setRebate8((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy7(user.getSuperiorOccupy()/100.0);
//                        break;
//                    case AGENT:
//                        lotteryBetOrder.setRebate7((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy6(user.getSuperiorOccupy()/100.0);
//                        lotteryBetOrder.setAgentId(user.getId());
//                        break;
//                    case DISTRIBUTOR:
//                        lotteryBetOrder.setRebate6((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy5(user.getSuperiorOccupy()/100.0);
//                        lotteryBetOrder.setDistributorId(user.getId());
//                        break;
//                    case SHAREHOLDER:
//                        lotteryBetOrder.setRebate5((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy4(user.getSuperiorOccupy()/100.0);
//                        lotteryBetOrder.setShareholderId(user.getId());
//                        break;
//                    case BRANCH:
//                        lotteryBetOrder.setRebate4((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy3(user.getSuperiorOccupy()/100.0);
//                        lotteryBetOrder.setBranchId(user.getId());
//                        break;
//                    case COMPANY:
//                        lotteryBetOrder.setRebate3((rebates.getRebateA()/100)* money);
//                        lotteryBetOrder.setOccupy2(lotteryBetOrder.getOccupy7());
//                        lotteryBetOrder.setCompanyId(LotteryCommonContext.get().getDomainUserId());
//                        break;
//                }
//            }
//            orders.add(lotteryBetOrder);
//        }
//        form.setBetOrderList(orders);
//    }
    /**
     * 检验参数（期数、彩种、玩法、赔率、金额）
     *
     * @param code
     * @param errorCode
     * @param bean
     * @return
     */
    private boolean checkParam(String code ,  ErrorCode errorCode, HandlerForm bean) {
        List<LotteryBetOrder> betOrders = bean.getBetOrderList();
        boolean hasErrors = false;
        if (CollectionTool.isEmpty(betOrders)) {
            return true;
        }
        Map<String, SiteLotteryOdds> oddMap = Cache.getBranchSiteLotteryOdds(SessionManagerCommon.getSysUserExtend().getHid(), code);
        double totalMoney = 0d;
        for (LotteryBetOrder betOrder : betOrders) {
            //检验彩种
            if (!code.equals(betOrder.getCode())) {
                LOG.info("彩票投注检验参数：彩种不对值");
                hasErrors = true;
                break;
            }

            //检验期数
            if (StringTool.isBlank(betOrder.getExpect())) {
                LOG.info("彩票投注检验参数：期数为空");
                hasErrors = true;
                break;
            }

            totalMoney = totalMoney + betOrder.getBetAmount();
            betOrder.setMemo(null);
        }
        bean.setTotalMoney(totalMoney);
        return hasErrors;
    }


    /**
     * 获取期数
     *
     * @param code
     * @return
     */
    public String expect(String code) {
        LotteryResult lotteryResult = getHandicap(code);
        if (lotteryResult != null) {
            return lotteryResult.getExpect();
        }
        return "";
    }

    /**
     * 获取彩票当前盘口信息(封盘)
     */
    public LotteryResult getHandicap(String code) {
        List<LotteryResult> lotteryResultList = CacheBase.getLotteryResult(code);
        Date curDate = new Date();
        for (LotteryResult lotteryResult : lotteryResultList) {
            if (curDate.getTime() <= lotteryResult.getOpenTime().getTime()) {
                Long leftTime = DateTool.secondsBetween(lotteryResult.getCloseTime(), curDate);
                lotteryResult.setLeftTime(leftTime);
                lotteryResult.setLeftOpenTime(DateTool.secondsBetween(lotteryResult.getOpeningTime(), curDate));
                return lotteryResult;
            }
        }
        return null;
    }

}
