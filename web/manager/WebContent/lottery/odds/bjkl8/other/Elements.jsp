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
                        <tr>
                            <th>金</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['金'].id}" name="lotteryOdds[10].id">
                                    <input type="hidden" value="${command['金'].code}" name="lotteryOdds[10].code">
                                    <input type="hidden" value="${command['金'].betCode}" name="lotteryOdds[10].betCode">
                                    <input type="hidden" value="${command['金'].siteId}" name="lotteryOdds[10].siteId">
                                    <input type="hidden" value="${command['金'].betNum}" name="lotteryOdds[10].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['金'].oddLimit}" data-limit="${command['金'].oddLimit}" data-value="${command['金'].odd}" name="lotteryOdds[10].odd" value="${command['金'].odd}">
                                </div>
                            </td>
                            <th>木</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <div class="input-group content-width-limit-10">
                                        <input type="hidden" value="${command['木'].id}" name="lotteryOdds[11].id">
                                        <input type="hidden" value="${command['木'].code}" name="lotteryOdds[11].code">
                                        <input type="hidden" value="${command['木'].betCode}" name="lotteryOdds[11].betCode">
                                        <input type="hidden" value="${command['木'].siteId}" name="lotteryOdds[11].siteId">
                                        <input type="hidden" value="${command['木'].betNum}" name="lotteryOdds[11].betNum">
                                        <input type="text" class="form-control input-sm" placeholder="<=${command['木'].oddLimit}" data-limit="${command['木'].oddLimit}" data-value="${command['木'].odd}" name="lotteryOdds[11].odd" value="${command['木'].odd}">
                                    </div>
                                </div>
                            </td>
                            <th>水</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['水'].id}" name="lotteryOdds[12].id">
                                    <input type="hidden" value="${command['水'].code}" name="lotteryOdds[12].code">
                                    <input type="hidden" value="${command['水'].betCode}" name="lotteryOdds[12].betCode">
                                    <input type="hidden" value="${command['水'].siteId}" name="lotteryOdds[12].siteId">
                                    <input type="hidden" value="${command['水'].betNum}" name="lotteryOdds[12].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['水'].oddLimit}" data-limit="${command['水'].oddLimit}" data-value="${command['水'].odd}" name="lotteryOdds[12].odd" value="${command['水'].odd}">
                                </div>
                            </td>
                            <th>火</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['火'].id}" name="lotteryOdds[13].id">
                                    <input type="hidden" value="${command['火'].code}" name="lotteryOdds[13].code">
                                    <input type="hidden" value="${command['火'].betCode}" name="lotteryOdds[13].betCode">
                                    <input type="hidden" value="${command['火'].siteId}" name="lotteryOdds[13].siteId">
                                    <input type="hidden" value="${command['火'].betNum}" name="lotteryOdds[13].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['火'].oddLimit}" data-limit="${command['火'].oddLimit}" data-value="${command['火'].odd}" name="lotteryOdds[13].odd" value="${command['火'].odd}">
                                </div>
                            </td>
                            <th>土</th>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${command['土'].id}" name="lotteryOdds[14].id">
                                    <input type="hidden" value="${command['土'].code}" name="lotteryOdds[14].code">
                                    <input type="hidden" value="${command['土'].betCode}" name="lotteryOdds[14].betCode">
                                    <input type="hidden" value="${command['土'].siteId}" name="lotteryOdds[14].siteId">
                                    <input type="hidden" value="${command['土'].betNum}" name="lotteryOdds[14].betNum">
                                    <input type="text" class="form-control input-sm" placeholder="<=${command['土'].oddLimit}" data-limit="${command['土'].oddLimit}" data-value="${command['土'].odd}" name="lotteryOdds[14].odd" value="${command['土'].odd}">
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>