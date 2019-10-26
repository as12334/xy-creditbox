<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<html lang="zh-CN">
<head>
    <title>域名编辑</title>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>

<form:form id="editDomainForm" method="post">
    <lb:token/>
    <input type="hidden" name="result.id" value="${command.result.id}"/>
    <lb:validateRule/>
    <div class="modal-body">
        <div class="form-group clearfix">
            <label class="col-xs-3 al-right line-hi34" for="result.name"><span class="co-red m-r-sm">*</span>名称：</label>
            <div class="col-xs-9">
                <input id="result.name" name="result.name" class="form-control m-b-xs" type="text" value="${command.result.name}" aria-required="true" aria-invalid="true"/>
            </div>
        </div>
            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34">模板名称：</label>
                <div class="col-xs-9">
                    <input id="result.templateCode" name="result.templateCode" class="form-control m-b-xs" type="text" value="${command.result.templateCode}" aria-required="true" aria-invalid="true"/>
                </div>
            </div>
            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34">主题名称：</label>
                <div class="col-xs-9">
                    <input id="result.theme" name="result.theme" class="form-control m-b-xs" type="text" value="${command.result.theme}" aria-required="true" aria-invalid="true"/>
                </div>
            </div>
        <%--默认域名--%>
        <div class="form-group clearfix isDefault" >
            <label class="col-xs-3 al-right" >${views.content['domain.defaultDomain']}：</label>
            <div class="col-xs-9">
                <label><input type="checkbox" id="isDefault" value="${command.result.isDefault?'true':'false'}">${views.content['domain.setDefault']}</label>
                <input hidden name="result.isDefault" value="">
            </div>
        </div>

    </div>
    <div class="modal-footer">
        <soul:button target="${root}/account/domain/persistDomain.html?result.id=${command.result.id}" post="getCurrentFormData" precall="saveDomain" text="${views.common['confirm']}" opType="ajax" dataType="json" cssClass="btn btn-filter" callback="saveCallbak" tag="button"/>
        <soul:button cssClass="btn btn-outline btn-filter" target="closePage" text="取消" opType="function"/>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/account/domain/Edit"/>
</html>