package so.wwb.creditbox.schedule.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.mq.ProducerMQTool;
import org.soul.commons.spring.utils.CommonBeanFactory;
import org.soul.commons.support.CommonConf;
import org.soul.service.init.context.BaseServiceCtxLoaderListener;
import org.soul.watcher.zookeeper.NotifyTool;
import org.soul.watcher.zookeeper.handler.NodeVersionInfo;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimeZone;

public class ServiceCtxLoaderListener extends BaseServiceCtxLoaderListener {
    private static final Log LOG = LogFactory.getLog(ServiceCtxLoaderListener.class);
    public static boolean gameScheduleStart = false;

    @Override
    protected void customizeContext(final ServletContext sc, ConfigurableWebApplicationContext wac) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        super.customizeContext(sc, wac);
    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (!NotifyTool.isInited()) {
            LOG.debug("Game-Schedule-Context上下文启动失败...");
            super.stopService();
        }else {
            CommonConf.isStoped = false;
            LOG.debug("Game-Schedule-Context上下文启动完成...");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.stopService();
        super.contextDestroyed(event);
        LOG.debug("Game-Schedule-Context上下文销毁结束...");
    }
    /**
     * Notify
     * 处理站点版本更新通知逻辑
     */
    public static void refreshServiceVersion(NodeVersionInfo info){
        try {
            CommonBeanFactory.getCommonConf().setCustomVersion(info.getApplicationName(),info.getVersion());
            ProducerMQTool.initProducer();
            LOG.info("初始化MQ消费者成功!");
        } catch (Exception e) {
            LOG.error(e,"初始化线程错误:{0}!",e.getMessage());
        }
    }
}
