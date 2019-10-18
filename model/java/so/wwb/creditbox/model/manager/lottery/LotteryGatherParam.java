package so.wwb.creditbox.model.manager.lottery;

import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.company.lottery.po.LotteryRule;

import java.io.Serializable;
import java.util.Date;

public class LotteryGatherParam implements Serializable {

    public LotteryGatherParam() {
    }

    private static final long serialVersionUID = 3276820539530828778L;
    private String expect;
    private String type; //彩种类型
    private String code; //彩种号码
    private String url;
    private Date closeTime; //关盘时间
    private Date lotteryTime; //开奖时间
    //采集日期
    private String date;
    private String gather;
    private LotteryGatherConf lotteryGatherConf;
    private LotteryRule lotteryRule;

    public LotteryRule getLotteryRule() {
        return lotteryRule;
    }

    public void setLotteryRule(LotteryRule lotteryRule) {
        this.lotteryRule = lotteryRule;
    }

    public LotteryGatherConf getLotteryGatherConf() {
        return lotteryGatherConf;
    }
    public void setLotteryGatherConf(LotteryGatherConf lotteryGatherConf) {
        this.lotteryGatherConf = lotteryGatherConf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGather() {
        return gather;
    }

    public void setGather(String gather) {
        this.gather = gather;
    }
}
