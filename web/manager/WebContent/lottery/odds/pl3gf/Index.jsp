<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="lot_two_menu">
    <a href="javascript:void(0)" page="threedirectly" betCode="pl3_sanxing_zhixuan_fs,pl3_sanxing_zhixuan_ds,pl3_sanxing_zhixuan_hz">三星直选</a>
    <a href="javascript:void(0)" page="threegroup" betCode="pl3_sanxing_zuxuan_z3fs,pl3_sanxing_zuxuan_z3ds,pl3_sanxing_zuxuan_z6fs,pl3_sanxing_zuxuan_z6ds,pl3_sanxing_zuxuan_hhzx,pl3_sanxing_zuxuan_zxhz">三星组选</a>
    <a href="javascript:void(0)" page="twodirectly" betCode="pl3_erxing_zhixuan_qefs,pl3_erxing_zhixuan_qeds,pl3_erxing_zhixuan_hefs,pl3_erxing_zhixuan_heds">二星直选</a>
    <a href="javascript:void(0)" page="twogroup" betCode="pl3_erxing_zuxuan_qefs,pl3_erxing_zuxuan_qeds,pl3_erxing_zuxuan_hefs,pl3_erxing_zuxuan_heds">二星组选</a>
    <a href="javascript:void(0)" page="dingwei" betCode="pl3_yixing_dwd">定位胆</a>
    <a href="javascript:void(0)" page="threebudingwei" betCode="pl3_budingwei_sxym">三星不定位</a>
</div>


<script>
    $(function () {
        $(".lot_two_menu a").click(function () {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var page = $(this).attr("page");
            var siteId=$("#search_id").val();
            var betCode=$(this).attr("betCode");
            $("#lot_three_menu").hide();
            $.ajax({
                url:root + "/lottery/odds/code/betting/Index.html",
                type:"post",
                data:{"betting":betCode,"page":page,"siteId":siteId,"code":"${code}"},
                success: function (data) {
                    $("#editable_wrapper").html(data);
                }
            })
        });

        if(!$(".lot_two_menu a").hasClass('active')){
            $(".lot_two_menu a").eq(0).trigger("click");
        }
    });
</script>