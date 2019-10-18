package so.wwb.creditbox.model.manager.site.po;


import org.soul.commons.bean.IEntity;


/**
 * 经营地区表实体
 *
 * @author tony
 * @tableAuthor lorne
 * @time 2015-11-13 16:24:12
 */
//region your codes 1
public class SiteOperateArea implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -196207829361836864L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_CODE = "code";
	public static final String PROP_STATUS = "status";
	public static final String PROP_AREA_IP = "areaIp";
	public static final String PROP_OPEN_TIME = "openTime";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 站点ID */
	private Integer siteId;
	/** 字典表 国家 */
	private String code;
	/** 状态（0未使用；1使用中；2已停用） */
	private String status;
	/** IP */
	private String areaIp;
	/** 开通时间 */
	private java.util.Date openTime;
	//endregion

	
	//region constuctors
	public SiteOperateArea(){
	}

	public SiteOperateArea(Integer id){
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
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	@org.soul.model.common.Sortable
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getAreaIp() {
		return this.areaIp;
	}

	public void setAreaIp(String value) {
		this.areaIp = value;
	}
	@org.soul.model.common.Sortable
	public java.util.Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(java.util.Date value) {
		this.openTime = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}