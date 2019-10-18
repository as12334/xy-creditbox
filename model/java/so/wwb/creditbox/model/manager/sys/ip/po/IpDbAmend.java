package so.wwb.creditbox.model.manager.sys.ip.po;

import org.soul.commons.bean.IEntity;


/**
 * IP数据库-修正库实体
 *
 * @author longer
 * @tableAuthor Longer
 * @time Dec 8, 2015 11:04:54 AM
 */
//region your codes 1
public class IpDbAmend implements IEntity<Long> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 5189323656978612850L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_IP = "ip";
	public static final String PROP_ADDR_TYPE = "addrType";
	public static final String PROP_LAND = "land";
	public static final String PROP_COUNTRY = "country";
	public static final String PROP_STATEPROV = "stateprov";
	public static final String PROP_CITY = "city";
	public static final String PROP_CODE = "code";
	public static final String PROP_LATITUDE = "latitude";
	public static final String PROP_LONGITUDE = "longitude";
	public static final String PROP_TIMEZONE_OFFSET = "timezoneOffset";
	public static final String PROP_TIMEZONE_NAME = "timezoneName";
	public static final String PROP_ISP_NAME = "ispName";
	public static final String PROP_CONNECTION_TYPE = "connectionType";
	public static final String PROP_ORGANIZATION_NAME = "organizationName";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_USER = "updateUser";
	public static final String PROP_UPDATE_TIME = "updateTime";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Long id;
	/** ip */
	private Long ip;
	/** IP类型: 1:ipv4 2:ipv6 */
	private String addrType;
	/** 大洲 */
	private String land;
	/** 国家代码(2位) */
	private String country;
	/** 州|省 */
	private String stateprov;
	/** 城市 */
	private String city;
	/** 邮编 */
	private String code;
	/** 纬度 */
	private Double latitude;
	/** 经度 */
	private Double longitude;
	/** 时区偏移 */
	private Double timezoneOffset;
	/** 时区类型 */
	private String timezoneName;
	/** isp名称 */
	private String ispName;
	/** 连接类型:dialup','isdn','cable','dsl','fttx','wireless */
	private String connectionType;
	/** 组织名称 */
	private String organizationName;
	/** 站点ID */
	private Integer siteId;
	/** 创建用户 */
	private Integer createUser;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新用户 */
	private Integer updateUser;
	/** 更新时间 */
	private java.util.Date updateTime;
	//endregion

	
	//region constuctors
	public IpDbAmend(){
	}

	public IpDbAmend(Long id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	public Long getId() {
		return this.id;
	}

	public void setId(Long value) {
		this.id = value;
	}
	public Long getIp() {
		return this.ip;
	}

	public void setIp(Long value) {
		this.ip = value;
	}
	public String getAddrType() {
		return this.addrType;
	}

	public void setAddrType(String value) {
		this.addrType = value;
	}
	public String getLand() {
		return this.land;
	}

	public void setLand(String value) {
		this.land = value;
	}
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String value) {
		this.country = value;
	}
	public String getStateprov() {
		return this.stateprov;
	}

	public void setStateprov(String value) {
		this.stateprov = value;
	}
	public String getCity() {
		return this.city;
	}

	public void setCity(String value) {
		this.city = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double value) {
		this.latitude = value;
	}
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double value) {
		this.longitude = value;
	}
	public Double getTimezoneOffset() {
		return this.timezoneOffset;
	}

	public void setTimezoneOffset(Double value) {
		this.timezoneOffset = value;
	}
	public String getTimezoneName() {
		return this.timezoneName;
	}

	public void setTimezoneName(String value) {
		this.timezoneName = value;
	}
	public String getIspName() {
		return this.ispName;
	}

	public void setIspName(String value) {
		this.ispName = value;
	}
	public String getConnectionType() {
		return this.connectionType;
	}

	public void setConnectionType(String value) {
		this.connectionType = value;
	}
	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String value) {
		this.organizationName = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
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
	//endregion

	//region your codes 2

	//endregion your codes 2

}