package so.wwb.lotterybox.web.error.controller;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleDateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.error.ErrorMessage;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.web.session.KickOutMessage;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.support.BaseWebConf;
import org.soul.web.tag.ImageTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.model.base.CacheBase;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.model.enums.error.ErrorCodeEnum;
import so.wwb.lotterybox.model.enums.site.SiteStatusEnum;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;
import so.wwb.lotterybox.model.manager.sys.vo.VSysSiteDomainVo;
import so.wwb.lotterybox.model.manager.user.vo.SysUserExtendVo;
import so.wwb.lotterybox.utility.DomainTool;
import so.wwb.lotterybox.web.cache.Cache;
import so.wwb.lotterybox.web.init.ConfigBase;
import so.wwb.lotterybox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.lotterybox.web.shiro.common.filter.KickoutFilter;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

@Controller
@RequestMapping("/errors")
public class ErrorHandlerController {
    private static final Log LOG = LogFactory.getLog(ErrorHandlerController.class);

    @Autowired(required = false)
    private IPassportDelegate passportDelegate;

    private String getLoginUrl(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        Integer entranceId = passportDelegate.getEntranceType(contextPath, uri);
        if (null == entranceId) {
            entranceId = 0;
        }
        return passportDelegate.getLoginUrl(entranceId);
    }

    @RequestMapping("/index")
    public String error(HttpServletRequest request, HttpServletResponse response) {
        return "/errors/error";
    }

    @RequestMapping("/403")
    public String no_auth(HttpServletRequest request, HttpServletResponse response) {
        Integer code = Integer.parseInt(org.soul.model.error.ErrorCodeEnum.SC_FORBIDDEN.getCode());
        response.setStatus(code);
        response.setHeader(CUSTOM_HEADER_STATUS, code.toString());//
        return org.soul.model.error.ErrorCodeEnum.SC_FORBIDDEN.getUrl();
    }

    @RequestMapping("/404")
    public String no_exist(HttpServletRequest request, HttpServletResponse response) {
        return org.soul.model.error.ErrorCodeEnum.SC_NOT_FOUND.getUrl();
    }

    @RequestMapping("/602")
    public String serverBusy(HttpServletRequest request, HttpServletResponse response) {
        return org.soul.model.error.ErrorCodeEnum.SC_SERVICE_BUSY.getUrl();
    }

    @RequestMapping("/603")
    public String noExist(HttpServletRequest request, HttpServletResponse response) {
        return org.soul.model.error.ErrorCodeEnum.SC_DOMAIN_NO_EXIST.getUrl();
    }

    @RequestMapping("/604")
    public String tempTimeOut(HttpServletRequest request, HttpServletResponse response) {
        return org.soul.model.error.ErrorCodeEnum.SC_DOMAIN_TEMP_TIMEOUT.getUrl();
    }

    @RequestMapping("/605")
    public String ipConfine(HttpServletRequest request, HttpServletResponse response) {
        String url = org.soul.model.error.ErrorCodeEnum.SC_IP_CONFINE.getUrl();
        String defaultCustomerUrl = getDefaultCustomerUrl(request);
        request.setAttribute("customer", defaultCustomerUrl);
        return url;
    }

    @RequestMapping("/606")
    public String kickOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUrl = getLoginUrl(request);
        KickOutMessage sysOnLineSession = null;
        try {
            sysOnLineSession = SessionManagerBase.getKickOut();
            SessionManagerCommon.clearSession();
        } catch (Exception e) {
            LOG.error(e);
        }

        if (sysOnLineSession == null) {
            return "redirect:" + SessionManagerCommon.getRedirectUrl(request, loginUrl);
        }

        ErrorMessage errorMessage = KickoutFilter.defaultKickOutMsg(sysOnLineSession);
        if (ServletTool.isAjaxRequest(request)) {
            response.getWriter().write(JsonTool.toJson(errorMessage));
            response.getWriter().flush();
            return "";
        } else {
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("loginUrl", request.getContextPath() + loginUrl);
        }
        String pcCustomerServiceUrl = getDefaultCustomerUrl(request);
        request.setAttribute("customer", pcCustomerServiceUrl);
        //response.setStatus(606);
        return org.soul.model.error.ErrorCodeEnum.SC_KICK_OUT.getUrl();
    }

    private String getDefaultCustomerUrl(HttpServletRequest request) {
        BaseWebConf baseWebConf = (BaseWebConf) SpringTool.getBean("baseWebConf");
        Integer siteParentId = CommonContext.get().getSiteParentId();
        String subCode = baseWebConf.getSubsysCode();
        SysParamVo paramVo = new SysParamVo();
        paramVo._setDataSourceId(CommonContext.get().getSiteId());
        paramVo.getSearch().setActive(true);
        if (!ServletTool.isMobile(request)) {
//            paramVo.getQuery().setCriterions(new Criterion[]{
//                    new Criterion(SysParam.PROP_PARAM_TYPE, Operator.EQ, SiteParamEnum.SETTING_PC_CUSTOMER.getType()),
//                    new Criterion(SysParam.PROP_PARAM_CODE, Operator.EQ,SiteParamEnum.SETTING_PC_CUSTOMER.getCode())
//            });
            SysParamVo pcCustomer = ServiceTool.sysParamService().search(paramVo);
            if (pcCustomer.getResult()!=null) {
                return pcCustomer.getResult().getParamValue();
            }
        } else {
//            paramVo.getQuery().setCriterions(new Criterion[]{
//                    new Criterion(SysParam.PROP_PARAM_TYPE, Operator.EQ,SiteParamEnum.SETTING_MOBILE_CUSTOMER.getType()),
//                    new Criterion(SysParam.PROP_PARAM_CODE, Operator.EQ,SiteParamEnum.SETTING_MOBILE_CUSTOMER.getCode())
//            });
            SysParamVo mobileCustomer = ServiceTool.sysParamService().search(paramVo);
            if (mobileCustomer.getResult()!=null) {
                return mobileCustomer.getResult().getParamValue();
            }
        }
        return "";
    }

    @RequestMapping("/607")
    public String maintain(HttpServletRequest request) {
        String domain = DomainTool.getDomain(request);
        VSysSiteDomainVo vo = new VSysSiteDomainVo();
        vo.getSearch().setDomain(domain);
        VSysSiteDomain curDomain = ServiceTool.vSysSiteDomainService().getSiteDomainByDomain(vo).get(0);
        if (resolveMaintain(curDomain, curDomain.getSiteId()) || resolveMaintain(curDomain, 0)) {
            curDomain.setSiteStatus(SiteStatusEnum.MAINTAIN.getCode());
        } else {
            curDomain.setSiteStatus(SiteStatusEnum.NORMAL.getCode());
        }
        //总控对运营商维护,运营商旗下站点不可访问
        if (!SiteStatusEnum.MAINTAIN.getCode().equals(curDomain.getSiteStatus())) {
            Integer siteParentId = curDomain.getSiteParentId();
            if (siteParentId != null && siteParentId < 0) {
                Map<String, SysSite> sysSiteMap = CacheBase.getSysSite();
                SysSite sysSite = sysSiteMap.get(String.valueOf(siteParentId));
                if (sysSite != null) {
                    sysSite.calStatus();
                    curDomain.setSiteStatus(sysSite.getStatus());
                    curDomain.setMaintainStartTime(sysSite.getMaintainStartTime());
                    curDomain.setMaintainEndTime(sysSite.getMaintainEndTime());
                }}
        }

        if (StringTool.equals(curDomain.getSiteStatus(), SiteStatusEnum.MAINTAIN.getCode())) {
            //request.setAttribute("timezone", SessionManagerCommon.getTimeZone().getDisplayName());
            request.setAttribute("startTime", LocaleDateTool.formatDate(curDomain.getMaintainStartTime(), DateTool.FMT_HYPHEN_DAY_CLN_SECOND, SessionManagerCommon.getTimeZone()));
            request.setAttribute("endTime", LocaleDateTool.formatDate(curDomain.getMaintainEndTime(), DateTool.FMT_HYPHEN_DAY_CLN_SECOND, SessionManagerCommon.getTimeZone()));


            /*倒计时版本*/
            /*request.setAttribute("startTime", new Date().getTime());
            request.setAttribute("endTime", curDomain.getMaintainEndTime()==null?new Date().getTime():curDomain.getMaintainEndTime().getTime());*/
            String defaultCustomerUrl = getDefaultCustomerUrl(request);


            SysSiteVo sysSiteVo = new SysSiteVo();
            sysSiteVo.getSearch().setId(curDomain.getSiteId());
            sysSiteVo =  ServiceTool.sysSiteService().get(sysSiteVo);
            String reason = "";
            String siteName = "";
            String logoPath = "Logo/1/1459172297237.png";
            if (sysSiteVo.getResult() != null){
                reason = sysSiteVo.getResult().getMaintainReason();
                siteName = sysSiteVo.getResult().getName();
                logoPath = sysSiteVo.getResult().getLogoPath();
                SysUserExtendVo userExtendVo = new SysUserExtendVo();
                userExtendVo.getSearch().setId(sysSiteVo.getResult().getSysUserId());
                userExtendVo = ServiceTool.sysUserExtendService().get(userExtendVo);
                request.setAttribute("subsysCode", userExtendVo.getResult().getSubsysCode());
            }
            Cache.getSysSite();
            request.setAttribute("customer", defaultCustomerUrl);
            request.setAttribute("state", curDomain.getSiteStatus());
            request.setAttribute("reason", reason);
            request.setAttribute("siteName", siteName);
            request.setAttribute("logoPath", ImageTag.getThumbPath(domain, logoPath, 1024, 450));
            String resRoot = MessageFormat.format(ConfigBase.get().getResRoot(), request.getServerName());
            request.setAttribute("resRoot", resRoot);
            return org.soul.model.error.ErrorCodeEnum.SC_SITE_MAINTAIN.getUrl();
        } else {
            String loginUrl = getLoginUrl(request);
            return "redirect:" + SessionManagerCommon.getRedirectUrl(request, loginUrl);
        }

    }

    @RequestMapping("/608")
    public String repeatRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(608);
        return ErrorCodeEnum.SC_IP_DB.getUrl();
    }

    @RequestMapping("/609")
    public String noIpdb(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(609);
        return ErrorCodeEnum.SC_IP_DB.getUrl();
    }

    @RequestMapping("/610")
    public String ipLimitation(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(610);
        return ErrorCodeEnum.SC_IP_DB.getUrl();
    }

    @RequestMapping("/701")
    public String tokenDue() {
        return ErrorCodeEnum.TOKEN_DUE.getUrl();
    }


    public boolean resolveMaintain(VSysSiteDomain sysSiteDomain, Integer siteId) {
        // 检查当前站点的维护状态
        Map<String,SysSite> sysSiteMap =  CacheBase.getSysSite();
        SysSite sysSite = sysSiteMap.get(String.valueOf(siteId));
        if (sysSite != null){
            return !sysSite.isNormal();
        }
        return false;
    }
}
