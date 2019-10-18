package so.wwb.lotterybox.utility;

import com.google.gson.Gson;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.SafeEncoder;
import so.wwb.lotterybox.common.utility.common.SerializeTool;
import so.wwb.lotterybox.model.redis.RedisConfigCluster;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author: wilson
 * @function: redis utility for cluster
 * @deprecated:
 */
public class RedisToolCluster {
    //region instance
    private static final Log log = LogFactory.getLog(RedisToolCluster.class);
    private static JedisCluster jedisCluster = null;
    private static String[] redisHost = null;
    private static String[] port = null;
    private static Gson gson = new Gson();
    private static JedisPoolConfig jedisPoolConfig = null;

    static {
        RedisConfigCluster redisConfig = (RedisConfigCluster) SpringTool.getBean("redisConfig00");
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
        jedisPoolConfig.setTestOnBorrow(redisConfig.getTestOnBorrow());
        RedisToolCluster.redisHost = redisConfig.getRedisHost().split(",");
        RedisToolCluster.port = redisConfig.getPort().split(",");
    }

    private synchronized static JedisCluster getJedis() {
        if (null != RedisToolCluster.jedisCluster) return RedisToolCluster.jedisCluster;
        Set<HostAndPort> nodes = new HashSet<>();
        for (int i = 0; i < RedisToolCluster.redisHost.length; i++) {
            nodes.add(new HostAndPort(RedisToolCluster.redisHost[i], Integer.parseInt(RedisToolCluster.port[i])));
        }
        RedisToolCluster.jedisCluster = new JedisCluster(nodes, 1000, 1000, 1, jedisPoolConfig);
        return jedisCluster;
    }

    public static void ReleaseJedisCluster(JedisCluster jedisCluster) {
        try {
            jedisCluster.close();
        } catch (IOException e) {
            log.error("Release redis cluster occur exception", e);
        }
    }
    //endregion

    //region set

    public static void setJedis(String strKey, String strValue) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.set(strKey, strValue);
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisJson(String strKey, Object object) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.set(strKey, gson.toJson(object));
        ReleaseJedisCluster(jedis);
    }

    public static void setJedis(Map<String, String> strMap) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.set(entry.getKey(), entry.getValue());
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisJson(Map<String, Object> strMap) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.set(entry.getKey(), gson.toJson(entry.getValue()));
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisByte(String strKey, String strValue) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.set(SafeEncoder.encode(strKey), strValue.getBytes());
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisByte(Map<String, String> strMap) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.set(SafeEncoder.encode(entry.getKey()), entry.getValue().getBytes());
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisByteObject(String strKey, Object object) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.set(SafeEncoder.encode(strKey), SerializeTool.serialize(object));
        ReleaseJedisCluster(jedis);
    }

    public static void setJedisByteObject(Map<String, Object> strMap) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.set(SafeEncoder.encode(entry.getKey()), SerializeTool.serialize(entry.getValue()));
        }
        ReleaseJedisCluster(jedis);
    }

    //endregion

    //region setex (timeout: second)

    public static void setexJedis(String strKey, String strValue, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.setex(strKey, timeoutSeconds, strValue);
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisJson(String strKey, Object object, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.setex(strKey, timeoutSeconds, gson.toJson(object));
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedis(Map<String, String> strMap, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.setex(entry.getKey(), timeoutSeconds, entry.getValue());
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisJson(Map<String, Object> strMap, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.setex(entry.getKey(), timeoutSeconds, gson.toJson(entry.getValue()));
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisByte(String strKey, String strValue, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.setex(SafeEncoder.encode(strKey), timeoutSeconds, strValue.getBytes());
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisByteObject(String strKey, Object object, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.setex(SafeEncoder.encode(strKey), timeoutSeconds, SerializeTool.serialize(object));
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisByte(Map<String, String> strMap, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.setex(SafeEncoder.encode(entry.getKey()), timeoutSeconds, entry.getValue().getBytes());
        }
        ReleaseJedisCluster(jedis);
    }

    public static void setexJedisByteObject(Map<String, Object> strMap, int timeoutSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.setex(SafeEncoder.encode(entry.getKey()), timeoutSeconds, SerializeTool.serialize(entry.getValue()));
        }
        ReleaseJedisCluster(jedis);
    }

    //endregion

    //region get

    public static String getJedis(String strKey) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        String strValue = jedis.get(strKey);
        ReleaseJedisCluster(jedis);
        return strValue;
    }

    public static Object getJedisJsonClass(String strKey, Class objclass) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        String strValue = jedis.get(strKey);
        ReleaseJedisCluster(jedis);
        return gson.fromJson(strValue, objclass);
    }

    public static Object getJedisJsonType(String strKey, Type type) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        String strValue = jedis.get(strKey);
        ReleaseJedisCluster(jedis);
        return gson.fromJson(strValue, type);
    }

    public static Map<String, String> getJedis(List<String> strKeylist) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Map<String, String> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, jedis.get(key));
        ReleaseJedisCluster(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisJsonClass(List<String> strKeylist, Class objClass) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, gson.fromJson(jedis.get(key), objClass));
        ReleaseJedisCluster(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisJsonType(List<String> strKeylist, Type type) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, gson.fromJson(jedis.get(key), type));
        ReleaseJedisCluster(jedis);
        return strMap;
    }

    public static String getJedisByte(String strKey) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        String strValue = new String(jedis.get(SafeEncoder.encode(strKey)));
        ReleaseJedisCluster(jedis);
        return strValue;
    }

    public static Object getJedisByteObject(String strKey) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Object object = SerializeTool.unserialize(jedis.get(SafeEncoder.encode(strKey)));
        ReleaseJedisCluster(jedis);
        return object;
    }

    public static Map<String, String> getJedisByte(List<String> strKeylist) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Map<String, String> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, new String(jedis.get(SafeEncoder.encode(key))));
        ReleaseJedisCluster(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisByteObject(List<String> strKeylist) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, SerializeTool.unserialize(jedis.get(SafeEncoder.encode(key))));
        ReleaseJedisCluster(jedis);
        return strMap;
    }

    //endregion

    //region delete

    public static void delete(String strKey) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.del(strKey);
        ReleaseJedisCluster(jedis);
    }

    public static void deleteString(String... strKeyString) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.del(strKeyString);
        ReleaseJedisCluster(jedis);
    }

    public static void deleteList(List<String> strKeylist) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (String str : strKeylist)
            jedis.del(str);
        ReleaseJedisCluster(jedis);
    }

    public static void deleteByte(String strKey) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.del(SafeEncoder.encode(strKey));
        ReleaseJedisCluster(jedis);
    }

    public static void deleteByteString(byte[]... strKeyString) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.del(strKeyString);
        ReleaseJedisCluster(jedis);
    }

    public static void deleteByteList(List<String> strKeylist) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        for (String str : strKeylist)
            jedis.del(SafeEncoder.encode(str));
        ReleaseJedisCluster(jedis);
    }

    //endregion

    //region set expired (timeout:second)

    public static void setExpired(String strKey, int expiredSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.expire(strKey, expiredSeconds);
        ReleaseJedisCluster(jedis);
    }

    public static void setExpiredByte(String strKey, int expiredSeconds) {
        JedisCluster jedis = RedisToolCluster.getJedis();
        jedis.expire(SafeEncoder.encode(strKey), expiredSeconds);
        ReleaseJedisCluster(jedis);
    }

    //endregion
}
