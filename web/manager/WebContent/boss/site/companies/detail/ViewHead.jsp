<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="sys_tab_wrap clearfix m-b-sm">
    <div class="m-sm">
        <b class="fs16">站点详细资料</b>
        <c:if test="${userType!=0}">
        <div class="pull-right m-b-sm">
                <soul:button target="${root}/vSysSiteManage/siteformMaintain.html?search.siteId=${getSiteId}"
                             opType="dialog" text="站点维护" permission="site:siteMaintain"
                             cssClass="btn btn-outline btn-filter btn-sm siteClose ${disableVo.status==1?'':'disabled'}"
                             callback="siteSaveCallbak">
                    站点维护
                </soul:button>
            <input type="hidden" id="siteId" value="${siteId}">
        </div>
        </c:if>
    </div>
</div>
