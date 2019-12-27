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
import org.soul.web.controller.BaseCrudController;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.company.user.form.AddSysUserExtendForm;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.model.company.user.po.CzRateKc;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
import so.wwb.creditbox.model.company.user.so.VSiteUserSo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserListVo;
import so.wwb.creditbox.model.company.user.vo.VSiteUserVo;
import so.wwb.creditbox.company.user.form.VSiteUserSearchForm;
import so.wwb.creditbox.company.user.form.VSiteUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.lottery.*;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.session.Session;
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.SysParamTool;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
//region your codes 1
public class AccountControllerBak extends BaseCrudController<IVSiteUserService, VSiteUserListVo, VSiteUserVo, VSiteUserSearchForm, VSiteUserForm, VSiteUser, Integer> {
    private static final Log LOG = LogFactory.getLog(AccountController.class);

//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3

    @Token(generate = true)
    public String fgsList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/FgsList";
    }
    @Token(generate = true)
    public String gdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/GdList";
    }
    @Token(generate = true)
    public String zdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/ZdList";
    }
    @Token(generate = true)
    public String dlList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/DlList";
    }
    @Token(generate = true)
    public String hyList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.PLAYER.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/HyList";
    }
    @Token(generate = true)
    public String childList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/ChildList";
    }


    @Token(generate = true)
    public String fgsAdd(VSiteUserVo objectVo,SysUserExtendVo sysUserExtendVo, Model model) {

        objectVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.COMPANY.getCode());


        //查詢上級用戶  begin
        sysUserExtendVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
        sysUserExtendVo.getSearch().setId(SessionManager.getSiteUserId());
        sysUserExtendVo = ServiceTool.sysUserExtendService().get(sysUserExtendVo);
//        sysUserExtendVo.getResult().setSuperiorOccupy(100 - sysUserExtendVo.getResult().getSuperiorOccupy());
        //查詢上級用戶 end

        objectVo.setParentUser(sysUserExtendVo.getResult());
        objectVo._setDataSourceId(SessionManager.getSiteId());
        objectVo = this.getService().get(objectVo);
        //如果是编辑要查询上级和下级的占用情况
        if(objectVo.getSearch().getId() != null){
            objectVo = this.getService().sumSuperStintOccupy(objectVo);
        }
        objectVo.setValidateRule(JsRuleCreator.create(AddSysUserExtendForm.class, "result"));

        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/edit/FgsEdit";
    }
    @Token(generate = true)
    public String gdAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.BRANCH.getCode());
        objectVo = createUser(objectVo,model);
        if(objectVo.isSuccess()){
            return getViewBasePath() + "/edit/GdEdit";
        }
        else {
            return getViewBasePath() + "/MessagePage";
        }

    }
    @Token(generate = true)
    public String zdAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.SHAREHOLDER.getCode());
        objectVo = createUser(objectVo,model);
        if(objectVo.isSuccess()){
            return getViewBasePath() + "/edit/ZdEdit";
        }
        else{
            return getViewBasePath() + "/MessagePage";
        }
    }
    @Token(generate = true)
    public String dlAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        objectVo = createUser(objectVo,model);
        if(objectVo.isSuccess()){
            return getViewBasePath() + "/edit/DlEdit";
        }
        else{
            return getViewBasePath() + "/MessagePage";
        }
    }
    @Token(generate = true)
    public String childAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        createUser(objectVo,model);
        return getViewBasePath() + "/ChildEdit";
    }
    @Token(generate = true)
    public String hyAddDu(VSiteUserVo objectVo, Model model) {
        VSiteUserSo search = objectVo.getSearch();
        search.setUserType(UserTypeEnum.PLAYER.getCode());
        if(objectVo.getRdoutype() == null){
            SubSysCodeEnum subSysCodeEnum = EnumTool.enumOf(SubSysCodeEnum.class, SessionManager.getSubsysCode());
            switch (subSysCodeEnum){
                case COMPANY:search.setOwnerUserType(UserTypeEnum.BRANCH.getCode());
                    break;
                case BRANCH:search.setOwnerUserType(UserTypeEnum.SHAREHOLDER.getCode());
                    break;
                case SHAREHOLDER:search.setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());
                    break;
                case DISTRIBUTOR:search.setOwnerUserType(UserTypeEnum.AGENT.getCode());
                    break;
            }
        }
        else {
            UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, objectVo.getRdoutype());
            search.setOwnerUserType(userTypeEnum.getCode());
        }

        objectVo = createUser(objectVo,model);
        if(objectVo.isSuccess()){
            return getViewBasePath() + "/edit/HyDuEdit";
        }
        else{
            return getViewBasePath() + "/MessagePage";
        }
    }

    @Token(generate = true)
    public String hyAdd(VSiteUserVo objectVo, Model model) {
        VSiteUserSo search = objectVo.getSearch();
        search.setUserType(UserTypeEnum.PLAYER.getCode());
        search.setOwnerUserType(UserTypeEnum.AGENT.getCode());

        objectVo = createUser(objectVo,model);
        if(objectVo.isSuccess()){
            return getViewBasePath() + "/edit/HyDuEdit";
        }
        else{
            return getViewBasePath() + "/MessagePage";
        }
    }

    public VSiteUserVo createUser(VSiteUserVo objectVo, Model model) {
        objectVo._setDataSourceId(SessionManager.getSiteId());
        objectVo = this.getService().get(objectVo);
        //查詢上級用戶  begin
//        objectVo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        objectVo = this.getService().searchSuperUser(objectVo);
        //查詢上級用戶 end
        if(objectVo.isSuccess()){
            objectVo = this.getService().sumSuperStintOccupy(objectVo);

            objectVo.setValidateRule(JsRuleCreator.create(AddSysUserExtendForm.class, "result"));
        }
        model.addAttribute("command", objectVo);
        LotteryCommonContext.get().getDomainUserName();
        return objectVo;
    }

    @Token(generate = true)
    @ResponseBody
    public String persistUser(SysUserExtendVo objectVo, Model model, HttpServletRequest request, @FormModel("result") @Valid AddSysUserExtendForm form, BindingResult result) {
//        if(objectVo.getResult().getStintOccupy() == null){
//            objectVo.getResult().setStintOccupy(0);
//        }
        if (result.hasErrors()) {
            objectVo.setSuccess(false);
            LOG.error("参数错误，保存失败");
            return "参数错误，保存失败";
        }

        if(objectVo.getResult().getId() == null){
            String subSysCode = getSubSysCode(objectVo.getResult().getUserType());
            objectVo.getResult().setSubsysCode(subSysCode);
            initAccount(objectVo,request);
            objectVo = this.getService().saveManagerUser(objectVo);


            objectVo.setDataSourceId(Const.BASE_DATASOURCE_ID);
        }
        else{
            objectVo.setDataSourceId(SessionManagerCommon.getSiteId());
            ServiceTool.sysUserExtendService().updateManagerUser(objectVo);
        }
        return "保存成功！";
    }
    @Token(generate = true)
    @ResponseBody
    public Map updateManagerUser(SysUserExtendVo objectVo, Model model, HttpServletRequest request, @FormModel("result") @Valid VSiteUserForm form, BindingResult result) {

        if (result.hasErrors()) {
            objectVo.setSuccess(false);
            LOG.error("参数错误，保存失败");
            return this.getVoMessage(objectVo);
        }
        objectVo.setDataSourceId(SessionManagerCommon.getSiteId());
        objectVo = ServiceTool.sysUserExtendService().updateManagerUser(objectVo);
        model.addAttribute("command", objectVo);
        return this.getVoMessage(objectVo);
    }
    /**
     * 获取用户系统编号
     */
    private String getSubSysCode(String userType) {
        String subSysCode ;
        UserTypeEnum userTypeEnum = EnumTool.enumOf(UserTypeEnum.class, userType);
        switch (userTypeEnum) {
            case BRANCH:
            case BRANCH_SUB:
                subSysCode = SubSysCodeEnum.BRANCH.getCode();
                break;
            case SHAREHOLDER:
            case SHAREHOLDER_SUB:
                subSysCode = SubSysCodeEnum.SHAREHOLDER.getCode();
                break;
            case DISTRIBUTOR:
            case DISTRIBUTOR_SUB:
                subSysCode = SubSysCodeEnum.DISTRIBUTOR.getCode();
                break;
            case AGENT:
            case AGENT_SUB:
                subSysCode = SubSysCodeEnum.AGENT.getCode();
                break;
            default: subSysCode = SubSysCodeEnum.HALL.getCode();
        }
        return subSysCode;
    }


    /**
     * 初始化注册参数
     * PS: userType、subsysCode、ownerId、createUser 数据请在入口进行处理
     */
    private void initAccount(SysUserExtendVo objectVo, HttpServletRequest request) {

        //剩餘占成和報表查詢權限，只有一下角色有
        if(UserTypeEnum.SHAREHOLDER.getCode().equals(objectVo.getResult().getUserType())
                ||UserTypeEnum.DISTRIBUTOR.getCode().equals(objectVo.getResult().getUserType())
                ||UserTypeEnum.AGENT.getCode().equals(objectVo.getResult().getUserType())){
//            objectVo.getResult().setBreakpoint(BreakpointEnum.ZERO.getCode());
//            objectVo.getResult().setGeneral(GeneralEnum.OFF.getCode());
        }
        objectVo.getResult().setCreateUser(SessionManager.getSysUserExtend().getId());
//        objectVo.getResult().setModeSelection(ModeSelectionEnum.CREDIT.getCode());
//        objectVo.getResult().setTestAccount(TestAccountEnum.NO.getCode());
        String createUserType = objectVo.getResult().getUserType();




        //查詢上級 start
        SysUserExtendVo ownerVo = new SysUserExtendVo();
        ownerVo.getSearch().setId(objectVo.getResult().getOwnerId());
        if(!UserTypeEnum.BRANCH.getCode().equals(objectVo.getResult().getUserType())){
            ownerVo.setDataSourceId(SessionManager.getSiteId());
        }
        SysUserExtend owner = ServiceTool.sysUserExtendService().get(ownerVo).getResult();
//        objectVo.getResult().setHid(this.getService().getHid(owner.getHid()));
        //查詢上級 end
//        objectVo.getResult().setOwnerName(owner.getUsername());
        objectVo.getResult().setSiteId(owner.getSiteId());
        objectVo.getResult().setDefaultCurrency(owner.getDefaultCurrency());
        objectVo.getResult().setDefaultTimezone(owner.getDefaultTimezone());
        objectVo.getResult().setDefaultLocale(owner.getDefaultLocale());
        String splitName = owner.getUsername();
        if (splitName.contains("@")) {
            splitName = splitName.substring(splitName.indexOf("@"));
            objectVo.getResult().setUsername(objectVo.getResult().getUsername() + splitName);
        }
        if (!UserTypeEnum.PLAYER.getCode().equals(createUserType)) {
            //对身份验证码进行DES加密处理
            String str = GoogleAuthenticator.generateSecretKey();
            String key = objectVo.getResult().getUsername();
            String secret = DesTool.encrypt(str, key);
            objectVo.getResult().setAuthenticationKey(secret);
        }
//        objectVo.getResult().setRegisterIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
//        objectVo.getResult().setRegisterIpDictCode(SessionManagerCommon.getIpDictCode());
//        objectVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
//        objectVo.getResult().setBuiltIn(false);
//        objectVo.getResult().setUskin(SkinEnum.BLUE.getCode());
//        objectVo.getResult().setSupName(SessionManager.getUserName());
//        objectVo.getResult().setUtype(UTypeEnum.ZJ.getCode());
//        objectVo.getResult().setSuType(UTypeEnum.ZGS.getCode());
//        objectVo.getResult().setAddDate(new Date());
//        objectVo.getResult().setSixRate(0);
//        objectVo.getResult().setSixCredit(0.0);
//        objectVo.getResult().setSixUsableCredit(0.0);
//        objectVo.getResult().setSixKind(KindEnum.DEFAULT.getCode());
//        objectVo.getResult().setAstate(1);
//        objectVo.getResult().setSixAllowSale(AllowSaleEnum.YES.getCode());
//        objectVo.getResult().setAllowViewReport(Integer.parseInt(AllowViewReportEnum.YES.getCode()));
//        objectVo.getResult().setSixAllowMaxrate(0);
//        objectVo.getResult().setSixLowMaxrate(0);
//        objectVo.getResult().setSixRateOwner(0);
//        objectVo.getResult().setSixIscash(Integer.parseInt(CashEnum.NO.getCode()));
//        objectVo.getResult().setAllowOpt(1);
//        objectVo.getResult().setIsChanged("");
//        objectVo.getResult().setKcRate(0);
//        objectVo.getResult().setKcCredit(9999999.0);
//        objectVo.getResult().setKcUsableCredit(99999999.0);
//        objectVo.getResult().setKcKind(KindEnum.DEFAULT.getCode());
//        objectVo.getResult().setKcAllowSale(Integer.parseInt(AllowSaleEnum.YES.getCode()));
//        objectVo.getResult().setKcAllowMaxrate(0);
//        objectVo.getResult().setKcRateOwner(0);
//        objectVo.getResult().setKcCrashPayment(0);
//        objectVo.getResult().setKcIscash(Integer.parseInt(CashEnum.NO.getCode()));
//        objectVo.getResult().setKcOpOdds(Integer.parseInt(OpOddEnum.YES.getCode()));
//        objectVo.getResult().setSixOpOdds(Integer.parseInt(OpOddEnum.YES.getCode()));
//        objectVo.getResult().setKcIsautoBack(0);
//        objectVo.getResult().setSixIsautoBack(0);



        //保存公司以下角色都要切換數據源
        objectVo.setDataSourceId(SessionManager.getSiteId());
    }


    public String ExistNameAjax(@RequestParam("uname") String username){
        if(StringTool.isNotBlank(username)){
            SysUserExtendVo objectVo = new SysUserExtendVo();
            objectVo.setResult(new SysUserExtend());
            objectVo.getResult().setUsername(username +"@%");
            objectVo.setDataSourceId(SessionManagerCommon.getSiteId());
            if(!SysParamTool.checkManageUsername(objectVo)){
                return "1";
            }
            else {
                return "0";
            }
        }else {
            return "2";
        }
    }
    //endregion your codes 3

}