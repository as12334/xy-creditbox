package so.wwb.creditbox.model.company.lottery.so;


import so.wwb.creditbox.model.company.lottery.po.LotteryResultLog;

/**
 * 彩票杀率设置查询对象
 *
 * @author rambo
 * @time 2017-9-9 19:13:23
 */
//region your codes 1
public class LotteryResultLogSo extends LotteryResultLog {

//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -813824638846509018L;
	//endregion your codes 3
	/** 站点ID */
	private Integer siteId;

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	//region your codes 2

	//endregion your codes 2
}