<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>
    <a href="javascript:void(0)" betCode="k3_danxuan_ertong,k3_fuxuan_ertong,k3_danxuan_santong,k3_tongxuan_santong" page="tonghao">同号</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="k3_erbutong,k3_sanbutong" page="butong">不同号</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="k3_tongxuan_sanlian" page="lianhao">三连号</a>&nbsp;&nbsp;-&nbsp;&nbsp;
</div>
<script>
    $(function () {
        $(".lot_two_menu a").click(function (e) {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var betCode = $(this).attr("betCode");
            var page = $(this).attr("page");
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