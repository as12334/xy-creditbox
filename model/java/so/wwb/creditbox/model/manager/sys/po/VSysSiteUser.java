package so.wwb.creditbox.model.manager.sys.po;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.base.CacheBase;
import java.util.Date;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-10-23 16:52:38
 */
//region your codes 1
public class VSysSiteUser implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 4751979873719817363L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_NAME = "siteName";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_STATUS = "status";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_SITE_PARENT_ID = "siteParentId";
	public static final String PROP_SITE_LOCALE = "siteLocale";
	public static final String PROP_TIMEZONE = "timezone";
	public static final String PROP_OPENING_TIME = "openingTime";
	public static final String PROP_CODE = "code";
	public static final String PROP_TEMPLATE_CODE = "templateCode";
	public static final String PROP_THEME = "theme";
	public static final String PROP_TITLE = "title";
	public static final String PROP_MAINTAIN_START_TIME = "maintainStartTime";
	public static final String PROP_MAINTAIN_END_TIME = "maintainEndTime";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_MAIN_CURRENCY = "mainCurrency";
	public static final String PROP_MODE = "mode";
	public static final String PROP_OWNER_ID = "ownerId";
	//endregion
	
	
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
	private Integer siteParentId;
	/**  */
	private String siteLocale;
	/**  */
	private String timezone;
	/**  */
	private java.util.Date openingTime;
	/**  */
	private String code;
	/**  */
	private String templateCode;
	/**  */
	private String theme;
	/**  */
	private String title;
	/**  */
	private java.util.Date maintainStartTime;
	/**  */
	private java.util.Date maintainEndTime;
	/**  */
	private String remark;
	/**  */
	private String mainCurrency;
	/**  */
	private String mode;
	/**  */
	private Integer ownerId;
	//endregion

	
	//region constuctors
	public VSysSiteUser(){
	}

	public VSysSiteUser(Integer id){
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
	public java.util.Date getOpeningTime() {
		return this.openingTime;
	}

	public void setOpeningTime(java.util.Date value) {
		this.openingTime = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String value) {
		this.templateCode = value;
	}
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String value) {
		this.theme = value;
	}
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String value) {
		this.title = value;
	}
	public java.util.Date getMaintainStartTime() {
		return this.maintainStartTime;
	}

	public void setMaintainStartTime(java.util.Date value) {
		this.maintainStartTime = value;
	}
	public java.util.Date getMaintainEndTime() {
		return this.maintainEndTime;
	}

	public void setMaintainEndTime(java.util.Date value) {
		this.maintainEndTime = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	public String getMainCurrency() {
		return this.mainCurrency;
	}

	public void setMainCurrency(String value) {
		this.mainCurrency = value;
	}
	public String getMode() {
		return this.mode;
	}

	public void setMode(String value) {
		this.mode = value;
	}
	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer value) {
		this.ownerId = value;
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



	//endregion your codes 2

}