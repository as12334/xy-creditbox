package so.wwb.lotterybox.model.manager.user.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.support.Nonpersistent;

import java.util.List;


/**
 * 子账户视图实体
 *
 * @author Administrator
 * @time 2017-1-7 17:40:15
 */
//region your codes 1
public class VSubAccount implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -5861646624336488604L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_USER_TYPE = "userType";
	public static final String PROP_USERNAME = "username";
	public static final String PROP_STATUS = "status";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_REAL_NAME = "realName";
	public static final String PROP_NICKNAME = "nickname";
	public static final String PROP_ROLES = "roles";
	public static final String PROP_ROLE_IDS = "roleIds";
	public static final String PROP_BUILT_IN = "builtIn";
	public static final String PROP_OWNER_ID = "ownerId";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_LOGIN_TIME = "loginTime";
	//endregion


	//region properties
	/** sys_user id */
	private Integer id;
	/** 玩家类型 */
	private String userType;
	/** 用户名 */
	private String username;
	/** sys_user 状态 */
	private String status;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 真实姓名 */
	private String realName;
	/**  */
	private String nickname;
	/** 角色name json */
	private Object roles;
	/** 角色id json */
	private Object roleIds;
	/** 是否包含内置角色 */
	private Boolean builtIn;
	/** 拥有者id */
	private Integer ownerId;
	/**  */
	private Integer siteId;
	/**  */
	private java.util.Date loginTime;
	//endregion


	//region constuctors
	public VSubAccount(){
	}

	public VSubAccount(Integer id){
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
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String value) {
		this.userType = value;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String value) {
		this.username = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String value) {
		this.realName = value;
	}
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String value) {
		this.nickname = value;
	}
	public Object getRoles() {
		return this.roles;
	}

	public void setRoles(Object value) {
		this.roles = value;
	}
	public Object getRoleIds() {
		return this.roleIds;
	}

	public void setRoleIds(Object value) {
		this.roleIds = value;
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
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}
	//endregion

	//region your codes 2

	private List<String> roleNames;
	private List<String> roleIdCollection;
	@Nonpersistent
	public List<String> getRoleNames() {
		return JsonTool.fromJson(this.getRoles().toString(),List.class);
//		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public List<String> getRoleIdCollection() {
		return this.getRoleIds() == null ? null : JsonTool.fromJson(this.getRoleIds().toString(),List.class);
	}

	public void setRoleIdCollection(List<String> roleIdCollection) {
		this.roleIdCollection = roleIdCollection;
	}

	//endregion your codes 2

}