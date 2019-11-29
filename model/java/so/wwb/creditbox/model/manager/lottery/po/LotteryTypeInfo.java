package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-11-29 21:17:34
 */
//region your codes 1
public class LotteryTypeInfo implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4476604066118114897L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_TYPE = "type";
	public static final String PROP_BET_NAME = "betName";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_SORT = "sort";
	public static final String PROP_BET_SORT = "betSort";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String type;
	/**  */
	private String betName;
	/**  */
	private String betCode;
	/**  */
	private Integer playCode;
	/**  */
	private String betNum;
	/**  */
	private Integer sort;
	/**  */
	private String betSort;
	//endregion

	
	//region constuctors
	public LotteryTypeInfo(){
	}

	public LotteryTypeInfo(Integer id){
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
	public String getBetName() {
		return this.betName;
	}

	public void setBetName(String value) {
		this.betName = value;
	}
	public String getBetCode() {
		return this.betCode;
	}

	public void setBetCode(String value) {
		this.betCode = value;
	}
	public Integer getPlayCode() {
		return this.playCode;
	}

	public void setPlayCode(Integer value) {
		this.playCode = value;
	}
	public String getBetNum() {
		return this.betNum;
	}

	public void setBetNum(String value) {
		this.betNum = value;
	}
	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer value) {
		this.sort = value;
	}
	public String getBetSort() {
		return this.betSort;
	}

	public void setBetSort(String value) {
		this.betSort = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}