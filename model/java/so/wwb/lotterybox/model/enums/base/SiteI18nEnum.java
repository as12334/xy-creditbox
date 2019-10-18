package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.param.IParamEnum;
import org.soul.commons.support.IModule;

public enum SiteI18nEnum implements IParamEnum {
    MASTER_CONTENT(Module.MASTER_CONTENT, "pay_account", ""),
    MASTER_CONTENT_HIDE_ACCOUNT_CONTENT(Module.MASTER_CONTENT, "pay_account", "hide_account_content"),
    OPERATE_ACTIVITY_CLASSIFY(Module.MASTER_OPERATION, "operate_activity_classify", ""),
   // COMPANY_SITE_CLASSIFY(Module.COMPANY_SITE_CLASSIFY, "company_site_classify", ""),
    //推荐设置内容和规则
    MASTER_RECOMMEND(Module.COMPANY_SETTING,"recommended",""),
    MASTER_RECOMMEND_CONTENT(Module.COMPANY_SETTING,"recommended","content"),
    //服务条款
    MASTER_SERVICE_TERMS(Module.MASTER_SETTING,"service_terms","service"),
    //代理
    MASTER_SERVICE_TERMS_AGENT(Module.MASTER_SETTING,"service_terms_agent","service"),
    MASTER_RECOMMEND_RULE(Module.COMPANY_SETTING,"recommended","rule"),
    //站点名称
    SETTING_SITE_NAME(Module.COMPANY_SETTING,"site_name","name"),
    //站点title
    SETTING_SITE_TITLE(Module.COMPANY_SETTING,"site_seo","title"),
    //站点关键字
    SETTING_SITE_KEYWORDS(Module.COMPANY_SETTING,"site_seo","keywords"),
    //站点描述
    SETTING_SITE_DESCRIPTION(Module.COMPANY_SETTING,"site_seo","description"),
    //启用代理注册
    SETTING_OPERATE_MANAGE_CLOSURE(Module.COMPANY_SETTING,"operate_manage","closure"),
    //启用站点
    SETTING_SYSTEM_SETTINGS_PLAYER(Module.COMPANY_SETTING,"system_settings","player"),
    //启用代理注册
    SETTING_SYSTEM_SETTINGS_AGENT(Module.COMPANY_SETTING,"system_settings","proxy"),
    BOSS_GAME_TYPE(Module.COMPANY_SETTING,"game_type",""),
    //游戏标签
    MASTER_GAME_TAG(Module.MASTER_SETTING,"game_tag",""),
    //包网方案
    BOSS_CONTRACT_SCHEME(Module.BOSS_SCHEME,"contract_scheme",""),
    ;

    SiteI18nEnum(IModule module, String type, String code) {
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
