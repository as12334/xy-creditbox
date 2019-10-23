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
                <th >股东账号</th>
                <th >站点ID</th>
                <th >站点名称</th>
                <th>站点状态</th>
                <th >备注</th>
                <th>站点代码</th>
                <th >站点时区</th>
                <th>维护时间</th>
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
                            <a href="/boss/account/companies/view.html?id=${result.id}" nav-target="mainFrame">${empty fn:substringBefore(result.username,'@')?result.username:fn:substringBefore(result.username,'@')}</a>
                        </shiro:hasPermission>
                        <shiro:lacksPermission name="site:master">
                            ${empty fn:substringBefore(result.username,'@')?result.username:fn:substringBefore(result.username,'@')}
                        </shiro:lacksPermission>
                    </td>
                    <td>${result.id}</td>
                    <td>
                        <shiro:hasPermission name="site:companiesSiteDetail">
                            <a href="/site/companiesSiteDetail/viewSiteShareHolder.html?search.id=${result.id}&search.subsysCode=${result.subsysCode}"
                               nav-target="mainFrame">${result.siteName}</a>
                        </shiro:hasPermission>
                    </td>
                    <td>
                        <shiro:hasPermission name="site:update_shsite_status">
                            <c:choose>
                                <c:when test="${result.status eq '1'}">
                                    <input type="checkbox" name="my-checkbox" value="${result.id}"
                                           data-size="mini"  ${result.status=='1'?'checked':''} >
                                </c:when>
                                <c:when test="${result.status eq '2'}">
                                    <input type="checkbox" name="my-checkbox" value="${result.id}"
                                           data-size="mini">
                                </c:when>
                            </c:choose>
                        </shiro:hasPermission>
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
                        <c:if test="${check}">
                            ${soulFn:formatDateTz(result.maintainStartTime, DateFormat.DAY_SECOND,timeZone)}-- --
                            ${soulFn:formatDateTz(result.maintainEndTime, DateFormat.DAY_SECOND,timeZone)}
                        </c:if>
                    </td>

                    <td>
                            <soul:button target="${root}/site/siteCompanies/siteEdit.html?search.id=${result.id}"
                                         permission="site:siteCompanies" cssClass="" callback="callBackQuery" text="编辑"
                                         title="编辑[${result.id}]" opType="dialog"></soul:button>
                        <shiro:hasPermission name="site:boss_domain">
                            <a nav-target="mainFrame" href="/site/companiesSiteDetail/viewDomainCompanies.html?search.siteId=${result.id}&search.sysUserId=${result.sysUserId}">域名</a>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="site:confineIp">
                            <a nav-target="mainFrame" href="/siteConfineIp/companiesConfineIpList.html?search.siteId=${result.id}" >白名单</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="site:SiteConfineArea">
                            <a href="/siteConfineArea/companiesConfineAreaList.html?search.siteId=${result.id}" nav-target="mainFrame">黑名单</a>
                        </shiro:hasPermission>

                        <shiro:hasPermission name="site:companies_site_maintain">
                            <c:choose>
                                <c:when test="${check}">
                                    <soul:button target="${root}/vSysSiteManage/sysCompaniesSiteMaintainEnd.html?result.id=${result.id}"
                                                 text="结束维护" opType="ajax" dataType="json" confirm="您确定结束维护吗？"
                                                 callback="query" >结束维护</soul:button>
                                    <soul:button target="${root}/vSysSiteManage/sysCompaniesSiteMaintain.html?search.id=${result.id}"
                                                 opType="dialog" text="修改维护" callback="callBackQuery"
                                                 cssClass="">修改维护</soul:button>
                                </c:when>
                                <c:otherwise>
                                    <soul:button target="${root}/vSysSiteManage/sysCompaniesSiteMaintain.html?search.id=${result.id}"
                                                 opType="dialog" text="站点维护" callback="callBackQuery"
                                                 cssClass="">站点维护</soul:button>
                                </c:otherwise>
                            </c:choose>
                        </shiro:hasPermission>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<soul:pagination/>

