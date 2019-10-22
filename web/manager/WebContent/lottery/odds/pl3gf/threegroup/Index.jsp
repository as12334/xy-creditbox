<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div  id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="panel-body">
        <div class="tab-content">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover dataTable m-b-none text-center" aria-describedby="editable_info">
                    <thead>
                    <tr class="bg-gray">
                        <th>号码</th>
                        <th>当前奖金</th>
                        <th>返点比例</th>
                        <th>号码</th>
                        <th>当前奖金</th>
                        <th>返点比例</th>
                        <th>号码</th>
                        <th>当前奖金</th>
                        <th>返点比例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th><span>三星组三复式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zuxuan_z3fs}"/>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${odd[0].id}" name="lotteryOdds[1].id">
                                    <input type="hidden" value="${odd[0].code}" name="lotteryOdds[1].code">
                                    <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[1].betCode">
                                    <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[1].siteId">
                                    <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[1].betNum">
                                    <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[1].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[1].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[1].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                                </div>
                            </td>
                        <th><span>三星组三单式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zuxuan_z3ds}"/>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd[0].id}" name="lotteryOdds[2].id">
                                <input type="hidden" value="${odd[0].code}" name="lotteryOdds[2].code">
                                <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[2].betCode">
                                <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[2].siteId">
                                <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[2].betNum">
                                <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[2].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[2].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[2].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                            </div>
                        </td>
                        <th><span>三星组六复式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zuxuan_z6fs}"/>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd[0].id}" name="lotteryOdds[3].id">
                                <input type="hidden" value="${odd[0].code}" name="lotteryOdds[3].code">
                                <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[3].betCode">
                                <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[3].siteId">
                                <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[3].betNum">
                                <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[3].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[3].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[3].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <c:forEach items="${command.pl3_sanxing_zuxuan_hhzx}" var="p" >
                            <c:if test="${p.betNum eq '组三'}">
                                <th><span>三星混合组选(组三)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[5].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[5].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[5].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[5].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[5}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[5].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[5].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input id="sameRebate" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[5].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>

                        <c:forEach items="${command.pl3_sanxing_zuxuan_zxhz}" var="p" >
                            <c:if test="${p.betNum eq '组三'}">
                                <th><span>三星组选和值(组三)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[7].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[7].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[7].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[7].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[7].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[7].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[7].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input id="sameRebate1" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[7].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>

                        <th><span>三星组六单式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zuxuan_z6ds}"/>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd[0].id}" name="lotteryOdds[4].id">
                                <input type="hidden" value="${odd[0].code}" name="lotteryOdds[4].code">
                                <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[4].betCode">
                                <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[4].siteId">
                                <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[4].betNum">
                                <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[4].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[4].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[4].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <c:forEach items="${command.pl3_sanxing_zuxuan_hhzx}" var="p" >
                            <c:if test="${p.betNum eq '组六'}">
                                <th><span>三星混合组选(组六)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[6].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[6].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[6].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[6].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[6].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[6].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[6].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[6].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>

                        <c:forEach items="${command.pl3_sanxing_zuxuan_zxhz}" var="p" >
                            <c:if test="${p.betNum eq '组六'}">
                                <th><span>三星组选和值(组六)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[8].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[8].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[8].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[8].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[8].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[8].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[8].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[8].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

