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
@RequestMapping("/NewsManage")
public class NewsManageController {
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";




    @RequestMapping(value = "list")
    protected String list(SiteLotteryOddsVo vo, SysUserExtendVo userExtendVo,HttpServletRequest request, HttpServletResponse response, Model model) {
        return "/news/Index";
    }
}
