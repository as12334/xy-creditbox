package so.wwb.creditbox.model.base;

import org.soul.commons.bean.Pair;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.param.IParamEnum;
import org.soul.model.sys.po.SysParam;
import so.wwb.creditbox.model.enums.base.BossParamEnum;
import so.wwb.creditbox.model.enums.base.SiteParamEnum;

import java.util.Collection;

public class ParamTool extends ParamToolBase {
    private static final Log LOG = LogFactory.getLog(ParamTool.class);
    private static final Integer BOSS_SITE_ID = 0;


    /**
     * 是否开启:访问管理中心IP限制开关
     */
    public static boolean isOpenVisitManagementCenterStatus() {
        Pair<String, String> pair;
        pair = get(SiteParamEnum.SETTING_VISIT_MANAGER_STATUS);
        return toBoolean(pair);
    }

    /**
     * 是否开启:访问站点IP限制开关
     */
    public static boolean isOpenVisitSiteStatus() {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, SiteParamEnum.SETTING_VISIT_PLAY_STATUS);
        Pair<String, String> pair = get(SiteParamEnum.SETTING_VISIT_PLAY_STATUS);
        return toBoolean(pair);
    }

    /**
     * 获取验证码样式
     */
    public static String getCaptchaStyle() {
        Integer siteId = CommonContext.get().getSiteId();
//        checkSiteSiteID(siteId, SiteParamEnum.SETTING_CAPTCHA_STYLE);
//        Pair<String, String> pair = get(SiteParamEnum.SETTING_CAPTCHA_STYLE);
        return null;
    }

    /**
     * 获取验证码排除字符
     */
    public static String getCaptchaExclusion() {
        Integer siteId = CommonContext.get().getSiteId();
//        checkSiteSiteID(siteId, SiteParamEnum.SETTING_CAPTCHA_EXCLUSIONS);
//        Pair<String, String> pair = get(SiteParamEnum.SETTING_CAPTCHA_EXCLUSIONS);
        return null;
    }

    /**
     * 获取指定站点参数
     */
    public static SysParam getSysParam(SiteParamEnum paramEnum, Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取Site SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParam;
    }

    /**
     * 获取当前站点参数
     */
    public static Collection<SysParam> getSysParams(SiteParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, paramEnum);
        Collection<SysParam> sysParams = rawByType(siteId, paramEnum);
        if (sysParams.isEmpty()) {
            LOG.error("Site 获取SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParams;
    }

    /**
     * 获取指定站点参数
     */
    public static SysParam getSysParam(BossParamEnum paramEnum, Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParam;
    }

    /**
     * 获取当前站点参数
     */
    public static SysParam getSysParam(so.wwb.creditbox.model.enums.base.SiteParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, paramEnum);
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParam;
    }

    /**
     * 获取当前站点参数
     */
    public static Collection<SysParam> getSysParams(BossParamEnum paramEnum) {
        Collection<SysParam> sysParams = rawByType(BOSS_SITE_ID, paramEnum);
        if (sysParams == null || sysParams.isEmpty()) {
            LOG.error("获取Boss SysParam缓存为空{0},siteId{1}", paramEnum, BOSS_SITE_ID);
        }
        return sysParams;
    }

    /**
     * 获取当前站点参数
     */
    public static SysParam getSysParam(BossParamEnum paramEnum) {
        SysParam sysParam = raw(BOSS_SITE_ID, paramEnum);
        if (sysParam == null) {
            LOG.error("获取BossSysParam缓存为空{0},siteId{1}", paramEnum, BOSS_SITE_ID);
        }
        return sysParam;
    }

    /**
     * 刷新当前站点参数
     */
    public static void refresh(SiteParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, paramEnum);
        refresh(siteId, paramEnum);
    }

    /**
     *根据站点刷缓存
     */
    public static void refreshBySiteId(SiteParamEnum paramEnum,Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        refresh(siteId, paramEnum);
    }

    /**
     * 刷新指定站点参数
     */
    public static void refresh(SiteParamEnum paramEnum, Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        refresh(siteId, paramEnum);
    }

    /**
     * 刷新当前站点参数
     */
    public static void refresh(BossParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, paramEnum);
        refresh(siteId, paramEnum);
    }

    /**
     * 刷新指定站点参数
     */
    public static void refresh(BossParamEnum paramEnum, Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        refresh(siteId, paramEnum);
    }

    private static void checkSiteSiteID(Integer siteId, IParamEnum paramEnum) {
        if (siteId == null) {
            LOG.error("错误的应用场景,siteId为空,参数为:{0}", paramEnum.toString());
            return;
        }
        if (siteId == 0) {
            LOG.error("错误的应用场景,Boss站点不应刷新Site站点的参数,参数为:{0}", paramEnum.toString());
        }
    }

}
