package so.wwb.creditbox.model.common;

import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;


/**
 * 限制/允许访问站点/管理中心的IP表实体
 *
 * @author loong
 * @tableAuthor lorne
 * @time 2015-8-11 11:18:00
 */
//region your codes 1
public class FieldSort implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 3109324302307230775L;
	public static final String PROP_ID = "id";
	public static final String PROP_NAME = "name";
	public static final String PROP_IS_REQUIRED = "isRequired";
	public static final String PROP_STATUS = "status";
	public static final String PROP_IS_REGFIELD = "isRegField";
	public static final String PROP_BULIT_IN = "bulitIn";
	public static final String PROP_SORT = "sort";
	public static final String PROP_DERAIL = "derail";
	private Integer id;
	//名称
	private String name;
	//0：默认必填　１：是　　２：否
	private String isRequired;
	//0:没有开关 1：启用 2：停用
	private String status;
	//0：默认注册项　１：是　　２：否
	private String isRegField;
	//是否内置
	private boolean bulitIn;
	//排序
	private Integer sort;
	//是否需要开关
	private boolean derail;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isBulitIn() {
		return bulitIn;
	}

	public void setBulitIn(boolean bulitIn) {
		this.bulitIn = bulitIn;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsRegField() {
		return isRegField;
	}

	public void setIsRegField(String isRegField) {
		this.isRegField = isRegField;
	}

	public boolean isDerail() {
		return derail;
	}

	public void setDerail(boolean derail) {
		this.derail = derail;
	}


	//region your codes 2
	/*国际化后的字段名*/
	private String i18nName;

	@Nonpersistent
	public String getI18nName() {
		return i18nName;
	}

	public void setI18nName(String i18nName) {
		this.i18nName = i18nName;
	}
	//endregion your codes 2
}