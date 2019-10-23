package so.wwb.creditbox.manager.boss.site.controller;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.manager.common.site.controller.BaseDetailController;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.manager.sys.vo.SysSiteVo;
import so.wwb.creditbox.model.manager.sys.vo.VSysDomainListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ronnie
 * @date: 17-11-6
 */
@Controller
@RequestMapping("/site/companySiteDetail")
public class CompanySiteDetailController extends BaseDetailController {

    private static Log LOG = LogFactory.getLog(CompanySiteDetailController.class);
    protected String getViewBasePath() {
        return "/boss/site/company/detail/";
    }

//    /**
//     * 站点信息
//     */
//    @RequestMapping("/viewSiteMerchant")
//    public String viewSiteMerchant(VSysSiteUserVo vSysSiteUserVo, Model model) {
//        Integer siteId = vSysSiteUserVo.getSearch().getId();
//        if ("2".equals(vSysSiteUserVo.getSearch().getType())) {
//            SysParam sysParam = checkVerification(siteId);
////            SysParam dome = checkDemoParams(siteId);
//            model.addAttribute("sysParam", sysParam!=null?sysParam.getParamValue():null);//转站
//            model.addAttribute("dome", dome!=null?dome.getParamValue():null);
//            model.addAttribute("checkRealName", checkRealNameParams(siteId));
//            model.addAttribute("checkMobile", checkMobileParams(siteId));
//            model.addAttribute("checkWeixin", checkWeinxinParams(siteId));
//            model.addAttribute("disc", disc(vSysSiteUserVo.getSearch().getId()));
//            model.addAttribute("payee_bank_alipay", checkPayeeBankAlipayParams(siteId));
//            model.addAttribute("payee_bank_weixin", checkPayeeBankWeixinParams(siteId));
//            model.addAttribute("apiTransferSite", checkApiTransferSite(siteId));
//        }
//        return getVSysSiteUserVo(vSysSiteUserVo, model);
//    }

//    /**
//     * 盘口参数
//     */
//
//    private SysParam disc(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_DISC);
//    }
//
//    /**
//     * 转站开关
//     *
//     * @param siteId
//     * @return
//     */
//    private SysParam checkVerification(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_SYSTEM_SETTINGS_VERIFICATION);
//    }

//    /**
//     * 试玩开关
//     *
//     * @param siteId
//     * @return
//     */
//    private SysParam checkDemoParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_SYSTEM_SETTINGS_DEMO);
//    }

//    /**
//     * 真实姓名验证参数
//     *
//     * @param siteId 站点ID
//     */
//    private SysParam checkRealNameParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_CHECK_REAL_NAME);
//    }

//    /**
//     * 手机号必填验证参数
//     *
//     * @param siteId 站点ID
//     * @return
//     */
//    private SysParam checkMobileParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_CHECK_MOBILE);
//    }

//    /**
//     * 微信号必填验证参数
//     *
//     * @param siteId 站点ID
//     * @return
//     */
//    private SysParam checkWeinxinParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_CHECK_WEIXIN);
//    }
//
//
//    private SysParam checkPayeeBankAlipayParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_CHECK_PAYEE_BANK_ALIPAY);
//    }
//
//    private SysParam checkPayeeBankWeixinParams(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.SETTING_CHECK_PAYEE_BANK_WEIXIN);
//    }
//
//    private SysParam checkApiTransferSite(Integer siteId) {
//        return SysParamTool.getSiteParam(siteId, SiteParamEnum.API_TRANSFER_SITE);
//    }


    /**
     * 域名网址
     */
    @RequestMapping("/viewDomainCompany")
    public String viewDomainMerchant(VSysDomainListVo vSysDomainListVo, Model model, HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        list.add(SubSysCodeEnum.COMPANY.getCode());
        list.add(SubSysCodeEnum.HALL.getCode());
        vSysDomainListVo.getSearch().setTypeList(list);
        viewDomain(vSysDomainListVo, model);
        model.addAttribute("subSysCodes", list);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "PartialDomain";
        } else {
            return getViewBasePath() + "ViewDomain";
        }
    }


    @RequestMapping("/updateMode")
    @ResponseBody
    public Map<String, Object> updateMode(SysSiteVo syssiteVo) {
        Map<String, Object> map = new HashMap<>(2);
        if (syssiteVo.getResult() == null) {
            map.put("state", false);
            map.put("msg", "保存失败,参数错误");
            return map;
        }
        updateModes(syssiteVo);
        CacheBase.refreshSysSite();
        CacheBase.refreshSiteDomain();
        return map;
    }

    /**
     * 站点管理--总代
     */
    @RequestMapping("/domainAfent")
    protected String domainAfent(VSysDomainListVo vSysDomainListVo, Model model, HttpServletRequest request) {
        model.addAttribute("domainResolvestatus", getResolveStatusEnums());
        String[] codes = {SubSysCodeEnum.DISTRIBUTOR.getCode(), SubSysCodeEnum.DISTRIBUTOR.getCode()};
        vSysDomainListVo.getSearch().setSubSysCodes(codes);
        vSysDomainListVo = ServiceTool.vSysDomainService().search(vSysDomainListVo);//查询代理域名
        model.addAttribute("getSiteId", vSysDomainListVo.getSearch().getSiteId());
        model.addAttribute("sysUserId", vSysDomainListVo.getSearch().getSysUserId());
        model.addAttribute("command", vSysDomainListVo);
        if (ServletTool.isAjaxSoulRequest(request)) {
            return getViewBasePath() + "PartialDomainAgent";
        } else {
            return getViewBasePath() + "ViewDomainAgent";
        }
    }

//    /**
//     * 转站验证开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateSysParamStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_VERIFICATION, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateMhSiteStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_SYSTEM_SETTINGS_VERIFICATION,
//                AuditLogEnum.UPDATE_PARAM_CHECK_VERIFICATION, request);
//        return getVoMessage(sysParamVo);
//    }
//
//    /**
//     * 试玩验证开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateDemoSysParamStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_DEMO, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateMhSiteDemoStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_SYSTEM_SETTINGS_DEMO,
//                AuditLogEnum.UPDATE_PARAM_CHECK_DEMO, request);
//        return getVoMessage(sysParamVo);
//    }
//
//    /**
//     * 真实姓名必填开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateCheckRealNameStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_CHECK_REAL_NAME, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateCheckRealNameStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_CHECK_REAL_NAME,
//                AuditLogEnum.UPDATE_PARAM_CHECK_REAL_NAME, request);
//        return getVoMessage(sysParamVo);
//    }
//
//    /**
//     * 手机号必填开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateCheckMobileStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_CHECK_MOBILE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateCheckMobileStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_CHECK_MOBILE,
//                AuditLogEnum.UPDATE_PARAM_CHECK_MOBILE, request);
//        return getVoMessage(sysParamVo);
//    }
//
//    /**
//     * 微信号必填开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateCheckWeixinStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_CHECK_WEIXIN, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateCheckWeixinStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_CHECK_WEIXIN,
//                AuditLogEnum.UPDATE_PARAM_CHECK_WEIXIN, request);
//        return getVoMessage(sysParamVo);
//    }
//
//
//    /**
//     * 玩家收款账号支持支付宝
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updatePayeeBankAlipayStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_CHECK_PAYEE_BANK_ALIPAY, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updatePayeeBankAlipayStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_CHECK_PAYEE_BANK_ALIPAY,
//                AuditLogEnum.UPDATE_PARAM_CHECK_PAYEE_BANK_ALIPAY, request);
//        return getVoMessage(sysParamVo);
//    }
//
//    /**
//     * 玩家收款账号支持微信
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updatePayeeBankWeixinStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_CHECK_PAYEE_BANK_WEIXIN, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updatePayeeBankWeixinStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.SETTING_CHECK_PAYEE_BANK_WEIXIN,
//                AuditLogEnum.UPDATE_PARAM_CHECK_PAYEE_BANK_WEIXIN, request);
//        return getVoMessage(sysParamVo);
//    }
//
//
//    /**
//     * api免转开关
//     *
//     * @param sysParamVo result.siteId not null
//     * @return Map
//     */
//    @RequestMapping("/updateApiTransferSiteStatus")
//    @ResponseBody
//    @Audit(module = Module.CUSTOMER, moduleType = ModuleType.SYS_UPDATE_API_TRANSFER_SITE, opType = OpType.UPDATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map updateApiTransferSiteStatus(SysParamVo sysParamVo, HttpServletRequest request) {
//        sysParamVo = executeUpdateSysParam(sysParamVo, SiteParamEnum.API_TRANSFER_SITE,
//                AuditLogEnum.UPDATE_PARAM_CHECK_API_TRANSFER_SITE, request);
//        return getVoMessage(sysParamVo);
//    }


//    /**
//     * 修改系统参数
//     *
//     * @param paramVo   result.siteId not null
//     * @param paramEnum 参数枚举
//     * @param logEnum   日志枚举
//     * @param request   请求对象
//     * @return SysParamVo
//     */
//    private SysParamVo executeUpdateSysParam(SysParamVo paramVo, SiteParamEnum paramEnum, AuditLogEnum logEnum, HttpServletRequest request) {
//        if (paramEnum == null
//                || paramVo == null
//                || paramVo.getResult() == null
//                || paramVo.getResult().getSiteId() == null
//                || paramVo.getResult().getParamValue() == null) {
//            paramVo.setSuccess(false);
//            paramVo.setErrMsg("更新系统参数失败：缺少修改参数信息");
//            LOG.error("更新系统参数[{0}]失败：缺少修改参数信息", paramEnum.getType());
//            return paramVo;
//        }
//        Integer siteId = paramVo.getResult().getSiteId();
//        SysParam param = SysParamTool.getSiteParam(siteId, paramEnum);
//        if (param == null) {
//            paramVo.setSuccess(false);
//            paramVo.setErrMsg("更新系统参数失败：缺少基础参数");
//            LOG.error("更新系统参数[{0}]失败：缺少基础参数", paramEnum.getType());
//            return paramVo;
//        }
//        param.setParamValue(paramVo.getResult().getParamValue());
//        paramVo._setDataSourceId(siteId);
//        paramVo.setResult(param);
//        paramVo.setProperties(SysParam.PROP_PARAM_VALUE);
//        paramVo = ServiceTool.siteSysParamService().updateOnly(paramVo);
//        if (paramVo.isSuccess()) {
//            ParamTool.refreshBySiteId(paramEnum, siteId);
//            addAuditLog(paramVo, logEnum, request);
//        }
//        return paramVo;
//    }
//
//    @RequestMapping("/discParam")
//    @ResponseBody
//    public Map discParam(SysParamVo sysParamVo) {
//        Map<String, Object> map = new HashMap<>(1, 1);
//        Integer siteId = sysParamVo.getResult().getSiteId();
//        SysParam sysParam = disc(siteId);
//        if (sysParam != null) {
//            sysParam.setParamValue(sysParamVo.getResult().getParamValue());
//            sysParamVo._setDataSourceId(siteId);
//            sysParamVo.setResult(sysParam);
//            sysParamVo.setProperties(SysParam.PROP_PARAM_VALUE);
//            SysParamVo paramVo = ServiceTool.siteSysParamService().updateOnly(sysParamVo);
//            ParamTool.refreshBySiteId(SiteParamEnum.SETTING_DISC, siteId);
//            map = getVoMessage(paramVo);
//        } else {
//            map.put("state", false);
//            map.put("msg", "缺少系统参数");
//        }
//        return map;
//    }
//
//    /**
//     * boss 手动执行运营报表函数
//     */
//    @RequestMapping("/goReportOperate")
//    @ResponseBody
//    @Audit(module = Module.REPORT, moduleType = ModuleType.CALL_REPORT_OPERATE, opType = OpType.CREATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map goReportOperate(Integer siteId, String date, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>(5, 1f);
//        if (siteId == null || date == null) {
//            map.put("state", false);
//            map.put("msg", "参数错误");
//            return map;
//        }
//        ReportOperateVo vo = new ReportOperateVo();
//        vo.getSearch().setDate(date);
//        vo._setDataSourceId(siteId);
//        vo = ServiceTool.reportOperateService().callReportOperateVo(vo);
//        addAuditLog(vo, AuditLogEnum.CALL_REPORT_OPERATE_FUNCTION, request);
//        if (vo.isSuccess()) {
//            if("0".equals(vo.getSearch().getStatus())){
//                map.put("state", true);
//                map.put("msg", "执行成功");
//            }else{
//                map.put("state", false);
//                map.put("msg", "函数错误");
//            }
//        } else {
//            map.put("state", false);
//            map.put("msg", "执行失败");
//        }
//        return map;
//    }
//
//    @RequestMapping("/initSiteConfineArea")
//    @ResponseBody
//    @Audit(module = Module.FUND, moduleType = ModuleType.CALL_REPORT_OPERATE, opType = OpType.CREATE, ignoreForm = YesNot.YES, isSystem = YesNot.NOT)
//    public Map initSiteConfineArea(Integer siteId, HttpServletRequest request) {
//        Map<String, Object> map = new HashMap<>(5, 1f);
//        if (siteId == null) {
//            map.put("state", false);
//            map.put("msg", "参数错误");
//            return map;
//        }
//        SiteConfineAreaVo vo = new SiteConfineAreaVo();
//        SiteConfineArea siteConfineArea = new SiteConfineArea();
//        siteConfineArea.setSiteId(siteId);
//        vo.setResult(siteConfineArea);
//        vo = ServiceTool.siteConfineAreaService().callInitSiteConfineArea(vo);
//        addAuditLog(vo, AuditLogEnum.CALL_INIT_SITE_CONFINE_AREA_FUNCTION, request);
//        CacheBase.refreshSiteConfineArea();
//        if (vo.isSuccess()) {
//            map.put("state", true);
//            map.put("msg", "执行成功");
//        } else {
//            map.put("state", false);
//            map.put("msg", "执行失败");
//        }
//        return map;
//    }
//
//
//    private void addAuditLog(SysParamVo vo, AuditLogEnum logEnum, HttpServletRequest request) {
//        try {
//            if (vo.isSuccess()) {
//                List<String> paramList = new ArrayList<>(3);
//                paramList.add(vo._getDataSourceId().toString());
//                if (StringTool.equals("true", vo.getResult().getParamValue())) {
//                    paramList.add("关闭");
//                    paramList.add("开启");
//                } else {
//                    paramList.add("开启");
//                    paramList.add("关闭");
//                }
//                paramList.add(SessionManager.getUserName());
//                AuditAddLogTool.addLog(request, logEnum, paramList);
//            }
//        } catch (Exception e) {
//            LOG.error("保存审计日志出错", e.getMessage());
//        }
//    }
//
//    private void addAuditLog(ReportOperateVo vo, AuditLogEnum logEnum, HttpServletRequest request) {
//        try {
//            if (vo.isSuccess()) {
//                List<String> paramList = new ArrayList<>(3);
//                paramList.add(vo._getDataSourceId().toString());
//                paramList.add(vo.getSearch().getDate());
//                AuditAddLogTool.addLog(request, logEnum, paramList);
//            }
//        } catch (Exception e) {
//            LOG.error("保存审计日志出错", e.getMessage());
//        }
//    }
//
//    private void addAuditLog(SiteConfineAreaVo vo, AuditLogEnum logEnum, HttpServletRequest request) {
//        try {
//            if (vo.isSuccess()) {
//                List<String> paramList = new ArrayList<>(3);
//                paramList.add(vo._getDataSourceId().toString());
//                AuditAddLogTool.addLog(request, logEnum, paramList);
//            }
//        } catch (Exception e) {
//            LOG.error("保存审计日志出错", e.getMessage());
//        }
//    }
}