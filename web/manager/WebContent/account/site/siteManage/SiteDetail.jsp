<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<form:form id="actionSiteDetailForm" action="" method="post">
    <div class="row">
        <div class="position-wrap clearfix">
            <span>账户</span><span>/</span><span>站点详细</span>
            <soul:button tag="a" target="goToLastPage" text="" opType="function"
                         cssClass="returnSuperior m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn">
                <input hidden name="lastTimeSearch" value="${lastTimeSearch}">
                <em class="fa fa-caret-left"></em>${views.common['return']}
            </soul:button>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
                <%@include file="siteBasicDetail.jsp" %>
                <c:if test="${currentUserType eq '2' || currentUserType eq '21'}">
                    <%@include file="siteNetSchemeDetail.jsp" %>
                    <%@include file="siteTemplateDetail.jsp" %>
                </c:if>
            </div>
        </div>
    </div>
    <soul:import res="site/account/account/AccountSiteDetail"/>
</form:form>
