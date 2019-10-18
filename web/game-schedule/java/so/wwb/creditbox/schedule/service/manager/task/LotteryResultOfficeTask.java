package so.wwb.creditbox.schedule.service.manager.task;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.task.CommonTask;
import so.wwb.creditbox.iservice.common.IMessageService;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.model.constants.common.Const;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherOriginEnum;
import so.wwb.creditbox.model.enums.notice.CometSubscribeType;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.service.manager.lottery.gather.LotteryGatherHandleFactory;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩票官方彩采集任务
 * @author: marz
 * @time 2018-2-27 20:35:57
 */
public class LotteryResultOfficeTask extends CommonTask<LotteryResult> {
    public static final Log LOG = LogFactory.getLog(LotteryResultOfficeTask.class);

    private static final Integer DEFAULT_GATHER_INTERVAL = 360;

    @Autowired
    private ILotteryResultService lotteryResultService;

    @Autowired
    private IMessageService messageService;

    private LotteryGatherParam gatherParam;

    public void setGatherParam(LotteryGatherParam gatherParam) {
        this.gatherParam = gatherParam;
    }


    private static final String format ="HH:mm:ss";

    private final static int GTM8 = 8 ;

    @Override
    public LotteryResult call() {
        String message = "LotteryResultOfficeTask:地址:{0},类型:{1},code:{2},封盘时间:{3},当前时间:{4},开奖时间:{5},采集期号:{6},原始结果:{7}";
        //采集开奖时间1分钟左右
        LotteryGatherConf lotteryGatherConf = gatherParam.getLotteryGatherConf();
        ILotteryGatherHandle lotteryHandle = LotteryGatherHandleFactory.getInstance().getLotteryHandle(lotteryGatherConf.getAbbrName());
        Date lotteryTime = gatherParam.getLotteryTime();
        String expect = gatherParam.getExpect();
        String url = gatherParam.getUrl();
        String type = gatherParam.getType();
        String code = gatherParam.getCode();
        Date closeTime = gatherParam.getCloseTime();
        //开奖时间到最后采集时间间隔,单位s,默认360s
        Integer gatherInterval = gatherParam.getLotteryGatherConf().getGatherInterval() == null?
                DEFAULT_GATHER_INTERVAL:gatherParam.getLotteryGatherConf().getGatherInterval();
        Date startDate = DateTool.addMinutes(lotteryTime, -1);
        Date endDate = DateTool.addSeconds(lotteryTime, gatherInterval);
        try {
            while (true) {
                Date curDate = new Date();
                if (DateTool.minutesBetween(curDate, startDate) >= 0 && DateTool.secondsBetween(endDate, curDate) >= 0) {
                    Object object = lotteryHandle.doGather(gatherParam);
                    if(object instanceof LotteryResultVo){
                        LotteryResultVo lotteryResultvo = (LotteryResultVo)object;
                        //LotteryResultVo lotteryResultvo = linshi();
                        LotteryResult lotteryResult = lotteryResultvo.getResult();
                        LOG.info(message, url, type, code,
                                DateTool.formatDate(closeTime, format), DateTool.formatDate(curDate, format), DateTool.formatDate(lotteryTime, format), expect, JsonTool.toJson(lotteryResult));
                        if (lotteryResult != null && expect.equals(lotteryResult.getExpect())) {
                            //采集回来的开奖时间-当期的封盘时间<=30s，则发告警，不开奖，不派彩
                            if(lotteryResult.getGatherOpenTime() != null && DateTool.secondsBetween(lotteryResult.getGatherOpenTime(),closeTime)<=30){
                                LOG.error("采集失败,采集地址:{0},类型:{1},code:{2},expect:{3},当前时间:{4},封盘时间:{5},开奖时间:{6},原因:{7}", url, type, code,expect,
                                        DateTool.formatDate(curDate, format),DateTool.formatDate(closeTime, format), DateTool.formatDate(lotteryTime, format), "开奖号码提前开奖,发送告警,不开奖,不派彩！");
                                sendBossMessage(getPreMsgBody(lotteryGatherConf,gatherParam));
                                return defaultLotteryResult(gatherParam);
                            }
                            lotteryResult.setOpenTime(new Date());
                            if (lotteryGatherConf.getCheckNext() && StringTool.isNotBlank(lotteryResultvo.getNextExpect()) && lotteryResultvo.getNextOpenTime() != null) {
                                checkNextOpenTime(expect, type, code, lotteryResultvo, lotteryGatherConf,gatherParam);
                            }
                            return lotteryResult;
                        }
                    } else {
                        LOG.warn("采集失败,采集地址:{0},类型:{1},code:{2},expect:{3},当前时间:{4},封盘时间:{5},开奖时间:{6},原因:{7}",  url, type, code,expect,
                                DateTool.formatDate(curDate, format),DateTool.formatDate(closeTime, format), DateTool.formatDate(lotteryTime, format), "返回类型错误,等待5s后继续采集！");
                    }
                } else {
                    LOG.warn("采集失败,采集地址:{0},类型:{1},code:{2},expect:{3},当前时间:{4},封盘时间:{5},开奖时间:{6},原因:{7}",  url, type, code,expect,
                            DateTool.formatDate(curDate, format),DateTool.formatDate(closeTime, format), DateTool.formatDate(lotteryTime, format), "开奖号码延后开奖，发送告警！");
                    sendBossMessage(getPostMsgBody(lotteryGatherConf,gatherParam));
                    return defaultLotteryResult(gatherParam);
                }
                taskSleep();
            }
        } catch (Exception e) {
            LOG.error(e, "采集任务异常,采集code:{0},采集期号:{1},", code, expect);
            return defaultLotteryResult(gatherParam);
        }
    }


    /**
     * 临时的虚假开奖号码
     * @return
     */
    private LotteryResultVo linshi(){
        LotteryResultVo resultVo = new LotteryResultVo();
        LotteryResult result = new LotteryResult();
        result.setType(gatherParam.getType());
        result.setCode(gatherParam.getCode());
        result.setExpect(gatherParam.getExpect());

        result.setGather(Const.SYSTEM_OPERATOR);
        result.setGatherOpenTime(DateTool.addMinutes(new Date(),1));
        result.setGatherTime(new Date());
        result.setGatherOrigin(LotteryGatherOriginEnum.AUTO.getCode());
        String type = gatherParam.getType();
        String openCode = null;
        switch (type){
            case "ssc":{
                openCode="0,4,0,5,6";
                break;
            }case "pk10":{
                openCode="03,09,08,07,05,01,02,06,04,10";
                break;
            }case "lhc":{
                openCode="49,14,17,44,26,42,06";
                break;
            }case "k3":{
                openCode="4,4,6";
                break;
            }case "keno":{
                openCode="78,25,33,46,21,71,16,55,34,68,49,52,43,35,11,80,63,18,27,48";
                break;
            }case "sfc":{
                openCode="20,19,18,14,10,12,09,02";
                break;
            }case "pl3":{
                openCode="4,8,6";
                break;
            }case "xy28":{
                openCode="6,7,9";
                break;
            }
        }
        result.setOpenCode(openCode);
        resultVo.setResult(result);
        return resultVo;
    }

    private LotteryResult defaultLotteryResult(LotteryGatherParam gatherParam) {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setCode(gatherParam.getCode());
        lotteryResult.setType(gatherParam.getType());
        lotteryResult.setExpect(gatherParam.getExpect());
        lotteryResult.setOpenTime(new Date());
        return lotteryResult;
    }

    private void taskSleep() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    /**
     * 检验下一期的开奖时间
     * @param expect
     * @param type
     * @param code
     * @param lotteryResultvo
     * @param gatherConf
     */
    private void checkNextOpenTime(String expect, String type, String code, LotteryResultVo lotteryResultvo, LotteryGatherConf gatherConf,LotteryGatherParam gatherParam) {
        try {
            String nextExpect = String.valueOf(Long.valueOf(expect) + 1);
            lotteryResultvo.getSearch().setExpect(nextExpect);
            lotteryResultvo.getSearch().setCode(code);
            lotteryResultvo.getSearch().setType(type);
            lotteryResultvo = lotteryResultService.search(lotteryResultvo);
            if (lotteryResultvo.getResult() == null) {
                LOG.error("检验下一期的开奖时间未通过,类型:{0},code:{1},当期期号:{2},下期期号:{3},原因:{4}",  type, code,expect,nextExpect, "缺少下期期号的开奖结果");
                String checkMsgBody = getCheckNullMsgBody(nextExpect,gatherParam);
                sendBossMessage(checkMsgBody);
                return;
            }
            Date nextGatherOpenTime = lotteryResultvo.getNextOpenTime();
            Date closeTime = lotteryResultvo.getResult().getCloseTime();
            //下期开奖时间比较封盘时间
            if((DateTool.secondsBetween(nextGatherOpenTime, closeTime)) <= 0){
                LOG.error("检验下一期的开奖时间未通过,类型:{0},code:{1},当期期号:{2},下期期号:{3},采集到的下期开奖时间:{4},下期封盘时间:{5},原因:{6}",  type, code,expect,nextExpect,
                        DateTool.formatDate(nextGatherOpenTime,DateTool.yyyy_MM_dd_HH_mm_ss),DateTool.formatDate(closeTime,DateTool.yyyy_MM_dd_HH_mm_ss), "下期开奖时间,小于封盘时间");
                String checkMsgBody = getCheckNotPassMsgBody(nextExpect, nextGatherOpenTime,closeTime, gatherConf,gatherParam);
                sendBossMessage(checkMsgBody);
            }
        }catch (Exception e){
            LOG.error(e,"检验下一期的开奖时间异常, type{0}, code{1}, expect{2}", type,code,expect);
        }
    }

    /**
     * 获取提前开奖告警信息
     */
    private static String getPreMsgBody(LotteryGatherConf lotteryGatherConf,LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null?EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", gatherParam.getExpect());
        map.put("message", MessageFormat.format("采集接口{0}开奖号码提前开奖,当期暂不开奖,请及时检查官方开奖数据并做好相关操作",lotteryGatherConf.getName()));
        return JsonTool.toJson(map);
    }

    /**
     * 获取延后开奖告警信息
     */
    private static String getPostMsgBody(LotteryGatherConf lotteryGatherConf,LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null?EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", gatherParam.getExpect());
        map.put("message", MessageFormat.format("采集接口{0}延迟开奖,请及时检查官方开奖数据!",lotteryGatherConf.getName()));
        return JsonTool.toJson(map);
    }

    /**
     * 设置消息主体内容
     */
    private static String getCheckNullMsgBody(String nextExpect,LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null?EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", gatherParam.getExpect());
        String message = "缺少下期期号:{0}的开奖结果,请及时检查开奖结果！";
        map.put("message", MessageFormat.format(message, nextExpect));
        return JsonTool.toJson(map);
    }

    /**
     * 设置消息主体内容
     */
    private static String getCheckNotPassMsgBody(String nextExpect, Date nextGatherOpenTime, Date nextCloserTime, LotteryGatherConf gatherConf,LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null?EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", gatherParam.getExpect());
        String message = "下期期号:{0},采集接口:{1}采集到的下期开奖时间:{2},小于下期设置的封盘时间:{3},请检查开奖时间是否变化!!";
        String nextCloserTimeStr = (nextCloserTime != null) ? DateTool.formatDate(DateTool.addHours(nextCloserTime, GTM8), DateTool.yyyy_MM_dd_HH_mm_ss) : "空";
        map.put("message", MessageFormat.format(message, nextExpect,gatherConf.getName(), DateTool.formatDate(nextGatherOpenTime, DateTool.yyyy_MM_dd_HH_mm_ss), nextCloserTimeStr));
        return JsonTool.toJson(map);
    }

}