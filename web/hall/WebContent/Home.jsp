<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>

    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <link id="skin" rel="stylesheet" type="text/css" href="${resRoot}/themes/red/skin.css?v=${rcVersion}"/>



    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>聚發</title>
    <meta name="keyword" content="">

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <link href="http://mem1.vnfbsg517.hlbrhuanyou.com:88/favicon.ico" rel="shortcut icon">

    <script>
        var jsver = 20170128;
        var isOpenUpper = "0";
    </script>

    <!--[if IE 6]>
    <script src="Scripts/DD_belatedPNG_0.0.8a.js"></script>
    <script>
        DD_belatedPNG.fix('.logo, img,.logo img, .user_pic, .user_select a, .happy10, .blue_ball, .red_ball, .notice, #skinChange, .skin_btn, .ball.small span,.lbOn,.lbOff');
    </script>
    <![endif]-->

    <%--<link rel="stylesheet" href="./聚發_files/ui-dialog.css">--%>
    <link rel="stylesheet" type="text/css" href="${resRoot}/themes/ui-dialog.css?v=${rcVersion}"/>


</head>
<body>
<div class="top_bar base-clear">
    <div class="logo"><img id="logoText" src="${resRoot}/themes/images/sysname.png"></div>
    <div class="user_info_wrap base-clear">
        <div class="user_pic"></div>
        <div class="user_info">
            <p class="user_name">as12334
                <span id="skinChange"><a class="skin_btn" href="javascript:;">換膚</a>
					<em id="skinBox"><a data-skin="Yellow" class="user_skin skin_yellow" href="javascript:;"><i></i>栀子黄</a><a
                            data-skin="Blue" class="user_skin skin_blue" href="javascript:;"><i></i>天空藍</a><a
                            data-skin="Red" class="user_skin skin_red on" href="javascript:;"><i></i>寶石紅</a><a
                            data-skin="Green" class="user_skin skin_green" href="javascript:;"><i></i>翡翠綠</a></em>
				</span>
                <b id="soundSwitch" title="聲音開關" class="lbOn"></b>
            </p>
            <p><span class="nameType">(快)</span>額度：<span id="creditSpan">0</span><em>|</em> <span
                    class="nameType">(快)</span>可用：<span id="usableCreditSpan">0</span></p>
        </div>
        <div class="user_select">
            <a id="user_select_btn" href="javascript:void(0)"></a>
            <div class="user_select_item" style="width: 176px;"><span
                    class="user_select_itme_left"><h3>快彩</h3><p>盘　　口：A</p><p>信用額度：0</p><p>可用金額：0</p><p></p></span></div>
        </div>
    </div>
</div>
<div class="top_menu base-clear">
    <div class="menu">
        <a id="menuText" href="javascript:void(0)" data-id="0" data-type="2"><span>廣東快樂十分</span><i></i></a>
        <div>
            <ul id="menuList">
                <li><a data-id="0" data-type="2" data-url="gdklsf" href="javascript:void(0)">廣東快樂十分</a></li>
                <li><a data-id="1" data-type="2" data-url="L_CQSC" href="javascript:void(0)">重慶時時彩</a></li>
                <li><a data-id="2" data-type="2" data-url="L_PK10" href="javascript:void(0)">北京賽車(PK10)</a></li>
                <li><a data-id="6" data-type="2" data-url="L_K8SC" href="javascript:void(0)">幸運飛艇(3分鍾)</a></li>
                <li><a data-id="9" data-type="2" data-url="xyft" href="javascript:void(0)">幸運飛艇(5分鍾)</a></li>
                <li><a data-id="10" data-type="2" data-url="L_JSCAR" href="javascript:void(0)">極速賽車</a></li>
                <li><a data-id="11" data-type="2" data-url="L_SPEED5" href="javascript:void(0)">極速時時彩</a></li>
                <li><a data-id="12" data-type="2" data-url="L_JSPK10" href="javascript:void(0)">極速PK10(5分鍾)</a></li>
                <li><a data-id="13" data-type="2" data-url="L_JSCQSC" href="javascript:void(0)">極速時時彩(5分鐘)</a></li>
            </ul>
        </div>
    </div>
    <div class="nav base-clear">

        <a data-action="GameHall.aspx" href="javascript:;"><i class="icon9"></i><span>遊戲大廳</span></a>

        <a data-action="CreditInfo.aspx" href="javascript:;"><i class="icon1"></i><span>信用資料</span></a>
        <a data-action="LoginLog.aspx" href="javascript:;"><i class="icon8"></i><span>登錄日誌</span></a>
        <a data-action="ResetPasswd.aspx" href="javascript:;"><i class="icon2"></i><span>修改密碼</span></a>

        <a data-action="Bet.aspx" href="javascript:;"><i class="icon3"></i><span>未結明細</span></a>
        <a data-action="ReportBill/Report.aspx" href="javascript:;"><i class="icon4"></i><span>結算報表</span></a>

        <a data-action="Result.aspx" href="javascript:;"><i class="icon5"></i><span>歷史開獎</span></a>
        <a data-action="Rule.aspx" href="javascript:;"><i class="icon6"></i><span>玩法規則</span></a>
        <a data-action="" href="http://mem1.vnfbsg517.hlbrhuanyou.com:88/Quit.aspx" style="border-right:none;"><i
                class="icon7"></i><span>安全退出</span></a>
    </div>
</div>
<iframe id="mainIframe" name="mainIframe" src="" width="100%" height="519" marginheight="0"
        marginwidth="0" frameborder="0" scrolling="no" style="height: 873px;"></iframe>
<div class="notice">
    <div class="notice_box">
        <div class="notice_p base-clear">
            <p>
                <marquee id="noticeLink" behavior="scroll" scrollamount="2" direction="left"
                         onmouseout="this.setAttribute(&#39;scrollamount&#39;, 2, 0);"
                         onmouseover="this.setAttribute(&#39;scrollamount&#39;, 0, 0);"><a data-action=""
                                                                                           href="javascript:;"><span>聚发原网址911yg.com改为847e.com 安全码656829备用网址863126.com  请各级代理会员知悉!!!</span><span>2019/10/20 0:00:00</span></a>
                </marquee>
            </p>

        </div>
    </div>
</div>
<%--<iframe id="connectionIframe" name="connectionIframe" src="./聚發_files/ConnectionPage.html" width="100%" height="0" marginheight="0" marginwidth="0" frameborder="0" scrolling="no"></iframe>--%>

<script>
    var lastData = {};
    var ajaxErrorLogSwitch = 'false';//前端错误日志记录开关
    var browserCode = '8300';
    var topDialog = null;
    // 六合彩可用额度
    var sixUsableCredit = 0;
    // 快彩可用额度
    var kcUsableCredit = 0;
    // 当前菜单ID
    var nowMenuId = '0';
    var useNowMenuId = '1';//1表示不起用cookies的默認彩種id,直接使用nowMenuId的值；0表示使用cookies的默認彩種id（按原來的邏輯）。
    // 游戏logo
    var LogoSrc = 'Images/xyft/logo.png';
    // 游戏名称
    var GameName = '';
    // 游戏路径
    var GamePath = '';
    // 分页用 == playpage
    var GamePage = '';
    // 当前页面索引初始值为零
    var PlayPageIndex = 0;
    // 生肖
    var zodiacData = [0, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12];
    //
    var zData = returnZodiacNumber(49, 'str');

    var zNum = returnZodiacNumber(49, 'num');

    var zData2 = returnZodiacNumber(48, 'str');

    var zNum2 = returnZodiacNumber(48, 'num');

    var zDataHtml = {};

    var zDataHtml2 = {};

    var isScroll = true;

    for (var key in zData) {
        zDataHtml[key] = '';
        for (var i = 0; i < zData[key].length; i++) {
            zDataHtml[key] += '<span class="No_' + zData[key][i] + '"></span>';
        }
    }
    for (var key in zData2) {
        zDataHtml2[key] = '';
        for (var i = 0; i < zData2[key].length; i++) {
            zDataHtml2[key] += '<span class="No_' + zData2[key][i] + '"></span>';
        }
    }
    // 返回生肖对应的号码 lef === 48(六肖，49号码为打和) || len === 49
    function returnZodiacNumber(len, type) {
        var zodiacNumberData = {};
        for (var i = 1; i <= 12; i++) {
            zodiacNumberData[i] = [];
        }
        for (var i = 1; i <= len; i++) {
            if (type == 'str') {
                zodiacNumberData[zodiacData[i]].push(i < 10 ? '0' + i : i + '');
            } else if (type == 'num') {
                zodiacNumberData[zodiacData[i]].push(i);
            }
        }
        return zodiacNumberData;
    }
    // 尾数
    var mantData = {
        '1': [1, 11, 21, 31, 41],
        '2': [2, 12, 22, 32, 42],
        '3': [3, 13, 23, 33, 43],
        '4': [4, 14, 24, 34, 44],
        '5': [5, 15, 25, 35, 45],
        '6': [6, 16, 26, 36, 46],
        '7': [7, 17, 27, 37, 47],
        '8': [8, 18, 28, 38, 48],
        '9': [9, 19, 29, 39, 49],
        '10': [10, 20, 30, 40]
    };
    var masterids = '2';//彩种大类

    var menuData = {
        "play_0": {
            "name": "廣東快樂十分",
            "url": "gdkl10",
            "page": {
                "gdkl10_lmp": "两面盘",
                "gdkl10_dq1_8": "单球1-8",
                "gdkl10_d1": "第一球",
                "gdkl10_d2": "第二球",
                "gdkl10_d3": "第三球",
                "gdkl10_d4": "第四球",
                "gdkl10_d5": ":第五球",
                "gdkl10_d6": "第六球",
                "gdkl10_d7": "第七球",
                "gdkl10_d8": "第八球",
                "gdkl10_zhlh": "总和龙虎",
                "gdkl10_lm": "连码"
            }
        },
        "play_1": {
            "name": "重慶時時彩",
            "url": "L_CQSC",
            "page": {
                "cqsc_lmp": "两面盘",
                "cqsc_dq1_5": "单球1-5",
                "cqsc_d1": "第一球",
                "cqsc_d2": "第二球",
                "cqsc_d3": "第三球",
                "cqsc_d4": "第四球",
                "cqsc_d5": ":第五球"
            }
        },
        "play_2": {
            "name": "北京賽車(PK10)",
            "url": "L_PK10",
            "page": {
                "pk10_lmp": "两面盘",
                "pk10_dq1_10": "单球1-10",
                "pk10_gy": "冠亚组合",
                "pk10_dq3_6": "三四五六名",
                "pk10_dq7_9": "七八九十名"
            }
        },
        "play_6": {
            "name": "幸運飛艇(3分鍾)",
            "url": "L_K8SC",
            "page": {
                "k8sc_lmp": "两面盘",
                "k8sc_dq1_5": "单球1-5",
                "k8sc_d1": "第一球",
                "k8sc_d2": "第二球",
                "k8sc_d3": "第三球",
                "k8sc_d4": "第四球",
                "k8sc_d5": ":第五球"
            }
        },
        "play_9": {
            "name": "幸運飛艇(5分鍾)",
            "url": "xyft",
            "page": {
                "xyft_lmp": "两面盘",
                "xyft_dq1_10": "单球1-10",
                "xyft_gy": "冠亚组合",
                "xyft_dq3_6": "三四五六名",
                "xyft_dq7_9": "七八九十名"
            }
        },
        "play_10": {
            "name": "極速賽車",
            "url": "L_JSCAR",
            "page": {
                "jscar_lmp": "两面盘",
                "jscar_dq1_10": "单球1-10",
                "jscar_gy": "冠亚组合",
                "jscar_dq3_6": "三四五六名",
                "jscar_dq7_9": "七八九十名"
            }
        },
        "play_11": {
            "name": "極速時時彩",
            "url": "L_SPEED5",
            "page": {
                "speed5_lmp": "两面盘",
                "speed5_dq1_5": "单球1-5",
                "speed5_d1": "第一球",
                "speed5_d2": "第二球",
                "speed5_d3": "第三球",
                "speed5_d4": "第四球",
                "speed5_d5": ":第五球"
            }
        },
        "play_12": {
            "name": "極速PK10(5分鍾)",
            "url": "L_JSPK10",
            "page": {
                "jspk10_lmp": "两面盘",
                "jspk10_dq1_10": "单球1-10",
                "jspk10_gy": "冠亚组合",
                "jspk10_dq3_6": "三四五六名",
                "jspk10_dq7_9": "七八九十名"
            }
        },
        "play_13": {
            "name": "極速時時彩(5分鐘)",
            "url": "L_JSCQSC",
            "page": {
                "jscqsc_lmp": "两面盘",
                "jscqsc_dq1_5": "单球1-5",
                "jscqsc_d1": "第一球",
                "jscqsc_d2": "第二球",
                "jscqsc_d3": "第三球",
                "jscqsc_d4": "第四球",
                "jscqsc_d5": ":第五球"
            }
        }
    };

    // 种类配置表
    var masterArr = ['1', '2'];

    var masterFirst = 0;

    var six_cash = '0';
    var kc_cash = '0';

    var currTypeId = '';
    // 声音开关
    var soundSwitch = true;

    // iframe是否准备好了
    var isReady = false;

    // 返回生肖
    function returnAnimal(i) {
        switch (i) {
            case 1:
                return "鼠";
            case 2:
                return "牛";
            case 3:
                return "虎";
            case 4:
                return "兔";
            case 5:
                return "龍";
            case 6:
                return "蛇";
            case 7:
                return "馬";
            case 8:
                return "羊";
            case 9:
                return "猴";
            case 10:
                return "雞";
            case 11:
                return "狗";
            case 12:
                return "豬";
        }
    }
    // 连码配置
    // 72
    // var maxLen = 45;
    var configLm = {
        "72_0": {"minLen": 2, "maxLen": 28},
        "73_0": {"minLen": 2, "maxLen": 45},
        "74_0": {"minLen": 2, "maxLen": 28},
        "75_0": {"minLen": 3, "maxLen": 20},
        "76_0": {"minLen": 3, "maxLen": 45},
        "77_0": {"minLen": 3, "maxLen": 20},
        "78_0": {"minLen": 4, "maxLen": 70},
        "79_0": {"minLen": 5, "maxLen": 56},
        "72_3": {"minLen": 2, "maxLen": 28},
        "73_3": {"minLen": 2, "maxLen": 45},
        "74_3": {"minLen": 2, "maxLen": 28},
        "75_3": {"minLen": 3, "maxLen": 20},
        "78_3": {"minLen": 4, "maxLen": 70},
        "79_3": {"minLen": 5, "maxLen": 56},
        "71014_7": {"minLen": 3, "maxLen": 56},
        "72_14": {"minLen": 2, "maxLen": 28},
        "73_14": {"minLen": 2, "maxLen": 45},
        "74_14": {"minLen": 2, "maxLen": 28},
        "75_14": {"minLen": 3, "maxLen": 20},
        "76_14": {"minLen": 3, "maxLen": 45},
        "77_14": {"minLen": 3, "maxLen": 20},
        "78_14": {"minLen": 4, "maxLen": 70},
        "79_14": {"minLen": 5, "maxLen": 56},
        "91016_100": {"minLen": 3, "maxLen": 56},
        "91017_100": {"minLen": 3, "maxLen": 56},
        "91018_100": {"minLen": 2, "maxLen": 28},
        "91019_100": {"minLen": 2, "maxLen": 28},
        "91020_100": {"minLen": 2, "maxLen": 28},
        "91040_100": {"minLen": 4, "maxLen": 70},
        "91037_100": {"minLen": 5, "maxLen": 56},
        "91047_100": {"minLen": 6, "maxLen": 28},
        "91048_100": {"minLen": 7, "maxLen": 8},
        "91049_100": {"minLen": 8, "maxLen": 1},
        "91050_100": {"minLen": 9, "maxLen": 1},
        "91051_100": {"minLen": 10, "maxLen": 1},
        "91030_100": {"minLen": 6, "maxLen": 1},
        "91031_100": {"minLen": 2, "maxLen": 28},
        "91032_100": {"minLen": 3, "maxLen": 56},
        "91033_100": {"minLen": 4, "maxLen": 70},
        "91034_100": {"minLen": 2, "maxLen": 28},
        "91035_100": {"minLen": 3, "maxLen": 56},
        "91036_100": {"minLen": 4, "maxLen": 70}
    };

    // 设置皮肤
    var skinData = {
        "Yellow": "栀子黄", "Blue": "天空藍", "Red": "寶石紅", "Green": "翡翠綠"
    }
    var skinPath = 'Red';

    var setMyLayer = function (url, title) {
        // $("body").myLayer({
        //     title: title,
        //     isMiddle: true,
        //     isShowBtn: false,
        //     url: url
        // });

        var d = dialog({
            title: title,
            url: url,
            fixed: true,
            onreset: function () {
                // console.log()
            },
            oniframeload: function () {
                this.reset()
            }
        });
        d.showModal();
    };

    var ddddd = function () {
    };
    //游戏大厅点击事件
    function menuClick(dataId) {
        seajs.use(['jquery'], function ($) {
            $("#menuList a[data-id=" + dataId + "]").click();
        });
    }


    function setCredit(a, b) {
        seajs.use(['global'], function (indexInit) {
            if (indexInit.usableCreditData.hasOwnProperty('game_' + currTypeId)) {
                indexInit.usableCreditData['game_' + currTypeId]['credit'] = a;
                indexInit.usableCreditData['game_' + currTypeId]['usable_credit'] = b;
            }
            indexInit.setCredit(currTypeId);
        });
    }

    function setHeight(b) {
        seajs.use(['global'], function (indexInit) {
            indexInit.setIframeHeight(b);
        });
    }

    function exit() {
        seajs.use(['global'], function (indexInit) {
            indexInit.isNoLogin();
        });
    }

    window.onload = function () {
        seajs.use(['jquery', 'global'], function ($, indexInit) {
            masterFirst = $.inArray(masterids.split(',')[0], masterArr);

            //首页初始化
            indexInit._init();

            $("#logoText").attr({
                'src': $("#logoText").attr('src') + '?' + Math.random()
            });
        });
    };
</script>


</body>
</html>