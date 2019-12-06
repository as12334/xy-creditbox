package so.wwb.creditbox.company.user.controller;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.Const;
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
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.company.session.SessionManager;
import so.wwb.creditbox.company.user.form.AddSysUserExtendForm;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.model.company.user.po.VSiteUser;
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
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
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
        return super.list(listVo, form, result, model, request, response);
    }
    @RequestMapping("/gd_list")
    @Token(generate = true)
    public String gdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        return super.list(listVo, form, result, model, request, response);
    }
    @RequestMapping("/zd_list")
    @Token(generate = true)
    public String zdList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        return super.list(listVo, form, result, model, request, response);
    }
    @RequestMapping("/dl_list")
    @Token(generate = true)
    public String dlList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        return super.list(listVo, form, result, model, request, response);
    }
    @RequestMapping("/hy_list")
    @Token(generate = true)
    public String hyList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
        listVo.getSearch().setUserType(UserTypeEnum.PLAYER.getCode());
        return super.list(listVo, form, result, model, request, response);
    }
    @RequestMapping("/child_list")
    @Token(generate = true)
    public String childList(VSiteUserListVo listVo,VSiteUserSearchForm form, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) {
//        listVo.getSearch().setUserType(UserTypeEnum..getCode());
        return super.list(listVo, form, result, model, request, response);
    }


    @RequestMapping("/fgs_add")
    @Token(generate = true)
    public String fgsAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.COMPANY.getCode());
        objectVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
        return createUser(objectVo,model);
    }
    @RequestMapping("/gd_add")
    @Token(generate = true)
    public String gdAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.BRANCH.getCode());

        return createUser(objectVo,model);
    }
    @RequestMapping("/zd_add")
    @Token(generate = true)
    public String zdAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.SHAREHOLDER.getCode());

        return createUser(objectVo,model);
    }
    @RequestMapping("/dl_add")
    @Token(generate = true)
    public String dlAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());

        return createUser(objectVo,model);
    }
    @RequestMapping("/child_add")
    @Token(generate = true)
    public String childAdd(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        objectVo.getSearch().setOwnerUserType(UserTypeEnum.DISTRIBUTOR.getCode());

        return createUser(objectVo,model);
    }
    @RequestMapping("/hy_add")
    @Token(generate = true)
    public String hyAdd(VSiteUserVo objectVo, Model model) {
        String thisUserType = SessionManager.getUser().getUserType();
        //如果不是代理新增会员
        if(!thisUserType.equals(UserTypeEnum.AGENT.getCode())){
            //第一次加载新增会员页面，默认本用户类型
            if(StringTool.isBlank(objectVo.getSearch().getOwnerUserType())){
                //如果是公司类型，默认分公司类型
                if(thisUserType.equals(UserTypeEnum.COMPANY.getCode())){
                    objectVo.getSearch().setOwnerUserType(UserTypeEnum.BRANCH.getCode());
                }
                else {
                    objectVo.getSearch().setOwnerUserType(thisUserType);
                }
            }
        }
        objectVo.getSearch().setUserType(UserTypeEnum.PLAYER.getCode());
        return  createUser(objectVo,model);
    }



    public String createUser(VSiteUserVo objectVo, Model model) {
        //查詢上級用戶  begin
        objectVo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        objectVo = this.getService().searchLevelUser(objectVo);
        //查詢上級用戶 end
        objectVo.setValidateRule(JsRuleCreator.create(AddSysUserExtendForm.class, "result"));

        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/Edit";
    }

    @RequestMapping("/saveManagerUser")
    @Token(generate = true)
    @ResponseBody
    public Map saveManagerUser(SysUserExtendVo objectVo, Model model, HttpServletRequest request, @FormModel("result") @Valid AddSysUserExtendForm form, BindingResult result) {

        if (result.hasErrors()) {
            objectVo.setSuccess(false);
            LOG.error("参数错误，保存失败");
            return this.getVoMessage(objectVo);
        }
        String subSysCode = getSubSysCode(objectVo.getResult().getUserType());

        objectVo.getResult().setSubsysCode(subSysCode);
        initAccount(objectVo,request);
        objectVo = this.getService().saveManagerUser(objectVo);
        objectVo.setDataSourceId(Const.BASE_DATASOURCE_ID);
        //切換到管理庫
        model.addAttribute("command", objectVo);
        return this.getVoMessage(objectVo);
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

        if(objectVo.getResult().getStintOccupy() == null){
            objectVo.getResult().setStintOccupy(-1);
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

    /**
     * 獲取上級信息
     * @param vo
     * @return
     */
    @RequestMapping("/getSubInfo")
    @ResponseBody
    private Map getSubInfo(SysUserExtendVo vo){
        Integer maxSuperiorOccupy;
        Map map = new HashMap<>();
        if(UserTypeEnum.SHAREHOLDER.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.DISTRIBUTOR.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.AGENT.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.PLAYER.getCode().equals(vo.getSearch().getUserType())){
            vo._setDataSourceId(SessionManagerCommon.getSiteId());
            if(vo.getSearch().getId() == null){
                vo.getSearch().setId(vo.getSearch().getOwnerId());
                //获取上级使用成数
                vo = this.getService().sumSuperStintOccupy(vo);
            }
            else {
                //获取上下级已使用成数
                vo = ServiceTool.sysUserExtendService().get(vo);
                vo.getSearch().setHid(vo.getResult().getHid());
                vo = this.getService().sumSuperStintOccupyCount(vo);
            }
            maxSuperiorOccupy = vo.getSumSuperStintOccupy();
        }else{
            vo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
            maxSuperiorOccupy = 0;
        }

        //获取上级信息 start
        vo.getSearch().setId(vo.getSearch().getOwnerId());
        vo = ServiceTool.sysUserExtendService().get(vo);
        map.put("shareCredits",vo.getResult().getCredits());
        map.put("superiorOccupy",vo.getResult().getStintOccupy());
        //获取上级信息 end
        map.put("maxSuperiorOccupy",maxSuperiorOccupy);
        return map;
    }


    @RequestMapping("/createPlay")
    @Token(generate = true)
    public String createPlay(VSiteUserVo objectVo, Model model) {




        //查詢上級用戶  begin
        objectVo.getSearch().setHid(SessionManager.getSysUserExtend().getHid());
        //如果是查詢分公司的上級，要查詢管理庫
        if(UserTypeEnum.BRANCH.getCode().equals(objectVo.getSearch().getUserType())){
            objectVo._setDataSourceId(Const.BASE_DATASOURCE_ID);
        }
        objectVo = this.getService().searchLevelUser(objectVo);
        //查詢上級用戶 end


        objectVo.setValidateRule(JsRuleCreator.create(AddSysUserExtendForm.class, "result"));
        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/playEdit";
    }
    //endregion your codes 3

}