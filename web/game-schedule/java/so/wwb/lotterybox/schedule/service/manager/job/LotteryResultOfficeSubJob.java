package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.bean.BeanTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.comet.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import so.wwb.lotterybox.iservice.common.IMessageService;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.lottery.LotteryConfTypeEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryGatherOriginEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;
import so.wwb.lotterybox.model.manager.lottery.LotteryGatherParam;
import so.wwb.lotterybox.model.manager.lottery.po.*;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.lotterybox.schedule.service.manager.task.LotteryResultOfficeTask;
import so.wwb.lotterybox.schedule.service.utility.LotteryGatherParamUtility;
import so.wwb.lotterybox.utility.BjlResultFormatTool;
import so.wwb.lotterybox.utility.NnResultFormatTool;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 官方彩开奖子任务
 * @author: marz
 * @time 2018-2-27 20:35:57
 */
public class LotteryResultOfficeSubJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultOfficeSubJob.class);

    @Autowired
    private ExecutorService unifyGatherExecutor;

    @Autowired
    private ILotteryResultService lotteryResultService;

    @Autowired
    private IMessageService messageService;

    private final static int GTM8 = 8 ;

    public LotteryResultOfficeSubJob() {
    }

    public void execute(String code,String expect) {
        LOG.info("官方彩采集派彩任务开始code:{0},期号:{1}", code, expect);
        LotteryResult originResult = checkGather(code,expect);
        if (originResult==null) {
            return;
        }
        List<Future<LotteryResult>> futures = gather(originResult);
        LotteryResult result = getOpenCode(code,expect,futures);
        if (result != null) {
            saveAndPayoutResult(result);
        }
    }

    protected void saveAndPayoutResult(LotteryResult gatherResult) {
        LotteryResultVo resultVo = updateLotteryResult(gatherResult);
        if(resultVo.isSuccess()){
            CacheBase.refreshLotteryResult(gatherResult.getCode());
            payoutLotteryResult(resultVo);
        }
        //幸运２８是根据北京快乐８的数据生成
        if (LotteryEnum.BJKL8.getCode().equals(gatherResult.getCode())) {
            LotteryResult destResult = BeanTool.copyProperties(gatherResult, new LotteryResult());
            destResult.setType(LotteryEnum.XY28.getParent().getCode());
            destResult.setCode(LotteryEnum.XY28.getCode());
            String xy28OpenCode = getXy28OpenCode(destResult.getOpenCode());
            if (StringTool.isBlank(xy28OpenCode)) {
                LOG.error("保存开奖结果失败,code:{0},期号:{1},原因:{2}", destResult.getCode(), destResult.getExpect(), "xy28开奖号码为空");
                sendBossMessage(getErrorOpenCodeMsgBody(destResult.getCode(), destResult.getExpect()));
                return;
            }
            destResult.setOpenCode(xy28OpenCode);
            resultVo = updateLotteryResult(destResult);
            if (resultVo.isSuccess()) {
                CacheBase.refreshLotteryResult(gatherResult.getCode());
                payoutLotteryResult(resultVo);
            }
        }
        //pk10nn是根据BJPK10的数据生成
        if (LotteryEnum.BJPK10.getCode().equals(gatherResult.getCode())) {
            LotteryResult destResult = BeanTool.copyProperties(gatherResult, new LotteryResult());
            destResult.setType(LotteryEnum.PK10NN.getParent().getCode());
            destResult.setCode(LotteryEnum.PK10NN.getCode());
            String pk10nnOpenCode = destResult.getOpenCode();
            if (StringTool.isBlank(pk10nnOpenCode)) {
                LOG.error("保存开奖结果失败,code:{0},期号:{1},原因:{2}", destResult.getCode(), destResult.getExpect(), "pk10牛牛开奖号码为空");
                sendBossMessage(getErrorOpenCodeMsgBody(destResult.getCode(), destResult.getExpect()));
                return;
            }
            destResult.setOpenCode(pk10nnOpenCode);
            List<NnResult> nnResults = NnResultFormatTool.formatOpenCode(pk10nnOpenCode);
            destResult.setOpenCodeMemo(JsonTool.toJson(nnResults));
            resultVo = updateLotteryResult(destResult);
            if (resultVo.isSuccess()) {
                CacheBase.refreshLotteryResult(gatherResult.getCode());
                payoutLotteryResult(resultVo);
            }
        }
        //pk10百家乐是根据BJPK10的数据生成
        if (LotteryEnum.BJPK10.getCode().equals(gatherResult.getCode())) {
            LotteryResult destResult = BeanTool.copyProperties(gatherResult,new LotteryResult());
            destResult.setType(LotteryEnum.PK10BJL.getParent().getCode());
            destResult.setCode(LotteryEnum.PK10BJL.getCode());
            String pk10bjlOpenCode = destResult.getOpenCode();
            if(StringTool.isBlank(pk10bjlOpenCode)){
                LOG.error("保存开奖结果失败,code:{0},期号:{1},原因:{2}", destResult.getCode(), destResult.getExpect(),"pk10百家乐开奖号码为空");
                sendBossMessage(getErrorOpenCodeMsgBody(destResult.getCode(), destResult.getExpect()));
                return;
            }
            destResult.setOpenCode(pk10bjlOpenCode);
            List<BjlResult> bjlResults = BjlResultFormatTool.formatOpenCode(pk10bjlOpenCode);
            destResult.setOpenCodeMemo(JsonTool.toJson(bjlResults));
            resultVo = updateLotteryResult(destResult);
            if(resultVo.isSuccess()){
                CacheBase.refreshLotteryResult(gatherResult.getCode());
                payoutLotteryResult(resultVo);
            }
        }
    }

    /**
     * 获取开奖结果 多接口进行匹配比较
     * @param code
     * @param expect
     * @param futures
     * @return
     */
    protected LotteryResult getOpenCode(String code, String expect, List<Future<LotteryResult>> futures){
        LOG.info("LotteryResultOfficeSubJob:采集开始code:{0},采集期号:{1}", code, expect);
        Map<String,LotteryResult> map = new HashMap<>();
        for (Future<LotteryResult> future : futures) {
            LotteryResult lotteryResult = null;
            try {
                lotteryResult = future.get();
            } catch (Exception e) {
                LOG.error(e,"LotteryResultOfficeSubJob:code:{0},expect:{1}彩票采集任务获取future错误",code,expect);
                sendBossMessage("");
                throw new RuntimeException(e);
            }
            if(lotteryResult!=null && StringTool.isNotEmpty(lotteryResult.getOpenCode())){
                map.put(lotteryResult.getOpenCode(),lotteryResult);
            }
        }
        if(MapTool.isEmpty(map)){
            LOG.error("采集开奖号码失败,code:{0},expect:{1},原因:{2}",code,expect,"未采集到开奖号码,不开奖,不派彩");
            sendBossMessage(getNoOpenCodeMsgBody(code,expect));
            return null;
        }if(map.size() > 1){
            LOG.error("采集开奖号码失败,code:{0},expect:{1},原因:{2}",code,expect,"采集到不同的开奖号码,不开奖,不派彩");
            sendBossMessage(getNoOneOpenCodeMsgBody(code,expect));
            return null;
        }
        return map.values().iterator().next();
    }

    
    protected LotteryResult checkGather(String code,String expect){
        //幸运28是根据北京快乐8开奖号码生成的，不需要采集号码
        if (LotteryEnum.XY28.getCode().equals(code) || LotteryEnum.PK10NN.getCode().equals(code)) {
            LOG.info("LotteryResultOfficeSubJob:采集code:{0},不需要采集数据", code);
            return null;
        }
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setCode(code);
        lotteryResultVo.getSearch().setExpect(expect);
        lotteryResultVo = lotteryResultService.search(lotteryResultVo);
        LotteryResult result = lotteryResultVo.getResult();
//        LotteryResult result = CacheBase.getLotteryResult(code,expect);
        if (result==null) {
            LOG.error("LotteryResultOfficeSubJob:缺少code:{0},expect:{1}的开奖结果数据",code,expect);
            return null;
        }
        Map<String, Lottery> lotteryMap = CacheBase.getLotteryMap(0);
        if(MapTool.isEmpty(lotteryMap) || lotteryMap.get(code) == null){
            LOG.error("LotteryResultOfficeSubJob:缺少code:{0}的主lotery缓存数据",code);
            return null;
        }
        if(LotteryStatusEnum.CLOSE.getCode().equals(lotteryMap.get(code).getStatus())){
            LOG.info("LotteryResultOfficeSubJob:code:{0}的主lotery数据为停市状态，不采集",code);
            return null;
        }
        return result;
    }

    protected List<Future<LotteryResult>> gather(LotteryResult originResult) {
        LOG.info("LotteryResultOfficeSubJob:采集code:{0},采集期号:{1}", originResult.getCode(), originResult.getExpect());
        List<LotteryGatherConf> confList = CacheBase.getLotteryGatherConf(LotteryConfTypeEnum.GATHER.getCode(),originResult.getCode());
        if (CollectionTool.isEmpty(confList)) {
            LOG.error("LotteryResultOfficeSubJob:采集配置信息为空,code:{0},期号:{1}", originResult.getCode(), originResult.getExpect());
            return new LinkedList<>();
        }
        List<Future<LotteryResult>> futures = new LinkedList<>();
        for (LotteryGatherConf conf : confList) {
            LotteryGatherParam gatherParam = LotteryGatherParamUtility.initGatherParam(originResult, conf,null);
            if(gatherParam != null && StringTool.isNotEmpty(gatherParam.getUrl())){
                LotteryResultOfficeTask gatherTask = SpringTool.getBean(LotteryResultOfficeTask.class);
                gatherTask.setGatherParam(gatherParam);
                Future<LotteryResult> future = unifyGatherExecutor.submit(gatherTask);
                futures.add(future);
            }
        }
        return futures;
    }

    private String getXy28OpenCode(String openCode) {
        LOG.info("幸运28采集:北京快乐8开奖号码:{0}", openCode);
        String[] split = openCode.split(",");
        Arrays.sort(split);
        StringBuffer buffer = new StringBuffer();
        if (split.length != 20) {
            LOG.error("幸运28采集:采集失败，北京快乐８的开奖位数有错");
            return null;
        }
        int oneNum = 0;
        int twoNum = 0;
        int threeNum = 0;
        for (int i = 0; i < split.length; i++) {
            if (i < 6) {
                oneNum += Integer.parseInt(split[i]);
            } else if (i < 12) {
                twoNum += Integer.parseInt(split[i]);
            } else if (i < 18) {
                threeNum += Integer.parseInt(split[i]);
            }
        }
        String one = String.valueOf(oneNum);
        String two = String.valueOf(twoNum);
        String three = String.valueOf(threeNum);
        buffer.append(one.substring(one.length() - 1) + "," + two.substring(two.length() - 1) + "," + three.substring(three.length() - 1));
        LOG.info("幸运28采集:开奖号码:{0}", buffer.toString());
        return buffer.toString();
    }

    /**
     * 保存开奖结果
     *
     * @param lotteryResult
     * @return
     */
    @Transactional
    public LotteryResultVo updateLotteryResult(LotteryResult lotteryResult) {
        LOG.info("采集结束,保存开奖结果开始,code:{0},期号:{1},结果:{2}", lotteryResult.getCode(), lotteryResult.getExpect(), JsonTool.toJson(lotteryResult));
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setExpect(lotteryResult.getExpect());
        lotteryResultVo.getSearch().setCode(lotteryResult.getCode());
        lotteryResultVo = lotteryResultService.search(lotteryResultVo);
        if(!lotteryResultVo.isSuccess() && lotteryResultVo.getResult() == null){
            lotteryResultVo.setErrMsg("缺少开奖结果");
            LOG.error("保存开奖结果失败,code:{0},期号:{1},原因:{2}", lotteryResult.getCode(), lotteryResult.getExpect(), lotteryResultVo.getErrMsg());
            return lotteryResultVo;
        }
        lotteryResultVo.getResult().setOpenCode(lotteryResult.getOpenCode());
        lotteryResultVo.getResult().setOpenCodeMemo(lotteryResult.getOpenCodeMemo());
        lotteryResultVo.getResult().setGather(lotteryResult.getGather());
        lotteryResultVo.getResult().setGatherTime(lotteryResult.getGatherTime());
        lotteryResultVo.getResult().setGatherOpenTime(lotteryResult.getGatherOpenTime());
        lotteryResultVo.getResult().setGatherOrigin(LotteryGatherOriginEnum.AUTO.getCode());
        lotteryResultVo.setProperties(LotteryResult.PROP_OPEN_CODE,LotteryResult.PROP_OPEN_CODE_MEMO,LotteryResult.PROP_GATHER,LotteryResult.PROP_GATHER_TIME,
                LotteryResult.PROP_GATHER_OPEN_TIME,LotteryResult.PROP_GATHER_ORIGIN);
        lotteryResultVo = lotteryResultService.updateOnly(lotteryResultVo);
        if(!lotteryResultVo.isSuccess()){
            lotteryResultVo.setErrMsg("保存开奖结果失败");
            LOG.error("保存开奖结果失败,code:{0},期号:{1}", lotteryResult.getCode(), lotteryResult.getExpect());
            return lotteryResultVo;
        }
        LOG.info("保存开奖结果成功,code:{0},期号:{1},结果:{2}", lotteryResult.getCode(), lotteryResult.getExpect(),JsonTool.toJson(lotteryResult));
        return lotteryResultVo;
    }

    /**
     * 开奖结果派彩
     *
     * @return
     */
    private void payoutLotteryResult(LotteryResultVo resultVo) {
        String code = resultVo.getResult().getCode();
        String expect = resultVo.getResult().getExpect();
        LOG.info("LotteryResultOfficeSubJob:准备派彩,code:{0},expect:{1}", code, expect);
        resultVo.setOperateType(LotteryResultVo.OPERATE_TYPE_AUTO);
        resultVo.setOperator(resultVo.getResult().getGather());
        resultVo = lotteryResultService.officePayout(resultVo);
        if(resultVo.isSuccess()){
            LOG.info("派彩成功,code:{0},expect:{1}", code, expect);
        }else{
            LOG.error("派彩失败,code:{0},expect:{1},原因:", code, expect,resultVo.getErrMsg());
        }
    }

    /**
     * 开奖号码格式错误
     */
    private static String getErrorOpenCodeMsgBody(String code,String expect) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", expect);
        map.put("message", "该彩种当期开奖号码格式错误,不予开奖,请及时确认采集接口采集数据！");
        return JsonTool.toJson(map);
    }

    /**
     * 未采集到开奖号码
     */
    private static String getNoOpenCodeMsgBody(String code,String expect) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", expect);
        map.put("message", "该彩种当期开奖号码未采集到,不予开奖,请及时确认采集接口采集数据！");
        return JsonTool.toJson(map);
    }
    /**
     * 开奖号码不一致
     */
    private static String getNoOneOpenCodeMsgBody(String code,String expect) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", expect);
        map.put("message", "该彩种当期采集到的开奖号码不一致,不予开奖,请及时确认各自采集接口采集数据！");
        return JsonTool.toJson(map);
    }

    /**
     * 消息发送
     * @param mesBody
     */
    public void sendBossMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.BOSS_LOTTREY_RESULT_GATHER.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToBossMsg(message);
    }

}
