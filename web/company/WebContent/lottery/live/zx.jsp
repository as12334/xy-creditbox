
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
                            總項盤口
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
                                    <tbody>
                                    <tr>
                                        <td>
                                            <select id="blockChange" class="shortSelect" name="select">
                                                <option value="block1">
                                                    第一球
                                                </option>
                                                <option value="block2">
                                                    第二球
                                                </option>
                                                <option value="block3">
                                                    第三球
                                                </option>
                                                <option value="block8">
                                                    第四球
                                                </option>
                                                <option value="block9">
                                                    第五球
                                                </option>
                                            </select>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
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
                    <td colspan="12" id="upopennumber" class="L_CQSC">
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
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableBody">
                <tr>
                    <td valign="top">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td valign="top">
                                    <table class="t_list">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                第一球
                                            </th>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1" width="15%">
                                                號碼
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody class="descOrasc" id="block1">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        0
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="0" id="odds_1" data-odds="1" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_1" data-amount="1">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="0" class="black clearSzsz" id="szsz_1" data-szsz="1" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        1
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="1" id="odds_2" data-odds="2" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_2" data-amount="2">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_2" data-szsz="2" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        2
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="2" id="odds_3" data-odds="3" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_3" data-amount="3">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_3" data-szsz="3" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        3
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="3" id="odds_4" data-odds="4" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_4" data-amount="4">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_4" data-szsz="4" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        4
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="4" id="odds_5" data-odds="5" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_5" data-amount="5">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_5" data-szsz="5" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        5
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="5" id="odds_6" data-odds="6" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_6" data-amount="6">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_6" data-szsz="6" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        6
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="6" id="odds_7" data-odds="7" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_7" data-amount="7">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_7" data-szsz="7" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        7
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="7" id="odds_8" data-odds="8" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_8" data-amount="8">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_8" data-szsz="8" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        8
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="8" id="odds_9" data-odds="9" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_9" data-amount="9">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_9" data-szsz="9" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        9
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="9" id="odds_10" data-odds="10" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_10" data-amount="10">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_10" data-szsz="10" data-did="1">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="大" id="odds_11" data-odds="11" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_11" data-amount="11">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_11" data-szsz="11" data-did="2">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="小" id="odds_12" data-odds="12" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_12" data-amount="12">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_12" data-szsz="12" data-did="2">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="單" id="odds_13" data-odds="13" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_13" data-amount="13">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_13" data-szsz="13" data-did="3">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="雙" id="odds_14" data-odds="14" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_14" data-amount="14">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_14" data-szsz="14" data-did="3">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td width="3">
                                </td>
                                <td valign="top">
                                    <table class="t_list">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                第二球
                                            </th>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1" width="15%">
                                                號碼
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody class="descOrasc" id="block2">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        0
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="0" id="odds_15" data-odds="15" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_15" data-amount="15">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="0" class="black clearSzsz" id="szsz_15" data-szsz="15" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        1
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="1" id="odds_16" data-odds="16" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_16" data-amount="16">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_16" data-szsz="16" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        2
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="2" id="odds_17" data-odds="17" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_17" data-amount="17">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_17" data-szsz="17" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        3
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="3" id="odds_18" data-odds="18" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_18" data-amount="18">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_18" data-szsz="18" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        4
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="4" id="odds_19" data-odds="19" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_19" data-amount="19">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_19" data-szsz="19" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        5
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="5" id="odds_20" data-odds="20" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_20" data-amount="20">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_20" data-szsz="20" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        6
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="6" id="odds_21" data-odds="21" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_21" data-amount="21">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_21" data-szsz="21" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        7
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="7" id="odds_22" data-odds="22" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_22" data-amount="22">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_22" data-szsz="22" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        8
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="8" id="odds_23" data-odds="23" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_23" data-amount="23">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_23" data-szsz="23" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        9
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="9" id="odds_24" data-odds="24" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_24" data-amount="24">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_24" data-szsz="24" data-did="4">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="大" id="odds_25" data-odds="25" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_25" data-amount="25">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_25" data-szsz="25" data-did="5">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="小" id="odds_26" data-odds="26" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_26" data-amount="26">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_26" data-szsz="26" data-did="5">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="單" id="odds_27" data-odds="27" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_27" data-amount="27">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_27" data-szsz="27" data-did="6">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="雙" id="odds_28" data-odds="28" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_28" data-amount="28">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_28" data-szsz="28" data-did="6">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td width="3">
                                </td>
                                <td valign="top">
                                    <table class="t_list">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                第三球
                                            </th>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1" width="15%">
                                                號碼
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody class="descOrasc" id="block3">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        0
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="0" id="odds_29" data-odds="29" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_29" data-amount="29">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="0" class="black clearSzsz" id="szsz_29" data-szsz="29" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        1
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="1" id="odds_30" data-odds="30" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_30" data-amount="30">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_30" data-szsz="30" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        2
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="2" id="odds_31" data-odds="31" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_31" data-amount="31">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_31" data-szsz="31" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        3
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="3" id="odds_32" data-odds="32" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_32" data-amount="32">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_32" data-szsz="32" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        4
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="4" id="odds_33" data-odds="33" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_33" data-amount="33">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_33" data-szsz="33" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        5
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="5" id="odds_34" data-odds="34" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_34" data-amount="34">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_34" data-szsz="34" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        6
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="6" id="odds_35" data-odds="35" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_35" data-amount="35">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_35" data-szsz="35" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        7
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="7" id="odds_36" data-odds="36" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_36" data-amount="36">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_36" data-szsz="36" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        8
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="8" id="odds_37" data-odds="37" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_37" data-amount="37">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_37" data-szsz="37" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        9
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="9" id="odds_38" data-odds="38" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_38" data-amount="38">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_38" data-szsz="38" data-did="7">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="大" id="odds_39" data-odds="39" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_39" data-amount="39">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_39" data-szsz="39" data-did="8">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="小" id="odds_40" data-odds="40" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_40" data-amount="40">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_40" data-szsz="40" data-did="8">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="單" id="odds_41" data-odds="41" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_41" data-amount="41">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_41" data-szsz="41" data-did="9">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="雙" id="odds_42" data-odds="42" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_42" data-amount="42">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_42" data-szsz="42" data-did="9">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td width="3">
                                </td>
                                <td rowspan="2" valign="top">
                                    <table class="t_list">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                兩面
                                            </th>
                                        </tr>
                                        <tr>
                                            <td class="tdbg1" width="15%">
                                                類型
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody id="block4">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        總大
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="總大" id="odds_71" data-odds="71" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_71" data-amount="71">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="總大" class="black clearSzsz" id="szsz_71" data-szsz="71" data-did="16">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        總小
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="總小" id="odds_72" data-odds="72" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_72" data-amount="72">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="總小" class="black clearSzsz" id="szsz_72" data-szsz="72" data-did="16">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        總單
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="總單" id="odds_73" data-odds="73" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_73" data-amount="73">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="總單" class="black clearSzsz" id="szsz_73" data-szsz="73" data-did="17">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        總雙
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="總雙" id="odds_74" data-odds="74" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_74" data-amount="74">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="總雙" class="black clearSzsz" id="szsz_74" data-szsz="74" data-did="17">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        龍
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="龍" id="odds_75" data-odds="75" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_75" data-amount="75">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="龍" class="black clearSzsz" id="szsz_75" data-szsz="75" data-did="18">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        虎
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="虎" id="odds_76" data-odds="76" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_76" data-amount="76">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="虎" class="black clearSzsz" id="szsz_76" data-szsz="76" data-did="18">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        和
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="和" id="odds_77" data-odds="77" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_77" data-amount="77">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="和" class="black clearSzsz" id="szsz_77" data-szsz="77" data-did="1800">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <table class="t_list tm3">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                前三
                                            </th>
                                        </tr>
                                        <tr>
                                            <td class="tdbg1" width="15%">
                                                類型
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody id="block5">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        豹子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="豹子" id="odds_78" data-odds="78" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_78" data-amount="78">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="豹子" class="black clearSzsz" id="szsz_78" data-szsz="78" data-did="19">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        順子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="順子" id="odds_79" data-odds="79" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_79" data-amount="79">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="順子" class="black clearSzsz" id="szsz_79" data-szsz="79" data-did="19">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        對子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="對子" id="odds_80" data-odds="80" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_80" data-amount="80">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="對子" class="black clearSzsz" id="szsz_80" data-szsz="80" data-did="19">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        半順
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="半順" id="odds_81" data-odds="81" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_81" data-amount="81">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="半順" class="black clearSzsz" id="szsz_81" data-szsz="81" data-did="19">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        雜六
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="雜六" id="odds_82" data-odds="82" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_82" data-amount="82">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雜六" class="black clearSzsz" id="szsz_82" data-szsz="82" data-did="19">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <table class="t_list tm3">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                中三
                                            </th>
                                        </tr>
                                        <tr>
                                            <td class="tdbg1" width="15%">
                                                類型
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody id="block6">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        豹子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="豹子" id="odds_83" data-odds="83" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_83" data-amount="83">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="豹子" class="black clearSzsz" id="szsz_83" data-szsz="83" data-did="20">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        順子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="順子" id="odds_84" data-odds="84" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_84" data-amount="84">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="順子" class="black clearSzsz" id="szsz_84" data-szsz="84" data-did="20">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        對子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="對子" id="odds_85" data-odds="85" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_85" data-amount="85">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="對子" class="black clearSzsz" id="szsz_85" data-szsz="85" data-did="20">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        半順
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="半順" id="odds_86" data-odds="86" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_86" data-amount="86">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="半順" class="black clearSzsz" id="szsz_86" data-szsz="86" data-did="20">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        雜六
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="雜六" id="odds_87" data-odds="87" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_87" data-amount="87">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雜六" class="black clearSzsz" id="szsz_87" data-szsz="87" data-did="20">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <table class="t_list tm3">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                後三
                                            </th>
                                        </tr>
                                        <tr>
                                            <td class="tdbg1" width="15%">
                                                類型
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody id="block7">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        豹子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="豹子" id="odds_88" data-odds="88" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_88" data-amount="88">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="豹子" class="black clearSzsz" id="szsz_88" data-szsz="88" data-did="21">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        順子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="順子" id="odds_89" data-odds="89" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_89" data-amount="89">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="順子" class="black clearSzsz" id="szsz_89" data-szsz="89" data-did="21">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        對子
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="對子" id="odds_90" data-odds="90" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_90" data-amount="90">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="對子" class="black clearSzsz" id="szsz_90" data-szsz="90" data-did="21">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        半順
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="半順" id="odds_91" data-odds="91" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_91" data-amount="91">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="半順" class="black clearSzsz" id="szsz_91" data-szsz="91" data-did="21">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="grey ballOpenBtn">
                                                        雜六
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="雜六" id="odds_92" data-odds="92" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_92" data-amount="92">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雜六" class="black clearSzsz" id="szsz_92" data-szsz="92" data-did="21">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td valign="top">
                                    <table class="t_list tm3">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                第四球
                                            </th>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1" width="15%">
                                                號碼
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody class="descOrasc" id="block8">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        0
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="0" id="odds_43" data-odds="43" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_43" data-amount="43">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="0" class="black clearSzsz" id="szsz_43" data-szsz="43" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        1
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="1" id="odds_44" data-odds="44" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_44" data-amount="44">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_44" data-szsz="44" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        2
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="2" id="odds_45" data-odds="45" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_45" data-amount="45">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_45" data-szsz="45" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        3
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="3" id="odds_46" data-odds="46" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_46" data-amount="46">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_46" data-szsz="46" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        4
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="4" id="odds_47" data-odds="47" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_47" data-amount="47">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_47" data-szsz="47" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        5
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="5" id="odds_48" data-odds="48" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_48" data-amount="48">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_48" data-szsz="48" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        6
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="6" id="odds_49" data-odds="49" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_49" data-amount="49">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_49" data-szsz="49" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        7
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="7" id="odds_50" data-odds="50" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_50" data-amount="50">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_50" data-szsz="50" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        8
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="8" id="odds_51" data-odds="51" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_51" data-amount="51">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_51" data-szsz="51" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        9
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="9" id="odds_52" data-odds="52" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_52" data-amount="52">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_52" data-szsz="52" data-did="10">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="大" id="odds_53" data-odds="53" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_53" data-amount="53">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_53" data-szsz="53" data-did="11">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="小" id="odds_54" data-odds="54" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_54" data-amount="54">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_54" data-szsz="54" data-did="11">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="單" id="odds_55" data-odds="55" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_55" data-amount="55">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_55" data-szsz="55" data-did="12">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="雙" id="odds_56" data-odds="56" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_56" data-amount="56">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_56" data-szsz="56" data-did="12">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td>
                                </td>
                                <td valign="top">
                                    <table class="t_list tm3">
                                        <thead>
                                        <tr>
                                            <th colspan="4">
                                                第五球
                                            </th>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1" width="15%">
                                                號碼
                                            </td>
                                            <td class="tdbg1" width="30%">
                                                賠率
                                            </td>
                                            <td class="tdbg1">
                                                注額
                                            </td>
                                            <td class="tdbg1">
                                                虧盈
                                            </td>
                                        </tr>
                                        </thead>
                                        <tbody class="descOrasc" id="block9">
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        0
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="0" id="odds_57" data-odds="57" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_57" data-amount="57">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="0" class="black clearSzsz" id="szsz_57" data-szsz="57" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        1
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="1" id="odds_58" data-odds="58" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_58" data-amount="58">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_58" data-szsz="58" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        2
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="2" id="odds_59" data-odds="59" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_59" data-amount="59">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_59" data-szsz="59" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        3
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="3" id="odds_60" data-odds="60" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_60" data-amount="60">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_60" data-szsz="60" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        4
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="4" id="odds_61" data-odds="61" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_61" data-amount="61">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_61" data-szsz="61" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        5
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="5" id="odds_62" data-odds="62" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_62" data-amount="62">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_62" data-szsz="62" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        6
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="6" id="odds_63" data-odds="63" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_63" data-amount="63">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_63" data-szsz="63" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        7
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="7" id="odds_64" data-odds="64" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_64" data-amount="64">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_64" data-szsz="64" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        8
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="8" id="odds_65" data-odds="65" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_65" data-amount="65">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_65" data-szsz="65" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
                                            <td class="tdbg1">
                                                <b>
                                                    <a href="javascript:;" class="f14 blue ballOpenBtn">
                                                        9
                                                    </a>
                                                </b>
                                            </td>
                                            <td class="oddsWrap">
                                                <div class="pDiv">
                                                    <em class="addBtns">
                                                    </em>
                                                    <i class="minBtns">
                                                    </i>
                                                    <a href="javascript:;" data-name="9" id="odds_66" data-odds="66" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_66" data-amount="66">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_66" data-szsz="66" data-did="13">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="大" id="odds_67" data-odds="67" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_67" data-amount="67">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_67" data-szsz="67" data-did="14">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="小" id="odds_68" data-odds="68" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_68" data-amount="68">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_68" data-szsz="68" data-did="14">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="單" id="odds_69" data-odds="69" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_69" data-amount="69">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_69" data-szsz="69" data-did="15">
                                                </a>
                                            </td>
                                        </tr>
                                        <tr class="oddsParent">
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
                                                    <a href="javascript:;" data-name="雙" id="odds_70" data-odds="70" class="blue1 oddsTrim">
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <a href="javascript:;" class="black clearAmout" id="amount_70" data-amount="70">
                                                </a>
                                            </td>
                                            <td>
                                                <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_70" data-szsz="70" data-did="15">
                                                </a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                                <td>
                                </td>
                                <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td align="center">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <b>
                                                <a href="javascript:;" id="nowPageOpen" class="blue">開放</a></b> <span class="burster">/</span>
                                            <b>
                                                <a href="javascript:;" id="nowPageClose" class="red">停押</a></b>&nbsp;&nbsp;&nbsp;&nbsp;
                                            <b>
                                                <a href="javascript:;" id="allOpen" class="blue">全部開</a></b> <span class="burster">/</span>
                                            <b>
                                                <a href="javascript:;" id="allClose" class="red">全部停</a></b>											</td>
                                    </tr>
                                </table>					                    </td>
                                <td width="3">
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td width="3">
                    </td>
                    <td width="130" valign="top">
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


<script language="javascript" type="text/javascript">
    (function() {
        // 1800为和
        parent.playids = '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,1800';//大类玩法ID
        parent.isopt = '0';//是否有权限调整赔率
        parent.issllowsale = '1'; //是否可以走飞
        parent.usertype = '0';//用户类别
        parent.isLm = 0;
        parent.isShortcut = 0;
        parent.jeucode = '12120152062174';//下注验证
        parent.shortcutData = {
            'empty': [0],  // 空
            "live": [6,7,8,9,5],  // 大
            'small': [0,1,2,3,4],  // 小
            'single': [1,3,5,7,9],  // 单
            'double': [2,4,6,8,0]  // 双
        };
        parent.playpage = 'zx';
    })();
</script>
</body>
</html>
