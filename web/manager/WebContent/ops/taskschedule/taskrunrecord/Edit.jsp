<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

<html lang="zh-CN">
<head>
    <title>编辑</title>
    <%@ include file="/include/include.head.jsp" %>
    <!--//region your codes 2-->

    <!--//endregion your codes 2-->
</head>

<body>

<form:form id="editForm" action="${root}/taskRunRecord/edit.html" method="post">
    <form:hidden path="result.id" />
    <lb:validateRule/>
    <lb:token/>
    <!--//region your codes 3-->
    <div class="">
        <soul:button cssClass="btn btn-default" text="保存" opType="ajax" dataType="json" target="${root}/taskRunRecord/persist.html" precall="validateForm" post="getCurrentFormData" callback="saveCallbak" />
        <soul:button cssClass="btn btn-default" text="删除" opType="ajax" dataType="json" target="${root}/taskRunRecord/delete.html?id=${result.id}" callback="deleteCallbak" confirm="您确定要删除该条记录吗？" />
    </div>

    <div class="table-responsive">
        <div class="">任务运行结果</div>
        <table class="table table-condensed table-hover table-bordered">
        </table>
    </div>
    <!--//endregion your codes 3-->

</form:form>

</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import type="edit"/>
<!--//endregion your codes 4-->
</html>