package so.wwb.creditbox.model.company.user.po;

import org.soul.commons.bean.IEntity;
import org.soul.model.common.Sortable;


/**
 * 实体
 *
 * @author block
 * @time 2019-12-19 23:20:50
 */
//region your codes 1
public class CzRateKc implements IEntity<Integer> {
//endregion your codes 1

	//region your codes 3
	private static final long serialVersionUID = -1528693190797149395L;
	//endregion your codes 3

	//region property name constants
	public static final String PROP_ID = "id";
	public static final String PROP_UNAME = "uname";
	public static final String PROP_UTYPE = "utype";
	public static final String PROP_DL_NAME = "dlName";
	public static final String PROP_ZD_NAME = "zdName";
	public static final String PROP_GD_NAME = "gdName";
	public static final String PROP_FGS_NAME = "fgsName";
	public static final String PROP_DL_RATE = "dlRate";
	public static final String PROP_ZD_RATE = "zdRate";
	public static final String PROP_GD_RATE = "gdRate";
	public static final String PROP_FGS_RATE = "fgsRate";
	public static final String PROP_ZJ_RATE = "zjRate";
	//endregion
	
	
	//region properties
	/**  */
	private Integer id;
	/**  */
	private String uname;
	/**  */
	private String utype;
	/**  */
	private String dlName;
	/**  */
	private String zdName;
	/**  */
	private String gdName;
	/**  */
	private String fgsName;
	/**  */
	private Integer dlRate;
	/**  */
	private Integer zdRate;
	/**  */
	private Integer gdRate;
	/**  */
	private Integer fgsRate;
	/**  */
	private Integer zjRate;
	//endregion

	
	//region constuctors
	public CzRateKc(){
	}

	public CzRateKc(Integer id){
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
	public String getUname() {
		return this.uname;
	}

	public void setUname(String value) {
		this.uname = value;
	}
	public String getUtype() {
		return this.utype;
	}

	public void setUtype(String value) {
		this.utype = value;
	}
	public String getDlName() {
		return this.dlName;
	}

	public void setDlName(String value) {
		this.dlName = value;
	}
	public String getZdName() {
		return this.zdName;
	}

	public void setZdName(String value) {
		this.zdName = value;
	}
	public String getGdName() {
		return this.gdName;
	}

	public void setGdName(String value) {
		this.gdName = value;
	}
	public String getFgsName() {
		return this.fgsName;
	}

	public void setFgsName(String value) {
		this.fgsName = value;
	}
	public Integer getDlRate() {
		return this.dlRate;
	}

	public void setDlRate(Integer value) {
		this.dlRate = value;
	}
	public Integer getZdRate() {
		return this.zdRate;
	}

	public void setZdRate(Integer value) {
		this.zdRate = value;
	}
	public Integer getGdRate() {
		return this.gdRate;
	}

	public void setGdRate(Integer value) {
		this.gdRate = value;
	}
	public Integer getFgsRate() {
		return this.fgsRate;
	}

	public void setFgsRate(Integer value) {
		this.fgsRate = value;
	}
	public Integer getZjRate() {
		return this.zjRate;
	}

	public void setZjRate(Integer value) {
		this.zjRate = value;
	}
	//endregion

	//region your codes 2

	//endregion your codes 2

}