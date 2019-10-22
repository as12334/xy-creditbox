package so.wwb.creditbox.model.manager.lottery.so;

import so.wwb.creditbox.model.manager.lottery.po.SiteLotteryOdd;

import java.util.List;


/**
 * 赔率设置表查询对象
 *
 * @author block
 * @time 2019-10-21 22:52:07
 */
//region your codes 1
public class SiteLotteryOddSo extends SiteLotteryOdd {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4126546655092639764L;
	//endregion your codes 3

	//region your codes 2
	private List<Integer> ids;

	private String[] betCodes;

	public String[] getBetCodes() {
		return betCodes;
	}

	public void setBetCodes(String[] betCodes) {
		this.betCodes = betCodes;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//endregion your codes 2
}