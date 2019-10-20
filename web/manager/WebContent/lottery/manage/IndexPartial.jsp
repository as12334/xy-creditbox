<%--@elvariable id="command" type="so.wwb.gamebox.model.company.lottery.vo.LotteryListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<div class="table-responsive  table-min-h" style="padding-bottom: 95px">
    <table class="table table-condensed table-hover table-striped table-bordered ">
        <thead>
        <tr class="bg-gray">
            <th width="60">${views.column['VSiteApiType.orderNum']}</th>
            <th width="200px">
                <select class="btn-group chosen-select-no-single btn" callback="query" name="search.type">
                    <option value="">全部类型</option>
                    <c:forEach items="${lotteryType}" var="i">
                        <option value="${i.value.code}">${dicts.lottery.lottery_type[i.value.code]}</option>
                    </c:forEach>
                </select>
            </th>
            <th width="200px">
                <select class="btn-group chosen-select-no-single btn" callback="query" name="search.code">
                    <option value="">全部类型</option>
                    <c:forEach items="${command.result}" var="i">
                        <option value="${i.code}">${dicts.lottery.lottery[i.code]}</option>
                    </c:forEach>
                </select>
            </th>
            <th width="200px">彩种状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${command.result}" var="p" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${dicts.lottery.lottery_type[p.type]}(${p.type})</td>
                <td>${dicts.lottery.lottery[p.code]}(${p.code})</td>
                <td>
                    <c:if test="${p.status=='normal'}">
                        <span class="label label-success">正常</span>
                    </c:if>
                    <c:if test="${p.status=='maintain'}">
                        <span class="label label-warning">维护</span>
                    </c:if>
                    <c:if test="${p.status=='disable'}">
                        <span class="label label-danger">下架</span>
                    </c:if>
                </td>
                <td>
                    <div class="joy-list-row-operations">
                        <soul:button target="${root}/lottery/manage/lotteryManage.html?search.id=${p.id}" callback="query"
                                     cssClass="btn" text="管理" opType="dialog" />
                        <%--<soul:button target="${root}/lottery/view.html?id=${p.id}" text="盘口管理" opType="dialog" />--%>
                        <c:if test="${p.code!='hklhc'}">
                            <a href="/lotteryHandicap/list.html?search.code=${p.code}&search.type=${p.type}" class="btn" nav-target="mainFrame">盘口管理</a>
                        </c:if>
                        <c:if test="${p.code=='hklhc'}">
                            <a href="/lotteryHandicapLhc/list.html?search.code=${p.code}&search.type=${p.type}" class="btn" nav-target="mainFrame">盘口管理</a>
                        </c:if>
                        <c:if test="${p.code=='hklhc'}">
                            <a href="/lotteryLhcZodiac/list.html?search.code=${p.code}&search.type=${p.type}" class="btn" nav-target="mainFrame">生肖管理</a>
                        </c:if>
                        <c:if test="${p.code=='cqssc'||p.code=='xjssc'||p.code=='tjssc'||p.code=='bjpk10'||p.type=='k3'||p.type=='pl3'}">
                            <input type="hidden" name="code" value="${p.code}"/>
                            <input type="hidden" name="id" value="${p.id}"/>
                            <shiro:hasPermission name="lottery:change_lotterygenre">
                            <gb:select name="chargeGenre" listKey="genre"   notUseDefaultPrompt="true" list="${lotteryGenre}" value="${p.genre}" cssClass="btn-group chosen-select-no-single" callback="updateLotteryGenre"/>
                            </shiro:hasPermission>
                        </c:if>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<soul:pagination/>
<!--//endregion your codes 1-->
