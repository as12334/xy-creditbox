<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<html lang="zh-CN">
<head>
    <title>编辑</title>
    <%@ include file="/include/include.head.jsp" %>
</head>

<body>
<form:form id="shareHolderSitAreaEditForm">
    <form:hidden path="result.id"  />
    <form:hidden path="result.status"/>
    <form:hidden path="result.siteId"/>

    <lb:token/>
    <input type="hidden" id="endTimeVal" value="${command.result.endTime}"/>
    <input name="dateList1" value="${soulFn:formatDateTz(command.dateList[0], DateFormat.DAY_SECOND,timeZone)}" hidden="hidden">
    <input name="result.newDate" value="${soulFn:formatDateTz(command.result.newDate, DateFormat.DAY_SECOND,timeZone)}" hidden="hidden">
    <lb:validateRule/>
    <lb:token/>
    <div class="modal-body">
        <div class="form-group clearfix line-hi34">
            <label class="col-xs-2 al-right">${views.setting['siteConfine.confineArea']}：</label>
            <div class="input-group col-xs-8 p-x">
                   <div class="clearfix">
                       <div class="col-xs-4 p-x">
                           <div>
                               <lb:select name="result.nation" value="${command.result.nation}" prompt="${views.common['pleaseSelect']}"
                                          ajaxListPath="${root}/regions/list.html"
                                          listValue="remark" listKey="dictCode" relSelect="result.province"
                                          cssClass="btn-group chosen-select-no-single"/>
                           </div>
                       </div>
                       <div class="col-xs-4 p-x">
                           <div>
                               <lb:select name="result.province" prompt="${views.common['pleaseSelect']}" value="${command.result.province}"
                                          ajaxListPath="${root}/regions/states/${command.result.nation}.html"
                                          relSelectPath="${root}/regions/states/#result.nation#.html"
                                          listValue="remark" listKey="dictCode" cssClass="btn-group chosen-select-no-single"
                                          relSelect="result.city"/>
                           </div>
                       </div>
                       <div class="col-xs-4 p-x">
                           <div>
                               <lb:select name="result.city" prompt="${views.common['pleaseSelect']}" value="${command.result.city}"
                                          ajaxListPath="${root}/regions/cities/${command.result.nation}-${command.result.province}.html"
                                          relSelectPath="${root}/regions/cities/#result.nation#-#result.province#.html" listValue="remark"
                                          listKey="dictCode" cssClass="btn-group chosen-select-no-single"/>
                           </div>
                       </div>
                   </div>
            </div>
        </div>
        <div class="form-group clearfix line-hi34">
            <label class="col-xs-2 al-right">${views.column['SiteConfineArea.timeType']}：</label>
            <div class="input-group col-xs-8  line-hi34">
                <div class="input-group-btn p-x">
                    <lb:select name="result.timeType" list="${limitTypeMap}" prompt="" value="${command.result.timeType}"
                               listValue="value" listKey="key" callback="showLimitType"></lb:select>



                    <c:forEach var="dateItem" items="${command.dateList}" varStatus="vs">
                        <input type="hidden" id="timeLimit_${vs.index+1}" value="${soulFn:formatDateTz(dateItem, DateFormat.DAY_SECOND,timeZone)}">
                    </c:forEach>
                    </div>
                <span class="stop ${command.result.timeType=='8'?'hide':''}">截止：</span>
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
        <div class="form-group clearfix line-hi34 m-b-sm">
            <label  class="col-xs-2 al-right">${views.column['SiteConfineIp.remark']}：</label>
            <div class="input-group col-xs-8  line-hi34">
                <div class="input-group-btn p-x">
                    <form:textarea cssClass="form-control resize-vertical" path="result.remark" cssStyle="height: 170px"/>
            </div></div>
        </div>
        <div class="bg-gray p-xs">
            <span class="co-yellow m-r-sm"><i class="fa fa-exclamation-circle"></i></span>${views.setting['siteConfine.area.timePrompt']}
        </div>

    </div>
    <div class="modal-footer">
        <soul:button cssClass="btn btn-filter" text="${views.common['OK']}" dataType="json" opType="ajax" target="${root}/siteConfineArea/persist.html" precall="validateForm"  post="getCurrentFormData" callback="saveCallbak"/>
        <soul:button cssClass="btn btn-outline btn-filter" returnValue="false" text="${views.common['cancel']}" opType="function" target="closePage"/>
    </div>    </div>

</form:form>

</body>
<%@ include file="/include/include.js.jsp" %>
<%--<soul:import type="edit"/>--%>
<soul:import res="site/boss/site/companies/area/Edit"/>
</html>
