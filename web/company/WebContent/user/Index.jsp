<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form id="userListForm" action="${root}/sysUserExtend/list.html" method="post">


    <<input hidden name="search.userType" value="${command.search.userType}">
    <div class="shell-top" id="shell_top">
        <div class="shell-top-left"></div>
        <div class="shell-title-icon">
            <span id="shell_title">分公司管理</span>
        </div>
        <div class="shell-top-right"></div>
        <div id="title-nav">
            <select id="state" name="search.status">
                <option value="1">啟用</option>
                <option value="2">停用</option>
                <option value="3">凍結</option>
            </select>
            賬號：<input type="text" id="seachName" autocomplete="off" maxlength="15" class="text-input sw90"
                      name="search.username">
            <span class="text-btn-s" >
                <soul:button target="query" text="" opType="function">查询</soul:button>
            </span>
            <span class="text-btn-s" >
                <a nav-target="mainFrame" href="/vSiteUser/createManagerUser.html?search.userType=${command.search.userType}">新增</a>
                 </span>

        </div>
    </div>
    <div class="search-list-container">
        <%@ include file="IndexPartial.jsp" %>

    </div>
</form:form>
<%--<soul:import res="site/user/Index"/>--%>


<soul:import res="site/user/Index"/>
<!--//region your codes 3-->
<!--//endregion your codes 3-->