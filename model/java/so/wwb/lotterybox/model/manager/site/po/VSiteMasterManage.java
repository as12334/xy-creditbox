package so.wwb.lotterybox.model.manager.site.po;

import org.soul.commons.bean.IEntity;


/**
 * 实体
 *
 * @author jerry
 * @time 2017-4-7 9:42:27
 */
//region your codes 1
public class VSiteMasterManage implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 8326424840855015640L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_PASSWORD = "password";
	public static final String PROP_DEPT_ID = "deptId";
	public static final String PROP_STATUS = "status";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_DEFAULT_LOCALE = "defaultLocale";
	public static final String PROP_DEFAULT_TIMEZONE = "defaultTimezone";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_USER_TYPE = "userType";
	public static final String PROP_BUILT_IN = "builtIn";
	public static final String PROP_MERCHANT_ID = "merchantId";
	public static final String PROP_OWNER_ID = "ownerId";
	public static final String PROP_FREEZE_TYPE = "freezeType";
	public static final String PROP_FREEZE_START_TIME = "freezeStartTime";
	public static final String PROP_FREEZE_END_TIME = "freezeEndTime";
	public static final String PROP_FREEZE_CODE = "freezeCode";
	public static final String PROP_LOGIN_TIME = "loginTime";
	public static final String PROP_LOGIN_IP = "loginIp";
	public static final String PROP_LAST_ACTIVE_TIME = "lastActiveTime";
	public static final String PROP_USE_LINE = "useLine";
	public static final String PROP_LAST_LOGIN_TIME = "lastLoginTime";
	public static final String PROP_LAST_LOGIN_IP = "lastLoginIp";
	public static final String PROP_TOTAL_ONLINE_TIME = "totalOnlineTime";
	public static final String PROP_NICKNAME = "nickname";
	public static final String PROP_REAL_NAME = "realName";
	public static final String PROP_BIRTHDAY = "birthday";
	public static final String PROP_SEX = "sex";
	public static final String PROP_CONSTELLATION = "constellation";
	public static final String PROP_COUNTRY = "country";
	public static final String PROP_NATION = "nation";
	public static final String PROP_REGISTER_IP = "registerIp";
	public static final String PROP_AVATAR_URL = "avatarUrl";
	public static final String PROP_PERMISSION_PWD = "permissionPwd";
	public static final String PROP_IDCARD = "idcard";
	public static final String PROP_DEFAULT_CURRENCY = "defaultCurrency";
	public static final String PROP_REGISTER_SITE = "registerSite";
	public static final String PROP_REGION = "region";
	public static final String PROP_CITY = "city";
	public static final String PROP_MEMO = "memo";
	public static final String PROP_PASSWORD_LEVEL = "passwordLevel";
	public static final String PROP_LOGIN_IP_DICT_CODE = "loginIpDictCode";
	public static final String PROP_LAST_LOGIN_IP_DICT_CODE = "lastLoginIpDictCode";
	public static final String PROP_REGISTER_IP_DICT_CODE = "registerIpDictCode";
	public static final String PROP_LOGIN_ERROR_TIMES = "loginErrorTimes";
	public static final String PROP_FREEZE_TITLE = "freezeTitle";
	public static final String PROP_FREEZE_CONTENT = "freezeContent";
	public static final String PROP_LAST_LOGOUT_TIME = "lastLogoutTime";
	public static final String PROP_FREEZE_USER = "freezeUser";
	public static final String PROP_DISABLED_USER = "disabledUser";
	public static final String PROP_DISABLED_TIME = "disabledTime";
	public static final String PROP_FREEZE_TIME = "freezeTime";
	public static final String PROP_ACCOUNT_FREEZE_REMARK = "accountFreezeRemark";
	public static final String PROP_SECPWD_FREEZE_START_TIME = "secpwdFreezeStartTime";
	public static final String PROP_SECPWD_FREEZE_END_TIME = "secpwdFreezeEndTime";
	public static final String PROP_SECPWD_ERROR_TIMES = "secpwdErrorTimes";
	public static final String PROP_SESSION_KEY = "sessionKey";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_AUTHENTICATION_KEY = "authenticationKey";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_SITE_NUM = "siteNum";
	public static final String PROP_CODE = "code";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String username;
	/**  */
	private String password;
	/**  */
	private Integer deptId;
	/**  */
	private String status;
	/**  */
	private Integer createUser;
	/**  */
	private java.util.Date createTime;
	/**  */
	private Integer updateUser;
	/**  */
	private java.util.Date updateTime;
	/**  */
	private String defaultLocale;
	/**  */
	private String defaultTimezone;
	/**  */
	private String subsysCode;
	/**  */
	private String userType;
	/**  */
	private Boolean builtIn;
	/**  */
	private Integer merchantId;
	/**  */
	private Integer ownerId;
	/**  */
	private String freezeType;
	/**  */
	private java.util.Date freezeStartTime;
	/**  */
	private java.util.Date freezeEndTime;
	/**  */
	private String freezeCode;
	/**  */
	private java.util.Date loginTime;
	/**  */
	private Long loginIp;
	/**  */
	private java.util.Date lastActiveTime;
	/**  */
	private String useLine;
	/**  */
	private java.util.Date lastLoginTime;
	/**  */
	private Long lastLoginIp;
	/**  */
	private Long totalOnlineTime;
	/**  */
	private String nickname;
	/**  */
	private String realName;
	/**  */
	private java.util.Date birthday;
	/**  */
	private String sex;
	/**  */
	private String constellation;
	/**  */
	private String country;
	/**  */
	private String nation;
	/**  */
	private Long registerIp;
	/**  */
	private String avatarUrl;
	/**  */
	private String permissionPwd;
	/**  */
	private String idcard;
	/**  */
	private String defaultCurrency;
	/**  */
	private String registerSite;
	/**  */
	private String region;
	/**  */
	private String city;
	/**  */
	private String memo;
	/**  */
	private String passwordLevel;
	/**  */
	private String loginIpDictCode;
	/**  */
	private String lastLoginIpDictCode;
	/**  */
	private String registerIpDictCode;
	/**  */
	private Integer loginErrorTimes;
	/**  */
	private String freezeTitle;
	/**  */
	private String freezeContent;
	/**  */
	private java.util.Date lastLogoutTime;
	/**  */
	private Integer freezeUser;
	/**  */
	private Integer disabledUser;
	/**  */
	private java.util.Date disabledTime;
	/**  */
	private java.util.Date freezeTime;
	/**  */
	private String accountFreezeRemark;
	/**  */
	private java.util.Date secpwdFreezeStartTime;
	/**  */
	private java.util.Date secpwdFreezeEndTime;
	/**  */
	private Integer secpwdErrorTimes;
	/**  */
	private String sessionKey;
	/**  */
	private String terminal;
	/**  */
	private String authenticationKey;
	/**  */
	private Integer siteId;
	/**  */
	private Long siteNum;
	private String code;
	//endregion

	
	//region constuctors
	public VSiteMasterManage(){
	}

	public VSiteMasterManage(Integer id){
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
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String value) {
		this.password = value;
	}
	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer value) {
		this.deptId = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer value) {
		this.updateUser = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public String getDefaultLocale() {
		return this.defaultLocale;
	}

	public void setDefaultLocale(String value) {
		this.defaultLocale = value;
	}
	public String getDefaultTimezone() {
		return this.defaultTimezone;
	}

	public void setDefaultTimezone(String value) {
		this.defaultTimezone = value;
	}
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String value) {
		this.subsysCode = value;
	}
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String value) {
		this.userType = value;
	}
	public Boolean getBuiltIn() {
		return this.builtIn;
	}

	public void setBuiltIn(Boolean value) {
		this.builtIn = value;
	}
	public Integer getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(Integer value) {
		this.merchantId = value;
	}
	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}
	public String getFreezeType() {
		return this.freezeType;
	}

	public void setFreezeType(String value) {
		this.freezeType = value;
	}
	public java.util.Date getFreezeStartTime() {
		return this.freezeStartTime;
	}

	public void setFreezeStartTime(java.util.Date value) {
		this.freezeStartTime = value;
	}
	public java.util.Date getFreezeEndTime() {
		return this.freezeEndTime;
	}

	public void setFreezeEndTime(java.util.Date value) {
		this.freezeEndTime = value;
	}
	public String getFreezeCode() {
		return this.freezeCode;
	}

	public void setFreezeCode(String value) {
		this.freezeCode = value;
	}
	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}
	public Long getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(Long value) {
		this.loginIp = value;
	}
	public java.util.Date getLastActiveTime() {
		return this.lastActiveTime;
	}

	public void setLastActiveTime(java.util.Date value) {
		this.lastActiveTime = value;
	}
	public String getUseLine() {
		return this.useLine;
	}

	public void setUseLine(String value) {
		this.useLine = value;
	}
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}
	public Long getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(Long value) {
		this.lastLoginIp = value;
	}
	public Long getTotalOnlineTime() {
		return this.totalOnlineTime;
	}

	public void setTotalOnlineTime(Long value) {
		this.totalOnlineTime = value;
	}
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String value) {
		this.nickname = value;
	}
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String value) {
		this.realName = value;
	}
	public java.util.Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(java.util.Date value) {
		this.birthday = value;
	}
	public String getSex() {
		return this.sex;
	}

	public void setSex(String value) {
		this.sex = value;
	}
	public String getConstellation() {
		return this.constellation;
	}

	public void setConstellation(String value) {
		this.constellation = value;
	}
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String value) {
		this.country = value;
	}
	public String getNation() {
		return this.nation;
	}

	public void setNation(String value) {
		this.nation = value;
	}
	public Long getRegisterIp() {
		return this.registerIp;
	}

	public void setRegisterIp(Long value) {
		this.registerIp = value;
	}
	public String getAvatarUrl() {
		return this.avatarUrl;
	}

	public void setAvatarUrl(String value) {
		this.avatarUrl = value;
	}
	public String getPermissionPwd() {
		return this.permissionPwd;
	}

	public void setPermissionPwd(String value) {
		this.permissionPwd = value;
	}
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String value) {
		this.idcard = value;
	}
	public String getDefaultCurrency() {
		return this.defaultCurrency;
	}

	public void setDefaultCurrency(String value) {
		this.defaultCurrency = value;
	}
	public String getRegisterSite() {
		return this.registerSite;
	}

	public void setRegisterSite(String value) {
		this.registerSite = value;
	}
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String value) {
		this.region = value;
	}
	public String getCity() {
		return this.city;
	}

	public void setCity(String value) {
		this.city = value;
	}
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String value) {
		this.memo = value;
	}
	public String getPasswordLevel() {
		return this.passwordLevel;
	}

	public void setPasswordLevel(String value) {
		this.passwordLevel = value;
	}
	public String getLoginIpDictCode() {
		return this.loginIpDictCode;
	}

	public void setLoginIpDictCode(String value) {
		this.loginIpDictCode = value;
	}
	public String getLastLoginIpDictCode() {
		return this.lastLoginIpDictCode;
	}

	public void setLastLoginIpDictCode(String value) {
		this.lastLoginIpDictCode = value;
	}
	public String getRegisterIpDictCode() {
		return this.registerIpDictCode;
	}

	public void setRegisterIpDictCode(String value) {
		this.registerIpDictCode = value;
	}
	public Integer getLoginErrorTimes() {
		return this.loginErrorTimes;
	}

	public void setLoginErrorTimes(Integer value) {
		this.loginErrorTimes = value;
	}
	public String getFreezeTitle() {
		return this.freezeTitle;
	}

	public void setFreezeTitle(String value) {
		this.freezeTitle = value;
	}
	public String getFreezeContent() {
		return this.freezeContent;
	}

	public void setFreezeContent(String value) {
		this.freezeContent = value;
	}
	public java.util.Date getLastLogoutTime() {
		return this.lastLogoutTime;
	}

	public void setLastLogoutTime(java.util.Date value) {
		this.lastLogoutTime = value;
	}
	public Integer getFreezeUser() {
		return this.freezeUser;
	}

	public void setFreezeUser(Integer value) {
		this.freezeUser = value;
	}
	public Integer getDisabledUser() {
		return this.disabledUser;
	}

	public void setDisabledUser(Integer value) {
		this.disabledUser = value;
	}
	public java.util.Date getDisabledTime() {
		return this.disabledTime;
	}

	public void setDisabledTime(java.util.Date value) {
		this.disabledTime = value;
	}
	public java.util.Date getFreezeTime() {
		return this.freezeTime;
	}

	public void setFreezeTime(java.util.Date value) {
		this.freezeTime = value;
	}
	public String getAccountFreezeRemark() {
		return this.accountFreezeRemark;
	}

	public void setAccountFreezeRemark(String value) {
		this.accountFreezeRemark = value;
	}
	public java.util.Date getSecpwdFreezeStartTime() {
		return this.secpwdFreezeStartTime;
	}

	public void setSecpwdFreezeStartTime(java.util.Date value) {
		this.secpwdFreezeStartTime = value;
	}
	public java.util.Date getSecpwdFreezeEndTime() {
		return this.secpwdFreezeEndTime;
	}

	public void setSecpwdFreezeEndTime(java.util.Date value) {
		this.secpwdFreezeEndTime = value;
	}
	public Integer getSecpwdErrorTimes() {
		return this.secpwdErrorTimes;
	}

	public void setSecpwdErrorTimes(Integer value) {
		this.secpwdErrorTimes = value;
	}
	public String getSessionKey() {
		return this.sessionKey;
	}

	public void setSessionKey(String value) {
		this.sessionKey = value;
	}
	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String value) {
		this.terminal = value;
	}
	public String getAuthenticationKey() {
		return this.authenticationKey;
	}

	public void setAuthenticationKey(String value) {
		this.authenticationKey = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public Long getSiteNum() {
		return this.siteNum;
	}

	public void setSiteNum(Long value) {
		this.siteNum = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2

}