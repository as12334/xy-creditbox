package so.wwb.creditbox.model.company.lottery.so;

import so.wwb.creditbox.model.company.lottery.po.LotteryBetOrder;

import java.util.Date;


/**
 * 投注记录表查询对象
 *
 * @author block
 * @time 2019-11-27 21:11:29
 */
//region your codes 1
public class LotteryBetOrderSo extends LotteryBetOrder {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -3501119535021513945L;
	//endregion your codes 3

	//region your codes 2
	private Date queryStartDate;
	private Date queryEndDate;

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

	//endregion your codes 2
}