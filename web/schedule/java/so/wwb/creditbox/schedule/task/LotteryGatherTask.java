package so.wwb.creditbox.schedule.task;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.schedule.job.LotteryResultSubJob;
import so.wwb.creditbox.service.manager.gather.ILotteryGatherHandle;
import so.wwb.creditbox.service.manager.handle.LotteryGatherHandleFactory;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


/**
 * Created by aaa on 17-9-11.
 */
public class LotteryGatherTask implements Callable<LotteryResult> {

    protected final static String BEAN_ID = "lotteryGatherTask";

    private static final String format ="HH:mm:ss";

    private final static int GMT = 8 ;


    @Autowired
    private LotteryResultSubJob gatherJob;

    public LotteryGatherTask() {
    }

    private static final Log LOG = LogFactory.getLog(LotteryGatherTask.class);

    private LotteryGatherParam gatherParam;

    LotteryGatherTask(LotteryGatherParam gatherParam) {
        this.gatherParam = gatherParam;
    }

    @Override
    public LotteryResult call() {
        try {
            String message = "LotteryGatherTask:地址:{0},类型:{1},code:{2},封盘时间:{3},当前时间:{4},开奖时间:{5},采集期号:{6},原始结果:{7}";
            //采集开奖时间1分钟左右
            LotteryGatherConf lotteryGatherConf = gatherParam.getLotteryGatherConf();
            ILotteryGatherHandle lotterHandle = LotteryGatherHandleFactory.getInstance().getLotterHandle(lotteryGatherConf.getAbbrName());
            while (true) {
                Date curDate = new Date();
                Date lotteryTime = gatherParam.getLotteryTime();
                String expect = gatherParam.getExpect();
                String url = gatherParam.getUrl();
                String type = gatherParam.getType();
                String code = gatherParam.getCode();
                Date closeTime = gatherParam.getCloseTime();
                if (DateTool.minutesBetween(curDate, DateTool.addMinutes(lotteryTime, -2)) >= 0 && DateTool.minutesBetween(DateTool.addMinutes(lotteryTime, 6), curDate) >= 0) {
                    LotteryResultVo lotteryResultvo = lotterHandle.doGather(gatherParam);
                    LotteryResult lotteryResult = lotteryResultvo.getResult();
                    LOG.info(message, url, type, code,
                            DateTool.formatDate(closeTime, format), DateTool.formatDate(curDate, format), DateTool.formatDate(lotteryTime, format), expect, JsonTool.toJson(lotteryResult));
                    if (lotteryResult != null && expect.equals(lotteryResult.getExpect())) {
                        //采集回来的开奖时间-当期的封盘时间<=30s，则发告警，不开奖，不派彩
                        if(lotteryResult.getOpenTime() != null && DateTool.secondsBetween(lotteryResult.getOpenTime(),closeTime)<=30){
                            LOG.info(message, url, type, code,
                                    DateTool.formatDate(closeTime, format), DateTool.formatDate(curDate, format), DateTool.formatDate(lotteryTime, format), expect, "开奖号码提前开奖,发送告警,不开奖！");
                            gatherJob.sendMessage(getPreMsgBody(lotteryResult.getOpenTime(),gatherParam));
                            return defaultLotteryResult(gatherParam);
                        }
                        lotteryResult.setOpenTime(new Date());
                        if (lotteryGatherConf.getCheckNext() && StringTool.isNotBlank(lotteryResultvo.getNextExpect()) && lotteryResultvo.getNextOpenTime() != null) {
                            checkNextOpenTime(expect, type, code, lotteryResultvo, lotteryGatherConf);
                        }
                        return lotteryResult;
                    }
                } else {
                    LOG.info(message, url, type, code,
                            DateTool.formatDate(closeTime, format), DateTool.formatDate(curDate, format), DateTool.formatDate(lotteryTime, format), expect, "开奖号码延后开奖，发送告警！！");
                    gatherJob.sendMessage(getPostMsgBody(gatherParam));
                    return defaultLotteryResult(gatherParam);
                }
                taskSleep();
            }
        } catch (Exception e) {
            LOG.error(e, "LotteryGatherTask:采集任务异常,采集code:{0},采集期号:{1},", gatherParam.getCode(), gatherParam.getExpect());
            return defaultLotteryResult(gatherParam);
        }
    }
    private LotteryResult defaultLotteryResult(LotteryGatherParam gatherParam) {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setCode(gatherParam.getCode());
        lotteryResult.setType(gatherParam.getType());
        lotteryResult.setExpect(gatherParam.getExpect());
        lotteryResult.setOpenTime(new Date());
        return lotteryResult;
    }

    /**
     * 检验下一期的开奖时间
     * @param expect
     * @param type
     * @param code
     * @param lotteryResultvo
     * @param gatherConf
     */
    private void checkNextOpenTime(String expect, String type, String code, LotteryResultVo lotteryResultvo, LotteryGatherConf gatherConf) {
        try {
            String nextExpect = String.valueOf(Long.valueOf(expect) + 1);
            lotteryResultvo.getSearch().setExpect(nextExpect);
            lotteryResultvo.getSearch().setCode(code);
            lotteryResultvo.getSearch().setType(type);
            lotteryResultvo = ServiceTool.lotteryResultService().search(lotteryResultvo);
            if (lotteryResultvo.getResult() == null) {
                String checkMsgBody = getCheckMsgBody(code, nextExpect, null, gatherConf);
                gatherJob.sendBossMessage(checkMsgBody);
                LOG.error(checkMsgBody);
                return;
            }
            Date nextOpenTime = lotteryResultvo.getNextOpenTime();
            Date closeTime = lotteryResultvo.getResult().getCloseTime();
            //下期开奖时间比较封盘时间
            if((DateTool.secondsBetween(nextOpenTime, closeTime)) <= 0){
                String checkMsgBody = getCheckMsgBody(code, nextExpect, closeTime, gatherConf);
                LOG.error(checkMsgBody);
            }
        }catch (Exception e){
            LOG.error(e,"采集验证下一期开奖时间出错");
        }
    }

    private void taskSleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LotteryGatherParam getGatherParam() {
        return gatherParam;
    }

    public void setGatherParam(LotteryGatherParam gatherParam) {
        this.gatherParam = gatherParam;
    }

    /**
     * 获取提前开奖告警信息
     */
    private static String getPreMsgBody(Date gatherOpenTime,LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null? EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", gatherParam.getCode());
        String message = "彩票code:{0},当期期号:{1},当期封盘时间:{2},采集开奖时间：{3},采集接口开奖号码提前开奖,当期暂不开奖,请及时检查官方开奖数据并做好相关撤单!!";
        String closeTime = DateTool.formatDate(DateTool.addHours(gatherParam.getCloseTime(), GMT), DateTool.yyyy_MM_dd_HH_mm_ss);
        String openTime = DateTool.formatDate(DateTool.addHours(gatherOpenTime, GMT), DateTool.yyyy_MM_dd_HH_mm_ss);
        map.put("message", MessageFormat.format(message, codeName, gatherParam.getExpect(), closeTime,openTime));
        return JsonTool.toJson(map);
    }

    /**
     * 获取延后开奖告警信息
     */
    private static String getPostMsgBody(LotteryGatherParam gatherParam) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()) != null? EnumTool.enumOf(LotteryEnum.class,gatherParam.getCode()).getTrans():gatherParam.getCode();
        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", gatherParam.getCode());
        String message = "彩票code:{0},当期期号:{1},当期封盘时间:{2},采集接口开奖号码延迟开奖,请及时检查官方开奖数据!!";
        String closeTime = DateTool.formatDate(DateTool.addHours(gatherParam.getCloseTime(), GMT), DateTool.yyyy_MM_dd_HH_mm_ss);
        map.put("message", MessageFormat.format(message, codeName, gatherParam.getExpect(), closeTime));
        return JsonTool.toJson(map);
    }

    /**
     * 设置消息主体内容
     */
    private static String getCheckMsgBody(String code, String expect, Date lotteryTime, LotteryGatherConf gatherConf) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null? EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", code);
        String message = "采集接口:{0},彩票code:{1},下一期期号:{2},下一期开奖时间:{3},小于封盘时间,请检查开奖时间是否变化!!";
        String nextLotteryTime = (lotteryTime != null) ? DateTool.formatDate(DateTool.addHours(lotteryTime, GMT), DateTool.yyyy_MM_dd_HH_mm_ss) : "空";
        map.put("message", MessageFormat.format(message, gatherConf.getName(), codeName, expect, nextLotteryTime));
        return JsonTool.toJson(map);
    }
}