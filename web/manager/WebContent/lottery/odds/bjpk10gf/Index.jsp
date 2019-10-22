<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>
    <a href="javascript:void(0)" betCode="pk10_zhixuan_qyfs" page="one">前一直选</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="pk10_zhixuan_qefs,pk10_zhixuan_qeds" page="two">前二直选</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="pk10_zhixuan_qsfs,pk10_zhixuan_qsds" page="three">前三直选</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="pk10_yixing_dwd" page="dingwei">定位胆</a>&nbsp;&nbsp;-&nbsp;&nbsp;
</div>
<script>
    $(function () {
        $(".lot_two_menu a").click(function (e) {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var betCode = $(this).attr("betCode");
            var page = $(this).attr("page");
            var code = 'bjpk10gf';
            $("#lot_three_menu").hide();
            var siteId=$("#search_id").val();
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