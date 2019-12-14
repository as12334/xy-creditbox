package so.wwb.creditbox.model.company.lottery.po;

import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.enums.lottery.LotteryHandicapEnum;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-13 16:27:08
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
	public static final String PROP_SORT_TYPE = "sortType";
	public static final String PROP_BET_SORT = "betSort";
	public static final String PROP_PAGE_TYPE = "pageType";
	public static final String PROP_ODD_A = "oddA";
	public static final String PROP_ODD_B = "oddB";
	public static final String PROP_ODD_C = "oddC";
	public static final String PROP_MIN_ODD = "minOdd";
	public static final String PROP_MAX_ODD = "maxOdd";
	public static final String PROP_ODD_CLOSE = "oddClose";
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
	private String playCode;
	/**  */
	private String betNum;
	/**  */
	private Integer sort;
	/**  */
	private String sortType;
	/**  */
	private String betSort;
	/**  */
	private String pageType;
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
	private String oddClose;
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
	public String getSortType() {
		return this.sortType;
	}

	public void setSortType(String value) {
		this.sortType = value;
	}
	public String getBetSort() {
		return this.betSort;
	}

	public void setBetSort(String value) {
		this.betSort = value;
	}
	public String getPageType() {
		return this.pageType;
	}

	public void setPageType(String value) {
		this.pageType = value;
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
	public String getOddClose() {
		return this.oddClose;
	}

	public void setOddClose(String value) {
		this.oddClose = value;
	}
	//endregion

	//region your codes 2

	/**
	 * 上级的赔率
	 */

	/**  */
	private Double parentOddA;
	/**  */
	private Double parentOddB;
	/**  */
	private Double parentOddC;

	@Nonpersistent
	public Double getParentOddA() {
		return parentOddA;
	}

	public void setParentOddA(Double parentOddA) {
		this.parentOddA = parentOddA;
	}
	@Nonpersistent
	public Double getParentOddB() {
		return parentOddB;
	}

	public void setParentOddB(Double parentOddB) {
		this.parentOddB = parentOddB;
	}
	@Nonpersistent
	public Double getParentOddC() {
		return parentOddC;
	}

	public void setParentOddC(Double parentOddC) {
		this.parentOddC = parentOddC;
	}

	//获取公司的赔率
	public Double getCOdd(SysUserExtend sessionUser) {
		if(sessionUser.getHandicap().equals(LotteryHandicapEnum.A.getCode())){
			return parentOddA;
		}else if(sessionUser.getHandicap().equals(LotteryHandicapEnum.B.getCode())){
			return parentOddA - parentOddB;
		}else {
			return parentOddA - parentOddC;
		}
	}
	//获取分公司的赔率
	public Double getBOdd(SysUserExtend sessionUser) {
		if(sessionUser.getHandicap().equals(LotteryHandicapEnum.A.getCode())){
			return oddA;
		}else if(sessionUser.getHandicap().equals(LotteryHandicapEnum.B.getCode())){
			return oddA - oddB;
		}else {
			return oddA - oddC;
		}
	}


	//endregion your codes 2

}