package so.wwb.lotterybox.mweb.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.support.CommonConf;
import org.soul.service.init.context.BaseServiceCtxLoaderListener;
import org.soul.watcher.zookeeper.NotifyTool;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimeZone;

/**
 * Created by Mark on 2015/6/9 1425.
 */
public class ServiceCtxLoaderListener extends BaseServiceCtxLoaderListener {

    private static final Log LOG = LogFactory.getLog(ServiceCtxLoaderListener.class);

    @Override
    protected void customizeContext(final ServletContext sc, ConfigurableWebApplicationContext wac) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // 设置JVM默认时区为０时区
        super.customizeContext(sc, wac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.stopService();
        super.contextDestroyed(event);
        LOG.debug("Cache-Service-Context上下文销毁结束...");
    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (!NotifyTool.isInited()) {
            LOG.debug("Cache-Service-Context上下文启动失败...");
            super.stopService();
        }else {
            CommonConf.isStoped = false;
            LOG.debug("Cache-Service-Context上下文启动完成...");
        }
    }
}
