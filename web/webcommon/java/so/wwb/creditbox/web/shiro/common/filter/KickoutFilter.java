package so.wwb.creditbox.web.shiro.common.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.soul.commons.cache.CacheKey;
import org.soul.commons.cache.jedis.proxy.JedisClientProxy;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.SerializationTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.locale.LocaleTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.ServletTool;
import org.soul.commons.spring.utils.SpringTool;
import org.soul.commons.support._Module;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.error.ErrorMessage;
import org.soul.model.log.audit.enums.OpMode;
import org.soul.model.security.privilege.vo.SysUserVo;
import org.soul.model.session.SessionKey;
import org.soul.web.session.KickOutMessage;
import org.soul.web.session.RedisSessionDao;
import redis.clients.util.SafeEncoder;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.model.manager.sys.po.VSysSiteManage;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteManageVo;
import so.wwb.creditbox.web.init.CommonCtxLoaderListener;
import so.wwb.creditbox.web.tools.SessionManagerCommon;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Set;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class KickoutFilter extends AccessControlFilter {

    private static final Log LOG = LogFactory.getLog(KickoutFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String scheme = request.getHeader("X-Forwarded-Scheme");
        String port = request.getHeader("X-Forwarded-Port");
        if (StringTool.isEmpty(scheme)) {
            scheme = request.getScheme();
        }
        if (StringTool.isEmpty(port)) {
            port = String.valueOf(request.getServerPort());
        }
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return true;
        }

        KickOutMessage sysOnLineSession = (KickOutMessage) SessionManagerCommon.getAttribute(SessionKey.S_KICK_OUT);
        if (sysOnLineSession == null) {
            return true;
        }

        LOG.warn("踢出用户会话:SessionId:{2},用户[{0}],命中[待踢出]标识,踢出类型:{1}", SessionManagerCommon.getAttribute(SessionKey.S_USER_ID),sysOnLineSession.getOpMode().getTrans(),SessionManagerCommon.getId());
        ErrorMessage errorMessage = defaultKickOutMsg(sysOnLineSession);

        SessionManagerCommon.setAttribute(SessionKey.S_KICK_OUT,sysOnLineSession);
        Integer headerStatus = Integer.valueOf(ErrorCodeEnum.SC_KICK_OUT.getCode());
        response.setHeader(CUSTOM_HEADER_STATUS,headerStatus.toString());
        response.setStatus(headerStatus);

        if (ServletTool.isAjaxRequest(request)) {
            String json = JsonTool.toJson(errorMessage);
            response.getWriter().print(json);
            response.getWriter().flush();
            return false;
        }
        response.sendRedirect(MessageFormat.format("{0}://{1}:{2}{3}", scheme, request.getServerName(), port, CommonCtxLoaderListener.ContextPath + ErrorCodeEnum.SC_KICK_OUT.getUrl() + ".html"));
        return false;
    }

    public static ErrorMessage defaultKickOutMsg(KickOutMessage kickOutMessage) {
        ErrorMessage errorMessage = new ErrorMessage();
        String title = "";
        String message = "";
        if (OpMode.AUTO.equals(kickOutMessage.getOpMode())){
            title = LocaleTool.tranMessage(_Module.Passport, "kick.out.auto.title");
            message = LocaleTool.tranMessage(_Module.Passport, "kick.out.auto.content", kickOutMessage.getOperateIp());
        } else {
            message= (String)SessionManagerCommon.getAttribute(SessionKey.S_KICKOUT_MESSAGE);
            title = LocaleTool.tranMessage(_Module.Passport, "kick.out.manual.title");
            if(StringTool.isBlank(message)) {
                message = LocaleTool.tranMessage(_Module.Passport, "kick.out.manual.content");
            }
        }
        errorMessage.setCode(ErrorCodeEnum.SC_KICK_OUT.getCode());
        errorMessage.setTitle(title);
        errorMessage.setMessage(message);
        return errorMessage;
    }

    public static void loginKickoutAll(Integer userId,Integer siteId, OpMode opMode,String opSource) {
        loginKickoutAll(userId,siteId,opMode,null,opSource);
    }

    public static void loginKickoutAll(Integer userId,Integer siteId,OpMode opMode,String kickOutMsg,String opSource) {
        RedisSessionDao redisSessionDao = (RedisSessionDao) SpringTool.getBean("redisSessionDao");
        SysUserVo userVo = new SysUserVo();
        userVo.getSearch().setId(userId);
        if (siteId != null) {
            userVo._setDataSourceId(siteId);
        }
        userVo = ServiceTool.sysUserService().get(userVo);
        VSysSiteManageVo vSysSiteManageVo = new VSysSiteManageVo();
        vSysSiteManageVo.getSearch().setId(userVo.getResult().getSiteId());
        vSysSiteManageVo = ServiceTool.vSysSiteManageService().get(vSysSiteManageVo);
        VSysSiteManage site = vSysSiteManageVo.getResult();
        String pattern = userVo.getResult().getUserType() + "," + userVo.getResult().getId() + ",";
        String genPrefix = "";
        if (site != null) {
            genPrefix += redisSessionDao.getSessionKeyPreFix() + site.getParentId() + "," + site.getSysUserId() + "," + site.getId();
        } else {
            genPrefix += redisSessionDao.getSessionKeyPreFix() + userVo.getResult().getUserType() + "," + userVo.getResult().getId();
        }
        Set<String> keys = redisSessionDao.getJedisClientProxy().keys(SafeEncoder.encode(CacheKey.getCacheKey(genPrefix, pattern + "*")));
        JedisClientProxy jedisClientProxy = redisSessionDao.getJedisClientProxy();
        for (String key : keys) {
            CommonContext.get().getOperator().setOperatorId(SessionManagerCommon.getUserId());
            if (StringTool.isNotBlank(kickOutMsg)) {
                try {
                    Session session = (Session) SerializationTool.deserialize(jedisClientProxy.get(SafeEncoder.encode(key)));
                    session.setAttribute(SessionKey.S_KICKOUT_MESSAGE, kickOutMsg);
                    jedisClientProxy.setex(SafeEncoder.encode(key), 1800, SerializationTool.serialize((Serializable) session));
                } catch (Exception e) {
                    LOG.error(e);
                }
            }
            redisSessionDao.kickOutSession(key, opMode, opSource);
        }
    }

}