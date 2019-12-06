package so.wwb.creditbox.model.company.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 投注记录表实体
 *
 * @author block
 * @time 2019-12-6 21:50:49
 */
//region your codes 1
public class LotteryBetOrder implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4132712377806132082L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_USER_ID = "userId";
	public static final String PROP_HID = "hid";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_CODE = "code";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_HANDICAP = "handicap";
	public static final String PROP_BET_TIME = "betTime";
	public static final String PROP_BET_NAME = "betName";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_BET_SORT = "betSort";
	public static final String PROP_CODD1 = "codd1";
	public static final String PROP_CODD2 = "codd2";
	public static final String PROP_BODD1 = "bodd1";
	public static final String PROP_BODD2 = "bodd2";
	public static final String PROP_BET_AMOUNT = "betAmount";
	public static final String PROP_CPAYOUT = "cpayout";
	public static final String PROP_BPAYOUT = "bpayout";
	public static final String PROP_PAYOUT_TIME = "payoutTime";
	public static final String PROP_STATUS = "status";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_MEMO = "memo";
	public static final String PROP_REBATE8 = "rebate8";
	public static final String PROP_REBATE7 = "rebate7";
	public static final String PROP_REBATE6 = "rebate6";
	public static final String PROP_REBATE5 = "rebate5";
	public static final String PROP_REBATE4 = "rebate4";
	public static final String PROP_REBATE3 = "rebate3";
	public static final String PROP_REBATE2 = "rebate2";
	public static final String PROP_OCCUPY7 = "occupy7";
	public static final String PROP_OCCUPY6 = "occupy6";
	public static final String PROP_OCCUPY5 = "occupy5";
	public static final String PROP_OCCUPY4 = "occupy4";
	public static final String PROP_OCCUPY3 = "occupy3";
	public static final String PROP_OCCUPY2 = "occupy2";
	public static final String PROP_AGENT_ID = "agentId";
	public static final String PROP_DISTRIBUTOR_ID = "distributorId";
	public static final String PROP_SHAREHOLDER_ID = "shareholderId";
	public static final String PROP_BRANCH_ID = "branchId";
	public static final String PROP_COMPANY_ID = "companyId";
	public static final String PROP_OWNER_USER_TYPE = "ownerUserType";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 主键 */
	private Integer userId;
	/** 主键 */
	private String hid;
	/** 玩家账号 */
	private String username;
	/** 投注彩种 */
	private String code;
	/** 期数 */
	private String expect;
	/** 盘口 1 A盘、2 B盘 3 C盘 */
	private String handicap;
	/** 投注时间 */
	private java.util.Date betTime;
	/** 彩种玩法 */
	private String betName;
	/**  */
	private String betCode;
	/** 投注小类代码 */
	private String playCode;
	/** 投注小类 */
	private String betNum;
	/** 投注号码 */
	private String betSort;
	/** (公司)赔率 */
	private Double codd1;
	/** (公司)连码赔率中调用第二个赔率 */
	private Double codd2;
	/** (分公司)赔率 */
	private Double bodd1;
	/** (分公司)连码赔率中调用第二个赔率 */
	private Double bodd2;
	/** 投注金额 */
	private Double betAmount;
	/** (公司)派彩 */
	private Double cpayout;
	/** (分公司)派彩 */
	private Double bpayout;
	/**  */
	private java.util.Date payoutTime;
	/** 结算状态(待结算，已结算，已撤单，已撤销)  */
	private String status;
	/** 终端标示 */
	private String terminal;
	/** 投注内容描述 */
	private String memo;
	/** 代理退会员 */
	private Double rebate8;
	/** 总代理退代理 */
	private Double rebate7;
	/** 股东退总代理 */
	private Double rebate6;
	/** 分公司退股东 */
	private Double rebate5;
	/** 总监退分公司 */
	private Double rebate4;
	/** 总公司退水 */
	private Double rebate3;
	/**  */
	private Double rebate2;
	/** 代理占成 */
	private Double occupy7;
	/** 总代理占成 */
	private Double occupy6;
	/** 股东占成 */
	private Double occupy5;
	/** 分公司占成 */
	private Double occupy4;
	/** 总监占成 */
	private Double occupy3;
	/** 总公司占成 */
	private Double occupy2;
	/** 代理ID */
	private Integer agentId;
	/** 总代理ID */
	private Integer distributorId;
	/** 股东ID */
	private Integer shareholderId;
	/** 分公司ID */
	private Integer branchId;
	/** 公司ID */
	private Integer companyId;
	/** 上級用戶类型 */
	private String ownerUserType;
	//endregion

	
	//region constuctors
	public LotteryBetOrder(){
	}

	public LotteryBetOrder(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}
	public String getHid() {
		return this.hid;
	}

	public void setHid(String value) {
		this.hid = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getHandicap() {
		return this.handicap;
	}

	public void setHandicap(String value) {
		this.handicap = value;
	}
	public java.util.Date getBetTime() {
		return this.betTime;
	}

	public void setBetTime(java.util.Date value) {
		this.betTime = value;
	}
	public String getBetName() {
		return this.betName;
	}

	public void setBetName(String value) {
		this.betName = value;
	}
	public String getBetCode() {
		return this.betCode;
	}

	public void setBetCode(String value) {
		this.betCode = value;
	}
	public String getPlayCode() {
		return this.playCode;
	}

	public void setPlayCode(String value) {
		this.playCode = value;
	}
	public String getBetNum() {
		return this.betNum;
	}

	public void setBetNum(String value) {
		this.betNum = value;
	}
	public String getBetSort() {
		return this.betSort;
	}

	public void setBetSort(String value) {
		this.betSort = value;
	}
	public Double getCodd1() {
		return this.codd1;
	}

	public void setCodd1(Double value) {
		this.codd1 = value;
	}
	public Double getCodd2() {
		return this.codd2;
	}

	public void setCodd2(Double value) {
		this.codd2 = value;
	}
	public Double getBodd1() {
		return this.bodd1;
	}

	public void setBodd1(Double value) {
		this.bodd1 = value;
	}
	public Double getBodd2() {
		return this.bodd2;
	}

	public void setBodd2(Double value) {
		this.bodd2 = value;
	}
	public Double getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(Double value) {
		this.betAmount = value;
	}
	public Double getCpayout() {
		return this.cpayout;
	}

	public void setCpayout(Double value) {
		this.cpayout = value;
	}
	public Double getBpayout() {
		return this.bpayout;
	}

	public void setBpayout(Double value) {
		this.bpayout = value;
	}
	public java.util.Date getPayoutTime() {
		return this.payoutTime;
	}

	public void setPayoutTime(java.util.Date value) {
		this.payoutTime = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
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
	public Double getRebate8() {
		return this.rebate8;
	}

	public void setRebate8(Double value) {
		this.rebate8 = value;
	}
	public Double getRebate7() {
		return this.rebate7;
	}

	public void setRebate7(Double value) {
		this.rebate7 = value;
	}
	public Double getRebate6() {
		return this.rebate6;
	}

	public void setRebate6(Double value) {
		this.rebate6 = value;
	}
	public Double getRebate5() {
		return this.rebate5;
	}

	public void setRebate5(Double value) {
		this.rebate5 = value;
	}
	public Double getRebate4() {
		return this.rebate4;
	}

	public void setRebate4(Double value) {
		this.rebate4 = value;
	}
	public Double getRebate3() {
		return this.rebate3;
	}

	public void setRebate3(Double value) {
		this.rebate3 = value;
	}
	public Double getRebate2() {
		return this.rebate2;
	}

	public void setRebate2(Double value) {
		this.rebate2 = value;
	}
	public Double getOccupy7() {
		return this.occupy7;
	}

	public void setOccupy7(Double value) {
		this.occupy7 = value;
	}
	public Double getOccupy6() {
		return this.occupy6;
	}

	public void setOccupy6(Double value) {
		this.occupy6 = value;
	}
	public Double getOccupy5() {
		return this.occupy5;
	}

	public void setOccupy5(Double value) {
		this.occupy5 = value;
	}
	public Double getOccupy4() {
		return this.occupy4;
	}

	public void setOccupy4(Double value) {
		this.occupy4 = value;
	}
	public Double getOccupy3() {
		return this.occupy3;
	}

	public void setOccupy3(Double value) {
		this.occupy3 = value;
	}
	public Double getOccupy2() {
		return this.occupy2;
	}

	public void setOccupy2(Double value) {
		this.occupy2 = value;
	}
	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer value) {
		this.agentId = value;
	}
	public Integer getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(Integer value) {
		this.distributorId = value;
	}
	public Integer getShareholderId() {
		return this.shareholderId;
	}

	public void setShareholderId(Integer value) {
		this.shareholderId = value;
	}
	public Integer getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Integer value) {
		this.branchId = value;
	}
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer value) {
		this.companyId = value;
	}
	public String getOwnerUserType() {
		return this.ownerUserType;
	}

	public void setOwnerUserType(String value) {
		this.ownerUserType = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}