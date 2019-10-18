<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户冻结</title>
    <%@ include file="/include/include.inc.jsp" %>
    <%@ include file="/include/include.head.jsp" %>
    <style type="text/css">
        .theme-popcon{padding:20px 45px 30px 45px;color:#444;background:#fff}
        .theme-popcon .btn{font-size:13px}
        .theme-popcon h2{text-align:center;font-size:15px;color:#2772ee}
        .theme-popcon .text{margin-top:20px;margin-bottom:20px;line-height:26px;color:#666}
        .theme-popcon .text p.center{text-align: center;}
        .theme-popcon h3{color:#333;font-size:15px}
        .popalign{text-align:center}
        .popalignr{text-align:right;}
        .tipbig{display:inline-block;padding-right:5px;vertical-align:middle;width:52px;height:52px;background:url(${resComRoot}/images/tipbig.png) no-repeat top left;cursor: pointer;}
        .tipbig.success{background-position:-15px -8px;}
        .tipbig.fail{background-position:-80px -8px;}
        .tipbig.cry{background-position:-146px -8px;}
        .popbutton{text-align:center;}
        .middle-big{width:93px;border-radius:3px;text-align:center;font-family:"Microsoft YaHei";}
        .btn-blue{ background:#2772ee; color:#fff;border:1px solid #2772ee;}
        .btn-blue-bor{border:1px solid #2772ee;background:#fff;color:#2772ee;}
        .btn-blue a{color:#fff}
        .btn-gray{background:#fff;color:#666;border:1px solid #d0d0d0;}
        .btn-bggray,.btn-bggray:hover{background:#a9a9a9;color:#fff;border:1px solid #a9a9a9;cursor:pointer}
    </style>
</head>
<body>
<form>
    <div class="theme-popcon">
        <h3 class="popalign"><i class="tipbig fail"></i>密码输错已达上限</h3>
        <div class="text">
            <p>被暂时冻结3小时，可重置密码后再操作</p>
            <p><span class="gray">冻结时间：2015.08.09 03:32:43</span>
            </p>
        </div>
        <div class="popbutton">
            <button data-toggle="button" class="btn btn-blue middle-big" type="button">联系客服</button>
            <button data-toggle="button" class="btn btn-gray middle-big" type="button">取消</button>
        </div>
    </div>
</form>
</body>
<%@ include file="/include/include.js.jsp" %>
<soul:import type="list"/>
</html>
