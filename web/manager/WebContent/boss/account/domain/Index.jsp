<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->
<div class="row">
    <form:form id="domainForm" action="${root}/account/domain/list.html" method="post">
        <lb:validateRule/>
        <lb:token/>
        <div class="position-wrap clearfix">
            <span>站点</span><span>/</span>
            <span>域名管理</span>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow clearfix">
                <div class="m-t-md">
                    <div class="m-b-xs clearfix">
                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon bg-gray">站点ID</span>
                                <input type="text" autocomplete="off" class="form-control list-search-input-text" name="search.siteId" value="${command.search.siteId}">
                            </div>
                        </div>
                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <select name="searchType" id="searchType" style="display: none;" class="bg-gray bdn input-group-addon chosen-select-no-single valid" aria-invalid="false">
                                    <option value="search.name">名称</option>
                                    <option value="search.domain">域名</option>
                                </select>
                                <input class="form-control" id="searchInput" autocomplete="off" type="text" name="search.name">
                            </div>
                        </div>
                        <soul:button target="query" opType="function" text="搜索" cssClass="btn btn-filter m-l-lg">
                            <i class="fa fa-search "></i>
                            <spen>搜索</spen>
                        </soul:button>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-lg-12 m-t">
            <div class="wrapper white-bg shadow">
                <div class="search-list-container">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
    </form:form>
</div>

<soul:import res="site/boss/account/domain/Index"/>
