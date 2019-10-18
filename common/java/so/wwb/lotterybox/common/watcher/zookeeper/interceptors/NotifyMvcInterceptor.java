package so.wwb.lotterybox.common.watcher.zookeeper.interceptors;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.spring.utils.CommonBeanFactory;
import org.soul.watcher.zookeeper.NotifyTool;
import org.soul.watcher.zookeeper.annos.NotifyWebPoint;
import org.soul.watcher.zookeeper.interceptors.AbstractNotifyMvcInterceptor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by Tony on 2017/11/6.
 * 消息通知,拦截器
 */
public class NotifyMvcInterceptor extends AbstractNotifyMvcInterceptor {

    @Override
    protected Annotation isNeedTodo(HandlerMethod handlerMethod) {
        return handlerMethod.getMethodAnnotation(NotifyWebPoint.class);
    }

    @Override
    protected void doIt(Annotation annotation,HandlerMethod handlerMethod,HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        NotifyWebPoint notifyPoint = handlerMethod.getMethodAnnotation(NotifyWebPoint.class);
        if (notifyPoint == null) {
            return;
        }

        String classFullName = handlerMethod.getBeanType().getName();
        String methodName = handlerMethod.getMethod().getName();
        Object param=null;
        if(StringTool.isNotBlank(notifyPoint.parameterName())) {
            if(modelAndView.getModel().containsKey(notifyPoint.parameterName())){
                param=modelAndView.getModel().get(notifyPoint.parameterName());
            }
            if(param==null){
                param=request.getParameter(notifyPoint.parameterName());
            }
        }

        NotifyTool.sendNotify(notifyPoint.NotiyType(),classFullName,methodName,param, CommonBeanFactory.getCommonConf().getDubboVersion());
    }
}
