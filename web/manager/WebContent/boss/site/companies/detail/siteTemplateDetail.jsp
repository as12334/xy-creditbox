<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="row">
    <c:if test="${not empty vSysUserThemeRelation.pcThemeId}">
        <div class="col-sm-4">
            <div class="filter-wraper clearfix">
                <b class="fs16">PC端模板</b>
            </div>
            <div class="m-sm">
                <div class="gray-chunk clearfix" style="width: 655px;height: 505px;">
                    <div class="col-sm-12">
                        <div class="clearfix  m-t-sm m-b-sm change-logo">
                            <dd class="change-logo-title">
                            <span>
                                <c:choose>
                                    <c:when test="${vSysUserThemeRelation.pcFeeType eq '1'}">
                                        <b>免费模板</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>收费模板</b>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                                <p></p>
                            </dd>
                            <dd class="lightBoxGallery">
                                <img onload="if (this.width>600) this.width=600;if(this.height>600) this.height=600"  src="${resRoot}/${vSysUserThemeRelation.pcPicPath}">
                            </dd>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty vSysUserThemeRelation.mobileThemeId}">
        <div class="col-sm-8"  style="padding-left:300px;">
            <div class="filter-wraper clearfix">
                <b class="fs16">移动端模板</b>
            </div>
            <div class="m-sm">
                <div class="gray-chunk clearfix" style="width:470px;height:530px;">
                    <div class="col-sm-12">
                        <div class="clearfix  m-t-sm m-b-sm change-logo">
                            <dd class="change-logo-title">
                            <span>
                                <c:choose>
                                    <c:when test="${vSysUserThemeRelation.mobileFeeType eq '1'}">
                                        <b>免费模板</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>收费模板</b>
                                    </c:otherwise>
                                </c:choose>
                            </span>
                                <p></p>
                            </dd>
                            <dd class="lightBoxGallery">
                                <img src="${resRoot}/${vSysUserThemeRelation.mobilePicPath}">
                            </dd>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>


