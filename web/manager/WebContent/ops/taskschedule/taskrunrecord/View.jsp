<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

<html lang="zh-CN">
<head>
	<title>详情</title>
	<%@ include file="/include/include.head.jsp" %>
	<!--//region your codes 2-->

	<!--//endregion your codes 2-->
</head>
<body>
	<!--//region your codes 3-->
	<div class="table-responsive">
		<div class="">任务运行结果</div>
		<table class="table table-condensed table-hover table-bordered">
			<tr>
				<td>任务id</td>
				<td>${command.result.taskScheduleId}</td>
				<td>任务名称</td>
				<td>${command.result.jobName}</td>
			</tr>
			<tr>
				<td>触发器KeyName</td>
				<td>${command.result.triggerKeyName}</td>
				<td>任务实例状态 1、运行中 2、已结束</td>
				<td>${command.result.status}</td>
			</tr>
			<tr>
				<td>任务实例开始时间</td>
				<td>${command.result.beginTime}</td>
				<td>任务实例结束时间</td>
				<td>${command.result.endTime}</td>
			</tr>
			<tr>
				<td>任务实例运行结果 1、成功 2、失败</td>
				<td>${command.result.result}</td>
				<td>备注</td>
				<td>${command.result.remark}</td>
			</tr>
		</table>
	</div>
	<!--//endregion your codes 3-->
</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import type="view"/>
<!--//endregion your codes 4-->
</html>