<%--@elvariable id="command" type="${basepackage}.model.${module}.vo.${table.className}ListVo"--%>
<#assign controller = "${table.className?uncap_first}">
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div class="table-responsive">
    <table class="table table-condensed table-hover table-striped table-bordered">
        <thead>
        <tr>
            <th width="30px">#</th>
            <th width="70px">操作</th>
            <#list table.listColumns as item>
            <#if item.sortable>
            <th><soul:orderColumn property="${item.columnNameLower}" column="${item.remarks}"/></th>
            </#if>
            <#if item.sortable == false>
            <th>${item.remarks}</th>
            </#if>
            </#list>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${'$'}{command.result}" var="p" varStatus="status">
            <tr>
                <td>${'$'}{status.index+1}</td>
                <td>
                    <div class="joy-list-row-operations">
                        <soul:button target="${'$'}{root}/${controller}/view.html?id=${'$'}{p.id}" text="查看" opType="dialog" />
                        <soul:button target="${'$'}{root}/${controller}/edit.html?id=${'$'}{p.id}" text="编辑" opType="dialog" />
                        <soul:button target="${'$'}{root}/${controller}/delete.html?id=${'$'}{p.id}" text="删除" opType="ajax" dataType="json" confirm="您确定要删除该条记录吗？" callback="query" />
                    </div>
                </td>
                <#list table.listColumns as item>
                <td>${'$'}{p.${item.columnNameLower}}</td>
                </#list>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<soul:pagination/>
<!--//endregion your codes 1-->
