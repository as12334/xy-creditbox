<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<form:form id="bulidSiteSuccessForm" action="" method="post">
    <div class="row">
        <div class="position-wrap clearfix">
            <span>账户</span><span>/</span><span>新增站点</span>
        </div>

        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
<%--
                <%@include file="Flow.jsp" %>
--%>
                <div class="fundsContext step-finish p-b-lg clearfix">
                    <div class="col-xs-5 al-right">
                        <i class="success fa fa-smile-o"></i>
                    </div>
                    <div class="col-xs-7">
                        <div class="success p-t-sm"> 建站成功!</div>
                    </div>
                </div>
             <%--   <div class="m-lg">
                    <div class="gray-chunk  clearfix">
                        <dd class="pull-left p-xs">
                            <b> 临时管理中心地址：</b>
                            <span class="m-l-xs">${command.manageDomain}</span>
                        </dd>
                        <dd class="pull-left text-oflow-20">
                            <a data-clipboard-target="p0_manageDomain" class="btn btn-filter btn-sm m-t-xs"
                               data-clipboard-text="${command.manageDomain}" name="copy">${views.common['copy']}</a>
                        </dd>
                    </div>
                    <div class="line-hi34">
                        <span class="co-yellow"><i class="fa fa-exclamation-circle"></i></span>
                        有效期15天，过期将停用站点！
                    </div>
                </div>--%>

                <div class="operate-btn">
                    <a href="/boss/account/merchant/merchantList.html" nav-target="mainFrame" class="btn btn-outline btn-filter btn-lg"> 返回列表</a>
                </div>
            </div>
        </div>
    </div>
</form:form>
<soul:import res="site/account/site/siteManage/View"/>