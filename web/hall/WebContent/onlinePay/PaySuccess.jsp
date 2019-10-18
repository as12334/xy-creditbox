<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>充值接口</title>
</head>

<body>

<script type="">
	(function(){
		var userAgent = navigator.userAgent;
		if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Chrome") !=-1) {
			var win = window.open("about:blank", "_self");
			win.close();
		} else {
			window.opener = null;
			window.open("", "_self");
			window.close();
		}
	})();
</script>
</body>

</html>
