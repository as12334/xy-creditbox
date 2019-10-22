<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<c:set var="row" value="0"/>
<c:forEach begin="1" end="49" var="i">
    <c:if test="${i%5==1}">
        <tr>
        <c:set var="row" value="${row+1}"/>
        <c:set var="col" value="1"/>
    </c:if>
    <c:set var="num" value="${((row-1)*5+col).toString()}"/>
    <c:if test="${num.length()==1}">
        <c:set var="num" value="0${num}"/>
    </c:if>
    <th><span class="cpq-num cpq-cqssc" num="${num}">${num}</span></th>
    <td>
        <div class="input-group content-width-limit-10">
            <input type="hidden" value="${command[num].id}" name="lotteryOdds[${i}].id">
            <input type="hidden" value="${command[num].code}" name="lotteryOdds[${i}].code">
            <input type="hidden" value="${command[num].betCode}" name="lotteryOdds[${i}].betCode">
            <input type="hidden" value="${command[num].siteId}" name="lotteryOdds[${i}].siteId">
            <input type="hidden" value="${command[num].betNum}" name="lotteryOdds[${i}].betNum">
            <input type="text" class="form-control input-sm" placeholder="<=${command[num].oddLimit}" data-limit="${command[num].oddLimit}" data-value="${command[num].odd}" name="lotteryOdds[${i}].odd" value="${command[num].odd}">
        </div>
    </td>
    <td>
        <div class="input-group content-width-limit-10">
            <input type="text" class="form-control input-sm rebate" placeholder="<=${command[num].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command[num].rebateLimit}" data-value="${command[num].rebate}" value="${command[num].rebate}">
        </div>
    </td>
    <c:set var="col" value="${col+1}"/>
    <c:if test="${i%5==0}">
        <tr>
    </c:if>
</c:forEach>
<th></th>
<td></td>
</tr>