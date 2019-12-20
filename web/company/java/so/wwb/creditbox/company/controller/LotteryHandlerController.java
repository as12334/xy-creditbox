package so.wwb.creditbox.company.controller;

import org.apache.poi.ss.formula.functions.Odd;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.bean.HttpCodeEnum;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.common.HidTool;
import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.so.LotteryBetOrderSo;
import so.wwb.creditbox.model.company.lottery.so.SiteLotteryOddsSo;
import so.wwb.creditbox.model.company.lottery.vo.LotteryBetOrderListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsListVo;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryOpTypeEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryOrderStatusEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.hall.HandlerForm;
import so.wwb.creditbox.model.hall.LotteryErrorCode;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.lottery.controller.BaseLotteryController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class LotteryHandlerController extends BaseLotteryController{
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";



    @RequestMapping(value = "/{code}/handler/handler")
    @ResponseBody
    protected String handler(@PathVariable String code, HandlerForm form, HttpServletRequest request, HttpServletResponse response, Model model ) {
        form.setSessionUser(SessionManager.getSysUserExtend());




        WebJson webJson = new WebJson();
        LotteryErrorCode errorCode = new LotteryErrorCode();
        LotteryEnum lotteryEnum = EnumTool.enumOf(LotteryEnum.class, code);
        if(lotteryEnum == null){
            webJson.setSuccess(HttpCodeEnum.ERROR.getCode());
            webJson.setTipinfo("暂无该彩种!");
            return JsonTool.toJson(webJson);
        }

        if(StringTool.isNotBlank(form.getPlaypage())){
            String[] split = form.getPlaypage().split("_");
            if(split.length==2){
                form.setPlaypage(code+"_"+split[1]);
            }
        }else {
            form.setPlaypage(code+"_lmp");
        }




        if(StringTool.isBlank(form.getPlaypage())){
            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            webJson.setTipinfo("");
            return JsonTool.toJson(webJson);
        }


        //最近五期期的已开奖结果 start
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setCode(lotteryEnum.getCode());
        List<LotteryResult> openResults = ServiceTool.lotteryResultService().queryFiveRecentOpenResult(lotteryResultVo);
        //最近五期期的已开奖结果 end

        //赔率变更
        if("operate_adds".equals(form.getAction())){
            if(form.getOddOpTypeEnum() != null){

                SiteLotteryOddsVo siteLotteryOddsVo = new SiteLotteryOddsVo();
                siteLotteryOddsVo._setDataSourceId(SessionManager.getSiteId());
                siteLotteryOddsVo.setForm(form);
                webJson = ServiceTool.siteLotteryOddsService().opOdds(siteLotteryOddsVo);



                return JsonTool.toJson(webJson);
            }
            else {
             //参数无效
            }

        }
        else if("get_oddsinfo".equals(form.getAction())){

            //封盘的时候禁止下注
            Boolean isOpen = false;

            Map<String, Object> dataMap = new LinkedHashMap<>();
            dataMap.put("type","get_oddsinfo");
            dataMap.put("playpage", form.getPlaypage());
            dataMap.put("credit","111");
            //todo 已用额度后面添加
            dataMap.put("usable_credit",100000);
            LotteryResult lotteryResult = getHandicapOpen(lotteryEnum.getCode());
            //开奖时间
            dataMap.put("drawopen_time",DateTool.formatDate(lotteryResult.getOpenTime(),SessionManagerBase.getTimeZone(),DateTool.HH_mm_ss));

            //进入封盘时间
            if(new Date().getTime()<lotteryResult.getCloseTime().getTime()){
                isOpen = true;
                dataMap.put("openning","y");
                dataMap.put("stop_time","00:"+(lotteryResult.getLeftTime())/60+":"+(lotteryResult.getLeftTime())%60);
            }
            else {
                dataMap.put("openning","n");
                Long l = DateTool.minutesBetween(lotteryResult.getOpenTime(),new Date() );
                dataMap.put("stop_time","00:"+l/60+":"+l%60);
            }
            if (DateTool.minutesBetween(lotteryResult.getOpenTime(),new Date())> 20 ) {
                dataMap.put("isopen","1");
                lotteryResult.setCloseTime(new Date());
                lotteryResult.setOpeningTime(DateTool.addMinutes(lotteryResult.getOpenTime(),-20));
            }
            else {
                dataMap.put("isopen","1");
            }

            dataMap.put("nn",lotteryResult.getExpect());
            dataMap.put("p_id",lotteryResult.getId());
            //TODO 今日输赢
            dataMap.put("profit","0");
            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            webJson.setTipinfo("");

            dataMap.put("upopenphase",openResults.get(0).getExpect());
            dataMap.put("upopennumber",openResults.get(0).getOpenCode());



            LotteryBetOrderListVo lotteryBetOrderListVo = new LotteryBetOrderListVo();
            lotteryBetOrderListVo._setDataSourceId(SessionManager.getSiteId());
            LotteryBetOrderSo search = lotteryBetOrderListVo.getSearch();
//            search.setHid(HidTool.getBranchHid(form.getSessionUser().getHid()));
            search.setCode(lotteryEnum.getCode());
            search.setExpect(lotteryResult.getExpect());
            search.setSortTypes(form.getPlayid().split(","));
            int i = Integer.parseInt(form.getSessionUser().getUserType().substring(0, 1));
            search.setOccupyColumn("occupy"+i);
            search.setRebateColumn("rebate"+(i+1));

            List<SiteLotteryOdds> lotteryOdds = ServiceTool.lotteryBetOrderService().searchOddsInfo(lotteryBetOrderListVo);
            //赔率 start
            Map<Object, Object> playOddsMap = new LinkedHashMap<>();
            LinkedHashMap<Object, Object> szszMap = new LinkedHashMap<>();
            LinkedHashMap<Object, Object> szszCountMap = new LinkedHashMap<>();
            String[] split = form.getPlayid().split(",");
            for (SiteLotteryOdds odd : lotteryOdds) {
                Map<Object, Object> oddsMap = new LinkedHashMap<>();
                oddsMap.put("pl",isOpen?odd.getOddA()+"":"-");
                oddsMap.put("plx","");
                //如果是公司用户，最大
                if(form.getSessionUser().getSubsysCode().equals(SubSysCodeEnum.COMPANY.getCode())){
                    oddsMap.put("maxpl",odd.getMaxOdd()+"");
                }
                else {
//                    oddsMap.put("maxpl",odd.getCOdd(form.getSessionUser())+"");
                }

                oddsMap.put("minpl",odd.getMinOdd()+"");
                oddsMap.put("is_open",odd.getOddClose());
                playOddsMap.put(odd.getSort(),oddsMap);

                //实占需占
                szszMap.put(odd.getSort(),odd.getSzszAmount()+"");
            }

//            // 注数
//            'AmountNumber': 0,
//            // 注额
//            'AmountValue': 0,
//            // 盈亏
//            'WinValue': 0,
//            // 退水
//            'RecValue': 0,
//            // 补货
//            'RepValue': 0

            dataMap.put("play_odds",playOddsMap);
            dataMap.put("szsz_amount",szszMap);


            lotteryBetOrderListVo.getSearch().setExpect(lotteryResult.getExpect());
            lotteryBetOrderListVo.getSearch().setStatus(LotteryOrderStatusEnum.PENDING.getCode());
            lotteryBetOrderListVo.getSearch().setCode(lotteryEnum.getCode());
            lotteryBetOrderListVo = ServiceTool.lotteryBetOrderService().sumBetCode(lotteryBetOrderListVo);

            for(LotteryBetOrder order:lotteryBetOrderListVo.getResult()){
                szszCountMap.put(order.getBetCode(),order.getBetAmount()+"");
            }
            dataMap.put("szsz_amount_count",szszCountMap);

            dataMap.put("abovevalid","");
            dataMap.put("maxidvalid","0");
            dataMap.put("cleardata","0");
            //赔率 end
            webJson.setData(dataMap);

            return JsonTool.toJson(webJson);
        }
        else if("get_clyl".equals(form.getAction())){

            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_clyl\",\n" +
                    "    \"dropball\": [\n" +
                    "      {\n" +
                    "        \"Key\": \"01\",\n" +
                    "        \"Value\": \"6\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"02\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"03\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"04\",\n" +
                    "        \"Value\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"05\",\n" +
                    "        \"Value\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"06\",\n" +
                    "        \"Value\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"07\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"08\",\n" +
                    "        \"Value\": \"1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"09\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"10\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"11\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"12\",\n" +
                    "        \"Value\": \"6\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"13\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"14\",\n" +
                    "        \"Value\": \"0\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"15\",\n" +
                    "        \"Value\": \"1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"16\",\n" +
                    "        \"Value\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"17\",\n" +
                    "        \"Value\": \"1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"18\",\n" +
                    "        \"Value\": \"1\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"19\",\n" +
                    "        \"Value\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"Key\": \"20\",\n" +
                    "        \"Value\": \"2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"lmcl\": [\n" +
                    "      {\n" +
                    "        \"cl_name\": \"虎\",\n" +
                    "        \"cl_num\": \"6\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 小\",\n" +
                    "        \"cl_num\": \"5\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第4球 - 單\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 尾小\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 大\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 合雙\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 尾小\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 大\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第1球 - 合雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第2球 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 合雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 尾小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 合單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 尾大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 合單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }
        else if("get_opennumber".equals(form.getAction())){
            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            Map<String, Object> dataMap = new LinkedHashMap<>();
            Map<String, Object> opennumberMap = new LinkedHashMap<>();
            opennumberMap.put("profit","111");
            opennumberMap.put("upopenphase",openResults.get(0).getExpect());
            opennumberMap.put("upopennumber",openResults.get(0).getOpenCode());
            dataMap.put("type","get_opennumber");
            dataMap.put("opennumber",opennumberMap);



            webJson.setData(dataMap);
            webJson.setTipinfo("");

            return JsonTool.toJson(webJson);
        }
        return null;

    }
    /**
     * 获取彩票当前盘口信息(开奖)
     */
    public LotteryResult getHandicapOpen(String code) {
        List<LotteryResult> lotteryResultList = CacheBase.getLotteryResult(code);
        Date curDate = new Date();
        for (LotteryResult lotteryResult : lotteryResultList) {
            if (curDate.getTime() <= lotteryResult.getOpenTime().getTime()) {
                Long leftTime = DateTool.secondsBetween(lotteryResult.getCloseTime(), curDate);
                lotteryResult.setLeftTime(leftTime);
                lotteryResult.setLeftOpenTime(DateTool.secondsBetween(lotteryResult.getOpeningTime(), curDate));
                return lotteryResult;
            }
        }
        return null;
    }
}
