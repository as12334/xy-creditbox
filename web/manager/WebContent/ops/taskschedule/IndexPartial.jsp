<%@ page import="org.soul.model.taskschedule.po.TaskSchedule" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="poType" value="<%= TaskSchedule.class %>"></c:set>

<!--//region your codes 1-->
<div class="table-responsive table-min-h">
    <table class="table table-condensed table-hover table-striped table-bordered">
        <thead>
        <tr class="bg-gray">
            <th style="width: 200px;">操作</th>
            <th style="width: 40px;">序号</th>
            <th style="width: 110px;">任务编号</th>
            <th style="width: 110px;">任务名称</th>
            <th>任务class全路径</th>
            <th style="width: 90px;">任务方法名</th>
            <th style="width: 70px;">是否本地方法</th>
            <th style="width: 70px;">是否同步</th>
            <th style="width: 80px;">
                <lb:select name="search.status" value="${command.search.status}" cssClass="btn-group chosen-select-no-single" prompt="全部" list="${statusMap}" listKey="code" listValue="trans" callback="query"/>
            </th>
            <th style="width: 120px;">调度表达式</th>
            <th style="width: 135px;">创建时间</th>
            <th style="width: 65px;">所属机房</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr>
                <td>
                    <div class="joy-list-row-operations">
                        <c:if test="${p.status == '1'}">
                                <soul:button
                                        target="${root}/taskSchedule/pause.html?search.id=${p.id}&search.scheduler=${p.scheduler}"
                                        text="停用" opType="ajax" dataType="json" confirm="您确定要停用该任务吗？"
                                        callback="callBackQuery" permission="task:pause"/>
                                <soul:button
                                        target="${root}/taskSchedule/runOnce.html?search.jobCode=${p.jobCode}&search.scheduler=${p.scheduler}"
                                        text="运行" permission="task:runOnce" opType="ajax" dataType="json" confirm="您确定要立即运行一次该任务吗？"/>
                        </c:if>
                        <c:if test="${p.status == '2'}">
                                <soul:button
                                        target="${root}/taskSchedule/resume.html?search.id=${p.id}&search.scheduler=${p.scheduler}"
                                        text="启用" opType="ajax" permission="task:resume" dataType="json" confirm="您确定要启用该任务吗？"
                                        callback="callBackQuery"/>
                        </c:if>
                            <soul:button target="${root}/taskRunRecord/list.html?search.taskScheduleId=${p.id}"
                                         text="记录" permission="task:list" opType="dialog" size="size-wide"/>
                        <soul:button
                                target="${root}/taskSchedule/view.html?search.id=${p.id}&search.scheduler=${p.scheduler}"
                                text="查看" opType="dialog" size="size-wide"/>
                            <soul:button
                                    target="${root}/taskSchedule/edit.html?search.id=${p.id}&search.scheduler=${p.scheduler}"
                                    text="编辑" opType="dialog" permission="task:edit" size="size-wide" callback="callBackQuery"/>
                            <c:if test="${!p.isSystem}">
                                <soul:button
                                        target="${root}/taskSchedule/delete.html?search.id=${p.id}&search.scheduler=${p.scheduler}"
                                        text="删除" permission="task:delete" opType="ajax" dataType="json" confirm="您确定要删除该条记录吗？"
                                        callback="query"/>
                            </c:if>
                    </div>
                </td>
                <td >${status.index+1}</td>
                <td >${p.jobCode}</td>
                <td >${p.jobName}</td>
                <%--<td nowrap="nowrap">${p.aliasName}</td>--%>
                <%--<td nowrap="nowrap">${p.jobGroup}</td>--%>
                <td style="width: 25%;" title="${p.jobClass}">${p.jobClass}</td>
                <td >${p.jobMethod}</td>
                <%--<td nowrap="nowrap">${dicts.taskschedule.isSystem[p.isSystem.toString()]}</td>--%>
                <td >${dicts.taskschedule.isLocal[p.isLocal.toString()]}</td>
                <td >${dicts.taskschedule.isSync[p.isSync.toString()]}</td>
                <td >${dicts.taskschedule.status[p.status]}</td>
                <td >${p.cronexpression}</td>
                <td ><fmt:formatDate value="${p.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td >${p.belongToIdc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<soul:pagination/>
<!--//endregion your codes 1-->
