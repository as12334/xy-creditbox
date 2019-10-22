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
                    <tr>
                        <th>总大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总大'].id}" name="lotteryOdds[0].id">
                                <input type="hidden" value="${command['总大'].code}" name="lotteryOdds[0].code">
                                <input type="hidden" value="${command['总大'].betCode}" name="lotteryOdds[0].betCode">
                                <input type="hidden" value="${command['总大'].siteId}" name="lotteryOdds[0].siteId">
                                <input type="hidden" value="${command['总大'].betNum}" name="lotteryOdds[0].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总大'].oddLimit}" data-limit="${command['总大'].oddLimit}" data-value="${command['总大'].odd}" name="lotteryOdds[0].odd" value="${command['总大'].odd}">
                            </div>
                        </td>
                        <th>总小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总小'].id}" name="lotteryOdds[1].id">
                                <input type="hidden" value="${command['总小'].code}" name="lotteryOdds[1].code">
                                <input type="hidden" value="${command['总小'].betCode}" name="lotteryOdds[1].betCode">
                                <input type="hidden" value="${command['总小'].siteId}" name="lotteryOdds[1].siteId">
                                <input type="hidden" value="${command['总小'].betNum}" name="lotteryOdds[1].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总小'].oddLimit}" data-limit="${command['总小'].oddLimit}" data-value="${command['总小'].odd}" name="lotteryOdds[1].odd" value="${command['总小'].odd}">
                            </div>
                        </td>
                        <th>总单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总单'].id}" name="lotteryOdds[2].id">
                                <input type="hidden" value="${command['总单'].code}" name="lotteryOdds[2].code">
                                <input type="hidden" value="${command['总单'].betCode}" name="lotteryOdds[2].betCode">
                                <input type="hidden" value="${command['总单'].siteId}" name="lotteryOdds[2].siteId">
                                <input type="hidden" value="${command['总单'].betNum}" name="lotteryOdds[2].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总单'].oddLimit}" data-limit="${command['总单'].oddLimit}" data-value="${command['总单'].odd}" name="lotteryOdds[2].odd" value="${command['总单'].odd}">
                            </div>
                        </td>
                        <th>总双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总双'].id}" name="lotteryOdds[3].id">
                                <input type="hidden" value="${command['总双'].code}" name="lotteryOdds[3].code">
                                <input type="hidden" value="${command['总双'].betCode}" name="lotteryOdds[3].betCode">
                                <input type="hidden" value="${command['总双'].siteId}" name="lotteryOdds[3].siteId">
                                <input type="hidden" value="${command['总双'].betNum}" name="lotteryOdds[3].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总双'].oddLimit}" data-limit="${command['总双'].oddLimit}" data-value="${command['总双'].odd}" name="lotteryOdds[3].odd" value="${command['总双'].odd}">
                            </div>
                        </td>

                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>