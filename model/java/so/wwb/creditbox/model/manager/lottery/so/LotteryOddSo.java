package so.wwb.creditbox.model.manager.lottery.so;

import so.wwb.creditbox.model.manager.lottery.po.LotteryOdd;

import java.util.List;


/**
 * 赔率设置表查询对象
 *
 * @author block
 * @time 2019-10-21 21:46:34
 */
//region your codes 1
public class LotteryOddSo extends LotteryOdd {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -2036481703995505518L;
	//endregion your codes 3

	//region your codes 2
	private List<Integer> ids;

	private String[] betcodes;

	public String[] getBetcodes() {
		return betcodes;
	}

	public void setBetcodes(String[] betcodes) {
		this.betcodes = betcodes;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//endregion your codes 2
}