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
                        <th><span>3</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['3']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[0].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[0}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[0}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[0].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[0].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[0].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>4</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['4']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[1].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[1}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[1}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[1].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[1].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[1].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>5</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['5']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[2].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[2}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[2}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[2].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[2].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[2].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>6</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['6']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[3].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[3}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[3}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[3].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[3].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[3].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>7</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['7']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[4].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[4}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[4}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[4].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[4].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[4].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <th><span>8</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['8']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[5].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[5}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[5}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[5].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[5].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[5].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>9</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['9']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[6].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[6}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[6}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[6].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[6].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[6].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>10</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['10']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[7].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[7}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[7}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[7].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[7].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[7].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>11</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['11']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[8].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[8}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[8}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[8].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[8].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[8].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>12</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['12']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[9].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[9}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[9}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[9].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[9].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[9].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <th><span>13</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['13']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[10].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[10}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[10}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[10].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[10].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[10].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>14</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['14']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[11].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[11}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[11}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[11].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[11].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[11].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>15</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['15']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[12].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[12}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[12}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[12].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[12].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[12].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>16</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['16']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[13].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[13}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[13}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[13].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[13].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[13].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>17</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['17']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[14].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[14}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[14}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[14].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[14].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[14].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <th><span>18</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['18']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[15].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[15}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[15}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[15].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[15].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[15].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>19</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['19']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[16].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[16}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[16}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[16].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[16].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[16].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span></span></th>
                        <td></td>

                        <th><span></span></th>
                        <td></td>

                        <th></th>
                        <td></td>

                    </tr>

                    <tr>
                        <th><span>和大</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['和大']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[17].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[17}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[17}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[17].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[17].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[17].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>和小</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['和小']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[18].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[18}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[18}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[18].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[18].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[18].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>和单</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['和单']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[19].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[19}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[19}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[19].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[19].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[19].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th><span>和双</span></th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <c:set var="odd" value="${command['和双']}"/>
                                <input type="hidden" value="${odd.id}" name="lotteryOdds[20].id">
                                <input type="hidden" value="${odd.code}" name="lotteryOdds[20}].code">
                                <input type="hidden" value="${odd.betCode}" name="lotteryOdds[20}].betCode">
                                <input type="hidden" value="${odd.siteId}" name="lotteryOdds[20].siteId">
                                <input type="hidden" value="${odd.betNum}" name="lotteryOdds[20].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${odd.oddLimit}" name="lotteryOdds[20].odd" data-limit="${odd.oddLimit}" data-value="${odd.odd}" value="${odd.odd}">
                            </div>
                        </td>

                        <th></th>
                        <td></td>

                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>