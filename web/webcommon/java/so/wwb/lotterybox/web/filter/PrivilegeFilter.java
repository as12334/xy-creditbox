package so.wwb.lotterybox.web.filter;

import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.BooleanTool;
import org.soul.commons.lang.DateTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.filter.FilterTool;
import so.wwb.lotterybox.model.base.ParamTool;
import so.wwb.lotterybox.model.enums.base.BossParamEnum;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class PrivilegeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (FilterTool.isErrorRequest(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        Object needCheck = request.getAttribute(SessionKey.R_URL_PRIVILEGE);
        if (needCheck != null && BooleanTool.toBoolean(needCheck.toString())) {
            if (ServletTool.isAjaxRequest(request)) {
                if (isChecked()) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    Integer code = Integer.valueOf(ErrorCodeEnum.SC_PRIVILEGE.getCode());
                    response.setHeader(CUSTOM_HEADER_STATUS,code.toString());
                    response.setStatus(code);
                    return;
                }
            } else {
                if (isChecked()) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    String url = request.getRequestURI();
                    String param = request.getQueryString();
                    if (StringTool.isNotBlank(param)) {
                        url = url + "?" + param;
                    }
                    servletResponse.getWriter().println("<script>window.top.topPage.checkPrivilege({owner:window,type:1,url:'" + url + "'});\r\n</script>");
                    return;
                }
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public boolean isChecked() {
        SysUser user = SessionManagerCommon.getUser();
        if(user!=null){
            Integer times = user.getSecpwdErrorTimes()==null?1:user.getSecpwdErrorTimes();
            if(times==0){
                Date tempDate = DateTool.addDays(new Date(),-1);
                final Date lastTime = user.getSecpwdFreezeStartTime()==null?tempDate:user.getSecpwdFreezeStartTime();
                long l = DateTool.minutesBetween(new Date(), lastTime);

                String paramValue = "5";
                if(CommonContext.get().getSiteId()>0 && ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME)!=null){
                    paramValue = ParamTool.getSysParam(SiteParamEnum.SETTING_PRIVILAGE_PASS_TIME).getParamValue();
                }else if(CommonContext.get().getSiteId()==0 && ParamTool.getSysParam(BossParamEnum.SETTING_PRIVILAGE_PASS_TIME)!=null){
                    paramValue = ParamTool.getSysParam(BossParamEnum.SETTING_PRIVILAGE_PASS_TIME).getParamValue();
                }
                Integer privilegeTime=0;
                if(StringTool.isNotBlank(paramValue)){
                    privilegeTime=Integer.parseInt(paramValue);
                }
                return l <= privilegeTime;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
