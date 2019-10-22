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
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hszh}" var="p" >
                            <c:if test="${p.betNum eq '三星'}">
                                <th><span>后三直选组合(三星)</span></th>
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
                                <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                            </c:if>
                        </c:forEach>
                        <th><span>后三直选复式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hsfs}" var="p">
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
                        <th><span>后三直选和值</span></th>
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hshz}" var="p" >
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
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hszh}" var="p" >
                            <c:if test="${p.betNum eq '二星'}">
                                <th><span>后三直选组合(二星)</span></th>
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
                                    <div>
                                        <input id="sameRebate" type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                                <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                            </c:if>
                        </c:forEach>
                        <th><span>后三直选单式</span></th>
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hsds}" var="p" >
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
                        <th><span>后三直选跨度</span></th>
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hskd}" var="p" >
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
                        <c:forEach items="${command.ssc_sanxing_zhixuan_hszh}" var="p" >
                            <c:if test="${p.betNum eq '一星'}">
                                <th><span>后三直选组合(一星)</span></th>
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
                                    <div>
                                        <input type="hidden" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[${lotteryIndex}].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                    </div>
                                </td>
                                <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                            </c:if>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
