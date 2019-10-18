package so.wwb.lotterybox.schedule.service.manager.task;

/**
 * Created by marz on 18-7-15.
 */

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.comet.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.lotterybox.iservice.common.IMessageService;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryGatherHandle;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.lotterybox.model.enums.lottery.LotteryEnum;
import so.wwb.lotterybox.model.enums.notice.CometSubscribeType;
import so.wwb.lotterybox.model.manager.lottery.LotteryGatherParam;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.lotterybox.service.manager.lottery.gather.LotteryGatherHandleFactory;

import java.text.MessageFormat;
import java.util.*;

/**
 * 开奖号码校验任务(主要校验当天与前一天，2天的开奖结果)
 *
 * created by marz 2018-07-15 09:07
 */
public class LotteryValidTask implements Runnable {

    private static final Log LOG = LogFactory.getLog(LotteryValidTask.class);

    @Autowired
    private ILotteryResultService lotteryResultService;

    @Autowired
    private IMessageService messageService;//消息推送

    private final static int GTM8 = 8 ;

    private LotteryGatherConf conf;

    private String date;


    public void setConf(LotteryGatherConf conf) {
        this.conf = conf;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LotteryValidTask() {
    }

    @Override
    public void run() {
        LOG.info("开始校验开奖结果开奖号码,code:{0},date:{1}",this.conf.getCode(),this.date);
        List<LotteryResult> gatherLotteryResultList = getGatherLotteryResultList();
        if(CollectionTool.isEmpty(gatherLotteryResultList)){
            LOG.error("校验开奖结果开奖号码失败,code:{0},date:{1},原因：{2}",this.conf.getCode(),this.date,"未采集到开奖结果");
            return;
        }
        List<String> expects = new ArrayList<>(gatherLotteryResultList.size());
        gatherLotteryResultList.forEach(lotteryResult->{
            expects.add(lotteryResult.getExpect());
        });
        LotteryResultListVo listVo = new LotteryResultListVo();
        listVo.getSearch().setCode(this.conf.getCode());
        listVo.getSearch().setExpects(expects);
        listVo.setPaging(null);
        listVo = lotteryResultService.searchByExpects(listVo);
        if(!listVo.isSuccess() || CollectionTool.isEmpty(listVo.getResult())){
            LOG.error("校验开奖结果开奖号码,code:{0},date:{1},原因：{2}",this.conf.getCode(),this.date,"系统未查询到开奖结果");
            sendBossMessage(getListNullMsgBody(this.conf.getCode(),this.date));
            return;
        }
        // 只保留最多3期最新的未开奖的开奖结果
        List<String> openCodeNullList = new ArrayList<>();
        List<String> openCodeErrorList = new ArrayList<>();
        for (LotteryResult lotteryResult : listVo.getResult()) {
            if(StringTool.isBlank(lotteryResult.getOpenCode())){
                if(openCodeNullList.size() < 3){
                    openCodeNullList.add(lotteryResult.getExpect());
                }
            }else{
                gatherLotteryResultList.forEach(gatherLotteryResult->{
                    if(lotteryResult.getExpect().equals(gatherLotteryResult.getExpect()) &&
                            !lotteryResult.getOpenCode().equals(gatherLotteryResult.getOpenCode())){
                        openCodeErrorList.add(lotteryResult.getExpect());
                    }
                });
            }
        }
        if(CollectionTool.isNotEmpty(openCodeNullList)){
            LOG.error("校验开奖结果开奖号码,code:{0},date:{1},原因:{2},对应期数:{3}",this.conf.getCode(),this.date,"存在未开奖的开奖结果",StringTool.join(openCodeNullList,","));
            sendBossMessage(getNullMsgBody(this.conf.getCode(),StringTool.join(openCodeNullList,",")));
        }
        if(CollectionTool.isNotEmpty(openCodeErrorList)){
            LOG.error("校验开奖结果开奖号码,code:{0},date:{1},原因:{2},对应期数:{3}",this.conf.getCode(),this.date,"存在开奖号码不一致的开奖结果",StringTool.join(openCodeErrorList,","));
            sendBossMessage(getErrorMsgBody(this.conf.getCode(),StringTool.join(openCodeErrorList,",")));
        }
        LOG.info("结束校验开奖结果开奖号码,code:{0},date:{1}",this.conf.getCode(),this.date);
    }

    /**
     * 采集2天的开奖结果
     * @return
     */
    private List<LotteryResult> getGatherLotteryResultList(){
        List<LotteryResult> resultList = new ArrayList<>();
        ILotteryGatherHandle lotterHandle = LotteryGatherHandleFactory.getInstance().getLotterHandle(this.conf.getAbbrName());
        String gatherDate = this.date;
        //采集2天开奖结果
        LotteryGatherParam gatherParam = new LotteryGatherParam();
        gatherParam.setCode(this.conf.getCode());
        gatherParam.setDate(gatherDate);
        gatherParam.setLotteryGatherConf(conf);
        LotteryResultListVo list = lotterHandle.doMakeUp(gatherParam);
        if(CollectionTool.isNotEmpty(list.getResult())){
            resultList.addAll(list.getResult());
        }
        // 间隔12s再采集一次
        taskSleep();
        gatherDate = DateTool.formatDate(DateTool.addDays(DateTool.parseDate(gatherDate,DateTool.yyyy_MM_dd),-1),DateTool.yyyy_MM_dd);
        gatherParam.setDate(gatherDate);
        list = lotterHandle.doMakeUp(gatherParam);
        if(CollectionTool.isNotEmpty(list.getResult())){
            resultList.addAll(list.getResult());
        }
        return resultList;
    }

    private void taskSleep() {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            LOG.warn("检验开奖结果数据睡眠失败,原因:{0}",e.getMessage());
        }
    }

    /**
     * 设置未查询到开奖结果消息主体内容
     */
    private String getListNullMsgBody(String code,String date) {
        Map<String, Object> map = new HashMap<>(3,1f);
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(),GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", code);
        String message =  "采集接口:{0},缺少彩票:{1},{2}与{3}的开奖结果,请及时初始化开奖结果!!" ;
        map.put("message", MessageFormat.format(message,this.conf.getName(),codeName,
                DateTool.formatDate(DateTool.addDays(DateTool.parseDate(date,DateTool.yyyy_MM_dd),-1),DateTool.yyyy_MM_dd),date));
        return JsonTool.toJson(map);
    }

    /**
     * 设置未开奖消息主体内容
     */
    private String getNullMsgBody(String code,String expects) {
        Map<String, Object> map = new HashMap<>(3,1f);
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(),GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", code);
        String message =  "采集接口:{0},彩票:{1},期号:{2},开奖结果未开奖,请及时手动补采开奖!!" ;
        map.put("message", MessageFormat.format(message,this.conf.getName(),codeName,expects));
        return JsonTool.toJson(map);
    }

    /**
     * 设置开奖号码错误消息主体内容
     */
    private String getErrorMsgBody(String code,String expects) {
        Map<String, Object> map = new HashMap<>(3,1f);
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null?EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(),GTM8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", code);
        String message =  "采集接口:{0},彩票:{1},期号:{2},开奖结果不一致,请及时确认官网开奖结果!!" ;
        map.put("message", MessageFormat.format(message,this.conf.getName(),codeName,expects));
        return JsonTool.toJson(map);
    }

    /**
     * 消息发送
     * @param mesBody
     */
    public void sendBossMessage(String mesBody) {
        MessageVo message = new MessageVo();
        // 前端消息订阅类型
        message.setSubscribeType(CometSubscribeType.BOSS_LOTTREY_RESULT_VALID.getCode());
        // 设置消息主体内容
        message.setMsgBody(mesBody);
        // 设置消息接收对象
        messageService.sendToBossMsg(message);
    }
}