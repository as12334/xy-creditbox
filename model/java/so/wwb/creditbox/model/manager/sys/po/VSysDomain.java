package so.wwb.creditbox.model.manager.sys.po;

import org.soul.commons.support.Nonpersistent;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-10-11 19:37:33
 */
//region your codes 1
public class VSysDomain implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
    private static final long serialVersionUID = 7827593741111001019L;
    //endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SYS_USER_ID = "sysUserId";
	public static final String PROP_DOMAIN = "domain";
	public static final String PROP_IS_DEFAULT = "isDefault";
	public static final String PROP_IS_ENABLE = "isEnable";
	public static final String PROP_IS_DELETED = "isDeleted";
	public static final String PROP_SORT = "sort";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_PAGE_URL = "pageUrl";
	public static final String PROP_NAME = "name";
	public static final String PROP_RESOLVE_STATUS = "resolveStatus";
	public static final String PROP_BUILD_IN = "buildIn";
	public static final String PROP_PARENT_ID = "parentId";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_USER_CODE = "userCode";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private Integer sysUserId;
	/**  */
	private String domain;
	/**  */
	private Boolean isDefault;
	/**  */
	private Boolean isEnable;
	/**  */
	private Boolean isDeleted;
	/**  */
	private Integer sort;
	/**  */
	private Integer siteId;
	/**  */
	private String subsysCode;
	/**  */
	private Integer createUser;
	/**  */
	private java.util.Date createTime;
	/**  */
	private Integer updateUser;
	/**  */
	private java.util.Date updateTime;
	/**  */
	private String pageUrl;
	/**  */
	private String name;
	/**  */
	private String resolveStatus;
	/**  */
	private Boolean buildIn;
	/**  */
	private Integer parentId;
	/**  */
	private String username;
	/**  */
	private String userCode;
	//endregion

	
	//region constuctors
	public VSysDomain(){
	}

	public VSysDomain(Integer id){
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
	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer value) {
		this.sysUserId = value;
	}
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String value) {
		this.domain = value;
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
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}
	@org.soul.model.common.Sortable
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String value) {
		this.subsysCode = value;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	@org.soul.model.common.Sortable
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
	public String getPageUrl() {
		return this.pageUrl;
	}

	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	@org.soul.model.common.Sortable
	public String getResolveStatus() {
		return this.resolveStatus;
	}

	public void setResolveStatus(String value) {
		this.resolveStatus = value;
	}
	public Boolean getBuildIn() {
		return this.buildIn;
	}

	public void setBuildIn(Boolean value) {
		this.buildIn = value;
	}
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer value) {
		this.parentId = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String value) {
		this.userCode = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}