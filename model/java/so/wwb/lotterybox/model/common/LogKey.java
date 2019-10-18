package so.wwb.lotterybox.model.common;

import java.io.Serializable;

/**
 * 后期废弃； 勿用！！！！！！！！！！
 *
 * 请使用审计日志枚举 AuditLogEnum 实现
 *
 *
 * Created by jeremy on 18-7-4.
 */
public class LogKey implements Serializable {

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    /**
     * 登录
     */
    public class Passport {

    }

    /**
     * 账号
     */
    public class Account {

    }

    /**
     * 彩票
     */
    public class Lottery {

    }

    /**
     * 资金
     */
    public class Fund {


        public static final String BILL_RAKEBACK_ACTUAL_MONEY_UPDATE = "bill.rakeback.actual.money.update";
        public static final String BILL_RAKEBACK_SUCCESS = "bill.rakeback.success";
        public static final String BILL_RAKEBACK_FAIL = "bill.rakeback.fail";
        public static final String BILL_RAKEBACK_BATCH_SUCCESS = "bill.rakeback.batch.success";
        public static final String BILL_RAKEBACK_BATCH_FAILURE = "bill.rakeback.batch.failure";
        public static final String CALL_BILL_RAKEBACK = "call.bill.rakeback";

        public static final String BILL_RETREAT_SUCCESS ="bill.retreat.success";
        public static final String BILL_RETREAT_FAIL ="bill.retreat.fail";
        public static final String BILL_RETREAT_BATCH_SUCCESS = "bill.retreat.batch.success";
        public static final String BILL_RETREAT_BATCH_FAIL = "bill.retreat.batch.fail";

        public static final String BILL_SALARY_SUCCESS = "bill.salary.success";
        public static final String BILL_SALARY_FAIL = "bill.salary.fail";
        public static final String CALL_BILL_SALARY = "call.bill.salary";
        public static final String BILL_SALARY_BATCH_SUCCESS = "bill.salary.batch.success";
        public static final String BILL_SALARY_BATCH_FAIL = "bill.salary.batch.fail";


        public static final String BILL_DIVIDEN_SUCCESS = "bill.dividen.success";
        public static final String BILL_DIVIDEN_BATCH_SUCCESS = "bill.dividen.batch.success";
        public static final String BILL_DIVIDEN_FAIL = "bill.dividen.fail";
        public static final String BILL_DIVIDEN_BATCH_FAIL = "bill.dividen.batch.fail";
        public static final String BILL_DIVIDEN_HANGING = "bill.dividen.hanging";
        public static final String BILL_DIVIDEN_BATCH_HANGING = "bill.dividen.batch.hanging";
        public static final String CALL_BILL_DIVIDEN = "call.bill.dividen";


        public static final String MANUAL = "fund.manual.";
        public static final String ONLINE = "fund.online.";
        public static final String COMPANY = "fund.company.";
        public static final String FAVORABLE = "fund.favorable.";
        public static final String SYS = "fund.sys.";
        public static final String DEPOSIT_CHECK = "deposit.check.";
        public static final String WITHDRAW_CHECK = "withdraw.check.";

        /**
         * [订单详情备注] 站点[{0}] 订单号[{1}] 类型[{2}] 备注[{3}]
         * fund.favorable.remark
         */
        public static final String FAVORABLE_REMARK = FAVORABLE + "remark";
        /**
         * [禁用/启用财务模块声音] 站点[{0}] 模块[{1}] 状态[{2}]
         * fund.sys.voice
         */
        public static final String SYS_VOICE = SYS + "voice";
        /**
         * [系统存款订单生成成功] 站点[{0}] 玩家[{1}] 订单号[{2}] 存款金额[{3}] 存款类型[{4}] 存款打码量[{5}] 优惠金额[{6}] 优惠打码量[{7}]
         * fund.manual.deposit.success
         */
        public static final String MANUAL_DEPOSIT_SUCCESS = MANUAL + "deposit." + SUCCESS;
        /**
         * [系统存款订单生成失败] 站点[{0}] 玩家[{1}] 存款失败金额[{2}] 失败原因[{3}]
         * fund.manual.deposit.fail
         */
        public static final String MANUAL_DEPOSIT_FAIL = MANUAL + "deposit." + FAIL;
        /**
         * [系统取款订单生成成功] 站点[{0}] 玩家[{1}] 订单号[{2}] 取款金额[{3}] 取款类型[{4}] 是否清楚稽核点[{5}]
         * fund.manual.withdraw.success
         */
        public static final String MANUAL_WITHDRAW_SUCCESS = MANUAL + "withdraw." + SUCCESS;
        /**
         * [系统取款订单生成失败] 站点[{0}] 玩家[{1}] 取款失败金额[{2}] 失败原因[{3}]
         * fund.manual.withdraw.fail
         */
        public static final String MANUAL_WITHDRAW_FAIL = MANUAL + "withdraw." + FAIL;

        /**
         * [审核系统存款通过] 站点[{0}] 玩家[{1}] 订单号[{2}] 实际到账金额[{3}]
         * fund.manual.deposit.check.success
         */
        public static final String MANUAL_DEPOSIT_CHECK_SUCCESS = MANUAL + DEPOSIT_CHECK + SUCCESS;
        /**
         * [审核系统存款失败] 站点[{0}] 玩家[{1}] 订单号[{2}] 失败金额[{3}]
         * fund.manual.deposit.check.fail
         */
        public static final String MANUAL_DEPOSIT_CHECK_FAIL = MANUAL + DEPOSIT_CHECK + FAIL;
        /**
         * [审核线上支付通过] 站点[{0}] 玩家[{1}] 订单号[{2}] 实际到账金额[{3}]
         * fund.online.deposit.check.success
         */
        public static final String ONLINE_DEPOSIT_CHECK_SUCCESS = ONLINE + DEPOSIT_CHECK + SUCCESS;
        /**
         * [审核线上支付失败] 站点[{0}] 玩家[{1}] 订单号[{2}] 失败金额[{3}]
         * fund.online.deposit.check.fail
         */
        public static final String ONLINE_DEPOSIT_CHECK_FAIL = ONLINE + DEPOSIT_CHECK + FAIL;
        /**
         * [审核公司入款通过] 站点[{0}] 玩家[{1}] 订单号[{2}] 实际到账金额[{3}]
         * fund.company.deposit.check.success
         */
        public static final String COMPANY_DEPOSIT_CHECK_SUCCESS = COMPANY + DEPOSIT_CHECK + SUCCESS;
        /**
         * [审核公司入款失败] 站点[{0}] 玩家[{1}] 订单号[{2}] 失败金额[{3}]
         * fund.manual.deposit.check.fail
         */
        public static final String COMPANY_DEPOSIT_CHECK_FAIL = COMPANY + DEPOSIT_CHECK + FAIL;
        /**
         * [审核活动优惠通过] 站点[{0}] 玩家[{1}] 订单号[{2}] 优惠金额[{3}]
         * fund.favorable.check.success
         */
        public static final String FAVORABLE_CHECK_SUCCESS = FAVORABLE + "check." + SUCCESS;
        /**
         * [审核活动优惠失败] 站点[{0}] 玩家[{1}] 订单号[{2}] 优惠金额[{3}]
         * fund.favorable.check.fail
         */
        public static final String FAVORABLE_CHECK_FAIL = FAVORABLE + "check." + FAIL;

    }

    /**
     * 账变
     */
    public class BillChange {

    }

    /**
     * 运营
     */
    public class Operation {

    }

    /**
     * 内容
     */
    public class Content {

    }

    /**
     * 站点
     */
    public class Site {

    }

    /**
     * 系统
     */
    public class System {

    }

}
