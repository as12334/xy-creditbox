package so.wwb.lotterybox.web.shiro.local.filter;

import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.session.SessionKey;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ForbidFilter implements Filter {

    private static final Log LOG = LogFactory.getLog(ForbidFilter.class);

    private String redirectUrl = "/";

    private String [] filterUri = new String[] {"/register.html"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        if (Arrays.asList(filterUri).contains(uri)){
            Integer userId = (Integer) SessionManagerCommon.getAttribute(SessionKey.S_USER_ID);
            if (userId != null){
                LOG.debug("当前已登录，不能跳转注册页面");
                WebUtils.issueRedirect(request, response, redirectUrl);
            }else{
                filterChain.doFilter(request, response);
            }
        }else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
