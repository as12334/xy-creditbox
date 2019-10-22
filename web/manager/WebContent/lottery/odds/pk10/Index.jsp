<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>

    <a href="javascript:void(0)" betCode="champion_up_sum" page="championUpSum">冠/亚和</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="champion" page="normal">冠军</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="runner_up" page="normal">亚军</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="third_runner" page="normal">季军</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="fourth_place" page="normal">第四名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="fifth_place" page="normal">第五名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="sixth_place" page="normal">第六名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="seventh_place" page="normal">第七名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="eighth_place" page="normal">第八名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="ninth_place" page="normal">第九名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="tenth_place" page="normal">第十名</a>&nbsp;&nbsp;-&nbsp;&nbsp;
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