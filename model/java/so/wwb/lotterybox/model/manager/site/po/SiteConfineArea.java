package so.wwb.lotterybox.model.manager.site.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.support.Nonpersistent;
import org.soul.model.ip.IpBean;

import java.util.Date;


/**
 * 限制访问站点的地区表实体
 *
 * @author tony
 * @tableAuthor lorne
 * @time 2015-11-19 15:26:50
 */
//region your codes 1
public class SiteConfineArea implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -6312800529131377602L;
	public static final String PROP_STATUS = "status";
	/**
	 *状态 using：使用中，false：已过期
	 */
	private String status;

	private Date newDate;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_TIME_TYPE = "timeType";
	public static final String PROP_CREATE_TIME = "createTime";
	public static final String PROP_END_TIME = "endTime";
	public static final String PROP_CREATE_USER = "createUser";
	public static final String PROP_NATION = "nation";
	public static final String PROP_PROVINCE = "province";
	public static final String PROP_CITY = "city";
	public static final String PROP_DELTA = "delta";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_BUILT_IN = "builtIn";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 站点ID */
	private Integer siteId;
	/** 限制时间（1 永久限制；2 7天；3 15天；4 一个月；5 3个月；6 半年；7 1年；8自定义） */
	private String timeType;
	/** 创建时间 */
	private Date createTime;
	/** 截止时间 */
	private Date endTime;
	/** 创建人会员号 */
	private Integer createUser;
	/** 国家 */
	private String nation;
	/** 省/州 */
	private String province;
	/** 市 */
	private String city;
	/** 洲 */
	private String delta;
	/** 备注 */
	private String remark;
	/**是否内置*/
	private boolean builtIn;
	//endregion

	
	//region constuctors
	public SiteConfineArea(){
	}

	public SiteConfineArea(Integer id){
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
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date value) {
		this.endTime = value;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer value) {
		this.createUser = value;
	}
	public String getNation() {
		return this.nation;
	}

	public void setNation(String value) {
		this.nation = value;
	}
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String value) {
		this.province = value;
	}
	public String getCity() {
		return this.city;
	}

	public void setCity(String value) {
		this.city = value;
	}
	public String getDelta() {
		return this.delta;
	}

	public void setDelta(String value) {
		this.delta = value;
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
	public Date getNewDate() {
		return newDate;
	}

	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}

	public boolean getBuiltIn() {
		return builtIn;
	}

	public void setBuiltIn(boolean builtIn) {
		this.builtIn = builtIn;
	}

	/**
	 * 是否在区域内
	 * @param ipBean
	 * @return
	 * @author Longer
	 */
//	public boolean isInRange(IpBean ipBean){
//		if (this.endTime == null){
//			return false;
//		}
//		Date now = new Date();
//		if (now.after(this.endTime)){
//			return false;
//		}
//
//		/*if (StringTool.isBlank(this.getCity())
//				&& StringTool.isBlank(this.getProvince())
//				&& StringTool.isBlank(this.getNation())
//				&& StringTool.isBlank(this.getDelta())
//		) {
//			return false;
//		}*/
//
//		if (StringTool.isNotBlank(ipBean.getCountry())){
//			if (!ipBean.getCountry().equals(this.getNation())) {
//				return false;
//			}
//		}
//		if (StringTool.isNotBlank(ipBean.getCity())){
//			if (!ipBean.getCity().equals(this.getCity())) {
//				return false;
//			}
//		}
//		if (StringTool.isNotBlank(ipBean.getStateprov())){
//			if (!ipBean.getStateprov().equals(this.getProvince())) {
//				return false;
//			}
//		}
//
//		/*if (StringTool.isNotBlank(ipBean.getLand())){
//			if (!ipBean.getCountry().equals(this.getDelta())) {
//				return false;
//			}
//		}*/
//		return true;
//	}

	/**
	 * 是否在区域内
	 * @param ipBean
	 * @return
	 * @author Longer
	 */
	public boolean isInRange(IpBean ipBean){
		if (this.endTime == null){
			return false;
		}
		Date now = new Date();
		if (now.after(this.endTime)){
			return false;
		}

		if (StringTool.isBlank(ipBean.getCity())
				&& StringTool.isBlank(ipBean.getCountry())
				&& StringTool.isBlank(ipBean.getStateprov())
				&& StringTool.isBlank(ipBean.getLand())
				) {
			return false;
		}

		if ((StringTool.isNotBlank(ipBean.getCountry()) && ipBean.getCountry().equals(this.getNation()))
				&& ((StringTool.isNotBlank(ipBean.getStateprov()) && ipBean.getStateprov().equals(this.getProvince())) || StringTool.isBlank(this.getProvince()))
				&& ((StringTool.isNotBlank(ipBean.getCity()) && ipBean.getCity().equals(this.getCity())) || StringTool.isBlank(this.getCity())))
		{
			return true;
		}
		return false;
	}
	//endregion your codes 2

}