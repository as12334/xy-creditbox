<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑</title>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
<form name="resetPwdEditForm">
    <div class="modal-body">
        <lb:validateRule/>
        <input type="hidden" name="search.id" value="${command.search.id}"/>
        <div class="m-b-sm">账号：<span class="co-blue">${fn:substringBefore(command.result.username,'@')}</span></div>
        <div class="condition-options-wraper">
            <div class="form-group">
                <label><span class="co-red m-r-sm">*</span>新登录密码：</label>
                <input type="password" name="pwd" id="pwd" class="form-control">
            </div>
            <div class="form-group">
                <label><span class="co-red m-r-sm">*</span>确认登录密码：</label>
                <input type="password" name="confirmPwd" id="confirmPwd" class="form-control">
            </div>
            <br>
            <%--<div class="form-group">
                <label>新安全密码:</label>
                <input type="password" name="permissionPwd" id="permissionPwd" class="form-control">
            </div>
            <div class="form-group">
                <label>确认安全密码:</label>
                <input type="password" name="confirmPermissionPwd" id="confirmPermissionPwd" class="form-control">
            </div>--%>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button target="${root}/boss/account/companies/updateShPwd.html" post="getCurrentFormData" precall="validateForm" text="确认" opType="ajax" dataType="json" cssClass="btn btn-filter" callback="saveCallbak" tag="button"/>
        <soul:button cssClass="btn btn-outline btn-filter" target="closePage" text="取消" opType="function"/>
    </div>
</form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/account/companies/ResetPwd"/>
</html>