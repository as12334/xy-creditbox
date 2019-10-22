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
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="len" value="1"/>
                    <c:forEach var="i" begin="1" end="5">
                        <c:forEach var="j" begin="${i+1}" end="6">
                            <c:if test="${len%4==1}">
                                <tr>
                            </c:if>
                            <th><em class="gr gr-dice-${i} fs1"></em><em class="gr gr-dice-${j} fs1"></em></th>
                            <td>
                                <c:set var="num" value="${i}${j}"/>
                                <div class="input-group content-width-limit-10">
                                    <c:set var="odd" value="${command[num]}"/>
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[0].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[0].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[0].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[0].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[0].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" data-limit="${odd.oddLimit}" data-value="${odd.odd}" name="lotteryOdds[0].odd" value="${odd.odd}">
                                </div>
                            </td>
                            <c:if test="${len%4==0}">
                                </tr>
                            </c:if>
                            <c:set var="len" value="${len+1}"/>
                        </c:forEach>
                    </c:forEach>
                    <th></th>
                    <td> </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>