package so.wwb.creditbox.web.interceptor;

import com.google.gson.Gson;
import org.soul.commons.lang.DateTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import so.wwb.creditbox.model.common.annotations.SameUrlData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

/**
 * @author:wilson
 * @function:same_url_data_check_interceptor
 */
public class SameUrlDataInterceptor extends HandlerInterceptorAdapter {
    private static final Gson gson = new Gson();
    private static final String strRepeatData = "SAME_URL_REPEAT_DATA";
    private static final String strLastAccessTime = "SAME_URL_LAST_ACCESS_TIME";
    private static final Log log = LogFactory.getLog(SameUrlDataInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            SameUrlData annotation = method.getAnnotation(SameUrlData.class);
            if (annotation != null) {
                if (repeatDataValidator(request)) {
                    ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.SC_REPEAT_REQUEST;
                    if (ServletTool.isAjaxRequest(request)) {
                        Integer code = Integer.parseInt(errorCodeEnum.getCode());
                        response.setStatus(code);
                        response.setHeader(CUSTOM_HEADER_STATUS, errorCodeEnum.getCode());
                    } else {
                        response.sendRedirect(request.getContextPath() + errorCodeEnum.getUrl() + ".html");
                    }
                    return false;
                } else
                    return true;
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean repeatDataValidator(HttpServletRequest httpServletRequest) {
        String params = gson.toJson(httpServletRequest.getParameterMap());
        String url = httpServletRequest.getRequestURI();
        Map<String, String> map = new HashMap<String, String>();
        map.put(url, params);
        String nowUrlParams = map.toString();
        Object preUrlParams = httpServletRequest.getSession().getAttribute(strRepeatData);
        if (null == preUrlParams) {
            httpServletRequest.getSession().setAttribute(strRepeatData, nowUrlParams);
            httpServletRequest.getSession().setAttribute(strLastAccessTime, new Date());
            return false;
        } else {
            if (preUrlParams.toString().equals(nowUrlParams)) {
                Object lastAccessTime = httpServletRequest.getSession().getAttribute(strLastAccessTime);
                if (null != lastAccessTime) {
                    Date dtLastAccessTime = (Date) lastAccessTime;
                    long timeLong = DateTool.secondsBetween(new Date(), dtLastAccessTime);
                    if (timeLong <= 2) {
                        log.info(" request url: {0}, time gap: {1} seconds", nowUrlParams, timeLong);
                        return true;
                    } else {
                        setAttribute(httpServletRequest, nowUrlParams);
                        return false;
                    }
                } else {
                    setAttribute(httpServletRequest, nowUrlParams);
                    return false;
                }
            } else {
                setAttribute(httpServletRequest, nowUrlParams);
                return false;
            }
        }
    }

    private void setAttribute(HttpServletRequest request, String nowUrlParams) {
        request.getSession().setAttribute(strRepeatData, nowUrlParams);
        request.getSession().setAttribute(strLastAccessTime, new Date());
    }
}
