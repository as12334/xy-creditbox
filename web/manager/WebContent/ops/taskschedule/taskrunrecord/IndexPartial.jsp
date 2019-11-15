<%@ page import="so.wwb.lotterybox.model.manager.taskschedule.po.TaskRunRecord" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="poType" value="<%= TaskRunRecord.class %>"></c:set>

<!--//region your codes 1-->
<div class="table-responsive">
    <table class="table table-condensed table-hover table-striped table-bordered">
        <thead>
        <tr>
            <th width="30px">序号</th>
            <th nowrap="nowrap" width="70px">任务名称</th>
            <th nowrap="nowrap" width="70px">触发器KeyName</th>
            <th nowrap="nowrap" width="70px">实例状态</th>
            <th nowrap="nowrap" width="70px">实例开始时间</th>
            <th nowrap="nowrap" width="70px">实例结束时间</th>
            <th nowrap="nowrap" width="70px">实例运行结果</th>
            <th nowrap="nowrap" width="70px">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr>
                <td>${status.index+1+(command.paging.pageNumber-1)*command.paging.pageSize}</td>
                <td>${p.jobName}</td>
                <td>${p.triggerKeyName}</td>
                <td>${dicts.taskschedule.runRecordStatus[p.status]}</td>
                <td>${soulFn:formatDateTz(p.beginTime, DateFormat.DAY_SECOND, timeZone)}</td>
                <td>${soulFn:formatDateTz(p.endTime, DateFormat.DAY_SECOND, timeZone)}</td>
                <td>${dicts.taskschedule.runRecordResult[p.result]}</td>
                <td>${p.remark}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<soul:pagination  mode="simple"/>
<!--//endregion your codes 1-->
