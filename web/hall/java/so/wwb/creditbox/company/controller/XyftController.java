package so.wwb.creditbox.company.controller;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.HidTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xyft/handler")
public class XyftController {
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";




    @RequestMapping(value = "handler")
    @ResponseBody
    protected String handler(@RequestParam("action") String action,@RequestParam("playpage") String playpage,HttpServletRequest request, HttpServletResponse response, Model model ) {
        Cache.refreshSiteLotteryOdds(HidTool.getBranchHid(SessionManager.getSysUserExtend().getHid()),LotteryEnum.BJPK10.getCode());
        Cache.refreshSiteLotteryRebates(HidTool.getBranchHid(SessionManager.getSysUserExtend().getHid()),LotteryEnum.BJPK10.getCode());
        Map<String, SiteLotteryOdds> oddsMap = Cache.getSiteLotteryOdds(HidTool.getBranchHid(SessionManager.getSysUserExtend().getHid()), LotteryEnum.BJPK10.getCode());
        Map<String, SiteLotteryRebates> rebatesMap = Cache.getSiteLotteryRebates(HidTool.getBranchHid(SessionManager.getSysUserExtend().getHid()), LotteryEnum.BJPK10.getCode());

        List<LotteryResult> lotteryResult = Cache.getLotteryResult(LotteryEnum.XYFT.getCode());
        List<LotteryResult> results = ServiceTool.lotteryResultService().queryRecentResult(new LotteryResultVo());
        Map<Object, LotteryResult> objectLotteryResultMap = CollectionTool.toEntityMap(results, LotteryResult.PROP_CODE);





        System.out.println(JsonTool.toJson(objectLotteryResultMap.get(LotteryEnum.XYFT.getCode())));
        if("get_openball".equals(action)){
            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_openball\",\n" +
                    "    \"draw_phase\": \"2019111940\",\n" +
                    "    \"draw_result\": [\n" +
                    "      \"17\",\n" +
                    "      \"09\",\n" +
                    "      \"11\",\n" +
                    "      \"18\",\n" +
                    "      \"14\",\n" +
                    "      \"02\",\n" +
                    "      \"08\",\n" +
                    "      \"01\"\n" +
                    "    ],\n" +
                    "    \"phaseinfo\": {\n" +
                    "      \"intervaltime\": \"20分鐘\",\n" +
                    "      \"begintime\": \"09:00\",\n" +
                    "      \"endtime\": \"23:00\",\n" +
                    "      \"sold\": \"40\",\n" +
                    "      \"surplus\": \"2\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }
        else if("get_ranklist".equals(action)){
            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_ranklist\",\n" +
                    "    \"playpage\": \"xyft_lmp\",\n" +
                    "    \"jqkj\": [\n" +
                    "      {\n" +
                    "        \"phase\": \"20191124170\",\n" +
                    "        \"play_open_date\": \"2019/11/25 3:14:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"09\",\n" +
                    "          \"06\",\n" +
                    "          \"08\",\n" +
                    "          \"07\",\n" +
                    "          \"04\",\n" +
                    "          \"02\",\n" +
                    "          \"05\",\n" +
                    "          \"03\",\n" +
                    "          \"10\",\n" +
                    "          \"01\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"15\",\n" +
                    "          \"<span class=\\\"red\\\">大</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"20191124169\",\n" +
                    "        \"play_open_date\": \"2019/11/25 3:09:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"09\",\n" +
                    "          \"08\",\n" +
                    "          \"01\",\n" +
                    "          \"03\",\n" +
                    "          \"04\",\n" +
                    "          \"05\",\n" +
                    "          \"10\",\n" +
                    "          \"06\",\n" +
                    "          \"07\",\n" +
                    "          \"02\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"17\",\n" +
                    "          \"<span class=\\\"red\\\">大</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"20191124168\",\n" +
                    "        \"play_open_date\": \"2019/11/25 3:04:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"01\",\n" +
                    "          \"03\",\n" +
                    "          \"07\",\n" +
                    "          \"05\",\n" +
                    "          \"04\",\n" +
                    "          \"06\",\n" +
                    "          \"10\",\n" +
                    "          \"02\",\n" +
                    "          \"08\",\n" +
                    "          \"09\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"4\",\n" +
                    "          \"<span class=\\\"blue\\\">小</span>\",\n" +
                    "          \"<span class=\\\"red\\\">雙</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"20191124167\",\n" +
                    "        \"play_open_date\": \"2019/11/25 2:59:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"05\",\n" +
                    "          \"08\",\n" +
                    "          \"09\",\n" +
                    "          \"01\",\n" +
                    "          \"02\",\n" +
                    "          \"06\",\n" +
                    "          \"03\",\n" +
                    "          \"10\",\n" +
                    "          \"07\",\n" +
                    "          \"04\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"13\",\n" +
                    "          \"<span class=\\\"red\\\">大</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"20191124166\",\n" +
                    "        \"play_open_date\": \"2019/11/25 2:54:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"02\",\n" +
                    "          \"09\",\n" +
                    "          \"08\",\n" +
                    "          \"03\",\n" +
                    "          \"06\",\n" +
                    "          \"01\",\n" +
                    "          \"05\",\n" +
                    "          \"07\",\n" +
                    "          \"04\",\n" +
                    "          \"10\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"11\",\n" +
                    "          \"<span class=\\\"blue\\\">小</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"lmcl\": [\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第四名 - 單\",\n" +
                    "        \"cl_num\": \"5\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第五名 - 雙\",\n" +
                    "        \"cl_num\": \"5\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"冠軍 - 單\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第五名 - 小\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第九名 - 大\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"冠軍 - 龍\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"冠軍 - 大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"亞軍 - 雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"亞軍 - 大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第六名 - 小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第十名 - 小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"冠亞軍和 - 大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"冠亞軍和 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"cql\": {\n" +
                    "      \"title\": [\n" +
                    "        \"冠、亞軍和\",\n" +
                    "        \"冠、亞軍和 大小\",\n" +
                    "        \"冠、亞軍和 單雙\"\n" +
                    "      ],\n" +
                    "      \"content\": [\n" +
                    "        \"16,1|15,1|8,1|7,1|9,2|17,1|8,1|4,1|3,1|7,1|5,1|11,1|8,1|12,1|8,1|6,1|7,2|10,1|16,1|15,1|11,1|13,1|4,1|17,1|15,1\",\n" +
                    "        \"小,4|大,3|小,4|大,2|小,4|大,1|小,7|大,1|小,5|大,2|小,1|大,1|小,1|大,2\",\n" +
                    "        \"單,1|雙,2|單,2|雙,3|單,3|雙,1|單,1|雙,1|單,4|雙,2|單,4|雙,4|單,2|雙,2|單,3|雙,1|單,2\"\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }
        else if("get_putinfo".equals(action)){
            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_putinfo\"\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }
        else if("get_oddsinfo".equals(action)){
            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_oddsinfo\",\n" +
                    "    \"playpage\": \"xyft_lmp\",\n" +
                    "    \"credit\": \"0\",\n" +
                    "    \"usable_credit\": 0,\n" +
                    "    \"openning\": \"y\",\n" +
                    "    \"isopen\": \"1\",\n" +
                    "    \"drawopen_time\": \"02:54:00\",\n" +
                    "    \"stop_time\": \"00:03:05\",\n" +
                    "    \"nn\": \"20191124166\",\n" +
                    "    \"p_id\": \"143910\",\n" +
                    "    \"profit\": \"0\",\n" +
                    "    \"play_odds\": {\n" +
                    "      \"2_11\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"2_12\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"3_13\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"3_14\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"4_15\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"4_16\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"6_27\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"6_28\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"7_29\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"7_30\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"8_31\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"8_32\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"10_43\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"10_44\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"11_45\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"11_46\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"12_47\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"12_48\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"14_59\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"14_60\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"15_61\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"15_62\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"16_63\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"16_64\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"18_75\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"18_76\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"19_77\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"19_78\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"20_79\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"20_80\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"22_91\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"22_92\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"23_93\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"23_94\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"25_105\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"25_106\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"26_107\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"26_108\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"28_119\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"28_120\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"29_121\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"29_122\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"31_133\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"31_134\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"32_135\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"32_136\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"34_147\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"34_148\": {\n" +
                    "        \"pl\": \"1.9629\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"35_149\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"35_150\": {\n" +
                    "        \"pl\": \"1.9829\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"37_168\": {\n" +
                    "        \"pl\": \"2.1508\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"37_169\": {\n" +
                    "        \"pl\": \"1.7508\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"38_170\": {\n" +
                    "        \"pl\": \"1.7508\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"38_171\": {\n" +
                    "        \"pl\": \"2.1508\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"500000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }
        else if("put_money".equals(action)){
            return "{\n" +
                    "  \"success\": 200,\n" +
                    "  \"data\": {\n" +
                    "    \"type\": \"get_putinfo\"\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"下单成功\"\n" +
                    "}";
        }

        return "";

    }
}
