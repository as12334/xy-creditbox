package so.wwb.creditbox.manager.boss.account.controller;

import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.string.StringTool;
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
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.manager.user.vo.VSubAccountVo;
import so.wwb.creditbox.web.membercenter.form.ResetPwdForm;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 股东账号
 * Created by ronnie on 17-11-1.
 */
@Controller
@RequestMapping("/boss/account/companies")
public class CompaniesAccountController extends BaseAccountController {

    @Override
    protected String getViewBasePath() {
        return "/boss/account/companies/";
    }
    /**
     * 查询所有股东账号列表查询
     * 并统计当前股东账号下有多少商户数
     */
    @RequestMapping("/companiesList")
    public String shareholderList(SysUserExtendListVo listVo, SysUserExtendSearchForm form, BindingResult result, Model model, HttpServletRequest request) {
        SysUserExtendListVo companiesList = queryAccountListByType(listVo, UserTypeEnum.COMPANIES.getCode());
        //所有的股东列表
        model.addAttribute("command", companiesList);
        List<String> list =new ArrayList<>();
        list.add(SubSysCodeEnum.COMPANY.getCode());
        //所有股东对应的商户数
        model.addAttribute("ownerIds", querySubCount(companiesList, list));
        if (ServletTool.isAjaxSoulRequest(request)) {
            return this.getViewBasePath() + "IndexPartial";
        } else {
            return this.getViewBasePath() + "Index";
        }
    }

    @Override
    @RequestMapping("/create")
//    @Token(generate = true)
    public String create(SysUserExtendVo objectVo, Model model, HttpServletRequest request, HttpServletResponse response) {
        return super.create(objectVo, model, request, response);
    }

    @Override
    @RequestMapping("/view")
    public String view(SysUserExtendVo objectVo, Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
        return super.view(objectVo, id, model, request, response);
    }

    /**
     * 添加运营商账号
     *
     * @param objectVo
     * @param form
     * @param result
     * @param request
     * @return
     */
    @RequestMapping("/addAccount")
    @ResponseBody
//    @Token(valid = true)
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_ACCOUNT_CM_ADD, opType = OpType.CREATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map addAccount(SysUserExtendVo objectVo, @FormModel @Valid SysUserExtendForm form, BindingResult result, HttpServletRequest request) {
        SysUserExtend operator = SessionManager.getSysUserExtend();
        objectVo.getResult().setUserType(UserTypeEnum.COMPANIES.getCode());
        objectVo.getResult().setSubsysCode(SubSysCodeEnum.COMPANIES.getCode());
        objectVo.getResult().setCreateUser(operator.getId());
        objectVo.getResult().setSuperiorOccupy(0.0);
        objectVo.getResult().setStintOccupy(0.0);
        objectVo.getResult().setCredits(0.0);
        if (StringTool.equals(UserTypeEnum.BOSS.getCode(), operator.getUserType())) {
            objectVo.getResult().setOwnerId(operator.getId());
        } else if (StringTool.equals(UserTypeEnum.BOSS_SUB.getCode(), operator.getUserType())) {
            objectVo.getResult().setOwnerId(operator.getOwnerId());
        }
        return getVoMessage(baseAddAccount(objectVo, form, result, request));
    }

    /**
     * 编辑股东账号
     *
     * @param userExtendVo
     * @param form
     * @param result
     * @param request
     * @return
     */
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_ACCOUNT_UPDATE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    @RequestMapping("/updateAccount")
    @ResponseBody
    public Map updateAccount(SysUserExtendVo userExtendVo, @FormModel @Valid SysUserExtendUpdateForm form, BindingResult result, HttpServletRequest request) {
        userExtendVo = baseUpdateAccount(userExtendVo, form, result, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 编辑股东账号
     */
    @RequestMapping("/editShAccount")
    public String editShAccount(Model model, Integer id) {
        editAccount(model, id);
        return getViewBasePath() + "Edit";
    }

    /**
     * 重置登录密码跳转页
     */
    @RequestMapping("/resetPwd")
    public String resetPwd(Model model, Integer id) {
        super.resetPassword(model, id);
        return getViewBasePath() + "ResetPwd";
    }

    /**
     * 重置登录密码保存
     */
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_PASSWORD_UPDATE, opType = OpType.UPDATE)
    @RequestMapping("/updateShPwd")
    @ResponseBody
    public Map updateShPwd(SysUserExtendVo userExtendVo, HttpServletRequest request, @FormModel @Valid ResetPwdForm form, BindingResult result) {
        userExtendVo = updatePwd(userExtendVo, form, result, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 更新状态
     * 根据ID  更新冻结和解冻
     */
    @RequestMapping("/freezeShStatus")
    @ResponseBody
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_STATUS_FREEZE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map freezeShStatus(SysUserExtendVo userExtendVo, HttpServletRequest request) {
        userExtendVo = baseFreezeStatus(userExtendVo, request);
        return getVoMessage(userExtendVo);
    }

    /**
     * 更新状态
     * 根据ID  更新停用和使用
     */
    @Audit(module = Module.ACCOUNT, moduleType = ModuleType.USER_STATUS_DISABLE_OR_NORMAL, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Map updateStatus(SysUserExtendVo userExtendVo, HttpServletRequest request) {
        userExtendVo = baseDisabledStatus(request, userExtendVo);
        return getVoMessage(userExtendVo);
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
