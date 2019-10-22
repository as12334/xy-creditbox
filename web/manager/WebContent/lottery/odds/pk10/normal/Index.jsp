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
                    <c:forEach begin="1" end="10" var="i">
                        <c:if test="${i%5==1}">
                            <tr>
                        </c:if>
                        <c:set var="num" value="${i.toString()}"/>
                        <c:if test="${num.length()==1}">
                            <c:set var="num" value="0${i}" />
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
                        <c:if test="${i%5==0}">
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:if test="${command['大'].id !=null}">
                        <tr>
                            <th>大</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['大'].id}" name="lotteryOdds[10].id">
                                    <input type="hidden" value="${command['大'].code}" name="lotteryOdds[10].code">
                                    <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[10].betCode">
                                    <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[10].siteId">
                                    <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[10].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" name="lotteryOdds[10].odd"  data-limit="${command['大'].oddLimit}" data-value="${command['大'].odd}" value="${command['大'].odd}">
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
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['小'].oddLimit}" name="lotteryOdds[11].odd" data-limit="${command['小'].oddLimit}" data-value="${command['小'].odd}" value="${command['小'].odd}">
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
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" name="lotteryOdds[12].odd" data-limit="${command['单'].oddLimit}" data-value="${command['单'].odd}" value="${command['单'].odd}">
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
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['双'].oddLimit}" name="lotteryOdds[13].odd" data-limit="${command['双'].oddLimit}" data-value="${command['双'].odd}" value="${command['双'].odd}">
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
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>