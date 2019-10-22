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
                        <th>号码</th>
                        <th>当前奖金</th>
                        <th>返点比例</th>
                        <th>号码</th>
                        <th>当前奖金</th>
                        <th>返点比例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th><span>三星直选复式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zhixuan_fs}"/>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="hidden" value="${odd[0].id}" name="lotteryOdds[1].id">
                                    <input type="hidden" value="${odd[0].code}" name="lotteryOdds[1].code">
                                    <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[1].betCode">
                                    <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[1].siteId">
                                    <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[1].betNum">
                                    <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[1].baseNum">
                                    <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[1].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                                </div>
                            </td>
                            <td>
                                <div class="input-group content-width-limit-10">
                                    <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[1].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                                </div>
                            </td>
                        <th><span>三星直选单式</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zhixuan_ds}"/>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd[0].id}" name="lotteryOdds[2].id">
                                <input type="hidden" value="${odd[0].code}" name="lotteryOdds[2].code">
                                <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[2].betCode">
                                <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[2].siteId">
                                <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[2].betNum">
                                <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[2].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[2].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[2].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                            </div>
                        </td>
                        <th><span>三星直选和值</span></th>
                        <c:set var="odd" value="${command.pl3_sanxing_zhixuan_hz}"/>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${odd[0].id}" name="lotteryOdds[3].id">
                                <input type="hidden" value="${odd[0].code}" name="lotteryOdds[3].code">
                                <input type="hidden" value="${odd[0].betCode}" name="lotteryOdds[3].betCode">
                                <input type="hidden" value="${odd[0].siteId}" name="lotteryOdds[3].siteId">
                                <input type="hidden" value="${odd[0].betNum}" name="lotteryOdds[3].betNum">
                                <input type="hidden" value="${odd[0].baseNum}" name="lotteryOdds[3].baseNum">
                                <input type="text" class="form-control input-sm odd" placeholder="<=${odd[0].oddLimit}" name="lotteryOdds[3].odd" data-limit="${odd[0].oddLimit}" data-value="${odd[0].odd}" value="${odd[0].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${odd[0].rebateLimit}" name="lotteryOdds[3].rebate" data-limit="${odd[0].rebateLimit}" data-value="${odd[0].rebate}" value="${odd[0].rebate}">
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

