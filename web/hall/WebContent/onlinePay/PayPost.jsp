<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:if test="${empty payHtml}">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>充值接口提交信息</title>
    </head>
    <body>
    <form method="${httpMethod}" name="pay" id="pay" action="${payUrl}">
        <c:forEach items="${payParamMap}" var="item">
            <input name='${item.key}' type='hidden' value="${item.value}"/>
        </c:forEach>
    </form>
    </body>
    <c:if test="${httpMethod eq 'GET'}">
        <script>
            (function () {
                var url = '${payUrl}';
                window.location.href = url;
            })();
        </script>
    </c:if>
    <c:if test="${httpMethod != 'GET'}">
        <script>
            (function(){
                document.getElementById("pay").submit();
            })();
        </script>
    </c:if>

    </html>
</c:if>
<c:if test="${!empty payHtml}">
    ${payHtml}
</c:if>