<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<style>
    table th,table td {
        text-align: center;
    }
    table th {
        font-weight: bold;
    }
</style>
<form:form name="vbillChangeForm" action="${root}/fund/billChange/list.html" method="post">
    <div class="row">
        <lb:validateRule/>
        <lb:token/>
        <div class="position-wrap clearfix">
            <span>账号</span><span>/</span><span>首存列表</span>
                <soul:button target="goToLastPage" refresh="" cssClass="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn" text="" opType="function">
                    <em class="fa fa-caret-left"></em>返回
                </soul:button>
            <a href="javascript:void(0)" class="pull-right siteMap"><i class="fa fa-sitemap"></i></a>
        </div>

        <div class="col-lg-12">
            <div class="wrapper white-bg shadow clearfix fix_1px">
                <div class="m-t-md">
                    <div class="m-b-xs clearfix">
                        <div class="col-sm-12 clearfix" style="padding-left: 10px;">
                            <soul:button tag="button" cssClass="btn btn-export-btn btn-primary-hide"
                                         text="${views.common['export']}" callback="gotoExportHistory"
                                         precall="validExportCount" post="getCurrentFormData" title="${views.role['player.dataExport']}"
                                         target="${root}/fund/billChange/export.html" opType="ajax">
                                <i class="fa fa-sign-out"></i><span class="hd">${views.common['export']}</span>
                            </soul:button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-lg-12 m-t">
            <div class="wrapper">
                <div class="dataTables_wrapper search-list-container">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>

    </div>
</form:form>

<script type="text/javascript">
    curl(["site/merchant/fund/billChange/Index"], function(Page) {
        page =new Page();
        page.bindButtonEvents();
    });
</script>
