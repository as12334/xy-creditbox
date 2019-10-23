<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="row">
    <form:form action="${root}/site/siteCompany/list.html" method="post" id="mhSiteManagerForm">
        <lb:validateRule/>
        <div class="position-wrap clearfix">
            <span>站点</span><span>/</span>
            <span>商户站点</span>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow clearfix">
                <div class="m-t-md">
                    <div class="m-b-xs clearfix">

                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon bg-gray">商户账号：</span>
                                <input type="text" autocomplete="off" class="form-control" name="search.username" style="margin-right: 50px;">
                            </div>
                        </div>

                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon bg-gray">站点名称：</span>
                                <input type="text" autocomplete="off" class="form-control" id="searchtext" name="search.siteName"
                                       style="margin-right: 50px;">
                            </div>
                        </div>
                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon abroder-no"><b></b></span>
                                <soul:button cssClass="btn btn-filter" precall="" tag="button" opType="function"
                                             text="查询" target="query">
                                    <i class="fa fa-search"></i><span class="hd">&nbsp;查询</span>
                                </soul:button>
                            </div>
                        </div>
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
<soul:import res="site/boss/site/company/Index"/>
