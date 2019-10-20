package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 彩种玩法表实体
 *
 * @author block
 * @time 2019-10-20 22:59:01
 */
//region your codes 1
public class LotteryPlay implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = 8706861069389335681L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_TYPE = "type";
	public static final String PROP_CODE = "code";
	public static final String PROP_NAME = "name";
	//endregion
	
	
	//region properties
	/** 主键 */
	private Integer id;
	/** 彩种类型 */
	private String type;
	/** 彩种玩法代号 */
	private String code;
	/** 玩法名称 */
	private String name;
	//endregion

	
	//region constuctors
	public LotteryPlay(){
	}

	public LotteryPlay(Integer id){
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
	public String getType() {
		return this.type;
	}

	public void setType(String value) {
		this.type = value;
	}
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
	//endregion

	//region your codes 2

	//endregion your codes 2

}