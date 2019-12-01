package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.lang.string.HidTool;
import org.soul.commons.support.Nonpersistent;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-1 21:26:58
 */
//region your codes 1
public class SiteLotteryRebates implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3098885399576700267L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_HID = "hid";
	public static final String PROP_CODE = "code";
	public static final String PROP_BET_NAME = "betName";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_SORT = "sort";
	public static final String PROP_SORT_TYPE = "sortType";
	public static final String PROP_BET_SORT = "betSort";
	public static final String PROP_PAGE_TYPE = "pageType";
	public static final String PROP_REBATE_A = "rebateA";
	public static final String PROP_REBATE_B = "rebateB";
	public static final String PROP_REBATE_C = "rebateC";
	public static final String PROP_MIN_BET = "minBet";
	public static final String PROP_MAX_BET = "maxBet";
	public static final String PROP_MAX_EXPECT_BET = "maxExpectBet";
	public static final String PROP_POST_MONEY = "postMoney";
	public static final String PROP_POST_MONEY_CLOSE = "postMoneyClose";
	public static final String PROP_ODD_CLOSE = "oddClose";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private Integer siteId;
	/**  */
	private String hid;
	/** 彩种代号 */
	private String code;
	/**  */
	private String betName;
	/** 玩法代号 */
	private String betCode;
	/**  */
	private String playCode;
	/** 号码 */
	private String betNum;
	/**  */
	private Integer sort;
	/** 玩法小类 LotterySortTypeEnum */
	private String sortType;
	/** 玩法唯一标示 */
	private String betSort;
	/**  */
	private String pageType;
	/** A盤水位 */
	private Double rebateA;
	/** B盤水位 */
	private Double rebateB;
	/** C盤水位 */
	private Double rebateC;
	/** 最低下注额 */
	private Integer minBet;
	/** 单注限额 */
	private Integer maxBet;
	/** 单期限额 */
	private Integer maxExpectBet;
	/** 起补金额 */
	private Double postMoney;
	/** 是否开启，1开启、0关闭 */
	private String postMoneyClose;
	/**  */
	private Boolean oddClose;
	//endregion

	
	//region constuctors
	public SiteLotteryRebates(){
	}

	public SiteLotteryRebates(Integer id){
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
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getHid() {
		return this.hid;
	}

	public void setHid(String value) {
		this.hid = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
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
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}
	public String getSortType() {
		return this.sortType;
	}

	public void setSortType(String value) {
		this.sortType = value;
	}
	public String getBetSort() {
		return this.betSort;
	}

	public void setBetSort(String value) {
		this.betSort = value;
	}
	public String getPageType() {
		return this.pageType;
	}

	public void setPageType(String value) {
		this.pageType = value;
	}
	public Double getRebateA() {
		return this.rebateA;
	}

	public void setRebateA(Double value) {
		this.rebateA = value;
	}
	public Double getRebateB() {
		return this.rebateB;
	}

	public void setRebateB(Double value) {
		this.rebateB = value;
	}
	public Double getRebateC() {
		return this.rebateC;
	}

	public void setRebateC(Double value) {
		this.rebateC = value;
	}
	public Integer getMinBet() {
		return this.minBet;
	}

	public void setMinBet(Integer value) {
		this.minBet = value;
	}
	public Integer getMaxBet() {
		return this.maxBet;
	}

	public void setMaxBet(Integer value) {
		this.maxBet = value;
	}
	public Integer getMaxExpectBet() {
		return this.maxExpectBet;
	}

	public void setMaxExpectBet(Integer value) {
		this.maxExpectBet = value;
	}
	public Double getPostMoney() {
		return this.postMoney;
	}

	public void setPostMoney(Double value) {
		this.postMoney = value;
	}
	public String getPostMoneyClose() {
		return this.postMoneyClose;
	}

	public void setPostMoneyClose(String value) {
		this.postMoneyClose = value;
	}
	public Boolean getOddClose() {
		return this.oddClose;
	}

	public void setOddClose(Boolean value) {
		this.oddClose = value;
	}
	//endregion

	//region your codes 2

	private String parentHid;

	private SiteLotteryRebates parendRebate;

	@Nonpersistent
	public String getParentHid() {
		return hid.substring(0, hid.length() - HidTool.FLAG);
	}

	public void setParentHid(String parentHid) {
		this.parentHid = parentHid;
	}

	public SiteLotteryRebates getParendRebate() {
		return parendRebate;
	}

	public void setParendRebate(SiteLotteryRebates parendRebate) {
		this.parendRebate = parendRebate;
	}

	//endregion your codes 2

}