<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="m-sm">
    <div style="display: ${empty command.search.type || command.search.type eq '1'?'block':'none'}">
        <div class="clearfix">
            <dd class="pull-left p-xs text-oflow-20">
                <b>
                    商户账号：
                </b>
                <span class="m-l-xs">${fn:substringBefore(p.username,'@')}</span>
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
            <dd class="pull-left p-xs text-oflow-60">
                <b>模板名称:</b>
                <span class="m-l-xs">
                    ${p.templateCode}
                </span>
            </dd>
            <dd class="pull-left p-xs text-oflow-60">
                <b>主题名称:</b>
                <span class="m-l-xs">
                    ${p.theme}
                </span>
            </dd>
            <dd class="pull-left p-xs text-oflow-60">
                <b>标题名称:</b>
                <span class="m-l-xs">
                    ${p.title}
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
                                    <li class="clearfix">正常</li>
                                </c:when>
                                <c:when test="${p.status eq '2'}">
                                    <li class="clearfix"> 停用</li>
                                </c:when>
                                <c:otherwise>
                                    <li class="clearfix">维护中</li>
                                </c:otherwise>
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

                <div class="col-sm-4">
                    <div class="form-group clearfix m-t-sm m-b-sm">
                        <dd class="pull-left p-xs" style="padding-left: 0px;">当前模式：
                            <c:if test="${p.mode eq '1'}">
                                <span class="m-l-xs" id="mode">测试模式</span>
                            </c:if>
                            <c:if test="${p.mode eq '2'}">
                                <span class="m-l-xs" id="mode">正式模式</span>
                            </c:if>
                            <c:if test="${p.mode eq '3'}">
                                <span class="m-l-xs" id="mode">混合模式</span>
                            </c:if>
                        </dd>

                        <div class="clearfix col-sm-6 line-hi34">
                            <div class="input-group date" style="display: none" id="showModeContent">
                                <span style="display: inline-block">
                                <lb:select name="result.mode" value="${p.mode}" list="${mode}"
                                           notUseDefaultPrompt="true"/>
                                </span>
                                <soul:button cssClass="btn btn-default"
                                             target="updateMode"
                                             text="保存"
                                             opType="function"
                                             rid="${site.result.id}"
                                             permission="site:state"/>
                            </div>
                            <shiro:hasPermission name="site:state">
                                <button id="editMode" class="btn btn-filter">修改</button>
                            </shiro:hasPermission>
                        </div>
                    </div>
                </div>
        </div>
    </div>

    <div style="display: ${command.search.type eq '2'?'block':'none'}">
        <c:if test="${p.subsysCode eq 'merchant'}">
            <div class="gray-chunk clearfix">
            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>是否开启转站:</b>
                        <shiro:hasPermission name="sitename:update_param_status">
                        <span class="m-l-xs">
                            <c:choose>
                                <c:when test="${sysParam eq 'true'}">
                                    <input type="checkbox" name="my-checkbox" value="true" data-code="verification" data-size="mini" checked>
                                </c:when>
                                <c:when test="${sysParam eq 'false'}">
                                    <input type="checkbox" name="my-checkbox" value="false" data-code="verification" data-size="mini">
                                </c:when>
                            </c:choose>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>是否开启试玩:</b>
                        <shiro:hasPermission name="sitename:update_demo_param_status">
                        <span class="m-l-xs">
                        <c:choose>
                            <c:when test="${dome eq 'true'}">
                                <input type="checkbox" name="my-checkbox" value="true" data-code="demo" data-size="mini" checked>
                            </c:when>
                            <c:when test="${dome eq 'false'}">
                                <input type="checkbox" name="my-checkbox" value="false" data-code="demo" data-size="mini">
                            </c:when>
                        </c:choose>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>真实姓名必填:</b>
                        <shiro:hasPermission name="sitename:update_check_real_name_status">
                        <span class="m-l-xs">
                            <input type="checkbox" name="my-checkbox" value="${checkRealName.paramValue}"
                                   data-id="${checkRealName.id}" data-size="mini"  data-code="checkRealName"
                            ${checkRealName.paramValue eq 'true' ? 'checked': ''}>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>手机号必填:</b>
                        <shiro:hasPermission name="sitename:update_check_mobile_status">
                        <span class="m-l-xs">
                            <input type="checkbox" name="my-checkbox" value="${checkMobile.paramValue}"
                                   data-id="${checkMobile.id}" data-size="mini"  data-code="checkMobile"
                                ${checkMobile.paramValue eq 'true' ? 'checked': ''}>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>微信号必填:</b>
                        <shiro:hasPermission name="sitename:update_check_weixin_status">
                        <span class="m-l-xs">
                            <input type="checkbox" name="my-checkbox" value="${checkWeixin.paramValue}"
                                   data-id="${checkWeixin.id}" data-size="mini"  data-code="checkWeixin"
                                ${checkWeixin.paramValue eq 'true' ? 'checked': ''}>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>


            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>玩家收款账号支持支付宝:</b>
                        <shiro:hasPermission name="sitename:update_payee_bank_alipay_status">
                        <span class="m-l-xs">
                            <input type="checkbox" name="my-checkbox" value="${payee_bank_alipay.paramValue}"
                                   data-id="${payee_bank_alipay.id}" data-size="mini"  data-code="payee_bank_alipay"
                                ${payee_bank_alipay.paramValue eq 'true' ? 'checked': ''}>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>玩家收款账号支持微信:</b>
                        <shiro:hasPermission name="sitename:update_payee_bank_weixin_status">
                        <span class="m-l-xs">
                            <input type="checkbox" name="my-checkbox" value="${payee_bank_weixin.paramValue}"
                                   data-id="${payee_bank_weixin.id}" data-size="mini"  data-code="payee_bank_weixin"
                                ${payee_bank_weixin.paramValue eq 'true' ? 'checked': ''}>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>

        </div>
        </c:if>

        <c:if test="${p.subsysCode eq 'merchant-api'}">
            <div class="gray-chunk clearfix">
                <div class="col-sm-4">
                    <div class="form-group clearfix m-t-sm m-b-sm">
                        <dd class="pull-left p-xs">
                            <b>是否开启免转:</b>
                            <shiro:hasPermission name="sitename:update_check_update_api_transfer_site_status">
                                <span class="m-l-xs">
                                    <input type="checkbox" name="my-checkbox" value="${apiTransferSite.paramValue}"
                                     data-size="mini"  data-code="apiTransferSite"
                                    ${apiTransferSite.paramValue eq 'true' ? 'checked': ''}>
                                </span>
                            </shiro:hasPermission>
                        </dd>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="gray-chunk clearfix">
            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>盘口参数:</b>
                    </dd>
                    <div class="col-xs-3">
                        <input type="text" class="form-control  autocompleter-node " name="search.paramValue"
                               value="${disc.paramValue}" style="width: 100px"/>
                        <input type="hidden" name="" value="3">
                    </div>
                    <soul:button target="discParam"  text="保存" opType="function"  cssClass="btn btn-filter pull-left"
                                 callback="query">保存</soul:button>
                </div>
            </div>
        </div>
        <c:if test="${p.subsysCode eq 'merchant'}">
            <div class="gray-chunk clearfix">
            <div class="col-sm-8">
                <div class="form-group clearfix m-t-sm m-b-sm">
                <b>函数执行时间:</b>
                <span class="m-l-xs">
                    <lb:dateRange id="searchDate" name="searchDate" value="${date}" useToday="true" position="down" btnClass="search"
                                  style="width:11%" format="${DateFormat.DAY}" hideQuick="false"/>
                    &nbsp;
                    <soul:button site_id="${p.id}" permission="sitename:bill_rake_back" target="billRakebackSubmit" opType="function" callback="query" text="返水" confirm="确定执行返水函数?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;返水</span>
                    </soul:button>
                    &nbsp;
                    <soul:button site_id="${p.id}" permission="sitename:bill_wages" target="billSalarySubmit" opType="function" callback="query" text="工资" confirm="确定执行工资函数?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;工资</span>
                    </soul:button>
                    &nbsp;
                    <shiro:hasPermission name="sitename:bill_dividen">
                    <soul:button site_id="${p.id}" target="billDividenSubmit" opType="function" callback="query" text="分红" confirm="工资函数只执行到选择的年月,确定执行?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;分红</span>
                    </soul:button>
                    </shiro:hasPermission>
                    &nbsp;
                    <shiro:hasPermission name="sitename:bill_retreat">
                        <soul:button site_id="${p.id}" target="billRetreatSubmit" opType="function" callback="query" text="退水" confirm="确定执行退水函数?" cssClass="btn btn-export-btn btn-primary-hide">
                            <i class="fa fa-sign-out"></i><span class="hd">&nbsp;退水</span>
                        </soul:button>
                    </shiro:hasPermission>
                    &nbsp;
                    <soul:button site_id="${p.id}" permission="sitename:report_game" target="reportGameSubmit" opType="function" callback="query" text="游戏报表" confirm="确定执行游戏报表函数?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;游戏报表</span>
                    </soul:button>
                    &nbsp;
                    <soul:button site_id="${p.id}" permission="sitename:report_operate" target="reportOperateSubmit" opType="function" callback="query" text="运营报表" confirm="确定执行运营报表函数?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;运营报表</span>
                    </soul:button>
                    &nbsp;
                    <soul:button site_id="${p.id}" permission="sitename:report_business" target="reportBusinessSubmit" opType="function" callback="query" text="经营报表" confirm="确定执行经营报表函数?" cssClass="btn btn-export-btn btn-primary-hide">
                        <i class="fa fa-sign-out"></i><span class="hd">&nbsp;经营报表</span>
                    </soul:button>
                </span>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="form-group clearfix m-t-sm m-b-sm">
                    <dd class="pull-left p-xs">
                        <b>初始化黑名单:</b>
                        <shiro:hasPermission name="sitename:init_site_confine">
                        <span class="m-l-xs">
                            <soul:button site_id="${p.id}" target="initSiteConfineArea" opType="function" callback="query" text="初始化开站函数" confirm="确定执行函数?" cssClass="btn btn-export-btn btn-primary-hide">
                                <i class="fa fa-sign-out"></i><span class="hd">初始参数</span>
                            </soul:button>
                        </span>
                        </shiro:hasPermission>
                    </dd>
                </div>
            </div>
        </div>
        </c:if>
    </div>
</div>

