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
                        <c:set value="0" var="lotteryIndex"/>
                        <th><span>后三组三复式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hsz3fs}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <th><span>后三组三单式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hsz3ds}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <th><span>后三组六复式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hsz6fs}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                    </tr>
                    <tr>
                        <th><span>后三组六单式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hsz6ds}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hshhzx}" var="p" >
                            <c:if test="${p.betNum eq '组三'}">
                                <th><span>后三组选组合(组三)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input id="sameRebate" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hszxhz}" var="p" >
                                <c:if test="${p.betNum eq '组三'}">
                                    <th><span>后三组选和值(组三)</span></th>
                                    <td>
                                        <div class="input-group content-width-limit-10">
                                            <c:set var="odd" value="${p}"/>
                                            <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                            <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                            <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                            <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                            <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                            <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                            <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                        </div>
                                    </td>
                                    <td>
                                        <div class="input-group content-width-limit-10">
                                            <input id="sameRebate1" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                        </div>
                                    </td>
                                </c:if>
                                <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>

                    </tr>
                    <tr>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hszxbd}" var="p" >
                            <c:if test="${p.betNum eq '组三'}">
                                <th><span>后三组选包胆(组三)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input id="sameRebate2" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>

                        <c:forEach items="${command.ssc_sanxing_zuxuan_hshhzx}" var="p" >
                            <c:if test="${p.betNum eq '组六'}">
                                <th><span>后三组选组合(组六)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>

                        <c:forEach items="${command.ssc_sanxing_zuxuan_hszxhz}" var="p" >
                            <c:if test="${p.betNum eq '组六'}">
                                <th><span>后三组选和值(组六)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                    </tr>
                    <tr>
                        <c:forEach items="${command.ssc_sanxing_zuxuan_hszxbd}" var="p" >
                            <c:if test="${p.betNum eq '组六'}">
                                <th><span>后三组选包胆(组六)</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                        <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
