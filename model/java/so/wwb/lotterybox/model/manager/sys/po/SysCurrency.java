package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;


/**
 * 币种表实体
 *
 * @author catban
 * @tableAuthor lorne
 * @time 2015-12-17 15:27:35
 */
//region your codes 1
public class SysCurrency implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -6621219381694120896L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CODE = "code";
	public static final String PROP_STATUS = "status";
	public static final String PROP_CENTER_ID = "centerId";
	public static final String PROP_CURRENCY_SIGN = "currencySign";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 币种字典 */
	private String code;
	/** 状态 */
	private Boolean status;
	/** 总控ID */
	private Integer centerId;
	/** 货币符号 */
	private String currencySign;
	//endregion

	
	//region constuctors
	public SysCurrency(){
	}

	public SysCurrency(Integer id){
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
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean value) {
		this.status = value;
	}
	public Integer getCenterId() {
		return this.centerId;
	}

	public void setCenterId(Integer value) {
		this.centerId = value;
	}
	public String getCurrencySign() {
		return this.currencySign;
	}

	public void setCurrencySign(String value) {
		this.currencySign = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}