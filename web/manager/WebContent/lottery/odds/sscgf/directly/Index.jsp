<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="dataTables_wrapper" role="grid">
    <a href="javascript:void(0)" play="directly" betCode="ssc_wuxing_zhixuan_fs,ssc_wuxing_zhixuan_ds" page="five">五星直选</a>
    <a href="javascript:void(0)" play="directly" betCode="ssc_sixing_zhixuan_fs,ssc_sixing_zhixuan_ds" page="four">四星直选</a>
    <a href="javascript:void(0)" play="directly" betCode="ssc_sanxing_zhixuan_hsfs,ssc_sanxing_zhixuan_hsds,ssc_sanxing_zhixuan_hszh,ssc_sanxing_zhixuan_hshz,ssc_sanxing_zhixuan_hskd" page="behandthree">后三直选</a>
    <a href="javascript:void(0)" play="directly" betCode="ssc_sanxing_zhixuan_qsfs,s,ssc_sanxing_zhixuan_qsds,ssc_sanxing_zhixuan_qszh,ssc_sanxing_zhixuan_qshz,ssc_sanxing_zhixuan_qskd" page="beforethree">前三直选</a>
    <a href="javascript:void(0)" play="directly" betCode="ssc_erxing_zhixuan_qefs,ssc_erxing_zhixuan_qeds,ssc_erxing_zhixuan_qehz,ssc_erxing_zhixuan_qekd" page="beforetwo">前二直选</a>
    <a href="javascript:void(0)" play="directly" betCode="ssc_yixing_dwd" page="dingwei">定位胆</a>
    <%--如需开放，去掉注释--%>
    <%--<a href="javascript:void(0)" play="directly" betCode="ssc_renxuan2_zxfs,ssc_renxuan2_zxds,ssc_renxuan2_zxhz" page="rentwo">任二直选</a>--%>
    <%--<a href="javascript:void(0)" play="directly" betCode="ssc_renxuan3_zxfs,ssc_renxuan3_zxds,ssc_renxuan3_zxhz" page="renthree">任三直选</a>--%>
    <%--<a href="javascript:void(0)" play="directly" betCode="ssc_renxuan4_zxfs,ssc_renxuan4_zxds" page="renfour">任四直选</a>--%>
</div>
<script src="${resRoot}/js/lottery/odds/getGfSubPage.js?v=${rcVersion}"></script>