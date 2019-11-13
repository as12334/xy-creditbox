<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.lottery.vo.SiteLotteryOddsVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

    <div class="shell-middle-left">
        <div class="shell-middle-right">
            <div class="shell-middle" id="middleContent">
                <div id="setodds-gameIndex-3" class="acion" style="display: block;">
                    <table class="middle-table">
                        <thead>
                        <tr>

                            <th>${views.page["LotteryCode.".concat(command.search.code)]}</th>
                        </tr>
                        </thead>
                    </table>
                    <table border="0" cellpadding="0" cellspacing="0" width="100%" id="">
                        <thead>
                        <tr>
                            <td>
                                <div style="float:left;width:49.9%">
                                    <table class="middle-table bor-top">
                                        <thead>
                                        <tr>
                                            <th class="sw120">交易類型</th>
                                            <th>A盤賠率</th>
                                            <th>B盤差分</th>
                                            <th>C盤差分</th>
                                            <th>最高賠率</th>
                                            <th>選項</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:set var="ind"><fmt:formatNumber value="${(command.oddsMap.size()/2) + ((command.oddsMap.size()%2)>0?1:0)}" maxFractionDigits="0"></fmt:formatNumber></c:set>
                                        <c:forEach items="${command.oddsMap}" var="map" begin="0" end="${ind - 1}">
                                            <tr sort="1" class="betSortTr">

                                                <td class="bc sw120">${map.key}
                                                    <input hidden name="betSort" value="${map.value.betSort}"/>
                                                </td>
                                                <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="oddA" value="${map.value.oddA}"></td>
                                                <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddB" value="${map.value.oddB}"></td>
                                                <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddC" value="${map.value.oddC}"></td>
                                                <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="maxOdd" value="${map.value.maxOdd}"></td>
                                                <td><input type="checkbox" /></td>
                                            </tr>
                                        </c:forEach>



                                        </tbody>
                                    </table>
                                </div>
                                <div style="float:right;width:49.9%">
                                    <table class="middle-table bor-top">
                                        <thead>
                                        <tr>
                                            <th class="sw120">交易類型</th>
                                            <th>A盤賠率</th>
                                            <th>B盤差分</th>
                                            <th>C盤差分</th>
                                            <th>最高賠率</th>
                                            <th>選項</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${command.oddsMap}" var="map" begin="${ind}" end="${command.oddsMap.size()}">
                                            <tr sort="1" class="betSortTr">

                                                <td class="bc sw120">${map.key}
                                                    <input hidden name="betSort" value="${map.value.betSort}"/>
                                                </td>
                                                <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="oddA" value="${map.value.oddA}"></td>
                                                <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddB" value="${map.value.oddB}"></td>
                                                <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddC" value="${map.value.oddC}"></td>
                                                <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="maxOdd" value="${map.value.maxOdd}"></td>
                                                <td><input type="checkbox" /></td>
                                            </tr>
                                        </c:forEach>


                                        </tbody>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        </thead>
                    </table>
                    <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                        <tfoot>
                        <tr>
                            <td style="padding-top:10px;" id="od-set">
                                <div style="display:inline-block;margin-right:20px;color:red" class="odds-kj">
                                    快升：<span>+0.01</span><span>+0.05</span><span>+0.1</span><span>+0.5</span><span>+1</span><span>+1.5</span><span>+2</span><span>+2.5</span>
                                </div>
                                <div style="display:inline-block;color:red" class="odds-kj">
                                    快降：<span>-0.01</span><span>-0.05</span><span>-0.1</span><span>-0.5</span><span>-1</span><span>-1.5</span><span>-2</span><span>-2.5</span>
                                </div>
                                <div style="padding-top:10px;"><label class="label-box"><input type="checkbox"
                                                                                               name="od-a">A盤賠率</label>
                                    <label class="label-box"><input type="checkbox" name="od-b">B盤差分</label> <label
                                            class="label-box"><input type="checkbox" name="od-c">C盤差分</label> <label
                                            class="label-box"><input type="checkbox" name="od-max">最高賠率</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding-top:15px;">
                                    <%--<span class="text-btn" id="submit">保存設置</span>--%>
                                <soul:button cssClass="text-btn" target="saveLotterysOdd" text="保存設置" opType="function"></soul:button>
                                <soul:button cssClass="text-btn" target="resetOption" text="重置選項" opType="function"></soul:button>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
<%--<%@ include file="/include/include.js.jsp" %>--%>
<%--<soul:import res="site/lottery/OddEdit"/>--%>

<!--//region your codes 3-->
<!--//endregion your codes 3-->