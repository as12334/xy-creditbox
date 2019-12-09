<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script> if (top.location == self.location) top.location.href = "/WebContent"; </script>
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">


    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>



<script>
        seajs.use(['pageLoad']);
        var curUrl = "?lid=0&amp;ml=&amp;state=0&amp;flag=0&amp;keyword=&amp;sortName=0&amp;sortType=0&amp;page=1&amp;uid=4ad98bd2-d849-4168-addd-cf7618422fc9&amp;ut=gd";

        function changelottery(v) {
            var ml = v;
            location.href = "zd_list.aspx?ml="+ml+"&lid=0&state=0&flag=0&keyword=&page=1&sortName=0&timesort=0&uid=4ad98bd2-d849-4168-addd-cf7618422fc9&ut=gd";
        }
        function changestate(s)
        {
            location.href="zd_list.aspx?ml=&lid=0&state="+s+"&flag=0&keyword=&page=1&sortName=0&sortType=0&uid=4ad98bd2-d849-4168-addd-cf7618422fc9&ut=gd";
        }
        function changesort(s)
        {
            location.href="zd_list.aspx?ml=&lid=0&state=0&flag=0&keyword=&page=1&sortName="+s+"&sortType=0&uid=4ad98bd2-d849-4168-addd-cf7618422fc9&ut=gd";
        }
        function changesorttype(s)
        {
            location.href="zd_list.aspx?ml=&lid=0&state=0&flag=0&keyword=&page=1&sortName=0&sortType="+s+"&uid=4ad98bd2-d849-4168-addd-cf7618422fc9&ut=gd";
        }
    </script>
</head>
<body>
<!--主体部分-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <tr>
        <td class="topLeftBg1"></td>
        <td class="topBoxBg1"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="tm2">
            <tr>
                <td width="26" align="center"><div class="topArr"></div></td>
                <td width="80" align="left"><b>${views.page["UserTypeEnum.".concat(command.search.userType)]}管理</b></td>

                <td width="450" align="left">
                    <table style="display:none;">
                        <tr>
                            <td width="90" align="left"><label class="topLabel">
                                <input name="rbnLottery" id="rbnLottery" type="radio" value="" checked onclick="changelottery(this.value)" >
                                <span>
                                    全部顯示
                                </span>
                            </label></td>
                            <td width="160" align="left"><label class="topLabel">
                                <input type="radio"  name="rbnLottery" id="rbnLottery" value="six"   onclick="changelottery(this.value)">
                                <span>
                                    只顯示<b class="red">香港⑥合彩</b>
                                </span>
                            </label>
                            </td>
                            <td width="260" align="left"><label class="topLabel">
                                <input type="radio"  name="rbnLottery" id="rbnLottery" value="kc"   onclick="changelottery(this.value)">
                                <span>
                                    只顯示<b class="red">快彩</b>
                                </span>
                            </label></td>
                        </tr>
                    </table>
                </td>

                <td>
                    <form method="post">
                        <table>
                            <tr>
                                <td width="50" align="right">排序：</td>
                                <td width="50"><select name="sortName" id="sortName" onchange="changesort(this.value);">
                                    <option value="0" selected>時間</option>
                                    <option value="1" >帳號</option>
                                </select></td>
                                <td width="50"><select name="sortType" id="sortType" onchange="changesorttype(this.value);">
                                    <option value="0" selected>降序</option>
                                    <option value="1" >升序</option>
                                </select></td>
                                <td width="50" align="right">篩選：</td>
                                <td width="50"><select name="userState" id="userState" onchange="changestate(this.value)">
                                    <option value="0" selected>啟用</option>
                                    <option value="1" >凍結</option>
                                    <option value="2" >停用</option>
                                </select></td>
                                <td width="50" align="right">搜索：</td>
                                <td width="50"><select name="userFlag" id="userFlag">
                                    <option value="0" selected>帳號</option>
                                    <option value="1" >暱稱</option>
                                </select></td>
                                <td width="50" align="right"><input type="text" name="searchkey" id="searchkey" class="text w80" value=""></td>
                                <td width="50"><button type="submit" name="searchSubmit" id="searchSubmit" class="btn">查找</button></td>
                            </tr>
                        </table>
                        <input type="hidden" id="searchHidden" name="searchHidden" value="search" />
                    </form>
                </td>




                <td>&nbsp;</td>
                <td width="120"><div class="btnIco"><a id="" href="${root}/account/zd_add.html"><div class="GSico">新增${views.page["UserTypeEnum.".concat(command.search.userType)]}</div></a></div></td>
            </tr>
        </table></td>
        <td class="topRightBg1"></td>
    </tr>
    <tr>
        <td class="centerLeftBg"></td>
        <td valign="top">


            <table class="t_list">
                <tr>
                    <th width="40">在線</th>
                    <th>上级股東</th>
                    <th>占成</th>
                    <th>總代</th>
                    <th>限占</th>
                    <th>暱稱</th>
                    <th>代理</th>
                    <th>會員</th>
                    <th>信用額度</th>
                    <th>可用余額</th>
                    <th>盤口</th>
                    <th>信用/現金</th>
                    <th>新增日期</th>
                    <th>補貨</th>
                    <th width="98">功能</th>
                    <th width="60">狀態</th>
                </tr>

                <tbody class="list_hover">
                <c:forEach items="${command.result}" var="p">
                    <tr>
                        <td>
                            <img src="${resRoot}/images/USER_0.gif">
                        </td>
                        <td>${fn:substringBefore(p.ownerName,'@')}</td>
                        <td align="left">
                            <div class="mytip" uid="6cc0d7a9-e749-4cdf-bdce-04aeb31f02d5" user-name="zdl001">

                                <label class="c8">(快):</label>${p.superiorOccupy}%

                            </div>
                        </td>
                        <td>${fn:substringBefore(p.username,'@')}</td>
                        <td align="left">

                            <label class="c8">(快):</label>${p.stintOccupy > 0 ?p.stintOccupy:'...'}
                        </td>
                        <td>zdc</td>
                        <td><a href="${root}/account/fgs_add.html?search.id=${p.id}" class="redLink">0</a></td>
                        <td><a href="hy_list.aspx?lid=0&ml=&state=0&flag=0&keyword=&page=1&sortName=0&sortType=0&uid=6cc0d7a9-e749-4cdf-bdce-04aeb31f02d5&ut=zd" class="redLink">0</a></td>
                        <td align="left">

                            <label class="c8">(快):</label>${p.credits}

                        </td>

                        <td align="left">

                            <label class="c8">(快):</label>0</td>

                        </td>

                        <td align="center">

                            <label class="c8">(快):</label>${p.handicap}

                        </td>

                        <td align="left" width="190">

                            <label class="c8">(快):</label>信用

                        </td>

                        <td>19-11-21</td>
                        <td>
                            <label class="c8">(快):</label>
                            <img src="${resRoot}/images/${p.manualAutoShipments == 1?"img_1.gif":"img_0.gif"}" title="該帳號可以補貨">&nbsp;&nbsp;&nbsp;
                            <a href="/AutoLet/AutoLet_Show_kc.aspx?uid=6cc0d7a9-e749-4cdf-bdce-04aeb31f02d5&mid=2&lid=0" flag="kc" sale="1" class="setFlyAway" title="查看自動補貨設定"><img src="${resRoot}/Images/v.gif" /></a>

                        </td>

                        <td width="98" align="center"><div class="TSico"><a href="${root}/siteLotteryRebates/editRebate.html?search.id=${p.id}" class="redLink">退水</a></div>
                            <div class="XGico"><a href="${root}/account/zd_add.html?search.id=${p.id}" class="redLink">修改</a></div>
                            <div class="RZico"><a href="${root}/log/ViewUserLoginInfo.html?search.id=${p.id}" class="redLink editBtn">日誌</a></div>
                            <div class="JLico"><a href="${root}/log/LogUserChange.html?search.id=${p.id}" class="redLink editBtn">記錄</a></div></td>
                        <td align="center"><button type="button" name="Submit" uid="6cc0d7a9-e749-4cdf-bdce-04aeb31f02d5" status="0" data-name="zdl001" class="btn status">啟用</button></td>
                    </tr>
                </c:forEach>
                </tbody>


            </table>
            <!--主体开始-->
            <!--主体结束--></td>
        <td class="centerRightBg"></td>
    </tr>
    <tr>
        <td class="bottomLeftBg"></td>
        <td class="bottomBoxBg" align="center">
            <span id='pager'>共 1 條記錄  分頁：1/1頁&nbsp;&nbsp;&nbsp;上一頁『<span class='font_c'>1</span>&nbsp;』下一頁<input type="hidden" value="1" id="page"></span><input type="hidden" value="&lid=0&ml=&state=0&flag=0&namesort=0&timesort=0&keyword=&uid=4ad98bd2-d849-4168-addd-cf7618422fc9&ut=gd&sortName=0&sortType=0" id="hdnPString"></span>&nbsp;&nbsp;<input type='text' value='1' name='txtPager' id='txtPager' class='GOtext' onkeydown="javascript: if (event.keyCode ==13){ var txtPagerValue=document.getElementById('txtPager').value; var regs = /^\d+$/; if(!regs.test(txtPagerValue)){alert('輸入錯誤');document.getElementById('txtPager').focus();return false;};var hdnPStringValue=document.getElementById('hdnPString').value; location.href='?page='+txtPagerValue+hdnPStringValue;};" style="display:inline-block;vertical-align:middle;margin-bottom:2px;" /><input type='button' class='GObtn' onclick="javascript:  var txtPagerValue=document.getElementById('txtPager').value; var regs = /^\d+$/; if(!regs.test(txtPagerValue)){alert('輸入錯誤');document.getElementById('txtPager').focus();return false;};var hdnPStringValue=document.getElementById('hdnPString').value; location.href='?page='+txtPagerValue+hdnPStringValue;" id="btnPager" style="display:inline-block;vertical-align:middle;margin-bottom:2px;" />
        </td>
        <td class="bottomRightBg"></td>
    </tr>
</table>


<script>

    var isNewBet = true;
    var isReLoad = false;
    seajs.use(["setUserStatus","listHover"]);

</script>
</body>
</html>