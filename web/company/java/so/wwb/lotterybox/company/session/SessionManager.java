package so.wwb.lotterybox.company.session;

import org.soul.model.common.BaseObjectVo;
import org.soul.model.session.SessionKey;
import so.wwb.lotterybox.common.dubbo.ServiceTool;
import so.wwb.lotterybox.model.enums.base.SiteI18nEnum;
import so.wwb.lotterybox.model.enums.user.UserTypeEnum;
import so.wwb.lotterybox.model.manager.sys.vo.SysSiteVo;
import so.wwb.lotterybox.model.manager.user.vo.SysUserExtendListVo;
import so.wwb.lotterybox.web.cache.Cache;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class SessionManager extends SessionManagerCommon {


    public static final String CONTENT_DOCUMENT_MESSAGE = "contentDocumentMessage";

    public static final String SESSION_GATHER_VOICE_NOTICE = "SESSION_GATHER_VOICE_NOTICE";

    public static final String SESSION_BILL_VOICE_NOTICE = "SESSION_BILL_VOICE_NOTICE";

    //商户信息需要存session
    public static final String SESSION_SITE_BASIC = "siteBasic";

    public static final String SESSION_SITE_NET_SCHEME = "siteNetScheme";

    public static final String SESSION_CURRENT_USER_TYPE = "currentUserType";


    public static void setCurrentUserType(String key, String currentUserType) {
        setAttribute(key, currentUserType);
    }


    public static void setBaseObjectVo(String key, BaseObjectVo objectVo) {
        setAttribute(key, objectVo);
    }

    public static BaseObjectVo getBaseObjectVo(String key) {
        return (BaseObjectVo) getAttribute(key);
    }

    public static void setUserId(Integer userId) {
        setAttribute(SessionKey.S_USER_ID, userId);
    }


    public static Integer getMasterUserId() {
        return (Integer) getAttribute("masterUserId");
    }


    public static String getLogoutUrl() {
        return getUser() != null?"/passport/logout.html":"";
    }

    public static Boolean getGatherVoiceNotice() {
        Object flag = getAttribute(SESSION_GATHER_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static Boolean getBillVoiceNotice() {
        Object flag = getAttribute(SESSION_BILL_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static Boolean getOnlineVoiceNotice() {
        Object flag = getAttribute(SESSION_ONLINE_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static void setOnlineVoiceNotice(String status) {
        if ("0".equals(status)) {
            setAttribute(SESSION_ONLINE_VOICE_NOTICE, true);
        } else {
            setAttribute(SESSION_ONLINE_VOICE_NOTICE, false);
        }
    }

    //统一获取审批用户账号的方法，主要是处理站长虚拟账号的情况
    public static String getAuditUserName() {
        if (getUser().getUserType().equals(UserTypeEnum.COMPANY.getCode())) {
            return "—admin—";
        } else {
            return getUserName();
        }
    }

    //根据站点Id获取这个站点的用户SubsysCode
    public static String userSubsysCode(Integer siteId) {
        SysSiteVo sysSiteVo = new SysSiteVo();
        sysSiteVo.getSearch().setId(siteId);
        ServiceTool.sysSiteService().get(sysSiteVo).getResult().getSysUserId();
        return ServiceTool.sysSiteService().searchUserCode(sysSiteVo);
    }

    //查询当前站点下面代理
    public static SysUserExtendListVo sysUserExtendAgent(Integer siteId) {
        SysUserExtendListVo sysUserExtendListVo = new SysUserExtendListVo();
        sysUserExtendListVo.getSearch().setUserType(UserTypeEnum.DISTRIBUTOR.getCode());
        sysUserExtendListVo.getSearch().setSiteId(siteId);
        sysUserExtendListVo = ServiceTool.sysUserExtendService().search(sysUserExtendListVo);
        return sysUserExtendListVo;
    }

    public static final String SESSION_COMPANY_VOICE_NOTICE = "SESSION_COMPANY_VOICE_NOTICE";
    public static final String SESSION_ONLINE_VOICE_NOTICE = "SESSION_ONLINE_VOICE_NOTICE";
    public static final String SESSION_SYSDEPOSIT_VOICE_NOTICE = "SESSION_SYSDEPOSIT_VOICE_NOTICE";
    public static final String SESSION_DRAW_VOICE_NOTICE = "SESSION_DRAW_VOICE_NOTICE";
    public static final String SESSION_SYSDRAW_VOICE_NOTICE = "SESSION_SYSDRAW_VOICE_NOTICE";

    public static Boolean getSysdrawVoiceNotice() {
        Object flag = getAttribute(SESSION_SYSDRAW_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static void setSysdrawNotice(String status) {
        if ("0".equals(status)) {
            setAttribute(SESSION_SYSDRAW_VOICE_NOTICE, true);
        } else {
            setAttribute(SESSION_SYSDRAW_VOICE_NOTICE, false);
        }
    }

    public static Boolean getDrawVoiceNotice() {
        Object flag = getAttribute(SESSION_DRAW_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static void setDrawNotice(String status) {
        if ("0".equals(status)) {
            setAttribute(SESSION_DRAW_VOICE_NOTICE, true);
        } else {
            setAttribute(SESSION_DRAW_VOICE_NOTICE, false);
        }
    }

    public static Boolean getSysdepositVoiceNotice() {
        Object flag = getAttribute(SESSION_SYSDEPOSIT_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static void setSysdepositNotice(String status) {
        if ("0".equals(status)) {
            setAttribute(SESSION_SYSDEPOSIT_VOICE_NOTICE, true);
        } else {
            setAttribute(SESSION_SYSDEPOSIT_VOICE_NOTICE, false);
        }
    }

    public static Boolean getCompanyVoiceNotice() {
        Object flag = getAttribute(SESSION_COMPANY_VOICE_NOTICE);
        if (flag != null) {
            return (Boolean) flag;
        }
        return null;
    }

    public static void setCompanyVoiceNotice(String status) {
        if ("0".equals(status)) {
            setAttribute(SESSION_COMPANY_VOICE_NOTICE, true);
        } else {
            setAttribute(SESSION_COMPANY_VOICE_NOTICE, false);
        }
    }

//    public static void setContentDocument(ContentDocumentVo contentDocumentVo){
//        setAttribute(CONTENT_DOCUMENT_MESSAGE,contentDocumentVo);
//    }

    /**
     * 获取站点名称
     *
     * @param request
     * @return
     */
    public static String getSiteName(HttpServletRequest request) {
        if (getSiteId() > 0) {
            Locale locale = SessionManagerCommon.getLocale();
            if (locale != null && Cache.getSiteI18n(SiteI18nEnum.SETTING_SITE_NAME).containsKey(locale.toString())) {
                return Cache.getSiteI18n(SiteI18nEnum.SETTING_SITE_NAME).get(locale.toString()).getValue();
            } else if (locale != null) {
                return "Missing " + locale.toString() + "Site Name";
            }
            return "Missing Locale Define";

        } else {
            return getSiteDomain(request).getName();
        }
    }

}
