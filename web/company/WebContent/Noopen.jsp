<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <link href="favicon.ico" rel="shortcut icon">
    <%--<link id="Iframe_skin" href="Styles/Yellow/noopen.css" rel="stylesheet" type="text/css" />--%>


    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <link id="Iframe_skin" rel="stylesheet" type="text/css" href="${resRoot}/themes/blue/noopen.css?v=${rcVersion}"/>

    <script>
        var currentTime = "${soulFn:formatDateTz(command.closeTime, DateFormat.DAY_SECOND, timeZone)}";
        var endTime = "${soulFn:formatDateTz(command.openingTime, DateFormat.DAY_SECOND, timeZone)}";
        var lotteryName = "";
        var url = "/${command.code}/index.html?lid=0";
        var lid = "0";
        var oldId = 0;
        var phase = '';
    </script>
</head>
<body>
<div class="top"></div>
<div class="wrap">
    <div id="six" style="display:none">
        <h1>已截止下註<div class="kjBtn11"><a href="javascript:;" id="kjBtn" title="點擊查看開獎日期">開獎日期表</a></div></h1>
        <p id="openBox" class="L_SIX base-clear"><span style="float:left">第<span id="phase" class="red"></span>期開獎號碼：</span>
            <span id="openBall"></span>
        </p>
    </div>
    <div id="kc" style="display:none">
        <h1>${views.page["LotteryCode.".concat(command.code)]} 當前未開盤</h1>
        <p><em id="openTime"></em></p>
    </div>
</div>
<script type="text/javascript">
    var subInit = {
        pageScrollTop: function (sTop) { }
    };
    seajs.use('noopen', function (noopen) {
        noopen();
    });
</script>

</body>
</html>