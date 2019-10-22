package so.wwb.creditbox.manager.account.site.controller;

import org.soul.commons.collections.MapTool;
import org.soul.commons.dict.DictTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleDateTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.web.controller.BaseCrudController;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.sys.IVSysSiteManageService;
import so.wwb.creditbox.manager.account.site.form.VSiteMasterForm;
import so.wwb.creditbox.manager.account.site.form.VSysSiteManageForm;
import so.wwb.creditbox.manager.account.site.form.VSysSiteManageSearchForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.enums.base.DictEnum;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.site.SiteCurrencyTypeEnum;
import so.wwb.creditbox.model.enums.site.SiteLanguageEnum;
import so.wwb.creditbox.model.enums.sys.SysUserTypeEnum;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.site.po.VSiteMasterManage;
import so.wwb.creditbox.model.manager.site.vo.VSiteMasterManageVo;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageVo;
import so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.AuditAddLogTool;
import so.wwb.creditbox.web.tools.token.Token;
import so.wwb.creditbox.web.tools.token.TokenHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


/**
 * 控制器
 *
 * @author jerry
 */
@Controller
//region your codes 1
@RequestMapping("/vSysSiteManage")
public class VSysSiteManageController extends BaseCrudController<IVSysSiteManageService, VSysSiteManageListVo,
        VSysSiteManageVo, VSysSiteManageSearchForm, VSysSiteManageForm, VSysSiteManage, Integer> {
//endregion your codes 1
    private static final String SYS_CREATE_SITE = "sys.create.site";
    private static final String SITE_DOMAIN_MAINTENANCE_START = "site.domain.maintenance.start";
    private static final String SITE_DOMAIN_MAINTENANCE_END = "site.domain.maintenance.end";

    private static final org.soul.commons.log.Log LOG = org.soul.commons.log.LogFactory.getLog(VSysSiteManageController.class);
    @Override
    protected String getViewBasePath() {
        return "/account/site/siteManage/";
    }

    //region your codes 3

    /**
     * 1.站点基本信息
     * @param objectVo search 中包含 step和sysUserId
     */
    @RequestMapping("/siteBasic")
//    @Token(generate = true)
    public String siteBasic(VSysSiteManageVo objectVo, Model model, HttpServletRequest request) {
        // 如果lastStep 传参有值，是游戏配额和状态开启上一步操作
        TimeZone tz = null;
        Integer masterId = objectVo.getSearch().getSysUserId();
        if (StringTool.isNotEmpty(objectVo.getSearch().getLastStep())) {
            if (Objects.equals(SessionManager.getSysUserExtend().getUserType(), UserTypeEnum.SHAREHOLDER.getCode())
                    || Objects.equals(SessionManager.getSysUserExtend().getUserType(), UserTypeEnum.SHAREHOLDER_SUB.getCode())) {
                SessionManager.setBaseObjectVo(SessionManager.SESSION_SITE_NET_SCHEME, objectVo);
            }
            objectVo = (VSysSiteManageVo) SessionManager.getBaseObjectVo(SessionManager.SESSION_SITE_BASIC);
            objectVo.getSearch().setSysUserId(objectVo.getResult().getSysUserId());
            objectVo.getSearch().setStep("1");
            tz = TimeZone.getTimeZone(objectVo.getResult().getTimezone());
        } else {
            if (masterId != null) {
                SysUser master = getMaster(masterId);
                if (master != null) {
                    tz = TimeZone.getTimeZone(master.getDefaultTimezone());
                }
            }
            if (tz == null) {
                tz = TimeZone.getTimeZone(SessionManager.getUser().getDefaultTimezone());
            }
        }

        List<SiteLanguageEnum> SiteLanguageEnum = EnumTool.getEnumList(SiteLanguageEnum.class);
        // 开通的语言包
        model.addAttribute("siteLanguage", SiteLanguageEnum);

        List<SiteCurrencyTypeEnum> SiteCurrencyEnum = EnumTool.getEnumList(SiteCurrencyTypeEnum.class);
        // 开通的货币
        model.addAttribute("siteCurrency", SiteCurrencyEnum);

        // 字典时区
        model.addAttribute("dictTimeZone", DictTool.get(DictEnum.COMMON_TIME_ZONE));
        model.addAttribute("serviceDate", new Date());

        //获得站长信息
        objectVo.setvSiteMasterManage(masterView(objectVo.getSearch().getSysUserId()));
        objectVo.setValidateRule(JsRuleCreator.create(VSysSiteManageForm.class, "result"));

        model.addAttribute("command", objectVo);
        model.addAttribute("cTime", tz.getID());
        model.addAttribute("tz", tz);

        //用户类型是从上一个链接带过来，这个是上一步需要使用到
        if (objectVo.getSearch().getUserType() != null) {
            SessionManager.setCurrentUserType(SessionManager.SESSION_CURRENT_USER_TYPE, objectVo.getSearch().getUserType());
        }
        SysUser user = getMaster(masterId);
        model.addAttribute("subSysCode", user.getSubsysCode());
        return getViewBasePath() + "EditSiteBasic";
    }



    /**
     * 提交建站信息
     */
    @RequestMapping("/submit")
    @ResponseBody
//    @Token(valid = true)
    @Audit(module = Module.CUSTOMER,moduleType = ModuleType.SYS_CREATE_SITE,opType = OpType.CREATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map<String, Object> submit(VSysSiteManageVo objectVo, @FormModel("result") @Valid VSysSiteManageForm form, BindingResult result, HttpServletRequest request, Model model) {
        Map<String, Object> map;
        if (result.hasErrors()) {
            objectVo.setSuccess(false);
            objectVo.setErrMsg("信息填写有误");
            return getVoMessage(objectVo);
        }
        if(objectVo.getResult().getId()==null){
            objectVo.setSuccess(false);
            return getVoMessage(objectVo);
        }
        if(objectVo.getResult().getSysUserId()==null){
            objectVo.setSuccess(false);
            return getVoMessage(objectVo);
        }
        //得到站点拥有人
        SysUserExtendVo sysUserExtendvo=new SysUserExtendVo();
        sysUserExtendvo.getSearch().setId(objectVo.getResult().getSysUserId());
        sysUserExtendvo = ServiceTool.sysUserExtendService().get(sysUserExtendvo);
        if(sysUserExtendvo.getResult()!=null){
            objectVo.setSubCode(sysUserExtendvo.getResult().getSubsysCode());
            objectVo.getResult().setHid(sysUserExtendvo.getResult().getHid());
        }
        SysSiteVo sysSiteVo = new SysSiteVo();
        SysSite sysSite = new SysSite();
        sysSite.setId(objectVo.getResult().getId());
        sysSiteVo.setResult(sysSite);
        SysSiteVo Vo = ServiceTool.sysSiteService().get(sysSiteVo);
        if(Vo.getResult()!=null){
            objectVo.setSuccess(false);
            objectVo.setErrMsg("站点ID已经存在,请重新输入");
            return getVoMessage(objectVo);
        }else{
            objectVo.setCreateUser(SessionManager.getUserId());
            objectVo = getService().saveBuildSite(objectVo);

            if (objectVo.isSuccess()) {
                Cache.refreshSiteDomain();
                Cache.refreshSysSite();
                map  = this.getVoMessage(objectVo);
                if(!MapTool.getBoolean(map,"state")){
                    map.put(TokenHandler.TOKEN_VALUE,TokenHandler.generateGUID());
                }
                List<String> params = new ArrayList<>();
                params.add(objectVo.getResult().getId().toString());
                params.add(objectVo.getResult().getSiteName());
                params.add(objectVo.getResult().getSiteClassifyKey());
                params.add(objectVo.getResult().getSysUserId().toString());
                AuditAddLogTool.addLog(request,SYS_CREATE_SITE,params);
                return map;
            } else {
                objectVo.setSuccess(false);
                return getVoMessage(objectVo);
            }
        }

    }

    /**
     * 获取用户信息根据sys_user_id
     */
    private SysUser getMaster(Integer masterId) {
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.getSearch().setId(masterId);
        sysUserVo = ServiceTool.sysUserService().get(sysUserVo);
        return sysUserVo.getResult();
    }

    /**
     * 站长信息
     */
    private VSiteMasterManage masterView(Integer sysUserId) {
        VSiteMasterManageVo vSiteMasterManageVo = new VSiteMasterManageVo();
        vSiteMasterManageVo.getSearch().setId(sysUserId);
        return ServiceTool.vSiteMasterManageService().get(vSiteMasterManageVo).getResult();
    }

    /**
     * 商户站点维护跳转--maintain
     */
    @RequestMapping("/sysMerchantSiteMaintain")
    @Token(generate = true)
    public String sysMerchantSiteMaintain(SysSiteVo sysSiteVo, Model model) {
        this.addMaintainParams(sysSiteVo, model);
        return "account/site/detail/platformMaintainEdit";
    }

    /**
     * 股东站点维护跳转--maintain
     */
    @RequestMapping("/sysShareholderSiteMaintain")
    @Token(generate = true)
    public String sysShareholderSiteMaintain(SysSiteVo sysSiteVo, Model model) {
        this.addMaintainParams(sysSiteVo, model);
        return "account/site/detail/platformMaintainEdit";
    }

    private void addMaintainParams(SysSiteVo sysSiteVo, Model model) {
        model.addAttribute("validateRule", JsRuleCreator.create(VSiteMasterForm.class));
        sysSiteVo = ServiceTool.sysSiteService().get(sysSiteVo);
        model.addAttribute("command", sysSiteVo);
    }

    /**
     * 提前结束商户站点维护
     */
    @RequestMapping("/sysMerchantSiteMaintainEnd")
    @ResponseBody
    @Token(generate = true)
    @Audit(module = Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_MAINTENANCE,opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map sysMerchantSiteMaintainEnd(SysSiteVo sysSiteVo,HttpServletRequest request) {
        return this.baseSiteMaintainEnd(sysSiteVo, request);
    }

    /**
     * 提前结束股东站点维护
     */
    @RequestMapping("/sysShareholderSiteMaintainEnd")
    @ResponseBody
    @Token(generate = true)
    @Audit(module = Module.DOMAIN, moduleType = ModuleType.SITE_DOMAIN_MAINTENANCE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map sysShareholderSiteMaintainEnd(SysSiteVo sysSiteVo, HttpServletRequest request) {
        return this.baseSiteMaintainEnd(sysSiteVo, request);
    }

    private Map baseSiteMaintainEnd(SysSiteVo sysSiteVo, HttpServletRequest request) {
        if (sysSiteVo.getResult().getId() == null) {
            return null;
        }
        SysSiteVo vo = new SysSiteVo();
        vo.getSearch().setId(sysSiteVo.getResult().getId());
        SysSiteVo siteVo = ServiceTool.sysSiteService().get(vo);
        if (siteVo.getResult() != null) {//把停用状态改为正常
            siteVo.getResult().setMaintainEndTime(null);
            siteVo.getResult().setMaintainStartTime(null);
            siteVo = ServiceTool.sysSiteService().update(siteVo);
            if (siteVo.isSuccess()) {
                addAuditLog(siteVo, request, SITE_DOMAIN_MAINTENANCE_END);
            }
            Cache.refreshSiteDomain();
            Cache.refreshSysSite();
        }
        return this.getVoMessage(sysSiteVo);
    }

    /**
     * 保存---平台维护
     */
    @RequestMapping("/saveSiteMaintain")
    @ResponseBody
    @Audit(module = Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_MAINTENANCE,opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map saveSiteMaintain(SysSiteVo sysSiteVo,HttpServletRequest request) {
        if(sysSiteVo.getResult().getId()==null){
            return null;
        }
        SysSiteVo vo = new SysSiteVo();
        vo.getSearch().setId(sysSiteVo.getResult().getId());
        SysSiteVo  siteVo = ServiceTool.sysSiteService().get(vo);
        if (siteVo.getResult() != null) {//把停用状态改为正常
            siteVo.getResult().setMaintainStartTime(sysSiteVo.getResult().getMaintainStartTime());
            siteVo.getResult().setMaintainEndTime(sysSiteVo.getResult().getMaintainEndTime());
            siteVo.getResult().setMaintainReason(sysSiteVo.getResult().getMaintainReason());
            siteVo.setProperties(SysSite.PROP_MAINTAIN_START_TIME,SysSite.PROP_MAINTAIN_END_TIME,SysSite.PROP_MAINTAIN_REASON);
            siteVo = ServiceTool.sysSiteService().updateOnly(siteVo);
            Cache.refreshSysSite();
            Cache.refreshSiteDomain();
            if (siteVo.isSuccess()){
                addAuditLog(siteVo,request,SITE_DOMAIN_MAINTENANCE_START);
            }
        }
        return this.getVoMessage(sysSiteVo);
    }

    private void addAuditLog(SysSiteVo siteVo, HttpServletRequest request, String msgKey) {
        try {
            List<String> params = new ArrayList<>();
            params.add(siteVo.getResult().getId().toString());
            params.add(siteVo.getResult().getName());
            String type = siteVo.getResult().getSiteClassifyKey();
            for (SysUserTypeEnum typeEnum : SysUserTypeEnum.values()){
                if (StringTool.equals(typeEnum.getCode(),type)){
                    type = typeEnum.getTrans();
                }
            }
            params.add(type);
            if (StringTool.equals(SITE_DOMAIN_MAINTENANCE_END,msgKey)){
                AuditAddLogTool.addLog(request,msgKey,params);
                return;
            }
            params.add(
                    LocaleDateTool.formatDate(siteVo.getResult().getMaintainStartTime(), DateTool.yyyy_MM_dd_HH_mm_ss, SessionManager.getTimeZone())
                    +"~" + LocaleDateTool.formatDate(siteVo.getResult().getMaintainEndTime(), DateTool.yyyy_MM_dd_HH_mm_ss,SessionManager.getTimeZone())
            );
            AuditAddLogTool.addLog(request,msgKey,params);
        }catch (Exception e){
            LOG.error("编辑平台维护，保存审计日志异常{0}",e.getMessage());
        }
    }


    @RequestMapping(value = "/checkSiteCode")
    @ResponseBody
    public String checkSiteCode(@RequestParam("result.code") String code) {
        SysSiteVo vo = new SysSiteVo();
        vo.getSearch().setCode(code);
        return ServiceTool.sysSiteService().checkSiteCode(vo);
    }

    @RequestMapping(value = "/checkSiteId")
    @ResponseBody
    public String checkSiteId(@RequestParam("result.id") Integer id) {
        SysSiteVo vo = new SysSiteVo();
        vo.getSearch().setId(id);
        return ServiceTool.sysSiteService().checkSiteId(vo);
    }



}