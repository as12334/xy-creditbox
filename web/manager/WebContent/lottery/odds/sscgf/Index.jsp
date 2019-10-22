<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="lot_two_menu">
    <a href="javascript:void(0)" type="directly" page="directly">直选</a>
    <a href="javascript:void(0)" type="groupselect" page="groupselect">组选</a>
    <a href="javascript:void(0)" type="uncertain" page="uncertain">不定位</a>
    <%--大小单双暂停开放，如需开放，去掉注释--%>
    <%--<a href="javascript:void(0)"  type="size" page="size">大小单双</a>--%>
    <a href="javascript:void(0)" type="other"  page="other">其他</a>
</div>


<script>
    $(function () {
        $(".lot_two_menu a").click(function () {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            var type = $(this).attr("type");
            $("#lot_three_menu").load(root+'/lottery/odds/${code}/'+type+'/categoryIndex.html');
            $("#lot_three_menu").show();
        });

        if(!$(".lot_two_menu a").hasClass('active')){
            $(".lot_two_menu a").eq(0).trigger("click");
        }
    });
</script>