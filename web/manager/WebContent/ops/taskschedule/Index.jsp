<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form action="${root}/taskSchedule/list.html" method="post">
    <div class="position-wrap clearfix">
        <span>运维</span><span>/</span><span>任务调度</span>
        <a href="javascript:void(0)" class="pull-right siteMap"><i class="fa fa-sitemap"></i></a>
    </div>
    <lb:validateRule/>
    <lb:token/>
    <div class="panel panel-default">
        <div class="panel-body">
            <!--//region your codes 2-->
            <div class="m-t-md">
                <div class="m-b-xs clearfix">
                    <div class="form-group clearfix pull-left content-width-limit-200 m-b-xs">
                        <div class="input-group date">
                            <span class="input-group-addon bg-gray"><b>调度器:</b></span>
                            <lb:select name="search.scheduler" value="${command.search.scheduler}" prompt="全部"
                                       list="${schedulers}"
                                       listValue="trans" listKey="code"
                                       cssClass="btn-group chosen-select-no-single btn"/>
                        </div>
                    </div>
                    <div class="form-group clearfix pull-left col-md-3 col-sm-12 m-b-sm padding-r-none-sm">
                        <div class="input-group date">
                            <span class="input-group-addon bg-gray">任务名称</span>
                            <form:input class="form-control" path="search.jobName" placeholder="请输入"/>
                        </div>
                    </div>
                    <div class="form-group clearfix pull-left col-md-1 col-sm-12 m-b-sm padding-r-none-sm">
                        <soul:button target="query" opType="function" text="查询" cssClass="btn btn-default" />
                    </div>
                    <div class="form-group clearfix pull-left col-md-1 col-sm-12 m-b-sm padding-r-none-sm">
                        <soul:button target="${root}/taskSchedule/create.html" text="新增" opType="dialog" callback="callBackQuery"
                                     cssClass="btn btn-filter pull-left" permission="task:schedule_create" size="size-wide" />
                    </div>

                    <div class="form-group clearfix pull-left col-md-1 col-sm-12 m-b-sm padding-r-none-sm">
                        <soul:button target="initScheduler" permission="task:init" opType="function" text="初始化调度任务" cssClass="btn btn-default" />
                    </div>

                </div>
            </div>

            <br/>
            <div class="search-list-container">
                <%@ include file="IndexPartial.jsp" %>
            </div>
            <!--//endregion your codes 2-->
        </div>
    </div>
</form:form>

<!--//region your codes 3-->
<soul:import res="site/taskschedule/Index"/>
<!--//endregion your codes 3-->
