package so.wwb.lotterybox.web.shiro.local.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.session.SessionManagerBase;
import org.soul.web.shiro.common.autho.AuthorizationRefresher;
import so.wwb.lotterybox.model.constants.cache.CacheKey;
import so.wwb.lotterybox.web.shiro.local.authc.LocalToken;
import so.wwb.lotterybox.web.tools.SessionManagerCommon;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public class LocalRealm extends AuthorizingRealm {

    private static final Log LOG = LogFactory.getLog(LocalRealm.class);

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        AuthorizationInfo authorizationInfo = super.getAuthorizationInfo(principals);
        //如果缓存为空时，重新设置授权缓存
        if(authorizationInfo==null) {
            SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
            if (sysUser!=null) {
                HttpServletRequest request = SpringTool.getRequest();
                Object key = this.getAuthorizationCacheKey(principals);
                LOG.error("缓存获取用户授权信息为空:{0}, Key:{1}, 禁止访问,请求地址:{2}",sysUser.getUsername(),key,request.getRequestURL().toString());
            }
        }
        return authorizationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) SessionManagerCommon.getAttribute(SessionKey.S_USER);
        if (sysUser==null) {
            return null;
        }
        //功能权限
        Set<String> permissions = SessionManagerBase.findPermissions(sysUser);
        SimpleAuthorizationInfo simpleAuthorizationInfo =  new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions == null ? new HashSet<String>(0) : permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LocalToken localToken = (LocalToken) token;
        if(localToken.getAuthenticationException()!=null){
            throw localToken.getAuthenticationException();
        }else {
            String password = new String(localToken.getPassword());
            return new SimpleAuthenticationInfo(localToken.getPrincipal(), password, getName());
        }
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        //warning: final key would be: auth:z:1:21:water:11848
        return AuthorizationRefresher.AUTHORIZATION + CacheKey.CACHE_KEY_SEPERATOR + principals.getPrimaryPrincipal().toString();
    }

    @Override
    protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
        //warning: final key would be: auth:1:21:water:11848
        return principals.getPrimaryPrincipal().toString();
    }
}
