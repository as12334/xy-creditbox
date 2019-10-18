package so.wwb.creditbox.model.manager.site.po;

import org.soul.commons.bean.IEntity;


/**
 * 币种表实体
 *
 * @author jerry
 * @tableAuthor lorne
 * @time 2017-4-7 10:02:33
 */
//region your codes 1
public class SiteCurrency implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 431569289260757431L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_CODE = "code";
	public static final String PROP_STATUS = "status";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 站点ID */
	private Integer siteId;
	/** 币种字典 */
	private String code;
	/** 状态（0未使用；1使用中；2已停用） */
	private String status;
	//endregion

	
	//region constuctors
	public SiteCurrency(){
	}

	public SiteCurrency(Integer id){
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
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}