<%--@elvariable id="command" type="so.wwb.lotterybox.model.manager.user.vo.SysUserExtendListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div class="table-responsive table-min-h">
    <c:set var="lastTimeSearchToJson" value="${command.lastTimeSearchToJson}"/>
    <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
        <thead>
        <tr class="bg-gray">
            <th width="5%">序号</th>
            <th width="10%">商户账号[站点]</th>
            <th width="10%">昵称</th>
            <th width="10%">创建时间</th>
            <%--<th width="10%">上级股东[站点]</th>--%>
            <th width="5%">总代数量</th>
            <th width="10%">状态</th>
            <th width="15%">最近登录时间</th>
            <th width="25%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="i" varStatus="status">
            <tr>
                <td>${(command.paging.pageNumber-1)*command.paging.pageSize + status.index+1}</td>
                <td>
                        ${empty fn:substringBefore(i.username,'@')?i.username:fn:substringBefore(i.username,'@')}&nbsp;
                    <c:if test="${not empty i.siteId}">
                        [${i.siteId}]
                    </c:if>
                </td>

                <td>${i.nickname}</td>
                <td>${soulFn:formatDateTz(i.createTime, DateFormat.DAY_SECOND, timeZone)}</td>
                <%--<td>--%>
                    <%--<c:if test="${!empty i.ownerId}">--%>
                        <%--${empty fn:substringBefore(i.ownerName,'@')?i.ownerName:fn:substringBefore(i.ownerName,'@')}&nbsp;--%>
                        <%--<c:if test="${not empty i.siteId}">--%>
                            <%--[${i.siteId}]--%>
                        <%--</c:if>--%>
                    <%--</c:if>--%>
                <%--</td>--%>
                <td>
                    <c:set var="b" value="0"/>
                    <c:forEach var="owner" items="${ownerIds}" >
                        <c:if test="${owner.owner_id == i.id}">
                            <c:set var="b" value="${owner.count}"/>
                        </c:if>
                    </c:forEach>
                    <a href="/boss/account/agent/agentList.html?search.ownerId=${i.id}&search.hasReturn=merchant&search.shareholderId=${shareholderId}" nav-target="mainFrame"  tab-name="商户列表">${b}</a>
                </td>
                <td>
                    <shiro:hasPermission name="COMPANY:status">
                    <c:choose>
                        <c:when test="${i.status eq '1'}">
                                <input type="checkbox" name="my-checkbox" value="${i.id}" data-size="mini"  ${i.status=='1'?'checked':''} >
                        </c:when>
                        <c:when test="${i.status eq '2'}">
                            <input type="checkbox" name="my-checkbox" value="${i.id}" data-size="mini">
                        </c:when>
                        <c:when test="${i.status eq '3'}">
                            <input type="button" class="btn btn-default btn-sm" style="background-color: #DEDEDE" value="冻结中">
                        </c:when>
                    </c:choose>
                    </shiro:hasPermission>
                </td>

                <td>
                    <span class="co-gray">
                      ${soulFn:formatDateTz(i.loginTime, DateFormat.DAY_SECOND,timeZone)} -- -- ${soulFn:formatTimeMemo(i.loginTime,locale )}
                    </span>
                </td>
                <td>
                    <shiro:hasPermission name="COMPANY:detail">
                        <a nav-target="mainFrame" href="/boss/account/merchant/view.html?id=${i.id}&lastTimeSearch=${lastTimeSearchToJson}">详细</a>
                    </shiro:hasPermission>&nbsp&nbsp
                        <soul:button target="${root}/boss/account/company/editMhAccount.html?id=${i.id}" text="编辑"
                                     callback="callBackQuery" opType="dialog" permission="COMPANY:edit"/>&nbsp&nbsp&nbsp&nbsp
                    <c:if test="${!i.builtIn}">
                        <soul:button target="${root}/boss/account/company/resetPwd.html?id=${i.id}" text="重置密码"
                                     callback="callBackQuery" opType="dialog" permission="COMPANY:password"/>
                        <soul:button target="${root}/boss/account/company/resetAuthenticationKey.html?result.id=${i.id}&result.siteId=${i.siteId}"
                                     tag="a" cssClass="btn" text="重置身份验证" callback="showAuthenticationKeyUrl" opType="ajax" permission="COMPANY:reset"/>
                        <c:if test="${i.status eq'3'and i.status ne '2'}">
                            <soul:button target="${root}/boss/account/company/freezeMhStatus.html?result.id=${i.id}" confirm="确定解冻该账号吗？"
                                         text="解冻" callback="query" opType="ajax" permission="COMPANY:freeze"/>
                        </c:if>
                        <c:if test="${i.status=='1' and i.status ne '2'}">
                            <soul:button target="${root}/boss/account/company/freezeMhStatus.html?result.id=${i.id}" confirm="确定手动冻结该账号吗？"
                                         text="冻结" callback="query" opType="ajax" permission="COMPANY:freeze"/>
                        </c:if>


                    </c:if>&nbsp&nbsp

                    <c:if test="${i.userType eq '2' or i.userType eq '1'}">
                        <c:choose>
                            <c:when test="${not empty i.siteId}">
                                <%--使用商户站点-站点名称的权限--%>
                                <shiro:hasPermission name="site:merchantDetail">
                                    <a href="/site/merchantSiteDetail/viewSiteMerchant.html?search.id=${i.siteId}&search.subsysCode=${i.subsysCode}&search.type=1" nav-target="mainFrame">站点详细</a>
                                </shiro:hasPermission>
                            </c:when>
                            <c:otherwise>
                                <shiro:hasPermission name="COMPANY:site_create">
                                    <a nav-target="mainFrame" href="/vSysSiteManage/siteBasic.html?search.step=1&search.sysUserId=${i.id}&search.userType=${i.userType}&&search.parentId=${i.ownerId}&lastTimeSearch=${lastTimeSearchToJson}">新增站点</a>
                                </shiro:hasPermission>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<soul:pagination/>
<!--//endregion your codes 1--
