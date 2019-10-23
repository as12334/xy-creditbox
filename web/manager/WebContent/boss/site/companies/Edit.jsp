<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>${views.common['edit']}</title>
    <%@ include file="/include/include.head.jsp" %>
</head>

<body>
<form:form method="post" id="siteShareHolderEdit">
    <lb:validateRule/>

    <form:input type="hidden" path="result.id" value="${result.id}"/>
    <div class="modal-body">
        <div class="form-group over clearfix">
            <label class="col-xs-3 al-right line-hi34">备注：</label>
            <div class="input-group m-b col-xs-9">
                <form:textarea class="form-control" path="result.remark" value="${result.remark}"></form:textarea>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button precall="validateForm" cssClass="btn btn-filter"
                     callback="saveCallbak" text="${views.common['save']}"
                     opType="ajax" dataType="json" target="${root}/site/siteShareHolder/updateShareHolder.html"
                     post="getCurrentFormData"/>
        <soul:button target="closePage" text="${views.common['cancel']}" returnValue="false"  cssClass="btn btn-outline btn-filter" opType="function"/>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/site/companies/Edit"/>
</html>