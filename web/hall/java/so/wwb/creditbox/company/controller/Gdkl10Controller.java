package so.wwb.creditbox.company.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.data.datasource.DatasourceTool;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.service.tool.DatasourceUtil;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.HidTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gdkl10/handler")
public class Gdkl10Controller {
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
                    "    \"playpage\": \"kl10_lmp\",\n" +
                    "    \"jqkj\": [\n" +
                    "      {\n" +
                    "        \"phase\": \"2019111940\",\n" +
                    "        \"play_open_date\": \"2019/11/19 22:20:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"17\",\n" +
                    "          \"09\",\n" +
                    "          \"11\",\n" +
                    "          \"18\",\n" +
                    "          \"14\",\n" +
                    "          \"02\",\n" +
                    "          \"08\",\n" +
                    "          \"01\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"80\",\n" +
                    "          \"<span class=\\\"blue\\\">小</span>\",\n" +
                    "          \"<span class=\\\"red\\\">雙</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">尾小</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"2019111939\",\n" +
                    "        \"play_open_date\": \"2019/11/19 22:00:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"15\",\n" +
                    "          \"18\",\n" +
                    "          \"13\",\n" +
                    "          \"17\",\n" +
                    "          \"20\",\n" +
                    "          \"04\",\n" +
                    "          \"08\",\n" +
                    "          \"07\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"102\",\n" +
                    "          \"<span class=\\\"red\\\">大</span>\",\n" +
                    "          \"<span class=\\\"red\\\">雙</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">尾小</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"2019111938\",\n" +
                    "        \"play_open_date\": \"2019/11/19 21:40:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"04\",\n" +
                    "          \"10\",\n" +
                    "          \"14\",\n" +
                    "          \"11\",\n" +
                    "          \"08\",\n" +
                    "          \"01\",\n" +
                    "          \"05\",\n" +
                    "          \"02\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"55\",\n" +
                    "          \"<span class=\\\"blue\\\">小</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"red\\\">尾大</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"2019111937\",\n" +
                    "        \"play_open_date\": \"2019/11/19 21:20:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"15\",\n" +
                    "          \"04\",\n" +
                    "          \"13\",\n" +
                    "          \"02\",\n" +
                    "          \"11\",\n" +
                    "          \"03\",\n" +
                    "          \"08\",\n" +
                    "          \"09\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"65\",\n" +
                    "          \"<span class=\\\"blue\\\">小</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">單</span>\",\n" +
                    "          \"<span class=\\\"red\\\">尾大</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">龍</span>\"\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"phase\": \"2019111936\",\n" +
                    "        \"play_open_date\": \"2019/11/19 21:00:00\",\n" +
                    "        \"draw_num\": [\n" +
                    "          \"17\",\n" +
                    "          \"11\",\n" +
                    "          \"18\",\n" +
                    "          \"03\",\n" +
                    "          \"02\",\n" +
                    "          \"07\",\n" +
                    "          \"06\",\n" +
                    "          \"20\"\n" +
                    "        ],\n" +
                    "        \"total\": [\n" +
                    "          \"84\",\n" +
                    "          \"<span class=\\\"green\\\">和</span>\",\n" +
                    "          \"<span class=\\\"red\\\">雙</span>\",\n" +
                    "          \"<span class=\\\"blue\\\">尾小</span>\",\n" +
                    "          \"<span class=\\\"red\\\">虎</span>\"\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"lmcl\": [\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 大\",\n" +
                    "        \"cl_num\": \"7\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 尾大\",\n" +
                    "        \"cl_num\": \"7\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 小\",\n" +
                    "        \"cl_num\": \"6\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第1球 - 合雙\",\n" +
                    "        \"cl_num\": \"5\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 小\",\n" +
                    "        \"cl_num\": \"5\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 尾小\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 尾小\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 小\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"龍\",\n" +
                    "        \"cl_num\": \"4\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第2球 - 合單\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第4球 - 大\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 雙\",\n" +
                    "        \"cl_num\": \"3\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第1球 - 大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第1球 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第1球 - 尾大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第2球 - 尾大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第3球 - 合雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第4球 - 尾大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 大\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第5球 - 尾小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 合雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第6球 - 雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 合雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第7球 - 雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"第8球 - 合單\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"總和雙\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"cl_name\": \"總和尾小\",\n" +
                    "        \"cl_num\": \"2\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"cql\": {\n" +
                    "      \"title\": [\n" +
                    "        \"龍虎\",\n" +
                    "        \"總和大小\",\n" +
                    "        \"總和單雙\",\n" +
                    "        \"總和尾大小\"\n" +
                    "      ],\n" +
                    "      \"content\": [\n" +
                    "        \"虎,1|龍,3|虎,2|龍,1|虎,7|龍,1|虎,1|龍,8|虎,1|龍,2|虎,1|龍,2|虎,1|龍,4|虎,1|龍,4\",\n" +
                    "        \"大,1|小,2|大,2|小,2|大,2|小,1|大,2|小,2|大,5|小,1|大,3|小,9|大,1|小,1|大,1|和,1|小,2|大,1|小,1\",\n" +
                    "        \"雙,1|單,1|雙,1|單,3|雙,3|單,1|雙,1|單,3|雙,2|單,1|雙,1|單,3|雙,1|單,1|雙,1|單,2|雙,2|單,1|雙,7|單,2|雙,2\",\n" +
                    "        \"小,2|大,1|小,1|大,2|小,1|大,1|小,1|大,3|小,1|大,1|小,1|大,1|小,1|大,2|小,2|大,2|小,4|大,1|小,1|大,1|小,1|大,2|小,1|大,2|小,2\"\n" +
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
                    "    \"playpage\": \"kl10_lm\",\n" +
                    "    \"credit\": \"0\",\n" +
                    "    \"usable_credit\": 0,\n" +
                    "    \"openning\": \"y\",\n" +
                    "    \"isopen\": \"1\",\n" +
                    "    \"drawopen_time\": \"22:40:00\",\n" +
                    "    \"stop_time\": \"00:02:34\",\n" +
                    "    \"nn\": \"2019112341\",\n" +
                    "    \"p_id\": \"137558\",\n" +
                    "    \"profit\": \"0\",\n" +
                    "    \"play_odds\": {\n" +
                    "      \"72_1\": {\n" +
                    "        \"pl\": \"6.3\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"50000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"73_330\": {\n" +
                    "        \"pl\": \"0\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"50000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"74_331\": {\n" +
                    "        \"pl\": \"25\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"50000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"75_1181\": {\n" +
                    "        \"pl\": \"18.5\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"20000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"76_1200\": {\n" +
                    "        \"pl\": \"0\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"10000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"77_1201\": {\n" +
                    "        \"pl\": \"900\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"2000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"10000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"78_1202\": {\n" +
                    "        \"pl\": \"58\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"1000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"10000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"79_1203\": {\n" +
                    "        \"pl\": \"240\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"1000\",\n" +
                    "        \"top_amount\": \"500000\",\n" +
                    "        \"dq_max_amount\": \"10000\",\n" +
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
