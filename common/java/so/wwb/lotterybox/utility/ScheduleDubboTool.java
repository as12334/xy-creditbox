package so.wwb.lotterybox.utility;

import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import org.soul.commons.bean.BeanTool;
import org.soul.commons.dubbo.DubboConfig;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:wilson
 * @function: schedule dubbo service
 */
public class ScheduleDubboTool {
    private static final Log LOG = LogFactory.getLog(ScheduleDubboTool.class);
    private static final ConcurrentHashMap<String, ReferenceConfig> referenceConfigs = new ConcurrentHashMap<>();
    private static ConsumerConfig scheduleDubboConsumer = (ConsumerConfig) SpringTool.getBean("scheduleDubboConsumer");
    private static DubboConfig scheduleDubboConfig = (DubboConfig) SpringTool.getBean("scheduleDubboConfig");
    private static ConsumerConfig gameScheduleDubboConsumer = (ConsumerConfig) SpringTool.getBean("gameScheduleDubboConsumer");
    private static DubboConfig gameScheduleDubboConfig = (DubboConfig) SpringTool.getBean("gameScheduleDubboConfig");

    public ScheduleDubboTool() {
    }

    public static <T> T getGameScheduleService(Class<T> interfaceClazz) {
        return getService(interfaceClazz, gameScheduleDubboConsumer,gameScheduleDubboConfig);
    }

    public static <T> T getScheduleService(Class<T> interfaceClazz) {
        return getService(interfaceClazz, scheduleDubboConsumer,scheduleDubboConfig);
    }

    public static <T> T getService(Class<T> interfaceClazz, ConsumerConfig consumerConfig, DubboConfig dubboConfig) {
        if(consumerConfig == null || dubboConfig == null){
            return null;
        }
        String version = consumerConfig.getVersion();
        String key = buildKey(interfaceClazz, version);
        ReferenceConfig referenceObj = referenceConfigs.get(key);
        if (referenceObj != null) {
            return (T) referenceObj.get();
        } else {
            try {
                ReferenceConfig e = new ReferenceConfig();
                e.setProtocol(dubboConfig.getProtocol());
                e.setInterface(interfaceClazz);
                BeanTool.copyProperties(consumerConfig, e);
                if (StringTool.isNotBlank(version)) {
                    e.setVersion(version);
                } else {
                    version = e.getVersion();
                }

                if (e.get() != null) {
                    referenceConfigs.putIfAbsent(buildKey(interfaceClazz, version), e);
                }

                return (T) e.get();
            } catch (RuntimeException var6) {
                LOG.error(var6, "获取Dubbo服务异常!", new Object[0]);
                return null;
            }
        }
    }

    private static String buildKey(Class clsName, String version) {
        return clsName.toString() + "," + version;
    }

    public static void destorySchedule() {
        destory(scheduleDubboConsumer.getVersion());
    }

    public static void destoryGameSchedule() {
        destory(gameScheduleDubboConsumer.getVersion());
    }

    private static void destory(String version){
        for (int i = 10; i > 0; --i) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
            LOG.info("等待消费者结束倒计时" + i + "秒！", new Object[0]);
        }
        for (String key : referenceConfigs.keySet()) {
            if(StringTool.isNotEmpty(key) && referenceConfigs.get(key) != null && key.lastIndexOf("," + version) >= 0){
                ReferenceConfigCache.getCache().destroy(referenceConfigs.get(key));
                referenceConfigs.remove(key);
            }
        }
        LOG.info("反注册Dubbo消费者结束成功！", new Object[0]);
    }


}
