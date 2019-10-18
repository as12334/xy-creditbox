package so.wwb.creditbox.model.company.lottery.so;


import so.wwb.creditbox.model.company.lottery.po.LotteryRule;

/**
 * 彩票杀率设置查询对象
 *
 * @author zain
 * @time 2017-8-22 19:13:23
 */
//region your codes 1
public class LotteryRuleSo extends LotteryRule {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -6884362567806387692L;
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