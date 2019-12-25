package so.wwb.creditbox.model.company.user.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-25 11:57:09
 */
//region your codes 1
public class CzUsersChild implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -421973132662435086L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_UID = "uid";
	public static final String PROP_UNAME = "uname";
	public static final String PROP_UPSW = "upsw";
	public static final String PROP_SALT = "salt";
	public static final String PROP_UNICKER = "unicker";
	public static final String PROP_USKIN = "uskin";
	public static final String PROP_PARENT_UNAME = "parentUname";
	public static final String PROP_ADD_DATE = "addDate";
	public static final String PROP_STATUS = "status";
	public static final String PROP_IS_CHANGED = "isChanged";
	public static final String PROP_LAST_CHANGED_DATE = "lastChangedDate";
	public static final String PROP_RETRY_TIMES = "retryTimes";
	public static final String PROP_PERMISSIONS_NAME = "permissionsName";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String uid;
	/**  */
	private String uname;
	/**  */
	private String upsw;
	/**  */
	private String salt;
	/**  */
	private String unicker;
	/**  */
	private String uskin;
	/**  */
	private String parentUname;
	/**  */
	private java.util.Date addDate;
	/**  */
	private String status;
	/**  */
	private String isChanged;
	/**  */
	private java.util.Date lastChangedDate;
	/**  */
	private Integer retryTimes;
	/**  */
	private String permissionsName;
	//endregion

	
	//region constuctors
	public CzUsersChild(){
	}

	public CzUsersChild(Integer id){
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
	public String getUid() {
		return this.uid;
	}

	public void setUid(String value) {
		this.uid = value;
	}
	public String getUname() {
		return this.uname;
	}

	public void setUname(String value) {
		this.uname = value;
	}
	public String getUpsw() {
		return this.upsw;
	}

	public void setUpsw(String value) {
		this.upsw = value;
	}
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String value) {
		this.salt = value;
	}
	public String getUnicker() {
		return this.unicker;
	}

	public void setUnicker(String value) {
		this.unicker = value;
	}
	public String getUskin() {
		return this.uskin;
	}

	public void setUskin(String value) {
		this.uskin = value;
	}
	public String getParentUname() {
		return this.parentUname;
	}

	public void setParentUname(String value) {
		this.parentUname = value;
	}
	public java.util.Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(java.util.Date value) {
		this.addDate = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getIsChanged() {
		return this.isChanged;
	}

	public void setIsChanged(String value) {
		this.isChanged = value;
	}
	public java.util.Date getLastChangedDate() {
		return this.lastChangedDate;
	}

	public void setLastChangedDate(java.util.Date value) {
		this.lastChangedDate = value;
	}
	public Integer getRetryTimes() {
		return this.retryTimes;
	}

	public void setRetryTimes(Integer value) {
		this.retryTimes = value;
	}
	public String getPermissionsName() {
		return this.permissionsName;
	}

	public void setPermissionsName(String value) {
		this.permissionsName = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}