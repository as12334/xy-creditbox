<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
<form:form>
    <input type="hidden" name="search.siteId" value="${siteId}">
    <input type="hidden" name="search.status" value="${status}">
    <%--<div id="validateRule" style="display: none">${validateRule}</div>--%>
    <div class="modal-body">
        <div class="m-b">${views.setting['下架API']}</div>
        <div class="m-t-xs">
            <div class="input-group">
                <c:forEach items="${command.result}" var="p" varStatus="status">
                    <label style="padding: 0 10px;">
                        <input type="checkbox"  class="i-checks" name="siteLottery" value="${p.id}">${dicts.lottery.lottery[p.code]}
                    </label>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" precall="" text="${views.common.OK}" opType="ajax"
                     target="${root}/siteLottery/saveTakeOff.html" dataType="json" post="getCurrentFormData"
                     callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" opType="function" target="closePage" text="${views.common['cancel']}"/>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/lottery/manage/Edit"/>
</html>