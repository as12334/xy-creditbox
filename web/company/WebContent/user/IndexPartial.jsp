<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserListVo"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

<!--//region your codes 1-->
<c:set var="superUserTypeName" value='${views.page["UserTypeEnum.".concat(command.search.ownerUserType)]}'></c:set>

<div class="shell-middle-left">
    <div class="shell-middle-right">
        <div class="shell-middle" id="middleContent">
            <div id="load-middle" class="acion" style="display: block;">
                <div id="1571103618814">
                    <table class="middle-table">
                        <thead>
                        <tr>
                            <th>在線</th>
                            <th>上級${superUserTypeName}</th>
                            <th>占成</th>
                            <th>分公司</th>
                            <th>限占</th>
                            <th>名稱</th>
                            <th>股東</th>
                            <th>總代理</th>
                            <th>代理</th>
                            <th>會員</th>
                            <th>信用額度</th>
                            <th>可用額度</th>
                            <th>註冊日期</th>
                            <th>補貨</th>
                            <th>狀態</th>
                            <th>功能</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="result" items="${command.result}">
                            <%--<tr>--%>
                                <%--<td class="offline sw50"></td>--%>
                                <%--<td>${result.parentName}</td>--%>
                                <%--<td class="txt-left txt-fhs">${result.superiorOccupy}%</td>--%>
                                <%--<td data-name="f02">${result.username}</td>--%>
                                <%--<td>${result.stintOccupy}</td>--%>
                                <%--<td>${result.nickname}</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="txt-right">${result.credits}</td>--%>
                                <%--<td class="txt-right">${result.credits}</td>--%>
                                <%--<td class="txt-right">${soulFn:formatDateTz(result.createTime, DateFormat.DAY_SECOND,timeZone)}</td>--%>
                                <%--<td>啟用</td>--%>
                                <%--<td>啟用</td>--%>
                                <%--<td class="sw100">--%>
                                    <%--<span class="sp s-22" data-rec="userrebate" data-name="f02">退水</span>--%>
                                    <%--<span class="sp s-44" data-up="userupdate" data-name="f02">修改</span>--%>
                                    <%--<span class="sp s-55" data-fid="login" data-name="f02">日誌</span>--%>
                                    <%--<span class="sp s-99" data-fid="record" data-name="f02">記錄</span>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                                <%--<td class="offline sw50"></td>--%>
                                <%--<td>${result.parentName}</td>--%>
                                <%--<td class="txt-left txt-fhs">${result.superiorOccupy}%</td>--%>
                                <%--<td data-name="f02">${result.username}</td>--%>
                                <%--<td>${result.stintOccupy}</td>--%>
                                <%--<td>${result.nickname}</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="w5">0</td>--%>
                                <%--<td class="txt-right">${result.credits}</td>--%>
                                <%--<td class="txt-right">${result.credits}</td>--%>
                                <%--<td class="txt-right">${soulFn:formatDateTz(result.createTime, DateFormat.DAY_SECOND,timeZone)}</td>--%>
                                <%--<td>啟用</td>--%>
                                <%--<td class="sw100">--%>
                                    <%--<span class="sp s-22" data-rec="userrebate" data-name="f02">退水</span>--%>
                                    <%--<span class="sp s-44" data-up="userupdate" data-name="f02">修改</span>--%>
                                    <%--<span class="sp s-55" data-fid="login" data-name="f02">日誌</span>--%>
                                    <%--<span class="sp s-99" data-fid="record" data-name="f02">記錄</span>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                            <tr>
                                <td class="offline sw50"></td>
                                <td>${fn:substringBefore(result.parentName,'@')}</td>
                                <td class="txt-left txt-fhs">${result.superiorOccupy}%</td>
                                <td data-name="f01">${fn:substringBefore(result.username,'@')}</td>
                                <td>${result.stintOccupy}</td>
                                <td>${result.nickname}</td>
                                <td class="w5"><a href="javascript:void(0)" data-name="f01" data-level="3">0</a></td>
                                <td class="w5"><a href="javascript:void(0)" data-name="f01" data-level="4">0</a></td>
                                <td class="w5"><a href="javascript:void(0)" data-name="f01" data-level="5">0</a></td>
                                <td class="w5"><a href="javascript:void(0)" data-name="f01" data-level="6">0</a></td>
                                <td class="txt-right">${result.credits}</td>
                                <td class="txt-right">${result.credits}</td>
                                <td>${soulFn:formatDateTz(result.createTime, DateFormat.DAY_SECOND,timeZone)}</td>
                                <td><p class="fgs zun">0</p></td>
                                <td><a href="javascript:void(0)" data-state="2" data-name="f01">啟用</a></td>
                                <td class="sw100">
                                    <span class="sp s-22" data-rec="userrebate" data-name="f01">退水</span><span class="sp s-44" data-up="userupdate" data-name="f01">修改</span>
                                    <span class="sp s-55" data-fid="login" data-name="f01">日誌</span><span class="sp s-99" data-fid="record" data-name="f01">記錄</span>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/common/Pagination.jsp" %>


<%--<div class="shell-bottom">--%>
    <%--<div class="shell-bottom-left"></div>--%>
    <%--<div class="shell-bottom-right"></div>--%>
    <%--<div class="shell-bottom-content" id="shell_pageControl">--%>
        <%--<div class="pager" id="data-page">共 2 條記錄 分頁：1/1頁&nbsp;&nbsp;&nbsp;上一頁...『&nbsp;<span--%>
                <%--class="font_c">1</span>&nbsp;』...下一頁&nbsp;&nbsp;<input type="text" value="1" name="txtPager"--%>
                                                                       <%--id="txtPager" class="GOtext"></div>--%>
    <%--</div>--%>
<%--</div>--%>
<!--//endregion your codes 1-->
