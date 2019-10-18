package so.wwb.lotterybox.model.manager.lottery.po;

import java.util.Map;

/**
 * 下注累计限额
 * Created by cherry on 17-9-8.
 */
public class LotteryBetQuota {
    //彩种玩法
    String playCode;
    //下注bet_code
    String betCode;
    //同一play_code、bet_code下下注总额
    Double sumAmount;
    //同一play_code、bet_code、bet_num下下注总额
    Map<String,Double> betNumSumAmount;

    public String getPlayCode() {
        return playCode;
    }

    public void setPlayCode(String playCode) {
        this.playCode = playCode;
    }

    public String getBetCode() {
        return betCode;
    }

    public void setBetCode(String betCode) {
        this.betCode = betCode;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Map<String, Double> getBetNumSumAmount() {
        return betNumSumAmount;
    }

    public void setBetNumSumAmount(Map<String, Double> betNumSumAmount) {
        this.betNumSumAmount = betNumSumAmount;
    }
}
