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
                    <c:forEach begin="3" end="19" var="i">
                        <c:if test="${i%5==3}">
                            <tr>
                        </c:if>
                        <c:set var="num" value="${i.toString()}"/>
                        <c:if test="${i<3}">
                            <c:set var="num" value="0${i}"/>
                        </c:if>
                        <c:set var="odd" value="${command[num]}"/>
                        <th><span>${i}</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i-1}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i-1}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i-1}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i-1}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i-1}].betNum">
                                <input type="text" class="form-control input-sm" name="lotteryOdds[${i-1}].odd" placeholder="<=${odd.oddLimit}" data-limit="${command[num].oddLimit}" data-value="${command[num].odd}" value="${command[num].odd}">
                            </div>
                        </td>
                        <c:if test="${i%5==2}">
                            </tr>
                        </c:if>
                    </c:forEach>

                        <tr>
                            <th>和大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['和大'].id}" name="lotteryOdds[20].id">
                                    <input type="hidden" value="${command['和大'].code}" name="lotteryOdds[20].code">
                                    <input type="hidden" value="${command['和大'].betCode}" name="lotteryOdds[20].betCode">
                                    <input type="hidden" value="${command['和大'].siteId}" name="lotteryOdds[20].siteId">
                                    <input type="hidden" value="${command['和大'].betNum}" name="lotteryOdds[20].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['和大'].oddLimit}" name="lotteryOdds[20].odd"  data-limit="${command['和大'].oddLimit}" data-value="${command['和大'].odd}" value="${command['和大'].odd}">
                                </div>
                            </td>
                            <th>和小</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['和小'].id}" name="lotteryOdds[21].id">
                                        <input type="hidden" value="${command['和小'].code}" name="lotteryOdds[21].code">
                                        <input type="hidden" value="${command['和小'].betCode}" name="lotteryOdds[21].betCode">
                                        <input type="hidden" value="${command['和小'].siteId}" name="lotteryOdds[21].siteId">
                                        <input type="hidden" value="${command['和小'].betNum}" name="lotteryOdds[21].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['和小'].oddLimit}" name="lotteryOdds[21].odd" data-limit="${command['和小'].oddLimit}" data-value="${command['和小'].odd}" value="${command['和小'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>和单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['和单'].id}" name="lotteryOdds[22].id">
                                    <input type="hidden" value="${command['和单'].code}" name="lotteryOdds[22].code">
                                    <input type="hidden" value="${command['和单'].betCode}" name="lotteryOdds[22].betCode">
                                    <input type="hidden" value="${command['和单'].siteId}" name="lotteryOdds[22].siteId">
                                    <input type="hidden" value="${command['和单'].betNum}" name="lotteryOdds[22].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['和单'].oddLimit}" name="lotteryOdds[22].odd" data-limit="${command['和单'].oddLimit}" data-value="${command['和单'].odd}" value="${command['和单'].odd}">
                                </div>
                            </td>
                            <th>和双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['和双'].id}" name="lotteryOdds[23].id">
                                        <input type="hidden" value="${command['和双'].code}" name="lotteryOdds[23].code">
                                        <input type="hidden" value="${command['和双'].betCode}" name="lotteryOdds[23].betCode">
                                        <input type="hidden" value="${command['和双'].siteId}" name="lotteryOdds[23].siteId">
                                        <input type="hidden" value="${command['和双'].betNum}" name="lotteryOdds[23].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['和双'].oddLimit}" name="lotteryOdds[23].odd" data-limit="${command['和双'].oddLimit}" data-value="${command['和双'].odd}" value="${command['和双'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>大单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['大单'].id}" name="lotteryOdds[24].id">
                                    <input type="hidden" value="${command['大单'].code}" name="lotteryOdds[24].code">
                                    <input type="hidden" value="${command['大单'].betCode}" name="lotteryOdds[24].betCode">
                                    <input type="hidden" value="${command['大单'].siteId}" name="lotteryOdds[24].siteId">
                                    <input type="hidden" value="${command['大单'].betNum}" name="lotteryOdds[24].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大单'].oddLimit}" name="lotteryOdds[24].odd"  data-limit="${command['大单'].oddLimit}" data-value="${command['大单'].odd}" value="${command['大单'].odd}">
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <th>大双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['大双'].id}" name="lotteryOdds[25].id">
                                    <input type="hidden" value="${command['大双'].code}" name="lotteryOdds[25].code">
                                    <input type="hidden" value="${command['大双'].betCode}" name="lotteryOdds[25].betCode">
                                    <input type="hidden" value="${command['大双'].siteId}" name="lotteryOdds[25].siteId">
                                    <input type="hidden" value="${command['大双'].betNum}" name="lotteryOdds[25].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大双'].oddLimit}" name="lotteryOdds[25].odd"  data-limit="${command['大双'].oddLimit}" data-value="${command['大双'].odd}" value="${command['大双'].odd}">
                                </div>
                            </td>
                            <th>小单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['小单'].id}" name="lotteryOdds[26].id">
                                    <input type="hidden" value="${command['小单'].code}" name="lotteryOdds[26].code">
                                    <input type="hidden" value="${command['小单'].betCode}" name="lotteryOdds[26].betCode">
                                    <input type="hidden" value="${command['小单'].siteId}" name="lotteryOdds[26].siteId">
                                    <input type="hidden" value="${command['小单'].betNum}" name="lotteryOdds[26].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['小单'].oddLimit}" name="lotteryOdds[26].odd"  data-limit="${command['小单'].oddLimit}" data-value="${command['小单'].odd}" value="${command['小单'].odd}">
                                </div>
                            </td>
                            <th>小双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['小双'].id}" name="lotteryOdds[27].id">
                                    <input type="hidden" value="${command['小双'].code}" name="lotteryOdds[27].code">
                                    <input type="hidden" value="${command['小双'].betCode}" name="lotteryOdds[27].betCode">
                                    <input type="hidden" value="${command['小双'].siteId}" name="lotteryOdds[27].siteId">
                                    <input type="hidden" value="${command['小双'].betNum}" name="lotteryOdds[27].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['小双'].oddLimit}" name="lotteryOdds[27].odd"  data-limit="${command['小双'].oddLimit}" data-value="${command['小双'].odd}" value="${command['小双'].odd}">
                                </div>
                            </td>
                        </tr>
                  
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>