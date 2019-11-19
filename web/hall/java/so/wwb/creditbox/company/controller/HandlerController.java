package so.wwb.creditbox.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    protected String queryHandler(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "{\n" +
                "  \"success\": 200,\n" +
                "  \"data\": {\n" +
                "    \"type\": \"get_ad\",\n" +
                "    \"ad\": [\n" +
                "      {\n" +
                "        \"title\": \"聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!\",\n" +
                "        \"time\": \"2019/10/20 0:00:00\",\n" +
                "        \"u_type\": \"0\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"game_2\": {\n" +
                "      \"kind\": \"A\",\n" +
                "      \"name\": \"快彩\",\n" +
                "      \"credit\": \"1000\",\n" +
                "      \"usable_credit\": 10,\n" +
                "      \"profit\": \"0\",\n" +
                "      \"iscash\": \"0\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"tipinfo\": \"\"\n" +
                "}";
    }
}
