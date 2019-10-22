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
                    <c:forEach begin="5" end="10" var="i">
                        <c:if test="${i%5==0}">
                            <tr>
                        </c:if>
                        <c:set var="num" value="${i.toString()}"/>
                        <c:set var="odd" value="${command[num]}"/>
                        <th><span>${i}个号码</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[${i-5}].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[${i-5}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[${i-5}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[${i-5}].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[${i-5}].betNum">
                                <input type="text" class="form-control input-sm" name="lotteryOdds[${i-5}].odd" placeholder="<=${odd.oddLimit}" data-limit="${command[num].oddLimit}" data-value="${command[num].odd}" value="${command[num].odd}">
                            </div>
                        </td>
                        <c:if test="${i%5==4}">
                            </tr>
                        </c:if>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>