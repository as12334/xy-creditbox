
    <%@ page contentType="text/html;charset=UTF-8" %>
    <%@ include file="/include/include.inc.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>用戶登錄</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
        <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">
        <script>
            var isDisplayCode =  false;
            var jsver=20191126;
            var myLayerIndex = '19841011';
            var myLayerIndexArr = [];
        </script>
    <%--<script src="Scripts/sea.js" type="text/javascript"></script>--%>
    <%--<script src="Scripts/otherConfig.js" type="text/javascript"></script>--%>
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
    <form id="login">
        <div class="AL_t01"></div>
        <div class="AL_t022">
            <div class="AL_t02">
                <input type="hidden" name="username"/>
                <input type="hidden" name="siteCode" value="${siteCode}"/>
                <ul>
                    <li><input data-type="text" type="text" value="" id="loginName" name="name" tabindex="1" class="text" placeholder="請輸入您的用戶名" /></li>
                    <li><input data-type="text" type="password" value="" tabindex="2" id="loginPwd" name="password" class="text" placeholder="請輸入您的密碼" /></li>
                    <li style="display:none;"><input  data-type="text" type="text" id="pic_input" name="ValidateCode"  tabindex="3" maxlength="4" class="w80 text" placeholder="驗證碼" autocomplete="off" /><span><img id="pic_code" style="height:32px; display:none; width:100px; cursor:pointer;position:absolute; right:26px; top:0px;" title="" ></span></li>
                </ul>
                <button type="button" class="loginBtn" id="login_btn">登 錄</button>
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
    function doLogin(){




    }
</script>

<script>
    window.onload = function () {
        seajs.use('login');
    };
</script>
</body>
</html>
