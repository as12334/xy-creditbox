<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ include file="/include/include.inc.jsp" %>--%>
<%@ page import="org.soul.commons.lang.string.I18nTool" %>
<%@ page import="org.soul.web.session.SessionManagerBase" %>


<!--//region your codes 1-->
<div class="shell-bottom pagination ">
    <input type="hidden" name="paging.pageNumber" value="${command.paging.pageNumber}">
    <input type="hidden" name="paging.prePage" value="${command.paging.prePage}">
    <input type="hidden" name="paging.nextPage" value="${command.paging.nextPage}">
    <input type="hidden" name="paging.firstPageNumber" value="${command.paging.firstPageNumber}">
    <input type="hidden" name="paging.lastPageNumber" value="${command.paging.lastPageNumber}">
    <input type="hidden" name="paging.totalCount" value="${command.paging.totalCount}">


    <div class="shell-bottom-left"></div>
    <div class="shell-bottom-right"></div>
    <div class="shell-bottom-content" id="shell_pageControl">

        <div class="pager dataTables_paginate" id="data-page">
            <%--每页显示&nbsp;&nbsp;<select data-placeholder="${command.paging.pageSize}条">--%>
                <%--<option <c:if test="${command.paging.pageSize==10}">selected="selected"</c:if> value="10">10${views.pagination["record"]}</option>--%>
                <%--<option <c:if test="${command.paging.pageSize==20}">selected="selected"</c:if> value="20">20${views.pagination["record"]}</option>--%>
                <%--<option <c:if test="${command.paging.pageSize==30}">selected="selected"</c:if> value="30">30${views.pagination["record"]}</option>--%>
                <%--<option <c:if test="${command.paging.pageSize==50}">selected="selected"</c:if> value="50">50${views.pagination["record"]}</option>--%>
                <%--<option <c:if test="${command.paging.pageSize==100}">selected="selected"</c:if> value="100">100${views.pagination["record"]}</option>--%>
                <%--<option <c:if test="${command.paging.pageSize==200}">selected="selected"</c:if> value="200">200${views.pagination["record"]}</option>--%>
            <%--</select>--%>
            <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>

            共 ${command.paging.totalCount} 條記錄 分頁：${command.paging.pageNumber}/${command.paging.lastPageNumber}頁&nbsp;&nbsp;&nbsp;
            <a name="paging.prePage" href="javascript:void(0);">上一頁</a>...『&nbsp;<span
                class="font_c">${command.paging.pageNumber}</span>&nbsp;』...<a name="paging.nextPage" href="javascript:void(0);">下一頁</a>&nbsp;&nbsp;
            <input type="text" value="${command.paging.pageNumber}" name="paging.pageNumberText" id="txtPager" class="GOtext"><button type="button" class="btn btn-sm m-l-sm">跳转</button>
        </div>
    </div>
</div>
