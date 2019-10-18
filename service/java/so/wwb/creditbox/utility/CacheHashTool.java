package so.wwb.creditbox.utility;

import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;

import java.text.MessageFormat;
import java.util.Date;

/**
 * 缓存hash
 * Created by marz on 18-3-15.
 */
public class CacheHashTool {
    private static final Log LOG = LogFactory.getLog(CacheHashTool.class);

    //开奖,撤单，撤销共用同一个时间与key
    private static final int COMMON_OFFSET = 30;

    //补采
    private static final int MAKEUP_OFFSET = 10;

    private static final int OFFSET = 30;


    private static JedisClientProxy jedisTemplate = (JedisClientProxy) SpringTool.getBean("jedisTemplateData");


    /**
     * 开奖,撤单，撤销
     * 是否间隔内满足30s间隔hash
     *
     * @return
     */
    public static boolean checkCommonCacheHash(String code, String expect, Integer siteId) {
        String key = getCommonCacheHashKey(code,expect,siteId);
        String lastHash = jedisTemplate.get(key);
        String offsetHash = getCommonCacheHashValue(code,expect,siteId, DateTool.addSeconds(new Date(), -COMMON_OFFSET));
        String currentHash = getCommonCacheHashValue(code,expect,siteId);
        LOG.info("参数:{0},上次开奖hash:{1},间隔hash:{2},当前hash:{3},新旧hash是否相等:{4}", key, lastHash, offsetHash, currentHash, offsetHash.equals(lastHash));
        boolean result = (StringTool.isNotBlank(lastHash) && (offsetHash.equals(lastHash) || currentHash.equals(lastHash)));
        if(!result){
            String resultHash = getCommonCacheHashValue(code,expect,siteId);
            jedisTemplate.setex(key, 60, resultHash);
        }
        return result;
    }

    private static String getCommonCacheHashKey(String code, String expect, Integer siteId){
        return MessageFormat.format("{0}_{1}_{2}", code, expect, siteId);
    }

    private static String getCommonCacheHashValue(String code, String expect, Integer siteId){
        return getCommonCacheHashValue(code,expect,siteId,new Date());
    }

    private static String getCommonCacheHashValue(String code, String expect, Integer siteId, Date date){
        int ss = (int) (date.getTime() / 1000 / COMMON_OFFSET);
        return MessageFormat.format("{0}_{1}_{2}_{3}", code, expect, siteId, ss);
    }


    /**
     * 补采10s间隔判断
     * @param code
     * @return
     */
    public static boolean checkMakeUpCacheHash(String code,String endDate) {
        String key = getMakeUpCacheHashKey(code,endDate);
        String lastHash = jedisTemplate.get(key);
        String offsetHash = getMakeUpCacheHashValue(code,endDate, DateTool.addSeconds(new Date(), -MAKEUP_OFFSET));
        String currentHash = getMakeUpCacheHashValue(code,endDate);
        LOG.info("参数:{0},上次补采hash:{1},间隔hash:{2},当前hash:{3},结果:{4}", key, lastHash, offsetHash, currentHash, offsetHash.equals(lastHash));
        boolean result = (StringTool.isNotBlank(lastHash) && (offsetHash.equals(lastHash) || currentHash.equals(lastHash)));
        if(!result){
            String resultHash = getMakeUpCacheHashValue(code,endDate);
            jedisTemplate.setex(key, 60, resultHash);
        }
        return result;
    }

    private static String getMakeUpCacheHashKey(String code,String endDate){
        return MessageFormat.format("{0}_{1}", code, endDate);
    }

    private static String getMakeUpCacheHashValue(String code,String endDate){
        return getMakeUpCacheHashValue(code,endDate,new Date());
    }

    private static String getMakeUpCacheHashValue(String code,String endDate,Date date){
        int ss = (int) (date.getTime() / 1000 / MAKEUP_OFFSET);
        return MessageFormat.format("{0}_{1}_{2}_{3}", code, ss);
    }


    /**
     * 30s间隔判断
     * @return
     */
    public static boolean checkCacheHash(String... param) {
        String key = getCacheHashKey(param);
        String lastHash = jedisTemplate.get(key);
        String offsetHash = getCacheHashValue(DateTool.addSeconds(new Date(), -OFFSET),param);
        String currentHash = getCacheHashValue(param);
        LOG.info("参数:{0},上次hash:{1},间隔hash:{2},当前hash:{3},结果:{4}", key, lastHash, offsetHash, currentHash, offsetHash.equals(lastHash));
        boolean result = (StringTool.isNotBlank(lastHash) && (offsetHash.equals(lastHash) || currentHash.equals(lastHash)));
        if(!result){
            String resultHash = getCacheHashValue(param);
            jedisTemplate.setex(key, 60, resultHash);
        }
        return result;
    }

    private static String getCacheHashKey(String... param){
        return StringTool.join("_",param);
    }

    private static String getCacheHashValue(String... param){
        return getCacheHashValue(new Date(),param);
    }

    private static String getCacheHashValue(Date date,String... param){
        int ss = (int) (date.getTime() / 1000 / OFFSET);
        return StringTool.join("_",param)+"_"+ss;
    }
}
