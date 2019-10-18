package so.wwb.lotterybox.schedule.service.manager.job;

import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.comet.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.common.IMessageService;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryErrorLogService;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.model.enums.lottery.*;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;
import so.wwb.lotterybox.model.manager.lottery.LotteryGatherParam;
import so.wwb.lotterybox.model.manager.lottery.po.*;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryErrorLogVo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.lotterybox.model.company.lottery.po.LotteryRule;
import so.wwb.lotterybox.model.company.lottery.po.LotteryResultNumber;
import so.wwb.lotterybox.model.company.lottery.so.LotteryResultNumberSo;
import so.wwb.lotterybox.model.company.lottery.vo.LotteryResultNumberVo;
import so.wwb.lotterybox.schedule.service.manager.task.LotteryResultOwnTask;
import so.wwb.lotterybox.schedule.service.utility.LotteryGatherParamUtility;
import so.wwb.lotterybox.utility.LotteryResultNumberUtility;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 自主彩开奖子任务
 * @author: marz
 * @time 2018-2-27 20:35:57
 * */
public class LotteryResultOwnSubJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultOwnSubJob.class);
    //东八区
    private static int GTM8 = 8;

    @Autowired
    private ExecutorService ownLotteryExecutor;
    @Autowired
    private ILotteryResultService lotteryResultService;
    @Autowired
    private ILotteryErrorLogService errLogService;
    @Autowired
    private IMessageService messageService;//消息推送

    public LotteryResultOwnSubJob() {
    }

    public void execute(String code,String expect) {
        LOG.info("自主彩采集派彩任务开始code:{0},期号:{1}", code, expect);
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setCode(code);
        lotteryResultVo.getSearch().setExpect(expect);
        lotteryResultVo = lotteryResultService.search(lotteryResultVo);
        LotteryResult result = lotteryResultVo.getResult();
//        LotteryResult result = CacheBase.getLotteryResult(code,expect);
        if(result == null){
            LOG.error("自主彩采集派彩前校验未通过,code:{0},expect:{1},原因{2}",code,expect,"缺少的开奖结果数据");
            return;
        }
        List<LotteryGatherConf> confs = CacheBase.getLotteryGatherConf(LotteryConfTypeEnum.GATHER.getCode(),code);
        if(CollectionTool.isEmpty(confs)){
            LOG.error("自主彩采集派彩前校验未通过,code:{0},expect:{1},原因{2}",code,expect,"缺少采集配置");
            return;
        }
        LotteryGatherConf conf = confs.get(0);
        List<Lottery> lotteryList = CacheBase.getMerchantLotteryList(code);
        if(CollectionTool.isEmpty(lotteryList)){
            LOG.error("自主彩采集派彩前校验未通过,code:{0},expect:{1},原因{2}",code,expect,"未存在需要采集派彩的商户");
            return;
        }
        List<LotteryResultNumberVo> resultList = new ArrayList<>();
        List<Future<LotteryResultNumberVo>> futures = new LinkedList<>();
        for(Lottery lottery : lotteryList){
            LotteryRule killRate = CacheBase.getLotteryRule(Integer.toString(lottery.getSiteId()),lottery.getCode());
            LotteryResultNumberVo numberVo = createNumberVo(result);
            numberVo._setSiteId(lottery.getSiteId());
            numberVo.setOperator(Const.SYSTEM_OPERATOR);
            numberVo = checkLottery(numberVo,killRate,lottery);
            if(numberVo.isSuccess()){
                futures.add(ownLotteryResult(killRate,conf,numberVo));
            }else{
                resultList.add(numberVo);
            }
        }
        Map<String,LotteryResultNumberVo> numberMap = new HashMap<>();
        for (Future<LotteryResultNumberVo> future : futures) {
            try {
                LotteryResultNumberVo numberVo = future.get();
                numberMap.put(Integer.toString(numberVo._getSiteId()),numberVo);
            } catch (Exception e) {
                LOG.error(e,"自主彩采集派彩失败,code:{0},expect:{1},原因:{2}",code,expect,"采集派彩任务获取future错误");
            }
        }
        Integer count = 0;
        List<Map<String, String>> opnList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> errList = new ArrayList<Map<String, String>>();
        Map<String, String> opnMap = new HashedMap();
        opnMap.put("code", code);
        opnMap.put("expect", expect);
        opnList.add(opnMap);

        for(Lottery lottery : lotteryList){
            LotteryResultNumberVo numberVo = numberMap.get(Integer.toString(lottery.getSiteId()));

            if(numberVo == null){
                LOG.error("自主彩采集派彩失败,siteId:{0},code:{1},expect:{2},原因:{3}",lottery.getSiteId(),code,expect,"当前商户的当前彩种未返回派彩结果");

                Map<String, String> errMap = new HashedMap();
                errMap.put("siteId", lottery.getSiteId().toString());
                errMap.put("errMsg", "当前商户的当前彩种未返回派彩结果");
                errList.add(errMap);
                continue;
            }
            if(!numberVo.isSuccess()){
                LOG.error("自主彩采集派彩失败,siteId:{0},code:{1},expect:{2},原因:{3}",lottery.getSiteId(),code,expect,numberVo.getErrMsg());

                Map<String, String> errMap = new HashedMap();
                errMap.put("siteId", lottery.getSiteId().toString());
                errMap.put("errMsg", numberVo.getErrMsg());
                errList.add(errMap);
                continue;
            }else{
                count++;
            }
        }
        if(count == 0 && lotteryList.size() > 0){
            result.setOpenCode("全站派彩失败");
            LOG.error("自主彩采集派彩失败,code:{0},expect:{1},原因:{2}",code,expect,"全站派彩失败");

            LotteryErrorLogVo errorLogVo = new LotteryErrorLogVo();
            errorLogVo.setResult(new LotteryErrorLog());
            errorLogVo.getResult().setOperationMsgJson(new Gson().toJson(opnList));
            errorLogVo.getResult().setErrMsgJson(new Gson().toJson(errList));
            errorLogVo.getResult().setOperationType(LotteryOperationEnum.PAYOUT.getCode());
            errorLogVo.getResult().setCreateTime(new Date());
            errLogService.insert(errorLogVo);
            LotteryErrorLog errorLog =  errorLogVo.getResult();
            sendBossMessage(getLotteryErrorMsgBody(code, expect, errorLog.getErrMsgJson()));

        }else if(count < lotteryList.size()){
            result.setOpenCode("部分站点派彩成功");
            LOG.warn("自主彩采集派彩部分成功,code:{0},expect:{1},原因:{2}",code,expect,"部分站点派彩成功");

            LotteryErrorLogVo errorLogVo = new LotteryErrorLogVo();
            errorLogVo.setResult(new LotteryErrorLog());
            errorLogVo.getResult().setOperationMsgJson(new Gson().toJson(opnList));
            errorLogVo.getResult().setErrMsgJson(new Gson().toJson(errList));
            errorLogVo.getResult().setOperationType(LotteryOperationEnum.PAYOUT.getCode());
            errorLogVo.getResult().setCreateTime(new Date());
            errLogService.insert(errorLogVo);
            LotteryErrorLog errorLog =  errorLogVo.getResult();
            sendBossMessage(getLotteryErrorMsgBody(code, expect, errorLog.getErrMsgJson()));

        }else if(count == lotteryList.size()){
            result.setOpenCode("全站派彩成功");
            LOG.info("自主彩采集派彩成功,code:{0},expect:{1}",code,expect);
        }
        LotteryResultVo resultVo = updateLotteryResult(result);
        if(!resultVo.isSuccess()){
            CacheBase.refreshLotteryResult(code);
            LOG.error("自主彩保存开奖结果出错,code:{0},expect:{1},原因:{2}",code,expect,resultVo.getErrMsg());
            return;
        }
    }

    /**
     * 根据lotteryResult获取LotteryResultNumberVo
     * @param result
     * @return
     */
    private LotteryResultNumberVo createNumberVo(LotteryResult result){
        LotteryResultNumberVo numberVo = new LotteryResultNumberVo();
        LotteryResultNumber number = LotteryResultNumberUtility.createByLotteryResult(result);
        numberVo.setResult(number);
        numberVo.setSearch(new LotteryResultNumberSo());
        numberVo.getSearch().setCode(number.getCode());
        numberVo.getSearch().setExpect(number.getExpect());
        return numberVo;
    }

    /**
     * 保存开奖结果
     * @param result
     * @return
     */
    private LotteryResultVo updateLotteryResult(LotteryResult result){
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        Date curDate = new Date();
        result.setGather(Const.SYSTEM_OPERATOR);
        result.setGatherTime(curDate);
        result.setGatherOpenTime(curDate);
        result.setGatherOrigin(LotteryGatherOriginEnum.AUTO.getCode());
        LOG.info("自主彩保存开奖结果,code:{0},expect:{1},结果:{2}",result.getCode(), result.getExpect(), JsonTool.toJson(result));
        lotteryResultVo.setResult(result);
        lotteryResultVo.setProperties(LotteryResult.PROP_GATHER,LotteryResult.PROP_GATHER_TIME,LotteryResult.PROP_GATHER_OPEN_TIME,LotteryResult.PROP_GATHER_ORIGIN,LotteryResult.PROP_OPEN_CODE);
        return lotteryResultService.updateOnly(lotteryResultVo);
    }

    /**
     * 自主彩采集-派彩
     * @param killRate
     * @param conf
     * @param numberVo
     * @return
     */
    private Future<LotteryResultNumberVo> ownLotteryResult(LotteryRule killRate, LotteryGatherConf conf, LotteryResultNumberVo numberVo){
        LotteryResultOwnTask task = SpringTool.getBean(LotteryResultOwnTask.class);
        LotteryGatherParam gatherParam = LotteryGatherParamUtility.initGatherParam(numberVo.getResult(), conf, killRate);
        task.setGatherParam(gatherParam);
        task.setNumberVo(numberVo);
        return ownLotteryExecutor.submit(task);
    }

    /**
     * 检查商户彩种
     * @param lottery
     * @param killRate
     * @return
     */
    private LotteryResultNumberVo checkLottery(LotteryResultNumberVo numberVo, LotteryRule killRate, Lottery lottery){
        if(killRate == null){
            LOG.warn("LotteryResultOwnSubJob:自主彩采集前判断警告,原因:站点siteId:{0},自主彩code:{0}杀率配置为空",lottery.getSiteId(),lottery.getCode());
        }
        if(lottery == null){
            numberVo.setSuccess(false);
            numberVo.setErrMsg("未存在自主彩数据");
            LOG.error("LotteryResultOwnSubJob:自主彩采集前判断未通过,原因:未存在自主彩数据");
            return numberVo;
        }if(LotteryStatusEnum.CLOSE.getCode().equals(lottery.getStatus())){
            numberVo.setSuccess(false);
            numberVo.setErrMsg("自主彩code:"+lottery.getCode()+"处于停市状态,不采集");
            LOG.error("LotteryResultOwnSubJob:自主彩采集前判断未通过,原因:站点siteId:{0},自主彩code:{1}处于停市状态,不采集",lottery.getSiteId(),lottery.getCode());
            return numberVo;
        }
        return numberVo;
    }


    /**
     * 消息发送
     * @param mesBody
     */
    public void sendBossMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.BOSS_LOTTERY_ERROR.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToBossMsg(message);
    }
    /**
     * 设置失败消息主体内容
     */
    private static String getLotteryErrorMsgBody(String code, String expect, String errMsgJson) {
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("title", "派彩失败");
        map.put("code", code);
        map.put("expect", expect);
        map.put("errMsgJson", errMsgJson);
        map.put("message", "派彩失败,请及时处理!");
        return JsonTool.toJson(map);
    }

}
