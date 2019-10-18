<%@ include file="include.base.js.jsp" %>
<script>
</script>
<script type="text/javascript">
    curl(['lb/components/select'], function(Page) {
        select = new Page();
    });
    curl(['zeroClipboard','UE'], function (zeroClipboard,UE) {
       window.ZeroClipboard=zeroClipboard;
        window.UE=UE;
    });
</script>