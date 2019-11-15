package so.wwb.creditbox.model.manager.lottery;


import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 17-4-3.
 */
public class LotteryGatherParam implements Serializable {

    public LotteryGatherParam() {
    }

    private static final long serialVersionUID = 3276820539530828778L;
    //期数
    private String expect;
    //彩种类型
    private String type;
    //彩票code
    private String code;
    //彩票地址
    private String url;
    //封盘时间
    private Date closeTime;
    //开奖时间
    private Date lotteryTime;
    //采集日期
    private String date;

    private LotteryGatherConf lotteryGatherConf;

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
}
