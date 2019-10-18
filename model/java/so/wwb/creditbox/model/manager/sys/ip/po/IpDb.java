package so.wwb.creditbox.model.manager.sys.ip.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.common.Sortable;
import org.soul.model.ip.IpBean;

//region your codes 1
public class IpDb implements IEntity<Long>,IpBean {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -1652279547665831384L;
	public static final IpDb NULL = new IpDb(false);
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_IP_START = "ipStart";
	public static final String PROP_IP_END = "ipEnd";
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
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_AMEND_IP = "amendIp";
	public static final String PROP_IP_START_STR = "ipStartStr";
	public static final String PROP_IP_END_STR = "ipEndStr";
	//endregion

	//region properties
	/** 主键 */
	private Long id;
	/** ip段起 */
	private Long ipStart;
	/** ip段止 */
	private Long ipEnd;
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
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 修正IP */
	private Boolean amendIp;
	/** 开始IP字符串 */
	private String ipStartStr;
	/** 截止IP字符串 */
	private String ipEndStr;
	//endregion

	//region constuctors
	public IpDb(){
	}

	public IpDb(Long id){
		this.id = id;
	}
	//endregion

	//region getters and setters
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long value) {
		this.id = value;
	}
	@Sortable
	public Long getIpStart() {
		return this.ipStart;
	}

	public void setIpStart(Long value) {
		this.ipStart = value;
	}
	public Long getIpEnd() {
		return this.ipEnd;
	}

	public void setIpEnd(Long value) {
		this.ipEnd = value;
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
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public Boolean getAmendIp() {
		return amendIp;
	}

	public void setAmendIp(Boolean amendIp) {
		this.amendIp = amendIp;
	}

	public String getIpStartStr() {
		return ipStartStr;
	}

	public void setIpStartStr(String ipStartStr) {
		this.ipStartStr = ipStartStr;
	}

	public String getIpEndStr() {
		return ipEndStr;
	}

	public void setIpEndStr(String ipEndStr) {
		this.ipEndStr = ipEndStr;
	}
	//endregion

	//region your codes 2
	public IpDb(boolean isInDb){
		this.isInDb = false;
	}

	//默认查询结果都是存在ip库里的
	private boolean isInDb = true;
	private boolean isAmend;
	private long ip;
    private boolean isAllowAccess;
	private boolean isAllowAccessSwitch;

	@Nonpersistent
	public boolean isAmend() {
		return isAmend;
	}

	public void setIsAmend(boolean isAmend) {
		this.isAmend = isAmend;
	}

	@Nonpersistent
	@Override
	public long getIp() {
		return ip;
	}

	public void setIp(long ip) {
		this.ip = ip;
	}

	@Nonpersistent
	@Override
	public boolean isAllowAccess() {
		return isAllowAccess;
	}

	@Override
	public void setAllowAccess(boolean isAllowAccess) {
		this.isAllowAccess = isAllowAccess;
	}

	@Nonpersistent
	@Override
	public boolean isAllowAccessSwitch() {
		return isAllowAccessSwitch;
	}

	@Override
	public void setAllowAccessSwitch(boolean isAllowAccessSwitch) {
		this.isAllowAccessSwitch = isAllowAccessSwitch;
	}

	public boolean isInDb() {
		return isInDb;
	}

	public void setIsInDb(boolean isInDb) {
		this.isInDb = isInDb;
	}

	//endregion your codes 2
}