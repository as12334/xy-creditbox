package so.wwb.creditbox.model.company.lottery.po;


import org.soul.commons.bean.IEntity;
import org.soul.commons.support.Nonpersistent;
import so.wwb.creditbox.model.manager.user.po.SysUserExtend;


/**
 * 实体
 *
 * @author block
 * @time 2019-11-14 2:27:09
 */
//region your codes 1
public class parendOdds implements IEntity<Integer> {
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
	public static final String PROP_SORT_TYPE = "sortType";
	//endregion


	//region properties
	/**  */
	private Integer id;
	/**  */
	private String hid;
	/**  */
	private String code;
	/**  */
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
	//endregion



	//region getters and setters

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Double getOddA() {
		return oddA;
	}

	public void setOddA(Double oddA) {
		this.oddA = oddA;
	}

	public Double getOddB() {
		return oddB;
	}

	public void setOddB(Double oddB) {
		this.oddB = oddB;
	}

	public Double getOddC() {
		return oddC;
	}

	public void setOddC(Double oddC) {
		this.oddC = oddC;
	}

	public Double getMinOdd() {
		return minOdd;
	}

	public void setMinOdd(Double minOdd) {
		this.minOdd = minOdd;
	}

	public Double getMaxOdd() {
		return maxOdd;
	}

	public void setMaxOdd(Double maxOdd) {
		this.maxOdd = maxOdd;
	}


	//endregion your codes 2

}