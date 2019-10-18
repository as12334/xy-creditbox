package so.wwb.lotterybox.model.manager.sys.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 站点分组表实体
 *
 * @author steady
 * @time 2018-9-10 16:24:29
 */
public class SysSiteGroup implements IEntity<Integer> {
	private static final long serialVersionUID = 6725264603438246620L;
	public static final String PROP_ID = "id";
	public static final String PROP_NAME = "name";
	public static final String PROP_CODE = "code";
	public static final String PROP_TYPE = "type";
	public static final String PROP_SITES = "sites";
	public static final String PROP_UPDATE_TIME = "updateTime";
	public static final String PROP_UPDATE_USERNAME = "updateUsername";

	/** 主键 */
	private Integer id;
	/** 名称 */
	private String name;
	/** 代号 */
	private String code;
	/** 类型 */
	private String type;
	/** 商户ID */
	private Integer[] sites;
	/** 最新修改时间 */
	private java.util.Date updateTime;
	/** 最新修改人 */
	private String updateUsername;

	public SysSiteGroup(){
	}

	public SysSiteGroup(Integer id){
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	@Sortable
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	@Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	@Sortable
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}

	@Sortable
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	public String getUpdateUsername() {
		return this.updateUsername;
	}

	public void setUpdateUsername(String value) {
		this.updateUsername = value;
	}

	public Integer[] getSites() {
		return sites;
	}

	public void setSites(Integer[] sites) {
		this.sites = sites;
	}

}