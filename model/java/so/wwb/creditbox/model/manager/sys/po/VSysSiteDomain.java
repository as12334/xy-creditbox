package so.wwb.creditbox.model.manager.sys.po;

import so.wwb.creditbox.model.enums.base.MaintainTypeEnum;
import so.wwb.creditbox.model.enums.sys.SysSiteStatusEnum;
import java.util.Date;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-11-10 1:20:28
 */
//region your codes 1
public class VSysSiteDomain implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
    private static final long serialVersionUID = 204233763713118267L;
    //endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_DOM_NAME = "domName";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_NAME = "name";
	public static final String PROP_SITE_USER_ID = "siteUserId";
	public static final String PROP_SITE_USER_HID = "siteUserHid";
	public static final String PROP_SITE_USER_NAME = "siteUserName";
	public static final String PROP_SITE_USER_TYPE = "siteUserType";
	public static final String PROP_DOMAIN_ID = "domainId";
	public static final String PROP_DOMAIN = "domain";
	public static final String PROP_SITE_SUBSYS_CODE = "siteSubsysCode";
	public static final String PROP_DOMAIN_SUBSYS_CODE = "domainSubsysCode";
	public static final String PROP_DOMAIN_USER_ID = "domainUserId";
	public static final String PROP_DOMAIN_USER_TYPE = "domainUserType";
	public static final String PROP_DOMAIN_USER_NAME = "domainUserName";
	public static final String PROP_TIME_ZONE = "timeZone";
	public static final String PROP_SITE_LOCALE = "siteLocale";
	public static final String PROP_SITE_CODE = "siteCode";
	public static final String PROP_PLATFORM_CATEGORY = "platformCategory";
	public static final String PROP_LOGO_PATH = "logoPath";
	public static final String PROP_SITE_PARENT_ID = "siteParentId";
	public static final String PROP_SITE_STATUS = "siteStatus";
	public static final String PROP_MAINTAIN_START_TIME = "maintainStartTime";
	public static final String PROP_MAINTAIN_END_TIME = "maintainEndTime";
	public static final String PROP_MAINTAIN_REASON = "maintainReason";
	public static final String PROP_TEMPLATE_CODE = "templateCode";
	public static final String PROP_THEME = "theme";
	public static final String PROP_TITLE = "title";
	public static final String PROP_MODE = "mode";
	public static final String PROP_PAGE_URL = "pageUrl";
	public static final String PROP_IS_DEFAULT = "isDefault";
	public static final String PROP_IS_ENABLE = "isEnable";
	public static final String PROP_IS_DELETED = "isDeleted";
	public static final String PROP_RESOLVE_STATUS = "resolveStatus";
	public static final String PROP_CREATE_TIME = "createTime";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String domName;
	/**  */
	private Integer siteId;
	/**  */
	private String name;
	/**  */
	private Integer siteUserId;
	/**  */
	private String siteUserHid;
	/**  */
	private String siteUserName;
	/**  */
	private String siteUserType;
	/**  */
	private Integer domainId;
	/**  */
	private String domain;
	/**  */
	private String siteSubsysCode;
	/**  */
	private String domainSubsysCode;
	/**  */
	private Integer domainUserId;
	/**  */
	private String domainUserType;
	/**  */
	private String domainUserName;
	/**  */
	private String timeZone;
	/**  */
	private String siteLocale;
	/**  */
	private String siteCode;
	/**  */
	private String platformCategory;
	/**  */
	private String logoPath;
	/**  */
	private Integer siteParentId;
	/**  */
	private String siteStatus;
	/**  */
	private java.util.Date maintainStartTime;
	/**  */
	private java.util.Date maintainEndTime;
	/**  */
	private String maintainReason;
	/**  */
	private String templateCode;
	/**  */
	private String theme;
	/**  */
	private String title;
	/**  */
	private String mode;
	/**  */
	private String pageUrl;
	/**  */
	private Boolean isDefault;
	/**  */
	private Boolean isEnable;
	/**  */
	private Boolean isDeleted;
	/**  */
	private String resolveStatus;
	/**  */
	private java.util.Date createTime;
	//endregion

	
	//region constuctors
	public VSysSiteDomain(){
	}

	public VSysSiteDomain(Integer id){
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
	public String getDomName() {
		return this.domName;
	}

	public void setDomName(String value) {
		this.domName = value;
	}
	@org.soul.model.common.Sortable
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	@org.soul.model.common.Sortable
	public Integer getSiteUserId() {
		return this.siteUserId;
	}

	public void setSiteUserId(Integer value) {
		this.siteUserId = value;
	}
	public String getSiteUserHid() {
		return this.siteUserHid;
	}

	public void setSiteUserHid(String value) {
		this.siteUserHid = value;
	}
	public String getSiteUserName() {
		return this.siteUserName;
	}

	public void setSiteUserName(String value) {
		this.siteUserName = value;
	}
	public String getSiteUserType() {
		return this.siteUserType;
	}

	public void setSiteUserType(String value) {
		this.siteUserType = value;
	}
	public Integer getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Integer value) {
		this.domainId = value;
	}
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String value) {
		this.domain = value;
	}
	public String getSiteSubsysCode() {
		return this.siteSubsysCode;
	}

	public void setSiteSubsysCode(String value) {
		this.siteSubsysCode = value;
	}
	public String getDomainSubsysCode() {
		return this.domainSubsysCode;
	}

	public void setDomainSubsysCode(String value) {
		this.domainSubsysCode = value;
	}
	public Integer getDomainUserId() {
		return this.domainUserId;
	}

	public void setDomainUserId(Integer value) {
		this.domainUserId = value;
	}
	public String getDomainUserType() {
		return this.domainUserType;
	}

	public void setDomainUserType(String value) {
		this.domainUserType = value;
	}
	public String getDomainUserName() {
		return this.domainUserName;
	}

	public void setDomainUserName(String value) {
		this.domainUserName = value;
	}
	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String value) {
		this.timeZone = value;
	}
	public String getSiteLocale() {
		return this.siteLocale;
	}

	public void setSiteLocale(String value) {
		this.siteLocale = value;
	}
	public String getSiteCode() {
		return this.siteCode;
	}

	public void setSiteCode(String value) {
		this.siteCode = value;
	}
	public String getPlatformCategory() {
		return this.platformCategory;
	}

	public void setPlatformCategory(String value) {
		this.platformCategory = value;
	}
	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String value) {
		this.logoPath = value;
	}
	public Integer getSiteParentId() {
		return this.siteParentId;
	}

	public void setSiteParentId(Integer value) {
		this.siteParentId = value;
	}
	public String getSiteStatus() {
		return this.siteStatus;
	}

	public void setSiteStatus(String value) {
		this.siteStatus = value;
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
	public String getMaintainReason() {
		return this.maintainReason;
	}

	public void setMaintainReason(String value) {
		this.maintainReason = value;
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
	public String getMode() {
		return this.mode;
	}

	public void setMode(String value) {
		this.mode = value;
	}
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean value) {
		this.isDefault = value;
	}
	public Boolean getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Boolean value) {
		this.isEnable = value;
	}
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean value) {
		this.isDeleted = value;
	}
	@org.soul.model.common.Sortable
	public String getResolveStatus() {
		return this.resolveStatus;
	}

	public void setResolveStatus(String value) {
		this.resolveStatus = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	//endregion

	//region your codes 2
    public void calStatus(VSysSiteDomain sysSiteDomain) {


    }


    private void setOtherSiteStatus() {
        Date now = new Date();
        if (SysSiteStatusEnum.MAINTAIN.getCode().equals(getSiteStatus())) {
            if (getMaintainStartTime() != null) {
                if (now.before(getMaintainStartTime())) {
                    this.setSiteStatus(SysSiteStatusEnum.PRE_MAINTAIN.getCode());
                } else {
                    //this.setSiteStatus(SysSiteStatusEnum.MAINTAIN.getCode());
                    if (getMaintainEndTime() != null) {
                        if (now.before(getMaintainEndTime())) {
                            this.setSiteStatus(SysSiteStatusEnum.MAINTAIN.getCode());
                        } else {
                            this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
                        }
                    } else {
                        this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
                    }
                }
            } else {
                //返回原值
                this.setSiteStatus(SysSiteStatusEnum.NORMAL.getCode());
            }
        }
    }

    public static final String PROP_LOWER_DOMAIN = "lowerDomain";

    public String getLowerDomain() {
        return getDomain().toLowerCase();
    }


    //endregion your codes 2

}