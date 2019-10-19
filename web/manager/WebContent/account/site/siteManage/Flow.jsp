<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<ul class="artificial-tab clearfix">
    <c:choose>
        <c:when test="${currentUserType eq '2' || currentUserType eq '21'}">
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '1'?'current':''}" href="javascript:void(0)">
                    <span class="no">1</span><span class="con">站点基本信息</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '2'?'current':''}" href="javascript:void(0)">
                    <span class="no">2</span><span class="con">选择彩种</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '3'?'current':''}" href="javascript:void(0)">
                    <span class="no">3</span><span class="con">选择赔率</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '4'?'current':''}" href="javascript:void(0)">
                    <span class="no">4</span><span class="con">选择限额</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '5'?'current':''}" href="javascript:void(0)">
                    <span class="no">5</span><span class="con">选择模板</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '6'?'current':''}" href="javascript:void(0)">
                    <span class="no">6</span><span class="con">预览方案</span>
                </a>
            </li>
            <li class=" col-xs-10 p-x" style="width: 200px">
                <a class="${command.search.step eq '7'?'current':''}" href="javascript:void(0)">
                    <span class="no">7</span><span class="con">建站成功</span>
                </a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="col-sm-2 col-xs-12 p-x">
                <a class="${command.search.step eq '1'?'current':''}" href="javascript:void(0)">
                    <span class="no">1</span><span class="con">站点基本信息</span>
                </a>
            </li>
            <li class="col-sm-2 col-xs-12 p-x">
                <a class="${command.search.step eq '6'?'current':''}" href="javascript:void(0)">
                    <span class="no">6</span><span class="con">预览方案</span>
                </a>
            </li>
            <li class="col-sm-2 col-xs-12 p-x">
                <a class="${command.search.step eq '7'?'current':''}" href="javascript:void(0)">
                    <span class="no">7</span><span class="con">建站成功</span>
                </a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>