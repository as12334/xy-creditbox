<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>找回密码 | </title>
    <%@ include file="/include/include.base.inc.jsp" %>
    <link href="${resComRoot}/themes/default/forgetpassword/bootstrap.min.css" rel="stylesheet">
    <link href="${resComRoot}/themes/default/forgetpassword/common.css" rel="stylesheet">
    <link href="${resComRoot}/themes/default/forgetpassword/style.css" rel="stylesheet">
    <script src="${resComRoot}/js/jquery/jquery-2.1.1.js" type="text/javascript"></script>
    <script src="${resComRoot}/js/jquery/plugins/jquery.validate/jquery.validate.js"></script>
</head>

<body>

<input name="step" type="hidden" id="step">
<div class="main-jumbotron">
    <div class="container-fluid no-full">
        <div class="row">
            <div class="col-lg-12">
                <div class="branding text-white">
                    <img src="${resRoot}/images/logo.png" class="tamashi-logo"> | 找回登录密码
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid no-full m-t">
        <div class="row">
            <form id="findPasswordForm" class="form-horizontal" >
                <input name="encryptedId" value="" id="encryptedId" type="hidden">
                <input name="checkPassword" value="" id="checkPassword" type="hidden">
                <div style="display: none" id="validateRule">${forgetPasswordValidateRule}</div>

                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <!-- <div class="row"> -->
                        <div class="wizard">
                            <ul class="nav nav-pills nav-justified thumbnail nav-wizard">
                                <li class="disabled active">
                                    <a href="#step1" data-toggle="tab">
                                        <h3 class="list-group-item-heading">1</h3>
                                        <p class="list-group-item-text">输入账号</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step2" data-toggle="tab">
                                        <h3 class="list-group-item-heading">2</h3>
                                        <p class="list-group-item-text">选择校验方式</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step3" data-toggle="tab">
                                        <h3 class="list-group-item-heading">3</h3>
                                        <p class="list-group-item-text">重置密码</p>
                                    </a>
                                </li>
                                <li class="disabled">
                                    <a href="#step4" data-toggle="tab">
                                        <h3 class="list-group-item-heading">4</h3>
                                        <p class="list-group-item-text">完成</p>
                                    </a>
                                </li>
                            </ul>
                            <div class="tab-content m">
                                <div class="tab-pane active" id="step1">
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">账号</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="forgetUserName" maxlength="20" placeholder="请输入你的账号">
                                            <small class="help-block" data-bv-validator="notEmpty" data-bv-for="forgetUserName" data-bv-result="VALID"></small>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-sm-3 control-label">验证码</label>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                <input type="text" class="form-control" name="forgetPasswordCaptchaCode" maxlength="4" placeholder="验证码">
                                                <span class="input-group-btn"><a><img src="${root}/captcha/forgetPassword.html" alt="" class="_captcha_code" data-code="forgetPassword" onclick="changeCaptcha(this)" alt="" ></a></span>
                                            </div>
                                            <small class="help-block-2" data-bv-validator="notEmpty" data-bv-for="forgetPasswordCaptchaCode" data-bv-result="VALID"></small>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <a class="btn primary-btn -blue -sm continue" onclick="nextStep(2)">&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="step2">
                                    <div class="list-group findTypeGroup">
                                        <a href="#" class="list-group-item _emailCanUse" style="display: none"  data-find-type="email">
                                            <h4 class="list-group-item-heading text-info">邮箱验证</h4>
                                            <p class="list-group-item-text">若您账户绑定的电子邮箱<span class="text-info"  player-email=""></span>仍在正常使用中，请选择此验证方式。</p>
                                        </a>
                                        <a href="#" class="list-group-item _protectionCanUse" style="display: none"  data-find-type="protection">
                                            <h4 class="list-group-item-heading text-info">安全问题验证</h4>
                                            <p class="list-group-item-text">若您记得设置的安全问题的答案，请选择此验证方式。</p>
                                        </a>
                                        <a href="${customService}" class="list-group-item" data-find-type="customerervice" target="_blank">
                                            <h4 class="list-group-item-heading text-info">联系客服处理</h4>
                                            <p class="list-group-item-text">暂无其他可使用的验证方式，请直接联系在线客服。</p>
                                        </a>
                                        <input name="findWay" type="hidden" id="findWay">
                                    </div>
                                    <hr>
                                    <div class="form-group">
                                        <div class="col-sm-12 text-center">
                                            <a class="btn primary-btn -blue -sm continue" onclick="nextStep(3)">&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane _findTypeGroup" id="step3" find-type="protection" style="display: none">
                                    <!-- 安全问题验证 -->
                                    <div find-way="protection" style="display: none"  class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">问题一：</label>
                                        <div class="col-sm-6">
                                            <p class="form-control-static _answer1">我爷爷的名字是？</p>
                                        </div>
                                    </div>
                                    <div find-way="protection"  style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">答案：</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="forgetPasswordAnswer1" maxlength="20" placeholder="请输入答案">
                                        </div>
                                    </div>
                                    <hr>
                                    <div  find-way="protection" style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">问题二：</label>
                                        <div class="col-sm-6">
                                            <p class="form-control-static _answer2">我的幸运数字是？</p>
                                        </div>
                                    </div>
                                    <div find-way="protection"  style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">答案：</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="forgetPasswordAnswer2" maxlength="20" placeholder="请输入答案">
                                        </div>
                                    </div>
                                    <hr>
                                    <div find-way="protection"  style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">问题三：</label>
                                        <div class="col-sm-6">
                                            <p class="form-control-static _answer3">我的工号是？</p>
                                        </div>
                                    </div>
                                    <div find-way="protection" style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">答案：</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" name="forgetPasswordAnswer3" maxlength="20" placeholder="请输入答案">
                                        </div>
                                    </div>
                                    <hr>
                                    <div find-way="protection" style="display: none" class="form-group">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <a class="btn primary-btn -blue -sm continue" href="javascript:void(0)" onclick="showChangePwdForm()">&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                        </div>
                                    </div>
                                    <!-- 邮件验证码验证 -->
                                    <div find-way="email" style="display: none" class="form-group">
                                        <label for="inputEmail" class="col-sm-3 control-label">绑定邮箱</label>
                                        <div class="col-sm-6">
                                            <p class="form-control-static" player-email=""></p>
                                        </div>
                                    </div>
                                    <div find-way="email" style="display: none" class="form-group">
                                        <label for="inputPassword" class="col-sm-3 control-label">请输入验证码</label>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                <input type="text" class="form-control" name="securityCode"  maxlength="6" placeholder="验证码">
                                                <span class="input-group-btn"><a class="btn primary-btn -white -sm" id="resendBtn" onclick="sendEmailByUserName()">重新发送()</a></span>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>

                                    <div find-way="email"  style="display: none" class="form-group _change_password">
                                        <label for="inputEmail" class="col-sm-3 control-label">新的登录密码</label>
                                        <div class="col-sm-6">
                                            <input type="password" class="form-control" name="newPassword" maxlength="20" placeholder="Password">
                                            <div class="progress pass-strength">
                                                <div class="progress-bar" style="width: 20%;">弱</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div find-way="email" style="display: none" class="form-group _change_password">
                                        <label for="inputEmail" class="col-sm-3 control-label">确认新密码</label>
                                        <div class="col-sm-6">
                                            <input type="password" class="form-control" name="forgetConfirmPassword" maxlength="20" placeholder="Password">
                                        </div>
                                    </div>
                                    <div find-way="email" style="display: none"  class="form-group _change_password">
                                        <label for="inputPassword" class="col-sm-3 control-label">验证码</label>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                <input type="text" class="form-control" name="changePasswordCaptchaCode" maxlength="4" placeholder="验证码">
                                                <span class="input-group-btn"><a><img onclick="changeCaptcha(this)" class="_captcha_code2" data-code="changePassword" src="${root}/captcha/changePassword.html" height="34"></a></span>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div find-way="email"  style="display: none" class="form-group">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <a class="btn primary-btn -blue -sm continue" href="javascript:void(0)" onclick="changePasswordByEmail()">&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                        </div>
                                    </div>
                                    <div  class="form-group _change_password" style="display: none">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <a class="btn primary-btn -blue -sm continue" href="javascript:void(0)" onclick="changePasswordByQuestion()">&nbsp;&nbsp;&nbsp;&nbsp;下一步&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane _success" id="step4" style="display: none">
                                    <h4 class="text-center p-lg">恭喜您，密码已成功重置！欢迎您使用新密码再次登录！</h4>
                                    <hr>
                                    <div class="row">
                                        <div class="col-xs-6 p-lg text-right">
                                            <a class="btn primary-btn -blue -sm" href="/?do=loginDialog">立即登录</a>
                                        </div>
                                        <div class="col-xs-6 p-lg">
                                            <a class="btn primary-btn -white -sm" href="/">返回首页</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <!-- </div> -->
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!--Server Bar-->
<div class="server-bar">
    <button class="btn btn-block flat-btn -blue -xs" type="button">客服</button>
    <button class="btn btn-block flat-btn -white -xs topcontrol" type="button">顶部</button>
</div>
<%@ include file="/include/include.js.jsp" %>
<script>
    $(document).ready(function() {
        //Wizard
        $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
            var $target = $(e.target);
            if ($target.parent().hasClass('disabled')) {
                return false;
            }
        });
        $("input[name='forgetUserName']").on("focus",function(){
            $(".help-block").text('');
        });
        $("[name='forgetPasswordCaptchaCode']").on("focus", function () {
            $(".help-block-2").text('');
        })

    });
    function changeCaptcha(obj){
        var $this = $(obj);
        var src = root+"/captcha/forgetPassword.html?t=" + new Date().getTime().toString(36);
        $this.prop("src",src)
    }
    function nextTab(elem) {
        $(elem).next().find('a[data-toggle="tab"]').click();
    }
    /*绑定表单验证*/
    var $findPasswordForm = $('#findPasswordForm');
    var findPasswordRule;
    var $findPasswordRuleruleDiv = $findPasswordForm.find('#validateRule');
    var checkUserNameFlag =false;
    if ($findPasswordRuleruleDiv.length > 0) {
        findPasswordRule = eval("({" + $findPasswordRuleruleDiv.text() + "})");
        findPasswordRule.ignore = ".ignore";
    }

    if (findPasswordRule) {
        /*if ($.data($findPasswordForm[0], "validator")) {
            $.data($findPasswordForm[0], "validator", null);
        }
        $findPasswordForm.validate(findPasswordRule);*/
    }
    function closeOpenService(){
        window.open("${data.defaultCustomerService}","Online Help","target=_blank")
    }
    function nextStep(step){
        if($("[name='forgetUserName']").val()==""){
            $(".help-block").text("请输入用户名!");
            return;
        }
        if($("[name='forgetPasswordCaptchaCode']").val()==""){
            $(".help-block-2").text("请输入验证码!");
            return;
        }
        checkUserName();
        if(step === 2 && !checkUserNameFlag){
            //$("._captcha_code").trigger("click");
            return;
        }
        if($findPasswordForm.valid()){
            var selector = "#step"+step;
            $("a[href="+selector+"]").parent().addClass("active").siblings().removeClass("active");
            var $showDiv = $(selector);
            $showDiv.addClass("active").show().siblings().removeClass("active");

            if(step === 2){
                $.ajax({
                    url:root+"/forgetPassword/getFindWay.html",
                    data:{
                        "forgetUserName":$("[name='forgetUserName']").val()
                    },
                    type:"POST",
                    async:false,
                    dataType:"JSON",
                    success:function(data){
                        /*隐藏显示*/
                        if(data.protectionCanUse){
                            $("._protectionCanUse").show();
                            /*添加问题*/
                            var protection = data.protection
                            $('._answer1',$findPasswordForm).html(protection.answer1);
                            $('._answer2',$findPasswordForm).html(protection.answer2);
                            $('._answer3',$findPasswordForm).html(protection.answer3);
                        }else{
                        }
                        if(data.email){
                            $("._emailCanUse").show();
                            $("[player-email]").each(function(){
                                var $this = $(this);
                                var html = $this.html();
                                $this.html(data.email + html)
                            });
                        }
                        $("#encryptedId",$findPasswordForm).val(data.encryptedId)
                    }
                })

            }
            if($showDiv.hasClass("_findTypeGroup")){
                var $selectedType = $('.findTypeGroup a.active')
                if(!$selectedType.length){
                    alert('请选择验证方式！')
                    return;
                }
                var findType = $selectedType.data().findType;
                $("#findWay").val(findType);
                $('[find-way='+findType+']').show();
                if(findType === 'email'){
                    $("#checkPassword").val("check");
//                    next(4);
                    sendEmailByUserName();
                }
            } else if ($showDiv.hasClass("_success")){
                var findWayValue = $("#findWay").val();
                $('[find-way='+findType+']',$showDiv).show();
            }
            $("#step").val(step)
        }else {
            if (step === 2 ){
                $("._captcha_code").trigger("click");
            }
        }
    }

    function checkUserName(){

        $.ajax({
            url: root+"/forgetPassword/checkUserNameAndCheckCode.html",
            data: {
                "forgetUserName": $("[name='forgetUserName']").val(),
                "checkCode":$("[name='forgetPasswordCaptchaCode']").val()
            },
            type: "POST",
            async: false,
            dataType: "JSON",
            success: function (data) {
                if(data){
                    if(data.state=="false"){
                        if(data.errType=="1"){
                            $(".help-block").text(data.errmsg);
                        }else{
                            $(".help-block-2").text(data.errmsg);
                        }

                    }else{
                        checkUserNameFlag = true;
                    }
                }
                /*if (!data) {
                    $(".help-block").text('请输入正确的账户!');
                }else {
                    checkUserNameFlag = true;
                }*/
            }
        })
    }
    function changePasswordByQuestion(){
        if($findPasswordForm.valid()){
            $.ajax({
                url:root+"/forgetPassword/changePassword.html",
                data:$findPasswordForm.serialize(),
                type:"POST",
                dataType:"JSON",
                success:function(data){
                    if(data){
                        nextStep(4);
                        /*成功*/
                    }
                }
            })
        }else {
            $("._captcha_code2").trigger("click");
        }
    }
    $(".findTypeGroup a").on("click",function(){
        var $this = $(this);
        $("#findWay").val($this.data().findType);
        $this.siblings().removeClass("active");
        $this.addClass("active");
//        $('#findType').val($this.data().findType);
    });
    var FIND_PASSWORD_SEND_EMAiL_COOKIE_KEY = "findPasswordSendEmailCookieKey";
    var findPasswordSendEmailTimerId;
    function sendEmailByUserName(){
        var sendEmailIntervalSec = getCookie(FIND_PASSWORD_SEND_EMAiL_COOKIE_KEY);
        sendEmailIntervalSec = Number(sendEmailIntervalSec);
        if(!sendEmailIntervalSec){
            $.ajax({
                url:root+"/forgetPassword/sendEmail.html",
                data:{
                    encryptedId:$("#encryptedId").val()
                },
                type:"POST",
                dataType:"JSON",
                success:function(data){
                    if(data){
                        setCookie(FIND_PASSWORD_SEND_EMAiL_COOKIE_KEY,60);
                        findPasswordSendEmailTimer();
                    }
                }
            })
        }else{
            findPasswordSendEmailTimer();
        }
    }
    /**
     * 获取cookie
     * @param c_name cookie key
     */
    function getCookie(c_name){
        if (document.cookie.length>0){
            c_start=document.cookie.indexOf(c_name + "=")
            if (c_start!=-1){
                c_start=c_start + c_name.length+1
                c_end=document.cookie.indexOf(";",c_start)
                if (c_end==-1) c_end=document.cookie.length
                return unescape(document.cookie.substring(c_start,c_end))
            }
        }
        return ""
    }
    /*
     * 设置cookie
     * @param c_name
     * @param value
     * @param expiredays
     * */
    function setCookie(c_name,value,expiredays){
        var exdate=new Date()
        exdate.setDate(exdate.getDate()+expiredays)
        document.cookie=c_name+ "=" +escape(value)+
                ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
    }
    function findPasswordSendEmailTimer(){
        var $resendBtn = $("#resendBtn");
        findPasswordSendEmailTimerId = setInterval(
                function(){
                    var sendEmailIntervalSec = getCookie(FIND_PASSWORD_SEND_EMAiL_COOKIE_KEY);
                    sendEmailIntervalSec = Number(sendEmailIntervalSec);
                    sendEmailIntervalSec = --sendEmailIntervalSec;
                    if(!sendEmailIntervalSec || sendEmailIntervalSec<0){
                        clearInterval(findPasswordSendEmailTimerId);
                        $resendBtn.prop("disabled",false);
                        $resendBtn.removeClass('disabled')
                        $resendBtn.text("重新发送")
                    }else{
                        $resendBtn.prop("disabled",true);
                        $resendBtn.addClass('disabled')
                        $resendBtn.text("重新发送("+sendEmailIntervalSec+")")
                    }
                    setCookie(FIND_PASSWORD_SEND_EMAiL_COOKIE_KEY,sendEmailIntervalSec);
                },
                1000
        )
    }
    function changePasswordByEmail(){
        if($findPasswordForm.valid()){
            $.ajax({
                url:root+"/forgetPassword/changePasswordByEmail.html",
                data:$findPasswordForm.serialize(),
                type:"POST",
                dataType:"JSON",
                success:function(data){
                    if(data){
                        nextStep(4);
                    }
                }
            })
        }
    }
    function showChangePwdForm(){
        if($findPasswordForm.valid()){
            var  $findTypeGroup =$("._findTypeGroup");
            $findTypeGroup.children().hide();
            $("._change_password",$findTypeGroup).show();
            $("#checkPassword").val("check");
        }
    }

</script>
</body>

</html>
