package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.common.Sortable;


/**
 * 赔率设置表实体
 *
 * @author block
 * @time 2019-10-21 22:52:07
 */
//region your codes 1
public class SiteLotteryOdd implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -3014599273405129704L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_HID = "hid";
	public static final String PROP_CODE = "code";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_ODD_A = "oddA";
	public static final String PROP_ODD_B = "oddB";
	public static final String PROP_ODD_C = "oddC";
	public static final String PROP_MIN_ODD = "minOdd";
	public static final String PROP_MAX_ODD = "maxOdd";
	public static final String PROP_UP_ODD = "upOdd";
	public static final String PROP_TOTAL_MONEY = "totalMoney";
	public static final String PROP_PROPORTION = "proportion";
	public static final String PROP_ACCOUNT_COUNT = "accountCount";
	public static final String PROP_ODD_CLOSE = "oddClose";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 站点ID */
	private Integer siteId;
	/** 用户唯一标示 */
	private String hid;
	/** 彩种代号 */
	private String code;
	/** 玩法代号 */
	private String betCode;
	/**  */
	private String playCode;
	/** 号码 */
	private String betNum;
	/** A盤赔率 */
	private Double oddA;
	/** B盤赔率 */
	private Double oddB;
	/** C盤赔率 */
	private Double oddC;
	/** 赔率下限 */
	private Double minOdd;
	/**  */
	private Double maxOdd;
	/** 下调赔率值 */
	private Double upOdd;
	/** 累计金额 */
	private Double totalMoney;
	/** 占货比例，1按下注额计算、0按占货比计算 */
	private Double proportion;
	/** 占额总次数 */
	private Integer accountCount;
	/** 是否開盤 */
	private Boolean oddClose;
	//endregion

	
	//region constuctors
	public SiteLotteryOdd(){
	}

	public SiteLotteryOdd(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
	public String getBetNum() {
		return this.betNum;
	}

	public void setBetNum(String value) {
		this.betNum = value;
	}
	public Double getOddA() {
		return this.oddA;
	}

	public void setOddA(Double value) {
		this.oddA = value;
	}
	public Double getOddB() {
		return this.oddB;
	}

	public void setOddB(Double value) {
		this.oddB = value;
	}
	public Double getOddC() {
		return this.oddC;
	}

	public void setOddC(Double value) {
		this.oddC = value;
	}
	public Double getMinOdd() {
		return this.minOdd;
	}

	public void setMinOdd(Double value) {
		this.minOdd = value;
	}
	public Double getMaxOdd() {
		return this.maxOdd;
	}

	public void setMaxOdd(Double value) {
		this.maxOdd = value;
	}
	public Double getUpOdd() {
		return this.upOdd;
	}

	public void setUpOdd(Double value) {
		this.upOdd = value;
	}
	public Double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(Double value) {
		this.totalMoney = value;
	}
	public Double getProportion() {
		return this.proportion;
	}

	public void setProportion(Double value) {
		this.proportion = value;
	}
	public Integer getAccountCount() {
		return this.accountCount;
	}

	public void setAccountCount(Integer value) {
		this.accountCount = value;
	}
	public Boolean getOddClose() {
		return this.oddClose;
	}

	public void setOddClose(Boolean value) {
		this.oddClose = value;
	}
	//endregion

	//region your codes 2
	/**
	 * 基数
	 */
	private Double baseNum;
	@Nonpersistent
	public Double getBaseNum() {
		return baseNum;
	}

	public void setBaseNum(Double baseNum) {
		this.baseNum = baseNum;
	}

	//endregion your codes 2

}