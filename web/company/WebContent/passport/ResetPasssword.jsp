<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head >

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>變更密碼</title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <title>title</title>
    <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">
    <%--<link rel="stylesheet" href="/Styles/BallCss/ball_all.css">--%>
    <%--<link id="Iframe_skin" rel="stylesheet" href="/Styles/Green/skin.css">--%>
    <%--<link rel="stylesheet" href="/Styles/global.css">--%>
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <%--<script src="/Scripts/json2.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/sea.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/seajs-css.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/otherConfig.js" type="text/javascript"></script>--%>


    <%@ include file="/include/include.js.jsp" %>
    <%@ include file="/include/include.head.jsp" %>

    <style>
        body{ background:#fff; width:100%;}
    </style>
</head>
<body>
<!--主体部分-->
<form method="post" id="subform">
    <div style="width:510px; margin:10% auto 0 auto;">
        <div class="myLayer" style="margin: 0 auto;">
            <div class="myLayerTitle"><h3>重置上級修改的密碼</h3></div>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                <tr>
                    <td valign="top">

                        <table class="t_list" style="width:450px; margin:7px;">
                            <tr>
                                <td align="right" width="120" class="tdbg1">原始密碼 </td>
                                <td align="left">&nbsp;<input type="password" name="txtoldpwd" id="txtoldpwd" class="text w130" />&nbsp;&nbsp;請輸入原始密碼<div class="userTips"></div></td>
                            </tr>
                            <tr>
                                <td align="right" class="tdbg1">新設密碼 </td>
                                <td align="left">&nbsp;<input type="password" name="txtnewpwd" id="txtnewpwd" class="text w130" /><span class="passwordStrength"><span>弱</span><span>中</span><span>强</span></span><span class="passwordTip">8-20位,且必需包含字母和数字！</span></td>
                            </tr>
                            <tr>
                                <td align="right" class="tdbg1">確認密碼 </td>
                                <td align="left">&nbsp;<input type="password" name="txtnewpwdcf" id="txtnewpwdcf" class="text w130" />&nbsp;&nbsp;请您再一次输入新密码<div class="userTips"></div></td>
                            </tr>
                        </table>

                    </td>
                </tr>
            </table>
            <div style=" text-align:center; margin-top:7px; height:30px;"><button type="reset" name="resetBtn" id="resetBtn" class="btn1">重填</button>&nbsp;<button type="button" name="Submit" id="validFormBtn" class="btn1">確定修改</button><input type="hidden" name="hdnsubmit" id="hdnsubmit" value="submit" /></div>
        </div>
    </div>
</form>
<div id="alert_show"></div>

<script>
    var myLayerIndex = '19841011';
    var myLayerIndexArr = [];
    window.onload = function () {
        seajs.use(['jquery', 'checkPwd'], function ($, checkPwd) {

            $("#validFormBtn").click(function () {
                if(validOldForm() && validNewForm() && validcfForm()){
                    submitForm();
                }
            });
            $("#txtoldpwd").unbind('keyup').bind('keyup',function(){
                validOldForm();
            });
            $("#txtnewpwd").unbind('keyup').bind('keyup',function(){
                validNewForm();
            });
            $("#txtnewpwdcf").unbind('keyup').bind('keyup',function(){
                validcfForm();
            });

            function validOldForm() {
                var isOk = false;
                if ($("#txtoldpwd").val().length == 0) {
                    $("#txtoldpwd").siblings('.userTips').html('‘原始密碼’不能為空！').removeClass('tipsRight').addClass('tipsWrong');
                    $("#txtoldpwd").focus();
                    isOk = false;
                    return;
                }else{
                    $("#txtoldpwd").siblings('.userTips').html('').removeClass('tipsWrong');
                    $("#txtnewpwdcf").siblings('.userTips').html('').removeClass('tipsWrong');
                    isOk = true;
                }
                return isOk;
            }

            function validNewForm() {
                var isOk = false;
                if (!checkPwd.init($("#txtnewpwd"))) {
                    $("#txtnewpwd").focus();
                    isOk = false;
                    return;
                }else{
                    isOk = true;
                }
                return isOk;
            }

            function validcfForm() {
                var isOk = false;
                if ($("#txtnewpwdcf").val().length == 0) {
                    $("#txtnewpwdcf").siblings('.userTips').html('‘確認密碼’不能為空！').removeClass('tipsRight').addClass('tipsWrong');
                    $("#txtnewpwdcf").focus();
                    isOk = false;
                    return;
                }else if ($("#txtnewpwd").val() != $("#txtnewpwdcf").val()) {
                    $("#txtnewpwdcf").siblings('.userTips').html('‘新設密碼’與‘確認密碼’不一致！').removeClass('tipsRight').addClass('tipsWrong');
                    $("#txtnewpwdcf").focus();
                    isOk = false;
                    return;
                }else{
                    $("#txtnewpwdcf").siblings('.userTips').html('').removeClass('tipsWrong');
                    isOk = true;
                }
                return isOk;
            }

            function submitForm() {
                $.ajax({
                    type: 'POST',
                    url: root + "/passport/updatePwd.html",
                    data: $('#subform').serialize(),
                    error: function (e) {
                        if(e.status == 600){
                            window.location.href = root + "/passport/login.html";
                        }
//                        alert('处理程序出错,请通知管理员检查！');
                        },
                    success: function (msg) {
                        $("#alert_show").html(msg);
                    }
                })
            }
        })
    };
</script>

</body>
</html>
