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
                        商户账号：
                    </c:when>
                    <c:otherwise>
                        股东账号：
                    </c:otherwise>
                </c:choose>
            </b>
            <span class="m-l-xs">${masterView.username}</span>
        </dd>
        <dd class="pull-left p-xs text-oflow-60">
            <b>站点名称:</b>
            <span class="m-l-xs">
              <c:forEach items="${siteBasic.siteNameList}" var="p">
                  <c:if test="${p.locale eq basic.mainLanguage}">
                      ${p.value}
                  </c:if>
              </c:forEach>
          </span>
        </dd>
        <dd class="pull-left p-xs">
            <b>站点时区:</b>
            <span class="m-l-xs">${dicts.common.time_zone[basic.timezone]} </span><span
                class="co-red3">站点的系统信息将以该时区显示，一旦设置，不可修改!</span>
        </dd>
    </div>

    <div class="gray-chunk clearfix">
        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>经营地区:</b></span></dd>
                <dd>
                    <ul class="content clearfix">
                        <c:set var="areaCount" value="0"/>
                        <c:forEach items="${siteBasic.siteOperateAreaList}" var="p">
                            <p></p>
                            <c:if test="${!empty p.code}">
                                <li class="clearfix">
                                  <span class="control_state_1">
                                      <div class="flag">
                                          <div id="region_${p.code.toLowerCase()}"></div>
                                      </div>
                                          ${dicts.region.region[p.code]}</span>
                                </li>
                                <c:set var="areaCount" value="${areaCount+1}"/>
                            </c:if>
                            <p></p>
                        </c:forEach>
                        <li>
                            <span class="co-grayc2">已选择<a
                                    class="co-red3">${areaCount}</a>个</span>
                        </li>
                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix  m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用语言包:</b></span></dd>
                <dd>
                    <c:set var="languageCount" value="0"/>
                    <ul class="content clearfix">
                        <c:forEach items="${siteBasic.siteLanguageList}" var="p">
                            <p></p>
                            <c:if test="${p.language eq basic.mainLanguage}">
                                <li class="clearfix">
                                    <span class="m-r-sm control_state_1"><img src="${resRoot}/${p.logo}"
                                                                              class="m-r-sm">${dicts.common.nations[p.language]}</span>
                                    <span class="co-grayc2 m-r-sm fs12 control_state_2">${dicts.common.nations[p.language]}</span>
                                    <span class="label label-warning">主语言</span>
                                </li>
                                <c:set var="languageCount" value="${languageCount+1}"/>
                            </c:if>
                            <p></p>
                        </c:forEach>
                        <c:forEach items="${siteBasic.siteLanguageList}" var="p">
                            <p></p>
                            <c:if test="${!empty p.language && p.language!=basic.mainLanguage}">
                                <li class="clearfix">
                                    <span class="m-r-sm control_state_1"><img src="${resRoot}/${p.logo}"
                                                                              class="m-r-sm">${dicts.common.nations[p.language]}</span>
                                    <span class="co-grayc2 m-r-sm fs12 control_state_2">${dicts.common.nations[p.language]}</span>
                                </li>
                                <c:set var="languageCount" value="${languageCount+1}"/>
                            </c:if>
                            <p></p>
                        </c:forEach>
                        <li>
                            <span class="co-grayc2">已选择<a
                                    class="co-red3">${languageCount}</a>个</span>
                        </li>
                    </ul>
                </dd>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="clearfix m-t-sm m-b-sm change-logo">
                <dd class="change-logo-title"><span><b>使用货币:</b></span></dd>
                <dd>
                    <c:set var="currencyCount" value="0"/>
                    <ul class="content clearfix">
                        <c:forEach items="${siteBasic.siteCurrencyList}" var="p">
                            <p></p>
                            <c:if test="${p.code eq basic.mainCurrency}">
                                <li class="clearfix">
                                    <span class="m-r-sm control_state_2">${dicts.common.currency[p.code]}</span>
                                    <span class="m-r-sm control_state_2">${p.code}</span>
                                    <span class="label label-warning">主货币</span>
                                </li>
                                <c:set var="currencyCount" value="${currencyCount+1}"/>
                            </c:if>
                            <p></p>
                        </c:forEach>
                        <c:forEach items="${siteBasic.siteCurrencyList}" var="p">
                            <p></p>
                            <c:if test="${!empty p.code && p.code!=basic.mainCurrency}">
                                <li class="clearfix">
                                    <span class="m-r-sm control_state_2">${dicts.common.currency[p.code]}</span>
                                    <span class="m-r-sm control_state_2">${p.code}</span>
                                </li>
                                <c:set var="currencyCount" value="${currencyCount+1}"/>
                            </c:if>
                            <p></p>
                        </c:forEach>
                        <li>
                            <span class="co-grayc2">已选择<a
                                    class="co-red3">${currencyCount}</a>个</span>
                        </li>
                    </ul>
                </dd>
            </div>
        </div>
    </div>
</div>