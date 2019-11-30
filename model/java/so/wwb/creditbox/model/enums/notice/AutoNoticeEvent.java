package so.wwb.creditbox.model.enums.notice;

import org.soul.commons.enums.EnumTool;
import org.soul.model.msg.notice.enums.INoticeAutoEventType;

/**
 * Created by kevice on 7/20/15.
 */
public enum AutoNoticeEvent implements INoticeAutoEventType {

    /**
     * 定时任务监控消息类型
     */
    SCHEDULE_OVERTIME("SCHEDULE_OVERTIME", "定时任务超时"),
    SCHEDULE_EXCEPTION("SCHEDULE_EXCEPTION", "定时任务异常"),

    REGISTRY_SUCCESS("REGISTRY_SUCCESS", "注册成功"),
    DOMAIN_CHECK("DOMAIN_CHECK", "域名审核成功"),
    SWITCH("SWITCH", "开关设置"),

    //盈利上限提醒,提醒运营商
    PROFIT_MAX_RED("PROFIT_MAX_RED", "盈利上限红色预警"),
    PROFIT_MAX_ORANGE("PROFIT_MAX_ORANGE", "盈利上限橙色预警"),
    PROFIT_MAX_YELLOW("PROFIT_MAX_YELLOW", "盈利上限黄色预警"),

    //盈利上限提醒,提醒站长
    MCENTER_PROFIT_MAX_RED("MCENTER_PROFIT_MAX_RED", "盈利上限红色预警"),
    MCENTER_PROFIT_MAX_ORANGE("MCENTER_PROFIT_MAX_ORANGE", "盈利上限橙色预警"),
    MCENTER_PROFIT_MAX_YELLOW("MCENTER_PROFIT_MAX_YELLOW", "盈利上限黄色预警"),

    MANUAL_RECHARGE_SUCCESS("MANUAL_RECHARGE_SUCCESS", "手动存款成功"),
    MANUAL_WITHDRAWAL("MANUAL_WITHDRAWAL", "人工取款"),
    DEPOSIT_AUDIT_SUCCESS("DEPOSIT_AUDIT_SUCCESS", "充值审核成功"),
    DEPOSIT_AUDIT_FAIL("DEPOSIT_AUDIT_FAIL", "充值审核失败"),
    PLAYER_WITHDRAWAL_AUDIT_SUCCESS("PLAYER_WITHDRAWAL_AUDIT_SUCCESS", "玩家提现审核成功"),
    AGENT_WITHDRAWAL_AUDIT_SUCCESS("AGENT_WITHDRAWAL_AUDIT_SUCCESS", "代理提现审核成功"),
    WITHDRAWAL_AUDIT_FAIL("WITHDRAWAL_AUDIT_FAIL", "提现审核失败"),
    TRANSFER_ACCOUNTS_FAIL("TRANSFER_ACCOUNTS_FAIL", "转账失败"),
    CHANGE_PLAYER_DATA("CHANGE_PLAYER_DATA", "手动修改玩家资料"),
    TIMING_CHANGE_PASSWORD("TIMING_CHANGE_PASSWORD", "定时修改密码"),
    TIMING_CHANGE_SAFE_QUESTION("TIMING_CHANGE_SAFE_QUESTION", "定时修改安全问题"),
    SCORE_DECREASE("SCORE_DECREASE", "积分消耗"),
    LOGIN_ERROR("LOGIN_ERROR", "登录错误"),
    AUTO_KICK_OUT("AUTO_KICK_OUT", "自动踢出"),
    RETURN_RABBET_SUCCESS("RETURN_RABBET_SUCCESS", "返水结算成功"),
    RETURN_COMMISSION_SUCCESS("RETURN_COMMISSION_SUCCESS", "返佣结算成功"),
    PREFERENCE_AUDIT_SUCCESS("PREFERENCE_AUDIT_SUCCESS", "优惠审批成功"),
    PREFERENCE_AUDIT_FAIL("PREFERENCE_AUDIT_FAIL", "优惠审批失败"),
    BIND_EMAIL_VERIFICATION_CODE("BIND_EMAIL_VERIFICATION_CODE", "邮箱绑定验证码"),

    DOCUMENT_AUDIT_SUCCESS("DOCUMENT_AUDIT_SUCCESS", "文案审核成功"),
    DOCUMENT_AUDIT_FAIL("DOCUMENT_AUDIT_FAIL", "文案审核失败"),
    LOGO_AUDIT_SUCCESS("LOGO_AUDIT_SUCCESS", "LOGO审核成功"),
    LOGO_AUDIT_FAIL("LOGO_AUDIT_FAIL", "LOGO审核失败"),
    ACTIVITY_AUDIT_SUCCESS("ACTIVITY_AUDIT_SUCCESS", "优惠活动审核成功"),
    ACTIVITY_AUDIT_FAIL("ACTIVITY_AUDIT_FAIL", "优惠活动审核失败"),
    RESET_LOGIN_PASSWORD_SUCCESS("RESET_LOGIN_PASSWORD_SUCCESS", "手动重置密码"),
    RESET_PERMISSION_PWD_SUCCESS("RESET_PERMISSION_PWD_SUCCESS", "手动重置安全密码"),
    FIND_PASSWORD_VERIFICATION_CODE("FIND_PASSWORD_VERIFICATION_CODE", "邮箱绑定验证码"),
    MODIFY_STATION_BILL("MODIFY_STATION_BILL", "修改结算账單"),
    AGENT_REGISTER_SUCCESS("AGENT_REGISTER_SUCCESS", "代理注册成功"),
    PLAYER_REGISTER_SUCCESS("PLAYER_REGISTER_SUCCESS", "玩家注册成功"),
    BALANCE_AUTO_FREEZON("BALANCE_AUTO_FREEZON", "余额冻结(自动)"),
    ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "玩家账号不存在");

    AutoNoticeEvent(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return desc;
    }

    public static AutoNoticeEvent enumOf(String code) {
        return EnumTool.enumOf(AutoNoticeEvent.class, code);
    }

}
