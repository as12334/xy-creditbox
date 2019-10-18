package so.wwb.creditbox.manager.boss.site.controller;

import org.soul.commons.collections.MapTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.YesNot;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.log.audit.enums.OpType;
import org.soul.web.validation.form.annotation.FormModel;
import org.soul.web.validation.form.js.JsRuleCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.boss.site.form.VSysDomainSearchForm;
import so.wwb.creditbox.manager.boss.site.form.VSysDomainsForm;
import so.wwb.creditbox.manager.common.site.controller.BaseDomainController;
import so.wwb.creditbox.manager.form.content.SysDomainForm;
import so.wwb.creditbox.model.annotations.Audit;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.base.Module;
import so.wwb.creditbox.model.enums.base.ModuleType;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.sys.DomainPageUrlEnum;
import so.wwb.creditbox.model.enums.sys.ResolveStatusEnum;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.vo.SysDomainVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainListVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainVo;
import so.wwb.creditbox.web.tools.token.Token;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 域名管理
 * Created by dick on 18-6-30.
 */
@Controller
@RequestMapping("/account/domain")
public class BossDomainController extends BaseDomainController {

    @Override
    protected String getViewBasePath() {
        return "/boss/account/domain/";
    }

    @RequestMapping("/list")
    public String queryBillSalaryList(VSysDomainListVo listVo, VSysDomainSearchForm form, BindingResult result, Model model, HttpServletRequest request) {
        model.addAttribute("domainResolvestatus", getResolveStatusEnums());
//        model.addAttribute("domainTypes", getDomainTypeEnum("1")); //域名类型
        model.addAttribute("subSysCodes", EnumTool.getEnumList(SubSysCodeEnum.class)); //域名所属系统
        VSysDomainListVo cmd = super.doList(listVo, form, result, model);
        model.addAttribute("command", cmd);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "IndexPartial";
        } else {
            return getViewBasePath() + "Index";
        }
    }

    /**
     * 删除域名
     */
    @RequestMapping("/delete")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_DELETE, opType = OpType.DELETE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map delete(VSysDomainVo objectVo, HttpServletRequest request) {
        return super.delDomain(objectVo,request);
    }


    @RequestMapping("/persist")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ADD, opType = OpType.CREATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    @Token(valid = true)
    public Map persist(SysDomainVo objectVo, HttpServletRequest request) {
        return super.saveDomain(objectVo,request);
    }

    /**
     * 修改名称
     * @param objectVo
     * @param request
     * @return
     */
    @RequestMapping({"/persistDomain"})
    @ResponseBody
    @Token(valid = true)
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_UPDATE, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map persistDomain(SysDomainVo objectVo, HttpServletRequest request) {
        return updateDomain(objectVo,request);
    }


    @RequestMapping("/edit")
    @Token(generate = true)
    public String edit(SysDomainVo objectVo, Model model) {
        return getEdit(objectVo,model);
    }

    @RequestMapping("/bossEdit")
    @Token(generate = true)
    public String bossEdit(SysDomainVo objectVo, Model model) {
        return getEdit(objectVo,model);
    }

    @RequestMapping("/merchantEdit")
    @Token(generate = true)
    public String merchantEdit(SysDomainVo objectVo, Model model) {
        return getEdit(objectVo,model);
    }

    @RequestMapping("/shareHolderEdit")
    @Token(generate = true)
    public String shareHolderEdit(SysDomainVo objectVo, Model model) {
        return getEdit(objectVo,model);
    }

    private String getEdit(SysDomainVo objectVo, Model model){
        model.addAttribute("command", ServiceTool.sysDomainService().get(objectVo));
        return getViewBasePath() +"Edit";
    }

    /**
     * 是否启用
     *
     * @param sysDomainVo
     * @return
     */
    @RequestMapping("/changeStatus")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ISDISABLE, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map changeStatus(SysDomainVo sysDomainVo, HttpServletRequest request) {
        return updateStatus(sysDomainVo,request);
    }

    //boss
    @RequestMapping("/bossChangeStatus")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ISDISABLE, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map bossChangeStatus(SysDomainVo sysDomainVo, HttpServletRequest request) {
        return updateStatus(sysDomainVo,request);
    }

    @RequestMapping("/merchantChangeStatus")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ISDISABLE, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map merchantChangeStatus(SysDomainVo sysDomainVo, HttpServletRequest request) {
        return updateStatus(sysDomainVo,request);
    }

    @RequestMapping("/shareHolderChangeStatus")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ISDISABLE, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map shareHolderChangeStatus(SysDomainVo sysDomainVo, HttpServletRequest request) {
        return updateStatus(sysDomainVo,request);
    }

    private Map updateStatus(SysDomainVo sysDomainVo, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(1);
        if (sysDomainVo.getResult() == null || sysDomainVo.getResult().getId() == null) {
            map.put("state", false);
        }
        sysDomainVo.setProperties(SysDomain.PROP_IS_ENABLE);
        sysDomainVo = ServiceTool.sysDomainService().updateOnly(sysDomainVo);
        map.put("state", sysDomainVo.isSuccess());
        if (sysDomainVo.isSuccess()){
            sysDomainVo.getSearch().setId(sysDomainVo.getResult().getId());
            sysDomainVo = ServiceTool.sysDomainService().get(sysDomainVo);
            if (sysDomainVo.getResult() != null){
                addAuditLog(sysDomainVo, request,SITE_DOMAIN_ISDISABLE);
            }
        }
        CacheBase.refreshSiteDomain();
        return map;
    }


    /**
     * 待解绑
     *
     * @param sysDomainVo
     * @return
     */
    @RequestMapping("/toBound")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_TO_BOUND, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map toBound(SysDomainVo sysDomainVo, HttpServletRequest request) {
        return super.toBound(sysDomainVo,request);
    }

    /**
     * 解绑成功
     *
     * @param sysDomainVo
     * @return
     */
    @RequestMapping("/bounded")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_BOUNDED, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map boundle(SysDomainVo sysDomainVo, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(1);
        sysDomainVo = updateResolveStatus(ResolveStatusEnum.BOUNDED.getCode(), sysDomainVo);
        addAuditLog(sysDomainVo,request,SITE_DOMAIN_BOUNDED);
        map.put("state", sysDomainVo.isSuccess());
        map.put("msg", sysDomainVo.isSuccess() ? "操作成功" : "操作失败");
        CacheBase.refreshSiteDomain();
        return map;
    }

    /**
     * 解绑域名失败
     * 失败即绑定域名成功
     * @param sysDomainVo
     * @param request
     * @return
     */
    @RequestMapping("/boundedFail")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_BOUNDED_FAIL, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map boundedFail(SysDomainVo sysDomainVo, HttpServletRequest request){
        String requestType = "boundedFail";
        Map map = this.success(sysDomainVo, request, requestType);
        if (MapTool.getBoolean(map, "state")){
            addAuditLog(sysDomainVo,request,SITE_DOMAIN_BOUNDED_FAIL);
        }
        return map;
    }


    /**
     * 成功
     *
     * @param sysDomainVo
     * @return
     */
    @RequestMapping("/success")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_CHECK_SUCCESS, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map success(SysDomainVo sysDomainVo, HttpServletRequest request, String requestType) {
        Map<String, Object> map = new HashMap<>(1);
        sysDomainVo = updateResolveStatus(ResolveStatusEnum.SUCCESS.getCode(), sysDomainVo);
        if (StringTool.isBlank(requestType)){
            addAuditLog(sysDomainVo,request,SITE_DOMAIN_CHECK_SUCCESS);
        }
        map.put("state", sysDomainVo.isSuccess());
        map.put("msg", sysDomainVo.isSuccess() ? "操作成功" : "操作失败");
        CacheBase.refreshSiteDomain();
        return map;
    }

    /**
     * 失败
     *
     * @param sysDomainVo
     * @return
     */
    @RequestMapping("/fail")
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_CHECK_FAIL, opType = OpType.UPDATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    public Map fail(SysDomainVo sysDomainVo, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(1);
        sysDomainVo = updateResolveStatus(ResolveStatusEnum.FAIL.getCode(), sysDomainVo);
        addAuditLog(sysDomainVo,request,SITE_DOMAIN_CHECK_FAIL);
        map.put("state", sysDomainVo.isSuccess());
        map.put("msg", sysDomainVo.isSuccess() ? "操作成功" : "操作失败");
        CacheBase.refreshSiteDomain();
        return map;
    }

    /**
     * 验证域名唯一性
     *
     * @param domain
     * @return
     */
    @RequestMapping("/checkDomain")
    @ResponseBody
    public String checkDomain(@RequestParam("result.domain") String domain) {
        return checkDomainByDomain(domain);
    }


    /**
     * 站点管理--域名-点击新增跳转
     */
    @RequestMapping("/createDomain")
    @Token(generate = true)
    protected String create(SysDomainVo objectVo, Model model) {
        model.addAttribute("domainSiteId", objectVo.getSearch().getSiteId());
        objectVo.setValidateRule(JsRuleCreator.create(VSysDomainsForm.class, "result"));
        List<SubSysCodeEnum> list = new ArrayList<>();
        list.add(SubSysCodeEnum.COMPANY);
        list.add(SubSysCodeEnum.HALL);
        model.addAttribute("subSysCodes", list);
        model.addAttribute("command", objectVo);
        return getViewBasePath() + "/DomainEdit";
    }

    /**
     * 新增总代域名
     */
    @RequestMapping("/distributorCreate")
    @Token(generate = true)
    public String distributorCreate(VSysDomainVo objectVo, Model model) {
        objectVo = this.doCreate(objectVo, model);
        model.addAttribute("command", objectVo);
        model.addAttribute("sysUserId", objectVo.getSearch().getSysUserId());
        /*SysUserExtendListVo sysUserExtendListVo = new SysUserExtendListVo();
        sysUserExtendListVo.getSearch().setSiteId(objectVo.getSearch().getSiteId());
        List<String> list = new ArrayList<>();
        list.add(SubSysCodeEnum.DISTRIBUTOR.getCode());
        list.add(SubSysCodeEnum.DISTRIBUTOR.getCode());
        sysUserExtendListVo.getSearch().setSubSysCodes(list);
        sysUserExtendListVo.getSearch().setStatus(SysUserStatus.NORMAL.getCode());
        sysUserExtendListVo.setPaging(null);
        sysUserExtendListVo= ServiceTool.sysUserExtendService().search(sysUserExtendListVo);
        model.addAttribute("agentList", sysUserExtendListVo);*/
        objectVo.setValidateRule(JsRuleCreator.create(SysDomainForm.class));
        return this.getViewBasePath() + "DistributorAdd";
    }


    /**
     * 新增股东域名
     */
    @RequestMapping("/shareholderCreate")
    @Token(generate = true)
    public String shareholderCreate(VSysDomainVo objectVo, Model model) {
        objectVo = this.doCreate(objectVo, model);
        model.addAttribute("command", objectVo);
        objectVo.setValidateRule(JsRuleCreator.create(SysDomainForm.class));
        return this.getViewBasePath() + "ShareHolderAdd";
    }


    /**
     * 新增股东域名
     */
    @RequestMapping("/bossCreate")
    @Token(generate = true)
    public String bossCreate(VSysDomainVo objectVo, Model model) {
        objectVo = this.doCreate(objectVo, model);
        model.addAttribute("command", objectVo);
        objectVo.setValidateRule(JsRuleCreator.create(SysDomainForm.class));
        return this.getViewBasePath() + "BossAdd";
    }



    /**
     * 保存总代域名
     * @param sysDomainVo
     * @param form
     * @param result
     * @return
     */
    @RequestMapping("/addDistributorDomain")
    @ResponseBody
    @Audit(module = Module.DOMAIN, moduleType = ModuleType.CONTENT_SITE_DISTRIBUTOR_DOMAIN_ADD, opType = OpType.CREATE,ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map addAgentDomain(SysDomainVo sysDomainVo, @FormModel("result") @Valid SysDomainForm form, BindingResult result, HttpServletRequest request) {
        return saveDistributor(sysDomainVo,result,request);
    }

    @RequestMapping("/addShareholderDomain")
    @ResponseBody
    @Audit(module = Module.DOMAIN, moduleType = ModuleType.CONTENT_SITE_SHAREHOLDER_DOMAIN_ADD, opType = OpType.CREATE,ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map addShareholderDomain(SysDomainVo sysDomainVo, @FormModel("result") @Valid SysDomainForm form, BindingResult result, HttpServletRequest request) {
        Map map = new HashMap();
        if (!result.hasErrors()) {
            SysDomain sysDomain = sysDomainVo.getResult();
            sysDomain.setSubsysCode(SubSysCodeEnum.SHAREHOLDER.getCode());
            sysDomain.setPageUrl(DomainPageUrlEnum.COMPANY.getCode());
            addDomain(map,sysDomainVo,result,request,CONTENT_SITE_SHAREHOLDER_DOMAIN_ADD);
            return this.getVoMessage(sysDomainVo);
        }
        return map;
    }


    @RequestMapping("/addBossDomain")
    @ResponseBody
    @Audit(module = Module.DOMAIN, moduleType = ModuleType.CONTENT_SITE_SHAREHOLDER_DOMAIN_ADD, opType = OpType.CREATE,ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
    public Map addBossDomain(SysDomainVo sysDomainVo, @FormModel("result") @Valid SysDomainForm form, BindingResult result, HttpServletRequest request) {
        Map map = new HashMap();
        if (!result.hasErrors()) {
            SysDomain sysDomain = sysDomainVo.getResult();
            sysDomain.setSubsysCode(SubSysCodeEnum.BOSS.getCode());
            sysDomain.setPageUrl(DomainPageUrlEnum.COMPANY.getCode());
            sysDomain.setSysUserId(0);
            sysDomain.setSiteId(0);
            addDomain(map,sysDomainVo,result,request,CONTENT_SITE_BOSS_DOMAIN_ADD);
            return this.getVoMessage(sysDomainVo);
        }
        return map;
    }

    /**
     * 站点管理-保存数据
     */
    @RequestMapping("/doSaveAgent")
    @Token(valid = true)
    @ResponseBody
    @Audit(module= Module.DOMAIN,moduleType = ModuleType.SITE_DOMAIN_ADD, opType = OpType.CREATE,ignoreForm = YesNot.YES,isSystem = YesNot.NOT)
    protected Map doSaveAgent(VSysDomainVo objectVo, BindingResult result, HttpServletRequest request) {
        return saveAgent(objectVo,result,request);
    }

}
