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
                        <th>当前返点</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>当前返点</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>当前返点</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>当前返点</th>
                        <th>号码</th>
                        <th>当前赔率</th>
                        <th>当前返点</th>

                    </tr>
                    </thead>
                    <tbody>

                    <%@include file="../include/DigistA.jsp"%>
                    <input type="hidden" value="" id="lhca" >
                    <tr>
                        <th>大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['大'].id}" name="lotteryOdds[59].id">
                                <input type="hidden" value="${command['大'].code}" name="lotteryOdds[59].code">
                                <input type="hidden" value="${command['大'].betCode}" name="lotteryOdds[59].betCode">
                                <input type="hidden" value="${command['大'].siteId}" name="lotteryOdds[59].siteId">
                                <input type="hidden" value="${command['大'].betNum}" name="lotteryOdds[59].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['大'].oddLimit}" data-limit="${command['大'].oddLimit}" data-value="${command['大'].odd}" name="lotteryOdds[59].odd" value="${command['大'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['大'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['大'].rebateLimit}" data-value="${command['大'].rebate}" value="${command['大'].rebate}">
                            </div>
                        </td>
                        <th>小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['小'].id}" name="lotteryOdds[50].id">
                                <input type="hidden" value="${command['小'].code}" name="lotteryOdds[50].code">
                                <input type="hidden" value="${command['小'].betCode}" name="lotteryOdds[50].betCode">
                                <input type="hidden" value="${command['小'].siteId}" name="lotteryOdds[50].siteId">
                                <input type="hidden" value="${command['小'].betNum}" name="lotteryOdds[50].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['小'].oddLimit}" data-limit="${command['小'].oddLimit}" data-value="${command['小'].odd}" name="lotteryOdds[50].odd" value="${command['小'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['小'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['小'].rebateLimit}" data-value="${command['小'].rebate}" value="${command['小'].rebate}">
                            </div>
                        </td>
                        <th>单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['单'].id}" name="lotteryOdds[51].id">
                                <input type="hidden" value="${command['单'].code}" name="lotteryOdds[51].code">
                                <input type="hidden" value="${command['单'].betCode}" name="lotteryOdds[51].betCode">
                                <input type="hidden" value="${command['单'].siteId}" name="lotteryOdds[51].siteId">
                                <input type="hidden" value="${command['单'].betNum}" name="lotteryOdds[51].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['单'].oddLimit}" data-limit="${command['单'].oddLimit}" data-value="${command['单'].odd}" name="lotteryOdds[51].odd" value="${command['单'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['单'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['单'].rebateLimit}" data-value="${command['单'].rebate}" value="${command['单'].rebate}">
                            </div>
                        </td>
                        <th>双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['双'].id}" name="lotteryOdds[52].id">
                                <input type="hidden" value="${command['双'].code}" name="lotteryOdds[52].code">
                                <input type="hidden" value="${command['双'].betCode}" name="lotteryOdds[52].betCode">
                                <input type="hidden" value="${command['双'].siteId}" name="lotteryOdds[52].siteId">
                                <input type="hidden" value="${command['双'].betNum}" name="lotteryOdds[52].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['双'].oddLimit}" data-limit="${command['双'].oddLimit}" data-value="${command['双'].odd}" name="lotteryOdds[52].odd" value="${command['双'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['双'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['双'].rebateLimit}" data-value="${command['双'].rebate}" value="${command['双'].rebate}">
                            </div>
                        </td>
                        <th colspan="2"></th>
                    </tr>
                    <tr>
                        <th>合大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['合大'].id}" name="lotteryOdds[53].id">
                                <input type="hidden" value="${command['合大'].code}" name="lotteryOdds[53].code">
                                <input type="hidden" value="${command['合大'].betCode}" name="lotteryOdds[53].betCode">
                                <input type="hidden" value="${command['合大'].siteId}" name="lotteryOdds[53].siteId">
                                <input type="hidden" value="${command['合大'].betNum}" name="lotteryOdds[53].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['合大'].oddLimit}" data-limit="${command['合大'].oddLimit}" data-value="${command['合大'].odd}" name="lotteryOdds[53].odd" value="${command['合大'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['合大'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['合大'].rebateLimit}" data-value="${command['合大'].rebate}" value="${command['合大'].rebate}">
                            </div>
                        </td>
                        <th>合小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['合小'].id}" name="lotteryOdds[54].id">
                                <input type="hidden" value="${command['合小'].code}" name="lotteryOdds[54].code">
                                <input type="hidden" value="${command['合小'].betCode}" name="lotteryOdds[54].betCode">
                                <input type="hidden" value="${command['合小'].siteId}" name="lotteryOdds[54].siteId">
                                <input type="hidden" value="${command['合小'].betNum}" name="lotteryOdds[54].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['合小'].oddLimit}" data-limit="${command['合小'].oddLimit}" data-value="${command['合小'].odd}" name="lotteryOdds[54].odd" value="${command['合小'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['合小'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['合小'].rebateLimit}" data-value="${command['合小'].rebate}" value="${command['合小'].rebate}">
                            </div>
                        </td>
                        <th>合单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['合单'].id}" name="lotteryOdds[55].id">
                                <input type="hidden" value="${command['合单'].code}" name="lotteryOdds[55].code">
                                <input type="hidden" value="${command['合单'].betCode}" name="lotteryOdds[55].betCode">
                                <input type="hidden" value="${command['合单'].siteId}" name="lotteryOdds[55].siteId">
                                <input type="hidden" value="${command['合单'].betNum}" name="lotteryOdds[55].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['合单'].oddLimit}" data-limit="${command['合单'].oddLimit}" data-value="${command['合单'].odd}" name="lotteryOdds[55].odd" value="${command['合单'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['合单'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['合单'].rebateLimit}" data-value="${command['合单'].rebate}" value="${command['合单'].rebate}">
                            </div>
                        </td>
                        <th>合双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['合双'].id}" name="lotteryOdds[56].id">
                                <input type="hidden" value="${command['合双'].code}" name="lotteryOdds[56].code">
                                <input type="hidden" value="${command['合双'].betCode}" name="lotteryOdds[56].betCode">
                                <input type="hidden" value="${command['合双'].siteId}" name="lotteryOdds[56].siteId">
                                <input type="hidden" value="${command['合双'].betNum}" name="lotteryOdds[56].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['合双'].oddLimit}" data-limit="${command['合双'].oddLimit}" data-value="${command['合双'].odd}" name="lotteryOdds[56].odd" value="${command['合双'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['合双'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['合双'].rebateLimit}" data-value="${command['合双'].rebate}" value="${command['合双'].rebate}">
                            </div>
                        </td>
                        <th colspan="2"></th>
                    </tr>
                    <tr>
                        <th>尾大</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['尾大'].id}" name="lotteryOdds[57].id">
                                <input type="hidden" value="${command['尾大'].code}" name="lotteryOdds[57].code">
                                <input type="hidden" value="${command['尾大'].betCode}" name="lotteryOdds[57].betCode">
                                <input type="hidden" value="${command['尾大'].siteId}" name="lotteryOdds[57].siteId">
                                <input type="hidden" value="${command['尾大'].betNum}" name="lotteryOdds[57].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['尾大'].oddLimit}" data-limit="${command['尾大'].oddLimit}" data-value="${command['尾大'].odd}" name="lotteryOdds[57].odd" value="${command['尾大'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['尾大'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['尾大'].rebateLimit}" data-value="${command['尾大'].rebate}" value="${command['尾大'].rebate}">
                            </div>
                        </td>
                        <th>尾小</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['尾小'].id}" name="lotteryOdds[58].id">
                                <input type="hidden" value="${command['尾小'].code}" name="lotteryOdds[58].code">
                                <input type="hidden" value="${command['尾小'].betCode}" name="lotteryOdds[58].betCode">
                                <input type="hidden" value="${command['尾小'].siteId}" name="lotteryOdds[58].siteId">
                                <input type="hidden" value="${command['尾小'].betNum}" name="lotteryOdds[58].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['尾小'].oddLimit}" data-limit="${command['尾小'].oddLimit}" data-value="${command['尾小'].odd}" name="lotteryOdds[58].odd" value="${command['尾小'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['尾小'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['尾小'].rebateLimit}" data-value="${command['尾小'].rebate}" value="${command['尾小'].rebate}">
                            </div>
                        </td>
                        <th colspan="6"></th>
                    </tr>
                    <tr>
                        <th>红波</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['红波'].id}" name="lotteryOdds[61].id">
                                <input type="hidden" value="${command['红波'].code}" name="lotteryOdds[61].code">
                                <input type="hidden" value="${command['红波'].betCode}" name="lotteryOdds[61].betCode">
                                <input type="hidden" value="${command['红波'].siteId}" name="lotteryOdds[61].siteId">
                                <input type="hidden" value="${command['红波'].betNum}" name="lotteryOdds[61].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['红波'].oddLimit}" data-limit="${command['红波'].oddLimit}" data-value="${command['红波'].odd}" name="lotteryOdds[61].odd" value="${command['红波'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['红波'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['红波'].rebateLimit}" data-value="${command['红波'].rebate}" value="${command['红波'].rebate}">
                            </div>
                        </td>
                        <th>蓝波</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['蓝波'].id}" name="lotteryOdds[62].id">
                                <input type="hidden" value="${command['蓝波'].code}" name="lotteryOdds[62].code">
                                <input type="hidden" value="${command['蓝波'].betCode}" name="lotteryOdds[62].betCode">
                                <input type="hidden" value="${command['蓝波'].siteId}" name="lotteryOdds[62].siteId">
                                <input type="hidden" value="${command['蓝波'].betNum}" name="lotteryOdds[62].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['蓝波'].oddLimit}" data-limit="${command['蓝波'].oddLimit}" data-value="${command['蓝波'].odd}" name="lotteryOdds[62].odd" value="${command['蓝波'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['蓝波'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['蓝波'].rebateLimit}" data-value="${command['蓝波'].rebate}" value="${command['蓝波'].rebate}">
                            </div>
                        </td>
                        <th>绿波</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['绿波'].id}" name="lotteryOdds[63].id">
                                <input type="hidden" value="${command['绿波'].code}" name="lotteryOdds[63].code">
                                <input type="hidden" value="${command['绿波'].betCode}" name="lotteryOdds[63].betCode">
                                <input type="hidden" value="${command['绿波'].siteId}" name="lotteryOdds[63].siteId">
                                <input type="hidden" value="${command['绿波'].betNum}" name="lotteryOdds[63].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['绿波'].oddLimit}" data-limit="${command['绿波'].oddLimit}" data-value="${command['绿波'].odd}" name="lotteryOdds[63].odd" value="${command['绿波'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['绿波'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['绿波'].rebateLimit}" data-value="${command['绿波'].rebate}" value="${command['绿波'].rebate}">
                            </div>
                        </td>
                        <th colspan="4"></th>
                    </tr>


                    <tr>
                        <th>大单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['大单'].id}" name="lotteryOdds[64].id">
                                <input type="hidden" value="${command['大单'].code}" name="lotteryOdds[64].code">
                                <input type="hidden" value="${command['大单'].betCode}" name="lotteryOdds[64].betCode">
                                <input type="hidden" value="${command['大单'].siteId}" name="lotteryOdds[64].siteId">
                                <input type="hidden" value="${command['大单'].betNum}" name="lotteryOdds[64].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['大单'].oddLimit}" data-limit="${command['大单'].oddLimit}" data-value="${command['大单'].odd}" name="lotteryOdds[64].odd" value="${command['大单'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['大单'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['大单'].rebateLimit}" data-value="${command['大单'].rebate}" value="${command['大单'].rebate}">
                            </div>
                        </td>
                        <th>小单</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['小单'].id}" name="lotteryOdds[65].id">
                                <input type="hidden" value="${command['小单'].code}" name="lotteryOdds[65].code">
                                <input type="hidden" value="${command['小单'].betCode}" name="lotteryOdds[65].betCode">
                                <input type="hidden" value="${command['小单'].siteId}" name="lotteryOdds[65].siteId">
                                <input type="hidden" value="${command['小单'].betNum}" name="lotteryOdds[65].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['小单'].oddLimit}" data-limit="${command['小单'].oddLimit}" data-value="${command['小单'].odd}" name="lotteryOdds[65].odd" value="${command['小单'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['小单'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['小单'].rebateLimit}" data-value="${command['小单'].rebate}" value="${command['小单'].rebate}">
                            </div>
                        </td>
                        <th>大双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['大双'].id}" name="lotteryOdds[66].id">
                                <input type="hidden" value="${command['大双'].code}" name="lotteryOdds[66].code">
                                <input type="hidden" value="${command['大双'].betCode}" name="lotteryOdds[66].betCode">
                                <input type="hidden" value="${command['大双'].siteId}" name="lotteryOdds[66].siteId">
                                <input type="hidden" value="${command['大双'].betNum}" name="lotteryOdds[66].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['大双'].oddLimit}" data-limit="${command['大双'].oddLimit}" data-value="${command['大双'].odd}" name="lotteryOdds[66].odd" value="${command['大双'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['大双'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['大双'].rebateLimit}" data-value="${command['大双'].rebate}" value="${command['大双'].rebate}">
                            </div>
                        </td>
                        <th>小双</th>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="hidden" value="${command['小双'].id}" name="lotteryOdds[67].id">
                                <input type="hidden" value="${command['小双'].code}" name="lotteryOdds[67].code">
                                <input type="hidden" value="${command['小双'].betCode}" name="lotteryOdds[67].betCode">
                                <input type="hidden" value="${command['小双'].siteId}" name="lotteryOdds[67].siteId">
                                <input type="hidden" value="${command['小双'].betNum}" name="lotteryOdds[67].betNum">
                                <input type="text" class="form-control input-sm" placeholder="<=${command['小双'].oddLimit}" data-limit="${command['小双'].oddLimit}" data-value="${command['小双'].odd}" name="lotteryOdds[67].odd" value="${command['小双'].odd}">
                            </div>
                        </td>
                        <td>
                            <div class="input-group content-width-limit-10">
                                <input type="text" class="form-control input-sm rebate" placeholder="<=${command['小双'].rebateLimit}" name="lotteryOdds[59].rebate" data-limit="${command['小双'].rebateLimit}" data-value="${command['小双'].rebate}" value="${command['小双'].rebate}">
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>