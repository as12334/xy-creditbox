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
                        <th>号码</th>
                        <th>当前赔率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th>鼠</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['鼠'].id}" name="lotteryOdds[68].id">
                                <input type="hidden" value="${command['鼠'].code}" name="lotteryOdds[68].code">
                                <input type="hidden" value="${command['鼠'].betCode}" name="lotteryOdds[68].betCode">
                                <input type="hidden" value="${command['鼠'].siteId}" name="lotteryOdds[68].siteId">
                                <input type="hidden" value="${command['鼠'].betNum}" name="lotteryOdds[68].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['鼠'].oddLimit}" data-limit="${command['鼠'].oddLimit}" data-value="${command['鼠'].odd}" name="lotteryOdds[68].odd" value="${command['鼠'].odd}">
                            </div>
                        </td>
                        <th>牛</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['牛'].id}" name="lotteryOdds[69].id">
                                <input type="hidden" value="${command['牛'].code}" name="lotteryOdds[69].code">
                                <input type="hidden" value="${command['牛'].betCode}" name="lotteryOdds[69].betCode">
                                <input type="hidden" value="${command['牛'].siteId}" name="lotteryOdds[69].siteId">
                                <input type="hidden" value="${command['牛'].betNum}" name="lotteryOdds[69].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['牛'].oddLimit}" data-limit="${command['牛'].oddLimit}" data-value="${command['牛'].odd}" name="lotteryOdds[69].odd" value="${command['牛'].odd}">
                            </div>
                        </td>
                        <th>虎</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['虎'].id}" name="lotteryOdds[70].id">
                                <input type="hidden" value="${command['虎'].code}" name="lotteryOdds[70].code">
                                <input type="hidden" value="${command['虎'].betCode}" name="lotteryOdds[70].betCode">
                                <input type="hidden" value="${command['虎'].siteId}" name="lotteryOdds[70].siteId">
                                <input type="hidden" value="${command['虎'].betNum}" name="lotteryOdds[70].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['虎'].oddLimit}" data-limit="${command['虎'].oddLimit}" data-value="${command['虎'].odd}" name="lotteryOdds[70].odd" value="${command['虎'].odd}">
                            </div>
                        </td>
                        <th>兔</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['兔'].id}" name="lotteryOdds[71].id">
                                <input type="hidden" value="${command['兔'].code}" name="lotteryOdds[71].code">
                                <input type="hidden" value="${command['兔'].betCode}" name="lotteryOdds[71].betCode">
                                <input type="hidden" value="${command['兔'].siteId}" name="lotteryOdds[71].siteId">
                                <input type="hidden" value="${command['兔'].betNum}" name="lotteryOdds[71].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['兔'].oddLimit}" data-limit="${command['兔'].oddLimit}" data-value="${command['兔'].odd}" name="lotteryOdds[71].odd" value="${command['兔'].odd}">
                            </div>
                        </td>
                        <th>龙</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['龙'].id}" name="lotteryOdds[72].id">
                                <input type="hidden" value="${command['龙'].code}" name="lotteryOdds[72].code">
                                <input type="hidden" value="${command['龙'].betCode}" name="lotteryOdds[72].betCode">
                                <input type="hidden" value="${command['龙'].siteId}" name="lotteryOdds[72].siteId">
                                <input type="hidden" value="${command['龙'].betNum}" name="lotteryOdds[72].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['龙'].oddLimit}" data-limit="${command['龙'].oddLimit}" data-value="${command['龙'].odd}" name="lotteryOdds[72].odd" value="${command['龙'].odd}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>蛇</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蛇'].id}" name="lotteryOdds[73].id">
                                <input type="hidden" value="${command['蛇'].code}" name="lotteryOdds[73].code">
                                <input type="hidden" value="${command['蛇'].betCode}" name="lotteryOdds[73].betCode">
                                <input type="hidden" value="${command['蛇'].siteId}" name="lotteryOdds[73].siteId">
                                <input type="hidden" value="${command['蛇'].betNum}" name="lotteryOdds[73].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蛇'].oddLimit}" data-limit="${command['蛇'].oddLimit}" data-value="${command['蛇'].odd}" name="lotteryOdds[73].odd" value="${command['蛇'].odd}">
                            </div>
                        </td>
                        <th>马</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['马'].id}" name="lotteryOdds[74].id">
                                <input type="hidden" value="${command['马'].code}" name="lotteryOdds[74].code">
                                <input type="hidden" value="${command['马'].betCode}" name="lotteryOdds[74].betCode">
                                <input type="hidden" value="${command['马'].siteId}" name="lotteryOdds[74].siteId">
                                <input type="hidden" value="${command['马'].betNum}" name="lotteryOdds[74].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['马'].oddLimit}" data-limit="${command['马'].oddLimit}" data-value="${command['马'].odd}" name="lotteryOdds[74].odd" value="${command['马'].odd}">
                            </div>
                        </td>
                        <th>羊</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['羊'].id}" name="lotteryOdds[75].id">
                                <input type="hidden" value="${command['羊'].code}" name="lotteryOdds[75].code">
                                <input type="hidden" value="${command['羊'].betCode}" name="lotteryOdds[75].betCode">
                                <input type="hidden" value="${command['羊'].siteId}" name="lotteryOdds[75].siteId">
                                <input type="hidden" value="${command['羊'].betNum}" name="lotteryOdds[75].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['羊'].oddLimit}" data-limit="${command['羊'].oddLimit}" data-value="${command['羊'].odd}" name="lotteryOdds[75].odd" value="${command['羊'].odd}">
                            </div>
                        </td>
                        <th>猴</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['猴'].id}" name="lotteryOdds[76].id">
                                <input type="hidden" value="${command['猴'].code}" name="lotteryOdds[76].code">
                                <input type="hidden" value="${command['猴'].betCode}" name="lotteryOdds[76].betCode">
                                <input type="hidden" value="${command['猴'].siteId}" name="lotteryOdds[76].siteId">
                                <input type="hidden" value="${command['猴'].betNum}" name="lotteryOdds[76].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['猴'].oddLimit}" data-limit="${command['猴'].oddLimit}" data-value="${command['猴'].odd}" name="lotteryOdds[76].odd" value="${command['猴'].odd}">
                            </div>
                        </td>
                        <th>鸡</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['鸡'].id}" name="lotteryOdds[77].id">
                                <input type="hidden" value="${command['鸡'].code}" name="lotteryOdds[77].code">
                                <input type="hidden" value="${command['鸡'].betCode}" name="lotteryOdds[77].betCode">
                                <input type="hidden" value="${command['鸡'].siteId}" name="lotteryOdds[77].siteId">
                                <input type="hidden" value="${command['鸡'].betNum}" name="lotteryOdds[77].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['鸡'].oddLimit}" data-limit="${command['鸡'].oddLimit}" data-value="${command['鸡'].odd}" name="lotteryOdds[77].odd" value="${command['鸡'].odd}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>狗</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['狗'].id}" name="lotteryOdds[78].id">
                                <input type="hidden" value="${command['狗'].code}" name="lotteryOdds[78].code">
                                <input type="hidden" value="${command['狗'].betCode}" name="lotteryOdds[78].betCode">
                                <input type="hidden" value="${command['狗'].siteId}" name="lotteryOdds[78].siteId">
                                <input type="hidden" value="${command['狗'].betNum}" name="lotteryOdds[78].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['狗'].oddLimit}" data-limit="${command['狗'].oddLimit}" data-value="${command['狗'].odd}" name="lotteryOdds[78].odd" value="${command['狗'].odd}">
                            </div>
                        </td>
                        <th>猪</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['猪'].id}" name="lotteryOdds[79].id">
                                <input type="hidden" value="${command['猪'].code}" name="lotteryOdds[79].code">
                                <input type="hidden" value="${command['猪'].betCode}" name="lotteryOdds[79].betCode">
                                <input type="hidden" value="${command['猪'].siteId}" name="lotteryOdds[79].siteId">
                                <input type="hidden" value="${command['猪'].betNum}" name="lotteryOdds[79].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['猪'].oddLimit}" data-limit="${command['猪'].oddLimit}" data-value="${command['猪'].odd}" name="lotteryOdds[79].odd" value="${command['猪'].odd}">
                            </div>
                        </td>

                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
