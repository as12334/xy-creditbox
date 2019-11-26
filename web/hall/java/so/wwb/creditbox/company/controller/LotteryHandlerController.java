package so.wwb.creditbox.company.controller;

import com.alibaba.fastjson.JSONArray;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.bean.Data;
import so.wwb.creditbox.model.bean.HttpCodeEnum;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.session.Session;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.HidTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.*;

@Controller
@RequestMapping("/handler")
public class LotteryHandlerController {
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";




    @RequestMapping(value = "handler")
    @ResponseBody
    protected String handler(SiteLotteryOddsVo vo, HttpServletRequest request, HttpServletResponse response, Model model ) {
        WebJson webJson = new WebJson();
        if(StringTool.isBlank(vo.getPlaypage())){
            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            webJson.setTipinfo("");
            return JsonTool.toJson(webJson);
        }
        SysUserExtend sessionUser = SessionManager.getSysUserExtend();


        Cache.refreshSiteLotteryOdds(HidTool.getBranchHid(sessionUser.getHid()),LotteryEnum.BJPK10.getCode());
        Cache.refreshSiteLotteryRebates(HidTool.getBranchHid(sessionUser.getHid()),LotteryEnum.BJPK10.getCode());


        String prefix ;
        LotteryEnum lotteryEnum = null;

        if(StringTool.isNotBlank(vo.getPlaypage())){
            prefix = vo.getPlaypage().substring(0, vo.getPlaypage().indexOf("_"));
            lotteryEnum = EnumTool.enumOf(LotteryEnum.class, prefix);
        }


        //最近一期的开奖结果 start
        List<LotteryResult> results = ServiceTool.lotteryResultService().queryRecentResult(new LotteryResultVo());
        Map<Object, LotteryResult> objectLotteryResultMap = CollectionTool.toEntityMap(results, LotteryResult.PROP_CODE);
        //最近一期的开奖结果 end

        //最近五期期的已开奖结果 start
        LotteryResultVo lotteryResultVo = new LotteryResultVo();
        lotteryResultVo.getSearch().setCode(lotteryEnum.getCode());
        List<LotteryResult> openResults = ServiceTool.lotteryResultService().queryFiveRecentOpenResult(lotteryResultVo);
        //最近五期期的已开奖结果 end



        //最近五期的开奖结果 start
        List<LotteryResult> lotteryResult5 = Cache.getLotteryResult(LotteryEnum.XYFT.getCode());
        //最近五期的开奖结果 end
        if("get_openball".equals(vo.getAction())){
            HashMap<String, String> phaseinfoMap = new HashMap<>();
            phaseinfoMap.put("intervaltime","5分鐘");
            phaseinfoMap.put("begintime","13:04");
            phaseinfoMap.put("endtime","04:04");
            phaseinfoMap.put("sold","104");
            phaseinfoMap.put("surplus","76");

            HashMap<String, Object> dataMap = new HashMap<>();
            dataMap.put("phaseinfo",phaseinfoMap);
            dataMap.put("type","get_openball");
            dataMap.put("draw_phase", openResults.get(0).getExpect());
            dataMap.put("draw_result", openResults.get(0).getOpenCode().split(","));

            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            webJson.setTipinfo("");
            webJson.setData(dataMap);
            return JsonTool.toJson(webJson);
        }

        else if("get_oddsinfo".equals(vo.getAction())){


            String[] split = vo.getPlayid().split(",");
            Map<String, Object> playOddsMap = new LinkedHashMap<>();
            for (String s : split) {
                Map<String, SiteLotteryOdds> siteLotteryOdds = Cache.getSiteLotteryOdds(HidTool.getBranchHid(sessionUser.getHid()), lotteryEnum.getCode());
                Map<String, SiteLotteryRebates> siteLotteryRebates = Cache.getSiteLotteryRebates(HidTool.getBranchHid(sessionUser.getHid()), lotteryEnum.getCode());


                SiteLotteryOdds Odd = siteLotteryOdds.get(s);
                SiteLotteryRebates rebates = siteLotteryRebates.get(s);


                Map<String, Object> oddsMap = new LinkedHashMap<>();
                oddsMap.put("pl",Odd.getOddA()+"");
                oddsMap.put("plx","");
                oddsMap.put("min_amount",rebates.getMinBet()+"");
                oddsMap.put("max_amount",rebates.getMaxBet()+"");
                //超出派彩額度
                oddsMap.put("top_amount","10000000");
                //下注金額不能大於單期額度
                oddsMap.put("dq_max_amount",rebates.getMaxExpectBet()+"");
                oddsMap.put("dh_max_amount","100000");

                playOddsMap.put(s,oddsMap);








            }
            Map<String, Object> dataMap = new LinkedHashMap<>();


            dataMap.put("play_odds",playOddsMap);


            dataMap.put("type","get_oddsinfo");
            dataMap.put("playpage",vo.getPlaypage());
            dataMap.put("credit",sessionUser.getCredits());
            //todo 已用额度后面添加
            dataMap.put("usable_credit",100000);

            dataMap.put("isopen","1");

            LotteryResult lotteryResult = getHandicap(lotteryEnum.getCode());
            //开奖时间
            dataMap.put("drawopen_time",DateTool.formatDate(lotteryResult.getOpenTime(),SessionManagerBase.getTimeZone(),DateTool.HH_mm_ss));
            //封盘倒计时


            //进入封盘时间
            if(new Date().getTime()<lotteryResult.getCloseTime().getTime()){
                dataMap.put("openning","y");
                dataMap.put("stop_time","00:"+(lotteryResult.getLeftTime())/60+":"+(lotteryResult.getLeftTime())%60);
            }
            else {
                dataMap.put("openning","n");
                Long l = DateTool.secondsBetween(lotteryResult.getOpenTime(),new Date() );
                dataMap.put("stop_time","00:"+l/60+":"+l%60);
            }




            dataMap.put("nn",lotteryResult.getExpect());
            dataMap.put("p_id","143910");
            //TODO 今日输赢
            dataMap.put("profit","");
            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
            webJson.setTipinfo("");
            webJson.setData(dataMap);



            System.out.println(JsonTool.toJson(webJson));
            return JsonTool.toJson(webJson);
        }
        else if("get_ranklist".equals(vo.getAction())){
            return "{" +
                    "  \"success\": 200," +
                    "  \"data\": {" +
                    "    \"type\": \"get_ranklist\"," +
                    "    \"playpage\": \"xyft_lmp\"," +
                    "    \"jqkj\": [" +
                    "      {" +
                    "        \"phase\": \"20191124170\"," +
                    "        \"play_open_date\": \"2019/11/25 3:14:00\"," +
                    "        \"draw_num\": [" +
                    "          \"09\"," +
                    "          \"06\"," +
                    "          \"08\"," +
                    "          \"07\"," +
                    "          \"04\"," +
                    "          \"02\"," +
                    "          \"05\"," +
                    "          \"03\"," +
                    "          \"10\"," +
                    "          \"01\"" +
                    "        ]," +
                    "        \"total\": [" +
                    "          \"15\"," +
                    "          \"<span class=\\\"red\\\">大</span>\"," +
                    "          \"<span class=\\\"blue\\\">單</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"" +
                    "        ]" +
                    "      }," +
                    "      {" +
                    "        \"phase\": \"20191124169\"," +
                    "        \"play_open_date\": \"2019/11/25 3:09:00\"," +
                    "        \"draw_num\": [" +
                    "          \"09\"," +
                    "          \"08\"," +
                    "          \"01\"," +
                    "          \"03\"," +
                    "          \"04\"," +
                    "          \"05\"," +
                    "          \"10\"," +
                    "          \"06\"," +
                    "          \"07\"," +
                    "          \"02\"" +
                    "        ]," +
                    "        \"total\": [" +
                    "          \"17\"," +
                    "          \"<span class=\\\"red\\\">大</span>\"," +
                    "          \"<span class=\\\"blue\\\">單</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"" +
                    "        ]" +
                    "      }," +
                    "      {" +
                    "        \"phase\": \"20191124168\"," +
                    "        \"play_open_date\": \"2019/11/25 3:04:00\"," +
                    "        \"draw_num\": [" +
                    "          \"01\"," +
                    "          \"03\"," +
                    "          \"07\"," +
                    "          \"05\"," +
                    "          \"04\"," +
                    "          \"06\"," +
                    "          \"10\"," +
                    "          \"02\"," +
                    "          \"08\"," +
                    "          \"09\"" +
                    "        ]," +
                    "        \"total\": [" +
                    "          \"4\"," +
                    "          \"<span class=\\\"blue\\\">小</span>\"," +
                    "          \"<span class=\\\"red\\\">雙</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"" +
                    "        ]" +
                    "      }," +
                    "      {" +
                    "        \"phase\": \"20191124167\"," +
                    "        \"play_open_date\": \"2019/11/25 2:59:00\"," +
                    "        \"draw_num\": [" +
                    "          \"05\"," +
                    "          \"08\"," +
                    "          \"09\"," +
                    "          \"01\"," +
                    "          \"02\"," +
                    "          \"06\"," +
                    "          \"03\"," +
                    "          \"10\"," +
                    "          \"07\"," +
                    "          \"04\"" +
                    "        ]," +
                    "        \"total\": [" +
                    "          \"13\"," +
                    "          \"<span class=\\\"red\\\">大</span>\"," +
                    "          \"<span class=\\\"blue\\\">單</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"" +
                    "        ]" +
                    "      }," +
                    "      {" +
                    "        \"phase\": \"20191124166\"," +
                    "        \"play_open_date\": \"2019/11/25 2:54:00\"," +
                    "        \"draw_num\": [" +
                    "          \"02\"," +
                    "          \"09\"," +
                    "          \"08\"," +
                    "          \"03\"," +
                    "          \"06\"," +
                    "          \"01\"," +
                    "          \"05\"," +
                    "          \"07\"," +
                    "          \"04\"," +
                    "          \"10\"" +
                    "        ]," +
                    "        \"total\": [" +
                    "          \"11\"," +
                    "          \"<span class=\\\"blue\\\">小</span>\"," +
                    "          \"<span class=\\\"blue\\\">單</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"," +
                    "          \"<span class=\\\"red\\\">虎</span>\"," +
                    "          \"<span class=\\\"blue\\\">龍</span>\"" +
                    "        ]" +
                    "      }" +
                    "    ]," +
                    "    \"lmcl\": [" +
                    "      {" +
                    "        \"cl_name\": \"第四名 - 單\"," +
                    "        \"cl_num\": \"5\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"第五名 - 雙\"," +
                    "        \"cl_num\": \"5\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"冠軍 - 單\"," +
                    "        \"cl_num\": \"4\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"第五名 - 小\"," +
                    "        \"cl_num\": \"4\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"第九名 - 大\"," +
                    "        \"cl_num\": \"4\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"冠軍 - 龍\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"冠軍 - 大\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"亞軍 - 雙\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"亞軍 - 大\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"第六名 - 小\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"第十名 - 小\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"冠亞軍和 - 大\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }," +
                    "      {" +
                    "        \"cl_name\": \"冠亞軍和 - 單\"," +
                    "        \"cl_num\": \"2\"" +
                    "      }" +
                    "    ]," +
                    "    \"cql\": {" +
                    "      \"title\": [" +
                    "        \"冠、亞軍和\"," +
                    "        \"冠、亞軍和 大小\"," +
                    "        \"冠、亞軍和 單雙\"" +
                    "      ]," +
                    "      \"content\": [" +
                    "        \"16,1|15,1|8,1|7,1|9,2|17,1|8,1|4,1|3,1|7,1|5,1|11,1|8,1|12,1|8,1|6,1|7,2|10,1|16,1|15,1|11,1|13,1|4,1|17,1|15,1\"," +
                    "        \"小,4|大,3|小,4|大,2|小,4|大,1|小,7|大,1|小,5|大,2|小,1|大,1|小,1|大,2\"," +
                    "        \"單,1|雙,2|單,2|雙,3|單,3|雙,1|單,1|雙,1|單,4|雙,2|單,4|雙,4|單,2|雙,2|單,3|雙,1|單,2\"" +
                    "      ]" +
                    "    }" +
                    "  }," +
                    "  \"tipinfo\": \"\"" +
                    "}";
        }
        else if("get_putinfo".equals(vo.getAction())){
            return "{" +
                    "  \"success\": 200," +
                    "  \"data\": {" +
                    "    \"type\": \"get_putinfo\"" +
                    "  }," +
                    "  \"tipinfo\": \"\"" +
                    "}";
        }
        else if("put_money".equals(vo.getAction())){
            return "{" +
                    "  \"success\": 200," +
                    "  \"data\": {" +
                    "    \"type\": \"get_putinfo\"" +
                    "  }," +
                    "  \"tipinfo\": \"下单成功\"" +
                    "}";
        }

        return "";

    }
    /**
     * 获取彩票当前盘口信息
     */
    public LotteryResult getHandicap(String code) {
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
