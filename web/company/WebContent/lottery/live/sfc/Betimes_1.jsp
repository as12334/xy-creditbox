<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>

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

    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <script src="${resRoot}/js/config.js"></script>

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
                            第一球
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
                    <td colspan="12" id="upopennumber" class="gdkl10">
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
                                        <a href="javascript:;" data-name="01" id="odds_1" data-odds="1" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_1" data-amount="1">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="01" class="black clearSzsz" id="szsz_1" data-szsz="1" data-did="81">
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
                                        <a href="javascript:;" data-name="02" id="odds_2" data-odds="2" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_2" data-amount="2">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="02" class="black clearSzsz" id="szsz_2" data-szsz="2" data-did="81">
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
                                        <a href="javascript:;" data-name="03" id="odds_3" data-odds="3" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_3" data-amount="3">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="03" class="black clearSzsz" id="szsz_3" data-szsz="3" data-did="81">
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
                                        <a href="javascript:;" data-name="04" id="odds_4" data-odds="4" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_4" data-amount="4">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="04" class="black clearSzsz" id="szsz_4" data-szsz="4" data-did="81">
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
                                        <a href="javascript:;" data-name="05" id="odds_5" data-odds="5" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_5" data-amount="5">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="05" class="black clearSzsz" id="szsz_5" data-szsz="5" data-did="81">
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
                                        <a href="javascript:;" data-name="06" id="odds_6" data-odds="6" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_6" data-amount="6">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="06" class="black clearSzsz" id="szsz_6" data-szsz="6" data-did="81">
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
                                        <a href="javascript:;" data-name="07" id="odds_7" data-odds="7" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_7" data-amount="7">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="07" class="black clearSzsz" id="szsz_7" data-szsz="7" data-did="81">
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
                                        <a href="javascript:;" data-name="08" id="odds_8" data-odds="8" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_8" data-amount="8">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="08" class="black clearSzsz" id="szsz_8" data-szsz="8" data-did="81">
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
                                        <a href="javascript:;" data-name="09" id="odds_9" data-odds="9" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_9" data-amount="9">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="09" class="black clearSzsz" id="szsz_9" data-szsz="9" data-did="81">
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
                                        <a href="javascript:;" data-name="10" id="odds_10" data-odds="10" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_10" data-amount="10">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_10" data-szsz="10" data-did="81">
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
                                        <a href="javascript:;" data-name="11" id="odds_11" data-odds="11" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_11" data-amount="11">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="11" class="black clearSzsz" id="szsz_11" data-szsz="11" data-did="81">
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
                                        <a href="javascript:;" data-name="12" id="odds_12" data-odds="12" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_12" data-amount="12">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="12" class="black clearSzsz" id="szsz_12" data-szsz="12" data-did="81">
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
                                        <a href="javascript:;" data-name="13" id="odds_13" data-odds="13" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_13" data-amount="13">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="13" class="black clearSzsz" id="szsz_13" data-szsz="13" data-did="81">
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
                                        <a href="javascript:;" data-name="14" id="odds_14" data-odds="14" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_14" data-amount="14">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="14" class="black clearSzsz" id="szsz_14" data-szsz="14" data-did="81">
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
                                        <a href="javascript:;" data-name="15" id="odds_15" data-odds="15" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_15" data-amount="15">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="15" class="black clearSzsz" id="szsz_15" data-szsz="15" data-did="81">
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
                                        <a href="javascript:;" data-name="16" id="odds_16" data-odds="16" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_16" data-amount="16">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="16" class="black clearSzsz" id="szsz_16" data-szsz="16" data-did="81">
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
                                        <a href="javascript:;" data-name="17" id="odds_17" data-odds="17" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_17" data-amount="17">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="17" class="black clearSzsz" id="szsz_17" data-szsz="17" data-did="81">
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
                                        <a href="javascript:;" data-name="18" id="odds_18" data-odds="18" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_18" data-amount="18">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="18" class="black clearSzsz" id="szsz_18" data-szsz="18" data-did="81">
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
                                        <a href="javascript:;" data-name="19" id="odds_19" data-odds="19" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_19" data-amount="19">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="19" class="black clearSzsz" id="szsz_19" data-szsz="19" data-did="81">
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
                                        <a href="javascript:;" data-name="20" id="odds_20" data-odds="20" class="blue1 oddsTrim">
                                        </a>
                                    </div>
                                </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_20" data-amount="20">
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:;" data-name="20" class="black clearSzsz" id="szsz_20" data-szsz="20" data-did="81">
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
                                    號碼                                            </th>
                                <th width="30%">
                                    賠率                                            </th>
                                <th>
                                    注額                                            </th>
                                <th>
                                    虧盈                                            </th>
                            </tr>
                            </thead>
                            <tbody id="block3">
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="大" id="odds_21" data-odds="21" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_21" data-amount="21">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_21" data-szsz="21" data-did="82">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="小" id="odds_22" data-odds="22" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_22" data-amount="22">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_22" data-szsz="22" data-did="82">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="單" id="odds_23" data-odds="23" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_23" data-amount="23">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_23" data-szsz="23" data-did="83">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="雙" id="odds_24" data-odds="24" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_24" data-amount="24">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_24" data-szsz="24" data-did="83">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            尾大                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="尾大" id="odds_27" data-odds="27" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_27" data-amount="27">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="尾大" class="black clearSzsz" id="szsz_27" data-szsz="27" data-did="84">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            尾小                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="尾小" id="odds_28" data-odds="28" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_28" data-amount="28">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="尾小" class="black clearSzsz" id="szsz_28" data-szsz="28" data-did="84">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            合單                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="合單" id="odds_25" data-odds="25" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_25" data-amount="25">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="合單" class="black clearSzsz" id="szsz_25" data-szsz="25" data-did="85">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            合雙                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="合雙" id="odds_26" data-odds="26" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_26" data-amount="26">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="合雙" class="black clearSzsz" id="szsz_26" data-szsz="26" data-did="85">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            東                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="東" id="odds_251" data-odds="251" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_251" data-amount="251">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="東" class="black clearSzsz" id="szsz_251" data-szsz="251" data-did="121">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            南                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="南" id="odds_252" data-odds="252" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_252" data-amount="252">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="南" class="black clearSzsz" id="szsz_252" data-szsz="252" data-did="121">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            西                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="西" id="odds_253" data-odds="253" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_253" data-amount="253">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="西" class="black clearSzsz" id="szsz_253" data-szsz="253" data-did="121">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            北                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="北" id="odds_254" data-odds="254" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_254" data-amount="254">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="北" class="black clearSzsz" id="szsz_254" data-szsz="254" data-did="121">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            中                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="中" id="odds_283" data-odds="283" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_283" data-amount="283">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="中" class="black clearSzsz" id="szsz_283" data-szsz="283" data-did="122">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            發                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="發" id="odds_284" data-odds="284" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_284" data-amount="284">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="發" class="black clearSzsz" id="szsz_284" data-szsz="284" data-did="122">                                                </a>                                            </td>
                            </tr>
                            <tr class='oddsParent'>
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            白                                                    </a>                                                </b>                                            </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">                                                    </em>
                                        <i class="minBtns">                                                    </i>
                                        <a href="javascript:;" data-name="白" id="odds_285" data-odds="285" class="blue1 oddsTrim">                                                    </a>                                                </div>                                            </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_285" data-amount="285">                                                </a>                                            </td>
                                <td>
                                    <a href="javascript:;" data-name="白" class="black clearSzsz" id="szsz_285" data-szsz="285" data-did="122">                                                </a>                                            </td>
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
        </td>
        <td class="bottomRightBg">
        </td>
    </tr>
    </tbody>
</table>
<script>
    (function () {
        parent.playids = '82_22,82_21,84_27,83_23,83_24,85_25,85_26,84_28,81_9,81_1,81_5,81_15,122_283,81_2,81_3,81_4,81_6,81_7,81_8,81_10,81_11,81_12,81_17,81_18,81_19,81_20,121_254,121_252,121_251,122_284,122_285,121_253,81_13,81_14,81_16'; //大类玩法ID
//        parent.playids = '82_22,82_21,84_27,83_23,83_24,85_25,85_26,84_28,81_9,81_1,81_5,81_15,122_283,81_2,81_3,81_4,81_6,81_7,81_8,81_10,81_11,81_12,81_17,81_18,81_19,81_20,121_254,121_252,121_251,122_284,122_285,121_253,81_13,81_14,81_16'; //大类玩法ID
        parent.isopt = '0'; //是否有权限调整赔率
        parent.issllowsale = '1'; //是否可以走飞
        parent.usertype = '0'; //用户类别
        parent.isLm = 0;
        parent.isShortcut = 1;
        parent.jeucode = '12120820103164'; //下注验证
        parent.shortcutData = {
            'empty': [-1],  // 空
            "live": [11,12,13,14,15,16,17,18,19,20],  // 大
            'small': [1,2,3,4,5,6,7,8,9,10],  // 小
            'single': [1,3,5,7,9,11,13,15,17,19],  // 单
            'double': [2,4,6,8,10,12,14,16,18,20],  // 双
            'singleTogether': [1,3,5,7,9,10,12,14,16,18],  // 合单
            'doubleTogether': [2,4,6,8,11,13,15,17,19,20]  // 合双
        };
        parent.playpage = 'p1';
    })();
</script>
</body>
</html>
