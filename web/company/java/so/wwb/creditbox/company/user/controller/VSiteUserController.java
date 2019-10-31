package so.wwb.creditbox.company.user.controller;

import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.init.context.Const;
import org.soul.commons.lang.string.HidTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.gameapi.param.User;
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
import so.wwb.creditbox.model.manager.user.so.SysUserExtendSo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.model.session.Session;
import so.wwb.creditbox.utility.CommonTool;
import so.wwb.creditbox.utility.DesTool;
import so.wwb.creditbox.web.passport.captcha.GoogleAuthenticator;
import so.wwb.creditbox.web.tools.SessionManagerCommon;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
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
@RequestMapping("/vSiteUser")
public class VSiteUserController extends BaseCrudController<IVSiteUserService, VSiteUserListVo, VSiteUserVo, VSiteUserSearchForm, VSiteUserForm, VSiteUser, Integer> {
    private static final Log LOG = LogFactory.getLog(VSiteUserController.class);

//endregion your codes 1

    @Override
    protected String getViewBasePath() {
        //region your codes 2
        return "/user/";
        //endregion your codes 2
    }

    //region your codes 3

    @RequestMapping("/createUser/4")
    @Token(generate = true)
    public String createUser4(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.BRANCH.getCode());
        objectVo._setDataSourceId(Const.BOSS_DATASOURCE_ID);
        return createUser(objectVo,model);
    }
    @RequestMapping("/createUser/5")
    @Token(generate = true)
    public String createUser5(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.SHAREHOLDER.getCode());
        return createUser(objectVo,model);
    }
    @RequestMapping("/createUser/6")
    @Token(generate = true)
    public String createUser6(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        return createUser(objectVo,model);
    }
    @RequestMapping("/createUser/7")
    @Token(generate = true)
    public String createUser7(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.AGENT.getCode());
        return createUser(objectVo,model);
    }
    @RequestMapping("/createUser/8")
    @Token(generate = true)
    public String createUser8(VSiteUserVo objectVo, Model model) {
        objectVo.getSearch().setUserType(UserTypeEnum.PLAYER.getCode());
        createUser(objectVo,model);
        return getViewBasePath() + "/PlayEdit";
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
        //只有分公司並且開啟了賠率設置 才能新增賠率
        if(objectVo.getResult().getUserType().equals(UserTypeEnum.BRANCH.getCode()) && SetOddsEnum.ON.getCode().equals(objectVo.getResult().getSetOdds())){
            this.getService().doInitUserLotteryOdd(objectVo);
        }
        //只有新增主賬號才有返水設置
        if(objectVo.getResult().getUserType().length()==1){
            this.getService().doInitUserLotteryOdd(objectVo);

        }
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
            objectVo.getResult().setStintOccupy(-1.0);
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
        objectVo.getResult().setParentName(owner.getUsername());
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
        Map map = new HashMap<>();
        if(UserTypeEnum.SHAREHOLDER.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.DISTRIBUTOR.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.AGENT.getCode().equals(vo.getSearch().getUserType())
                || UserTypeEnum.PLAYER.getCode().equals(vo.getSearch().getUserType())){
            vo.setDataSourceId(SessionManagerCommon.getSiteId());
        }else{
            vo.setDataSourceId(Const.BOSS_DATASOURCE_ID);
        }
        vo = ServiceTool.sysUserExtendService().get(vo);
        map.put("shareCredits",vo.getResult().getCredits());
        map.put("superiorOccupy",vo.getResult().getStintOccupy());
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