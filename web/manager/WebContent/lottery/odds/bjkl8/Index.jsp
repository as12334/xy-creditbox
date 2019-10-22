<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lot_two_menu">
    <%@ include file="/include/include.inc.jsp" %>
     <a href="javascript:void(0)" betCode="keno_selection" page="selectionFive">选5</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="keno_selection" page="selectionFour">选4</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="keno_selection" page="selectionThree">选3</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="keno_selection" page="selectionTwo">选2</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="keno_selection" page="selectionOne">选1</a>&nbsp;&nbsp;-&nbsp;&nbsp;
    <a href="javascript:void(0)" betCode="tenth_place" page="other">其他</a>&nbsp;&nbsp;-&nbsp;&nbsp;
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

            if(page=="other"){
                $("#lot_three_menu").load(root+'/lottery/odds/${code}/'+page+'/categoryIndex.html');
                $("#lot_three_menu").show();
            }else {
                $.ajax({
                    url:root + "/lottery/odds/code/betting/Index.html",
                    type:"post",
                    data:{"betting":betCode,"page":page,"siteId":siteId,"code":"${code}"},
                    success: function (data) {
                        $("#editable_wrapper").html(data);
                    }
                })
            }

        });

        if(!$(".lot_two_menu a").hasClass('active')){
            $(".lot_two_menu a").eq(0).trigger("click");
        }
    });
</script>