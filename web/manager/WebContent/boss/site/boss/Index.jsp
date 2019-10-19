<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<div class="row">
    <form:form action="${root}/site/siteBoss/list.html" method="post" id="bossSiteManagerForm">
        <lb:validateRule/>
        <lb:token/>
        <div class="position-wrap clearfix">
            <span>站点</span><span>/</span>
            <span>平台管理</span>
        </div>
        <div class="col-lg-12 m-t">
            <div class="wrapper white-bg shadow">
                <div class="search-list-container">
                    <%@ include file="IndexPartial.jsp" %>
                </div>
            </div>
        </div>
    </form:form>
</div>
<soul:import res="site/boss/site/boss/Index"/>
