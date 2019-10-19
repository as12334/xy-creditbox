<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

    <!--//region your codes 2-->
<form:form action="${root}/exports/exportHistoryList.html" method="post">
<div class="position-wrap clearfix">
    <span>${views.sysResource['系统设置']}</span><span>/</span><span>导出任务列表</span>
    <span id="returnBtn"><soul:button target="goToLastPage" refresh="true" cssClass="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn" text="" opType="function"><em class="fa fa-caret-left"></em>返回</soul:button></span>

</div>

    <div class="row">
    <div class="col-lg-12">
        <div class="wrapper white-bg shadow">
            <!--筛选条件-->
            <div class="clearfix filter-wraper border-b-1">
                <div class="function-menu-show hide">
                    <soul:button target="${root}/exports/batchDelete.html" precall="valiSelected"
                                 post="getSelectIds" text="${views.common.delete}"
                                 cssClass="btn btn-danger-hide _delete" opType="ajax" dataType="json" confirm="您确定要删除这些记录吗？" callback="query"><i class="fa fa-trash-o"></i><span class="hd">${views.common['delete']}</span></soul:button>
                </div>
                <div class="search-wrapper btn-group pull-right m-r-n-xs">
                    <soul:button target="query" opType="function" text="" cssClass="btn btn-filter pull-right btn-export-list-search"><i class="fa fa-refresh"></i><span class="hd">&nbsp;${views.common['refresh']}</span></soul:button>
                </div>
            </div>

            <!--表格内容-->
            <div id="editable_wrapper" class="dataTables_wrapper search-list-container" role="grid">
                <%@ include file="IndexPartial.jsp" %>
            </div>
        </div>
    </div>
    </div>
    <!--//endregion your codes 2-->
</form:form>

<!--//region your codes 3-->
<soul:import res="lotterybox/share/Index"/>
<!--//endregion your codes 3-->