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
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="len" value="${1}"/>
                    <c:forEach var="i" begin="4" end="17">
                        <c:if test="${len%5==1}">
                            <tr>
                        </c:if>
                        <th><span>${i}</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command[i.toString()]}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${len-1}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${len-1}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${len-1}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${len-1}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${len-1}].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" data-limit="${odd.oddLimit}" data-value="${odd.odd}" name="lotteryOdds[${i}].odd" value="${odd.odd}">
                            </div>
                        </td>
                        <c:if test="${len%5==0||i==17}">
                            </tr>
                        </c:if>
                        <c:set var="len" value="${len+1}"/>
                    </c:forEach>
                    <tr>
                        <th>大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['大'].id}" name="lotteryOdds[10].id">
                                <input type="hidden" value="${command['大'].code}" name="lotteryOdds[10].code">
                                <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[10].betCode">
                                <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[10].siteId">
                                <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[10].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" data-limit="${command['大'].oddLimit}" data-value="${command['大'].odd}" name="lotteryOdds[10].odd" value="${command['大'].odd}">
                            </div>
                        </td>
                        <th>小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['小'].id}" name="lotteryOdds[11].id">
                                    <input type="hidden" value="${command['小'].code}" name="lotteryOdds[11].code">
                                    <input type="hidden" value="${command['小'].betCode}" name="lotteryOdds[11].betCode">
                                    <input type="hidden" value="${command['小'].siteId}" name="lotteryOdds[11].siteId">
                                    <input type="hidden" value="${command['小'].betNum}" name="lotteryOdds[11].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['小'].oddLimit}" data-limit="${command['小'].oddLimit}" data-value="${command['小'].odd}" name="lotteryOdds[11].odd" value="${command['小'].odd}">
                                </div>
                            </div>
                        </td>
                        <th>单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['单'].id}" name="lotteryOdds[12].id">
                                <input type="hidden" value="${command['单'].code}" name="lotteryOdds[12].code">
                                <input type="hidden" value="${command['单'].betCode}" name="lotteryOdds[12].betCode">
                                <input type="hidden" value="${command['单'].siteId}" name="lotteryOdds[12].siteId">
                                <input type="hidden" value="${command['单'].betNum}" name="lotteryOdds[12].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['单'].oddLimit}" data-limit="${command['单'].oddLimit}" data-value="${command['单'].odd}" name="lotteryOdds[12].odd" value="${command['单'].odd}">
                            </div>
                        </td>
                        <th>双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['双'].id}" name="lotteryOdds[13].id">
                                    <input type="hidden" value="${command['双'].code}" name="lotteryOdds[13].code">
                                    <input type="hidden" value="${command['双'].betCode}" name="lotteryOdds[13].betCode">
                                    <input type="hidden" value="${command['双'].siteId}" name="lotteryOdds[13].siteId">
                                    <input type="hidden" value="${command['双'].betNum}" name="lotteryOdds[13].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['双'].oddLimit}" data-limit="${command['双'].oddLimit}" data-value="${command['双'].odd}" name="lotteryOdds[13].odd" value="${command['双'].odd}">
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
                </table>
            </div>
        </div>
    </div>
</div>