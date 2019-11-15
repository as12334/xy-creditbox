package so.wwb.creditbox.service.manager.gather;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryFhlmData;
import so.wwb.creditbox.model.manager.lottery.LotteryFhlmResult;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by marz on 19-4-1.
 */
public class FhlmGatherHandle extends AbstractLotteryGatherHandle {
    private static final Log LOG = LogFactory.getLog(FhlmGatherHandle.class);




    @Override
    protected LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response) {
        LotteryResultListVo resultVo = new LotteryResultListVo();
        if(StringTool.isBlank(response)){
            LOG.error("未采集到凤凰联盟开奖结果");
            return resultVo;
        }
        try {
            LotteryFhlmResult lotteryFhlmResult = JsonTool.fromJson(response, LotteryFhlmResult.class);
            if (lotteryFhlmResult == null || CollectionTool.isEmpty(lotteryFhlmResult.getList())) {
                LOG.error("凤凰联盟开奖结果为空");
                return resultVo;
            }
            List<LotteryFhlmData> list = lotteryFhlmResult.getList();
            List<LotteryResult> resultList = new ArrayList<>();
            for(LotteryFhlmData record : list){
                LotteryResult lotteryResult = new LotteryResult();
                String expect = getExpect(gatherParam.getCode(),record.getIssue());
                if (StringTool.isNotEmpty(gatherParam.getExpect())) {
                    if (expect.equals(gatherParam.getExpect())) {
                        lotteryResult = initFhlmData (gatherParam, record, expect);
                        resultList.add(lotteryResult);
                        break;
                    }
                } else {
                    lotteryResult = initFhlmData (gatherParam, record, expect);
                    resultList.add(lotteryResult);
                }
                resultList.add(lotteryResult);
            }
            resultVo.setResult(resultList);
        } catch (Exception e) {
            LOG.error(e,"凤凰联盟采集开奖结果错误");
        }
        return resultVo;
    }

    private LotteryResult initFhlmData (LotteryGatherParam gatherParam, LotteryFhlmData record, String expect) {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setCode(gatherParam.getCode());
        lotteryResult.setExpect(expect);
        String openCode = StringTool.join(",",record.getCode());
        openCode = getOpenCode(gatherParam.getCode(),openCode);
        lotteryResult.setOpenCode(openCode);
        return lotteryResult;
    }

    @Override
    protected LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        if(StringTool.isBlank(response)){
            LOG.error("未采集到凤凰联盟开奖结果");
            return lotteryResultVo;
        }
        try {
            LotteryFhlmResult lotteryFhlmResult = JsonTool.fromJson(response, LotteryFhlmResult.class);
            if (lotteryFhlmResult == null || CollectionTool.isEmpty(lotteryFhlmResult.getList())) {
                LOG.error("凤凰联盟开奖结果为空");
                return lotteryResultVo;
            }
            LotteryFhlmData data = lotteryFhlmResult.getList().get(0);

            LotteryResult result = new LotteryResult();
            result.setType(gatherParam.getType());
            result.setCode(gatherParam.getCode());
            result.setExpect(getExpect(gatherParam.getCode(),data.getIssue()));
            String openCode = StringTool.join(",",data.getCode());
            openCode = getOpenCode(gatherParam.getCode(),openCode);
            result.setOpenCode(openCode);
            result.setGatherTime(new Date());
            lotteryResultVo.setResult(result);
        } catch (Exception e) {
            LOG.error(e,"凤凰联盟采集开奖结果错误");
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
        if(LotteryEnum.CQSSC.getCode().equals(code) || LotteryEnum.HKLHC.getCode().equals(code) || LotteryEnum.HBK3.getCode().equals(code)
                || LotteryEnum.XYFT.getCode().equals(code)){
            result = "20"+sourceExpect;
        }else if(LotteryEnum.XJSSC.getCode().equals(code)){
            result = "20"+sourceExpect.substring(0,6)+"0"+sourceExpect.substring(6,sourceExpect.length());
        }else if(LotteryEnum.JSK3.getCode().equals(code)){
            result = sourceExpect.substring(2,sourceExpect.length());
        }else if(LotteryEnum.CQXYNC.getCode().equals(code) || LotteryEnum.GDKL10.getCode().equals(code)){
            result = sourceExpect.substring(0,8)+"0"+sourceExpect.substring(8,sourceExpect.length());
        }else if(LotteryEnum.GXK3.getCode().equals(code)){
            result = sourceExpect.substring(2,8) + "0" +sourceExpect.substring(8,sourceExpect.length());
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
        if (LotteryEnum.TCPL3.getCode().equals(code)) {
            result = sourceOpenCode.substring(0,5);
        }else if (LotteryEnum.BJPK10.getCode().equals(code)||LotteryEnum.XYFT.getCode().equals(code)) {
            result = getPk10OpenCode(sourceOpenCode);
        }else if(LotteryEnum.XY28.getCode().equals(code)){
            result = getXy28OpenCode(sourceOpenCode);
        }
        return result;
    }

    public String getPk10OpenCode(String openCode) {
        LOG.info("北京PK10开奖号码:{0}",openCode);
        String[] openCodes = openCode.split(",");
        String[] result = new String[openCodes.length];
        for (int i = 0; i < openCodes.length; i++){
            String code = openCodes[i];
            if(StringTool.isNotBlank(code)){
                if(code.trim().length() == 1){
                    code = "0"+code;
                }
                result[i] = code;
            }
        }
        return StringTool.join(",",result);
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

}