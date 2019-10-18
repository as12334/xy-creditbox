package so.wwb.creditbox.web.defense.core.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import so.wwb.creditbox.web.defense.biz.interceptor.IDefense;
import so.wwb.creditbox.web.defense.biz.interceptor.IDefenseAnnotationResolver;
import so.wwb.creditbox.web.defense.core.handle.IDefenseHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by longer on 1/13/16.
 * 功能防御,拦截器
 */
public class DefenseInterceptor extends HandlerInterceptorAdapter {

    /**
     * 防御注解获取器
     */
    private IDefenseAnnotationResolver defenseAnnotationResolver;

    private IDefenseHandler defenseHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IDefense defense =  defenseAnnotationResolver.getDefense(handler);
        if (defense == null) {
            return true;
        }

        defenseHandler.beforeHandle(request, defense);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        IDefense defense =  defenseAnnotationResolver.getDefense(handler);
        if (defense == null) {
            return;
        }

        defenseHandler.afterHandle(request, defense);
    }

    public void setDefenseHandler(IDefenseHandler defenseHandler) {
        this.defenseHandler = defenseHandler;
    }

    public void setDefenseAnnotationResolver(IDefenseAnnotationResolver defenseAnnotationResolver) {
        this.defenseAnnotationResolver = defenseAnnotationResolver;
    }
}
