<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.manager.user.vo.SysUserExtendVo"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">

    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>



    <script>
        function changefgsuser(v) {
            var val = v;

            location.href = "zd_add.html?uid=${user.uid}&sltuid=" + v;
        }
    </script>
</head>
<body>
<form method="post" id="form">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
        <tr>
            <td class="topLeftBg1"></td>
            <td class="topBoxBg1"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="tm2">
                <tr>
                    <td width="26" align="center"><div class="topArr"></div></td>
                    <td><b>新增分公司</b></td>
                    <td width="100">&nbsp;</td>
                    <td width="140" align="right"><div class="btnIco"><div onclick="javascript:history.go(-1)"><div class="Reico" style="cursor:pointer;">返回</div></div></div></td>
                </tr>
            </table></td>
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
                                        ${fn:substringBefore(user.username,'@')}
                                        </select></td>
                                    <td align="right" width="100" class="tdbg1">名稱&nbsp;</td>
                                    <td align="left">${user.nickname}</td>

                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        分公司帳號&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td>
                                                    &nbsp;<input type="text" name="userName" id="userName" class="text w130" /><div class="userTips">（帳號必須包含字母和數字，除開頭和結尾外可以用‘_’）</div>
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
                                        &nbsp;<input type="text" name="userPassword" id="userPassword" class="text w130"><span class="passwordStrength"><span>弱</span><span>中</span><span>强</span></span><span class="passwordTip">8-20位,且必需包含字母和数字！</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="140" class="tdbg1">
                                        分公司名稱&nbsp;
                                    </td>
                                    <td colspan="3" align="left">
                                        &nbsp;<input type="text" name="userNicker" id="userNicker" class="text w130">
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
                                                <li class="tabBtn on w130"  style='display:;'>快彩</li>
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
                            <tr>
                                <td align="right" width="140" class="tdbg1"> <span id="isCash_six_01">(⑥合彩)信用額度</span>&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="${user.sixCredit}" name="userCredit_six" id="userCredit_six" class="text w130 zfNumber toRMB" /><span class="toRMBspan"></span>
                                    上級餘額:
                                    <label id="userCredit_six_1">${user.sixCredit}</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)總監占成&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="100" name="userRate_six" id="userRate_six" class="text zfNumber" />
                                    % 　最高可設占成
                                    <label id="userMaxRate_six">100%</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)下綫占成上限&nbsp;</td>
                                <td align="left"><label class="topLabel"><input type="radio" id="allowmaxrate_six" name="allowmaxrate_six" value="0" checked="checked" />
                                    <span>
											占餘成數下綫任占
										</span>
                                </label>
                                    <label class="topLabel"><input type="radio" id="allowmaxrate_six" name="allowmaxrate_six" value="1" />
                                        <span>
											限製下綫可占成數
										</span>
                                    </label>
                                    <span id="lowmaxrate_six_wrap"></span>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)補貨功能&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="userAllowSale_six" id="userAllowSale_six" value="1" checked=checked />
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="userAllowSale_six" id="userAllowSale_six" value="0"  />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)盤口&nbsp;</td>
                                <td align="left"><label class="topLabel"><input type="radio" name="userKind_six"  id="userKind_six" value="0"  checked="checked" />
                                    <span>
										不限
									</span>
                                </label>
                                    <label class="topLabel"><input type="radio" name="userKind_six"  id="userKind_six" value="A" />
                                        <span>
										A盤
									</span>
                                    </label>
                                    <label class="topLabel"><input type="radio" name="userKind_six"  id="userKind_six" value="B" />
                                        <span>
										B盤
									</span>
                                    </label>
                                    <label class="topLabel"><input type="radio" name="userKind_six"  id="userKind_six" value="C" />
                                        <span>
										C盤
									</span>
                                    </label>

                                </td>
                            </tr>


                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)操盤&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="op_six" id="op_six" value="1" checked=checked  />
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="op_six" id="op_six" value="0"  />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>


                            <tr>
                                <td align="right" width="140" class="tdbg1"> (⑥合彩)userRateOwner_six&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="userRateOwner_six" id="userRateOwner_six" value="1" checked=checked  />
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="userRateOwner_six" id="userRateOwner_six" value="0"  />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1">  (⑥合彩)信用/現金&nbsp;</td>
                                <td align="left">


                                    <label class="topLabel"><input type="radio" name="isCash_six"  id="isCash_six" value="0" checked=checked  disabled />
                                        <span>
										信用
									</span>
                                    </label>

                                </td>
                            </tr>
                        </table></td>
                    </tr>
                    <tr id="kc" class="tabBox">
                        <td><table  class="t_list" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="right" width="140" class="tdbg1"> <span id="isCash_kc_01">(快彩)信用額度</span>&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="${user.kcCredit}" name="userCredit_kc" id="userCredit_kc" class="text w130 zfNumber toRMB" /><span class="toRMBspan"></span>
                                    上級餘額:
                                    <label id="userCredit_kc_1">${user.kcCredit}</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)總監占成&nbsp;</td>
                                <td align="left">&nbsp;<input type="text" data-max="100" name="userRate_kc" id="userRate_kc" class="text zfNumber" />
                                    % 　最高可設占成
                                    <label id="userMaxRate_kc">100%</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)補貨功能&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="userAllowSale_kc" id="userAllowSale_kc" value="1" checked=checked  />
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="userAllowSale_kc" id="userAllowSale_kc" value="0"  />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>






                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)開放公司報表&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="userReport" id="userReport" value="1" checked=checked  />
                                            <span>
										顯示
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="userReport" id="userReport" value="0"  />
                                            <span>
										禁看
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>



                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)占餘成數歸&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="userRateOwner_kc" id="userRateOwner_kc" value="1" checked=checked  />
                                            <span>
										總監
									</span>
                                        </label></td>
                                        <td width="150"><label class="topLabel">
                                            <input type="radio"  name="userRateOwner_kc" id="userRateOwner_kc" value="0"  />
                                            <span>
										分公司
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>








                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)盤口&nbsp;</td>
                                <td align="left">
                                    <label class="topLabel"><input type="radio" name="userKind_kc"  id="userKind_kc" value="0"  checked="checked" />
                                        <span>
							不限
						</span>
                                    </label>
                                    <label class="topLabel"><input type="radio" name="userKind_kc"  id="userKind_kc" value="A" />
                                        <span>
							A盤
						</span>
                                    </label>
                                    <label class="topLabel"><input type="radio" name="userKind_kc"  id="userKind_kc" value="B" />
                                        <span>
							B盤
						</span>
                                    </label>
                                    <label class="topLabel"><input type="radio" name="userKind_kc"  id="userKind_kc" value="C" />
                                        <span>
							C盤
						</span>
                                    </label>

                                </td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)操盤&nbsp;</td>
                                <td align="left"><table border="0" cellspacing="0" cellpadding="0">
                                    <tr>

                                        <td width="60"><label class="topLabel">
                                            <input type="radio" name="op_kc" id="op_kc" value="1" checked=checked  />
                                            <span>
										啟用
									</span>
                                        </label></td>
                                        <td width="60"><label class="topLabel">
                                            <input type="radio"  name="op_kc" id="op_kc" value="0"  />
                                            <span>
										禁用
									</span>
                                        </label></td>
                                    </tr>
                                </table></td>
                            </tr>

                            <tr>
                                <td align="right" width="140" class="tdbg1"> (快彩)信用/現金&nbsp;</td>
                                <td align="left">

                                    <label class="topLabel"><input type="radio" name="isCash_kc"  id="isCash_kc" value="0" checked=checked  disabled />
                                        <span>
										信用
									</span>
                                    </label>

                                </td>
                            </tr>

                        </table></td>
                    </tr>
                </table>

                <!--主体结束-->
            </td>
            <td class="centerRightBg"></td>
        </tr>
        <tr>
            <td class="bottomLeftBg"></td>
            <td class="bottomBoxBg" align="center"><button type="button" name="backBtn" id="backBtn" class="btn" onclick="javascript:location.href='/account/zd_list.aspx?lid=22';"> 返回 </button>&nbsp;&nbsp;&nbsp;&nbsp;

                <button type="button" name="btnSubmit" id="btnSubmit" class="btn"> 確定 </button>
                <input type="hidden" id="hdnadd" name="hdnadd" value="hdnadd" /><input type="hidden" id="uid" name="uid" value="4ad98bd2-d849-4168-addd-cf7618422fc9" /><input type="hidden" id="sltuid" name="sltuid" value="" />
            </td>
            <td class="bottomRightBg"></td>
        </tr>
    </table></form>

<script type="text/javascript">
    window.onload=function () {
        seajs.use('tabEvent', function(tabEvent) {
            tabEvent(window.top.masterFirst);
        });
        seajs.use('addUser');
    };
</script>
<div id="alert_show"></div>


</body>
</html>
