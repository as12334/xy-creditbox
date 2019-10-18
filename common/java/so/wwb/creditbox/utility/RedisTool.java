package so.wwb.creditbox.utility;

import com.google.gson.Gson;
import org.soul.commons.spring.utils.SpringTool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.SafeEncoder;
import so.wwb.creditbox.common.utility.common.SerializeTool;
import so.wwb.creditbox.model.redis.RedisConfig;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wilson
 * @function: redis utility no cluster
 * @deprecated:
 */
public class RedisTool {

    //region instance

    private static JedisPool jedisPool = null;
    private static boolean usePool;
    private static Jedis jedis = null;
    private static String redisHost = null;
    private static Integer port = null;
    private static Integer dbIndex = 0;
    private static Gson gson = new Gson();

    static {
        RedisConfig redisconfig = (RedisConfig) SpringTool.getBean("redisConfig0");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(redisconfig.getMaxTotal());
        config.setMaxIdle(redisconfig.getMaxIdle());
        config.setMaxWaitMillis(redisconfig.getMaxWaitMillis());
        config.setTestOnBorrow(redisconfig.getTestOnBorrow());
        RedisTool.usePool = redisconfig.getUsePool();
        RedisTool.redisHost = redisconfig.getRedisHost();
        RedisTool.port = redisconfig.getPort();
        RedisTool.dbIndex = redisconfig.getDbIndex();
        jedisPool = new JedisPool(RedisTool.redisHost, RedisTool.port);
    }

    private synchronized static Jedis getJedis() {
        if (RedisTool.usePool) {
            if (null == jedisPool) return null;
            Jedis jedis = jedisPool.getResource();
            jedis.select(RedisTool.dbIndex);
            return jedis;
        } else {
            if (null == jedis) {
                RedisTool.jedis = new Jedis(RedisTool.redisHost, RedisTool.port);
                RedisTool.jedis.select(RedisTool.dbIndex);
            }
            return RedisTool.jedis;
        }
    }

    private static void returnresource(Jedis jedis) {
        if (RedisTool.usePool) {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    //endregion

    //region set

    public static void setJedis(String strKey, String strValue) {
        Jedis jedis = RedisTool.getJedis();
        jedis.set(strKey, strValue);
        RedisTool.returnresource(jedis);
    }

    public static void setJedisJson(String strKey, Object object) {
        Jedis jedis = RedisTool.getJedis();
        jedis.set(strKey, gson.toJson(object));
        RedisTool.returnresource(jedis);
    }

    public static void setJedis(Map<String, String> strMap) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.set(entry.getKey(), entry.getValue());
        }
        RedisTool.returnresource(jedis);
    }

    public static void setJedisJson(Map<String, Object> strMap) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.set(entry.getKey(), gson.toJson(entry.getValue()));
        }
        RedisTool.returnresource(jedis);
    }

    public static void setJedisByte(String strKey, String strValue) {
        Jedis jedis = RedisTool.getJedis();
        jedis.set(SafeEncoder.encode(strKey), strValue.getBytes());
        RedisTool.returnresource(jedis);
    }

    public static void setJedisByte(Map<String, String> strMap) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.set(SafeEncoder.encode(entry.getKey()), entry.getValue().getBytes());
        }
        RedisTool.returnresource(jedis);
    }

    public static void setJedisByteObject(String strKey, Object object) {
        Jedis jedis = RedisTool.getJedis();
        jedis.set(SafeEncoder.encode(strKey), SerializeTool.serialize(object));
        RedisTool.returnresource(jedis);
    }

    public static void setJedisByteObject(Map<String, Object> strMap) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.set(SafeEncoder.encode(entry.getKey()), SerializeTool.serialize(entry.getValue()));
        }
        RedisTool.returnresource(jedis);
    }

    //endregion

    //region setex (timeout: second)

    public static void setexJedis(String strKey, String strValue, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.setex(strKey, timeoutSeconds, strValue);
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisJson(String strKey, Object object, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.setex(strKey, timeoutSeconds, gson.toJson(object));
        RedisTool.returnresource(jedis);
    }

    public static void setexJedis(Map<String, String> strMap, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.setex(entry.getKey(), timeoutSeconds, entry.getValue());
        }
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisJson(Map<String, Object> strMap, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.setex(entry.getKey(), timeoutSeconds, gson.toJson(entry.getValue()));
        }
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisByte(String strKey, String strValue, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.setex(SafeEncoder.encode(strKey), timeoutSeconds, strValue.getBytes());
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisByteObject(String strKey, Object object, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.setex(SafeEncoder.encode(strKey), timeoutSeconds, SerializeTool.serialize(object));
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisByte(Map<String, String> strMap, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, String> entry : strMap.entrySet()) {
            jedis.setex(SafeEncoder.encode(entry.getKey()), timeoutSeconds, entry.getValue().getBytes());
        }
        RedisTool.returnresource(jedis);
    }

    public static void setexJedisByteObject(Map<String, Object> strMap, int timeoutSeconds) {
        Jedis jedis = RedisTool.getJedis();
        for (Map.Entry<String, Object> entry : strMap.entrySet()) {
            jedis.setex(SafeEncoder.encode(entry.getKey()), timeoutSeconds, SerializeTool.serialize(entry.getValue()));
        }
        RedisTool.returnresource(jedis);
    }

    //endregion

    //region get

    public static String getJedis(String strKey) {
        Jedis jedis = RedisTool.getJedis();
        String strValue = jedis.get(strKey);
        RedisTool.returnresource(jedis);
        return strValue;
    }

    public static Object getJedisJsonClass(String strKey, Class objclass) {
        Jedis jedis = RedisTool.getJedis();
        String strValue = jedis.get(strKey);
        RedisTool.returnresource(jedis);
        return gson.fromJson(strValue, objclass);
    }

    public static Object getJedisJsonType(String strKey, Type type) {
        Jedis jedis = RedisTool.getJedis();
        String strValue = jedis.get(strKey);
        RedisTool.returnresource(jedis);
        return gson.fromJson(strValue, type);
    }

    public static Map<String, String> getJedis(List<String> strKeylist) {
        Jedis jedis = RedisTool.getJedis();
        Map<String, String> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, jedis.get(key));
        RedisTool.returnresource(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisJsonClass(List<String> strKeylist, Class objClass) {
        Jedis jedis = RedisTool.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, gson.fromJson(jedis.get(key), objClass));
        RedisTool.returnresource(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisJsonType(List<String> strKeylist, Type type) {
        Jedis jedis = RedisTool.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, gson.fromJson(jedis.get(key), type));
        RedisTool.returnresource(jedis);
        return strMap;
    }

    public static String getJedisByte(String strKey) {
        Jedis jedis = RedisTool.getJedis();
        String strValue = new String(jedis.get(SafeEncoder.encode(strKey)));
        RedisTool.returnresource(jedis);
        return strValue;
    }

    public static Object getJedisByteObject(String strKey) {
        Jedis jedis = RedisTool.getJedis();
        Object object = SerializeTool.unserialize(jedis.get(SafeEncoder.encode(strKey)));
        RedisTool.returnresource(jedis);
        return object;
    }

    public static Map<String, String> getJedisByte(List<String> strKeylist) {
        Jedis jedis = RedisTool.getJedis();
        Map<String, String> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, new String(jedis.get(SafeEncoder.encode(key))));
        RedisTool.returnresource(jedis);
        return strMap;
    }

    public static Map<String, Object> getJedisByteObject(List<String> strKeylist) {
        Jedis jedis = RedisTool.getJedis();
        Map<String, Object> strMap = new HashMap<>();
        for (String key : strKeylist)
            strMap.put(key, SerializeTool.unserialize(jedis.get(SafeEncoder.encode(key))));
        RedisTool.returnresource(jedis);
        return strMap;
    }

    //endregion

    //region delete

    public static void delete(String strKey) {
        Jedis jedis = RedisTool.getJedis();
        jedis.del(strKey);
        RedisTool.returnresource(jedis);
    }

    public static void deleteString(String... strKeyString) {
        Jedis jedis = RedisTool.getJedis();
        jedis.del(strKeyString);
        RedisTool.returnresource(jedis);
    }

    public static void deleteList(List<String> strKeylist) {
        Jedis jedis = RedisTool.getJedis();
        for (String str : strKeylist)
            jedis.del(str);
        RedisTool.returnresource(jedis);
    }

    public static void deleteByte(String strKey) {
        Jedis jedis = RedisTool.getJedis();
        jedis.del(SafeEncoder.encode(strKey));
        RedisTool.returnresource(jedis);
    }

    public static void deleteByteString(byte[]... strKeyString) {
        Jedis jedis = RedisTool.getJedis();
        jedis.del(strKeyString);
        RedisTool.returnresource(jedis);
    }

    public static void deleteByteList(List<String> strKeylist) {
        Jedis jedis = RedisTool.getJedis();
        for (String str : strKeylist)
            jedis.del(SafeEncoder.encode(str));
        RedisTool.returnresource(jedis);
    }

    //endregion

    //region set expired (timeout:second)

    public static void setExpired(String strKey, int expiredSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.expire(strKey, expiredSeconds);
        RedisTool.returnresource(jedis);
    }

    public static void setExpiredByte(String strKey, int expiredSeconds) {
        Jedis jedis = RedisTool.getJedis();
        jedis.expire(SafeEncoder.encode(strKey), expiredSeconds);
        RedisTool.returnresource(jedis);
    }

    //endregion
}
