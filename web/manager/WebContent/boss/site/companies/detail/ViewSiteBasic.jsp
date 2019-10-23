<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%@ page import="java.util.Date" %>
<div class="m-sm">
    <div class="clearfix">
        <dd class="pull-left p-xs text-oflow-20">
            <b>
                股东账号：
            </b>
            <span class="m-l-xs">${empty fn:substringBefore(p.username,'@')?p.username:fn:substringBefore(p.username,'@')}</span>
        </dd>
        <dd class="pull-left p-xs text-oflow-30">
            <b>开站时间:</b>
            <span class="m-l-xs">
                ${soulFn:formatDateTz(p.openingTime,DateFormat.DAY , timeZone)}
                <span class="m-l co-grayc2">距今<fmt:formatNumber value="${empty years?0:years}"
                                                                pattern="###"/>年${months%12}月</span>
            </span>

        </dd>
        <dd class="pull-left p-xs text-oflow-60">
            <b>站点名称:</b>
            <span class="m-l-xs">
                ${p.siteName}
            </span>
        </dd>

        <dd class="pull-left p-xs">
            <b>站点时区:</b>
            <span class="m-l-xs">${dicts.common.time_zone[p.timezone]}&nbsp;&nbsp;</span><span
                class="co-red3">站点的系统信息将以该时区显示，一旦设置，不可修改!</span>
        </dd>
    </div>

    <div class="gray-chunk clearfix">
        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>管理中心:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <c:choose>
                            <c:when test="${p.status eq '1'}">
                                <li class="clearfix">正常  </li>
                            </c:when>
                            <c:when test="${p.status eq '2'}">
                                <li class="clearfix"> 停用 </li>
                            </c:when>
                            <c:otherwise><li class="clearfix">维护中 </li></c:otherwise>
                        </c:choose>

                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用语言包:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <li class="clearfix">
                            <span class="m-r-sm control_state_1">${dicts.common.nations[p.siteLocale]}</span>
                            <span class="co-grayc2 m-r-sm fs12 control_state_2">${dicts.common.local[p.siteLocale]}</span>
                        </li>
                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用货币:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <p></p>
                        <li class="clearfix">
                            <span class="m-r-sm control_state_2">${dicts.common.currency[p.mainCurrency]}</span>
                            <span class="m-r-sm control_state_2">${p.mainCurrency}</span>
                        </li>
                        <p></p>
                    </ul>
                </dd>
            </div>
        </div>

    </div>
    <div class="gray-chunk clearfix">
        <div class="col-sm-4">
            <div class="clearfix m-t-sm m-b-sm change-logo">
                <c:set var="nowTime" value="<%=new Date()%>"/>
                <c:set var="check" value="${not empty p.maintainStartTime and not empty p.maintainEndTime and nowTime.before(p.maintainEndTime) and nowTime.after(p.maintainStartTime)}"/>
                <dd class="change-logo-title"><span><b>维护时间:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <li class="clearfix">
                            <c:if test="${check}">
                                ${soulFn:formatDateTz(p.maintainStartTime, DateFormat.DAY_SECOND,timeZone)}-- --
                                ${soulFn:formatDateTz(p.maintainEndTime, DateFormat.DAY_SECOND,timeZone)}
                            </c:if>
                            <c:if test="${!check}">
                                -- --
                            </c:if>
                        </li>
                    </ul>
                </dd>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group clearfix m-t-sm m-b-sm">
                <dd class="pull-left p-xs">
                    <b>备注:</b>
                    <span class="m-l-xs">
                        ${p.remark}
                    </span>
                </dd>
            </div>
        </div>
    </div>
</div>
