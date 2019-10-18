package so.wwb.lotterybox.model.manager.sys.po;


import org.soul.commons.bean.IEntity;



/**
 * 域名表实体
 *
 * @author block
 * @time 2019-10-11 22:27:02
 */
//region your codes 1
public class SysDomain implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
    private static final long serialVersionUID = 5967350233645526228L;
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
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 域名所属的主帐号的用户ID,关联sys_user_extend.id 且用户类型为:[0,1,2] */
	private Integer sysUserId;
	/** 域名 */
	private String domain;
	/** 是否默认 */
	private Boolean isDefault;
	/** 是否有效 */
	private Boolean isEnable;
	/** 是否删除 */
	private Boolean isDeleted;
	/** 排序号 */
	private Integer sort;
	/** 站点ID */
	private Integer siteId;
	/** 子系统编号:boss:总控,companies:运营商,company:公司,branch:分公司,shareholder:股东,distributor:总代,agent:代理 */
	private String subsysCode;
	/** 创建用户ID */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新用户ID */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 页面地址 */
	private String pageUrl;
	/** 名称 */
	private String name;
	/** 域名绑定状态:1 待绑定，2绑定中，3待解绑，4解绑中，5完成，6失败 */
	private String resolveStatus;
	/** 是否内置:开发使用 */
	private Boolean buildIn;
	//endregion

	
	//region constuctors
	public SysDomain(){
	}

	public SysDomain(Integer id){
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
	@org.soul.model.common.Sortable
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
	//endregion

	//region your codes 2

	//endregion your codes 2

}