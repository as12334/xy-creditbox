package so.wwb.creditbox.model.enums.site;

import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.IModule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longer on 7/1/15.
 * 统一模块类
 * 定义全局有关模块的信息,如字典模块,参数模块,日志模块,异常模块
 */
public enum Module implements IModule {

    Log("log", "审计日志"),
    Log_Request(Log, "request", "请求"),
    Log_Request_Domain(Log_Request, "request", "域名"),
    REGION("region", "国家地区"),
    STATE("state", "州省"),
    CITY("city", "城市"),
    COMMON("common", "通用/公共"),
    COLUMN("column", "字段"),
    Passport("passport", "通行证"),
    Passport_Login(Module.Passport, "login", "登录"),
    Passport_Logout(Module.Passport, "logout", "退出"),
    PRIVILEGE("privilege", "权限"),

    NATIONS("nations", "国家/地区"),
    MESSAGE("passport", "消息"),

    GAME("game", "游戏"),
    GAME_TYPE(GAME, "game_type", "游戏分类"),

    MASTER("master", "站长"),
    MASTER_INDEX(MASTER, "index", "首页"),
    MASTER_TASK_REMINDER(MASTER, "taskReminder", "任务"),
    MASTER_PAY_WARNING(MASTER, "payWarning", "预警展示"),

    INDEX_PENDING_TASK(MASTER, "indexPendingTask", "任务"),
    MASTER_CONTENT("content", "内容"),
    MASTER_SETTING("setting", "系统设置"),

    MASTER_NOTICE("notice", "信息模板"),

    MASTER_OPERATION(MASTER, "operation", "运营管理"),

    TASKSCHEDULE("taskschedule", "任务调度"),

    BOSS("boss", "运维"),
    COMPANY("company", "运营"),
    COMPANY_SETTING("setting", "系统设置"),
    COMPANY_SITE_CLASSIFY("siteClassify", "站点类型"),

    REPORT("report", "报表"),

    PLAYER("player", "玩家"),
    PLAYER_STATUS(PLAYER, "player_status", "玩家状态"),

    FUND("fund", "资金"),
    FUND_TRANSFER("transfer", "资金-转账相关"),
    AGENT("agent", "代理中心"),
    COMPANY_SERVE("serve", "服务"),
    BOSS_SCHEME("boss_scheme", "总控-包网方案"),
    BOSS_PLATFORM(BOSS, "platform", "总控-平台"),
    SITE("site", "site"),
    BOSS_SITE("boss_site", "总控-站点"),
    PAY_WARNING("pay_warning", "账户预警"),
    SPORT_RECOMMENDED("sport_recommended", "体育推荐"),
    OP("op", "运维相关"),
    API("api", "api相关"),
    REGISTER("Register", "注册"),
    ANALYZE("analyze", "分析"),
    LOTTERY("lottery","彩票"),
    PAY("pay", "支付"),
    ACTIVITY("activity", "活动"),
    ROLE("role","角色"),
    SUB_ACCOUNT("subAccount","子账号"),
    CREDIT("credit","买分"),
    DIGICCY("digiccy","数字货币");
    private String code;//模块
    private String trans;   //名称
    private IModule parent; //父节点

    Module(String code, String name) {
        this.code = code;
        this.trans = name;
    }

    Module(IModule parent, String code, String trans) {
        this.code = code;
        this.trans = trans;
        this.parent = parent;
    }

    @Override
    public IModule getParent() {
        return parent;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    /**
     * 枚举缓存
     */
    private static Map<String, Module> cache = new HashMap<>();

    /**
     * 模块字符串转换到枚举值
     *
     * @param fullModuleCode
     * @return
     */
    public static Module enumOf(String fullModuleCode) {
        String[] codes = StringTool.split(fullModuleCode, "/");
        if (ArrayTool.isEmpty(codes)) {
            return null;
        }
        Module c = cache.get(fullModuleCode);
        if (c != null) {
            return c;
        }
        for (Module e : Module.class.getEnumConstants()) {
            IModule now = e;
            boolean isMatch = true;
            for (int i = codes.length - 1; i >= 0; i--) {
                if (now.getCode().equals(codes[i])) {
                    now = now.getParent();
                    if (now == null && i > 0) {
                        isMatch = false;
                        break;
                    }
                } else {
                    isMatch = false;
                }
            }
            if (isMatch) {
                cache.put(fullModuleCode, e);
                return e;
            }
        }
        return null;
    }
}
