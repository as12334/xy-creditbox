<%--只提供国际化相关--%>
<%@ page import="org.soul.commons.lang.string.I18nTool" %>
<%@ page import="so.wwb.creditbox.web.tools.SessionManagerCommon" %>

<c:set var="views" value='<%=I18nTool.getI18nMap(SessionManagerCommon.getLocale().toString()).get("views") %>'/>
<c:set var="dicts" value='<%=I18nTool.getDictsMap(SessionManagerCommon.getLocale().toString()) %>' />
<c:set var="messages" value='<%=I18nTool.getI18nMap(SessionManagerCommon.getLocale().toString()).get("messages") %>' />