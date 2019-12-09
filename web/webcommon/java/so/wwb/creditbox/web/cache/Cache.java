package so.wwb.creditbox.web.cache;

import org.apache.commons.collections.map.HashedMap;
import org.soul.commons.cache.CacheTool;
import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.collections.CollectionQueryTool;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.http.*;
import org.soul.commons.query.sort.Order;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.sys.po.SysParam;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.support.BaseWebBeanFactory;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.base.ParamTool;
import so.wwb.creditbox.model.company.lottery.po.SiteLottery;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryOdds;
import so.wwb.creditbox.model.company.lottery.po.SiteLotteryRebates;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.enums.base.BossParamEnum;
import so.wwb.creditbox.model.manager.lottery.po.LotteryOdds;
import so.wwb.creditbox.model.manager.lottery.po.LotteryResult;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.model.common.HidTool;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

public class Cache extends CacheBase {

    private static final Log log = LogFactory.getLog(Cache.class);
    private static JedisClientProxy jedisTemplate = BaseWebBeanFactory.getJedisTemplatePageCache();

    public static String getRcVersion() {
        JedisClientProxy jedisTemplateData = ((JedisClientProxy) SpringTool.getBean("jedisTemplateData"));
        String rcVersion = jedisTemplateData.get("data:RC_VERSION");
        if (StringTool.isBlank(rcVersion)) {
            rcVersion = String.valueOf(System.currentTimeMillis());
            jedisTemplateData.setex("data:RC_VERSION",7*24*60*60, rcVersion);
        }
        return rcVersion;
    }
    public static void refreshSiteLotteryOdds(String hid, String code) {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY_ODD, LotteryCommonContext.get().getSiteId().toString(),hid,code));
    }

    /*获取站点彩票赔率缓存*/
    public static Map<String, SiteLotteryOdds> getSiteLotteryOdds(String hid , String code) {
        Map<String, SiteLotteryOdds> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY_ODD, LotteryCommonContext.get().getSiteId().toString(),hid,code));
        if (MapTool.isEmpty(map)) {
            log.error("缺少SiteLotteryOdd的缓存数据！");
        }
        return map;
    }
    /*获取站点分公司彩票赔率缓存*/
    public static Map<String, SiteLotteryOdds> getBranchSiteLotteryOdds(String hid , String code) {
        return  getSiteLotteryOdds(HidTool.getBranchHid(hid),code);
    }

    public static void refreshSiteLotteryRebates(String hid ,String code) {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY_REBATE, LotteryCommonContext.get().getSiteId().toString(),hid,code));
    }

    /*获取站点彩票赔率缓存*/
    public static Map<String, SiteLotteryRebates> getSiteLotteryRebates(String hid , String code) {
        Map<String, SiteLotteryRebates> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY_REBATE, LotteryCommonContext.get().getSiteId().toString(),hid,code));
        if (MapTool.isEmpty(map)) {
            log.error("缺少SiteLotteryOdd的缓存数据！");
        }
        return map;
    }


    /**
     * 根据code查询开奖结果
     *
     * @param code
     * @return
     */
    public static List<LotteryResult> getLotteryResult(String code) {
        if (StringTool.isBlank(code)) {
            return new ArrayList<>(0);
        }
        Map<String, LotteryResult> result = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT, code));
        if (MapTool.isEmpty(result)) {
            log.error("缺少LotteryResult的缓存数据！");
            return new ArrayList<>(0);
        }
        List<LotteryResult> list = new ArrayList<>(result.values());
        return list;
    }
    /**
     * 刷新指定彩种的开奖结果
     */
    public static void refreshLotteryResult(String code) {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_RESULT, code));
    }

    /**
     * 刷新站点彩票
     *
     * @param siteId
     */
    public static void refreshSiteLottery(Integer siteId) {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY, String.valueOf(siteId)));
    }
    /**
     * 站点彩票
     *
     * @param siteId
     * @return
     */
    public static Map<String, SiteLottery> getSiteLottery(Integer siteId) {
        Map<String, SiteLottery> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY, String.valueOf(siteId)));
        if (MapTool.isEmpty(map)) {
            log.error("缺少siteLottery的缓存数据！");
        }
        return map;
    }

    /** 站点域名基本信息缓存 */
    public static VSysSiteDomain getSiteDomain(String domain) {
        if (StringTool.isBlank(domain)) {
            log.error(new Exception("缺失域名变量"));
            return null;
        }
        Map<String, VSysSiteDomain> map = getSiteDomain();
        if (map != null) {
            return map.get(domain);
        }
        return null;
    }
    /**
     * 清理外围页面缓存
     * @param siteId 站点ID
     */
    public static void purgeOutPageCache(final Integer siteId) {
        SysParam sysParam = ParamTool.getSysParam(BossParamEnum.OP_PURGE_OUT_PAGE_CACHE_URL);
        final String url = sysParam.getParamValue();
        /**
         * 直接请求外围刷新缓存
         */
        String servers=Cache.getSysSite().get(siteId.toString()).getServers();
        if(StringTool.isBlank(servers)){
            log.error("站点{0}请求外围刷新缓存为空,清理外围页面缓存失败",siteId.toString());
            return;
        }
        String[] serverArr=servers.split(",");
        for (final String server : serverArr) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    String targetUrl=url;
                    /**
                     * 兼容旧版的配置
                     * TODO v1071 在删除
                     */
                    if(url.indexOf("nginx.c")>0){
                        targetUrl=url.replace("nginx.c/purge_out_page_cache","{0}/__clear_html_cache");
                    }
                    targetUrl= MessageFormat.format(targetUrl+"?siteId={1}",server,siteId);
                    requestRefreshCache(targetUrl, "gamebox.com");
                }
            };
            thread.start();
        }
    }
    /**
     * 清理外围页面缓存
     * @param url 目标URL
     * @param host 目标Host
     * @return
     */
    private static boolean requestRefreshCache(String url,String host) {
        HttpClientParam httpParam = new HttpClientParam();
        httpParam.setAsync(true);
        httpParam.setUrl(url);
        httpParam.setMethod(HttpRequestMethod.GET);
        httpParam.setReqContentType(HttpContentType.XML);
        httpParam.setResContentType(HttpContentType.XML);
        Map<String, String> headers = httpParam.getHeaders();
        if (headers == null) {
            headers = new HashMap<>();
        }
        if(StringTool.isNotBlank(host)) {
            headers.put("Host", host);
        }
        httpParam.setConnectionManageKey("PageCache");
        httpParam.setHeaders(headers);
        HttpAsyncResult async = HttpClientTool.async(httpParam);
        HttpResult httpResult=async.get(HttpResult.class);
        int statusCode=httpResult.getResponse().getStatusLine().getStatusCode();
        if(statusCode==200){
            log.debug("刷新站点HTML缓存:{0},成功",url);
        }else{
            log.debug("刷新站点HTML缓存:{0},失败",url);
        }
        return statusCode==200;
    }

    public static Map<String,Serializable> getIpDb(){
        Map<String, Serializable> map = CacheTool.get(CacheKey.CACHE_KEY_IP_DB);
        if (map == null) {
            log.error("缺少IpDb中国大陆的缓存数据！");
        }
        return map;
    }

//    public static void refreshIpDb() {
//        getProxy().refresh(CacheKey.CACHE_KEY_IP_DB);
//    }


    /**
     * 刷新所有站点彩票
     *
     * @param
     */
    public static void refreshAllSiteLottery() {
        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SITE_LOTTERY));
    }
//
//    /**
//     * 站点彩票
//     */
//    public static Map<String, Lottery> getLottery(Integer siteId) {
//        Map<String, Lottery> map = getLotteryMap(siteId);
//        if (map == null) {
//            log.error("缺少Lottery的缓存数据！");
//        }
//        return map;
//    }
//    /**
//     * 获取站点彩票类型
//     */
//    public static List<LotteryType> getSiteLotteryType (Integer siteId) {
//        Map<String,LotteryType> map = getLotteryType();
//        Map<String, List<Lottery>> map1 = getLotteryByType(siteId);
//        List<LotteryType> list = new ArrayList<>();
//        map.forEach((k,v)->initSiteLotteryType (k,v,map1,list));
//        return list;
//    }
//
//    private static void initSiteLotteryType (String key, LotteryType v, Map<String, List<Lottery>> map1, List<LotteryType> list) {
//        List<Lottery> list1 = map1.get(key);
//        if (CollectionTool.isNotEmpty(list1)) {
//            LotteryType value = new LotteryType();
//            value.setLotteryNum(String.valueOf(list1.size()));
//            value.setTypeName(v.getTypeName());
//            value.setTypeCode(key);
//            list.add(value);
//        }
//
//
//    }
//
//    /**
//     * 获取站点彩种类型对应的彩票
//     */
//    public static Map<String, List<Lottery>> getLotteryByType (Integer siteId) {
//        Map<String, List<Lottery>> typeMap = new HashMap<>();
//        Map<String, Lottery> map = getLottery(siteId);
//        map.forEach((k,v)-> initLotteryByType(v,typeMap));
//        return typeMap;
//    }
//
//    /**
//     * 根据站点id,类型获取彩种
//     */
//    public static List<Lottery> getLotteryByType (Integer siteId, String type) {
//        Map<String, List<Lottery>> map = getLotteryByType(siteId);
//        return map.get(type);
//    }
//
//    /**
//     * 根据站点id,类型获取彩种
//     */
//    public static List<Lottery> getLotteryByCalssify (Integer siteId, String classify) {
//        if (siteId == null) {
//            siteId = 0;
//        }
//        List<Lottery> result = new ArrayList<>();
//        Map<String, Lottery> map = getLottery(siteId);
//        map.forEach((k,v)->initLotteryByClassify(v,classify,result));
//        return result;
//    }
//
//    private static void initLotteryByType (Lottery lottery, Map<String, List<Lottery>> typeMap) {
//        if (CollectionTool.isEmpty(typeMap.get(lottery.getType()))) {
//            List<Lottery> list = new ArrayList<>();
//            list.add(lottery);
//            typeMap.put(lottery.getType(),list);
//        } else {
//            typeMap.get(lottery.getType()).add(lottery);
//        }
//    }
//
//    private static void initLotteryByClassify (Lottery lottery, String classify, List<Lottery> result) {
//        if (classify.equals(lottery.getClassify())) {
//            result.add(lottery);
//        }
//    }
//
//    /**
//     * 根据Code获取彩种
//     */
//    public static Lottery getLotteryByCode(String code) {
//        if (StringTool.isBlank(code)) return null;
//        Map<String, Lottery> map = getLotteryMap();
//        if (map == null) return null;
//        return map.get(code);
//    }
//
//    /**
//     * 获取Boss彩种
//     */
//    public static Lottery getBossLotteryByCode(String code) {
//        if (StringTool.isBlank(code)) return null;
//        Map<String, Lottery> map = getLotteryMap(BOSS_SITE_ID);
//        if (map == null) return null;
//        return map.get(code);
//    }
//
//    public static Map<String,List<Lottery>> getHighAndLowCodeMap(){
//        Map<String,Lottery> lotteryMap = getLotteryMap();
//        return installHighAndLowCodeMap(lotteryMap);
//    }
//
//    public static Map<String,List<Lottery>> getHighAndLowCodeMap(Integer siteId){
//        Map<String,Lottery> lotteryMap= getLotteryMap(siteId);
//        return installHighAndLowCodeMap(lotteryMap);
//    }
//
//    public static Map<String,List<Lottery>> installHighAndLowCodeMap(Map<String,Lottery> lotteryMap){
//        Map<String,List<Lottery>> map = new HashedMap();
//        List<Lottery> highCode = new ArrayList<>();
//        List<Lottery> lowCode = new ArrayList<>();
//        if (CollectionTool.isNotEmpty(lotteryMap.values())){
//            for(Lottery lottery :lotteryMap.values()){
//                if(FrequencyEnum.HIGH.getCode().equals(lottery.getFrequency())){
//                    highCode.add(lottery);
//                }else if (FrequencyEnum.LOW.getCode().equals(lottery.getFrequency())) {
//                    lowCode.add(lottery);
//                }
//            }
//        }
//        map.put("high",highCode);
//        map.put("low",lowCode);
//        return map;
//    }
//
//    /**
//     * 刷新站点彩票
//     */
//    public static void refreshLottery() {
//        getProxy().refresh(CacheKey.CACHE_KEY_LOTTERY);
//    }
//
//    /**
//     * @param  siteId 站点id
//     * 刷新站点彩票
//     */
//    public static void refreshSiteLottery(Integer siteId) {
//        getProxy().refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY,String.valueOf(siteId)));
//    }
//
//    /**
//     * 获取站点可用彩种
//     */
//    public static Map<String, Lottery> getNormalLottery() {
//        Map<String, Lottery> map = Cache.getLotteryMap();
//        if (MapTool.isEmpty(map)) return new HashMap<>(0);
//
//        Map<String, Lottery> normalMap = new HashMap<>();
//        String status = LotteryStatusEnum.NORMAL.getCode();
//        for (Lottery lottery : map.values()) {
//            if (status.equals(lottery.getStatus())) {
//                normalMap.put(lottery.getCode(), lottery);
//            }
//        }
//        return normalMap;
//    }
//    /**
//     * 获取站点可用彩种
//     */
//    public static List<Lottery> getNormalLotteryList() {
//        Map<String, Lottery> map = Cache.getLotteryMap();
//        if (MapTool.isEmpty(map)) return new ArrayList<>(0);
//        List<Lottery> lotteries = new ArrayList<>();
//        String status = LotteryStatusEnum.NORMAL.getCode();
//        for (Lottery lottery : map.values()) {
//            if (status.equals(lottery.getStatus())) {
//                lotteries.add(lottery);
//            }
//        }
//        return CollectionQueryTool.sort(lotteries, Order.asc(Lottery.PROP_ORDER_NUM));
//    }
////    /**
////     * 获取站点token
////     */
////    public static Map<String,OauthToken> getOauthToken() {
////        Integer siteId = SessionManagerBase.getSiteId();
////        Map<String, OauthToken> map = CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_OAUTH_TOKEN, String.valueOf(siteId)));
////        if (map == null) {
////            log.error("缺少oauth token的缓存数据！");
////        }
////        return map;
////    }
//
////    public static OauthToken getOauthToken(String token) {
////        Map<String, OauthToken> map = getOauthToken();
////        if (map != null) {
////            OauthToken oauthToken = map.get(token);
////            if (oauthToken != null) {
////                return oauthToken;
////            } else {
////                log.error("缺少{0} token的缓存数据", token);
////            }
////        }
////        return null;
////    }
//
//    /**
//     * 根据账号查找token
//     */
////    public static OauthToken getOauthTokenByUsername(String username) {
////         Map<String, OauthToken> map = getOauthToken();
////         for (Map.Entry<String, OauthToken> entry : map.entrySet()) {
////             OauthToken token = entry.getValue();
////             if (username.equals(token.getUsername())) {
////                 return token;
////             }
////         }
////         return null;
////    }
//
//    /**
//     * 刷新站点token
//     */
//    public static void refreshOauthToken() {
//        Integer siteId = SessionManagerBase.getSiteId();
//        getProxy().refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_OAUTH_TOKEN, String.valueOf(siteId)));
//    }
//
//    /**
//     * 根据终端获取站点可用彩种
//     */
//    public static List<Lottery> getNormalLottery(String terminal) {
//        Map<String, Lottery> lotteryMap = Cache.getLotteryMap();
//        if (MapTool.isEmpty(lotteryMap)) {
//            return null;
//        }
//        List<Lottery> lotteries = new ArrayList<>();
//        String normal = GameStatusEnum.NORMAL.getCode();
//        String allSupport = TerminalEnum.ALL.getCode();
//        for (Map.Entry<String, Lottery> entry : lotteryMap.entrySet()) {
//            Lottery lottery = entry.getValue();
//            if (lottery == null) continue;
//            if (normal.equals(lottery.getStatus()) && (allSupport.equals(lottery.getTerminal()) || terminal.equals(lottery.getTerminal()))) {
//                lotteries.add(lottery);
//            }
//        }
//        return CollectionQueryTool.sort(lotteries, Order.asc(Lottery.PROP_ORDER_NUM));
//    }
//
//    /** 获取站点彩票赔率缓存 */
//    public static Map<String,LotteryOddSet> getLotteryOdds(Integer projectId, String code) {
//        Map<String, LotteryOddSet> map = getOddSet(projectId,code);
//        if (map == null) {
//            log.error("缺少LotteryOdd的缓存数据！");
//        }
//        return map;
//    }
//
//    public static void refreshLotteryOdd() {
//        Integer siteId = SessionManagerBase.getSiteId();
//        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_ODD_SET, siteId.toString()));
//    }
//
//    public static void refreshLotteryOddSet(Integer projectId) {
//        Integer siteId = SessionManagerBase.getSiteId();
//        refreshLotteryOddSet(siteId,projectId);
//    }
//
//    public static void refreshLotteryOddSet(Integer siteId,Integer projectId) {
//        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_ODD_SET, String.valueOf(siteId), String.valueOf(projectId)));
//    }
//
//    public static void refreshLotteryQuotas(Integer siteId) {
//        if (siteId == null) {
//            siteId = SessionManagerBase.getSiteId();
//        }
//        CacheTool.refresh(CacheKey.getCacheKey(CacheKey.CACHE_KEY_LOTTERY_QUOTA_SET, siteId.toString()));
//    }
//
//    public static void refreshPayProvider() {
//        CacheTool.refresh(CacheKey.CACHE_KEY_PAYPROVIDER);
//    }
//    public static void refreshBank() {
//        CacheTool.refresh(CacheKey.CACHE_KEY_BANK);
//    }
//
//    public static void refreshBanner() {
//        getProxy().refresh(CacheKey.CACHE_KEY_BANNER + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString());
//    }
////
////    /** 从缓存中获取站点公告 */
////    public static Map<String, ContentBulletin> getContentBulletin() {
////        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_CONTENT_BULLETIN, SessionManagerBase.getSiteIdString()));
////    }
//
////    /**
////     * 获取要展示的公告
////     */
////    public static List<ContentBulletin> getNormalContentBulletin() {
////        Map<String, ContentBulletin> map = Cache.getContentBulletin();
////        if (MapTool.isEmpty(map)) {
////            return null;
////        }
////        List<ContentBulletin> bulletins = new ArrayList<>();
////        String normal = "0";
////        Date date = new Date();
////        date = DateTool.addHours(date, 8);
////        for (Map.Entry<String, ContentBulletin> entry : map.entrySet()) {
////            ContentBulletin bulletin = entry.getValue();
////            if (bulletin == null) continue;
////            if (bulletin.getDisplay() && normal.equals(bulletin.getStatus()) && date.getTime() > bulletin.getCreateTime().getTime()) {
////                bulletins.add(bulletin);
////            }
////        }
////        return CollectionQueryTool.sort(bulletins, Order.asc(ContentBulletin.PROP_ORDER_NUM));
////    }
//    public static void refreshContentBulletin() {
//        getProxy().refresh(CacheKey.CACHE_KEY_CONTENT_BULLETIN + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString());
//    }
//
//    /**从缓存中获取平台公告*/
//    public static Map<String ,SystemAnnouncement> getSysAnnouncement(){
//        return getProxy().get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_SYS_ANNOUNCEMENT, SessionManagerBase.getSiteIdString()));
//    }
//
//    public static void refreshSysAnnouncement(){
//        getProxy().refresh(CacheKey.CACHE_KEY_SYS_ANNOUNCEMENT + CacheKey.CACHE_KEY_SEPERATOR + SessionManagerBase.getSiteIdString());
//    }

}
