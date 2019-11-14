<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.lottery.vo.SiteLotteryRebatesVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

<form:form method="post" id="edidRebateForm">
    <lb:validateRule></lb:validateRule>
    <div class="widthAuto">
        <div class="shell-top" id="shell_top">
            <div class="shell-top-left"></div>
            <div class="shell-title-icon">
                <span id="shell_title">退水盤 [<span class="blue">總監:zj01</span>]</span>
            </div>
            <div class="shell-top-right"></div>
        </div>
        <div class="shell-middle-left">
            <div class="shell-middle-right">
                <div class="shell-middle" id="middleContent">
                    <div id="load-middle" class="acion" style="display: block;">
                        <div id="load-userrebate-game-kc">
                            <table class="t_list" style="margin-bottom:3px">
                                <tbody class="list_hover">
                                <tr class="tractive">
                                    <td width="130">退水微調</td>
                                    <td width="150"><em class="addBtns"></em><i class="minBtns"></i><input type="text"
                                                                                                           value="0.1"
                                                                                                           id="kc_plwt"
                                                                                                           class="text zk plNumber w80">
                                    </td>
                                    <td style="text-align:left;padding-left:5px;">在這裏對全局退水進行統壹微調</td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="t_list">
                                <tbody>
                                <tr>
                                    <th colspan="8">大項快速設置【<b class="red">註意：設置高於上級最高限制時按最高可調</b>】</th>
                                </tr>
                                <tr>
                                    <td class="tdbg1">調整項目</td>
                                    <td class="tdbg1" style="">A盤</td>
                                    <td class="tdbg1" style="">B盤</td>
                                    <td class="tdbg1" style="">C盤</td>
                                    <td class="tdbg1">單注限額</td>
                                    <td class="tdbg1">單期限額</td>
                                    <td class="tdbg1">最小單注</td>
                                    <td class="tdbg1">操作</td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>特碼類(第一球、第二球、冠軍 …)</td>
                                    <td style=""><label class="lBg1"></label><input type="text" name="tm_pk_a" id="tm_pk_a" data-a="" class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="tm_pk_b" id="tm_pk_b" data-b="" class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="tm_pk_c" data-c="" id="tm_pk_c" class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="tm_max_amount" data-e="" id="tm_max_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="tm_phase_amount" data-f="" id="tm_phase_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="tm_single_min_amount" data-d="" id="tm_single_min_amount" class="text zk onlyNum w80" value="100"></td>
                                    <td><label class="lBg1"></label> <button type="button" name="btnTM" id="btnTM" data-sid="d" class="btn btntb btnBS">修改</button> </td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>兩面類(單雙、大小、龍虎 …)</td>
                                    <td style=""><label class="lBg2"></label><input type="text" name="lmp_pk_a" id="lmp_pk_a" data-a="" class="text zk plNumber w80"  value="100"></td>
                                    <td style=""><input type="text" name="lmp_pk_b" id="lmp_pk_b" data-b="" class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="lmp_pk_c" data-c="" id="lmp_pk_c" class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="lmp_max_amount" data-e="" id="lmp_max_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lmp_phase_amount" data-f="" id="lmp_phase_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lmp_single_min_amount" data-d="" id="lmp_single_min_amount" class="text zk onlyNum w80" value="100"></td>
                                    <td><label class="lBg2"></label> <button type="button" name="btnLMP" id="btnLMP" data-sid="lmp" class="btn btntb btnBS">修改</button> </td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>連碼類(任選二、任選三 …)</td>
                                    <td style=""><label class="lBg3"></label><input type="text" name="lm_pk_a" id="lm_pk_a" data-a="" class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="lm_pk_b" id="lm_pk_b" data-b="" class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="lm_pk_c" data-c="" id="lm_pk_c" class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="lm_max_amount" data-e="" id="lm_max_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lm_phase_amount" data-f="" id="lm_phase_amount" class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lm_single_min_amount" data-d="" id="lm_single_min_amount" class="text zk onlyNum w80" value="100"></td>
                                    <td><label class="lBg3"></label> <button type="button" name="btnLM" id="btnLM" data-sid="lm" class="btn btntb btnBS">修改</button> </td>
                                </tr>
                                </tbody>
                            </table>

                            <table border="0" cellpadding="0" cellspacing="0" width="100%" name="data-content">
                                <thead>
                                <tr>
                                    <td>
                                        <c:forEach var="map" items="${command.rebatesMap}">
                                            <div data-close="0" data-index="klc" class="acion">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th>${views.page["LotteryCode.".concat(map.key)]}</th>
                                                    </tr>
                                                    </thead>
                                                </table>
                                                <div style="float:left;width:49.9%">
                                                    <table class="middle-table bor-top">
                                                        <tbody>
                                                        <tr class="bc">
                                                            <td class="w15">類型</td>
                                                            <td>單註最低</td>
                                                            <td>單註最高</td>
                                                            <td>單項最高</td>
                                                            <td>A盤</td>
                                                            <td>B盤</td>
                                                            <td>C盤</td>
                                                        </tr>
                                                        <c:set var="ind"><fmt:formatNumber value="${(map.value.size()/2) + ((map.value.size()%2)>0?1:0)}"></fmt:formatNumber></c:set>
                                                        <c:forEach var="map1" items="${map.value}" begin="0" end="${ind - 1}" varStatus="i">
                                                            <tr data-sid="${map1.value.sortType}" data-sort="1" class="betSortTr">
                                                                <td class="bc">
                                                                    <label class="lBg1"></label>${map1.key}
                                                                    <input hidden name="code" value="${map1.value.code}"/>
                                                                    <input hidden name="betSort" value="${map1.value.betSort}"/>
                                                                </td>
                                                                <td><input type="text" data-d="" name="minBet[${i.index}]" class="text-input sw70" data-number="" maxlength="3" data-maxvalue="100" data-minvalue="0" data-sort="1" value="${map1.value.minBet}"></td>
                                                                <td><input type="text" data-e="" name="maxBet[${i.index}]" class="text-input sw70" data-number="" maxlength="7" data-maxvalue="500000" data-minvalue="0" data-sort="1" value="${map1.value.maxBet}"></td>
                                                                <td><input type="text" data-f="" name="maxExpectBet[${i.index}]" class="text-input sw70" data-number="" maxlength="7" data-maxvalue="500000" data-minvalue="0" data-sort="1" value="${map1.value.maxExpectBet}"></td>
                                                                <td><input type="text" data-a="" name="rebateA[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="102" data-minvalue="0" data-sort="1" value="${map1.value.rebateA}"></td>
                                                                <td><input type="text" data-b="" name="rebateB[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="0" data-minvalue="0" data-sort="1" value="${map1.value.rebateB}"></td>
                                                                <td><input type="text" data-c="" name="rebateC[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="102" data-minvalue="0" data-sort="1" value="${map1.value.rebateC}"></td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <div class="clear"></div>
                                                </div>
                                                <div style="float:right;width:49.9%">
                                                    <table class="middle-table bor-top">
                                                        <tbody>
                                                        <tr class="bc">
                                                            <td class="w15">類型</td>
                                                            <td>單註最低</td>
                                                            <td>單註最高</td>
                                                            <td>單項最高</td>
                                                            <td>A盤</td>
                                                            <td>B盤</td>
                                                            <td>C盤</td>
                                                        </tr>
                                                        <c:set var="ind"><fmt:formatNumber value="${(map.value.size()/2) + ((map.value.size()%2)>0?1:0)}"></fmt:formatNumber></c:set>
                                                        <c:forEach var="map1" items="${map.value}" begin="${ind}" end="${map.value.size()}">
                                                            <tr data-sid="${map1.value.sortType}" data-sort="1" class="betSortTr">
                                                                <td class="bc">
                                                                    <label class="lBg1"></label>${map1.key}
                                                                    <input hidden name="code" value="${map1.value.code}"/>
                                                                    <input hidden name="betSort" value="${map1.value.betSort}"/>
                                                                </td>
                                                                <td><input type="text" data-d="" name="minBet[${i.index}]" class="text-input sw70" data-number="" maxlength="3" data-maxvalue="100" data-minvalue="0" data-sort="1" value="${map1.value.minBet}"></td>
                                                                <td><input type="text" data-e="" name="maxBet[${i.index}]" class="text-input sw70" data-number="" maxlength="7" data-maxvalue="500000" data-minvalue="0" data-sort="1" value="${map1.value.maxBet}"></td>
                                                                <td><input type="text" data-f="" name="maxExpectBet[${i.index}]" class="text-input sw70" data-number="" maxlength="7" data-maxvalue="500000" data-minvalue="0" data-sort="1" value="${map1.value.maxExpectBet}"></td>
                                                                <td><input type="text" data-a="" name="rebateA[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="102" data-minvalue="0" data-sort="1" value="${map1.value.rebateA}"></td>
                                                                <td><input type="text" data-b="" name="rebateB[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="0" data-minvalue="0" data-sort="1" value="${map1.value.rebateB}"></td>
                                                                <td><input type="text" data-c="" name="rebateC[${i.index}]" class="text-input sw50" data-numbertodouble="" maxlength="5" data-maxvalue="102" data-minvalue="0" data-sort="1" value="${map1.value.rebateC}"></td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </td>
                                </tr>
                                </thead>
                            </table>
                            <table class="middle-table" id="kj">
                                <tfoot>
                                <tr>
                                    <td colspan="6" style="height:30px;">
                                        <span class="text-btn" id="submit">
                                            <soul:button target="saveLotteryRebate" text="保存設置" opType="function"></soul:button>
                                        </span>

                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="shell-bottom">
            <div class="shell-bottom-left"></div>
            <div class="shell-bottom-right"></div>
            <div class="shell-bottom-content" id="shell_pageControl"></div>
        </div>
    </div>
</form:form>
<%--<%@ include file="/include/include.js.jsp" %>--%>
<soul:import res="site/lottery/rebate/EditRebates"/>

<!--//region your codes 3-->
<!--//endregion your codes 3-->