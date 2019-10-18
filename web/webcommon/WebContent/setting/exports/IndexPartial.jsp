<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="table-responsive table-min-h">
        <table class="table table-striped table-hover dataTable" aria-describedby="editable_info">
            <thead>
            <tr role="row" class="bg-gray">
                <th style="width: 40px"><label><input type="checkbox" class="i-checks"></label></th>
                <th style="width: 50px">序号</th>
                <th>${views.column['SysExport.fileName']}</th>
                <th>${views.column['SysExport.createTime']}</th>
                <th>完成时间</th>
                <th>导出条数</th>
                <th>操作人</th>
                <th>${views.column['SysExport.status']}</th>
                <th>${views.column['SysExport.operate']}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${command.result}" var="export" varStatus="vs">
                <tr>
                    <td><label><input type="checkbox" class="i-checks" value="${export.id}"></label></td>
                    <td>${(command.paging.pageNumber-1)*command.paging.pageSize + (vs.index+1)}</td>
                    <td><span class="content-width-no content-width-limit-10" title="${export.fileName}">${export.fileName}</span></td>
                    <td>${soulFn:formatDateTz(export.createTime, DateFormat.DAY_SECOND, timeZone)}</td>
                    <td>${empty export.exportEndTime?'--':soulFn:formatDateTz(export.exportEndTime, DateFormat.DAY_SECOND, timeZone)}</td>
                    <td>${soulFn:formatInteger(export.exportCount)}</td>
                    <td>${export.username}</td>
                    <td>${views.export[export.status]}</td>
                    <td>
                        <c:if test="${export.status=='completed'}">
                            <a href="${root}/exports/download.html?id=${export.id}" >${views.common.download}</a>
                            <%--<soul:button target="${soulFn:getImagePath(domain,export.filePath)}" text="${views.common.download}"
                            cssClass="co-blue" opType="ajax" dataType="json" confirm="您确定要下载此文件吗？" />--%>
                        </c:if>
                        <soul:button target="${root}/exports/delete.html?id=${export.id}" text="${views.common.delete}" cssClass="co-blue"
                                     opType="ajax" dataType="json" confirm="${views.common['confirm.delete']}" callback="query" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<soul:pagination/>
<!--//endregion your codes 1-->
