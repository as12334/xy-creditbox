package so.wwb.lotterybox.model.manager.lottery.so;

import so.wwb.lotterybox.model.manager.lottery.po.Lottery;

import java.util.List;

/**
 * 彩种表查询对象
 *
 * @author shook
 * @time 2017-4-7 19:50:21
 */
//region your codes 1
public class LotterySo extends Lottery {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -3810448174211628197L;
	//endregion your codes 3

	//region your codes 2
	private List<String> noIncludeCodeList;
	/**根据彩种代码查询自主彩*/
	private List<String> ownCodes;

	public List<String> getNoIncludeCodeList() {
		return noIncludeCodeList;
	}

	public void setNoIncludeCodeList(List<String> noIncludeCodeList) {
		this.noIncludeCodeList = noIncludeCodeList;
	}

	public List<String> getOwnCodes() {
		return ownCodes;
	}

	public void setOwnCodes(List<String> ownCodes) {
		this.ownCodes = ownCodes;
	}

	//endregion your codes 2
}