<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%--<%@ include file="/include/include.head.jsp" %>--%>

    <%@ include file="/include/include.js.jsp" %>
    <title>${siteName}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<link href="/images/favicon.ico" rel="shortcut icon">--%>
    <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">

    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/skin/main.css?v=${rcVersion}"/>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/jquery-ui-1.8.21.custom.css?v=${rcVersion}"/>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/number.css?v=${rcVersion}"/>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/globals.css?v=${rcVersion}"/>


    <title>${siteName}</title>
</head>
<body class="skinGreen">
<div class="topBox widthAuto" id="topBox">
    <div class="jpBox" id="scrollDiv">
        <ul id="autoOddsList" style="margin-top: 0px;">
            <li>『廣東快樂十分<span class="green">第2019090914期</span>第一球<span class="blue">01</span> 升<span
                    class="red">0.01</span>』 13:38:11
            </li>
            <li>『廣東快樂十分<span class="green">第2019090914期</span>第一球<span class="blue">01</span> 降<span
                    class="red">0.01</span>』 13:33:54
            </li>
            <li>『廣東快樂十分<span class="green">第2019090914期</span>第一球<span class="blue">01</span> 升<span
                    class="red">0.01</span>』 13:38:10
            </li>
        </ul>
    </div>
    <div class="top">
        <div class="log-bg">
            <span class="log-text">${siteName}</span>
        </div>
        <div class="on-line">
            <span>在线:<b id="online">2</b></span>
            <span id="myRoleName">總公司:admin</span>
        </div>
        <div class="skin-change" id="skinChange">
            <table class="skinTb">
                <tbody>
                <tr>
                    <td>
                        <div id="skinWrap">
                            <a href="javascript:;" class="skinBtn">換膚</a>
                            <div id="skinBox" style="display: none;">
                                <a class="Green active" data-skin="Green"
                                   href="javascript:;"><em><i></i></em><span>綠色</span></a>
                                <a class="Blue active" data-skin="Blue"
                                   href="javascript:;"><em><i></i></em><span>蓝色</span></a>
                                <a class="Violet" data-skin="Violet" href="javascript:;"><em><i></i></em><span>紫色</span></a>
                                <a class="Yellow" data-skin="Yellow" href="javascript:;"><em><i></i></em><span>黄色</span></a>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

        </div>
        <div class="lb-on" id="voice"></div>
        <div class="scroll">
            <marquee onmouseover="this.setAttribute(&#39;scrollamount&#39;, 0, 0);"
                     onmouseout="this.setAttribute(&#39;scrollamount&#39;, 2, 0);" direction="left" scrolldelay="4"
                     scrollamount="2" behavior="scroll"><span id="autoNews">asdfasdfasdfasdfasdfasdfaewfasvad</span>
            </marquee>
        </div>
        <div style="display: none; clear: left; visibility: visible;" id="sound">
            播放声音
        </div>


    </div>
    <div class="menuBox">
        <!-- 下拉选项 -->
        <div class="navBox" id="gameAll">
            <i class="up"></i>
            <b class="down"></b>
            <span id="gameDefault" data-code="${lotterys[0].code}">${lotterys[0].name}</span>
            <div class="navList" id="gameList">
                <ul>
                    <c:forEach items="${lotterys}" var="i" varStatus="status">
                            <li><a href="javascript:void(0);" data-code="${i.code}">${i.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!-- 1级导航栏 -->
        <div class="menu">
            <ul id="menuUl">
                <%--<li data-action="immediate" class="on">即時注單</li>--%>
                <%--<li data-action="1">用戶管理</li>--%>
                <%--<li data-action="2">系統管理</li>--%>
                <%--<li data-action="3">註單管理</li>--%>
                <%--<li data-action="4">开奖管理</li>--%>
                <%--<li data-action="6">個人管理</li>--%>
                <%--<li data-action="5">報表查詢</li>--%>
                <%--<li data-action="7" class="">歷史開獎</li>--%>
                <%--<li data-action="8" class="">站内消息</li>--%>
                <%--<li data-action="out">安全退出</li>--%>
            </ul>
        </div>
    </div>
    <!-- 2级导航栏 -->
    <div class="navListBox" id="navListBox">
        <%--<a href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=1" class="onBtn">第一球</a><b>|</b>--%>
        <%--<a href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=2">第二球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=3">第三球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=4">第四球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=5">第五球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=6">第六球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=7">第七球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=8">第八球</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=9">正碼、總和</a><b>|</b><a--%>
            <%--href="javascript:void(0);" data-action="gamedata&amp;gameIndex=2&amp;type=10">連碼</a></div>--%>
</div>
<div id="mainFrame">
    <!--//region your codes 1-->

</div>
    <lb:validateRule/>

<script type="text/javascript" src="${root}/message_<%=SessionManagerCommon.getLocale().toString()%>.js?v=${rcVersion}"></script>
<script language="javascript" type="text/javascript">
    window.top.language="zh-CN";
</script>

<script type="text/javascript">
    curl(['site/home/Top','lb/xy/TopPage'], function(Page,TopPage) {
        page = new Page();
        topPage = new TopPage();
    });
</script>
<%--<script type="text/javascript" src="${resRoot}/js/home/Top.js"></script>--%>

</body>
</html>