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
                    <c:forEach begin="0" end="27" var="i">
                        <c:if test="${!empty  command[i.toString()]}">
                        <c:if test="${i%5==0}">
                            <tr>
                        </c:if>
                        <th><span>${i}</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command[i.toString()]}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i}].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${i}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>
                        <c:if test="${i%5==4}">
                            </tr>
                        </c:if>
                        </c:if>
                    </c:forEach>
                    <c:if test="${command['0尾'].id !=null}">
                    <c:forEach begin="0" end="9" var="i">
                        <c:if test="${i%5==0}">
                            <tr>
                        </c:if>
                        <c:set var="num" value="${i.toString()}尾"/>
                        <th><span>${num}</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command[num]}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i+19}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i+19}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i+19}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i+19}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i+19}].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${i+19}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>
                        <c:if test="${i%5==4}">
                            </tr>
                        </c:if>
                    </c:forEach>
                    </c:if>
                        <tr>
                            <c:if test="${command['大'].id !=null}">
                            <th>大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['大'].id}" name="lotteryOdds[29].id">
                                    <input type="hidden" value="${command['大'].code}" name="lotteryOdds[29].code">
                                    <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[29].betCode">
                                    <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[29].siteId">
                                    <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[29].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" data-limit="${command['大'].oddLimit}" data-value="${command['大'].odd}" name="lotteryOdds[29].odd" value="${command['大'].odd}">
                                </div>
                            </td>
                            </c:if>
                            <c:if test="${command['小'].id !=null}">
                            <th>小</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['小'].id}" name="lotteryOdds[30].id">
                                        <input type="hidden" value="${command['小'].code}" name="lotteryOdds[30].code">
                                        <input type="hidden" value="${command['小'].betCode}" name="lotteryOdds[30].betCode">
                                        <input type="hidden" value="${command['小'].siteId}" name="lotteryOdds[30].siteId">
                                        <input type="hidden" value="${command['小'].betNum}" name="lotteryOdds[30].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['小'].oddLimit}" data-limit="${command['小'].oddLimit}" data-value="${command['小'].odd}" name="lotteryOdds[30].odd" value="${command['小'].odd}">
                                    </div>
                                </div>
                            </td>
                            </c:if>
                            <c:if test="${command['单'].id !=null}">
                            <th>单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['单'].id}" name="lotteryOdds[31].id">
                                    <input type="hidden" value="${command['单'].code}" name="lotteryOdds[31].code">
                                    <input type="hidden" value="${command['单'].betCode}" name="lotteryOdds[31].betCode">
                                    <input type="hidden" value="${command['单'].siteId}" name="lotteryOdds[31].siteId">
                                    <input type="hidden" value="${command['单'].betNum}" name="lotteryOdds[31].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['单'].oddLimit}" data-limit="${command['单'].oddLimit}" data-value="${command['单'].odd}" name="lotteryOdds[31].odd" value="${command['单'].odd}">
                                </div>
                            </td>
                            </c:if>
                            <c:if test="${command['双'].id !=null}">
                            <th>双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['双'].id}" name="lotteryOdds[32].id">
                                        <input type="hidden" value="${command['双'].code}" name="lotteryOdds[32].code">
                                        <input type="hidden" value="${command['双'].betCode}" name="lotteryOdds[32].betCode">
                                        <input type="hidden" value="${command['双'].siteId}" name="lotteryOdds[32].siteId">
                                        <input type="hidden" value="${command['双'].betNum}" name="lotteryOdds[32].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['双'].oddLimit}" data-limit="${command['双'].oddLimit}" data-value="${command['双'].odd}" name="lotteryOdds[32].odd" value="${command['双'].odd}">
                                    </div>
                                </div>
                            </td>
                            </c:if>
                        </tr>
                        <tr>
                            <th>尾质</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾质'].id}" name="lotteryOdds[33].id">
                                        <input type="hidden" value="${command['尾质'].code}" name="lotteryOdds[33].code">
                                        <input type="hidden" value="${command['尾质'].betCode}" name="lotteryOdds[33].betCode">
                                        <input type="hidden" value="${command['尾质'].siteId}" name="lotteryOdds[33].siteId">
                                        <input type="hidden" value="${command['尾质'].betNum}" name="lotteryOdds[33].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾质'].oddLimit}" data-limit="${command['尾质'].oddLimit}" data-value="${command['尾质'].odd}" name="lotteryOdds[33].odd" value="${command['尾质'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>尾合</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾合'].id}" name="lotteryOdds[34].id">
                                        <input type="hidden" value="${command['尾合'].code}" name="lotteryOdds[34].code">
                                        <input type="hidden" value="${command['尾合'].betCode}" name="lotteryOdds[34].betCode">
                                        <input type="hidden" value="${command['尾合'].siteId}" name="lotteryOdds[34].siteId">
                                        <input type="hidden" value="${command['尾合'].betNum}" name="lotteryOdds[34].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾合'].oddLimit}" data-limit="${command['尾合'].oddLimit}" data-value="${command['尾合'].odd}" name="lotteryOdds[34].odd" value="${command['尾合'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>尾大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾大'].id}" name="lotteryOdds[35].id">
                                        <input type="hidden" value="${command['尾大'].code}" name="lotteryOdds[35].code">
                                        <input type="hidden" value="${command['尾大'].betCode}" name="lotteryOdds[35].betCode">
                                        <input type="hidden" value="${command['尾大'].siteId}" name="lotteryOdds[35].siteId">
                                        <input type="hidden" value="${command['尾大'].betNum}" name="lotteryOdds[35].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾大'].oddLimit}" data-limit="${command['尾大'].oddLimit}" data-value="${command['尾大'].odd}" name="lotteryOdds[35].odd" value="${command['尾大'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>尾小</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾小'].id}" name="lotteryOdds[36].id">
                                        <input type="hidden" value="${command['尾小'].code}" name="lotteryOdds[36].code">
                                        <input type="hidden" value="${command['尾小'].betCode}" name="lotteryOdds[36].betCode">
                                        <input type="hidden" value="${command['尾小'].siteId}" name="lotteryOdds[36].siteId">
                                        <input type="hidden" value="${command['尾小'].betNum}" name="lotteryOdds[36].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾小'].oddLimit}" data-limit="${command['尾小'].oddLimit}" data-value="${command['尾小'].odd}" name="lotteryOdds[36].odd" value="${command['尾小'].odd}">
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