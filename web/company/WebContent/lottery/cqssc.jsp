<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.manager.lottery.vo.SiteLotteryOddsVo"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

<form:form method="post" id="edidOddForm">
    <div class="widthAuto">
        <div class="shell-top" id="shell_top">
            <div class="shell-top-left"></div>
            <div class="shell-title-icon">
                <span id="shell_title">賠率設置 [<span class="blue">總監:zj01</span>]</span>
            </div>
            <div class="shell-top-right"></div>
            <div id="title-nav" class="title-nav-right">
                <select name="search.code" id="lotteryCode">
                    <c:forEach items="${command.siteLotteryList}" var="p">
                        <option value="${p.code}">${p.name}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="shell-middle-left">
            <div class="shell-middle-right">
                <div class="shell-middle" id="middleContent">
                    <div id="setodds-gameIndex-3" class="acion" style="display: block;">
                        <table class="middle-table">
                            <thead>
                            <tr>
                                <th>重慶時時彩</th>
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
                                            <c:forEach items="${command.oddsMap}" var="map">
                                                <tr sort="1" class="betSortTr">
                                                    <input hidden name="betSort" value="${map.value.betSort}"/>
                                                    <td class="bc sw120">${map.key}</td>
                                                    <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="oddA" value="${map.value.oddA}"></td>
                                                    <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddB" value="${map.value.oddB}"></td>
                                                    <td><input type="text" autocomplete="off" exts="" class="text-input sw70" name="oddC" value="${map.value.oddC}"></td>
                                                    <td><input type="text" autocomplete="off" ext=""  class="text-input sw70" name="maxOdd" value="${map.value.maxOdd}"></td>
                                                    <td><input type="checkbox" name="ddd"></td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="float:right;width:49.9%">

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
                                <td style="padding-top:15px;"><span class="text-btn" id="submit">保存設置</span><span
                                        class="text-btn" id="reset">重置選項</span></td>
                            </tr>
                            </tfoot>
                        </table>
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
<soul:import res="site/lottery/cqssc"/>

<!--//region your codes 3-->
<!--//endregion your codes 3-->