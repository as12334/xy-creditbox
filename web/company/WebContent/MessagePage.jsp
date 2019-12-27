
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserVo"--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title></title>
    <link href="favicon.ico" rel="shortcut icon">
    <%--<link rel="stylesheet" href="Styles/Blue/skin.css">--%>
    <%--<link rel="stylesheet" href="Styles/global.css">--%>


    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <title>title</title>
    <link href="favicon.ico" rel="shortcut icon">
    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>



</head>
<body >

<!--主体部分-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <tr class="alertHide">
        <td class="topLeftBg1">
        </td>
        <td class="topBoxBg1">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tm2">
                <tr>
                    <td width="26" align="center">
                        <div class="topArr">
                        </div>
                    </td>
                    <td>
                        <b>
                            系統提示
                        </b>
                    </td>
                    <td width="100">&nbsp;

                    </td>
                    <td width="140" align="right">
                    </td>
                </tr>
            </table>
        </td>
        <td class="topRightBg1">
        </td>
    </tr>
    <tr>
        <td class="centerLeftBg alertHide">
        </td>
        <td valign="top" align="center">
            <!-- 開始 -->
            <div class="tBox">
                <div class="wrong">
                    ${command.errMsg}
                </div>
            </div>
            <!-- 結束 -->
        </td>
        <td class="centerRightBg alertHide">
        </td>
    </tr>
    <tr class="alertHide">
        <td class="bottomLeftBg">
        </td>
        <td class="bottomBoxBg" align="center">

        </td>
        <td class="bottomRightBg">
        </td>
    </tr>
</table>
<script>
    window.onload = function () {
        seajs.use(['jquery', 'sub'], function ($, sub) {
            sub.removeAjaxLoading();

        });
    };
</script>
</body>
</html>

