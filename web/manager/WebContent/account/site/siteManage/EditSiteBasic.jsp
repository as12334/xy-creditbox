<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<form:form id="addSysSiteForm" action="" method="post">
    <lb:token/>
    <lb:validateRule/>
    <div class="row">
        <div class="position-wrap clearfix">
            <span>账户</span><span>/</span><span>新增站点</span>
            <soul:button tag="a" target="goToLastPage" text="" opType="function"
                         cssClass="returnSuperior m-l-sm btn btn-outline btn-default btn-xs co-gray6 return-btn">
                <input hidden name="lastTimeSearch" value="${command.lastTimeSearch}">
                <em class="fa fa-caret-left"></em>返回
            </soul:button>
        </div>

        <div class="col-lg-12">
            <div class="wrapper white-bg shadow">
                <div class="form-group clearfix m-b-sm">
                    <label class="col-sm-3 al-right line-hi34 ft-bold">
                        <c:choose>
                            <c:when test="${subSysCode eq 'company'}">
                                公司账号：
                            </c:when>
                            <c:otherwise>
                                运营商账号：
                            </c:otherwise>
                        </c:choose>
                    </label>
                    <div class="col-sm-5 line-hi34">
                        <font size="4px">${empty fn:substringBefore(command.vSiteMasterManage.username,'@')?command.vSiteMasterManage.username:fn:substringBefore(command.vSiteMasterManage.username,'@')}</font>
                    </div>
                </div>
            <input type="hidden"  name="result.siteClassifyKey" id="result.siteClassifyKey"  value="${subSysCode}" class="form-control"/>


                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>站点名称：</label>
                    <div class="col-sm-5" id="siteName">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.siteName" id="result.siteName" class="form-control" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>站点ID：</label>
                    <div class="col-sm-5" id="id">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.id" id="result.id" class="form-control" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                </div>
                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>站点代码：</label>
                    <div class="col-sm-5" id="code">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.code" id="result.code"  class="form-control" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                </div>

                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right">模板名称：</label>
                    <div class="col-sm-5">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.templateCode" id="result.templateCode" class="form-control" aria-required="true" aria-invalid="true" placeholder="选填，默认为:default"/>
                        </div>
                    </div>
                </div>

                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right">主题名称：</label>
                    <div class="col-sm-5">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.theme" id="result.theme" class="form-control" aria-required="true" aria-invalid="true" placeholder="选填，默认为:default"/>
                        </div>
                    </div>
                </div>

                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>标题名称：</label>
                    <div class="col-sm-5">
                        <div class="input-group  m-b-sm">
                            <input type="text" name="result.title" id="result.title" class="form-control" aria-required="true" aria-invalid="true"/>
                        </div>
                    </div>
                </div>

                <div class="clearfix m-t-md" id="secondary" var="siteLang">
                    <label class="ft-bold col-sm-3 al-right line-hi30">站点logo：</label>
                    <div class="col-sm-3">
                        <div class="form-group m-b-sm">
                            <div id="activityCoverImage">
                            </div>
                            <input id="activityCoverFile"  class="file file2" type="file"
                                   target="result.logoPath" accept="image/*" name="activityCoverFile">
                            <input type="hidden" class="activityCoverFile"
                                   name="result.logoPath" value="">
                        </div>
                        <div id="activityCoverImg">
                            <img id="upCoverImage" src="" style="display: none;width:100%;height: auto;"/>
                        </div>
                        <div>请上传1M以内，JPG,JPEG,PNG,GIF格式的图片</div>
                    </div>
                </div>

                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>站点主语言：</label>
                    <div class="col-sm-5">
                        <div class="input-group date" style="width: 400px">
                        <select  name="result.mainLanguage" id="result.mainLanguage"  class="chosen-select-no-single" callback="selectChange">
                                    <c:forEach items="${siteLanguage}" var="p">
                                        <option value="${p.code}">${p.trans}&nbsp;&nbsp;&nbsp;&nbsp;${p.code}&nbsp;&nbsp;</option>
                                    </c:forEach>
                         </select>
                        </div>
                        <div class="m-t-sm mainLanguage">
                            <span class="co-yellow m-r-sm"><i class="fa fa-exclamation-circle"></i></span>站点的系统信息将以该语言版本显示，一旦设置，不可修改！
                        </div>

                    </div>
                </div>

                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>选择主货币：</label>
                    <div class="col-sm-5">
                        <div class="input-group date">
                                <select  name="result.mainCurrency" id="result.mainCurrency" class="chosen-select-no-single" callback="selectChange">
                                    <c:forEach items="${siteCurrency}" var="p">
                                        <option value="${p.code}">${p.trans}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${p.code}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="m-t-sm sitecurrency">
                            <span class="co-yellow m-r-sm"><i class="fa fa-exclamation-circle"></i></span>站点的资金将转换成该货币显示，一旦设置，不可修改！
                        </div>
                    </div>
                </div>
                <div class="form-group clearfix m-b-sm">
                    <label class="ft-bold col-sm-3 line-hi34 al-right"><span class="co-red m-r-sm">*</span>站点时区：</label>
                    <div class="col-sm-3">
                        <div class="input-group date">
                            <select class="chosen-select-no-single" name="result.timezone" callback="selectChange">
                                <c:set var="chooseTz" value="${tz}"/>
                                <c:forEach items="${dictTimeZone}" var="dictTz">
                                    <c:if test="${cTime eq dictTz.key}">
                                        <option value="${dictTz.key}" ${cTime eq dictTz.key?'selected':''}>${dicts.common.time_zone[dictTz.value.dictCode]}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            <span class="input-group-addon abroder-no" id="tz">${soulFn:formatDateTz(serviceDate,DateFormat.DAY_SECOND ,chooseTz )}</span>
                        </div>
                        <div class="m-t-sm"><span class="co-yellow m-r-sm"><i
                                class="fa fa-exclamation-circle"></i></span>站点的系统信息将以该时区显示，一旦设置，不可修改！
                        </div>
                    </div>
                </div>

                <div class="operate-btn">
                    <input type="hidden" value="${command.search.sysUserId}" name="result.sysUserId"/>
                    <input type="hidden" value="${command.search.parentId}" name="result.parentId"/>
                       <c:choose>
                           <c:when test="${subSysCode eq 'shareholder'}">
                               <soul:button  cssClass="btn btn-filter btn-lg" text="保存" opType="ajax" dataType="json"
                                             target="${root}/vSysSiteManage/submit.html" post="getCurrentFormData" callback="saveCallbak"/>
                               <a href="" id="editTest" nav-target="mainFrame" style="display: none"></a>
                           </c:when>
                           <c:otherwise>
                               <soul:button  cssClass="btn btn-filter btn-lg" text="保存" opType="ajax" dataType="json"
                                             target="${root}/vSysSiteManage/submit.html" post="getCurrentFormData" callback="saveCallbakMch" precall="uploadFile"/>
                               <a href="" id="editTestMch" nav-target="mainFrame" style="display: none"></a>
                           </c:otherwise>
                       </c:choose>
                       <soul:button cssClass="btn btn-outline btn-lg m-l-sm" opType="function" target="goToLastPage" text="取消"/>
                </div>
            </div>
        </div>
    </div>
</form:form>
<soul:import res="site/account/site/siteManage/EditSiteBasic"/>