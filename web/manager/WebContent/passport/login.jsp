<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%@ include file="/include/include.head.jsp" %>
    <title>${siteName}</title>
</head>

<body <c:if test="${root!='/acenter'}">class="login"</c:if><c:if test="${root=='/acenter'}">style="background-color: #445862;box-shadow: inset 0 20px 50px rgba(0,0,0,0.2);" </c:if>>
<form action="${root}${requestScope.loginUrl}" method="post" id="loginForm">
    <div id="preview">
        <div id="preview-container">
            <div class="login-logo" style="width: 700px;">
                <c:if test="${root!='/acenter'}"><span class="fs24 m-l-sm">彩票管理中心</span></c:if>
            </div>

            <div class="login-bl">
                <input type="hidden" name="url" value="${root}/"/>
                <div class="clearfix">
                    <span class="fs24 m-b-sm pull-left">登录</span>
                    <span class="pull-right line-hi34">
                    </span>
                </div>
                <div class="form-group">
                    <div class="ico-left"><em class="fa fa-user" style="color: #333333"></em></div>
                    <input type="text"  name="name" value="" class="form-control" placeholder="用户名" autocomplete="off" >
                    <input type="hidden" name="siteCode" value="${siteCode}" class="form-control" >
                    <input type="hidden"  name="username" value="" class="form-control"  placeholder="用户名" autocomplete="off" >

                </div>
                <div class="form-group" id="username-error-msg">
                    ${SK_Passport_Rs.propMessages["username"]}
                </div>
                <div class="form-group">
                    <div class="ico-left"><em class="fa fa-unlock-alt" style="color: #333333"></em></div>
                    <input name="password" type="password" class="form-control" placeholder="密码" value="" autocomplete="off">
                </div>
                <div class="form-group" id="password-error-msg">
                    ${sessionScope.SK_Passport_Rs.propMessages["password"]}
                </div>
                    <c:if test="${sessionScope.SK_Passport_Rs.isOpenCaptcha}">
                        <input type="hidden" name="type" value="code">
                        <div class="form-group clearfix ">
                            <div class="input-group date">
                              <span class="input-group-addon abroder-no"><b>验证：</b></span>
                              <input type="text" name="captcha" maxlength="4" class="form-control" placeholder="请输入验证码" value="">
                              <span class="verify-img"><img class="captcha-code" src="${root}/captcha/code.html"></span>
                              <span class="input-group-addon abroder-no"><soul:button target="changeCode" tag="a" text="" opType="function">换一张</soul:button></span>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${subsysCode!='mcenterAgent'&&subsysCode!='mcenterTopAgent'}">
                        <div class="form-group">
                            <input type="number" name="authentication" oninput="value=value.replace(/[^\d]/g,'').slice(0,6)" class="form-control" placeholder="请输入身份验证码" value="">
                        </div>
                    </c:if>
                <div class="form-group" id="authentication-error-msg">
                    ${sessionScope.SK_Passport_Rs.propMessages["authentication"]}${sessionScope.SK_Passport_Rs.message}
                </div>
                <div class="login-btn-1">
                    <button type="button" onclick="doLogin()" class="btn btn-filter full-width btn-lg btn-block">立即登录</button>
                </div>
            </div>
        </div>
    </div>

    <input type="hidden" name="subsysCode" value="${subsysCode}">
    <div class="hint-box" style="display: none" >
        <span class="hint-content">
            <i class="fa fa-exclamation-circle"></i>
            ${views.privilege[subsysCode]}
            <soul:button target="closeHint" cssClass="close" tag="button" text="" opType="function">
                <span aria-hidden="true">×</span>
                <span class="sr-only">关闭</span>
            </soul:button>
        </span>
    </div>
</form>

<script type="text/javascript" src="${root}/message_<%=SessionManagerCommon.getLocale().toString()%>.js?v=${rcVersion}"></script>
<script type="text/javascript">
    var language = '${language.replace('_','-')}';
</script>
<%@ include file="/include/include.js.jsp" %>
<script>
    curl(['lb/home/TopPage','common/Login'], function(TopPage,Page) {
        topPage = new TopPage();
        page = new Page();
        page.bindButtonEvents();
    });

    function doLogin(){

        var password = $("[name='password']").val();
        var name = $("[name='name']").val();
        var siteCode = $("[name='siteCode']").val();
        $("[name='username']").val(name+'@'+siteCode);
        var username = $("[name='username']").val();


        if(name==""){
            $("#username-error-msg").text("用户名不能为空");
            $("[name='name']").focus();
            return;
        }else{
            $("#username-error-msg").text("");
        }

        if(username==""){
            $("#username-error-msg").text("用户名不能为空");
            $("[name='username']").focus();
            return;
        }else{
            $("#username-error-msg").text("");
        }

        if(password==""){
            $("#password-error-msg").text("密码不能为空");
            $("[name='password']").focus();
            return;
        }else{
            $("#password-error-msg").text("");
        }

        if($("[name='authentication']").length>0&&$("[name='authentication']").val()==""){
            $("#authentication-error-msg").text("身份验证码不能为空");
            $("[name='authentication']").focus();
            return;
        }else{
            $("#authentication-error-msg").text("");
        }

        $("#loginForm").submit();
    }
</script>

</body>
</html>