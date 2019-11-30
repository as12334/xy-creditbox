package so.wwb.creditbox.utility;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * FastJson工具类
 * Create by Fei on 2018-01-09
 */
public class FastJsonTool {

    /**
     * 排除不需要的属性
     * @param obj 需要排除的对象
     * @param properties 需要排除的属性
     * @return 新的对象
     */
    public static Object excludeProperties(Object obj, String... properties) {
        if (obj == null) return null;
        String data = toJsonExcludes(obj, properties);
        return JSON.parseArray(data);
    }

    /**
     * 输出需要的属性
     * @param obj 需要输出的对象
     * @param properties 需要输出的属性
     * @return 新的对象
     */
    public static Object includeProperties(Object obj, String... properties) {
        if (obj == null) return null;
        String data = toJsonIncludes(obj, properties);
        return JSON.parseArray(data);
    }

    /**
     * 针对單个对象排除不需要的属性
     * @param obj 需要输出的对象
     * @param properties 需要输出的属性
     * @return 过滤后的Json
     */
    public static String objectExcludes(Object obj, String... properties) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        Set<String> excludes = filter.getExcludes();

        SerializeConfig config = new SerializeConfig();
        Collections.addAll(excludes, properties);

        return JSON.toJSONString(obj, config, filter, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 针对單个对象输出需要的属性
     * @param obj 需要输出的对象
     * @param properties 需要输出的属性
     * @return 过滤后的Json
     */
    public static String objectIncludes(Object obj, String... properties) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        Set<String> includes = filter.getIncludes();

        SerializeConfig config = new SerializeConfig();
        Collections.addAll(includes, properties);

        return JSON.toJSONString(obj, config, filter, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 对象转JSON，可选需要排除的属性
     * @param obj 需要转换的对象
     * @param properties 需要排除的属性
     * @return json字符串
     */
    private static String toJsonExcludes(Object obj, String... properties) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();

        Set<String> excludes = filter.getExcludes();
        excludes.addAll(Arrays.asList(properties));

        SerializeConfig config = new SerializeConfig();
        config.put(Date.class, new DateFormatSerializer());

        return JSON.toJSONString(obj, config, filter, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 对象转JSON，可选需要输出的属性
     * @param obj 需要转换的对象
     * @param properties 需要输出的属性
     * @return json字符串
     */
    private static String toJsonIncludes(Object obj, String... properties) {
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();

        Set<String> includes = filter.getIncludes();
        includes.addAll(Arrays.asList(properties));

        SerializeConfig config = new SerializeConfig();
        config.put(Date.class, new DateFormatSerializer());

        return JSON.toJSONString(obj, config, filter, SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty);
    }

}
