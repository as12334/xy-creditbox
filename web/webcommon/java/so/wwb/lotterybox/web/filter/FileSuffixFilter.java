package so.wwb.lotterybox.web.filter;

import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class FileSuffixFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean isRequestJsp = request.getRequestURI().endsWith(".jsp");
        //boolean isRequestFtl = request.getRequestURI().endsWith(".ftl");
        if (isRequestJsp) {
            if (ServletTool.isAjaxRequest(request)) {
                Integer code = Integer.parseInt(ErrorCodeEnum.SC_NOT_FOUND.getCode());
                response.setStatus(code);
                response.setHeader(CUSTOM_HEADER_STATUS,code.toString());
                return;
            } else {
                response.sendRedirect(request.getContextPath() + ErrorCodeEnum.SC_NOT_FOUND.getUrl() + ".html");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
