
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>title</title>
    <meta name="keyword" content="">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" id="Iframe_skin" href="/Styles/Blue/skin.css">
    <link rel="stylesheet" href="/Styles/global.css">
    <link rel="stylesheet" href="/Styles/BallCss/ball_all.css">
    <link rel="stylesheet" href="/Styles/ui-dialog.css">
    <script src="/Scripts/json2.js" type="text/javascript"></script>


    <script>var jsver=20191126;</script>
    <script>var isOpenUpper="0";</script>
    <script src="/Scripts/json2.js" type="text/javascript"></script>
    <script src="/Scripts/sea.js"></script>
    <script src="/Scripts/seajs-css.js" type="text/javascript"></script>
    <script src="/Scripts/config.js"></script>

</head>

<body>
<!--主体部分-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <tbody>
    <tr>
        <td class="topLeftBg">
        </td>
        <td class="topBoxBg">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td width="26" align="center">
                        <div class="topArr"></div>
                    </td>
                    <td width="310">
                        <b>
                            第二球
                        </b>
                        【第
                        <b class="green" id="nn" data-pId="">
                            0
                        </b>
                        期】
                    </td>
                    <td width="180">
                        &nbsp;第
                        <b class="blue" id="upopenphase">
                            0
                        </b>
                        期賽果：
                        <br />
                    </td>
                    <td>&nbsp;

                    </td>
                    <td width="70">
                        <label for="cbN" class="topLabel">
                            <input id="cbN" type="checkbox" name="checkbox" value="checkbox">
                            <span>
										注数
									</span>
                        </label>
                    </td>
                    <td width="90">
                        <label for="cbM" class="topLabel">
                            <input id="cbM" type="checkbox" name="checkbox" value="checkbox">
                            <span>
										補貨注額
									</span>
                        </label>
                    </td>
                    <td width="50" align="right">
                        更新：
                    </td>
                    <td width="50">
                        <select name="select2" id="upSecond"></select>
                    </td>
                    <td width="50">
                        <select name="select4" id="upActual">
                            <option value="0">
                                虚占
                            </option>
                            <option value="1" selected>
                                實占
                            </option>

                        </select>
                    </td>
                    <td width="33">
                        <select name="select" id="upHandicap">
                            <option value="" selected>全部</option><option value="a">A盤</option><option value="b">B盤</option><option value="c">C盤</option>
                        </select>
                    </td>
                    <td width="110" align="right">
                        <button id="countSeconds" type="button" name="button" class="btn">
                        </button>
                    </td>
                    <td width="60" align="right" id="KJLbtn">
                        <div class="kjlBox">
                            <button id="ShortcutBtn" class="btn" name="" type="button">
                                快捷欄
                            </button>
                            <div id="ShortcutBox" class="listBox">
                                <table class="t_list3">
                                    <thead>
                                    <tr>
                                        <th colspan="2">
                                            快捷欄
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody id="ShortcutMenu">
                                    <tr>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="single">
                                                單
                                            </a>
                                        </td>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="double">
                                                雙
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="great">
                                                大
                                            </a>
                                        </td>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="small">
                                                小
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="singleTogether">
                                                合單
                                            </a>
                                        </td>
                                        <td>
                                            <a class="black" href="javascript:;" data-id="doubleTogether">
                                                合雙
                                            </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table class="t_list3">
                                    <thead>
                                    <tr>
                                        <th class="tdbg4" colspan="2">
                                            <b>
                                                篩選方式
                                            </b>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody id="ShortcutSet">
                                    <tr>
                                        <td colspan="2">
                                            <select id="retention" class="shortSelect" name="select">
                                                <option value="empty">
                                                    &mdash; NO&mdash;
                                                </option>
                                                <option value="single">
                                                    保留-單
                                                </option>
                                                <option value="double">
                                                    保留-雙
                                                </option>
                                                <option value="great">
                                                    保留-大
                                                </option>
                                                <option value="small">
                                                    保留-小
                                                </option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <em id="ShortcutAdd">
                                            </em>
                                            <i id="ShortcutMin">
                                            </i>
                                            <select id="ShortcutOddr" class="h18">
                                                <option>
                                                    0.1
                                                </option>
                                                <option>
                                                    0.2
                                                </option>
                                                <option>
                                                    0.5
                                                </option>
                                                <option>
                                                    1
                                                </option>
                                                <option>
                                                    2
                                                </option>
                                                <option>
                                                    5
                                                </option>
                                                <option>
                                                    10
                                                </option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input id="ShortcutText" type="text" class="text w98" name="textfield"
                                                   placeholder="輸入新賠率">
                                            <button id="ShortcutSubmit" class="btn" name="" type="button">
                                                調整
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <b id="ShortcutOpen" class="blue">
                                                開放
                                            </b>
                                            /
                                            <b id="ShortcutClose" class="red">
                                                停押
                                            </b>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center">&nbsp;

                    </td>
                    <td>
								<span id="openType">
									已封盤
								</span>
                        <b id="openTypeTime" class="red">
                        </b>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;今日输赢：
                        <b class="red" id="profit">
                            0
                        </b>
                    </td>
                    <td colspan="12" id="upopennumber" class="L_KL10">
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
        <td class="topRightBg">
        </td>
    </tr>
    <tr>
        <td class="centerLeftBg">
        </td>
        <td valign="top">
            <!--主体开始-->
            <table class="tableBody" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th>
                                    號碼
                                </th>
                                <th>
                                    賠率
                                </th>
                                <th>
                                    注額
                                </th>
                                <th>
                                    虧盈
                                </th>
                            </tr>
                            </thead>
                            <tbody class="descOrasc" id="block1">
                            <tr class="oddsParent">
                                <td class="tdbg1" width="15%">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            01
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap" width="30%">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="01" id="odds_29" data-odds="29" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_29" data-amount="29">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="01" class="black clearSzsz" id="szsz_29" data-szsz="29" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            02
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="02" id="odds_30" data-odds="30" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_30" data-amount="30">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="02" class="black clearSzsz" id="szsz_30" data-szsz="30" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            03
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="03" id="odds_31" data-odds="31" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_31" data-amount="31">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="03" class="black clearSzsz" id="szsz_31" data-szsz="31" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            04
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="04" id="odds_32" data-odds="32" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_32" data-amount="32">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="04" class="black clearSzsz" id="szsz_32" data-szsz="32" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            05
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="05" id="odds_33" data-odds="33" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_33" data-amount="33">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="05" class="black clearSzsz" id="szsz_33" data-szsz="33" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            06
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="06" id="odds_34" data-odds="34" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_34" data-amount="34">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="06" class="black clearSzsz" id="szsz_34" data-szsz="34" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            07
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="07" id="odds_35" data-odds="35" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_35" data-amount="35">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="07" class="black clearSzsz" id="szsz_35" data-szsz="35" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            08
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="08" id="odds_36" data-odds="36" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_36" data-amount="36">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="08" class="black clearSzsz" id="szsz_36" data-szsz="36" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            09
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="09" id="odds_37" data-odds="37" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_37" data-amount="37">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="09" class="black clearSzsz" id="szsz_37" data-szsz="37" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            10
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="10" id="odds_38" data-odds="38" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_38" data-amount="38">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_38" data-szsz="38" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            11
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="11" id="odds_39" data-odds="39" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_39" data-amount="39">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="11" class="black clearSzsz" id="szsz_39" data-szsz="39" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            12
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="12" id="odds_40" data-odds="40" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_40" data-amount="40">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="12" class="black clearSzsz" id="szsz_40" data-szsz="40" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            13
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="13" id="odds_41" data-odds="41" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_41" data-amount="41">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="13" class="black clearSzsz" id="szsz_41" data-szsz="41" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            14
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="14" id="odds_42" data-odds="42" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_42" data-amount="42">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="14" class="black clearSzsz" id="szsz_42" data-szsz="42" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            15
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="15" id="odds_43" data-odds="43" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_43" data-amount="43">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="15" class="black clearSzsz" id="szsz_43" data-szsz="43" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            16
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="16" id="odds_44" data-odds="44" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_44" data-amount="44">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="16" class="black clearSzsz" id="szsz_44" data-szsz="44" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            17
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="17" id="odds_45" data-odds="45" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_45" data-amount="45">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="17" class="black clearSzsz" id="szsz_45" data-szsz="45" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 blue ballOpenBtn">
                                            18
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="18" id="odds_46" data-odds="46" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_46" data-amount="46">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="18" class="black clearSzsz" id="szsz_46" data-szsz="46" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 red ballOpenBtn">
                                            19
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="19" id="odds_47" data-odds="47" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_47" data-amount="47">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="19" class="black clearSzsz" id="szsz_47" data-szsz="47" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 red ballOpenBtn">
                                            20
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="20" id="odds_48" data-odds="48" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_48" data-amount="48">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="20" class="black clearSzsz" id="szsz_48" data-szsz="48" data-did="86">
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td valign="top">
                        <table class="t_list2">
                            <thead id="descOrascBtn">
                            <tr>
                                <th colspan="4">
                                    <div class="base-clear">
                                        <a href="javascript:;" data-id="asc" class="descOrascBtn active">按虧損額負值排列</a>
                                        <a href="javascript:;" data-id="desc" class="descOrascBtn">按虧損額正值排列</a>
                                    </div>
                                </th>
                            </tr>
                            </thead>
                            <tbody class="descOrascNoAuto" data-len="-1" id="block2">

                            </tbody>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th width="15%">
                                    類型
                                </th>
                                <th width="30%">
                                    賠率
                                </th>
                                <th>
                                    注額
                                </th>
                                <th>
                                    虧盈
                                </th>
                            </tr>
                            </thead>
                            <tbody id="block3">
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="大" id="odds_49" data-odds="49" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_49" data-amount="49">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_49" data-szsz="49" data-did="87">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="小" id="odds_50" data-odds="50" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_50" data-amount="50">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_50" data-szsz="50" data-did="87">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="單" id="odds_51" data-odds="51" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_51" data-amount="51">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_51" data-szsz="51" data-did="88">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="雙" id="odds_52" data-odds="52" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_52" data-amount="52">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_52" data-szsz="52" data-did="88">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            尾大
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="尾大" id="odds_55" data-odds="55" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_55" data-amount="55">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="尾大" class="black clearSzsz" id="szsz_55" data-szsz="55" data-did="89">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            尾小
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="尾小" id="odds_56" data-odds="56" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_56" data-amount="56">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="尾小" class="black clearSzsz" id="szsz_56" data-szsz="56" data-did="89">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            合單
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="合單" id="odds_53" data-odds="53" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_53" data-amount="53">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="合單" class="black clearSzsz" id="szsz_53" data-szsz="53" data-did="90">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            合雙
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="合雙" id="odds_54" data-odds="54" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_54" data-amount="54">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="合雙" class="black clearSzsz" id="szsz_54" data-szsz="54" data-did="90">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            東
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="東" id="odds_255" data-odds="255" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_255" data-amount="255">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="東" class="black clearSzsz" id="szsz_255" data-szsz="255" data-did="123">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            南
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="南" id="odds_256" data-odds="256" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_256" data-amount="256">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="南" class="black clearSzsz" id="szsz_256" data-szsz="256" data-did="123">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            西
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="西" id="odds_257" data-odds="257" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_257" data-amount="257">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="西" class="black clearSzsz" id="szsz_257" data-szsz="257" data-did="123">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            北
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="北" id="odds_258" data-odds="258" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_258" data-amount="258">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="北" class="black clearSzsz" id="szsz_258" data-szsz="258" data-did="123">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            中
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="中" id="odds_286" data-odds="286" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_286" data-amount="286">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="中" class="black clearSzsz" id="szsz_286" data-szsz="286" data-did="124">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            發
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="發" id="odds_287" data-odds="287" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_287" data-amount="287">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="發" class="black clearSzsz" id="szsz_287" data-szsz="287" data-did="124">
                                    </a>
                                </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            白
                                        </a>
                                    </b>
                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">
                                        </em>
                                        <i class="minBtns">
                                        </i>
                                        <a href="javascript:;" data-name="白" id="odds_288" data-odds="288" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_288" data-amount="288">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="白" class="black clearSzsz" id="szsz_288" data-szsz="288" data-did="124">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="hui tdbg3" align="left" height="110">
                                    <b>
                                        總投註額：
                                        <b class="green" id="sumQuota">0</b>
                                        <br />
                                        最高虧損：
                                        <b class="red" id="minQuota">0</b>
                                        <br />
                                        最高盈利：
                                        <b class="grey" id="maxQuota">0</b>
                                    </b><br />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="hui tdbg3" align="center" height="23">
                                    <b>
                                        <a href="javascript:;" id="nowPageOpen" class="blue">開放</a></b> <span class="burster">/</span>
                                    <b>
                                        <a href="javascript:;" id="nowPageClose" class="red">停押</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <b>
                                        <a href="javascript:;" id="allOpen" class="blue">全部開</a></b> <span class="burster">/</span>
                                    <b>
                                        <a href="javascript:;" id="allClose" class="red">全部停</a></b>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td valign="top" width="160">
                        <table class="t_list">
                            <tbody>
                            <tr>
                                <th width="160">
                                    總額：
                                    <b id="numCounts" class="green">
                                        0
                                    </b>
                                </th>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_1.aspx" class="black kcmx">
                                        第一球總：
                                        <b class="green" data-amountcount="81">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_2.aspx" class="black kcmx">
                                        第二球總：
                                        <b class="green" data-amountcount="86">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_3.aspx" class="black kcmx">
                                        第三球總：
                                        <b class="green" data-amountcount="91">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_4.aspx" class="black kcmx">
                                        第四球總：
                                        <b class="green" data-amountcount="96">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_5.aspx" class="black kcmx">
                                        第五球總：
                                        <b class="green" data-amountcount="101">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_6.aspx" class="black kcmx">
                                        第六球總：
                                        <b class="green" data-amountcount="106">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_7.aspx" class="black kcmx">
                                        第七球總：
                                        <b class="green" data-amountcount="111">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_8.aspx" class="black kcmx">
                                        第八球總：
                                        <b class="green" data-amountcount="116">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lh.aspx" class="black kcmx">
                                        總和大小：
                                        <b class="green" data-amountcount="1011">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lh.aspx" class="black kcmx">
                                        總和單雙：
                                        <b class="green" data-amountcount="1012">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lh.aspx" class="black kcmx">
                                        總尾大小：
                                        <b class="green" data-amountcount="1013">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lh.aspx" class="black kcmx">
                                        龍　　虎：
                                        <b class="green" data-amountcount="80">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        任&nbsp;&nbsp;選&nbsp;&nbsp;二：
                                        <b class="green" data-amountcount="72">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        選二連直：
                                        <b class="green" data-amountcount="73">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        選二連組：
                                        <b class="green" data-amountcount="74">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        任&nbsp;&nbsp;選&nbsp;&nbsp;三：
                                        <b class="green" data-amountcount="75">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        選三前直：
                                        <b class="green" data-amountcount="76">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        選三前組：
                                        <b class="green" data-amountcount="77">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        任&nbsp;&nbsp;選&nbsp;&nbsp;四：
                                        <b class="green" data-amountcount="78">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a href="javascript:;" data-page="Betimes_lm.aspx" class="black kcmx">
                                        任&nbsp;&nbsp;選&nbsp;&nbsp;五：
                                        <b class="green" data-amountcount="79">
                                            0
                                        </b>
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td valign="top" width="60">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th colspan="2" width="60">
                                    遺漏
                                </th>
                            </tr>
                            </thead>
                            <tbody id="dropball"></tbody>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td valign="top" width="130">
                        <table class="t_list1">
                            <thead>
                            <tr>
                                <th>
                                    兩面長龍
                                </th>
                            </tr>
                            </thead>
                            <tbody id="lmcl"></tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <!--主体结束-->
        </td>
        <td class="centerRightBg">
        </td>
    </tr>
    <tr>
        <td class="bottomLeftBg">
        </td>
        <td class="bottomBoxBg" align="left">
            <div class="tool_left">
                <div id="tool_wrap" class="t_left">
                </div>
            </div>
            <!--
                            平均虧損：
                            <input type="text" name="textfield" class="text w80" />
                            &nbsp;&nbsp;&nbsp;賠率：
                            <input type="text" name="textfield" class="text" />
                            &nbsp;&nbsp;&nbsp;退水：
                            <input type="text" name="textfield" class="text" />
                            &nbsp;&nbsp;&nbsp;
                            <button type="button" name="button" class="btn">
                                計算補貨
                            </button>
                            &nbsp;&nbsp;&nbsp;
                            <button type="button" name="button" class="btn">
                                快速補單
                            </button>
                            &nbsp;&nbsp;&nbsp;
                            <button type="button" name="button" class="btn">
                                補貨說明
                            </button> -->
        </td>
        <td class="bottomRightBg">
        </td>
    </tr>
    </tbody>
</table>

<script>
    (function() {
        parent.playids = '86,87,88,89,90,123,124';//大类玩法ID
        parent.isopt = '0';//是否有权限调整赔率
        parent.issllowsale = '1'; //是否可以走飞
        parent.usertype = '0';//用户类别
        parent.isLm = 0;
        parent.isShortcut = 1;
        parent.jeucode = '12120820103164';//下注验证
        parent.shortcutData = {
            'empty': [-1],  // 空
            "live": [11,12,13,14,15,16,17,18,19,20],  // 大
            'small': [1,2,3,4,5,6,7,8,9,10],  // 小
            'single': [1,3,5,7,9,11,13,15,17,19],  // 单
            'double': [2,4,6,8,10,12,14,16,18,20],  // 双
            'singleTogether': [1,3,5,7,9,10,12,14,16,18],  // 合单
            'doubleTogether': [2,4,6,8,11,13,15,17,19,20]  // 合双
        };
        parent.playpage = 'p2';
    })();

</script>
</body>
</html>
