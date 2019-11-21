package so.wwb.creditbox.model.cache;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.cache.aop.point.CacheRefreshAopPoint;
import org.soul.commons.cache.core.CacheItemConf;
import org.soul.commons.cache.jedis.proxy.CustomJedisProxy;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.SerializationTool;
import org.soul.commons.lang.reflect.MethodTool;
import org.soul.commons.lang.reflect.PropertyTool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 15-4-27.下午1:18;
 */
public class CustomSiteOddsJedisPorxy extends CustomJedisProxy {

    @Override
    protected List<Object> buildMethodArgs(String subKey,CacheItemConf itemConf) {
        int keyLen = 2;
        //[0] == siteId
        //[1] == hid
        String[] array = subKey.split(CacheKey.CACHE_KEY_SEPERATOR);
        //args[0] == SiteI18nVo
        int index = 0;
        List<Object> rs = new ArrayList<>(itemConf.getMethodArgs().size());
        Serializable vo = (Serializable)itemConf.getMethodArgs().get(0);
        Serializable voClone = SerializationTool.clone(vo);
        rs.add(voClone);
        Serializable searchObject= (Serializable) MethodTool.invokeGetter(voClone, "search");

        if(PropertyTool.getAllProperties(searchObject.getClass()).contains("siteId")){
            if (array.length < keyLen) {
                MethodTool.invokeSetter(searchObject, "siteId", CommonContext.get().getSiteId());
            } else {
                MethodTool.invokeSetter(searchObject, "siteId", Integer.valueOf(array[0]));
            }
        } else{
            if (!(array.length < keyLen)) {
                MethodTool.invokeMethod(voClone, "_setDataSourceId", Integer.valueOf(array[0]));
            }
        }

        if (!(array.length < keyLen)) {
            MethodTool.invokeSetter(searchObject, "hid", array[1]);
        }
        return rs;
    }

    @Override
    public String getFullKeyName(CacheRefreshAopPoint cacheRefreshAopPoint, String rootKey, Object vo) {
        rootKey = super.getFullKeyName(cacheRefreshAopPoint,rootKey,vo);
        String module = (String) MethodTool.invokeGetter(vo,"module");
        String type = (String) MethodTool.invokeGetter(vo,"type");
        return rootKey + CacheKey.CACHE_KEY_SEPERATOR + module + CacheKey.CACHE_KEY_SEPERATOR + type;
    }
}
