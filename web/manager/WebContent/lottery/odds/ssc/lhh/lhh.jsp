<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div id="editable_wrapper" class="dataTables_wrapper" role="grid">
    <div class="panel-body">
        <div class="tab-content">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover dataTable m-b-none text-center"
                       aria-describedby="editable_info">
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
                        <th><span>龙</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['龙'].id}" name="lotteryOdds[0].id">
                                <input type="hidden" value="${command['龙'].code}" name="lotteryOdds[0].code">
                                <input type="hidden" value="${command['龙'].betCode}" name="lotteryOdds[0].betCode">
                                <input type="hidden" value="${command['龙'].siteId}" name="lotteryOdds[0].siteId">
                                <input type="hidden" value="${command['龙'].betNum}" name="lotteryOdds[0].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['龙'].oddLimit}" data-limit="${command['龙'].oddLimit}" data-value="${command['龙'].odd}" name="lotteryOdds[0].odd" value="${command['龙'].odd}">
                            </div>
                        </td>
                        <th><span>虎</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['虎'].id}" name="lotteryOdds[1].id">
                                <input type="hidden" value="${command['虎'].code}" name="lotteryOdds[1].code">
                                <input type="hidden" value="${command['虎'].betCode}" name="lotteryOdds[1].betCode">
                                <input type="hidden" value="${command['虎'].siteId}" name="lotteryOdds[1].siteId">
                                <input type="hidden" value="${command['虎'].betNum}" name="lotteryOdds[1].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['虎'].oddLimit}" data-limit="${command['虎'].oddLimit}" data-value="${command['虎'].odd}" name="lotteryOdds[1].odd"value="${command['虎'].odd}">
                            </div>
                        </td>
                        <th><span>和</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['和'].id}" name="lotteryOdds[2].id">
                                <input type="hidden" value="${command['和'].code}" name="lotteryOdds[2].code">
                                <input type="hidden" value="${command['和'].betCode}" name="lotteryOdds[2].betCode">
                                <input type="hidden" value="${command['和'].siteId}" name="lotteryOdds[2].siteId">
                                <input type="hidden" value="${command['和'].betNum}" name="lotteryOdds[2].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['和'].oddLimit}" data-limit="${command['和'].oddLimit}" data-value="${command['和'].odd}" name="lotteryOdds[2].odd"value="${command['和'].odd}">
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>