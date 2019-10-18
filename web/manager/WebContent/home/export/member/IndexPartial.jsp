<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%@ page import="java.util.Date" %>
<div class="table-responsive table-min-h">
    <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
        <thead>
        <tr class="bg-gray">
            <th width="5%">序号</th>
            <th width="10%">玩家账号</th>
            <th width="15%">注册时间</th>
            <th width="10%">状态</th>
            <th width="20%">最后登录时间</th>
            <th width="20%">最后登录的IP/地区</th>
            <th width="15%">玩家上级</th>
            <th width="15%">真实姓名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr>
                <td>${(command.paging.pageNumber-1)*command.paging.pageSize + status.index+1}</td>
                <td>${p.username}</td>
                <td>
                    <span data-content="${soulFn:formatDateTz(p.createTime,DateFormat.DAY_SECOND,timeZone)}"
                          data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                          role="button" class="ico-lock" tabindex="0" data-original-title="" title="">
                        <apan class="co-grayc2">${soulFn:formatTimeMemo(p.createTime,locale)}</apan>
                    </span>
                </td>
                <td>
                    <div class="content" data-value="${p.status}">
                        <c:set var="nowTime" value="<%=new Date()%>"/>
                        <c:if test="${empty p.freezeEndTime or nowTime.after(p.freezeEndTime) or nowTime.before(p.freezeStartTime)}">
                            <span id="${p.id}_${p.username}" data-value="${p.status}" class="label ${p.status eq '1'?"btn-success":"badge-danger"}">${dicts.account.user_status[p.status]}</span>
                        </c:if>
                        <c:if test="${not empty p.freezeEndTime and nowTime.before(p.freezeEndTime) and nowTime.after(p.freezeStartTime)}">
                            <span id="${p.id}_${p.username}" data-value="3" class="label badge-danger">冻结</span>
                        </c:if>
                    </div>
                </td>
                <td>
                    <span data-content="${soulFn:formatDateTz(p.lastLoginTime,DateFormat.DAY_SECOND,timeZone)}"
                          data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                          role="button" class="ico-lock" tabindex="0" data-original-title="" title="">
                        <apan class="co-grayc2">${soulFn:formatTimeMemo(p.lastLoginTime,locale)}</apan>
                    </span>
                </td>
                <td>
                    <span class="co-red" style="padding-left: 0px">
                    <c:if test="${not empty p.lastLoginIp}">
                        ${soulFn:formatIp(p.lastLoginIp)}
                    </c:if>
                    </span>
                        ${gbFn:getShortIpRegion(p.lastLoginIpDictCode)}
                </td>
                <td>
                    <c:if test="${empty p.superiorId}"><span style="font-style: italic;color: #C0C0C0">无</span></c:if>
                    <c:if test="${not empty p.superiorId}">
                        <a href="/merchant/account/membercenter/view.html?search.id=${p.superiorId}&search.username=${p.superiorName}&search.historyUsername=${command.search.username}" nav-target="mainFrame" title="点击查看玩家详情">${p.superiorName}</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${empty p.realName}"><span style="font-style: italic;color: #C0C0C0">${views.common['unfilled']}</span></c:if>
                    <c:if test="${not empty p.realName}">${p.realName}</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<soul:pagination/>