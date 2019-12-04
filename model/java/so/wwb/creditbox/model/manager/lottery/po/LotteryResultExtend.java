package so.wwb.creditbox.model.manager.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-4 23:53:22
 */
//region your codes 1
public class LotteryResultExtend implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -8976729013656262292L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_RESULT_ID = "resultId";
	public static final String PROP_EXPECT = "expect";
	public static final String PROP_CODE = "code";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_SORT = "sort";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private Integer resultId;
	/**  */
	private String expect;
	/**  */
	private String code;
	/**  */
	private String betCode;
	/**  */
	private String playCode;
	/**  */
	private String betNum;
	/**  */
	private Integer sort;
	//endregion

	
	//region constuctors
	public LotteryResultExtend(){
	}

	public LotteryResultExtend(Integer id){
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
	public Integer getResultId() {
		return this.resultId;
	}

	public void setResultId(Integer value) {
		this.resultId = value;
	}
	public String getExpect() {
		return this.expect;
	}

	public void setExpect(String value) {
		this.expect = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
	}
	public String getBetCode() {
		return this.betCode;
	}

	public void setBetCode(String value) {
		this.betCode = value;
	}
	public String getPlayCode() {
		return this.playCode;
	}

	public void setPlayCode(String value) {
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
	//endregion

	//region your codes 2

	//endregion your codes 2

}