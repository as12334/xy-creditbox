<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@ include file="/include/include.inc.jsp" %>
    <%@ include file="/include/include.head.jsp" %>
    <%--<script src="${resComRoot}/js/lotterybox/common/main.js"></script>--%>

    <%@ include file="/include/include.js.jsp" %>
    <title>title</title>
    <meta name="keyword" content="">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EDGE">
    <script> if (top.location == self.location) top.location.href = "/"; </script>
    <link href="favicon.ico" rel="shortcut icon">

    <link id="Iframe_skin" rel="stylesheet" type="text/css" href="${resRoot}/themes/red/skin.css?v=${rcVersion}"/>

    <%--<link rel="stylesheet" href="/Styles/base.css">--%>
    <%--<link rel="stylesheet" href="/Styles/sub.css">--%>
    <%--<link rel="stylesheet" href="/Styles/BallCss/ball_all.css">--%>
    <%--<link rel="stylesheet" id="Iframe_skin" href="/Styles/Yellow/skin.css">--%>
    <script>var jsver=20170128;</script>
    <%--<script src="/Scripts/sea.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/seajs-css.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/juicer-min.js" type="text/javascript"></script>--%>
    <%--<script src="/Scripts/iframeConfig.js" type="text/javascript"></script>--%>
    <!--[if IE 6]>
    <script src="/Scripts/DD_belatedPNG_0.0.8a.js"></script>
    <script>
        DD_belatedPNG.fix('.logo, .user_pic, .user_select a, .happy10, .blue_ball, .red_ball, .notice, .game_pic img, .mtip .micon, .mtip .mclose,.mtip .mclose,.mtip .mclose');
    </script>
    <![endif]-->

</head>
<body>
<style>
    body{ background: none; }
</style>
<%--<link rel="stylesheet" href="/Styles/game.css">--%>

<div class="top_info">
    <div class="top_info_box base-clear">
        <div class="game_name_wrap base-clear">
            <div class="game_pic">

                <a href="http://www.gdfc.org.cn/play_list_game_9.html" target="_blank"><img id="game_logo" src="" alt=""></a>
            </div>
            <div class="game_name">
                <h5><a href="http://www.gdfc.org.cn/play_list_game_9.html" target="_blank" title="官網"><span id="game_big_name"></span></a> <span>-</span> <em id="game_small_name"></em></h5>
                <p><b><span id="intervaltime"></span></b>一期，每天<b><span id="begintime"></span>-<span id="endtime"></span></b>銷售</p>
                <p>今天已售 <b id="phase1" class="green"></b> 期，還剩 <b id="phase2" class="green"></b> 期</p>
            </div>
        </div>
        <div class="game_info_wrap">
            <h4><b class="red">今日輸贏：<i id="profit"></i></b>&nbsp;&nbsp;&nbsp;第<span id="NowJq" data-id=""></span>期，距離<label id="closeText">封盤</label>：<label data-time="4" id="closedTime" class="time time_loading"></label></h4>
            <h5>第<b id="newPhase"></b>期開獎：<strong id="prevBall" class="ball time_loading"></strong></h5>
        </div>
        <div class="game_tool">
            <p><span id="updateTime">0</span></p>
            <a class="look_history_btn" href="javascript:void(0)">查看近期開獎</a>
        </div>
    </div>
</div>

<div class="wrap">

    <!-- History start -->
    <div class="history_wrap">
        <table>
            <thead>
            <tr>
                <th>期數</th>
                <th>開獎時間</th>
                <th>開出號碼</th>
                <th colspan="4">總和</th>
                <th>龍虎</th>
            </tr>
            </thead>
            <tbody id="historyResult">
            </tbody>
        </table>
    </div>
    <!-- History end -->

    <div class="main base-clear">
        <div class="gameLeft">
            <div class="game_wrap">
                <div class="game_box tab_box">
                    <div class="game_box_title">
                        <ul class="base-clear">
                            <li class="active subBtn" data-id="${code}_lmp"><a href="javascript:void(0)">兩面盤</a></li>
                            <li class="subBtn" data-id="${code}_d1_8"><a href="javascript:void(0)">單球1-8</a></li>
                            <li class="subBtn" data-id="${code}_d1"><a href="javascript:void(0)">第一球</a></li>
                            <li class="subBtn" data-id="${code}_d2"><a href="javascript:void(0)">第二球</a></li>
                            <li class="subBtn" data-id="${code}_d3"><a href="javascript:void(0)">第三球</a></li>
                            <li class="subBtn" data-id="${code}_d4"><a href="javascript:void(0)">第四球</a></li>
                            <li class="subBtn" data-id="${code}_d5"><a href="javascript:void(0)">第五球</a></li>
                            <li class="subBtn" data-id="${code}_d6"><a href="javascript:void(0)">第六球</a></li>
                            <li class="subBtn" data-id="${code}_d7"><a href="javascript:void(0)">第七球</a></li>
                            <li class="subBtn" data-id="${code}_d8"><a href="javascript:void(0)">第八球</a></li>
                            <li class="subBtn" data-id="${code}_zhlh"><a href="javascript:void(0)">總和、龍虎</a></li>
                            <li data-type="lm" class="subBtn" data-id="${code}_lm"><a href="javascript:void(0)">連碼</a></li>
                        </ul>
                    </div>
                    <div class="game_box_con">

                        <div class="game_loading_wrap">
                            <p>正在为您加载<span>请您稍后</span></p>
                            <p class="game_loding"></p>
                            <p>如果您長時間未能載入頁面請點擊：<a href="javascript:;" id="game_reload">刷新</a></p>
                        </div>

                        <div class="game_item_warp">
                            <div id="gameBox" class="game_item">

                            </div>
                            <div class="game_tips_box">
                                <div class="game_tips_bg"></div>
                                <span class="tipsText"></span>
                            </div>
                        </div>


                        <!-- gameBoxTool start -->
                        <div class="game_box_tool base-clear">
                            <div class="tool_left">
                                <div id="tool_ys_wrap" class="t_left">
                                    <label for="tool_ys_input">快捷下注金额：</label><input id="tool_ys_input" class="input onlyNum" type="text"><i id="close" style="display: none;">x</i>
                                    <span><a href="javascript:void(0)">50</a> <a href="javascript:void(0)">100</a> <a href="javascript:void(0)">200</a> <a href="javascript:void(0)">500</a> <a href="javascript:void(0)">1000</a></span>
                                    <em><b>+</b>
                                        <strong>
                                            <input class="input onlyNum" type="text">
                                            <input class="input onlyNum" type="text">
                                            <input class="input onlyNum" type="text">
                                            <input class="input onlyNum" type="text">
                                            <input class="input onlyNum" type="text">
                                            <div class="base-clear">
                                            </div>
                                            <input class="btn" type="button" value="确定">
                                        </strong>
                                    </em>
                                </div>
                            </div>
                            <div class="t_right">
                                <input id="clearBtn" class="btn grayBtn" type="button" value="重填">
                                <input id="gameSubmit" class="btn hotBtn" type="button" value="提交">
                            </div>
                        </div>
                        <!-- gameBoxTool end -->
                    </div>
                </div>
            </div>

            <div class="hot_Cool">
                <table id="lrylResult">

                </table>
            </div>

            <!-- trend start -->
            <div id="cqlResult" class="trend_wrap tab_box">
            </div>
            <!-- trend end -->
        </div>

        <!-- rightBox start -->
        <div class="rightBox tab_box base-clear">
            <div class="left">
                <ul>
                    <li class="tab_btn active">兩<br />
                        面<br />
                        長<br />
                        龍
                    </li>
                    <li class="tab_btn">近<br />
                        期<br />
                        下<br />
                        注
                    </li>
                </ul>
            </div>
            <div class="right">
                <ul id="lmResult" class="tab_item base-clear active">
                </ul>
                <ul id="putResult" class="tab_item base-clear">
                </ul>
            </div>
        </div>
        <!-- rightBox end -->
    </div>
</div>

<div class="updata_wrap">
</div>
<div id="myWarp">
</div>

<!-- 历史开奖 公用框架模板结构 start -->
<script id="tpl_history" type="text/template">
    {@each jqkj as it}
    <tr>
        <td>&{it.phase}</td>
        <td>&{it.play_open_date}</td>
        <td>
            <strong class="ball">
                {@each it.draw_num as item}
                <span class="No_&{item}"></span>
                {@/each}
            </strong>
        </td>
        {@each it.total as item}
        <td>&&{item}</td>
        {@/each}
    </tr>
    {@/each}
</script>
<!-- 历史开奖 公用框架模板结构 end -->

<!-- 两面长龙 公用框架模板结构 start -->
<script id="tpl_lmcl" type="text/template">
    {@each lmcl as it, index}
    {@if it.cl_name.indexOf("-")>0 }
    {@if index % 2 != 0 }
    <li class="on"><span>&{it.cl_num}期</span>&{it.cl_name.split('-')[0]} - <b class="red">&{it.cl_name.split('-')[1]}</b></li>
    {@else}
    <li><span>&{it.cl_num}期</span>&{it.cl_name.split('-')[0]} - <b class="red">&{it.cl_name.split('-')[1]}</b></li>
    {@/if}
    {@else}
    {@if index % 2 != 0 }
    <li class="on"><span>&{it.cl_num}期</span>&{it.cl_name.split('-')[0]} <b class="red">&{it.cl_name.split('-')[1]}</b></li>
    {@else}
    <li><span>&{it.cl_num}期</span>&{it.cl_name.split('-')[0]} <b class="red">&{it.cl_name.split('-')[1]}</b></li>
    {@/if}
    {@/if}
    {@/each}
</script>
<!-- 两面长龙 公用框架模板结构 end -->

<!-- 冷热遗漏 公用框架模板结构 start -->
<script id="tpl_lryl" type="text/template">
    <thead>
    <tr>
        {@each lryl.num as it, index}
        {@if index==0}
        <th width="80">&{it}</th>
        {@else}
        <th>&{it}</th>
        {@/if}
        {@/each}
    </tr>
    </thead>
    <tbody>
    <tr>
        {@each lryl.lr as it}
        <td>&{it}</td>
        {@/each}
    </tr>
    <tr>
        {@each lryl.yl as it}
        <td>&{it}</td>
        {@/each}
    </tr>
    </tbody>
</script>
<!-- 冷热遗漏 公用框架模板结构 end -->

<!-- 出球率 公用框架模板结构 start -->
<script id="tpl_cql" type="text/template">
    <div class="trend_title">
        <ul class="base-clear">
            {@each cql.title as it, index}
            {@if index==0}
            <li class="tab_btn active"><a href="javascript:void(0)">&{it}</a></li>
            {@else}
            <li class="tab_btn"><a href="javascript:void(0)">&{it}</a></li>
            {@/if}
            {@/each}
        </ul>
    </div>
    <div class="trend_con">
        <ul class="base-clear">
            {@each cql.content as item, index}
            {@if index==0}
            <li class="tab_item active dib-wrap">
                {@each item.split("|") as it3}
                <span class="dib">
								 {@each i in range(0, it3.split(",")[1]-0)}
									<em>&{it3.split(",")[0]}</em>
								 {@/each}
							</span>
                {@/each}
            </li>
            {@else}
            <li class="tab_item dib-wrap">
                {@each item.split("|") as it3}
                <span class="dib">
								 {@each i in range(0, it3.split(",")[1]-0)}
									<em>&{it3.split(",")[0]}</em>
								 {@/each}
							</span>
                {@/each}
            </li>
            {@/if}
            {@/each}
        </ul>
    </div>
</script>
<!-- 出球率 公用框架模板结构 end -->


<!-- 确认弹窗 公用框架模板结构 start -->
<script id="tpl_order" type="text/template">
    <form id="orderForm">
        <div class="formTips base-clear">
            <div class="formTips_text"></div>
            <a class="formTips_close" href="javascript:void(0)">×</a>
        </div>
        <div class="tpl_order">
            <table class="order">
                <thead>
                <tr>
                    <th>注單</th>
                    <th>賠率</th>
                    <th>下註金額</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                {@each list as it, index}
                <tr>
                    <td>&{it.iName}-&{it.name}</td>
                    <td width="100"><div class="plShow">&{it.pl}<div class="plFloat"><span></span><div class="pl_left"></div></div></div></td>
                    <td><input id="order_&{index}" data-min="&{it.min}" data-max="&{it.max}" name="uPI_M" class="input onlyNum" value="&{it.m}" type="text"><input name="uPI_ID" value="&{it.uPI_ID}" type="hidden"><input name="uPI_P" value="&{it.pl}" type="hidden"><input name="i_index" value="&{index}" type="hidden"></td>
                    <td><a class="deleteOrder" href="javascript:void(0)">删除</a></td>
                </tr>
                {@/each}
                </tbody>
                <thead class="zjWrap">
                <tr>
                    <th colspan="4">注數：<span id="zj"></span> 筆     合計金額：<span data-credit="" id="zjm"></span>   </th>
                </tr>
                </thead>
            </table>
        </div>
        <input value="&{jV}" name="JeuValidate" type="hidden">
        <input value="&{wanfa}" name="wanfa" type="hidden">
        <input value="&{jiangqi}" name="jiangqi" type="hidden">
    </form>
</script>
<!-- 确认弹窗 公用框架模板结构 end -->

<!-- 赔率弹窗 公用框架模板结构 start -->
<script id="tpl_odds" type="text/template">
    <form id="oddsForm">
        <div class="formTips base-clear">
            <div class="formTips_text"></div>
            <a class="formTips_close" href="javascript:void(0)">×</a>
        </div>
        <div>&{title}【&{type}】@ <span class="odPl">&{odds}</span><input id="odds_pl" data-min="&{min}" data-max="&{max}" data-credit="&{value}" name="uPI_M" class="input onlyNum" data-pl="&{odds}" type="text" value="&{value}"><input name="uPI_P" value="&{odds}" type="hidden"><input name="uPI_ID" value="&{uPI_ID}" type="hidden"><input name="i_index" value="0" type="hidden"><div class="oddsPlFl"><div class="plFloat"><span></span><div class="pl_left"></div></div></div></div>
        <p>可赢金额：<span class="odPl" id="valueOdds">&{value*odds}</span></p>
        <p>最高派彩：&{topAmount}</p>
        <input value="&{jV}" name="JeuValidate" type="hidden">
        <input value="&{wanfa}" name="wanfa" type="hidden">
        <input value="&{jiangqi}" name="jiangqi" type="hidden">
    </form>
</script>
<!-- 赔率弹窗 公用框架模板结构 end -->

<!-- 连码确认弹窗 公用框架模板结构 start -->
<script id="tpl_lm_odds" type="text/template">
    <form id="orderLmForm">
        <div class="formTips base-clear">
            <div class="formTips_text"></div>
            <a class="formTips_close" href="javascript:void(0)">×</a>
        </div>
        <div class="lmSubmitWrap">
            <div class="lsw_top">
                <p>下注號碼明細</p>
                <p class="myNos">&{myNos}</p>
            </div>
            <div>您共選擇了<span>&{len}</span>個號碼<br>‘復式’共分為<span>&{group}</span>組，
                每注最高可下注金額<span>&{max}</span>元。 </div>
            <div><em>&{h3} @</em><strong>&{odds}</strong><input id="odds_lm_pl" data-min="&{min}" data-max="&{max}" data-credit="" name="uPI_M" class="input onlyNum" data-pl="&{odds}" type="text" value=""><input name="uPI_P" value="&{odds}" type="hidden"><input name="uPI_ID" value="&{uPI_ID}" type="hidden"><div class="oddsPlFl"><div class="plFloat"><span></span><div class="pl_left"></div></div></div></div>
            <div>总金额：<span data-credit="" id="lmPl">0</span></div>
        </div>
        <input value="" id="uPI_TM" name="uPI_TM" type="hidden">
        <input value="&{jV}" name="JeuValidate" type="hidden">
        <input value="&{wanfa}" name="wanfa" type="hidden">
        <input value="&{jiangqi}" name="jiangqi" type="hidden">
        <input value="0" name="LM_Type" type="hidden">
        <input value="&{NoS}" name="NoS" type="hidden">
    </form>
</script>
<!-- 赔率弹窗 公用框架模板结构 end -->
<script>
    var JeuValidate = '11190836317117';
    var GameName = '';
    var GameSmallName = '兩面盤';
    var GamePath = '';
    window.onload = function () {
        seajs.use(['jquery', 'game_global'], function ($, subInit) {
            // sub Init
            subInit._init();
        });
    };
</script>
</body>
</html>
