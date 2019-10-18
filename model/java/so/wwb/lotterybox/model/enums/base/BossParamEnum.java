package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.param.IParamEnum;
import org.soul.commons.support.IModule;

public enum BossParamEnum implements IParamEnum {
    SETTING_VISIT_MANAGEMENT_CENTER_STATUS(Module.MASTER_SETTING,"visit","visit.management.center"),//是否开启允许访问管理中心的IP

    /*清理外围页面缓存*/
    OP_PURGE_OUT_PAGE_CACHE_URL(Module.OP,"purge_out_page_cache","purge_out_page_cache"),
    /*清理外围静态资源缓存*/
    OP_PURGE_OUT_STATIC_CACHE_URL(Module.OP,"purge_out_static_cache","purge_out_static_cache"),
    OP_PURGE_CF_CACHE_URL(Module.OP,"purge_cf_cache","purge_cf_cache"),

    SETTING_CAPTCHA_STYLES(Module.MASTER_SETTING, "captcha_style", ""),
    SETTING_CAPTCHA_STYLE(Module.MASTER_SETTING, "captcha", "style"),//验证码
    SETTING_CAPTCHA_EXCLUSIONS(Module.MASTER_SETTING, "captcha", "exclusions"),//验证码排除内容
    SYS_TONE_ONLINEPAY(Module.MASTER_SETTING, "sys_tone_onlinePay", ""),
    SYS_TONE_WARM(Module.MASTER_SETTING, "sys_tone_warm", ""),
    SYS_TONE_NOTICE(Module.MASTER_SETTING, "sys_tone_notice", ""),
    SYS_TONE_DRAW(Module.MASTER_SETTING, "sys_tone_draw", ""),
    SYS_TONE_DEPOSIT(Module.MASTER_SETTING, "sys_tone_deposit", ""),
    SYS_TONE_AUDIT(Module.MASTER_SETTING, "sys_tone_audit", ""),
    SYS_TONE_GATHER(Module.MASTER_SETTING, "sys_tone_gather", ""),
    SYS_TONE_BILL(Module.MASTER_SETTING, "sys_tone_bill", ""),
    SYS_TONE_SYSDRAW(Module.MASTER_SETTING, "sys_tone_sysDraw", ""),
    SYS_TONE_SYSDEPOSIT(Module.MASTER_SETTING, "sys_tone_sysDeposit", ""),


    DOMAIN_URL_SHAREHOLDER(Module.DOMAIN, "url", "shareholder_url"),
    DOMAIN_URL_MERCHANT(Module.DOMAIN, "url", "merchant_url"),
    DOMAIN_URL_AGENT(Module.DOMAIN, "url", "agent_url"),

    //买分默认剩余倒计时
    CONTENT_DOMAIN_TYPE_INDEX(Module.MASTER_CONTENT, "domain_type", "index"),//页面地址类别
    CONTENT_DOMAIN_TYPE_MANAGER(Module.MASTER_CONTENT, "domain_type", "manager"),//管理地址类别

    CONTENT_DOMAIN_TYPE_ONLINEPAY(Module.MASTER_CONTENT, "domain_type", "onLinePay"),//支付地址类别
    SETTING_PRIVILAGE_PASS_TIME(Module.MASTER_SETTING,"privilage_pass_time","setting.privilage.pass.time"),//密码权限时效性设置
    PASSPORT_LOGIN_ErrorTimesLimit(Module.Passport,"login","error.times.for.freeze"),
    WARMING_TONE_GATHER(Module.MASTER_SETTING, "warming_tone_project", "gather"), //采集器报警
    ;


    BossParamEnum(IModule module, String type, String code) {
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

    @Override
    public String toString() {
        return module+":"+type+":"+code;
    }
}
