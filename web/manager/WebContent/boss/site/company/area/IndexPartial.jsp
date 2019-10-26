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
        <soul:button tag="button" target="${root}/siteConfineArea/merchantCreate.html?search.siteId=${command.search.siteId}"
             text="新增" title="新增" opType="dialog"
             cssClass="btn btn-info btn-addon" size="open-dialog-50"
             callback="callBackQuery" permission="blacklist:newly_added">
            <i class="fa fa-plus"></i>
            <span class="hd">新增</span>
        </soul:button>
    </div>
    <div class="function-menu-show hide">
        <soul:button precall="confirmMessage" tag="button" permission="blacklist:delete_area"
                     text="${views.contacts['page.contacts.del']}"
                     target="${root}/siteConfineArea/merchantBatchDeleteArea.html" post="getSelectIds"
                     opType="ajax" cssClass="btn btn-danger-hide" callback="query"><i
                class="fa fa-trash-o"></i><span
                class="hd">${views.setting['common.delete']}</span></soul:button>
    </div>
</div>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="table-responsive table-min-h">
        <table class="table table-striped table-hover dataTable m-b-sm" id="editable" aria-describedby="editable_info">
            <thead>
                <tr role="row" class="bg-gray">
                    <th class="user_checkbox"><label><input type="checkbox" class="i-checks"></label></th>
                    <th>${views.setting['siteConfine.confineArea']}</th>
                    <th>${views.column['SiteConfineArea.timeType']}</th>
                    <th>${views.column['SiteConfineArea.endTime']}</th>
                    <th>${views.column['SiteConfineArea.createTime']}</th>
                    <th class="">
                        <lb:select name="search.status" value="${command.search.status}" list="${command.status}" cssClass="btn-group chosen-select-no-single" prompt="${views.common['all']}" callback="query"/>
                    </th>
                    <th>${views.common['operate']}${dicts.setting['site_confine_status.using']}</th>
                </tr>
                <tr class="bd-none hide">
                    <th colspan="${fn:length(command.fields)+3}">
                        <div class="select-records"><i class="fa fa-exclamation-circle"></i>${views.role['player.cancelSelectAll.prefix']}&nbsp;<span id="page_selected_total_record"></span>${views.role['player.cancelSelectAll.middlefix']}
                            <soul:button target="cancelSelectAll" opType="function" text="${views.role['player.cancelSelectAll']}"/>${views.role['player.cancelSelectAll.suffix']}
                        </div>
                    </th>
                </tr>

            </thead>
            <tbody>
            <c:forEach items="${command.result}" var="p" varStatus="status">
                <tr class="tab-detail">
                    <th>
                        <input type="checkbox" value="${p.id}" >
                    </th>
                    <td>${dicts.region.region[p.nation]}${p.province.length()>0?"-":""}${dicts.state[p.nation][p.province]}${p.city.length()>0?"-":""}${dicts.city[p.nation.concat("_").concat(p.province)][p.city]}</td>
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
                    <td><span class="${p.status=='expired'?"label label-danger":"label label-success"}">${dicts.setting.site_confine_status[p.status]}</span></td>
                    <td>
                        <c:if test="${p.builtIn ne 'true'}">
                            <soul:button target="${root}/siteConfineArea/merchantEdit.html?search.id=${p.id}" permission="blacklist:edit_black"  size="open-dialog-50" text="编辑" cssClass="co-blue m-r-xs m-l-xs" opType="dialog" callback="callBackQuery" />
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<soul:pagination/>

<!--//endregion your codes 1-->
