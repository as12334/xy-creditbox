package so.wwb.creditbox.mdcenter.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.mq.ConsumerMQTool;
import org.soul.commons.spring.utils.CommonBeanFactory;
import org.soul.commons.support.CommonConf;
import org.soul.watcher.zookeeper.NotifyTool;
import org.soul.watcher.zookeeper.handler.NodeVersionInfo;
import org.soul.web.init.BaseCtxLoaderListener;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimeZone;

/**
 * Created by Kevice on 2015/3/23 0023.
 */
public class CtxLoaderListener extends BaseCtxLoaderListener {

    private static final Log LOG = LogFactory.getLog(CtxLoaderListener.class);

    @Override
    protected void customizeContext(final ServletContext sc, ConfigurableWebApplicationContext wac) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // 设置JVM默认时区为０时区
        super.customizeContext(sc, wac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.stopService();
        super.contextDestroyed(event);
    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (!NotifyTool.isInited()) {
            LOG.debug("MDCenter-Context上下文启动失败...");
            super.stopService();
        }else {
            CommonConf.isStoped = false;
            LOG.debug("MDCenter-Context上下文启动完成...");
        }
    }
    /**
     * Notify
     * 处理站点版本更新通知逻辑
     */
    public static void refreshServiceVersion(NodeVersionInfo info){
        try {
            CommonBeanFactory.getCommonConf().setCustomVersion(info.getApplicationName(),info.getVersion());
            ConsumerMQTool.initConsumer();
            LOG.info("初始化MQ消费者成功!");
        } catch (Exception e) {
            LOG.error(e,"初始化线程错误:{0}!",e.getMessage());
        }
    }
    /**
     * Notify
     * 处理站点版本更新通知逻辑
     */
    public static void refreshSiteVersion(){
        try {
            ConsumerMQTool.initConsumer();
            LOG.info("初始化MQ消费者成功!");
        } catch (Exception e) {
            LOG.error(e,"初始化线程错误:{0}!",e.getMessage());
        }
    }
}
