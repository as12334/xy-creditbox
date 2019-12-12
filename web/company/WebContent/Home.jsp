<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.soul.commons.init.context.CommonContext" %><%--common js base--%>
<%@ include file="/include/include.inc.jsp" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="Keywords" Content="">
    <meta name="Description" Content="">
    <title>聚發管理</title>
    <meta name="keyword" content="">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <link href="${resRoot}/images/favicon.ico" rel="shortcut icon">


    <%@ include file="/include/include.head.jsp" %>

    <%@ include file="/include/include.js.jsp" %>

    <script language="javascript" type="text/javascript">
        var nav = {
            "即時注單": {
                "L_SIX": ["特碼|Betimes_tmZX2.aspx", "正碼|Betimes_zm.aspx", "正碼特|Betimes_zmt1.aspx", "連碼|Betimes_lm.aspx", "不中|Betimes_bz.aspx", "正碼1-6|Betimes_zm1-6.aspx", "特碼生肖色波|Betimes_tmsxsb.aspx", "生肖尾數|Betimes_sxws.aspx", "半波|Betimes_bb.aspx", "六肖...連|Betimes_lxl.aspx", "龍虎-特碼攤子|Betimes_lhtmtz.aspx", "七碼五行|Betimes_qmwx.aspx", "帳單|../L_SIX/Bill.aspx|1"],
                "gdkl10": ["第一球|Betimes_1.html", "第二球|Betimes_2.aspx", "第三球|Betimes_3.aspx", "第四球|Betimes_4.aspx", "第五球|Betimes_5.aspx", "第六球|Betimes_6.aspx", "第七球|Betimes_7.aspx", "第八球|Betimes_8.aspx", "總和、龍虎|Betimes_lh.aspx", "連碼|Betimes_lm.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_CQSC": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_PK10": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_XYNC": ["第一球|Betimes_1.aspx", "第二球|Betimes_2.aspx", "第三球|Betimes_3.aspx", "第四球|Betimes_4.aspx", "第五球|Betimes_5.aspx", "第六球|Betimes_6.aspx", "第七球|Betimes_7.aspx", "第八球|Betimes_8.aspx", "總和、家禽野獸|Betimes_zh.aspx", "連碼|Betimes_lm.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_K3": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_KL8": ["總和、比數、五行|Betimes_zh.aspx", "正碼|Betimes_zm.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_K8SC": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_PCDD": ["總項盤口|Betimes_zx.aspx", "特碼包三|Betimes_lm.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_XYFT5": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_PKBJL": ["總項盤口|Betimes_1.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_JSCAR": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_SPEED5": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_JSCQSC": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_JSPK10": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_JSSFC": ["第一球|Betimes_1.aspx", "第二球|Betimes_2.aspx", "第三球|Betimes_3.aspx", "第四球|Betimes_4.aspx", "第五球|Betimes_5.aspx", "第六球|Betimes_6.aspx", "第七球|Betimes_7.aspx", "第八球|Betimes_8.aspx", "總和、龍虎|Betimes_lh.aspx", "連碼|Betimes_lm.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_JSFT2": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_CAR168": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_SSC168": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_VRCAR": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_VRSSC": ["總項盤口|Betimes_zx.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_XYFTOA": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_XYFTSG": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"],
                "L_HAPPYCAR": ["冠、亞軍 組合|Betimes_1.aspx", "三、四、伍、六名|Betimes_2.aspx", "七、八、九、十名|Betimes_3.aspx", "帳單|../Bill_kc.aspx|1", "備份|../BillBackup_kc.aspx|1"]
            },
            "用戶管理": {"ut": ["分公司|${root}/account/fgs_list.html","股东|${root}/account/gd_list.html","總代理|${root}/account/zd_list.html", "代理|${root}/account/dl_list.html", "會員|${root}/account/hy_list.html", "子賬號|${root}/account/child_list.html"]},
            "個人管理": {"ut": ["信用資料|CreditInfo.aspx", "登陸日誌|ViewLog/LoginLog.aspx", "變更密碼|EditPwd.aspx|0", "自動補貨設定|/AutoLet/AutoLet_kc.aspx", "自動補貨變更記錄|/ViewLog/ViewAutoSaleLog.aspx"]},
            "報表查詢": {"ut": ["(新)報表查詢|ReportSearch/ReportNew.aspx", "報表查詢|ReportSearch/Report.aspx"]},
            "歷史開獎": {"ut": ["歷史開獎|${root}/LotteryPeriod/HistoryLottery.aspx"]},
            "站内消息": {"ut": ["站内消息|${root}/NewsManage/list.html"]},
            "安全退出": {"ut": ["Quit.aspx"]}
        }
        var jsver = 20191126;
        var isOpenUpper = "0";

        var ua = navigator.userAgent;
        var ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
            isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
            isAndroid = ua.match(/(Android)\s+([\d.]+)/),
            isMobile = isIphone || isAndroid;

    </script>
</head>
<body>
<!--头部-->
<div class="topBox widthAuto">
    <div class="jpBox" id="scrollDiv" style="right: 35px;">
        <ul id="jpWrap">
        </ul>
    </div>
    <div id="soundSwitch2" title="降賠聲音開關" class="lbOn lbOff" style="position: absolute; right: 0px; top: 48px; "></div>
    <div class="top">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="14%">
                    <div class="logo"><img id="logoText" src="${resRoot}/themes/images/sysname.png">
                        <div class="zi_logo" style="display:none;"></div>
                    </div>
                </td>
                <td width="16%">
                    <div class="userInfo">股東:jj0099

                    </div>
                </td>
                <td width="4%">
                    <div id="skinWrap">
                        <a href="javascript:;" class="skinBtn">換膚</a>
                        <div id="skinBox">
                        </div>
                    </div>
                </td>
                <td width="64%">
                    <div class="ggBox"></div>
                </td>
                <td width="2%">
                    <div id="soundSwitch" title="開獎聲音開關" class="lbOn lbOff"></div>
                </td>
            </tr>
        </table>
    </div>
    <div class="menuBox">
        <div class="navBox"><i class="up"></i><b class="down"></b><span id="menuText" data-id="0" data-url="L_KL10">廣東快樂十分</span>
            <div class="navList">
                <ul>
                    <li><a data-id="0" data-url="gdkl10" href="javascript:void(0)">廣東快樂十分</a></li>
                    <li><a data-id="1" data-url="L_CQSC" href="javascript:void(0)">重慶時時彩</a></li>
                    <li><a data-id="2" data-url="L_PK10" href="javascript:void(0)">北京賽車(PK10)</a></li>
                    <li><a data-id="6" data-url="L_K8SC" href="javascript:void(0)">幸運時時(3分鐘)</a></li>
                    <li><a data-id="9" data-url="L_XYFT5" href="javascript:void(0)">幸運飛艇(5分鍾)</a></li>
                    <li><a data-id="10" data-url="L_JSCAR" href="javascript:void(0)">極速賽車</a></li>
                    <li><a data-id="11" data-url="L_SPEED5" href="javascript:void(0)">極速時時彩</a></li>
                    <li><a data-id="12" data-url="L_JSPK10" href="javascript:void(0)">加拿大PK10(5分鐘)</a></li>
                    <li><a data-id="13" data-url="L_JSCQSC" href="javascript:void(0)">加拿大時時(5分鐘)</a></li>
                    <li><a data-id="22" data-url="L_HAPPYCAR" href="javascript:void(0)">幸運飛艇(3分鐘)</a></li>
                </ul>
            </div>
        </div>
        <div class="menu">
            <ul id="menuUl">

            </ul>
        </div>

    </div>
    <div class="navListBox">
    </div>
</div>

<div class="widthAuto">
    <iframe id="mainIframe" name="mainIframe" src="" width="100%" height="512"
            marginheight="0" marginwidth="0" frameborder="0" scrolling="no" class="BoxBg"
            style="height: 798px;"></iframe>
</div>
<%--<iframe id="connectionIframe" name="connectionIframe" src="ConnectionPage.aspx" width="100%" height="0" marginheight="0"--%>
        <%--marginwidth="0" frameborder="0" scrolling="no"></iframe>--%>

<script>
    var browserCode = '5606';//回传code ,浏览器不同用户
    var ajaxErrorLogSwitch = 'true';//前端错误日志记录开关
    var NewIsAdd = false;
    var myLayerIndex = '19841011';
    var myLayerIndexArr = [];
    // 是否可以再次点击
    var isClickAgin = true;

    // 是否开封盘倒计时对象
    var openTimer = null;
    var openTimer2 = null;
    var upWindowTime = null;
    // 開獎接口
    var upOpenPhaseTimer = null;
    var zodiacData = [0, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 12]; //生肖
    // 初始化倒计时
    var timer = null;
    var timer2 = null;

    var isShowLM_B = '1'; //0不显示连码B，1显示连码B
    var playids = '';
    var isopt = '';
    var issllowsale = '';
    var online_type = 'gd';//zj才能點擊查看在綫明細
    var usertype = '';//用户类别
    var aAllowSaleUserName = {"saleuser": {}};
    var negativesale = ''; // 是否可以负值走飞
    var isLm = 0;
    var isShortcut = 1;
    var jeucode = '';//下注验证
    var htmlData = {};
    var pathName = ''; //缓存路径名称
    var pathFolder = ''; //缓存文件夹名称
    var shortcutData = {};
    var playpage = '';
    var myLid = ''; // 彩种id
    var myPath = '';
    // 请求赔率id
    var oldId = 0;

    var masterids = '2';

    // 种类配置表 1: 六合彩  2：快彩
    var masterArr = ['1', '2'];

    var masterFirst = 0;

    var isScroll = true;

    // 声音开关
    var soundSwitch = true;
    var soundSwitch2 = true;

    //connectionIframe框架的高度
    var oConnectionIframeHeight = 20;

    var saleMin_kc = 10;
    var saleMin_six = 10;

    var pkbjl_playeramount = '';//
    var pkbjl_bankeramount = '';

    // 皮肤设置
    var skinData = {
        "Green": "綠色", "Blue": "蓝色", "Violet": "紫色", "Yellow": "黄色"
    }
    var skinPath = 'Blue';
    // 返回彩种配置
    function returnSid(sid) {
        if (sid == '100') {
            return '1';
        } else {
            return '2';
        }
    }

    function getDocHeight(doc) {
        doc = doc || document;
        var body = doc.body, html = doc.documentElement;
        if (!body || !html) {
            return;
        }
        var height = Math.max(body.scrollHeight, body.offsetHeight,
            html.clientHeight, html.scrollHeight, html.offsetHeight);
        return height;
    }
    function reHeight(id, h) {
        var hei = h ? h : 0;
        var ifrm = document.getElementById(id);
        var doc = ifrm.contentDocument ? ifrm.contentDocument :
            ifrm.contentWindow.document;
        ifrm.style.visibility = 'hidden';
        ifrm.style.height = getDocHeight(doc) + hei + "px"; // reset to minimal height ...
        // IE opt. for bing/msn needs a bit added or scrollbar appears
        // ifrm.style.height = getDocHeight( doc ) + 4 + hei + "px";
        return getDocHeight(doc) + hei;
    }
    // iframeHeight
    function setIframeHeight(b) {
        setTimeout(function () {
            var oIframe = $("#mainIframe");
            var hei = 0;
            var winHeight = $(window).height() - 100;
            if (!b) {
                hei = oIframe.contents().find('html body').height();
            } else {
                var h = oIframe.height();
                hei = h + b;
            }
            ;

            if (hei <= winHeight) {
                hei = winHeight - oConnectionIframeHeight;
            }
            ;
            oIframe.height(hei - 2);
        }, 10);
    };


    var iframeCurUrl = '';
    // dialog 是否刷新，跳转，关闭
    // isReload 0（否） 1（是） 2（关闭并刷新父页面）
    // isReplace '' 有值跳转
    // isClose 0（否） 1（是）
    function saveReload(isReload, isReplace, isClose) {
        var d = dialog.get('iframeDialog');
        if (isReload) {
            if (isReload == 2) {
                $('#mainIframe').attr('src', isReplace);
            } else {
                $('#mainIframe').attr('src', $('#mainIframe').attr('src').split('?')[0] + iframeCurUrl);
            }
        }
        if (isReplace) {
            $(d.iframeNode).attr('src', isReplace);
        }
        if (isClose) {
            d.close().remove();
        }
    }

    function setDialogBox(msg, okCallBack) {
        if (typeof okCallBack == "function") {
            dialog({
                title: "提示",
                content: msg,
                fixed: true,
                okValue: '確認',
                ok: function () {
                },
                onclose: function () {
                    okCallBack();
                }
            }).showModal();
        } else {
            dialog({
                title: "提示",
                content: msg,
                fixed: true
            }).showModal();
        }
    }

    // 点击跳转
    function kcClickMenu(src) {
        $(".navListBox a[data-iframe='" + src + "']").click();
    }

    // 设置用户类别根据索引
    function setUserType(i) {
        $(".navListBox>a").removeClass('onBtn');
        $(".navListBox>a").eq(i).addClass('onBtn');
    }
    var isNewBet = true;
    window.onload = function () {
        seajs.use('index', function () {
        });
    }

</script>

</body>
</html>
