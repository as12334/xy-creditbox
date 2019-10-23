
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<form:form action="${root}/siteConfineArea/merchantConfineAreaList.html?search.siteId=${command.search.siteId}" method="post" id="merchantMainFrameArea">
    <div class="row">
        <div class="position-wrap clearfix">
            <span>站点</span><span>/</span><span>商户站点</span>
            <span>/</span><span>黑名单</span>
            <a href="/site/siteMerChant/list.html" nav-target="mainFrame"
               class="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn">
                <em class="fa fa-caret-left"></em>${views.common['return']}</a>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
                <!--筛选条件-->
                <div class="clearfix filter-wraper border-b-1">
                    <div class="btn-group pull-right m-r-n-xs content-width-limit-400">
                        <div class="input-group">
                            <div class="col-xs-4">
                                <div>
                                    <lb:select name="search.nation" prompt="${views.common['pleaseSelect']}"
                                               ajaxListPath="${root}/regions/list.html" listValue="remark"
                                               listKey="dictCode" relSelect="search.province"
                                               cssClass="btn-group chosen-select-no-single"/>
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div>
                                    <lb:select name="search.province" prompt="${views.common['pleaseSelect']}"
                                               relSelectPath="${root}/regions/states/#search.nation#.html"
                                               listValue="remark" listKey="dictCode"
                                               cssClass="btn-group chosen-select-no-single" relSelect="search.city"/>
                                </div>
                            </div>
                            <div class="col-xs-4">
                                <div>
                                    <lb:select name="search.city" prompt="${views.common['pleaseSelect']}"
                                               relSelectPath="${root}/regions/cities/#search.nation#-#search.province#.html"
                                               listValue="remark" listKey="dictCode"
                                               cssClass="btn-group chosen-select-no-single"/>
                                </div>
                            </div>
                            <input id="searchIp" class="form-control" type="hidden" name="search.searchIp" placeholder="${views.common['pleaseEnter']}IP">
                                <span class="input-group-btn">
                                <soul:button target="query" opType="function" text="${views.common['query']}"
                                             cssClass="btn btn-filter">
                                    <i class="fa fa-search"></i><span class="hd">&nbsp;${views.common['query']}</span>
                                </soul:button>
                            </span>
                        </div>
                    </div>
                </div>
                <!--表格内容-->
                <div class="search-list-container" id="tab-content">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
    </div>
    </div>
</form:form>
<soul:import res="site/boss/site/company/area/Index"/>
