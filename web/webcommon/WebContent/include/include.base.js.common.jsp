<%@ page import="org.soul.commons.init.context.CommonContext" %><%--common js base--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var curTheme = '${curTheme}';
    var root = '${root}';
    var resComRoot = '${resComRoot}';
    var resRoot = '${resRoot}';
    var fileRoot = '${fileRoot}';
    var imgRoot = '${imgRoot}';
    var random = '${random}';
    var wsRoot='${wsRoot}';
    var rcVersion = '${rcVersion}';
    var utcOffSet = <%=SessionManagerCommon.getTimeZone().getRawOffset()/60/1000%>;
    var dateFormat={daySecond:'<%= CommonContext.getDateFormat().getDAY_SECOND() %>',day:'<%= CommonContext.getDateFormat().getDAY() %>',dayminute:'<%=CommonContext.getDateFormat().getDAY_MINUTE()%>'};
</script>
