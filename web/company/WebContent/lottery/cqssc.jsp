<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<%--@elvariable id="command" type="so.wwb.creditbox.model.company.user.vo.VSiteUserVo"--%>
<%--@elvariable id="userTypeEnum" type="so.wwb.creditbox.model.enums.user.UserTypeEnum"--%>

<!--//region your codes 1-->

<!--//endregion your codes 1-->

<form:form method="post" id="edidOddForm">
    <div class="widthAuto">
        <div class="shell-top" id="shell_top">
            <div class="shell-top-left"></div>
            <div class="shell-title-icon">
                <span id="shell_title">賠率設置 [<span class="blue">總監:zj01</span>]</span>
            </div>
            <div class="shell-top-right"></div>
            <div id="title-nav" class="title-nav-right"><select data-id="gameIndex">
                <option value="2">廣東快樂十分</option>
                <option value="3">重慶時時彩</option>
                <option value="4">北京賽車(PK10)</option>
                <option value="6">北京快樂8</option>
                <option value="7">重慶幸運農場</option>
                <option value="8">幸運飛艇</option>
                <option value="14">极速賽車</option>
                <option value="15">极速時時彩</option>
            </select></div>
        </div>
        <div class="shell-middle-left">
            <div class="shell-middle-right">
                <div class="shell-middle" id="middleContent">
                    <div id="load-middle" class="acion" style="display: none;">
                        <div id="load-userrebate-game-kc">
                            <table class="t_list" style="margin-bottom:3px">
                                <tbody class="list_hover">
                                <tr class="tractive">
                                    <td width="130">退水微調</td>
                                    <td width="150"><em class="addBtns"></em><i class="minBtns"></i><input type="text"
                                                                                                           value="0.1"
                                                                                                           id="kc_plwt"
                                                                                                           class="text zk plNumber w80">
                                    </td>
                                    <td style="text-align:left;padding-left:5px;">在這裏對全局退水進行統壹微調</td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="t_list">
                                <tbody>
                                <tr>
                                    <th colspan="8">大項快速設置【<b class="red">註意：設置高於上級最高限制時按最高可調</b>】</th>
                                </tr>
                                <tr>
                                    <td class="tdbg1">調整項目</td>
                                    <td class="tdbg1" style="">A盤</td>
                                    <td class="tdbg1" style="">B盤</td>
                                    <td class="tdbg1" style="">C盤</td>
                                    <td class="tdbg1">單注限額</td>
                                    <td class="tdbg1">單期限額</td>
                                    <td class="tdbg1">最小單注</td>
                                    <td class="tdbg1">操作</td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>特碼類(第一球、第二球、冠軍 …)</td>
                                    <td style=""><label class="lBg1"></label><input type="text" name="tm_pk_a"
                                                                                    id="tm_pk_a" data-a=""
                                                                                    class="text zk plNumber w80"
                                                                                    value="100"></td>
                                    <td style=""><input type="text" name="tm_pk_b" id="tm_pk_b" data-b=""
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="tm_pk_c" data-c="" id="tm_pk_c"
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="tm_max_amount" data-e="" id="tm_max_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="tm_phase_amount" data-f="" id="tm_phase_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="tm_single_min_amount" data-d=""
                                               id="tm_single_min_amount" class="text zk onlyNum w80" value="0"></td>
                                    <td><label class="lBg1"></label>
                                        <button type="button" name="btnTM" id="btnTM" data-sid="1"
                                                class="btn btntb btnBS">修改
                                        </button>
                                    </td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>兩面類(單雙、大小、龍虎 …)</td>
                                    <td style=""><label class="lBg2"></label><input type="text" name="lmp_pk_a"
                                                                                    id="lmp_pk_a" data-a=""
                                                                                    class="text zk plNumber w80"
                                                                                    value="100"></td>
                                    <td style=""><input type="text" name="lmp_pk_b" id="lmp_pk_b" data-b=""
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="lmp_pk_c" data-c="" id="lmp_pk_c"
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="lmp_max_amount" data-e="" id="lmp_max_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lmp_phase_amount" data-f="" id="lmp_phase_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lmp_single_min_amount" data-d=""
                                               id="lmp_single_min_amount" class="text zk onlyNum w80" value="0"></td>
                                    <td><label class="lBg2"></label>
                                        <button type="button" name="btnLMP" id="btnLMP" data-sid="2"
                                                class="btn btntb btnBS">修改
                                        </button>
                                    </td>
                                </tr>
                                </tbody>
                                <tbody class="list_hover">
                                <tr style="" class="">
                                    <td>連碼類(任選二、任選三 …)</td>
                                    <td style=""><label class="lBg3"></label><input type="text" name="lm_pk_a"
                                                                                    id="lm_pk_a" data-a=""
                                                                                    class="text zk plNumber w80"
                                                                                    value="100"></td>
                                    <td style=""><input type="text" name="lm_pk_b" id="lm_pk_b" data-b=""
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td style=""><input type="text" name="lm_pk_c" data-c="" id="lm_pk_c"
                                                        class="text zk plNumber w80" value="100"></td>
                                    <td><input type="text" name="lm_max_amount" data-e="" id="lm_max_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lm_phase_amount" data-f="" id="lm_phase_amount"
                                               class="text zk onlyNum w80" value="500000"></td>
                                    <td><input type="text" name="lm_single_min_amount" data-d=""
                                               id="lm_single_min_amount" class="text zk onlyNum w80" value="0"></td>
                                    <td><label class="lBg3"></label>
                                        <button type="button" name="btnLM" id="btnLM" data-sid="3"
                                                class="btn btntb btnBS">修改
                                        </button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="middle-table" id="kj">
                                <tfoot>
                                <tr>
                                    <td colspan="6" style="height:30px;"><span class="text-btn"
                                                                               id="submit">保存設置</span><span
                                            class="text-btn" id="gopart">送出</span></td>
                                </tr>
                                </tfoot>
                            </table>
                            <table border="0" cellpadding="0" cellspacing="0" width="100%" name="data-content">
                                <thead>
                                <tr>
                                    <td>
                                        <div data-close="0" data-index="klc" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>廣東快樂十分</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1" class="">
                                                        <td class="bc"><label class="lBg1"></label>1-8單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>1-8兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>1-8方位</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>1-8中發白</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>1-4龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>正碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="7">
                                                        <td class="bc"><label class="lBg2"></label>總和兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="7" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="8">
                                                        <td class="bc"><label class="lBg3"></label>任選二</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="8" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="9">
                                                        <td class="bc"><label class="lBg3"></label>選二連直</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="9" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="10">
                                                        <td class="bc"><label class="lBg3"></label>選二連組</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="10" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="10" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="10" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="11">
                                                        <td class="bc"><label class="lBg3"></label>任選三</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="11" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="11" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="11" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="12">
                                                        <td class="bc"><label class="lBg3"></label>選三前組</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="12" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="12" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="12" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="13">
                                                        <td class="bc"><label class="lBg3"></label>任選四</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="13" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="13" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="13" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="14">
                                                        <td class="bc"><label class="lBg3"></label>任選五</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="14" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="14" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="14" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="ssc" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>重慶時時彩</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-5單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4" class="">
                                                        <td class="bc"><label class="lBg2"></label>和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>豹子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>順子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="7">
                                                        <td class="bc"><label class="lBg2"></label>對子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="7" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="8">
                                                        <td class="bc"><label class="lBg2"></label>半順</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="8" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="9">
                                                        <td class="bc"><label class="lBg2"></label>雜六</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="9" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="sscjs" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>极速時時彩</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-5單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>豹子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>順子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="7">
                                                        <td class="bc"><label class="lBg2"></label>對子</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="7" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="8">
                                                        <td class="bc"><label class="lBg2"></label>半順</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="8" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="9">
                                                        <td class="bc"><label class="lBg2"></label>雜六</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="9" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="pk" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>北京賽車(PK10)</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-10單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>1-10兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>1-5龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和大小</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和單雙</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="pkjs" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>极速賽車</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-10單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>1-10兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>1-5龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和大小</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和單雙</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="klb" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>北京快樂8</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="1">
                                                        <td class="bc"><label class="lBg2"></label>正碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>總和大小</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>總和單雙</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>總和和局</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>總和過關</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>前後和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="7">
                                                        <td class="bc"><label class="lBg2"></label>單雙和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="7" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="8">
                                                        <td class="bc"><label class="lBg2"></label>五行</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="8" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="nc" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>重慶幸運農場</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-8單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>1-8兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>1-8東南西北</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>1-8中發白</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>1-4龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>正碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="7">
                                                        <td class="bc"><label class="lBg2"></label>總和兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="7" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="7" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="7"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="8">
                                                        <td class="bc"><label class="lBg3"></label>任選二</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="8" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="8" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="8"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="9">
                                                        <td class="bc"><label class="lBg3"></label>選二連直</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="9" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="9" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="9"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="10">
                                                        <td class="bc"><label class="lBg3"></label>選二連組</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="10" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="10" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="10" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="10"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="11">
                                                        <td class="bc"><label class="lBg3"></label>任選三</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="11" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="11" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="11" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="11"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="12">
                                                        <td class="bc"><label class="lBg3"></label>選三前組</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="12" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="12" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="12" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="12"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="13">
                                                        <td class="bc"><label class="lBg3"></label>任選四</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="13" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="13" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="13" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="13"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="3" data-sort="14">
                                                        <td class="bc"><label class="lBg3"></label>任選五</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="14" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="14" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="14" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="14"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div data-close="0" data-index="ft" class="acion" style="display: none;">
                                            <table class="middle-table">
                                                <thead>
                                                <tr>
                                                    <th>幸運飛艇</th>
                                                </tr>
                                                </thead>
                                            </table>
                                            <div style="float:left;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="1" data-sort="1">
                                                        <td class="bc"><label class="lBg1"></label>1-10單碼</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="1" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="1" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="1"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="2">
                                                        <td class="bc"><label class="lBg2"></label>1-10兩面</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="2" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="2" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="2"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="3">
                                                        <td class="bc"><label class="lBg2"></label>1-5龍虎</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="3" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="3" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="3"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                            <div style="float:right;width:49.9%">
                                                <table class="middle-table bor-top">
                                                    <tbody>
                                                    <tr class="bc">
                                                        <td class="w15">類型</td>
                                                        <td>單註最低</td>
                                                        <td>單註最高</td>
                                                        <td>單項最高</td>
                                                        <td>A盤</td>
                                                        <td>B盤</td>
                                                        <td>C盤</td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="4">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和大小</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="4" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="4" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="4"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="5">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和單雙</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="5" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="5" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="5"
                                                                   value="100"></td>
                                                    </tr>
                                                    <tr data-sid="2" data-sort="6">
                                                        <td class="bc"><label class="lBg2"></label>冠亞和</td>
                                                        <td><input type="text" data-d="" class="text-input sw70"
                                                                   data-number="" maxlength="3" data-maxvalue="100"
                                                                   data-minvalue="0" data-sort="6" value="0"></td>
                                                        <td><input type="text" data-e="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-f="" class="text-input sw70"
                                                                   data-number="" maxlength="7" data-maxvalue="500000"
                                                                   data-minvalue="0" data-sort="6" value="500000"></td>
                                                        <td><input type="text" data-a="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-b="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                        <td><input type="text" data-c="" class="text-input sw50"
                                                                   data-numbertodouble="" maxlength="5"
                                                                   data-maxvalue="100" data-minvalue="0" data-sort="6"
                                                                   value="100"></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <div id="game_2_1" class="acion game-heiht" style="display: none;">
                        <div id="game-data">
                            <table style="width:100%;" border="0" cellpadding="0" cellspacing="0">
                                <thead>
                                <tr>
                                    <td>
                                        <div style="float:left;width:75.5%;" id="game-row">
                                            <div style="float:left;width:33.3%;" name="game-row">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th class="w15">號碼</th>
                                                        <th class="w30">賠率</th>
                                                        <th class="w20">註額</th>
                                                        <th class="w20">盈虧</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr data-sort="1" data-type="第一球" data-name="01"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">01</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="2" data-type="第一球" data-name="02"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">02</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="3" data-type="第一球" data-name="03"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">03</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="4" data-type="第一球" data-name="04"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">04</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="5" data-type="第一球" data-name="05"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">05</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="6" data-type="第一球" data-name="06"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">06</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="7" data-type="第一球" data-name="07"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">07</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="8" data-type="第一球" data-name="08"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">08</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="9" data-type="第一球" data-name="09"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">09</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="10" data-type="第一球" data-name="10"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc bold blue">10</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="11" data-type="第一球" data-name="11"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">11</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="12" data-type="第一球" data-name="12"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">12</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="13" data-type="第一球" data-name="13"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">13</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="14" data-type="第一球" data-name="14"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">14</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="15" data-type="第一球" data-name="15"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">15</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="16" data-type="第一球" data-name="16"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">16</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="17" data-type="第一球" data-name="17"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">17</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="18" data-type="第一球" data-name="18"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold blue">18</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="19" data-type="第一球" data-name="19"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold red">19</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="20" data-type="第一球" data-name="20"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold red">20</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">19.64</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="float:left;width:33.3%;" id="fz-sort">
                                                <table class="middle-table bor-left">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="4">虧損額負值排列</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr data-sort="1" data-type="第一球" data-name="01"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">01</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="2" data-type="第一球" data-name="02"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">02</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="3" data-type="第一球" data-name="03"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">03</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="4" data-type="第一球" data-name="04"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">04</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="5" data-type="第一球" data-name="05"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">05</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="6" data-type="第一球" data-name="06"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">06</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="7" data-type="第一球" data-name="07"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">07</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="8" data-type="第一球" data-name="08"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">08</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="9" data-type="第一球" data-name="09"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">09</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="10" data-type="第一球" data-name="10"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">10</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="11" data-type="第一球" data-name="11"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">11</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="12" data-type="第一球" data-name="12"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">12</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="13" data-type="第一球" data-name="13"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">13</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="14" data-type="第一球" data-name="14"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">14</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="15" data-type="第一球" data-name="15"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">15</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="16" data-type="第一球" data-name="16"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">16</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="17" data-type="第一球" data-name="17"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">17</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="18" data-type="第一球" data-name="18"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 blue">18</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="19" data-type="第一球" data-name="19"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 red">19</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="20" data-type="第一球" data-name="20"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc bold w15 red">20</td>
                                                        <td class="w30 qhs"><a class="line1 sup-line">19.64</a></td>
                                                        <td class="w20 qhs"><a class="line2 sup-line cursor">-</a></td>
                                                        <td class="w20 qhs"><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="float:left;width:33.3%;" name="game-row">
                                                <table class="middle-table bor-left">
                                                    <thead>
                                                    <tr>
                                                        <th class="w15">號碼</th>
                                                        <th class="w30">賠率</th>
                                                        <th class="w20">註額</th>
                                                        <th class="w20">盈虧</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr data-sort="21" data-type="第一球" data-name="單"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">單</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="22" data-type="第一球" data-name="雙"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">雙</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="23" data-type="第一球" data-name="大"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">大</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="24" data-type="第一球" data-name="小"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">小</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="25" data-type="第一球" data-name="合單"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">合單</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="26" data-type="第一球" data-name="合雙"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">合雙</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="27" data-type="第一球" data-name="尾大"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc">尾大</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="28" data-type="第一球" data-name="尾小"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc">尾小</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="29" data-type="第一球" data-name="東"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc">東</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3.75</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="30" data-type="第一球" data-name="南"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc">南</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3.75</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="31" data-type="第一球" data-name="西"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                        class="">
                                                        <td class="bc">西</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3.75</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="32" data-type="第一球" data-name="北"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">北</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3.75</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="33" data-type="第一球" data-name="中"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">中</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="34" data-type="第一球" data-name="發"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">發</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">3</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="35" data-type="第一球" data-name="白"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">白</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.9</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="36" data-type="第一球" data-name="龍"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">龍</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="37" data-type="第一球" data-name="虎"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">虎</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="float:left;width:33.3%;" id="total_tongji"><p>總投註額：<b
                                                    class="green">0</b></p>
                                                <p>最高虧損：<b class="red">0</b></p>
                                                <p>最高盈利：<b>0</b></p></div>
                                        </div>
                                        <div style="float:right;width:24.2%;">
                                            <div style="float:left;width:50%;">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th class="txt-left">&nbsp;總註額:<span id="count-bt"
                                                                                             class="green">0</span></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="count-ary">
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="1">第一球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="2">第二球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="3">第三球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="4">第四球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="5">第五球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="6">第六球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="7">第七球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="8">第八球
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="9">正&nbsp;碼&nbsp;&nbsp;
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="9">總&nbsp;和&nbsp;&nbsp;
                                                            總:<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">任&nbsp;選&nbsp;二:&nbsp;&nbsp;<span
                                                                class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">
                                                            選二連直:&nbsp;<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">
                                                            選二連組:&nbsp;<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">任&nbsp;選&nbsp;三:&nbsp;&nbsp;<span
                                                                class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">
                                                            選三前組:&nbsp;<span class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">任&nbsp;選四&nbsp;:&nbsp;&nbsp;<span
                                                                class="green">0</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left cursor" my-type="10">任&nbsp;選&nbsp;五:&nbsp;&nbsp;<span
                                                                class="green">0</span></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="float:left;width:15%;margin-left:5px;">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="2">遺漏</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="yl-count">
                                                    <tr>
                                                        <td class="w50 bold fhs">01</td>
                                                        <td class="w50" index="1">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">02</td>
                                                        <td class="w50" index="2">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">03</td>
                                                        <td class="w50" index="3">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">04</td>
                                                        <td class="w50" index="4">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">05</td>
                                                        <td class="w50" index="5">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">06</td>
                                                        <td class="w50" index="6">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">07</td>
                                                        <td class="w50" index="7">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">08</td>
                                                        <td class="w50" index="8">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">09</td>
                                                        <td class="w50" index="9">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">10</td>
                                                        <td class="w50" index="10">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">11</td>
                                                        <td class="w50" index="11">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">12</td>
                                                        <td class="w50" index="12">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">13</td>
                                                        <td class="w50" index="13">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">14</td>
                                                        <td class="w50" index="14">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">15</td>
                                                        <td class="w50" index="15">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">16</td>
                                                        <td class="w50" index="16">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">17</td>
                                                        <td class="w50" index="17">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">18</td>
                                                        <td class="w50" index="18">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">19</td>
                                                        <td class="w50" index="19">0</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="w50 bold fhs">20</td>
                                                        <td class="w50" index="20">0</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div style="float:right;width:33%;">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="2">兩面長龍排行</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="cl-count">
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第2球 龍</td>
                                                        <td class="fff red">6期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第1球 小</td>
                                                        <td class="fff red">5期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第8球 單</td>
                                                        <td class="fff red">5期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第6球 尾小</td>
                                                        <td class="fff red">4期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第2球 合雙</td>
                                                        <td class="fff red">3期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第4球 尾大</td>
                                                        <td class="fff red">3期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第4球 虎</td>
                                                        <td class="fff red">3期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第5球 大</td>
                                                        <td class="fff red">3期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">總和 單</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第1球 單</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第1球 合單</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第1球 尾大</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第2球 大</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第3球 雙</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第3球 小</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第4球 小</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第5球 尾小</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第6球 雙</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第6球 小</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第7球 合雙</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第8球 尾小</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <div id="game_3_1" class="acion game-heiht" style="display: none;">
                        <div id="game-data">
                            <table style="width:100%;" border="0" cellpadding="0" cellspacing="0">
                                <thead>
                                <tr>
                                    <td>
                                        <div style="float:left;width:93%;" id="game-row">
                                            <div style="float:left;width:75%;">
                                                <div style="float:left;width:33%;" name="game-row">
                                                    <table class="middle-table">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="4">第一球</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="w15 bc">號碼</td>
                                                            <td class="w30 bc">賠率</td>
                                                            <td class="w20 bc">註額</td>
                                                            <td class="w20 bc">盈虧</td>
                                                        </tr>
                                                        <tr data-sort="1" data-type="第一球" data-name="0"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">0</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="2" data-type="第一球" data-name="1"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">1</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="3" data-type="第一球" data-name="2"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">2</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="4" data-type="第一球" data-name="3"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">3</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="5" data-type="第一球" data-name="4"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">4</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="6" data-type="第一球" data-name="5"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">5</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="7" data-type="第一球" data-name="6"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">6</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="8" data-type="第一球" data-name="7"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">7</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="9" data-type="第一球" data-name="8"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">8</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="10" data-type="第一球" data-name="9"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">9</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="11" data-type="第一球" data-name="單"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">單</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="12" data-type="第一球" data-name="雙"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">雙</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="13" data-type="第一球" data-name="大"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">大</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="14" data-type="第一球" data-name="小"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">小</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="float:left;width:0.3%">&nbsp;</div>
                                                <div style="float:left;width:33%;" name="game-row">
                                                    <table class="middle-table">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="4">第二球</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="w15 bc">號碼</td>
                                                            <td class="w30 bc">賠率</td>
                                                            <td class="w20 bc">註額</td>
                                                            <td class="w20 bc">盈虧</td>
                                                        </tr>
                                                        <tr data-sort="15" data-type="第二球" data-name="0"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">0</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="16" data-type="第二球" data-name="1"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">1</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="17" data-type="第二球" data-name="2"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">2</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="18" data-type="第二球" data-name="3"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">3</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="19" data-type="第二球" data-name="4"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">4</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="20" data-type="第二球" data-name="5"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">5</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="21" data-type="第二球" data-name="6"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">6</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="22" data-type="第二球" data-name="7"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">7</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="23" data-type="第二球" data-name="8"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">8</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="24" data-type="第二球" data-name="9"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">9</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="25" data-type="第二球" data-name="單"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">單</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="26" data-type="第二球" data-name="雙"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">雙</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="27" data-type="第二球" data-name="大"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">大</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="28" data-type="第二球" data-name="小"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">小</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="float:left;width:0.3%">&nbsp;</div>
                                                <div style="float:left;width:33%;" name="game-row">
                                                    <table class="middle-table">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="4">第三球</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="w15 bc">號碼</td>
                                                            <td class="w30 bc">賠率</td>
                                                            <td class="w20 bc">註額</td>
                                                            <td class="w20 bc">盈虧</td>
                                                        </tr>
                                                        <tr data-sort="29" data-type="第三球" data-name="0"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">0</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="30" data-type="第三球" data-name="1"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">1</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="31" data-type="第三球" data-name="2"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">2</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="32" data-type="第三球" data-name="3"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">3</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="33" data-type="第三球" data-name="4"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">4</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="34" data-type="第三球" data-name="5"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">5</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="35" data-type="第三球" data-name="6"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">6</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="36" data-type="第三球" data-name="7"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">7</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="37" data-type="第三球" data-name="8"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">8</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="38" data-type="第三球" data-name="9"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc bold">9</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="39" data-type="第三球" data-name="單"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc ">單</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="40" data-type="第三球" data-name="雙"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc ">雙</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="41" data-type="第三球" data-name="大"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc ">大</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="42" data-type="第三球" data-name="小"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)"
                                                            class="">
                                                            <td class="bc ">小</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="float:left;width:33%;" name="game-row">
                                                    <div class="clear"></div>
                                                    <table class="middle-table">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="4">第四球</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="w15 bc">號碼</td>
                                                            <td class="w30 bc">賠率</td>
                                                            <td class="w20 bc">註額</td>
                                                            <td class="w20 bc">盈虧</td>
                                                        </tr>
                                                        <tr data-sort="43" data-type="第四球" data-name="0"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">0</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="44" data-type="第四球" data-name="1"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">1</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="45" data-type="第四球" data-name="2"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">2</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="46" data-type="第四球" data-name="3"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">3</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="47" data-type="第四球" data-name="4"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">4</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="48" data-type="第四球" data-name="5"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">5</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="49" data-type="第四球" data-name="6"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">6</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="50" data-type="第四球" data-name="7"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">7</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="51" data-type="第四球" data-name="8"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">8</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="52" data-type="第四球" data-name="9"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">9</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="53" data-type="第四球" data-name="單"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">單</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="54" data-type="第四球" data-name="雙"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">雙</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="55" data-type="第四球" data-name="大"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">大</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="56" data-type="第四球" data-name="小"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">小</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="float:left;width:0.3%">&nbsp;</div>
                                                <div style="float:left;width:33%;" name="game-row">
                                                    <div class="clear"></div>
                                                    <table class="middle-table">
                                                        <thead>
                                                        <tr>
                                                            <th colspan="4">第五球</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="w15 bc">號碼</td>
                                                            <td class="w30 bc">賠率</td>
                                                            <td class="w20 bc">註額</td>
                                                            <td class="w20 bc">盈虧</td>
                                                        </tr>
                                                        <tr data-sort="57" data-type="第五球" data-name="0"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">0</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="58" data-type="第五球" data-name="1"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">1</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="59" data-type="第五球" data-name="2"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">2</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="60" data-type="第五球" data-name="3"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">3</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="61" data-type="第五球" data-name="4"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">4</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="62" data-type="第五球" data-name="5"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">5</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="63" data-type="第五球" data-name="6"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">6</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="64" data-type="第五球" data-name="7"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">7</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="65" data-type="第五球" data-name="8"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">8</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="66" data-type="第五球" data-name="9"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc bold">9</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">9.64</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="67" data-type="第五球" data-name="單"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">單</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="68" data-type="第五球" data-name="雙"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">雙</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="69" data-type="第五球" data-name="大"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">大</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        <tr data-sort="70" data-type="第五球" data-name="小"
                                                            style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                            <td class="bc ">小</td>
                                                            <td><span name="up"
                                                                      class="odd_set up fl cursor"></span><span
                                                                    name="down" class="odd_set down fr cursor"></span><a
                                                                    class="line1 sup-line cursor">1.985</a></td>
                                                            <td><a class="line2 sup-line cursor">-</a></td>
                                                            <td><a class="line3 sup-line cursor">-</a></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="float:left;width:0.3%">&nbsp;</div>
                                            </div>
                                            <div style="float:left;width:25%;" name="game-row">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="4">兩面</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="w15 bc">號碼</td>
                                                        <td class="w30 bc">賠率</td>
                                                        <td class="w20 bc">註額</td>
                                                        <td class="w20 bc">盈虧</td>
                                                    </tr>
                                                    <tr data-sort="71" data-type="總和" data-name="單"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">單</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="72" data-type="總和" data-name="雙"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">雙</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="73" data-type="總和" data-name="大"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">大</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="74" data-type="總和" data-name="小"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">小</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="75" data-type="" data-name="龍"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">龍</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="76" data-type="" data-name="虎"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">虎</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="77" data-type="" data-name="和"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">和</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">1.985</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="4">前三</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="w15 bc">號碼</td>
                                                        <td class="w30 bc">賠率</td>
                                                        <td class="w20 bc">註額</td>
                                                        <td class="w20 bc">盈虧</td>
                                                    </tr>
                                                    <tr data-sort="78" data-type="前三" data-name="豹子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">豹子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">70</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="79" data-type="前三" data-name="順子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">順子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">13</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="80" data-type="前三" data-name="對子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">對子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.8</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="81" data-type="前三" data-name="半順"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">半順</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="82" data-type="前三" data-name="雜六"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">雜六</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="4">中三</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="w15 bc">號碼</td>
                                                        <td class="w30 bc">賠率</td>
                                                        <td class="w20 bc">註額</td>
                                                        <td class="w20 bc">盈虧</td>
                                                    </tr>
                                                    <tr data-sort="83" data-type="中三" data-name="豹子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">豹子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">70</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="84" data-type="中三" data-name="順子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">順子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">13</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="85" data-type="中三" data-name="對子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">對子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.8</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="86" data-type="中三" data-name="半順"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">半順</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="87" data-type="中三" data-name="雜六"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">雜六</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <div class="clear"></div>
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="4">后三</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="w15 bc">號碼</td>
                                                        <td class="w30 bc">賠率</td>
                                                        <td class="w20 bc">註額</td>
                                                        <td class="w20 bc">盈虧</td>
                                                    </tr>
                                                    <tr data-sort="88" data-type="后三" data-name="豹子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">豹子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">70</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="89" data-type="后三" data-name="順子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">順子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">13</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="90" data-type="后三" data-name="對子"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">對子</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.8</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="91" data-type="后三" data-name="半順"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">半順</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    <tr data-sort="92" data-type="后三" data-name="雜六"
                                                        style="background: none repeat scroll 0% 0% rgb(230, 230, 230)">
                                                        <td class="bc">雜六</td>
                                                        <td><span name="up" class="odd_set up fl cursor"></span><span
                                                                name="down" class="odd_set down fr cursor"></span><a
                                                                class="line1 sup-line cursor">2.2</a></td>
                                                        <td><a class="line2 sup-line cursor">-</a></td>
                                                        <td><a class="line3 sup-line cursor">-</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div style="float:right;width:6.8%;">
                                            <div style="float:right;width:100%;">
                                                <table class="middle-table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="2">兩面長龍排行</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="cl-count">
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">第4球 大</td>
                                                        <td class="fff red">5期</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="bc txt-left txt-paddin-left">總和 大</td>
                                                        <td class="fff red">2期</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <div id="globalr" class="acion" style="display: none;">
                        <table class="middle-table" id="jiben">
                            <thead>
                            <tr>
                                <th colspan="2">全局設置</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="w25 txt-right bc">系統標題:</td>
                                <td class="txt-left txt-paddin-left"><input type="text" name="WebTitle"
                                                                            class="text-input sw90" maxlength="4"
                                                                            value="" msg="2-4位中文或數字或字母。"></td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">導航驗證碼:</td>
                                <td class="txt-left txt-paddin-left"><input type="text" name="WebCode"
                                                                            class="text-input sw90" maxlength="8"
                                                                            value="" msg="4-8位純數字組成。"></td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">下級占成修改:</td>
                                <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                     name="IsSuperior"
                                                                                                     value="0"
                                                                                                     checked="checked">禁用</label>
                                    <label class="label-box"><input type="radio" name="IsSuperior" value="1">啟用</label>
                                    <span class="red"> 說明：啟用后下級會員有下註依然可修改占成。</span></td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">下級自動補貨修改:</td>
                                <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                     name="IsAutoShipments"
                                                                                                     value="0"
                                                                                                     checked="checked">禁用</label>
                                    <label class="label-box"><input type="radio" name="IsAutoShipments"
                                                                    value="1">啟用</label> <span class="red"> 說明：啟用后下級會員有下註依然可修改自動補貨。</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">下級及會員賬單下載:</td>
                                <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                     name="detailsBak"
                                                                                                     value="0">禁用</label>
                                    <label class="label-box"><input type="radio" name="detailsBak" value="1"
                                                                    checked="checked">啟用</label></td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">兩面長龍排行:</td>
                                <td class="txt-left txt-paddin-left"><select name="clindex">
                                    <option value="0">關閉</option>
                                    <option value="2">2期</option>
                                    <option value="3">3期</option>
                                    <option value="4">4期</option>
                                    <option value="5">5期</option>
                                    <option value="6">6期</option>
                                    <option value="7">7期</option>
                                    <option value="8">8期</option>
                                    <option value="9">9期</option>
                                    <option value="10">10期</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td class="w25 txt-right bc">單註最高派彩:</td>
                                <td class="txt-left txt-paddin-left"><label class="label-box"><input type="text"
                                                                                                     number=""
                                                                                                     name="MaxPayout"
                                                                                                     class="text-input sw70"
                                                                                                     value=""
                                                                                                     maxlength="9"
                                                                                                     msg="1-9位純數字組成。"></label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div id="all">
                            <div class="clear"></div>
                            <table class="middle-table hiden" data-index="0" style="display: none;">
                                <thead>
                                <tr>
                                    <th colspan="14">香港樂透HK</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="txt-right bc w7">特碼A:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK1"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK1" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">特碼B:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK2"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK2" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">色波:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK3"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK3" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">特肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK4"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK4" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">2肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK5"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK5" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">3肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK6"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK6" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">4肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK7"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK7" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                <tr>
                                    <td class="txt-right bc w7">5肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK8"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK8" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">6肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK9"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK9" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">頭數:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK10"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK10" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">尾數:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK11"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK11" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">正碼總和:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK12"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK12" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">正碼特:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK13"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK13" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">平特一肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK14"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK14" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                <tr>
                                    <td class="txt-right bc w7">平特尾數:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK15"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK15" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">正肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK16"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK16" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">7色波:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK17"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK17" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">總肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK18"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK18" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">五行:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK19"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK19" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">連肖:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK20"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK20" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">連尾:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK21"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK21" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                <tr>
                                    <td class="txt-right bc w7">連碼:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK22"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK22" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">5不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK23"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK23" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">6不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK24"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK24" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">7不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK25"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK25" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">8不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK26"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK26" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">9不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK27"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK27" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">10不中:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="HK28"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="HK28" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="clear"></div>
                            <table class="middle-table hiden" data-index="2" style="display: table;">
                                <thead>
                                <tr>
                                    <th colspan="14">快彩</th>
                                </tr>
                                </thead>
                                <tbody gameindex="klc">
                                <tr>
                                    <td class="txt-right bc w7">廣東快樂十分:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="KLC"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="KLC" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">重慶時時彩:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="SSC"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="SSC" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">北京賽車(PK10):</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="PK"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="PK" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">江蘇骰寶(快3):</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="KS"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="KS" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">北京快樂8:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="KLB"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="KLB" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">重慶幸運農場:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="NC"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="NC" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">廣西快樂十分:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="GX"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="GX" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                <tr>
                                    <td class="txt-right bc w7">幸運飛艇:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="FT"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="FT" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">广西快3:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="GXKS"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="GXKS" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">极速賽車:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="PKJS"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="PKJS" value="1"
                                                                        checked="checked">開啟</label></td>
                                    <td class="txt-right bc w7">极速時時彩:</td>
                                    <td class="txt-left txt-paddin-left"><label class="label-box"><input type="radio"
                                                                                                         name="SSCJS"
                                                                                                         value="0">關閉</label>
                                        <label class="label-box"><input type="radio" name="SSCJS" value="1"
                                                                        checked="checked">開啟</label></td>
                                </tr>
                                <tr></tr>
                                </tbody>
                            </table>
                        </div>
                        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                            <tfoot>
                            <tr>
                                <td style="padding-top:20px;"><span class="text-btn" id="submit">保存設置</span></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div id="setodds-gameIndex-3" class="acion" style="display: block;">
                        <table class="middle-table">
                            <thead>
                            <tr>
                                <th>重慶時時彩</th>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <td>
                                    <div style="float:left;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選項</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="1" class="">
                                                <td class="bc sw120">1-5單碼</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="11" class="">
                                                <td class="bc sw120">1-5單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="13" class="">
                                                <td class="bc sw120">1-5大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="71" class="">
                                                <td class="bc sw120">總和單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="73" class="">
                                                <td class="bc sw120">總和大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="75" class="">
                                                <td class="bc sw120">龍虎</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="77" class="">
                                                <td class="bc sw120">和</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="78" class="">
                                                <td class="bc sw120">豹子</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="79" class="">
                                                <td class="bc sw120">順子</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="80" class="">
                                                <td class="bc sw120">對子</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="81" class="">
                                                <td class="bc sw120">半順</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="82" class="">
                                                <td class="bc sw120">雜六</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="float:right;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選擇</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="93" class="">
                                                <td class="bc sw120">牛一</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="94" class="">
                                                <td class="bc sw120">牛二</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="95" class="">
                                                <td class="bc sw120">牛三</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="96" class="">
                                                <td class="bc sw120">牛四</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="97" class="">
                                                <td class="bc sw120">牛五</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="98" class="">
                                                <td class="bc sw120">牛六</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="99" class="">
                                                <td class="bc sw120">牛七</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="100" class="">
                                                <td class="bc sw120">牛八</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="101" class="">
                                                <td class="bc sw120">牛九</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="102" class="">
                                                <td class="bc sw120">牛牛</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="103" class="">
                                                <td class="bc sw120">無牛</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                            <tfoot>
                            <tr>
                                <td style="padding-top:10px;" id="od-set">
                                    <div style="display:inline-block;margin-right:20px;color:red" class="odds-kj">
                                        快升：<span>+0.01</span><span>+0.05</span><span>+0.1</span><span>+0.5</span><span>+1</span><span>+1.5</span><span>+2</span><span>+2.5</span>
                                    </div>
                                    <div style="display:inline-block;color:red" class="odds-kj">
                                        快降：<span>-0.01</span><span>-0.05</span><span>-0.1</span><span>-0.5</span><span>-1</span><span>-1.5</span><span>-2</span><span>-2.5</span>
                                    </div>
                                    <div style="padding-top:10px;"><label class="label-box"><input type="checkbox"
                                                                                                   name="od-a">A盤賠率</label>
                                        <label class="label-box"><input type="checkbox" name="od-b">B盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-c">C盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-max">最高賠率</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-top:15px;"><span class="text-btn" id="submit">保存設置</span><span
                                        class="text-btn" id="reset">重置選項</span></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div id="setodds-gameIndex-4" class="acion" style="display: none;">
                        <table class="middle-table">
                            <thead>
                            <tr>
                                <th>北京賽車(PK10)</th>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <td>
                                    <div style="float:left;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選項</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="22">
                                                <td class="bc sw120">1-10單碼</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="32">
                                                <td class="bc sw120">1-10單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="34">
                                                <td class="bc sw120">1-10大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="36">
                                                <td class="bc sw120">1-5龍虎</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="18">
                                                <td class="bc sw120">冠亞單</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="19">
                                                <td class="bc sw120">冠亞雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="20">
                                                <td class="bc sw120">冠亞大</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="21">
                                                <td class="bc sw120">冠亞小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="float:right;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選擇</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="1">
                                                <td class="bc sw120">冠亞和-3,4,18,19</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="3">
                                                <td class="bc sw120">冠亞和-5,6,16,17</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="5">
                                                <td class="bc sw120">冠亞和-7,8,14,15</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="7">
                                                <td class="bc sw120">冠亞和-9,10,12,13</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="9">
                                                <td class="bc sw120">冠亞和-11</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                            <tfoot>
                            <tr>
                                <td style="padding-top:10px;" id="od-set">
                                    <div style="display:inline-block;margin-right:20px;color:red" class="odds-kj">
                                        快升：<span>+0.01</span><span>+0.05</span><span>+0.1</span><span>+0.5</span><span>+1</span><span>+1.5</span><span>+2</span><span>+2.5</span>
                                    </div>
                                    <div style="display:inline-block;color:red" class="odds-kj">
                                        快降：<span>-0.01</span><span>-0.05</span><span>-0.1</span><span>-0.5</span><span>-1</span><span>-1.5</span><span>-2</span><span>-2.5</span>
                                    </div>
                                    <div style="padding-top:10px;"><label class="label-box"><input type="checkbox"
                                                                                                   name="od-a">A盤賠率</label>
                                        <label class="label-box"><input type="checkbox" name="od-b">B盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-c">C盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-max">最高賠率</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-top:15px;"><span class="text-btn" id="submit">保存設置</span><span
                                        class="text-btn" id="reset">重置選項</span></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div id="setodds-gameIndex-2" class="acion" style="display: none;">
                        <table class="middle-table">
                            <thead>
                            <tr>
                                <th>廣東快樂十分</th>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <td>
                                    <div style="float:left;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選項</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="1">
                                                <td class="bc sw120">1-8單碼</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="21">
                                                <td class="bc sw120">1-8單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="23">
                                                <td class="bc sw120">1-8大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="25">
                                                <td class="bc sw120">1-8尾大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="27">
                                                <td class="bc sw120">1-8合單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="29">
                                                <td class="bc sw120">1-8方位</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="33">
                                                <td class="bc sw120">1-8中發白-中發</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="35">
                                                <td class="bc sw120">1-8中發白-白</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="36">
                                                <td class="bc sw120">1-4龍虎</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="297">
                                                <td class="bc sw120">正碼</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="float:right;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選擇</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="317">
                                                <td class="bc sw120">總和單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="319">
                                                <td class="bc sw120">總和大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="321">
                                                <td class="bc sw120">總和尾大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="323">
                                                <td class="bc sw120">任選二</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="324">
                                                <td class="bc sw120">選二連直</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="325">
                                                <td class="bc sw120">選二連組</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="326">
                                                <td class="bc sw120">任選三</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="327">
                                                <td class="bc sw120">選三前組</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="328">
                                                <td class="bc sw120">任選四</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="329">
                                                <td class="bc sw120">任選五</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                            <tfoot>
                            <tr>
                                <td style="padding-top:10px;" id="od-set">
                                    <div style="display:inline-block;margin-right:20px;color:red" class="odds-kj">
                                        快升：<span>+0.01</span><span>+0.05</span><span>+0.1</span><span>+0.5</span><span>+1</span><span>+1.5</span><span>+2</span><span>+2.5</span>
                                    </div>
                                    <div style="display:inline-block;color:red" class="odds-kj">
                                        快降：<span>-0.01</span><span>-0.05</span><span>-0.1</span><span>-0.5</span><span>-1</span><span>-1.5</span><span>-2</span><span>-2.5</span>
                                    </div>
                                    <div style="padding-top:10px;"><label class="label-box"><input type="checkbox"
                                                                                                   name="od-a">A盤賠率</label>
                                        <label class="label-box"><input type="checkbox" name="od-b">B盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-c">C盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-max">最高賠率</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-top:15px;"><span class="text-btn" id="submit">保存設置</span><span
                                        class="text-btn" id="reset">重置選項</span></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div id="setodds-gameIndex-6" class="acion" style="display: none;">
                        <table class="middle-table">
                            <thead>
                            <tr>
                                <th>北京快樂8</th>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <td>
                                    <div style="float:left;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選項</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="1">
                                                <td class="bc sw120">正碼</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="81">
                                                <td class="bc sw120">總和單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="83">
                                                <td class="bc sw120">總和大小</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="85">
                                                <td class="bc sw120">總和和局</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="86">
                                                <td class="bc sw120">總和過關</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="90">
                                                <td class="bc sw120">前后和-前后</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="92">
                                                <td class="bc sw120">前后和-和</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="float:right;width:49.9%">
                                        <table class="middle-table bor-top">
                                            <thead>
                                            <tr>
                                                <th class="sw120">交易類型</th>
                                                <th>A盤賠率</th>
                                                <th>B盤差分</th>
                                                <th>C盤差分</th>
                                                <th>最高賠率</th>
                                                <th>選擇</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr sort="93">
                                                <td class="bc sw120">單雙和-單雙</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="95">
                                                <td class="bc sw120">單雙和-和</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="96">
                                                <td class="bc sw120">五行-金</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="97">
                                                <td class="bc sw120">五行-木</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="98">
                                                <td class="bc sw120">五行-水</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="99">
                                                <td class="bc sw120">五行-火</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            <tr sort="100">
                                                <td class="bc sw120">五行-土</td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" exts=""
                                                           class="text-input sw70"></td>
                                                <td><input type="text" autocomplete="off" ext=""
                                                           class="text-input sw70"></td>
                                                <td><input type="checkbox"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            </thead>
                        </table>
                        <table border="0" cellpadding="0" cellspacing="0" style="width:100%;text-align:center;">
                            <tfoot>
                            <tr>
                                <td style="padding-top:10px;" id="od-set">
                                    <div style="display:inline-block;margin-right:20px;color:red" class="odds-kj">
                                        快升：<span>+0.01</span><span>+0.05</span><span>+0.1</span><span>+0.5</span><span>+1</span><span>+1.5</span><span>+2</span><span>+2.5</span>
                                    </div>
                                    <div style="display:inline-block;color:red" class="odds-kj">
                                        快降：<span>-0.01</span><span>-0.05</span><span>-0.1</span><span>-0.5</span><span>-1</span><span>-1.5</span><span>-2</span><span>-2.5</span>
                                    </div>
                                    <div style="padding-top:10px;"><label class="label-box"><input type="checkbox"
                                                                                                   name="od-a">A盤賠率</label>
                                        <label class="label-box"><input type="checkbox" name="od-b">B盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-c">C盤差分</label> <label
                                                class="label-box"><input type="checkbox" name="od-max">最高賠率</label>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-top:15px;"><span class="text-btn" id="submit">保存設置</span><span
                                        class="text-btn" id="reset">重置選項</span></td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="shell-bottom">
            <div class="shell-bottom-left"></div>
            <div class="shell-bottom-right"></div>
            <div class="shell-bottom-content" id="shell_pageControl"></div>
        </div>
    </div>
</form:form>
<%--<%@ include file="/include/include.js.jsp" %>--%>
<soul:import res="site/user/Edit"/>

<!--//region your codes 3-->
<!--//endregion your codes 3-->