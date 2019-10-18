package so.wwb.creditbox.web.tools.token;

import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class TokenValidInterceptor implements HandlerInterceptor {
    private static final Log LOG = LogFactory.getLog(TokenValidInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            if (o instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) o;
            Token annotation = handlerMethod.getMethodAnnotation(Token.class);
            if (annotation != null) {
                if (annotation.valid()) {
                    String clientToken = httpServletRequest.getParameter(TokenHandler.DEFAULT_TOKEN_NAME);
                    //如果客户端token为空中断流程
                    if (!TokenHandler.validClientToken(clientToken)) {
                        LOG.warn("客户端token为空中断流程");
                        return false;
                    }

                    ErrorCodeEnum errorCodeEnum = null;
                    if (TokenHandler.isRepeat(clientToken)) {
                        errorCodeEnum = ErrorCodeEnum.SC_REPEAT_REQUEST;
                    }
                    if (errorCodeEnum != null) {
                        if (ServletTool.isAjaxRequest(httpServletRequest)) {
                            Integer code = Integer.parseInt(errorCodeEnum.getCode());
                            httpServletResponse.setStatus(code);
                            httpServletResponse.setHeader(CUSTOM_HEADER_STATUS,code.toString());//
                        } else {
                            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + errorCodeEnum.getUrl() + ".html");
                        }
                        LOG.warn("重复提交过滤器,错误代码:[{0}],错误说明:[{1}],请求地址:[{2}]", errorCodeEnum.getCode(), errorCodeEnum.getTrans(),httpServletRequest.getRequestURI());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
