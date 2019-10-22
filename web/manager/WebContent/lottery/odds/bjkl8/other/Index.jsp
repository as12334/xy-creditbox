<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="other" betCode="keno_sum20" page="Sum">和值</a>
    <a href="javascript:void(0)" play="other" betCode="keno_number" page="UpDown">上中下盘</a>
    <a href="javascript:void(0)" play="other" betCode="keno_number" page="OddEven">奇偶和盘</a>
    <a href="javascript:void(0)" play="other" betCode="keno_sum20" page="Elements">五行</a>
</div>
<script src="${resRoot}/js/lottery/odds/getSubPage.js?v=${rcVersion}"></script>
