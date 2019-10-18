package so.wwb.creditbox.company.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.soul.commons.net.ServletTool;
import org.soul.model.error.ErrorCodeEnum;
import org.soul.model.security.privilege.po.SysUser;
import org.soul.web.session.SessionManagerBase;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.web.filter.SubsysCodeFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.soul.commons.init.context.Const.CUSTOM_HEADER_STATUS;

public class ManagerSubsysCodeFilter extends SubsysCodeFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return true;
        }
        LotteryContextParam contextParam = LotteryCommonContext.get();
        SysUser sysUser = SessionManagerBase.getUser();
        String code = sysUser.getSubsysCode();
        //TODO api商户、API总代 的域名的subsysCode 并没有使用merchant-api、distributor-api的格式； jeremy 2018年10月25日
        if (code.contains("-")){
            code = code.substring(0, code.indexOf("-"));
        }
        if(contextParam != null && contextParam.getSubSysCodeEnum() != null && contextParam.getSubSysCodeEnum().getCode().equals(code)){
            return true;
        }
        if (ServletTool.isAjaxRequest(request)) {
            Integer headerStatus = Integer.valueOf(ErrorCodeEnum.SC_FORBIDDEN.getCode());
            response.setHeader(CUSTOM_HEADER_STATUS,headerStatus.toString());
            response.setStatus(headerStatus);
        } else {
            String url = ErrorCodeEnum.SC_FORBIDDEN.getUrl() + ".html";
            WebUtils.redirectToSavedRequest(request, response, url);
        }
        return false;
    }
}
