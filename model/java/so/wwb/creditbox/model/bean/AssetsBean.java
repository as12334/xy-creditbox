package so.wwb.creditbox.model.bean;

import so.wwb.creditbox.model.manager.lottery.bean.BaseBean;

/**
 * APP 购彩记录页面资产bean
 * Create by Fei on 2018-01-12
 */
public class AssetsBean extends BaseBean {

    /** 账户余额 */
    private Double balance;
    /** 中奖金额(派彩) */
    private Double payout = 0d;
    /** 投注总额 */
    private Double betAmount;
    /** 盈亏 */
    private Double profit = 0d;
    /** 有效投注额 */
    private Double effective = 0d;
    /** 返点 */
    private Double rebate = 0d;
    /** 未开奖金额 */
    private Double unOpen = 0d;
    /** 撤單 */
    private Double revoke = 0d;
    /** 撤销 */
    private Double repeal = 0d;
    /** 前一天盈亏 */
    private Double beforeProfit = 0d;
    /** 后一天盈亏 */
    private Double afterProfit = 0d;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPayout() {
        return payout;
    }

    public void setPayout(Double payout) {
        this.payout = payout;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getEffective() {
        return effective;
    }

    public void setEffective(Double effective) {
        this.effective = effective;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Double getUnOpen() {
        return unOpen;
    }

    public void setUnOpen(Double unOpen) {
        this.unOpen = unOpen;
    }

    public Double getRevoke() {
        return revoke;
    }

    public void setRevoke(Double revoke) {
        this.revoke = revoke;
    }

    public Double getRepeal() {
        return repeal;
    }

    public void setRepeal(Double repeal) {
        this.repeal = repeal;
    }

    public Double getBeforeProfit() {
        return beforeProfit;
    }

    public void setBeforeProfit(Double beforeProfit) {
        this.beforeProfit = beforeProfit;
    }

    public Double getAfterProfit() {
        return afterProfit;
    }

    public void setAfterProfit(Double afterProfit) {
        this.afterProfit = afterProfit;
    }
}
