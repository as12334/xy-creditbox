package so.wwb.creditbox.manager.boss.account.controller;

import org.soul.commons.enums.YesNot;
import org.soul.commons.net.ServletTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.web.validation.form.annotation.FormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.manager.common.account.controller.BaseAccountController;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendForm;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendSearchForm;
import so.wwb.creditbox.manager.common.account.form.SysUserExtendUpdateForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.*;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;
import so.wwb.creditbox.web.membercenter.form.ResetPwdForm;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * 商户账号
 * Created by ronnie on 17-11-1.
 */
@Controller
@RequestMapping("/boss/account/company")
public class CompanyAccountController extends BaseAccountController {

    @Override
    protected String getViewBasePath() {
        return "/boss/account/company/";
    }


    /**
     * 查询所有商户账号列表
     */
    @RequestMapping("/companyList")
    public String companyList(SysUserExtendListVo listVo, SysUserExtendSearchForm form, BindingResult result, Model model, HttpServletRequest request) {
        SysUserExtendListVo companyList = queryAccountListByType(listVo, UserTypeEnum.COMPANY.getCode());
        //所有的商户主账号列表
        model.addAttribute("command", companyList);
        List<String> list =new ArrayList<>();
        list.add(SubSysCodeEnum.BRANCH.getCode());
        //所有商户下对应的总代人数
        model.addAttribute("ownerIds", querySubCount(companyList, list));
        //拥有站点的股东主账号列表
        model.addAttribute("companies", queryAccountListAsSiteByType(listVo, UserTypeEnum.COMPANIES.getCode()));
        if (ServletTool.isAjaxSoulRequest(request)) {
            return this.getViewBasePath() + "IndexPartial";
        } else {
            return this.getViewBasePath() + "Index";
        }
    }

    @Override
    @RequestMapping("/create")
    @Token(generate = true)
    public String create(SysUserExtendVo objectVo, Model model, HttpServletRequest request, HttpServletResponse response) {
        objectVo.getSearch().setUserType(UserTypeEnum.COMPANY.getCode());

        model.addAttribute("companies", queryAccountListAsSiteByType(new SysUserExtendListVo(), UserTypeEnum.COMPANIES.getCode()));

        return super.create(objectVo, model, request, response);
    }

    @Override
    @RequestMapping("/view")
    public String view(SysUserExtendVo objectVo, Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
        return super.view(objectVo, id, model, request, response);
    }

    /**
     * 添加公司
     *
     * @param objectVo
     * @param form
     * @param result
     * @param request
     * @return
     */
    @RequestMapping("/addAccount")
    @ResponseBody
    @Token(valid = true)
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_ACCOUNT_ME_ADD, opType = OpType.CREATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map addAccount(SysUserExtendVo objectVo, @FormModel @Valid SysUserExtendForm form, BindingResult result, HttpServletRequest request) {
        objectVo.getResult().setUserType(UserTypeEnum.COMPANY.getCode());
        objectVo.getResult().setCreateUser(SessionManager.getSysUserExtend().getId());
        objectVo.getResult().setSubsysCode(SubSysCodeEnum.COMPANY.getCode());



        objectVo.getResult().setBuiltIn(false);
        objectVo.getResult().setUid(UUID.randomUUID().toString());
        objectVo.getResult().setUskin(SkinEnum.BLUE.getCode());
        objectVo.getResult().setSupName(SessionManager.getUserName());
        objectVo.getResult().setUtype(UTypeEnum.ZJ.getCode());
        objectVo.getResult().setSuType(UTypeEnum.ZGS.getCode());
        objectVo.getResult().setAddDate(new Date());
        objectVo.getResult().setSixRate(0);
        objectVo.getResult().setSixCredit(0.0);
        objectVo.getResult().setSixUsableCredit(0.0);
        objectVo.getResult().setSixKind(KindEnum.DEFAULT.getCode());
        objectVo.getResult().setAstate(1);
        objectVo.getResult().setSixAllowSale(AllowSaleEnum.YES.getCode());
        objectVo.getResult().setAllowViewReport(AllowViewReportEnum.YES.getCode());
        objectVo.getResult().setSixAllowMaxrate(AllowMaxrateEnum.CLOSE.getCode());
        objectVo.getResult().setSixLowMaxrate(0);
        objectVo.getResult().setSixRateOwner(RateOwnerEnum.FGS.getCode());
        objectVo.getResult().setSixIscash(CashEnum.NO.getCode());
        objectVo.getResult().setAllowOpt(1);
        objectVo.getResult().setIsChanged("");
        objectVo.getResult().setKcRate(0);
        objectVo.getResult().setKcCredit(9999999.0);
        objectVo.getResult().setKcUsableCredit(99999999.0);
        objectVo.getResult().setKcKind(KindEnum.DEFAULT.getCode());
        objectVo.getResult().setKcAllowSale(AllowSaleEnum.YES.getCode());
        objectVo.getResult().setKcAllowMaxrate(AllowMaxrateEnum.CLOSE.getCode());
        objectVo.getResult().setKcRateOwner(RateOwnerEnum.FGS.getCode());
        objectVo.getResult().setKcCrashPayment(0);
        objectVo.getResult().setKcIscash(CashEnum.NO.getCode());
        objectVo.getResult().setKcOpOdds(OpOddEnum.YES.getCode());
        objectVo.getResult().setSixOpOdds(OpOddEnum.YES.getCode());
        objectVo.getResult().setKcIsautoBack(IsautoBackEnum.AUTO.getCode());
        objectVo.getResult().setSixIsautoBack(IsautoBackEnum.AUTO.getCode());
        return getVoMessage(baseAddAccount(objectVo, form, result, request));
    }

    /**
     * 编辑商户账号
     *
     * @param userExtendVo
     * @param form
     * @param result
     * @param request
     * @return
     */
    @RequestMapping("/updateAccount")
    @ResponseBody
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_ACCOUNT_UPDATE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map updateAccount(SysUserExtendVo userExtendVo, @FormModel @Valid SysUserExtendUpdateForm form, BindingResult result, HttpServletRequest request) {
        userExtendVo = baseUpdateAccount(userExtendVo, form, result, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 新增商户账号
     */
    @RequestMapping("/editMhAccount")
    public String editMhAccount(Model model, Integer id) {
        editAccount(model, id);
        return getViewBasePath() + "Edit";
    }

    /**
     * 重置登录密码跳转页
     */
    @RequestMapping("/resetPwd")
    public String resetPwd(Model model, Integer id) {
        resetPassword(model, id);
        return getViewBasePath() + "ResetPwd";
    }

    /**
     * 重置登录密码保存
     */
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_PASSWORD_UPDATE, opType = OpType.UPDATE)
    @RequestMapping("/updateMhPwd")
    @ResponseBody
    public Map updateMhPwd(SysUserExtendVo userExtendVo, @FormModel @Valid ResetPwdForm form, BindingResult result, HttpServletRequest request) {
        userExtendVo = updatePwd(userExtendVo, form, result, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 更新状态
     * 根据ID  更新冻结和解冻
     */
    @RequestMapping("/freezeMhStatus")
    @ResponseBody
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_STATUS_FREEZE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map freezeMhStatus(SysUserExtendVo userExtendVo, HttpServletRequest request) {
        userExtendVo = baseFreezeStatus(userExtendVo, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 更新状态
     * 根据ID  更新停用和使用
     */
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_STATUS_DISABLE_OR_NORMAL, opType = OpType.UPDATE)
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Map updateStatus(SysUserExtendVo userExtendVo, HttpServletRequest request) {
        userExtendVo = baseDisabledStatus(request, userExtendVo);
        return getVoMessage(userExtendVo);
    }

    @RequestMapping("/viewKey")
    @ResponseBody
    public Map viewKey(SysUserExtendVo sysUserExtendVo) {
        sysUserExtendVo = getService().get(sysUserExtendVo);
        Map<String, String> map = new HashMap<>(1);
        if (sysUserExtendVo.getResult() != null && sysUserExtendVo.getResult().getKey() != null) {
            map.put("key", sysUserExtendVo.getResult().getKey());
        }
        return map;
    }

    /**
     * 重置身份验证
     *
     * @param objectVo
     * @param request
     * @return
     */
    @RequestMapping("/resetAuthenticationKey")
    @ResponseBody
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_ACCOUNT_RESET_AUTHENTICATION_KEY, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.YES)
    public Map<String, Object> resetAuthenticationKey(VSubAccountVo objectVo, HttpServletRequest request) {
        return baseResetAuthenticationKey(objectVo, request);
    }

    /**
     * 显示二维码Url
     *
     * @param username
     * @param host
     * @param secret
     * @param model
     * @return
     */
    @RequestMapping("/showAuthenticationKeyUrl")
    public String showAuthenticationKeyUrl(String username, String host, String secret, Model model) {
        String url = GoogleAuthenticator.getQRBarcodeURL(username, host, secret);
        model.addAttribute("pageUrl", url);
        return "/common/account/ShowAuthenticationKeyUrl";
    }

}
