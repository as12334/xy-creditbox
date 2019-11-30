package so.wwb.creditbox.web.filter;

import org.soul.commons.init.context.CommonContext;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.iservice.common.IIpOrAreaResolver;
import org.soul.model.ip.IpBean;
import org.soul.web.session.SessionManagerBase;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.iservice.manager.common.IIpDbService;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.enums.base.SubSysCodeEnum;
import so.wwb.creditbox.model.enums.site.SiteConfineIpTypeEnum;
import so.wwb.creditbox.model.manager.site.po.SiteConfineArea;
import so.wwb.creditbox.model.manager.site.po.SiteConfineIp;
import so.wwb.creditbox.model.manager.sys.ip.po.IpDb;
import so.wwb.creditbox.model.manager.sys.ip.vo.IpDbVo;

import java.util.Map;

public class IpOrAreaResolver implements IIpOrAreaResolver {

    private static final Log LOG = LogFactory.getLog(IpOrAreaResolver.class);

    @Override
    public boolean isAllowIp(String ipStr, Integer siteId, String domain) {
        boolean isAllowIp = false;
        long ip = IpTool.ipv4StringToLong(ipStr);
        Map<String, SiteConfineIp> ipMap = CacheBase.getSiteConfineIp(siteId);
//        isAllowIp = checkIpMap(ipMap, ipStr, siteId, ip, domain);
        return true;
    }

    private boolean checkIpMap(Map<String, SiteConfineIp> ipMap, String ipStr, Integer siteId, long ip, String domain) {
        IpBean ipBean = SessionManagerBase.getIpDb();
        Boolean isAllowAccessSwitch = ipBean.isAllowAccessSwitch();
        for (Map.Entry<String, SiteConfineIp> entry : ipMap.entrySet()) {
            SiteConfineIp siteConfineIp = entry.getValue();
            if (!isSiteManagement()) {
                if (isAllowAccessSwitch) {
                    if (SiteConfineIpTypeEnum.SITE_ALLOW.getCode().equals(siteConfineIp.getType())) {
                        boolean isAllow = siteConfineIp.isAllowAccess(ip, SiteConfineIpTypeEnum.SITE_ALLOW);
                        if (isAllow) {
                            LOG.warn("站点ID:{0},域名为:{1},允许IP访问:{2},站点!", siteId, domain, ipStr);
                            return true;
                        }
                    }
                } else if (SiteConfineIpTypeEnum.SITE_DENY.getCode().equals(siteConfineIp.getType())) {
                    boolean isAllow = siteConfineIp.isAllowAccess(ip, SiteConfineIpTypeEnum.SITE_DENY);
                    if (!isAllow) {
                        LOG.warn("站点ID:{0},域名为:{1},禁止IP访问:{2},站点!", siteId, domain, ipStr);
                        return false;
                    }
                }
            } else if (isSiteManagement() && isAllowAccessSwitch && SiteConfineIpTypeEnum.CENTER_ALLOW.getCode().equals(siteConfineIp.getType())) {
                boolean isAllow = siteConfineIp.isAllowAccess(ip, SiteConfineIpTypeEnum.CENTER_ALLOW);
                if (isAllow) {
                    LOG.warn("站点ID:{0},域名为:{1},允许IP访问:{2},管理中心!", siteId, domain, ipStr);
                    return true;
                }
            }
        }
        //前台黑名單
        if (!isSiteManagement()) {
            if (!isAllowAccessSwitch) {
                // IP白名單(TODO add by Fei 商户中心不允许添加游戏中心白名單)
                for (Map.Entry<String, SiteConfineIp> entry : ipMap.entrySet()) {
                    SiteConfineIp siteConfineIp = entry.getValue();
                    if (SiteConfineIpTypeEnum.SITE_ALLOW.getCode().equals(siteConfineIp.getType())) {
                        boolean isAllow = siteConfineIp.isAllowAccess(ip, SiteConfineIpTypeEnum.SITE_ALLOW);
                        if (isAllow) {
                            LOG.warn("前台地区黑名單中IP白名單，站点ID:{0},域名为:{1},允许IP访问:{2},站点!", siteId, domain, ipStr);
                            return true;
                        }
                    }
                }

                // 地区黑名單
                Map<String, SiteConfineArea> areaMap = CacheBase.getSiteConfineArea();
                for (Map.Entry<String, SiteConfineArea> confineAreaEntry : areaMap.entrySet()) {
                    SiteConfineArea siteConfineArea = confineAreaEntry.getValue();
                    if (siteConfineArea.isInRange(ipBean)) {
                        LOG.warn("站点ID:{0},域名为:{1},禁止地区访问:{2}{3}{4},站点!", siteId, domain, ipBean.getCountry(), ipBean.getStateprov(), ipBean.getCity());
                        //前台限制访问地区为黑名單开启，走到这里，证明在限制访问地区内，禁止访问
                        return false;
                    }
                }
                LOG.warn("站点ID:{0},域名为:{1},允许IP访问:{2},站点!", siteId, domain, IpTool.ipv4LongToString(ip));
                //前台限制访问地区为黑名單开启，走到这里，证明不在限制访问地区内，允许访问
                return true;
            } else {
                LOG.warn("站点ID:{0},域名为:{1},禁止IP访问:{2},站点!", siteId, domain, IpTool.ipv4LongToString(ip));
                //前台限制访问地区为白名單开启，走到这里，证明不在白名單内，禁止访问
                return false;
            }
        } else {
            if (isAllowAccessSwitch) {
                LOG.warn("站点ID:{0},域名为:{1},禁止IP访问:{2},管理中心!", siteId, domain, IpTool.ipv4LongToString(ip));
                //非前台白名單开启，走到这里，证明不在白名單内,禁止访问
                return false;
            } else {
                LOG.warn("站点ID:{0},域名为:{1},允许IP访问:{2},管理中心!", siteId, domain, IpTool.ipv4LongToString(ip));
                //非前台白名單未开启，走到这里，允许访问
                return true;
            }
        }
    }

    private Boolean getAllowAccessSwitch() {
        boolean allowAccessSwitch;
        if (!isSiteManagement()) {
            allowAccessSwitch = ParamTool.isOpenVisitSiteStatus();//查询前端ip开关
        } else if (isAgentManagement()) {
            allowAccessSwitch = false;//总代 目前不知道什么用
        } else {
            allowAccessSwitch = ParamTool.isOpenVisitManagementCenterStatus();//查询后台ip开关
        }
        return allowAccessSwitch;
    }

    @Override
    public IpBean getIpFormDb(String ipStr) {
        boolean allowAccessSwitch = getAllowAccessSwitch();
        IIpDbService ipDbService = ServiceTool.ipDbService();
        IpDbVo vo = new IpDbVo();
        vo.getSearch().setIpStr(ipStr);
        IpDb ipDb = null;
        try {
            ipDb = ipDbService.getIp(vo);
        } catch (Exception e) {
            LOG.error(e,"IP库:服务调用异常!");
        }
        if (ipDb == null || !ipDb.isInDb()) {
            LOG.warn("IP库:查找不到IP:[{0}],请手工添加!", ipStr);
            ipDb = IpDb.NULL;
        } else {
            ipDb.setIp(IpTool.ipv4StringToLong(ipStr));
        }
        ipDb.setAllowAccessSwitch(allowAccessSwitch);
        // TODO 设置游戏中心可访问 by Fei
        //ipDb.setAllowAccess(allowAccessSwitch);
        return ipDb;
    }

    @Override
    public boolean isExceptionIp(String ipStr, Integer siteId) {
        return false;
    }

    @Override
    public boolean isExceptionDomain(String domain) {
        return false;
    }


    private boolean isAgentManagement() {
        return SubSysCodeEnum.DISTRIBUTOR.getCode().equals(CommonContext.get().getSubsysCode());
    }

    private boolean isSiteManagement() {
        switch (LotteryCommonContext.get().getSubSysCodeEnum()) {
            case BOSS:
            case COMPANIES:
            case COMPANY:
            default:
                return false;
        }
    }

//    private boolean isSiteFront() {
//        switch (LotteryCommonContext.get().getDomainTypeEnum()) {
//            case HALL:
//                return true;
//            default:
//                return false;
//        }
//    }
}
