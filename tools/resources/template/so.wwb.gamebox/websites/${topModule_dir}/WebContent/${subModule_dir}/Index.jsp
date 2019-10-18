<%--@elvariable id="command" type="${basepackage}.model.${module}.vo.${table.className}ListVo"--%>
<#assign controller = "${table.className?uncap_first}">
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!--//region your codes 1-->

<!--//endregion your codes 1-->
<form:form action="${'$'}{root}/${controller}/list.html" method="post">
    <div id="validateRule" style="display: none">${'$'}{command.validateRule}</div>
    <div class="panel panel-default">
        <div class="panel-body">
            <!--//region your codes 2-->
            <div class="row">
                <#list table.columns as item>
                <#if item.searchable>
                <label class="col-md-1 control-label" for="search.${item.columnNameLower}">${item.remarks}</label>
                <div class="col-md-2">
                    <form:input class="form-control" path="search.${item.columnNameLower}" placeholder="请输入${item.remarks}"/>
                </div>
                </#if>
                </#list>

                <div class="col-md-1">
                    <soul:button target="query" opType="function" text="查询" cssClass="btn btn-default" />
                </div>
                <div class="col-md-1">
                    <soul:button target="${'$'}{root}/${controller}/create.html" opType="dialog" text="新增" cssClass="btn btn-default" />
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
<soul:import type="list"/>
<!--//endregion your codes 3-->