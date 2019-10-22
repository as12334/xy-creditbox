<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="group" betCode="group3_first_three" page="three">前三组选三</a>
    <a href="javascript:void(0)" play="group" betCode="group3_in_three" page="three">中三组选三</a>
    <a href="javascript:void(0)" play="group" betCode="group3_after_three" page="three">后三组选三</a>
    <a href="javascript:void(0)" play="group" betCode="group6_first_three" page="six">前三组选六</a>
    <a href="javascript:void(0)" play="group" betCode="group6_in_three" page="six">中三组选六</a>
    <a href="javascript:void(0)" play="group" betCode="group6_after_three" page="six">后三组选六</a>
</div>

<script src="${resRoot}/js/lottery/odds/getSubPage.js?v=${rcVersion}"></script>
