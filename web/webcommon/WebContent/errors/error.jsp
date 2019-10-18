<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.soul.commons.exception.ExceptionTool" %>
<%@ page import="org.soul.commons.init.context.CommonContext" %>
<%@ page import="org.soul.commons.init.context.ContextParam" %>
<%@ page import="org.soul.commons.lang.DateTool" %>
<%@ page import="org.soul.commons.lang.string.RandomStringTool" %>
<%@ page import="org.soul.commons.locale.LocaleDateTool" %>
<%@ page import="org.soul.commons.log.Log" %>
<%@ page import="org.soul.commons.log.LogFactory" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>500 | 服务器内部错误</title>
    <%@ include file="/include/include.base.inc.jsp" %>
    <%@ include file="/include/include.base.head.jsp" %>
</head>
<body>
<%
    String s="";
    ContextParam contextParam = CommonContext.get();
    TimeZone timeZone = contextParam == null ? TimeZone.getTimeZone("GMT+8") : CommonContext.get().getTimeZone();
    TimeZone timeZone1 = timeZone == null ? TimeZone.getTimeZone("GMT+8") : timeZone;
    String date = LocaleDateTool.formatDate(new Date(), DateTool.FMT_HYPHEN_DAY_CLN_SECOND, timeZone == null ? TimeZone.getTimeZone("GMT+8") : timeZone);
    Exception exception= ((Exception)request.getAttribute("javax.servlet.error.exception"));
    if(exception!=null) {
        s = RandomStringTool.randomNumeric(5);
        Log LOG = LogFactory.getLog(exception.getClass());
        String stackTrace = ExceptionTool.getStackTrace(exception);
        if (exception != null && exception.getCause() != null && exception.getCause().getCause() != null) {
            stackTrace += "\r\nRoot Cause:" + ExceptionTool.getStackTrace(exception.getCause().getCause());
        }
        LOG.error("error-" + s + "-" + stackTrace);
    }
%>
错误代码：<%=s%><br>
请将此代码提交给我们，我们将第一时间为您解决，给您带来不便敬请谅解。<br>(<%=date%>(<%=timeZone1.getID()%>))
</body>
</html>