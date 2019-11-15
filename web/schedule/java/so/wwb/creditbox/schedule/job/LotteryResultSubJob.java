package so.wwb.creditbox.schedule.job;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.support.DataContext;
import org.soul.model.comet.vo.MessageVo;
import org.soul.model.security.privilege.vo.SysResourceListVo;
import org.springframework.beans.factory.annotation.Autowired;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.lottery.LotteryConfTypeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryOriginEnum;
import so.wwb.creditbox.model.enums.notice.CometSubscribeType;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.schedule.task.LotteryGatherTask;
import so.wwb.creditbox.service.tool.DatasourceUtil;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by shook on 17-11-22.
 * 开奖结果子任务,负责发起采集请求
 */
public class LotteryResultSubJob {

    private static final Log LOG = LogFactory.getLog(LotteryResultSubJob.class);

    private final static String BEAN_ID = "lotteryGatherTask";

    private final static int GMT8 = 8 ;


    @Autowired
    private ExecutorService gatherExecutor;

    public void execute(String code) {
        LotteryResult originResult = getCurLotteryResult(code);
        //幸运28是根据北京快乐8开奖号码生成的，不需要采集号码
        if (LotteryEnum.XY28.getCode().equals(code) || originResult == null) {
            LOG.info("LotteryResultSubJob:采集code:{0},时间:{1},没有需要采集数据", code, new Date());
            return;
        }
        List<Future<LotteryResult>> futures = gather(originResult);
        LotteryResult result = checkOpenCode(originResult.getCode(),originResult.getExpect(),futures);

        if (result != null) {
            saveResult(originResult, result);
        }
    }

    /**
     * 校验开奖号码，当前只有一个采集接口，意义不大
     *
     * @param futures
     * @return
     */
    private LotteryResult checkOpenCode(String code,String expect,List<Future<LotteryResult>> futures) {
        Map<String,LotteryResult> map = new HashMap<>();
        boolean isAdvanceOpen = false;
        if (CollectionTool.isNotEmpty(futures)) {
            for (int i = 0; i < futures.size(); ++i) {
                Future<LotteryResult> future = futures.get(i);
                if (future != null) {
                    LotteryResult lotteryResult = null;
                    try {
                        lotteryResult = future.get();
                    } catch (Exception e) {
                        LOG.error(e,"LotteryResultSubJob:code:{0},expect:{1}彩票采集任务获取future错误",code,expect);
                    }
//                    if (lotteryResult!=null && lotteryResult.isAdvanceOpen()) {
//                        isAdvanceOpen = lotteryResult.isAdvanceOpen();
//                        break;
//                    }
                    if(lotteryResult!=null && StringTool.isNotEmpty(lotteryResult.getOpenCode())){
                        map.put(lotteryResult.getOpenCode(),lotteryResult);
                    }
                }
            }
        }
        if (isAdvanceOpen) {
            LOG.error("采集开奖号码失败,code:{0},expect:{1},原因:{2}",code,expect,"提前采集号码,所有采集源,不开奖,不派彩");
            sendBossMessage(getNoOpenCodeMsgBody(code,expect));
            return null;
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

    private void saveResult(LotteryResult originResult, LotteryResult lotteryResult) {
        String openCode = saveLotteryResult(originResult, lotteryResult);
        //幸运２８是根据北京快乐８的数据生成
        if (LotteryEnum.BJKL8.getCode().equals(originResult.getCode())) {
            saveXy28Result(originResult, openCode);
        }
    }

    private List<Future<LotteryResult>> gather(LotteryResult originResult) {
        LOG.info("LotteryResultSubJob:采集code:{0},采集期号:{1}", originResult.getCode(), originResult.getExpect());
        List<LotteryGatherConf> lotteryGatherConf = CacheBase.getLotteryGatherConf(originResult.getCode());
        lotteryGatherConf = lotteryGatherConf.stream().filter(v -> LotteryConfTypeEnum.GATHER.getCode().equals(v.getConfType())).collect(Collectors.toList());
        if (CollectionTool.isEmpty(lotteryGatherConf)) {
            LOG.error("LotteryResultSubJob:采集配置信息为空,code:{0},期号:{1}", originResult.getCode(), originResult.getExpect());
            return new LinkedList<>();
        }
        List<Future<LotteryResult>> futures = new LinkedList<>();
        for (LotteryGatherConf conf : lotteryGatherConf) {
            LotteryGatherParam gatherParam = initGatherParam(originResult, conf);
            LotteryGatherTask gatherTask = (LotteryGatherTask) SpringTool.getBean(BEAN_ID);
            gatherTask.setGatherParam(gatherParam);
            Future<LotteryResult> future = gatherExecutor.submit(gatherTask);
            futures.add(future);
        }
        return futures;
    }

    /**
     * 保存开奖结果
     *
     * @param originResult
     * @param gatherResult
     * @return
     */
    private String saveLotteryResult(LotteryResult originResult, LotteryResult gatherResult) {
        LOG.info("LotteryResultSubJob:采集结束,code:{0},期号:{1},结果:{2}", originResult.getCode(), originResult.getExpect(), JsonTool.toJson(originResult));
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setExpect(originResult.getExpect());
        lotteryResultVo.getSearch().setCode(originResult.getCode());

        String openCode = gatherResult.getOpenCode();
        originResult.setOpenCode(openCode);
        originResult.setGatherTime(new Date());
        String code = (StringTool.isNotBlank(originResult.getOrigin())) ? originResult.getOrigin() : LotteryOriginEnum.AUTO.getCode();
        originResult.setOrigin(code);
        lotteryResultVo.setResult(originResult);
        ServiceTool.lotteryResultService().saveLotterResult(lotteryResultVo);
        CacheBase.refreshLotteryResult(originResult.getCode());
        return openCode;
    }


    /**
     * 生产幸运28的开奖结果
     *
     * @param originResult
     * @param openCode
     */
    private void saveXy28Result(LotteryResult originResult, String openCode) {
        LotteryEnum xy28 = LotteryEnum.XY28;
        LotteryResultVo xy28ResultVo = new LotteryResultVo();
        ILotteryResultService service = ServiceTool.lotteryResultService();
        xy28ResultVo.getSearch().setCode(xy28.getCode());
        xy28ResultVo.getSearch().setType(xy28.getType());
        xy28ResultVo.getSearch().setExpect(originResult.getExpect());
        LotteryResult xy28Result = service.search(xy28ResultVo).getResult();
        xy28Result.setCode(xy28.getCode());
        xy28Result.setType(xy28.getType());
        String xy28OpenCode = getXy28OpenCode(openCode);
        xy28Result.setOpenCode(xy28OpenCode);
        xy28Result.setGatherTime(new Date());
        xy28Result.setOrigin(LotteryOriginEnum.AUTO.getCode());
        xy28ResultVo.setResult(xy28Result);
        service.saveLotterResult(xy28ResultVo);
        CacheBase.refreshLotteryResult(LotteryEnum.XY28.getCode());
        LOG.info("LotteryResultSubJob:生成幸运28结果:{0},采集成功", JsonTool.toJson(xy28Result));
    }

    public String getXy28OpenCode(String openCode) {
        LOG.info("LotteryResultSubJob:北京快乐8开奖号码:{0}", openCode);
        String[] split = openCode.split(",");
        Arrays.sort(split);
        StringBuffer buffer = new StringBuffer();
        if (split.length != 20) {
            LOG.error("LotteryResultSubJob:彩票采集任务失败，北京快乐８的开奖位数有错");
            return buffer.toString();
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
        LOG.info("LotteryResultSubJob:幸运28开奖号码:{0}", buffer.toString());
        return buffer.toString();
    }

    /**
     * 初始采集参数
     *
     * @param lotteryResult
     * @param conf
     * @return
     */
    private LotteryGatherParam initGatherParam(LotteryResult lotteryResult, LotteryGatherConf conf) {
        LotteryGatherParam gatherParam = new LotteryGatherParam();
        gatherParam.setCode(lotteryResult.getCode());
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, lotteryResult.getCode());
        gatherParam.setType(lotteryEnum.getType());
        gatherParam.setExpect(lotteryResult.getExpect());
        gatherParam.setLotteryTime(lotteryResult.getOpenTime());
        gatherParam.setCloseTime(lotteryResult.getCloseTime());
        gatherParam.setUrl(conf.getUrl());
        gatherParam.setLotteryGatherConf(conf);
        return gatherParam;
    }

    /**
     * 获取当前要开奖的所有盘口信息
     *
     * @return
     */
    private LotteryResult getCurLotteryResult(String code) {
        DataContext.setDataSource(DatasourceUtil.getBossDatasource());
        ILotteryResultService service = ServiceTool.lotteryResultService();
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setCode(code);
        LotteryResult lotteryResult = service.searchByCurTime(lotteryResultVo);
        return lotteryResult;
    }

    /**
     * 发送彩票结果采集监控消息提醒到boss与mcenter
     */

    public void sendMessage(String mesBody) {
//        sendMcenterMessage(mesBody);
        sendBossMessage(mesBody);
    }

    /**
     * 发送彩票结果采集监控消息提醒到boss
     */

    public void sendBossMessage(String mesBody) {
        try {
            //发送boss消息需要设置boss数据源，但1个线程只能有1个数据源，所以新增一个线程用来发送boss消息
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    MessageVo message = new MessageVo();
                    // 前端消息订阅类型
                    message.setSubscribeType(CometSubscribeType.BOSS_LOTTREY_RESULT_VALID.getCode());
                    // 设置消息主体内容
                    message.setMsgBody(mesBody);
                    SysResourceListVo sysResourceListVo = new SysResourceListVo();
                    sysResourceListVo.getSearch().setUrl("lottery/manage/list.html");
                    DataContext.setDataSource(DatasourceUtil.getBossDatasource());
                    List<Integer> userIds = ServiceTool.lotteryResultService().queryBossIds(sysResourceListVo);
                    // 设置消息接收对象
                    message.addUserIds(userIds);
                    message.setSendToUser(true);
                    message.setSiteId(0);
                    ServiceTool.messageService().sendToBossMsg(message);
                }
            });
            thread.start();
        } catch (Exception e) {
            LOG.error("发送boss消息失败！消息内容：{0}", mesBody);
        }
    }


//    /**
//     * 发送彩票结果采集监控消息提醒到mcenter
//     */
//
//    public void sendMcenterMessage(String mesBody) {
//        List<Integer> siteIdList = ServiceTool.siteApiService().getSiteIdsByApiId(Integer.valueOf(ApiProviderEnum.PL.getCode()));
//        if (CollectionTool.isNotEmpty(siteIdList)) {
//            for (Integer siteId : siteIdList) {
//                MessageVo message = new MessageVo();
//                // 前端消息订阅类型
//                message.setSubscribeType(CometSubscribeType.MCENTER_LOTTREY_RESULT_REMINDER.getCode());
//                // 设置消息主体内容
//                message.setMsgBody(mesBody);
//                // 设置消息接收对象
//                message.setReceiveUserType(ReceiverGroupType.ONLINE_BACK.getCode());
//                message.setSiteId(siteId);
//                ServiceTool.messageService().sendToMCenterMsg(message);
//            }
//        }
//    }

    /**
     * 设置消息主体内容
     */
    private String getMsgBody(LotteryResult lotteryResult) {
        Map<String, Object> map = new HashMap<>(3, 1f);
        String codeName = EnumTool.enumOf(LotteryEnum.class, lotteryResult.getCode()) != null ? EnumTool.enumOf(LotteryEnum.class, lotteryResult.getCode()).getTrans() : lotteryResult.getCode();
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("code", lotteryResult.getCode());
        String message = "彩票code:{0},期号:{1},接口开奖结果采集失败,请手动开奖!!";
        map.put("message", MessageFormat.format(message, codeName, lotteryResult.getExpect()));
        return JsonTool.toJson(map);
    }

    /**
     * 未采集到开奖号码
     */
    private static String getNoOpenCodeMsgBody(String code,String expect) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null? EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", expect);
        map.put("message", "彩种:"+codeName+" 期数:"+expect+" 该彩种当期开奖号码未采集到,不予开奖,请及时确认采集接口采集数据！");
        return JsonTool.toJson(map);
    }
    /**
     * 开奖号码不一致
     */
    private static String getNoOneOpenCodeMsgBody(String code,String expect) {
        String codeName = EnumTool.enumOf(LotteryEnum.class,code) != null? EnumTool.enumOf(LotteryEnum.class,code).getTrans():code;
        Map<String, Object> map = new HashMap<>(4, 1f);
        map.put("date", DateTool.formatDate(DateTool.addHours(new Date(), GMT8), DateTool.yyyy_MM_dd_HH_mm_ss));
        map.put("codeName", codeName);
        map.put("expect", expect);
        map.put("message", "彩种:"+codeName+" 期数:"+expect+" 该彩种当期采集到的开奖号码不一致,不予开奖,请及时确认各自采集接口采集数据！");
        return JsonTool.toJson(map);
    }

}
