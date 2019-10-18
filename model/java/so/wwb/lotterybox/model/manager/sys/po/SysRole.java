package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;


/**
 * 系统角色实体
 *
 * Created by tom using soul-code-generator on 2015-7-10 16:37:31
 */
//region your codes 1
public class SysRole implements IEntity<Integer> {
//endregion your codes 1

	private static final long serialVersionUID = -9223372036854775808L;

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_NAME = "name";
	public static final String PROP_STATUS = "status";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_CODE = "code";
	public static final String PROP_BUILT_IN = "builtIn";
	public static final String PROP_SITE_ID = "siteId";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 角色名称 */
	private String name;
	/** 状态(1启用  2禁用) */
	private Integer status;
	/** 创建用户id */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 创建用户id */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 所属子系统编号 */
	private String subsysCode;
	/** 角色编号 */
	private String code;
	/** 是否系统内置 */
	private Boolean builtIn = Boolean.valueOf(false);
	/** 站长ID */
	private Integer siteId;
	//endregion

	
	//region constuctors
	public SysRole(){
	}

	public SysRole(Integer id){
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
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}

	@org.soul.model.common.Sortable
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer value) {
		this.status = value;
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

	@org.soul.model.common.Sortable
	public String getSubsysCode() {
		return this.subsysCode;
	}

	public void setSubsysCode(String value) {
		this.subsysCode = value;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public Boolean getBuiltIn() {
		return this.builtIn;
	}

	public void setBuiltIn(Boolean value) {
		this.builtIn = value;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}

	//endregion

	//region your codes 2

	//endregion your codes 2

}