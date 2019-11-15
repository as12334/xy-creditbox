<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

<html lang="zh-CN">
<head>
    <title>${views.service['game.edit']}</title>
    <%@ include file="/include/include.head.jsp" %>

    <!--//region your codes 2-->
    <!--//endregion your codes 2-->
</head>

<style>
    body {
        font-family: 'Microsoft YaHei', "Helvetica Neue", Helvetica, Arial, sans-serif;
        font-size: 12px;
        color: #3d4346;
        overflow-x: hidden;
    }
</style>

<body>
<!--//region your codes 3-->
<form:form id="opsTaskscheduleForm" action="${root}/taskSchedule/edit.html" method="post">
    <form:hidden path="result.id" />
    <form:hidden path="result.isSystem" />
    <lb:validateRule/>
    <lb:token/>
    <div class="modal-body" style="max-height:460px;">
        <div id="editor">
            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" for="result.jobCode">
                    <span class="co-red m-r-sm">*</span>任务编码：</label>
                <div class="col-xs-4">
                    <input id="result.jobCode" name="result.jobCode" class="form-control m-b-xs" type="text" value="${command.result.jobCode}" aria-invalid="true"/>
                </div>
                <label class="col-xs-2 al-right line-hi34" for="result.jobName">
                    <span class="co-red m-r-sm">*</span>任务名称：</label>
                <div class="col-xs-4">
                    <input id="result.jobName" name="result.jobName" class="form-control m-b-xs" type="text" value="${command.result.jobName}"  aria-invalid="true"/>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" for="result.jobMethod">
                    <span class="co-red m-r-sm">*</span>任务方法名：</label>
                <div class="col-xs-4">
                    <input id="result.jobMethod" name="result.jobMethod" class="form-control m-b-xs" type="text" value="${command.result.jobMethod}"  aria-invalid="true"/>
                </div>
                <label class="col-xs-2 al-right line-hi34" for="result.cronexpression">
                    <span class="co-red m-r-sm">*</span>调度表达式：</label>
                <div class="col-xs-4">
                    <input id="result.cronexpression" name="result.cronexpression" class="form-control m-b-xs" type="text" value="${command.result.cronexpression}"  aria-invalid="false"/>
                </div>
            </div>

            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" for="result.scheduler">
                    <span class="co-red m-r-sm">*</span>Quartz调度器：</label>
                <div class="col-xs-4">
                    <lb:select name="result.scheduler" value="${command.result.scheduler}" prompt="请选择"
                               list="${taskSchedules}" listValue="trans" listKey="code" optionDirection="up"
                               cssClass="form-control m-b-xs"/>
                </div>
                <label class="col-xs-2 al-right line-hi34" for="result.belongToIdc">
                    <span class="co-red m-r-sm">*</span>任务机房：</label>
                <div class="col-xs-4">
                    <input id="result.belongToIdc" name="result.belongToIdc" class="form-control m-b-xs" type="text" value="${command.result.belongToIdc}"  aria-invalid=""/>
                </div>
            </div>

            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34">
                    <span class="co-red m-r-sm">*</span>参数值json串：</label>
                <div class="col-xs-4">
                    <div id="jobMethodArgDiv" style="display:none;">${command.result.jobMethodArg}</div>
                    <input id="jobMethodArg" name="result.jobMethodArg" class="form-control m-b-xs" type="text" value=""/>
                </div>
                <label class="col-xs-2 al-right line-hi34" style="width: 142px;" for="result.jobMethodArgClass">
                    <span class="co-red m-r-sm">*</span>参数className:</label>
                <div class="col-xs-4">
                    <input id="result.jobMethodArgClass" name="result.jobMethodArgClass" class="form-control m-b-xs" type="text" value="${command.result.jobMethodArgClass}"/>
                </div>
            </div>

            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" >
                    <span class="co-red m-r-sm">*</span>是否同步：</label>
                <div class="col-xs-4">
                    <label><input type="radio" class="i-checks status" value="true" name="result.isSync" <c:if test="${command.result.isSync}">checked</c:if>>同步</label>
                    <label><input type="radio" class="i-checks status" value="false" name="result.isSync" <c:if test="${!command.result.isSync}">checked</c:if>>异步</label>
                </div>
                <label class="col-xs-2 al-right line-hi34" >
                    <span class="co-red m-r-sm">*</span>是否本地方法：</label>
                <div class="col-xs-4">
                    <label><input type="radio" class="i-checks status" value="true" name="result.isLocal" <c:if test="${command.result.isLocal}">checked</c:if>>是</label>
                    <label><input type="radio" class="i-checks status" value="false" name="result.isLocal" <c:if test="${!command.result.isLocal}">checked</c:if>>否</label>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" for="result.jobClass">
                    <span class="co-red m-r-sm">*</span>CLASS全路径：</label>
                <div class="col-xs-10">
                    <input id="result.jobClass" name="result.jobClass" class="form-control m-b-xs" type="text" value="${command.result.jobClass}"  aria-invalid="true"/>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-xs-2 al-right line-hi34" for="result.description">
                    <span class="co-red m-r-sm"></span>任务描述：</label>
                <div class="col-xs-10">
                    <input id="result.description" name="result.description" class="form-control m-b-xs" type="text" value="${command.result.description}"  aria-invalid="true"/>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" text="保存" opType="ajax" dataType="json"  target="${root}/taskSchedule/persist.html"  post="getCurrentFormData" precall="validateForm" callback="saveCallbak" />
        <soul:button cssClass="btn btn-outline btn-filter" opType="function" target="closePage"
                     text="${views.common['cancel']}"/>
    </div>



</form:form>

</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import res="site/ops/taskschedule/Edit"/>
<!--//endregion your codes 4-->
</html>