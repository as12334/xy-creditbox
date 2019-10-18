<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<div class="table-responsive table-min-h">
    <table class="table table-striped table-hover dataTable" id="editable" aria-describedby="editable_info">
        <thead>
        <tr role="row" class="bg-gray">
            <th>序号</th>
            <th>玩家账号</th>
            <th>账变类型</th>
            <th>订单号</th>
            <th>交易金额</th>
            <th>手续费</th>
            <th>交易时间</th>
            <th>玩家上级</th>
            <th>真实姓名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="stat">
            <tr class="tab-detail">
                <td>${(command.paging.pageNumber-1)*command.paging.pageSize + status.index+1}</td>
                <td>
                    <a href="/merchant/account/membercenter/view.html?search.id=${p.playerId}&search.hasReturn=true" nav-target="mainFrame" class="co-blue">${p.userName}</a>
                </td>
                <td>${dicts.fund.bill_deposit_type[p.type]}<a href="javascript:void(0)" style="color: #9c9c9c"><span class="glyphicon glyphicon-arrow-right" /></a>${dicts.fund.bill_deposit_item[p.item]}</td>
                <td>${p.billNo}</td>
                <td><p style="color: #be1b00">${fn:replace(gbFn:formatBonus(p.money, 1), ",", "")}</p></td>
                <td>0.000</td>
                <td>
                    <apan class="co-gray3">${soulFn:formatDateTz(p.completionTime, DateFormat.DAY_SECOND, timeZone)}</apan>
                    <apan class="co-gray6">--${soulFn:formatTimeMemo(p.completionTime,locale)}</apan>
                </td>
                <c:choose>
                    <c:when test="${p.parentAgenterName!= null}">
                        <td>${p.parentAgenterName}</td>
                    </c:when>
                    <c:otherwise>
                             <td>--</td>
                    </c:otherwise>
                </c:choose>
                <td>${p.realName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<soul:pagination/>

