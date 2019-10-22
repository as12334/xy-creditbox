<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="groupselect" betCode="ssc_sanxing_zuxuan_hsz3fs,ssc_sanxing_zuxuan_hsz3ds,ssc_sanxing_zuxuan_hsz6fs,ssc_sanxing_zuxuan_hsz6ds,ssc_sanxing_zuxuan_hshhzx,ssc_sanxing_zuxuan_hszxhz,ssc_sanxing_zuxuan_hszxbd" page="behandsan">后三组合</a>
    <a href="javascript:void(0)" play="groupselect" betCode="ssc_sanxing_zuxuan_qsz3fs,ssc_sanxing_zuxuan_qsz3ds,ssc_sanxing_zuxuan_qsz6fs,ssc_sanxing_zuxuan_qsz6ds,ssc_sanxing_zuxuan_qshhzx,ssc_sanxing_zuxuan_qszxhz,ssc_sanxing_zuxuan_qszxbd" page="beforesan">前三组选</a>
    <a href="javascript:void(0)" play="groupselect" betCode="ssc_erxing_zuxuan_qefs,ssc_erxing_zuxuan_qeds,ssc_erxing_zuxuan_qehz,ssc_erxing_zuxuan_qebd" page="beforetwo">前二组选</a>
    <%--任选注释，如需开放，只需去掉注释就好--%>
    <%--<a href="javascript:void(0)" play="groupselect" betCode="ssc_renxuan2_zuxfs,ssc_renxuan2_zuxds,ssc_renxuan2_zuxhz" page="rentwo">任二组选</a>--%>
    <%--<a href="javascript:void(0)" play="groupselect" betCode="ssc_renxuan3_z3fs,ssc_renxuan3_z3ds,ssc_renxuan3_z6fs,ssc_renxuan3_z6ds,ssc_renxuan3_hhzx,ssc_renxuan3_zuxhz" page="renthree">任三组选</a>--%>
    <%--<a href="javascript:void(0)" play="groupselect" betCode="ssc_renxuan4_zx24,ssc_renxuan4_zx12,ssc_renxuan4_zx6,ssc_renxuan4_zx4" page="renfour">任四组选</a>--%>
</div>
<script src="${resRoot}/js/lottery/odds/getGfSubPage.js?v=${rcVersion}"></script>