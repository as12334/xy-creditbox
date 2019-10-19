<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<form:form action="${root}/siteConfineIp/bossSiteConfineIpList.html?search.siteId=${command.search.siteId}" method="post"
           id="bossMainFrameIp">
    <div class="row">
    <lb:validateRule/>
        <lb:token/>
    <div class="position-wrap clearfix">
        <span>站点</span><span>/</span><span>平台管理</span>
        <span>/</span><span>白名单</span>
        <a nav-target="mainFrame" class="m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn"  href="/site/siteBoss/list.html">
            <em class="fa fa-caret-left"></em>返回</a>
    </div>
    <div class="col-lg-12">
        <div class="wrapper white-bg shadow">
            <!--筛选条件-->
            <c:choose>
            <c:when test="${command.type.equals('2')&&!command.sysParam.paramValue=='true'&&command.result.size()==0}">
                <div class="modal-body">
                    <div class="clearfix m-b bg-gray p-t-xs">
                    <span class="co-orange fs36 line-hi25 col-xs-1 al-right m-r-sm">
                        <i class="fa fa-exclamation-circle"></i>
                    </span>
                        <div class="line-hi34 m-b-sm">${command.type.equals('2')?views.setting['siteConfine.ip.site.playerMsg']:views.setting['siteConfine.ip.site.admin.playerMsg']}</div>
                    </div>
                </div>
                <div class="modal-footer al-center">
                    <a href="/siteConfineIp/list.html?sysParam.id=${command.sysParam.id}&sysParam.paramValue=true&search.type=${command.type}&type=${command.type}" class="btn btn-filter btn-lg" nav-target="mainFrame">好的</a>
                </div>
            </c:when>
            <c:otherwise>
            <div class="clearfix filter-wraper border-b-1">
                <div class="search-wrapper btn-group pull-right m-r-n-xs">
                    <div class="input-group">
                        <form:input class="form-control" path="search.searchIp" placeholder="${views.common['pleaseEnter']}IP"/>
                            <span class="input-group-btn">
                                <soul:button target="query" opType="function" text="${views.common['query']}"  cssClass="btn btn-filter">
                                    <i class="fa fa-search"></i><span class="hd">&nbsp;${views.common['query']}</span>
                                </soul:button>
                            </span>
                    </div>
                </div> </div>
            <!--表格内容-->
            <div class="search-list-container">
                <%@ include file="IndexPartial.jsp" %>
                </c:otherwise>
                </c:choose>
            </div>
        </div></div>
    </div>
    </div>

    <button hidden="hidden" id="showButton" type="button" class="" data-toggle="modal" data-target="#myModal">
    </button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">${messages.common['msg']}</h4>
                </div>
                <div class="modal-body">
                        ${views.setting['siteConfine.ip.open']}
                </div>
                <div class="modal-footer">
                    <soul:button cssClass="btn btn-primary-hide" callback="closeModal" target="${root}/siteConfineIp/getSettingParam.html?type=${command.type}" text="${views.common['setting']}" opType="dialog"><i class="fa fa-gear"></i><span class="hd">${views.setting['siteConfine.ip.to.open']}</span></soul:button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">${views.common['cancel']}</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
<soul:import res="site/boss/site/boss/ip/Index"/>
