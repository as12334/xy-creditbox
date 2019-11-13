package so.wwb.creditbox.model.company.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 站点彩票实体
 *
 * @author block
 * @time 2019-10-23 22:20:43
 */
//region your codes 1
public class SiteLottery implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -6192168340361798234L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_CODE = "code";
	public static final String PROP_NAME = "name";
	public static final String PROP_STATUS = "status";
	public static final String PROP_ORDER_NUM = "orderNum";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_TYPE = "type";
	public static final String PROP_GENRE = "genre";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 站点id */
	private Integer siteId;
	/** 彩种 */
	private String code;
	/** 名称 */
	private String name;
	/**  */
	private String status;
	/** 顺序 */
	private Integer orderNum;
	/** 终端 */
	private String terminal;
	/** 彩种类型 */
	private String type;
	/** 类型(1.全部2.官方玩法3.双面玩法) */
	private Integer genre;
	//endregion

	
	//region constuctors
	public SiteLottery(){
	}

	public SiteLottery(Integer id){
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
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}
	@org.soul.model.common.Sortable
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer value) {
		this.orderNum = value;
	}
	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String value) {
		this.terminal = value;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	public Integer getGenre() {
		return this.genre;
	}

	public void setGenre(Integer value) {
		this.genre = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}