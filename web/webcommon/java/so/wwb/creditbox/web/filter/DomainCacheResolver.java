package so.wwb.creditbox.web.filter;

import org.soul.commons.bean.IEntity;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.iservice.common.IDomainCacheResolver;
import org.soul.model.common.BaseObjectVo;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.support.BaseWebConf;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.constants.common.Const;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.site.SiteStatusEnum;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteDomainVo;
import so.wwb.creditbox.web.init.ConfigBase;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author tony
 */
public class DomainCacheResolver implements IDomainCacheResolver {
    private static final Log LOG = LogFactory.getLog(DomainCacheResolver.class);

    @Override
    public BaseObjectVo fileContext(IEntity<Integer> iEntity, HttpServletRequest request) {
        LotteryContextParam contextParam = LotteryCommonContext.get();
        VSysSiteDomain domain =(VSysSiteDomain)iEntity;
        if (domain != null) {

            contextParam.setUserType(domain.getDomainUserType());
            contextParam.setSiteId(domain.getSiteId());
            contextParam.setSiteUserId(domain.getSiteUserId());
            contextParam.setSiteParentId(domain.getSiteParentId());
            contextParam.setSiteCode(domain.getSiteCode());
            contextParam.setSessionSiteId(domain.getSiteId());
            contextParam.setTerminal(AuditLogTool.setTerminal(AuditLogTool.getClientInfo(request)));

            contextParam.setSessionSiteId(domain.getSiteId());

            contextParam.setTimeZone(TimeZone.getTimeZone(domain.getTimeZone()));
            contextParam.setSiteTimeZone(contextParam.getTimeZone());

            contextParam.setUserIp(ServletTool.getIpAddr(request));
            contextParam.setMerchantName(domain.getSiteUserName());

            contextParam.setDomain(domain.getDomain());
            contextParam.setDomainUserId(domain.getDomainUserId());
            contextParam.setDomainUserName(domain.getDomainUserName());
            contextParam.setDomainSubsysCode(domain.getDomainSubsysCode());

//            contextParam.setDomainTypeEnum(EnumTool.enumOf(DomainTypeEnum.class, contextParam.getDomainType()));
            contextParam.setSubSysCodeEnum(EnumTool.enumOf(SubSysCodeEnum.class, contextParam.getDomainSubsysCode()));
            //TODO dick api变成包网
            /*String susysCode = domain.getSiteSubsysCode();
            if(SubSysCodeEnum.COMPANY.getCode().equals(susysCode)){
                susysCode = SubSysCodeEnum.COMPANY.getCode();
            }else if(SubSysCodeEnum.DISTRIBUTOR.getCode().equals(susysCode)){
                susysCode = SubSysCodeEnum.DISTRIBUTOR.getCode();
            }*/
            contextParam.setSiteSubsysCode(domain.getSiteSubsysCode());
//            contextParam.setSiteMode(EnumTool.enumOf(ModeEnum.class,domain.getMode()));

            if (SubSysCodeEnum.COMPANY.getCode().equalsIgnoreCase(contextParam.getSiteSubsysCode())) {
                // TODO theme
//                setSiteTheme(contextParam);
            }

            if (StringTool.isNotBlank(domain.getSiteLocale())) {
                String[] arr = domain.getSiteLocale().split("_");
                contextParam.setLocale(new Locale(arr[0], arr[1]));
                contextParam.setSiteLocale(new Locale(arr[0], arr[1]));
                contextParam.setSessionSiteId(contextParam.getSiteId());
            } else {
                contextParam.setLocale(ConfigBase.get().getDefaultLocal());
                contextParam.setSiteLocale(ConfigBase.get().getDefaultLocal());
            }

            contextParam.setSessionSiteId(contextParam.getSiteId());
            BaseWebConf baseWebConf = (BaseWebConf) SpringTool.getBean("baseWebConf");
            baseWebConf.setSubsysCode(LotteryCommonContext.get().getSiteSubsysCode());
            contextParam.setSubsysCode(contextParam.getSiteSubsysCode());
        }
        return VSysSiteDomainVo.toVo(domain);
    }


    @Override
    public BaseObjectVo fromCache(HttpServletRequest request) {
        Map<String, VSysSiteDomain> siteDomains = CacheBase.getSiteDomain();
        if (null==siteDomains|| siteDomains.size() <=0) {
            CacheBase.refreshSiteDomain();
        }
        VSysSiteDomain domain = SessionManagerCommon.getSiteDomain(request);
        return fileContext(domain,request);
    }


    @Override
    public boolean isSiteDisabled(BaseObjectVo vSysSiteDomainVo) {
        //前端才判断站点是否停用
        if(SubSysCodeEnum.HALL.equals(LotteryCommonContext.get().getSubSysCodeEnum())){
            if (vSysSiteDomainVo.getResult() instanceof VSysSiteDomain) {
                VSysSiteDomain sysSiteDomain = (VSysSiteDomain) vSysSiteDomainVo.getResult();
                Map<String,SysSite> sysSiteMap =  CacheBase.getSysSite();
                SysSite sysSite = sysSiteMap.get(String.valueOf(sysSiteDomain.getSiteId()));
                if (sysSite != null){
                    return !sysSite.isNormal();
                }
            }
        }
        return false;
    }

    @Override
    public boolean isDomainTempAndTimeOut(BaseObjectVo vSysSiteDomainVo) {
        if (vSysSiteDomainVo.getResult() instanceof VSysSiteDomain) {
            VSysSiteDomain sysSiteDomain = (VSysSiteDomain) vSysSiteDomainVo.getResult();

            Date createDate = sysSiteDomain.getCreateTime();
            if (createDate == null) {
                LOG.error("临时域名:{0}没有创建时间,影响过期判断!", sysSiteDomain.getDomain());
                return false;
            }

            return DateTool.addDays(createDate, Const.Domain_Temp_Can_Use_Days).before(new Date());
        }

        return false;
    }

    @Override
    public boolean isSiteMaintainNow(BaseObjectVo vSysSiteDomainVo) {
        if (vSysSiteDomainVo.getResult() instanceof VSysSiteDomain) {
            VSysSiteDomain sysSiteDomain = (VSysSiteDomain) vSysSiteDomainVo.getResult();
            if (StringTool.isBlank(sysSiteDomain.getSiteStatus())) {
                return false;
            }
            if (resolveMaintain(sysSiteDomain, 0)) { // 检查 boss 是否维护
                return true;
            }
            return resolveMaintain(sysSiteDomain, sysSiteDomain.getSiteId());
        }
        return false;
    }

    public boolean resolveMaintain(VSysSiteDomain sysSiteDomain, Integer siteId) {
        // 检查当前站点的维护状态
        Map<String,SysSite> sysSiteMap =  CacheBase.getSysSite();
        SysSite sysSite = sysSiteMap.get(String.valueOf(siteId));
        if (sysSite != null){
            Date now = new Date();
            if (sysSite.getMaintainStartTime()!=null && sysSite.getMaintainEndTime()!=null
                    &&sysSite.getMaintainStartTime().before(now) && sysSite.getMaintainEndTime().after(now)) {
                sysSiteDomain.setSiteStatus(SiteStatusEnum.MAINTAIN.getCode());
                sysSiteDomain.setMaintainStartTime(sysSite.getMaintainStartTime());
                sysSiteDomain.setMaintainEndTime(sysSite.getMaintainEndTime());
                LOG.debug("域名:{0}所在站点ID:{1}正维护中!", sysSiteDomain.getDomain(), sysSiteDomain.getSiteId());
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSiteMaintainReason(BaseObjectVo vSysSiteDomainVo) {
        if (vSysSiteDomainVo.getResult() instanceof VSysSiteDomain) {
            VSysSiteDomain sysSiteDomain = (VSysSiteDomain) vSysSiteDomainVo.getResult();
            return sysSiteDomain.getMaintainReason();
        }
        return null;
    }

}
