<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VUserDetailVo"--%>

<html lang="zh-CN">
<head>
    <title>域名编辑</title>
    <%--<%@ include file="/include/include.head.jsp" %>--%>
</head>
<body >
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/skin/main.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/jquery-ui-1.8.21.custom.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/number.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/globals.css?v=${rcVersion}"/>

<form:form id="editDomainForm" method="post">
    <lb:token/>
    <input type="hidden" name="result.id" value="${command.result.id}"/>
    <lb:validateRule/>

    <div id="myWarpr"><table class="myLayer" cellspacing="0" cellpadding="0" border="0" style="top: 316.071px; left: 282px;"><tbody><tr><td><div class="myLayerOn" style="display: none;"></div><div class="myLayerTitle"><h3>提示</h3><a href="javascript:;" class="myLayerClose" title="關閉"></a></div><div class="myLayerContent" style="width: auto; height: auto; overflow-y: auto;">不允许跨级新增！</div><div class="myLayerFooter" style="display: block;"><a href="javascript:;" class="btn grayBtn myLayerCancel" title="取消" style="display: none;">取消</a><a href="javascript:;" class="btn hotBtn myLayerOk" title="確認" style="display: inline-block;">確認</a></div><div class="myLayerLoading"></div></td></tr></tbody></table></div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<%--<script type="text/javascript">--%>
    <%--curl(['site/user/Edit'], function(Page,Dialog) {--%>
        <%--page = new Page();--%>
    <%--});--%>
<%--</script>--%>

</html>