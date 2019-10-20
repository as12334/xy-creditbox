<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->

<!--//region your codes 2-->
<form:form action="${root}/vSiteApiTypeRelation/orderSiteApi.html?search.status=normal" method="post">
<div class="row">

    <div class="position-wrap clearfix">
        <h2><a class="navbar-minimalize" href="javascript:void(0)"><i class="icon iconfont">&#xe610;</i> </a></h2>
        <span>彩票管理</span><span>/</span><span>彩票种类</span>
        <soul:button target="goToLastPage" refresh="true" cssClass="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn" text="" opType="function">
            <em class="fa fa-caret-left"></em>返回
        </soul:button>
    </div>


    <div class="col-lg-12">
        <div class="wrapper white-bg shadow">

            <div class="clearfix filter-wraper border-b-1">
                <div class=" clearfix m-sm">
                    <i class="fa fa-exclamation-circle"></i><span class="co-yellow m-l-sm">可拖拽排序</span>
                </div>
            </div>
            <div id="editable_wrapper" class="dataTables_wrapper search-list-container" role="grid">
                <table class="table table-striped table-hover dataTable m-b-sm dragdd" aria-describedby="editable_info">
                    <thead>
                    <tr role="row" class="bg-gray">
                        <th width="100px">序号</th>
                        <th width="200px">彩种类型</th>
                        <th width="200px">彩种代号</th>
                        <th width="200px">彩种状态</th>
                    </tr>
                    <tr class="bd-none hide">
                        <th colspan="7">
                                <%-- <div class="select-records"><i class="fa fa-exclamation-circle"></i>${views.role['player.cancelSelectAll.prefix']}&nbsp;<span id="page_selected_total_record"></span>${views.role['player.cancelSelectAll.middlefix']}
                                     <soul:button target="cancelSelectAll" opType="function" text="${views.role['player.cancelSelectAll']}"/>${views.role['player.cancelSelectAll.suffix']}
                                 </div>--%>
                        </th>
                    </tr>
                    </thead>
                    <input type="hidden" name="siteId" value="${siteId}" class="td-handle2"/>
                    <tbody class="dd-list1">
                    <c:if test="${empty command.result}">
                        <td colspan="7" class="no-content_wrap">
                            <div>
                                <i class="fa fa-exclamation-circle"></i> 暂无记录
                            </div>
                        </td>
                    </c:if>
                    <c:forEach items="${command.result}" var="p" varStatus="status">
                        <tr class="tab-detail dd-item1">
                            <input type="hidden" name="lotteryId" value="${p.id}" class="td-handle1"/>
                            <td class="td-handle1">${status.index+1}</td>
                            <td class="td-handle1">${dicts.lottery.lottery_type[p.type]}(${p.type})</td>
                            <td class="td-handle1">${dicts.lottery.lottery[p.code]}(${p.code})</td>
                            <td class="td-handle1">
                                <c:if test="${p.status=='normal'}">
                                    <span class="label label-success">正常</span>
                                </c:if>
                                <c:if test="${p.status=='maintain'}">
                                    <span class="label label-warning">维护</span>
                                </c:if>
                                <c:if test="${p.status=='disable'}">
                                    <span class="label label-danger">下架</span>
                                </c:if>
                            </td>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="operate-btn" style="text-align: center">
                <soul:button target="saveLotteryOrder" text="确认" opType="function"
                             cssClass="btn btn-filter btn-lg m-r" >确认</soul:button>
                <soul:button target="goToLastPage" text="${views.common['cancel']}" opType="function"
                             cssClass="btn btn-outline btn-filter btn-lg m-r" >${views.common['cancel']}</soul:button>
            </div>
        </div>
    </div>

</div>
</form:form>
<!--//endregion your codes 2-->


<!--//region your codes 3-->
<!--//region your codes 4-->
<soul:import res="site/lottery/manage/OrderLottery"/>
<!--//endregion your codes 4-->

<!--//endregion your codes 1-->
