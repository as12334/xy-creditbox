package so.wwb.lotterybox.model.manager.site.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;


/**
 * 站点语言表实体
 *
 * @author tony
 * @tableAuthor lorne
 * @time 2015-11-13 16:23:49
 */
//region your codes 1
public class SiteLanguage implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -2586357097850780708L;
	/** 临时字段：是否编辑过 */
	private Boolean isEdit;
	/**
	 * 临时字段:是否可关闭；
	 */
	private boolean isClose;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_LANGUAGE = "language";
	public static final String PROP_STATUS = "status";
	public static final String PROP_LOGO = "logo";
	public static final String PROP_OPEN_TIME = "openTime";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 站点id */
	private Integer siteId;
	/** 字典 common  language */
	private String language;
	/** 状态（0未使用；1使用中；2已停用） */
	private String status;
	/** 图标url */
	private String logo;
	/** 开启时间 */
	private java.util.Date openTime;
	//endregion

	
	//region constuctors
	public SiteLanguage(){
	}

	public SiteLanguage(Integer id){
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
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String value) {
		this.language = value;
	}
	@org.soul.model.common.Sortable
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String value) {
		this.logo = value;
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
	private String transLangByLocale;
	@Nonpersistent
	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	/*国际化翻译*/
	private String tran;

	@Nonpersistent
	public String getTran() {
		return tran;
	}

	public void setTran(String tran) {
		this.tran = tran;
	}

	@Nonpersistent
	public String getTransLangByLocale() {
		return transLangByLocale;
	}

	public void setTransLangByLocale(String transLangByLocale) {
		this.transLangByLocale = transLangByLocale;
	}

	@Nonpersistent
	public boolean isClose() {
		return isClose;
	}

	public void setClose(boolean close) {
		isClose = close;
	}
}