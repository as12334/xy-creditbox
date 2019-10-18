package so.wwb.creditbox.web.filter;

import org.soul.commons.dubbo.ConsumerFilter;
import org.soul.commons.init.context.AbstractBaseVo;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author alvin
 * @date 2017.5.24
 */
public class LotteryConsumerFilter extends ConsumerFilter {
    private Log LOG = LogFactory.getLog(LotteryConsumerFilter.class);

    @Override
    protected void setHiddenValue(AbstractBaseVo arg) {
        super.setHiddenValue(arg);
        LotteryContextParam ctx = LotteryCommonContext.get();
        Method[] methods = ctx.getClass().getMethods();
        Map<String,Object> params=new HashMap<>();
        for (Method method : methods) {
            Object obj = null;
            try {
                if (method.getName().startsWith("get") || method.getName().startsWith("_get")) {
                    if (method.getParameterCount() > 0) continue;
                    obj = method.invoke(ctx);
                    if (obj != null && !(obj instanceof Map)) {
                        params.put(method.getName().replace("get", ""), obj);
                    }
                }
            } catch (Exception e) {
                LOG.error(e,"过滤器设置上下文" + obj);
            }
        }
        arg._setParams(params);
    }
}
