<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%--<%@ include file="/include/include.head.jsp" %>--%>
    <script src="${resComRoot}/js/lotterybox/common/main.js"></script>

    <%@ include file="/include/include.js.jsp" %>
    <title>用戶登錄</title>
    <meta name="keyword" content="">

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">

    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/default/userlogin.css?v=${rcVersion}"/>
    <%--<script src="${resRoot}/js/login.js" type="text/javascript"/>--%>


    <script>
        var jsver=20170128;
        var isDisplayCode = false;
        var sysver=1
    </script>
    <%--<script src="./login_files/sea.js.下载" type="text/javascript"></script>--%>
    <%--<script src="./login_files/config.js.下载" type="text/javascript"></script>--%>
    <style>
        .btnD{
            background: #ccc!important;
            color: #999!important;
        }
    </style>
</head>

<body>

<%--<link href="./login_files/userlogin.css" rel="stylesheet" type="text/css">--%>
<div class="AL_box">
    <form id="login" method="post">
        <div class="AL_t01"></div>
        <div class="AL_t02">
            <div class="left"></div>
            <div class="right">
                <ul>
                    <input type="hidden" name="siteCode" value="${siteCode}" class="form-control" >
                    <input hidden  data-type="text" type="text" value=""  name="username" tabindex="1" class="text" />

                    <li><input data-type="text" type="text" value="" id="loginName" name="name" tabindex="1" class="text" placeholder="請輸入您的用戶名" data-issubmit="1"></li>
                    <li><input data-type="text" type="password" value="" tabindex="2" id="loginPwd" name="password" class="text" placeholder="請輸入您的密碼" data-issubmit="1"></li>
                </ul>
                <div class="btnBox">
                    <button id="login_btn" type="button" value="Login" class="loginBtn" onclick="doLogin()">登 錄</button>
                </div>
            </div>
            <div class="clear"></div>
        </div>

    </form>
    <div class="copy">版權所有   <span id="year">2019</span>  All  Rights  Reserved</div>
    <div class="clear"></div>
</div>


<script>
    window.onload = function () {
        seajs.use('login');
    }
</script>


<%--<soul:import res="site/login"/>--%>

<script>
    function doLogin(){
    var password = $("[name='password']").val();
    var name = $("[name='name']").val();
    var siteCode = $("[name='siteCode']").val();
    $("[name='username']").val(name+'@'+siteCode);
    var username = $("[name='username']").val();


    if(name=="" || username==""){
        alert("用户名不能为空！");
        return;
    }


    if(password==""){
        alert("密码不能为空！");
        return;
    }

    $("#login").submit();
}
</script>

</body></html>