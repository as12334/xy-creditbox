<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="combination" betCode="pl3_all_three" page="num">一字组合</a>
    <a href="javascript:void(0)" play="combination" betCode="pl3_two_different,pl3_two_same" page="two">二字组合</a>
    <a href="javascript:void(0)" play="combination" betCode="pl3_three_group3,pl3_three_group6,pl3_three_same" page="three">三字组合</a>
</div>
<script src="${resRoot}/js/lottery/odds/getSubPage.js?v=${rcVersion}"></script>
