package so.wwb.creditbox.model.manager.sys.po;


import org.soul.commons.bean.IEntity;


/**
 * 角色视图 - jeff实体
 *
 * @author fei
 * @time 2016-5-27 15:10:21
 */
//region your codes 1
public class VSysRole implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3679893867996905924L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_NAME = "name";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_SUBSYS_CODE = "subsysCode";
	public static final String PROP_BUILT_IN = "builtIn";
	public static final String PROP_USER_COUNT = "userCount";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 角色名称 */
	private String name;
	/** 站点ID */
	private Integer siteId;
	/** 系统code */
	private String subsysCode;
	/** 是否内置 */
	private Boolean builtIn;
	/** 使用角色的用户总数 */
	private Long userCount;
	//endregion

	
	//region constuctors
	public VSysRole(){
	}

	public VSysRole(Integer id){
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
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
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
	public Boolean getBuiltIn() {
		return this.builtIn;
	}

	public void setBuiltIn(Boolean value) {
		this.builtIn = value;
	}
	public Long getUserCount() {
		return this.userCount;
	}

	public void setUserCount(Long value) {
		this.userCount = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}