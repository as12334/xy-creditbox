<%--@elvariable id="command" type="List<TreeNode<VSysUserResource>>"--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/include.inc.jsp" %>
<nav class="navbar-default navbar-static-side shadow" role="navigation">
  <div class="sidebar-collapse">
    <ul class="nav" id="side-menu">
      <c:forEach items="${command}" var="obj" varStatus="status">
        <c:if test="${not(obj.object.id == '703' && sessionSysUser.userType == '21')}">
        <li>
          <a <c:if test="${obj.children.size()>0}">href="javascript:void(0);"</c:if>
                  <c:if test="${obj.children.size()==0}">nav-target='mainFrame' href="/${obj.object.resourceUrl}"</c:if>>
            <em class="iconfont ${obj.object.resourceIcon}"></em><span class="nav-label">${obj.object.resourceRName}</span>
            <%--<span class="fa arrow"></span>--%>
          </a>
         <%-- <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
            <c:forEach items="${obj.children}" var="cobj" varStatus="status">
              <li><a nav-target='mainFrame' href="/${cobj.object.resourceUrl}">${cobj.object.resourceRName}</a></li>
            </c:forEach>
          </ul>--%>
        </li>
        </c:if>
      </c:forEach>
    </ul>
  </div>
</nav>
<div id="page-wrapper" class="gray-bg dashbard-1">
  <div id="mainFrame">
  </div>
</div>
<script type="text/javascript" language="JavaScript">
  $('#side-menu').metisMenu();
</script>

<%--
<c:forEach items="${command}" var="obj" varStatus="status">
  <li>
    <a <c:if test="${obj.children.size()>0}">href="javascript:void(0);"</c:if>
       <c:if test="${obj.children.size()==0}">nav-target='mainFrame' href="/${obj.object.resourceUrl}"</c:if>>
      <em class="fa ${obj.object.resourceIcon}"></em><span class="nav-label">${obj.object.resourceRName}</span>
        &lt;%&ndash;<span class="fa arrow"></span>&ndash;%&gt;
    </a>
    <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
      <c:forEach items="${obj.children}" var="cobj" varStatus="status">
        <li><a nav-target='mainFrame' href="/${cobj.object.resourceUrl}">${cobj.object.resourceRName}</a></li>
      </c:forEach>
    </ul>
  </li>
</c:forEach>--%>
