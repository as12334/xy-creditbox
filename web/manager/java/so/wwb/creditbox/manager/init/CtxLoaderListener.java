package so.wwb.creditbox.manager.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.support.CommonConf;
import org.soul.watcher.zookeeper.NotifyTool;
import so.wwb.creditbox.web.init.CommonCtxLoaderListener;

import javax.servlet.ServletContextEvent;

public class CtxLoaderListener extends CommonCtxLoaderListener {
    private static final Log LOG = LogFactory.getLog(CtxLoaderListener.class);
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if (!NotifyTool.isInited()) {
            LOG.debug("ACenter-Context上下文启动失败...");
            super.stopService();
        }else {
            CommonConf.isStoped = false;
            LOG.debug("ACenter-Context上下文启动完成...");
        }
    }
}
