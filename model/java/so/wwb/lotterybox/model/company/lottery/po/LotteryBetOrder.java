
package so.wwb.lotterybox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import so.wwb.lotterybox.model.enums.lottery.LotteryBonusModelEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryModelEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryOrderStatusEnum;
import so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import static so.wwb.lotterybox.model.enums.lottery.LotteryPlayEnum.NN_LEVEL;

/**
* 投注记录表实体
*
* @author Administrator
* @time 2017-4-18 9:29:30
*/
//region your codes 1
public class LotteryBetOrder implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 2089931752601378246L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_BET_TIME = "betTime";
	public static final String PROP_CODE = "code";
	public static final String PROP_LOTTERY_NAME = "lotteryName";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_ODD = "odd";
	public static final String PROP_BET_AMOUNT = "betAmount";
	public static final String PROP_PAYOUT = "payout";
	public static final String PROP_PAYOUT_TIME = "payoutTime";
	public static final String PROP_STATUS = "status";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_MEMO = "memo";
	public static final String PROP_USER_ID = "userId";
	public static final String PROP_EFFECTIVE_TRADE_AMOUNT = "effectiveTradeAmount";
	public static final String PROP_ODD2 = "odd2";
	public static final String PROP_ODD3 = "odd3";
	public static final String PROP_BONUS_MODEL = "bonusModel";
	public static final String PROP_PLAY_MODEL = "playModel";
	public static final String PROP_REBATE = "rebate";
	public static final String PROP_MULTIPLE = "multiple";
	public static final String PROP_BET_COUNT = "betCount";
	public static final String PROP_ODDS = "odds";
	public static final String PROP_BILL_NO = "billNo";
	public static final String PROP_OPEN_TIME = "openTime";
	public static final String PROP_OPEN_CODE = "openCode";
	public static final String PROP_PARENT_AGENTER_ID = "parentAgenterId";
	public static final String PROP_PARENT_AGENTER_NAME = "parentAgenterName";
	public static final String PROP_FREEZ_AMOUNT = "freezAmount";
	//endregion


	//region properties
	/** 主键 */
	private Integer id;
	/** 期数 */
	private String expect;
	/** 玩家账号 */
	private String username;
	/** 投注时间 */
	private Date betTime;
	/** 投注彩种 */
	private String code;
	/** 投注彩种名称 */
	private String lotteryName;
	/** 彩种玩法 */
	private String playCode;
	/** 投注玩法 */
	private String betCode;
	/** 投注号码,多个号码逗号隔开 */
	private String betNum;
	/** 赔率 */
	private Double odd;
	/** 投注金额 */
	private Double betAmount;
	/** 派彩金额 */
	private Double payout;
	/** 派彩时间 */
	private Date payoutTime;
	/** 结算状态(待结算，已结算，撤单) */
	private String status;
	/** 终端标示 */
	private String terminal;
	/** 投注内容描述 */
	private String memo;
	/** 玩家ID */
	private Integer userId;
	/** 有效交易量 */
	private Double effectiveTradeAmount;
	/** 赔率2 */
	private Double odd2;
	/** 赔率3 */
	private Double odd3;
	/** 奖金模式：1:元,10:角,100:分 */
	private String bonusModel = LotteryBonusModelEnum.YUAN.getCode();
	/** 玩法模式 LotteryModelEnum */
	private String playModel = LotteryModelEnum.TRADITION.getCode();
	/** 返点比例 */
	private Double rebate = 0D;
	/** 倍数 */
	private Double multiple = 1.0d;
	/** 注数 */
	private Integer betCount = 1;
	/** 赔率/奖金数组 */
	private Double[] odds;
	/** 交易号 */
	private String billNo;
	/** 开奖时间 */
	private Date openTime;
	/** 开奖号码 */
	private String openCode;
	/** 上级代理id */
	private Integer parentAgenterId;
	/** 上级代理账号 */
	private String parentAgenterName;
	/** 投注冻结金额 */
	private Double freezAmount;

	private Double profit;

	/** 封盘 */
	private boolean closeExpect;



	//endregion


	//region constuctors
	public LotteryBetOrder(){
	}

	public LotteryBetOrder(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	@org.soul.model.common.Sortable
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer value) {
		this.id = value;
	}
	@org.soul.model.common.Sortable
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	@org.soul.model.common.Sortable
	public Date getBetTime() {
		return this.betTime;
	}

	public void setBetTime(Date value) {
		this.betTime = value;
	}

	@org.soul.model.common.Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getPlayCode() {
		return this.playCode;
	}

	public void setPlayCode(String value) {
		this.playCode = value;
	}
	public String getBetCode() {
		return this.betCode;
	}

	public void setBetCode(String value) {
		this.betCode = value;
	}
	public String getBetNum() {
		return this.betNum;
	}

	public void setBetNum(String value) {
		this.betNum = value;
	}
	public Double getOdd() {
		return this.odd;
	}

	public void setOdd(Double value) {
		this.odd = value;
	}
	@org.soul.model.common.Sortable
	public Double getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(Double value) {
		this.betAmount = value;
	}
	@org.soul.model.common.Sortable
	public Double getPayout() {
		return this.payout;
	}

	public void setPayout(Double value) {
		this.payout = value;
	}
	@org.soul.model.common.Sortable
	public Date getPayoutTime() {
		return this.payoutTime;
	}

	public void setPayoutTime(Date value) {
		this.payoutTime = value;
	}
	@org.soul.model.common.Sortable
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	@org.soul.model.common.Sortable
	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String value) {
		this.terminal = value;
	}
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String value) {
		this.memo = value;
	}
	@org.soul.model.common.Sortable
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}
	public Double getEffectiveTradeAmount() {
		return this.effectiveTradeAmount;
	}

	public void setEffectiveTradeAmount(Double value) {
		this.effectiveTradeAmount = value;
	}

	public Double getOdd2() {
		return odd2;
	}

	public void setOdd2(Double odd2) {
		this.odd2 = odd2;
	}

	public Double getOdd3() {
		return odd3;
	}

	public void setOdd3(Double odd3) {
		this.odd3 = odd3;
	}

	//endregion

	//region your codes 2
	/**游戏种类国际化*/
	private String codeMemo;
	/**玩法国际化*/
	private String betCodeMemo;
	/**玩法国际化*/
	private String playCodeMemo;
	/**彩种类型*/
	private String type;



	@Nonpersistent
	public String getLotteryName() {
		return lotteryName;
	}

	public void setLotteryName(String lotteryName) {
		this.lotteryName = lotteryName;
	}

	@Nonpersistent
	public String getPlayCodeMemo() {
		return playCodeMemo;
	}

	public void setPlayCodeMemo(String playCodeMemo) {
		this.playCodeMemo = playCodeMemo;
	}

	@Nonpersistent
	public String getCodeMemo() {
		return codeMemo;
	}

	public void setCodeMemo(String codeMemo) {
		this.codeMemo = codeMemo;
	}

	@Nonpersistent
	public String getBetCodeMemo() {
		return betCodeMemo;
	}

	public void setBetCodeMemo(String betCodeMemo) {
		this.betCodeMemo = betCodeMemo;
	}

	@Nonpersistent
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBonusModel() {
		return bonusModel;
	}

	public void setBonusModel(String bonusModel) {
		this.bonusModel = bonusModel;
	}

	public String getPlayModel() {
		return playModel;
	}

	public void setPlayModel(String playModel) {
		this.playModel = playModel;
	}

	public Double getRebate() {
		return rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	public Double getMultiple() {
		return multiple;
	}

	public void setMultiple(Double multiple) {
		this.multiple = multiple;
	}

	public Integer getBetCount() {
		return betCount;
	}

	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}

	@Nonpersistent
	public Double getRebateAmount(){
		DecimalFormat bonus = new DecimalFormat("#0.000");
		if(this.rebate == null){
			this.rebate = 0D;
		}
		if(this.betAmount != null){
			BigDecimal bd = new BigDecimal(String.valueOf(this.betAmount * this.rebate));

			return new Double(bonus.format(bd.setScale(3, BigDecimal.ROUND_DOWN)));
		}
		return 0D;
	}

	@Nonpersistent
	public Double getRealBetAmount(){
		if(this.rebate == null){
			this.rebate = 0D;
		}
		return this.betAmount != null?this.betAmount - this.getRebateAmount():0D;
	}
	@Nonpersistent
	@org.soul.model.common.Sortable
	public Double getProfit(){
		double money = 0l;
		DecimalFormat bonus = new DecimalFormat("#0.000");
		if(this.rebate == null){
			this.rebate = 0D;
		}
		if(this.payout == null){
			this.payout = 0D;
		}
		BigDecimal b1 = new BigDecimal(String.valueOf(this.payout));
		BigDecimal b2 = new BigDecimal(String.valueOf(this.getRebateAmount()));

		BigDecimal b3 = new BigDecimal(String.valueOf(this.betAmount));

		BigDecimal bd = b1.add(b2).subtract(b3);
		if(LotteryOrderStatusEnum.REVOKE_SYS.getCode().equals(this.status) || LotteryOrderStatusEnum.REVOKE_SELF.getCode().equals(this.status)|| LotteryOrderStatusEnum.REVOCATION.getCode().equals(this.status)) {
			return money;
		} else {
			return new Double(bonus.format(bd.setScale(3, BigDecimal.ROUND_DOWN)));
		}
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	@Nonpersistent
	public String getWinMoney(){
		DecimalFormat bonus = new DecimalFormat("#0.000");
		if(this.odd == null){
			this.odd = 0D;
		}
		if (LotteryModelEnum.TRADITION.getCode().equals(this.playModel)) {
			BigDecimal b1 = new BigDecimal(String.valueOf(this.odd));

			BigDecimal b3 = new BigDecimal(String.valueOf(this.betAmount));
			BigDecimal bd;
			// 牛牛平倍单独处理
			if (NN_LEVEL.NN_LEVEL.getCode().equals(this.playCode)) {
				 bd = b3.multiply(b1);
			} else {
				 bd = b3.multiply(b1).subtract(b3);
			}

			Double winMoney = new Double(bonus.format(bd.setScale(3, BigDecimal.ROUND_DOWN)));
			if (this.odd2 == null) {
				return winMoney.toString();
			} else {
				BigDecimal b2;
				if (this.odd3 !=null) {
					b2= new BigDecimal(String.valueOf(this.odd3));
				} else {
					b2= new BigDecimal(String.valueOf(this.odd2));
				}
				BigDecimal bb3 = new BigDecimal(String.valueOf(this.betAmount));

				BigDecimal bbd = bb3.multiply(b2).subtract(bb3);
				Double winMoney2 = new Double(bonus.format(bbd.setScale(3, BigDecimal.ROUND_DOWN)));
				if (winMoney < winMoney2) {
					return winMoney.toString() + " —— " + winMoney2.toString();
				} else {
					return winMoney2.toString() + " —— " + winMoney.toString();
				}
			}
		} else {
			BigDecimal b1 = new BigDecimal(String.valueOf(this.odd));
			BigDecimal b2 = new BigDecimal(String.valueOf(this.bonusModel));
			BigDecimal b3 = new BigDecimal(String.valueOf(this.multiple));
			BigDecimal b4 = new BigDecimal(String.valueOf(this.betAmount));
			BigDecimal b5 = new BigDecimal(String.valueOf(this.rebate));
			int sum = 1;
			if (LotteryPlayEnum.SSC_YIXING.getCode().equals(this.playCode)) {
				sum = sum -1;
				String[] ss = this.betNum.split("\\|");
				for (int i=0; i<ss.length; i++) {
					if (ss[i].length()>0) {
						sum = sum +1;
					}
				}
			}
			BigDecimal sums = new BigDecimal(sum);
			BigDecimal ddd = b4.multiply(b5).divide(b2).multiply(b3);
			BigDecimal bd = b1.multiply(b3).multiply(sums).divide(b2).subtract(b4).add(ddd);
			Double winMoney = new Double(bonus.format(bd.setScale(3, BigDecimal.ROUND_DOWN)));
			if (this.odd2 == null) {
				return winMoney.toString();
			} else {
				BigDecimal bb1;
				if (this.odd3 !=null) {
					bb1= new BigDecimal(String.valueOf(this.odd3));
				} else {
					bb1= new BigDecimal(String.valueOf(this.odd2));
				}
				BigDecimal bb2 = new BigDecimal(String.valueOf(this.bonusModel));
				BigDecimal bb3 = new BigDecimal(String.valueOf(this.multiple));
				BigDecimal bb4 = new BigDecimal(String.valueOf(this.betAmount));
				BigDecimal bb5 = new BigDecimal(String.valueOf(this.rebate));

				BigDecimal dddd = bb4.multiply(bb5).divide(bb3).multiply(bb2);
				BigDecimal bbd = bb1.multiply(bb3).divide(bb2).subtract(bb4).add(dddd);
				Double winMoney2 = new Double(bonus.format(bbd.setScale(3, BigDecimal.ROUND_DOWN)));
				if (winMoney <winMoney2) {
					return winMoney.toString() + " —— " + winMoney2.toString();
				} else {
					return winMoney2.toString() + " —— " + winMoney.toString();
				}

			}
		}

	}
	public Double[] getOdds() {
		return odds;
	}

	public void setOdds(Double[] odds) {
		this.odds = odds;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public String getOpenCode() {
		return openCode;
	}

	public void setOpenCode(String openCode) {
		this.openCode = openCode;
	}

	public Integer getParentAgenterId() {
		return parentAgenterId;
	}

	public void setParentAgenterId(Integer parentAgenterId) {
		this.parentAgenterId = parentAgenterId;
	}

	public String getParentAgenterName() {
		return parentAgenterName;
	}

	public void setParentAgenterName(String parentAgenterName) {
		this.parentAgenterName = parentAgenterName;
	}

	public Double getFreezAmount() {
		return freezAmount;
	}

	public void setFreezAmount(Double freezAmount) {
		this.freezAmount = freezAmount;
	}
	@Nonpersistent
	public boolean isCloseExpect() {
		return closeExpect;
	}

	public void setCloseExpect(boolean closeExpect) {
		this.closeExpect = closeExpect;
	}
	//endregion your codes 2　
}