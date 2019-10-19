<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%@ page import="java.util.Date" %>
<style>
    .remark{
        color:blue;
        font-size: 12px;
    }
</style>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="table-responsive" style="min-height: 300px">
        <table class="table table-condensed table-hover table-striped table-bordered">
            <thead>
            <tr class="bg-gray">
                <th >序号</th>
                <th >账号</th>
                <th >站点ID</th>
                <th >站点名称</th>
                <th >备注</th>
                <th>站点代码</th>
                <th >站点时区</th>
                <th >操作</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="nowTime" value="<%=new Date()%>"/>
            <c:forEach items="${command.result}" var="result" varStatus="status">
                <c:set var="check" value="${not empty result.maintainStartTime and not empty result.maintainEndTime and nowTime.before(result.maintainEndTime) and nowTime.after(result.maintainStartTime)}"/>
                <tr>
                    <td>${status.index+1}</td>
                    <td>
                        <shiro:hasPermission name="site:master">
                            <a href="/account/account/view.html?id=${result.id}" nav-target="mainFrame">${fn:substringBefore(result.username,'@')}</a>
                        </shiro:hasPermission>
                        <shiro:lacksPermission name="site:master">
                            ${empty fn:substringBefore(result.username,'@')?result.username:fn:substringBefore(result.username,'@')}
                        </shiro:lacksPermission>
                    </td>
                    <td>${result.id}</td>
                    <td>
                        ${result.siteName}
                    </td>
                    <td>
                        <c:if test="${fn:length(result.remark)>20}">
                            ${fn:substring(result.remark,0,20)} <span class="remark"> 更多</span>
                        </c:if>
                        <c:if test="${fn:length(result.remark)<=20}">
                            ${result.remark}
                        </c:if>
                        <div  style="display: none">${result.remark}</div>
                    </td>
                    <td>${result.code}</td>
                    <td>${result.timezone}</td>
                    <td>
                            <soul:button target="${root}/site/siteBoss/siteEdit.html?search.id=${result.id}"
                                         cssClass="" permission="site:boss_edit" callback="callBackQuery" text="编辑"
                                         title="编辑[${result.id}]" opType="dialog"></soul:button>

                        <shiro:hasPermission name="site:boss_viewDomain">
                            <a nav-target="mainFrame"  href="/site/siteBossDetail/viewDomainBoss.html">域名</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="site:boss_confineIp">
                            <a nav-target="mainFrame" href="/siteConfineIp/bossSiteConfineIpList.html?search.siteId=${result.id}">白名单</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="site:boss_confineArea">
                            <a href="/siteConfineArea/bossConfineAreaList.html?search.siteId=${result.id}" nav-target="mainFrame">黑名单</a>
                        </shiro:hasPermission>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<soul:pagination/>

