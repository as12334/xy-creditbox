<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.lotterybox.model.manager.user.vo.VUserManagerVo"--%>

<html lang="zh-CN">
<head>
    <title>域名编辑</title>
    <%--<%@ include file="/include/include.head.jsp" %>--%>
</head>
<body >
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/skin/main.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/jquery-ui-1.8.21.custom.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/number.css?v=${rcVersion}"/>
<link rel="stylesheet" type="text/css" href="${resRoot}/themes/globals.css?v=${rcVersion}"/>

<form:form id="editDomainForm" method="post">
    <lb:token/>
    <input type="hidden" name="result.id" value="${command.result.id}"/>
    <lb:validateRule/>

    <div id="myWarpr">
        <table class="myLayer" cellspacing="0" cellpadding="0" border="0" style="top: 170.714px; left: 173.5px;">
            <tbody>
            <tr>
                <td>
                    <div class="myLayerOn" style="display: none;"></div>
                    <div class="myLayerTitle"><h3>新增分公司</h3><a href="javascript:;" class="myLayerClose" title="關閉"></a>
                    </div>
                    <div class="myLayerContent" style="width: 450px; height: auto; overflow-y: auto;">
                        <div id="add-user">
                            <table class="middle-table">
                                <thead>
                                <tr></tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="w25 bc txt-right">上級<span name="shareRole">${views.page[command.superUserList[0].subsysCode]}</span>:</td>
                                    <td class="txt-left"><select name="shareName">
                                        <c:forEach items="${command.superUserList}" var="result">
                                            <option value="${result.hid}">${result.username}</option>
                                        </c:forEach>

                                    </select> 餘額:<span name="shareCredits">900000</span></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">用戶暱稱:</td>
                                    <td class="txt-left"><input type="text" name="fatherName" autocomplete="off"
                                                                maxlength="12" class="text-input sw90"
                                                                reg="/^[a-zA-Z0-9-一-龥]{1,12}$/"
                                                                mesg="“名稱”由漢字的簡繁體(壹個漢字2位字符)、字母、數字、下劃線組成，長度不超過12個英文字符或8個漢字！">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">登錄賬號:</td>
                                    <td class="txt-left"><input type="text" name="userName" autocomplete="off"
                                                                maxlength="12" class="text-input sw90"
                                                                reg="/^[a-z0-9A-Z][a-z0-9A-Z_]{0,12}$/"
                                                                mesg="“賬號”由1-12位英文字母、數字、下劃線組成，且第壹位不能是下劃線！"></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">登錄密碼:</td>
                                    <td class="txt-left"><input type="text" name="pwd" autocomplete="off" maxlength="20"
                                                                class="text-input sw90"
                                                                reg="/^[a-z0-9A-Z][a-z0-9A-Z]{6,20}$/"
                                                                mesg="“密碼”必需包含字母、小寫字母和數字組成，長度6-20位！"></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">信用額度:</td>
                                    <td class="txt-left"><input type="text" name="credits" autocomplete="off"
                                                                maxlength="9" value="0" class="text-input sw90"
                                                                reg="/^[0-9]{1,9}$/" mesg="“信用額度” 由1-9位正整数组成。"> <span
                                            class="red" id="up-rmb"></span></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">信用/現金:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio"
                                                                                         name="modeSelection"
                                                                                         checked="checked"
                                                                                         data-value="0">信用</label>
                                        <label class="label-box"><input type="radio" name="modeSelection"
                                                                        data-value="1">現金</label></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">试玩帐户:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio"
                                                                                         name="testAccountID"
                                                                                         checked="checked"
                                                                                         data-value="0">否</label> <label
                                            class="label-box"><input type="radio" name="testAccountID" data-value="1">是</label>
                                    </td>
                                </tr>
                                <tr style="display:;">
                                    <td class="w25 bc txt-right">邀请码:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio" name="YaoQingID"
                                                                                         checked="checked"
                                                                                         data-value="0">是</label> <label
                                            class="label-box"><input type="radio" name="YaoQingID"
                                                                     data-value="1">否</label></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">補貨設定:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio" name="shipments"
                                                                                         checked="checked"
                                                                                         data-value="1">啟用</label>
                                        <label class="label-box"><input type="radio" name="shipments" data-value="0">禁用</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">剩餘成數:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio" name="breakpoint"
                                                                                         checked="checked"
                                                                                         data-value="1">總監</label>
                                        <label class="label-box"><input type="radio" name="breakpoint" data-value="2">分公司</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">總賬報表:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio" name="generalId"
                                                                                         data-value="1">總賬(非明细)</label>
                                        <label class="label-box"><input type="radio" name="generalId" data-value="2">總賬(包括明細)</label>
                                        <label class="label-box"><input type="radio" name="generalId" checked="checked"
                                                                        data-value="0">關閉</label></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right"><span name="shareRole">總監</span>占成:</td>
                                    <td class="txt-left"><input type="text" name="superior" autocomplete="off"
                                                                maxlength="3" value="0" class="text-input sw50"
                                                                reg="/^[0-9]{1,3}$/" mesg="“上级占成” 由1-3位正整数组成。"> <span
                                            name="shareSuperior">100</span>%
                                    </td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">下級限占:</td>
                                    <td class="txt-left"><label class="label-box"><input type="radio" name="stintId"
                                                                                         checked="checked"
                                                                                         data-value="yes">占餘成數下線任占</label>
                                        <label class="label-box"><input type="radio" name="stintId" data-value="no">限制下線占成</label>
                                        <input type="text" name="stint" autocomplete="off" maxlength="3" value="-1"
                                               class="text-input sw50 hiden" reg="/^[-]?[0-9]+$/"
                                               mesg="“下級限占” 由1-3位正整数组成。"></td>
                                </tr>
                                <tr>
                                    <td class="w25 bc txt-right">退水設定:</td>
                                    <td class="txt-left"><select name="set_water">
                                        <option value="0">全退到底</option>
                                        <option value="100">全部賺取</option>
                                        <option value="0.1">0.1</option>
                                        <option value="0.3">0.3</option>
                                        <option value="0.5">0.5</option>
                                    </select> <input type="text" name="water" autocomplete="off" maxlength="5" value="0"
                                                     class="text-input sw40" reg="/^[0-9.]+$/"
                                                     mesg="“自定退水” 0-100之间，允许4位小数组成。"> 自定設置
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="myLayerFooter" style="display: block;"><a href="javascript:;"
                                                                          class="btn grayBtn myLayerCancel" title="取消"
                                                                          style="display: inline-block;">取消</a><a
                            href="javascript:;" class="btn hotBtn myLayerOk" title="確認" style="display: inline-block;">確認</a>
                    </div>
                    <div class="myLayerLoading"></div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<script type="text/javascript">
    curl(['site/user/Edit'], function(Page,Dialog) {
        page = new Page();
    });
</script>

</html>