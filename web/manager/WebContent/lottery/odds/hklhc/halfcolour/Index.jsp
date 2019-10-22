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
                        <th>红大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['红大'].id}" name="lotteryOdds[68].id">
                                <input type="hidden" value="${command['红大'].code}" name="lotteryOdds[68].code">
                                <input type="hidden" value="${command['红大'].betCode}" name="lotteryOdds[68].betCode">
                                <input type="hidden" value="${command['红大'].siteId}" name="lotteryOdds[68].siteId">
                                <input type="hidden" value="${command['红大'].betNum}" name="lotteryOdds[68].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['红大'].oddLimit}" data-limit="${command['红大'].oddLimit}" data-value="${command['红大'].odd}" name="lotteryOdds[68].odd" value="${command['红大'].odd}">
                            </div>
                        </td>
                        <th>红小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['红小'].id}" name="lotteryOdds[69].id">
                                <input type="hidden" value="${command['红小'].code}" name="lotteryOdds[69].code">
                                <input type="hidden" value="${command['红小'].betCode}" name="lotteryOdds[69].betCode">
                                <input type="hidden" value="${command['红小'].siteId}" name="lotteryOdds[69].siteId">
                                <input type="hidden" value="${command['红小'].betNum}" name="lotteryOdds[69].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['红小'].oddLimit}" data-limit="${command['红小'].oddLimit}" data-value="${command['红小'].odd}" name="lotteryOdds[69].odd" value="${command['红小'].odd}">
                            </div>
                        </td>
                        <th>红双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['红双'].id}" name="lotteryOdds[70].id">
                                <input type="hidden" value="${command['红双'].code}" name="lotteryOdds[70].code">
                                <input type="hidden" value="${command['红双'].betCode}" name="lotteryOdds[70].betCode">
                                <input type="hidden" value="${command['红双'].siteId}" name="lotteryOdds[70].siteId">
                                <input type="hidden" value="${command['红双'].betNum}" name="lotteryOdds[70].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['红双'].oddLimit}" data-limit="${command['红双'].oddLimit}" data-value="${command['红双'].odd}" name="lotteryOdds[70].odd" value="${command['红双'].odd}">
                            </div>
                        </td>
                        <th>红单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['红单'].id}" name="lotteryOdds[71].id">
                                <input type="hidden" value="${command['红单'].code}" name="lotteryOdds[71].code">
                                <input type="hidden" value="${command['红单'].betCode}" name="lotteryOdds[71].betCode">
                                <input type="hidden" value="${command['红单'].siteId}" name="lotteryOdds[71].siteId">
                                <input type="hidden" value="${command['红单'].betNum}" name="lotteryOdds[71].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['红单'].oddLimit}" data-limit="${command['红单'].oddLimit}" data-value="${command['红单'].odd}" name="lotteryOdds[71].odd" value="${command['红单'].odd}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>绿大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['绿大'].id}" name="lotteryOdds[72].id">
                                <input type="hidden" value="${command['绿大'].code}" name="lotteryOdds[72].code">
                                <input type="hidden" value="${command['绿大'].betCode}" name="lotteryOdds[72].betCode">
                                <input type="hidden" value="${command['绿大'].siteId}" name="lotteryOdds[72].siteId">
                                <input type="hidden" value="${command['绿大'].betNum}" name="lotteryOdds[72].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['绿大'].oddLimit}" data-limit="${command['绿大'].oddLimit}" data-value="${command['绿大'].odd}" name="lotteryOdds[72].odd" value="${command['绿大'].odd}">
                            </div>
                        </td>
                        <th>绿小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['绿小'].id}" name="lotteryOdds[73].id">
                                <input type="hidden" value="${command['绿小'].code}" name="lotteryOdds[73].code">
                                <input type="hidden" value="${command['绿小'].betCode}" name="lotteryOdds[73].betCode">
                                <input type="hidden" value="${command['绿小'].siteId}" name="lotteryOdds[73].siteId">
                                <input type="hidden" value="${command['绿小'].betNum}" name="lotteryOdds[73].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['绿小'].oddLimit}" data-limit="${command['绿小'].oddLimit}" data-value="${command['绿小'].odd}" name="lotteryOdds[73].odd" value="${command['绿小'].odd}">
                            </div>
                        </td>
                        <th>绿双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['绿双'].id}" name="lotteryOdds[74].id">
                                <input type="hidden" value="${command['绿双'].code}" name="lotteryOdds[74].code">
                                <input type="hidden" value="${command['绿双'].betCode}" name="lotteryOdds[74].betCode">
                                <input type="hidden" value="${command['绿双'].siteId}" name="lotteryOdds[74].siteId">
                                <input type="hidden" value="${command['绿双'].betNum}" name="lotteryOdds[74].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['绿双'].oddLimit}" data-limit="${command['绿双'].oddLimit}" data-value="${command['绿双'].odd}" name="lotteryOdds[74].odd" value="${command['绿双'].odd}">
                            </div>
                        </td>
                        <th>绿单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['绿单'].id}" name="lotteryOdds[75].id">
                                <input type="hidden" value="${command['绿单'].code}" name="lotteryOdds[75].code">
                                <input type="hidden" value="${command['绿单'].betCode}" name="lotteryOdds[75].betCode">
                                <input type="hidden" value="${command['绿单'].siteId}" name="lotteryOdds[75].siteId">
                                <input type="hidden" value="${command['绿单'].betNum}" name="lotteryOdds[75].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['绿单'].oddLimit}" data-limit="${command['绿单'].oddLimit}" data-value="${command['绿单'].odd}" name="lotteryOdds[75].odd" value="${command['绿单'].odd}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>蓝大</th>lan
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蓝大'].id}" name="lotteryOdds[76].id">
                                <input type="hidden" value="${command['蓝大'].code}" name="lotteryOdds[76].code">
                                <input type="hidden" value="${command['蓝大'].betCode}" name="lotteryOdds[76].betCode">
                                <input type="hidden" value="${command['蓝大'].siteId}" name="lotteryOdds[76].siteId">
                                <input type="hidden" value="${command['蓝大'].betNum}" name="lotteryOdds[76].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蓝大'].oddLimit}" data-limit="${command['蓝大'].oddLimit}" data-value="${command['蓝大'].odd}" name="lotteryOdds[76].odd" value="${command['蓝大'].odd}">
                            </div>
                        </td>
                        <th>蓝小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蓝小'].id}" name="lotteryOdds[77].id">
                                <input type="hidden" value="${command['蓝小'].code}" name="lotteryOdds[77].code">
                                <input type="hidden" value="${command['蓝小'].betCode}" name="lotteryOdds[77].betCode">
                                <input type="hidden" value="${command['蓝小'].siteId}" name="lotteryOdds[77].siteId">
                                <input type="hidden" value="${command['蓝小'].betNum}" name="lotteryOdds[77].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蓝小'].oddLimit}" data-limit="${command['蓝小'].oddLimit}" data-value="${command['蓝小'].odd}" name="lotteryOdds[77].odd" value="${command['蓝小'].odd}">
                            </div>
                        </td>
                        <th>蓝双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蓝双'].id}" name="lotteryOdds[78].id">
                                <input type="hidden" value="${command['蓝双'].code}" name="lotteryOdds[78].code">
                                <input type="hidden" value="${command['蓝双'].betCode}" name="lotteryOdds[78].betCode">
                                <input type="hidden" value="${command['蓝双'].siteId}" name="lotteryOdds[78].siteId">
                                <input type="hidden" value="${command['蓝双'].betNum}" name="lotteryOdds[78].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蓝双'].oddLimit}" data-limit="${command['蓝双'].oddLimit}" data-value="${command['蓝双'].odd}" name="lotteryOdds[78].odd" value="${command['蓝双'].odd}">
                            </div>
                        </td>
                        <th>蓝单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蓝单'].id}" name="lotteryOdds[79].id">
                                <input type="hidden" value="${command['蓝单'].code}" name="lotteryOdds[79].code">
                                <input type="hidden" value="${command['蓝单'].betCode}" name="lotteryOdds[79].betCode">
                                <input type="hidden" value="${command['蓝单'].siteId}" name="lotteryOdds[79].siteId">
                                <input type="hidden" value="${command['蓝单'].betNum}" name="lotteryOdds[79].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蓝单'].oddLimit}" data-limit="${command['蓝单'].oddLimit}" data-value="${command['蓝单'].odd}" name="lotteryOdds[79].odd" value="${command['蓝单'].odd}">
                            </div>
                        </td>

                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>