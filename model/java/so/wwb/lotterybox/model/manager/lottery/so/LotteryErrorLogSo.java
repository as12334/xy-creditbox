package so.wwb.lotterybox.model.manager.lottery.so;


import so.wwb.lotterybox.model.manager.lottery.po.LotteryErrorLog;

import java.util.Date;

/**
 * 彩票失败日志查询对象
 *
 * @author steady
 * @time 2018-5-24 14:52:46
 */
public class LotteryErrorLogSo extends LotteryErrorLog {
	private static final long serialVersionUID = -6636406466559942552L;

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

}