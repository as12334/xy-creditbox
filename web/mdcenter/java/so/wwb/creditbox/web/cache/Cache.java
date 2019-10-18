package so.wwb.creditbox.web.cache;

import org.soul.commons.cache.CacheTool;
import org.soul.commons.collections.MapTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.sms_interface.po.SmsInterface;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteUser;

import java.util.Date;
import java.util.Map;

/**
 * Created by tony on 15-7-30.
 */
public class Cache {

    private static final Log LOG = LogFactory.getLog(Cache.class);
    private static CacheTool cacheTool;

    private static CacheTool getProxy() {
        if (cacheTool == null) {
            cacheTool = (CacheTool) SpringTool.getBean("cacheTool");
        }
        return cacheTool;
    }
    //region   本地静态代理缓存
    private static Map<String, VSysSiteUser> sysSiteUserMap;
    private static Date sysSiteUserLastAccess;

    private static boolean isTimeout(Map map,Date lastAccess) {
        return map == null || lastAccess == null || (new Date().getTime() - lastAccess.getTime()) > 60000l;
    }

    public static Map<String, VSysSiteUser> getSysSiteUser() {
        if (isTimeout(sysSiteUserMap,sysSiteUserLastAccess)) {
            synchronized (CacheKey.CACHE_KEY_SITE_USER) {
                sysSiteUserMap = getProxy().get(CacheKey.CACHE_KEY_SITE_USER);
                sysSiteUserLastAccess = new Date();
                return sysSiteUserMap;
            }
        }
        return sysSiteUserMap;
    }


    /**
     * 总控短信接口缓存
     * @return
     */
    public static Map<String, SmsInterface> getCommonSmsInterfaces() {
        Map<String, SmsInterface> map =null;// CacheTool.get(CacheKey.getCacheKey(CacheKey.CACHE_KEY_COMMON_SMS_INTERFACE));
        if (MapTool.isEmpty(map)) {
            LOG.error("缺少总控 SMS_INTERFACE短信接口的缓存数据！");
        }
        return map;
    }

}
