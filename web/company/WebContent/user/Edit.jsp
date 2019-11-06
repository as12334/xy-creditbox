<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserVo"--%>
<%--@elvariable id="userTypeEnum" type="so.wwb.creditbox.model.enums.user.UserTypeEnum"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

<form:form method="post" id="editUserForm">
    <a hidden id="changeOwnerUserType" nav-target="mainFrame" href="/vSiteUser/createUser/8.html">新增</a>

    <lb:validateRule/>

    <c:set var="superUserTypeName" value='${views.page["UserTypeEnum.".concat(command.search.ownerUserType)]}'></c:set>
    <%--新增分公司才要显示，其他用户类型不显示--%>
    <c:set var="hiddenBranchStatus" value="${command.search.userType == '4'?'':'hidden'}"></c:set>
    <%--新增玩家才要显示，其他用户类型不显示--%>
    <c:set var="playHiddenStatus" value="${command.search.userType == '8'}"></c:set>
    <c:set var="playEditHiddenStatus" value="${empty command.result.id}"></c:set>

    <input hidden name="result.userType" value="${command.search.userType}">
    <input hidden id="superStintOccupy" value="">
    <input hidden name="result.id" value="${command.result.id}">


    <div class="shell-top" id="shell_top">
        <div class="shell-top-left"></div>
        <div class="shell-title-icon">
            <span id="shell_title">${views.page["UserTypeEnum.".concat(command.search.userType)]} -> 新增</span>
        </div>
        <div class="shell-top-right"></div>
    </div>
    <div class="shell-middle-left">
        <div class="shell-middle-right">
            <div class="shell-middle" id="middleContent">
                <div id="load-middle" class="acion" style="display: block;">
                    <div id="1571103618814">
                        <table class="middle-table" id="add-user">
                            <thead>
                            <tr></tr>
                            </thead>
                            <tbody>
                            <tr ${playHiddenStatus &&  playEditHiddenStatus? "":"hidden"}>
                                <td class="w25 bc txt-right">選擇上級:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.ownerUserType" value="4" ${empty command.search.ownerUserType || command.search.ownerUserType == '4' ? 'checked':''}>分公司</label>
                                    <label class="label-box"><input type="radio" name="result.ownerUserType" value="5" ${command.search.ownerUserType == '5' ? 'checked':''}>股東</label>
                                    <label class="label-box"><input type="radio" name="result.ownerUserType" value="6" ${command.search.ownerUserType == '6' ? 'checked':''}>總代理</label>
                                    <label class="label-box"><input type="radio" name="result.ownerUserType" value="7" ${command.search.ownerUserType == '7' ? 'checked':''}>代理</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">上級<span
                                        name="shareRole">${superUserTypeName}</span>:
                                </td>
                                <c:choose>
                                    <c:when test="${empty command.result.id}">
                                        <td class="txt-left">
                                            <select name="result.ownerId">
                                                <c:if test="${command.superUserList.size()==0}">
                                                    <option value="">请先创建${superUserTypeName}用户</option>
                                                </c:if>
                                                <c:forEach items="${command.superUserList}" var="result">
                                                    <option value="${result.id}" data-credit="${result.credits}">${fn:substringBefore(result.username,'@')}</option>
                                                </c:forEach>
                                            </select>
                                            餘額:<span id="shareCredits">0</span></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="txt-left">${fn:substringBefore(command.result.ownerName,'@')}</td>
                                        <input hidden name="result.ownerId" value="${command.result.ownerId}"/>
                                    </c:otherwise>
                                </c:choose>

                            </tr>
                            <tr ${playHiddenStatus ? "":"hidden"}>
                                <td class="w25 bc txt-right">會員盤口:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.handicap" value="1" ${empty command.result.handicap || command.result.handicap == '1' ? 'checked':''}>A盤</label>
                                    <label class="label-box"><input type="radio" name="result.handicap" value="2" ${command.result.handicap == '2' ? 'checked':''}>B盤</label>
                                    <label class="label-box"><input type="radio" name="result.handicap" value="3" ${command.result.handicap == '3' ? 'checked':''}>C盤</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">賬號狀態:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.status" data-value="1" ${command.result.status == '1' || empty command.result.status?'checked':''} value="1">啟用</label>
                                    <label class="label-box"><input type="radio" name="result.status" data-value="2" ${command.result.status == '2'?'checked':''} value="2">停用</label>
                                    <label class="label-box"><input type="radio" name="result.status" data-value="3" ${command.result.status == '3'?'checked':''}  value="3">凍結</label>
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">用戶暱稱:</td>
                                <td class="txt-left">
                                    <input type="text" name="result.nickname" value="${command.result.nickname}" autocomplete="off" maxlength="12" class="text-input sw90" reg="/^[a-zA-Z0-9_]{4,16}$/" mesg="請輸入4-16个(由英文字母,下划线“-”,數字或任意組合而成)" >
                                </td>
                            </tr>
                            <tr ${empty command.result.id?"":"hidden"}>
                                <td class="w25 bc txt-right">登錄賬號:</td>
                                <td class="txt-left">
                                    <input type="text" name="result.username" value="${fn:substringBefore(command.result.username,'@')}" autocomplete="off" maxlength="12" class="text-input sw90" reg="/^[a-z0-9A-Z][a-z0-9A-Z_]{3,12}$/" mesg="“賬號”由4-12位英文字母、數字、下劃線組成，且第壹位不能是下劃線！">
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">登錄密碼:</td>
                                <td class="txt-left">
                                    <input type="text" name="result.password" value="" autocomplete="off" maxlength="20" class="text-input sw90" reg="/^[a-z0-9A-Z][a-z0-9A-Z]{5,20}$/" mesg="“密碼”必需包含字母、小寫字母和數字組成，長度6-20位！">
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">信用額度:</td>
                                <td class="txt-left">
                                    <input type="text" name="result.credits" value="${empty command.result.credits ? '0':command.result.credits}" autocomplete="off" maxlength="9" value="0" class="text-input sw90" reg="/^[0-9].*$/" mesg="請輸入 1-99999999 ">
                                    <span class="red" id="up-rmb"></span>
                                </td>
                            </tr>
                            <tr ${playHiddenStatus ? "hidden":""}>
                                <td class="w25 bc txt-right">補貨設定:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.manualAutoShipments" ${command.result.manualAutoShipments == '1'?'checked':''} value="1">啟用</label>
                                    <label class="label-box"><input type="radio" name="result.manualAutoShipments" ${command.result.manualAutoShipments != '1'?'checked':''} value="0">禁用</label>
                                </td>
                            </tr>
                            <tr ${hiddenBranchStatus}>
                                <td class="w25 bc txt-right">剩餘成數:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.breakpoint" ${command.result.breakpoint != '2'?'checked':''} value="1">總監</label>
                                    <label class="label-box"><input type="radio" name="result.breakpoint" ${command.result.breakpoint == '2'?'checked':''} value="2">分公司</label></td>
                            </tr>
                            <tr ${hiddenBranchStatus}>
                                <td class="w25 bc txt-right">總賬報表:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.general" ${command.result.general == '1'?'checked':''} value="1">總賬(非明细)</label>
                                    <label class="label-box"><input type="radio" name="result.general" ${command.result.general == '2'?'checked':''} value="2">總賬(包括明細)</label>
                                    <label class="label-box"><input type="radio" name="result.general" ${command.result.general == '0' || empty command.result.general?'checked':''} value="0">關閉</label></td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right"><span
                                        name="shareRole">${superUserTypeName}</span>占成:
                                </td>
                                <td class="txt-left">
                                    <input type="text" name="result.superiorOccupy" autocomplete="off" maxlength="5" value="${empty command.result.superiorOccupy ? '0':command.result.superiorOccupy}" class="text-input sw50" reg="/^[0-9].*$/" mesg="“上级占成” 由1-3位正整数组成。">
                                    <span id="maxSuperiorOccupy" >0</span>%
                                    <input hidden name="maxSuperiorOccupy" value="0"/>
                                </td>
                            </tr>
                            <tr ${playHiddenStatus ? "hidden":""}>
                                <td class="w25 bc txt-right">下級限占:</td>
                                <td class="txt-left">
                                    <label class="label-box"> <input type="radio" name="stintId" ${empty command.result.stintOccupy || command.result.stintOccupy==-1?"checked":""} value="yes">占餘成數下線任占</label>
                                    <label class="label-box"><input type="radio" name="stintId"  ${command.result.stintOccupy > -1?"checked":""} value="no">限制下線占成</label>
                                    <input ${empty command.result.stintOccupy || command.result.stintOccupy==-1 ? "hidden":""} type="text" name="result.stintOccupy" autocomplete="off" maxlength="5" value="${command.result.stintOccupy}" class="text-input sw50" reg="/^(-)?[1-9][0-9]*$/" mesg="“下級限占” 由1-3位數字组成。">
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 bc txt-right">退水設定:</td>
                                <td class="txt-left"><select name="set_water">
                                    <option value="0">全退到底</option>
                                    <option value="100">全部賺取</option>
                                    <option value="0.1">0.1</option>
                                    <option value="0.3">0.3</option>
                                    <option value="0.5">0.5</option>
                                </select>
                                    <input type="text" name="water" autocomplete="off" maxlength="5" value="0" class="text-input sw40" reg="/^[0-9.]+$/" mesg="“自定退水” 0-100之间，允许4位小数组成。"> 自定設置
                                </td>
                            </tr>
                            <tr ${hiddenBranchStatus}>
                                <td class="w25 bc txt-right">操盤:</td>
                                <td class="txt-left">
                                    <label class="label-box"><input type="radio" name="result.setOdds" ${command.result.setOdds == '1'?"checked":""}  value="1">啟用</label>
                                    <label class="label-box"><input type="radio" name="result.setOdds" ${empty command.result.setOdds || command.result.setOdds==0?"checked":""} value="0">禁用</label>
                                </td>
                            </tr>

                            <tr>
                                <td class="w25 bc txt-right"></td>
                                <td class="txt-left">
                                    <div class="myLayerFooter" style="display: block;    text-align: left;">
                                        <a href="javascript:;" class="btn grayBtn myLayerCancel" title="取消" style="display: inline-block;">取消</a>
                                        <c:if test="${empty command.result.id}"><soul:button cssClass="btn hotBtn " target="saveValid" text="確認" opType="function"></soul:button></c:if>
                                        <c:if test="${!empty command.result.id}"><soul:button cssClass="btn hotBtn " target="updateValid" text="確認" opType="function"></soul:button></c:if>
                                        <%--<soul:button target="${root}/vSiteUser/saveManagerUser.html" post="getCurrentFormData" precall="validateForm" text="确认" opType="ajax" dataType="json" cssClass="btn hotBtn" callback="saveCallbak" tag="button"/>--%>

                                    <%--<a href="javascript:;" class="btn hotBtn myLayerOk" title="確認" style="display: inline-block;text-align: left;">確認</a>--%>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
<%--<%@ include file="/include/include.js.jsp" %>--%>
<soul:import res="site/user/Edit"/>

<!--//region your codes 3-->
<!--//endregion your codes 3-->