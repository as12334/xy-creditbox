package so.wwb.creditbox.model.manager.lottery.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;

/**
 * 六合彩生肖表实体
 *
 * @author zain
 * @time 2017-8-9 11:01:20
 */
//region your codes 1
public class LotteryLhcZodiac implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -8745780782797391629L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_ZODIAC_NAME = "zodiacName";
	public static final String PROP_ZODIAC_NUM = "zodiacNum";
	public static final String PROP_UPDATE_TIME = "updateTime";
	//endregion


	//region properties
	/** 主键 */
	private Integer id;
	/** 生肖名称 */
	private String zodiacName;
	/** 生肖数字 */
	private String zodiacNum;
	/** 修改时间 */
	private java.util.Date updateTime;
	//endregion


	//region constuctors
	public LotteryLhcZodiac(){
	}

	public LotteryLhcZodiac(Integer id){
		this.id = id;
	}
	//endregion


	//region getters and setters
	@Sortable
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	public String getZodiacName() {
		return this.zodiacName;
	}

	public void setZodiacName(String value) {
		this.zodiacName = value;
	}
	@Sortable
	public String getZodiacNum() {
		return this.zodiacNum;
	}

	public void setZodiacNum(String value) {
		this.zodiacNum = value;
	}
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}