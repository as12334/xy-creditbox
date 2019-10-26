<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<html lang="zh-CN">
<head>
    <title>编辑</title>
    <%@ include file="/include/include.head.jsp" %>
</head>

<body>
<div class="modal-body">
<form:form id="shareHolderSiteEditIpForm"  method="post">
    <lb:validateRule/>
    <form:hidden path="result.id"/>
    <form:hidden path="result.siteId"/>
    <lb:token/>
    <input type="hidden" id="endTimeVal" value="${command.result.endTime}"/>
    <input name="dateList1" value="${soulFn:formatDateTz(command.dateList[0], DateFormat.DAY_SECOND,timeZone)}" hidden="hidden">
    <input name="result.newDate" value="${soulFn:formatDateTz(command.result.newDate, DateFormat.DAY_SECOND,timeZone)}" hidden="hidden">
    <div class="modal-body">
            <div class="clearfix m-b bg-gray p-t-xs">
                    <span class="co-orange fs36 line-hi25 col-xs-1 al-right">
                        <i class="fa fa-exclamation-circle m-t-n-sm"></i>
                    </span>
                <div class="pull-left col-xs-11 m-b-sm">
                    <div class="co-red3">${command.result.type=='2'?views.setting['siteConfine.ip.top.2']:command.result.type=='3'?views.setting['siteConfine.ip.top.3']:''}</div>
                       ${views.setting['siteConfine.ip.addIpPrompt']}
                </div>
            </div>
        <div class="form-group clearfix line-hi34 m-b-sm">
            <label class="col-xs-3 al-right">
                <span class="co-red m-r-sm">*</span>${views.column['SiteConfineIp.startIp']}：
            </label>

            <div class="col-xs-8">
                <form:input path="result.startIpStr" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group clearfix line-hi34 m-b-sm">
            <label class="col-xs-3 al-right">
                <span class="co-red m-r-sm">*</span>${views.column['SiteConfineIp.endIp']}：
            </label>

            <div class="col-xs-8">
                <form:input path="result.endIpStr" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group clearfix line-hi34">
            <label for="result.timeType" class="col-xs-3 al-right">
                <span class="co-red m-r-sm">*</span>
                类型：
            </label>
            <input name="result.type" value="3" hidden/>
            <span class="stop" style="padding-left: 15px">管理中心</span>
        </div>
        <div class="form-group clearfix line-hi34">
            <label for="result.timeType" class="col-xs-3 al-right">
                <span class="co-red m-r-sm">*</span>
                ${command.result.type=='2'||command.result.type=='3'?views.column['SiteConfineArea.allow']:views.column['SiteConfineArea.timeType']}：
            </label>

            <div class="input-group col-xs-8  line-hi34">
                <div class="input-group-btn" >
                    <lb:select name="result.timeType" list="${limitTypeMap}" prompt="" value="${command.result.timeType}"
                               listValue="value" listKey="key" callback="showLimitType"></lb:select>

                    <c:forEach var="dateItem" items="${command.dateList}" varStatus="vs">
                        <input type="hidden" id="timeLimit_${vs.index+1}" value="${soulFn:formatDateTz(dateItem, DateFormat.DAY_SECOND,timeZone)}">
                    </c:forEach>
                    </div>
                <span class="stop ${command.result.timeType=='8'?'hide':''}" style="padding-left: 15px">截止：</span>
                <c:choose>
                    <c:when test="${command.result.endTime==null}">
                        <span id="showTime" pattern="${DateFormat.DAY_SECOND}">----</span>
                    </c:when>
                    <c:otherwise>
                        <span id="showTime" pattern="${DateFormat.DAY_SECOND}">

                                ${command.result.timeType=='1'?"----":command.result.timeType=='8'?'':soulFn:formatDateTz(command.result.endTime, DateFormat.DAY_SECOND,timeZone)}
                        </span>
                    </c:otherwise>
                </c:choose>
                <span class="endTime ${command.result.timeType!='8'?'hide':''}">
                    <lb:dateRange format="${DateFormat.DAY_SECOND}" style="width:160px" position="down"
                                  value="${command.result.endTime}" minDate="${dateQPicker.today}" name="result.endTime"/>
                </span>
            </div>
        </div>
        <div class="form-group clearfix line-hi34 endTime" style="display: none">
            <label for="result.endTime" class="col-xs-3 al-right">${views.setting['siteConfine.customTime']}：</label>

            <div class="col-xs-8 p-x">
                <div class="col-xs-8">
                    <lb:dateRange format="${DateFormat.DAY_SECOND}" style="width:160px" position="down"
                                  value="${command.result.endTime}" minDate="${dateQPicker.today}" name="result.endTime"/>
                </div>
            </div>
        </div>


        <div class="form-group clearfix line-hi34 m-b-sm">
            <label  class="col-xs-3 al-right">${views.column['SiteConfineIp.remark']}：</label>

            <div class="col-xs-8">
                <form:textarea cssClass="form-control" path="result.remark" cssStyle="height: 170px"/>
            </div>
        </div>
        <div class="clearfix m-b bg-gray p-t-xs">
                    <span class="co-orange fs36 line-hi25 col-xs-1 al-right">
                        <i class="fa fa-exclamation-circle m-t-n-sm"></i>
                    </span>
            <div class="line-hi25 pull-left col-xs-11 m-b-sm">${views.setting['siteConfine.ip.addIpPromptAfter.allow']}</div>
        </div>
    </div>

    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" text="${views.common['OK']}" dataType="json" opType="ajax"
                     target="${root}/siteConfineIp/persist.html?" precall="saveValid" post="getCurrentFormData"
                     callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" returnValue="false"  text="${views.common['cancel']}" opType="function"
                     target="closePage"/>
    </div>
</form:form>
</div>
</body>
<%@ include file="/include/include.js.jsp" %>

<soul:import res="site/boss/site/companies/ip/Edit"/>
</html>
