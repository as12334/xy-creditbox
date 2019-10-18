package so.wwb.creditbox.model.manager.site.po;

import org.soul.commons.bean.IEntity;
import org.soul.commons.cache.CacheKey;
import org.soul.commons.support.Nonpersistent;

//region your codes 1
public class SiteI18n implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 7418981038168729799L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_MODULE = "module";
	public static final String PROP_TYPE = "type";
	public static final String PROP_KEY = "key";
	public static final String PROP_LOCALE = "locale";
	public static final String PROP_VALUE = "value";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_REMARK = "remark";
	public static final String PROP_DEFAULT_VALUE = "defaultValue";
	public static final String PROP_BUILT_IN = "builtIn";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/** 模块编号 */
	private String module;
	/** 国际化信息类型 */
	private String type;
	/** 国际化key */
	private String key;
	/** 两位小写语言代码_两位大写国家代码 */
	private String locale;
	/** 国际化后的值 */
	private String value;
	/** 站点id */
	private Integer siteId;
	/** 备注 */
	private String remark;
	/** 默认值 */
	private String defaultValue;
	/** 是否内置 */
	private Boolean builtIn;

	//endregion

	
	//region constuctors
	public SiteI18n(){
	}

	public SiteI18n(Integer id){
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
	@org.soul.model.common.Sortable
	public String getModule() {
		return this.module;
	}

	public void setModule(String value) {
		this.module = value;
	}
	@org.soul.model.common.Sortable
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	@org.soul.model.common.Sortable
	public String getKey() {
		return this.key;
	}

	public void setKey(String value) {
		this.key = value;
	}
	@org.soul.model.common.Sortable
	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String value) {
		this.locale = value;
	}
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Integer value) {
		this.siteId = value;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String value) {
		this.remark = value;
	}
	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}
	public Boolean getBuiltIn() {
		return this.builtIn;
	}

	public void setBuiltIn(Boolean value) {
		this.builtIn = value;
	}
	//endregion

	//region your codes 2
	/** 一个游戏分类对应的多个contractOccupyApi */
	public static final String PROP_CACHE_KEY = "cacheKey";
	public static final String PROP_CACHE_KEY_LOCALE = "cacheKeyLocale";

	@Nonpersistent
	public String getCacheKey(){
		return CacheKey.getCacheKey(String.valueOf(siteId),getModule(), getType());
	}
	@Nonpersistent
	public String getCacheKeyLocale(){
		return CacheKey.getCacheKey(getKey(),getLocale());
	}


	//endregion your codes 2

}