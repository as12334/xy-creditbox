package so.wwb.lotterybox.model.manager.sys.po;


import org.soul.commons.bean.IEntity;


/**
 * 币种汇率表实体
 *
 * @author catban
 * @tableAuthor lorne
 * @time 2016-3-21 10:14:39
 */
//region your codes 1
public class CurrencyExchangeRate implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -2576084221308698226L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_IFROM_CURRENCY = "ifromCurrency";
	public static final String PROP_ITO_CURRENCY = "itoCurrency";
	public static final String PROP_RATE = "rate";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	//endregion


	//region properties
	/**  */
	private Integer id;
	/** 主币种 */
	private String ifromCurrency;
	/** 兑换币种 */
	private String itoCurrency;
	/** 汇率 */
	private Double rate;
	/** 备注 */
	private String remark;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 更新人id */
	private Integer updateUser;
	//endregion


	//region constuctors
	public CurrencyExchangeRate(){
	}

	public CurrencyExchangeRate(Integer id){
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
	public String getIfromCurrency() {
		return this.ifromCurrency;
	}

	public void setIfromCurrency(String value) {
		this.ifromCurrency = value;
	}
	public String getItoCurrency() {
		return this.itoCurrency;
	}

	public void setItoCurrency(String value) {
		this.itoCurrency = value;
	}
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double value) {
		this.rate = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer value) {
		this.updateUser = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}