<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%--<%@ include file="/include/include.head.jsp" %>--%>

    <%@ include file="/include/include.js.jsp" %>
    <title>用戶登錄</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">
    <%--<link rel="stylesheet" type="text/css" href="${resRoot}/themes/skin/main.css?v=${rcVersion}"/>--%>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/skin/yellow/userlogin.css?v=${rcVersion}"/>

    <%--<script type="text/javascript" src="/scripts/jquery.js"></script>--%>
    <%--<script type="text/javascript" src="/scripts/globals.js"></script>--%>
    <title>${siteName}</title>
</head>

<body >



<div class="AL_box">
    <form id="login" method="post">
        <div class="AL_t01"></div>
        <div class="AL_t02">
            <ul>
                <input type="hidden" name="siteCode" value="${siteCode}" class="form-control" >
                <input hidden  data-type="text" type="text" value=""  name="username" tabindex="1" class="text" />



                <li><input  data-type="text" type="text" value=""  name="name" tabindex="1" class="text" placeholder="請輸入您的用戶名" /></li>
                <li><input  data-type="text" type="password" value="" tabindex="2" name="password" class="text" placeholder="請輸入您的密碼" /></li>
                <%--<li style=""><input  data-type="text" type="text" id="pic_input" name="captcha"  tabindex="3" autocomplete="off" maxlength="4" class="w100 text" placeholder="請輸入驗證碼" /><span><img onclick="changeCode()" src="${root}/captcha/code.html" id="pic_code" style="height:32px;  width:100px; cursor:pointer;position:absolute; right:0px; top:0px;" title="" ></span></li>--%>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="form-group" id="authentication-error-msg">
            ${sessionScope.SK_Passport_Rs.propMessages["authentication"]}${sessionScope.SK_Passport_Rs.message}
        </div>
        <div class="AL_t03">
            <label>
                <button type="button" class="loginBtn" id="login_btn" onclick="doLogin()">登 錄</button>
            </label>
            <div class="copy">版權所有   2019  All  Rights  Reserved</div>
        </div>
    </form>
    <div class="clear"></div>
</div>
</body>
<script>function doLogin(){

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

</html>
