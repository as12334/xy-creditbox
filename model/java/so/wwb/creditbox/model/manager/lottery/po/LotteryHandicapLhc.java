package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 彩种盘口实体
 *
 * @author block
 * @time 2019-11-15 9:43:19
 */
//region your codes 1
public class LotteryHandicapLhc implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -2875189871625474563L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CODE = "code";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_OPEN_TIME = "openTime";
	public static final String PROP_CLOSE_TIME = "closeTime";
	public static final String PROP_LOTTERY_TIME = "lotteryTime";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 彩种代号 */
	private String code;
	/** 期数 */
	private String expect;
	/** 开盘时间 */
	private java.util.Date openTime;
	/** 封盘时间 */
	private java.util.Date closeTime;
	/** 开奖时间 */
	private java.util.Date lotteryTime;
	//endregion

	
	//region constuctors
	public LotteryHandicapLhc(){
	}

	public LotteryHandicapLhc(Integer id){
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
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public java.util.Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(java.util.Date value) {
		this.openTime = value;
	}
	public java.util.Date getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(java.util.Date value) {
		this.closeTime = value;
	}
	public java.util.Date getLotteryTime() {
		return this.lotteryTime;
	}

	public void setLotteryTime(java.util.Date value) {
		this.lotteryTime = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}