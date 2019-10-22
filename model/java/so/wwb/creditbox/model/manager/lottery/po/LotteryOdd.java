package so.wwb.creditbox.model.manager.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 赔率设置表实体
 *
 * @author block
 * @time 2019-10-21 23:16:42
 */
//region your codes 1
public class LotteryOdd implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -5057469007999482064L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CODE = "code";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_BASE_NUM = "baseNum";
	public static final String PROP_ODD_A = "oddA";
	public static final String PROP_ODD_B = "oddB";
	public static final String PROP_ODD_C = "oddC";
	public static final String PROP_MIN_ODD = "minOdd";
	public static final String PROP_MAX_ODD = "maxOdd";
	public static final String PROP_ODD_CLOSE = "oddClose";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 彩种代号 */
	private String code;
	/** 玩法代号 */
	private String betCode;
	/**  */
	private String playCode;
	/** 号码 */
	private String betNum;
	/** 基数 */
	private Double baseNum;
	/** A盤赔率 */
	private Double oddA;
	/** B盤赔率 */
	private Double oddB;
	/** C盤赔率 */
	private Double oddC;
	/** 赔率下限 */
	private Double minOdd;
	/** 赔率上限 */
	private Double maxOdd;
	/** 是否開盤 */
	private Boolean oddClose;
	//endregion

	
	//region constuctors
	public LotteryOdd(){
	}

	public LotteryOdd(Integer id){
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
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
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
	public Double getBaseNum() {
		return this.baseNum;
	}

	public void setBaseNum(Double value) {
		this.baseNum = value;
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
	public Boolean getOddClose() {
		return this.oddClose;
	}

	public void setOddClose(Boolean value) {
		this.oddClose = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}