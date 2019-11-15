<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <%@ include file="/include/include.head.jsp" %>
    <style>
        .modal-body {
            overflow-y: auto;
        }
    </style>
</head>
<body>
<div class="modal-body">
    <form id="taskRunRecordListForm" action="${root}/taskRunRecord/list.html?search.taskScheduleId=${command.search.taskScheduleId}" method="post">
        <lb:validateRule/>
        <lb:token/>
        <div class="form-group clearfix pull-left content-width-limit-200 m-t-sm">
            <div class="input-group">
                <span class="input-group-addon abroder-no"><b>任务名称：</b></span>
                <input name="search.jobName" class="form-control" placeholder="请输入任务名称"/>
            </div>
        </div>
        <%--<div class="form-group clearfix pull-left content-width-limit-200 m-t-sm">--%>
            <%--<div class="input-group">--%>
                <%--<span class="input-group-addon abroder-no"><b>任务编码：</b></span>--%>
                <%--<input name="search.jobCode" class="form-control" placeholder="请输入任务编码"/>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="form-group clearfix pull-left content-width-limit-200 m-t-sm">
            <div class="input-group">
                <soul:button target="query" opType="function" text="查询" cssClass="btn btn-default" />
            </div>
        </div>
        <div class="search-list-container">
            <%@include file="IndexPartial.jsp" %>
        </div>
    </form>
</div>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/ops/taskschedule/Index"/>
</html>
