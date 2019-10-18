package so.wwb.lotterybox.schedule.service.manager.job;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import org.soul.model.msg.notice.enums.NoticeReceiverGroupType;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.common.IMessageService;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.lotterybox.schedule.service.utility.ServiceManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化开奖结果任务
 * @author: marz
 * @time 2018-2-27 20:35:57
 */
public class LotteryResultInitJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultMainJob.class);

    @Autowired
    private IMessageService messageService;

    private static final int GTM8 = 8;

    public void execute() {
        LotteryResultVo resultVo = new LotteryResultVo();
        resultVo.setSearch(new LotteryResultSo());
        resultVo.getSearch().setInitDate(new Date());
        resultVo.setOperateType(LotteryResultVo.OPERATE_TYPE_AUTO);
        try {
            resultVo = ServiceManager.getLotteryResultService().initLotteryResult(resultVo);
            if(!resultVo.isSuccess()){
                sendBossMessage(getInitMsgBody(DateTool.formatDate(DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8),DateTool.yyyy_MM_dd)));
                LOG.error("自动初始化开奖结果失败,date:{0},code:{1},原因:{2}",DateTool.formatDate(DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8),DateTool.yyyy_MM_dd),
                        JsonTool.toJson(resultVo.getCodes()),resultVo.getErrMsg());
                throw new RuntimeException(resultVo.getErrMsg());
            }
            LOG.info("自动初始化开奖结果成功,date:{0},code:{1}！",DateTool.formatDate(DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8),DateTool.yyyy_MM_dd),
                    JsonTool.toJson(resultVo.getCodes()));
        } catch (Exception e) {
            LOG.error(e, "自动初始化开奖结果异常,date:{0}", DateTool.formatDate(DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8),DateTool.yyyy_MM_dd));
            sendBossMessage(getInitMsgBody(DateTool.formatDate(DateTool.addHours(resultVo.getSearch().getInitDate(),GTM8),DateTool.yyyy_MM_dd)));
            throw e;
        }
    }

    /**
     * 设置消息主体内容
     */
    private static String getInitMsgBody(String initDateStr) {
        Map<String, Object> map = new HashMap<>(3, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("initDate", initDateStr);
        map.put("message", "自动初始化开奖结果失败,请手动初始化");
        return JsonTool.toJson(map);
    }

    /**
     * 彩票结果初始化监控消息发送
     * @param mesBody
     */
    public void sendBossMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.BOSS_LOTTREY_RESULT_INIT.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        message.setReceiveUserType(NoticeReceiverGroupType.ONLINE_BACK.getCode());
        messageService.sendToBossMsg(message);
    }
}
