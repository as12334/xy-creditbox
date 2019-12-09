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
            var val = v;

            location.href = "${root}/account/fgs_add.html" + v;
        }
        var kc_low_maxrate = ${command.result.stintOccupy};
    </script>
</head>
<body>
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
                        <td><b>新增分公司</b></td>
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
                                <tr>
                                    <td align="right" class="tdbg1">上級總監&nbsp;</td>
                                    <td align="left" width="150">&nbsp;
                                        ${fn:substringBefore(command.parentUser.username,'@')}
                                    </select></td>
                                    <td align="right" width="100" class="tdbg1">名稱&nbsp;</td>
                                    <td align="left">${command.parentUser.nickname}</td>

                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">分公司帳號&nbsp;</td>
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
                                                     class="text w130" data-empty="${empty command.result.id ? "":"true"}"><span
                                            class="passwordStrength"><span>弱</span><span>中</span><span>强</span></span><span
                                            class="passwordTip">8-20位,且必需包含字母和数字！</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        分公司名稱&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        &nbsp;<input type="text" value="${command.result.nickname}" name="result.nickname" id="userNicker" class="text w130">
                                    </td>
                                </tr>
                                <tr style='display:none;'>
                                    <td colspan="4" class="tdbg4 red">
                                        <b>注意：請分別點擊修改以下各項游戲的占成數：①->②再按確定修改帳號設置。</b>
                                    </td>
                                </tr>
                                <tr>
                                    <th colspan="4">
                                        <div class="bline tm3 lp3">
                                            <ul>
                                                <li class="tabBtn  w130" style='display:none;'>香港⑥合彩</li>
                                                <li class="tabBtn on w130">快彩</li>
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
                        <td><table class="t_list" border="0" cellspacing="0" cellpadding="0">


                            <tbody><tr>
                                <td align="right" width="140" class="tdbg1"> <span id="isCash_six_01">(⑥合彩)信用額度</span>&nbsp; </td>
                                <td align="left">&nbsp;<input type="text" name="userCredit_six" id="userCredit_six" class="text w130 zfNumber toRMB" value="0" data-min="0" data-max="0"><span class="toRMBspan"></span>『&nbsp;可‘回收’餘額&nbsp;<span>0</span>&nbsp;』 &nbsp;&nbsp; 上級餘額：0
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)股東占成&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="0" name="userRate_six" id="userRate_six" class="text zfNumber" value="0">
                                    %　 最高可設占成 0% </td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)下綫占成上限&nbsp;</td>
                                <td align="left"><label class="topLabel"><input type="radio" id="allowmaxrate_six" name="allowmaxrate_six" value="0" checked="checked">
                                    <span>
											占餘成數下綫任占
										</span>
                                </label>
                                    <label class="topLabel"><input type="radio" id="allowmaxrate_six" name="allowmaxrate_six" value="1">
                                        <span>
											限製下綫可占成數
										</span>
                                    </label>
                                    <span id="lowmaxrate_six_wrap"></span>
                                    <span id="min_xz_downRate_six" style="display:none;">${command.result.stintOccupy}</span>
                                </td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)補貨功能&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tbody><tr>

                                        <td width="60"><label class="topLabel"><input type="radio" name="userAllowSale_six" id="userAllowSale_six" value="1" checked="checked">
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel"><input type="radio" name="userAllowSale_six" id="userAllowSale_six" value="0">
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                    </tbody></table></td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)盤口&nbsp;</td>
                                <td align="left">
                                    <table border="0" cellspacing="0" cellpadding="0">
                                        <tbody><tr>

                                            <td>
                                                <label class="topLabel"><input type="radio" name="userKind_six" id="userKind_six" value="0" checked="checked">
                                                    <span>
							不限
						</span>
                                                </label>
                                            </td>
                                        </tr>



                                        </tbody></table>

                                </td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)信用/現金&nbsp;</td>
                                <td align="left">

                                    <label class="topLabel"><input type="radio" name="isCash_six" id="isCash_six" value="0" checked="checked" disabled="">
                                        <span>
										信用
									</span>
                                    </label>

                                </td>
                            </tr>

                            </tbody></table></td>
                    </tr>
                    <tr id="kc" class="tabBox tabBoxOn" style="display: table-row;">
                        <td><table class="t_list" border="0" cellspacing="0" cellpadding="0">
                            <tbody><tr>
                                <td align="right" width="140" class="tdbg1"> <span id="isCash_kc_01">(快彩)信用額度</span>&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="${command.parentUser.credits}" value="${command.result.credits}" name="result.credits" id="userCredit_kc" class="text w130 zfNumber toRMB">
                                    <span class="toRMBspan"></span>
                                    上級餘額:<label id="userCredit_kc_1">${command.parentUser.credits}</label>
                                </td>
                            </tr>





                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)總監占成&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="${command.parentUser.superiorOccupy}" value="${command.result.superiorOccupy}" name="result.superiorOccupy" id="userRate_kc" class="text zfNumber">
                                    % 　最高可設占成
                                    <label id="userMaxRate_kc">${command.parentUser.superiorOccupy}%</label>
                                </td>
                            </tr>


                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)剩餘成數:&nbsp;</td>
                                <td align="left">
                                    <table border="0" cellspacing="0" cellpadding="0">
                                        <tr>

                                            <td width="60"><label class="topLabel">
                                                <input type="radio" name="result.breakpoint"
                                                       value="1" ${command.result.breakpoint != '2'?'checked':''} />
                                                <span>
										總監
									</span>
                                            </label></td>
                                            <td width="80"><label class="topLabel">
                                                <input type="radio" name="result.breakpoint"
                                                       value="2" ${command.result.breakpoint == '2'?'checked':''}/>
                                                <span>
										分公司
									</span>
                                            </label></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>


                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)總賬報表:&nbsp;</td>
                                <td align="left">
                                    <table border="0" cellspacing="0" cellpadding="0">
                                        <tr>

                                            <td width="100"><label class="topLabel">
                                                <input type="radio" name="result.general"
                                                       value="1" ${command.result.general == '1'?'checked':''} />
                                                <span>
										總賬(非明细)
									</span>
                                            </label></td>
                                            <td width="120"><label class="topLabel">
                                                <input type="radio" name="result.general"
                                                       value="2" ${command.result.general == '2'?'checked':''}/>
                                                <span>
										總賬(包括明細)
									</span>
                                            </label></td>
                                            <td width="120"><label class="topLabel">
                                                <input type="radio" name="result.general"
                                                       value="0" ${command.result.general == '0' || empty command.result.general?'checked':''}/>
                                                <span>
										關閉
									</span>
                                            </label></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)下綫占成上限&nbsp;</td>
                                <td align="left"><label class="topLabel"><input type="radio"  name="result.stintOccupySwitch" value="0" ${command.result.stintOccupySwitch !='1' ?"checked":""}>
                                    <span>
											占餘成數下綫任占
										</span>
                                </label>
                                    <label class="topLabel"><input type="radio"  name="result.stintOccupySwitch" value="1" ${command.result.stintOccupySwitch == '1'?"checked":""}>
                                        <span>
											限製下綫可占成數
										</span>
                                    </label>
                                        <span id="lowmaxrate_kc_wrap"></span>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)補貨功能&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tbody><tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="result.manualAutoShipments"  value="1" ${command.result.manualAutoShipments == '1'?'checked':''}>
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="result.manualAutoShipments"  value="0" ${command.result.manualAutoShipments != '1'?'checked':''} />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                    </tbody></table></td>
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
                                <td align="right" width="140" class="tdbg1"> (快彩)操盘:&nbsp;</td>
                                <td align="left">
                                    <table border="0" cellspacing="0" cellpadding="0">
                                        <tr>

                                            <td width="60"><label class="topLabel">
                                                <input type="radio" name="result.setOdds"
                                                       value="1" ${command.result.setOdds == '1'?"checked":""} />
                                                <span>
										啟用
									</span>
                                            </label></td>
                                            <td width="80"><label class="topLabel">
                                                <input type="radio" name="result.setOdds"
                                                       value="0" ${empty command.result.setOdds || command.result.setOdds==0?"checked":""} />
                                                <span>
										禁用
									</span>
                                            </label></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)信用&nbsp;</td>
                                <td align="left">

                                    <label class="topLabel"><input type="radio" name="isCash_kc" id="isCash_kc" value="0" checked="checked" disabled="">
                                        <span>
										信用
									</span>
                                    </label>

                                </td>
                            </tr>

                            </tbody></table></td>
                    </tr>
                    </tbody>
                </table>

                <!--主体结束-->
            </td>
            <td class="centerRightBg"></td>
        </tr>
        <tr>
            <td class="bottomLeftBg"></td>
            <td class="bottomBoxBg" align="center">
                <button type="button" name="backBtn" id="backBtn" class="btn"
                        onclick="javascript:location.href= '${root}/account/fgs_list.html?lid=0';"> 返回
                </button>&nbsp;&nbsp;&nbsp;&nbsp;

                <button type="button" name="btnSubmit" id="btnSubmit" class="btn"> 確定</button>
                <input type="hidden" id="hdnadd" name="hdnadd" value="hdnadd"/><input type="hidden" id="uid" name="uid"
                                                                                      value="4ad98bd2-d849-4168-addd-cf7618422fc9"/><input
                    type="hidden" id="sltuid" name="sltuid" value=""/>
            </td>
            <td class="bottomRightBg"></td>
        </tr>
    </table>
</form>

<script type="text/javascript">
    window.onload = function () {
        seajs.use('tabEvent', function (tabEvent) {
            tabEvent(window.top.masterFirst);
        });
        seajs.use('addUser');
    };
</script>
<div id="alert_show"></div>


</body>
</html>
