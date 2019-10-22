<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div  class="dataTables_wrapper" role="grid">
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:set value="0" var="lotteryIndex"/>
                        <th><span>四全中</span></th>
                        <c:forEach items="${command.lhc_four_all_in}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <th><span>三全中</span></th>
                        <c:forEach items="${command.lhc_three_all_in}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <c:forEach items="${command.lhc_three_in_two}" var="p" >
                            <c:if test="${p.betNum eq '中2'}">
                            <th><span >三中二之中二</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                            </c:if>
                            <c:if test="${p.betNum eq '中3'}">
                                <th><span >三中二之中三</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                    </tr>
                    <tr>
                        <th><span>二全中</span></th>
                        <c:forEach items="${command.lhc_two_all_in}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <c:forEach items="${command.lhc_two_in_special}" var="p" >
                            <c:if test="${p.betNum eq '中2'}">
                                <th><span >二中特之中二</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                            </c:if>
                            <c:if test="${p.betNum eq '中特'}">
                                <th><span >二中特之中特</span></th>
                                <td>
                                    <div class="input-group content-width-limit-10">
                                        <c:set var="odd" value="${p}"/>
                                        <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                        <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                        <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                        <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                        <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                    </div>
                                </td>
                            </c:if>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                        <th><span>特串</span></th>
                        <c:forEach items="${command.lhc_special_strand}" var="p" >
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${p}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[${lotteryIndex}].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[${lotteryIndex}].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${lotteryIndex}].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${lotteryIndex}].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${lotteryIndex}].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[${lotteryIndex}].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <c:set value="${lotteryIndex+1}" var="lotteryIndex"/>
                        </c:forEach>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

