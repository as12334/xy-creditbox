<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>充值接口</title>
</head>

<body>
<form id="form1" method="get" name="form1">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30" align="center">
				<h1>
					※ 支付失败 ※
				</h1>
			</td>
		</tr>
	</table>
	<table bordercolor="#cccccc" cellspacing="5" cellpadding="0" width="400" align="center"
		border="0">
		<tr>
			<td class="text_12" bordercolor="#ffffff" align="right" width="150" height="20">
				充值接口：</td>
			<td class="text_12" bordercolor="#ffffff" align="left">
				${orderId}
			</td>
		</tr>
		<tr>
			<td class="text_12" bordercolor="#ffffff" align="right" width="150" height="20">
				订单金额元</td>
			<td class="text_12" bordercolor="#ffffff" align="left">
				${orderMoney}
			</td>
		</tr>
		<tr>
			<td class="text_12" bordercolor="#ffffff" align="right" width="150" height="20">
				错误代码
			</td>
			<td class="text_12" bordercolor="#ffffff" align="left">
				${statusCode}-${responseText}
			</td>
		</tr>
	</table>
</form>
</body>
</html>
