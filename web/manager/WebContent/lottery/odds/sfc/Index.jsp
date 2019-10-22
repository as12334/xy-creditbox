<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>
    <a href="javascript:void(0)" betCode="sfc_first" page="normal">第一球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_second" page="normal">第二球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_third" page="normal">第三球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_fourth" page="normal">第四球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_fifth" page="normal">第五球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_sixth" page="normal">第六球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_seventh" page="normal">第七球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_eighth" page="normal">第八球</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_sum8" page="sum">总和</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sfc_dragon_tiger_12,sfc_dragon_tiger_13,sfc_dragon_tiger_14,sfc_dragon_tiger_15,sfc_dragon_tiger_16,sfc_dragon_tiger_17,sfc_dragon_tiger_18,sfc_dragon_tiger_23,sfc_dragon_tiger_24,sfc_dragon_tiger_25,sfc_dragon_tiger_26,sfc_dragon_tiger_27,sfc_dragon_tiger_28,sfc_dragon_tiger_34,sfc_dragon_tiger_35,sfc_dragon_tiger_36,sfc_dragon_tiger_37,sfc_dragon_tiger_38,sfc_dragon_tiger_45,sfc_dragon_tiger_46,sfc_dragon_tiger_47,sfc_dragon_tiger_48,sfc_dragon_tiger_56,sfc_dragon_tiger_57,sfc_dragon_tiger_58,sfc_dragon_tiger_67,sfc_dragon_tiger_68,sfc_dragon_tiger_78"  page="dragonTiger">龙虎</a>&nbsp;&nbsp;-&nbsp;&nbsp;
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