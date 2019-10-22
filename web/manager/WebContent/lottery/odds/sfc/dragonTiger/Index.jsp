    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="panel-body">
        <div class="tab-content">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover dataTable m-b-none text-center"
                       aria-describedby="editable_info">
                    <thead>

                    <tr class="bg-gray">
                        <th>号码</th>
                        <th>龙</th>
                        <th>虎</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set value="0" var="lotteryIndex"/>
                    <c:forEach items="${command}" var="i" varStatus="status">
                        <c:if test="${lotteryIndex%2==0}">
                        <tr>
                        </c:if>
                        <th><span>龙${fn:substring(i.key,17,18)}虎${fn:substring(i.key,18,19)}</span></th>
                            <c:forEach items="${i.value}" var="p" >

                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                                <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                            </c:forEach>
                        <c:if test="${lotteryIndex%2==1}">
                        </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>