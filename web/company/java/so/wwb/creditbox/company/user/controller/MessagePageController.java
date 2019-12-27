package so.wwb.creditbox.company.user.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.sys.po.SysParam;
import org.soul.web.validation.form.annotation.FormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.company.controller.MemberPageBase;
import so.wwb.creditbox.company.user.form.VSiteUserSearchForm;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.common.MessagePageBean;
import so.wwb.creditbox.model.company.user.po.CzRateKc;
import so.wwb.creditbox.model.company.user.po.CzRateSix;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.model.enums.base.*;
import so.wwb.creditbox.model.enums.common.CurrencyEnum;
import so.wwb.creditbox.model.enums.common.TimezoneEnum;
import so.wwb.creditbox.model.enums.lottery.SkinEnum;
import so.wwb.creditbox.model.enums.lottery.UTypeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.po.UserBean;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


/**
 * 控制器
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
@Controller
//region your codes 1
@RequestMapping("/")
public class MessagePageController extends MemberPageBase {
    private static final Log LOG = LogFactory.getLog(MessagePageController.class);

//endregion your codes 1

    protected String getViewBasePath() {
        //region your codes 2
        return "/MessagePage";
        //endregion your codes 2
    }

    //region your codes 3
    @RequestMapping("/MessagePage")
    public String messagePage(MessagePageBean bean,Model model, HttpServletRequest request, HttpServletResponse response){
        bean.setMsgText("抱歉！您不能跨級新增帳戶！");
        model.addAttribute("command",bean);
        return getViewBasePath();
    }
    //endregion your codes 3

}