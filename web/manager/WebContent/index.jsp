<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="logoutUrl" value="<%= SessionManager.getLogoutUrl() %>"/>
<!DOCTYPE html>
<head>
    <title>${siteTilte} | 管理中心</title>
    <c:choose>
        <c:when test="${not empty logo
        and (sessionSysUser.subsysCode eq 'merchant' or sessionSysUser.subsysCode eq 'distributor' or sessionSysUser.subsysCode eq 'merchant-api' or sessionSysUser.subsysCode eq 'distributor-api')
        and logo ne 'Logo/1/1459172297237.png'}">
            <link rel="shortcut icon" href="${soulFn:getThumbPath(domain, logo, 57, 38)}"/>
        </c:when>
        <c:when test="${not empty logo and (sessionSysUser.subsysCode eq 'boss' or sessionSysUser.subsysCode eq 'shareholder')}">
            <link rel="shortcut icon" href="${resRoot}/images/logo.png"/>
        </c:when>
    </c:choose>
    <%@ include file="/include/include.head.jsp" %>
    <style type="text/css">
        .carousel-fill {
            background-position: center;
            text-align: center;
        }

        .carousel-fill img {
            /*设置图片垂直居中*/
            vertical-align: middle;
            max-width: 100%;
            max-height: 100%;
        }

        /* faster sliding speed */
        .carousel-inner > .item {
            -webkit-transition: 0.3s ease-in-out left;
            -moz-transition: 0.3s ease-in-out left;
            -o-transition: 0.3s ease-in-out left;
            transition: 0.3s ease-in-out left;
        }

        /*  左侧菜单鼠标滚轮 隐藏*/
        .tempTest::-webkit-scrollbar {
            display: none;
            -ms-overflow-style: none;
            overflow: -moz-scrollbars-none;
        }
    </style>

    <script type="text/javascript">
        var language = '${language.replace('_','-')}';
        //    mcenter专用
        var entrance = '${S_ENTRANCE}';
    </script>
    <%@ include file="/include/include.js.jsp" %>
    <script type="text/javascript">
        curl(['zeroClipboard', 'UE', 'clipboard'], function (zeroClipboard, UE, Clipboard) {
            var now = new Date();
            window.ZeroClipboard = zeroClipboard;
            window.UE = UE;
            window.clipboard = Clipboard;
            //用于区分不同后台的访问路径
            var uri = $('input[name="currentSubsysCode"]').val();
            if (uri == 'merchant-api') {
                uri = 'api/merchant';
            } else if (uri == 'distributor-api') {
                uri = 'api/distributor';
            }
            window.managerUrl = root + '/' + uri;
            console.log('%s indexPage loaded managerUrl:%s', now.toLocaleString(), window.managerUrl);
        });

        curl(['lb/home/TopPage', 'lb/home/TopNav',
            'lb/home/taskManager'], function (TopPage, TopNav, TaskManager) {
            topPage = new TopPage();
            topNav = new TopNav();
            taskManager = new TaskManager();
//            cometNew = new CometNew();
        });
        curl(['common/Gba', 'site/index/Comet',
            'inspinia', 'jqmetisMenu', 'jqnouislider', 'jqcontextify'], function (Gba, Comet) {
            comet = new Comet();
        });

        function updateLoginPwd(title) {
            var btnOption = {};
            btnOption.target = window.managerUrl + "/account/mine/toUpdatePassword.html";
            btnOption.text = title;
            btnOption.callback = function (e, opt) {

            };
            window.top.topPage.doDialog({}, btnOption);
        }
        function updatePowerPwd(title) {
            var btnOption = {};
            btnOption.target = root + "/account/mine/toUpdatePrivilegePassword.html";
            btnOption.text = title;
            btnOption.callback = function (e, opt) {

            };
            window.top.topPage.doDialog({}, btnOption);
        }
    </script>
    <script type="text/javascript">
        curl(['lb/home/LeftNav'],
            function (LeftNav) {
                leftNav = new LeftNav();
                if ($("#siteInfo")) {
                    window.setTimeout(function () {
                        $("#siteInfo").load(root + "/siteInfo.html");
                    }, 1000);
                }
            });
    </script>

    <script type="text/html" id="leftMenuArtTmpl">
        {{each list as obj index}}
        <li id="">
            {{if obj.object.resourceName == '菜单'}}
                <i href="#">
                    <em class="">
                        <img src="${resRoot}/images/{{obj.object.resourceIcon}}"
                             style="font-size:13px;opacity: .7; margin-top: 12px;">
                    </em>
                    <span class="nav-label">{{obj.object.resourceName}}</span>
                </i>
            {{else}}
                <a href="#">
                    <em class="">
                        <img src="${resRoot}/images/{{obj.object.resourceIcon}}"
                             style="font-size:13px;opacity: .7; margin-top: -5px;">
                    </em>
                    <span class="nav-label">{{obj.object.resourceName}}</span>
                    {{if obj.object.resourceName != '首页'}}
                    <span class="fa fa-angle-right arrow"></span>
                    {{/if}}
                </a>
            {{/if}}



            {{if obj.children!=null && obj.children.length>0}}
                {{if obj.object.resourceName != '菜单'}}
                    <ul class="nav nav-second-level collapse" aria-expanded="false">
                        {{each obj.children as child index2}}
                        <li><a {{if child.object.resourceUrl== null}} href='/index/content.html?parentId={{child.object.id}}'
                               {{else}} href='/{{child.object.resourceUrl}}' {{/if}}
                            nav-target="mainFrame" class="leftMenu" > {{child.object.resourceName}}</a>
                        </li>
                        {{/each}}
                    </ul>
                {{else}}
                    <ul class="nav nav-second-level in" aria-expandedsss="true">
                        {{each obj.children as child index2}}
                        <li><a {{if child.object.resourceUrl== null}} href='/index/content.html?parentId={{child.object.id}}'
                               {{else}} href='/{{child.object.resourceUrl}}' {{/if}}
                            nav-target="mainFrame" class="leftMenu" > {{child.object.resourceName}}</a>
                        </li>
                        {{/each}}
                    </ul>
                {{/if}}
            {{/if}}
        </li>
        {{/each}}
    </script>

</head>
<body class="background-gray" style="display:block;">
<div id="wrapper">
    <div class="top">
        <div id="task_music" class="hide"></div>
        <div id="auto_alert" class="hide"></div>
        <input type="hidden" value="${indexDomainTemp}" id="indexDomainTemp"/>
        <input type="hidden" value="${managerDomainTemp}" id="managerDomainTemp"/>
        <input type="hidden" value="${medias}" id="medias"/>
        <input hidden value="${sessionSysUser.userType}">
        <input type="hidden" name="currentSubsysCode" value="${sessionSysUser.subsysCode}">
        <c:set var="subsysCode" value="${sessionSysUser.subsysCode}"/>
        <c:set var="userType" value="${sessionSysUser.userType}"/>
        <c:set var="username" value="${fn:substringBefore(sessionSysUser.username,'@')}"/>
        <div class="pull-right top-account-menu">
            <shiro:hasPermission name="boss:number_statistics">
                <c:if test="${(sessionSysUser.subsysCode) eq 'boss' }">
                    <ul class="tips pull-left">
                        <li class="infos show-info">
                            <a data-toggle="dropdown" style="padding-right: 0px;margin-right: 0px;" onclick='
                        $("#siteInfo .infos").animate({opacity:"0.3"});
                        $("#siteInfo").load(root+"/siteInfo.html",
                        function() {
                          $("#siteInfo .infos").animate({opacity:"1"});
                        }); return false;'>刷新
                            </a>
                        </li>
                    </ul>
                    <ul class="tips pull-left" id="siteInfo"></ul>
                </c:if>
            </shiro:hasPermission>
            <ul class="tips">
                <c:if test="${(sessionSysUser.subsysCode) == 'merchant' or (sessionSysUser.subsysCode) == 'merchant-api' }">
                    <li class="tasks">
                        <input id="isReminderTask" type="hidden" value=""/>
                        <a href="javascript:void(0)" class="locate" data-toggle="dropdown"
                           data-href="${root}/vTaskReminder/index/task.html">
                            　<i class="icon iconfont"></i><span class="label label-orange"
                                                                 id="unReadTaskCount">0</span></a>
                        <dl class="infos_list tasks_list nav-shadow">
                            <dt>任务提醒</dt>
                            <dd class="infos-load">
                                <img src="${resRoot}/images/022b.gif">
                            </dd>
                        </dl>
                    </li>
                    <li class="informations">
                        <a href="javascript:void(0)" class="locate" data-toggle="dropdown">
                            <i class="icon iconfont"></i>
                        </a>
                        <dl class="infos_list nav-shadow">
                            <dd class="infos-none t-left">
                                <div>当前时区：<%= SessionManager.getTimeZone().getID() %>
                                </div>
                                <div>当前时间：
                                    <div id="index-clock" class="clock-show"></div>
                                </div>
                                <div>当前在线人数： <i class="co-orange" id="onlinePlayerNum">0</i>人</div>
                                    <%--<div>当前活跃人数： <i class="co-orange" id="activePlayerNum">0</i>人</div>--%>
                            </dd>
                        </dl>
                    </li>
                </c:if>
                <li class="infos show-info">
                    <a data-toggle="dropdown" class="locate" aria-expanded="false">
                        <img src="${resRoot}/images/user-ico.png">${username}
                    </a>
                    <ul class="information nav-shadow">
                        <c:choose>
                            <c:when test="${subsysCode eq 'merchant-api'}">
                                <c:set var="subsysCodeUri" value="api/merchant"/>
                                <c:set var="shiroPrefix" value="merchant"/>
                            </c:when>
                            <c:when test="${subsysCode eq 'distributor-api'}">
                                <c:set var="subsysCodeUri" value="api/distributor"/>
                                <c:set var="shiroPrefix" value="distributor"/>
                            </c:when>
                            <c:otherwise>
                                <c:set var="subsysCodeUri" value="${subsysCode}"/>
                                <c:set var="shiroPrefix" value="${subsysCode}"/>
                            </c:otherwise>
                        </c:choose>
                        <shiro:hasPermission name="${shiroPrefix}:my_account">
                            <li>
                                <a href="/${subsysCodeUri}/account/mine/index.html" nav-target="mainFrame"
                                   add-table="addTable">
                                    <i class="fa fa-user"></i>我的账户
                                </a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="${shiroPrefix}:my_role">
                            <li>
                                <a href="/${subsysCodeUri}/account/role/list.html" nav-target="mainFrame"
                                   add-table="addTable">
                                    <i class="fa fa-user"></i>我的权限
                                </a>
                            </li>
                        </shiro:hasPermission>
                        <%--system:log：使用系统日志的权限开关--%>
                        <shiro:hasPermission name="system:log">
                            <li>
                                <a href="/${subsysCodeUri}/system/log/logIndex.html?linkSearchRoleType=merchant&linkSearchOperator=${username}"
                                   nav-target="mainFrame"
                                   add-table="addTable"><i class="fa fa-file-excel-o"></i>系统日志</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="${shiroPrefix}:update_my_login_pwd">
                            <li>
                                <a href="javascript:updateLoginPwd('${views.setting['myAccount.updateAccountPassword']}');">
                                    <i class="fa fa-key"></i>修改登录密码
                                </a>
                            </li>
                        </shiro:hasPermission>
                        <%--<shiro:hasPermission name="mine:updateLoginPwd">--%>
                        <%--<li>--%>
                        <%--<a href="javascript:updateLoginPwd('${views.setting['myAccount.updateAccountPassword']}');"><i class="fa fa-key"></i>修改登录密码</a>--%>
                        <%--</li>--%>
                        <%--</shiro:hasPermission>--%>
                        <%--<shiro:hasPermission name="mine:updateSecurityPwd">--%>
                        <%--<li>--%>
                        <%--<a href="javascript:updatePowerPwd('${views.setting['myAccount.updatePrivilegePassword']}');"><i--%>
                        <%--class="fa fa-key"></i>修改安全密码</a></li>--%>
                        <%--</shiro:hasPermission>--%>
                        <li class="off"><a href="${root}${logoutUrl}" target="_top">退出 <i
                                class="fa fa-power-off"></i></a></li>
                    </ul>
                </li>
                <!--站点列表结束-->
            </ul>
        </div>
        <div class="row top-navigation border-bottom white-bg">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-header">
                    <div href="javascript:void(0)" class="navbar-brand">
                        <div class="arrows-wrap">
                            <a id="hamburger-4" class="hamburger navbar-minimalize" href="javascript:void (0)">
                                <span class="line"></span>
                                <span class="line"></span>
                                <span class="line"></span>
                            </a>
                        </div>
                        <c:choose>
                            <c:when test="${not empty logo
                            and (sessionSysUser.subsysCode eq 'merchant' or sessionSysUser.subsysCode eq 'distributor' or sessionSysUser.subsysCode eq 'merchant-api' or sessionSysUser.subsysCode eq 'distributor-api')
                            and logo ne 'Logo/1/1459172297237.png'}">
                                <img data-url="${soulFn:getImagePath(domain, logo)}"
                                     src="${soulFn:getThumbPath(domain, logo, 166, 64)}">
                            </c:when>
                            <c:when test="${not empty logo and (sessionSysUser.subsysCode eq 'boss' or sessionSysUser.subsysCode eq 'shareholder')}">
                                <img src="${resRoot}/images/logo.png"/>
                            </c:when>
                            <c:when test="${empty logo or logo eq 'Logo/1/1459172297237.png'}"><span
                                    style="margin-left: 40px">${siteTilte}</span></c:when>
                        </c:choose>
                    </div>
                    <%--时间显示暂时取消--%>
                    <%--<span class="footer-clock pull-left navbar-brand" style="font-size: 12px;">--%>
                    <%--<span><i class="icon iconfont"></i>当前时区：</span>--%>
                    <%--<span id="userTime"><%= SessionManager.getTimeZone().getID() %>(美东时间)</span>--%>
                    <%--<span id="index-clock" class="clock-show"></span>--%>
                    <%--</span>--%>
                </div>
            </nav>
        </div>
    </div>
    <div id="toFrame">
        <div>
            <nav name="leftIndexForm" class="navbar-default navbar-static-side shadow" role="navigation">
                <%--style里面样式为左侧菜单滚动条--%>
                <div class="sidebar-collapse tempTest" style="width: 100%;height: 100%;overflow-y: scroll;">
                    <ul class="nav" id="side-menu">

                    </ul>
                </div>
            </nav>
            <div id="page-wrapper" class="gray-bg dashbard-1">
                <nav class="navbar-default">
                    <div class="win-tab">
                        <a id="tab-scroll-left" style="display: inline;"><em class="fa fa-arrow-left"></em></a>
                        <a id="tab-scroll-right" style="display: inline;"><em class="fa fa-arrow-right"></em></a>
                        <ul class="top_tab_wrap show-jt" id="tab-scroll"></ul>
                    </div>
                </nav>
                <div id="mainFrame"
                     style="min-height: 780px; overflow-x: hidden;overflow-y: auto;height: 790px;margin-right: -10px;">
                </div>

                <div class="footer" style="display: none">
                    <div class="a-copy clearfix">
                    </div>
                </div>
            </div>
        </div>
        <!--推送消息弹出矿开始-->
        <div class="real-time-inform">
            <div class="clearfix"><span class="unfold open">
                <i class="fa fa-angle-double-up m-r-xs pull-left"></i>
                <a href="javascript:void(0)" class="unfold-z"></a>
                <a href="javascript:void(0)" class="unfold-s"></a></span>
            </div>
            <div class="max-ccc "></div>
            <div id="newMessageDIV"></div>
        </div>

        <!--推送消息弹出矿结束-->
    </div>
</div>

<script type="text/javascript"
        src="${root}/message_<%=SessionManagerCommon.getLocale().toString()%>.js?v=${rcVersion}"></script>
</body>

<%-- 触发错误页面 --%>
<div style="display: none">
    <a id="e403" href="${root}/errors/403.html" nav-target="mainFrame"></a>
    <a id="e404" href="${root}/errors/404.html" nav-target="mainFrame"></a>
    <a id="e600" href="${root}/errors/600.html" nav-target="mainFrame"></a>
</div>

<div class="preloader"></div>
<div id="mainFrame2" style="display: none;"></div>
<div id="subPageCache" style="display: none;"></div>
</html>

