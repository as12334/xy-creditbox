package so.wwb.creditbox.mdcenter.filter;

import org.apache.shiro.session.Session;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.init.context.ContextParam;
import org.soul.commons.init.context.Operator;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.SerializationTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.model.session.SessionKey;
import org.soul.web.session.ICipherKeyResolver;
import org.soul.web.session.RedisSessionDao;
import org.soul.web.session.Sid;
import redis.clients.util.SafeEncoder;
import so.wwb.creditbox.model.base.CacheBase;
import so.wwb.creditbox.model.constants.cache.CacheKey;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteDomain;
import so.wwb.creditbox.utility.DomainTool;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

/**
 * Created by longer on 6/4/15.
 */
public class SessionFilter implements Filter {

    private static final Log LOG = LogFactory.getLog(SessionFilter.class);
    /**
     * redisSessionDao
     */
    private RedisSessionDao redisSessionDao;
    /**
     * 会话缓存前缀
     */
    private String sessionKeyPreFix;

    public String getSessionKeyPreFix() {
        return sessionKeyPreFix;
    }

    public void setSessionKeyPreFix(String sessionKeyPreFix) {
        this.sessionKeyPreFix = sessionKeyPreFix;
    }
    /**
     * 密匙提供者
     */
    private byte[] decryptionCipherKey;

    public RedisSessionDao getRedisSessionDao() {
        return redisSessionDao;
    }

    public void setRedisSessionDao(RedisSessionDao redisSessionDao) {
        this.redisSessionDao = redisSessionDao;
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
    public static VSysSiteDomain getSiteDomain(HttpServletRequest request) {
        return CacheBase.getSiteDomain(DomainTool.getDomain(request));

    }

    /*@IMonitorPoint(proxyType = "Web")*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        VSysSiteDomain siteDomain= getSiteDomain(request);
        CommonContext.set(new ContextParam());
        if(siteDomain!=null) {
            CommonContext.get().setSiteId(siteDomain.getSiteId());
            CommonContext.get().setSiteParentId(siteDomain.getSiteParentId());
            CommonContext.get().setSiteUserId(siteDomain.getSiteUserId());
            CommonContext.get().setUserIp(ServletTool.getIpAddr(request));
        }

        Cookie[] cookies = request.getCookies();
        //优先读取有子路径的SID
        String sessionId=null;
        String url=request.getRequestURI();
        for (Cookie cookie : cookies) {
            if ("SID".equals(cookie.getName())) {
                String  sidBase64 = cookie.getValue();
                Sid sid = new Sid();
                sid.decrypt(sidBase64,decryptionCipherKey);
                if(StringTool.isNotBlank(sid.getPath()) && "/".equals(sid.getPath()) &&  url.startsWith("/mdcenter")){
                    sessionId = sid.getId();
                    break;
                }else if(StringTool.isNotBlank(sid.getPath())&& !"/".equals(sid.getPath()) && !url.startsWith(sid.getPath())){
                    sessionId = sid.getId();
                    break;
                }
            }
        }


        sessionId = CacheKey.getCacheKey(getPreFix(request),sessionId);
        LOG.info("sessionId:{0}", sessionId);
        byte[] bytes = redisSessionDao.getJedisClientProxy().get(sessionId.getBytes());
        if (ArrayTool.isEmpty(bytes)) {
            response.getWriter().write("Session Time Out!");
            Integer code = Integer.parseInt(ErrorCodeEnum.SC_SESSION_EXPIRE.getCode());
            response.setStatus(code);
            response.setHeader(CUSTOM_HEADER_STATUS,code.toString());
            LOG.info("Session {0} Time Out!",sessionId);
            return;
        }
        Session session = (Session) SerializationTool.deserialize(bytes);

        if(session!=null){
            CommonContext.get().setSessionId(session.getId().toString());
            SysUser sysUser=(SysUser)session.getAttribute(SessionKey.S_USER);
            if(sysUser!=null){
                CommonContext.get().setUserId(sysUser.getId());
                CommonContext.get().setUserType(sysUser.getUserType());
                CommonContext.get().setOperator(new Operator());
                CommonContext.get().getOperator().setOperatorId(sysUser.getId());
                CommonContext.get().getOperator().setOperator(sysUser.getUsername());
                CommonContext.get().getOperator().setOperatorUserType(sysUser.getUserType());
            }
            touch(session,bytes);
            filterChain.doFilter(request, response);
        }
    }
    /**
     * 防止session过期
     * @param session
     */
    private void touch(Session session,byte[] key){
        if(new Date().getTime()-session.getLastAccessTime().getTime()>180000){
            session.setAttribute(SessionKey.TOUCH_ATTRIBUTE_KEY,"");
            int timeOut=Math.toIntExact(session.getTimeout());
            redisSessionDao.saveSession(SafeEncoder.encode(key),session, timeOut);
        }
    }
    private String getPreFix(HttpServletRequest request){
        VSysSiteDomain siteDomain=  getSiteDomain(request);
        return getSessionKeyPreFix()+ CacheKey.getCacheKeyPrefix(String.valueOf(siteDomain.getSiteParentId()),
                String.valueOf(siteDomain.getSiteUserId()),
                String.valueOf(siteDomain.getSiteId()));
    }
    public void setCipherKeyResolver(ICipherKeyResolver cipherKeyResolver) {
        setDecryptionCipherKey(cipherKeyResolver.getDecryptionCipherKey());
    }

    public void setDecryptionCipherKey(byte[] decryptionCipherKey) {
        this.decryptionCipherKey = decryptionCipherKey;
    }

    @Override
    public void destroy() {

    }
}