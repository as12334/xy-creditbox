package so.wwb.creditbox.model.enums.base;

import org.soul.commons.support.IModuleType;

public enum ModuleType implements IModuleType {

    //登录-登出 1-50存merchant (1,2,3。manager,merchant共用)
    PASSPORT_LOGIN("1", "通行证(登录)"),
    PASSPORT_LOGOUT("2", "通行证(退出)"),
    PASSPORT_LOGIN_FAIL("3", "通行证(登录失败)"),

    //彩票
    LOTTERY_ODD("41", "赔率修改"),

    //以下类型日志存在merchant中
//    PLAYER_PASSWORD_UPDATE("4","修改登录密码"),
//    PLAYER_REALNAME_UPDATE("5","修改真实姓名"),
//    PLAYER_BANKCARD_ADD("6","新增银行卡"),
//    PLAYER_SALARY_SET("7","设置日工资"),
//    PLAYER_DIVIDEN_SET("8","设置分红"),
//    PLAYER_REPORT_TOTAL("9","玩家报表统计"),
//    PLAYER_REPORT_EXPORT("10","玩家报表导出"),
//
//    //账号 101-200
//    USER_ACCOUNT_BOSS_SUB_ADD("101", "新增boss子账号"),
    USER_ACCOUNT_CM_ADD("102", "新增运营商账号"),
    USER_ACCOUNT_CM_SUB_ADD("103", "新增运营商子账号"),
    USER_ACCOUNT_ME_ADD("104", "新增公司账号"),
//    USER_ACCOUNT_ME_SUB_ADD("105", "新增商户子账号"),
//    USER_ACCOUNT_DI_ADD("106", "新增总代账号"),
//    USER_ACCOUNT_DI_SUB_ADD("107", "新增总代子账号"),
//    USER_ACCOUNT_PLAYER_ADD("108","新增玩家账号"),
    USER_ACCOUNT_UPDATE("109", "编辑账号"),
//
    USER_MINUTE_INFO_UPDATE("110","修改账号详细资料"),
    USER_STATUS("111","修改账号状态"),
    USER_STATUS_FREEZE("112","冻结/解冻账号"),
    USER_STATUS_FREEZE_TRUE("113", "冻结账号"),
    USER_STATUS_FREEZE_FALSE("114", "解冻账号"),
    USER_STATUS_DISABLE_OR_NORMAL("115", "停用/启用账号"),
//
    USER_PASSWORD_UPDATE("118", "重置登录密码"),
    USER_PERMISSIONPWD_UPDATE("119", "重置安全密码"),
//    USER_REAL_NAME_UPDATE("120","修改玩家真实姓名"),
//    PLAYER_RANK_UPDATE("121","修改玩家层级"),
//    USER_MEMO_UPDATE("122","修改玩家备注"),
//    USER_RAKEBACK_UPDATE("123","修改玩家所属返水方案"),
    USER_ACCOUNT_RESET_AUTHENTICATION_KEY("124","重置身份验证"),
//    USER_NICK_NAME_UPDATE("125", "修改玩家昵称"),
//
//    COMMON_UPDATE_REMARK("130", "修改备注"),
//
//    USER_BANKCARD_ADD("140","新增/编辑银行卡"),
//    USER_BANKCARD_DELETE("142","删除银行卡"),
//
//    USER_ALIAPY_ADD("144","新增/编辑支付宝"),
//    USER_ALIAPY_DELETE("145","删除支付宝"),
//    USER_WEIXIN_ADD("147","新增/编辑微信"),
//    USER_WEIXIN_DELETE("148","删除微信"),
//
//    PAY_ACCOUNT("160","入款账号"),
//    PAY_ACCOUNT_ADD_OR_UPDATE("160","新增/编辑收款账户"),
//    PAY_ACCOUNT_STATUS("161","修改收款账户状态"),
//    PAY_ACCOUNT_DELETE("162","删除/批量删除收款账户"),
//
//    TAKE_PLAY_UPDATE_MONEY("170", "修改带玩账号钱包余额"),
//    TAKE_PLAY_UPDATE_NUMBER("171", "修改带玩账号注册次数上限"),
//    TAKE_PLAY_UPDATE_SYS_PARAM("173", "修改带玩系统参数"),
//
//
//    //彩票/游戏 201-300
//    LOTTERY_OPEN_NUMBER("210","开号"),
//    LOTTERY_ADJUST("211","调盘"),
//    LOTTERY_PAYOUT("212","派彩"),
//    LOTTERY_RECALCULATE("213","重结"),
//    LOTTERY_REVOKE("214","撤单"),
//    LOTTERY_REVOCATION("215","撤销"),
//    LOTTERY_MAKE_UP("216","补采"),
//    LOTTERY_RESULT("217","开奖结果"),
//    LOTTERY_GATHER_CONF("218","采集配置"),
//
//    LOTTERY_HANDICAP_EDIT("230","开奖周期编辑"),
//
//    LOTTERY_SORT("240","彩种排序"),
//    LOTTERY_SYNC("241","同步彩种"),
//    LOTTERY_TAKE_OFF("242","下架彩种"),
//    LOTTERY_GENRE("243","修改彩种玩法模式 传统/官方/全部"),
//    LOTTERY_STATUS("244","修改彩种状态 启用/维护/下架/停市"),
//    LOTTERY_ADD_OR_UPDATE("245","新增/编辑彩种"),
//    LOTTERY_UPDATE("246","编辑彩种"),
//    LOTTERY_DELETE("247","删除彩种"),
//    LOTTERY_HOT("248","彩种热门"),
//    LOTTERY_NEW("249","是否新彩种"),
//    LOTTERY_ZODIAC("250","保存生肖"),
//    LOTTERY_RULE("251","系统彩设置"),
//
//    LOTTERY_TYPE_SORT("260","彩种类型排序"),
//    LOTTERY_TYPE_ADD_OR_UPDATE("260","新增/编辑彩种类型"),
//    LOTTERY_TYPE_ADD("261","新增彩种类型"),
//    LOTTERY_TYPE_UPDATE("262","编辑彩种类型"),
//    LOTTERY_TYPE_DELETE("263","删除彩种类型"),
//    LOTTERY_TYPE_STATUS("264","启用/停用彩种类型"),
//
    LOTTERY_ODD_UPDATE("270","修改赔率奖金"),
//    LOTTERY_QUOTA_UPDATE("271","修改限额"),
//    LOTTERY_BET_RECORD_EXPORT("280","投注记录导出"),
//
//    LOTTERY_RETREAT_SET("290", "退水设置"),
//
//
////    LOTTERY_KILL_ADD_OR_UPDATE("290","新增/编辑自主彩杀率"),
////    LOTTERY_KILL_DELETE("291","删除自主彩杀率"),
//
//
//    //层级 301-400
//    PLAYER_RANK("301","玩家层级"),
//
//    //返水、日工资、分红 401-500
//    OPERATION_RAKEBACK_ADD_OR_UPDATE("401","新增/编辑返水方案"),
//    OPERATION_RAKEBACK_STATUS("402","启用/禁用返水方案"),
//    OPERATION_DIVIDEN_ADD_OR_UPDATE("410","新增/修改分红方案"),
//    OPERATION_DIVIDEN_STATUS("411","启用/禁用分红方案"),
//    OPERATION_DIVIDEN_DELETE("412","删除分红方案"),
//    OPERATION_SALARY_ADD_OR_UPDATE("420","新增/修改日工资方案"),
//    OPERATION_SALARY_STATUS("421","启用/禁用日工资方案"),
//    OPERATION_SALARY_DELETE("422","删除日工资方案"),
//    OPERATION_ACTIVITY_ADD("430","新增优惠活动"),
//    OPERATION_ACTIVITY_UPDATE("431","编辑优惠活动"),
//    OPERATION_ACTIVITY_STATUS("432","启用/禁用优惠活动"),
//    OPERATION_ACTIVITY_SORT("433","排序优惠活动"),
//    OPERATION_ACTIVITY_DELETE("434","删除优惠活动"),
//
//
//    BILL_RAKEBACK_SUCCESS("440", "通过返水结算"),
//    BILL_RAKEBACK_FAILURE("441", "拒绝返水结算"),
//    BILL_SALARY_SUCCESS("442", "通过日工资结算"),
//    BILL_SALARY_FAILURE("443", "拒绝日工资结算"),
//    BILL_DIVIDEN_SUCCESS("444", "通过分红结算"),
//    BILL_DIVIDEN_FAILURE("445", "拒绝分红结算"),
//    BILL_CHANGE_EXPORT("448", "账变记录导出"),
//    BILL_RETREAT_FAILURE("446","拒绝退水结算"),
//    BILL_RETREAT_SUCCESS("447","通过退水结算"),
//
//    CALL_BILL_RAKEBACK("450", "手动执行返水函数"),
//    CALL_BILL_SALARY("451", "手动执行工资函数"),
//    CALL_BILL_DIVIDEN("452", "手动执行分红函数"),
//    CALL_REPORT_CAME("453", "手动执行游戏报表函数"),
//    CALL_REPORT_OPERATE("454", "手动执行运营报表函数"),
//    BILL_RAKEBACK_ACTUAL_MONEY_UPDATE("455","修改实际返水金额"),
//    CALL_BILL_RETREAT("456", "手动执行退水函数"),
//    CALL_REPORT_BUSINESS("457", "手动执行经营报表函数"),
//
//    //存取款 501-600
//    FUND_MANUAL("501","人工存取"),
//    FUND_MANUAL_DEPOSIT("502","系统存款"),
//    FUND_MANUAL_WITHDRAW("503","系统取款"),
//
//    FUND_MANUAL_DEPOSIT_CHECK("510","系统存款审核"),
//    FUND_MANUAL_WITHDRAW_CHECK("511","系统取款审核"),
//    FUND_ONLINE_DEPOSIT_CHECK("512","线上支付审核"),
//    FUND_COMPANY_DEPOSIT_CHECK("513","公司入款审核"),
//    FUND_PLAYER_WITHDRAW_CHECK("514","玩家取款审核"),
//    FUND_FAVORABLE_CHECK("515","活动优惠审核"),
//    FUND_BILLAUDIT_UPDATE("516","修改玩家存款,优惠稽核打码量"),
//
//    FUND_WITHDRAW_CHECK_UNLOCK("520","取款审核解锁订单"),
//    FUND_WITHDRAW_CHECK_LOCK("521","取款审核锁定订单"),
//    FUND_SYS_VOICE("590","财务模块声音禁用/启用"),
//
//    //内容601-700
//    CONTENT_CAROUSEL_ADD_OR_UPDATE("601","新增/编辑广告"),
//    CONTENT_CAROUSEL_DELETE("602","删除广告"),
//    CONTENT_CAROUSEL_SORT("603","排序广告"),
//    CONTENT_CAROUSEL_DISPLAY("604","启用/禁用前端展示广告"),
//
//    CONTENT_DOCUMENT_ADD_OR_UPDATE("610","新增/编辑文案"),
//    CONTENT_DOCUMENT_DELETE("611","删除文案"),
//    CONTENT_DOCUMENT_SORT("612","排序文案"),
//    CONTENT_DOCUMENT_STATUS("613","启用/禁用文案"),
//
//    CONTENT_SITE_MESSAGE("620", "站内信息"),
//    CONTENT_SITE_MESSAGE_ADD("621", "新增站内信息"),
//
//    CONTENT_SITE_ANNOUNCEMENT_ADD_OR_UPDATE("630","新增/编辑站点公告"),
//    CONTENT_SITE_ANNOUNCEMENT_DELETE("631","删除站点公告"),
//    CONTENT_SITE_ANNOUNCEMENT_DISPLAY("632","启用/禁用站点公告前端展示"),
//    CONTENT_SITE_ANNOUNCEMENT_SORT("633","排序站点公告"),
//    CONTENT_SITE_PROFIT_WINNING_SORT("634","排序盈利中奖"),
//
//    CONTENT_SITE_DOMAIN_ADD("640","新增站点域名"),
//    CONTENT_SITE_DOMAIN_DELETE("641","删除站点域名"),
//    CONTENT_SITE_DOMAIN_UPDATE("642","编辑站点域名"),
//    CONTENT_SITE_DOMAIN_STATUS("643","启用/禁用站点域名"),
//    CONTENT_SITE_DOMAIN_RESOLVE_STATUS("645","申请解绑站点域名"),
//
//    CONTENT_SITE_DISTRIBUTOR_DOMAIN_ADD("650","新增总代域名"),
    CONTENT_SITE_COMPANIES_DOMAIN_ADD("651","新增运营商域名"),
//    CONTENT_SITE_BOSSS_DOMAIN_ADD("653","新增总控域名"),
////    CONTENT_SITE_DISTRIBUTOR_DOMAIN_DELETE("651","删除总代域名"),
//    CONTENT_SITE_DISTRIBUTOR_DOMAIN_UPDATE("652","编辑总代域名"),
////    CONTENT_SITE_DISTRIBUTOR_DOMAIN_STATUS("653","启用/禁用总代域名"),
//
//    CONTENT_SITE_AGENT_DOMAIN_ADD("654","新增推广域名"),
////    CONTENT_SITE_AGENT_DOMAIN_DELETE("655","删除推广域名"),
//    CONTENT_SITE_AGENT_DOMAIN_UPDATE("656","编辑推广域名"),
////    CONTENT_SITE_AGENT_DOMAIN_STATUS("657","启用/禁用总代域名"),
//    CONTENT_PROFIT_ADD_OR_UPDATE("658","新增/编辑盈利中奖"),
//
//    //域名站点701-800
    SITE_DOMAIN_ADD("702","新增域名"),
    SITE_DOMAIN_UPDATE("703","编辑域名"),
    SITE_DOMAIN_ISDISABLE("704","启用/禁用域名"),
    SITE_DOMAIN_WHITELIST_ADD_OR_UPDATE("705","新增/编辑白名单IP"),
    SITE_DOMAIN_BLACKLIST_ADD_OR_UPDATE("706","新增/编辑黑名单IP"),
    SITE_DOMAIN_WHITELIST_DELETE("707","删除白名单"),
    SITE_DOMAIN_BLACKLIST_DELETE("708","删除黑名单"),
    SITE_DOMAIN_MAINTENANCE("709","站点维护"),
    SITE_DOMAIN_TO_BOUND("710","解绑域名"),
    SITE_DOMAIN_BOUNDED("711","解绑域名成功"),
    SITE_DOMAIN_DELETE("712","删除域名"),
    SITE_DOMAIN_CHECK_SUCCESS("713","新增域名审核通过"),
    SITE_DOMAIN_CHECK_FAIL("714","新增域名审核失败"),
    SITE_DOMAIN_BOUNDED_FAIL("715","解绑域名失败"),
//
//
    SITE_BOSS_UPDATE("720","编辑平台备注"),
    SITE_BOSS_STATUS("721","启用/禁用平台站点"),
//
//    SITE_BOSS_DOMAIN_BLACKLIST_ADD_OR_UPDATE("722","新增/编辑平台黑名单"),
//
//
    SITE_COMPANIES_UPDATE("730","编辑股东站点备注"),
    SITE_COMPANIES_DOMAIN_ADD_OR_UPDATE("731","新增/编辑股东域名"),
    SITE_COMPANIES_DOMAIN_ISDISABLE("732","启用/禁用股东域名"),
    SITE_COMPANIES_STATUS("733","启用/禁用股东站点"),
//
    SITE_COMPANY_STATUS("734","启用/禁用商户站点"),
    SITE_COMPANY_UPDATE("735","编辑商户站点备注"),
//
//    SITE_GROUP_ADD("736", "站点分组新增"),
//    SITE_GROUP_UPDATE("737", "站点分组修改"),
//    SITE_GROUP_DELETE("738", " 删除站点分组"),
//
//
//
//    //系统 901-1100
//    SYS_CONFINE_WHITELIST_IP_ADD_OR_UPDATE("901","新增/编辑白名单ip"),
//    SYS_CONFINE_WHITELIST_IP_DELETE("902","删除白名单ip"),
//    SYS_CONFINE_BLACKLIST_IP_ADD_OR_UPDATE("904","新增/编辑黑名单ip"),
//    SYS_CONFINE_BLACKLIST_IP_DELETE("910","删除黑名单ip"),
//
//    SYS_ACCOUNT_DOMAIN("911", "线路域名"),
//    SYS_SETTING_VOICE("920","系统声音"),
//    SYS_MESSAGE("930", "系统信息"),
//    SYS_CUSTOMER_SERVICE_PARAMS_ADD_OR_UPDATE("940","新增/修改客服参数"),
//    SYS_YZM_PARAMS_ADD_OR_UPDATE("941","新增/修改排除验证码参数"),
//    SYS_PLAYER_REGISTER_MODE_ADD("942","新增/修改玩家注册模式"),
//    SYS_TONE_PARAMS_UPDATE("951","修改系统提示音参数"),
//    SYS_TONE_PARAMS_ACTIVE("952","启用/禁用系统提示音参数"),
//
//    SYS_IMPORT_PLAYER_ACCOUNT("960","导入玩家"),
//    SYS_VIP_STATUS("965", "启用/禁用显示玩家vip"),
//    SYS_VIP_EDIT("966", "修改玩家vip各等级参数"),
//
    SYS_CREATE_SITE("970","新建站点"),
//
//    SYS_PAY_JAR_ADD_OR_UPDATE("980","新增/编辑支付JAR"),
//    SYS_PAY_JAR_VERSION_UPDATE("981","更新支付JAR版本"),
//    SYS_PAY_JAR_DELETE("982","删除支付JAR"),
//    SYS_PAY_API_ADD_OR_UPDATE("985","新增/编辑支付API"),
//    SYS_PAY_API_DELETE("986","删除支付API"),
//    SYS_PAY_API_ISUSE("987","启用/停用支付接口"),
//
//    SYS_APP_ADD_OR_UPDATE("990","新增/编辑APP参数"),
//    SYS_APP_KEY_ADD_OR_UPDATE("991","新增/编辑APP秘钥"),
//    SYS_APP_KEY_STATUS("992","启用/禁用APP秘钥"),
//    SYS_APP_UPDATE_DELETE("993","删除APP_UPDTE"),
//    SYS_APP_REEOR_LOG_UPDATE("994","解决app错误日志"),
//
//    SYS_ANN_ADD_OR_UPDATE("1000","新增/编辑系统公告"),
//    SYS_ANN_DELETE("1001","删除系统公告"),
//    SYS_MSG_ADD("1002","新增系统信息"),
//
//    SYS_UPDATE_VERIFICATION("1003","修改转站状态"),
//    SYS_UPDATE_NAME_VERIFICATION("1004","修改真实名称验证状态"),
//    SYS_UPDATE_BANKCARDNUMBER_VERIFICATION("1005","修改银行卡验证状态"),
//    SYS_UPDATE_CHECK_REAL_NAME("1006","修改真实姓名必填状态"),
//    SYS_UPDATE_API("1007","修改API状态"),
//    SYS_UPDATE_CHECK_MOBILE("1008","修改手机号必填状态"),
//    SYS_UPDATE_CHECK_WEIXIN("1009","修改微信号必填状态"),
//    SYS_UPDATE_DEMO("1010","修改试玩状态"),
//
//    SYS_UPDATE_CHECK_PAYEE_BANK_ALIPAY("1011","修改玩家收款账号支持支付宝状态"),
//    SYS_UPDATE_CHECK_PAYEE_BANK_WEIXIN("1012","修改玩家收款账号支持支微信状态"),
//
//    SYS_UPDATE_API_TRANSFER_SITE("1013","修改api是否开启免转状态"),
//
//    //运维　1101 - 1200
//    OPS_TASK_SCHEDULE_SERVICE_RUN("1001","任务调度运行"),



    ;

    /*CREDIT_LINE("38","修改授信额度"),
    PAY_ACCOUNT("50","入款账号");*/

    private String code;
    private String trans;

    ModuleType(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
