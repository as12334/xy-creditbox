package so.wwb.creditbox.company.controller;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.tree.TreeNode;
import org.soul.model.security.privilege.po.VSysUserResource;
import org.soul.model.security.privilege.vo.SysResourceVo;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.controller.BaseIndexController;
import org.soul.web.security.privilege.controller.SysResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.init.ConfigManager;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.lottery.LotteryEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.company.lottery.vo.SiteLotteryListVo;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("index")
public class IndexController {
    private static final String INDEX_URI = "Home";
    private static final String LOGIN_VALIDATE = "LoginValidate";
    private static final String INDEX_CONTENT_URI = "index.include/content";


    @RequestMapping(value = "")
    protected String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        return INDEX_URI;
    }

    @RequestMapping(value = "loginValidate")
    protected String loginValidate(HttpServletRequest request, HttpServletResponse response, Model model) {
        return LOGIN_VALIDATE;
    }

    @RequestMapping(value = "{code}")
    protected String lotteryCodeIndex(@PathVariable String code, HttpServletRequest request, HttpServletResponse response, Model model) {
        LotteryEnum anEnum = EnumTool.enumOf(LotteryEnum.class, code);
        return "lottery/template/"+anEnum.getType();
    }



}
