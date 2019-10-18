<%--账号详细--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.lotterybox.model.manager.user.vo.SysUserExtendVo"--%>
<form id="shViewForm" name="shViewForm" method="post">
    <div class="row" name="playerViewDiv">
        <div class="position-wrap clearfix">
            <span>账户</span><span>/</span><span>账户管理</span>
            <soul:button target="goToLastPage" cssClass="returnSuperior m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn" text="" opType="function">
                    <input hidden name="lastTimeSearch" value="${command.lastTimeSearch}">
                <em class="fa fa-caret-left"></em>${views.common['return']}
            </soul:button>
        </div>
        <div class="col-lg-12">
            <c:set var="r" value="${command.result}"/>
            <input type="hidden" name="result.id" value="${r.id}" id="userId">
            <div class="wrapper white-bg clearfix shadow">
                <div class="sys_tab_wrap clearfix m-b-sm">
                    <div class="m-sm">
                        <b class="fs16">账号详细</b>
                    </div>
                </div>
                <div class="panel-body p-sm">
                    <ul class="new-detail-list">
                        <li class="detail-list-name">
                            <span class="player-name" style="font-size: 30px;">${fn:substringBefore(r.username,'@')}</span>
                            <a href="javascript:void(0)" class="btn btn-outline btn-filter btn-sm m-l-sm" style="opacity: 0.6">ID ${command.result.id}</a>
                            <c:if test="${r.status eq '2'}">
                                <c:set value="true" var="option_btn_disabled"></c:set>
                            </c:if>
                            <%--<soul:button target="${root}/account/account/resetPwd.html?search.id=${r.id}" cssClass="${option_btn_disabled ?'disabled':''} btn btn-outline btn-filter btn-sm m-l" text="重置登录密码" opType="dialog" tag="button"/>
                            <soul:button target="${root}/account/account/resetPayPwd.html?search.id=${r.id}" cssClass="${option_btn_disabled ?'disabled':''} ${command.result.status eq '3'?'disabled':''} btn btn-outline btn-filter btn-sm m-l" text="重置安全密码" opType="dialog" tag="button"/>
                        </li>--%>

                        <li class="detail-list-cow">
                            <span class="title">账号类型</span>
                            <div class="content">${dicts.account.user_type[r.userType]}</div>
                            <c:if test="${r.userType eq '0' || r.userType eq '1'  || r.userType eq '2' || r.userType eq '22'}">
                                <a href="/account/domain/list.html" nav-target="mainFrame"></a>
                            </c:if>
                        </li>
                        <%--<li class="detail-list-cow">--%>
                            <%--<span class="title">体系</span>--%>
                            <%--<div class="content">--%>
                                <%--<c:set var="parentIds" value="${fn:split(r.parentIds, ',')}"/>--%>
                                <%--<c:set var="parentNames" value="${fn:split(r.parentNames, ',')}"/>--%>
                                <%--<c:forEach items="${parentNames}" var="i" varStatus="status">--%>
                                    <%--<c:if test="${!empty i}">--%>
                                        <%--${i}(id = ${parentIds[status.index]})--%>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${status.index<fn:length(parentNames)-1}">--%>
                                        <%--<i class="fa fa-arrow-circle-right" style="font-size:16px;color:gray"/>                                    </c:if>--%>
                                <%--</c:forEach>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <li class="detail-list-cow">
                            <span class="title">代号</span>
                            <div class="content">${r.code}</div>
                        </li>
                        <li class="detail-list-cow">
                            <span class="title">上层代号</span>
                            <div class="content">${r.ownerCode}</div>
                        </li>
                        <li class="detail-list-cow">
                            <span class="title">当前状态</span>
                            <div class="content" id="player-stauts-detail">
                                <c:set var="status" value="${r.status}"/>
                                <c:if test="${status=='1'}">
                                <span class="label label-success">
                                        ${dicts.account.user_status[status]}
                                </span>
                                </c:if>
                                <c:if test="${status=='2'}">
                                <span class="label label-danger">
                                        ${dicts.account.user_status[status]}
                                </span>
                                </c:if>
                                <c:if test="${status=='3'}">
                                <span class="label label-info">
                                    ${dicts.account.user_status[status]}
                                </span>
                                </c:if>
                                <c:if test="${status=='4'}">
                                <span class="label label-warning">
                                    ${dicts.account.user_status[status]}
                                </span>
                                </c:if>
                                <c:if test="${status=='5'}">
                                <span class="label label-danger">
                                        ${dicts.account.user_status[status]}
                                </span>
                                </c:if>
<%--
                                <soul:button target="editStatus" text="修改状态" opType="function" cssClass="btn btn-link co-blue" permission="account:updateStatus"></soul:button>
--%>
                                <input type="hidden" name="current-status" id="current-status" value="${status}">
                            </div>
                            <div class="content" style="display: none" id="status-edit">
                                <lb:select name="result.status" value="${status}" cssClass="result-playerStatus"
                                           list="${userStatus}" notUseDefaultPrompt="true"/>

                                <%--<soul:button target="${root}/account/account/freezeAccount.html?result.id=${r.id}"
                                             text="${views.role['Player.detail.freezeAccount']}" callback="queryView"
                                             opType="dialog" cssClass="btn btn-link co-blue save-status-btn freeze-account-btn hide"
                                             permission="role:player_freezeaccout">
                                    ${views.common['save']}
                                </soul:button>
                                <soul:button
                                        target="${root}/account/account/disabledAccount.html?result.id=${r.id}"
                                        text="${messages['playerTag']['accountDisabled']}"
                                        opType="dialog" cssClass="btn btn-link co-blue save-status-btn disable-account-btn hide"
                                        callback="queryView">
                                    ${views.common['save']}
                                </soul:button>
--%>
                                <soul:button target="updateStatus" callback=""  text="${views.common['save']}" opType="function" cssClass="btn btn-link co-blue save-status-btn save-normal-btn" permission="account:updateStatus"></soul:button>
                                <soul:button target="cancelEditStatus" text="${views.common['cancel']}" opType="function" cssClass="btn btn-link co-blue"></soul:button>
                        </li>

                        <li class="detail-list-cow" id="personal-data-view">
                            <span class="title">真实姓名 </span>
                            <div class="content" id="real-name-detail">
                                <span id="show-real-name">${command.result.realName}</span>
                            </div>
                        </li>

                        <%--<li class="detail-list-cow">--%>
                            <%--<span class="title">电子邮箱 </span>--%>
                            <%--<div class="content">--%>
                                <%--<span>${email}</span>--%>
                            <%--</div>--%>
                        <%--</li>--%>

                        <li class="detail-list-cow">
                            <c:if test="${empty command.result.loginIp}">
                                该账号未被登入过
                            </c:if>
                            <c:if test="${not empty command.result.loginIp}">
                                <div class="content">最后一次登入 IP 为
                                    <shiro:hasPermission name="mine:log">
                                        <a href="/boss/system/log/logIndex.html?hasReturn=true&search.roleType=${r.subsysCode}&keys=search.ip&search.ip=${soulFn:formatIp(command.result.loginIp)}" nav-target="mainFrame" add-table='addTable' tab-name='操作日志' >${soulFn:formatIp(command.result.loginIp)}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="mine:log">${soulFn:formatIp(command.result.loginIp)}</shiro:lacksPermission>
                                    <c:if test="${not empty command.result.loginIpDictCode}">
                                        [ ${gbFn:getShortIpRegion(command.result.loginIpDictCode)}]
                                    </c:if>
                                    于 <span class="co-gray">
                                    ${soulFn:formatDateTz(command.result.loginTime, DateFormat.DAY_SECOND,timeZone)} - ${soulFn:formatTimeMemo(command.result.loginTime,locale )}
                                </span>
                                </div>
                            </c:if>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</form>
<soul:import res="site/boss/account/companies/View"/>

