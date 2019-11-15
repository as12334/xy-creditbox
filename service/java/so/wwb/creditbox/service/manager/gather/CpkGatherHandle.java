package so.wwb.creditbox.service.manager.gather;

import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.*;

/**
 * @author: rambo
 * @Description: 彩票控采集
 * @CreateDate: 2019-04-21 上午11:44
 */
public class CpkGatherHandle extends AbstractLotteryGatherHandle {
    private static final Log LOG = LogFactory.getLog(CpkGatherHandle.class);




    @Override
    protected LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response) {
        LotteryResultListVo resultVo = new LotteryResultListVo();
        if(StringTool.isBlank(response)){
            LOG.error("未采集到彩票控开奖结果");
            return resultVo;
        }
        try {
            Map<String ,Map<String,String>> map = JsonTool.fromJson(response, Map.class);
            if (MapTool.isEmpty(map)) {
                resultVo.setSuccess(false);
                resultVo.setErrMsg("未采集到补采数据");
                LOG.error("彩票控开奖结果为空");
                return resultVo;
            }
            List<LotteryResult> resultList = new ArrayList<>();
            for (Map.Entry entry : map.entrySet()) {
                LotteryResult lotteryResult;
                String expect = getRealExpect(gatherParam.getCode(),(String) entry.getKey());
                if (StringTool.isNotEmpty(gatherParam.getExpect())) {
                    if (expect.equals(gatherParam.getExpect())) {
                        lotteryResult = initCpkData (gatherParam, entry, expect);
                        resultList.add(lotteryResult);
                        break;
                    }
                } else {
                    lotteryResult = initCpkData (gatherParam, entry, expect);
                    resultList.add(lotteryResult);
                }
            }
            resultVo.setResult(resultList);
        } catch (Exception e) {
            LOG.error(e,"彩票控采集开奖结果错误");
        }
        return resultVo;
    }

    private LotteryResult initCpkData (LotteryGatherParam gatherParam, Map.Entry entry, String expect) {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setCode(gatherParam.getCode());
        lotteryResult.setExpect(expect);
        Map data = (Map)entry.getValue();
        String openCode = (String) data.get("number");
        openCode = getOpenCode(gatherParam.getCode(),openCode);
        lotteryResult.setOpenCode(openCode);
        return lotteryResult;
    }


    @Override
    protected LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        if(StringTool.isBlank(response)){
            LOG.error("未采集到彩票控开奖结果");
            return lotteryResultVo;
        }
        try {
            Map map = JsonTool.fromJson(response, Map.class);
            if (MapTool.isEmpty(map)) {
                LOG.error("彩票控开奖结果为空");
                return lotteryResultVo;
            }
            String expect = gatherParam.getExpect();
            String apiExpect = getExpect (gatherParam.getCode(), expect);
            Map data = (Map) map.get(apiExpect);

            if (data == null) {
                LOG.error("彩票控开奖结果为空,期数:{0}",expect);
                return lotteryResultVo;
            }

            if (data.get("number") == null) {
                LOG.error("彩票控开奖结果为空,期数:{0}",expect);
                return lotteryResultVo;
            }

            String openCode = (String) data.get("number");
            openCode = getOpenCode (gatherParam.getCode(), openCode);
            LotteryResult result = new LotteryResult();
            result.setType(gatherParam.getType());
            result.setCode(gatherParam.getCode());
            result.setExpect(expect);
            result.setOpenCode(openCode);
            result.setGatherTime(new Date());
            lotteryResultVo.setResult(result);
        } catch (Exception e) {
            LOG.error(e,"彩票控采集开奖结果错误");
        }
        return lotteryResultVo;
    }

    private String getRealExpect (String code, String apiExpect) {
        String result = apiExpect;
        if (LotteryEnum.GDKL10.getCode().equals(code) || LotteryEnum.XJSSC.getCode().equals(code)) {
            result = apiExpect.substring(0,apiExpect.length() - 2) + "0" + apiExpect.substring(apiExpect.length() - 2);
        } else if (LotteryEnum.CQXYNC.getCode().equals(code)) {
            result = "20" + apiExpect;
        }
        return result;
    }

    /**
     * 根据code获取格式化期数
     * @param code
     * @param sourceExpect
     * @return
     */
    private String getExpect(String code,String sourceExpect){
        String result = sourceExpect;
        if (LotteryEnum.GDKL10.getCode().equals(code) || LotteryEnum.XJSSC.getCode().equals(code)) {
            result = sourceExpect.substring(0,sourceExpect.length() - 3) + sourceExpect.substring(sourceExpect.length() - 2,sourceExpect.length());
        } else if (LotteryEnum.CQXYNC.getCode().equals(code)) {
            result = sourceExpect.substring(2,sourceExpect.length());
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
        if (LotteryEnum.BJKL8.getCode().equals(code)) {
            result = sourceOpenCode.substring(0,sourceOpenCode.length() - 3);
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
        openCode = openCode.substring(0,openCode.length() - 3);
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