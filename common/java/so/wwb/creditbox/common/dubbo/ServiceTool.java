package so.wwb.creditbox.common.dubbo;
import org.soul.iservice.log.audit.IAuditService;
import org.soul.iservice.msg.notice.INoticeReceiverService;
import org.soul.iservice.msg.notice.INoticeService;
import org.soul.iservice.passport.IPassportService;
import org.soul.iservice.pay.IOnlinePayService;
import org.soul.iservice.security.privilege.ISysResourceService;
import org.soul.iservice.security.privilege.ISysRoleService;
import org.soul.iservice.security.privilege.ISysUserRoleService;
import org.soul.iservice.security.privilege.ISysUserService;
import org.soul.iservice.sys.ISysAuditLogService;
import org.soul.iservice.sys.ISysDatasourceService;
import org.soul.iservice.sys.ISysParamService;
import org.soul.iservice.test.IDbValidService;
import so.wwb.creditbox.iservice.common.IMessageService;
import so.wwb.creditbox.iservice.company.site.ISiteSysParamService;
import so.wwb.creditbox.iservice.company.user.IVSiteUserService;
import so.wwb.creditbox.iservice.manager.common.*;
import so.wwb.creditbox.iservice.manager.lottery.*;
import so.wwb.creditbox.iservice.manager.message.ISystemAnnouncementService;
import so.wwb.creditbox.iservice.manager.sys.*;
import so.wwb.creditbox.iservice.manager.user.ISysUserExtendService;
import so.wwb.creditbox.iservice.manager.user.IVSubAccountService;

import org.soul.commons.dubbo.DubboTool;
/**
 * 远程服务实例获取工具类
 *
 * @author block
 * @time 2019-11-12 0:36:34
 */
public class ServiceTool {

    //region your codes 1

    //region append IMPARTIBLE codes 1
    private static String dubboApplicationName;
    protected static <T> T getService(Class<T> interfaceClazz) {
        return DubboTool.getServiceByAppName(interfaceClazz, dubboApplicationName);
    }

    public static ISiteConfineAreaService siteConfineAreaService() {
        return getService(ISiteConfineAreaService.class);
    }

    public static ISiteSysParamService siteSysParamService() {
        return getService(ISiteSysParamService.class);
    }
    public static ISysRoleService sysRoleService(){
        return getService(ISysRoleService.class);
    }


    public static IVSiteMasterManageService vSiteMasterManageService() {
        return getService(IVSiteMasterManageService.class);
    }

    public static IVSiteUserService vSiteUserService() {
        return getService(IVSiteUserService.class);
    }

    /**
     * 返回用户管理/详细视图 - Fei  jeremy远程服务实例
     *
     * @return 用户管理/详细视图 - Fei  jeremy远程服务实例
     */



    public  void setDubboApplicationName(String appName){
        dubboApplicationName=appName;
    }
        public static String getDubboApplicationName(){
        return dubboApplicationName;
    }

    public static ISysDatasourceService sysDatasourceService() {
        return getService(ISysDatasourceService.class);
    }
//
//    public static ILotteryResultService lotterResultService() {
//        return getService(ILotteryResultService.class);
//    }


//    /**
//     * 赔率方案服务
//     */
//    public static ILotteryProjectService lotteryProjectService () {
//        return getService(ILotteryProjectService.class);
//    }
public static ISysUserRoleService sysUserRoleService() {
    return getService(ISysUserRoleService.class);
}


    /**
     * 返回子账户视图远程服务实例
     *
     * @return 子账户视图远程服务实例
     */
    public static IVSubAccountService vSubAccountService() {
        return getService(IVSubAccountService.class);
    }

    public static ILotteryService lotteryService() {
        return getService(ILotteryService.class);
    }

    /**
     * 平台公告 2018年03月23日13:44:34
     */
    public static ISystemAnnouncementService sysAnnouncementService(){return getService(ISystemAnnouncementService.class);}

    public static ISysDomainService sysDomainService() {
        return getService(ISysDomainService.class);
    }

    public static ISiteConfineIpService siteConfineIpService() {
        return getService(ISiteConfineIpService.class);
    }


    public static IVSysDomainService vSysDomainService() {
        return getService(IVSysDomainService.class);
    }


    public static IVSysSiteUserService vSysSiteUserService() {
        return getService(IVSysSiteUserService.class);
    }


    public static IDbValidService dbValidService() {
        return getService(IDbValidService.class);
    }

    public static IMessageService messageService() {return getService(IMessageService.class);}

    public static INoticeReceiverService noticeReceiverService() {return getService(INoticeReceiverService.class);}

//    public static ILotteryHandicapService lotteryHandicapService() {
//        return getService(ILotteryHandicapService.class);
//    }
//
//
//    public static ILotteryTypeService lotteryTypeService() {
//        return getService(ILotteryTypeService.class);
//    }


    /**
     * 返回用户管理/详细视图 - Fei  jeremy远程服务实例
     *
     * @return 用户管理/详细视图 - Fei  jeremy远程服务实例
     */

    public static ISysUserExtendService sysUserExtendService() {
        return getService(ISysUserExtendService.class);
    }


    public static ISysUserService sysUserService() {
        return getService(ISysUserService.class);
    }

    public static IPassportService passportService() {
        return getService(IPassportService.class);
    }

    public static ISysSiteService sysSiteService() {
        return getService(ISysSiteService.class);
    }

    public static ISysParamService sysParamService() {
        return getService(ISysParamService.class);
    }

    public static IAuditService auditService() {
        return getService(IAuditService.class);
    }

    public static ISysAuditLogService sysAuditLogService() {
        return getService(ISysAuditLogService.class);
    }


    public static IDefenseRecordService defenseRecordService(){return getService(IDefenseRecordService.class);}

    public static IVSysSiteDomainService vSysSiteDomainService(){return getService(IVSysSiteDomainService.class);}

    public static IIpDbService ipDbService(){return getService(IIpDbService.class);}

    public static IVSysSiteManageService vSysSiteManageService(){return getService(IVSysSiteManageService.class);}

    public static ISysResourceService sysResourceService(){return getService(ISysResourceService.class);}

    public static ISiteLotteryService siteLotteryService() {
        return getService(ISiteLotteryService.class);
    }
    public static ISiteLotteryOddService siteLotteryOddService() {
        return getService(ISiteLotteryOddService.class);
    }
    public static ISiteLotteryOddsService siteLotteryOddsService() {
        return getService(ISiteLotteryOddsService.class);
    }
    public static ILotteryOddService lotteryOddService() {
        return getService(ILotteryOddService.class);
    }
    public static ILotteryOddsService lotteryOddsService() {
        return getService(ILotteryOddsService.class);
    }

//    /**
//     * 返回用户管理/详细视图 - Fei  jeremy远程服务实例
//     *
//     * @return 用户管理/详细视图 - Fei  jeremy远程服务实例
//     */
//    public static IVUserManagerService vUserManagerService() {
//        return getService(IVUserManagerService.class);
//    }

    //endregion append IMPARTIBLE codes 1

        /**
     * 返回远程服务实例
     *
     * @return 远程服务实例
     */
    public static so.wwb.creditbox.iservice.manager.lottery.ILotteryRebatesService lotteryRebatesService() {
        return getService(so.wwb.creditbox.iservice.manager.lottery.ILotteryRebatesService.class);
    }
    
    /**
     * 返回远程服务实例
     *
     * @return 远程服务实例
     */
    public static so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryRebatesService siteLotteryRebatesService() {
        return getService(so.wwb.creditbox.iservice.manager.lottery.ISiteLotteryRebatesService.class);
    }
    
    /**
     * 返回远程服务实例
     *
     * @return 远程服务实例
     */
    public static so.wwb.creditbox.iservice.company.lottery.ISiteLotteryRebatesService siteLotteryRebatesService() {
        return getService(so.wwb.creditbox.iservice.company.lottery.ISiteLotteryRebatesService.class);
    }
    
//endregion your codes 1

}
