<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="one" betCode="ten_thousand" page="num">万定位</a>
    <a href="javascript:void(0)" play="one" betCode="thousand" page="num">千定位</a>
    <a href="javascript:void(0)" play="one" betCode="hundred" page="num">百定位</a>
    <a href="javascript:void(0)" play="one" betCode="ten" page="num">十定位</a>
    <a href="javascript:void(0)" play="one" betCode="one" page="num">个定位</a>
    <a href="javascript:void(0)" play="one" betCode="one_all_five" page="group">全五一字组合</a>
    <a href="javascript:void(0)" play="one" betCode="one_first_three" page="group">前三一字组合</a>
    <a href="javascript:void(0)" play="one" betCode="one_in_three" page="group">中三一字组合</a>
    <a href="javascript:void(0)" play="one" betCode="one_after_three" page="group">后三一字组合</a>
</div>
<script src="${resRoot}/js/lottery/odds/getSubPage.js?v=${rcVersion}"></script>
