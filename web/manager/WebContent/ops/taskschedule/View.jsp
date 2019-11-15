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
		<div class=""><h4>任务调度实体</h4></div>
		<table class="table table-condensed table-hover table-bordered">
			<tr>
				<td style="width: 150px">任务名称</td>
				<td class="td-width-150" title="${command.result.jobName}">${command.result.jobName}</td>
				<td  style="width: 150px">是否同步</td>
				<td style="width: 180px">${dicts.taskschedule.isSync[command.result.isSync.toString()]}</td>
			</tr>
			<tr>
				<td>任务编号</td>
				<td class="td-width-150" title="${command.result.jobCode}">${command.result.jobCode}</td>
				<td>是否本地方法</td>
				<td>${dicts.taskschedule.isLocal[command.result.isLocal.toString()]}</td>
			</tr>
			<tr>
				<td>任务class全路径</td>
				<td class="td-width-150" title="${command.result.jobClass}">${command.result.jobClass}</td>
				<td>是否内置</td>
				<td>${dicts.taskschedule.isSystem[command.result.isSystem.toString()]}</td>
			</tr>
			<tr>
				<td>任务方法名</td>
				<td class="td-width-150" title="${command.result.jobMethod}">${command.result.jobMethod}</td>
				<td>状态</td>
				<td>${dicts.taskschedule.status[command.result.status]}</td>
			</tr>
			<tr>
				<td>参数值json串</td>
				<td class="td-width-150" title="${command.result.jobMethodArg}">${command.result.jobMethodArg}</td>
				<td>调度表达式</td>
				<td class="td-width-150" title="${command.result.cronexpression}">${command.result.cronexpression}</td>
			</tr>
			<tr>
				<td>参数className</td>
				<td class="td-width-150" title="${command.result.jobMethodArgClass}">${command.result.jobMethodArgClass}</td>
				<td>创建时间</td>
				<td><fmt:formatDate value="${command.result.createTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<td>描述</td>
				<td class="td-width-150" title="${command.result.description}">${command.result.description}</td>
				<td>修改时间</td>
				<td><fmt:formatDate value="${command.result.updateTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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