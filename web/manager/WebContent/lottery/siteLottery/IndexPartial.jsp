<%--<%@ page import="so.wwb.gamebox.model.company.site.po.VSiteApiType" %>--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div class="table-responsive table-min-h" style="padding-bottom: 95px">
    <table class="table table-striped table-hover dataTable" aria-describedby="editable_info">
        <%--<c:set var="poType" value="<%= VSiteApiType.class %>"></c:set>--%>
        <thead>
        <tr role="row" class="bg-gray">
            <th width="60">${views.column['VSiteApiType.orderNum']}</th>
            <th>站点ID</th>
            <th>彩种类型</th>
            <th>彩种代号</th>
            <th>彩种状态</th>
            <th>${views.common['operate']}</th>
            <th></th>
        </tr>
        <tr class="bd-none hide">
            <th colspan="7">
                <%-- <div class="select-records"><i class="fa fa-exclamation-circle"></i>${views.role['player.cancelSelectAll.prefix']}&nbsp;<span id="page_selected_total_record"></span>${views.role['player.cancelSelectAll.middlefix']}
                     <soul:button target="cancelSelectAll" opType="function" text="${views.role['player.cancelSelectAll']}"/>${views.role['player.cancelSelectAll.suffix']}
                 </div>--%>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty command.result}">
            <td colspan="7" class="no-content_wrap">
                <div>
                    <i class="fa fa-exclamation-circle"></i> 暂无记录
                </div>
            </td>
        </c:if>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr class="tab-detail">
                <td>
                    ${status.index+1}
                </td>
                <td>${p.siteId}</td>
                <td>${dicts.lottery.lottery_type[p.type]}(${p.type})</td>
                <td>${dicts.lottery.lottery[p.code]}(${p.code})</td>
                <td>
                    <c:if test="${p.status=='normal'}">
                        <span class="label label-success">正常</span>
                    </c:if>
                    <c:if test="${p.status=='maintain'}">
                        <span class="label label-warning">维护</span>
                    </c:if>
                    <c:if test="${p.status=='disable'}">
                        <span class="label label-danger">下架</span>
                    </c:if>
                </td>
                <td>
                    <div class="joy-list-row-operations">
                        <soul:button target="${root}/siteLottery/siteLotteryManage.html?search.id=${p.id}" callback="query"
                                     cssClass="btn" text="管理" opType="dialog" />
                    </div>
                </td>
                <td>
                    <c:if test="${p.code=='cqssc'||p.code=='xjssc'||p.code=='tjssc'||p.code=='bjpk10'||p.type=='k3'||p.code=='fc3d'||p.code=='tcpl3'}">
                        <input type="hidden" name="code" value="${p.code}"/>
                        <input type="hidden" name="id" value="${p.id}"/>
                        <shiro:hasPermission name="lottery:change_lotterygenre">
                        <gb:select name="chargeGenre" list="${lotteryGenre}" notUseDefaultPrompt="true" value="${p.genre}" cssClass="btn-group chosen-select-no-single" callback="updateSiteLotteryGenre"/>
                        </shiro:hasPermission>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<soul:pagination/>

<!--//endregion your codes 1-->
