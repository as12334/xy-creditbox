
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
    <form:form id="bossShareholderAddForm">
        <lb:validateRule/>
        <lb:token/>
            <form:hidden path="result.id"/>
            <input hidden name="result.siteId" value="${command.search.siteId}">
        <div class="modal-body">
            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34">${views.content['domain.name']}：</label>
                <div class="col-xs-9">
                    <form:input path="result.name" cssClass="form-control m-b-xs"/>
                </div>
            </div>
            <input hidden name="result.sysUserId" value="${command.search.sysUserId}">
            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34">${views.content['domain.tgym']}：</label>
                <div class="col-xs-9">
                    <form:textarea path="result.domain" cssClass="form-control m-b-xs resize-vertical text-lowercase" readonly="${command.result.id ne null?true:''}"></form:textarea>
                    <div class="co-grayc2">${views.content['domain.tgym.prompt']}</div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <soul:button target="${root}/account/domain/addShareholderDomain.html" callback="saveCallbak" post="getCurrentFormData"  precall="validateForm" text=""   opType="ajax" dataType="json" cssClass="btn btn-filter _search" tag="button">${views.common['confirm']}</soul:button>
            <soul:button target="closePage" text="取消" opType="function" cssClass="btn btn-outline btn-filter" tag="button">${views.common['cancel']}</soul:button>
        </div>
    </form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/account/domain/ShareHolderEdit"/>
</html>
