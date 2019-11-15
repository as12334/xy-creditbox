package so.wwb.creditbox.service.manager.gather;

import org.soul.commons.collections.MapTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 17-4-14.
 */
public class Kai168CaiGatherHandle extends AbstractLotteryGatherHandle {

    private final static int GMT = 8;

    private static final Log LOG = LogFactory.getLog(Kai168CaiGatherHandle.class);

    @Override
    protected LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response) {
        return null;
    }

    @Override
    protected LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response) {
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        LotteryResult lotteryResult = new LotteryResult();
        try {
            if (StringTool.isEmpty(response)) {
                LOG.error("采集结果不成功,采集参数:{0},采集结果为:{1}", JsonTool.toJson(gatherParam), response);
                return lotteryResultVo;
            }
            Map openResult = JsonTool.fromJson(response, Map.class);
            if (MapTool.isEmpty(openResult)) {
                LOG.error("采集结果不成功,采集参数:{0},采集结果为:{1}", JsonTool.toJson(gatherParam), response);
                return lotteryResultVo;
            }
            int errorCode = (int) openResult.get("errorCode");
            String message = (String) openResult.get("message");
            String success = "操作成功";
            if (errorCode == 0 && success.equals(message)) {
                HashMap result = (HashMap) openResult.get("result");
                int businessCode = (int) result.get("businessCode");
                message = (String) result.get("message");
                if (businessCode == 0 && success.equals(message)) {
                    HashMap data = (HashMap) result.get("data");
                    String openCode = (String) data.get("preDrawCode");
                    String nextOpenTime = (String) data.get("drawTime");
                    lotteryResult.setType(gatherParam.getType());
                    String code = gatherParam.getCode();
                    lotteryResult.setCode(code);
                    Object preDrawIssue = data.get("preDrawIssue");
                    String expect = "";
                    if (preDrawIssue instanceof Long) {
                        expect = String.valueOf((long) preDrawIssue);
                    } else {
                        expect = String.valueOf(preDrawIssue);
                    }
                    Object drawIssue = data.get("drawIssue");
                    String nextexpect = "";
                    if (preDrawIssue instanceof Long) {
                        nextexpect = String.valueOf((long) drawIssue);
                    } else {
                        nextexpect = String.valueOf(drawIssue);
                    }
                    if (LotteryEnum.BJKL8.getCode().equals(gatherParam.getCode())) {
                        int length = openCode.split(",").length;
                        openCode = (length == 21) ? openCode.substring(0, openCode.lastIndexOf(",")) : "";
                    }
                    lotteryResultVo.setNextExpect(nextexpect);
                    Date nextOpenTime1 = DateTool.parseDate(nextOpenTime, DateTool.yyyy_MM_dd_HH_mm_ss);
                    lotteryResultVo.setNextOpenTime(DateTool.addHours(nextOpenTime1, -GMT));
                    StringBuilder buf = new StringBuilder(expect.length() + 1);
                    expect = handleExpectAppend(code, expect, buf);
                    lotteryResult.setExpect(expect);
                    lotteryResult.setOpenCode(openCode);
                    lotteryResult.setOpenTime(new Date());
                    lotteryResult.setType(gatherParam.getType());
                }
            } else {
                LOG.error("采集结果不成功,采集结果为:{0}", response);
            }
            lotteryResultVo.setResult(lotteryResult);
        } catch (Exception e) {
            LOG.error("采集结果不成功,采集结果为:{0}", response);
        }
        return lotteryResultVo;
    }

    /**
     * 广东快乐10，新疆时时彩只有10位,如：2017042596 -->20170425096
     *
     * @param code
     * @param expect
     * @param buf
     * @return
     */
    private String handleExpectAppend(String code, String expect, StringBuilder buf) {
        if (LotteryEnum.XJSSC.getCode().equals(code) || LotteryEnum.GDKL10.getCode().equals(code)) {
            buf.append(expect.substring(0, 8));
            buf.append("0");
            buf.append(expect.substring(8, 10));
            expect = buf.toString();
        }
        return expect;
    }


    public static void main(String[] args) {
        String expect = "2017042596";
        StringBuilder buf = new StringBuilder(expect.length() + 1);
        buf.append(expect.substring(0, 8));
        buf.append("0");
        buf.append(expect.substring(8, 10));
        System.out.println(buf.toString());


        String openCode = "01,05,08,11,19,20,22,23,29,32,33,35,39,41,43,52,57,69,70,78,01";
        int length = openCode.split(",").length;
        if (length == 21) {
            System.out.println(21);
        }

        String xml = "2017082515";
        System.out.println(xml.substring(0, 8));
        System.out.println(xml.substring(9, xml.length()));


        System.out.println(openCode.lastIndexOf(","));
        System.out.println(openCode.substring(0, openCode.lastIndexOf(",")));
//        String response ="{\"errorCode\":0,\"message\":\"操作成功\",\"result\":{\"businessCode\":0,\"message\":\"操作成功\",\"data\":{\"preDrawCode\":\"9,7,1,7,2\",\"drawIssue\":20170413081,\"drawTime\":\"2017-04-13 19:30:35\",\"preDrawDate\":\"2017-04-13 00:00:00\",\"preDrawIssue\":20170413080,\"drawCount\":80,\"preDrawTime\":\"2017-04-13 19:20:35\",\"sumBigSmall\":0,\"sumNum\":26,\"sumSingleDouble\":1,\"fifthNum\":2,\"firstNum\":9,\"fourthNum\":7,\"secondNum\":7,\"thirdNum\":1,\"behindThree\":0,\"betweenThree\":3,\"dragonTiger\":0,\"fifthBigSmall\":1,\"fifthSingleDouble\":1,\"firstBigSmall\":0,\"firstSingleDouble\":0,\"fourthBigSmall\":0,\"fourthSingleDouble\":0,\"lastThree\":1,\"sdrawCount\":\"\",\"secondBigSmall\":0,\"secondSingleDouble\":0,\"thirdBigSmall\":1,\"thirdSingleDouble\":0,\"id\":15012,\"status\":0,\"lotName\":\"重庆时时彩\",\"iconUrl\":\"http://webapp.1680180.com/images/icon/3x/cqssc@3x.png\",\"lotCode\":10002,\"shelves\":0,\"totalCount\":120,\"serverTime\":\"2017-04-13 19:23:31\",\"index\":100}}}";
//        Map openResult = JsonTool.fromJson(response, Map.class);
//        int errorCode = (int) openResult.get("errorCode");
//        String  message = (String) openResult.get("message");
//        if(errorCode==0&&"操作成功".equals(message)){
//            HashMap result = (HashMap) openResult.get("result");
//            int businessCode = (int) result.get("businessCode");
//            message = (String) result.get("message");
//            if(businessCode==0&&"操作成功".equals(message)){
//                HashMap data = (HashMap) result.get("data");
//                String expect = (String) data.get("preDrawIssue");
//                String openCode = (String) data.get("preDrawCode");
//                String openTime =(String) data.get("drawTime");
//            }
//        }
    }
}
