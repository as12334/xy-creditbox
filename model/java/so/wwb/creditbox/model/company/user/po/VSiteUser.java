package so.wwb.creditbox.model.company.user.po;

import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-27 20:24:56
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
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 账号 */
	private String username;
	/** 用户密码 */
	private String password;
	/** 部门 id */
	private Integer deptId;
	/** 状态,枚举:SysUserStatus,[1, 正常],[2, 停用],[3, 冻结(不记录表)],[4, 未激活/未审核],[5,审核失败] */
	private String status;
	/** 创建用户id */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新用户id */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 默认本地化信息：两位小写语言代码_两位大写国家代码 */
	private String defaultLocale;
	/** 默认时区 */
	private String defaultTimezone;
	/** 系统编号：boss-总控，shareholder-股东，merchant-商户，agent-代理，pcenter-玩家 */
	private String subsysCode;
	/** 用户类型：22-代理商，221-代理商子账号，23-玩家 */
	private String userType;
	/** 是否系统内置 */
	private Boolean builtIn;
	/** 所有者id */
	private Integer ownerId;
	/** 冻结类型(1:自动冻结 2:手动冻结) */
	private String freezeType;
	/** 冻结开始时间 */
	private java.util.Date freezeStartTime;
	/** 冻结结束时间,当前时间在冻结结束区间内,状态为:冻结,3000年默认为:永久冻结 */
	private java.util.Date freezeEndTime;
	/** 冻结原因i18代码,关联表:v_site_user_freeze_reason */
	private String freezeCode;
	/** 本次登录时间 */
	private java.util.Date loginTime;
	/** 本次登录IP */
	private Long loginIp;
	/** 最后活跃时间 */
	private java.util.Date lastActiveTime;
	/** 本次使用线路 */
	private String useLine;
	/** 上次登录时间 */
	private java.util.Date lastLoginTime;
	/** 上次登录IP */
	private Long lastLoginIp;
	/** 累计在线时长 */
	private Long totalOnlineTime;
	/** 昵称 */
	private String nickname;
	/** 真实姓名 */
	private String realName;
	/** 生日 */
	private java.util.Date birthday;
	/** 性别，字典类型sex(common模块) */
	private String sex;
	/** 星座 */
	private String constellation;
	/** 国家，字典类型country(common模块) */
	private String country;
	/** 民族，字典类型nation(common模块) */
	private String nation;
	/** 注册ip */
	private Long registerIp;
	/** 头像地址 */
	private String avatarUrl;
	/** 权限密码 */
	private String permissionPwd;
	/** 身份证号 */
	private String idcard;
	/** 默认币种代码，字典类型currency(common模块) */
	private String defaultCurrency;
	/** 注册网站地址 */
	private String registerSite;
	/** 省/地区，字典类型province(common模块) */
	private String region;
	/** 城市 */
	private String city;
	/** 备注 */
	private String memo;
	/** 密码级别:高 30, 中,20 低,10 */
	private String passwordLevel;
	/** 登录IP地区字典代码 */
	private String loginIpDictCode;
	/** 上次登录IP地区字典代码 */
	private String lastLoginIpDictCode;
	/** 注册IP地区字典代码 */
	private String registerIpDictCode;
	/** 登录错误次数 */
	private Integer loginErrorTimes;
	/** 账号冻结标题 */
	private String freezeTitle;
	/** 账号冻结内容 */
	private String freezeContent;
	/** 上次退出时间 */
	private java.util.Date lastLogoutTime;
	/** 冻结操作人id */
	private Integer freezeUser;
	/** 停用操作人id */
	private Integer disabledUser;
	/** 停用时间 */
	private java.util.Date disabledTime;
	/** 冻结操作时间 */
	private java.util.Date freezeTime;
	/**  */
	private String accountFreezeRemark;
	/** 安全密码冻结开始时间 */
	private java.util.Date secpwdFreezeStartTime;
	/** 安全密码冻结结束时间 */
	private java.util.Date secpwdFreezeEndTime;
	/** 安全密码输错次数 */
	private Integer secpwdErrorTimes;
	/** 用户的session_key,online_session_id将被删除 */
	private String sessionKey;
	/** 登录终端：1-PC，2-MOBILE */
	private String terminal;
	/** 动态密码 */
	private String authenticationKey;
	/**  */
	private Integer siteId;
	/** 钥匙 */
	private String key;
	/** 用户唯一串 */
	private String uid;
	/** 密码加密盐 */
	private String salt;
	/** 皮肤 SkinEnum */
	private String uskin;
	/** 上级用户名 */
	private String supName;
	/** 用户新增时间 */
	private java.util.Date addDate;
	/** 用户类型 UtypeEnum */
	private String utype;
	/** 上级用户类型 UtypeEnum */
	private String suType;
	/** ⑥合彩占成 */
	private Integer sixRate;
	/** ⑥合彩信用额度 */
	private Double sixCredit;
	/** ⑥合彩可用额度 */
	private Double sixUsableCredit;
	/** ⑥合彩盘口 */
	private String sixKind;
	/**  */
	private Integer astate;
	/** ⑥合彩補貨功能 */
	private String sixAllowSale;
	/** 開放公司報錶功能 1:開放 0:禁看 */
	private String allowViewReport;
	/** ⑥合彩下線占成上限功能 1:限製下綫可占成數 0:占餘成數下綫任占 */
	private String sixAllowMaxrate;
	/** ⑥合彩限製下綫可占成數 */
	private Integer sixLowMaxrate;
	/** ⑥合彩占餘成數歸 1:總監 0:分公司 */
	private String sixRateOwner;
	/** 1:现金 0:信用 */
	private String sixIscash;
	/**  */
	private Integer allowOpt;
	/** 0:新密碼首次登錄,需重置密碼 1:不需要重置 */
	private String isChanged;
	/** 快彩占成 */
	private Integer kcRate;
	/** 快彩信用额度 */
	private Double kcCredit;
	/** 快彩可用额度 */
	private Double kcUsableCredit;
	/** 快彩盘口 */
	private String kcKind;
	/** 快彩補貨功能 */
	private String kcAllowSale;
	/** 快彩下線占成上限功能 1:限製下綫可占成數 0:占餘成數下綫任占 */
	private String kcAllowMaxrate;
	/** 快彩限製下綫可占成數 */
	private Integer kcLowMaxrate;
	/** 快彩占餘成數歸 1:總監 0:分公司 */
	private String kcRateOwner;
	/**  */
	private Integer kcCrashPayment;
	/** 1:现金 0:信用 */
	private String kcIscash;
	/** ⑥合彩操盤 */
	private String sixOpOdds;
	/** 快彩操盤 */
	private String kcOpOdds;
	/** 快彩會員現金自動回收 */
	private String kcIsautoBack;
	/** ⑥合彩會員現金自動回收 */
	private String sixIsautoBack;
	/** 密码最后修改时间 */
	private java.util.Date lastChangedDate;
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
	//endregion

	//region your codes 2

	//已使用额度
	private Double usableCredit;

	//今日输赢
	private Double toDayProfit;
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

//endregion your codes 2

}