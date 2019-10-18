package so.wwb.lotterybox.model.manager.lottery.bean;


import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrder;

import java.util.List;

public class OrderBean extends BaseBean {
    // 彩种
    private String code;
    // 当前期数
    private String expect;
    // 投注数量
    private int quantity;
    // 投注总额
    private double totalMoney;
    // 玩法模式
    private String playModel;
    // 投注订单详情
    private List<LotteryBetOrder> betOrders;
    /** 盘口信息 */
    private LotteryResult handicap;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<LotteryBetOrder> getBetOrders() {
        return betOrders;
    }

    public void setBetOrders(List<LotteryBetOrder> betOrders) {
        this.betOrders = betOrders;
    }

    public String getPlayModel() {
        return playModel;
    }

    public void setPlayModel(String playModel) {
        this.playModel = playModel;
    }

    public LotteryResult getHandicap() {
        return handicap;
    }

    public void setHandicap(LotteryResult handicap) {
        this.handicap = handicap;
    }

}
