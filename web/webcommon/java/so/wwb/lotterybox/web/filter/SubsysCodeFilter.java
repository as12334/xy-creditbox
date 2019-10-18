package so.wwb.lotterybox.web.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.web.session.SessionManagerBase;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class SubsysCodeFilter extends AccessControlFilter {

    private String subsysCode;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return true;
        }

        SysUser sysUser = SessionManagerBase.getUser();
        String code = sysUser.getSubsysCode();
        if (!code.equals(subsysCode)) {
            if (ServletTool.isAjaxRequest(request)) {
                Integer headerStatus = Integer.valueOf(ErrorCodeEnum.SC_FORBIDDEN.getCode());
                response.setHeader(CUSTOM_HEADER_STATUS,headerStatus.toString());//
                response.setStatus(headerStatus);
                return false;
            } else {
                String url = ErrorCodeEnum.SC_FORBIDDEN.getUrl() + ".html";
                WebUtils.redirectToSavedRequest(request, response, url);
                return false;
            }
        }
        return true;
    }

    public void setSubsysCode(String subsysCode) {
        this.subsysCode = subsysCode;
    }
}
