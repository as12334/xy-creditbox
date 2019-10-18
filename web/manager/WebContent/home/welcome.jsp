<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="logoutUrl" value="<%= SessionManager.getLogoutUrl() %>"/>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
    <title>欢迎进入彩票管理后台</title>

    <style>
        .welcome-tybg{
            background-color:#4cae4c;
            background-image:  url(${resRoot}/images/welcome-bg.png);
            background-repeat: no-repeat;
            background-position:bottom;
            background-size: 100%;
            margin: 0;
            padding: 0;
            height: 100%;
        }
        .welcome-tylogo{
            background-image: url(${resRoot}/images/welcome-logo.png);
            background-repeat: no-repeat;
            background-position: center;
            background-size: 48%;
            width: 100%;
            height: 447px;
            position: absolute;
            top: calc(50% - 250px);
        }
        .main{
            width: 100%;
            height: 771px;
        }
        .mian_head{
            width: 100%;
            height: 10px;
        }

        .main_top{
            width: 100%;
            height: 400px;
            margin-top: 5px;
        }
        .main_mid{
            width: 100%;
            height: 400px;
        }
        .main_below{
            width: 100%;
            height: 260px;
        }
        .main_div_left{
            width: 50%;
            height: 100%;
            float: left;
        }
        .main_div_right{
            width: 50%;
            height: 100%;
            float: right;
        }
    </style>

</head>
<body>
<div class="main" id="welcomeMerchant">
<div class="row">
    <div class="position-wrap clearfix">
        <span>首页</span><span>/</span><span>数据</span>
        <input type="hidden" name="search.currentSubsysCode" value="${sessionSysUser.subsysCode}">
    </div>
    <div class="col-lg-12">
        <div id="editable_wrapper" class="dataTables_wrapper" role="grid">
            <ul class="clearfix sys_tab_wrap top_menu">
                <li id="li_top_1" class="active" data-index="systemDepositList">
                    <soul:button target="event_today_active" permission="" text="今日数据" opType="function"
                                 url="/chart/report/queryReportToday.html"/>
                </li>
                <li id="li_top_2" class="" data-index="systemDepositList">
                    <soul:button target="event_today_active" permission="" text="平台数据" opType="function"
                                 url="/chart/report/queryGame.html"/>
                </li>


            </ul>
        </div>
    </div>
    <div class="col-lg-12 m-t">
        <div class="wrapper shadow white-bg" id="search-list-container" style="height: 790px">
            <div class="search-list-container">
                <%@ include file="IndexPartial.jsp"%>

            </div>
        </div>
        <div class="wrapper shadow white-bg" id="search-list-container2" style="display: none;height: 1180px;">
            <div class="search-list-container2" >
                <%@ include file="IndexPartial2.jsp"%>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
<soul:import res="site/home/welcome"/>
</html>
