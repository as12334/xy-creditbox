package so.wwb.lotterybox.web.filter;

import org.soul.commons.dubbo.ConsumerFilter;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.init.context.Operator;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.IpTool;
import org.soul.commons.net.ServletTool;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.log.audit.AuditLogTool;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AccessFilter implements Filter {
    private static final Log LOG = LogFactory.getLog(DomainFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ContextParam contextParam = CommonContext.get();
        if (SessionManagerCommon.getAttribute(SessionKey.S_LOCALE_SESSION_ATTRIBUTE_NAME) != null) {
            contextParam.setLocale((Locale) SessionManagerCommon.getAttribute(SessionKey.S_LOCALE_SESSION_ATTRIBUTE_NAME));
        }
        SysUser sysUser = SessionManagerCommon.getUser();
        if (sysUser != null) {
            contextParam.setSessionId(SessionManagerCommon.getId());
            contextParam.setUserId(sysUser.getId());
            contextParam.setUserType(sysUser.getUserType());
            contextParam.setOperator(AuditLogTool.getOperator(request, sysUser));
            Object isIgnoreAudit = SessionManagerCommon.getAttribute(SessionKey.S_IS_IGNORE_AUDIT);
            if (isIgnoreAudit != null) {
                contextParam.setIsIgnoreAudit((Boolean) isIgnoreAudit);
            }
            contextParam.setSiteIds((List<Integer>) SessionManagerCommon.getAttribute(SessionKey.S_USER_OWN_SITES));
            if (contextParam.getOperator() == null) {
                contextParam.setOperator(new Operator());
                contextParam.getOperator().setOperateIp(IpTool.ipv4StringToLong(ServletTool.getIpAddr(request)));
            }
            if (SessionManagerCommon.getSwitchSiteId() != null) {
                contextParam.setSwitchSiteId(SessionManagerCommon.getSwitchSiteId());
            }
            Integer switchSiteId = SessionManagerCommon.getSwitchSiteId();
            if (switchSiteId != null) {
                contextParam.setSwitchSiteId(switchSiteId);
                if (ConsumerFilter.hasAuthUser4Switch(sysUser.getUserType())) {
                    LOG.debug("[允许]切换站点ID:站点用户:{0},由站点ID:{1}切换为:{2}", sysUser.getId(), contextParam.getSiteId(), switchSiteId);
                    SessionManagerCommon.setAttribute(SessionKey.S_SITE_ID, switchSiteId);
                } else {
                    LOG.error("[禁止]切换站点ID:站点用户:{0},试图由站点ID:{1}切换为:{2},用户类别为:{3}", sysUser.getId(), contextParam.getSiteId(), switchSiteId, sysUser.getUserType());
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
