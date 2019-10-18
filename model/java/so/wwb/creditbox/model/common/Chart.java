package so.wwb.creditbox.model.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fei on 16-9-5.
 */
public class Chart implements Serializable {
    /** 统计日期 */
    private Date statDate;
    private String date;
    /** 站点盈利 */
    private Double profit;
    /** 报表损益 */
    private Double payout;
    /** 新增玩家数 */
    private Integer player;
    /** 新增存款玩家数 */
    private Integer deposit;
    /** 投注玩家数 */
    private Integer bet;
    /** 线上存款 */
    private Double online;
    /** 公司入款 */
    private Double company;
    /** 手机存款 */
    private Double mobile;

    private Double manualDeposit;
    /** 有效投注额 */
    private Double effeAmount;
    /** API TYPE ID */
    private Integer apiTypeId;
    /** 投注单量 */
    private Integer single;
    /** API ID */
    private Integer apiId;

    private Integer depositPlayer;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getPayout() {
        return payout;
    }

    public void setPayout(Double payout) {
        this.payout = payout;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public Double getOnline() {
        return online;
    }

    public void setOnline(Double online) {
        this.online = online;
    }

    public Double getCompany() {
        return company;
    }

    public void setCompany(Double company) {
        this.company = company;
    }

    public Double getMobile() {
        return mobile;
    }

    public void setMobile(Double mobile) {
        this.mobile = mobile;
    }

    public Double getManualDeposit() {
        return manualDeposit;
    }

    public void setManualDeposit(Double manualDeposit) {
        this.manualDeposit = manualDeposit;
    }

    public Double getEffeAmount() {
        return effeAmount;
    }

    public void setEffeAmount(Double effeAmount) {
        this.effeAmount = effeAmount;
    }

    public Integer getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Integer apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public Integer getSingle() {
        return single;
    }

    public void setSingle(Integer single) {
        this.single = single;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public Integer getDepositPlayer() {
        return depositPlayer;
    }

    public void setDepositPlayer(Integer depositPlayer) {
        this.depositPlayer = depositPlayer;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Chart && this.date.equals(((Chart) obj).getDate());
    }
}
