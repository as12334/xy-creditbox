
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
</head>
<body>
    <form:form id="bossDistributorAddForm">
        <lb:validateRule/>
        <lb:token/>
            <form:hidden path="result.id"/>
            <input hidden name="result.siteId" value="${command.search.siteId}">
            <input hidden name="result.sysUserId" value="${sysUserId}">
        <div class="modal-body">
            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34" for="result.domain">${views.content['domain.name']}：</label>
                <div class="col-xs-9">
                    <form:input path="result.name" cssClass="form-control m-b-xs"/>
                </div>
            </div>
            <%--<div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34" >选择总代：</label>
                <div class="col-xs-9">
                    <select class="form-control list-search-input-text"  id="result.ownerId" name="result.ownerId" >
                        <c:forEach items="${agentList.result}" var="sh">
                            <option value="${sh.id}">${empty fn:substringBefore(sh.username,'@')?sh.username:fn:substringBefore(sh.username,'@')}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>--%>

            <div class="form-group clearfix">
                <label class="col-xs-3 al-right line-hi34">${views.content['domain.tgym']}：</label>
                <div class="col-xs-9">
                    <form:textarea path="result.domain" cssClass="form-control m-b-xs resize-vertical text-lowercase" readonly="${command.result.id ne null?true:''}"></form:textarea>

                    <div class="co-grayc2">${views.content['domain.tgym.prompt']}</div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <soul:button target="${root}/account/domain/addDistributorDomain.html" callback="saveCallbak" post="getCurrentFormData"  precall="validateForm" text=""   opType="ajax" dataType="json" cssClass="btn btn-filter _search" tag="button">${views.common['confirm']}</soul:button>
            <soul:button target="closePage" text="取消" opType="function" cssClass="btn btn-outline btn-filter" tag="button">${views.common['cancel']}</soul:button>
        </div>
    </form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/account/domain/DistributorEdit"/>
</html>
