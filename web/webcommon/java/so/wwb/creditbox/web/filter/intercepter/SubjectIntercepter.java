package so.wwb.creditbox.web.filter.intercepter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.soul.commons.dubbo.ConsumerFilter;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.iservice.common.IDomainCacheResolver;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.log.audit.AuditLogTool;
import org.soul.web.shiro.common.servlet.intercepter.ISubjectInterceptor;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by longer on 1/24/16.
 */
public class SubjectIntercepter implements ISubjectInterceptor {

    private static final Log LOG = LogFactory.getLog(SubjectIntercepter.class);

    /**
     * 域名缓存
     */
    private IDomainCacheResolver domainCacheResolver;

    public void afterCreate(HttpServletRequest request,HttpServletResponse response,Subject subject) {
        ThreadContext.bind(subject);
        BaseObjectVo objectVo = domainCacheResolver.fromCache(request);
        ContextParam contextParam = CommonContext.get();
        //有session时，才能设置到上下文中
        SysUser sysUser = SessionManagerCommon.getUser();
        if(sysUser!=null) {
            contextParam.setSessionId(request.getSession().getId());
            contextParam.setSessionId(SessionManagerCommon.getId());
            Integer switchSiteId = SessionManagerCommon.getSwitchSiteId();
            contextParam.setUserId(sysUser.getId());
            contextParam.setUserOwnerId(sysUser.getOwnerId());
            contextParam.setUserType(sysUser.getUserType());
            contextParam.setOperator(AuditLogTool.getOperator(request,sysUser));

            String userType = sysUser.getUserType();
            Integer siteId = contextParam.getSiteId();
            if(switchSiteId!=null){
                contextParam.setSwitchSiteId(switchSiteId);
                if (ConsumerFilter.hasAuthUser4Switch(userType)) {
                    LOG.debug("[允许]切换站点ID:站点用户:{0},由站点ID:{1}切换为:{2}", sysUser.getId(), siteId, switchSiteId);
                    SessionManagerCommon.setAttribute(SessionKey.S_SITE_ID, switchSiteId);
                } else {
                    LOG.error("[禁止]切换站点ID:站点用户:{0},试图由站点ID:{1}切换为:{2},用户类别为:{3}", sysUser.getId(), siteId, switchSiteId, userType);
                }
            }
            SessionManagerCommon.setAttribute(SessionKey.S_SITE_USER_ID, contextParam.getSiteUserId());
            SessionManagerCommon.setAttribute(SessionKey.S_SITE_PARENT_ID, contextParam.getSiteParentId());
            //站长用户可以切换站点
            contextParam.setSiteIds((List<Integer>) SessionManagerCommon.getAttribute(SessionKey.S_USER_OWN_SITES));
        }else{
            if(subject.getSession(false)==null){
                subject.getSession(true);
            }
        }
    }

    public void setDomainCacheResolver(IDomainCacheResolver domainCacheResolver) {
        this.domainCacheResolver = domainCacheResolver;
    }
}
