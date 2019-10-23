<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%@ page import="java.util.Date" %>
<form:form id="mhSiteViewForm" action="${root}/site/merchantSiteDetail/viewSiteMerchant.html?search.id=${getSiteId}"
           method="post">
    <div class="row">
        <c:set var="p" value="${command.result}"/>
        <input type="hidden" name="getSiteId" value="${getSiteId}">
        <div class="position-wrap clearfix">
            <span>站点</span><span>/</span><span>商户站点</span><span>/</span><span>详情</span>
            <soul:button target="goToLastPage" cssClass="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn" text="" opType="function">
                <em class="fa fa-caret-left"></em>${views.common['return']}
            </soul:button>
        </div>
        <div class="col-lg-12">
            <ul class="clearfix sys_tab_wrap">
                <li id="li_top_1" class="${empty command.search.type || command.search.type eq '1'?'active':''}"><a id="" href="/site/merchantSiteDetail/viewSiteMerchant.html?search.id=${getSiteId}&search.type=1" nav-target="mainFrame">站点信息</a></li>
                <li id="li_top_2" class="${command.search.type eq '2'?'active':''}"><a  href="/site/merchantSiteDetail/viewSiteMerchant.html?search.id=${getSiteId}&search.type=2" nav-target="mainFrame">站点参数</a></li>
            </ul>
            <div class="wrapper white-bg clearfix shadow">
                <div class="panel blank-panel">
                    <div class="domainTab">
                        <div class="panel-options">
                            <ul class="nav nav-tabs p-l-sm p-r-sm">
                            </ul>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="tab-content" id="tab-content1">
                            <c:if test="${not empty p}">
                                <%@include file="ViewSiteBasic.jsp"%>
                            </c:if>
                            <c:if test="${empty p}">
                                该商户没有站点数据！
                            </c:if>
                        </div>

                        <div class="tab-content hide" id="tab-content2">
                        </div>
                        <div class="tab-content hide" id="tab-content3">
                        </div>
                        <div class="tab-content hide" id="tab-content4">
                        </div>
                        <div class="tab-content hide" id="tab-content5">
                        </div>
                        <div class="tab-content hide" id="tab-content6">
                        </div>
                        <div class="tab-content hide" id="tab-content7">
                        </div>
                        <div class="tab-content hide" id="tab-content8">
                        </div>
                        <div class="tab-content hide" id="tab-content9">
                        </div>
                        <div class="tab-content hide" id="tab-content10">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
<soul:import res="site/boss/site/company/detail/View"/>
