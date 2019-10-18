package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;

import java.util.Date;

//region your codes 1
public class LotteryRule implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3121595819339437211L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CODE = "code";
	public static final String PROP_MODEL = "model";
	public static final String PROP_USER_NAME = "username";
	public static final String PROP_AMOUNT_LIMIT = "amountLimit";
	public static final String PROP_COUNT_LIMIT = "countLimit";
	public static final String PROP_UPDATE_UNSERNAME = "updateUsername";
	public static final String PROP_UPDATE_TIME = "updateTime";
	//endregion

	//region properties
	/** 主键 */
	private Integer id;
	/** 彩种代号 */
	private String code;
	/** 开奖模式(随机(random),最佳匹配(best)) */
	private String model;
	/** 匹配账号 */
	private String username;
	/** 匹配最低金额 */
	private Double amountLimit;
	/** 匹配次数限制 */
	private Integer countLimit;
	/** 修改人 */
	private String updateUsername;
	/** 规则说明 */
	private Date updateTime;
	//endregion

	//region constuctors
	public LotteryRule(){
	}

	public LotteryRule(Integer id){
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

	@Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getAmountLimit() {
		return amountLimit;
	}

	public void setAmountLimit(Double amountLimit) {
		this.amountLimit = amountLimit;
	}

	public Integer getCountLimit() {
		return countLimit;
	}

	public void setCountLimit(Integer countLimit) {
		this.countLimit = countLimit;
	}

	public String getUpdateUsername() {
		return updateUsername;
	}

	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2
}