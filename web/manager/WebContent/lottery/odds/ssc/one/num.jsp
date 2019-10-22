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
                        <th>A赔率</th>
                        <th>B赔率</th>
                        <th>C赔率</th>
                        <th>号码</th>
                        <th>A赔率</th>
                        <th>B赔率</th>
                        <th>C赔率</th>
                        <th>号码</th>
                        <th>A赔率</th>
                        <th>B赔率</th>
                        <th>C赔率</th>
                        <th>号码</th>
                        <th>A赔率</th>
                        <th>B赔率</th>
                        <th>C赔率</th>
                        <th>号码</th>
                        <th>A赔率</th>
                        <th>B赔率</th>
                        <th>C赔率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach begin="0" end="9" var="i">
                        <c:if test="${i%5==0}">
                            <tr>
                        </c:if>
                        <th><span>${i}</span></th>
                        <td>
                            <div class="input-group content-width-limit-5">
                                <c:set var="odd" value="${command[i.toString()]}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i}].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.maxOdd}" name="lotteryOdds[${i}].oddA" data-limit="${odd.maxOdd}" data-value="${odd.oddA}" value="${odd.oddA}">
                            </div>
                        </td>

                        <td>
                            <div class="input-group content-width-limit-5">
                                <input type="text" class="form-control input-sm"  name="lotteryOdds[${i}].oddB"  data-value="${odd.oddB}" value="${odd.oddB}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-5">
                                <input type="text" class="form-control input-sm" name="lotteryOdds[${i}].oddC"  data-value="${odd.oddC}" value="${odd.oddC}">
                            </div>
                        </td>

                        <c:if test="${i%5==4}">
                            </tr>
                        </c:if>
                    </c:forEach>
                    <c:if test="${command['大'].id !=null}">
                        <tr>
                            <th>大</th>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="hidden" value="${command['大'].id}" name="lotteryOdds[10].id">
                                    <input type="hidden" value="${command['大'].code}" name="lotteryOdds[10].code">
                                    <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[10].betCode">
                                    <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[10].siteId">
                                    <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[10].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['大'].maxOdd}" data-limit="${command['大'].maxOdd}" data-value="${command['大'].oddA}" name="lotteryOdds[10].oddA" value="${command['大'].oddA}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['大'].oddB}" name="lotteryOdds[10].oddB" value="${command['大'].oddB}">

                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['大'].oddC}" name="lotteryOdds[10].oddC" value="${command['大'].oddC}">

                                </div>
                            </td>
                            <th>小</th>
                            <td>
                                    <div class="input-group content-width-limit-5">
                                        <input type="hidden" value="${command['小'].id}" name="lotteryOdds[11].id">
                                        <input type="hidden" value="${command['小'].code}" name="lotteryOdds[11].code">
                                        <input type="hidden" value="${command['小'].betCode}" name="lotteryOdds[11].betCode">
                                        <input type="hidden" value="${command['小'].siteId}" name="lotteryOdds[11].siteId">
                                        <input type="hidden" value="${command['小'].betNum}" name="lotteryOdds[11].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['小'].maxOdd}" data-limit="${command['小'].maxOdd}" data-value="${command['小'].oddA}" name="lotteryOdds[11].oddA" value="${command['小'].oddA}">
                                    </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"   data-value="${command['小'].oddB}" name="lotteryOdds[11].oddB" value="${command['小'].oddB}">


                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"   data-value="${command['小'].oddC}" name="lotteryOdds[11].oddC" value="${command['小'].oddC}">

                                </div>
                            </td>
                            <th>单</th>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="hidden" value="${command['单'].id}" name="lotteryOdds[12].id">
                                    <input type="hidden" value="${command['单'].code}" name="lotteryOdds[12].code">
                                    <input type="hidden" value="${command['单'].betCode}" name="lotteryOdds[12].betCode">
                                    <input type="hidden" value="${command['单'].siteId}" name="lotteryOdds[12].siteId">
                                    <input type="hidden" value="${command['单'].betNum}" name="lotteryOdds[12].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['单'].maxOdd}" data-limit="${command['单'].maxOdd}" data-value="${command['单'].oddA}" name="lotteryOdds[12].oddA" value="${command['单'].oddA}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['单'].oddB}" name="lotteryOdds[12].oddB" value="${command['单'].oddB}">

                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['单'].oddC}" name="lotteryOdds[12].oddC" value="${command['单'].oddC}">

                                </div>
                            </td>
                            <th>双</th>
                            <td>
                                    <div class="input-group content-width-limit-5">
                                        <input type="hidden" value="${command['双'].id}" name="lotteryOdds[13].id">
                                        <input type="hidden" value="${command['双'].code}" name="lotteryOdds[13].code">
                                        <input type="hidden" value="${command['双'].betCode}" name="lotteryOdds[13].betCode">
                                        <input type="hidden" value="${command['双'].siteId}" name="lotteryOdds[13].siteId">
                                        <input type="hidden" value="${command['双'].betNum}" name="lotteryOdds[13].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['双'].maxOdd}" data-limit="${command['双'].maxOdd}" data-value="${command['双'].oddA}" name="lotteryOdds[13].oddA" value="${command['双'].oddA}">
                                    </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['双'].oddB}" name="lotteryOdds[13].oddB" value="${command['双'].oddB}">

                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['双'].oddC}" name="lotteryOdds[13].oddC" value="${command['双'].oddC}">

                                </div>
                            </td>
                            <th>质</th>
                            <td>
                                    <div class="input-group content-width-limit-5">
                                        <input type="hidden" value="${command['质'].id}" name="lotteryOdds[14].id">
                                        <input type="hidden" value="${command['质'].code}" name="lotteryOdds[14].code">
                                        <input type="hidden" value="${command['质'].betCode}" name="lotteryOdds[14].betCode">
                                        <input type="hidden" value="${command['质'].siteId}" name="lotteryOdds[14].siteId">
                                        <input type="hidden" value="${command['质'].betNum}" name="lotteryOdds[14].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['质'].maxOdd}" data-limit="${command['质'].maxOdd}" data-value="${command['质'].oddA}" name="lotteryOdds[14].oddA" value="${command['质'].oddA}">
                                    </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['质'].oddB}" name="lotteryOdds[14].oddB" value="${command['质'].oddB}">

                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['质'].oddC}" name="lotteryOdds[14].oddC" value="${command['质'].oddC}">

                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>合</th>
                            <td>
                                    <div class="input-group content-width-limit-5">
                                        <input type="hidden" value="${command['合'].id}" name="lotteryOdds[15].id">
                                        <input type="hidden" value="${command['合'].code}" name="lotteryOdds[15].code">
                                        <input type="hidden" value="${command['合'].betCode}" name="lotteryOdds[15].betCode">
                                        <input type="hidden" value="${command['合'].siteId}" name="lotteryOdds[15].siteId">
                                        <input type="hidden" value="${command['合'].betNum}" name="lotteryOdds[15].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['合'].maxOdd}" data-limit="${command['合'].maxOdd}" data-value="${command['合'].oddA}" name="lotteryOdds[15].oddA" value="${command['合'].oddA}">
                                    </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['合'].oddB}" name="lotteryOdds[15].oddB" value="${command['合'].oddB}">

                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-5">
                                    <input type="text" class="form-control input-sm"  data-value="${command['合'].oddC}" name="lotteryOdds[15].oddC" value="${command['合'].oddC}">

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