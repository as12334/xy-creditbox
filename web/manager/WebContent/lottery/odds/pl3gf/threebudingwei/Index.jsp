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
                        <th><span>三星一码不定位</span></th>
                        <c:set var="odd" value="${command['1']}"/>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${odd.id}" name="lotteryOdds[1].id">
                                    <input type="hidden" value="${odd.code}" name="lotteryOdds[1].code">
                                    <input type="hidden" value="${odd.betCode}" name="lotteryOdds[1].betCode">
                                    <input type="hidden" value="${odd.siteId}" name="lotteryOdds[1].siteId">
                                    <input type="hidden" value="${odd.betNum}" name="lotteryOdds[1].betNum">
                                    <input type="hidden" value="${odd.baseNum}" name="lotteryOdds[1].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd.oddLimit}" name="lotteryOdds[1].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd.rebateLimit}" name="lotteryOdds[1].rebate" data-limit="${odd.rebateLimit}" data-value="${odd.rebate}" value="${odd.rebate}">
                                </div>
                            </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

