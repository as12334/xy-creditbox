<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="logoutUrl" value="<%= SessionManager.getLogoutUrl() %>"/>
<html>
<head>
    <%@ include file="/include/include.head.jsp" %>
    <title>欢迎进入LT彩票管理后台</title>

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
    </style>

</head>
<body>
<div class="welcome-tybg">
<div class="welcome-tylogo">

</div>
</div>
</body>
</html>
