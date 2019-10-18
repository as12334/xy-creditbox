package so.wwb.creditbox.web.init;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.web.init.BaseCtxLoaderListener;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.TimeZone;

public class CommonCtxLoaderListener extends BaseCtxLoaderListener {
    private static final Log LOG = LogFactory.getLog(CommonCtxLoaderListener.class);
    @Override
    protected void customizeContext(ServletContext sc, ConfigurableWebApplicationContext wac) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        super.customizeContext(sc, wac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.stopService();
        super.contextDestroyed(event);
        LOG.debug("Context上下文销毁结束...");
    }

}
