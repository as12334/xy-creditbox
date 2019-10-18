package so.wwb.lotterybox.web.shiro.local.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.session.SessionKey;
import org.soul.web.shiro.local.PassportResult;
import so.wwb.lotterybox.web.shiro.common.delegate.IPassportDelegate;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalLogoutFilter extends LogoutFilter {

    private static final Log LOG = LogFactory.getLog(LocalLogoutFilter.class);
    private IPassportDelegate passportDelegate;

    @Override
    protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Subject subject = SecurityUtils.getSubject();
        String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            passportDelegate.onLogoutDelegate(request, response);
            SessionManagerCommon.clearSession();
        } catch (SessionException ise) {
            LOG.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }

        if (ServletTool.isAjaxRequest(request)) {
            String json = JsonTool.toJson(PassportResult.SUCCESS);
            response.getWriter().print(json);
            response.getWriter().flush();
        } else {
            issueRedirect(request, response, redirectUrl);
        }
        return false;
    }

    @Override
    protected String getRedirectUrl(ServletRequest servletRequest, ServletResponse servletResponse, Subject subject) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getParameter("url");
        if (StringTool.isNotBlank(url)) {
            return url;
        }
        String entrance = (String) SessionManagerCommon.getAttribute(SessionKey.S_ENTRANCE);
        if (StringTool.isNotBlank(entrance)) {
            return passportDelegate.getLoginUrl(Integer.valueOf(entrance));
        }
        return super.getRedirectUrl();
    }

    public void setPassportDelegate(IPassportDelegate passportDelegate) {
        this.passportDelegate = passportDelegate;
    }
}
