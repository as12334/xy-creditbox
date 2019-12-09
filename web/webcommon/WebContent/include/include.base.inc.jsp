<%--@elvariable id="DateFormat" type="org.soul.commons.locale.DateFormat"--%>
<%--@elvariable id="dateQPicker" type="org.soul.web.locale.DateQuickPicker"--%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="org.soul.commons.locale.DateFormat" %>
<%@page import="org.soul.commons.locale.DateQuickPicker" %>
<%@page import="so.wwb.creditbox.web.cache.Cache" %>
<%@ page import="so.wwb.creditbox.web.init.ConfigBase" %>
<%@ page import="so.wwb.creditbox.web.tools.SessionManagerCommon" %>
<%@ page import="java.text.MessageFormat" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@ page import="so.wwb.creditbox.web.tools.SysParamTool" %>
<%@ page import="so.wwb.creditbox.web.route.ManageRoute" %>
<%@ page import="so.wwb.creditbox.context.LotteryCommonContext" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://soul/tags" prefix="soul" %>
<%@taglib uri="http://soul/fnTag" prefix="soulFn"  %>
<%@taglib uri="http://gb/fnTag" prefix="gbFn"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="lb" %>

<c:set var="random" value="<%= System.currentTimeMillis() %>"/>
<c:set var="locale" value="<%=SessionManagerCommon.getLocale() %>"/>
<c:set var="language" value="<%= SessionManagerCommon.getLocale().toString() %>"/>
<c:set var="DateFormat" value="<%= new DateFormat() %>"/>
<c:set var="timeZone" value="<%= SessionManagerCommon.getTimeZone() %>"/>
<c:set var="dateQPicker" value="<%=DateQuickPicker.getInstance() %>"/>
<c:set var="user" value="<%= SessionManagerCommon.getSysUserExtend() %>"/>
<c:set var="siteUser" value="<%= LotteryCommonContext.get().getDomainUserName() %>"/>

<c:set var="rcVersion" value="<%= Cache.getRcVersion() %>"/>
<c:set var="domain" value="<%= request.getServerName() %>"/>

<c:set var="root" value='<%= MessageFormat.format(ConfigBase.get().getRoot(),request.getServerName()) %>' />
<c:set var="resComRoot" value='<%= MessageFormat.format(ConfigBase.get().getResComRoot(),request.getServerName()) %>' />
<c:set var="resRoot" value='<%= MessageFormat.format(ConfigBase.get().getResRoot(),request.getServerName()) %>' />
<c:set var="fileRoot" value='<%= MessageFormat.format(ConfigBase.get().getFileRoot(),request.getServerName()) %>' />
<c:set var="imgRoot" value='<%= MessageFormat.format(ConfigBase.get().getImgRoot(),request.getServerName()) %>' />
<c:set var="wsRoot" value='<%= MessageFormat.format(ConfigBase.get().getWsRoot(),SessionManagerCommon.getSubsysCode()) %>' />

<c:set var="themePath" value="${resRoot}/theme/${terminalPath}/${theme}" />
<c:set var="staticPath" value="${resRoot}/static" />
<c:set var="curTheme" value="default"/>
