package so.wwb.creditbox.model.base;

import org.apache.commons.collections.Predicate;
import org.soul.commons.cache.CacheTool;
import org.soul.commons.collections.CollectionQueryTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.sort.Order;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.web.session.SessionManagerBase;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.enums.base.SiteI18nEnum;
import so.wwb.creditbox.model.enums.site.SiteLangStatusEnum;
import so.wwb.creditbox.model.enums.sys.ResolveStatusEnum;
import so.wwb.creditbox.model.manager.lottery.po.*;
import so.wwb.creditbox.model.manager.site.po.*;
import so.wwb.creditbox.model.manager.sys.po.SysCurrency;
import so.wwb.creditbox.model.manager.sys.po.SysSite;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;
//import so.wwb.lotterybox.model.company.user.po.UserLotteryCodeModel;

import java.io.Serializable;
import java.util.*;

public class CacheBase {

    private static Map<String, VSysSiteDomain> siteDomainMap;
    private static Date lastAccess;
    public static final Log log = LogFactory.getLog(CacheBase.class);
    public static final String RC_VERSION_KEY = "data:RC_VERSION";

    public static final Integer BOSS_SITE_ID = 0;
    private static CacheTool cacheTool;

    protected static CacheTool getProxy() {
        if (cacheTool == null) {
            cacheTool = (CacheTool) SpringTool.getBean("cacheTool");
        }
        return cacheTool;
    }


    public static void refreshSiteDomain() {
        siteDomainMap = null;
        lastAccess = null;
        getProxy().refresh(CacheKey.CACHE_KEY_DOMAIN);
    }



    public static void refreshLottery() {
        CacheTool.refresh(CacheKey.CACHE_KEY_LOTTERY);
    }



    public static void refreshSysSite() {
        getProxy().refresh(CacheKey.CACHE_KEY_SYS_SITE);
    }


    public static void refreshSysUserExtend() {
        getProxy().refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SYS_USER));
    }

    public static Map<String, SiteConfineArea> getSiteConfineArea() {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_CONFINE_AREA, SessionManagerBase.getSiteIdString()));
    }

    public static Map<String, SiteConfineIp> getSiteConfineIp() {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_CONFINE_IP, SessionManagerBase.getSiteIdString()));
    }

    public static Map<String, SiteConfineIp> getSiteConfineIp(Integer siteId) {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_CONFINE_IP, siteId.toString()));
    }

    //取得站点系统用户
    public static Map<String, VSysSiteUser> getSysSiteUser() {
        return getProxy().get(CacheKey.CACHE_KEY_SITE_USER);
    }

    /** 取得全平台的管理用户 */
    public static Map<String, SysUserExtend> getSysUser() {
        return getProxy().get(CacheKey.CACHE_KEY_SYS_USER);
    }

    /** 根据siteId获取SiteI18n */
    public static Map<String, SiteI18n> getSiteI18n(SiteI18nEnum dictEnum, Integer siteId) {
        Map<String, SiteI18n> map = getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_I18N, String.valueOf(siteId), dictEnum.getModule().getCode(), dictEnum.getType()));
        if (map == null) {
            return MapTool.newLinkedHashMap();
        }
        if (StringTool.isBlank(dictEnum.getCode())) {
            return map;
        }
        Map<String, SiteI18n> rs = new LinkedHashMap<>(3);
        Set<String> set = map.keySet();
        for (String key : set) {
            if (key.startsWith(dictEnum.getCode())) {
                SiteI18n siteI18n = map.get(key);
                rs.put(siteI18n.getLocale(), siteI18n);
            }
        }
        return rs;
    }

    /**
     * 当查询按类别:返回的Map中的key值为:key:locale
     * 当查询按类别:返回的Map中的key值为:key
     */
    public static Map<String, SiteI18n> getSiteI18n(SiteI18nEnum dictEnum) {
        return getSiteI18n(dictEnum, SessionManagerBase.getSiteId());
    }

    public static Map<String, SiteLanguage> getSiteLanguage() {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LANGUAGE, SessionManagerBase.getSiteIdString()));
    }

    /** 站点语言 */
    public static Map<String, SiteLanguage> getAvailableSiteLanguage() {
        Map<String, SiteLanguage> availableSiteLanguageMap = new LinkedHashMap<>();
        Map<String, SiteLanguage> siteLanguageMap = getSiteLanguage();
        for (Map.Entry<String, SiteLanguage> entry : siteLanguageMap.entrySet()) {
            SiteLanguage siteLanguage = entry.getValue();
            if (SiteLangStatusEnum.USING.getCode().equals(siteLanguage.getStatus())) {
                availableSiteLanguageMap.put(entry.getKey(), siteLanguage);
            }
        }
        return availableSiteLanguageMap;
    }

    public static Map<String, SiteCurrency> getAvailableSiteCurrency(Integer... siteIds) {
        Integer siteId = ArrayTool.isNotEmpty(siteIds) ? siteIds[0] : SessionManagerBase.getSiteId();
        Map<String, SiteCurrency> availableSiteCurrencyMap = new LinkedHashMap<>();
        Map<String, SiteCurrency> siteCurrencyMap = getSiteCurrency(siteId);
        for (Map.Entry<String, SiteCurrency> entry : siteCurrencyMap.entrySet()) {
            SiteCurrency siteLanguage = entry.getValue();
            if (SiteLangStatusEnum.USING.getCode().equals(siteLanguage.getStatus())) {
                availableSiteCurrencyMap.put(entry.getKey(), siteLanguage);
            }
        }
        return availableSiteCurrencyMap;
    }

    public static Map<String, SiteCurrency> getSiteCurrency(Integer siteId) {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_CURRENCY, siteId.toString()));
    }
    public static Map<String, SiteCurrency> getSiteCurrency() {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_CURRENCY, SessionManagerBase.getSiteIdString()));
    }
    public static Map<String, SiteOperateArea> getAvailableSiteOperateArea() {
        Map<String, SiteOperateArea> availableSiteOperateAreaMap = new LinkedHashMap<>();
        Map<String, SiteOperateArea> siteOperateAreaMap = getSiteOperateArea();
        for (Map.Entry<String, SiteOperateArea> entry : siteOperateAreaMap.entrySet()) {
            SiteOperateArea siteOperateArea = entry.getValue();
            if (SiteLangStatusEnum.USING.getCode().equals(siteOperateArea.getStatus())) {
                availableSiteOperateAreaMap.put(entry.getKey(), siteOperateArea);
            }
        }
        return availableSiteOperateAreaMap;
    }

    public static Map<String, SiteOperateArea> getSiteOperateArea() {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_OPERATE_AREA, SessionManagerBase.getSiteIdString()));
    }

    public static Map<String, SiteOperateArea> getSiteOperateArea(Integer siteId) {
        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_OPERATE_AREA, siteId.toString()));
    }

    public static Map<String, VSysSiteDomain> getSiteDomain() {
        if (siteDomainMap == null || lastAccess == null || (System.currentTimeMillis() - lastAccess.getTime()) > 60000L) {
            lastAccess = new Date();
            siteDomainMap = getProxy().get(CacheKey.CACHE_KEY_DOMAIN);
        }
        return siteDomainMap;
    }

    public static List<VSysSiteDomain> getHallDomainBySiteId(Integer siteId) {
        Map<String, VSysSiteDomain> map = getSiteDomain();

        if (MapTool.isEmpty(map)) {
            return null;
        }

        List<VSysSiteDomain> domains = new ArrayList<>();
        for (VSysSiteDomain domain : map.values()) {
            if (ResolveStatusEnum.SUCCESS.getCode().equals(domain.getResolveStatus())) {
                domains.add(domain);
            }
        }
        return domains;
    }

    public static String getSiteNameBySiteId(Integer siteId) {
        Map<String, SiteI18n> siteI18nMap = getSiteI18n(SiteI18nEnum.SETTING_SITE_NAME, siteId);
        SiteI18n siteI18n = siteI18nMap.get(CommonContext.get().getLocale().toString());
        if (siteI18n != null) {
            return siteI18n.getValue();
        }
        return "";
    }

    public static TimeZone getTimezoneByGmt(String gmtZone) {
        TimeZone timeZone = TimeZone.getTimeZone(gmtZone);
        return timeZone;
    }

    /** 站点信息 */
    public static Map<String, SysSite> getSysSite() {
        Map<String, SysSite> sysSiteMap = getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SYS_SITE));
        return sysSiteMap;
    }

    /** 根据站点ID获取站点信息 */
    public static SysSite getSiteById(Integer siteId) {
        Map<String, SysSite> map = getSysSite();
        if (MapTool.isNotEmpty(map)) {
            return map.get(String.valueOf(siteId));
        }
        log.error("缺少站点:{0} 的缓存数据！", siteId);
        return null;
    }

//    /**
//     * 获取六合彩所有号码对应的生肖
//     * @return key:号码 value:生肖
//     */
//    public static Map<String, String> getLotteryLhcZodiacMap() {
//        Map<String, LotteryLhcZodiac> map = getLotteryLhcZodiac();
//        Map<String, String> zodicNumMap = new HashMap<>();
//        for (String key : map.keySet()) {
//            zodicNumMap.put(key, map.get(key).getZodiacName());
//        }
//        if (MapTool.isEmpty(zodicNumMap)) {
//            log.error("缺少六合彩生肖（LotteryLhcZodiac）的缓存数据！");
//        }
//        return zodicNumMap;
//    }
//
//    /**
//     * 根据号码获取六合彩生肖
//     * @return key:号码,value:生肖
//     */
//    public static List<String> getLotteryLhcZodiacList(String... openCodes) {
//        Map<String, String> zodicMap = getLotteryLhcZodiacMap();
//        if (MapTool.isEmpty(zodicMap)) {
//            return null;
//        }
//        if(openCodes == null || openCodes.length == 0){
//            log.error("缺少开奖号码！");
//            return new ArrayList<>(0);
//        }
//        List<String> result = new ArrayList<>(openCodes.length);
//        for (int i = 0; i < openCodes.length ; i++) {
//            result.add(zodicMap.get(openCodes[i]));
//        }
//        return result;
//    }
//
//    /**
//     * 获取六合彩生肖对应的号码列表
//     * @return key:生肖 value:号码列表,由小到大
//     */
//    public static Map<String, String[]> getLotteryLhcZodiacNumsMap() {
//        Map<String, LotteryLhcZodiac> zodicNumMap = getLotteryLhcZodiac();
//        if (MapTool.isEmpty(zodicNumMap)) {
//            log.error("缺少六合彩生肖（LotteryLhcZodiac）的缓存数据！");
//            return null;
//        }
//        Map<String, List<String>> temp = new HashMap<>(12, 1f);
//        List<LotteryLhcZodiac> zodiacs = CollectionQueryTool.sort(zodicNumMap.values(), Order.asc(LotteryLhcZodiac.PROP_ZODIAC_NUM));
//        for (LotteryLhcZodiac zodiac : zodiacs) {
//            if (zodiac != null) {
//                List<String> list = new ArrayList<>();
//                if (temp.containsKey(zodiac.getZodiacName())) {
//                    list = temp.get(zodiac.getZodiacName());
//                }
//                String tempStr = zodiac.getZodiacNum();
//                if (StringTool.isNotEmpty(tempStr) && tempStr.length() == 1) {
//                    tempStr = "0" + tempStr;
//                }
//                list.add(tempStr);
//                temp.put(zodiac.getZodiacName(), list);
//            }
//        }
//        //方便页面使用
//        Map<String, String[]> result = new HashMap<>(12, 1f);
//        for (String name : temp.keySet()) {
//            List<String> list = temp.get(name);
//            if (CollectionTool.isNotEmpty(list)) {
//                result.put(name, list.toArray(new String[list.size()]));
//            }
//        }
//        return result;
//    }
//
//    public static Map<String, LotteryLhcZodiac> getLotteryLhcZodiac() {
//        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_LHC_ZODIAC));
//    }
//
//    public static Map<String, LotteryType> getLotteryType() {
//        return getProxy().get(CacheKey.CACHE_KEY_LOTTERY_TYPE);
//    }

    /**
     * 获取开奖结果数据
     * @return
     */
    public static Map<String, Serializable> getLotteryResult() {
        Map<String, Serializable> result = getProxy().get(CacheKey.CACHE_KEY_LOTTERY_RESULT);
        if(MapTool.isEmpty(result)){
            log.error("缺少LotteryResult的缓存数据！");
            return new HashMap<>(0);
        }
        return result;
    }

//    /**
//     * 根据code查询已封盘最后一期和近期未封盘数据
//     * @param code
//     * @return
//     */
//    public static List<LotteryResult> getLotteryResult(String code) {
//        Map<String, LotteryResult> result = getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT,code));
//        if(MapTool.isEmpty(result)){
//            log.error("缺少code:{0}的LotteryResult的缓存数据！",code);
//            return new ArrayList<>(0);
//        }
//        List<LotteryResult> list = new ArrayList<>(result.values());
//        return list;
//    }

//    /**
//     * 根据code与expect获取开奖结果数据
//     * @param code
//     * @param expect
//     * @return
//     */
//    public static LotteryResult getLotteryResult(String code,String expect) {
//        List<LotteryResult> list = getLotteryResult(code);
//        LotteryResult result = CollectionTool.findFirst(list, new Predicate() {
//            @Override
//            public boolean evaluate(Object o) {
//                if (o != null) {
//                    return expect.equals(((LotteryResult) o).getExpect());
//                } else {
//                    log.error("LotteryResult数据为空！");
//                    return false;
//                }
//            }
//        });
//        if(CollectionTool.isEmpty(list) || result == null){
//            log.error("缺少彩种:{0},期数:{1},的LotteryResult的缓存数据！",code,expect);
//            return null;
//        }
//        return result;
//    }
//    /**
//     * 获取自主开号规则
//     * @return
//     */
//    public static Map<String, LotteryRule> getLotteryRule(String siteId) {
//        Map<String, LotteryRule> result = getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT_RULE,siteId));
//        if(MapTool.isEmpty(result)){
//            log.error("缺少siteId:{0}的LotteryResultRule的缓存数据！",siteId);
//            return new HashMap<>(0);
//        }
//        return result;
//    }

    public static void refreshLotteryRule(Integer siteId) {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT_RULE, Integer.toString(siteId)));
    }

//    /**
//     * 获取杀率
//     * @return
//     */
//    public static LotteryRule getLotteryRule(String siteId, String code) {
//        Map<String, LotteryRule> map = CacheBase.getLotteryRule(siteId);
//        if(MapTool.isEmpty(map) || map.get(code) == null){
//            log.error("缺少siteId:{0},code:{1}的LotteryResultRule的缓存数据！",siteId,code);
//            return null;
//        }
//        return map.get(code);
//    }

    public static void refreshLotteryType() {
        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY_TYPE);
    }

    public static void refreshLotteryResult(String... codes) {
        if (ArrayTool.isEmpty(codes)) {
            log.error("参数错误 缺少彩种 code:{0}",codes);
            return;
        }
        for (String code: codes) {
            getProxy().refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT,code));
        }
    }

//    public static Map<String, LotteryBetOrder> getLotteryBetOrder(Integer siteId,String code,String expect) {
//        Map<String, LotteryBetOrder> result = getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_BET_ORDER,siteId.toString(),code,expect));
//        if(MapTool.isEmpty(result)){
//            log.error("缺少LotteryBetOrder的缓存数据！");
//            return new HashMap<>(0);
//        }
//        return result;
//    }
//    /** 从缓存中获取玩家彩种模式*/
//    public static  Map<String,UserLotteryCodeModel> getUserLotteryCodeModel(String userId) {
//        if (StringTool.isBlank(userId)) {
//            return new HashMap<>(0);
//        }
//        Map<String,UserLotteryCodeModel> map= getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_CODE_MODEL, SessionManagerBase.getSiteIdString(),userId));
//
//        if(MapTool.isEmpty(map)){
//            log.error("缺少userId:{0}的LotteryResult的缓存数据！",userId);
//            return new HashMap<>(0);
//        }
//        return map;
//
//    }
//
//    public static UserLotteryCodeModel getUserLotteryCodeModelByCode(String userId,String code) {
//        if(getUserLotteryCodeModel(userId)==null) {
//            return null;
//        }
//        return getUserLotteryCodeModel(userId).get(code);
//
//
//    }

    public static void  refreshLotteryBetOrder (Integer siteId, String code,String expect) {
        if (StringTool.isBlank(code)) {
            log.error("参数错误 缺少彩种 code:{0}",code);
            return;
        }
        getProxy().refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_BET_ORDER + CacheKey.CACHE_KEY_SEPERATOR + siteId.toString() + CacheKey.CACHE_KEY_SEPERATOR + code + CacheKey.CACHE_KEY_SEPERATOR + expect));
    }

    public static void refreshUserLotteryCodeModel(String userId) {
        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY_CODE_MODEL + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString()+CacheKey.CACHE_KEY_SEPERATOR + userId);
    }

//    public static Map<String,List<LotteryGatherConf>> getLotteryGatherConf(String confType) {
//        Map<String, Serializable> gatherConfMap = getProxy().get(CacheKey.CACHE_KEY_LOTTERY_GATHER_CONF);
//        if(MapTool.isEmpty(gatherConfMap)){
//            log.error("缺少confType:{0}的LotteryGatherConf的缓存数据!",confType);
//            return null;
//        }
//        return (Map<String,List<LotteryGatherConf>>) gatherConfMap.get(confType);
//    }
//
//
//
//    public static List<LotteryGatherConf> getLotteryGatherConf(String confType,String code) {
//        if(StringTool.isEmpty(code)){
//            log.error("LotteryGatherConf:缺少code参数!");
//            return null;
//        }
//        Map<String,List<LotteryGatherConf>> map = getLotteryGatherConf(confType);
//        if(MapTool.isEmpty(map)){
//            return null;
//        }
//        List<LotteryGatherConf> result = map.get(code);
//        if(CollectionTool.isEmpty(result)){
//            log.error("缺少confType:{0},code:{1}的LotteryGatherConf的缓存数据!",confType,code);
//            return null;
//        }
//        return result;
//    }

    public static void refreshLotteryGatherConf() {
        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY_GATHER_CONF);
    }

    /** 站点域名基本信息缓存 */
    public static VSysSiteDomain getSiteDomain(String domain) {
        if (StringTool.isBlank(domain)) {
            log.error(new Exception("缺失域名变量"));
            return null;
        }
        domain = getDomain(domain);
        Map<String, VSysSiteDomain> map = getSiteDomain();
        if (MapTool.isNotEmpty(map)) {
            return map.get(domain);
        }
        return null;
    }

    public static String getDomain(String domain) {
        if (domain.startsWith("www.")) {
            domain = domain.substring(4);
        } else if (domain.startsWith("m.")) {
            domain = domain.substring(2);
        } else if (domain.startsWith("android.")) {
            domain = domain.substring("android.".length());
        } else if (domain.startsWith("ios.")) {
            domain = domain.substring("ios.".length());
        }
        return domain;
    }

    /** 运营优惠活动分类的默认分类，不属于站点分类，这里做特殊处理 */
    public static Map<String, SiteI18n> getOperateActivityClassify(Integer... siteIds) {
        Integer siteId = ArrayTool.isNotEmpty(siteIds) ? siteIds[0] : SessionManagerBase.getSiteId();
        Map<String, SiteI18n> stringSiteI18nMap = getSiteI18n(SiteI18nEnum.OPERATE_ACTIVITY_CLASSIFY, siteId);
        if (stringSiteI18nMap == null) {
            stringSiteI18nMap = new HashMap<>();
        }
        Map<String, SiteI18n> stringSiteI18nMap1 = getSiteI18n(SiteI18nEnum.OPERATE_ACTIVITY_CLASSIFY, BOSS_SITE_ID);
        for (String s : stringSiteI18nMap1.keySet()) {
            stringSiteI18nMap.put(s, stringSiteI18nMap1.get(s));
        }
        return stringSiteI18nMap;
    }
    public static void refreshContentDocument() {
        getProxy().refresh(CacheKey.CACHE_KEY_CTT_DOCUMENT + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString());
    }

    public static void refreshContentDocumentI18n() {
        getProxy().refresh(CacheKey.CACHE_KEY_CTT_DOCUMENT_I18N + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString());
    }


    /**
     * 根据彩种获取当前彩种的商户彩种列表
     */
    public static List<Lottery> getMerchantLotteryList(String code) {
        List<Lottery> result = new ArrayList<>();
        Map<String, List<Lottery>> map = getMerchantLotteryMap();
        if (MapTool.isNotEmpty(map)) {
            for(List<Lottery> values : map.values()){
                if(CollectionTool.isNotEmpty(values)){
                    for(Lottery lottery : values){
                        if(lottery != null && code.equals(lottery.getCode())){
                            result.add(lottery);
                        }
                    }
                }
            }
        }
        if (CollectionTool.isEmpty(result)) {
            log.error("缺少code:{0}的商户Lottery的缓存数据！", code);
            return new ArrayList<>(0);
        }
        return result;
    }

    /**
     * 商户彩票 add by marz
     */
    public static Map<String, List<Lottery>> getMerchantLotteryMap() {
        Map<String, Serializable> map = getLotteryAllMap();
        if(MapTool.isEmpty(map)){
            return new HashMap<>(0);
        }
        Map<String, List<Lottery>> result = new HashMap<>();
        for(String key : map.keySet()){
            if(StringTool.isNotBlank(key) && !Integer.toString(BOSS_SITE_ID).equals(key) && map.get(key) != null){
//                result.put(key,(List<Lottery>)map.get(key));

                List<Lottery> list = new ArrayList<>();
                ((Map<String, Lottery>)map.get(key)).forEach((k, value) -> {
                    list.add(value);
                });
                result.put(key,list);
            }
        }
        return result;
    }
    /**
     * 获取全部彩种缓存
     * @return
     */
    private static Map<String, Serializable> getLotteryAllMap() {
        Map<String, Serializable> map = CacheTool.get(CacheKey.CACHE_KEY_LOTTERY);
        if (MapTool.isEmpty(map)) {
            log.error("缺少Lottery的缓存数据！");
        }
        return map;
    }

    /**
     * 根据站点id获取全部彩种缓存
     * @param siteId
     * @return
     */
    public static List<Lottery> getLotteryList(Integer siteId) {
        List<Lottery> list = new ArrayList<>();
        Map<String, Serializable> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY, siteId.toString()));
        if (MapTool.isEmpty(map)) {
            log.error("缺少Lottery的缓存数据！");
        }
        map.forEach((key, value) -> {
            list.add((Lottery) value);
        });
        return list;
    }

    /**
     * 根据站点id,彩种类型获取全部彩种缓存
     * @param siteId
     * @param type
     * @return
     */
    public static List<Lottery> getLotteryListByType(Integer siteId, String type) {
        List<Lottery> list = new ArrayList<>();
        Map<String, Serializable> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY, siteId.toString()));
        if (MapTool.isEmpty(map)) {
            log.error("缺少Lottery的缓存数据！");
        }
        map.forEach((key, value) -> {initLotterys (list,(Lottery) value,type); });
        return list;
    }

    private static void initLotterys (List<Lottery> list, Lottery value,String type) {
        if (type.equals(value.getType())) {
            list.add(value);
        }
    }

    /**
     * 站点彩票 add by Fei
     */
    public static Map<String, Lottery> getLotteryMap() {
        return getLotteryMap(SessionManagerBase.getSiteId());
    }

    /**
     * 根据siteId获取站点彩票
     */
    public static Map<String, Lottery> getLotteryMap(Integer siteId) {
        List<Lottery> result = getLotteryList(siteId);
        return CollectionTool.toEntityMap(result, Lottery.PROP_CODE, String.class);
    }

    /**
     * 根据Code获取彩种
     */
    public static Lottery getLottery(String code) {
        if (StringTool.isBlank(code)) {
            return null;
        }
        return getLotteryMap().get(code);
    }

    /**
     * 根据siteId与code获取站点彩票
     */
    public static Lottery getLottery(Integer siteId, String code) {
        if (siteId == null || StringTool.isBlank(code)) {
            return null;
        }
        return getLotteryMap(siteId).get(code);
    }

//    public static Map<String, LotteryOddSet> getOddSet(Integer siteId,Integer projectId, String code) {
//        Map<String, LotteryOddSet> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_ODD_SET, siteId.toString(),projectId.toString(), code));
//        if (MapTool.isEmpty(map)) {
//            log.error("缺少Lottery Odd Set的缓存数据！");
//        }
//        return map;
//    }

    /**
     * 根据彩种获取站点赔率设置
     */
//    public static Map<String, LotteryOddSet> getOddSet(Integer projectId,String code) {
//        if (StringTool.isBlank(code)) {
//            return null;
//        }
//        log.info("站点SessionManagerBase.getSiteId：{0}，彩种code:{1},用户名：{2},方案:{3}",SessionManagerBase.getSiteId(), code,SessionManagerBase.getUserName(),projectId);
//        return getOddSet(SessionManagerBase.getSiteId(),projectId, code);
//    }

    /** 刷新赔率缓存 */
    public static void refreshOddSet(String code) {
        refreshOddSet(SessionManagerBase.getSiteId(), code);
    }

    public static void refreshOddSet(Integer siteId, String code) {
        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY_ODD_SET + CacheKey.CACHE_KEY_SEPERATOR + siteId + CacheKey.CACHE_KEY_SEPERATOR + code);
    }

//    /** 获取站点限额缓存 */
//    public static Map<String, LotteryQuotaSet> getQuotaSet(Integer siteId, String code) {
//        Map<String, LotteryQuotaSet> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_QUOTA_SET, siteId.toString(), code));
//        if (map == null) {
//            log.error("缺少Lottery Quota Set的缓存数据！");
//        }
//        return map;
//    }
//
//    /**
//     * 根据彩种获取站点限额设置
//     */
//    public static Map<String, LotteryQuotaSet> getQuotaSet(String code) {
//        if (StringTool.isBlank(code)) {
//            return null;
//        }
//        return getQuotaSet(SessionManagerBase.getSiteId(), code);
//    }

    /** 刷新站点限额缓存 */
    public static void refreshQuotaSet(String code) {
        refreshQuotaSet(SessionManagerBase.getSiteId(), code);
    }

    public static void refreshQuotaSet(Integer siteId, String code) {
        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY_QUOTA_SET + CacheKey.CACHE_KEY_SEPERATOR + siteId + CacheKey.CACHE_KEY_SEPERATOR + code);
    }

}
