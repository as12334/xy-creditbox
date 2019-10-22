<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>
    <a href="javascript:void(0)" betCode="points" page="point">点数</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="armed_forces" page="armed">三军</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="dice_full_dice" page="dice">围骰/全骰</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="long_card" page="long">长牌</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="short_card" page="short">短牌</a>&nbsp;&nbsp;-&nbsp;&nbsp;
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