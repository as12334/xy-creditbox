package so.wwb.lotterybox.model.manager.lottery.so;


import so.wwb.lotterybox.model.manager.lottery.po.LotteryType;

/**
 * 查询对象
 *
 * @author ronnie
 * @time 2017-10-23 19:07:34
 */
//region your codes 1
public class LotteryTypeSo extends LotteryType {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 2739168755614645201L;
	/**自主彩类型*/
	private String[] ownTypes;

	public String[] getOwnTypes() {
		return ownTypes;
	}

	public void setOwnTypes(String[] ownTypes) {
		this.ownTypes = ownTypes;
	}
//endregion your codes 3

	//region your codes 2

	//endregion your codes 2
}