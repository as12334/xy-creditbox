<%--
  Created by IntelliJ IDEA.
  User: block
  Date: 2019/12/12
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
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
                            七、八、九、十名
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
                                                    第七名
                                                </option>
                                                <option value="block2">
                                                    第八名
                                                </option>
                                                <option value="block3">
                                                    第九名
                                                </option>
                                                <option value="block4">
                                                    第十名
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
                                    第七名										</th>
                            </tr>
                            <tr>
                                <td class="tdbg1" width="15%">
                                    號碼										</td>
                                <td class="tdbg1" width="30%">
                                    賠率										</td>
                                <td class="tdbg1">
                                    注額										</td>
                                <td class="tdbg1">
                                    虧盈										</td>
                            </tr>
                            </thead>
                            <tbody class="descOrasc" id="block1">
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
                                            1		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="1" id="odds_95" data-odds="95" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_95" data-amount="95">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_95" data-szsz="95" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
                                            2		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="2" id="odds_96" data-odds="96" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_96" data-amount="96">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_96" data-szsz="96" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
                                            3		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="3" id="odds_97" data-odds="97" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_97" data-amount="97">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_97" data-szsz="97" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
                                            4		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="4" id="odds_98" data-odds="98" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_98" data-amount="98">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_98" data-szsz="98" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
                                            5		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="5" id="odds_99" data-odds="99" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_99" data-amount="99">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_99" data-szsz="99" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
                                            6		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="6" id="odds_100" data-odds="100" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_100" data-amount="100">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_100" data-szsz="100" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
                                            7		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="7" id="odds_101" data-odds="101" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_101" data-amount="101">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_101" data-szsz="101" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
                                            8		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="8" id="odds_102" data-odds="102" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_102" data-amount="102">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_102" data-szsz="102" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
                                            9		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="9" id="odds_103" data-odds="103" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_103" data-amount="103">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_103" data-szsz="103" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
                                            10		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="10" id="odds_104" data-odds="104" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_104" data-amount="104">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_104" data-szsz="104" data-did="24">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="大" id="odds_105" data-odds="105" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_105" data-amount="105">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_105" data-szsz="105" data-did="25">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="小" id="odds_106" data-odds="106" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_106" data-amount="106">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_106" data-szsz="106" data-did="25">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="單" id="odds_107" data-odds="107" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_107" data-amount="107">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_107" data-szsz="107" data-did="26">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="雙" id="odds_108" data-odds="108" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_108" data-amount="108">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_108" data-szsz="108" data-did="26">	                                        </a>	                                    </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d7ze"></b>											</b>										</td>
                            </tr>
                            </tbody>
                        </table>						</td>
                    <td width="3">						</td>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th colspan="4">
                                    第八名										</th>
                            </tr>
                            <tr>
                                <td class="tdbg1" width="15%">
                                    號碼										</td>
                                <td class="tdbg1" width="30%">
                                    賠率										</td>
                                <td class="tdbg1">
                                    注額										</td>
                                <td class="tdbg1">
                                    虧盈										</td>
                            </tr>
                            </thead>
                            <tbody class="descOrasc" id="block2">
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
                                            1		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="1" id="odds_109" data-odds="109" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_109" data-amount="109">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_109" data-szsz="109" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
                                            2		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="2" id="odds_110" data-odds="110" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_110" data-amount="110">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_110" data-szsz="110" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
                                            3		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="3" id="odds_111" data-odds="111" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_111" data-amount="111">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_111" data-szsz="111" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
                                            4		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="4" id="odds_112" data-odds="112" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_112" data-amount="112">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_112" data-szsz="112" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
                                            5		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="5" id="odds_113" data-odds="113" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_113" data-amount="113">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_113" data-szsz="113" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
                                            6		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="6" id="odds_114" data-odds="114" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_114" data-amount="114">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_114" data-szsz="114" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
                                            7		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="7" id="odds_115" data-odds="115" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_115" data-amount="115">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_115" data-szsz="115" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
                                            8		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="8" id="odds_116" data-odds="116" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_116" data-amount="116">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_116" data-szsz="116" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
                                            9		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="9" id="odds_117" data-odds="117" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_117" data-amount="117">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_117" data-szsz="117" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
                                            10		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="10" id="odds_118" data-odds="118" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_118" data-amount="118">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_118" data-szsz="118" data-did="27">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="大" id="odds_119" data-odds="119" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_119" data-amount="119">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_119" data-szsz="119" data-did="28">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="小" id="odds_120" data-odds="120" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_120" data-amount="120">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_120" data-szsz="120" data-did="28">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="單" id="odds_121" data-odds="121" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_121" data-amount="121">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_121" data-szsz="121" data-did="29">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="雙" id="odds_122" data-odds="122" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_122" data-amount="122">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_122" data-szsz="122" data-did="29">	                                        </a>	                                    </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d8ze"></b>											</b>										</td>
                            </tr>
                            </tbody>
                        </table>						</td>
                    <td width="3">						</td>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th colspan="4">
                                    第九名										</th>
                            </tr>
                            <tr>
                                <td class="tdbg1" width="15%">
                                    號碼										</td>
                                <td class="tdbg1" width="30%">
                                    賠率										</td>
                                <td class="tdbg1">
                                    注額										</td>
                                <td class="tdbg1">
                                    虧盈										</td>
                            </tr>
                            </thead>
                            <tbody class="descOrasc" id="block3">
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
                                            1		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="1" id="odds_123" data-odds="123" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_123" data-amount="123">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_123" data-szsz="123" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
                                            2		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="2" id="odds_124" data-odds="124" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_124" data-amount="124">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_124" data-szsz="124" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
                                            3		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="3" id="odds_125" data-odds="125" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_125" data-amount="125">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_125" data-szsz="125" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
                                            4		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="4" id="odds_126" data-odds="126" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_126" data-amount="126">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_126" data-szsz="126" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
                                            5		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="5" id="odds_127" data-odds="127" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_127" data-amount="127">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_127" data-szsz="127" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
                                            6		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="6" id="odds_128" data-odds="128" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_128" data-amount="128">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_128" data-szsz="128" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
                                            7		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="7" id="odds_129" data-odds="129" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_129" data-amount="129">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_129" data-szsz="129" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
                                            8		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="8" id="odds_130" data-odds="130" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_130" data-amount="130">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_130" data-szsz="130" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
                                            9		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="9" id="odds_131" data-odds="131" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_131" data-amount="131">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_131" data-szsz="131" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
                                            10		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="10" id="odds_132" data-odds="132" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_132" data-amount="132">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_132" data-szsz="132" data-did="30">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="大" id="odds_133" data-odds="133" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_133" data-amount="133">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_133" data-szsz="133" data-did="31">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="小" id="odds_134" data-odds="134" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_134" data-amount="134">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_134" data-szsz="134" data-did="31">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="單" id="odds_135" data-odds="135" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_135" data-amount="135">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_135" data-szsz="135" data-did="32">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="雙" id="odds_136" data-odds="136" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_136" data-amount="136">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_136" data-szsz="136" data-did="32">	                                        </a>	                                    </td>
                            </tr>
                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d9ze"></b>											</b>										</td>
                            </tr>
                            </tbody>
                        </table>						</td>
                    <td width="3">						</td>
                    <td valign="top">
                        <table class="t_list">
                            <thead>
                            <tr>
                                <th colspan="4">
                                    第十名										</th>
                            </tr>
                            <tr>
                                <td class="tdbg1" width="15%">
                                    號碼										</td>
                                <td class="tdbg1" width="30%">
                                    賠率										</td>
                                <td class="tdbg1">
                                    注額										</td>
                                <td class="tdbg1">
                                    虧盈										</td>
                            </tr>
                            </thead>
                            <tbody class="descOrasc" id="block4">
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_1 ballOpenBtn">
                                            1		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="1" id="odds_137" data-odds="137" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_137" data-amount="137">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="1" class="black clearSzsz" id="szsz_137" data-szsz="137" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_2 ballOpenBtn">
                                            2		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="2" id="odds_138" data-odds="138" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_138" data-amount="138">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="2" class="black clearSzsz" id="szsz_138" data-szsz="138" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_3 ballOpenBtn">
                                            3		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="3" id="odds_139" data-odds="139" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_139" data-amount="139">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="3" class="black clearSzsz" id="szsz_139" data-szsz="139" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_4 ballOpenBtn">
                                            4		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="4" id="odds_140" data-odds="140" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_140" data-amount="140">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="4" class="black clearSzsz" id="szsz_140" data-szsz="140" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_5 ballOpenBtn">
                                            5		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="5" id="odds_141" data-odds="141" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_141" data-amount="141">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="5" class="black clearSzsz" id="szsz_141" data-szsz="141" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_6 ballOpenBtn">
                                            6		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="6" id="odds_142" data-odds="142" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_142" data-amount="142">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="6" class="black clearSzsz" id="szsz_142" data-szsz="142" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_7 ballOpenBtn">
                                            7		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="7" id="odds_143" data-odds="143" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_143" data-amount="143">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="7" class="black clearSzsz" id="szsz_143" data-szsz="143" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_8 ballOpenBtn">
                                            8		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="8" id="odds_144" data-odds="144" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_144" data-amount="144">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="8" class="black clearSzsz" id="szsz_144" data-szsz="144" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_9 ballOpenBtn">
                                            9		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="9" id="odds_145" data-odds="145" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_145" data-amount="145">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="9" class="black clearSzsz" id="szsz_145" data-szsz="145" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="f14 F_Ball_10 ballOpenBtn">
                                            10		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="10" id="odds_146" data-odds="146" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_146" data-amount="146">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="10" class="black clearSzsz" id="szsz_146" data-szsz="146" data-did="33">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            大		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="大" id="odds_147" data-odds="147" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_147" data-amount="147">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="大" class="black clearSzsz" id="szsz_147" data-szsz="147" data-did="34">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            小		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="小" id="odds_148" data-odds="148" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_148" data-amount="148">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="小" class="black clearSzsz" id="szsz_148" data-szsz="148" data-did="34">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            單		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="單" id="odds_149" data-odds="149" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_149" data-amount="149">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="單" class="black clearSzsz" id="szsz_149" data-szsz="149" data-did="35">	                                        </a>	                                    </td>
                            </tr>
                            <tr class="oddsParent">
                                <td class="tdbg1">
                                    <b>
                                        <a href="javascript:;" class="grey ballOpenBtn">
                                            雙		                                        </a>		                                    </b>		                                </td>
                                <td class="oddsWrap">
                                    <div class="pDiv">
                                        <em class="addBtns">	                                            </em>
                                        <i class="minBtns">	                                            </i>
                                        <a href="javascript:;" data-name="雙" id="odds_150" data-odds="150" class="blue1 oddsTrim">	                                            </a>	                                        </div>	                                    </td>
                                <td>
                                    <a href="javascript:;" class="black clearAmout" id="amount_150" data-amount="150">	                                        </a>	                                    </td>
                                <td>
                                    <a href="javascript:;" data-name="雙" class="black clearSzsz" id="szsz_150" data-szsz="150" data-did="35">	                                        </a>	                                    </td>
                            </tr>

                            <tr>
                                <td colspan="4" class="tdbg4 grey1">
                                    <b>
                                        總額：
                                        <b class="green" id="d10ze"></b>											</b>										</td>
                            </tr>
                            </tbody>
                        </table>						</td>
                    <td width="3">						</td>
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
                    <td width="3">						</td>
                    <td valign="top" width="130">
                        <table class="t_list1">
                            <thead>
                            <tr>
                                <th>
                                    兩面長龍                                    </th>
                            </tr>
                            </thead>
                            <tbody id="lmcl">
                            </tbody>
                        </table>						</td>
                </tr>
                <tr>
                    <td colspan="7" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="center" height="10"></td>
                        </tr>
                        <tr>
                            <td align="center"><b> <a href="javascript:;" id="nowPageOpen" class="blue">開放</a></b> <span class="burster">/</span> <b> <a href="javascript:;" id="nowPageClose" class="red">停押</a></b>&nbsp;&nbsp;&nbsp;&nbsp; <b> <a href="javascript:;" id="allOpen" class="blue">全部開</a></b> <span class="burster">/</span> <b> <a href="javascript:;" id="allClose" class="red">全部停</a></b> </td>
                        </tr>
                    </table></td>
                    <td></td>
                    <td valign="top">&nbsp;</td>
                    <td></td>
                    <td valign="top">&nbsp;</td>
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
        parent.playids = '24,25,26,27,28,29,30,31,32,33,34,35';//大类玩法ID
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
        parent.playpage = 'p3';
    })();

</script>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
