package so.wwb.creditbox.model.company.user.po;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-27 22:20:55
 */
//region your codes 1
public class VSiteUser implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -1000619930882254157L;
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
	public static final String PROP_KEY = "key";
	public static final String PROP_UID = "uid";
	public static final String PROP_SALT = "salt";
	public static final String PROP_USKIN = "uskin";
	public static final String PROP_SUP_NAME = "supName";
	public static final String PROP_ADD_DATE = "addDate";
	public static final String PROP_UTYPE = "utype";
	public static final String PROP_SU_TYPE = "suType";
	public static final String PROP_SIX_RATE = "sixRate";
	public static final String PROP_SIX_CREDIT = "sixCredit";
	public static final String PROP_SIX_USABLE_CREDIT = "sixUsableCredit";
	public static final String PROP_SIX_KIND = "sixKind";
	public static final String PROP_ASTATE = "astate";
	public static final String PROP_SIX_ALLOW_SALE = "sixAllowSale";
	public static final String PROP_ALLOW_VIEW_REPORT = "allowViewReport";
	public static final String PROP_SIX_ALLOW_MAXRATE = "sixAllowMaxrate";
	public static final String PROP_SIX_LOW_MAXRATE = "sixLowMaxrate";
	public static final String PROP_SIX_RATE_OWNER = "sixRateOwner";
	public static final String PROP_SIX_ISCASH = "sixIscash";
	public static final String PROP_ALLOW_OPT = "allowOpt";
	public static final String PROP_IS_CHANGED = "isChanged";
	public static final String PROP_KC_RATE = "kcRate";
	public static final String PROP_KC_CREDIT = "kcCredit";
	public static final String PROP_KC_USABLE_CREDIT = "kcUsableCredit";
	public static final String PROP_KC_KIND = "kcKind";
	public static final String PROP_KC_ALLOW_SALE = "kcAllowSale";
	public static final String PROP_KC_ALLOW_MAXRATE = "kcAllowMaxrate";
	public static final String PROP_KC_LOW_MAXRATE = "kcLowMaxrate";
	public static final String PROP_KC_RATE_OWNER = "kcRateOwner";
	public static final String PROP_KC_CRASH_PAYMENT = "kcCrashPayment";
	public static final String PROP_KC_ISCASH = "kcIscash";
	public static final String PROP_SIX_OP_ODDS = "sixOpOdds";
	public static final String PROP_KC_OP_ODDS = "kcOpOdds";
	public static final String PROP_KC_ISAUTO_BACK = "kcIsautoBack";
	public static final String PROP_SIX_ISAUTO_BACK = "sixIsautoBack";
	public static final String PROP_LAST_CHANGED_DATE = "lastChangedDate";
	public static final String PROP_HID = "hid";
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
	private String key;
	/**  */
	private String uid;
	/**  */
	private String salt;
	/**  */
	private String uskin;
	/**  */
	private String supName;
	/**  */
	private java.util.Date addDate;
	/**  */
	private String utype;
	/**  */
	private String suType;
	/**  */
	private Integer sixRate;
	/**  */
	private Double sixCredit;
	/**  */
	private Double sixUsableCredit;
	/**  */
	private String sixKind;
	/**  */
	private Integer astate;
	/**  */
	private String sixAllowSale;
	/**  */
	private String allowViewReport;
	/**  */
	private String sixAllowMaxrate;
	/**  */
	private Integer sixLowMaxrate;
	/**  */
	private String sixRateOwner;
	/**  */
	private String sixIscash;
	/**  */
	private Integer allowOpt;
	/**  */
	private String isChanged;
	/**  */
	private Integer kcRate;
	/**  */
	private Double kcCredit;
	/**  */
	private Double kcUsableCredit;
	/**  */
	private String kcKind;
	/**  */
	private String kcAllowSale;
	/**  */
	private String kcAllowMaxrate;
	/**  */
	private Integer kcLowMaxrate;
	/**  */
	private String kcRateOwner;
	/**  */
	private Integer kcCrashPayment;
	/**  */
	private String kcIscash;
	/**  */
	private String sixOpOdds;
	/**  */
	private String kcOpOdds;
	/**  */
	private String kcIsautoBack;
	/**  */
	private String sixIsautoBack;
	/**  */
	private java.util.Date lastChangedDate;
	/**  */
	private String hid;
	//endregion

	
	//region constuctors
	public VSiteUser(){
	}

	public VSiteUser(Integer id){
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
	@org.soul.model.common.Sortable
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
	public String getKey() {
		return this.key;
	}

	public void setKey(String value) {
		this.key = value;
	}
	public String getUid() {
		return this.uid;
	}

	public void setUid(String value) {
		this.uid = value;
	}
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String value) {
		this.salt = value;
	}
	public String getUskin() {
		return this.uskin;
	}

	public void setUskin(String value) {
		this.uskin = value;
	}
	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String value) {
		this.supName = value;
	}
	public java.util.Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(java.util.Date value) {
		this.addDate = value;
	}
	public String getUtype() {
		return this.utype;
	}

	public void setUtype(String value) {
		this.utype = value;
	}
	public String getSuType() {
		return this.suType;
	}

	public void setSuType(String value) {
		this.suType = value;
	}
	public Integer getSixRate() {
		return this.sixRate;
	}

	public void setSixRate(Integer value) {
		this.sixRate = value;
	}
	public Double getSixCredit() {
		return this.sixCredit;
	}

	public void setSixCredit(Double value) {
		this.sixCredit = value;
	}
	public Double getSixUsableCredit() {
		return this.sixUsableCredit;
	}

	public void setSixUsableCredit(Double value) {
		this.sixUsableCredit = value;
	}
	public String getSixKind() {
		return this.sixKind;
	}

	public void setSixKind(String value) {
		this.sixKind = value;
	}
	public Integer getAstate() {
		return this.astate;
	}

	public void setAstate(Integer value) {
		this.astate = value;
	}
	public String getSixAllowSale() {
		return this.sixAllowSale;
	}

	public void setSixAllowSale(String value) {
		this.sixAllowSale = value;
	}
	public String getAllowViewReport() {
		return this.allowViewReport;
	}

	public void setAllowViewReport(String value) {
		this.allowViewReport = value;
	}
	public String getSixAllowMaxrate() {
		return this.sixAllowMaxrate;
	}

	public void setSixAllowMaxrate(String value) {
		this.sixAllowMaxrate = value;
	}
	public Integer getSixLowMaxrate() {
		return this.sixLowMaxrate;
	}

	public void setSixLowMaxrate(Integer value) {
		this.sixLowMaxrate = value;
	}
	public String getSixRateOwner() {
		return this.sixRateOwner;
	}

	public void setSixRateOwner(String value) {
		this.sixRateOwner = value;
	}
	public String getSixIscash() {
		return this.sixIscash;
	}

	public void setSixIscash(String value) {
		this.sixIscash = value;
	}
	public Integer getAllowOpt() {
		return this.allowOpt;
	}

	public void setAllowOpt(Integer value) {
		this.allowOpt = value;
	}
	public String getIsChanged() {
		return this.isChanged;
	}

	public void setIsChanged(String value) {
		this.isChanged = value;
	}
	public Integer getKcRate() {
		return this.kcRate;
	}

	public void setKcRate(Integer value) {
		this.kcRate = value;
	}
	public Double getKcCredit() {
		return this.kcCredit;
	}

	public void setKcCredit(Double value) {
		this.kcCredit = value;
	}
	public Double getKcUsableCredit() {
		return this.kcUsableCredit;
	}

	public void setKcUsableCredit(Double value) {
		this.kcUsableCredit = value;
	}
	public String getKcKind() {
		return this.kcKind;
	}

	public void setKcKind(String value) {
		this.kcKind = value;
	}
	public String getKcAllowSale() {
		return this.kcAllowSale;
	}

	public void setKcAllowSale(String value) {
		this.kcAllowSale = value;
	}
	public String getKcAllowMaxrate() {
		return this.kcAllowMaxrate;
	}

	public void setKcAllowMaxrate(String value) {
		this.kcAllowMaxrate = value;
	}
	public Integer getKcLowMaxrate() {
		return this.kcLowMaxrate;
	}

	public void setKcLowMaxrate(Integer value) {
		this.kcLowMaxrate = value;
	}
	public String getKcRateOwner() {
		return this.kcRateOwner;
	}

	public void setKcRateOwner(String value) {
		this.kcRateOwner = value;
	}
	public Integer getKcCrashPayment() {
		return this.kcCrashPayment;
	}

	public void setKcCrashPayment(Integer value) {
		this.kcCrashPayment = value;
	}
	public String getKcIscash() {
		return this.kcIscash;
	}

	public void setKcIscash(String value) {
		this.kcIscash = value;
	}
	public String getSixOpOdds() {
		return this.sixOpOdds;
	}

	public void setSixOpOdds(String value) {
		this.sixOpOdds = value;
	}
	public String getKcOpOdds() {
		return this.kcOpOdds;
	}

	public void setKcOpOdds(String value) {
		this.kcOpOdds = value;
	}
	public String getKcIsautoBack() {
		return this.kcIsautoBack;
	}

	public void setKcIsautoBack(String value) {
		this.kcIsautoBack = value;
	}
	public String getSixIsautoBack() {
		return this.sixIsautoBack;
	}

	public void setSixIsautoBack(String value) {
		this.sixIsautoBack = value;
	}
	public java.util.Date getLastChangedDate() {
		return this.lastChangedDate;
	}

	public void setLastChangedDate(java.util.Date value) {
		this.lastChangedDate = value;
	}
	public String getHid() {
		return this.hid;
	}

	public void setHid(String value) {
		this.hid = value;
	}
	//endregion

	//region your codes 2

	//已使用额度
	private Double usableCredit;

	//今日输赢
	private Double toDayProfit;

	private Integer fgsCount;
	private Integer gdCount;
	private Integer zdCount;
	private Integer dlCount;
	private Integer hyCount;
	@Nonpersistent
	public Double getUsableCredit() {
		return usableCredit;
	}

	public void setUsableCredit(Double usableCredit) {
		this.usableCredit = usableCredit;
	}
	@Nonpersistent
	public Double getToDayProfit() {
		return toDayProfit;
	}

	public void setToDayProfit(Double toDayProfit) {
		this.toDayProfit = toDayProfit;
	}

	@Nonpersistent
	public Integer getFgsCount() {
		return fgsCount;
	}

	public void setFgsCount(Integer fgsCount) {
		this.fgsCount = fgsCount;
	}
	@Nonpersistent
	public Integer getGdCount() {
		return gdCount;
	}

	public void setGdCount(Integer gdCount) {
		this.gdCount = gdCount;
	}
	@Nonpersistent
	public Integer getZdCount() {
		return zdCount;
	}

	public void setZdCount(Integer zdCount) {
		this.zdCount = zdCount;
	}
	@Nonpersistent
	public Integer getDlCount() {
		return dlCount;
	}

	public void setDlCount(Integer dlCount) {
		this.dlCount = dlCount;
	}
	@Nonpersistent
	public Integer getHyCount() {
		return hyCount;
	}

	public void setHyCount(Integer hyCount) {
		this.hyCount = hyCount;
	}

//endregion your codes 2

}