<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<style>
    .createButton{
        margin:-50px 0 35px 0;
        padding-bottom:15px;
    }
    .float-left{
        float: left;
        margin-right: 15px;
    }
</style>
<div class="createButton">
    <div class="float-left">
        <soul:button tag="button" target="${root}/siteConfineIp/bossCreate.html?search.siteId=${command.search.siteId}"
                     text="新增" title="新增" opType="dialog"
                     cssClass="btn btn-info btn-addon" size="open-dialog-50"
                     callback="callBackQuery" permission="siteConfineIp:boss_create">
            <i class="fa fa-plus"></i>
            <span class="hd">新增</span>
        </soul:button>
    </div>
    <div class="function-menu-show hide">
        <soul:button precall="confirmMessage" tag="button"
                     text="${views.setting['common.delete']}"
                     target="${root}/siteConfineIp/bossBatchDeleteArea.html"
                     post="getSelectIds" opType="ajax"
                     cssClass="btn btn-outline btn-filter"
                     callback="query" permission="siteConfineIp:boss_delete">
            <i class="fa fa-trash-o"></i>
            <span class="hd">${views.setting['common.delete']}</span>
        </soul:button>
    </div>
</div>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <input id="listSize" value="${command.result.size()}" type="hidden">
    <input id="active" value="${command.sysParam.paramValue}" hidden="hidden">
    <input type="hidden" name="type" value="${command.type}">
    <div class="table-responsive  table-min-h">
        <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
            <thead>
            <tr role="row" class="bg-gray">
                <th class="user_checkbox"><label><input type="checkbox" class="i-checks"></label></th>
                <th>${views.column['SiteConfineIp.startIp']}</th>
                <th>${views.column['SiteConfineIp.endIp']}</th>
                <th>
                    <lb:select name="search.type" value="${command.search.type}" list="${typeMap}"
                               cssClass="btn-group chosen-select-no-single" prompt="全部类型"
                               callback="query"/>
                </th>
                <th>允许时间</th>
                <th>${views.column['SiteConfineArea.endTime']}</th>
                <th>${views.column['SiteConfineArea.createTime']}</th>
                <th>
                    <lb:select name="search.status" value="${command.search.status}" list="${command.status}"
                               cssClass="btn-group chosen-select-no-single" prompt="全部状态"
                               callback="query"/>
                </th>
                <th>备注</th>
                <th>${views.common['operate']}</th>
            </tr>
            <tr class="bd-none hide">
                <th colspan="${fn:length(command.fields)+3}">
                    <div class="select-records"><i
                            class="fa fa-exclamation-circle"></i>${views.role['player.cancelSelectAll.prefix']}&nbsp;<span
                            id="page_selected_total_record"></span>${views.role['player.cancelSelectAll.middlefix']}
                        <soul:button target="cancelSelectAll" opType="function"
                                     text="${views.role['player.cancelSelectAll']}"/>${views.role['player.cancelSelectAll.suffix']}
                    </div>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${command.result}" var="p" varStatus="status">
                <tr>
                    <th><input type="checkbox" value="${p.id}"></th>
                    <td>${soulFn:formatIp(p.startIp)}</td>
                    <td>${soulFn:formatIp(p.endIp)}</td>
                    <td>${dicts.setting.siteConfineType[p.type]}</td>
                    <td>${dicts.setting.siteConfine[p.timeType]}</td>
                    <c:choose>
                        <c:when test="${p.timeType==1}">
                            <td>----</td>
                        </c:when>
                        <c:otherwise>
                            <td>${soulFn:formatDateTz(p.endTime, DateFormat.DAY_SECOND,timeZone)}</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${soulFn:formatDateTz(p.createTime, DateFormat.DAY_SECOND,timeZone)}</td>
                    <td><span
                            class="${p.status=='expired'?"label label-danger":"label label-success"}">${dicts.setting.site_confine_status[p.status]}</span>
                    </td>
                    <td>
                            ${fn:substring(p.remark, 0, 25)}${fn:length(p.remark)>25?'...': ''}
                    </td>
                    <td>
                        <soul:button target="${root}/siteConfineIp/bossEdit.html?search.id=${p.id}"
                                     dd="" size="open-dialog-50"
                                     text="${views.common['edit']}" permission="siteConfineIp:boss_edit" cssClass="co-blue m-r-xs m-l-xs" opType="dialog"
                                     callback="callBackQuery"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<soul:pagination/>


