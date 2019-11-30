package so.wwb.creditbox.model.enums.notice;

import org.soul.commons.enums.EnumTool;
import org.soul.model.msg.notice.enums.ICometSubscribeType;

public enum CometSubscribeType implements ICometSubscribeType {
    SYS_TEST("SYS_TEST", "测试"),
    NEW_BILL("NEW_BILL", "新订單通知"),
    ECHO(CODE_ECHO,"测试回声"),
    M_SYS_ANN("M_SYS_ANN", "系统公告1"),
    S_SYS_ANN("S_SYS_ANN", "系统公告2"),
    D_SYS_ANN("D_SYS_ANN", "系统公告3"),

    ME_SYS_ANN("ME_SYS_ANN","商户系统公告"),
    SH_SYS_ANN("SH_SYS_ANN","股东系统公告"),
    DI_SYS_ANN("DI_SYS_ANN","总代系统公告"),

    ME_SYS_MSG("ME_SYS_MSG","商户系统消息"),
    SH_SYS_MSG("SH_SYS_MSG","股东系统消息"),
    DI_SYS_MSG("DI_SYS_MSG","总代系统消息"),

    GAME_ANN("GAME_ANN", "游戏公告"),
    SITE_ANN("SITE_ANN", "站点公告"),
    SITE_MESSAGE("SITE_MESSAGE", "站内信"),
    TASK_REMINDER("MCENTER_TASK_REMINDER", "任务提醒"),
    TASK_PAY_EX("MCENTER_PAY_EX", "账户异常任务提醒"),
    TASK_PAY_REMINDER("MCENTER_TASK_PAY", "账户任务提醒"),
    TASK_RANK_INADEQUATE("TASK_RANK_INADEQUATE", "层级账户不足弹窗提醒"),
    TASK_PAY("MCENTER_TASK_COUNT", "账户任务提醒"),
    PROFIT("MCENTER_PROFIT", "盈利上限提醒"),

    RANKINADEQUATE("MCENTER_RANKINADEQUATE", "层级账户不足提醒"),
    READ_COUNT("MCENTER_READ_COUNT", "消息提醒"),
    EXPORT_DOWNLOAD_REMINDER("EXPORT_DOWNLOAD_REMINDER", "下载导出提醒"),

    MSITE_ONLINERECHARGE("MSITE-ONLINERECHARGE", "线上支付结果"),
    MSITE_PLAYER_ANNOUNCEMENT_NOTICE("MSITE-Player-Announcement-Notice", "消息公告弹窗提醒"),

    MCENTER_PLAYER_AUDIO("MCENTER_PLAYER_AUDIO", "玩家注册声音提醒"),
    MCENTER_RECHARGE_CHECK_REMINDER("MCENTER_RECHARGE_CHECK_REMINDER", "存款审核完成提醒"),
    MCENTER_NEGATIVE_WIHTHDRAW_REMINDER("MCENTER_NEGATIVE_WIHTHDRAW_REMINDER", "手动回充提醒"),
    MCENTER_ONLINE_RECHARGE_REMINDER("MCENTER_ONLINE_RECHARGE_REMINDER", "在线支付存款提醒"),
    MCENTER_WITHDRAW_AUDIT_UPDATE_STATUS("MCENTER_WITHDRAW_AUDIT_UPDATE_STATUS", "玩家取款审核后更新状态"),
    MCENTER_LOTTREY_RESULT_REMINDER("MCENTER_LOTTREY_RESULT_REMINDER", "彩票结果采集监控"),

    MERCHANT_RECHARGE_REMINDER("MERCHANT_RECHARGE_REMINDER", "存款审核提醒"),
    MERCHANT_WITHDRAW_REMINDER("MERCHANT_WITHDRAW_REMINDER", "取款提醒"),

    BOSS_ATTACK_REMINDER("BOSS_ATTACK_REMINDER", "攻击监控"),
    BOSS_CREDIT_PAY_REMINDER("BOSS_CREDIT_PAY_REMINDER", "买分提醒"),
    BOSS_TRANSFER_REMINDER("BOSS_TRANSFER_REMINDER", "转账异常提醒"),
    BOSS_API_ORDER_REMINDER("BOSS_API_ORDER_REMINDER", "API注單进度监控"),
    BOSS_API_TRANS_REMINDER("BOSS_API_TRANS_REMINDER", "API转账进度监控"),

    BOSS_LOTTREY_RESULT_GATHER("BOSS_LOTTREY_RESULT_GATHER", "彩票结果采集监控"),
    BOSS_LOTTREY_RESULT_VALID("BOSS_LOTTREY_RESULT_VALID", "彩票结果校验监控"),
    BOSS_LOTTREY_RESULT_INIT("BOSS_LOTTREY_RESULT_INIT", "彩票结果初始化监控"),

    SHAREHOLDER_LOTTREY_RESULT_REMINDER("SHAREHOLDER_LOTTREY_RESULT_REMINDER", "股东彩票结果采集监控"),
    MERCHANT_LOTTREY_RESULT_REMINDER("MERCHANT_LOTTREY_RESULT_REMINDER", "商户彩票结果采集监控"),
    DISTRIBUTOR_LOTTREY_RESULT_REMINDER("DISTRIBUTOR_LOTTREY_RESULT_REMINDER", "总代彩票结果采集监控"),

    BOSS_LOTTERY_ERROR("BOSS_LOTTERY_ERROR", "彩票错误监控"),

    MERCHANT_API("MERCHANT_API", "商户API"),

    //只播放类型 为notice的声音
    MESSAGE_NOTICE("MESSAGE_NOTICE","消息通知"),
    TRANSFER_LIMIT_WARNING("TRANSFER_LIMIT_WARNING", "转账上限提醒"),
    LARGE_TRANSACTION_MONITOR("LARGE_TRANSACTION_MONITOR","大额交易监控"),
    LOTTERY_BETORDER("LOTTERY_BETORDER","注單推送"),
    MSITE_DIGICCY_REFRESH_BALANCE("MSITE_DIGICCY_REFRESH_BALANCE", "自动刷新余额");


    CometSubscribeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getTrans() {
        return desc;
    }

    public static CometSubscribeType enumOf(String code) {
        return EnumTool.enumOf(CometSubscribeType.class, code);
    }
}
