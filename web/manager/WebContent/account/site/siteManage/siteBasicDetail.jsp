<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="filter-wraper clearfix">
    <b class="fs16">基本信息:</b>
</div>
<div class="m-sm">
    <div class="clearfix">
        <dd class="pull-left p-xs text-oflow-20">
            <b>
                <c:choose>
                    <c:when test="${currentUserType eq '2' || currentUserType eq '21'}">
                        商户：
                    </c:when>
                    <c:otherwise>
                        股东账：
                    </c:otherwise>
                </c:choose>
            </b>
            <span class="m-l-xs">${sysUserVo.result.username}</span>
        </dd>
        <dd class="pull-left p-xs text-oflow-60">
            <b>站点名称:</b>
            <span class="m-l-xs">
                ${command.name}
          </span>
        </dd>
        <dd class="pull-left p-xs">
            <b>站点时区:</b>
            <span class="m-l-xs">${dicts.common.time_zone[command.timezone]}&nbsp;&nbsp;</span><span
                class="co-red3">站点的系统信息将以该时区显示，一旦设置，不可修改!</span>
        </dd>
    </div>

    <div class="gray-chunk clearfix">
        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>经营地区:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <c:forEach items="${siteOperateArea.result}" var="area">
                            <p></p>
                            <li class="clearfix">
                            <span class="control_state_1">
                                <div class="flag">
                                    <div id="region_${area.code.toLowerCase()}"></div>
                                </div>
                                ${dicts.region.region[area.code]}
                            </span>
                            </li>
                            <p></p>
                        </c:forEach>
                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用语言包:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <c:forEach items="${siteLanguage.result}" var="lang">
                            <p></p>
                            <li class="clearfix">
                                <span class="m-r-sm control_state_1"><img src="${resRoot}/${lang.logo}"
                                                                          class="m-r-sm">${dicts.common.nations[lang.language]}</span>
                                <span class="co-grayc2 m-r-sm fs12 control_state_2">${dicts.common.local[lang.language]}</span>
                            </li>
                            <p></p>
                        </c:forEach>
                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用货币:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <c:forEach items="${siteCurrency.result}" var="currency">
                            <p></p>
                            <li class="clearfix">
                                <span class="m-r-sm control_state_2">${dicts.common.currency[currency.code]}</span>
                                <span class="m-r-sm control_state_2">${currency.code}</span>
                            </li>
                            <p></p>
                        </c:forEach>
                    </ul>
                </dd>
            </div>
        </div>
    </div>

    <div class="gray-chunk clearfix">
        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm">
                <b class="pull-left p-xs">当前模式：</b>
                <div class="pull-left p-xs">
                    <c:if test="${command.mode eq '1'}">
                        <span>测试模式</span>
                    </c:if>
                    <c:if test="${command.mode eq '2'}">
                        <span>正式模式</span>
                    </c:if>
                    <c:if test="${command.mode eq '3'}">
                        <span>混合模式</span>
                    </c:if>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm">
                <dd class="pull-left p-xs">
                    <b>站点域名:</b>
                    <span class="m-l-xs">${vSysSiteDomain.domain}&nbsp;<c:if test="${vSysSiteDomain.isTemp}">(临时域名)</c:if></span>
                </dd>
                <dd class="pull-left text-oflow-20">
                    <a class="btn btn-filter btn-sm m-t-xs"
                       data-clipboard-text="${vSysSiteDomain.domain}" name="copy">${views.common['copy']}</a>
                </dd>
            </div>
        </div>
    </div>
</div>