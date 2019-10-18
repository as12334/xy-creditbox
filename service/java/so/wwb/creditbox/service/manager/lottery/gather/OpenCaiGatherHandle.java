package so.wwb.creditbox.service.manager.lottery.gather;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherOriginEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherData;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.LotteryOpenResult;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.utility.BjlResultFormatTool;
import so.wwb.creditbox.utility.NnResultFormatTool;

import java.util.*;

/**
 * Created by admin on 17-4-14.
 */
public class OpenCaiGatherHandle extends AbstractLotteryGatherHandle {
    private final static int GMT = 8 ;
    private static final Log LOG = LogFactory.getLog(OpenCaiGatherHandle.class);

    @Override
    protected LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response) {
        LotteryResultListVo resultVo = new LotteryResultListVo();
        Map map = JsonTool.fromJson(response,Map.class);
        if(MapTool.isEmpty(map)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未采集到补采数据");
            return resultVo;
        }
        List<LinkedHashMap> data = (List<LinkedHashMap>)map.get("data");
        if(CollectionTool.isEmpty(data)){
            resultVo.setSuccess(false);
            resultVo.setErrMsg("未采集到补采数据");
            return resultVo;
        }
        List<LotteryResult> resultList = new ArrayList<>();
        for(Map record : data){
            LotteryResult lotteryResult = new LotteryResult();
            lotteryResult.setCode(gatherParam.getCode());
            lotteryResult.setGather(gatherParam.getGather());
            lotteryResult.setExpect(getExpect(gatherParam.getCode(),String.valueOf(record.get("expect"))));
            String openCode = getOpenCode(gatherParam.getCode(),String.valueOf(record.get("opencode")));
            lotteryResult.setOpenCode(openCode);
            lotteryResult.setOpenCodeMemo(getOpenCodeMemo(gatherParam.getCode(),openCode));
            lotteryResult.setGatherOrigin(LotteryGatherOriginEnum.MAKE_UP.getCode());
            lotteryResult.setGatherTime(new Date());
            lotteryResult.setGatherOpenTime(DateTool.addHours(DateTool.parseDate(String.valueOf(record.get("opentime")), DateTool.yyyy_MM_dd_HH_mm_ss),-GMT));
            resultList.add(lotteryResult);
        }
        resultVo.setResult(resultList);
        return resultVo;
    }

    @Override
    protected LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        if(StringTool.isBlank(response)){
            LOG.error("开奖网采集结果为空");
            return lotteryResultVo;
        }
        try {
            LotteryOpenResult openResult = JsonTool.fromJson(response, LotteryOpenResult.class);
            if (openResult == null || CollectionTool.isEmpty(openResult.getLotterGatherDataList())) {
                LOG.error("开奖网采集结果为空");
                return lotteryResultVo;
            }
            if (StringTool.isNotBlank(openResult.getRemain())) {
                try {
                    int remain = Integer.parseInt(openResult.getRemain().split("hrs")[0]);
                    if (remain < 24 * 7) {
                        LOG.error("开奖网采集剩余时间少于一周，请尽快续费");
                    }
                } catch (Exception e) {
                    LOG.error("开奖网采集剩余时间出错", response);
                }
            }
            List<LotteryGatherData> nextDatas = openResult.getNextData();
            if (CollectionTool.isNotEmpty(nextDatas)) {
                LotteryGatherData nextData = nextDatas.get(0);
                String nextDataOpentime = nextData.getOpentime();
                Date nextOpenDate = DateTool.parseDate(nextDataOpentime, DateTool.yyyy_MM_dd_HH_mm_ss);
                lotteryResultVo.setNextExpect(nextData.getExpect());
                lotteryResultVo.setNextOpenTime(DateTool.addHours(nextOpenDate,-GMT));
            }
            LotteryGatherData lotteryGatherData = openResult.getLotterGatherDataList().get(0);
            LotteryResult result = new LotteryResult();
            result.setType(gatherParam.getType());
            result.setCode(gatherParam.getCode());
            result.setExpect(getExpect(gatherParam.getCode(),lotteryGatherData.getExpect()));
            String openCode = getOpenCode(gatherParam.getCode(),lotteryGatherData.getOpencode());
            result.setOpenCode(openCode);
            result.setGather(gatherParam.getGather());
            result.setOpenCodeMemo(getOpenCodeMemo(gatherParam.getCode(),openCode));
            result.setGatherTime(new Date());
            result.setGatherOpenTime(DateTool.addHours(DateTool.parseDate(lotteryGatherData.getOpentime(), DateTool.yyyy_MM_dd_HH_mm_ss),-GMT));
            lotteryResultVo.setResult(result);
        } catch (Exception e) {
            LOG.error(e,"采集OpenCai错误");
        }
        return lotteryResultVo;
    }

    /**
     * 根据code获取格式化期数
     * @param code
     * @param sourceExpect
     * @return
     */
    private String getExpect(String code,String sourceExpect){
        String result = sourceExpect;
        if(LotteryEnum.JSK3.getCode().equals(code)|| LotteryEnum.GXK3.getCode().equals(code)){
            result = result.substring(2,result.length());
        }
        return result;
    }

    /**
     * 根据code获取格式化开奖号码
     * @param code
     * @param sourceOpenCode
     * @return
     */
    private String getOpenCode(String code,String sourceOpenCode){
        String result = sourceOpenCode;
        if (LotteryEnum.HKLHC.getCode().equals(code)) {
            result = result.replace("+", ",");
        }
        //自动采集不会xy28 手动补采会进入当前逻辑
        if (LotteryEnum.BJKL8.getCode().equals(code) || LotteryEnum.XY28.getCode().equals(code)) {
            result = result.split("\\+")[0];
        }
        if(LotteryEnum.XY28.getCode().equals(code)){
            result = getXy28OpenCode(result);
        }
        return result;
    }

    public String getXy28OpenCode(String openCode) {
        LOG.info("北京快乐8开奖号码:{0}",openCode);
        String[] split = openCode.split(",");
        Arrays.sort(split);
        StringBuffer buffer = new StringBuffer();
        if(split.length!=20){
            LOG.error("彩票采集任务失败，北京快乐８的开奖位数有错");
            return buffer.toString();
        }
        int oneNum =0;
        int twoNum=0;
        int threeNum =0;
        for (int i=0;i<split.length;i++) {
            if(i<6){
                oneNum  += Integer.parseInt(split[i]);
            }else if(i<12){
                twoNum  += Integer.parseInt(split[i]);
            }else if(i<18){
                threeNum  += Integer.parseInt(split[i]);
            }
        }
        String one = String.valueOf(oneNum);
        String two = String.valueOf(twoNum);
        String three = String.valueOf(threeNum);
        buffer.append(one.substring(one.length()-1)+","+two.substring(two.length()-1)+","+three.substring(three.length()-1));
        LOG.info("幸运28开奖号码:{0}",buffer.toString());
        return buffer.toString();
    }

    /**
     * 根据开奖号码获取开奖号码备注，暂时保存六合彩生肖,PK10牛牛,PK10百家乐
     * @return
     */
    private String getOpenCodeMemo(String code,String openCode){
        String result = null;
        if(StringTool.isNotEmpty(code) && StringTool.isNotEmpty(openCode)){
            if(LotteryEnum.HKLHC.getCode().equals(code)){
                List<String> zodicList = CacheBase.getLotteryLhcZodiacList(StringTool.split(openCode,","));
                result = StringTool.join(zodicList,",");
            } else if (LotteryEnum.PK10BJL.getCode().equals(code)) {
                result = JsonTool.toJson(BjlResultFormatTool.formatOpenCode(openCode));
            } else if (LotteryEnum.PK10NN.getCode().equals(code)) {
                result = JsonTool.toJson(NnResultFormatTool.formatOpenCode(openCode));
            }
        }
        return result;
    }

}