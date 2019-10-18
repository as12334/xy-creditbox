package so.wwb.lotterybox.model.company.lottery.so;

import so.wwb.lotterybox.model.company.lottery.po.LotteryBetOrderSend;

import java.util.Date;


/**
 * 下注推送注单失败记录表查询对象
 *
 * @author diego
 * @time 2018-11-20 19:11:05
 */
//region your codes 1
public class LotteryBetOrderSendSo extends LotteryBetOrderSend {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 4217571213425466669L;
	//endregion your codes 3
	private Date queryStartDate;
	private Date queryEndDate;
	private Integer siteId;
	//region your codes 2

	public Date getQueryStartDate() {
		return queryStartDate;
	}

	public void setQueryStartDate(Date queryStartDate) {
		this.queryStartDate = queryStartDate;
	}

	public Date getQueryEndDate() {
		return queryEndDate;
	}

	public void setQueryEndDate(Date queryEndDate) {
		this.queryEndDate = queryEndDate;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

//endregion your codes 2
}