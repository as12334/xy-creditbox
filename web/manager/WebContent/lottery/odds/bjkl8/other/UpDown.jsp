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
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>上</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['上'].id}" name="lotteryOdds[10].id">
                                    <input type="hidden" value="${command['上'].code}" name="lotteryOdds[10].code">
                                    <input type="hidden" value="${command['上'].betCode}" name="lotteryOdds[10].betCode">
                                    <input type="hidden" value="${command['上'].siteId}" name="lotteryOdds[10].siteId">
                                    <input type="hidden" value="${command['上'].betNum}" name="lotteryOdds[10].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['上'].oddLimit}" data-limit="${command['上'].oddLimit}" data-value="${command['上'].odd}" name="lotteryOdds[10].odd" value="${command['上'].odd}">
                                </div>
                            </td>
                            <th>中</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['中'].id}" name="lotteryOdds[11].id">
                                        <input type="hidden" value="${command['中'].code}" name="lotteryOdds[11].code">
                                        <input type="hidden" value="${command['中'].betCode}" name="lotteryOdds[11].betCode">
                                        <input type="hidden" value="${command['中'].siteId}" name="lotteryOdds[11].siteId">
                                        <input type="hidden" value="${command['中'].betNum}" name="lotteryOdds[11].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['中'].oddLimit}" data-limit="${command['中'].oddLimit}" data-value="${command['中'].odd}" name="lotteryOdds[11].odd" value="${command['中'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>下</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['下'].id}" name="lotteryOdds[12].id">
                                    <input type="hidden" value="${command['下'].code}" name="lotteryOdds[12].code">
                                    <input type="hidden" value="${command['下'].betCode}" name="lotteryOdds[12].betCode">
                                    <input type="hidden" value="${command['下'].siteId}" name="lotteryOdds[12].siteId">
                                    <input type="hidden" value="${command['下'].betNum}" name="lotteryOdds[12].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['下'].oddLimit}" data-limit="${command['下'].oddLimit}" data-value="${command['下'].odd}" name="lotteryOdds[12].odd" value="${command['下'].odd}">
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>