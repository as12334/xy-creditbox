<%--@elvariable id="command" type="${basepackage}.model.${module}.vo.${table.className}Vo"--%>
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
		<div class="">${table.remarks}</div>
		<table class="table table-condensed table-hover table-bordered">
		<#list table.viewColumns as item>
		<#if item_index%2 == 0>
			<tr>
		</#if>
				<td>${item.remarks}</td>
				<td>${'$'}{command.result.${item.columnNameLower}}</td>
		<#if (item_index%2 == 0) && (item_has_next == false)>
				<td></td>
				<td></td>
			</tr>
		</#if>
		<#if item_index%2 == 1>
			</tr>
		</#if>
		</#list>
		</table>
	</div>
	<!--//endregion your codes 3-->
</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import type="view"/>
<!--//endregion your codes 4-->
</html>