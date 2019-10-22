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

                    <tr>
                        <c:set value="0" var="lotteryIndex"/>
                        <th><span>二肖</span></th>
                        <c:forEach items="${command.lhc_two_zodiac}" var="p" >
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
                        <th><span>三肖</span></th>
                        <c:forEach items="${command.lhc_three_zodiac}" var="p" >
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
                        <th><span>四肖</span></th>
                        <c:forEach items="${command.lhc_four_zodiac}" var="p" >
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
                        <th><span>五肖</span></th>
                        <c:forEach items="${command.lhc_five_zodiac}" var="p" >
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
                        <th><span>六肖</span></th>
                        <c:forEach items="${command.lhc_six_zodiac}" var="p" >
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
                    <tr>
                        <th><span>七肖</span></th>
                        <c:forEach items="${command.lhc_seven_zodiac}" var="p" >
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
                        <th><span>八肖</span></th>
                        <c:forEach items="${command.lhc_eight_zodiac}" var="p" >
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
                        <th><span>九肖</span></th>
                        <c:forEach items="${command.lhc_nine_zodiac}" var="p" >
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
                        <th><span>十肖</span></th>
                        <c:forEach items="${command.lhc_ten_zodiac}" var="p" >
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
                        <th><span>十一肖</span></th>
                        <c:forEach items="${command.lhc_eleven_zodiac}" var="p" >
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
