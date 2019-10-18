package so.wwb.creditbox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.cache.CacheKey;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.base.CacheBase;

import java.util.Date;

//region your codes 1
public class VSysSiteUser implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 4751979873719817363L;
	//endregion your codes 3

	public static final String PROP_ID = "id";
	public static final String PROP_SITE_NAME = "siteName";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_STATUS = "status";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_CENTER_ID = "centerId";
	public static final String PROP_SITE_PARENT_ID = "siteParentId";
	public static final String PROP_SITE_LOCALE = "siteLocale";
	public static final String PROP_TIMEZONE = "timezone";
	public static final String PROP_IDC = "idc";
	public static final String PROP_CODE = "code";
	public static final String PROP_OPENING_TIME = "openingTime";
	public static final String PROP_MERCHANT_CODE = "merchantCode";
	public static final String PROP_TEMPLATE_CODE = "templateCode";
	public static final String PROP_MAINTAIN_START_TIME = "maintainStartTime";
	public static final String PROP_MAINTAIN_END_TIME = "maintainEndTime";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_OWNER_ID = "ownerId";
	public static final String PROP_MODE = "mode";
	public static final String PROP_MAIN_CURRENCY = "mainCurrency";
	public static final String PROP_THEME = "theme";
	public static final String PROP_TITLE = "title";

	public static final String PROP_SERVERS = "servers";
	public static final String PROP_APP_SERVERS = "appServers";

	//region properties
	/**  */
	private Integer id;
	/**  */
	private String siteName;
	/**  */
	private Integer sysUserId;
	/**  */
	private String status;
	/**  */
	private String username;
	/**  */
	private String subsysCode;
	/**  */
	private Integer centerId;
	/**  */
	private Integer siteParentId;
	/**  */
	private String siteLocale;
	/**  */
	private String timezone;
	/**  */
	private String idc;
	/**  */
	private String code;
	/**  */
	private Date openingTime;
	//endregion
	private String merchantCode;

	/** 模板code */
	private String templateCode;
	/** 维护开始时间 */
	private java.util.Date maintainStartTime;
	/** 维护结束时间 */
	private java.util.Date maintainEndTime;
	/** 备注 */
	private String remark;

	private Integer ownerId;

	/**
	 * 模式:测试:1、正式:2
	 */
	private String mode;

	/** 主货币 */
	private String mainCurrency;

	private String theme;
	private String title;

	private String servers;
	private String appServers;

	//region constuctors
	public VSysSiteUser(){
	}

	public VSysSiteUser(Integer id){
		this.id = id;
	}
	//endregion


	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	//region getters and setters
	@org.soul.model.common.Sortable
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String value) {
		this.siteName = value;
	}
	@org.soul.model.common.Sortable
	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String value) {
		this.subsysCode = value;
	}
	@org.soul.model.common.Sortable
	public Integer getCenterId() {
		return this.centerId;
	}

	public void setCenterId(Integer value) {
		this.centerId = value;
	}
	@org.soul.model.common.Sortable
	public Integer getSiteParentId() {
		return this.siteParentId;
	}

	public void setSiteParentId(Integer value) {
		this.siteParentId = value;
	}
	public String getSiteLocale() {
		return this.siteLocale;
	}

	public void setSiteLocale(String value) {
		this.siteLocale = value;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String value) {
		this.timezone = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
//endregion

	//region your codes 2
	public static final String	PROP_CACHE_KEY			= "cacheKey";

	/**
	 * 获取缓存的Key
	 * @return
	 */
	@Nonpersistent
	public String getCacheKey(){
//		String centerId = getCenterId() == null ? "null" : getCenterId().toString();
//		String sysUserId= getSysUserId() == null ? "null" : getSysUserId().toString();
		return CacheKey.getCacheKey(getId().toString());
	}
	private String siteNameI18n;
	@Nonpersistent
	public String getSiteNameI18n(){
		siteNameI18n = CacheBase.getSiteNameBySiteId(getId());
		return siteNameI18n;
	}

	private String centerName;
	private Integer centerUserId;
	@Nonpersistent
	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Integer getCenterUserId() {
		return centerUserId;
	}

	public void setCenterUserId(Integer centerUserId) {
		this.centerUserId = centerUserId;
	}

	public String getIdc() {
		return idc;
	}

	public void setIdc(String idc) {
		this.idc = idc;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public Date getMaintainStartTime() {
		return maintainStartTime;
	}

	public void setMaintainStartTime(Date maintainStartTime) {
		this.maintainStartTime = maintainStartTime;
	}

	public Date getMaintainEndTime() {
		return maintainEndTime;
	}

	public void setMaintainEndTime(Date maintainEndTime) {
		this.maintainEndTime = maintainEndTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}

	public String getMainCurrency() {
		return mainCurrency;
	}

	public void setMainCurrency(String mainCurrency) {
		this.mainCurrency = mainCurrency;
	}

	//endregion your codes 2


	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public String getAppServers() {
		return appServers;
	}

	public void setAppServers(String appServers) {
		this.appServers = appServers;
	}
}