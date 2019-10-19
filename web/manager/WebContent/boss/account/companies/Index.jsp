<%--@elvariable id="command" type="so.wwb.lotterybox.model.manager.user.vo.SysUserExtendListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->
<div class="row">
    <form:form id="shareholderForm" name="shareholderForm" action="${root}/boss/account/companies/companiesList.html" method="post">
        <%--如果登录的用户是boss--%>
        <c:if test="${sessionSysUser.userType ne '1' && sessionSysUser.userType ne '11'}">
            <form:hidden path="search.ownerId" value="${sessionSysUser.id}"/>
        </c:if>
        <lb:validateRule/>
        <div class="position-wrap clearfix">
            <span>账户</span><span>/</span><span>股东账号</span>
        </div>
        <div class="col-lg-12">
            <div class="wrapper white-bg shadow clearfix">
                <div class="m-t-md">
                    <div class="m-b-xs clearfix">
                        <div class="form-group clearfix pull-left col-md-2 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon bg-gray">股东账号</span>
                                <input type="text" autocomplete="off" class="form-control list-search-input-text" name="search.username" value="${command.search.username}">
                            </div>
                        </div>
                        <div class="form-group clearfix pull-left col-md-5 col-sm-12 m-b-sm padding-r-none-sm">
                            <div class="input-group date">
                                <span class="input-group-addon bg-gray">创建时间</span>
                                <lb:dateRange format="${DateFormat.DAY_SECOND}" style="width:42%;" useToday="true"
                                              btnClass="search" useRange="true" startName="search.createTimeBegin"
                                              startDate="${command.search.createTimeBegin}" endName="search.createTimeEnd"
                                              endDate="${command.search.createTimeEnd}"/>
                            </div>
                        </div>
                        <soul:button target="query" opType="function" text="搜索" cssClass="btn btn-filter">
                            <i class="fa fa-search "></i>
                            <spen>搜索</spen>
                        </soul:button>&nbsp;
                        <button id="clearQueryParam" type="reset" hidden/>
                        <soul:button target="resetCondition" opType="function"  text="重置" cssClass="btn btn-filter">
                            <i class="glyphicon glyphicon-trash"></i><spen>重置</spen>
                        </soul:button>
                        <div class="col-sm-12 clearfix template-menu">
                            <soul:button target="${root}/boss/account/companies/create.html" opType="dialog" text="新增"
                                         cssClass="btn btn-info btn-addon" callback="callBackQuery" permission="account:companies_create">
                                <i class="fa fa-plus"></i>新增
                            </soul:button>
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

<!--//region your codes 3-->
<soul:import res="site/boss/account/companies/Index"/>
<!--//endregion your codes 3-->