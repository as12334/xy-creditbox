<%--@elvariable id="sup" type="so.wwb.gamebox.model.company.lottery.vo.SiteLotteryOddVo"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<style>
    /*彩票三级目录*/
    .lot_three_menu {
        padding: 10px 15px 0 15px;
        color:#b3b2b2;
    }
    .lot_three_menu a{
        color: #b3b2b2;
        border: 1px solid rgba(0, 0, 0, 0);
        padding: 2px 5px;
        transition: all 0.2s;
        margin: 3px;
        display: inline-block;
        border-radius: 4px;
    }
    .lot_three_menu a:hover,.lot_three_menu a.active{
        background: #829ba7;
        color: #FFFFFF;
        padding: 2px 5px;
        border-radius: 10px;

    }
    .sys_tab_wrap li.active .badge-blue {
        background: #3183eb;
    }
    /*赔率官方玩法*/
    .gfwfqh-wrap{border-bottom: 1px solid #e6e6e6; position: relative;min-height: 108px;}
    .gfwfqh-wrap .lot_two_menu,.gfwfqh-wrap .lot_three_menu{margin-left: 126px;}
    .gfwfqh-wrap .wfqh-btn{ position: absolute; background: #fff;  height: 100%;  width: 125px;}
    .gfwfqh-wrap .wfqh-btn a{display: block; width: 100px; margin-left: auto; margin-right: auto; text-align: center; background: #fff; color: #333; border:1px solid #b4b7bb; padding: 10px 0; border-radius: 40px; margin-top: 9px;}
    .gfwfqh-wrap .wfqh-btn a:hover,.gfwfqh-wrap .wfqh-btn a.active{background: #f39503; border:1px solid #f39503; color: #fff;}
    .gfwfqh-wrap .lot_three_menu{padding: 10px 15px 10px 15px;}
</style>
<div class="row">
    <form:form method="post" name="lotteryoddform">
        <div id="validateRule" style="display: none">${oddRule}</div>
        <div id="${id}" class="position-wrap clearfix">
            <h2><a class="navbar-minimalize" href="javascript:void(0)"><i class="icon iconfont">&#xe610;</i> </a></h2>
            <span>彩票</span><span>/</span><span>赔率设置</span>
            <a href="javascript:void(0)" class="pull-right siteMap"><i class="fa fa-sitemap"></i></a>
        </div>


        <div class="clearfix m-t-md m-b-sm">
            <div class="clearfix col-lg-10" style="padding-left: 0;">
                <div class="form-group clearfix pull-left col-md-4 col-sm-12 m-b-sm padding-r-none-sm">
                    <div class="input-group date time-select-a">
                        <span class="input-group-addon bg-gray1">站点ID</span>
                        <input type="number" class="form-control" placeholder="站点ID" id="search_id" VALUE="4" name="search.siteId">
                        <span class="input-group-addon time-select-btn">
                            <a href="javascript:void(0)"  class="btn btn-filter" id="comitSearch">查询</a>
                        </span>
                    </div>
                </div>
            </div>
        </div>

                    <div class="col-lg-12" style="display: none">
                            <ul class="clearfix sys_tab_wrap" id="lotteryDiv">
                                <li class="active" data-code="ssclottery" code="cqssc"><a href="javascript:void(0)">时时彩<span class="badge badge-blue m-l-sm">4种</span></a></li>
                                <li data-code="k3lottery" code="jsk3"><a href="javascript:void(0)">快3<span class="badge badge-blue m-l-sm">4种</span></a></li>
                                <li data-code="pk10lottery" code="bjpk10"><a href="javascript:void(0)">PK10<span class="badge badge-blue m-l-sm">3种</span></a></li>
                                <li data-code="sfclottery" code="cqxync"><a href="javascript:void(0)">十分彩<span class="badge badge-blue m-l-sm">2种</span></a></li>
                                <li data-code="otherlottery" code="hklhc"><a href="javascript:void(0)" >其它<span class="badge badge-blue m-l-sm">5种</span></a></li>
                            </ul>
                        <div class="wrapper white-bg shadow">
                            <!--筛选条件-->

                            <div class="sys_tab_wrap clearfix" id="searchDiv">
                                <div class="m-sm">
                                    <a  href="javascript:void(0)" id="firstOne" code="cqssc" class="label ssc-label" data-code="ssclottery">${dicts.lottery.lottery['cqssc']}</a>
                                    <a  href="javascript:void(0)" code="tjssc" class="label ssc-label" data-code="ssclottery">${dicts.lottery.lottery['tjssc']}</a>
                                    <a  href="javascript:void(0)" code="xjssc" class="label ssc-label" data-code="ssclottery">${dicts.lottery.lottery['xjssc']}</a>
                                    <a  href="javascript:void(0)" code="ffssc" class="label ssc-label" data-code="ssclottery">${dicts.lottery.lottery['ffssc']}</a>

                                    <a  href="javascript:void(0)" code="jsk3" class="label ssc-label"   data-code="k3lottery" style="display: none">${dicts.lottery.lottery['jsk3']}</a>
                                    <a  href="javascript:void(0)" code="hbk3" class="label ssc-label" data-code="k3lottery" style="display: none">${dicts.lottery.lottery['hbk3']}</a>
                                    <a  href="javascript:void(0)" code="ahk3" class="label ssc-label" data-code="k3lottery" style="display: none">${dicts.lottery.lottery['ahk3']}</a>
                                    <a  href="javascript:void(0)" code="gxk3" class="label ssc-label" data-code="k3lottery" style="display: none">${dicts.lottery.lottery['gxk3']}</a>

                                    <a  href="javascript:void(0)" code="bjpk10" class="label ssc-label" data-code="pk10lottery" style="display: none">${dicts.lottery.lottery['bjpk10']}</a>
                                    <a  href="javascript:void(0)" code="xyft" class="label ssc-label" data-code="pk10lottery" style="display: none">${dicts.lottery.lottery['xyft']}</a>
                                    <a  href="javascript:void(0)" code="jspk10" class="label ssc-label" data-code="pk10lottery" style="display: none">${dicts.lottery.lottery['jspk10']}</a>

                                    <a  href="javascript:void(0)" code="cqxync" class="label ssc-label" data-code="sfclottery" style="display: none">${dicts.lottery.lottery['cqxync']}</a>
                                    <a  href="javascript:void(0)" code="gdkl10" class="label ssc-label" data-code="sfclottery" style="display: none">${dicts.lottery.lottery['gdkl10']}</a>

                                    <a  href="javascript:void(0)" code="hklhc" class="label ssc-label" data-code="otherlottery" style="display: none">${dicts.lottery.lottery['hklhc']}</a>
                                    <a  href="javascript:void(0)" code="xy28" class="label ssc-label" data-code="otherlottery" style="display: none">${dicts.lottery.lottery['xy28']}</a>
                                    <a  href="javascript:void(0)" code="bjkl8" class="label ssc-label" data-code="otherlottery" style="display: none">${dicts.lottery.lottery['bjkl8']}</a>
                                    <a  href="javascript:void(0)" code="fc3d" class="label ssc-label" data-code="otherlottery" style="display: none">${dicts.lottery.lottery['fc3d']}</a>
                                    <a  href="javascript:void(0)" code="tcpl3" class="label ssc-label" data-code="otherlottery" style="display: none">${dicts.lottery.lottery['tcpl3']}</a>
                                </div>
                            </div>
                            <div id="gfwfqh">
                                <div id="wfqh-btn" class="wfqh-btn" style="display: none">
                                    <a id="jdwf" class="active">信用玩法</a>
                                    <a id="gfwf" >官方玩法</a>
                                </div>
                                <div id="lot_two_menu">
                                </div>
                                <div id="lot_three_menu" class="lot_three_menu">
                                </div>
                            </div>
                            <!--表格内容-->
                            <div id="editable_wrapper" class="editable_wrapper">

                            </div>

                        </div>
                        <div class="operate-btn" id="comitBtn">
                            <soul:button cssClass="btn btn-filter btn-lg" text="确认修改" opType="function" target="saveLotteryOdd"/>
                        </div>
                    </div>

                    <div id="norecord" style="display: block">
                        <div id="" class="dataTables_wrapper" role="grid">
                            <div class="table-responsive table-min-h">
                                <table class="table table-striped table-hover dataTable m-b-sm" aria-describedby="editable_info">

                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
            </form:form>
        </div>
<soul:import res="site/lottery/odds/Index"/>