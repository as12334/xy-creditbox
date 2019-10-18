<%--@elvariable id="command" type="so.wwb.lotterybox.model.manager.user.vo.SysUserExtendListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div class="table-responsive table-min-h">
    <c:set var="lastTimeSearchToJson" value="${command.lastTimeSearchToJson}"/>
    <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
        <thead>
        <tr class="bg-gray">
            <th width="10%">序号</th>
            <th width="10%">股东账号[站点]</th>
            <th width="10%">昵称</th>
            <th width="15%">创建时间</th>
            <th width="10%">商户数</th>
            <th width="10%">状态</th>
            <th width="15%">最近登录时间</th>
            <th width="20%">操作</th>
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
                <td>
                    <c:set var="b" value="0"></c:set>
                    <c:forEach var="owner" items="${ownerIds}" >
                            <c:if test="${owner.owner_id == i.id}">
                                <c:set var="b" value="${owner.count}"></c:set>
                            </c:if>
                    </c:forEach>
                    <a href="/boss/account/merchant/merchantList.html?search.ownerId=${i.id}&search.hasReturn=companies" nav-target="mainFrame"  tab-name="商户列表">${b}</a>
                </td>
                <td>
                    <shiro:hasPermission name="account:companies_status">
                    <c:choose>
                        <c:when test="${i.status eq '1'}">
                                <input type="checkbox" name="my-checkbox" value="${i.id}"
                                       data-size="mini"  ${i.status=='1'?'checked':''} >
                        </c:when>
                        <c:when test="${i.status eq '2'}">
                            <input type="checkbox" name="my-checkbox" value="${i.id}"
                                   data-size="mini" >
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
                    <shiro:hasPermission name="account:companies_view">
                        <a nav-target="mainFrame" href="/boss/account/companies/view.html?id=${i.id}&lastTimeSearch=${lastTimeSearchToJson}">详细</a>
                    </shiro:hasPermission>&nbsp&nbsp
                    <soul:button target="${root}/boss/account/companies/editShAccount.html?id=${i.id}" text="编辑" callback="callBackQuery"
                                 opType="dialog" permission="account:companies_edit"/>&nbsp&nbsp&nbsp&nbsp
                    <c:if test="${!i.builtIn}">
                        <soul:button target="${root}/boss/account/companies/resetPwd.html?id=${i.id}" text="重置密码" callback="callBackQuery"
                                     opType="dialog" permission="account:companies_updateShPwd"/>

                        <soul:button target="${root}/boss/account/companies/resetAuthenticationKey.html?result.id=${i.id}&result.siteId=${i.siteId}"
                                     tag="a" cssClass="btn" text="重置身份验证" callback="showAuthenticationKeyUrl" opType="ajax"
                                     permission="account:companies_resetAuthenticationKey"/>

                        <c:if test="${i.status eq'3' and i.status ne '2'}">
                            <soul:button target="${root}/boss/account/companies/freezeShStatus.html?result.id=${i.id}" confirm="确定解冻该账号吗？"
                                         text="解冻" callback="query" opType="ajax" permission="account:companies_freeze"/>
                        </c:if>
                        <c:if test="${i.status eq '1' and i.status ne '2'}">
                            <soul:button target="${root}/boss/account/companies/freezeShStatus.html?result.id=${i.id}" confirm="确定手动冻结该账号吗？"
                                         text="冻结" callback="query" opType="ajax" permission="account:companies_freeze"/>
                        </c:if>
                    </c:if>&nbsp;&nbsp;

                    <c:if test="${i.userType eq '2' || i.userType eq '1'}">
                        <c:choose>
                            <c:when test="${not empty i.siteId}">
                                <%--站点详细权限使用股东站点，站点 名称的权限--%>
                                <shiro:hasPermission name="site:shareholderSiteDetail">
                                    <a href="/site/shareholderSiteDetail/viewSiteShareHolder.html?search.id=${i.siteId}&search.type=1&search.subsysCode=${i.subsysCode}" nav-target="mainFrame">站点详细</a>
                                </shiro:hasPermission>
                            </c:when>
                            <c:otherwise>
                                <shiro:hasPermission name="account:companies_site_create">
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
