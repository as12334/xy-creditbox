<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="lot_two_menu">
    <a href="javascript:void(0)" type="digital">定位</a>
    <a href="javascript:void(0)" type="combination">组合</a>
    <a href="javascript:void(0)" type="sum">和数</a>
    <a href="javascript:void(0)" type="group3" page="group3" betCode="pl3_group3">组选3</a>
    <a href="javascript:void(0)" type="group6" page="group6" betCode="pl3_group6">组选6</a>
    <a href="javascript:void(0)" type="span" page="span" betCode="pl3_span">跨度</a>
</div>


<script>
    $(function () {
        $(".lot_two_menu a").click(function (e) {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var type = $(this).attr("type");
            //获取时时彩类别列表
            if("group3"==type||"group6"==type||"span"==type){
                var siteId=$("#search_id").val();
                var page = $(this).attr("page");
                var betCode = $(this).attr("betCode");
                $.ajax({
                    url:root + "/lottery/odds/code/betting/Index.html",
                    type:"post",
                    data:{"betting":betCode,"page":page,"siteId":siteId,"code":"${code}"},
                    success: function (data) {
                        $("#editable_wrapper").html(data);
                    }
                })
                $("#lot_three_menu").hide();
            }else{
                $("#lot_three_menu").load(root+'/lottery/odds/${code}/'+type+'/categoryIndex.html');
                $("#lot_three_menu").show();
            }


        });

        if(!$(".lot_two_menu a").hasClass('active')){
            $(".lot_two_menu a").eq(0).trigger("click");
        }
    });
</script>