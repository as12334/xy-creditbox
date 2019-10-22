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
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <th>选四-中4</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['选四-中4'].id}" name="lotteryOdds[49].id">
                                <input type="hidden" value="${command['选四-中4'].code}" name="lotteryOdds[49].code">
                                <input type="hidden" value="${command['选四-中4'].betCode}" name="lotteryOdds[49].betCode">
                                <input type="hidden" value="${command['选四-中4'].siteId}" name="lotteryOdds[49].siteId">
                                <input type="hidden" value="${command['选四-中4'].betNum}" name="lotteryOdds[49].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['选四-中4'].oddLimit}" data-limit="${command['选四-中4'].oddLimit}" data-value="${command['选四-中4'].odd}" name="lotteryOdds[49].odd" value="${command['选四-中4'].odd}">
                            </div>
                        </td>
                        <th>选四-中3</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['选四-中3'].id}" name="lotteryOdds[50].id">
                                <input type="hidden" value="${command['选四-中3'].code}" name="lotteryOdds[50].code">
                                <input type="hidden" value="${command['选四-中3'].betCode}" name="lotteryOdds[50].betCode">
                                <input type="hidden" value="${command['选四-中3'].siteId}" name="lotteryOdds[50].siteId">
                                <input type="hidden" value="${command['选四-中3'].betNum}" name="lotteryOdds[50].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['选四-中3'].oddLimit}" data-limit="${command['选四-中3'].oddLimit}" data-value="${command['选四-中3'].odd}" name="lotteryOdds[50].odd" value="${command['选四-中3'].odd}">
                            </div>
                        </td>
                        <th>选四-中2</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['选四-中2'].id}" name="lotteryOdds[51].id">
                                <input type="hidden" value="${command['选四-中2'].code}" name="lotteryOdds[51].code">
                                <input type="hidden" value="${command['选四-中2'].betCode}" name="lotteryOdds[51].betCode">
                                <input type="hidden" value="${command['选四-中2'].siteId}" name="lotteryOdds[51].siteId">
                                <input type="hidden" value="${command['选四-中2'].betNum}" name="lotteryOdds[51].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['选四-中2'].oddLimit}" data-limit="${command['选四-中2'].oddLimit}" data-value="${command['选四-中2'].odd}" name="lotteryOdds[51].odd" value="${command['选四-中2'].odd}">
                            </div>
                        </td>

                    </tr>
                   

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>