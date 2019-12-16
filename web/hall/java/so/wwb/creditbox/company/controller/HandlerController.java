package so.wwb.creditbox.company.controller;

import org.soul.commons.data.json.JsonTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.bean.HttpCodeEnum;
import so.wwb.creditbox.model.bean.WebJson;
import so.wwb.creditbox.model.common.HttpCode;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.lottery.controller.BaseLotteryController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/Handler")
public class HandlerController extends BaseLotteryController{
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";




    @RequestMapping(value = "QueryHandler")
    @ResponseBody
    protected String queryHandler(SiteLotteryOddsVo vo, SysUserExtendVo userExtendVo,HttpServletRequest request, HttpServletResponse response, Model model) {

//        //信用额
//        if("get_ad".equals(vo.getAction())){
//            userExtendVo.setDataSourceId(SessionManager.getSiteId());
//            userExtendVo.getSearch().setId(SessionManager.getUserId());
//            userExtendVo = ServiceTool.sysUserExtendService().get(userExtendVo);
//
//            Double credits = userExtendVo.getResult().getCredits();
//
//            WebJson webJson = new WebJson();
//            webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
//            webJson.setTipinfo("");
//
//            Map<String, Object> map = new HashMap<>();
//            map.put("type","get_ad");
//            map.put("ad"," [\n" +
//                    "      {\n" +
//                    "        \"title\": \"聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!\",\n" +
//                    "        \"time\": \"2019/10/20 0:00:00\",\n" +
//                    "        \"u_type\": \"0\"\n" +
//                    "      }\n" +
//                    "    ]");
//
//            Map<String, Object> map1 = new HashMap<>();
//            map1.put("kind","");
//            map1.put("name","");
//            map1.put("credit","");
//            map1.put("usable_credit","");
//            map1.put("profit","");
//            map1.put("iscash","");
//            map.put("game_2",map1);
////            webJson.setData(map);
//
//
//        }
        WebJson webJson = new WebJson();
        webJson.setSuccess(HttpCodeEnum.SUCCESS.getCode());
        webJson.setTipinfo("");
        Map<String, Object> dataMap = new LinkedHashMap<>();

        dataMap.put("type","get_ad");
        Map[] adArray=new HashMap[1];
        HashMap<Object, Object> adMap = new HashMap<>();
        adMap.put("title","聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!");
        adMap.put("time","2019/10/20 0:00:00");
        adMap.put("u_type","0");
        adArray[0]=adMap;
        dataMap.put("ad",adArray);

        VSiteUser vSiteUser = getvSiteUserCreditInfo();
        HashMap<Object, Object> gameMap = new HashMap<>();
        gameMap.put("kind",SessionManager.getSysUserExtend().getHandicap());
        gameMap.put("name","快彩");
        gameMap.put("credit",vSiteUser.getCredits());
        gameMap.put("usable_credit",vSiteUser.getCredits() - vSiteUser.getUsableCredit());
        gameMap.put("profit",vSiteUser.getToDayProfit());
        gameMap.put("iscash","0");
        dataMap.put("game_2",gameMap);
        webJson.setData(dataMap);
        return JsonTool.toJson(webJson);
//        return "{\n" +
//                "  \"success\": 200,\n" +
//                "  \"data\": {\n" +
//                "    \"type\": \"get_ad\",\n" +
//                "    \"ad\": [\n" +
//                "      {\n" +
//                "        \"title\": \"聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!\",\n" +
//                "        \"time\": \"2019/10/20 0:00:00\",\n" +
//                "        \"u_type\": \"0\"\n" +
//                "      }\n" +
//                "    ],\n" +
//                "    \"game_2\": {\n" +
//                "      \"kind\": \"A\",\n" +
//                "      \"name\": \"快彩\",\n" +
//                "      \"credit\": \"10000000\",\n" +
//                "      \"usable_credit\": 100000,\n" +
//                "      \"profit\": \"0\",\n" +
//                "      \"iscash\": \"0\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"tipinfo\": \"\"\n" +
//                "}";
    }
}
