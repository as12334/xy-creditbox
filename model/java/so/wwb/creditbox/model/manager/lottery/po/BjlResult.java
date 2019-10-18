package so.wwb.creditbox.model.manager.lottery.po;

import java.io.Serializable;

public class BjlResult implements Serializable {

	private static final long serialVersionUID = -2139029275919733402L;
	/** 号码 */
	private String nums;
	/** 玩法 */
	private String betNum;

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getBetNum() {
		return betNum;
	}

	public void setBetNum(String betNum) {
		this.betNum = betNum;
	}
}