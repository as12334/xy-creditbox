package so.wwb.lotterybox.web.ip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IpAccessRuleController {

    /**
     * 返回当前站点经营地区IP段
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "OperationAreaIpRang")
    @ResponseBody
    protected String OperationAreaIpRang(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "";
    }

    /**
     * 返回当前站点限制访问地区IP段
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "DenyAreaIpRang")
    @ResponseBody
    protected String DenyAreaIpRang(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "";
    }

    /**
     * 返回当前站点允许访问地区IP段
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "AllowAreaIpRang")
    @ResponseBody
    protected String AllowAreaIpRang(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "";
    }

    /**
     * 返回当前站点限制访问地区IP段
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "DenyIpRang")
    @ResponseBody
    protected String DenyIpRang(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "";
    }

    /**
     * 返回当前站点允许访问地区IP段
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "AllowIpRang")
    @ResponseBody
    protected String AllowIpRang(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "";
    }
}
