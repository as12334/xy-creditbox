package so.wwb.creditbox.model.manager.lottery.po;

import java.util.Date;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 彩种表实体
 *
 * @author block
 * @time 2019-10-20 23:40:18
 */
//region your codes 1
public class Lottery implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -8185970038395576616L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_TYPE = "type";
	public static final String PROP_CODE = "code";
	public static final String PROP_NAME = "name";
	public static final String PROP_STATUS = "status";
	public static final String PROP_ORDER_NUM = "orderNum";
	public static final String PROP_TERMINAL = "terminal";
	public static final String PROP_GENRE = "genre";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 彩种类型 */
	private String type;
	/** 彩种代号 */
	private String code;
	/** 彩种名称 */
	private String name;
	/** 彩种状态:正常,维护 */
	private String status;
	/** 序号 */
	private Integer orderNum;
	/** 支持终端：0-全部终端,1-PC,2-移动 */
	private String terminal;
	/** 类型(1.全部2.官方玩法3.雙面玩法) */
	private Integer genre;
	//endregion

	
	//region constuctors
	public Lottery(){
	}

	public Lottery(Integer id){
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
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
	@org.soul.model.common.Sortable
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String value) {
		this.name = value;
	}
	@org.soul.model.common.Sortable
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
	@org.soul.model.common.Sortable
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