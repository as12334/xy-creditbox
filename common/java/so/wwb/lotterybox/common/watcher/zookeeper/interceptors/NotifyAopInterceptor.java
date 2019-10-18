package so.wwb.lotterybox.common.watcher.zookeeper.interceptors;

import org.aspectj.lang.JoinPoint;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.CommonBeanFactory;
import org.soul.watcher.zookeeper.NotifyTool;
import org.soul.watcher.zookeeper.annos.NotifyAopPoint;
import org.soul.watcher.zookeeper.interceptors.AbstractNotifyAopInterceptor;

import java.lang.reflect.Method;


/**
 * 消息通知Aop拦截器
 * Created by Tony on 2017-11-06:下午2:58.
 */
public class NotifyAopInterceptor extends AbstractNotifyAopInterceptor {

    private static final Log LOG = LogFactory.getLog(NotifyAopInterceptor.class);

    @Override
    public void doInterceptor(JoinPoint joinPoint) {
        String classFullName = joinPoint.getSourceLocation().getWithinType().getName();
        String methodName = joinPoint.getSignature().getName();
        Method method = getMethod(joinPoint);
        NotifyAopPoint notifyPoint = method.getAnnotation(NotifyAopPoint.class);
        Object[] obj = joinPoint.getArgs();
        Object param=null;
        if(obj.length>0){
            param=obj[0];
        }
        NotifyTool.sendNotify(notifyPoint.NotiyType(),classFullName,methodName,param, CommonBeanFactory.getCommonConf().getDubboVersion());
    }
}
