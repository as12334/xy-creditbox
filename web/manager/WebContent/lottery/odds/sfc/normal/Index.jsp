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
                    <c:forEach begin="1" end="20" var="i">
                        <c:if test="${i%5==1}">
                            <tr>
                        </c:if>
                        <c:set var="num" value="${i.toString()}"/>
                        <c:if test="${i<10}">
                            <c:set var="num" value="0${i}"/>
                        </c:if>
                        <c:set var="odd" value="${command[num]}"/>
                        <th><span>${num}</span></th>
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
                        <c:if test="${i%5==0}">
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:if test="${command['大'].id !=null}">
                        <tr>
                            <th>大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['大'].id}" name="lotteryOdds[20].id">
                                    <input type="hidden" value="${command['大'].code}" name="lotteryOdds[20].code">
                                    <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[20].betCode">
                                    <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[20].siteId">
                                    <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[20].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" name="lotteryOdds[20].odd"  data-limit="${command['大'].oddLimit}" data-value="${command['大'].odd}" value="${command['大'].odd}">
                                </div>
                            </td>
                            <th>小</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['小'].id}" name="lotteryOdds[21].id">
                                        <input type="hidden" value="${command['小'].code}" name="lotteryOdds[21].code">
                                        <input type="hidden" value="${command['小'].betCode}" name="lotteryOdds[21].betCode">
                                        <input type="hidden" value="${command['小'].siteId}" name="lotteryOdds[21].siteId">
                                        <input type="hidden" value="${command['小'].betNum}" name="lotteryOdds[21].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['小'].oddLimit}" name="lotteryOdds[21].odd" data-limit="${command['小'].oddLimit}" data-value="${command['小'].odd}" value="${command['小'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['单'].id}" name="lotteryOdds[22].id">
                                    <input type="hidden" value="${command['单'].code}" name="lotteryOdds[22].code">
                                    <input type="hidden" value="${command['单'].betCode}" name="lotteryOdds[22].betCode">
                                    <input type="hidden" value="${command['单'].siteId}" name="lotteryOdds[22].siteId">
                                    <input type="hidden" value="${command['单'].betNum}" name="lotteryOdds[22].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" name="lotteryOdds[22].odd" data-limit="${command['单'].oddLimit}" data-value="${command['单'].odd}" value="${command['单'].odd}">
                                </div>
                            </td>
                            <th>双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['双'].id}" name="lotteryOdds[23].id">
                                        <input type="hidden" value="${command['双'].code}" name="lotteryOdds[23].code">
                                        <input type="hidden" value="${command['双'].betCode}" name="lotteryOdds[23].betCode">
                                        <input type="hidden" value="${command['双'].siteId}" name="lotteryOdds[23].siteId">
                                        <input type="hidden" value="${command['双'].betNum}" name="lotteryOdds[23].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['双'].oddLimit}" name="lotteryOdds[23].odd" data-limit="${command['双'].oddLimit}" data-value="${command['双'].odd}" value="${command['双'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>尾大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾大'].id}" name="lotteryOdds[24].id">
                                        <input type="hidden" value="${command['尾大'].code}" name="lotteryOdds[24].code">
                                        <input type="hidden" value="${command['尾大'].betCode}" name="lotteryOdds[24].betCode">
                                        <input type="hidden" value="${command['尾大'].siteId}" name="lotteryOdds[24].siteId">
                                        <input type="hidden" value="${command['尾大'].betNum}" name="lotteryOdds[24].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾大'].oddLimit}" name="lotteryOdds[24].odd" data-limit="${command['尾大'].oddLimit}" data-value="${command['尾大'].odd}" value="${command['尾大'].odd}">
                                    </div>
                                </div>
                            </td>

                            <c:if test="${betCode=='champion' || betCode=='runner_up' || betCode=='third_runner'|| betCode=='fourth_place'|| betCode=='fifth_place'}">
                                <th>龙</th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <div class="input-group content-width-limit-10">
                                            <input type="hidden" value="${command['龙'].id}" name="lotteryOdds[14].id">
                                            <input type="hidden" value="${command['龙'].code}" name="lotteryOdds[14].code">
                                            <input type="hidden" value="${command['龙'].betCode}" name="lotteryOdds[14].betCode">
                                            <input type="hidden" value="${command['龙'].siteId}" name="lotteryOdds[14].siteId">
                                            <input type="hidden" value="${command['龙'].betNum}" name="lotteryOdds[14].betNum">
                                            <input type="text" class="form-control input-sm" placeholder="<=${command['龙'].oddLimit}" name="lotteryOdds[14].odd" data-limit="${command['龙'].oddLimit}" data-value="${command['龙'].odd}" value="${command['龙'].odd}">
                                        </div>
                                    </div>
                                </td>
                            </c:if>
                        </tr>
                        <c:if test="${betCode=='champion' || betCode=='runner_up' || betCode=='third_runner'|| betCode=='fourth_place'|| betCode=='fifth_place'}">
                            <tr>
                                <th>虎</th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <div class="input-group content-width-limit-10">
                                            <input type="hidden" value="${command['虎'].id}" name="lotteryOdds[15].id">
                                            <input type="hidden" value="${command['虎'].code}" name="lotteryOdds[15].code">
                                            <input type="hidden" value="${command['虎'].betCode}" name="lotteryOdds[15].betCode">
                                            <input type="hidden" value="${command['虎'].siteId}" name="lotteryOdds[15].siteId">
                                            <input type="hidden" value="${command['虎'].betNum}" name="lotteryOdds[15].betNum">
                                            <input type="text" class="form-control input-sm" placeholder="<=${command['虎'].oddLimit}" name="lotteryOdds[15].odd" data-limit="${command['虎'].oddLimit}" data-value="${command['虎'].odd}" value="${command['虎'].odd}">
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <th>尾小</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['尾小'].id}" name="lotteryOdds[25].id">
                                        <input type="hidden" value="${command['尾小'].code}" name="lotteryOdds[25].code">
                                        <input type="hidden" value="${command['尾小'].betCode}" name="lotteryOdds[25].betCode">
                                        <input type="hidden" value="${command['尾小'].siteId}" name="lotteryOdds[25].siteId">
                                        <input type="hidden" value="${command['尾小'].betNum}" name="lotteryOdds[25].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['尾小'].oddLimit}" name="lotteryOdds[25].odd" data-limit="${command['尾小'].oddLimit}" data-value="${command['尾小'].odd}" value="${command['尾小'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>合单</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['合单'].id}" name="lotteryOdds[26].id">
                                        <input type="hidden" value="${command['合单'].code}" name="lotteryOdds[26].code">
                                        <input type="hidden" value="${command['合单'].betCode}" name="lotteryOdds[26].betCode">
                                        <input type="hidden" value="${command['合单'].siteId}" name="lotteryOdds[26].siteId">
                                        <input type="hidden" value="${command['合单'].betNum}" name="lotteryOdds[26].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['合单'].oddLimit}" name="lotteryOdds[26].odd" data-limit="${command['合单'].oddLimit}" data-value="${command['合单'].odd}" value="${command['合单'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>合双</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['合双'].id}" name="lotteryOdds[27].id">
                                        <input type="hidden" value="${command['合双'].code}" name="lotteryOdds[27].code">
                                        <input type="hidden" value="${command['合双'].betCode}" name="lotteryOdds[27].betCode">
                                        <input type="hidden" value="${command['合双'].siteId}" name="lotteryOdds[27].siteId">
                                        <input type="hidden" value="${command['合双'].betNum}" name="lotteryOdds[27].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['合双'].oddLimit}" name="lotteryOdds[27].odd" data-limit="${command['合双'].oddLimit}" data-value="${command['合双'].odd}" value="${command['合双'].odd}">
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>