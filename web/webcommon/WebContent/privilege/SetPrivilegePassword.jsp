<%--@elvariable id="command" type="org.soul.model.security.privilege.vo.SysUserVo"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
    <form:form>
    <lb:validateRule/>
    <!--修改密码-->
    <div class="modal-body">
        <div class="form-group clearfix line-hi34">
            <label for="result.permissionPwd" class="col-xs-3 al-right">${views.privilege['permissionPwd']}：</label>
            <div class="col-xs-8 p-x"><input type="password" class="form-control" name="result.permissionPwd"></div>
        </div>
        <div class="form-group clearfix line-hi34">
            <label for="confirmPermissionPwd" class="col-xs-3 al-right">${views.privilege['confirmPermissionPwd']}：</label>
            <div class="col-xs-8 p-x"><input type="password" class="form-control" name="confirmPermissionPwd"></div>
        </div>
        <div class="form-group clearfix line-hi34">
            <label for="result.password" class="col-xs-3 al-right">${views.privilege['loginPwd']}：</label>
            <div class="col-xs-8 p-x"><input type="password" placeholder="" class="form-control" name="result.password" maxlength="20"></div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" text="${views.common.OK}" opType="ajax" precall="validateForm" target="${root}/privilege/setPrivilegePassword.html" dataType="json" post="getCurrentFormData" callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" target="closePage" opType="function" text="${views.common.cancel}"/>
    </div>
    </form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="privilege/SetPrivilegePassword"/>
</html>