<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/include.inc.jsp" %>

<div class="mian_head">
    <div style="margin-left: 40px;margin-top: 20px">
        <h3>有效玩家存款不低于
            <span style="margin-right: 10%;">
                <input type="text" name="search.amount"　class="check-amount" style="width:80px;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" class="btn btn-primary-hide refreshQuery">
                    <i class="fa fa-refresh fa-spin"></i><spen>刷新</spen>
                </a>
            </span>
        </h3>
    </div>
</div>

<div class="mian_head2">
    <div style="margin-left: 40px;margin-top: 40px">
        <h3>玩家人数</h3>
    </div>
</div>
<div class="main_below2">
    <div style="width: 95%;height:90%; margin-top: 10px;margin-left: 40px">
        <table style="width: 97.5%; margin-top: 10px;margin-right: 0px" border="1" cellspacing="0">
            <thead style="width: 100%; margin-top: 10px;margin-left: 0px">
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <%--<th width="13%" bgcolor="#d3d3d3"  style="text-align:center;" height="70px">
                        <span data-content="当日新注册的玩家的人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">新增玩家<i class="fa fa-question-circle"></i></span>
                </th>--%>

                <th width="13%" bgcolor="#d3d3d3"  style="text-align:center;" height="70px">
                        <span data-content="当日新增的玩家的人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">新增玩家<i class="fa fa-question-circle"></i></span>
                </th>
                <th width="14%" bgcolor="#d3d3d3"  style="text-align:center;">
                        <span data-content="当日注册完成存款的人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">当日注册存款<i class="fa fa-question-circle"></i></span>
                </th>
                <th width="15%" bgcolor="#d3d3d3"  style="text-align:center;">
                        <span data-content="注册玩家后首次存入款的人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">当日首存人数<i class="fa fa-question-circle"></i></span>
                </th>
                <th width="15%" bgcolor="#d3d3d3"  style="text-align:center;">
                    总存款人数
                </th>
                <th width="15%" bgcolor="#d3d3d3"  style="text-align:center;" >
                        <span data-content="当日新增的有效玩家人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">新增有效玩家<i class="fa fa-question-circle"></i></span>
                </th>
                <th width="15%" bgcolor="#d3d3d3"  style="text-align:center;" >
                        <span data-content="当日有效玩家人数" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">总有效玩家人数<i class="fa fa-question-circle"></i></span>
                </th>
            </tr>
            </thead>
            <tbody>
                <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                    <th style='text-align:center;' height='50px'><div id="agent_add_num">0</div></th>
                    <th style='text-align:center;'><div id="today_register_deposit_num">0</div></th>
                    <th style='text-align:center;'><div id="today_frist_deposit_num">0</div></th>
                    <th style='text-align:center;'><div class="co-red3" id="total_deposit_num">0</div></th>
                    <th style='text-align:center;'><div id="add_effective_num">0</div></th>
                    <th style='text-align:center;'><div class="co-red3" id="total_effective_num">0</div></th>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="mian_head2">
    <div style="margin-left: 40px;margin-top: 20px;">
        <h3>存取数据</h3>
    </div>
</div>
<div class="main_below3">
    <div style="width: 95%;height:90%; margin-top: 10px;margin-left: 40px">
        <table style="width: 97.5%; margin-top: 10px;margin-right: 0px" border="1" cellspacing="0">
            <thead style="width: 100%; margin-top: 10px;margin-left: 0px">
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <th width="15%" rowspan="2" bgcolor="#d3d3d3" style="text-align:center;" height="70px">
                    <span data-content="当日首存的金额" style="background-color:#d3d3d3"
                          data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                          role="button" class="input-group-addon help-popover" tabindex="0"
                          data-original-title="" title="">首存金额<i class="fa fa-question-circle"></i>
                    </span>
                </th>

                <th width="14%" bgcolor="#d3d3d3" style="text-align:center;" rowspan="2">
                    <span data-content="指玩家所有优惠金额" style="background-color:#d3d3d3"
                          data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                          role="button" class="input-group-addon help-popover" tabindex="0"
                          data-original-title="" title="">优惠<i class="fa fa-question-circle"></i>
                    </span>
                </th>

                <th width="45%" colspan="3" bgcolor="#d3d3d3" style="text-align:center;"><div id="deposit_amount">存款金额(<span class="co-red3">0</span>元)</div></th>

                <th width="25%" colspan="2" bgcolor="#d3d3d3" style="text-align:center;"><div id="withdraw_amount">取款金额(<span class="co-red3">0</span>元)</div></th>

                <th width="15%" rowspan="2" bgcolor="#d3d3d3" style="text-align:center;">
                    <span data-content="存取差" style="background-color:#d3d3d3"
                          data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                          role="button" class="input-group-addon help-popover" tabindex="0"
                          data-original-title="" title="">存取差<i class="fa fa-question-circle"></i>
                    </span>
                </th>
            </tr>
            <tr>
                <th bgcolor="#d3d3d3" style="text-align:center;">公司入款</th>
                <th bgcolor="#d3d3d3" style="text-align:center;">线上支付</th>
                <th bgcolor="#d3d3d3" style="text-align:center;">系统存款</th>
                <th bgcolor="#d3d3d3" style="text-align:center;">系统取款</th>
                <th bgcolor="#d3d3d3" style="text-align:center;">玩家取款</th>
            </tr>
            </thead>
            <tbody>
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <th style="text-align:center;" height="70px"><div id="first_deposit_amount">0</div></th>
                <th style="text-align:center;"><div id="favourable_amount">0</div></th>
                <th style="text-align:center;"><div id="company_deposit_amount">0</div></th>
                <th style="text-align:center;"><div id="online_pay_deposit_amount">0</div></th>
                <th style="text-align:center;"><div id="system_deposit_amount">0</div></th>
                <th style="text-align:center;"><div id="system_withdraw_amount">0</div></th>
                <th style="text-align:center;"><div id="player_withdraw_amount">0</div></th>
                <th style="text-align:center;"><div id="deposit_differ_withraw_amount">0</div></th>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="main_below4">
    <div style="width: 95%;height:90%; margin-top: 10px;margin-left: 40px">
        <table style="width: 97.5%; margin-top: 10px;margin-right: 0px" border="1" cellspacing="0">
            <thead style="width: 100%; margin-top: 20px;margin-left: 0px">
            <tr style="width: 100%; margin-left: 0px">
                <th colspan='3' width='30%' bgcolor='#d3d3d3' style='text-align:center;' height='35px'><div id="deposit_count">存款笔数(<span class="co-red3">0</span>笔)</div></th>
                <th colspan='3' width='30%' bgcolor='#d3d3d3' style='text-align:center;'><div id="deposit_num">存款人数(<span class="co-red3">0</span>人)</div></th>
                <th colspan='2' width='20%' bgcolor='#d3d3d3' style='text-align:center;'><div id="withdraw_count">取款笔数(<span class="co-red3">0</span>笔)</div></th>
                <th colspan='2' width='20%' bgcolor='#d3d3d3' style='text-align:center;' ><div id="withdraw_num">取款人数(<span class="co-red3">0</span>人)</div></th>　　　　
            </tr>
            <tr>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" height="35px">公司入款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >线上支付</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >系统存款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >公司入款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >线上支付</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >系统存款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >系统取款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >玩家取款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >系统取款</th>
                <th width="10%" bgcolor="#d3d3d3" style="text-align:center;" >玩家取款</th>
            </tr>
            </thead>
            <tbody>
            <tr style="width: 100%; margin-left: 0px">
                <th style="text-align:center;" height="70px"><div id="company_deposit_count">0</div></th>
                <th style="text-align:center;"><div id="online_pay_deposit_count">0</div></th>
                <th style="text-align:center;"><div id="system_deposit_count">0</div></th>
                <th style="text-align:center;"><div id="company_deposit_num">0</div></th>
                <th style="text-align:center;"><div id="online_pay_deposit_num">0</div></th>
                <th style="text-align:center;"><div id="system_deposit_num">0</div></th>
                <th style="text-align:center;"><div id="system_withdraw_count">0</div></th>
                <th style="text-align:center;"><div id="player_withdraw_count">0</div></th>
                <th style="text-align:center;"><div id="system_withdraw_num">0</div></th>
                <th style="text-align:center;"><div id="player_withdraw_num">0</div></th>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="mian_head5">
    <div style="margin-left: 40px;margin-top: 20px;">
        <h3>游戏数据</h3>
    </div>
</div>
<div class="main_below5">
    <div style="width: 95%;height:90%; margin-top: 10px;margin-left: 40px">
        <table style="width: 97.5%; margin-top: 10px;margin-right: 0px" border="1" cellspacing="0">
            <thead style="width: 100%; margin-top: 10px;margin-left: 0px">
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <th width="14%" bgcolor="#d3d3d3"  style="text-align:center;" height="70px">
                    投注人数
                </th>
                <th width="14%" bgcolor="#d3d3d3"  style="text-align:center;" height="70px">
                        <span data-content="指所有玩家投注金额之和" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">总投注金额<i class="fa fa-question-circle"></i></span>
                </th>
                <th width="15%" bgcolor="#d3d3d3" style="text-align:center;">
                        <span data-content="有效投注=投注金额-返点金额(PK10牛牛--牛牛翻倍玩法,未中奖的有效投注金额=投注金额-派彩金额)" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">总有效投注金额<i class="fa fa-question-circle"></i></span></th>
                <th width="15%" bgcolor="#d3d3d3" style="text-align:center;">
                        <span data-content="只统计今日正式玩家" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">返点金额<i class="fa fa-question-circle"></i></span>
                </th>

                <th width="15%" bgcolor="#d3d3d3" style="text-align:center;">
                          <span data-content="游戏总的派彩" style="background-color:#d3d3d3"
                                data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                                role="button" class="input-group-addon help-popover" tabindex="0"
                                data-original-title="" title="">总派彩金额<i class="fa fa-question-circle"></i></span>
                </th>

                <th width="14%" bgcolor="#d3d3d3" style="text-align:center;">
                        <span data-content="正数表示玩家盈利，负数表示玩家亏损" style="background-color:#d3d3d3"
                              data-placement="top" data-trigger="focus" data-toggle="popover" data-container="body"
                              role="button" class="input-group-addon help-popover" tabindex="0"
                              data-original-title="" title="">盈亏<i class="fa fa-question-circle"></i></span>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr style="width: 100%; margin-top: 10px;margin-left: 0px">
                <th style="text-align:center;" height="50px"><div class="co-red3" id="lottery_bet_num">0</div></th>
                <th style="text-align:center;"><div id="total_lottery_bet_amount">0</div></th>
                <th style="text-align:center;"><div id="total_effective_amount">0</div></th>
                <th style="text-align:center;"><div id="rebate_amount">0</div></th>
                <th style="text-align:center;"><div id="pay_out_amount">0</div></th>
                <th style="text-align:center;"><div id="profit_amount">0</div></th>
            </tr>
            </tbody>
        </table>
    </div>
</div>


