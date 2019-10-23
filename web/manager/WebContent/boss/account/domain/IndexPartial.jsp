<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="so.wwb.creditbox.model.enums.sys.ResolveStatusEnum" %>
<%@ include file="/include/include.inc.jsp" %>

<c:set var="fail" value="<%=ResolveStatusEnum.FAIL.getCode()%>"/>
<c:set var="success" value="<%=ResolveStatusEnum.SUCCESS.getCode()%>"/>
<c:set var="toBebound" value="<%=ResolveStatusEnum.TOBEBOUND.getCode()%>"/>
<c:set var="toBetied" value="<%=ResolveStatusEnum.TOBETIEDUP.getCode()%>"/>
<c:set var="toBetiedup" value="<%=ResolveStatusEnum.TOBEBIND.getCode()%>"/>
<c:set var="bounded" value="<%=ResolveStatusEnum.BOUNDED.getCode()%>"/>
<div class="table-responsive table-min-h">
        <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
            <thead>
            <tr class="bg-gray">
            <th>序号</th>
            <th>站点ID</th>
            <th>站点拥有者</th>
            <th>名称</th>
            <th>线路域名</th>
            <%--<th>--%>
                <%--<lb:selectPure callback="query" cssClass="btn-group chosen-select-no-single " name="search.type"--%>
                               <%--value="${command.search.type}" list="${domainTypes}" listValue="trans" listKey="code" prompt="全部类型"/>--%>
            <%--</th>--%>
            <th>
                <%--域名所属系统  domainSystemType--%>
                <lb:selectPure callback="query" cssClass="btn-group chosen-select-no-single" name="search.subsysCode"
                               value="${command.search.subsysCode}" list="${subSysCodes}" listValue="trans" listKey="code" prompt="全部角色"/>
            </th>
            <th>
                <lb:selectPure callback="query" cssClass="btn-group chosen-select-no-single" name="search.resolveStatus"
                               value="${command.search.resolveStatus}" list="${domainResolvestatus}" listValue="trans" listKey="code" prompt="全部状态"/>
            </th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="i" varStatus="status">
            <tr>
                <td>${(command.paging.pageNumber-1)*command.paging.pageSize + status.index+1}</td>
                <td>
                    <shiro:hasPermission name="account:site">
                        <a href="/vSiteMaster/list.html?search.siteid=${i.siteId}" nav-target="mainFrame" add-table="addTable" tab-name="站点管理">${i.siteId}</a>
                    </shiro:hasPermission>
                    <shiro:lacksPermission name="account:site">
                        ${i.siteId}
                    </shiro:lacksPermission>
                </td>
                <td>
                    <shiro:hasPermission name="account:site">
                        <a href="/vSiteMaster/list.html?search.username=${i.username}" nav-target="mainFrame" add-table="addTable" tab-name="站点管理">${empty fn:substringBefore(i.username,'@')?i.username:fn:substringBefore(i.username,'@')}</a>
                    </shiro:hasPermission>
                    <shiro:lacksPermission name="account:site">
                        ${empty fn:substringBefore(i.username,'@')?i.username:fn:substringBefore(i.username,'@')}
                    </shiro:lacksPermission>
                </td>
                <td>${i.name}
                    <c:if test="${i.isDefault}">
                        <span data-content="默认域名" data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="help-popover" tabindex="0"
                              data-original-title="" title="">
                            <i class="fa fa-exclamation-circle co-orange"></i>
                        </span>
                    </c:if>
                </td>
                <td>${i.domain}</td>
                <%--<td>--%>
                    <%--${dicts.account.domain_type[i.type]}--%>
                <%--</td>--%>
                <td>
                    ${dicts.account.susbSysCode[i.subsysCode]}
                </td>
                <td class="resolve" style="color: ${i.resolveStatus==fail?'red':''};">
                    ${dicts.account.domain_resolveStatus[i.resolveStatus]}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${i.resolveStatus eq '5'&&!i.isDefault}">
                            <shiro:hasPermission name="domain:switch">
                                <input type="checkbox" name="my-checkbox" value="${i.id}"
                                       data-size="mini"  ${i.isEnable?'checked':''}>
                            </shiro:hasPermission>
                        </c:when>
                        <c:otherwise>
                            ---
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <%--待绑定，和失败的域名不支持编辑和开关，隐藏编辑按钮和开关--%>
                    <shiro:hasPermission name="domain:domain_edit">
                    <c:if test="${i.resolveStatus eq fail || i.resolveStatus eq toBebound}">
                            <soul:button target="${root}/account/domain/edit.html?search.id=${i.id}" text="编辑"
                                         callback="callBackQuery" opType="dialog"/>
                    </c:if>
                    </shiro:hasPermission>
                    <%--只有成功才可解绑--%>
                        <shiro:hasPermission name="domain:unBind">
                    <c:if test="${i.resolveStatus eq success}">
                        <soul:button target="${root}/account/domain/toBound.html?result.id=${i.id}" confirm="您确定要解绑该域名吗？" text="解绑"
                                     callback="query" opType="ajax"/>
                    </c:if>
                        </shiro:hasPermission>
                    <c:if test="${i.resolveStatus eq toBetied}">
                        <shiro:hasPermission name="domain:bounded">
                        <soul:button target="${root}/account/domain/bounded.html?result.id=${i.id}" text="解绑成功"
                                     callback="query" opType="ajax"/>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="domain:success">
                        <%--解绑无效即状态更会成功--%>
                        <soul:button target="${root}/account/domain/boundedFail.html?result.id=${i.id}" text="解绑失败"
                                     callback="query" opType="ajax"/>
                        </shiro:hasPermission>
                    </c:if>
                        <%--只有失败、解绑才可删除--%>
                    <c:if test="${i.resolveStatus eq fail || i.resolveStatus eq bounded || i.resolveStatus eq toBebound}">
                        <shiro:hasPermission name="domain:delete">
                        <soul:button target="${root}/account/domain/delete.html?search.id=${i.id}" text="删除" opType="ajax" dataType="json" confirm="您确定要删除该条记录吗？" callback="query" />
                        </shiro:hasPermission>
                    </c:if>
                        <%--只有待绑定，才显示通过、失败--%>
                    <c:if test="${i.resolveStatus eq toBebound}">
                        <shiro:hasPermission name="domain:success">
                        <soul:button target="${root}/account/domain/success.html?result.id=${i.id}" text="通过"
                                     callback="query" opType="ajax"/>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="domain:fail">
                        <soul:button target="${root}/account/domain/fail.html?result.id=${i.id}" text="失败"
                                     callback="query" opType="ajax"/>
                        </shiro:hasPermission>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<soul:pagination/>

