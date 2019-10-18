package so.wwb.lotterybox.model.manager.lottery.po;

import java.io.Serializable;

public class NnResult implements Serializable {


	private static final long serialVersionUID = -7993339166632426769L;
	/** 号码 */
	private String nums;
	/** 玩法 */
	private String playName;
	/** 输赢 */
	private String winOrLose;

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getPlayName() {
		return playName;
	}

	public void setPlayName(String playName) {
		this.playName = playName;
	}

	public String getWinOrLose() {
		return winOrLose;
	}

	public void setWinOrLose(String winOrLose) {
		this.winOrLose = winOrLose;
	}

}