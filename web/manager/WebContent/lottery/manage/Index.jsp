<%--@elvariable id="command" type="so.wwb.gamebox.model.company.lottery.vo.LotteryListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form action="${root}/siteLottery/queryLotteryList.html" method="post">
    <!--//region your codes 2-->
    <div class="row">
        <div class="position-wrap clearfix">
            <h2><a class="navbar-minimalize" href="javascript:void(0)"><i class="icon iconfont">&#xe610;</i> </a></h2>
            <span>彩票</span><span>/</span>
            <span>彩种管理</span>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
                <div class="filter-wraper clearfix p-xs border-b-1">
                    <!--筛选条件-->
                    <div class="form-group clearfix pull-left content-width-limit-30 m-t-sm m-b-none">
                        <div class="input-group">
                            <span class="input-group-addon abroder-no"><b>站点ID：</b></span>
                            <input id="singleVal" class="form-control search" type="text" name="search.siteId">
                        </div>
                    </div>

                    <div class="form-group clearfix pull-left">
                        <div class="form-group clearfix m-t-sm m-b-none">
                            <span style="display: inline-block;width: 10px;height: 10px;"/>
                            <soul:button  target="query" opType="function" text="查询" cssClass="btn btn-filter _enter_submit" />
                        </div>
                    </div>
                    <div class="form-group clearfix pull-left">
                        <div class="form-group clearfix m-t-sm m-b-none">
                            <span style="display: inline-block;width: 10px;height: 10px;"/>
                            <soul:button target="sync" opType="function" text="同步" cssClass="btn btn-filter"  callback="query" permission=""/>
                        </div>
                    </div>
                    <div class="form-group clearfix pull-left">
                        <div class="form-group clearfix m-t-sm m-b-none">
                            <span style="display: inline-block;width: 10px;height: 10px;"/>
                            <soul:button target="takeOff" opType="function" text="下架" cssClass="btn btn-filter" callback="query" permission=""/>
                        </div>
                    </div>

                    <div class="pull-right m-t-n-xxs">
                        <shiro:hasPermission name="lottery:list_killrate">
                            <a href="/lotteryOwnRule/list.html" class="btn btn-filter" nav-target="mainFrame">杀率管理</a>
                        </shiro:hasPermission>

                        <a class="btn btn-outline btn-filter" nav-target="mainFrame" id="common-order">
                            <i class="fa fa-sort-amount-desc m-r-xs"></i>排序
                        </a>
                        <a href="" id="tot" nav-target="mainFrame" style="display: none"></a>
                    </div>

                </div>

                <div class="search-list-container">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
        <!--//endregion your codes 2-->
    </div>
</form:form>
<!--//region your codes 3-->
<%--<soul:import res="site/operate/domainExamine/Index"/>--%>
<soul:import res="site/lottery/manage/Index"/>
<!--//endregion your codes 3-->