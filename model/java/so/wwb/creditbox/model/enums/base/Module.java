package so.wwb.creditbox.model.enums.base;

import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.IModule;

import java.util.HashMap;
import java.util.Map;

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

    BOSS_SCHEME("boss_scheme", "总控-包网方案"),

    NATIONS("nations", "国家/地区"),

    MESSAGE("passport", "消息"),

    GAME("game", "游戏"),

    GAME_TYPE(GAME, "game_type", "游戏分类"),

    COMPANY_SERVE("serve","服务"),

    COMPANY_SETTING("setting","系统设置"),

    MASTER("master","站长"),

    MASTER_TASK_REMINDER(MASTER,"taskReminder","任务"),

    INDEX_PENDING_TASK(MASTER,"indexPendingTask","任务"),

    MASTER_NOTICE("notice", "信息模板"),

    MASTER_SETTING("setting","系统设置"),

    TASKSCHEDULE("taskschedule", "任务调度"),

    BOSS("boss", "运维"),

    REPORT("report", "报表"),

    FUND("fund", "资金"),

    OP("op", "运维相关"),

    API("api", "api相关"),

    ACCOUNT("account", "账户相关"),

    MEMBER("member", "会员"),

    MATCH("match", "赛事维护"),

    DOMAIN("domain", "临时域名"),

    LOTTERY("lottery","彩票"),

    PLAYER("player", "玩家"),

    BET("bet", "投注"),

    CREDIT("credit","买分"),

    MASTER_PAY_WARNING(MASTER, "payWarning", "预警展示"),
    MASTER_OPERATION(MASTER, "operation", "运营管理"),

    AGENT("agent","代理商"),

    PAY("pay","支付"),
    RANK("rank","层级"),


    MASTER_CONTENT("content", "内容"),

    PLAYER_AUDIT("audit", "玩家稽核"),

    OPERATION_ACTIVITY("operation","优惠活动"),

    CUSTOMER("setting","系统设置"),

    BILL_DIVIDEN("operation","分红"),

    BILL_SALARY("operation","工资"),

    ANALYZE_PLAYER("analyze_player", "分析");

    private String code;
    private String trans;
    private IModule parent;

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

    private static Map<String, Module> cache = new HashMap<>();

    //模块字符串转换到枚举值
    public static Module enumOf(String fullModuleCode) {
        String[] codes = StringTool.split(fullModuleCode, "/");
        if (ArrayTool.isEmpty(codes)) {
            return null;
        }

        Module c = cache.get(fullModuleCode);
        if (c != null) return c;

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
                } else isMatch = false;
            }

            if (isMatch) {
                cache.put(fullModuleCode, e);
                return e;
            }
        }
        return null;
    }
}
