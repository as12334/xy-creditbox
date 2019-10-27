<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailListVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form id="userListForm" action="${root}/sysUserExtend/list.html" method="post">


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
                <%--<a title="搜索" data-rel="{&quot;precall&quot;:&quot;&quot;,&quot;callback&quot;:&quot;&quot;,post:&quot;&quot;,opType:&quot;function&quot;,dataType:&quot;&quot;,target:&quot;query&quot;,confirm:&quot;&quot;,text:&quot;搜索&quot;,size:&quot;&quot; }">--%>
                        <%--<i class="fa fa-search "></i>--%>
                            <%--<spen>搜索</spen>--%>


                <%--</a>--%>
            </span>
            <span class="text-btn-s" id="magAdd"
                  data-url="/sysUserExtend/createManagerUser.html?search.userType=${command.search.userType}">新增</span>
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