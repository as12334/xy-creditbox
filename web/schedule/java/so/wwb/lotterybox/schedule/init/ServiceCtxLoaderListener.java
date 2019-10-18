package so.wwb.lotterybox.schedule.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.support.CommonConf;
import org.soul.service.init.context.BaseServiceCtxLoaderListener;
import org.soul.watcher.zookeeper.NotifyTool;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimeZone;

public class ServiceCtxLoaderListener extends BaseServiceCtxLoaderListener {
    private static final Log LOG = LogFactory.getLog(ServiceCtxLoaderListener.class);
    public static boolean managerScheduleStart = false;
    public static boolean merchantScheduleStart = false;

    @Override
    protected void customizeContext(final ServletContext sc, ConfigurableWebApplicationContext wac) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        super.customizeContext(sc, wac);
    }
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (!NotifyTool.isInited()) {
            LOG.debug("Schedule-Context上下文启动失败...");
            super.stopService();
        }else {
            CommonConf.isStoped = false;
            LOG.debug("Schedule-Context上下文启动完成...");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.stopService();
        super.contextDestroyed(event);
        LOG.debug("Schedule-Context上下文销毁结束...");
    }
}
