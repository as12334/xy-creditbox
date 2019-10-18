package so.wwb.lotterybox.model.common;

/**
 * Created by admin on 16-5-18.
 */
public interface MessageI18nConst {

    //国际化KEY
    String OPERATION_SUCCESS = "operation.success";
    /** 存款账号丢失或被删除 */
    String RECHARGE_PAY_ACCOUNT_LOST = "recharge.payAccount.lost";
    /** 手续费不能小于存款金额 */
    String RECHARGE_AMOUNT_LT_FEE = "rechargeForm.rechargeAmountLTFee";
    //保存成功
    String SAVE_SUCCESS = "save.success";
    //保存失败
    String SAVE_FAILED = "save.failed";
    /*无交易号*/
    String PAY_NO_ORDER = "noOrder";
    /*无该笔交易*/
    String PAY_NO_EXIST_ORDER = "noExistOrder";
    /*该笔交易已完成，不能重复支付！*/
    String PAY_ORDER_FINISHED = "orderFinished";

    String DEPOSIT_VIEW_AUTOMATICALLY = "deposit.view.automatically";

    String DELETE_SUCCESS = "delete.success";
    String DELETE_FAILED = "delete.failed";
}
