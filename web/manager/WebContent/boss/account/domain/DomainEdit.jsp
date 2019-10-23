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
            <label class="col-xs-3 al-right line-hi34">域名类型：</label>
            <div class="col-xs-8">
                <div class="input-group date">
                    <lb:selectPure callback="checkHall" cssStyle="width: 300px" cssClass="btn-group chosen-select-no-single"
                                   name="result.subsysCode" value="${command.result.subsysCode}" list="${subSysCodes}"
                                   listKey="code" listValue="trans"/>
                </div>
            </div>
        </div>
        <div class="form-group clearfix">
            <label class="col-xs-3 al-right line-hi34" for="result.name">名称：</label>
            <div class="col-xs-9">
                <input id="result.name" name="result.name" class="form-control m-b-xs" type="text"
                       value="${command.result.name}" aria-required="true" aria-invalid="true"/>
            </div>
        </div>


        <c:choose>
            <c:when test="${empty command.result.id}">
                <div class="form-group clearfix">
                    <label class="col-xs-3 al-right line-hi34" for="result.domain">线路域名：</label>
                    <div class="col-xs-9">
                        <div class="form-group m-t-sm">
                            <textarea id="result.domain" name="result.domain"
                                      class="form-control m-b">${command.result.domain}</textarea>
                        </div>
                        <div class="co-grayc2"> 域名不需要添加“http://",也不要以"/"结尾,例如:lb.zh.com<br>多个域名，请用半角逗号“,”隔开</div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <form:hidden path="result.domain"/>
                <div class="form-group clearfix">
                    <label class="col-xs-3 al-right line-hi34" for="result.domain">线路域名：</label>
                    <div class="col-xs-9">
                        <div class="form-group m-t-sm">
                            <textarea disabled name="result.domain" class="form-control m-b">${command.result.domain}</textarea>
                        </div>
                        <div class="co-grayc2"> 域名不需要添加“http://",也不要以"/"结尾,例如:lb.zh.com<br>多个域名，请用半角逗号“,”隔开</div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
    </div>
    <div class="modal-footer">
        <c:choose>
            <c:when test="${empty command.result.id}">
                <soul:button target="${root}/account/domain/persist.html?result.siteId=${domainSiteId}"
                             post="getCurrentFormData" precall="validateForm" text="" opType="ajax" dataType="json"
                             cssClass="btn btn-filter _search" callback="saveCallbak"
                             tag="button">${views.common['confirm']}</soul:button>
            </c:when>
            <c:otherwise>
                <soul:button target="${root}/account/domain/persistDomain.html?result.siteId=${domainSiteId}"
                             post="getCurrentFormData" precall="validateForm" text="" opType="ajax" dataType="json"
                             cssClass="btn btn-filter _search" callback="saveCallbak"
                             tag="button">${views.common['confirm']}</soul:button>
            </c:otherwise>
        </c:choose>
        <soul:button cssClass="btn btn-outline btn-filter" target="closePage" text="取消" opType="function"/>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import res="site/boss/account/domain/DomainEdit"/>
</html>