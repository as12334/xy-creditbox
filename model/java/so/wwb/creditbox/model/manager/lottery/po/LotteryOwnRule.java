package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 自主开号规则表实体
 *
 * @author block
 * @time 2019-11-15 15:39:41
 */
//region your codes 1
public class LotteryOwnRule implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -590784077155323129L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_CODE = "code";
	public static final String PROP_STATUS = "status";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_OPEN_NUM = "openNum";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_AMOUNT_LIMIT = "amountLimit";
	public static final String PROP_COUNT_LIMIT = "countLimit";
	public static final String PROP_UPDATE_CONTENT = "updateContent";
	public static final String PROP_UPDATE_USERNAME = "updateUsername";
	public static final String PROP_UPDATE_TIME = "updateTime";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 彩种 */
	private String code;
	/** 是否启用 */
	private String status;
	/** 期数 */
	private String expect;
	/** 开奖号码 */
	private String openNum;
	/** 站点id */
	private Integer siteId;
	/** 匹配最低金额 */
	private Double amountLimit;
	/** 匹配次数限制 */
	private Integer countLimit;
	/** 更新内容 */
	private String updateContent;
	/** 修改人 */
	private String updateUsername;
	/** 修改时间 */
	private java.util.Date updateTime;
	//endregion

	
	//region constuctors
	public LotteryOwnRule(){
	}

	public LotteryOwnRule(Integer id){
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
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getOpenNum() {
		return this.openNum;
	}

	public void setOpenNum(String value) {
		this.openNum = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public Double getAmountLimit() {
		return this.amountLimit;
	}

	public void setAmountLimit(Double value) {
		this.amountLimit = value;
	}
	public Integer getCountLimit() {
		return this.countLimit;
	}

	public void setCountLimit(Integer value) {
		this.countLimit = value;
	}
	public String getUpdateContent() {
		return this.updateContent;
	}

	public void setUpdateContent(String value) {
		this.updateContent = value;
	}
	public String getUpdateUsername() {
		return this.updateUsername;
	}

	public void setUpdateUsername(String value) {
		this.updateUsername = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}