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
                        <th>总大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总大'].id}" name="lotteryOdds[4].id">
                                <input type="hidden" value="${command['总大'].code}" name="lotteryOdds[4].code">
                                <input type="hidden" value="${command['总大'].betCode}" name="lotteryOdds[4].betCode">
                                <input type="hidden" value="${command['总大'].siteId}" name="lotteryOdds[4].siteId">
                                <input type="hidden" value="${command['总大'].betNum}" name="lotteryOdds[4].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总大'].oddLimit}" data-limit="${command['总大'].oddLimit}" data-value="${command['总大'].odd}" name="lotteryOdds[4].odd" value="${command['总大'].odd}">
                            </div>
                        </td>
                        <th>总小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总小'].id}" name="lotteryOdds[5].id">
                                <input type="hidden" value="${command['总小'].code}" name="lotteryOdds[5].code">
                                <input type="hidden" value="${command['总小'].betCode}" name="lotteryOdds[5].betCode">
                                <input type="hidden" value="${command['总小'].siteId}" name="lotteryOdds[5].siteId">
                                <input type="hidden" value="${command['总小'].betNum}" name="lotteryOdds[5].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总小'].oddLimit}" data-limit="${command['总小'].oddLimit}" data-value="${command['总小'].odd}" name="lotteryOdds[5].odd" value="${command['总小'].odd}">
                            </div>
                        </td>
                        <th>总单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总单'].id}" name="lotteryOdds[6].id">
                                <input type="hidden" value="${command['总单'].code}" name="lotteryOdds[6].code">
                                <input type="hidden" value="${command['总单'].betCode}" name="lotteryOdds[6].betCode">
                                <input type="hidden" value="${command['总单'].siteId}" name="lotteryOdds[6].siteId">
                                <input type="hidden" value="${command['总单'].betNum}" name="lotteryOdds[6].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总单'].oddLimit}" data-limit="${command['总单'].oddLimit}" data-value="${command['总单'].odd}" name="lotteryOdds[6].odd" value="${command['总单'].odd}">
                            </div>
                        </td>
                        <th>总双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['总双'].id}" name="lotteryOdds[7].id">
                                <input type="hidden" value="${command['总双'].code}" name="lotteryOdds[7].code">
                                <input type="hidden" value="${command['总双'].betCode}" name="lotteryOdds[7].betCode">
                                <input type="hidden" value="${command['总双'].siteId}" name="lotteryOdds[7].siteId">
                                <input type="hidden" value="${command['总双'].betNum}" name="lotteryOdds[7].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['总双'].oddLimit}" data-limit="${command['总双'].oddLimit}" data-value="${command['总双'].odd}" name="lotteryOdds[7].odd" value="${command['总双'].odd}">
                            </div>
                        </td>
                        <th colspan="2"></th>
                    </tr>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>