package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.dict.IDictEnum;
import org.soul.commons.support.IModule;

//通用字典枚举
public enum DictEnum implements IDictEnum {

    //region Region
    REGION_DELTA(Module.REGION, "delta"),//洲
    REGION_REGION(Module.REGION, "region"),//国家地区
    REGION_STATE(Module.STATE, ""),//省/州
    REGION_CITY(Module.CITY, ""),//城市
    REGION_CALLING_CODE(Module.REGION, "callingcode"),//手机号码区号
    //endregion Region

    //region common
    COMMON_RANK(Module.COMMON, "rank"),//层级
    COMMON_SEX(Module.COMMON, "sex"), // 性别COMMON_TERMINAL_TYPE
    COMMON_MONTH(Module.COMMON, "month"),//月份
    COMMON_AREA(Module.COMMON, "area"), // 省/州
    COMMON_CURRENCY(Module.COMMON, "currency"), // 货币
    COMMON_CURRENCY_SYMBOL(Module.COMMON, "currency_symbol"), // 货币符号
    COMMON_LANGUAGE(Module.COMMON, "language"),//语言
    COMMON_LOCAL(Module.COMMON, "local"),//语言
    COMMON_DELTA(Module.COMMON, "delta"),//洲
    COMMON_NATION(Module.COMMON, "nations"),//国家
    COMMON_PROVINCE(Module.COMMON, "province"),//省/州
    COMMON_CITY(Module.COMMON, "city"),//城市
    COMMON_ADDRESS_STATUS(Module.COMMON, "address_status"),//地址状态
    COMMON_IM_TYPE(Module.COMMON, "im_type"),//即时通讯（已废弃）
    COMMON_CONTACT_WAY_TYPE(Module.MASTER_NOTICE, "contact_way_type"),// 即时通讯
    COMMON_REMARK_TITLE(Module.COMMON, "remark_title"),//备注标题
    COMMON_COUNTRY(Module.COMMON, "country"),
    COMMON_TIME_ZONE(Module.COMMON, "time_zone"),
    COMMON_STATUS(Module.COMMON, "status"),
    COMMON_TRANSACTION_TYPE(Module.COMMON, "transaction_type"), //交易类型
    COMMON_USER_TYPE(Module.COMMON, "user_type"), //系统用户类型
    COMMON_USER_STATUS(Module.ACCOUNT, "user_status"), //系统用户状态
    COMMON_FUND_TYPE(Module.COMMON, "fund_type"), //系统用户类型
    COMMON_FREEZE_TIME(Module.COMMON, "freeze_time"),//冻结时间
    COMMON_TERMINAL_TYPE(Module.PLAYER, "terminal_type"),//来源终端(玩家管理意外的地方使用)
    SETTING_SITE_CONFINE_STATUS(Module.MASTER_SETTING, "site_confine_status"),//访问限制的使用状态
    DOMAIN_SYSTEM_TYPE(Module.ACCOUNT, "domain_system_type"),//域名所属系统
    PLAYER_STATUS(Module.PLAYER, "player_status"), //玩家状态
    CLAIM_PERIOD(Module.MASTER_OPERATION, "claim_period"),
    EFFECTIVE_TIME(Module.MASTER_OPERATION, "effective_time"),
    //endregion

    //region log
    Log_OpType(Module.Log, "op_type"), //日志操作类型
    //endregion
    //统计报表
    GAME_ORDER_STATE(Module.GAME, "order_state"),
    //region message
    MESSAGE_MSG_TYPE(Module.MESSAGE, "msg_type"), // 消息类别
    MESSAGE_MSG_DISPLAY(Module.MESSAGE, "msg_display"),//消息展示方式
    //endregion

    //region taskschedule
    TASK_SCHEDULE_ISLOCAL(Module.TASKSCHEDULE, "isLocal"), //是否本地方法
    TASK_SCHEDULE_ISSYSTEM(Module.TASKSCHEDULE, "isSystem"), //是否内置
    TASK_SCHEDULE_ISSYNC(Module.TASKSCHEDULE, "isSync"), //是否同步
    TASK_SCHEDULE_STATUS(Module.TASKSCHEDULE, "status"), //任务状态
    //endregion

    //region player
    PLAYER_CHANNEL_TERMINAL(Module.PLAYER,"channel_terminal"),//玩家来源终端
    PLAYER_ONLINE_STATUS(Module.PLAYER,"player_online"),//玩家来源终端
    //region content
    //账号密保问题
    SETTING_MASTER_QUESTIONS(Module.MASTER_SETTING, "master_questions"),
    NOTICE_REASON_TMPL_TYPE(Module.MASTER_NOTICE, "manual_event_type"),//原因模板类型
    NOTICE_REASON_TMPL_TYPE_AUTO(Module.MASTER_NOTICE, "auto_event_type"),//原因模板类型
    NOTICE_PUBLISH_METHOD(Module.MASTER_NOTICE, "publish_method"), // 发布方式代码
    WARMING_TONE_PROJECT(Module.MASTER_SETTING, "warming_tone_project"), // 提示音设置
    //region operation
    ACTIVITY_STATE(Module.MASTER_OPERATION, "activity_state"),
    ACTIVITY_TYPE(Module.COMMON, "activity_type"),
    ACTIVITY_APPLY_CHECK_STATUS(Module.MASTER_OPERATION, "activity_apply_check_status"),
    //域名
    DOMAIN_TYPE(Module.ACCOUNT, "domain_type"), //域名类型
    DOMAIN_PAGE_URL_TYPE(Module.ACCOUNT, "domain_page_url_type"), //域名指向页面
    API_PROVIDER(Module.API, "api_provider"),

    COMMON_TERMINAL(Module.COMMON, "terminal"), //设备终端
    MEMBER_TRADETYPE(Module.MEMBER, "tradeType"), //交易类型
    COMMON_SETTLEMENT_STATUS(Module.COMMON, "settlement_status"), //结算状态
    COMMON_BET_STATUS(Module.COMMON, "bet_status"), //投注状态

    COMMON_SPORT_GAME(Module.COMMON, "sport_game"), //赛事类型

    /**
     * 赛事维护比分审核
     */
    MATCH_AUDIT_STATUS(Module.MATCH, "audit_status"),
    /**
     * 比分操作类型
     */
    TY_RESULT_OPERATION_TYPE(Module.BET, "ty_result_operation"),

    /**注单统计*/
    COMMON_WINNING_STATUS(Module.COMMON,"winning_status"),
    /**
     * 赛事维护比分来源类型
     */
    MATCH_RESULT_TYPE(Module.MATCH, "result_type"),

    BET_MAT_STATUS(Module.BET, "mat_status"),

    MEMBER_USER_STATUS(Module.MEMBER, "user_status"),

    MEMBER_BETTING_STATUS(Module.MEMBER, "betting_status"),

    COMMON_WIN_STATUS(Module.COMMON, "win_status"),

    //region account
    ACCOUNT_USER_TYPE(Module.ACCOUNT, "user_type"),

    ACCOUNT_MODE(Module.ACCOUNT, "mode"),

    ACCOUNT_DOMAIN_RESOLVESTATUS(Module.ACCOUNT, "domain_resolveStatus"),
    //endregion

    //region account
    BET_MATCH_RESULT(Module.BET, "match_result"),
    BET_MATCH_RESULT_30(Module.BET, "match_result_30"),
    BET_MATCH_RESULT_31(Module.BET, "match_result_31"),
    BET_MATCH_RESULT_32(Module.BET, "match_result_32"),
    BET_MATCH_RESULT_33(Module.BET, "match_result_33"),
    BET_MATCH_RESULT_34(Module.BET, "match_result_34"),
    BET_MATCH_RESULT_35(Module.BET, "match_result_35"),
    BET_MATCH_RESULT_36(Module.BET, "match_result_36"),
    BET_MATCH_RESULT_37(Module.BET, "match_result_37"),
    BET_MATCH_RESULT_38(Module.BET, "match_result_38"),
    //endregion

    //region account
    BET_SETTLEMENT_STATUS(Module.BET, "settlement_status"),
    //endregion
    //
    //咨询
    ADVISORY_TYPE(Module.PLAYER, "advisory_type"),

    CHECK_STATUS(Module.MASTER_CONTENT, "check_status"),//审核状态
    FUND_CHECK_STATUS(Module.FUND, "check_status"),//资金审核状态
    PAY_TYPE(Module.CREDIT, "pay_type"),
    CREDIT_STATUS(Module.CREDIT, "credit_status"),
    CREDIT_USE_STATUS(Module.CREDIT, "credit_use_status"),

    FUND_RECHARGE_TYPE(Module.FUND, "recharge_type"),//充值类型
    FUND_RECHARGE_STATUS(Module.FUND, "recharge_status"),
    FUND_DRAW_PROJECT(Module.FUND, "draw_project"),//手工提存提现项目
    FUND_TRANSFER_STATE(Module.FUND, "transfer_state"),//转账状态
    FUND_CHECK_TRANSFER_STATE(Module.FUND, "check_result"),//转账状态
    //endregion

    //region withdraw
    WITHDRAW_TYPE_PARENT(Module.FUND, "withdraw_type_parent"), //提现父类型
    WITHDRAW_TYPE(Module.FUND, "withdraw_type"), //提现类型
    WITHDRAW_STATUS(Module.FUND, "withdraw_status"), //任务状态
    IS_AUDIT(Module.FUND, "is_audit"),//是否稽核

    BANKNAME(Module.COMMON, "bankname"),//银行类别
    CONTENT_DRAFT_STATUS(Module.MASTER_CONTENT, "draft_status"),//文案管理状态
    //endregion

    //region withdraw
    TRANSACTION_STATUS(Module.FUND, "transaction_status"), //代理取款审核
    //endregion

    //region content
    RANK_FEE_TYPE(Module.PLAYER, "rank_fee_type"),//层级提现类型
    PAY_ACCOUNT_STATUS(Module.MASTER_CONTENT, "pay_account_status"),//收款账号状态
    FLOAT_PIC_LINK_TYPE(Module.MASTER_CONTENT, "float_pic_link_type"),//浮动图链接类型
    FLOAT_PIC_DISPLAY_IN(Module.MASTER_CONTENT, "float_pic_display_in"),//浮动图展示位置
    PAY_ACCOUNT_ACCOUNT_TYPE(Module.MASTER_CONTENT, "pay_account_account_type"), //存款账户类型
    PAY_ACCOUNT_TYPE(Module.MASTER_CONTENT, "pay_account_type"), //存款类型

    //
    DX(Module.LOTTERY,"dx"),
    ZH(Module.LOTTERY,"zh"),
    DS(Module.LOTTERY,"ds"),
    LHT(Module.LOTTERY,"lht"),
    LOTTERY(Module.LOTTERY,"lottery"),
    LOTTERY_TYPE(Module.LOTTERY,"lottery_type"),
    LOTTERY_PLAY(Module.LOTTERY,"lottery_play"),
    LOTTERY_BETTING(Module.LOTTERY,"lottery_betting"),
    LOTTERY_BET_TYPE(Module.LOTTERY,"lottery_bet_type"),
    LOTTERY_BET_NUM(Module.LOTTERY,"lottery_bet_num"),
    ORDER_STATUS(Module.LOTTERY,"order_status"),

    BILL_TYPE(Module.FUND,"bill_deposit_type"),
    BILL_ITEM(Module.FUND,"bill_deposit_item"),

    CONTENT_CAROUSEL_TYPE(Module.MASTER_CONTENT, "carousel_type"),//内容管理-轮播广告-类别
    CAROUSEL_STATE(Module.MASTER_CONTENT, "carousel_state"),//轮播广告使用状态
    CONTENT_CTTANNOUNCEMENT_TYPE(Module.MASTER_CONTENT, "ctt_announcement_type"),//文案类型

    //关闭站点的时间类型(立即生效,定时生效)
    MASTER_SETTING_CLOSE_TIME_TYPE(Module.COMPANY_SETTING, "close_site_time_type"),

    LSSUING_STATE(Module.MASTER_OPERATION, "lssuing_state"),

    //手机端背景颜色
    MOBILE_BACKGROUND_COLOR(Module.MASTER_SETTING,"mobile_background_color");




    DictEnum(IModule module, String type) {
        this.module = module;
        this.type = type;
    }

    private IModule module;
    private String type;

    @Override
    public IModule getModule() {
        return module;
    }

    @Override
    public String getType() {
        return type;
    }
}
