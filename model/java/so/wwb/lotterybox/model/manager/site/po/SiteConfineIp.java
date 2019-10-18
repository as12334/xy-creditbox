package so.wwb.lotterybox.model.manager.site.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.net.IpTool;
import org.soul.commons.support.Nonpersistent;
import so.wwb.lotterybox.model.constants.common.Const;
import so.wwb.lotterybox.model.enums.site.SiteConfineIpTypeEnum;

import java.util.Date;


/**
 * 限制/允许访问站点/管理中心的IP表实体
 *
 * @author tony
 * @tableAuthor lorne
 * @time 2015-11-13 16:25:18
 */
//region your codes 1
public class SiteConfineIp implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4617909879572433552L;
	public static final String PROP_STATUS = "status";
	/**
	 *状态 using：使用中，false：已过期
	 */
	private String status;
	/** 起始IP */
	private String startIpStr;
	/** 结束IP */
	private String endIpStr;
	/**IP查询这段**/
	private String searchIp;
	/** 当前时间**/
	private Date newDate;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_TIME_TYPE = "timeType";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_END_TIME = "endTime";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_TYPE = "type";
	public static final String PROP_START_IP = "startIp";
	public static final String PROP_END_IP = "endIp";
	public static final String PROP_REMARK = "remark";
	//endregion


	//region properties
	/** 主键 */
	private Integer id;
	/** 站点ID */
	private Integer siteId;
	/** 限制时间（1 永久限制；2 7天；3 15天；4 一个月；5 3个月；6 半年；7 1年；8自定义） */
	private String timeType;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 截止时间 */
	private java.util.Date endTime;
	/** 创建人会员号 */
	private Integer createUser;
	/** 类型（1限制访问站点；2允许访问站点；3允许访问管理中心） */
	private String type;
	/** 起始IP */
	private Long startIp;
	/** 结束IP */
	private Long endIp;
	/** 备注 */
	private String remark;
	//endregion


	//region constuctors
	public SiteConfineIp(){
	}

	public SiteConfineIp(Integer id){
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
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getTimeType() {
		return this.timeType;
	}

	public void setTimeType(String value) {
		this.timeType = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	public java.util.Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(java.util.Date value) {
		this.endTime = value;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	public Long getStartIp() {
		return this.startIp;
	}

	public void setStartIp(Long value) {
		this.startIp = value;
		this.startIpStr = IpTool.ipv4LongToString(value);
	}
	public Long getEndIp() {
		return this.endIp;
	}

	public void setEndIp(Long value) {
		this.endIp = value;
		this.endIpStr = IpTool.ipv4LongToString(value);
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	//endregion

	//region your codes 2
	@Nonpersistent
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Nonpersistent
	public String getEndIpStr() {
		return endIpStr;
	}

	public void setEndIpStr(String endIpStr) {
		this.endIpStr = endIpStr;
		this.endIp = IpTool.ipv4StringToLong(endIpStr);
	}
	@Nonpersistent
	public String getStartIpStr() {
		return startIpStr;
	}

	public void setStartIpStr(String startIpStr) {
		this.startIpStr = startIpStr;
		this.startIp = IpTool.ipv4StringToLong(startIpStr);
	}
	@Nonpersistent
	public String getSearchIp() {
		return searchIp;
	}

	public void setSearchIp(String searchIp) {
		this.searchIp = searchIp;
	}
	@Nonpersistent
	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	/**
	 * 是否允许访问
	 * @param ip
	 * @return
	 * @author Longer
	 */
	public boolean isAllowAccess(long ip,SiteConfineIpTypeEnum typeEnum) {
		boolean inRange = isInRange(ip);
		switch (typeEnum) {
			case CENTER_ALLOW:
				return inRange;
			case SITE_ALLOW:
				return inRange;
			case SITE_DENY:
				return !inRange;
			default:
				return true;
		}
	}

	/**
	 * 是否在区间内
	 * @param ip
	 * @return
	 * @author Longer
	 */
	public boolean isInRange(long ip) {
		if (getStartIp() == null || getEndIp() == null) {
			return false;
		}
		if (getStartIp() <= ip && ip <= getEndIp()) {
			Date now = new Date();
			Date s = getCreateTime();
			Date e = getEndTime();
			if (s == null){
				s = Const.Platform_Begin_Date;
			}
			if (e == null) {
				e = Const.Platform_Forever_Date;
			}
            return s.before(now) && e.after(now);
		}
		return false;
	}
	//endregion your codes 2

}