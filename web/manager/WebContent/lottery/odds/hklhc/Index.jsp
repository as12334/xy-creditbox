<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="lot_two_menu">
    <a href="javascript:void(0)" type="special" betCode="special_a" page="speciala">特码A</a>
    <a href="javascript:void(0)" type="special" betCode="special_b" page="specialb">特码B</a>
    <a href="javascript:void(0)" type="special" betCode="special" page="special">特肖</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_first" page="positiveNum">正码一</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_second" page="positiveNum">正码二</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_third" page="positiveNum">正码三</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_fourth" page="positiveNum">正码四</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_fifth" page="positiveNum">正码五</a>
    <a href="javascript:void(0)" type="positiveNum" betCode="positive_sixth" page="positiveNum">正码六</a>
    <a href="javascript:void(0)" type="positiveB" betCode="positive" page="positiveB">正码</a>
    <a href="javascript:void(0)" type="sevensum" betCode="seven_sum" page="sevensum">总和</a>
    <a href="javascript:void(0)" type="halfcolour" betCode="lhc_half_colour" page="halfcolour">半波</a>
    <a href="javascript:void(0)" type="onezodiac" betCode="lhc_one_zodiac" page="onezodiac">一肖</a>
    <a href="javascript:void(0)" type="linkcode" betCode="lhc_link_code" page="linkcode">连码</a>
    <a href="javascript:void(0)" type="linkzodiac" betCode="lhc_link_zodiac" page="linkzodiac">连肖</a>
    <a href="javascript:void(0)" type="allzodiac" betCode="lhc_all_zodiac" page="allzodiac">合肖</a>
    <a href="javascript:void(0)" type="linkmantissa" betCode="lhc_link_mantissa" page="linkmantissa">尾数连</a>
    <a href="javascript:void(0)" type="allnoin" betCode="lhc_all_no_in" page="allnoin">全不中</a>
</div>
<script>
    $(function () {
        $(".lot_two_menu a").click(function (e) {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var type = $(this).attr("type");
            //获取时时彩类别列表
            if("special"==type||"positiveNum"==type||"positiveB"==type
                ||"sevensum"==type||"halfcolour"==type ||"onezodiac"==type){
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