<%--
  Created by IntelliJ IDEA.
  User: block
  Date: 2019/12/5
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">
    <%--<link rel="stylesheet" href="/Styles/BallCss/ball_all.css">--%>
    <%--<link id="Iframe_skin" rel="stylesheet" href="/Styles/Blue/skin.css">--%>
    <%--<link rel="stylesheet" href="/Styles/global.css">--%>
    <%--<script src="/Scripts/json2.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/sea.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/seajs-css.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/otherConfig.js" type="text/javascript"></script>--%>
    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <script>
        seajs.use(['pageLoad']);
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
                <td><b>站內消息</b></td>
                <td width="100">&nbsp;</td>
                <td width="140" align="right"></td>
            </tr>
        </table></td>
        <td class="topRightBg1"></td>
    </tr>
    <tr>
        <td class="centerLeftBg"></td>
        <td valign="top" align="center">
            <table class="t_list">
                <tr>
                    <th width="170">貼出時間</th>
                    <th>消息詳情</th>
                </tr>
                <tbody class="list_hover">

                <tr>
                    <td width="200">公司規則</td>
                    <td class="hui" align="left">當您加入本公司成為管理層時，您必須清楚了解及遵從本公司的所有條例。您在本公司網站開出的第一個下線時，就代表您已同意及接受所有本公司的<a href="javascript:;" id="A1" class="blue">《規則及條例》</a>。
                    </td>
                </tr>

                <tr>
                    <td>2019-12-01 22:30:00</td>
                    <td class="hui" align="left">公告：由于官網提供開碼信息有誤，廣東快樂10分第2019120119期開獎號號由【11-17-05-06-14-15-13-16】更正為【15-01-11-19-08-05-02-06】，請各代理會員檢查核對，如出現額度透支，一切數據以報表為準，由此造成的不便敬請諒解！！</td>
                </tr>

                <tr>
                    <td>2019-10-20 00:00:00</td>
                    <td class="hui" align="left">聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!</td>
                </tr>


                </tbody>
            </table>

        </td>
        <td class="centerRightBg"></td>
    </tr>
    <tr>
        <td class="bottomLeftBg"></td>
        <td class="bottomBoxBg" align="center">
            <span id='pager'>共 2 條記錄  分頁：1/1頁&nbsp;&nbsp;&nbsp;上一頁『<span class='font_c'>1</span>&nbsp;』下一頁<input type="hidden" value="1" id="page"></span><input type="hidden" value="" id="hdnPString"></span>&nbsp;&nbsp;<input type='text' value='1' name='txtPager' id='txtPager' class='GOtext' onkeydown="javascript: if (event.keyCode ==13){ var txtPagerValue=document.getElementById('txtPager').value; var regs = /^\d+$/; if(!regs.test(txtPagerValue)){alert('輸入錯誤');document.getElementById('txtPager').focus();return false;};var hdnPStringValue=document.getElementById('hdnPString').value; location.href='?page='+txtPagerValue+hdnPStringValue;};" style="display:inline-block;vertical-align:middle;margin-bottom:2px;" /><input type='button' class='GObtn' onclick="javascript:  var txtPagerValue=document.getElementById('txtPager').value; var regs = /^\d+$/; if(!regs.test(txtPagerValue)){alert('輸入錯誤');document.getElementById('txtPager').focus();return false;};var hdnPStringValue=document.getElementById('hdnPString').value; location.href='?page='+txtPagerValue+hdnPStringValue;" id="btnPager" style="display:inline-block;vertical-align:middle;margin-bottom:2px;" />
        </td>
        <td class="bottomRightBg"></td>
    </tr>
</table>
<div id="A1Box">
    <div class="contentNode">
        <ul>
            <li><label>1.</label><span>使用本公司網站的各股東和代理商，請留意閣下所在的國家或居住地的相關法律規定，如有疑問應就相關問題，尋求當地法律意見。</span></li>
            <li><label>2.</label><span>若發生遭駭客入侵破壞行為或不可抗拒之災害導致網站故障或資料損壞、資料丟失等情況，我們將以本公司之後備資料為最後處理依據。</span></li>
            <li><label>3.</label><span>開獎統計等資料只供參考，并非是對客戶操作的指引，本公司也不接受關於統計數據產生錯誤而引起的相關投訴。</span></li>
            <li><label>4.</label><span>國際網路的連接速度並非本公司所能控制，本公司也不接受關於網路引起的相關投訴。</span></li>
            <li><label>5.</label><span>由於係統服務涉及高端的技術要求及外圍所不能控制的因素限制，因此係統的稳定性，連續性會有時受到影響，本公司也不承担由此而產生的損失。
    </span></li>
            <li><label>6.</label><span>各股東和代理商必須留意下線的信用額度，在某種特殊情況下，下线之信用額可能會出現透支。</span></li>
            <li><label>7.</label><span>本公司擁有一切判決及註消任何涉嫌以非正常方式下註註單之權利，在進行調查期間將停止發放與其有關之任何彩金。</span></li>
            <li><label>8.</label><span>客戶有責任確保自己的帳戶及密碼的安全，如果客戶懷疑自己的資料被盜用，應立即通知本公司，並須更改其個人詳細資料。所有被盜用帳號之損失將由客戶自行負責。</span></li>
            <li><label>9.</label><span>本公司不接受任何人以任何理由要求註銷會員下註的註单，而不論該註單是否已有開獎結果，除非该註單是由于係統出现错误或人为操作造成出現赔率错误的註單，而“赔率错误”僅定义於：(1)無論出現任何開獎結果，會員進行單項目下注的註單结果都無法獲利，或 (2)無論出現任何開獎結果，會員在同一時間如果進行多項目下註的總结果都能獲利。</span></li>
            <li><label>10.</label><span>本規則及條例的解释權及修改權歸本公司所有。</span></li>
            <li style="text-align:right"><span>“<b class="red">聚發</b>" 敬啟</span></li>
        </ul>
    </div>
</div>
<script>
    window.onload = function () {
        seajs.use(['jquery', 'alert', 'listHover'], function ($, myAlert) {
            var A1Box = $("#A1Box");
            $("#A1").click(function () {
                // myAlert({
                //     title: '公司規則',
                //     content: A1Box.html(),
                //     isShowBtn: false
                // });

                top.dialog({
                    id: 'iframeDialog',
                    title: "公司規則",
                    content: A1Box.html(),
                    fixed: true,
                    onreset: function () {
                        console.log()
                    }
                }).showModal();
            });
        });
    }
</script>
</body>
</html>
