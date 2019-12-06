package so.wwb.creditbox.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/Handler")
public class HandlerController {
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


        return "{\n" +
                "  \"success\": 200,\n" +
                "  \"data\": {\n" +
                "    \"type\": \"get_ad\",\n" +
                "    \"ad\": [\n" +
                "      {\n" +
                "        \"title\": \"聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!\",\n" +
                "        \"time\": \"2019/10/20 0:00:00\",\n" +
                "        \"u_type\": \"0\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"title\": \"公告：由于官網提供開碼信息有誤，廣東快樂10分第2019120119期開獎號號由【11-17-05-06-14-15-13-16】更正為【15-01-11-19-08-05-02-06】，請各代理會員檢查核對，如出現額度透支，一切數據以報表為準，由此造成的不便敬請諒解！！\",\n" +
                "        \"time\": \"2019/12/1 22:30:00\",\n" +
                "        \"u_type\": \"0\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"autoJP\": {\n" +
                "      \"tipsList\": [\n" +
                "        {\n" +
                "          \"category\": \"\",\n" +
                "          \"lottery_id\": \"9\",\n" +
                "          \"lottery_name\": \"幸運飛艇(5分鍾)\",\n" +
                "          \"play_name\": \"第八名\",\n" +
                "          \"put_val\": \"6\",\n" +
                "          \"odds\": \"0.03\",\n" +
                "          \"number\": \"\",\n" +
                "          \"phase\": \"20191205094\",\n" +
                "          \"add_time\": \"20:53:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"category\": \"\",\n" +
                "          \"lottery_id\": \"9\",\n" +
                "          \"lottery_name\": \"幸運飛艇(5分鍾)\",\n" +
                "          \"play_name\": \"第八名\",\n" +
                "          \"put_val\": \"4\",\n" +
                "          \"odds\": \"0.03\",\n" +
                "          \"number\": \"\",\n" +
                "          \"phase\": \"20191205094\",\n" +
                "          \"add_time\": \"20:53:00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"category\": \"\",\n" +
                "          \"lottery_id\": \"22\",\n" +
                "          \"lottery_name\": \"幸運飛艇(3分鐘)\",\n" +
                "          \"play_name\": \"第十名\",\n" +
                "          \"put_val\": \"9\",\n" +
                "          \"odds\": \"0.02\",\n" +
                "          \"number\": \"\",\n" +
                "          \"phase\": \"20191205238\",\n" +
                "          \"add_time\": \"20:51:01\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"category\": \"\",\n" +
                "          \"lottery_id\": \"22\",\n" +
                "          \"lottery_name\": \"幸運飛艇(3分鐘)\",\n" +
                "          \"play_name\": \"第十名\",\n" +
                "          \"put_val\": \"7\",\n" +
                "          \"odds\": \"0.02\",\n" +
                "          \"number\": \"\",\n" +
                "          \"phase\": \"20191205238\",\n" +
                "          \"add_time\": \"20:51:01\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"category\": \"\",\n" +
                "          \"lottery_id\": \"22\",\n" +
                "          \"lottery_name\": \"幸運飛艇(3分鐘)\",\n" +
                "          \"play_name\": \"第十名\",\n" +
                "          \"put_val\": \"5\",\n" +
                "          \"odds\": \"0.02\",\n" +
                "          \"number\": \"\",\n" +
                "          \"phase\": \"20191205238\",\n" +
                "          \"add_time\": \"20:51:01\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"timestamp\": 1575550403\n" +
                "    }\n" +
                "  },\n" +
                "  \"tipinfo\": \"\"\n" +
                "}";
    }
}
