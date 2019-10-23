<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%@ page import="so.wwb.lotterybox.model.enums.sys.ResolveStatusEnum" %>
<c:set var="fail" value="<%=ResolveStatusEnum.FAIL.getCode()%>"/>
<c:set var="success" value="<%=ResolveStatusEnum.SUCCESS.getCode()%>"/>
<c:set var="toBebound" value="<%=ResolveStatusEnum.TOBEBOUND.getCode()%>"/>
<c:set var="toBetiedup" value="<%=ResolveStatusEnum.TOBETIEDUP.getCode()%>"/>
<c:set var="toBetiedup" value="<%=ResolveStatusEnum.TOBEBIND.getCode()%>"/>
<c:set var="bounded" value="<%=ResolveStatusEnum.BOUNDED.getCode()%>"/>
<div class="table-responsive table-min-h">
    <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
        <thead>
        <tr class="bg-gray">
            <th>编号</th>
            <th>代理号</th>
            <th>名称</th>
            <th>域名</th>
            <th>类型</th>
            <th>
                <lb:select name="search.resolveStatus" callback="query" cssClass="btn-group chosen-select-no-single" listKey="code" listValue="trans" value="${command.search.resolveStatus}" list="${domainResolvestatus}"
                           prompt="全部状态"/>
            </th>
            <th>状态</th>
            <th>创建时间</th>
            <th>是否启用</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr class="gradeA ${status.index%2==0?'odd':'even'}">
                <td>${(command.paging.pageNumber-1)*command.paging.pageSize + status.index+1}</td>
                <td>${p.userCode}</td>
                <td>${p.name}
                    <c:if test="${p.isDefault}">
                        <span data-content="默认域名" data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="help-popover" tabindex="0"
                              data-original-title="" title="">
                            <i class="fa fa-exclamation-circle co-orange"></i>
                        </span>
                    </c:if>
                </td>
                <td>${p.domain}</td>
                <td>${dicts.account.domain_type[p.type]}</td>
                <td class="resolve"
                    style="color: ${i.resolveStatus==fail?'red':''};">${dicts.account.domain_resolveStatus[p.resolveStatus]}</td>
                <c:choose>
                    <%--只有成功的才可以选择启用或者停用--%>
                    <c:when test="${p.resolveStatus == success}">
                        <td class="_enable${p.isEnable ? '':' hide'}">
                            <span class="label label-green">已启用</span>
                        </td>
                        <td class="co-grayc2 _disabled${not p.isEnable ? '':' hide'}">
                            <span class="label">已停用</span>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            <span>---</span>
                        </td>
                    </c:otherwise>
                </c:choose>
                <td>${soulFn:formatDateTz(p.createTime,DateFormat.DAY_SECOND ,timeZone )}</td>
                <td>
                    <shiro:hasPermission name="domain:changestatus_domain">
                    <c:choose>
                        <c:when test="${p.resolveStatus eq '5'&&!p.isDefault}">
                            <input type="checkbox" name="my-checkbox" value="${p.id}"
                                   data-size="mini"  ${p.isEnable?'checked':''}>
                            <shiro:lacksPermission name="domain:switch">
                            </shiro:lacksPermission>
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                    </shiro:hasPermission>
                </td>
                <td>
                    <soul:button
                            target="${root}/account/domain/edit.html?search.id=${p.id}&search.siteId=${getSiteId}"
                            size="open-dialog-50" text="${views.common['edit']}" cssClass="co-blue m-r-xs m-l-xs"
                            opType="dialog" callback="callBackQuery" permission="domin:deit_domain"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
<soul:pagination/>
