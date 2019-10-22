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
                            <th>奇</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['奇'].id}" name="lotteryOdds[10].id">
                                    <input type="hidden" value="${command['奇'].code}" name="lotteryOdds[10].code">
                                    <input type="hidden" value="${command['奇'].betCode}" name="lotteryOdds[10].betCode">
                                    <input type="hidden" value="${command['奇'].siteId}" name="lotteryOdds[10].siteId">
                                    <input type="hidden" value="${command['奇'].betNum}" name="lotteryOdds[10].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['奇'].oddLimit}" data-limit="${command['奇'].oddLimit}" data-value="${command['奇'].odd}" name="lotteryOdds[10].odd" value="${command['奇'].odd}">
                                </div>
                            </td>
                            <th>和</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['和'].id}" name="lotteryOdds[11].id">
                                        <input type="hidden" value="${command['和'].code}" name="lotteryOdds[11].code">
                                        <input type="hidden" value="${command['和'].betCode}" name="lotteryOdds[11].betCode">
                                        <input type="hidden" value="${command['和'].siteId}" name="lotteryOdds[11].siteId">
                                        <input type="hidden" value="${command['和'].betNum}" name="lotteryOdds[11].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['和'].oddLimit}" data-limit="${command['和'].oddLimit}" data-value="${command['和'].odd}" name="lotteryOdds[11].odd" value="${command['和'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>偶</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['偶'].id}" name="lotteryOdds[12].id">
                                    <input type="hidden" value="${command['偶'].code}" name="lotteryOdds[12].code">
                                    <input type="hidden" value="${command['偶'].betCode}" name="lotteryOdds[12].betCode">
                                    <input type="hidden" value="${command['偶'].siteId}" name="lotteryOdds[12].siteId">
                                    <input type="hidden" value="${command['偶'].betNum}" name="lotteryOdds[12].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['偶'].oddLimit}" data-limit="${command['偶'].oddLimit}" data-value="${command['偶'].odd}" name="lotteryOdds[12].odd" value="${command['偶'].odd}">
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>