<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="panel-body">
        <div class="tab-content">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover dataTable m-b-none text-center" aria-describedby="editable_info">
                    <thead>
                    <tr class="bg-gray">
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" begin="1" end="6">
                        <c:if test="${i%3==1}">
                            <tr>
                        </c:if>
                        <th><em class="gr gr-dice-${i} fs1"></em><em class="gr gr-dice-${i} fs1"></em><em class="gr gr-dice-${i} fs1"></em></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="num" value="${i}${i}${i}"/>
                                <c:set var="odd" value="${command[num]}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i-1}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i-1}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i-1}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i-1}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i-1}].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${i-1}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>
                        <c:if test="${i%3==0}">
                            </tr>
                        </c:if>
                    </c:forEach>
                    <tr>
                        <th>全骰</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['全骰'].id}" name="lotteryOdds[6].id">
                                <input type="hidden" value="${command['全骰'].code}" name="lotteryOdds[6].code">
                                <input type="hidden" value="${command['全骰'].betCode}" name="lotteryOdds[6].betCode">
                                <input type="hidden" value="${command['全骰'].siteId}" name="lotteryOdds[6].siteId">
                                <input type="hidden" value="${command['全骰'].betNum}" name="lotteryOdds[6].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['全骰'].oddLimit}" data-limit="${command['全骰'].oddLimit}" data-value="${command['全骰'].odd}" name="lotteryOdds[6].odd" value="${command['全骰'].odd}">
                            </div>
                        </td>
                        <th></th>
                        <td></td>
                        <th></th>
                        <td></td>
                    </tr>
                </tbody>
                </table>
            </div>
        </div>
    </div>
</div>