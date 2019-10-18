<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="keywords" content="keywords"/>
    <meta name="description" content="description"/>
    <meta name="author" content="author"/>
    <meta name="Copyright" content="author"/>
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>充值接口支付二维码</title>
    <style type="text/css">
        * {
            box-sizing: border-box;
        }

        html {
            -ms-text-size-adjust: 100%;
            -webkit-text-size-adjust: 100%;
        }

        ol, ul {
            list-style: none;
        }

        a {
            color: #333;
            outline: none;
            text-decoration: none;
        }

        a:hover {
            color: #555;
        }

        img {
            border: none;
        }

        body {
            color: #666;
            background: #f0f4f7;
            font: 14px/1.5em "Segoe UI", "Lucida Grande", "Helvetica", "Arial", "Microsoft YaHei";
            margin: 0;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        td, th {
            padding: 0;
        }

        /*common*/
        .container {
            margin: 0 auto;
            overflow: hidden;
            padding-left: 10px;
            padding-right: 10px;
        }

        .container:before, .container:after {
            content: " ";
            display: table
        }

        .container:after {
            clear: both
        }

        .pull-left {
            float: left;
        }

        .pull-right {
            float: right;
        }

        .list-inline {
            list-style: none;
        }

        .list-inline > li {
            display: inline;
            padding: 0;
        }

        .row {
            margin-left: -10px;
            margin-right: -10px
        }

        .row:before, .row:after {
            content: " ";
            display: table
        }

        .row:after {
            clear: both
        }

        .col-left, .col-right {
            position: relative;
            min-height: 1px;
            padding-left: 10px;
            padding-right: 10px;
            box-sizing: border-box;
            float: left
        }

        .row-gutter-0 {
            margin-left: 0;
            margin-right: 0
        }

        .row-gutter-0 > * {
            padding-left: 0;
            padding-right: 0
        }

        /*tool*/
        .text-left {
            text-align: left;
        }

        .text-center {
            text-align: center;
        }

        .text-right {
            text-align: right;
        }

        .m-l-40 {
            margin-left: 40px;
        }

        .btn {
            display: inline-block;
            margin-bottom: 0;
            padding: 5px 12px;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.5;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            cursor: pointer;
            user-select: none;
            border-radius: 4px;
        }

        /*style*/
        .top-box {
            background: #003551;
            color: #fff;
            height: 32px;
            line-height: 32px;
        }

        .main-box {
            margin: 10px 0;
        }

        .main {
            background: #fff;
            border: 1px solid #e8ecef;
        }

        .main > .main-top {
            border-bottom: 1px dashed #9ca6ac;
            padding: 35px 30px;
        }

        .main > .main-content {
            padding: 20px;
            text-align: center;
        }

        .main > .main-content .qrcode-title, .main > .main-content .qrcode-caption {
            height: 40px;
            line-height: 40px;
        }

        .main > .main-content .qrcode-img img {
            width: 100%;
            max-width: 360px;
            margin: 0 auto;
        }

        .main > .main-content .pay-desc {
            text-align: center;
        }

        .main > .main-content .pay-desc img {
            max-width: 100%;
            margin: 0 auto;
        }

        .main > .main-content .qrcode-caption {
            font-size: 1.1em;
            color: #2772ee;
        }

        .main > .main-content .pay-desc {
            padding-top: 60px;
        }

        .main > .main-footer {
            border-top: 1px dashed #e8e8e8;
            padding: 35px 30px;
        }

        .money-text {
            color: #FF8208;
            font-size: 2em;
        }

        .order-text {
            color: #00678a;
            font-size: 1.2em;
        }

        .btn-blue {
            background: #2772ee;
            color: #fff;
            padding: 10px 72px;
        }

        .btn-blue:hover {
            color: #ddd;
            background: #1b56e8;
        }

        /*Media Queries Style*/
        @media (max-width: 480px) {
            .container {
                width: 100%;
            }

            .col-left, .col-right {
                width: 100%;
            }

            .qrcode-text {
                margin-left: 10px;
            }

            .order-text {
                display: block;
                margin-left: 0;
                font-size: 1em;
            }
        }

        @media (min-width: 480px) {
            .container {
                width: 460px;
            }

            .col-left, .col-right {
                width: 100%;
            }

            .qrcode-text {
                margin-left: 10px;
            }

            .order-text {
                display: block;
                margin-left: 0;
            }
        }

        @media (min-width: 768px) {
            .container {
                width: 750px;
            }

            .order-text, .qrcode-text {
                display: inline-block;
                margin-left: 20px;
            }
        }

        @media (min-width: 980px) {
            .container {
                width: 960px;
            }

            .order-text, .qrcode-text {
                margin-left: 30px;
            }
        }

        @media (min-width: 1200px) {
            .container {
                width: 1170px;
            }

            .col-left {
                width: 35%
            }

            .col-right {
                width: 65%
            }

            .order-text, .qrcode-text {
                margin-left: 40px;
            }
        }
    </style>
</head>

<body>
<div class="top-box">
    <div class="container">扫码支付</div>
</div>
<c:if test="${accountType eq 'wechatpay_scan'}">
    <c:set var="desc" value="微信"/>
</c:if>
<c:if test="${accountType eq 'alipay_scan'}">
    <c:set var="desc" value="支付宝"/>
</c:if>
<c:if test="${accountType eq 'qqwallet_scan'}">
    <c:set var="desc" value="QQ钱包"/>
</c:if>
<c:if test="${accountType eq 'jdwallet_scan'}">
    <c:set var="desc" value="京东钱包"/>
</c:if>
<c:if test="${accountType eq 'bdwallet_scan'}">
    <c:set var="desc" value="百度钱包"/>
</c:if>
<c:if test="${accountType eq 'unionpay_scan'}">
    <c:set var="desc" value="银联扫码"/>
</c:if>
<div class="main-box">
    <div class="container">
        <div class="main">
            <div class="main-top">存款金额
                <strong class="money-text">${money}</strong>
                <strong class="order-text">订单号${key}</strong>
            </div>
            <div class="main-content">
                <div class="row">
                    <div class="col-left">
                        <div class="qrcode-title">
                            扫码支付
                            <span class="qrcode-text">扫一扫二维码即可完成支付</span>
                        </div>
                        <div class="qrcode-img">
                            <c:choose>
                                <c:when test="${!empty qrImgUrl}">
                                    <img src="${qrImgUrl}"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="data:image/png;base64,${qrcode64}"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="qrcode-caption">扫码支付</div>
                    </div>
                    <div class="col-rigth">
                        <div class="pay-desc">
                            <c:if test="${accountType eq 'wechatpay_scan'}">
                                <img src="/onlinePay/images/wechat-pay-desc.png" alt="支付步骤">
                            </c:if>
                            <c:if test="${accountType eq 'alipay_scan'}">
                                <img src="/onlinePay/images/alipay-pay-desc.png" alt="支付步骤">
                            </c:if>
                            <c:if test="${accountType eq 'qqwallet_scan'}">
                                <img src="/onlinePay/images/qqwallet-pay-desc.png" alt="QQ钱包支付步骤">
                            </c:if>
                            <c:if test="${accountType eq 'jdwallet_scan'}">
                                <img src="/onlinePay/images/jdwallet-pay-desc.png" alt="京东钱包">
                            </c:if>
                            <c:if test="${accountType eq 'bdwallet_scan'}">
                                <img src="/onlinePay/images/bdwallet-pay-desc.png " alt="百度钱包">
                            </c:if>
                            <c:if test="${accountType eq 'unionpay_scan'}">
                                <img src="/onlinePay/images/ylwallet-pay-desc.png" alt="银联扫码">
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <%--<div class="main-footer text-center"><a class="btn btn-blue" href="javascript:window.close()" title="付款完成">付款完成</a>
            </div>--%>
        </div>
    </div>
</div>
</body>
</html>