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
                        <th>当前奖金</th>
                        <th>返点比例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th><span>定位胆</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['定位胆'].id}" name="lotteryOdds[68].id">
                                <input type="hidden" value="${command['定位胆'].code}" name="lotteryOdds[68].code">
                                <input type="hidden" value="${command['定位胆'].betCode}" name="lotteryOdds[68].betCode">
                                <input type="hidden" value="${command['定位胆'].siteId}" name="lotteryOdds[68].siteId">
                                <input type="hidden" value="${command['定位胆'].betNum}" name="lotteryOdds[68].betNum">
                                <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[${lotteryIndex}].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${command['定位胆'].oddLimit}" data-limit="${command['定位胆'].oddLimit}" data-value="${command['定位胆'].odd}" name="lotteryOdds[68].odd" value="${command['定位胆'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['定位胆'].rebateLimit}" data-limit="${command['定位胆'].rebateLimit}" data-value="${command['定位胆'].rebate}" name="lotteryOdds[68].rebate" value="${command['定位胆'].rebate}">
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
