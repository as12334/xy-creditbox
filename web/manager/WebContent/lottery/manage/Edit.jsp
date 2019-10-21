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

<body>
<!--//region your codes 3-->
<form:form id="lotteryEditForm" action="${root}/api/saveManage.html" method="post">
    <div class="modal-body">
        <div id="editor">
            <div class="clearfix m-t-xs line-hi34">
                <label class="ft-bold col-xs-4 al-right">状态：</label>
                <form:hidden path="result.id" ></form:hidden>
                <div class="col-xs-8 p-x line-hi34">
                    <label><input type="radio" class="i-checks status" value="normal" name="result.status" <c:if test="${command.result.status=='normal'}">checked</c:if> > 正常</label>
                    <label><input type="radio" class="i-checks status" value="maintain" name="result.status" <c:if test="${command.result.status=='maintain'}">checked</c:if> > 维护</label>
                    <label><input type="radio" class="i-checks status" value="disable" name="result.status" <c:if test="${command.result.status=='disable'}">checked</c:if> > 停用</label>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer" >
        <soul:button cssClass="btn btn-filter confirm-btn" text="确认"
                     opType="ajax" target="${root}/lottery/manage/changeLotteryStatus.html" post="getCurrentFormData" callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" opType="function" target="closePage" text="取消"/>
    </div>
</form:form>
<!--//endregion your codes 3-->
</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import res="site/lottery/manage/Edit"/>
<!--//endregion your codes 4-->
</html>