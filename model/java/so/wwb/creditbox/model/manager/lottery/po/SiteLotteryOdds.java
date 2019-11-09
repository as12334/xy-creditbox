package so.wwb.creditbox.model.manager.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-11-9 22:23:11
 */
//region your codes 1
public class SiteLotteryOdds implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -4878812135951948164L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_SITE_ID = "siteId";
	public static final String PROP_HID = "hid";
	public static final String PROP_CODE = "code";
	public static final String PROP_BET_NAME = "betName";
	public static final String PROP_BET_CODE = "betCode";
	public static final String PROP_PLAY_CODE = "playCode";
	public static final String PROP_BET_NUM = "betNum";
	public static final String PROP_SORT = "sort";
	public static final String PROP_ODD_A = "oddA";
	public static final String PROP_ODD_B = "oddB";
	public static final String PROP_ODD_C = "oddC";
	public static final String PROP_MIN_ODD = "minOdd";
	public static final String PROP_MAX_ODD = "maxOdd";
	public static final String PROP_ODD_CLOSE = "oddClose";
	public static final String PROP_BET_SORT = "betSort";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private Integer siteId;
	/**  */
	private String hid;
	/**  */
	private String code;
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
	private Double oddA;
	/**  */
	private Double oddB;
	/**  */
	private Double oddC;
	/**  */
	private Double minOdd;
	/**  */
	private Double maxOdd;
	/**  */
	private Boolean oddClose;
	/**  */
	private String betSort;
	//endregion

	
	//region constuctors
	public SiteLotteryOdds(){
	}

	public SiteLotteryOdds(Integer id){
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
	public String getHid() {
		return this.hid;
	}

	public void setHid(String value) {
		this.hid = value;
	}
	public String getCode() {
		return this.code;
	}

	public void setCode(String value) {
		this.code = value;
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
	public Double getOddA() {
		return this.oddA;
	}

	public void setOddA(Double value) {
		this.oddA = value;
	}
	public Double getOddB() {
		return this.oddB;
	}

	public void setOddB(Double value) {
		this.oddB = value;
	}
	public Double getOddC() {
		return this.oddC;
	}

	public void setOddC(Double value) {
		this.oddC = value;
	}
	public Double getMinOdd() {
		return this.minOdd;
	}

	public void setMinOdd(Double value) {
		this.minOdd = value;
	}
	public Double getMaxOdd() {
		return this.maxOdd;
	}

	public void setMaxOdd(Double value) {
		this.maxOdd = value;
	}
	public Boolean getOddClose() {
		return this.oddClose;
	}

	public void setOddClose(Boolean value) {
		this.oddClose = value;
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