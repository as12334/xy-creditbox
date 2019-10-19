<%--@elvariable id="command" type="org.soul.model.security.privilege.vo.SysUserVo"--%>
<%--@elvariable id="roles" type="java.util.List<java.util.Map<java.lang.String,java.lang.Object>>"--%>
<%--@elvariable id="site" type="so.wwb.lotterybox.model.manager.sys.po.SysSite"--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<style>
    .err{
        color:red;
        font-size: 5px;
    }
    .roleNull{
        color:red;
    }

</style>
<html lang="zh-CN">
<head>
    <title>股东账号编辑</title>
    <%@ include file="/include/include.head.jsp" %>
</head>

<body>

<form:form id="editCompanyForm" method="post">
    <c:set var="r" value="${command.result}"/>
    <input type="hidden" name="result.id" value="${r.id}"/>
    <input type="hidden" name="result.userType" value="1">
    <input type="hidden" name="result.ownerId" value="0">
    <lb:validateRule/>
    <lb:token/>
    <c:choose>
        <c:when test="${empty r.id && empty userTypes}">
            暂无新增用户权限
        </c:when>
        <c:otherwise>
            <input hidden name="result.credits" value="0"/>
            <div class="modal-body">
                <div class="form-group clearfix">
                    <label class="col-xs-3 al-right line-hi34" for="result.username"><span class="co-red m-r-sm">*</span>账号：</label>
                    <div class="col-xs-9">
                        <input id="result.username" ${!empty r.id?'readonly':''} name="result.username" class="form-control m-b-xs" type="text" value="${fn:substringBefore(r.username,'@')}" aria-required="true" aria-invalid="true"/>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-xs-3 al-right line-hi34" for="result.nickname"><span class="co-red m-r-sm">*</span>昵称：</label>
                    <div class="col-xs-9">
                        <input id="result.nickname" name="result.nickname" class="form-control m-b-xs" type="text" value="${r.nickname}" aria-required="true" aria-invalid="true"/>
                    </div>
                </div>
                <div class="form-group clearfix">
                    <label class="col-xs-3 al-right line-hi34" for="result.realName"></span>真实姓名：</label>
                    <div class="col-xs-9">
                        <input id="result.realName" name="result.realName" class="form-control m-b-xs" type="text" value="${r.realName}"  aria-invalid="true"/>
                    </div>
                </div>
                <c:if test="${empty r.id}">
                    <div class="form-group clearfix">
                        <label class="col-xs-3 al-right line-hi34" for="result.password"><span class="co-red m-r-sm">*</span>登录密码：</label>
                        <div class="col-xs-9">
                            <input id="result.password" name="result.password" class="form-control m-b-xs" type="password" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                    <div class="form-group clearfix">
                        <label class="col-xs-3 al-right line-hi34" for="confirmPwd"><span class="co-red m-r-sm">*</span>确认登录密码：</label>
                        <div class="col-xs-9">
                            <input id="confirmPwd" name="confirmPwd" class="form-control m-b-xs" type="password" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                    <div class="form-group clearfix">
                        <label class="col-xs-3 al-right line-hi34" for="result.permissionPwd"><span class="co-red m-r-sm">*</span>安全密码：</label>
                        <div class="col-xs-9">
                            <input id="result.permissionPwd" name="result.permissionPwd" class="form-control m-b-xs" type="password" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                    <div class="form-group clearfix">
                        <label class="col-xs-3 al-right line-hi34" for="confirmPermissionPwd"><span class="co-red m-r-sm">*</span>确认安全密码：</label>
                        <div class="col-xs-9">
                            <input id="confirmPermissionPwd" name="confirmPermissionPwd" class="form-control m-b-xs" type="password" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                </c:if>

                <%--<div class="form-group clearfix">--%>
                    <%--<label class="col-xs-3 al-right line-hi34" for="noticeContactWay.contactValue"></span>电子邮箱：</label>--%>
                    <%--<div class="col-xs-9">--%>
                        <%--<input id="noticeContactWay.contactValue" name="noticeContactWay.contactValue" class="form-control m-b-xs" type="text" value="${email}" aria-invalid="true"/>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <c:if test="${!empty sex}">
                    <div class="form-group clearfix line-hi34">
                        <label class="col-xs-3 al-right">性别</label>
                        <div class="col-xs-8 p-x">
                            <lb:select name="result.sex" cssClass="btn-group chosen-select-no-single"
                                       prompt="${views.common['pleaseSelect']}" value="${r.sex}" list="${sex}" optionDirection="up"/>
                        </div>
                    </div>
                </c:if>
                <div class="form-group clearfix line-hi34 m-b-xxs">
                    <label class="col-xs-3 al-right">生日</label>
                    <div class="col-xs-8 p-x">
                        <lb:dateRange name="result.birthday" maxDate="${dateQPicker.today}" value="${r.birthday}"
                                      readonly="readonly"
                                      position="up" showDropdowns="true"/>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <c:choose>
                    <c:when test="${empty r.id}">
                        <soul:button target="${root}/boss/account/companies/addAccount.html" post="getCurrentFormData" precall="validateForm" text="确认" opType="ajax" dataType="json" cssClass="btn btn-filter" callback="saveCallbak" tag="button"/>
                    </c:when>
                    <c:otherwise>
                        <soul:button target="${root}/boss/account/companies/updateAccount.html" post="getCurrentFormData" precall="validateForm" text="确认" opType="ajax" dataType="json" cssClass="btn btn-filter" callback="saveCallbak" tag="button"/>
                    </c:otherwise>
                </c:choose>
                <soul:button cssClass="btn btn-outline btn-filter" target="closePage" text="取消" opType="function"/>
            </div>
        </c:otherwise>
    </c:choose>
</form:form>
</body>
<%@ include file="/include/include.js.jsp" %>
<!--//region your codes 4-->
<soul:import res="site/boss/account/companies/Edit"/>
<!--//endregion your codes 4-->
</html>