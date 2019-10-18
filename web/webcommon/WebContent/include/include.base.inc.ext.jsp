<%@page import="so.wwb.lotterybox.web.tools.SessionManagerCommon" %>

<c:set var="logo" value="<%= SessionManagerCommon.getLogo() %>"/>
<c:set var="flashLogo" value="<%= SessionManagerCommon.getFlashLogo() %>"/>
<c:set var="sessionSysUser" value="<%= SessionManagerCommon.getUser() %>"/>
<c:set var="siteId" value="<%=SessionManagerCommon.getSiteId() %>"/>
<c:set var="siteName" value="<%=SessionManagerCommon.getSiteDomainName(request) %>"/>
<c:set var="siteTilte" value="<%=SessionManagerCommon.getSiteDomainTilte(request)%>"/>
<c:set var="siteDomain" value="<%=SessionManagerCommon.getSiteDomain(request) %>"/>
