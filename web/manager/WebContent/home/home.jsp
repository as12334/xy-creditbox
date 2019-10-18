<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<html>
<head>
</head>
<body>
<div class="row">
    <div class="position-wrap clearfix">
        <span>管理首页</span>
    </div>
    <div class="white-bg indicators clearfix  m-l m-r m-b operationsOverview overview shadow">
        <div class="filter-wraper clearfix p-xs">
            <h3 class="pull-left m-r line-hi25">注单近日数据</h3>
            <span class=" line-hi34 m-l-sm co-grayc2">更新时间：<span class="clock-show"></span></span>
            <div id="topData" class="pull-right" style="padding-right: 20px">
                &nbsp;&nbsp;
                <div style="display: none"></div>
            </div>
        </div>
        <div id="stat">
            <div id="chart">
                <div class="dataTables_wrapper table" role="grid">
                    <input hidden id="command" value="${command}">
                    <div id="HomeEcharts">
                    </div>
                    <div class="panel-body">
                        <div class="tab-content">
                            <div class="table-responsive">

                                <table class="table table-striped table-hover dataTable m-b-none" aria-describedby="editable_info">
                                    <thead>
                                    <tr>
                                        <td class="ft-bold"></td>
                                        <td class="ft-bold t-a-c">注单数量</td>
                                        <td class="ft-bold t-a-c">注单金额</td>
                                        <td class="ft-bold t-a-c">派彩金额</td>
                                        <td class="ft-bold t-a-c">利润</td>
                                        <td class="ft-bold t-a-c">差额</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${command}" var="i" varStatus="status" >
                                        <tr>
                                            <td class="t-a-c">${i.nowadays}</td>
                                            <td class="t-a-c">${i.counts}</td>
                                            <td class="t-a-c"> <fmt:formatNumber  value="${i.bet_amount}"  type="currency" /></td>
                                            <td class="t-a-c">
                                                <c:if test="${i.bet_award == null}">
                                                    ￥0.00
                                                </c:if>
                                                <fmt:formatNumber  value="${i.bet_award}"  type="currency" />
                                            </td>
                                            <td class="t-a-c">
                                                <fmt:formatNumber  value="${i.profit}"  type="currency" /></td>
                                            <td class="t-a-c">
                                                <fmt:formatNumber type="number" value="${i.difference*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tbody>
                                    <tr>
                                        <td class="t-a-c">总计</td>
                                        <td class="t-a-c">${countOneWeek['conts']}</td>
                                        <td class="t-a-c"> <fmt:formatNumber  value="${countOneWeek['bet_amount']}"  type="currency" /></td>
                                        <td class="t-a-c">
                                            <c:if test="${countOneWeek['bet_award'] == null}">
                                                ￥0.00
                                            </c:if>
                                            <fmt:formatNumber  value="${countOneWeek['bet_award']}"  type="currency" />
                                        </td>
                                        <td class="t-a-c">
                                            <fmt:formatNumber  value="${countOneWeek['profit']}"  type="currency" /></td>
                                        <td class="t-a-c">
                                            <fmt:formatNumber type="number" value="${countOneWeek['difference']*100}" pattern="0.00" maxFractionDigits="2"/>%</td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
<!--//region your codes 3-->
<soul:import res="site/home/HichartHome"/>
<!--//endregion your codes 3-->
</html>
