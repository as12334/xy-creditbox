package so.wwb.creditbox.manager.common.site.controller;


import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.support._Module;
import org.soul.web.controller.NoMappingCrudController;
import org.springframework.validation.BindingResult;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.sys.IVSysDomainService;
import so.wwb.creditbox.manager.boss.site.form.VSysDomainForm;
import so.wwb.creditbox.manager.boss.site.form.VSysDomainSearchForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.common.MessageI18nConst;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.sys.*;
import so.wwb.creditbox.model.manager.sys.po.SysDomain;
import so.wwb.creditbox.model.manager.sys.po.VSysDomain;
import so.wwb.creditbox.model.manager.sys.vo.*;
import so.wwb.creditbox.web.tools.AuditAddLogTool;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author: dick
 * @date: 18/6/30
 */
public class BaseDomainController extends NoMappingCrudController<IVSysDomainService, VSysDomainListVo, VSysDomainVo, VSysDomainSearchForm, VSysDomainForm, VSysDomain, Integer> {

    protected static final org.soul.commons.log.Log LOG = org.soul.commons.log.LogFactory.getLog(BaseDomainController.class);

    protected final static String SUCCESS = "success";
    protected static final String SITE_DOMAIN_ADD = "site.domain.add";
    protected static final String SITE_DOMAIN_UPDATE = "site.domain.update";
    protected static final String SITE_DOMAIN_ISDISABLE = "site.domain.isdisable";
    protected static final String SITE_DOMAIN_TO_BOUND = "site.domain.to.bound";
    protected static final String SITE_DOMAIN_DELETE = "site.domain.delete";
    protected static final String SITE_DOMAIN_CHECK_SUCCESS = "site.domain.check.success";
    protected static final String SITE_DOMAIN_CHECK_FAIL = "site.domain.check.fail";
    protected static final String SITE_DOMAIN_BOUNDED = "site.domain.bounded";

    protected static final String SITE_DOMAIN_BOUNDED_FAIL = "site.domain.bounded.fail";

    protected static final String CONTENT_SITE_DISTRIBUTOR_DOMAIN_ADD = "content.site.distributor.domain.add";
    protected static final String CONTENT_SITE_SHAREHOLDER_DOMAIN_ADD = "content.site.shareholder.domain.add";
    protected static final String CONTENT_SITE_BOSS_DOMAIN_ADD = "content.site.boss.domain.add";

    protected static final String CONTENT_SITE_AGENT_DOMAIN_ADD = "content.site.agent.domain.add";
    protected static final String CONTENT_SITE_DOMAIN_RESOLVE_STATUS = "content.site.domain.resolve.status";
    protected static final String CONTENT_SITE_DOMAIN_STATUS = "content.site.domain.status";




    protected String getViewBasePath() {
        return "";
    }

    protected List getResolveStatusEnums(){
        List list = new ArrayList();
        for(ResolveStatusEnum statusEnum : EnumTool.getEnumList(ResolveStatusEnum.class)){
            if(!ResolveStatusEnum.BOUNDED.getCode().equals(statusEnum.getCode())){
                list.add(statusEnum);
            }
        }
        return list;
    }

    protected void addAuditLog(VSysDomainVo objectVo, HttpServletRequest request, String msgKey) {
        try {
            Integer siteId = objectVo.getResult().getSiteId();
            if (siteId == null){
                Integer domainId = objectVo.getResult().getId();
                if (domainId != null){
                    objectVo.getSearch().setId(domainId);
                    objectVo = this.getService().get(objectVo);
                    if (objectVo.getResult() != null){
                        siteId = objectVo.getResult().getSiteId();
                    }
                }
            }
            if (siteId != null){
                SysSiteVo siteVo = new SysSiteVo();
                siteVo.getSearch().setId(siteId);
                siteVo = ServiceTool.sysSiteService().get(siteVo);
                if (siteVo.getResult() != null){
                    List<String> params = new ArrayList<>();
                    params.add(siteVo.getResult().getId().toString());
                    params.add(AuditAddLogTool.installEnumMsg(SysUserTypeEnum.class, siteVo.getResult().getSiteClassifyKey()));
                    String domainName = objectVo.getResult().getName();
                    String domain = objectVo.getResult().getDomain();
                    Boolean isEnable = objectVo.getResult().getIsEnable();
                    params.add(domainName);
                    params.add(domain);
//                    params.add(AuditAddLogTool.installEnumMsg(DomainTypeEnum.class, objectVo.getResult().getType()));
                    params.add(isEnable?"启用":"禁用");
                    AuditAddLogTool.addLog(request,msgKey,params);
                }
            }
        }catch (Exception e){
            LOG.error("保存审计日志出错{0}",e.getMessage());
        }
    }

    protected void addAuditLog(SysDomainVo sysDomainVo, HttpServletRequest request,String msgKey) {
        try {
            if (sysDomainVo.isSuccess()){
                if (StringTool.equals(SITE_DOMAIN_TO_BOUND,msgKey)){
                    sysDomainVo.getSearch().setId(sysDomainVo.getResult().getId());
                    SysDomainVo domainVo = ServiceTool.sysDomainService().get(sysDomainVo);
                    if (domainVo.getResult() != null){
                        sysDomainVo.setResult(domainVo.getResult());
                    }
                }
                Integer siteId = sysDomainVo.getResult().getSiteId();
                if (siteId == null){
                    Integer domainId = sysDomainVo.getResult().getId();
                    if (domainId != null){
                        sysDomainVo.getSearch().setId(domainId);
                        sysDomainVo = ServiceTool.sysDomainService().get(sysDomainVo);
                        if (sysDomainVo.getResult() != null){
                            siteId = sysDomainVo.getResult().getSiteId();
                        }
                    }
                }
                if (siteId != null){
                    SysSiteVo siteVo = new SysSiteVo();
                    siteVo.getSearch().setId(siteId);
                    siteVo = ServiceTool.sysSiteService().get(siteVo);
                    if (siteVo.getResult() != null){
                        List<String> params = new ArrayList<>();
                        params.add(siteVo.getResult().getId().toString());
                        params.add(AuditAddLogTool.installEnumMsg(SysUserTypeEnum.class, siteVo.getResult().getSiteClassifyKey()));
                        params.add(sysDomainVo.getResult().getName());
                        params.add(sysDomainVo.getResult().getDomain());
//                        params.add(AuditAddLogTool.installEnumMsg(DomainTypeEnum.class, sysDomainVo.getResult().getType()));
                        params.add(sysDomainVo.getResult().getIsEnable()?"启用":"禁用");
                        if (StringTool.equals(SITE_DOMAIN_TO_BOUND,msgKey)
                                || StringTool.equals(SITE_DOMAIN_CHECK_SUCCESS,msgKey)
                                || StringTool.equals(SITE_DOMAIN_CHECK_FAIL,msgKey)
                                || StringTool.equals(SITE_DOMAIN_BOUNDED,msgKey)
                                || StringTool.equals(SITE_DOMAIN_BOUNDED_FAIL, msgKey)){
                            params.add(AuditAddLogTool.installEnumMsg(ResolveStatusEnum.class, sysDomainVo.getResult().getResolveStatus()));
                        }
                        AuditAddLogTool.addLog(request,msgKey,params);
                    }
                }
            }
        }catch (Exception e){
            LOG.error("保存审计日志出错{0}",e.getMessage());
        }
    }

    protected Map updateDomain(SysDomainVo objectVo,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(2);
        if(objectVo.getResult().getId() == null){
            map.put("msg", "参数错误");
            map.put("state", false);
            return map;
        }
        try{
            objectVo.getSearch().setId(objectVo.getResult().getId());
            SysDomainVo vo = ServiceTool.sysDomainService().get(objectVo);
            vo.getResult().setName(objectVo.getResult().getName());
            vo.getResult().setUpdateTime(new Date());
            vo.getResult().setUpdateUser(SessionManager.getUserId());
            vo.getResult().setIsDefault(objectVo.getResult().getIsDefault());
            vo.setProperties(
                    SysDomain.PROP_NAME,
                    SysDomain.PROP_UPDATE_USER,
                    SysDomain.PROP_UPDATE_TIME,
                    SysDomain.PROP_IS_DEFAULT
                    );
            ServiceTool.sysDomainService().updateNameAndIsDefault(vo);
            CacheBase.refreshSiteDomain();
            if(vo.isSuccess()){
                map.put("state", true);
                map.put("msg", "保存成功");
                addAuditLog(objectVo,request,SITE_DOMAIN_UPDATE);
            }
        }catch (Exception ex){
            map.put("state", false);
            map.put("msg", "修改失败");
            LOG.error(ex,"修改域名失败,原因:{0}",ex.getMessage());
        }
        return map;
    }

    protected Map delDomain(VSysDomainVo objectVo,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(2);
        if(objectVo.getSearch().getId() == null){
            map.put("msg", "参数错误");
            map.put("state", false);
            return map;
        }
        try{
            SysDomainVo domainVo = new SysDomainVo();
            domainVo.getSearch().setId(objectVo.getSearch().getId());
            domainVo = ServiceTool.sysDomainService().get(domainVo);
            domainVo.getResult().setIsDeleted(true);
            domainVo.setProperties(SysDomain.PROP_IS_DELETED);
            domainVo = ServiceTool.sysDomainService().updateOnly(domainVo);
            CacheBase.refreshSiteDomain();
            if(domainVo.isSuccess()){
                map.put("state", true);
                map.put("msg", "保存成功");
                addAuditLog(domainVo,request,SITE_DOMAIN_DELETE);
            }
        }catch (Exception ex){
            map.put("state", false);
            map.put("msg", "修改失败");
            LOG.error(ex,"删除域名失败,原因:{0}",ex.getMessage());
        }
        return map;
    }


    protected void domainSaveMsg(SysDomainVo sysDomainVo) {
        if (sysDomainVo.isSuccess() && StringTool.isBlank(sysDomainVo.getOkMsg())) {
            if (sysDomainVo.getResult().getUpdateTime() == null && (ResolveStatusEnum.TOBEBOUND.getCode().equals(sysDomainVo.getResult().getResolveStatus())
                    || ResolveStatusEnum.TOBETIEDUP.getCode().equals(sysDomainVo.getResult().getResolveStatus()))) {

                sysDomainVo.setOkMsg(LocaleTool.tranMessage("content", "sysdomain.success"));
            } else {
                sysDomainVo.setOkMsg(LocaleTool.tranMessage(_Module.COMMON, MessageI18nConst.OPERATION_SUCCESS));
            }
        } else if (!sysDomainVo.isSuccess() && StringTool.isBlank(sysDomainVo.getErrMsg())) {
            sysDomainVo.setErrMsg(LocaleTool.tranMessage(_Module.COMMON, "operation.fail"));
        }
    }

    /**
     * 更新域名状态
     */
    protected SysDomainVo updateResolveStatus(String resolveStatus, SysDomainVo sysDomainVo) {
        if (sysDomainVo.getResult() == null || sysDomainVo.getResult().getId() == null) {
            sysDomainVo.setSuccess(false);
            return sysDomainVo;
        }
        sysDomainVo.getResult().setResolveStatus(resolveStatus);
        if(resolveStatus.equals(ResolveStatusEnum.SUCCESS.getCode())) {
            sysDomainVo.getResult().setIsEnable(true);
        }else{
            sysDomainVo.getResult().setIsEnable(false);
        }
        //如果是解绑 直接删除
        if(resolveStatus.equals(ResolveStatusEnum.BOUNDED.getCode())) {
            sysDomainVo.getResult().setIsDeleted(true);
        }else{
            sysDomainVo.getResult().setIsDeleted(false);
        }
        sysDomainVo.setProperties(SysDomain.PROP_RESOLVE_STATUS,SysDomain.PROP_IS_ENABLE,SysDomain.PROP_IS_DELETED);
        return ServiceTool.sysDomainService().updateOnly(sysDomainVo);
    }

    protected Map saveAgent(VSysDomainVo objectVo, BindingResult result,HttpServletRequest request){
        SysDomainVo domainVo = ServiceTool.sysDomainService().saveAgentDomain(objectVo);
        if (!result.hasErrors()) {
            domainVo = ServiceTool.sysDomainService().batchSaveDomain(domainVo);
            addAuditLog(domainVo,request,SITE_DOMAIN_ADD);
            CacheBase.refreshSiteDomain(); //刷缓存
        }
        objectVo.setSuccess(domainVo.isSuccess());
        return this.getVoMessage(objectVo);
    }

    protected Map toBound(SysDomainVo sysDomainVo,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(1);
        sysDomainVo = updateResolveStatus(ResolveStatusEnum.BOUNDED.getCode(), sysDomainVo);
        if (sysDomainVo.isSuccess()){
            addAuditLog(sysDomainVo,request,SITE_DOMAIN_TO_BOUND);
        }
        map.put("state", sysDomainVo.isSuccess());
        return map;
    }

//    protected List<DomainTypeEnum> getDomainTypeEnum(String str) {
//        List<DomainTypeEnum> list = new ArrayList<>();
//        if ("1".equals(str)) {
//            for (DomainTypeEnum typeEnum : DomainTypeEnum.values()) {
//                if (!typeEnum.getCode().equals(DomainTypeEnum.COMPANY.getCode())) {
//                    list.add(typeEnum);
//                }
//            }
//        } else if("2".equals(str)){
//            //自行添加，控制前端展示顺序问题
//            list.add(DomainTypeEnum.COMPANY);
//        } else if("3".equals(str)){
//            //自行添加，控制前端展示顺序问题
//            list.add(DomainTypeEnum.COMPANY);
//        } else if ("4".equals(str)){// TODO: 18-11-27 商户API
//            list.add(DomainTypeEnum.COMPANY);
//        }
//        return list;
//    }

    /**
     * 初始数据
     * @param sysDomain
     */
    protected void setDomainData(SysDomain sysDomain) {
        sysDomain.setIsDeleted(false);
        sysDomain.setBuildIn(false);
        sysDomain.setResolveStatus(ResolveStatusEnum.TOBEBOUND.getCode());
        sysDomain.setIsEnable(false);
        sysDomain.setCreateTime(new Date());
        sysDomain.setCreateUser(SessionManager.getUserId());
    }


    protected String checkDomainByDomain(String domain){
        SysDomainVo sysDomainVo = new SysDomainVo();
        sysDomainVo.getSearch().setDomain(domain.trim());
        return ServiceTool.sysDomainService().checkDomainExists(sysDomainVo);
    }

    protected Map saveDistributor(SysDomainVo sysDomainVo,BindingResult result, HttpServletRequest request){
        Map map = new HashMap();
        if (!result.hasErrors()) {
            SysDomain sysDomain = sysDomainVo.getResult();
            sysDomain.setSubsysCode(SubSysCodeEnum.DISTRIBUTOR.getCode());
            sysDomain.setPageUrl(DomainPageUrlEnum.COMPANY.getCode());
            addDomain(map,sysDomainVo,result,request,CONTENT_SITE_DISTRIBUTOR_DOMAIN_ADD);
            return this.getVoMessage(sysDomainVo);
        }
        return map;
    }

    //添加boss，股东，总代域名
    protected void addDomain(Map map,SysDomainVo sysDomainVo,BindingResult result, HttpServletRequest request,String str){
        setDomainData(sysDomainVo.getResult());
        if (sysDomainVo.getResult().getSysUserId() != null) {
            sysDomainVo.setDomainPlatform(DomainPlatformEnum.SITE.getCode());
            sysDomainVo = ServiceTool.sysDomainService().batchSaveDomain(sysDomainVo);
            CacheBase.refreshSiteDomain();
            addAuditLog(sysDomainVo,request,str);
            map.put("state",true);
            domainSaveMsg(sysDomainVo);
        } else {
            map.put("state",false);
            sysDomainVo.setSuccess(false);
            sysDomainVo.setErrMsg(LocaleTool.tranMessage("content_auto", "找不到对象"));
        }
    }

    /**
     * 保存domain
     * @param objectVo
     * @param request
     * @return
     */
    protected Map saveDomain(SysDomainVo objectVo,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>(4);
        if(objectVo.getResult() ==null){
            map.put("msg", "参数错误");
            map.put("state", false);
            return map;
        }
        try{
            SysDomainListVo domainVo = new SysDomainListVo();
            domainVo.getSearch().setDomain(objectVo.getResult().getDomain());
            SysDomainListVo sysDomainListVo = ServiceTool.sysDomainService().search(domainVo);
            if(sysDomainListVo.getResult().size()>1){
                map.put("msg", "该域名有重复");
                map.put("state", false);
                return map;
            } else {
                if(SubSysCodeEnum.BOSS.getCode().equals(objectVo.getResult().getSubsysCode())){
                    objectVo.getResult().setPageUrl(DomainPageUrlEnum.BOSS.getCode());
                    objectVo.getResult().setSubsysCode(SubSysCodeEnum.BOSS.getCode());
                }else if(SubSysCodeEnum.COMPANIES.getCode().equals(objectVo.getResult().getSubsysCode())){
                    objectVo.getResult().setSubsysCode(SubSysCodeEnum.COMPANIES.getCode());
                    objectVo.getResult().setPageUrl(DomainPageUrlEnum.COMPANIES.getCode());
                }else if(SubSysCodeEnum.COMPANY.getCode().equals(objectVo.getResult().getSubsysCode())){
                    objectVo.getResult().setSubsysCode(SubSysCodeEnum.COMPANY.getCode());
                    objectVo.getResult().setPageUrl(DomainPageUrlEnum.COMPANY.getCode());
                }else if(SubSysCodeEnum.HALL.getCode().equals(objectVo.getResult().getSubsysCode())){
                    objectVo.getResult().setSubsysCode(SubSysCodeEnum.HALL.getCode());
                    objectVo.getResult().setPageUrl(DomainPageUrlEnum.HALL.getCode());
                }
                SysSiteVo sysSiteVo = new SysSiteVo();
                sysSiteVo.getSearch().setId(objectVo.getResult().getSiteId());
                Integer domainUserId = ServiceTool.sysSiteService().get(sysSiteVo).getResult().getSysUserId();//当前站点的用户ID
                objectVo.getResult().setSysUserId(domainUserId);
                setDomainData(objectVo.getResult());//初始数据
                sysSiteVo._setDataSourceId(SessionManagerCommon.getSiteId());
                objectVo = ServiceTool.sysDomainService().batchSaveDomain(objectVo);
                if(objectVo.isSuccess()){
                    addAuditLog(objectVo,request, SITE_DOMAIN_ADD);
                    map.put("msg", "保存成功");
                    map.put("state", true);
                }
                CacheBase.refreshSiteDomain();
            }
        }catch (Exception ex){
            map.put("state", false);
            map.put("msg", "保存失败");
            LOG.error(ex,"新增域名失败,原因:{0}",ex.getMessage());
        }
        return map;
    }

}
