<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

<form:form method="post" id="edidOddForm">
    <lb:validateRule></lb:validateRule>
    <div class="widthAuto">
        <div class="shell-top" id="shell_top">
            <div class="shell-top-left"></div>
            <div class="shell-title-icon">
                <span id="shell_title">賠率設置 [<span class="blue">總監:zj01</span>]</span>
            </div>
            <div class="shell-top-right"></div>
            <div id="title-nav" class="title-nav-right">
                <select name="search.code" id="lotteryCode">
                    <c:forEach items="${command.siteLotteryList}" var="p">
                        <option value="${p.code}"  ${p.code == command.search.code?'selected':''}>${p.name}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div id="oddEditPartial">
            <jsp:include page="OddEditPartial.jsp"/>
        </div>
        <div class="shell-bottom">
            <div class="shell-bottom-left"></div>
            <div class="shell-bottom-right"></div>
            <div class="shell-bottom-content" id="shell_pageControl"></div>
        </div>
    </div>
</form:form>
<%--<%@ include file="/include/include.js.jsp" %>--%>
<soul:import res="site/lottery/odd/OddEdit"/>

<!--//region your codes 3-->
<!--//endregion your codes 3-->