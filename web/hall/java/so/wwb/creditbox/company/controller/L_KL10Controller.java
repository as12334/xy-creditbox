package so.wwb.creditbox.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/L_KL10/Handler/")
public class L_KL10Controller {
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";




    @RequestMapping(value = "Handler")
    @ResponseBody
    protected String handler(@RequestParam("action") String action,@RequestParam("playpage") String playpage,HttpServletRequest request, HttpServletResponse response, Model model ) {

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
                    "    \"playpage\": \"kl10_lmp\",\n" +
                    "    \"credit\": \"0\",\n" +
                    "    \"usable_credit\": 0,\n" +
                    "    \"openning\": \"y\",\n" +
                    "    \"isopen\": \"1\",\n" +
                    "    \"drawopen_time\": \"22:40:00\",\n" +
                    "    \"stop_time\": \"00:10:25\",\n" +
                    "    \"nn\": \"2019111941\",\n" +
                    "    \"p_id\": \"137390\",\n" +
                    "    \"profit\": \"0\",\n" +
                    "    \"play_odds\": {\n" +
                    "      \"82_21\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"82_22\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"83_23\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"83_24\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"85_25\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"85_26\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"84_27\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"84_28\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"87_49\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"87_50\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"88_51\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"88_52\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"90_53\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"90_54\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"89_55\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"89_56\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"92_77\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"92_78\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"93_79\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"93_80\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"95_81\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"95_82\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"94_83\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"94_84\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"97_105\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"97_106\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"98_107\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"98_108\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"100_109\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"100_110\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"99_111\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"99_112\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"102_133\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"102_134\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"103_135\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"103_136\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"105_137\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"105_138\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"104_139\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"104_140\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"107_161\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"107_162\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"108_163\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"108_164\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"110_165\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"110_166\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"109_167\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"109_168\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"112_189\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"112_190\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"113_191\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"113_192\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"115_193\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"115_194\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"114_195\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"114_196\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"117_217\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"117_218\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"118_219\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"118_220\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"120_221\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"120_222\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"119_223\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"119_224\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"11_245\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"11_246\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"12_247\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"12_248\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"13_249\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"13_250\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"80_307\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      },\n" +
                    "      \"80_308\": {\n" +
                    "        \"pl\": \"1.9828\",\n" +
                    "        \"plx\": [],\n" +
                    "        \"min_amount\": \"2\",\n" +
                    "        \"max_amount\": \"20000\",\n" +
                    "        \"top_amount\": \"10000000\",\n" +
                    "        \"dq_max_amount\": \"1000000\",\n" +
                    "        \"dh_max_amount\": \"100000\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"tipinfo\": \"\"\n" +
                    "}";
        }

        return "";

    }
}
