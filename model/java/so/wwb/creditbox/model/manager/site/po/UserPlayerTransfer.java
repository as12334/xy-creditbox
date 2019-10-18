package so.wwb.creditbox.model.manager.site.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;


/**
 * 导入玩家表 by River实体
 *
 * @author Administrator
 * @time 2017-3-14 8:40:51
 */
//region your codes 1
public class UserPlayerTransfer implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -3784822382423425603L;
	public static final String PROP_EXCELROW = "excelRow";
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_TOPAGENT = "topagent";
	public static final String PROP_AGENT = "agent";
	public static final String PROP_PLAYER_ACCOUNT = "playerAccount";
	public static final String PROP_ACCOUNT_BALANCE = "accountBalance";
	public static final String PROP_REAL_NAME = "realName";
	public static final String PROP_MOBILE_PHONE = "mobilePhone";
	public static final String PROP_EMAIL = "email";
	public static final String PROP_BANKCARD_NUMBER = "bankcardNumber";
	public static final String PROP_BANK_DEPOSIT = "bankDeposit";
	public static final String PROP_IS_ACTIVE = "isActive";
	public static final String PROP_INSERT_TIME = "insertTime";
	public static final String PROP_IMPORT_ID = "importId";
	public static final String PROP_BANK_CODE = "bankCode";
	public static final String PROP_USER_ID = "userId";
	public static final String PROP_PLAYER_RANK = "playerRank";
	public static final String PROP_PLAYER_RANK_ID = "playerRankId";
	public static final String PROP_IS_AGENT = "isAgent";
	public static final String PROP_WECHAT = "wechat";
	public static final String PROP_QQ = "qq";

	//endregion


	//region properties
	/** 主键 */
	private Integer id;
	/** 所属总代 */
	private String topagent;
	/** 所属代理 */
	private String agent;
	/** 玩家账号 */
	private String playerAccount;
	/** 账号余额 */
	private Double accountBalance;
	/** 真实姓名 */
	private String realName;
	/** 手机号码 */
	private String mobilePhone;
	/** 邮箱地址 */
	private String email;
	/** 收款银行卡号 */
	private String bankcardNumber;
	/** 开户行 */
	private String bankDeposit;
	/** 是否激活 0未激活1已激活 */
	private String isActive;
	/** 插入时间 */
	private java.util.Date insertTime;
	/** 导入记录ID */
	private Integer importId;
	/** 银行代码 */
	private String bankCode;
	/** 用户ID */
	private Integer userId;
	/** 玩家层级 */
	private String playerRank;
	/** 玩家层级ID */
	private Integer playerRankId;
	/** 是否代理*/
	private Boolean isAgent;
	/** 微信*/
	private String wechat;
	/** qq*/
	private String qq;

	public void setAgent(Boolean agent) {
		isAgent = agent;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	//endregion


	//region constuctors
	public UserPlayerTransfer(){
	}

	public UserPlayerTransfer(Integer id){
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
	@org.soul.model.common.Sortable
	public String getTopagent() {
		return this.topagent;
	}

	public void setTopagent(String value) {
		this.topagent = value;
	}
	@org.soul.model.common.Sortable
	public String getAgent() {
		return this.agent;
	}

	public void setAgent(String value) {
		this.agent = value;
	}
	@org.soul.model.common.Sortable
	public String getPlayerAccount() {
		return this.playerAccount;
	}

	public void setPlayerAccount(String value) {
		this.playerAccount = value;
	}
	@org.soul.model.common.Sortable
	public Double getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(Double value) {
		this.accountBalance = value;
	}
	@org.soul.model.common.Sortable
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String value) {
		this.realName = value;
	}
	@org.soul.model.common.Sortable
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String value) {
		this.mobilePhone = value;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String value) {
		this.email = value;
	}
	public String getBankcardNumber() {
		return this.bankcardNumber;
	}

	public void setBankcardNumber(String value) {
		this.bankcardNumber = value;
	}
	public String getBankDeposit() {
		return this.bankDeposit;
	}

	public void setBankDeposit(String value) {
		this.bankDeposit = value;
	}
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String value) {
		this.isActive = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(java.util.Date value) {
		this.insertTime = value;
	}
	public Integer getImportId() {
		return this.importId;
	}

	public void setImportId(Integer value) {
		this.importId = value;
	}
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String value) {
		this.bankCode = value;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}
	public String getPlayerRank() {
		return this.playerRank;
	}

	public void setPlayerRank(String value) {
		this.playerRank = value;
	}
	public Integer getPlayerRankId() {
		return this.playerRankId;
	}

	public void setPlayerRankId(Integer value) {
		this.playerRankId = value;
	}
	//endregion

	//region your codes 2
	private int excelRow;
	@Nonpersistent
	public int getExcelRow() {
		return excelRow;
	}

	public void setExcelRow(int excelRow) {
		this.excelRow = excelRow;
	}
	//endregion your codes 2

}