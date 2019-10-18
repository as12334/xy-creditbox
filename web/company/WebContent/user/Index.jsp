<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailListVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form action="${root}/vUserDetail/list.html" method="post">


    <div class="shell-top" id="shell_top">
        <div class="shell-top-left"></div>
        <div class="shell-title-icon">
            <span id="shell_title">分公司管理</span>
        </div>
        <div class="shell-top-right"></div>
        <div id="title-nav"><select id="state">
            <option value="0">停用</option>
            <option value="1">凍結</option>
            <option value="2">啟用</option>
        </select>賬號：<input type="text" id="seachName" autocomplete="off" maxlength="15" class="text-input sw90"><span
                class="text-btn-s" id="search">查詢</span><span class="text-btn-s" id="magAdd" data-userType="${command.search.userType}">新增</span></div>
    </div>
    <%@ include file="IndexPartial.jsp" %>
</form:form>
<%--<soul:import res="site/user/Index"/>--%>

<script type="text/javascript">
    curl(['site/user/Index'], function(Page,Dialog) {
        page = new Page();
    });
</script>
<%--<soul:import res="site/home/Ddialog"/>--%>
<!--//region your codes 3-->
<!--//endregion your codes 3-->