package so.wwb.creditbox.model.common;

import org.soul.commons.ienums.ICodeEnum;

/**
 * @author jeremy
 *         PS： 添加审计日志请按照格式， 以便后续维护
 *         1.
 * @time 2018年09月13日21:34:21
 */
public enum AuditLogEnum implements ICodeEnum {

    //账号相关
    UPDATE_PLAYER_ACCOUNT_PASSWORD("update.player.account.password", "[玩家账号-重置登录密码] 账号[{0}]"),
    UPDATE_PLAYER_ACCOUNT_PERMISSION_PASSWORD("update.player.account.permission_password", "[玩家账号-重置资金密码] 账号[{0}]"),
    UPDATE_PLAYER_ACCOUNT_REAL_NAME("update.player.account.real_name", "[玩家账号-修改真实姓名] 账号[{0}] 真实姓名[{1}]"),
    UPDATE_PLAYER_ACCOUNT_NICK_NAME("update.player.account.nick_name", "[玩家账号-修改昵称] 账号[{0}] 昵称[{1}]"),
    UPDATE_PLAYER_ACCOUNT_MEMO("update.player.account.memo", "[玩家账号-修改备注] 账号[{0}] 备注[{1}]"),
    UPDATE_PLAYER_ACCOUNT_INFO("update.player.account.info", "[玩家账号-修改详细资料] 账号[{0}]"),
    UPDATE_PLAYER_ACCOUNT_STATUS("update.player.account.status", "[玩家账号-修改账号状态] 状态[{0}] 账号[{1}]"),
    UPDATE_PLAYER_ACCOUNT_RANK("update.player.account.rank", "[玩家账号-修改所属层级] 层级[{0}] 账号[{1}]"),
    UPDATE_PLAYER_ACCOUNT_RAKEBACK("update.player.account.rakeback", "[玩家账号-修改所属返水方案] 返水方案[{0}] 账号[{1}]"),
    INSERT_PLAYER_ACCOUNT("insert.player.account", "[新增玩家/代理账号] 账号[{0}] 真实姓名[{1}] 类型[{2}] 层数[{3}] 上级代理[{4}]"),
    //玩家收款账号
    INSERT_PLAYER_BANK_CARD("insert.player.bank.card", "[玩家账号-新增银行卡] 持卡人姓名[{0}] 银行[{1}] 卡号[{2}] 类型[{3}] 是否默认[{4}]"),
    UPDATE_PLAYER_BANK_CARD("update.player.bank.card", "[玩家账号-编辑银行卡] 持卡人姓名[{0}] 银行[{1}] 卡号[{2}] 类型[{3}] 是否默认[{4}]"),
    DELETE_PLAYER_BANK_CARD("delete.player.bank.card", "[玩家账号-删除银行卡] 持卡人姓名[{0}] 银行[{1}] 卡号[{2}] 类型[{3}] 是否默认[{4}]"),
    INSERT_PLAYER_ALIAPY("insert.player.alipay", "[玩家账号-新增支付宝] 玩家账号[{0}] 二维码路径[{1}] 支付宝账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),
    UPDATE_PLAYER_ALIAPY("update.player.alipay", "[玩家账号-编辑支付] 玩家账号[{0}] 二维码路径[{1}] 支付宝账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),
    DELETE_PLAYER_ALIAPY("delete.player.alipay", "[玩家账号-删除支付] 玩家账号[{0}] 二维码路径[{1}] 支付宝账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),
    INSERT_PLAYER_WEIXIN("insert.player.weixin", "[玩家账号-新增微信] 玩家账号[{0}] 二维码路径[{1}] 微信账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),
    UPDATE_PLAYER_WEIXIN("update.player.weixin", "[玩家账号-编辑微信] 玩家账号[{0}] 二维码路径[{1}] 微信账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),
    DELETE_PLAYER_WEIXIN("delete.player.weixin", "[玩家账号-删除微信] 玩家账号[{0}] 二维码路径[{1}] 微信账号[{2}] 填写的姓名[{3}] 手机号码[{4}] 是否默认[{5}]"),

    //带玩相关
    INSERT_TAKE_PLAY_ACCOUNT("insert.take.play.account", "[带玩账号-新增账号] 账号[{0}]"),
    UPDATE_TAKE_PLAY_ACCOUNT_BALANCE("update.take.play.account.balance", "[带玩账号-修改钱包余额] 站点[{0}] 账号[{1}] 改前余额[{2}] 改后余额[{3}]"),
    UPDATE_TAKE_PLAY_SYS_PARAM("update.take.play.sys.param", "[带玩账号-修改带玩系统参数] 站点[{0}] 改前注册次数上限[{1}] 改后注册次数上限[{2}] 改前注册初始金额[{3}] 改后注册初始金额[{4}]"),
    UPDATE_TAKE_PLAY_ACCOUNT_STATUS("update.take.play.account.status", "[带玩账号-修改账号状态] 站点[{0}] 账号[{1}] 状态[{2}]"),

    //平台账号
    UPDATE_MANAGE_ACCOUNT_PASSWORD("update.manage.account.password", "[平台账号-重置登录密码] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
    UPDATE_MANAGE_ACCOUNT_STATUS("update.manage.account.status", "[平台账号-修改账号状态] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
    UPDATE_MANAGE_ACCOUNT_INFO("update.manage.account.info", "[平台账号-修改详细资料] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}] 状态[{4}]"),
    INSERT_MANAGE_ACCOUNT("insert.manage.account", "[平台账号-新增账号] 站点[{0}] 账号[{1}] 类型[{2}] 上级[{3}]"),
    UPDATE_MANAGE_ACCOUNT_AUTHENTICATION_KEY("update.manage.account.authentication", "[平台账号-重置身份验证] 站点[{0}] 账号[{1}] 类型[{2}] 上级id[{3}] 验证码地址[{4}]"),

    //资金
    //系统存取
    INSERT_MANUAL_DEPOSIT_ORDER("insert.manual.deposit.order", "[系统存取-生成存款订單] 站点[{0}] [{1}]"),
    INSERT_MANUAL_WITHDRAW_ORDER("insert.manual.withdraw.order", "[系统存取-生成取款订單] 站点[{0}] 玩家[{1}] 订單号[{2}] 取款金额[{3}] 取款类型[{4}] 是否清除稽核点[{5}]"),
    //存款审核
    UPDATE_MANUAL_DEPOSIT_CHECK_SUCCESS("update.manual.deposit.check.success", "[财务审核-系统存款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 存款金额[{3}] 优惠金额[{4}] 优惠状态[{5}] 实际到账金额[{6}]"),
    UPDATE_MANUAL_DEPOSIT_CHECK_FAIL("update.manual.deposit.check.fail", "[财务审核-系统存款订單失败] 站点[{0}] 玩家[{1}] 订單号[{2}] 失败金额[{3}]"),
    UPDATE_MANUAL_DEPOSIT_REMARK("update.manual.deposit.remark", "[备注信息-系统存款订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),
    //公司入款
    UPDATE_COMPANY_DEPOSIT_CHECK_SUCCESS("update.company.deposit.check.success", "[财务审核-公司入款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 存款金额[{3}] 优惠金额[{4}] 优惠状态[{5}] 手续费[{6}] 实际到账金额[{7}]"),
    UPDATE_COMPANY_DEPOSIT_CHECK_FAIL("update.company.deposit.check.fail", "[财务审核-公司入款订單失败] 站点[{0}] 玩家[{1}] 订單号[{2}] 失败金额[{3}]"),
    UPDATE_COMPANY_DEPOSIT_REMARK("update.company.deposit.remark", "[备注信息-公司入款订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),
    //优惠活动
    UPDATE_FAVORABLE_DEPOSIT_CHECK_SUCCESS("update.favorable.deposit.check.success", "[财务审核-活动优惠订單赠送] 站点[{0}] 玩家[{1}] 订單号[{2}] 赠送优惠金额[{3}]"),
    UPDATE_FAVORABLE_DEPOSIT_CHECK_FAIL("update.favorable.deposit.check.fail", "[财务审核-活动优惠订單拒绝] 站点[{0}] 玩家[{1}] 订單号[{2}] 拒绝优惠金额[{3}]"),
    UPDATE_FAVORABLE_DEPOSIT_REMARK("update.favorable.deposit.remark", "[备注信息-优惠活动订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),
    //线上支付
    UPDATE_ONLINE_DEPOSIT_CHECK_SUCCESS("update.online.deposit.check.success", "[财务审核-线上支付订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 存款金额[{3}] 手续费[{4}] 实际到账金额[{5}]"),
    UPDATE_ONLINE_DEPOSIT_CHECK_FAIL("update.online.deposit.check.fail", "[财务审核-线上支付订單失败] 站点[{0}] 玩家[{1}] 订單号[{2}] 失败金额[{3}]"),
    UPDATE_ONLINE_DEPOSIT_REMARK("update.online.deposit.remark", "[备注信息-线上支付订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),

    //系统取款
    UPDATE_MANUAL_WITHDRAW_CHECK_LOCK("update.manual.withdraw.check.lock", "[财务审核-系统取款订單锁定] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_MANUAL_WITHDRAW_CHECK_UNLOCK("update.manual.withdraw.check.unlock", "[财务审核-系统取款订單解锁] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_MANUAL_WITHDRAW_CHECK_SUCCESS("update.manual.withdraw.check.success", "[财务审核-系统取款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 取款金额[{3}] 类型[{4}] 是否清除稽核点[{5}]"),
    UPDATE_MANUAL_WITHDRAW_CHECK_FAIL("update.manual.withdraw.check.fail", "[财务审核-系统取款订單失败] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_MANUAL_WITHDRAW_REMARK("update.manual.withdraw.remark", "[备注信息-系统取款订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),
    //玩家取款
    UPDATE_PLAYER_WITHDRAW_CHECK_LOCK("update.player.withdraw.check.lock", "[财务审核-玩家取款订單锁定] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_PLAYER_WITHDRAW_CHECK_UNLOCK("update.player.withdraw.check.unlock", "[财务审核-玩家取款订單解锁] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_PLAYER_WITHDRAW_CHECK_SUCCESS("update.player.withdraw.check.success", "[财务审核-玩家取款订單通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 取款金额[{3}] 扣除优惠[{4}] 行政费[{5}] 实际到账金额[{6}]"),
    UPDATE_PLAYER_WITHDRAW_CHECK_FAIL("update.player.withdraw.check.fail", "[财务审核-玩家取款订單失败] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_PLAYER_WITHDRAW_CHECK_REJECT("update.player.withdraw.check.reject", "[财务审核-玩家取款订單拒绝] 站点[{0}] 玩家[{1}] 订單号[{2}]"),
    UPDATE_PLAYER_WITHDRAW_REMARK("update.player.withdraw.remark", "[备注信息-玩家取款订單] 站点[{0}] 订單号[{1}] 类型[{2}] 备注[{3}]"),
    //赠送状态
    UPDATE_GIVE_FAVORABLE_SUCCESS("update.give.favorable.success", "[修改赠送优惠状态-通过] 站点[{0}] 玩家[{1}] 订單号[{2}] 赠送金额[{3}]"),
    UPDATE_GIVE_FAVORABLE_REJECT("update.give.favorable.reject", "[修改赠送优惠状态-拒绝] 站点[{0}] 玩家[{1}] 订單号[{2}] 拒绝金额[{3}]"),

    //系统参数
    UPDATE_PARAM_CHECK_REAL_NAME("update.param.check.real_name", "[系统参数-修改真实姓名必填状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_MOBILE("update.param.check.mobile", "[系统参数-修改手机号必填状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_WEIXIN("update.param.check.weixin", "[系统参数-修改微信号必填状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_DEMO("update.param.check.demo", "[系统参数-修改试玩开关状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_VERIFICATION("update.param.check.verification", "[系统参数-修改转站验证] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_PAYEE_BANK_ALIPAY("update.param.check.payee_bank_alipay", "[系统参数-修改玩家收款账号支持支付宝状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_PAYEE_BANK_WEIXIN("update.param.check.payee_bank_weixin", "[系统参数-修改玩家收款账号支持支微信状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),
    UPDATE_PARAM_CHECK_API_TRANSFER_SITE("update.param.check.api_transfer_site", "[系统参数-修改API免转状态] 站点[{0}] 修改前状态[{1}] 修改后状态[{2}]"),


    //函数
    CALL_REPORT_OPERATE_FUNCTION("call.report.operate.function", "[执行函数-手动执行运营报表函数] 站点[{0}] 日期[{1}]"),
    CALL_REPORT_OPERATE_BUSINESS("call.report.business.function", "[执行函数-手动执行经营报表函数] 站点[{0}] 日期[{1}]"),
    CALL_INIT_SITE_CONFINE_AREA_FUNCTION("call.init.site.confine.area.function", "[执行函数-手动执初始化黑名單函数] 站点[{0}]"),


    //彩票
    INSERT_BILL_RETREAT_PARAMS("insert.bill.retreat.params", "[退水-设置参数] 站点[{0}] 盘口名称[{1}] 所属总代[{2}] 退水概述[{3}] 优惠稽核[{4}] 每期退水上限[{5}] 比例[{6}]");



    private String code;
    private String trans;


    AuditLogEnum(String code, String trans) {
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