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
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author block
 * @time 2019-10-29 20:12:43
 */
@Controller
//region your codes 1
@RequestMapping("/account")
public class AccountController extends BaseCrudController<IVSiteUserService, VSiteUserListVo, VSiteUserVo, VSiteUserSearchForm, VSiteUserForm, VSiteUser, Integer> {
    private static final Log LOG = LogFactory.getLog(AccountController.class);

//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3

    @RequestMapping("/fgs_list")
    @Token(generate = true)
    public String fgsList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/FgsList";
    }
    @RequestMapping("/gd_list")
    @Token(generate = true)
    public String gdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/GdList";
    }
    @RequestMapping("/zd_list")
    @Token(generate = true)
    public String zdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/ZdList";
    }
    @RequestMapping("/dl_list")
    @Token(generate = true)
    public String dlList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/DlList";
    }
    @RequestMapping("/hy_list")
    @Token(generate = true)
    public String hyList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.PLAYER.getCode());
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/HyList";
    }
    @RequestMapping("/child_list")
    @Token(generate = true)
    public String childList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        super.list(listVo, form, result, model, request, response);
        return getViewBasePath() + "/list/ChildList";
    }


    @RequestMapping("/fgs_add")
    @Token(generate = true)
    public String fgsAdd(VSiteUserVo objectVo,SysUserExtendVo sysUserExtendVo, Model model) {

        objectVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.COMPANY.getCode());


        //查詢上級用戶  begin
        sysUserExtendVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
        sysUserExtendVo.getSearch().setId(SessionManager.getSiteUserId());
        sysUserExtendVo = ServiceTool.sysUserExtendService().get(sysUserExtendVo);
        sysUserExtendVo.getResult().setSuperiorOccupy(100 - sysUserExtendVo.getResult().getSuperiorOccupy());
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
    @RequestMapping("/gd_add")
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
    @RequestMapping("/zd_add")
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
    @RequestMapping("/dl_add")
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
    @RequestMapping("/child_add")
    @Token(generate = true)
    public String childAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        createUser(objectVo,model);
        return getViewBasePath() + "/ChildEdit";
    }
    @RequestMapping("/hy_add_du")
    @Token(generate = true)
    public String hyAdd(VSiteUserVo objectVo, Model model) {
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

        createUser(objectVo,model);
//        SysUserExtend parentUser;
//        search.setHid(SessionManager.getSysUserExtend().getHid());
//
//        objectVo._setDataSourceId(SessionManager.getSiteId());
//        Map<String, List<SysUserExtend>> stringListMap = this.getService().searchAllManagerList(objectVo);
//
//        if(StringTool.isBlank(objectVo.getRdoutype())){
//            if(search.getOwnerId() != null){
//                search.setId(search.getOwnerId());
//                SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
//                sysUserExtendVo.setDataSourceId(SessionManager.getSiteId());
//                sysUserExtendVo.getSearch().setId(search.getOwnerId());
//                sysUserExtendVo = ServiceTool.sysUserExtendService().get(sysUserExtendVo);
//                parentUser = sysUserExtendVo.getResult();
//
//                objectVo.setParentUser(sysUserExtendVo.getResult());
//                objectVo.setRdoutype(parentUser.getUserType());
//                objectVo.setSuperUserList(stringListMap.get(parentUser.getUserType()));
//                objectVo.setParentUser(parentUser);
//            }
//            else{
//                for (String s : stringListMap.keySet()) {
//                    List<SysUserExtend> vSiteUsers = stringListMap.get(s);
//                    objectVo.setRdoutype(s);
//                    objectVo.setSuperUserList(vSiteUsers);
//                    objectVo.setParentUser(vSiteUsers.get(0));
//                    break;
//                }
//            }
//
//        }
//        else {
//            List<SysUserExtend> sysUserExtends = stringListMap.get(objectVo.getRdoutype());
//            objectVo.setSuperUserList(sysUserExtends);
//            if(search.getOwnerId() != null){
//                search.setId(search.getOwnerId());
//                objectVo = this.getService().get(objectVo);
//                SysUserExtendVo sysUserExtendVo = new SysUserExtendVo();
//                sysUserExtendVo.getSearch().setId(search.getOwnerId());
//                sysUserExtendVo = ServiceTool.sysUserExtendService().get(sysUserExtendVo);
//                objectVo.setParentUser(sysUserExtendVo.getResult());
//            }
//            else if(sysUserExtends != null && sysUserExtends.size() > 0){
//
//                objectVo.setParentUser(sysUserExtends.get(0));
//                createUser(objectVo,model);
//            }else{
//                objectVo.setErrMsg("抱歉！您不能跨級新增帳戶！");
//                model.addAttribute("command",objectVo);
//                return getViewBasePath() + "/MessagePage";
//            }
//
//        }
//        objectVo = this.getService().sumSuperStintOccupy(objectVo);
//        model.addAttribute("command",objectVo);
        return getViewBasePath() + "/edit/HyDuEdit";
    }



    public VSiteUserVo createUser(VSiteUserVo objectVo, Model model) {
        objectVo._setDataSourceId(SessionManager.getSiteId());
        objectVo = this.getService().get(objectVo);
        //查詢上級用戶  begin
        objectVo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
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

    @RequestMapping("/persistUser")
    @Token(generate = true)
    @ResponseBody
    public String persistUser(SysUserExtendVo objectVo, Model model, HttpServletRequest request, @FormModel("result") @Valid AddSysUserExtendForm form, BindingResult result) {
        if(objectVo.getResult().getStintOccupy() == null){
            objectVo.getResult().setStintOccupy(0);
        }
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
    @RequestMapping("/updateManagerUser")
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
            objectVo.getResult().setBreakpoint(BreakpointEnum.ZERO.getCode());
            objectVo.getResult().setGeneral(GeneralEnum.OFF.getCode());
        }
        objectVo.getResult().setCreateUser(SessionManager.getSysUserExtend().getId());
        objectVo.getResult().setModeSelection(ModeSelectionEnum.CREDIT.getCode());
        objectVo.getResult().setTestAccount(TestAccountEnum.NO.getCode());
        String createUserType = objectVo.getResult().getUserType();




        //查詢上級 start
        SysUserExtendVo ownerVo = new SysUserExtendVo();
        ownerVo.getSearch().setId(objectVo.getResult().getOwnerId());
        if(!UserTypeEnum.BRANCH.getCode().equals(objectVo.getResult().getUserType())){
            ownerVo.setDataSourceId(SessionManager.getSiteId());
        }
        SysUserExtend owner = ServiceTool.sysUserExtendService().get(ownerVo).getResult();
        objectVo.getResult().setHid(this.getService().getHid(owner.getHid()));
        //查詢上級 end
        objectVo.getResult().setOwnerName(owner.getUsername());
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
        objectVo.getResult().setRegisterIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
        objectVo.getResult().setRegisterIpDictCode(SessionManagerCommon.getIpDictCode());
        objectVo.getResult().setStatus(SysUserStatus.NORMAL.getCode());
        objectVo.getResult().setBuiltIn(false);
        //保存公司以下角色都要切換數據源
        objectVo.setDataSourceId(SessionManager.getSiteId());
    }

//    /**
//     * 獲取上級信息
//     * @param vo
//     * @return
//     */
//    @RequestMapping("/getSubInfo")
//    @ResponseBody
//    private Map getSubInfo(VSiteUser vo){
//        Integer maxSuperiorOccupy;
//        Map map = new HashMap<>();
//        if(UserTypeEnum.SHAREHOLDER.getCode().equals(vo.getSearch().getUserType())
//                || UserTypeEnum.DISTRIBUTOR.getCode().equals(vo.getSearch().getUserType())
//                || UserTypeEnum.AGENT.getCode().equals(vo.getSearch().getUserType())
//                || UserTypeEnum.PLAYER.getCode().equals(vo.getSearch().getUserType())){
//            vo._setDataSourceId(SessionManagerCommon.getSiteId());
//            if(vo.getSearch().getId() == null){
//                vo.getSearch().setId(vo.getSearch().getOwnerId());
//                //获取上级使用成数
//                vo = this.getService().sumSuperStintOccupy(vo);
//            }
//            else {
//                //获取上下级已使用成数
//                vo = ServiceTool.sysUserExtendService().get(vo);
//                vo.getSearch().setHid(vo.getResult().getHid());
//                vo = this.getService().sumSuperStintOccupyCount(vo);
//            }
//            maxSuperiorOccupy = vo.getSumSuperStintOccupy();
//        }else{
//            vo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
//            maxSuperiorOccupy = 0;
//        }
//
//        //获取上级信息 start
//        vo.getSearch().setId(vo.getSearch().getOwnerId());
//        vo = ServiceTool.sysUserExtendService().get(vo);
//        map.put("shareCredits",vo.getResult().getCredits());
//        map.put("superiorOccupy",vo.getResult().getStintOccupy());
//        //获取上级信息 end
//        map.put("maxSuperiorOccupy",maxSuperiorOccupy);
//        return map;
//    }


    @RequestMapping("/createPlay")
    @Token(generate = true)
    public String createPlay(VSiteUserVo objectVo, Model model) {




        //查詢上級用戶  begin
        objectVo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        //如果是查詢分公司的上級，要查詢管理庫
        if(UserTypeEnum.BRANCH.getCode().equals(objectVo.getSearch().getUserType())){
            objectVo._setDataSourceId(Const.BASE_DATASOURCE_ID);
        }
//        objectVo = this.getService().searchLevelUser(objectVo);
        //查詢上級用戶 end


        objectVo.setValidateRule(JsRuleCreator.create(AddSysUserExtendForm.class, "result"));
        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/playEdit";
    }

    @RequestMapping("/existNameAjax")
    @ResponseBody
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