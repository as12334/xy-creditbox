package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;

/**
 * hash记录表对象
 *
 * @author marz
 * @time 2018-3-28 19:00:04
 */
//region your codes 1
public class LotteryHashRecord implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -6500099315094419348L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_OPERATION = "operation";
	public static final String PROP_CODE = "code";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_OPEN_CODE = "openCode";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_OPERATOR = "operator";
	public static final String PROP_HASH = "hash";
	//endregion

	//region properties
	/** 主键 */
	private Integer id;
	/** 操作类型LotteryOperationEnum */
	private String operation;
	/** 彩种代号 */
	private String code;
	/** 开奖期数 */
	private String expect;
	/** 开奖号码 */
	private String openCode;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 操作人 */
	private String operator;
	/** hash，避免同时存在 */
	private String hash;
	//endregion

	//region constuctors
	public LotteryHashRecord(){
	}

	public LotteryHashRecord(Integer id){
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

	@org.soul.model.common.Sortable
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	@org.soul.model.common.Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getOpenCode() {
		return this.openCode;
	}

	public void setOpenCode(String value) {
		this.openCode = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2
}