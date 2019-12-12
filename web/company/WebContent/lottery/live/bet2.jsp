
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
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
                            三、四、伍、六名
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
                                                    第三名
                                                </option>
                                                <option value="block2">
                                                    第四名
                                                </option>
                                                <option value="block3">
                                                    第五名
                                                </option>
                                                <option value="block4">
                                                    第六名
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
                                            <select id="retention" class="h18" name="select">
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
                    <td colspan="12" id="upopennumber" class="L_XYFT5">
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
                <tr>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th colspan="4">
                                    第三名
                                </th>
                            </tr>
                            <tr>
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
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="1" id="odds_33" data-odds="33" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_33" data-amount="33">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_33" data-szsz="33" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="2" id="odds_34" data-odds="34" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_34" data-amount="34">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_34" data-szsz="34" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="3" id="odds_35" data-odds="35" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_35" data-amount="35">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_35" data-szsz="35" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="4" id="odds_36" data-odds="36" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_36" data-amount="36">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_36" data-szsz="36" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="5" id="odds_37" data-odds="37" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_37" data-amount="37">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_37" data-szsz="37" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="6" id="odds_38" data-odds="38" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_38" data-amount="38">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_38" data-szsz="38" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="7" id="odds_39" data-odds="39" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_39" data-amount="39">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_39" data-szsz="39" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="8" id="odds_40" data-odds="40" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_40" data-amount="40">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_40" data-szsz="40" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="9" id="odds_41" data-odds="41" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_41" data-amount="41">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_41" data-szsz="41" data-did="9">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="10" id="odds_42" data-odds="42" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_42" data-amount="42">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_42" data-szsz="42" data-did="9">
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
                                        <a href="javascript:;" data-name="大" id="odds_43" data-odds="43" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_43" data-amount="43">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_43" data-szsz="43" data-did="10">
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
                                        <a href="javascript:;" data-name="小" id="odds_44" data-odds="44" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_44" data-amount="44">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_44" data-szsz="44" data-did="10">
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
                                        <a href="javascript:;" data-name="單" id="odds_45" data-odds="45" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_45" data-amount="45">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_45" data-szsz="45" data-did="11">
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
                                        <a href="javascript:;" data-name="雙" id="odds_46" data-odds="46" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_46" data-amount="46">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_46" data-szsz="46" data-did="11">
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
                                        <a href="javascript:;" data-name="龍" id="odds_47" data-odds="47" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_47" data-amount="47">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="龍" class="black clearSzsz" id="szsz_47" data-szsz="47" data-did="12">
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
                                        <a href="javascript:;" data-name="虎" id="odds_48" data-odds="48" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_48" data-amount="48">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="虎" class="black clearSzsz" id="szsz_48" data-szsz="48" data-did="12">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d3ze"></b>
                                    </b>
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
                                    第四名
                                </th>
                            </tr>
                            <tr>
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
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="1" id="odds_49" data-odds="49" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_49" data-amount="49">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_49" data-szsz="49" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="2" id="odds_50" data-odds="50" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_50" data-amount="50">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_50" data-szsz="50" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="3" id="odds_51" data-odds="51" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_51" data-amount="51">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_51" data-szsz="51" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="4" id="odds_52" data-odds="52" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_52" data-amount="52">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_52" data-szsz="52" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="5" id="odds_53" data-odds="53" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_53" data-amount="53">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_53" data-szsz="53" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="6" id="odds_54" data-odds="54" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_54" data-amount="54">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_54" data-szsz="54" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="7" id="odds_55" data-odds="55" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_55" data-amount="55">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_55" data-szsz="55" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="8" id="odds_56" data-odds="56" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_56" data-amount="56">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_56" data-szsz="56" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="9" id="odds_57" data-odds="57" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_57" data-amount="57">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_57" data-szsz="57" data-did="13">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="10" id="odds_58" data-odds="58" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_58" data-amount="58">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_58" data-szsz="58" data-did="13">
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
                                        <a href="javascript:;" data-name="大" id="odds_59" data-odds="59" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_59" data-amount="59">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_59" data-szsz="59" data-did="14">
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
                                        <a href="javascript:;" data-name="小" id="odds_60" data-odds="60" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_60" data-amount="60">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_60" data-szsz="60" data-did="14">
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
                                        <a href="javascript:;" data-name="單" id="odds_61" data-odds="61" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_61" data-amount="61">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_61" data-szsz="61" data-did="15">
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
                                        <a href="javascript:;" data-name="雙" id="odds_62" data-odds="62" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_62" data-amount="62">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_62" data-szsz="62" data-did="15">
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
                                        <a href="javascript:;" data-name="龍" id="odds_63" data-odds="63" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_63" data-amount="63">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="龍" class="black clearSzsz" id="szsz_63" data-szsz="63" data-did="16">
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
                                        <a href="javascript:;" data-name="虎" id="odds_64" data-odds="64" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_64" data-amount="64">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="虎" class="black clearSzsz" id="szsz_64" data-szsz="64" data-did="16">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d4ze"></b>
                                    </b>
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
                                    第五名
                                </th>
                            </tr>
                            <tr>
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
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="1" id="odds_65" data-odds="65" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_65" data-amount="65">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_65" data-szsz="65" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="2" id="odds_66" data-odds="66" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_66" data-amount="66">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_66" data-szsz="66" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="3" id="odds_67" data-odds="67" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_67" data-amount="67">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_67" data-szsz="67" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="4" id="odds_68" data-odds="68" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_68" data-amount="68">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_68" data-szsz="68" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="5" id="odds_69" data-odds="69" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_69" data-amount="69">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_69" data-szsz="69" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="6" id="odds_70" data-odds="70" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_70" data-amount="70">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_70" data-szsz="70" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="7" id="odds_71" data-odds="71" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_71" data-amount="71">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_71" data-szsz="71" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="8" id="odds_72" data-odds="72" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_72" data-amount="72">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_72" data-szsz="72" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="9" id="odds_73" data-odds="73" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_73" data-amount="73">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_73" data-szsz="73" data-did="17">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="10" id="odds_74" data-odds="74" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_74" data-amount="74">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_74" data-szsz="74" data-did="17">
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
                                        <a href="javascript:;" data-name="大" id="odds_75" data-odds="75" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_75" data-amount="75">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_75" data-szsz="75" data-did="18">
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
                                        <a href="javascript:;" data-name="小" id="odds_76" data-odds="76" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_76" data-amount="76">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_76" data-szsz="76" data-did="18">
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
                                        <a href="javascript:;" data-name="單" id="odds_77" data-odds="77" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_77" data-amount="77">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_77" data-szsz="77" data-did="19">
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
                                        <a href="javascript:;" data-name="雙" id="odds_78" data-odds="78" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_78" data-amount="78">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_78" data-szsz="78" data-did="19">
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
                                        <a href="javascript:;" data-name="龍" id="odds_79" data-odds="79" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_79" data-amount="79">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="龍" class="black clearSzsz" id="szsz_79" data-szsz="79" data-did="20">
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
                                        <a href="javascript:;" data-name="虎" id="odds_80" data-odds="80" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_80" data-amount="80">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="虎" class="black clearSzsz" id="szsz_80" data-szsz="80" data-did="20">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d5ze"></b>
                                    </b>
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
                                    第六名
                                </th>
                            </tr>
                            <tr>
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
                            <tbody class="descOrasc" id="block4">
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="1" id="odds_81" data-odds="81" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_81" data-amount="81">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_81" data-szsz="81" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="2" id="odds_82" data-odds="82" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_82" data-amount="82">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_82" data-szsz="82" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="3" id="odds_83" data-odds="83" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_83" data-amount="83">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_83" data-szsz="83" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="4" id="odds_84" data-odds="84" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_84" data-amount="84">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_84" data-szsz="84" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="5" id="odds_85" data-odds="85" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_85" data-amount="85">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_85" data-szsz="85" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="6" id="odds_86" data-odds="86" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_86" data-amount="86">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_86" data-szsz="86" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="7" id="odds_87" data-odds="87" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_87" data-amount="87">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_87" data-szsz="87" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="8" id="odds_88" data-odds="88" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_88" data-amount="88">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_88" data-szsz="88" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="9" id="odds_89" data-odds="89" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_89" data-amount="89">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_89" data-szsz="89" data-did="21">
                                    </a>
                                </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
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
                                        <a href="javascript:;" data-name="10" id="odds_90" data-odds="90" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_90" data-amount="90">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_90" data-szsz="90" data-did="21">
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
                                        <a href="javascript:;" data-name="大" id="odds_91" data-odds="91" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_91" data-amount="91">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_91" data-szsz="91" data-did="22">
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
                                        <a href="javascript:;" data-name="小" id="odds_92" data-odds="92" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_92" data-amount="92">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_92" data-szsz="92" data-did="22">
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
                                        <a href="javascript:;" data-name="單" id="odds_93" data-odds="93" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_93" data-amount="93">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_93" data-szsz="93" data-did="23">
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
                                        <a href="javascript:;" data-name="雙" id="odds_94" data-odds="94" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_94" data-amount="94">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_94" data-szsz="94" data-did="23">
                                    </a>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d6ze"></b>
                                    </b>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td align="center">&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center"><b> <a href="javascript:;" id="nowPageOpen" class="blue">開放</a></b> <span class="burster">/</span> <b> <a href="javascript:;" id="nowPageClose" class="red">停押</a></b>&nbsp;&nbsp;&nbsp;&nbsp; <b> <a href="javascript:;" id="allOpen" class="blue">全部開</a></b> <span class="burster">/</span> <b> <a href="javascript:;" id="allClose" class="red">全部停</a></b> </td>
                            </tr>
                        </table></td>
                    <td width="3">
                    </td>
                    <td valign="top" width="140">
                        <table class="t_list">
                            <tr>
                                <th width="140">
                                    總額：
                                    <b id="numCounts" class="green">0</b>
                                </th>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_1.aspx" href="javascript:;">
                                        冠亞軍和：
                                        <b data-amountcount="36" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_1.aspx" href="javascript:;">
                                        冠亞大小：
                                        <b data-amountcount="37" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_1.aspx" href="javascript:;">
                                        冠亞單雙：
                                        <b data-amountcount="38" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_1.aspx" href="javascript:;">
                                        冠軍總：
                                        <b data-amountcount="1" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_1.aspx" href="javascript:;">
                                        亞軍總：
                                        <b data-amountcount="5" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_2.aspx" href="javascript:;">
                                        第三名總：
                                        <b data-amountcount="9" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_2.aspx" href="javascript:;">
                                        第四名總：
                                        <b data-amountcount="13" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_2.aspx" href="javascript:;">
                                        第五名總：
                                        <b data-amountcount="17" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_2.aspx" href="javascript:;">
                                        第六名總：
                                        <b data-amountcount="21" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_3.aspx" href="javascript:;">
                                        第七名總：
                                        <b data-amountcount="24" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_3.aspx" href="javascript:;">
                                        第八名總：
                                        <b data-amountcount="27" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_3.aspx" href="javascript:;">
                                        第九名總：
                                        <b data-amountcount="30" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdbg5">
                                    <a class="black kcmx" data-page="Betimes_3.aspx" href="javascript:;">
                                        第十名總：
                                        <b data-amountcount="33" class="green">0</b>
                                    </a>
                                </td>
                            </tr>
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
                            <tbody id="lmcl">
                            </tbody>
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
            <!-- 平均虧損： <input type="text" name="textfield" class="text w80" />
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
            </button>
            -->
        </td>
        <td class="bottomRightBg">
        </td>
    </tr>
</table>
<script>
    (function() {
        parent.playids = '9,10,11,12,13,14,15,16,17,18,19,20,21,22,23';//大类玩法ID
        parent.isopt = '0';//是否有权限调整赔率
        parent.issllowsale = '1'; //是否可以走飞
        parent.usertype = '0';//用户类别
        parent.isLm = 0;
        parent.isShortcut = 1;
        parent.jeucode = '12120156324017';//下注验证
        parent.shortcutData = {
            'empty': [-1],  // 空
            "live": [6,7,8,9,10],  // 大
            'small': [1,2,3,4,5],  // 小
            'single': [1,3,5,7,9],  // 单
            'double': [2,4,6,8,10]  // 双
        };
        parent.playpage = 'p2';
    })();
</script>
</body>
</html>
