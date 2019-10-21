<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
<form:form id="lotteryEditForm">
    <input type="hidden" name="search.siteId" value="${siteId}">
    <div id="validateRule" style="display: none">${validateRule}</div>
    <div class="modal-body">
        <div class="m-b">${views.setting['同步API']}</div>
        <div class="m-t-xs">
            <soul:button cssClass="btn btn-filter" target="selectAll" text="全选" opType="function"/>
            <soul:button cssClass="btn btn-filter" target="selectNoAll" text="全不选" opType="function"/>
            <hr>
            <div class="input-group">
                <c:forEach items="${lottery.result}" var="p" varStatus="status">
                    <c:if test="${empty siteLotteryMap[p.code]}">
                        <label style="padding: 0 10px;">
                            <input type="checkbox"  class="i-checks" name="siteLottery" value="${p.id}">${lotteryEnums[p.code]}
                        </label>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" precall="validateForm" text="确认" opType="ajax"
                     target="${root}/siteLottery/saveSync.html" dataType="json" post="getCurrentFormData"
                     callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" opType="function" target="closePage" text="取消"/>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/lottery/manage/Edit"/>
</html>