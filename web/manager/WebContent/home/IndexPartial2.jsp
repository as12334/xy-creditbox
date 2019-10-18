<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>
<div class="mian_head">
    <div style="margin-left: 40px;margin-top: 10px">
        <h3>
            <span class="pull-right" style="margin-right: 5%;margin-top: 10px;">
                <span data-content="${userType eq "2" or userType eq "21"?"本站所有玩家的余额总计":"该总代下所有玩家的余额总计"}" data-placement="top" data-trigger="focus"
                      data-toggle="popover" data-container="body" role="button" class="co-blue help-popover"
                      tabindex="0" data-original-title="" title="">
                    <i class="fa fa-question-circle"></i>
                </span>
                总余额：<span class="total_assets" style="color: red;">0.000</span>&nbsp;<span>元</span>
            </span>
        </h3>
    </div>
</div>

<div class="mian_head">
    <div style="margin-left: 40px;margin-top: 30px;">
        <h3>运营状况</h3>
    </div>
</div>
<div class="main_below">
    <div style="width: 95%;height:90%; margin-top: 10px;margin-left: 40px">
        <table style="width: 97.5%; margin-top: 10px;margin-right: 0px" border="1" cellspacing="0">
            <thead style="width: 100%; margin-top: 10px;margin-left: 0px">
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <th rowspan="2"  width="5%" bgcolor="#d3d3d3"  style="text-align:center;" height="50px">
                        <span data-content="本周和本月数据不包括今日数据" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">日期<i class="fa fa-question-circle"></i></span>
                </th>
                <th colspan="3" width="25%" bgcolor="#d3d3d3"  style="text-align:center;" >新增玩家</th>
                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                        <span data-content="包括公司入款，线上支付和系统存款" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">存款金额(￥)<i class="fa fa-question-circle"></i></span></th>
                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                        <span data-content="包括玩家取款和系统取款" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">取款金额(￥)<i class="fa fa-question-circle"></i></span>
                </th>
                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                          <span data-content="指玩家所有优惠金额" style="background-color:#d3d3d3"
                                data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                                role="button" class="input-group-addon help-popover" tabindex="0"
                                data-original-title="" title="">优惠金额(￥)<i class="fa fa-question-circle"></i></span>
                </th>

                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                          <span data-content="指所有投注玩家" style="background-color:#d3d3d3"
                                data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                                role="button" class="input-group-addon help-popover" tabindex="0"
                                data-original-title="" title="">投注人数(个)<i class="fa fa-question-circle"></i></span>
                </th>
                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                          <span style="background-color:#d3d3d3"
                                data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                                role="button" class="input-group-addon help-popover" tabindex="0"
                                data-original-title="" title="">总派彩金额(￥)</span>
                </th>

                <th rowspan="2" width="15%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                         <span data-content="有效投注=投注金额-返点金额(PK10牛牛--牛牛翻倍玩法,未中奖的有效投注金额=投注金额-派彩金额)" style="background-color:#d3d3d3"
                               data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                               role="button" class="input-group-addon help-popover" tabindex="0"
                               data-original-title="" title="">有效投注金额(￥)<i class="fa fa-question-circle"></i></span>
                </th>
                <th rowspan="2" width="10%" bgcolor="#d3d3d3" style="text-align:center;" height="50px">
                        <span data-content="盈亏金额=有效投注金额-派彩金额" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">盈亏金额(￥)<i class="fa fa-question-circle"></i></span>
                </th>
            </tr>
            <tr>
                <th bgcolor="#d3d3d3" style="text-align:center;" >
                        <span data-content="" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">玩家人数<i class=""></i></span>
                </th>
                <th bgcolor="#d3d3d3" style="text-align:center;">存款人数</th>
                <th bgcolor="#d3d3d3" style="text-align:center;">存款金额(￥)</th>
            </tr>
            </thead>
            <tbody>
            <tr id="yesToday"></tr>
            <tr id="thisWeek"></tr>
            <tr id="lastWeek"></tr>
            <tr id="thisMonth"></tr>
            </tbody>
        </table>
    </div>
</div>

<div class="main_top">
    <div class="main_div_left">
        <div id="report_player" style="width: 90%;height:90%; margin-top: 10px;margin-left: 40px"></div>

    </div>
    <div class="main_div_right">
        <div id="report_game" style="width: 90%;height:80%; margin-top: 10px"></div>
        <div class="days"  style="width: 90%;height:10%;background-color:#FFFFFF ">
            <button class="button1" style="background-color: #f2f2f2"><span id="stat-day6"/></button>
            <button class="button2" style="background-color: #f2f2f2"><span id="stat-day5"/></button>
            <button class="button3" style="background-color: #f2f2f2"><span id="stat-day4"/></button>
            <button class="button4" style="background-color: #f2f2f2"><span id="stat-day3"/></button>
            <button class="button5" style="background-color: #f2f2f2"><span id="stat-day2"/></button>
            <button class="button6" style="background-color: #f2f2f2"><span id="stat-day1"/></button>
            <button class="button7" style="background-color: #f2f2f2"><span id="stat-day0"/></button>
        </div>
    </div>
</div>
<div class="main_mid">
    <div class="main_div_left">
        <div id="report_deposit" style="width: 90%;height:90%; margin-top: 10px;margin-left: 40px"></div>
    </div>
    <div class="main_div_right">
        <div id="report_withdraw" style="width: 90%;height:90%; margin-top: 10px"></div>
    </div>
</div>


