package so.wwb.creditbox.model.enums.base;

import org.soul.commons.param.IParamEnum;
import org.soul.commons.support.IModule;

public enum SiteParamEnum implements IParamEnum {
//    SETTING_VISIT(Module.MASTER_SETTING, "visit", ""),//是否开启允许访问管理中心的IP
    SETTING_VISIT_MANAGER_STATUS(Module.MASTER_SETTING, "visit", "visit.manager"),//是否开启允许访问管理中心(后台)的IP
    SETTING_VISIT_MANAGER_STATUS_PROMPT(Module.MASTER_SETTING, "visit", "visit.manager.prompt"),//是否开启允许访问管理中心的IP,是否需要显示提示语
    SETTING_VISIT_PLAY_STATUS(Module.MASTER_SETTING, "visit", "visit.play"),//是否开启允许访问站点(前端)的IP
    SETTING_VISIT_PLAY_STATUS_PROMPT(Module.MASTER_SETTING, "visit", "visit.play.prompt"),//是否开启允许访问站点的IP,是否需要显示提示语
//    SETTING_VISIT_API_STATUS(Module.MASTER_SETTING, "visit", "visit.api"),//是否开启允许访问站点的IP
//    SETTING_VISIT_API_STATUS_PROMPT(Module.MASTER_SETTING, "visit", "visit.api.prompt"),//是否开启允许访问站点的IP,是否需要显示提示语
//    CONTENT_DEPOSIT_ACCOUNT_WARNING_INADEQUATE_STATE(Module.MASTER_CONTENT, "depositAccountWarning", "inadequate.warning.state"),//层级账户不足提醒
//    CONTENT_DEPOSIT_ACCOUNT_WARNING_INADEQUATE_COUNT(Module.MASTER_CONTENT, "depositAccountWarning", "inadequate.warning.count"),//层级账户不足个数
//    CONTENT_DEPOSIT_ACCOUNT_WARNING_DEPOSIT_RESET_DAYS(Module.MASTER_CONTENT, "depositAccountWarning", "deposit.reset.days"),//账户入款清零时间/天
//    CONTENT_DEPOSIT_ACCOUNT_WARNING_DEPOSIT_RESET_DAYS_NEXT_TIME(Module.MASTER_CONTENT, "depositAccountWarning", "deposit.reset.days.next.time"),//账户入款清零时间/天
//    SETTING_SYSTEM_SETTINGS_BACKGROUND_COLOR(Module.MASTER_SETTING,"system_settings","background_color"),//手机端背景颜色类型
//    SETTING_CLOSE_SITE_SALES_TYPE(Module.MASTER_SETTING, "close_site_sales", "type"),//关闭站点营业类型（1立即；2定时）
//    CONTENT_PAY_ACCOUNT_WARNING_INADEQUATE_STATE(Module.MASTER_CONTENT, "payAccountWarning", "inadequate.warning.state"),//层级账户不足提醒
//    CONTENT_PAY_ACCOUNT_WARNING_INADEQUATE_COUNT(Module.MASTER_CONTENT, "payAccountWarning", "inadequate.warning.count"),//层级账户不足个数
//    SETTING_CAPTCHA_STYLES(Module.MASTER_SETTING, "captcha_style", ""),
//    SETTING_CAPTCHA_STYLE(Module.MASTER_SETTING, "captcha", "style"),//验证码
//    SETTING_CAPTCHA_EXCLUSIONS(Module.MASTER_SETTING, "captcha", "exclusions"),//验证码排除内容
//    /*取款现金方式：是否开启现金*/
//    //SETTING_WITHDRAW_TYPE_IS_CASH(Module.MASTER_SETTING, "withdraw_type", "is_cash"),
//    //收款账号
//    CONTENT_PAY_ACCOUNT_HIDE(Module.MASTER_CONTENT, "pay_account", "hide_account"),//收款账号-公司入款账号是否隐藏
//    CONTENT_PAY_ACCOUNT_HANDLE_CUSTOMER_SERVICE(Module.MASTER_CONTENT, "pay_account", "handle_customer_service"),//收款账号-处理客服
//    PAY_ACCOUNT_HIDE_ONLINE_BANKING(Module.MASTER_CONTENT, "pay_account_hide", "online_banking"),   // 隐藏网银存款账号
//    PAY_ACCOUNT_HIDE_E_PAYMENT(Module.MASTER_CONTENT, "pay_account_hide", "e_payment"),             // 隐藏电子支付账号
//    PAY_ACCOUNT_HIDE_ATM_COUNTER(Module.MASTER_CONTENT, "pay_account_hide", "atm_counter"),         // 隐藏柜员机/柜台存款账号
//    //是否是demo(能否转账)
//    IS_DEMO(Module.MASTER_SETTING, "fund", "demo"),
//
//    SETTING_REG_LIMIT_IP_REG(Module.MASTER_SETTING, "reg_limit", ""),//同一IP注册间隔时间
//    SETTING_REG_LIMIT_IP_REG_INTERVAL(Module.MASTER_SETTING, "reg_limit", "ip_reg_interval"),//同一IP注册间隔时间
//    SETTING_REG_LIMIT_REG_ADDRESS(Module.MASTER_SETTING, "reg_limit", "reg_address"),//注册地址
//    SETTING_REG_LIMIT_IP_DAY_MAX_REGNUM(Module.MASTER_SETTING, "reg_limit", "ip_day_max_regNum"),//同一IP24小时注册次数
//    SETTING_REG_SETTING_SETTING(Module.MASTER_SETTING, "reg_setting", ""),//注册字段设置
//    SETTING_REG_SETTING_FIELD_SETTING(Module.MASTER_SETTING, "reg_setting", "field_setting"),//注册字段设置
//    SETTING_REG_SETTING_PHONE_VERIFCATION(Module.MASTER_SETTING, "reg_setting", "verification_phone"),//手机注册前before，注册后验证after
//    SETTING_REG_SETTING_MAIL_VERIFCATION(Module.MASTER_SETTING, "reg_setting", "verification_mail"),//邮箱注册前before，注册后验证after
//    SETTING_REG_SERVICE_TERMS_SHOW(Module.MASTER_SETTING, "reg_setting", "service_show"),//是否显示服务条款
//    SETTING_REG_SERVICE_TERMS_FORCED_SHOW(Module.MASTER_SETTING, "reg_setting", "service_forced"),//是否强制显示服务条款
//    SETTING_SYSTEM_SETTINGS_DEPOSIT(Module.MASTER_SETTING, "system_settings", "deposit"),//启用存款稽核
//    SETTING_SYSTEM_SETTINGS_DISCOUNT(Module.MASTER_SETTING, "system_settings", "discount"),//启用优惠稽核
//    SITE_PLAYER_EXPORT(Module.MASTER_SETTING, "export", "export_players"),//是否开启导出玩家功能
//
//    //返水设置-结算周期
//    SETTING_RAKEBACKSETTING_SETTLEMENTPERIODTIMES(Module.MASTER_SETTING, "rakebackSetting", "settlement.period.times"),
//    SETTING_RAKEBACKSETTING_SETTLEMENTPERIODTIMESNEW(Module.MASTER_SETTING, "rakebackSetting", "settlement.period.times.new"),
//    SETTING_RAKEBACKSETTING_SETTLEMENTPERIODEFFECTIVETIME(Module.MASTER_SETTING, "rakebackSetting", "settlement.period.effective.time"),
    SETTING_SYSTEM_SETTINGS_VERIFICATION(Module.MASTER_SETTING,"system_settings","verification"),//是否启动验证
//    SETTING_SYSTEM_SETTINGS_NAME_VERIFICATION(Module.MASTER_SETTING,"system_settings","name_verification"),//启用真实姓名验证
//    SETTING_SYSTEM_SETTINGS_BANKCARDNUMBER_VERIFICATION(Module.MASTER_SETTING,"system_settings","bank_card_number_verification"),//启用银行卡验证
//    SETTING_SYSTEM_SETTINGS_DEMO(Module.MASTER_SETTING,"system_settings","demo"),//是否启动试玩
//
//    SETTING_SHOWPOP(Module.MASTER_SETTING, "showpop", ""), //是否默认显示消息通知框
    WARMING_TONE_GATHER(Module.MASTER_SETTING, "warming_tone_project", "gather"), //采集器报警
//    WARMING_TONE_BILL(Module.MASTER_SETTING, "warming_tone_project", "bill"), //新订單通知
//
    SETTING_PRIVILAGE_PASS_TIME(Module.MASTER_SETTING,"privilage_pass_time","setting.privilage.pass.time"),//密码权限时效性设置
//    WARMING_TONE_DEPOSIT(Module.MASTER_SETTING,"warming_tone_project","deposit"),
//    WARMING_TONE_SYSDEPOSIT(Module.MASTER_SETTING,"warming_tone_project","sysDeposit"),
//    WARMING_TONE_ONLINEPAY(Module.MASTER_SETTING,"warming_tone_project","onlinePay"),
//    WARMING_TONE_AUDIT(Module.MASTER_SETTING,"warming_tone_project","audit"),
//    WARMING_TONE_NOTICE(Module.MASTER_SETTING,"warming_tone_project","notice"),
//    WARMING_TONE_SYSDRAW(Module.MASTER_SETTING, "warming_tone_project", "sysDraw"),
//    //警示
//    WARMING_TONE_WARM(Module.MASTER_SETTING, "warming_tone_project", "warm"),
//    WARMING_TONE_DRAW(Module.MASTER_SETTING, "warming_tone_project", "draw"),
//
//    CONTENT_CAROUSEL_INTERVAL_TIME(Module.MASTER_CONTENT, "carouselIntervalTime", "carousel_type_login"),// 轮播广告间隔时间
//
//
//    //代理注册
//    SETTING_REG_LIMIT_IP_REG_AGENT(Module.MASTER_SETTING, "reg_limit_agent", ""),//同一IP注册间隔时间
//    SETTING_REG_LIMIT_IP_REG_INTERVAL_AGENT(Module.MASTER_SETTING, "reg_limit_agent", "ip_reg_interval"),//同一IP注册间隔时间
//    SETTING_REG_LIMIT_REG_ADDRESS_AGENT(Module.MASTER_SETTING, "reg_limit_agent", "reg_address"),//同一IP24小时注册次数
//    SETTING_REG_LIMIT_IP_DAY_MAX_REGNUM_AGENT(Module.MASTER_SETTING, "reg_limit_agent", "ip_day_max_regNum"),//注册地址
//    SETTING_REG_SETTING_FIELD_SETTING_AGENT(Module.MASTER_SETTING, "reg_setting_agent", "field_setting"),//注册字段设置
//    SETTING_REG_SETTING_FIELD_AGENT(Module.MASTER_SETTING, "reg_setting_agent", ""),//注册字段设置
//    SETTING_REG_SETTING_PHONE_VERIFCATION_AGENT(Module.MASTER_SETTING, "reg_setting_agent", "verification_phone"),//手机注册前before，注册后验证after
//    SETTING_REG_SETTING_MAIL_VERIFCATION_AGENT(Module.MASTER_SETTING, "reg_setting_agent", "verification_mail"),//邮箱注册前before，注册后验证after//TODO PARAM Check是否有用
//    SETTING_REG_SERVICE_TERMS_SHOW_AGENT(Module.MASTER_SETTING, "reg_setting_agent", "service_show"),//是否显示服务条款
//    SETTING_REG_SERVICE_TERMS_FORCED_SHOW_AGENT(Module.MASTER_SETTING, "reg_setting_agent", "service_forced"),//是否强制显示服务条款
//    CONTENT_PAY_ACCOUNT_WARNING_DEPOSIT_RESET_DAYS_NEXT_TIME(Module.MASTER_CONTENT, "payAccountWarning", "deposit.reset.days.next.time"),//账户下次清零时间
//    CONTENT_PAY_ACCOUNT_WARNING_UNUSUAL_ERROR_NOTICE_VAL(Module.MASTER_CONTENT, "payAccountWarning", "unusual.error.notice.val"),//X小时内X个玩家对某收款账户失败达到X次时进行提醒
//    CONTENT_PAY_ACCOUNT_WARNING_UNUSUAL_NOINCOME_NOTICE_VAL(Module.MASTER_CONTENT, "payAccountWarning", "unusual.noincome.notice.val"),//X小时内次某收款账号没有存款成功的订單时提醒
//
//    //带玩注册初始金额
//    SETTING_TAKE_PLAY_ACCOUNT_INIT_MONEY(Module.MASTER_SETTING, "take_play_account", "init_money"),
//    //带玩注册次数上限
//    SETTING_TAKE_PLAY_ACCOUNT_MAX_NUMBER(Module.MASTER_SETTING, "take_play_account", "max_number"),
//
//    //玩家VIP等级
//    SETTING_PLAYER_VIP_STATUS(Module.MASTER_SETTING, "VIP", "status"),
//    SETTING_PLAYER_VIP_ONE(Module.MASTER_SETTING, "VIP", "1"),
//    SETTING_PLAYER_VIP_TWO(Module.MASTER_SETTING, "VIP", "2"),
//    SETTING_PLAYER_VIP_THREE(Module.MASTER_SETTING, "VIP", "3"),
//    SETTING_PLAYER_VIP_FOUR(Module.MASTER_SETTING, "VIP", "4"),
//    SETTING_PLAYER_VIP_FIVE(Module.MASTER_SETTING, "VIP", "5"),
//    SETTING_PLAYER_VIP_SIX(Module.MASTER_SETTING, "VIP", "6"),
//    SETTING_PLAYER_VIP_SEVEN(Module.MASTER_SETTING, "VIP", "7"),
//    SETTING_PLAYER_VIP_EIGHT(Module.MASTER_SETTING, "VIP", "8"),
//    SETTING_PLAYER_VIP_NINE(Module.MASTER_SETTING, "VIP", "9"),
//    SETTING_PLAYER_VIP_TEN(Module.MASTER_SETTING, "VIP", "10"),
//    /**
//     * 注册检查真实姓名
//     */
//    SETTING_CHECK_REAL_NAME(Module.MASTER_SETTING, "check_params", "real_name"),
//    SETTING_CHECK_MOBILE(Module.MASTER_SETTING, "check_params", "mobile"),
//    SETTING_CHECK_WEIXIN(Module.MASTER_SETTING, "check_params", "weixin"),
//    /**
//     * 玩家收款账号是否支持支付宝（默认支持）
//     */
//    SETTING_CHECK_PAYEE_BANK_ALIPAY(Module.MASTER_SETTING, "check_params", "payee_bank_alipay"),
//    /**
//     * 玩家收款账号是否支持微信（默认支持）
//     */
//    SETTING_CHECK_PAYEE_BANK_WEIXIN(Module.MASTER_SETTING, "check_params", "payee_bank_weixin"),
//
//    /**
//     * 开启额度转换按钮{注释：默认false 额度转换、true 免转}
//     */
//    API_TRANSFER_SITE(Module.MASTER_SETTING, "check_params", "api_transfer"),
//
//    /**
//     * 盘口参数
//     * */
//    SETTING_DISC(Module.MASTER_SETTING,"disc","disc_mode"),
//    /**
//     * 是否禁止转账 true-不能转账
//     */
//    DISABLE_TRANSFER(Module.MASTER_SETTING, "fund", "disable_transfer"),
//    //SITE_DOMAIN_PARAM(Module.BOSS_SITE,"domian_param","site_domain") //移动到了boss
//    /**
//     * api额度免转开关
//     **/
//    SITE_API_AUTO_PAY(Module.MASTER_SETTING, "api_setting", "auto_pay"),
//    /**
//     * 快速充值域名地址
//     */
//    SETTING_RECHARGE_URL(Module.MASTER_SETTING, "online_recharge", "recharge_url"),
//    /**
//     * 快速充值域名是否参与全部层级
//     */
//    SETTING_RECHARGE_URL_ALL_RANK(Module.MASTER_SETTING, "online_recharge", "recharge_url_all_rank"),
//    /**
//     * 快速充值域名参与层级id，以逗号隔开
//     */
//    SETTING_RECHARGE_URL_RANKS(Module.MASTER_SETTING, "online_recharge", "recharge_url_ranks"),
//    /*取款现金方式：是否开启现金*/
//    SETTING_WITHDRAW_TYPE_IS_CASH(Module.MASTER_SETTING, "withdraw_type", "is_cash"),
//    /*取款先进方式：是否开启比特币*/
//    SETTING_WITHDRAW_TYPE_IS_BITCOIN(Module.MASTER_SETTING, "withdraw_type", "is_bitcoin"),
//    /**
//     * 上分系统分公司的KEY值
//     **/
//    SITE_PAY_KEY(Module.MASTER_CONTENT, "company_recharge", "pay_key"),
//    /**
//     * 上分系统开关-由运营商设置
//     **/
//    SITE_ACB_SWITCH(Module.MASTER_CONTENT, "company_recharge", "acb_switch"),
//    /**
//     * 站点單注最低限额设置
//     */
//    SETTING_CAPTCHA_MINBETQUOTA(Module.MASTER_SETTING,"quota","minBetQuota"),
//
//    SETTING_OPERATE_MANAGE_LINE(Module.MASTER_SETTING, "operate_manage", "line"),//启用线路检测站
//    SETTING_SYSTEM_SETTINGS_SMS(Module.MASTER_SETTING, "system_settings", "sms"),//启用短信功能
//    /**PC客服系统参数设置*/
//    SETTING_PC_CUSTOMER(Module.CUSTOMER,"customer","pc"),
//    /**mobile客服系统参数设置*/
//    SETTING_MOBILE_CUSTOMER(Module.CUSTOMER,"customer","mobile"),
//    /**启用全代理模式设置*/
//    SETTING_REGISTER_MODE(Module.CUSTOMER,"system_settings","register_mode"),
//
//    ANALYZE_PLAYER_EFFECTIVE(Module.ANALYZE_PLAYER, "system_settings", "effective_amount"),
    ANALYZE_PLAYER_STATIC_TIME_END(Module.ANALYZE_PLAYER, "system_settings", "static_time_end");//最新统计时间

    SiteParamEnum(IModule module, String type, String code) {
        this.module = module;
        this.type = type;
        this.code = code;
    }

    private IModule module;
    private String type;
    private String code;

    @Override
    public IModule getModule() {
        return module;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getCode() {
        return code;
    }
}
