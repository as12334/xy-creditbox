package so.wwb.creditbox.company.user.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.Const;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.security.privilege.po.SysUserStatus;
import org.soul.model.sys.po.SysParam;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.common.utility.security.AuthTool;
import so.wwb.creditbox.company.controller.MemberPageBase;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.company.user.form.AddSysUserExtendForm;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.company.user.po.CzRateKc;
import so.wwb.creditbox.model.company.user.po.CzRateSix;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.company.user.form.VSiteUserSearchForm;
import so.wwb.creditbox.company.user.form.VSiteUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.enums.base.*;
import so.wwb.creditbox.model.enums.common.CurrencyEnum;
import so.wwb.creditbox.model.enums.common.TimezoneEnum;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.po.UserBean;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.session.Session;
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;
import so.wwb.creditbox.web.tools.token.Token;

import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


/**
 * 控制器
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
@Controller
//region your codes 1
@RequestMapping("/account")
public class AccountController extends MemberPageBase {
    private static final Log LOG = LogFactory.getLog(AccountController.class);

//endregion your codes 1

    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3

    @RequestMapping("/fgs_list")
    @Token(generate = true)
    public String fgsList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysUserExtend sysUserExtend = SessionManagerCommon.getSysUserExtend();
        //如果不是總監
        if(!sysUserExtend.getUtype().equals(UTypeEnum.ZJ.getCode())){
            response.sendRedirect( "../MessagePage.html?code=u100035&url=&issuccess=1&isback=0");
        }
        super.Permission_Aspx_ZJ("po_2_1",response);



        listVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
//        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/FgsList";
    }


    @RequestMapping("/fgs_add")
    @Token(generate = true)
    public String fgsAdd(UserBean bean,BindingResult result,VSiteUserVo objectVo,SysUserExtendVo sysUserExtendVo, Model model, HttpServletResponse response) throws IOException {

        SysUserExtend sysUserExtend = SessionManagerCommon.getSysUserExtend();
        //如果不是總監
        if(!sysUserExtend.getUtype().equals(UTypeEnum.ZJ.getCode())){
            return "../MessagePage.html?code=u100035&url=&issuccess=1&isback=0";
        }
        super.Permission_Aspx_ZJ("po_2_1",response);
        return getViewBasePath() + "/edit/FgsEdit";
    }
    @RequestMapping("/persistUser")
    @Token(generate = true)
    @ResponseBody
    public String persistUser(SysUserExtendVo objectVo, Model model,@FormModel("") @Valid UserBean bean, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()){
            return "";
        }
        UserReportEnum userReportEnum = EnumTool.enumOf(UserReportEnum.class, bean.getUserReport());
        SysUserExtend sessionUser = SessionManagerCommon.getSysUserExtend();
        if(userReportEnum == null){
            return "";
        }


//        if(super.ValidParamByUserAdd(bean,UTypeEnum.FGS.getCode(),"","","1")){

            SysUserExtend sysUserExtend = defaultAccount(bean, request);

        sysUserExtend.setHid(sessionUser.getHid());
            sysUserExtend.setUtype("fgs");
            sysUserExtend.setSuType("zj");
            sysUserExtend.setSixAllowMaxrate(AllowMaxrateEnum.CLOSE.getCode());
            sysUserExtend.setSixLowMaxrate(0);
            sysUserExtend.setKcAllowMaxrate(AllowMaxrateEnum.CLOSE.getCode());
            sysUserExtend.setKcLowMaxrate(0);
            sysUserExtend.setSixRateOwner(bean.getUserRateOwner_six());
            sysUserExtend.setSixIscash(bean.getIsCash_six());

            sysUserExtend.setKcRateOwner(bean.getUserRateOwner_kc());
            sysUserExtend.setKcIscash(bean.getIsCash_kc());

            sysUserExtend.setSixOpOdds(bean.getOp_six());
            sysUserExtend.setKcOpOdds(bean.getOp_kc());





            SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
            sysUserExtendVo.setDataSourceId(sessionUser.getSiteId());
            sysUserExtendVo.setResult(sysUserExtend);
            ServiceTool.sysUserExtendService().insert(sysUserExtendVo);

            CzRateKc czRateKc = new CzRateKc();
            czRateKc.setUid(sysUserExtend.getUid());
            czRateKc.setUname(bean.getUserName());
            czRateKc.setUtype("fgs");
            czRateKc.setDlName("");
            czRateKc.setZdName("");
            czRateKc.setGdName("");
            czRateKc.setFgsName(bean.getUserName());
            czRateKc.setDlRate(0);
            czRateKc.setZdRate(0);
            czRateKc.setGdRate(0);
            czRateKc.setFgsRate(0);
            czRateKc.setZjRate(sysUserExtend.getKcRate());

            CzRateSix czRateSix = new CzRateSix();
            czRateSix.setUid(sysUserExtend.getUid());
            czRateSix.setUname(bean.getUserName());
            czRateSix.setUtype("fgs");
            czRateSix.setDlName("");
            czRateSix.setZdName("");
            czRateSix.setGdName("");
            czRateSix.setFgsName(bean.getUserName());
            czRateSix.setDlRate(0);
            czRateSix.setZdRate(0);
            czRateSix.setGdRate(0);
            czRateSix.setFgsRate(0);
            czRateSix.setZjRate(sysUserExtend.getSixRate());

            sysUserExtendVo.setCzRateKc(czRateKc);
            sysUserExtendVo.setCzRateSix(czRateSix);

//        }
        return "保存成功！";
    }
    @RequestMapping("/existNameAjax")
    @ResponseBody
    public String ExistNameAjax(@RequestParam("uname") String username){
        return super.getUserNameExist(username);
    }


    private SysUserExtend defaultAccount(UserBean bean, HttpServletRequest request){
        SysUserExtend sessionUser = SessionManagerCommon.getSysUserExtend();

        SysUserExtend sysUserExtend = new SysUserExtend();
        sysUserExtend.setSiteId(SessionManagerCommon.getSiteId());
        sysUserExtend.setDefaultCurrency(CurrencyEnum.CNY.getCode());
        sysUserExtend.setDefaultTimezone(TimezoneEnum.GMT2800.getCode());
        sysUserExtend.setDefaultLocale("zh_CN");
        sysUserExtend.setUsername(bean.getUserName()+ "@" + LotteryCommonContext.get().getSiteCode());
        //对身份验证码进行DES加密处理
        String str = GoogleAuthenticator.generateSecretKey();
        String key = sysUserExtend.getUsername();
        String secret = DesTool.encrypt(str, key);
        sysUserExtend.setAuthenticationKey(secret);
        sysUserExtend.setPassword(AuthTool.md5SysUserPassword(bean.getUserPassword(), sysUserExtend.getUsername())); //账户密码加密

        sysUserExtend.setRegisterIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
        sysUserExtend.setRegisterIpDictCode(SessionManagerCommon.getIpDictCode());
        sysUserExtend.setStatus(SysUserStatus.NORMAL.getCode());
        sysUserExtend.setBuiltIn(false);
        sysUserExtend.setCreateTime(new Date());
        sysUserExtend.setCreateUser(sessionUser.getId());
        sysUserExtend.setSubsysCode(SubSysCodeEnum.BRANCH.getCode());
        sysUserExtend.setOwnerId(sessionUser.getId());
        sysUserExtend.setNickname(bean.getUserNicker());
        sysUserExtend.setUserType(UserTypeEnum.BRANCH.getCode());

        sysUserExtend.setUid(UUID.randomUUID().toString());
        sysUserExtend.setSalt("");
        sysUserExtend.setLastChangedDate(new Date());
        sysUserExtend.setUskin(SkinEnum.BLUE.getCode());
        sysUserExtend.setSupName(sessionUser.getUsername());

        sysUserExtend.setAddDate(new Date());
        SysParam lotteryTypeParam = ParamTool.getSysParam(SiteParamEnum.SETTING_SITE_LOTTERY_TYPE);
        if(lotteryTypeParam.getParamValue().equals("1")){
            sysUserExtend.setSixRate(Integer.parseInt(bean.getUserRate_six()));
            sysUserExtend.setKcRate(100);
            sysUserExtend.setSixCredit(Double.parseDouble(bean.getUserCredit_six()));
            sysUserExtend.setSixUsableCredit(Double.parseDouble(bean.getUserCredit_six()));
            sysUserExtend.setKcCredit(0.0);
            sysUserExtend.setKcUsableCredit(0.0);

        }else {
            sysUserExtend.setSixRate(100);
            sysUserExtend.setKcRate(Integer.parseInt(bean.getUserRate_kc()));
            sysUserExtend.setSixCredit(0.0);
            sysUserExtend.setSixUsableCredit(0.0);
            sysUserExtend.setKcCredit(Double.parseDouble(bean.getUserCredit_kc()));
            sysUserExtend.setKcUsableCredit(Double.parseDouble(bean.getUserCredit_kc()));
        }

        sysUserExtend.setAstate(0);
        sysUserExtend.setAllowViewReport(bean.getUserReport());

        sysUserExtend.setSixKind(bean.getUserKind_six());
        sysUserExtend.setSixAllowSale(bean.getUserAllowSale_six());

        sysUserExtend.setKcKind(bean.getUserKind_kc());
        sysUserExtend.setKcAllowSale(bean.getUserAllowSale_kc());

        sysUserExtend.setAllowOpt(1);
        sysUserExtend.setKcCrashPayment(0);
        sysUserExtend.setIsChanged(PasswordIsChangeEnum.FRIST.getCode());
        sysUserExtend.setKcIsautoBack(IsautoBackEnum.AUTO.getCode());
        sysUserExtend.setSixIsautoBack(IsautoBackEnum.AUTO.getCode());

        return sysUserExtend;
    }
    //endregion your codes 3

}