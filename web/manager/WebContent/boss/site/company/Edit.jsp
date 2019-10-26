<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<html>
<head>
    <title>编辑</title>
    <%@ include file="/include/include.head.jsp" %>
    <%@ include file="/WebContent/include/include.base.js.jsp" %>
</head>

<body>
<form:form id="siteMerChantEdit1">
    <lb:validateRule/>
    <lb:token/>
    <form:input type="hidden" path="result.id" value="${result.id}"/>
    <div class="modal-body">
        <div class="form-group">
            <label class="col-xs-3 al-right line-hi34"><span class="co-red m-r-sm">*</span>站点名称：</label>
            <div class="input-group m-b col-xs-9">
                <form:input class="form-control" path="result.name" value="${result.name}"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 al-right line-hi34">模板名称：</label>
            <div class="input-group m-b col-xs-9">
                <form:input class="form-control" path="result.templateCode" placeholder="选填，默认为:default" value="${result.templateCode}"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 al-right line-hi34"><span class="co-red m-r-sm">*</span>标题名称：</label>
            <div class="input-group m-b col-xs-9">
                <form:input class="form-control" path="result.title" value="${result.title}"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 al-right line-hi34">主题名称：</label>
            <div class="input-group m-b col-xs-9">
                <form:input class="form-control" path="result.theme" placeholder="选填，默认为:default" value="${result.theme}"></form:input>
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-3 al-right line-hi34">备注：</label>
            <div class="input-group m-b col-xs-9">
                <form:textarea class="form-control" path="result.remark" value="${result.remark}"></form:textarea>
            </div>
        </div>

        <div class="hfsj-wrap" style="height: 460px;">
            <div class="ann tab-pane" style="display:">
                <div class="form-group">
                    <label>站点logo：</label>
                    <span class="m-l co-grayc2">请上传1M以内,JPG,JPEG,PNG,GIF格式的图片</span>
                    <div class="form-group m-b-sm">
                        <div id="carouselCover1">
                            <c:if test="${not empty command.result.logoPath}">
                                <img id="carouselCoverImg" src="${soulFn:getThumbPath(domain, command.result.logoPath,500,500)}"
                                     class="logo-size-h100" style="margin: 10px 0; width: auto;height: 150px;"/>
                            </c:if>
                        </div>
                        <input id="contentCoverFile" class="file " type="file" accept="image/*" name="carouselCoverFile" target="result.logoPath" value="">
                        <input type="hidden" class="carouselCoverVal" name="result.logoPath" id="carouselCover2" value="${command.result.logoPath}">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <soul:button precall="preSave" cssClass="btn btn-filter"
                     callback="saveCallbak" text="${views.common['save']}"
                     opType="ajax" dataType="json" target="${root}/site/siteMerChant/updateSiteMerChant.html"
                     post="getCurrentFormData"/>
        <soul:button target="closePage" text="${views.common['cancel']}" returnValue="false"  cssClass="btn btn-outline btn-filter" opType="function"/>
    </div>
</form:form>
</body>
<script type="text/javascript">
    curl(['lb/components/select'], function(Page) {
        select = new Page();
    });
</script>
<soul:import res="site/boss/site/company/Edit"/>
</html>