package so.wwb.creditbox.model.company.lottery.po;

//region your codes 1
public class BetOrderWin {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3817502759660544882L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_BETCODE = "betCode";
	public static final String PROP_BETNUM = "betNum";
	public static final String PROP_BETAMOUNT = "betAmount";
	public static final String PROP_CANWINMONEY = "canWinMoney";

	//endregion

	//region properties
	/**玩法 */
	private String betCode;
	/** 期数 */
	private String betNum;
	/** 投注金额 */
	private Double betAmount;
	/** 可中奖金额 */
	private Double canWinMoney;

	//endregion

	//region constuctors

	public String getBetCode() {
		return betCode;
	}

	public void setBetCode(String betCode) {
		this.betCode = betCode;
	}

	public String getBetNum() {
		return betNum;
	}

	public void setBetNum(String betNum) {
		this.betNum = betNum;
	}

	public Double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	public Double getCanWinMoney() {
		return canWinMoney;
	}

	public void setCanWinMoney(Double canWinMoney) {
		this.canWinMoney = canWinMoney;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2
}