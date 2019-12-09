<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserVo"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver = 20191126;</script>
    <script>var isOpenUpper = "0";</script>
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">

    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>
    <script>
        function changefgsuser(v) {
            location.href = "hy_add_du.html?search.ownerId=" + v;
        }
        function checkedrdo(v) {
            location.href = "hy_add_du.html?rdoutype=" + v;
        }
    </script>
</head>
<body>
<script type="text/javascript">
    window.onload = function () {

        seajs.use(['tabEvent', 'jquery'], function (tabEvent, $) {
            tabEvent(window.top.masterFirst);

//            setRadioAndSelect();

            // $("input[name=rdoutype]").click(function () {
            // 	checkedrdo($(this).val());
            // 	setRadioAndSelect();
            // })

            function setRadioAndSelect() {
                $.ajax({
                    type: 'POST',
                    url: root + '/account/existNameAjax.html',
                    dataType: "json",
                    data: {
                        action: 'get_hydu',
                        chktype: $("input[name=rdoutype]:checked").val(),
                        sltuid: $("#sltupuser").val()
                    },
                    error: function () {
                        alert('处理程序出错,请通知管理员检查！');
                    },
                    success: function (d) {
                        // u_nicker_d
                        $("#u_nicker_d").html(d.data.u_nicker_d);

                        var sixData = d.data.six;
                        // six_rate_d
                        $("#userRate_six").attr('data-max', sixData.six_rate_d);
                        $("#userMaxRate_six").html(sixData.six_rate_d + "%");

                        // six_usable_credit_d
                        $("#userCredit_six_1").html(sixData.six_usable_credit_d);
                        // six_kind_d
                        var sixAttr = ['A', 'B', 'C'];
                        if (sixData.six_kind_d != 0) {
                            $("input[name=userKind_six]").prop('disabled', true);
                            $("#userKind_six_" + sixData.six_kind_d).prop('checked', 'checked');
                            $("#userKind_six_" + sixData.six_kind_d).prop('disabled', false);
                            for (var i = 0; i < sixAttr.length; i++) {
                                if (sixAttr[i] != sixData.six_kind_d) {
                                    $("#userKind_six_" + sixAttr[i]).parent().remove();
                                }
                            }
                        }

                        var kcData = d.data.kc;
                        // kc_rate_d
                        $("#userRate_kc").attr('data-max', kcData.kc_rate_d);
                        $("#userMaxRate_kc").html(kcData.kc_rate_d + "%");

                        // kc_kind_d
                        var kcAttr = ['A', 'B', 'C'];
                        if (kcData.kc_kind_d != 0) {
                            $("input[name=userKind_kc]").prop('disabled', true);
                            $("#userKind_kc_" + kcData.kc_kind_d).prop('checked', 'checked');
                            $("#userKind_kc_" + kcData.kc_kind_d).prop('disabled', false);
                            for (var i = 0; i < kcAttr.length; i++) {
                                if (kcAttr[i] != kcData.kc_kind_d) {
                                    $("#userKind_kc_" + kcAttr[i]).parent().remove();
                                }
                            }
                        }

                        // kc_usable_credit_d
                        $("#userCredit_kc_1").html(kcData.kc_usable_credit_d);
                        // kc_iscash
                        $("#isCash_kc_" + kcData.kc_iscash).prop('checked', 'checked');
                    }
                });
            }
        });

        seajs.use('addUser');
    };
</script>
<form method="post" id="form">
    <input hidden name="result.userType" value="${command.search.userType}">
    <input hidden id="superStintOccupy" value="">
    <input hidden name="result.id" value="${command.result.id}">
    <input hidden name="result.ownerUserType" value="${command.search.ownerUserType}">
    <input hidden name="result.ownerId" value="${command.parentUser.id}">


    <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
        <tr>
            <td class="topLeftBg1"></td>
            <td class="topBoxBg1">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tm2">
                    <tr>
                        <td width="26" align="center">
                            <div class="topArr"></div>
                        </td>
                        <td><b>新增直屬會員</b></td>
                        <td width="100">&nbsp;</td>
                        <td width="140" align="right">
                            <div class="btnIco">
                                <div onclick="javascript:history.go(-1)">
                                    <div class="Reico" style="cursor:pointer;">返回</div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
            <td class="topRightBg1"></td>
        </tr>
        <tr>
            <td class="centerLeftBg"></td>
            <td valign="top" align="center">
                <!--主体部分-->

                <table width="700" class="addUserTop" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>
                            <table class="t_list">
                                <tr>
                                    <th colspan="4">
                                        帳戶資料
                                    </th>
                                </tr>

                                <c:if test="${empty command.result.id}">
                                    <tr>
                                        <td align="right" class="tdbg1">直屬上級&nbsp;</td>
                                        <td colspan="3" align="left">
                                            <c:if test="${user.subsysCode == 'company' }">
                                                <label class="topLabel"><input
                                                        type="radio" ${command.parentUser.userType == '4'?'checked':''} name="rdoutype"
                                                        value="4" onclick="checkedrdo('4');">
                                                    <span>分公司</span>
                                                </label>
                                            </c:if>
                                            <c:if test="${user.subsysCode == 'company' || user.subsysCode == 'branch' }">
                                                <label class="topLabel"><input
                                                        type="radio" ${command.parentUser.userType == '5'?'checked':''} name="rdoutype"
                                                        value="5" onclick="checkedrdo('5');">
                                                    <span>股东</span>
                                                </label>
                                            </c:if>
                                            <c:if test="${user.subsysCode == 'company' || user.subsysCode == 'branch' || user.subsysCode == 'shareholder'}">
                                                <label class="topLabel"><input
                                                        type="radio" ${command.parentUser.userType == '6'?'checked':''} name="rdoutype"
                                                        value="6" onclick="checkedrdo('6');">
                                                    <span>總代</span>
                                                </label>
                                            </c:if>


                                        </td>
                                    </tr>
                                </c:if>


                                <tr>
                                    <td align="right" class="tdbg1">上級${views.page["UserTypeEnum.".concat(command.parentUser.userType)]}&nbsp;</td>
                                    <td align="left" width="150">
                                        <c:choose>
                                        <c:when test="${empty command.result.id}">
                                        &nbsp;<select id="sltupuser" name="result.ownerId"
                                                      onchange="changefgsuser(this.value);">
                                        <c:forEach items="${command.superUserList}" var="result">
                                            <option value="${result.id}"
                                                    data-credit="${result.credits}" ${result.id == command.parentUser.id ? 'selected':''}>${fn:substringBefore(result.username,'@')}</option>
                                        </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            &nbsp;${fn:substringBefore(command.parentUser.username,'@')}
                                        </c:otherwise>
                                        </c:choose>
                                        <c:if test="">

                                        </c:if>

                                    </select></td>
                                    <td align="right" width="100" class="tdbg1">名稱&nbsp;</td>
                                    <td align="left">${command.parentUser.nickname}</td>

                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        會員帳號&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${empty command.result.id}">
                                                            &nbsp;<input type="text" value="" name="result.username" id="userName" class="text w130"/>
                                                            <div class="userTips">（帳號必須包含字母和數字，除開頭和結尾外可以用‘_’）</div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            &nbsp;${fn:substringBefore(command.result.username,'@')}
                                                        </c:otherwise>
                                                    </c:choose>

                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        密 碼&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        &nbsp;<input type="text" name="result.password" id="userPassword"
                                                     class="text w130"
                                                     data-empty="${empty command.result.id ? "":"true"}"><span
                                            class="passwordStrength"><span>弱</span><span>中</span><span>强</span></span><span
                                            class="passwordTip">8-20位,且必需包含字母和数字！</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        會員名稱&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        &nbsp;<input type="text" value="${command.result.nickname}"
                                                     name="result.nickname" id="userNicker" class="text w130">
                                    </td>
                                </tr>
                                <tr style='display:none;'>
                                    <td colspan="4" class="tdbg4 red">
                                        <b>注意：請分別點擊修改以下各項游戲的占成數：①->②再按確定修改帳號設置。</b></td>
                                </tr>
                                <tr>
                                    <th colspan="4">
                                        <div class="bline tm3 lp3">
                                            <ul>
                                                <li class="tabBtn  w130" style='display:none;'>香港⑥合彩</li>
                                                <li class="tabBtn on w130" style=''>快彩</li>
                                            </ul>
                                        </div>
                                    </th>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <table width="700" border="0" cellspacing="0" cellpadding="0">
                    <tr id="six" class="tabBox">
                        <td>
                            <table class="t_list" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="right" width="140" class="tdbg1"><span
                                            id="isCash_six_01">(⑥合彩)信用額度</span>&nbsp;
                                    </td>
                                    <td align="left">&nbsp;<input type="text" name="userCredit_six" id="userCredit_six"
                                                                  class="text zfNumber w130 toRMB"/><span
                                            class="toRMBspan"></span>
                                        上級餘額:
                                        <label id="userCredit_six_1">0</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (⑥合彩)<label
                                            id="userMaxRate_six_1">股東</label>占成&nbsp;
                                    </td>
                                    <td align="left">&nbsp;<input type="text" data-max="0" name="userRate_six"
                                                                  id="userRate_six" class="text zfNumber"/>
                                        %　 最高可設占成
                                        <label id="userMaxRate_six">0%</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (⑥合彩)盤口&nbsp;</td>
                                    <td align="left">
                                        <label class="topLabel"><input type="radio" name="userKind_six"
                                                                       id="userKind_six_A" value="A" checked="checked"/>
                                            <span>
						A盤
					</span>
                                        </label>
                                        <label class="topLabel"><input type="radio" name="userKind_six"
                                                                       id="userKind_six_B" value="B"/>
                                            <span>
						B盤
					</span>
                                        </label>
                                        <label class="topLabel"><input type="radio" name="userKind_six"
                                                                       id="userKind_six_C" value="C"/>
                                            <span>
						C盤
					</span>
                                        </label>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (⑥合彩)退水設定&nbsp;</td>
                                    <td align="left">&nbsp;<select id="sltDrawback_six" name="sltDrawback_six">

                                        <option value="0" selected=selected>水全退到底</option>
                                        <option value="1">賺取 0.1 退水</option>
                                        <option value="2">賺取 0.2 退水</option>
                                        <option value="3">賺取 0.3 退水</option>
                                        <option value="4">賺取 0.4 退水</option>
                                        <option value="5">賺取所有退水</option>
                                        <option value="auto">自定義</option>
                                    </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (⑥合彩)信用/現金&nbsp;</td>
                                    <td align="left">

                                        <label class="topLabel"><input type="radio" name="isCash_six" id="isCash_six"
                                                                       value="0" checked=checked disabled/>
                                            <span>
										信用
									</span>
                                        </label>

                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr id="kc" class="tabBox">
                        <td>
                            <table class="t_list" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="right" width="140" class="tdbg1"><span id="isCash_kc_01">(快彩)信用額度</span>&nbsp;
                                    </td>
                                    <td align="left">&nbsp;<input type="text" data-max="${command.parentUser.credits}" value="${command.result.credits}" name="result.credits" id="userCredit_kc" class="text w130 zfNumber toRMB">
                                        <span class="toRMBspan"></span>
                                        上級餘額:<label id="userCredit_kc_1">${command.parentUser.credits}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (快彩)${views.page["UserTypeEnum.".concat(command.search.ownerUserType)]}占成&nbsp;</td>
                                    <td align="left">&nbsp;<input type="text" data-max="${command.parentUser.superiorOccupy}" value="${command.result.superiorOccupy}" name="result.superiorOccupy" id="userRate_kc" class="text zfNumber">
                                        % 　最高可設占成
                                        <label id="userMaxRate_kc">${command.parentUser.superiorOccupy}%</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (快彩)盤口&nbsp;</td>
                                    <td align="left">
                                        <%--<label class="topLabel"><input type="radio" name="userKind_kc"  value="0" checked="checked">--%>
                                        <%--<span>--%>
                                        <%--不限--%>
                                        <%--</span>--%>
                                        <%--</label>--%>
                                        <label class="topLabel"><input type="radio" name="result.handicap" value="A" ${empty command.result.handicap || command.result.handicap == 'A' ? 'checked':''} />
                                            <span>
							A盤
						</span>
                                        </label>
                                        <label class="topLabel"><input type="radio" name="result.handicap" value="B" ${command.result.handicap == 'B' ? 'checked':''} />
                                            <span>
							B盤
						</span>
                                        </label>
                                        <label class="topLabel"><input type="radio" name="result.handicap" value="C" ${command.result.handicap == 'C' ? 'checked':''}>
                                            <span>
							C盤
						</span>
                                        </label>

                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (快彩)退水設定&nbsp;</td>
                                    <td align="left">&nbsp;<select id="sltDrawback_kc" name="sltDrawback_kc">

                                        <option value="0" selected=selected>水全退到底</option>
                                        <option value="1">賺取 0.1 退水</option>
                                        <option value="2">賺取 0.2 退水</option>
                                        <option value="3">賺取 0.3 退水</option>
                                        <option value="4">賺取 0.4 退水</option>
                                        <option value="5">賺取所有退水</option>
                                        <option value="auto">自定義</option>
                                    </select>
                                    </td>
                                </tr>

                                <tr>
                                    <td align="right" width="140" class="tdbg1"> (快彩)信用/現金&nbsp;</td>
                                    <td align="left">

                                        <label class="topLabel"><input type="radio" name="isCash_kc" id="isCash_kc"
                                                                       value="0" checked=checked disabled/>
                                            <span>
										信用
									</span>
                                        </label>

                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>
                </table>

                <!--主体结束-->
            </td>
            <td class="centerRightBg"></td>
        </tr>
        <tr>
            <td class="bottomLeftBg"></td>
            <td class="bottomBoxBg" align="center">
                <button type="button" name="backBtn" id="backBtn" class="btn"
                        onclick="javascript:location.href='${root}/account/hy_list.html?lid=0';"> 返回
                </button>&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" name="btnSubmit" id="btnSubmit" class="btn">確定</button>
                <input type="hidden" id="hdnadd" name="hdnadd" value="hdnadd"/><input type="hidden" id="uid" name="uid"
                                                                                      value=""/><input type="hidden"
                                                                                                       id="sltuid"
                                                                                                       name="sltuid"
                                                                                                       value=""/>
            </td>
            <td class="bottomRightBg"></td>
        </tr>
    </table>
</form>
<div id="alert_show"></div>

</body>
</html>
