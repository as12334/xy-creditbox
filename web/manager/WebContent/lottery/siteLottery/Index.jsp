<%--@elvariable id="command" type="so.wwb.gamebox.model.company.site.vo.VSiteApiTypeListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

<!--//region your codes 2-->

<div class="row">

    <div class="position-wrap clearfix">
        <h2><a class="navbar-minimalize" href="javascript:void(0)"><i class="icon iconfont">&#xe610;</i> </a></h2>
        <span>站点服务</span><span>/</span><span>站点彩票管理</span>
    </div>

    <form:form action="${root}/siteLottery/list.html" method="post">
        <%--<form:hidden path="validateRule" />--%>
        <div id="validateRule" style="display: none">${validateRule}</div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
                <div class="clearfix filter-wraper border-b-1">
                    <div class="form-group clearfix pull-left content-width-limit-30 m-t-sm m-b-none">
                        <div class="input-group">
                            <span class="input-group-addon abroder-no"><b>站点ID：</b></span>
                            <input id="singleVal" class="form-control search" type="text" name="search.siteId">
                        </div>
                    </div>

                    <div class="form-group clearfix pull-left content-width-limit-50">
                        <div class="form-group clearfix m-t-sm m-b-none">
                            <span style="display: inline-block;width: 10px;height: 10px;"></span>
                            <soul:button precall="validateForm" target="query" opType="function" text="${views.common['query']}" cssClass="btn btn-filter" />
                        </div>
                    </div>

                </div>
                <div id="editable_wrapper" class="dataTables_wrapper search-list-container" role="grid">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
    </form:form>
</div>

<!--//endregion your codes 2-->


<!--//region your codes 3-->
<soul:import res="site/lottery/site/Index"/>
<!--//endregion your codes 3-->