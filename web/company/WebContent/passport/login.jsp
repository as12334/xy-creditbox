
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用戶登錄</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <link href="favicon.ico" rel="shortcut icon">
    <script>
        var isDisplayCode =  false;
        var jsver=20191126;
        var myLayerIndex = '19841011';
        var myLayerIndexArr = [];
    </script>
    <style>
        .btnD{
            background: #ccc!important;
            color: #999!important;
        }
    </style>
</head>

<body>

<link href="${resRoot}/themes/login/default/userlogin.css" rel="stylesheet" type="text/css" />

<%@ include file="/include/include.js.jsp" %>

<div class="AL_box">
    <form id="login" method="post">
        <div class="AL_t01"></div>
        <div class="AL_t022">
            <div class="AL_t02">
                <ul>
                    <input type="hidden" name="siteCode" value="${siteCode}" class="form-control" >
                    <input hidden  data-type="text" type="text" value=""  name="username" tabindex="1" class="text" />

                    <li><input data-type="text" type="text" value="" id="loginName" name="name" tabindex="1" class="text" placeholder="請輸入您的用戶名" data-issubmit="1"></li>
                    <li><input data-type="text" type="password" value="" tabindex="2" id="loginPwd" name="password" class="text" placeholder="請輸入您的密碼" data-issubmit="1"></li>
                </ul>
                <button id="login_btn" type="button" value="Login" class="loginBtn" onclick="doLogin()">登 錄</button>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="AL_t03">
            <label>

            </label>
            <div class="copy">版權所有   <span id="year"></span>  All  Rights  Reserved</div>
        </div>
    </form>
    <div class="clear"></div>
</div>


<script>
    window.onload = function () {
        seajs.use('jquery');
    };
</script>

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
</body>
</html>
