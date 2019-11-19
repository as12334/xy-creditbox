<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>
    <title>用戶協議與規則</title>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/red/userlogin.css?v=${rcVersion}"/>
    <script>
        function exit()
        {
            location.href = 'Quit.aspx';
        }
        function agree()
        {

            location.href = 'index.html';

        }
        var massage = '聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!';
        var jsver=20170128;
    </script>
</head>
<body>
<div class="wrap">
    <div class="proBox">
        <div class="proPic1"></div>
        <div class="proPic2">
            <div class="textbox1">
                <ul>
                    <li><span>1、</span><label>使用本公司網站的客戶，請留意閣下所在的國家或居住地的相關法律規定，如有疑問應就相關問題，尋求當地法律意見。</label></li>
                    <li><span>2、</span><label>若發生遭駭客入侵破壞行為或不可抗拒之災害導致網站故障或資料損壞、資料丟失等情況，我們將以本公司之後備資料為最後處理依據；為確保各方利益，請各會員投注後列印資料。本公司不會接受沒有列印資料的投訴。</label></li>
                    <li><span>3、</span><label>為避免糾紛，各會員在投注之後，務必進入下注狀況檢查及列印資料。若發現任何異常，請立即與代理商聯繫查證，一切投注將以本公司資料庫的資料為准，不得異議。如出现特殊网络情况或线路不稳定导致不能下注或下注失败。本公司概不负责。</label></li>
                    <li><span>4、</span><label>單一注單最高派彩上限為一百萬。</label></li>
                    <li><span>5、</span><label>開獎結果以官方公佈的結果為准。</label></li>
                    <li><span>6、</span><label>我們將竭力提供準確而可靠的開獎統計等資料，但並不保證資料絕對無誤，統計資料只供參考，並非是對客戶行為的指引，本公司也不接受關於統計數據產生錯誤而引起的相關投訴。</label></li>
                    <li><span>7、</span><label>本公司擁有一切判決及註消任何涉嫌以非正常方式下註之權利，在進行更深入調查期間將停止發放與其有關之任何彩金。客戶有責任確保自己的帳戶及密碼保密，如果客戶懷疑自己的資料被盜用，應立即通知本公司，並須更改其個人詳細資料。所有被盜用帳號之損失將由客戶自行負責。在某種特殊情況下，客人之信用額可能會出現透支。</label></li>
                    <li style="text-align:right;">“聚發”管理層 敬啟　</li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="proPic3"><input type="button" value="不同意" class="btn1 grayBtn" onclick="exit()"><input type="button" value="同意" class="btn1 hotBtn" onclick="agree()"></div>

    </div>
</div>
<%--<script type="text/javascript">--%>
    <%--curl(['site/LoginValidate'], function(Page) {--%>
        <%--page = new Page();--%>
    <%--});--%>
<%--</script>--%>
<script type="text/javascript">
    window.onload = function () {
        seajs.use('LoginValidate');
    };
</script>
</body>
</html>

<%--E:\WORK\XY\rcenter\WebContent\hall\js\plugin\myLayer.js--%>

<%--<script type="text/javascript" src="${resRoot}/js/plugin/myLayer.js"></script>--%>
<%--<script type="text/javascript" src="${resRoot}/js/LoginValidate.js"></script>--%>

