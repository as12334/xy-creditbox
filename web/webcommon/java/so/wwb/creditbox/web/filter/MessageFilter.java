package so.wwb.creditbox.web.filter;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.string.I18nTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.tree.TreeNode;
import org.soul.model.security.privilege.po.VSysUserResource;
import org.soul.model.security.privilege.vo.SysResourceVo;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.context.LotteryCommonContext;
import so.wwb.creditbox.context.LotteryContextParam;
import so.wwb.creditbox.model.enums.user.UserTypeEnum;
import so.wwb.creditbox.model.manager.sys.po.Nav;
import so.wwb.creditbox.model.manager.sys.vo.VSysSiteDomainVo;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SysResourceVo o = new SysResourceVo();
        LotteryContextParam contextParam = LotteryCommonContext.get();
//        if(!StringTool.equals(contextParam.getUserType(), UserTypeEnum.COMPANY.getCode())){
//            o.getSearch().setUserId(SessionManagerCommon.getUserId());
//        }
        o.getSearch().setSubsysCode(contextParam.getDomainSubsysCode());
        o._setSiteId(contextParam.getSiteId());
        o._setDataSourceId(contextParam.getSiteId());
//        List<Nav>  navs = ServiceTool.vUserPlayerService().getAllMenus(o);

//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        for (Nav nav : navs) {
//            linkedHashMap.put(nav.getName(),nav);
//        }


        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/javascript");
//        String result = MessageFormat.format("var message = {0}; var nav = {1};",I18nTool.getScriptMessageObject(CommonContext.get().getLocale().toString()), JsonTool.toJson(linkedHashMap));
//        response.getWriter().print(result);
        response.getWriter().close();







    }

    @Override
    public void destroy() {

    }
}