package so.wwb.lotterybox.service.manager.lottery.gather;

import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import so.wwb.lotterybox.iservice.manager.lottery.ILotteryResultService;
import so.wwb.lotterybox.model.enums.lottery.Lottery600Enum;
import so.wwb.lotterybox.model.manager.lottery.LotteryGatherParam;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.lotterybox.model.manager.lottery.vo.LotteryResultVo;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created by aaa on 17-8-21.
 */
public class LbwGatherHandle extends AbstractLotteryGatherHandle {
    private static final Log LOG = LogFactory.getLog(LbwGatherHandle.class);
    @Override
    protected LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response) {
        return null;
    }

    @Override
    protected LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response) {
        return null;
    }

    @Override
    protected  void valid(String response){
        if(StringTool.isNotBlank(response)){
            LOG.info("600w原始结算时间:{0}",response);
            Map map = JsonTool.fromJson(response, Map.class);
            ArrayList<Map> sscTimeList = (ArrayList) map.get("sscTimeList");
            for (Map data : sscTimeList) {
                String playGroupId = MapTool.getString(data, "playGroupId");
                String lastOpenData = MapTool.getString(data, "lastOpenData");
                String number = MapTool.getString(data, "number");
                long leftTime = MapTool.getLong(data, "leftTime");
                Lottery600Enum lottery600Enum = EnumTool.enumOf(Lottery600Enum.class, playGroupId);
                if(lottery600Enum==null){
                    continue;
                }
                StringBuffer message = new StringBuffer() ;
                message.append("彩种:{0},期号:{1},");
                String format = MessageFormat.format(message.toString(),lottery600Enum.getTrans(),number);
                LOG.info(format);
                ILotteryResultService service = SpringTool.getBean(ILotteryResultService.class);
                LotteryResultVo lotteryResultVo = new LotteryResultVo();
                lotteryResultVo.getSearch().setExpect(number);
                lotteryResultVo.getSearch().setCode(lottery600Enum.getOriCode());
                lotteryResultVo = service.search(lotteryResultVo);
                if(lotteryResultVo.getResult()==null){
                    continue;
                }
                LotteryResult lotteryResult = lotteryResultVo.getResult();
                Date openTime = lotteryResult.getOpenTime();
                long oriLeftTime = DateTool.secondsBetween(openTime, new Date());
                long offset = leftTime - oriLeftTime;
                long defauleOffset = getDefaultOffset(lottery600Enum.getOriCode());
                if(leftTime>=oriLeftTime){
                    message.append("早于600万彩票网开奖时间，相差:{5}秒") ;
                    String msgFormat = MessageFormat.format(message.toString(), lottery600Enum.getTrans(),number,lastOpenData,leftTime, DateTool.formatDate(new Date(),DateTool.yyyy_MM_dd_HH_mm_ss), offset);
                    LOG.info(msgFormat);
                    sendMessage(getMsgBody(msgFormat));
                }

            }
        }
    }

    private long getDefaultOffset(String oriCode) {
        long defauleOffset = (Lottery600Enum.HKLHC.getOriCode().equals(oriCode))?600:60;
        return defauleOffset;
    }

    private String getMsgBody(String message) {
        Map<String, Object> map = new HashMap<>(2,1f);
        map.put("message", message);
        map.put("date", DateTool.formatDate(new Date(), DateTool.yyyy_MM_dd_HH_mm_ss));
        return JsonTool.toJson(map);
    }

    /**
     * 获取消息发送对象
     */
    private List<Integer> getMsgReceivers() {
//        SysResourceListVo sysResourceListVo = new SysResourceListVo();
//        sysResourceListVo.getSearch().setUrl("lottery/manage/list.html");
//        return getService(ISvrServersService.class).queryBossIds(sysResourceListVo);
        return null;
    }

    private void sendMessage(String msg) {
        /*getService(IMessageService.class).sendMessage(message);*/
    }

}
