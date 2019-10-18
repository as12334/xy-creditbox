<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<style>
    table th,table td {
        text-align: center;
    }
    table th{
        font-weight: bold;
    }
</style>
<div class="row">
    <form:form id="vuserPlayerForm" action="${root}//merchant/account/player/reportList.html?search.type=${command.search.type}" method="post">
        <lb:validateRule/>
        <lb:token></lb:token>
        <input type="hidden" name="actionSearch" value="query">
        <input type="hidden" name="search.id" value="${command.search.id}"/>
        <div class="position-wrap clearfix">
            <span>账号</span><span>/</span><span>新增玩家列表</span>
            <soul:button tag="a" target="goToLastPage" text="" opType="function" cssClass="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn">
                <em class="fa fa-caret-left"></em>返回
            </soul:button>
        </div>
       <%-- <div class="col-lg-12">
            <div class="wrapper white-bg shadow clearfix fix_1px">
                <div class="m-t-md">
                    <div class="m-b-xs clearfix">
                        <div class="col-sm-12 clearfix" style="padding-left: 10px;">
                            <soul:button tag="button" cssClass="btn btn-export-btn btn-primary-hide"
                                         text="${views.common['export']}" callback="gotoExportHistory"
                                         precall="validExportCount" post="getCurrentFormData" title="${views.role['player.dataExport']}"
                                         target="${root}/merchant/account/player/export.html?search.type=${command.search.type}" opType="ajax">
                                <i class="fa fa-sign-out"></i><span class="hd">${views.common['export']}</span>
                            </soul:button>
                        </div>
                    </div>
                </div>

            </div>
        </div>--%>

        <div class="col-lg-12 m-t">
            <div class="wrapper white-bg shadow">
                <div class="search-list-container">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
    </form:form>
</div>

<soul:import res="site/home/report/member/Index" />