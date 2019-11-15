package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 开奖结果主表实体
 *
 * @author block
 * @time 2019-11-15 9:31:52
 */
//region your codes 1
public class LotteryResult implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3986045245730007559L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_OPEN_CODE = "openCode";
	public static final String PROP_OPEN_TIME = "openTime";
	public static final String PROP_CLOSE_TIME = "closeTime";
	public static final String PROP_OPENING_TIME = "openingTime";
	public static final String PROP_GATHER_TIME = "gatherTime";
	public static final String PROP_ORIGIN = "origin";
	public static final String PROP_RESULT_HASH = "resultHash";
	public static final String PROP_OPEN_CODE_MEMO = "openCodeMemo";
	//endregion
	
	
	//region properties
	/** ID主键 */
	private Integer id;
	/** 开奖期数 */
	private String expect;
	/** 彩种代号 */
	private String code;
	/** 彩种类型 */
	private String type;
	/** 开奖结果,多个号码逗号隔开 */
	private String openCode;
	/** 开奖时间  */
	private java.util.Date openTime;
	/** 封盘时间 */
	private java.util.Date closeTime;
	/** 开盘时间 */
	private java.util.Date openingTime;
	/** 采集时间 */
	private java.util.Date gatherTime;
	/** 区分手动自动采集 0-手动 1-自动 */
	private String origin;
	/** 开奖hash，避免同时开奖 */
	private String resultHash;
	/**  */
	private String openCodeMemo;
	//endregion

	
	//region constuctors
	public LotteryResult(){
	}

	public LotteryResult(Integer id){
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
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	public String getOpenCode() {
		return this.openCode;
	}

	public void setOpenCode(String value) {
		this.openCode = value;
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
	public java.util.Date getOpeningTime() {
		return this.openingTime;
	}

	public void setOpeningTime(java.util.Date value) {
		this.openingTime = value;
	}
	public java.util.Date getGatherTime() {
		return this.gatherTime;
	}

	public void setGatherTime(java.util.Date value) {
		this.gatherTime = value;
	}
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String value) {
		this.origin = value;
	}
	public String getResultHash() {
		return this.resultHash;
	}

	public void setResultHash(String value) {
		this.resultHash = value;
	}
	public String getOpenCodeMemo() {
		return this.openCodeMemo;
	}

	public void setOpenCodeMemo(String value) {
		this.openCodeMemo = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}